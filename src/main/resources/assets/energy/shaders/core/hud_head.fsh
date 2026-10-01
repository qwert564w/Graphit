#version 330

layout(std140) uniform DynamicTransforms {
    mat4 ModelViewMat;
    vec4 ColorModulator;
    vec3 ModelOffset;
    mat4 TextureMat;
};

uniform sampler2D Sampler0;

in vec2 faceUv;
in vec4 vertexColor;
flat in vec2 logicalSize;
flat in float cornerRadius;
flat in float hurtAmount;

out vec4 fragColor;

vec4 sampleRegion(vec2 uv, ivec2 origin) {
    ivec2 atlasSize = textureSize(Sampler0, 0);
    ivec2 pixelOrigin = ivec2(round(vec2(origin) * vec2(atlasSize) / 64.0));
    ivec2 regionSize = max(ivec2(round(vec2(8.0) * vec2(atlasSize) / 64.0)), ivec2(1));
    ivec2 localPixel = clamp(ivec2(floor(uv * vec2(regionSize))), ivec2(0), regionSize - ivec2(1));
    return texelFetch(Sampler0, pixelOrigin + localPixel, 0);
}

float signedDistanceField(vec2 p, vec2 b, float r) {
    return length(max(abs(p) - b, 0.0)) - r;
}

void main() {
    vec2 pixel = faceUv * logicalSize;
    vec2 centre = logicalSize * 0.5;
    float roundMask = 1.0 - smoothstep(0.0, 1.0,
        signedDistanceField(centre - pixel,
                            centre - cornerRadius - 1.0,
                            cornerRadius)
    );

    vec4 base = sampleRegion(faceUv, ivec2(8, 8));
    vec4 hat = sampleRegion(faceUv, ivec2(40, 8));
    vec3 rgb = mix(base.rgb, hat.rgb, hat.a);
    rgb = mix(rgb, vec3(1.0, 0.0, 0.0), hurtAmount);
    // The old shader multiplied the animation alpha once as a uniform and
    // once through vertexColor. Keep that exact fade behaviour.
    float alpha = max(base.a, hat.a) * roundMask * vertexColor.a;
    if (alpha == 0.0) discard;
    fragColor = vec4(rgb, alpha) * vertexColor * ColorModulator;
}
