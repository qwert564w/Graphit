#version 150

in vec3 Position;
in vec4 Color;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

out vec4 vertexColor;
out vec3 localPos;
out vec2 quadUv;

const vec2[4] QUAD_UVS = vec2[](
    vec2(0.0, 0.0),
    vec2(0.0, 1.0),
    vec2(1.0, 1.0),
    vec2(1.0, 0.0)
);

void main() {
    vertexColor = Color;
    localPos = Position;
    quadUv = QUAD_UVS[gl_VertexID % 4];
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);
}
