#version 150

uniform sampler2D DiffuseSampler;
uniform sampler2D BlurSampler;
uniform vec4 multiplier;
uniform vec2 viewOffset;
uniform vec2 resolution;

in vec2 texCoord;
in vec2 oneTexel;

out vec4 fragColor;

void main() {
    vec2 pos = gl_FragCoord.xy + viewOffset;
    vec4 srcColor = texture(DiffuseSampler, texCoord);
    vec2 blurredPos = pos / resolution;
    pos.y = resolution.y - pos.y;
    fragColor = texture(BlurSampler, blurredPos) * multiplier * srcColor.a;
}
