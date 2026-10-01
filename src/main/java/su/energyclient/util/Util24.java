package su.energyclient.util;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gl.Defines;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import su.energyclient.QuickImports;
import su.energyclient.render.RenderUtil9;

public class Util24 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final List<RenderUtil9> f_3259 = new ArrayList<>();
   public static final RenderUtil9 f_3260 = m_642(Util24.f_3298, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 l = m_642(Util24.f_3299, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3261 = m_642(Util24.f_3300, VertexFormats.POSITION_COLOR);
   public static final RenderUtil9 f_3262 = m_642(Util24.f_3301, VertexFormats.POSITION_COLOR);
   public static final RenderUtil9 f_3263 = m_642(Util24.f_3302, VertexFormats.POSITION_COLOR);
   public static final RenderUtil9 f_3264 = m_642(Util24.f_3303, VertexFormats.POSITION_COLOR);
   public static final RenderUtil9 f_3265 = m_642(Util24.f_3304, VertexFormats.POSITION_COLOR);
   public static final RenderUtil9 f_3266 = m_642(Util24.f_3305, VertexFormats.POSITION_COLOR);
   public static final RenderUtil9 f_3267 = m_642(Util24.f_3306, VertexFormats.POSITION_COLOR);
   public static final RenderUtil9 f_3268 = m_642(Util24.f_3307, VertexFormats.POSITION_TEXTURE_COLOR);
   public static RenderUtil9 f_3269 = m_642(Util24.f_3308, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3270 = m_642(Util24.f_3309, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3271 = m_642(Util24.f_3310, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3272 = m_642(Util24.f_3311, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3273 = m_642(Util24.f_3312, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3274 = m_642(Util24.f_3313, VertexFormats.POSITION_COLOR);
   public static final RenderUtil9 f_3275 = m_642(Util24.f_3314, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3276 = m_642(Util24.f_3315, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3277 = m_642(Util24.f_3316, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3278 = m_642(Util24.f_3317, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3279 = m_642(Util24.f_3318, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3280 = m_642(Util24.f_3319, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3281 = m_642(Util24.f_3320, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3282 = m_642(Util24.f_3321, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3283 = m_642(Util24.f_3322, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3284 = m_642(Util24.f_3323, VertexFormats.POSITION_TEXTURE);
   public static final RenderUtil9 f_3285 = m_642(Util24.f_3324, VertexFormats.POSITION);
   public static final RenderUtil9 f_3286 = m_642(Util24.f_3325, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3287 = m_642(Util24.f_3326, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3288 = m_642(Util24.f_3327, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3289 = m_642(Util24.f_3328, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3290 = m_642(Util24.f_3329, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3291 = m_642(Util24.f_3330, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3292 = m_642(Util24.f_3331, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3293 = m_642(Util24.f_3332, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3294 = m_642(Util24.f_3333, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3295 = m_642(Util24.f_3334, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 O = m_642(Util24.f_3335, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_3296 = m_642(Util24.f_3336, VertexFormats.POSITION_TEXTURE_COLOR);
   private static final String f_3297 = "energy";
   private static final String f_3298 = "light_kawase_up";
   private static final String f_3299 = "light_kawase_down";
   private static final String f_3300 = "rounded_rectangle";
   private static final String f_3301 = "squircle_round_rect";
   private static final String f_3302 = "outline";
   private static final String f_3303 = "blurred_round_rectangle";
   private static final String f_3304 = "rounded_rectangle_gradient";
   private static final String f_3305 = "rounded_rectangle_gradient_glowed";
   private static final String f_3306 = "rounded_rectangle_glowed";
   private static final String f_3307 = "substring";
   private static final String f_3308 = "rounded_head_texture";
   private static final String f_3309 = "ghost";
   private static final String f_3310 = "hands_cosmos";
   private static final String f_3311 = "hands_blur";
   private static final String f_3312 = "scan_effect";
   private static final String f_3313 = "block_highlight_liquid";
   private static final String f_3314 = "fog_blur_tint";
   private static final String f_3315 = "fog_blur_gaussian";
   private static final String f_3316 = "fog_blur_depth";
   private static final String f_3317 = "fog_blur_passthrough";
   private static final String f_3318 = "fog_glow_extract";
   private static final String f_3319 = "fog_glow_blur";
   private static final String f_3320 = "fog_glow_composite";
   private static final String f_3321 = "dead_internet";
   private static final String f_3322 = "realistic_rain_world";
   private static final String f_3323 = "realistic_rain_lens";
   private static final String f_3324 = "shader_sky";
   private static final String f_3325 = "hands_pretty";
   private static final String f_3326 = "hands_glow";
   private static final String f_3327 = "hands_kawase_up";
   private static final String f_3328 = "hands_kawase_down";
   private static final String f_3329 = "hands_mask_diff";
   private static final String f_3330 = "hands_overlay";
   private static final String f_3331 = "hands_pick";
   private static final String f_3332 = "hands_trail_displace";
   private static final String f_3333 = "hands_trail_glow";
   private static final String f_3334 = "hands_trail_energy_displace";
   private static final String f_3335 = "hands_trail_energy";
   private static final String f_3336 = "hands_glass";

   private static RenderUtil9 m_3046(String var0, VertexFormat var1, Defines var2) {
      RenderUtil9 var3 = new RenderUtil9(Identifier.of(f_3297, var0), var1, var2);
      f_3259.add(var3);
      return var3;
   }

   private static RenderUtil9 m_642(String var0, VertexFormat var1) {
      return m_3046(var0, var1, Defines.EMPTY);
   }
}
