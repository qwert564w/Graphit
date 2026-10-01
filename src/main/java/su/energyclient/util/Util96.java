package su.energyclient.util;

import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public final class Util96 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_6150 = 0.99;
   private static final double f_6151 = 0.98;
   private static final double f_6152 = 0.99;
   private static final double f_6153 = 0.8;
   private static final double f_6154 = 0.08;
   private static final double f_6155 = 0.8;
   private static final double f_6156 = 0.8;
   private static final double f_6157 = 0.6;
   private static final double f_6158 = 0.3;
   private static final double f_6159 = 0.5;
   private static final double f_6160 = 0.02;
   private static final double f_6161 = 0.5;
   private static final double f_6162 = 0.5;
   private static final double f_6163 = 0.6;
   private static final double f_6164 = 0.3;
   private static final double f_6165 = 0.5;
   private static final double f_6166 = 0.5;
   private static final double f_6167 = -0.15;
   private static final double f_6168 = 0.15;
   private static final double f_6169 = -0.15;
   private static final double f_6170 = 0.15;
   private static final double f_6171 = -0.15;
   private static final double f_6172 = 0.2;
   private static final double f_6173 = 0.01;
   private static final double f_6174 = 0.08;
   private static final double f_6175 = 0.05;
   private static final double f_6176 = 0.2;
   private static final double f_6177 = 0.5;
   private static final double f_6178 = 0.5000001;
   private static final double f_6179 = 0.5;
   private static final float f_6180 = 0.91F;
   private static final float f_6181 = 0.91F;
   private static final double f_6182 = 0.98;
   private static final double f_6183 = 0.5;
   private static final double f_6184 = 0.5;
   private static final double f_6185 = 1.0E-7;
   private static final double f_6186 = 1.0E-7;
   private static final double f_6187 = 1.0E-7;

   public static Util96.wzUwRrngJnenpZwo m_2264(LivingEntity var0, int var1) {
      Box var2 = var0.getBoundingBox();
      Vec3d var3 = var0 instanceof PlayerEntity ? new Vec3d(var0.getX() - var0.lastX, var0.getY() - var0.lastY, var0.getZ() - var0.lastZ) : var0.getVelocity();
      boolean var4 = var0.isOnGround();

      for (int var5 = 0; var5 < var1; var5++) {
         Vec3d var6 = Entity.adjustMovementForCollisions(var0, var3, var2, var0.getEntityWorld(), List.of());
         var2 = var2.offset(var6);
         boolean var7 = var3.x != var6.x || var3.z != var6.z;
         boolean var8 = var3.y != var6.y;
         var4 = var8 && var3.y < 0.0;
         double var9 = var3.x != var6.x ? 0.0 : var6.x;
         double var11 = var3.z != var6.z ? 0.0 : var6.z;
         double var13 = var4 ? 0.0 : var6.y;
         boolean var15 = m_2955(var0, var2, true);
         boolean var16 = m_2955(var0, var2, false);
         if (var0.isGliding()) {
            var3 = new Vec3d(var9 * f_6150, var13 * f_6151, var11 * f_6152);
         } else if (var15) {
            var3 = new Vec3d(var9 * f_6153, (var13 - f_6154) * f_6155, var11 * f_6156);
            if (var7 && m_1790(var0, var2, var3.x, f_6157, var3.z)) {
               var3 = new Vec3d(var3.x, f_6158, var3.z);
            }
         } else if (var16) {
            var3 = new Vec3d(var9 * f_6159, (var13 - f_6160) * f_6161, var11 * f_6162);
            if (var7 && m_1790(var0, var2, var3.x, f_6163, var3.z)) {
               var3 = new Vec3d(var3.x, f_6164, var3.z);
            }
         } else {
            BlockPos var17 = BlockPos.ofFloored((var2.minX + var2.maxX) * f_6165, var2.minY, (var2.minZ + var2.maxZ) * f_6166);
            if (var0.getEntityWorld().getBlockState(var17).isIn(BlockTags.CLIMBABLE)) {
               var9 = Math.max(f_6167, Math.min(f_6168, var9));
               var11 = Math.max(f_6169, Math.min(f_6170, var11));
               var13 = Math.max(var13, f_6171);
               if (var7) {
                  var13 = f_6172;
               }
            }

            double var18 = var0.hasStatusEffect(StatusEffects.SLOW_FALLING) && var13 <= 0.0 ? f_6173 : f_6174;
            StatusEffectInstance var20 = var0.getStatusEffect(StatusEffects.LEVITATION);
            if (var20 != null) {
               var13 += (f_6175 * (var20.getAmplifier() + 1) - var13) * f_6176;
            } else if (!var0.hasNoGravity()) {
               var13 -= var18;
            }

            BlockPos var21 = BlockPos.ofFloored((var2.minX + var2.maxX) * f_6177, var2.minY - f_6178, (var2.minZ + var2.maxZ) * f_6179);
            BlockState var22 = var0.getEntityWorld().getBlockState(var21);
            float var23 = var4 ? var22.getBlock().getSlipperiness() * f_6180 : f_6181;
            var3 = new Vec3d(var9 * var23, var13 * f_6182, var11 * var23);
         }
      }

      return new Util96.wzUwRrngJnenpZwo(var2, new Vec3d((var2.minX + var2.maxX) * f_6183, var2.minY, (var2.minZ + var2.maxZ) * f_6184));
   }

   private Util96() {
   }

   private static boolean m_1790(LivingEntity var0, Box var1, double var2, double var4, double var6) {
      return Entity.adjustMovementForCollisions(var0, new Vec3d(var2, var4, var6), var1, var0.getEntityWorld(), List.of()).equals(new Vec3d(var2, var4, var6));
   }

   private static boolean m_2955(LivingEntity var0, Box var1, boolean var2) {
      int var3 = (int)Math.floor(var1.minX);
      int var4 = (int)Math.floor(var1.minY);
      int var5 = (int)Math.floor(var1.minZ);
      int var6 = (int)Math.floor(var1.maxX - f_6185);
      int var7 = (int)Math.floor(var1.maxY - f_6186);
      int var8 = (int)Math.floor(var1.maxZ - f_6187);

      for (int var9 = var3; var9 <= var6; var9++) {
         for (int var10 = var4; var10 <= var7; var10++) {
            for (int var11 = var5; var11 <= var8; var11++) {
               FluidState var12 = var0.getEntityWorld().getFluidState(new BlockPos(var9, var10, var11));
               if (var2 ? var12.isIn(FluidTags.WATER) : var12.isIn(FluidTags.LAVA)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public record wzUwRrngJnenpZwo(Box box, Vec3d position) {
   }
}
