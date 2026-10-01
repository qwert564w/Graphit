package su.energyclient.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;

public class Util39 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_7752 = 1.0E8;
   private static final double f_7753 = 1.0E8;
   private static final double f_7754 = 180.0;
   private static final double f_7755 = Math.PI;
   private static final double f_7756 = 90.0;
   private static final double f_7757 = 180.0;
   private static final double f_7758 = Math.PI;
   private static final double f_7759 = 0.9;
   private static final double f_7760 = 90.0;
   private static final double f_7761 = 20.0;
   private static final double f_7762 = 20.0;
   private static final double f_7763 = Math.PI;
   private static final double f_7764 = 2.0;
   private static final double f_7765 = 2.0;
   private static final float f_7766 = 0.5F;
   private static final float f_7767 = 90.0F;
   private static final double f_7768 = 100.0;
   private static final double f_7769 = 100.0;
   private static final double f_7770 = 0.016F;

   public static Vec3d m_861(Vec3d var0, Vec3d var1, float var2) {
      return new Vec3d(
         m_561((float)var0.getX(), (float)var1.getX(), var2),
         m_561((float)var0.getY(), (float)var1.getY(), var2),
         m_561((float)var0.getZ(), (float)var1.getZ(), var2)
      );
   }

   public static Util10 m_2474(Vec3d var0) {
      var0 = var0.subtract(f_5909.player.getEyePos());
      return m_3442(var0);
   }

   public static double m_1150(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * MathHelper.clamp(m_2496() * var4, 0.0, 1.0);
   }

   public static Vec2f m_2428(Entity var0) {
      Vec3d var1 = var0.getEntityPos().subtract(f_5909.player.getEntityPos());
      double var2 = Math.hypot(var1.x, var1.z);
      return new Vec2f((float)Math.toDegrees(Math.atan2(var1.z, var1.x)) - f_7767, (float)(-Math.toDegrees(Math.atan2(var1.y, var2))));
   }

   public static float m_1129(float var0, float var1, float var2) {
      return var1 + (var0 - var1) * var2;
   }

   public static Vec2f m_390(Entity var0) {
      return m_974(
         var0.getEntityPos()
            .add(
               0.0,
               Math.max(
                  0.0,
                  Math.min(f_5909.player.getY() - var0.getY() + f_5909.player.getEyeY(), (var0.getBoundingBox().maxY - var0.getBoundingBox().minY) * f_7759)
               ),
               0.0
            )
      );
   }

   public static float m_2499(float var0, float var1) {
      return (float)(Math.random() * (var1 - var0) + var0);
   }

   public static double m_2496() {
      return f_5909.getCurrentFps() > 5 ? 1.0F / f_5909.getCurrentFps() : f_7770;
   }

   public static float m_3204(float var0, float var1, double var2) {
      return (float)(var0 + (var1 - var0) * var2);
   }

   public static float m_2529(float var0, float var1, float var2) {
      if (var0 <= var1) {
         return var1;
      } else {
         return var0 >= var2 ? var2 : var0;
      }
   }

   public static Vec2f m_3700(Vec3d var0, Vec3d var1) {
      Vec3d var2 = var1.subtract(var0);
      float var3 = MathHelper.sqrt((float)(var2.x * var2.x + var2.z * var2.z));
      float var4 = (float)(MathHelper.atan2(var2.z, var2.x) * f_7754 / f_7755 - f_7756);
      float var5 = (float)(-(MathHelper.atan2(var2.y, var3) * f_7757 / f_7758));
      return new Vec2f(var4, var5);
   }

   public static Util10 m_3442(Vec3d var0) {
      float var1 = (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var0.z, var0.x)) - f_7760);
      float var2 = (float)(-Math.toDegrees(Math.atan2(var0.y, Math.hypot(var0.x, var0.z))));
      return new Util10(var1, var2);
   }

   public static float m_2261(float var0, float var1) {
      float var2 = Math.round(var0 / var1) * var1;
      BigDecimal var3 = new BigDecimal((double)var2);
      var3 = var3.setScale(2, RoundingMode.HALF_UP);
      return var3.floatValue();
   }

   public static double m_1196(double var0, double var2) {
      double var4 = Math.round(var0 / var2) * var2;
      BigDecimal var6 = new BigDecimal(var4);
      var6 = var6.setScale(2, RoundingMode.HALF_UP);
      return var6.doubleValue();
   }

   public static float m_2038(float var0, float var1) {
      return m_2499(var0, var1);
   }

   public static double m_2395(Entity var0) {
      double var1 = var0.getX() - var0.lastX;
      double var3 = var0.getY() - var0.lastY;
      double var5 = var0.getZ() - var0.lastZ;
      double var7 = Math.sqrt(var1 * var1 + var3 * var3 + var5 * var5);
      return var7 * f_7761;
   }

   public static double m_1508(double var0, double var2) {
      double var4 = Math.round(var0 / var2) * var2;
      return Math.round(var4 * f_7768) / f_7769;
   }

   public static double m_949(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   public static boolean m_121(double var0, double var2, float var4, float var5, float var6, float var7) {
      return var0 > var4 && var0 < var4 + var6 && var2 > var5 && var2 < var5 + var7;
   }

   public static float m_3472(float var0, float var1) {
      double var2 = f_7763;
      double var4 = 1.0 / Math.sqrt(f_7764 * var2 * (var1 * var1));
      return (float)(var4 * Math.exp(-(var0 * var0) / (f_7765 * (var1 * var1))));
   }

   public static float m_3959(float var0, float var1, float var2) {
      return (float)(var0 + (var1 - var0) * MathHelper.clamp(m_2496() * var2, 0.0, 1.0));
   }

   public static Vec2f m_974(Vec3d var0) {
      return m_3700(f_5909.player.getEntityPos().add(0.0, f_5909.player.getEyeY(), 0.0), var0);
   }

   public static boolean m_2594(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 > var2 && var0 < var2 + var4 && var1 > var3 && var1 < var3 + var5;
   }

   public static float m_789(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   public static float m_1804(float var0, float var1, float var2) {
      float var3 = MathHelper.clamp(var2, 0.0F, 1.0F);
      float var4 = MathHelper.wrapDegrees(var1 - var0);
      return Math.abs(var4) < f_7766 ? var1 : MathHelper.wrapDegrees(var0 + var4 * var3);
   }

   public static float m_561(float var0, float var1, float var2) {
      return (1.0F - MathHelper.clamp((float)(m_2496() * var2), 0.0F, 1.0F)) * var0 + MathHelper.clamp((float)(m_2496() * var2), 0.0F, 1.0F) * var1;
   }

   public static double m_2061(double var0, double var2) {
      double var4 = Math.round(var0 / var2) * var2;
      BigDecimal var6 = new BigDecimal(var4);
      var6 = var6.setScale(2, RoundingMode.HALF_UP);
      return var6.doubleValue();
   }

   public static int m_930(int var0, int var1, double var2) {
      return (int)(var0 + (var1 - var0) * var2);
   }

   public static float m_1964(double var0) {
      return (float)(Math.round(var0 * f_7752) / f_7753);
   }

   public static double m_1252(Entity var0, int var1) {
      double var2 = var0.getX() - var0.lastX;
      double var4 = var0.getY() - var0.lastY;
      double var6 = var0.getZ() - var0.lastZ;
      double var8 = Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6) * f_7762;
      return m_1196(var8, var1);
   }
}
