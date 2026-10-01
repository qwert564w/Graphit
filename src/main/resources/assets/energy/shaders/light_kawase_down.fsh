#version 150

uniform sampler2D image;
uniform float offset;
uniform vec2 resolution;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    vec2 uv = texCoord * 2.0;
    vec2 halfpixel = resolution * 2.0 * offset;

    vec3 sum = texture(image, uv).rgb * 4.0;
    sum += texture(image, uv - halfpixel).rgb;
    sum += texture(image, uv + halfpixel).rgb;
    sum += texture(image, uv + vec2(halfpixel.x, -halfpixel.y)).rgb;
    sum += texture(image, uv - vec2(halfpixel.x, -halfpixel.y)).rgb;

    fragColor = vec4(sum / 8.0, 1.0);
}

