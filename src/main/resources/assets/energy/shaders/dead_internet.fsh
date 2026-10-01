#version 150

uniform sampler2D Tex0;

uniform vec2 Resolution;
uniform float Time;
uniform float Intensity;
uniform float VirtualHeight;
uniform float Glitch;
uniform float Chroma;
uniform float Exposure;
uniform float Disturbance;
uniform float Seed;
uniform int Preset;
uniform int Scanlines;
uniform int PacketLoss;

in vec2 texCoord;
out vec4 fragColor;

float hash11(float p) {
    p = fract(p * 0.1031);
    p *= p + 33.33;
    p *= p + p;
    return fract(p);
}

float hash21(vec2 p) {
    vec3 p3 = fract(vec3(p.xyx) * 0.1031);
    p3 += dot(p3, p3.yzx + 33.33);
    return fract((p3.x + p3.y) * p3.z);
}

float luminance(vec3 color) {
    return dot(color, vec3(0.2126, 0.7152, 0.0722));
}

vec3 thresholdSample(vec2 uv) {
    vec3 color = texture(Tex0, uv).rgb;
    return color * smoothstep(0.62, 0.96, luminance(color));
}

void palette(out vec3 shadows, out vec3 mids, out vec3 lights, out vec3 accent) {
    if (Preset == 1) {
        shadows = vec3(0.010, 0.018, 0.045);
        mids = vec3(0.225, 0.390, 0.590);
        lights = vec3(0.820, 0.930, 1.000);
        accent = vec3(0.180, 0.650, 1.000);
    } else if (Preset == 2) {
        shadows = vec3(0.015, 0.045, 0.060);
        mids = vec3(0.370, 0.570, 0.590);
        lights = vec3(0.900, 1.000, 0.960);
        accent = vec3(0.250, 1.000, 0.880);
    } else if (Preset == 3) {
        shadows = vec3(0.005, 0.008, 0.035);
        mids = vec3(0.105, 0.190, 0.570);
        lights = vec3(0.680, 0.800, 1.000);
        accent = vec3(0.360, 0.120, 1.000);
    } else {
        shadows = vec3(0.008, 0.010, 0.042);
        mids = vec3(0.175, 0.285, 0.570);
        lights = vec3(0.760, 0.900, 1.000);
        accent = vec3(0.380, 0.180, 0.950);
    }
}

