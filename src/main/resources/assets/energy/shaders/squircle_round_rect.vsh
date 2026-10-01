#version 150

in vec3 Position;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

out vec2 TexCoord;

const vec2[4] RECT_VERTICES_COORDS = vec2[] (
    vec2(0.0, 0.0),
    vec2(0.0, 1.0),
    vec2(1.0, 1.0),
    vec2(1.0, 0.0)
);

void main() {
    TexCoord = RECT_VERTICES_COORDS[gl_VertexID % 4];
    gl_Position = ProjMat * ModelViewMat * vec4(Position, 1.0);
}

