#version 150

uniform sampler2D Sampler0;
uniform float time;
uniform float warp;
uniform float density;
uniform float glow;
uniform vec2 resolution;

in vec2 texCoord;
out vec4 fragColor;

float hash(vec2 p) {
    p = fract(p * vec2(123.34, 345.45));
    p += dot(p, p + 34.345);
    return fract(p.x * p.y);
}

vec3 palette(float t) {
    return vec3(
    0.55 + 0.45 * sin(t + 0.0),
    0.55 + 0.45 * sin(t + 2.0),
    0.75 + 0.25 * sin(t + 4.0)
    );
}

void main() {
    vec2 uv = texCoord;
    vec2 res = resolution;

    vec2 centered = uv - 0.5;
    centered.x *= res.x / max(res.y, 1.0);
    float len = length(centered);

    float angle = atan(centered.y, centered.x);
    float swirl = sin(angle * 4.0 + len * 10.0 - time * 1.4);
    vec2 warped = uv + normalize(centered + 1e-4) * swirl * 0.02 * warp;

    vec4 base = texture(Sampler0, warped);

    float starNoise = hash(warped * density * 60.0 + time);
    float stars = step(0.985, starNoise) * glow;

    vec3 nebula = palette(time * 0.2 + len * 3.0);
    vec3 starColor = palette(time * 0.35);

    float halo = smoothstep(0.6, 0.0, len);

    // stronger stylization so эффект явно заметен
    vec3 cosmic = nebula * (0.6 + glow * 0.4);
    cosmic += starColor * stars * 1.8;
    cosmic = mix(base.rgb, cosmic, 0.9); // 90% замешиваем космос
    cosmic = mix(cosmic, base.rgb, 1.0 - halo * 0.6); // слегка подсвечиваем края рук

    fragColor = vec4(cosmic, base.a);
}
