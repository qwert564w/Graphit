#version 150

uniform sampler2D Tex0;
uniform int Alpha;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    vec4 color = texture(Tex0, texCoord);
    if (Alpha == 0 && color.a > 0.0) {
        color.a = 1.0;
    }
    fragColor = color;
}
