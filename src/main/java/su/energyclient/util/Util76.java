package su.energyclient.util;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

final class Util76 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_9341 = 16.0;
   private int f_9342;
   private Vec3d f_9343;
   private Vec3d f_9344;
   private int f_9345;
   private Util76.Inner_7PNRURzqcF1Y7Kub f_9346;
   private static final int f_9347 = Integer.MIN_VALUE;
   private static final double f_9348 = 16.0;
   private static final float f_9349 = -90.0F;
   private static final float f_9350 = 90.0F;
   private static final double f_9351 = 0.08;
   private static final double f_9352 = 4.0;
   private static final double f_9353 = 4.0;
   private static final double f_9354 = 3.0;
   private static final double f_9355 = 1.0E-6;
   private static final double f_9356 = 1.0E-6;
   private static final double f_9357 = 1.0E-6;
   private static final double f_9358 = 16.0;
   private static final double f_9359 = 0.1;
   private static final double f_9360 = 0.25;
   private static final double f_9361 = 0.65;
   private static final double f_9362 = 0.75;
   private static final double f_9363 = 16.0;
   private static final double f_9364 = 1.0E-6;
   private static final double f_9365 = 0.35;
   private static final double f_9366 = 0.5;
   private static final double f_9367 = 0.65;
   private static final float f_9368 = 20.0F;
   private static final float f_9369 = 12.0F;
   private static final double f_9370 = 0.8;
   private static final double f_9371 = 0.12;
   private static final double f_9372 = 0.3;
   private static final float f_9373 = 60.0F;
   private static final float f_9374 = 40.0F;
   private static final double f_9375 = 16.0;
   private static final float f_9376 = 3.0F;
   private static final float f_9377 = 0.35F;
   private static final float f_9378 = 0.5F;
   private static final float f_9379 = 0.5F;

   private static float m_172(float var0, float var1, float var2) {
      if (Math.abs(var1) > var2 * f_9376) {
         return 0.0F;
      } else {
         float var3 = MathHelper.clamp(var1, -var2, var2);
         return var0 * var3 < 0.0F ? var3 * f_9377 : var0 * f_9378 + var3 * f_9379;
      }
   }

   Util76() {
      this.f_9342 = f_9347;
      this.f_9344 = Vec3d.ZERO;
   }

   Util76.Inner_7PNRURzqcF1Y7Kub m_199(int var1, Vec3d var2, Vec3d var3, float var4, float var5, double var6, boolean var8) {
      Vec3d var9 = Util130.m_2694(var3, f_9348);
      var4 = Float.isFinite(var4) ? MathHelper.wrapDegrees(var4) : 0.0F;
      var5 = Float.isFinite(var5) ? MathHelper.clamp(var5, f_9349, f_9350) : 0.0F;
      var6 = Double.isFinite(var6) ? MathHelper.clamp(var6, 0.0, 1.0) : f_9351;
      double var10 = this.f_9346 == null ? f_9352 : Math.max(f_9353, Math.max(this.f_9346.velocity.length(), var9.length()) * f_9354 + 1.0);
      boolean var12 = this.f_9346 != null && (!Util130.m_1552(var2) || !Util130.m_1552(this.f_9343) || var2.squaredDistanceTo(this.f_9343) > var10 * var10);
      if (this.f_9346 != null && var1 == this.f_9342 && !var12) {
         return this.f_9346;
      } else {
         int var13 = var1 - this.f_9342;
         boolean var14 = this.f_9346 != null && var13 == 1 && !var12;
         Vec3d var15 = var14 ? var2.subtract(this.f_9343) : Vec3d.ZERO;
         if (var14) {
            boolean var16 = var15.lengthSquared() < f_9355;
            boolean var17 = var9.squaredDistanceTo(this.f_9344) < f_9356;
            this.f_9345 = var16 && var17 ? this.f_9345 + 1 : 0;
            if (this.f_9345 >= 3) {
               var9 = Vec3d.ZERO;
            } else if (!var16) {
               if (var9.lengthSquared() < f_9357) {
                  var9 = Util130.m_2694(var15, f_9358);
               } else {
                  double var18 = var9.distanceTo(var15) / Math.max(f_9359, Math.max(var9.length(), var15.length()));
                  double var20 = MathHelper.clamp((var18 - f_9360) * f_9361, 0.0, f_9362);
                  var9 = var9.lerp(Util130.m_2694(var15, f_9363), var20);
               }
            }

            double var31 = var9.distanceTo(this.f_9346.velocity);
            boolean var32 = var9.lengthSquared() < f_9364
               || this.f_9346.velocity.dotProduct(var9) < 0.0
               || var31 > Math.max(f_9365, this.f_9346.velocity.length() * f_9366);
            Vec3d var21 = var32 ? var9 : this.f_9346.smoothVelocity.lerp(var9, f_9367);
            float var22 = MathHelper.wrapDegrees(var4 - this.f_9346.yaw);
            float var23 = var5 - this.f_9346.pitch;
            float var24 = m_172(this.f_9346.yawRate, var22, f_9368);
            float var25 = m_172(this.f_9346.pitchRate, var23, f_9369);
            Vec3d var26 = Util130.m_224(this.f_9346.velocity, var4, var5, var6, var8);
            Vec3d var27 = Util130.m_2694(var9.subtract(var26), Math.min(f_9370, f_9371 + var9.length() * f_9372));
            if (var32 || Math.abs(var22) > f_9373 || Math.abs(var23) > f_9374) {
               var27 = Vec3d.ZERO;
               var24 = 0.0F;
               var25 = 0.0F;
            }

            this.f_9346 = new Util76.Inner_7PNRURzqcF1Y7Kub(var9, var21, var27, var4, var5, var24, var25, var6, var8, this.f_9345 >= 3);
         } else {
            this.f_9345 = 0;
            this.f_9346 = new Util76.Inner_7PNRURzqcF1Y7Kub(var9, var9, Vec3d.ZERO, var4, var5, 0.0F, 0.0F, var6, var8, false);
         }

         this.f_9342 = var1;
         this.f_9343 = var2;
         this.f_9344 = Util130.m_2694(var3, f_9375);
         return this.f_9346;
      }
   }

   record Inner_7PNRURzqcF1Y7Kub(
      Vec3d velocity,
      Vec3d smoothVelocity,
      Vec3d residual,
      float yaw,
      float pitch,
      float yawRate,
      float pitchRate,
      double gravity,
      boolean slowFalling,
      boolean stopped
   ) {
   }
}
