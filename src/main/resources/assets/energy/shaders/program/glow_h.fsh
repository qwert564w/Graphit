#version 150

#define DOUBLE_GLOW 4

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform int noAlphaMode;
uniform int glowQuality;
uniform float glowRadius;

out vec4 fragColor;

void main() {
    if (noAlphaMode != DOUBLE_GLOW) discard;

    int width = glowQuality * int(glowRadius);
    vec4 center = texture(DiffuseSampler, texCoord);

    if (center.a == 0.0) {
        float probe = sign(texture(DiffuseSampler, texCoord + vec2(float(width), 0.0) * oneTexel).a)
                    + sign(texture(DiffuseSampler, texCoord + vec2(float(-width), 0.0) * oneTexel).a);
        if (probe == 0.0) {
            int hw = max(1, width / 2);
            probe += sign(texture(DiffuseSampler, texCoord + vec2(float(hw), 0.0) * oneTexel).a)
                   + sign(texture(DiffuseSampler, texCoord + vec2(float(-hw), 0.0) * oneTexel).a);
            if (probe == 0.0) discard;
        }
    }

    float hCount = 0.0;
    for (int x = -width; x <= width; x += glowQuality) {
        if (texture(DiffuseSampler, texCoord + vec2(float(x), 0.0) * oneTexel).a != 0.0) {
            hCount += 1.0;
        }
    }

    if (hCount == 0.0) discard;

    float maxH = float(2 * int(glowRadius) + 1);
    fragColor = vec4(hCount / maxH, 0.0, 0.0, 1.0);
}
