#version 150

uniform sampler2D SceneSampler;
uniform sampler2D DepthSampler;
uniform sampler2D ExposureSampler;

uniform mat4 InvViewMat;
uniform mat4 InvProjMat;
uniform vec2 Resolution;
uniform vec3 CameraPos;
uniform vec2 PatternOrigin;
uniform vec2 ExposureCameraOffset;
uniform float ExposureMapSize;
uniform float CameraHeight;
uniform float Time;
uniform float RainStrength;
uniform float Wetness;
uniform float PuddleAmount;
uniform float ReflectionStrength;
uniform float RippleStrength;
uniform vec2 Wind;
uniform float Lightning;
uniform float LightningAge;
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
    return vec2(n, hash21(p + n + 19.19));
}

float valueNoise(vec2 p) {
    vec2 cell = floor(p);
    vec2 f = fract(p);
    f = f * f * (3.0 - 2.0 * f);
    float a = hash21(cell);
    float b = hash21(cell + vec2(1.0, 0.0));
    float c = hash21(cell + vec2(0.0, 1.0));
    float d = hash21(cell + vec2(1.0, 1.0));
    return mix(mix(a, b, f.x), mix(c, d, f.x), f.y);
}

float fbm(vec2 p) {
    float sum = 0.0;
    float weight = 0.54;
    for (int i = 0; i < 4; i++) {
        sum += valueNoise(p) * weight;
        p = p * 2.03 + vec2(8.3, 2.7);
        weight *= 0.48;
    }
    return sum;
}

vec3 reconstructRelativePosition(vec2 uv, float depth) {
    vec4 clip = vec4(uv * 2.0 - 1.0, depth * 2.0 - 1.0, 1.0);
    vec4 view = InvProjMat * clip;
    view /= max(abs(view.w), 1.0e-6);
    vec4 relativeWorld = InvViewMat * vec4(view.xyz, 1.0);
    return relativeWorld.xyz;
}

vec3 paletteTint() {
    if (Preset == 1) return vec3(0.55, 0.72, 1.00);
    if (Preset == 2) return vec3(0.92, 0.96, 0.84);
    if (Preset == 3) return vec3(0.62, 0.70, 0.78);
    return vec3(0.72, 0.86, 0.96);
}

float rainExposure(vec3 relativePosition) {
    vec2 mapPosition = relativePosition.xz + ExposureCameraOffset;
    if (mapPosition.x < 0.0 || mapPosition.y < 0.0
            || mapPosition.x >= ExposureMapSize || mapPosition.y >= ExposureMapSize) {
        return 0.0;
    }

    vec2 mapUv = (floor(mapPosition) + 0.5) / ExposureMapSize;
    float exposedTopY = texture(ExposureSampler, mapUv).r;
    if (exposedTopY < -1000.0) return 0.0;

    float surfaceY = CameraHeight + relativePosition.y;
    // A generous upper edge keeps slabs, stairs and the slightly lowered
    // water surface while still rejecting floors beneath a roof.
    return 1.0 - smoothstep(0.18, 0.86, abs(surfaceY - exposedTopY));
}

vec3 rippleCell(vec2 p, vec2 cell, float margin, float ringLimit, float edgeSharpness) {
    vec2 random = hash22(cell);
    vec2 center = cell + margin + random * (1.0 - margin * 2.0);
    vec2 delta = p - center;
    float distanceToDrop = length(delta);

    // Intensity must not be multiplied into absolute time: doing so teleports
    // every ring when vanilla rain ramps up or down.
    float dropSpeed = 0.48 + random.y * 0.34;
    float age = fract(Time * dropSpeed + random.x * 7.17);
    float ringRadius = age * ringLimit;
    float envelope = exp(-abs(distanceToDrop - ringRadius) * edgeSharpness) * (1.0 - age);
    float wave = sin((distanceToDrop - ringRadius) * 73.0) * envelope;
    return vec3(delta / max(distanceToDrop, 0.001) * wave, envelope);
}

