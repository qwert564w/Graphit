#version 150

uniform sampler2D Tex0;
uniform vec2 Direction;
uniform vec2 TexelSize;
uniform int Alpha;
uniform vec3 Gaussian;
uniform int Support;
uniform int LinearSampling;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    vec3 gaussian = Gaussian;
    vec4 color = texture(Tex0, texCoord) * gaussian.x;
    float sum = gaussian.x;

    if (LinearSampling != 0) {
        for (int i = 1; i <= Support; i += 2) {
            gaussian.xy *= gaussian.yz;
            float w1 = gaussian.x;
            gaussian.xy *= gaussian.yz;
            float w2 = gaussian.x;
            float w = w1 + w2;
            vec2 offset = TexelSize * Direction * ((float(i) * w1 + (float(i) + 1.0) * w2) / max(w, 1e-5));
            color += texture(Tex0, texCoord + offset) * w;
            color += texture(Tex0, texCoord - offset) * w;
            sum += w * 2.0;
        }
    } else {
        for (int i = 1; i <= Support; i++) {
            gaussian.xy *= gaussian.yz;
            vec2 offset = TexelSize * Direction * float(i);
            color += texture(Tex0, texCoord + offset) * gaussian.x;
            color += texture(Tex0, texCoord - offset) * gaussian.x;
            sum += gaussian.x * 2.0;
        }
    }

    color /= max(sum, 1e-5);
    if (Alpha == 0) {
        color.a = 1.0;
    }

    fragColor = color;
}
