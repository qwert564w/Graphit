#version 330

layout(std140) uniform DynamicTransforms {
    mat4 ModelViewMat;
    vec4 ColorModulator;
    vec3 ModelOffset;
    mat4 TextureMat;
};

uniform sampler2D Sampler0;

in vec2 localUv;
in vec2 screenUv;
in vec4 tintColor;
flat in vec2 logicalSize;
flat in float cornerRadius;
flat in float overallAlpha;

out vec4 fragColor;

float signedDistanceField(vec2 p, vec2 b, float r) {
    vec2 q = abs(p) - b + r;
    if (q.x < 0.0 && q.y < 0.0) {
        return max(q.x, q.y);
    }

    vec2 qp = max(q, 0.0);
    float n = 5.0;
    return pow(pow(qp.x, n) + pow(qp.y, n), 1.0 / n) - r;
}

void main() {
    vec2 rectHalf = logicalSize * 0.5;
    float rr = 1.0 - smoothstep(0.0, 1.0,
        signedDistanceField(rectHalf - localUv * logicalSize,
                            rectHalf - 1.0,
                            cornerRadius)
    );

    vec3 blurred = texture(Sampler0, screenUv).rgb;
    vec3 tinted = mix(blurred, tintColor.rgb, tintColor.a);
    fragColor = vec4(tinted, rr * overallAlpha) * ColorModulator;
}
