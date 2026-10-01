#version 150

#define THIN_OUTLINE 3
#define DOUBLE_GLOW 4

#define SINGLE_COLOR 1
#define RAINBOW 2
#define TWO_COLORS 3

uniform sampler2D DiffuseSampler;
uniform sampler2D PrevSampler;
uniform sampler2D MinecraftSampler;

in vec2 texCoord;
in vec2 oneTexel;

uniform float GameTime;
uniform float timeMult;
uniform vec2 ScreenSize;
uniform vec4 color1;
uniform vec4 color2;
uniform int noAlphaMode;
uniform int colorMode;
uniform bool blurState;
uniform float blurMix;
uniform int glowQuality;
uniform float glowRadius;
uniform float glowAlphaMult;
uniform bool glowThinOutline;
uniform int glowLogic;
uniform float fillAlphaMult;
uniform float colorRadius;
uniform bool centred;
uniform float saturation;
uniform float brightness;

out vec4 fragColor;

vec3 hsv2rgb(vec3 c) {
    vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);
    vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);
    return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);
}

vec4 computeColor() {
    if (colorMode == SINGLE_COLOR) return color1;

    float time = GameTime * timeMult;

    if (colorMode == RAINBOW) {
        vec2 offset = centred ? -ScreenSize / 2.0 : vec2(0.0);
        float dist = (length((texCoord + offset) * 0.01) + time) / colorRadius;
        return vec4(hsv2rgb(vec3(fract(dist) / colorRadius, saturation, brightness)), 1.0);
    }

    float percent = (sin((length(texCoord) + time * 200.0) * colorRadius * colorRadius * 1000.0) + 1.0) * 0.5;
    return mix(color2, color1, percent);
}

void main() {
    vec4 prevColor = texture(PrevSampler, texCoord);

    // Off-entity without outline/glow: skip immediately
    if (prevColor.a == 0.0 && noAlphaMode != THIN_OUTLINE && noAlphaMode != DOUBLE_GLOW) {
        discard;
    }

    // On-entity fill (no glow processing needed)
    if (prevColor.a != 0.0 && noAlphaMode != DOUBLE_GLOW) {
        if (fillAlphaMult == 0.0) discard;
        vec4 oc = computeColor();
        fragColor = vec4(oc.rgb, oc.a * fillAlphaMult);
        return;
    }

    // --- Thin outline (5x5 kernel, cheap) ---
    if (noAlphaMode == THIN_OUTLINE) {
        float alpha = 0.0;
        for (int x = -2; x <= 2; x++) {
            for (int y = -2; y <= 2; y++) {
                if (texture(PrevSampler, texCoord + vec2(x, y) * oneTexel).a != 0.0) {
                    alpha += max(0.0, 2.0 - sqrt(float(x * x + y * y)));
                }
            }
        }
        if (alpha == 0.0) discard;
        fragColor = vec4(computeColor().rgb, alpha);
        return;
    }

    // --- Double glow: vertical pass (reads horizontal counts from pass 1) ---
    if (noAlphaMode == DOUBLE_GLOW) {
        // Thin outline sub-effect on top of glow
        if (glowThinOutline && prevColor.a == 0.0) {
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    if ((x != 0 || y != 0) && texture(PrevSampler, texCoord + vec2(x, y) * oneTexel).a != 0.0) {
                        fragColor = vec4(computeColor().rgb, 1.0);
                        return;
                    }
                }
            }
        }

        int width = glowQuality * int(glowRadius);

        // Early exit for off-entity pixels far from any glow data
        if (prevColor.a == 0.0) {
            float probe = texture(DiffuseSampler, texCoord).r
                        + texture(DiffuseSampler, texCoord + vec2(0.0, float(width)) * oneTexel).r
                        + texture(DiffuseSampler, texCoord + vec2(0.0, float(-width)) * oneTexel).r;
            if (probe == 0.0) {
                int hw = max(1, width / 2);
                probe += texture(DiffuseSampler, texCoord + vec2(0.0, float(hw)) * oneTexel).r
                       + texture(DiffuseSampler, texCoord + vec2(0.0, float(-hw)) * oneTexel).r;
                if (probe == 0.0) discard;
            }
        }

        // Vertical summation of horizontal counts from pass 1
        float totalCount = 0.0;
        for (int y = -width; y <= width; y += glowQuality) {
            totalCount += texture(DiffuseSampler, texCoord + vec2(0.0, float(y)) * oneTexel).r;
        }

        float maxH = float(2 * int(glowRadius) + 1);
        float j = totalCount * maxH;
        int count = int(glowRadius * glowRadius + glowRadius);
        float glowAlpha = j / float(count * 4);
        float alpha;

        vec4 outputColor = computeColor();

        if (prevColor.a != 0.0) {
            alpha = max((1.0 - glowAlpha) * glowAlphaMult, outputColor.a * fillAlphaMult);
        } else {
            alpha = glowAlpha * glowAlphaMult;
        }

        if (alpha < 0.002) discard;
        fragColor = vec4(outputColor.rgb, alpha);
        return;
    }

    discard;
}
