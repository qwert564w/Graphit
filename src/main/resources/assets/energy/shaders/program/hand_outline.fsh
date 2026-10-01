#version 150

#define Width 3

uniform sampler2D DiffuseSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform int RenderMode;
uniform float FillOpacity;

out vec4 fragColor;

void main() {
    vec4 current = texture(DiffuseSampler, texCoord);

    if (current.a != 0.0) {
        if (RenderMode == 1) discard;
        fragColor = vec4(current.rgb, current.a * FillOpacity);
    } else {
        if (RenderMode == 0) discard;

        float probe = sign(texture(DiffuseSampler, texCoord + vec2(Width - 1, 0) * oneTexel).a)
                    + sign(texture(DiffuseSampler, texCoord + vec2(-(Width), 0) * oneTexel).a)
                    + sign(texture(DiffuseSampler, texCoord + vec2(0, Width - 1) * oneTexel).a)
                    + sign(texture(DiffuseSampler, texCoord + vec2(0, -(Width)) * oneTexel).a);
        if (probe == 0.0) discard;

        float alpha = 0.0;
        float maxSample = 3.0;
        float divider = 5.0;

        for (float x = -Width; x < Width; x++) {
            for (float y = -Width; y < Width; y++) {
                vec4 s = texture(DiffuseSampler, texCoord + vec2(x, y) * oneTexel);
                if (s.a != 0.0) {
                    current = s;
                    alpha += max(0.0, (maxSample - length(vec2(x, y))) / divider);
                }
            }
        }

        fragColor = vec4(current.rgb, alpha * alpha);
    }
}
