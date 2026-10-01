package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.gl.Defines;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;

public final class RenderUtil7 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final RenderUtil9 f_13885 = m_1436(RenderUtil7.f_13890, VertexFormats.POSITION_COLOR);
   public static final RenderUtil9 f_13886 = m_1436(RenderUtil7.f_13891, VertexFormats.POSITION_TEXTURE_COLOR);
   public static final RenderUtil9 f_13887 = m_1436(RenderUtil7.f_13892, VertexFormats.POSITION_COLOR_NORMAL_LINE_WIDTH);
   public static final RenderUtil9 f_13888 = m_1436(RenderUtil7.f_13893, VertexFormats.POSITION);
   private static final String f_13889 = "energy";
   private static final String f_13890 = "position_color";
   private static final String f_13891 = "position_tex_color";
   private static final String f_13892 = "lines";
   private static final String f_13893 = "blit_screen";

   private static RenderUtil9 m_1436(String var0, VertexFormat var1) {
      return new RenderUtil9(Identifier.of(f_13889, "compat/" + var0), var1, Defines.EMPTY);
   }

   private RenderUtil7() {
   }
}
