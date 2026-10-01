package su.energyclient.render;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

public final class RenderUtil21 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final VertexFormat f_1139 = VertexFormat.builder()
      .add(RenderUtil21.f_1152, VertexFormatElement.POSITION)
      .add(RenderUtil21.f_1153, VertexFormatElement.COLOR)
      .add(RenderUtil21.f_1154, VertexFormatElement.UV0)
      .add(RenderUtil21.f_1155, VertexFormatElement.UV1)
      .add(RenderUtil21.f_1156, VertexFormatElement.UV2)
      .build();
   private static final Identifier f_1140 = Identifier.of(RenderUtil21.f_1157, RenderUtil21.f_1158);
   private static final Identifier f_1141 = Identifier.of(RenderUtil21.f_1159, RenderUtil21.f_1160);
   private static final Identifier f_1142 = Identifier.of(RenderUtil21.f_1161, RenderUtil21.f_1162);
   private static final Identifier f_1143 = Identifier.of(RenderUtil21.f_1163, RenderUtil21.f_1164);
   private static final Identifier f_1144 = Identifier.of(RenderUtil21.f_1165, RenderUtil21.f_1166);
   public static final RenderPipeline f_1145 = l(RenderUtil21.f_1167, f_1142);
   public static final RenderPipeline f_1146 = l(RenderUtil21.f_1168, f_1143);
   public static final RenderPipeline f_1147 = m_3037(RenderUtil21.f_1169, f_1144);
   public static final RenderPipeline f_1148 = RenderPipelines.register(
      RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
         .withLocation(Identifier.of(RenderUtil21.f_1170, RenderUtil21.f_1171))
         .withBlend(new BlendFunction(SourceFactor.SRC_ALPHA, DestFactor.ONE, SourceFactor.ZERO, DestFactor.ONE))
         .build()
   );
   public static final RenderPipeline l = RenderPipelines.register(
      RenderPipeline.builder(new Snippet[]{RenderPipelines.TRANSFORMS_AND_PROJECTION_SNIPPET})
         .withLocation(Identifier.of(RenderUtil21.f_1172, RenderUtil21.f_1173))
         .withVertexShader(f_1140)
         .withFragmentShader(f_1140)
         .withSampler(RenderUtil21.f_1174)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withVertexFormat(f_1139, DrawMode.QUADS)
         .build()
   );
   public static final RenderPipeline f_1149 = RenderPipelines.register(
      RenderPipeline.builder(new Snippet[]{RenderPipelines.TRANSFORMS_AND_PROJECTION_SNIPPET})
         .withLocation(Identifier.of(RenderUtil21.f_1175, RenderUtil21.f_1176))
         .withVertexShader(f_1141)
         .withFragmentShader(f_1141)
         .withSampler(RenderUtil21.f_1177)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withVertexFormat(f_1139, DrawMode.QUADS)
         .build()
   );
   private static final String f_1150 = "energy";
   private static final String f_1151 = "energy";
   private static final String f_1152 = "Position";
   private static final String f_1153 = "Color";
   private static final String f_1154 = "UV0";
   private static final String f_1155 = "UV1";
   private static final String f_1156 = "UV2";
   private static final String f_1157 = "energy";
   private static final String f_1158 = "core/hud_blur";
   private static final String f_1159 = "energy";
   private static final String f_1160 = "core/hud_head";
   private static final String f_1161 = "energy";
   private static final String f_1162 = "core/hud_rounded";
   private static final String f_1163 = "energy";
   private static final String f_1164 = "core/hud_squircle";
   private static final String f_1165 = "energy";
   private static final String f_1166 = "core/hud_glow";
   private static final String f_1167 = "hud_rounded_rect";
   private static final String f_1168 = "hud_squircle_rect";
   private static final String f_1169 = "hud_glow_rect";
   private static final String f_1170 = "energy";
   private static final String f_1171 = "pipeline/hud_textured_additive";
   private static final String f_1172 = "energy";
   private static final String f_1173 = "pipeline/hud_blurred_rounded";
   private static final String f_1174 = "Sampler0";
   private static final String f_1175 = "energy";
   private static final String f_1176 = "pipeline/hud_rounded_head";
   private static final String f_1177 = "Sampler0";

   private static RenderPipeline l(String var0, Identifier var1) {
      return RenderPipelines.register(
         RenderPipeline.builder(new Snippet[]{RenderPipelines.TRANSFORMS_AND_PROJECTION_SNIPPET})
            .withLocation(Identifier.of(f_1150, "pipeline/" + var0))
            .withVertexShader(var1)
            .withFragmentShader(var1)
            .withBlend(BlendFunction.TRANSLUCENT)
            .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
            .withDepthWrite(false)
            .withVertexFormat(f_1139, DrawMode.QUADS)
            .build()
      );
   }

   private RenderUtil21() {
   }

   private static RenderPipeline m_3037(String var0, Identifier var1) {
      return RenderPipelines.register(
         RenderPipeline.builder(new Snippet[]{RenderPipelines.TRANSFORMS_AND_PROJECTION_SNIPPET})
            .withLocation(Identifier.of(f_1151, "pipeline/" + var0))
            .withVertexShader(var1)
            .withFragmentShader(var1)
            .withBlend(BlendFunction.TRANSLUCENT)
            .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
            .withDepthWrite(false)
            .withVertexFormat(VertexFormats.POSITION_TEXTURE_COLOR, DrawMode.QUADS)
            .build()
      );
   }

   public static void m_3785() {
   }
}
