#version 150

uniform vec2 size;
uniform vec3 color;
uniform vec4 radius;
uniform float alpha;
uniform float glowRadius;

in vec2 TexCoord;
out vec4 fragColor;

float signedDistanceField(vec2 p, vec2 b, vec4 r) {
    r.xy = (p.x > 0.0) ? r.xy : r.zw;
    r.x  = (p.y > 0.0) ? r.x : r.y;

    vec2 q = abs(p) - b + r.x;
    return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - r.x;
}

void main() {
    vec2 halfSize = size * 0.5;
    float sdf = signedDistanceField(halfSize - TexCoord * size, halfSize - glowRadius, radius);

    float a = (1.0 - smoothstep(-glowRadius, glowRadius, sdf)) * alpha;

    fragColor = mix(vec4(color, 0.0),
                    vec4(color, a),
                    a);
}
