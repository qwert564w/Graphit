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

out vec2 faceUv;
out vec4 vertexColor;
flat out vec2 logicalSize;
flat out float cornerRadius;
flat out float hurtAmount;

const vec2[4] RECT_VERTICES = vec2[](
    vec2(0.0, 0.0),
    vec2(0.0, 1.0),
    vec2(1.0, 1.0),
    vec2(1.0, 0.0)
);

void main() {
    gl_Position = ProjMat * ModelViewMat * vec4(Position.xy, 0.0, 1.0);
    faceUv = RECT_VERTICES[gl_VertexID % 4];
    vertexColor = Color;
    logicalSize = UV0;
    cornerRadius = float(UV1.x) / 64.0;
    hurtAmount = Position.z;
}
