package su.energyclient.util.math;

public final class MathUtil3 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static volatile boolean f_6063 = false;
   public static volatile float f_6064 = MathUtil3.f_6067;
   private static long f_6065 = 0L;
   private static final double f_6066 = 1.0E9;
   private static final float f_6067 = 10.0F;

   public static boolean m_3596() {
      if (!f_6063) {
         f_6065 = 0L;
         return true;
      } else {
         long var0 = System.nanoTime();
         long var2 = (long)(f_6066 / Math.max(1.0F, f_6064));
         if (f_6065 != 0L && var0 - f_6065 < var2) {
            return false;
         } else {
            f_6065 = var0;
            return true;
         }
      }
   }

   private MathUtil3() {
   }
}
