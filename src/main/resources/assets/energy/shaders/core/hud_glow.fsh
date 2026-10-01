#version 330

layout(std140) uniform DynamicTransforms {
    mat4 ModelViewMat;
    vec4 ColorModulator;
    vec3 ModelOffset;
    mat4 TextureMat;
};

in vec2 localUv;
in vec2 shapeRatios;
in vec4 vertexColor;
out vec4 fragColor;

float roundedBoxSdf(vec2 point, vec2 halfBounds, float radius) {
    vec2 q = abs(point) - halfBounds + radius;
    return min(max(q.x, q.y), 0.0) + length(max(q, 0.0)) - radius;
}

void main() {
    vec2 size = vec2(1.0 / max(fwidth(localUv.x), 0.000001),
                     1.0 / max(fwidth(localUv.y), 0.000001));
    float minimumSize = min(size.x, size.y);
    float radius = minimumSize * shapeRatios.x;
    float glowRadius = max(minimumSize * shapeRatios.y, 0.0001);
    vec2 halfSize = size * 0.5;
    float sdf = roundedBoxSdf(halfSize - localUv * size,
                              halfSize - glowRadius,
                              radius);

    float alpha = (1.0 - smoothstep(-glowRadius, glowRadius, sdf)) * vertexColor.a;
    fragColor = vec4(vertexColor.rgb, alpha * alpha) * ColorModulator;
}
