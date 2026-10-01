#version 150

in vec2 TexCoord;
out vec4 fragColor;

uniform vec2 size;
uniform vec4 radius;
uniform vec4 color;

float signedDistanceField(vec2 p, vec2 b, vec4 r) {
    r.xy = (p.x > 0.0) ? r.xy : r.zw;
    r.x  = (p.y > 0.0) ? r.x : r.y;

    vec2 q = abs(p) - b + r.x;
    return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - r.x;
}

void main() {
    vec2 rectHalf = size * 0.5;
    float sdf = signedDistanceField(rectHalf - (TexCoord * size),
                                    rectHalf - 1.0,
                                    radius);
    float smoothedAlpha = (1.0 - smoothstep(0.0, 1.0, sdf)) * color.a;
    fragColor = vec4(color.rgb, smoothedAlpha);
}
