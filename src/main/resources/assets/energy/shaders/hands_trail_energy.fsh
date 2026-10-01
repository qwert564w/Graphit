#version 150

uniform sampler2D Sampler0;
uniform vec3 color;
uniform vec3 color2;
uniform float exposure;
uniform float autoColor;
uniform float saturation;
uniform float intensity;
uniform float core;
uniform float pulse;
uniform float time;

in vec2 TexCoord;
out vec4 OutColor;

vec3 extractItemColor(vec4 bloom) {
    vec3 c = bloom.rgb / max(bloom.a, 0.001);
    float m = max(c.r, max(c.g, c.b));
    if (m > 0.001) {
        c /= m;
    }
    float l = dot(c, vec3(0.299, 0.587, 0.114));
    return clamp(mix(vec3(l), c, saturation), 0.0, 1.0);
}

void main() {
    vec2 uv = TexCoord;
    vec4 bloom = texture(Sampler0, uv);
    if (bloom.a <= 0.0) {
        discard;
    }

    float breathe = 1.0 + pulse * (0.32 * sin(time * 6.1) + 0.18 * sin(time * 9.7 + 1.3));
    float raw = bloom.a * exposure * intensity * breathe;
    // Exponential saturation instead of a clamp: the halo can be driven hard without
    // collapsing into a flat disc with a visible cut-off ring.
    float a = 1.0 - exp(-raw);
    if (a <= 0.002) {
        discard;
    }

    vec3 base = autoColor > 0.5
            ? extractItemColor(bloom)
            : mix(color, color2, uv.y);

    // Overdrive the hue so the plume reads as neon rather than washed out.
    float lum = dot(base, vec3(0.299, 0.587, 0.114));
    base = clamp(mix(vec3(lum), base, 1.35), 0.0, 1.0);

    // Keyed off raw coverage so the white core hugs the silhouette regardless of intensity.
    float hot = smoothstep(0.55, 1.0, bloom.a);
    vec3 rgb = mix(base, vec3(1.0), hot * core);
    rgb *= 1.0 + 0.85 * raw;

    OutColor = vec4(rgb * a, a);
}
