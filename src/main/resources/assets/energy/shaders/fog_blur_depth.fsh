#version 150

uniform sampler2D Tex0;
uniform sampler2D Tex1;
uniform float Near;
uniform float Far;
uniform float MinThreshold;
uniform float MaxThreshold;

in vec2 texCoord;
out vec4 fragColor;

float linearizeDepth(float depth, float nearPlane, float farPlane) {
    return (2.0 * nearPlane * farPlane) / (farPlane + nearPlane - depth * (farPlane - nearPlane));
}

void main() {
    float depth = texture(Tex1, texCoord).x;
    float distance = linearizeDepth(depth, Near, Far) / max(Far, 1e-5);

    fragColor = vec4(0.0);
    if (distance > MinThreshold) {
        vec3 blurredColor = texture(Tex0, texCoord).rgb;
        float thresholdRange = max(MaxThreshold - MinThreshold, 1e-5);
        float alpha = clamp((distance - MinThreshold) / thresholdRange, 0.0, 1.0);
        fragColor = vec4(blurredColor, alpha);
    }
}
