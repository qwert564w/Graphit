#version 150

uniform sampler2D Sampler0;

uniform vec2 size;
uniform float radius;
uniform float hurt_time;
uniform float alpha;
uniform float texXSize;
uniform float texYSize;

in vec2 texCoord0;
in vec4 vertexColor;

out vec4 fragColor;

float signedDistanceField(vec2 p, vec2 b, float r) {
    return length(max(abs(p) - b, 0.0)) - r;
}

vec4 sampleSkinRegionNearest(vec2 uv, vec2 origin) {
    ivec2 atlasSize = textureSize(Sampler0, 0);
    vec2 atlasScale = vec2(atlasSize) / vec2(texXSize, texYSize);
    ivec2 regionOrigin = ivec2(round(origin * atlasScale));
    ivec2 regionSize = max(ivec2(round(vec2(8.0) * atlasScale)), ivec2(1));
    ivec2 localPixel = clamp(
        ivec2(floor(uv * vec2(regionSize))),
        ivec2(0),
        regionSize - ivec2(1)
    );
    return texelFetch(Sampler0, regionOrigin + localPixel, 0);
}

void main() {
    vec2 tex = texCoord0;
    vec2 pixel = tex * size;
    vec2 centre = 0.5 * size;
    
    float roundMask = 1.0 - smoothstep(0.0, 1.0, signedDistanceField(centre - pixel, centre - radius - 1.0, radius));
    
    vec4 baseSkin = sampleSkinRegionNearest(tex, vec2(8.0, 8.0));
    vec4 overlay = sampleSkinRegionNearest(tex, vec2(40.0, 8.0));
    
    vec3 finalColor = mix(baseSkin.rgb, overlay.rgb, overlay.a);
    float finalAlpha = max(baseSkin.a, overlay.a);
    
    finalColor = mix(finalColor, vec3(1.0, 0.0, 0.0), hurt_time);
    
    finalAlpha = finalAlpha * roundMask * alpha;
    
    fragColor = vec4(finalColor, finalAlpha) * vertexColor;
}





