package su.energyclient.render;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.util.Objects;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.VertexFormats;
import su.energyclient.util.Util114;
import su.energyclient.util.Util98;

public class RenderUtil28 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static boolean f_1130 = true;
   private static final String f_1131 = "Blit shader not loaded";
   private static final String f_1132 = "InSampler";

   public static void m_2280(Framebuffer var0, int var1, int var2) {
      Util114.m_811();
      GlStateManager._colorMask(true, true, true, true);
      Util114.m_672();
      Util114.m_1878(false);
      GlStateManager._viewport(0, 0, var1, var2);
      Util98 var3 = Objects.requireNonNull(Util114.m_3784(RenderUtil7.f_13888), f_1131);
      var3.m_3726(f_1132, RenderUtil6.m_668(var0.getColorAttachment()));
      BufferBuilder var4 = Util114.m_2494().begin(DrawMode.QUADS, VertexFormats.POSITION);
      var4.vertex(0.0F, 0.0F, 0.0F);
      var4.vertex(1.0F, 0.0F, 0.0F);
      var4.vertex(1.0F, 1.0F, 0.0F);
      var4.vertex(0.0F, 1.0F, 0.0F);
      RenderUtil12.I(var4.end());
      Util114.m_1878(true);
      GlStateManager._colorMask(true, true, true, true);
   }
}
