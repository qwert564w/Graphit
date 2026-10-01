#version 150

uniform sampler2D blurredTexture;
uniform vec2 resolution;
uniform vec2 size;
uniform float radius;
uniform float alpha;
uniform vec4 color;

in vec2 texCoord;
out vec4 fragColor;

float signedDistanceField(vec2 p, vec2 b, float r) {
    vec2 q = abs(p) - b + r;

    if (q.x < 0.0 && q.y < 0.0) {
        return max(q.x, q.y);
    }

    vec2 qp = max(q, 0.0);
    float n = 5.0; // iOS squircle
    return pow(pow(qp.x, n) + pow(qp.y, n), 1.0 / n) - r;
}

void main() {
    vec2 rectHalf = size * 0.5;

    vec2 blurredPos = gl_FragCoord.xy / resolution;
    vec3 blurredColor = mix(texture(blurredTexture, blurredPos).rgb, color.rgb, color.a);

    vec2 localCoord = texCoord * size;

    float rr = 1.0 - smoothstep(0.0, 1.0,
        signedDistanceField(rectHalf - localCoord, rectHalf - 1.0, radius)
    );

    fragColor = vec4(blurredColor, rr * alpha);
}