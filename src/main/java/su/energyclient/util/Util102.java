package su.energyclient.util;

import net.minecraft.client.gui.DrawContext;
import su.energyclient.EnergyClient;
import su.energyclient.module.render.Interface;
import su.energyclient.render.RenderUtil25;

public class Util102 extends Util156 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_14326 = 22.0F;
   private static final float f_14327 = 0.0F;
   private static final float f_14328 = 0.0F;
   private static final float f_14329 = 0.0F;
   private static final float f_14330 = 0.0F;
   private static final float f_14331 = 0.0F;
   private static final float f_14332 = 0.0F;
   private final Util165 f_14333;
   private boolean f_14334;
   private static final long f_14335 = 200L;
   private static final String f_14336 = "b";
   private static final String f_14337 = "d";
   private static final String f_14338 = "TPS";
   private static final String f_14339 = "a";
   private static final String f_14340 = "BPS";
   private static final float f_14341 = 12.0F;
   private static final float f_14342 = 22.0F;
   private static final float f_14343 = 14.0F;
   private static final int f_14344 = 1315865;
   private static final float f_14345 = 6.0F;
   private static final String f_14346 = "b";
   private static final String f_14347 = "d";
   private static final String f_14348 = "TPS";
   private static final String f_14349 = "a";
   private static final String f_14350 = "BPS";
   private static final float f_14351 = 22.0F;
   private static final float f_14352 = 4.0F;
   private static final float f_14353 = 12.5F;
   private static final float f_14354 = 8.5F;
   private static final float f_14355 = 4.0F;
   private static final float f_14356 = 10.0F;
   private static final float f_14357 = 10.0F;
   private static final int f_14358 = -4869442;
   private static final float f_14359 = 6.0F;
   private static final float f_14360 = 6.0F;
   private static final float f_14361 = 0.5F;
   private static final float f_14362 = 10.0F;
   private static final float f_14363 = 0.5F;
   private static final float f_14364 = 6.0F;

   public Util102(Util112 var1) {
      super(var1);
      this.f_14333 = new Util165(Util153.EASE_OUT_CUBIC, f_14335);
   }

   private float m_435(DrawContext var1, float var2, float var3) {
      var2 += f_14359;
      if (Interface.m_886(255) > 0) {
         int var4 = Util71.m_756(122, 122, 122, Interface.m_886(100));
         RenderUtil25.m_3752(var1, var2, var3 + f_14360, f_14361, f_14362, var4, var4, var4, var4);
      }

      return var2 + f_14363 + f_14364;
   }

   private float m_893(float var1) {
      if (this.f_14334 && !(var1 > this.f_14333.m_2276())) {
         this.f_14333.m_3631(var1);
         return Math.max(var1, (float)this.f_14333.m_2276());
      } else {
         this.m_2729(var1);
         this.f_14334 = true;
         return var1;
      }
   }

   private float O(String var1, String var2, String var3) {
      float var4 = Util93.l[21].m_585(var1) + f_14352 + Util93.f_6001[15].m_585(var2);
      if (!var3.isEmpty()) {
         var4 += 2.0F + Util93.f_6001[13].m_585(var3);
      }

      return var4;
   }

   @Override
   public void m_4(Util169 var1) {
      if (f_5909.player == null) {
         this.f_14334 = false;
         this.f_10920.m_1597(0.0F);
         this.f_10920.m_1076(0.0F);
      } else {
         DrawContext var2 = var1.m_4037();
         float var3 = this.f_10920.m_2838();
         float var4 = this.f_10920.m_671();
         String var5 = "x" + f_5909.player.getBlockX() + " y" + f_5909.player.getBlockY() + " z" + f_5909.player.getBlockZ();
         String var6 = Float.toString(Util60.m_2077());
         String var7 = Util101.m_3762();
         float var8 = this.O(f_14336, var5, "");
         float var9 = this.O(f_14337, var6, f_14338);
         float var10 = this.O(f_14339, var7, f_14340);
         float var11 = f_14341 + var8 + var9 + var10 + this.m_155() * 2.0F;
         float var12 = this.m_893(var11);
         if (Interface.m_886(255) > 0) {
            Util158.m_3998(var3, var4, var12, f_14342, f_14343, Util71.m_3389(f_14344, Interface.m_886(150)), 1.0F);
         }

         float var13 = var3 + f_14345;
         var13 = this.O(var2, var13, var4, f_14346, var5, "");
         var13 = this.m_435(var2, var13, var4);
         var13 = this.O(var2, var13, var4, f_14347, var6, f_14348);
         var13 = this.m_435(var2, var13, var4);
         this.O(var2, var13, var4, f_14349, var7, f_14350);
         this.f_10920.m_1597(var12);
         this.f_10920.m_1076(f_14351);
      }
   }

   private void m_2729(float var1) {
      long var2 = System.currentTimeMillis();
      this.f_14333.m_2214(var1);
      this.f_14333.m_2946(var1);
      this.f_14333.m_1829(var1);
      this.f_14333.m_1876(var2);
      this.f_14333.m_1066(var2);
      this.f_14333.l(true);
   }

   private float m_155() {
      return f_14353;
   }

   private float O(DrawContext var1, float var2, float var3, String var4, String var5, String var6) {
      Util93.l[21].m_2915(var1, var4, var2, var3 + f_14354, EnergyClient.getTheme(0));
      var2 += Util93.l[21].m_585(var4) + f_14355;
      Util93.f_6001[15].m_2915(var1, var5, var2, var3 + f_14356, -1);
      var2 += Util93.f_6001[15].m_585(var5);
      if (!var6.isEmpty()) {
         var2 += 2.0F;
         Util93.f_6001[13].m_2915(var1, var6, var2, var3 + f_14357, f_14358);
         var2 += Util93.f_6001[13].m_585(var6);
      }

      return var2;
   }
}
