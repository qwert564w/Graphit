package su.energyclient.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import su.energyclient.QuickImports;

public final class Util75 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_9335 = 0.8F;
   private static final double f_9336 = 0.1;
   private static final double f_9337 = 0.125;
   private static final double f_9338 = 0.1875;
   private static final double f_9339 = 1.0E-7;
   private static final double f_9340 = 0.001;

   private Util75() {
   }

   private static boolean m_62(float var0) {
      return m_1454(Blocks.WATER, var0) || m_1454(Blocks.LAVA, var0);
   }

   private static boolean m_1454(Block var0, float var1) {
      double var2 = f_5909.player.getX();
      double var4 = f_5909.player.getZ();
      double var6 = f_5909.player.getBoundingBox().minY;
      return f_5909.world.getBlockState(BlockPos.ofFloored(var2, var6, var4)).isOf(var0)
         && !f_5909.world.getBlockState(BlockPos.ofFloored(var2, var6 + var1, var4)).isOf(var0)
         && !f_5909.world.getBlockState(BlockPos.ofFloored(var2, f_5909.player.getEyeY(), var4)).isOf(var0);
   }

   public static boolean m_2491(boolean var0) {
      if (f_5909.player != null && f_5909.world != null) {
         boolean var1 = f_5909.player.isOnGround();
         boolean var2 = var0 || f_5909.player.hasStatusEffect(StatusEffects.JUMP_BOOST);
         if (var2 && !f_5909.player.input.playerInput.jump() && var1) {
            return false;
         } else {
            boolean var3 = (f_5909.player.isTouchingWater() || f_5909.player.isInLava()) && !m_62(f_9335);
            boolean var4 = f_5909.world.isSpaceEmpty(f_5909.player.getBoundingBox().offset(0.0, f_9336, 0.0));
            double var5 = Math.abs((int)f_5909.player.getY() - f_5909.player.getY());
            boolean var7 = (var5 == f_9337 || var5 == f_9338) && !var4;
            boolean var8 = var1
               && !f_5909.world
                  .isSpaceEmpty(f_5909.player, f_5909.player.getDimensions(EntityPose.STANDING).getBoxAt(f_5909.player.getEntityPos()).contract(f_9339));
            boolean var9 = !var4 && var1;
            return !f_5909.player.isGliding()
               && !f_5909.player.getAbilities().flying
               && !f_5909.player.hasStatusEffect(StatusEffects.LEVITATION)
               && !f_5909.player.hasStatusEffect(StatusEffects.BLINDNESS)
               && !f_5909.player.hasStatusEffect(StatusEffects.SLOW_FALLING)
               && !f_5909.player.hasVehicle()
               && !f_5909.player.isClimbing()
               && !m_1394()
               && !f_5909.player.isSwimming()
               && !var3
               && !var7
               && !var8
               && !var9;
         }
      } else {
         return false;
      }
   }

   private static boolean m_1394() {
      Box var0 = f_5909.player.getBoundingBox().contract(f_9340);

      for (BlockPos var2 : BlockPos.iterate(
         MathHelper.floor(var0.minX),
         MathHelper.floor(var0.minY),
         MathHelper.floor(var0.minZ),
         MathHelper.floor(var0.maxX),
         MathHelper.floor(var0.maxY),
         MathHelper.floor(var0.maxZ)
      )) {
         BlockState var3 = f_5909.world.getBlockState(var2);
         if (var3.isOf(Blocks.COBWEB) || var3.isOf(Blocks.SWEET_BERRY_BUSH) || var3.isOf(Blocks.SCAFFOLDING)) {
            return true;
         }
      }

      return false;
   }
}
