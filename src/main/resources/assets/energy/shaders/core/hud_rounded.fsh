#version 330

layout(std140) uniform DynamicTransforms {
    mat4 ModelViewMat;
    vec4 ColorModulator;
    vec3 ModelOffset;
    mat4 TextureMat;
};

in vec2 localUv;
in vec4 vertexColor;
flat in vec2 logicalSize;
flat in vec4 cornerRadii;
out vec4 fragColor;

float signedDistanceField(vec2 p, vec2 b, vec4 r) {
    r.xy = (p.x > 0.0) ? r.xy : r.zw;
    r.x = (p.y > 0.0) ? r.x : r.y;

    vec2 q = abs(p) - b + r.x;
    return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - r.x;
}

void main() {
    vec2 rectHalf = logicalSize * 0.5;
    float sdf = signedDistanceField(rectHalf - localUv * logicalSize,
                                    rectHalf - 1.0,
                                    cornerRadii);
    float smoothedAlpha = (1.0 - smoothstep(0.0, 1.0, sdf)) * vertexColor.a;
    fragColor = vec4(vertexColor.rgb, smoothedAlpha) * ColorModulator;
}
