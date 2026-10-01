#version 150

uniform sampler2D font;
uniform float width;
uniform float maxWidth;

in vec2 texCoord;
in vec4 vertexColor;
out vec4 fragColor;

void main() {
    float f = clamp(smoothstep(0.5, 1.0, 1.0 - (gl_FragCoord.x - maxWidth) / width), 0.0, 1.0);
    vec4 color = texture(font, texCoord);
    if (color.a > 0.0) {
        color.a *= f;
    }
    fragColor = color * vertexColor;
}

