#version 150

uniform sampler2D Sampler0;
uniform vec2 offset;
uniform vec2 texSize;
uniform float fade;
uniform float t;
uniform float dt;
uniform float turb;
uniform float flickAmp;
uniform float flames;
uniform float expand;
uniform float softness;

in vec2 TexCoord;
out vec4 OutColor;

float hash12(vec2 p) {
    vec3 p3 = fract(vec3(p.xyx) * 0.1031);
    p3 += dot(p3, p3.yzx + 33.33);
    return fract((p3.x + p3.y) * p3.z);
}

float vnoise(vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    vec2 u = f * f * (3.0 - 2.0 * f);
    float a = hash12(i);
    float b = hash12(i + vec2(1.0, 0.0));
    float c = hash12(i + vec2(0.0, 1.0));
    float d = hash12(i + vec2(1.0, 1.0));
    return mix(mix(a, b, u.x), mix(c, d, u.x), u.y);
}

float fbm(vec2 p) {
    float v = 0.0;
    float a = 0.55;
    for (int i = 0; i < 4; i++) {
        v += a * vnoise(p);
        p = p * 2.07 + vec2(1.7, 9.2);
        a *= 0.5;
    }
    return v;
}

// Slowly scrolling velocity field: the plume licks sideways while it climbs.
vec2 flowField(vec2 uv, float tt) {
    vec2 q = uv * vec2(3.4, 2.6) + vec2(0.0, -tt * 0.75);
    return vec2(fbm(q), fbm(q + vec2(37.2, 11.5))) - 0.5;
}

float wob(float y, float tt) {
    return sin(y * 9.0 + tt * 4.3) * 0.6
         + sin(y * 17.0 - tt * 2.1) * 0.3
         + sin(y * 4.0 + tt * 1.3) * 0.4
         + sin(y * 28.0 + tt * 5.7) * 0.15;
}

vec4 softSample(vec2 p, float r) {
    vec2 px = r / max(texSize, vec2(1.0));
    vec4 c = texture(Sampler0, p) * 0.28;
    c += texture(Sampler0, p + vec2(px.x, 0.0)) * 0.13;
    c += texture(Sampler0, p + vec2(-px.x, 0.0)) * 0.13;
    c += texture(Sampler0, p + vec2(0.0, px.y)) * 0.13;
    c += texture(Sampler0, p + vec2(0.0, -px.y)) * 0.13;
    c += texture(Sampler0, p + px * 0.7) * 0.05;
    c += texture(Sampler0, p - px * 0.7) * 0.05;
    c += texture(Sampler0, p + vec2(px.x, -px.y) * 0.7) * 0.05;
    c += texture(Sampler0, p + vec2(-px.x, px.y) * 0.7) * 0.05;
    return c;
}

void main() {
    vec2 uv = TexCoord;

    float yFactor = 0.6 + uv.y * 1.0;
    float dxTurb = (wob(uv.y, t) - wob(uv.y, t - dt)) * turb;

    vec2 f = flowField(uv, t);
    vec2 lick = vec2(f.x * 1.7, abs(f.y) * 1.1 + 0.30) * flames * dt * 0.30;
    vec2 grow = (uv - vec2(0.5, 0.05)) * expand * dt;

    vec2 disp = vec2(offset.x + dxTurb, offset.y * yFactor) + lick + grow;
    vec4 c = softSample(uv - disp, softness);

    float flick = 1.0 - flickAmp + flickAmp * (0.5 + 0.5 * sin(t * 14.0) + 0.25 * sin(t * 9.3));
    // Noisy erosion breaks the plume into separate tongues instead of one blob.
    float eat = fade * (0.70 + 0.65 * vnoise(uv * 26.0 + vec2(0.0, -t * 2.2)));
    float oldA = c.a;
    float newA = max(0.0, oldA * (0.990 * flick) - eat);
    float scale = oldA > 1e-5 ? newA / oldA : 0.0;
    OutColor = vec4(c.rgb * scale, newA);
}
