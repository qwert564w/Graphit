package su.energyclient.util;

import java.util.Objects;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;

public final class Util36 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_7704 = 0.15;
   private static final double f_7705 = 0.6F;
   private static final double f_7706 = 0.2F;
   private static final double f_7707 = 3.0;
   private static final double f_7708 = 8.0;
   private static final double f_7709 = 180.0 / Math.PI;
   private static final double f_7710 = 90.0;
   private static final double f_7711 = 180.0 / Math.PI;
   private static final String f_7712 = "This is a utility class and cannot be instantiated";

   public static Vec3d m_1701(Vec3d var0, Entity var1) {
      return m_3001(var0, var1.getBoundingBox());
   }

   private Util36() {
      throw new UnsupportedOperationException(f_7712);
   }

   public static float m_3974(float var0) {
      return Math.round(var0 / m_399());
   }

   public static boolean m_1308(Vec3d var0, double var1, Box var3) {
      Vec3d var4 = Objects.requireNonNull(f_5909.player).getEyePos();
      return var3.contains(var4) || var3.raycast(var4, var4.add(var0.multiply(var1))).isPresent();
   }

   public static Vec3d m_3448(Entity var0) {
      Vec3d var1 = f_5909.player.getCameraPosVec(f_5909.getRenderTickCounter().getTickProgress(true));
      return m_1701(var1, var0).subtract(var1);
   }

   public static Vec3d m_3001(Vec3d var0, Box var1) {
      return new Vec3d(
         Math.clamp(var0.getX(), var1.minX, var1.maxX), Math.clamp(var0.getY(), var1.minY, var1.maxY), Math.clamp(var0.getZ(), var1.minZ, var1.maxZ)
      );
   }

   public static float m_852(float var0) {
      return Math.round(var0 / m_399()) * m_399();
   }

   public static Vec2f m_1381(double var0, double var2, double var4) {
      double var6 = var0 - f_5909.player.getX();
      double var8 = var2 - f_5909.player.getEyeY();
      double var10 = var4 - f_5909.player.getZ();
      double var12 = MathHelper.sqrt((float)(var6 * var6 + var10 * var10));
      float var14 = (float)(MathHelper.atan2(var10, var6) * f_7709 - f_7710);
      float var15 = (float)(-MathHelper.atan2(var8, var12) * f_7711);
      return new Vec2f(var14, var15);
   }

   public static float m_1598(float var0) {
      float var1 = m_399();
      return var1 <= 0.0F ? var0 : var0 - var0 % var1;
   }

   public static float m_2538() {
      double var0 = (Double)f_5909.options.getMouseSensitivity().getValue();
      return (float)(Math.pow(var0 * f_7705 + f_7706, f_7707) * f_7708);
   }

   public static float m_569(float var0) {
      return m_3974(var0) * m_399();
   }

   public static boolean m_4095(Util10 var0, double var1, Box var3) {
      Vec3d var4 = Objects.requireNonNull(f_5909.player).getEyePos();
      return var3.contains(var4) || var3.raycast(var4, var4.add(var0.O().multiply(var1))).isPresent();
   }

   public static Vec2f m_1202(Vec3d var0) {
      return m_1381(var0.x, var0.y, var0.z);
   }

   public static float m_399() {
      double var0 = f_7704;
      return (float)(m_2538() * var0);
   }
}
