#version 150

uniform sampler2D originalTexture;
uniform sampler2D blurredTexture;
uniform vec4 multiplier;
uniform vec2 viewOffset;
uniform vec2 resolution;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    vec2 pos = gl_FragCoord.xy + viewOffset;
    vec4 srcColor = texture(originalTexture, texCoord);
    vec2 blurredPos = pos / resolution;
    fragColor = texture(blurredTexture, blurredPos) * multiplier * srcColor.a;
}
