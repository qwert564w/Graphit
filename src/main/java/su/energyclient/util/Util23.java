package su.energyclient.util;

import net.minecraft.client.gui.DrawContext;

public class Util23 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private String f_3423;
   private boolean f_3424 = true;
   private boolean f_3425 = false;
   private final Runnable f_3426;
   private final Util165 f_3427;
   private static final long f_3428 = 120L;
   private static final int f_3429 = 2775612;
   private static final int f_3430 = 2764339;
   private static final int f_3431 = 2112811;
   private static final int f_3432 = 1777186;
   private static final int f_3433 = 1252631;
   private static final int f_3434 = 1119255;
   private static final float f_3435 = 4.0F;
   private static final float f_3436 = 255.0F;
   private static final float f_3437 = 0.7F;
   private static final float f_3438 = 0.7F;
   private static final float f_3439 = 1.4F;
   private static final float f_3440 = 1.4F;
   private static final float f_3441 = 3.5F;
   private static final float f_3442 = 0.78F;
   private static final float f_3443 = 0.12F;
   private static final int f_3444 = 16777215;

   public boolean m_3633(double var1, double var3, float var5, float var6, float var7, float var8) {
      if (!this.f_3424) {
         return false;
      } else if (Util39.m_2594((float)var1, (float)var3, var5, var6, var7, var8)) {
         this.f_3426.run();
         return true;
      } else {
         return false;
      }
   }

   public void m_443(String var1) {
      this.f_3423 = var1;
   }

   public Util23(String var1, Runnable var2) {
      this.f_3427 = new Util165(Util153.EASE_IN_OUT_CUBIC, f_3428);
      this.f_3423 = var1;
      this.f_3426 = var2;
   }

   public void m_489(boolean var1) {
      this.f_3425 = var1;
   }

   public void m_3598(boolean var1) {
      this.f_3424 = var1;
   }

   public void m_3005(DrawContext var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8) {
      boolean var9 = this.f_3424 && Util39.m_2594(var7, var8, var2, var3, var4, var5);
      this.f_3427.m_3631(var9 ? 1.0 : 0.0);
      float var10 = (float)this.f_3427.m_2276();
      int var11 = this.f_3425 ? f_3429 : f_3430;
      int var12 = this.f_3425 ? f_3431 : f_3432;
      int var13 = this.f_3425 ? f_3433 : f_3434;
      Util158.m_3404(var2, var3, var4, var5, f_3435, var11, var12, var11, var12, var6 / f_3436);
      Util158.m_1849(
         var2 + f_3437, var3 + f_3438, var4 - f_3439, var5 - f_3440, f_3441, Util71.m_3389(var13, Math.min(255, (int)(var6 * (f_3442 + var10 * f_3443))))
      );
      float var14 = Util93.f_6001[13].m_585(this.f_3423);
      float var15 = Util93.f_6001[13].m_619();
      Util93.f_6001[13].m_2915(var1, this.f_3423, var2 + (var4 - var14) / 2.0F, var3 + (var5 - var15) / 2.0F + 1.0F, Util71.m_3389(f_3444, var6));
   }
}
