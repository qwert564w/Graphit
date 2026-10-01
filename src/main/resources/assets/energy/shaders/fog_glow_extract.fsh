#version 150

uniform sampler2D SceneSampler;
uniform sampler2D DepthSampler;
uniform mat4 InvProjMat;
uniform mat4 InvViewMat;
uniform vec3 FogColor;
uniform vec4 FogRanges;

in vec2 texCoord;
out vec4 fragColor;

// The depth attachment uses OpenGL depth [0, 1], not linear distance.
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
    float sphericalDistance = length(viewPos);
    float cylindricalDistance = max(length(worldRelative.xz), abs(worldRelative.y));
    return max(rangeFog(sphericalDistance, FogRanges.xy),
               rangeFog(cylindricalDistance, FogRanges.zw));
}

float skyFog(vec2 uv) {
    // Never unproject depth 1: an infinite-far projection has w == 0 there.
    vec3 worldRay = normalize(mat3(InvViewMat) * viewPosition(uv, 0.5));
    float horizon = exp2(-abs(worldRay.y) * 9.0);
    return 0.02 + 0.18 * horizon * horizon;
}

void main() {
    float depth = texture(DepthSampler, texCoord).r;
    bool sky = depth >= 0.9999999;
    float fog = sky ? skyFog(texCoord) : geometryFog(viewPosition(texCoord, depth));

    vec3 scene = max(texture(SceneSampler, texCoord).rgb, vec3(0.0));
    vec3 fogTint = clamp(FogColor, vec3(0.0), vec3(1.0));

    // Fog is the light source, so unfogged highlights cannot bloom into the effect.
    // A little local scene color keeps dusk, clouds and terrain from looking flat.
    vec3 emissionColor = mix(fogTint, min(scene, vec3(1.0)), 0.12);
    float fogLight = dot(fogTint, vec3(0.2126, 0.7152, 0.0722));
    emissionColor *= smoothstep(0.0, 0.12, fogLight);

    // Concentrate the extra light in the fog bank, with a softer fully fogged tail.
    float fogBank = 4.0 * fog * (1.0 - fog);
    float emission = sky ? fog : fog * (0.58 + 0.42 * fogBank);
    fragColor = vec4(emissionColor * emission, emission);
}
