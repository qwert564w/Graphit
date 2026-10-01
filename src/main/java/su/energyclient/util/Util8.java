package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class Util8 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_5125 = (float) (Math.PI / 180.0);
   private static final double f_5126 = 0.01;
   private static final double f_5127 = -1.0;
   private static final double f_5128 = 0.75;
   private static final double f_5129 = -0.1;
   private static final double f_5130 = 0.04;
   private static final double f_5131 = 3.2;
   private static final double f_5132 = 0.1;
   private static final double f_5133 = 0.1;
   private static final double f_5134 = 0.99;
   private static final double f_5135 = 0.98;
   private static final double f_5136 = 0.99;
   private static final float f_5137 = 360.0F;
   private static final float f_5138 = 360.0F;
   private static final float f_5139 = 2.16F;
   private static final float f_5140 = 45.0F;
   private static final float f_5141 = 135.0F;
   private static final float f_5142 = 225.0F;
   private static final float f_5143 = 315.0F;
   private static final float f_5144 = Float.MAX_VALUE;
   private static final float f_5145 = 0.05F;
   private static final float f_5146 = 1.61F;
   private static final float f_5147 = (float) (Math.PI / 180.0);
   private static final double f_5148 = 0.01;
   private static final double f_5149 = -1.0;
   private static final double f_5150 = 0.75;
   private static final double f_5151 = -0.1;
   private static final double f_5152 = 0.04;
   private static final double f_5153 = 3.2;
   private static final double f_5154 = 0.1;
   private static final double f_5155 = 0.1;
   private static final double f_5156 = 0.99;
   private static final double f_5157 = 0.98;
   private static final double f_5158 = 0.99;

   private Util8() {
   }

   public static Vec3d m_2252(LivingEntity var0) {
      float var1 = Math.abs((var0.getYaw() - f_5137) % f_5138);
      float var2 = f_5139;
      float[] var3 = new float[]{f_5140, f_5141, f_5142, f_5143};
      float var4 = var3[0];
      float var5 = f_5144;

      for (float var9 : var3) {
         float var10 = Math.abs(var1 - var9);
         if (var10 < var5) {
            var5 = var10;
            var4 = var9;
         }
      }

      float var22 = Math.abs(var1 - var4);
      float var23 = var2 - var22 * f_5145;
      Vec3d var24 = var0.getRotationVector();
      Vec3d var25 = Vec3d.fromPolar(var0.getPitch(), var0.getYaw()).multiply(Math.max(var23, f_5146));
      float var27 = var0.getPitch() * f_5147;
      double var11 = Math.sqrt(var24.x * var24.x + var24.z * var24.z);
      double var13 = var25.horizontalLength();
      boolean var15 = var0.getVelocity().y <= 0.0;
      double var16 = var15 && var0.hasStatusEffect(StatusEffects.SLOW_FALLING) ? Math.min(var0.getFinalGravity(), f_5148) : var0.getFinalGravity();
      double var18 = MathHelper.square(Math.cos(var27));
      var25 = var25.add(0.0, var16 * (f_5149 + var18 * f_5150), 0.0);
      if (var25.y < 0.0 && var11 > 0.0) {
         double var20 = var25.y * f_5151 * var18;
         var25 = var25.add(var24.x * var20 / var11, var20, var24.z * var20 / var11);
      }

      if (var27 < 0.0F && var11 > 0.0) {
         double var28 = var13 * -MathHelper.sin(var27) * f_5152;
         var25 = var25.add(-var24.x * var28 / var11, var28 * f_5153, -var24.z * var28 / var11);
      }

      if (var11 > 0.0) {
         var25 = var25.add((var24.x / var11 * var13 - var25.x) * f_5154, 0.0, (var24.z / var11 * var13 - var25.z) * f_5155);
      }

      double var29 = var25.length();
      return new Vec3d(var29, var29, var29).multiply(f_5156, f_5157, f_5158);
   }

   public static Vec3d m_2151(LivingEntity var0, float var1, float var2) {
      Vec3d var3 = var0.getRotationVector();
      Vec3d var4 = Vec3d.fromPolar(var0.getPitch(), var0.getYaw()).multiply(var1);
      float var5 = var0.getPitch() * f_5125;
      double var6 = Math.sqrt(var3.x * var3.x + var3.z * var3.z);
      double var8 = var4.horizontalLength();
      boolean var10 = var0.getVelocity().y <= 0.0;
      double var11 = var10 && var0.hasStatusEffect(StatusEffects.SLOW_FALLING) ? Math.min(var0.getFinalGravity(), f_5126) : var0.getFinalGravity();
      double var13 = MathHelper.square(Math.cos(var5));
      var4 = var4.add(0.0, var11 * (f_5127 + var13 * f_5128), 0.0);
      if (var4.y < 0.0 && var6 > 0.0) {
         double var15 = var4.y * f_5129 * var13;
         var4 = var4.add(var3.x * var15 / var6, var15 * var2 / var1, var3.z * var15 / var6);
      }

      if (var5 < 0.0F && var6 > 0.0) {
         double var18 = var8 * -MathHelper.sin(var5) * f_5130;
         var4 = var4.add(-var3.x * var18 / var6, var18 * f_5131 * var2 / var1, -var3.z * var18 / var6);
      }

      if (var6 > 0.0) {
         var4 = var4.add((var3.x / var6 * var8 - var4.x) * f_5132, 0.0, (var3.z / var6 * var8 - var4.z) * f_5133);
      }

      return var4.multiply(f_5134, f_5135, f_5136);
   }
}
