package su.energyclient.render;

import net.minecraft.client.gl.SimpleFramebuffer;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;

public class RenderUtil20 extends RenderUtil11 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static long f_1178 = 0L;
   private static final String f_1179 = "effects";
   private static final String f_1180 = "tint";
   private static final String f_1181 = "Tex0";
   private static final String f_1182 = "RGBPuke";
   private static final String f_1183 = "SV";
   private static final String f_1184 = "Opacity";
   private static final String f_1185 = "Time";
   private static final float f_1186 = 1.0E9F;
   private static final String f_1187 = "Yaw";
   private static final String f_1188 = "Pitch";

   public RenderUtil20() {
      super(f_1179, f_1180);
      f_1178 = System.nanoTime();
   }

   public static void m_95(RenderUtil20 var0, SimpleFramebuffer var1, SimpleFramebuffer var2, float var3, float var4, float var5) {
      RenderUtil6.m_4071(var1, true);
      var0.m_2989();
      var0.m_3372(f_1181, 0);
      var0.m_3397(f_1182, true);
      var0.m_366(f_1183, var4, var5);
      var0.m_2024(f_1184, var3);
      var0.m_2024(f_1185, (float)(System.nanoTime() - f_1178) / f_1186);
      if (f_5909.player != null) {
         var0.m_2024(f_1187, f_5909.player.getYaw());
         var0.m_2024(f_1188, f_5909.player.getPitch());
      }

      Util114.m_2012(RenderUtil6.m_668(var2.getColorAttachment()));
      RenderUtil23.m_1477();
      var0.m_233();
   }
}
