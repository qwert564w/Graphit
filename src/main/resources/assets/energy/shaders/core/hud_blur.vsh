#version 330

layout(std140) uniform DynamicTransforms {
    mat4 ModelViewMat;
    vec4 ColorModulator;
    vec3 ModelOffset;
    mat4 TextureMat;
};
layout(std140) uniform Projection {
    mat4 ProjMat;
};

in vec3 Position;
in vec2 UV0;
in vec4 Color;
in ivec2 UV1;
in ivec2 UV2;

out vec2 localUv;
out vec2 screenUv;
out vec4 tintColor;
flat out vec2 logicalSize;
flat out float cornerRadius;
flat out float overallAlpha;

const vec2[4] RECT_VERTICES = vec2[](
    vec2(0.0, 0.0),
    vec2(0.0, 1.0),
    vec2(1.0, 1.0),
    vec2(1.0, 0.0)
);

void main() {
    vec4 clipPosition = ProjMat * ModelViewMat * vec4(Position.xy, 0.0, 1.0);
    gl_Position = clipPosition;
    localUv = RECT_VERTICES[gl_VertexID % 4];
    screenUv = clipPosition.xy / clipPosition.w * 0.5 + 0.5;
    tintColor = Color;
    logicalSize = UV0;
    cornerRadius = float(UV1.x) / 64.0;
    overallAlpha = Position.z;
}
