package su.energyclient.render;

import com.mojang.blaze3d.opengl.GlStateManager;
import net.minecraft.client.gl.SimpleFramebuffer;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;

public class RenderUtil1 extends RenderUtil11 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_13084 = "effects";
   private static final String f_13085 = "depth";
   private static final String f_13086 = "Tex0";
   private static final String f_13087 = "Tex1";
   private static final String f_13088 = "Near";
   private static final float f_13089 = 0.05F;
   private static final String f_13090 = "Far";
   private static final String f_13091 = "MinThreshold";
   private static final float f_13092 = 0.1F;
   private static final float f_13093 = 100.0F;
   private static final String f_13094 = "MaxThreshold";
   private static final float f_13095 = 0.28F;
   private static final float f_13096 = 100.0F;
   private static final int f_13097 = 33984;
   private static final int f_13098 = 33985;
   private static final int f_13099 = 33984;

   public static void m_1706(RenderUtil1 var0, SimpleFramebuffer var1, SimpleFramebuffer var2, SimpleFramebuffer var3, float var4) {
      RenderUtil6.m_4071(var1, true);
      var0.m_2989();
      var0.m_3372(f_13086, 0);
      var0.m_3372(f_13087, 1);
      var0.m_2024(f_13088, f_13089);
      var0.m_2024(f_13090, f_5909.gameRenderer.getFarPlaneDistance());
      var0.m_2024(f_13091, f_13092 * var4 / f_13093);
      var0.m_2024(f_13094, f_13095 * var4 / f_13096);
      Util114.m_2836(f_13097);
      Util114.m_2012(RenderUtil6.m_668(var2.getColorAttachment()));
      Util114.m_2836(f_13098);
      Util114.m_2012(RenderUtil6.m_668(var3.getDepthAttachment()));
      GlStateManager._texParameter(3553, 10241, 9728);
      GlStateManager._texParameter(3553, 10240, 9728);
      RenderUtil23.m_1477();
      var0.m_233();
      Util114.m_2836(f_13099);
   }

   public RenderUtil1() {
      super(f_13084, f_13085);
   }
}
