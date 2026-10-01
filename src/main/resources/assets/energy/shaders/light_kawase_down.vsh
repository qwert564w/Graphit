#version 150
in vec3 Position;
in vec2 UV0;
uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
out vec2 texCoord;

void main() {
    // Post-process passes must cover the target independently of the current
    // GUI scale/projection (HUD uses scale 2, screens may use another scale).
    gl_Position = vec4(UV0.x * 2.0 - 1.0, 1.0 - UV0.y * 2.0, 0.0, 1.0);
    texCoord = UV0 * 0.5;
}
