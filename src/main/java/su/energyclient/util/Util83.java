package su.energyclient.util;

import su.energyclient.QuickImports;

public class Util83 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static float f_5245 = 0.0F;
   public static float f_5246 = 0.0F;
   private static final float f_5247 = 0.5F;

   public static void m_2664() {
      f_5245 = 0.0F;
      f_5246 = 0.0F;
   }

   public static void m_1864(float var0) {
      f_5245 = var0;
      f_5246 = var0;
   }

   public static boolean m_1857() {
      return f_5909.player.getAttackCooldownProgress(f_5247) >= 1.0F;
   }
}
