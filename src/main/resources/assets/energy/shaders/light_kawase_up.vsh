#version 150
in vec3 Position;
in vec2 UV0;
uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
out vec2 texCoord;

void main() {
    // See light_kawase_down.vsh: this is a framebuffer-space pass, not GUI
    // geometry, so it must not inherit a screen's projection matrix.
    gl_Position = vec4(UV0.x * 2.0 - 1.0, 1.0 - UV0.y * 2.0, 0.0, 1.0);
    texCoord = UV0 * 2.0;
}
