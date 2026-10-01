#version 150

// Faithful port of the legacy #version 120 "glass" hands shader:
//   gl_FragColor = texture2D(blurredTexture, blurredPos) * multiplier * srcColor.a;
// Sampler0 = hand mask (alpha)  -> originalTexture (only its alpha is used)
// Sampler1 = blurred background -> blurredTexture (sampled in screen space)
// multiplier.rgb = tint, multiplier.a = glass opacity

uniform sampler2D Sampler0;
uniform sampler2D Sampler1;
uniform vec4 multiplier;

in vec2 TexCoord;
out vec4 OutColor;

void main() {
    float handAlpha = texture(Sampler0, TexCoord).a;
    vec3 blurred = texture(Sampler1, TexCoord).rgb;

    float coverage = handAlpha * multiplier.a;
    if (coverage <= 0.001) discard;

    // Premultiplied output for the ONE / ONE_MINUS_SRC_ALPHA composite below,
    // mirroring the original "* srcColor.a" multiply.
    OutColor = vec4(blurred * multiplier.rgb * coverage, coverage);
}
