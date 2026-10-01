#version 150

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;

in vec2 TexCoord;
out vec4 OutColor;

void main() {
    vec2 uv = TexCoord;
    float mask = texture(Sampler1, uv).a;
    if (mask <= 0.5) {
        discard;
    }
    vec4 scene = texture(Sampler0, uv);
    OutColor = vec4(scene.rgb, 1.0);
}
