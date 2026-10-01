package su.energyclient.util;

import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

final class Util130 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_10590 = 16.0;
   private static final double f_10591 = 1.0E-8;
   private static final double f_10592 = 16.0;
   private static final double f_10593 = 1.0E-8;
   private static final float f_10594 = -90.0F;
   private static final float f_10595 = 90.0F;
   private static final double f_10596 = 0.12;
   private static final float f_10597 = 5.0F;
   private static final float f_10598 = 5.0F;
   private static final double f_10599 = 16.0;
   private static final double f_10600 = 0.5;
   private static final double f_10601 = 1.5;
   private static final double f_10602 = 0.25;
   private static final double f_10603 = 2.0;
   private static final double f_10604 = 0.6;
   private static final float f_10605 = 0.7F;
   private static final float f_10606 = -90.0F;
   private static final float f_10607 = 90.0F;
   private static final double f_10608 = 0.5;
   private static final double f_10609 = 1.0E-7;
   private static final double f_10610 = 1.0E-7;
   private static final double f_10611 = 1.0E-7;
   private static final float f_10612 = (float) (Math.PI / 180.0);
   private static final float f_10613 = (float) (Math.PI / 180.0);
   private static final double f_10614 = 0.01;
   private static final double f_10615 = -1.0;
   private static final double f_10616 = 0.75;
   private static final double f_10617 = -0.1;
   private static final double f_10618 = 0.04;
   private static final double f_10619 = 3.2;
   private static final double f_10620 = 0.1;
   private static final double f_10621 = 0.1;
   private static final double f_10622 = 0.99F;
   private static final double f_10623 = 0.98F;
   private static final double f_10624 = 0.99F;

   static Vec3d m_224(Vec3d var0, float var1, float var2, double var3, boolean var5) {
      float var6 = var2 * f_10612;
      float var7 = -var1 * f_10613;
      float var8 = MathHelper.cos(var6);
      Vec3d var9 = new Vec3d(MathHelper.sin(var7) * var8, -MathHelper.sin(var6), MathHelper.cos(var7) * var8);
      double var10 = Math.sqrt(var9.x * var9.x + var9.z * var9.z);
      double var12 = var0.horizontalLength();
      double var14 = var5 && var0.y <= 0.0 ? Math.min(var3, f_10614) : var3;
      double var16 = MathHelper.square(Math.cos(var6));
      Vec3d var18 = var0.add(0.0, var14 * (f_10615 + var16 * f_10616), 0.0);
      if (var18.y < 0.0 && var10 > 0.0) {
         double var19 = var18.y * f_10617 * var16;
         var18 = var18.add(var9.x * var19 / var10, var19, var9.z * var19 / var10);
      }

      if (var6 < 0.0F && var10 > 0.0) {
         double var21 = var12 * -MathHelper.sin(var6) * f_10618;
         var18 = var18.add(-var9.x * var21 / var10, var21 * f_10619, -var9.z * var21 / var10);
      }

      if (var10 > 0.0) {
         var18 = var18.add((var9.x / var10 * var12 - var18.x) * f_10620, 0.0, (var9.z / var10 * var12 - var18.z) * f_10621);
      }

      return var18.multiply(f_10622, f_10623, f_10624);
   }

   static boolean m_1552(Vec3d var0) {
      return var0 != null && Double.isFinite(var0.x) && Double.isFinite(var0.y) && Double.isFinite(var0.z);
   }

   private Util130() {
   }

   static Vec3d m_1511(Box var0, Vec3d var1, Vec3d var2) {
      return var0.getCenter().add(var1).subtract(var2);
   }

   static Vec3d m_223(Util76.Inner_7PNRURzqcF1Y7Kub var0, float var1, boolean var2, Box var3, Util130.VDVsxAH71h31RQlm var4) {
      if (!var0.stopped() && Float.isFinite(var1) && !(var1 <= 0.0F)) {
         var1 = Math.min(var1, f_10598);
         Vec3d var5 = var2 ? var0.smoothVelocity() : var0.velocity();
         Vec3d var6 = Vec3d.ZERO;
         double var7 = Math.min(f_10599, Math.max(f_10600, var0.velocity().length() * f_10601 + f_10602));

         for (int var9 = 0; var9 < Math.ceil(var1); var9++) {
            double var10 = Math.min(1.0, (double)(var1 - var9));
            float var12 = (float)(f_10603 * (1.0 - Math.pow(f_10604, var9 + 1)));
            float var13 = var2 ? f_10605 : 1.0F;
            float var14 = var0.yaw() + var0.yawRate() * var12 * var13;
            float var15 = MathHelper.clamp(var0.pitch() + var0.pitchRate() * var12 * var13, f_10606, f_10607);
            Vec3d var19 = m_224(var5, var14, var15, var0.gravity(), var0.slowFalling());
            var5 = m_2694(var19.add(var0.residual().multiply(Math.pow(f_10608, var9))), var7);
            Vec3d var16 = var5.multiply(var10);
            Vec3d var17 = var4.m_673(var3, var16);
            if (!m_1552(var17)) {
               break;
            }

            var6 = var6.add(var17);
            var3 = var3.offset(var17);
            if (Math.abs(var16.x - var17.x) > f_10609 || Math.abs(var16.y - var17.y) > f_10610 || Math.abs(var16.z - var17.z) > f_10611) {
               break;
            }
         }

         return var6;
      } else {
         return Vec3d.ZERO;
      }
   }

   static Vec3d m_2694(Vec3d var0, double var1) {
      if (m_1552(var0) && Double.isFinite(var1) && !(var1 <= 0.0)) {
         double var3 = Math.max(Math.max(Math.abs(var0.x), Math.abs(var0.y)), Math.abs(var0.z));
         if (var3 == 0.0) {
            return var0;
         } else {
            double var5 = var0.x / var3;
            double var7 = var0.y / var3;
            double var9 = var0.z / var3;
            double var11 = Math.sqrt(var5 * var5 + var7 * var7 + var9 * var9);
            double var13 = var1 / var11;
            return var3 <= var13 ? var0 : new Vec3d(var5 * var13, var7 * var13, var9 * var13);
         }
      } else {
         return Vec3d.ZERO;
      }
   }

   static Vec3d m_2615(Vec3d var0, float var1, float var2, float var3, Box var4, Util130.VDVsxAH71h31RQlm var5) {
      if (m_1552(var0) && Float.isFinite(var3) && !(var3 <= 0.0F)) {
         Vec3d var6 = m_2694(var0, f_10592);
         if (var6.lengthSquared() <= f_10593) {
            return Vec3d.ZERO;
         } else {
            var6 = var6.normalize();
            Vec3d var7 = var6;
            if (Float.isFinite(var1) && Float.isFinite(var2)) {
               Vec3d var8 = Vec3d.fromPolar(MathHelper.clamp(var2, f_10594, f_10595), MathHelper.wrapDegrees(var1));
               var7 = var6.lerp(var8, f_10596).normalize();
            }

            Vec3d var11 = var7.multiply(Math.min(var3, f_10597));
            Vec3d var9 = var5.m_673(var4, var11);
            return m_1552(var9) ? var9 : Vec3d.ZERO;
         }
      } else {
         return Vec3d.ZERO;
      }
   }

   static Vec3d m_2443(Vec3d var0, Util76.Inner_7PNRURzqcF1Y7Kub var1) {
      Vec3d var2 = m_2694(var0, f_10590);
      return var2.lengthSquared() > f_10591 ? var2 : var1.velocity();
   }

   @FunctionalInterface
   interface VDVsxAH71h31RQlm {
      Vec3d m_673(Box var1, Vec3d var2);
   }
}
