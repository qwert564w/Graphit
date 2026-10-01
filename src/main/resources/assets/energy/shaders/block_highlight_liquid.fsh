#version 150

in vec4 vertexColor;
in vec3 localPos;
in vec2 quadUv;

out vec4 fragColor;

uniform float time;
uniform float alpha;
uniform vec4 baseColor;
uniform vec4 accentColor;
uniform float softness;

#define PI 3.14159265359

// psrdnoise2 (Stefan Gustavson & Ian McEwan, MIT license)
float psrdnoise(vec2 x, vec2 period, float rot, out vec2 grad) {
    vec2 uv = vec2(x.x + x.y * 0.5, x.y);
    vec2 i0 = floor(uv);
    vec2 f0 = fract(uv);
    float cmp = step(f0.y, f0.x);
    vec2 o1 = vec2(cmp, 1.0 - cmp);
    vec2 i1 = i0 + o1;
    vec2 i2 = i0 + vec2(1.0, 1.0);
    vec2 v0 = vec2(i0.x - i0.y * 0.5, i0.y);
    vec2 v1 = vec2(v0.x + o1.x - o1.y * 0.5, v0.y + o1.y);
    vec2 v2 = vec2(v0.x + 0.5, v0.y + 1.0);
    vec2 x0 = x - v0;
    vec2 x1 = x - v1;
    vec2 x2 = x - v2;
    vec3 iu, iv;
    vec3 xw, yw;
    if (any(greaterThan(period, vec2(0.0)))) {
        xw = vec3(v0.x, v1.x, v2.x);
        yw = vec3(v0.y, v1.y, v2.y);
        if (period.x > 0.0) xw = mod(vec3(v0.x, v1.x, v2.x), period.x);
        if (period.y > 0.0) yw = mod(vec3(v0.y, v1.y, v2.y), period.y);
        iu = floor(xw + 0.5 * yw + 0.5);
        iv = floor(yw + 0.5);
    } else {
        iu = vec3(i0.x, i1.x, i2.x);
        iv = vec3(i0.y, i1.y, i2.y);
    }
    vec3 hash = mod(iu, 289.0);
    hash = mod((hash * 51.0 + 2.0) * hash + iv, 289.0);
    hash = mod((hash * 34.0 + 10.0) * hash, 289.0);
    vec3 psi = hash * 0.07482 + rot;
    vec3 gx = cos(psi);
    vec3 gy = sin(psi);
    vec2 g0 = vec2(gx.x, gy.x);
    vec2 g1 = vec2(gx.y, gy.y);
    vec2 g2 = vec2(gx.z, gy.z);
    vec3 w = 0.8 - vec3(dot(x0, x0), dot(x1, x1), dot(x2, x2));
    w = max(w, 0.0);
    vec3 w2 = w * w;
    vec3 w4 = w2 * w2;
    vec3 gdotx = vec3(dot(g0, x0), dot(g1, x1), dot(g2, x2));
    float n = dot(w4, gdotx);
    vec3 w3 = w2 * w;
    vec3 dw = -8.0 * w3 * gdotx;
    vec2 dn0 = w4.x * g0 + dw.x * x0;
    vec2 dn1 = w4.y * g1 + dw.y * x1;
    vec2 dn2 = w4.z * g2 + dw.z * x2;
    grad = 10.9 * (dn0 + dn1 + dn2);
    return 10.9 * n;
}

vec2 rot(vec2 v, float a) {
    return mat2(cos(a), -sin(a), sin(a), cos(a)) * v;
}

void main() {
    // Stable per-face coordinate so the pattern stays put instead of sliding with the camera.
    vec2 st = rot(quadUv, -PI / 8.0);

    // Smooth domain-warped flow (faster swirl).
    vec2 grad;
    float n = psrdnoise(vec2(3.0) * st, vec2(0.0), 1.2 * time, grad);

    // Gentle smooth wave - no bounce easing, so no hard black/white "zebra" bands. Faster drift.
    float wave = 0.5 + 0.5 * sin((st.x * 4.5 + n * 0.9 + time * 0.9) * PI);
    wave = smoothstep(0.05, 0.95, wave);

    // Brighter, still low-contrast: both ends sit high so it glows instead of going muddy/dark.
    vec3 dim = baseColor.rgb * 0.8;
    vec3 lit = accentColor.rgb;
    vec3 col = mix(dim, lit, wave * 0.6 + 0.25);

    // Edge sheen to frame the face.
    float edgeDist = min(min(quadUv.x, 1.0 - quadUv.x), min(quadUv.y, 1.0 - quadUv.y));
    float edge = 1.0 - smoothstep(0.0, 0.14 + softness * 0.3, edgeDist);
    col += accentColor.rgb * edge * 0.1;

    // Higher, gently varying opacity so the highlight is clearly visible (but not a hard glare).
    float finalAlpha = (0.34 + 0.36 * wave) * alpha * vertexColor.a;

    fragColor = vec4(col, clamp(finalAlpha, 0.0, 1.0));
}
