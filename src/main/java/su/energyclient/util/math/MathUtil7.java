package su.energyclient.util.math;

import net.minecraft.util.math.Vec3d;

public final class MathUtil7 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_6019 = 8.0;
   private static final double f_6020 = 0.91;
   private static final double f_6021 = 0.08;
   private static final double f_6022 = 0.98;
   private static final double f_6023 = 0.91;
   private static final double f_6024 = 60.0;
   private static final double f_6025 = 10.0;
   private static final double f_6026 = 3.0;
   private static final double f_6027 = 8.0;
   private static final double f_6028 = -0.05;
   private static final double f_6029 = 5.0;
   private static final double f_6030 = 4.0;
   private static final double f_6031 = 2.0;
   private static final double f_6032 = 28.0;
   private static final double f_6033 = 0.8;
   private static final double f_6034 = 0.5;
   private static final double f_6035 = 0.4;
   private static final double f_6036 = 1.5;

   public static double m_145(Vec3d var0, Vec3d var1) {
      return Math.hypot(var0.x - var1.x, var0.z - var1.z);
   }

   public static boolean m_968(boolean var0, boolean var1, double var2, double var4, double var6) {
      return !var0 && !var1 && Double.isFinite(var2) && var2 < 0.0 && Double.isFinite(var4) && Double.isFinite(var6) && var4 > Math.max(f_6036, var6);
   }

   private static boolean m_4141(Vec3d var0) {
      return Double.isFinite(var0.x) && Double.isFinite(var0.y) && Double.isFinite(var0.z);
   }

   private MathUtil7() {
   }

   public static Vec3d m_3466(Vec3d var0, Vec3d var1, double var2) {
      double var4 = Double.isFinite(var2) ? Math.clamp(var2, 0.0, f_6025) : 0.0;
      return var0.add(m_3377(m_3377(var1, f_6026).multiply(var4), f_6027));
   }

   public static boolean m_735(Vec3d var0, Vec3d var1, Vec3d var2, Vec3d var3, double var4) {
      if (m_4141(var0) && m_4141(var1) && m_4141(var2) && m_4141(var3) && Double.isFinite(var4) && !(var4 <= 0.0)) {
         double var6 = var0.y - var2.y;
         if (!(var1.y >= f_6028) && !(var6 < Math.max(f_6029, -var1.y * f_6030 + f_6031)) && !(var6 > f_6032)) {
            MathUtil7.dnTdBko3wycmdlOV var8 = m_2338(var6, var1);
            Vec3d var9 = var0.add(var8.displacement());
            Vec3d var10 = m_3466(var2, var3, var8.ticks());
            return m_145(var9, var10) <= Math.max(f_6033, var4 * f_6034 + f_6035);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static MathUtil7.dnTdBko3wycmdlOV m_2338(double var0, Vec3d var2) {
      if (Double.isFinite(var0) && !(var0 <= 0.0)) {
         Vec3d var3 = m_3377(var2, f_6019);
         Vec3d var4 = Vec3d.ZERO;

         for (int var5 = 0; var5 < 60; var5++) {
            Vec3d var6 = var4.add(var3);
            if (var6.y <= -var0) {
               double var7 = (-var0 - var4.y) / var3.y;
               return new MathUtil7.dnTdBko3wycmdlOV(var5 + var7, var4.add(var3.multiply(var7)));
            }

            var4 = var6;
            var3 = new Vec3d(var3.x * f_6020, (var3.y - f_6021) * f_6022, var3.z * f_6023);
         }

         return new MathUtil7.dnTdBko3wycmdlOV(f_6024, var4);
      } else {
         return new MathUtil7.dnTdBko3wycmdlOV(0.0, Vec3d.ZERO);
      }
   }

   public static Vec3d m_3377(Vec3d var0, double var1) {
      if (Double.isFinite(var0.x) && Double.isFinite(var0.y) && Double.isFinite(var0.z)) {
         double var3 = var0.length();
         return var3 > var1 ? var0.multiply(var1 / var3) : var0;
      } else {
         return Vec3d.ZERO;
      }
   }

   public record dnTdBko3wycmdlOV(double ticks, Vec3d displacement) {
   }
}
