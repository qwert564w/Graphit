package su.energyclient.util.math;

import java.util.Optional;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import su.energyclient.QuickImports;

public final class MathUtil2 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_5849 = 1.0E-7;
   private static final double f_5850 = 2.5;
   private static final double f_5851 = 1.5;
   private static final double f_5852 = 0.05;
   private static final double f_5853 = 0.2;
   private static final double f_5854 = 0.3;
   private static final double f_5855 = 0.3;
   private static final double f_5856 = 0.3;
   private static final double f_5857 = 0.3;

   public static Vec3d m_208(Entity var0) {
      if (f_5909.player == null) {
         return Vec3d.ZERO;
      } else {
         Vec3d var1 = f_5909.player.getCameraPosVec(f_5909.getRenderTickCounter().getTickProgress(true));
         return m_1315(var1, var0).subtract(var1);
      }
   }

   private static Box m_1460(double var0) {
      double var2 = f_5909.player.getX();
      double var4 = f_5909.player.getY();
      double var6 = f_5909.player.getZ();
      return new Box(var2 - f_5854, var4 + f_5909.player.getHeight(), var6 - f_5855, var2 + f_5856, var4 + var0, var6 + f_5857);
   }

   public static boolean m_2472() {
      if (f_5909.player != null && f_5909.world != null) {
         double var0 = f_5909.player.isOnGround() ? f_5850 : f_5851;
         return f_5909.world.getBlockCollisions(f_5909.player, m_1460(var0)).iterator().hasNext();
      } else {
         return false;
      }
   }

   public static Vec3d m_1315(Vec3d var0, Entity var1) {
      return m_4038(var0, var1.getBoundingBox());
   }

   public static boolean m_2856() {
      return f_5909.player != null && f_5909.player.fallDistance > 0.0 && !f_5909.player.isOnGround() && m_2870();
   }

   private MathUtil2() {
   }

   public static boolean m_2870() {
      return f_5909.player != null && f_5909.world != null
         ? !f_5909.player.hasStatusEffect(StatusEffects.LEVITATION)
            && !f_5909.player.hasStatusEffect(StatusEffects.BLINDNESS)
            && !f_5909.player.isTouchingWater()
            && !f_5909.player.isInLava()
            && !f_5909.player.getAbilities().flying
            && !f_5909.player.isGliding()
            && !f_5909.player.isClimbing()
            && !f_5909.player.hasVehicle()
            && !m_1754()
         : false;
   }

   private static boolean m_1754() {
      Box var0 = f_5909.player.getBoundingBox();

      for (BlockPos var2 : BlockPos.iterate(
         MathHelper.floor(var0.minX),
         MathHelper.floor(var0.minY),
         MathHelper.floor(var0.minZ),
         MathHelper.floor(var0.maxX),
         MathHelper.floor(var0.maxY),
         MathHelper.floor(var0.maxZ)
      )) {
         if (f_5909.world.getBlockState(var2).isOf(Blocks.COBWEB)) {
            return true;
         }
      }

      return false;
   }

   public static Vec3d m_4038(Vec3d var0, Box var1) {
      return new Vec3d(
         MathHelper.clamp(var0.x, var1.minX, var1.maxX), MathHelper.clamp(var0.y, var1.minY, var1.maxY), MathHelper.clamp(var0.z, var1.minZ, var1.maxZ)
      );
   }

   public static boolean m_3975(float var0, float var1, double var2, Entity var4, boolean var5) {
      if (f_5909.player != null && f_5909.world != null && var4 != null) {
         Vec3d var6 = f_5909.player.getCameraPosVec(f_5909.getRenderTickCounter().getTickProgress(true));
         Vec3d var7 = var6.add(f_5909.player.getRotationVector(var1, var0).multiply(var2));
         Box var8 = var4.getBoundingBox();
         if (var8.contains(var6)) {
            return true;
         } else {
            Optional var9 = var8.raycast(var6, var7);
            if (var9.isEmpty()) {
               return false;
            } else if (!var5) {
               return true;
            } else {
               BlockHitResult var10 = f_5909.world.raycast(new RaycastContext(var6, (Vec3d)var9.get(), ShapeType.OUTLINE, FluidHandling.NONE, f_5909.player));
               return var10.getType() == Type.MISS || var6.squaredDistanceTo((Vec3d)var9.get()) <= var6.squaredDistanceTo(var10.getPos()) + f_5849;
            }
         }
      } else {
         return false;
      }
   }

   public static boolean m_3558() {
      if (f_5909.player != null && f_5909.world != null) {
         boolean var0 = f_5909.player.getPose() == EntityPose.CROUCHING && f_5909.options.jumpKey.isPressed();
         double var1 = f_5909.player.getHeight() + (var0 ? f_5852 : f_5853);
         return !f_5909.world.getBlockCollisions(f_5909.player, m_1460(var1)).iterator().hasNext();
      } else {
         return false;
      }
   }

   public static boolean m_1988() {
      if (f_5909.player == null || f_5909.world == null) {
         return false;
      } else {
         return !f_5909.player.isSubmergedInWater() && !f_5909.player.isClimbing() && !f_5909.player.getAbilities().flying
            ? f_5909.player.isOnGround() && m_2472() && !m_3558()
            : false;
      }
   }
}
