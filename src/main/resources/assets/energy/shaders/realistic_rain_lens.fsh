#version 150

uniform sampler2D SceneSampler;

uniform vec2 Resolution;
uniform float Time;
uniform float RainStrength;
uniform float Wetness;
uniform float LensAmount;
uniform float Refraction;
uniform vec2 Wind;
uniform vec2 CameraMotion;
uniform float Lightning;
uniform int Preset;
uniform int Quality;

in vec2 texCoord;
out vec4 fragColor;

float hash21(vec2 p) {
    vec3 p3 = fract(vec3(p.xyx) * 0.1031);
    p3 += dot(p3, p3.yzx + 33.33);
    return fract((p3.x + p3.y) * p3.z);
}

vec2 hash22(vec2 p) {
    float n = hash21(p);
    return vec2(n, hash21(p + n + 27.17));
}

vec3 lensTint() {
    if (Preset == 1) return vec3(0.48, 0.70, 1.00);
    if (Preset == 2) return vec3(0.94, 0.98, 0.86);
    if (Preset == 3) return vec3(0.62, 0.72, 0.82);
    return vec3(0.73, 0.88, 1.00);
}

float dropLayer(vec2 uv, float scale, float speed, float seed) {
    float aspect = Resolution.x / max(Resolution.y, 1.0);
    vec2 p = vec2(uv.x * aspect, uv.y) * scale;
    vec2 cellId = floor(p);
    vec2 cell = fract(p) - 0.5;
    vec2 random = hash22(cellId + seed);

    float travel = fract(Time * speed + random.y * 5.31 + seed * 0.17);
    vec2 center = vec2((random.x - 0.5) * 0.66, 0.68 - travel * 1.36);
    center.x += Wind.x * travel * 0.14 + CameraMotion.x * (0.08 + travel * 0.13);
    center.y += CameraMotion.y * 0.07;

    vec2 bodyDelta = (cell - center) * vec2(1.0, 0.78);
    float bodyDistance = length(bodyDelta);
    float body = 1.0 - smoothstep(0.045, 0.135, bodyDistance);

    float trailY = cell.y - center.y;
    float trailX = abs(cell.x - center.x + sin(trailY * 12.0 + random.x * 6.28) * 0.012);
    float trail = (1.0 - smoothstep(0.014, 0.055, trailX));
    trail *= smoothstep(0.015, 0.075, trailY);
    trail *= 1.0 - smoothstep(0.10, 0.48, trailY);
    float brokenTrail = 0.54 + 0.46 * sin(trailY * 46.0 + random.y * 19.0);
    trail *= smoothstep(-0.18, 0.45, brokenTrail) * (0.30 + random.x * 0.52);

    float satellite = 1.0 - smoothstep(
            0.018,
            0.052,
            length(cell - center - vec2((random.y - 0.5) * 0.11, 0.20 + random.x * 0.16))
    );
    return max(body, max(trail, satellite * 0.62));
}

float dropField(vec2 uv) {
    float amount = clamp(LensAmount, 0.0, 1.0);
    // Keep phase independent from the changing vanilla rain gradient. The
    // amount still reacts to weather through Wetness, but drops never jump.
    float speed = 0.092;
    float large = dropLayer(uv, mix(5.2, 7.4, amount), speed, 3.7);
    float result = large;
    if (Quality < 2) {
        float medium = dropLayer(uv + vec2(0.17, 0.09), mix(9.5, 13.0, amount), speed * 1.34, 17.3);
        result = max(result, medium * (0.52 + amount * 0.30));
    }
    if (Quality == 0) {
        float small = dropLayer(uv - vec2(0.11, 0.13), mix(15.0, 21.0, amount), speed * 1.72, 41.9);
        result = max(result, small * amount * 0.68);
    }
    return result;
}

void main() {
    vec3 original = texture(SceneSampler, texCoord).rgb;
    if (Wetness <= 0.001 || LensAmount <= 0.001) {
        fragColor = vec4(original, 1.0);
        return;
    }

    vec2 pixel = 1.0 / max(Resolution, vec2(1.0));
    vec2 sampleStep = pixel * 2.25;
    float field = dropField(texCoord);
    float fieldLeft = dropField(texCoord - vec2(sampleStep.x, 0.0));
    float fieldRight = dropField(texCoord + vec2(sampleStep.x, 0.0));
    float fieldDown = dropField(texCoord - vec2(0.0, sampleStep.y));
    float fieldUp = dropField(texCoord + vec2(0.0, sampleStep.y));

    vec2 dropNormal = vec2(fieldRight - fieldLeft, fieldUp - fieldDown);
    float amountPresence = smoothstep(0.0, 0.22, clamp(LensAmount, 0.0, 1.0));
    float dropMask = smoothstep(0.035, 0.48, field)
            * clamp(Wetness, 0.0, 1.0) * amountPresence;
    float normalLength = length(dropNormal);
    if (normalLength > 0.001) dropNormal /= max(normalLength, 0.001);

    float refractionScale = mix(0.0025, 0.0105, clamp(Refraction, 0.0, 1.0));
    refractionScale *= 0.60 + dropMask * 0.55;
    vec2 refractedUv = clamp(texCoord + dropNormal * refractionScale * dropMask, vec2(0.001), vec2(0.999));

    float dispersion = Refraction * dropMask * 1.55 / max(Resolution.x, 1.0);
    vec2 dispersionOffset = dropNormal * dispersion;
    vec3 refracted;
    refracted.r = texture(SceneSampler, clamp(refractedUv + dispersionOffset, 0.0, 1.0)).r;
    refracted.g = texture(SceneSampler, refractedUv).g;
    refracted.b = texture(SceneSampler, clamp(refractedUv - dispersionOffset, 0.0, 1.0)).b;

    float interior = smoothstep(0.18, 0.78, field);
    vec3 softFocus = texture(SceneSampler, clamp(refractedUv + pixel * vec2(2.0, -1.0), 0.0, 1.0)).rgb;
    refracted = mix(refracted, softFocus, interior * 0.14 * Refraction);

    float rim = smoothstep(0.035, 0.24, field) * (1.0 - smoothstep(0.42, 0.90, field));
    rim *= amountPresence * clamp(Wetness, 0.0, 1.0);
    float directionalGlint = pow(clamp(dot(normalize(dropNormal + vec2(0.001)), normalize(vec2(-0.48, 0.88))), 0.0, 1.0), 5.0);
    vec3 tint = lensTint();

    vec3 color = mix(original, refracted, dropMask * (0.70 + Refraction * 0.22));
    color += tint * rim * (0.055 + directionalGlint * 0.16);
    color += tint * rim * Lightning * 0.62;

    float edgeMist = smoothstep(0.48, 1.05, length(texCoord * 2.0 - 1.0));
    color = mix(color, color * tint, edgeMist * Wetness * RainStrength * 0.022);

    float movingSmear = abs(CameraMotion.x) + abs(CameraMotion.y);
    color += tint * rim * clamp(movingSmear, 0.0, 1.0) * 0.035;
    fragColor = vec4(clamp(color, 0.0, 1.0), 1.0);
}
