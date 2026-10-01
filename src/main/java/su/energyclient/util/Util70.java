package su.energyclient.util;

import net.minecraft.client.gl.SimpleFramebuffer;
import org.joml.Vector3f;
import su.energyclient.render.RenderUtil11;
import su.energyclient.render.RenderUtil23;
import su.energyclient.render.RenderUtil6;

public class Util70 extends RenderUtil11 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_9319 = "blurs";
   private static final String f_9320 = "gaussian";
   private static final float f_9321 = 0.01F;
   private static final float f_9322 = 3.0F;
   private static final String f_9323 = "Tex0";
   private static final String f_9324 = "Alpha";
   private static final String f_9325 = "Gaussian";
   private static final String f_9326 = "Support";
   private static final String f_9327 = "LinearSampling";
   private static final String f_9328 = "Direction";
   private static final String f_9329 = "TexelSize";
   private static final String f_9330 = "Direction";
   private static final String f_9331 = "TexelSize";
   private static final float f_9332 = 2.50662F;
   private static final float f_9333 = -0.5F;
   private static final float f_9334 = 2.50662F;

   public Util70() {
      super(f_9319, f_9320);
   }

   public static void m_3412(
      Util70 var0, SimpleFramebuffer var1, SimpleFramebuffer var2, SimpleFramebuffer var3, SimpleFramebuffer var4, float var5, boolean var6, boolean var7
   ) {
      float var8 = Math.max(var5, f_9321);
      Vector3f var9 = m_2013(var8);
      int var10 = Math.max(1, (int)Math.ceil(var8 * f_9322));
      var0.m_2989();
      var0.m_3372(f_9323, 0);
      var0.m_3397(f_9324, false);
      var0.m_1054(f_9325, var9);
      var0.m_3372(f_9326, var10);
      var0.m_3397(f_9327, var6);
      RenderUtil6.m_4071(var1, true);
      var0.m_366(f_9328, 1.0F, 0.0F);
      var0.m_366(f_9329, 1.0F / var1.textureWidth, 1.0F / var1.textureHeight);
      int var11 = var7 ? RenderUtil6.m_668(var3.getColorAttachment()) : RenderUtil6.m_668(var4.getColorAttachment());
      Util114.m_2012(var11);
      RenderUtil23.m_1477();
      RenderUtil6.m_4071(var2, true);
      var0.m_366(f_9330, 0.0F, 1.0F);
      var0.m_366(f_9331, 1.0F / var2.textureWidth, 1.0F / var2.textureHeight);
      Util114.m_2012(RenderUtil6.m_668(var1.getColorAttachment()));
      RenderUtil23.m_1477();
      var0.m_233();
   }

   public static Vector3f m_2013(float var0) {
      float var1 = f_9332;
      float var2 = (float)Math.exp(f_9333 / (var0 * var0));
      return new Vector3f(1.0F / (f_9334 * var0), var2, var2 * var2);
   }
}
