package su.energyclient.util.math;

public final class MathUtil1 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private double f_5869;
   private boolean f_5870;
   private int f_5871;
   private long f_5872;
   private int f_5873;
   private int f_5874;
   private static final long f_5875 = 400L;
   private static final int f_5876 = Integer.MAX_VALUE;
   private static final double f_5877 = 0.43152384527073195;
   private static final double f_5878 = 0.0548933470320776;
   private static final double f_5879 = -0.15233518685055708;
   private static final float f_5880 = 0.9F;
   private static final float f_5881 = 500.0F;
   private static final double f_5882 = 20.0;
   private static final double f_5883 = 20.0;
   private static final double f_5884 = 40.0;

   public boolean m_1764() {
      return this.f_5873 > 0;
   }

   public void O(long var1) {
      long var3 = var1 - this.f_5872;
      this.f_5872 = var1;
      if (!this.f_5870) {
         this.f_5871 = 0;
      } else if (var3 > f_5875 && this.f_5871 < f_5876) {
         this.f_5871++;
      }
   }

   public void m_1512(double var1) {
      double var3 = Math.abs((int)var1 - var1);
      if (var3 == f_5877) {
         this.f_5873 = 2;
      } else if (var3 == f_5878) {
         this.f_5873 = 3;
      }
   }

   public void m_1215() {
      this.f_5874 = 1;
   }

   public boolean m_1928() {
      return this.f_5871 >= 19 && this.f_5870;
   }

   public void m_2111(double var1, boolean var3) {
      double var4 = this.f_5869;
      this.f_5869 = var1 >= 0.0 ? 0.0 : this.f_5869 - var1;
      if (var3) {
         this.f_5870 = var4 == 0.0 && this.f_5869 != 0.0;
      }
   }

   public static float m_3099(double var0, float var2, double var3) {
      double var5 = Double.isFinite(var3) ? Math.max(1.0, Math.min(f_5882, var3)) : f_5883;
      return (float)(Math.max(1.0F, var2) / var0 * (f_5884 - var5));
   }

   public boolean m_2562() {
      return this.f_5874 > 0;
   }

   public static boolean m_3417(float var0, long var1, int var3) {
      return var0 > f_5880 && (float)var1 >= f_5881 - var3;
   }

   public void m_740(int var1, double var2) {
      if (var1 >= 0 && var1 < 3) {
         int var4 = var1 + 1;
         this.f_5873 = var4 * 2 - var4 / 2;
         if (var2 < f_5879) {
            this.f_5873++;
         }
      }
   }

   public void m_3713() {
      this.f_5869 = 0.0;
      this.f_5870 = false;
      this.f_5871 = 0;
      this.f_5872 = 0L;
      this.f_5873 = 0;
      this.f_5874 = 0;
   }

   public void m_1802(boolean var1) {
      if (this.f_5873 > 0 && var1) {
         this.f_5873--;
      }

      if (this.f_5874 > 0) {
         this.f_5874--;
      }
   }
}
