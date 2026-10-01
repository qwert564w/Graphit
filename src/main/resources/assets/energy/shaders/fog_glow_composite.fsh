#version 150

uniform sampler2D SceneSampler;
uniform sampler2D GlowSampler;
uniform sampler2D DepthSampler;
uniform mat4 InvProjMat;
uniform mat4 InvViewMat;
uniform vec4 FogRanges;
uniform float Intensity;

in vec2 texCoord;
out vec4 fragColor;

vec3 viewPosition(vec2 uv, float depth) {
    vec4 position = InvProjMat * vec4(uv * 2.0 - 1.0, depth * 2.0 - 1.0, 1.0);
    return position.xyz / max(abs(position.w), 0.000001) * sign(position.w);
}

float rangeFog(float distance, vec2 range) {
    float amount = clamp((distance - range.x) / max(range.y - range.x, 0.001), 0.0, 1.0);
    return amount * amount * (3.0 - 2.0 * amount);
}

float geometryFog(vec3 viewPos) {
    vec3 worldRelative = mat3(InvViewMat) * viewPos;
    return max(rangeFog(length(viewPos), FogRanges.xy),
               rangeFog(max(length(worldRelative.xz), abs(worldRelative.y)), FogRanges.zw));
}

float skyFog(vec2 uv) {
    vec3 worldRay = normalize(mat3(InvViewMat) * viewPosition(uv, 0.5));
    float horizon = exp2(-abs(worldRay.y) * 9.0);
    return 0.02 + 0.18 * horizon * horizon;
}

void main() {
    vec4 scene = texture(SceneSampler, texCoord);
    float strength = clamp(Intensity, 0.0, 3.0);
    if (strength <= 0.0) {
        fragColor = scene;
        return;
    }

    float depth = texture(DepthSampler, texCoord).r;
    bool sky = depth >= 0.9999999;
    float fog = sky ? skyFog(texCoord) : geometryFog(viewPosition(texCoord, depth));

    // Test the original full-resolution depth after blurring. Nearby silhouettes
    // remain crisp even when they border the brightest part of the distant fog.
    float localGate = sky ? fog : smoothstep(0.0, 0.30, fog);
    vec3 glow = max(texture(GlowSampler, texCoord).rgb, vec3(0.0));

    // An exponential screen blend rolls off towards highlights without clipping
    // colored fog to white. Preserve source alpha and any existing HDR values.
    vec3 screenAmount = vec3(1.0) - exp(-glow * (strength * 1.35));
    vec3 headroom = max(vec3(1.0) - scene.rgb, vec3(0.0));
    fragColor = vec4(scene.rgb + headroom * screenAmount * localGate, scene.a);
}
