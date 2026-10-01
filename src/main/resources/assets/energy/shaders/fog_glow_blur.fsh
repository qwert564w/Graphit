#version 150

uniform sampler2D GlowSampler;
uniform vec2 Direction;
uniform float Radius;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    // Direction already contains one texel in the selected axis. Radius is the
    // support in half-resolution pixels, independent of the window dimensions.
    vec2 stepUv = Direction * clamp(Radius, 0.0, 32.0) / 8.0;
    vec4 color = texture(GlowSampler, texCoord);
    float weightSum = 1.0;
    for (int i = 1; i <= 8; ++i) {
        float x = float(i);
        float weight = exp(-0.5 * x * x / 9.0);
        vec2 offset = stepUv * x;
        color += (texture(GlowSampler, clamp(texCoord - offset, vec2(0.0), vec2(1.0)))
                + texture(GlowSampler, clamp(texCoord + offset, vec2(0.0), vec2(1.0)))) * weight;
        weightSum += 2.0 * weight;
    }
    fragColor = color / weightSum;
}
