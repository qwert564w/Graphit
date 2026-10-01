#version 150

uniform sampler2D image;
uniform float offset;
uniform vec2 resolution;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    vec2 uv = texCoord / 2.0;
    vec2 halfpixel = resolution / 2.0 * offset;

    vec3 sum = vec3(0.0);
    sum += texture(image, uv + vec2(-halfpixel.x * 2.0, 0.0)).rgb;
    sum += texture(image, uv + vec2(-halfpixel.x, halfpixel.y)).rgb * 2.0;
    sum += texture(image, uv + vec2(0.0, halfpixel.y * 2.0)).rgb;
    sum += texture(image, uv + vec2(halfpixel.x, halfpixel.y)).rgb * 2.0;
    sum += texture(image, uv + vec2(halfpixel.x * 2.0, 0.0)).rgb;
    sum += texture(image, uv + vec2(halfpixel.x, -halfpixel.y)).rgb * 2.0;
    sum += texture(image, uv + vec2(0.0, -halfpixel.y * 2.0)).rgb;
    sum += texture(image, uv + vec2(-halfpixel.x, -halfpixel.y)).rgb * 2.0;

    fragColor = vec4(sum / 12.0, 1.0);
}