vec3 rippleField(vec2 worldXZ) {
    vec2 p = worldXZ * 0.47;
    vec2 base = floor(p);
    vec3 result = vec3(0.0);

    if (Quality >= 2) {
        // The FPS path examines one compact ring fully contained in its cell.
        // This avoids both nine samples and square seams at floor(p) changes.
        result = rippleCell(p, base, 0.28, 0.19, 44.0);
    } else {
        // No uniform-dependent loop/continue: this is friendlier to older
        // Intel/AMD GLSL 1.50 drivers than dynamically trimming the loop.
        for (int y = -1; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                result += rippleCell(p, base + vec2(float(x), float(y)), 0.12, 0.72, 32.0);
            }
        }
    }

    result.z = min(result.z, 1.0);
    return result;
}

void main() {
    vec3 scene = texture(SceneSampler, texCoord).rgb;
    float depth = texture(DepthSampler, texCoord).r;
    if (depth >= 0.99998 || Wetness <= 0.001) {
        fragColor = vec4(scene, 1.0);
        return;
    }

    // Work camera-relative to preserve sub-pixel precision at large world
    // coordinates (millions of blocks).
    vec3 relativePosition = reconstructRelativePosition(texCoord, depth);
    vec2 pixel = 1.0 / max(Resolution, vec2(1.0));
    float stepX = texCoord.x + pixel.x < 1.0 ? pixel.x : -pixel.x;
    float stepY = texCoord.y + pixel.y < 1.0 ? pixel.y : -pixel.y;
    vec2 uvX = texCoord + vec2(stepX, 0.0);
    vec2 uvY = texCoord + vec2(0.0, stepY);
    float depthX = texture(DepthSampler, uvX).r;
    float depthY = texture(DepthSampler, uvY).r;
    if (depthX >= 0.99998 || depthY >= 0.99998) {
        fragColor = vec4(scene, 1.0);
        return;
    }

    // Explicit neighbour reconstruction stays defined across non-uniform
    // branches, unlike dFdx/dFdy after a per-pixel early return.
    vec3 dx = reconstructRelativePosition(uvX, depthX) - relativePosition;
    vec3 dy = reconstructRelativePosition(uvY, depthY) - relativePosition;
    float dxLength = length(dx);
    float dyLength = length(dy);
    if (!(dxLength > 1.0e-7) || !(dyLength > 1.0e-7)) {
        fragColor = vec4(scene, 1.0);
        return;
    }
    vec3 rawNormal = cross(dx / dxLength, dy / dyLength);
    float normalEnergy = dot(rawNormal, rawNormal);
    if (!(normalEnergy > 1.0e-8) || normalEnergy > 1.0001) {
        fragColor = vec4(scene, 1.0);
        return;
    }
    vec3 normal = rawNormal * inversesqrt(normalEnergy);
    vec3 toCamera = normalize(-relativePosition);
    if (dot(normal, toCamera) < 0.0) normal = -normal;

    float horizontal = smoothstep(0.72, 0.965, normal.y);
    float distanceFromCamera = length(relativePosition);
    // The map recentres every four blocks. Keep a padded dry edge so that its
    // nearest border never clips a still-visible puddle while the player moves.
    float distanceFade = 1.0 - smoothstep(ExposureMapSize * 0.31, ExposureMapSize * 0.42, distanceFromCamera);
    // Across silhouettes neighbour samples jump between unrelated surfaces.
    // Fade those pixels out instead of turning the discontinuity into a halo.
    float derivativeSpan = max(length(dx), length(dy));
    float surfaceContinuity = 1.0 - smoothstep(1.8, 5.5, derivativeSpan);
    float validSurface = horizontal * distanceFade * surfaceContinuity * rainExposure(relativePosition);
    if (validSurface <= 0.001) {
        fragColor = vec4(scene, 1.0);
        return;
    }

    float generalWet = validSurface * Wetness * (0.12 + RainStrength * 0.13);
    scene *= 1.0 - generalWet * 0.15;
    scene = mix(scene, scene * vec3(0.82, 0.89, 0.95), generalWet * 0.24);

    if (PuddleAmount <= 0.001) {
        fragColor = vec4(clamp(scene, 0.0, 1.0), 1.0);
        return;
    }

    // Rebase procedural coordinates in Java before converting to float. The
    // long centred repeat is invisible locally and keeps sub-block precision
    // at the world border.
    vec2 worldXZ = relativePosition.xz + PatternOrigin;
    float largeShape = fbm(worldXZ * 0.105 + vec2(11.7, -4.3));
    float edgeDetail = fbm(worldXZ * 0.31 - vec2(3.4, 7.9));
    float puddleNoise = largeShape * 0.78 + edgeDetail * 0.22;
    float threshold = mix(0.68, 0.37, clamp(PuddleAmount, 0.0, 1.0));
    float puddlePresence = smoothstep(0.0, 0.04, clamp(PuddleAmount, 0.0, 1.0));
    float puddle = smoothstep(threshold, threshold + 0.16, puddleNoise)
            * validSurface * clamp(Wetness, 0.0, 1.0) * puddlePresence;

    vec3 ripple = RippleStrength > 0.001 && puddle > 0.001 ? rippleField(worldXZ) : vec3(0.0);
    float windWave = sin(dot(worldXZ, normalize(Wind + vec2(0.001))) * 1.9 + Time * 1.3) * 0.5 + 0.5;
    vec2 distortion = ripple.xy * 0.0027 * RippleStrength * (0.35 + RainStrength * 0.65);
    distortion += Wind * (windWave - 0.5) * 0.0022;

    vec2 reflectedUv = vec2(texCoord.x, 1.0 - texCoord.y) + vec2(distortion.x, -distortion.y);
    reflectedUv = clamp(reflectedUv, vec2(0.002), vec2(0.998));
    vec2 blurStep = vec2(2.25 / max(Resolution.x, 1.0), 0.0);
    vec3 reflection = scene;
    if (ReflectionStrength > 0.001 && puddle > 0.001) {
        reflection = texture(SceneSampler, reflectedUv).rgb;
        if (Quality < 2) {
            reflection += texture(SceneSampler, clamp(reflectedUv + blurStep, 0.0, 1.0)).rgb;
            reflection += texture(SceneSampler, clamp(reflectedUv - blurStep, 0.0, 1.0)).rgb;
            reflection /= 3.0;
        }
    }

    vec3 tint = paletteTint();
    reflection = mix(reflection, reflection * tint, 0.38);
    float fresnel = pow(1.0 - clamp(dot(normal, toCamera), 0.0, 1.0), 3.2);
    float reflectionMix = puddle * ReflectionStrength * (0.26 + fresnel * 0.62);
    vec3 wetBase = scene * mix(vec3(0.82, 0.87, 0.91), tint, 0.08);
    vec3 color = mix(scene, wetBase, puddle * 0.42);
    color = mix(color, reflection, clamp(reflectionMix, 0.0, 0.86));

    float ringHighlight = ripple.z * RippleStrength * RainStrength * puddle;
    color += tint * ringHighlight * 0.075;

    float echoRadius = LightningAge * 18.0;
    float echo = exp(-abs(length(relativePosition.xz) - echoRadius) * 1.55)
            * (1.0 - smoothstep(0.0, 2.65, LightningAge));
    color += tint * puddle * (Lightning * 0.34 + echo * 0.30);

    float microSparkle = pow(max(0.0, ripple.z), 3.0) * puddle;
    color += vec3(0.80, 0.91, 1.0) * microSparkle * 0.055;
    fragColor = vec4(clamp(color, 0.0, 1.0), 1.0);
}