void main() {
    float intensity = clamp(Intensity, 0.0, 1.0);
    float glitch = clamp(Glitch, 0.0, 1.0);
    float disturbance = clamp(Disturbance, 0.0, 1.0);
    float virtualH = max(VirtualHeight, 90.0);
    float aspect = Resolution.x / max(Resolution.y, 1.0);
    vec2 virtualSize = vec2(virtualH * aspect, virtualH);
    vec2 texel = 1.0 / max(Resolution, vec2(1.0));

    vec2 centered = texCoord * 2.0 - 1.0;
    float radius2 = dot(centered, centered);
    vec2 uv = centered * (1.0 + radius2 * 0.012 * intensity) * 0.5 + 0.5;

    float frame12 = floor(Time * 12.0);
    float frame6 = floor(Time * 6.0);
    float burstRandom = hash11(floor(Time * 1.65) + Seed);
    float burst = smoothstep(0.76 - glitch * 0.18, 0.995, burstRandom);
    float instability = glitch * (0.16 + burst * 0.84) + disturbance * 0.92;

    float line = floor(uv.y * virtualH);
    float lineRandom = hash21(vec2(line, frame12 + Seed));
    float lineGate = smoothstep(0.925 - instability * 0.12, 1.0, lineRandom);
    float lineShift = (hash21(vec2(line * 0.73 + Seed, frame6)) - 0.5)
            * (0.006 + 0.055 * instability) * lineGate;

    float tearBandId = floor(uv.y * 19.0);
    float tearRandom = hash21(vec2(tearBandId + Seed, frame6));
    float tearGate = smoothstep(0.952 - instability * 0.09, 0.999, tearRandom);
    float tear = (hash21(vec2(frame6, tearBandId * 2.7 + Seed)) - 0.5)
            * 0.105 * instability * tearGate;

    float headCenter = 0.035 + sin(Time * 0.73 + Seed) * 0.012;
    float headSwitch = exp(-pow((uv.y - headCenter) / 0.014, 2.0));
    float headWave = sin(uv.y * Resolution.y * 0.72 + Time * 42.0) * texel.x * 11.0;

    uv.x += lineShift + tear + headWave * headSwitch * (0.25 + glitch);

    float packetMask = 0.0;
    if (PacketLoss != 0) {
        vec2 macroCell = floor(uv * vec2(22.0, max(16.0, virtualH / 11.0)));
        float packetRandom = hash21(macroCell + vec2(frame6 * 1.31, Seed));
        float packetGate = smoothstep(0.986 - instability * 0.030, 0.9998, packetRandom);
        packetMask = packetGate * smoothstep(0.18, 0.72, burst + disturbance);
        float packetShift = (hash21(macroCell.yx + vec2(Seed, frame6)) - 0.5) * 0.17;
        uv.x += packetShift * packetMask * (0.35 + instability);
        uv.y -= floor(hash21(macroCell + 91.7) * 4.0) * (2.0 / virtualH) * packetMask;
    }

    vec2 quantizedUv = (floor(uv * virtualSize) + 0.5) / virtualSize;
    vec2 safeUv = clamp(quantizedUv, texel * 0.5, vec2(1.0) - texel * 0.5);

    float edgeAberration = 0.35 + radius2 * 1.35;
    float chromaPixels = (0.75 + 4.25 * Chroma) * edgeAberration * (1.0 + instability * 1.6);
    vec2 chromaOffset = vec2(chromaPixels / virtualSize.x, 0.0);

    vec3 centerColor = texture(Tex0, safeUv).rgb;
    float red = texture(Tex0, clamp(safeUv + chromaOffset, 0.0, 1.0)).r;
    float blueA = texture(Tex0, clamp(safeUv - chromaOffset * 1.45, 0.0, 1.0)).b;
    float blueB = texture(Tex0, clamp(safeUv - chromaOffset * 3.10, 0.0, 1.0)).b;
    vec3 color = vec3(red, centerColor.g, mix(blueA, blueB, 0.28 + 0.22 * intensity));

    vec3 ghost = texture(Tex0, clamp(safeUv + vec2(0.0035 + tear * 0.18, texel.y), 0.0, 1.0)).rgb;
    color += ghost * vec3(0.025, 0.050, 0.115) * intensity * (0.6 + instability);

    vec2 bloomStep = texel * mix(2.5, 7.5, Exposure);
    vec3 bloom = thresholdSample(clamp(safeUv + vec2(bloomStep.x, 0.0), 0.0, 1.0));
    bloom += thresholdSample(clamp(safeUv - vec2(bloomStep.x, 0.0), 0.0, 1.0));
    bloom += thresholdSample(clamp(safeUv + vec2(0.0, bloomStep.y), 0.0, 1.0));
    bloom += thresholdSample(clamp(safeUv - vec2(0.0, bloomStep.y), 0.0, 1.0));
    bloom *= 0.25;

    float luma = luminance(color);
    vec3 shadows;
    vec3 mids;
    vec3 lights;
    vec3 accent;
    palette(shadows, mids, lights, accent);

    vec3 paletteColor = mix(shadows, mids, smoothstep(0.015, 0.54, luma));
    paletteColor = mix(paletteColor, lights, smoothstep(0.56, 0.94, luma));
    paletteColor *= 0.32 + luma * 1.34;

    float gradeStrength = intensity * (Preset == 2 ? 0.48 : 0.64);
    color = mix(color, paletteColor, gradeStrength);
    color += bloom * mix(lights, accent, 0.24) * Exposure * (0.34 + intensity * 0.64);

    float burned = smoothstep(0.57, 0.93 - Exposure * 0.16, luma);
    color = mix(color, lights * (1.03 + bloom * 0.55), burned * Exposure * 0.72);

    float crushedLuma = luminance(color);
    color *= smoothstep(-0.015, 0.095 + intensity * 0.025, crushedLuma);
    color += accent * packetMask * (0.035 + instability * 0.11);

    if (Scanlines != 0) {
        float virtualLine = floor(safeUv.y * virtualH);
        float alternating = mod(virtualLine + floor(Time * 29.97), 2.0);
        float scan = mix(0.965, 0.875, alternating);
        color *= mix(1.0, scan, intensity * 0.68);

        float physicalLine = 0.985 + 0.015 * sin(gl_FragCoord.y * 3.14159265);
        color *= mix(1.0, physicalLine, intensity * 0.55);
    }

    float grain = hash21(floor(gl_FragCoord.xy * 0.5) + vec2(frame12, Seed)) - 0.5;
    color += grain * (0.016 + glitch * 0.035) * (0.35 + intensity);
    color += vec3(0.14, 0.28, 0.62) * headSwitch * hash21(vec2(gl_FragCoord.x, frame12))
            * instability * 0.10;

    float vignette = 16.0 * texCoord.x * texCoord.y * (1.0 - texCoord.x) * (1.0 - texCoord.y);
    vignette = pow(clamp(vignette, 0.0, 1.0), 0.16 + intensity * 0.11);
    color = mix(shadows * 0.28, color, vignette);

    float outside = step(0.0, uv.x) * step(uv.x, 1.0) * step(0.0, uv.y) * step(uv.y, 1.0);
    color *= outside;

    color = max(color, vec3(0.0));
    color = color / (vec3(1.0) + color * 0.20);
    fragColor = vec4(clamp(color, 0.0, 1.0), 1.0);
}
