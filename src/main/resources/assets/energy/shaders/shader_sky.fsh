#version 150

uniform vec2 u_Resolution;
uniform float u_Fov;
uniform mat4 u_WorldFromView;

uniform float time;
uniform float speed;
uniform float intensity;
uniform float waveScale;
uniform float starStrength;
uniform float saturation;
uniform float brightness;
uniform float skyAlpha;

uniform vec4 lowColor;   // aurora base (near the horizon side of a curtain)
uniform vec4 highColor;  // aurora tips (toward the top of a curtain)
uniform vec4 deepColor;  // night sky tint

out vec4 fragColor;

float hash21(vec2 p) {
    p = fract(p * vec2(123.34, 456.21));
    p += dot(p, p + 45.32);
    return fract(p.x * p.y);
}

float vnoise(vec2 p) {
    vec2 i = floor(p);
    vec2 f = fract(p);
    vec2 u = f * f * (3.0 - 2.0 * f);
    float a = hash21(i);
    float b = hash21(i + vec2(1.0, 0.0));
    float c = hash21(i + vec2(0.0, 1.0));
    float d = hash21(i + vec2(1.0, 1.0));
    return mix(mix(a, b, u.x), mix(c, d, u.x), u.y);
}

float fbm(vec2 p) {
    float v = 0.0;
    float a = 0.5;
    for (int i = 0; i < 5; i++) {
        v += a * vnoise(p);
        p = p * 1.92 + vec2(7.3, 1.7);
        a *= 0.5;
    }
    return v;
}

// World-space view direction for this pixel (reconstructed from screen + camera).
vec3 viewDir() {
    vec2 ndc = (gl_FragCoord.xy / u_Resolution) * 2.0 - 1.0;
    float aspect = u_Resolution.x / max(u_Resolution.y, 1.0);
    float tanFov = tan(u_Fov * 0.5);
    vec3 rayView = normalize(vec3(ndc.x * aspect * tanFov, ndc.y * tanFov, -1.0));
    return normalize((u_WorldFromView * vec4(rayView, 0.0)).xyz);
}

void main() {
    vec3 dir = viewDir();
    float t = time * max(speed, 0.001);

    float az = atan(dir.z, dir.x);             // azimuth  (-pi .. pi)
    float el = asin(clamp(dir.y, -1.0, 1.0));  // elevation
    float zen = clamp(dir.y, 0.0, 1.0);

    // ---- night sky tint (deeper toward the zenith) ----
    vec3 nightSky = mix(deepColor.rgb * 1.35, deepColor.rgb * 0.55, pow(zen, 0.6));

    // ---- stars ----
    vec3 starCol = vec3(0.0);
    {
        vec2 sUv = vec2(az * 2.1, el * 2.7) * 26.0;
        vec2 cell = floor(sUv);
        float h = hash21(cell);
        float s = smoothstep(0.978, 1.0, h);
        float tw = 0.5 + 0.5 * sin(t * 5.0 + h * 90.0);
        starCol = vec3(0.80, 0.90, 1.0) * s * tw * starStrength * smoothstep(0.02, 0.35, dir.y);
    }

    // ---- aurora curtains ----
    vec3 aurora = vec3(0.0);
    float glow = 0.0;
    if (dir.y > -0.05) {
        float ws = max(waveScale, 0.05);
        float fr = 2.2 / ws;
        vec2 azc = vec2(cos(az), sin(az));     // seamless azimuth coordinate

        const int LAYERS = 5;
        for (int i = 0; i < LAYERS; i++) {
            float fi = float(i);

            // base elevation of this curtain, with a slow horizontal wave
            float base = 0.18 + fi * 0.155;
            float w = fbm(azc * fr + vec2(fi * 4.0, t * 0.20)) * 2.0 - 1.0;
            float center = base + w * 0.17;

            float d = el - center;
            float sheet = exp(-d * d * 62.0);

            // vertical striations running up the curtain
            float rays = fbm(azc * (fr * 4.0) + vec2(fi * 2.0, el * 3.0 - t * 0.45));
            rays = pow(0.40 + 0.60 * rays, 2.0);

            float flicker = 0.80 + 0.20 * sin(t * 1.7 + fi * 1.7 + azc.x * 2.0);

            float strength = sheet * rays * flicker;

            // vertical colour gradient: lowColor at the base, highColor at the tips
            float g = clamp(d * 6.0 + 0.5, 0.0, 1.0);
            vec3 cc = mix(lowColor.rgb, highColor.rgb, g);
            cc = mix(cc, lowColor.rgb * vec3(0.55, 1.0, 0.75), clamp(-d * 4.5, 0.0, 0.45));

            aurora += cc * strength * (1.0 - fi * 0.10);
            glow += strength;
        }

        float horizonMask = smoothstep(-0.04, 0.10, dir.y);
        aurora *= horizonMask * intensity;
        glow *= horizonMask;

        // soft bloom around the brightest parts
        aurora += highColor.rgb * pow(clamp(glow, 0.0, 1.0), 2.2) * 0.18 * intensity;
    }

    vec3 color = nightSky + aurora + starCol;

    // saturation / brightness
    float luma = dot(color, vec3(0.299, 0.587, 0.114));
    color = mix(vec3(luma), color, saturation);
    color *= brightness;

    // gentle tonemap so the highlights stay clean
    color = color / (1.0 + max(color, 0.0) * 0.28);
    color = clamp(color, 0.0, 1.0);

    fragColor = vec4(color, clamp(skyAlpha, 0.0, 1.0));
}
