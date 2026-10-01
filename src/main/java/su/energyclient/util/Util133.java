package su.energyclient.util;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class Util133 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Map<LivingEntity, Util133.EpagZYMJKR4g5bzV> f_10567 = new WeakHashMap<>();
   private static final float f_10568 = 5.0F;

   public static Vec3d m_1391(LivingEntity var0, Vec3d var1, Vec3d var2, float var3, boolean var4) {
      if (var0 == null || var1 == null) {
         return var1;
      } else if (!var0.isAlive() || var0.isRemoved() || !var0.isGliding() || var0.isOnGround() || var0.isTouchingWater() || var0.isInLava()) {
         f_10567.remove(var0);
         return var1;
      } else if (Util130.m_1552(var1) && Float.isFinite(var3)) {
         float var5 = MathHelper.clamp(var3, 0.0F, f_10568);
         Util133.EpagZYMJKR4g5bzV var6 = f_10567.get(var0);
         if (var6 == null || var6.f_686.get() != var0) {
            f_10567.remove(var0);
            var6 = new Util133.EpagZYMJKR4g5bzV(var0);
            f_10567.put(var0, var6);
         }

         Vec3d var7 = var0.getEntityPos();
         Vec3d var8 = var2 == null ? var0.getVelocity() : var2;
         Util76.Inner_7PNRURzqcF1Y7Kub var9 = var6.f_687
            .m_199(var0.age, var7, var8, var0.getYaw(), var0.getPitch(), var0.getFinalGravity(), var0.hasStatusEffect(StatusEffects.SLOW_FALLING));
         Vec3d var10 = Util130.m_2443(var8, var9);
         float var11 = var0.getInterpolator().getLerpedYaw();
         float var12 = var0.getInterpolator().getLerpedPitch();
         boolean var13 = var6.f_688 != var9 || var6.f_689 != var5 || var6.f_690 != var4 || !var7.equals(var6.f_691);
         if (!var4) {
            var13 |= !var10.equals(var6.f_692) || var11 != var6.f_693 || var12 != var6.f_694;
         }

         if (var13) {
            Util130.VDVsxAH71h31RQlm var14 = (var1x, var2x) -> {
               Box var3x = var1x.stretch(var2x);
               return !m_389(var0, var3x)
                  ? null
                  : Entity.adjustMovementForCollisions(var0, var2x, var1x, var0.getEntityWorld(), var0.getEntityWorld().getEntityCollisions(var0, var3x));
            };
            var6.f_695 = var4
               ? Util130.m_223(var9, var5, true, var0.getBoundingBox(), var14)
               : Util130.m_2615(var10, var11, var12, var5, var0.getBoundingBox(), var14);
            var6.f_688 = var9;
            var6.f_689 = var5;
            var6.f_690 = var4;
            var6.f_691 = var7;
            var6.f_692 = var10;
            var6.f_693 = var11;
            var6.f_694 = var12;
         }

         return var1.add(var6.f_695);
      } else {
         return var1;
      }
   }

   private static boolean m_389(LivingEntity var0, Box var1) {
      int var2 = MathHelper.floor(var1.minX) >> 4;
      int var3 = MathHelper.floor(var1.maxX) >> 4;
      int var4 = MathHelper.floor(var1.minZ) >> 4;
      int var5 = MathHelper.floor(var1.maxZ) >> 4;

      for (int var6 = var2; var6 <= var3; var6++) {
         for (int var7 = var4; var7 <= var5; var7++) {
            if (!var0.getEntityWorld().isChunkLoaded(var6, var7)) {
               return false;
            }
         }
      }

      return true;
   }

   public static void m_805() {
      f_10567.clear();
   }

   public static Vec3d m_1623(LivingEntity var0, Vec3d var1, float var2) {
      return m_1391(var0, var1, var0 == null ? Vec3d.ZERO : var0.getVelocity(), var2, true);
   }

   private Util133() {
   }

   private static final class EpagZYMJKR4g5bzV {
      private final WeakReference<LivingEntity> f_686;
      private final Util76 f_687 = new Util76();
      private Util76.Inner_7PNRURzqcF1Y7Kub f_688;
      private float f_689 = Float.NaN;
      private boolean f_690;
      private Vec3d f_691;
      private Vec3d f_692;
      private float f_693;
      private float f_694;
      private Vec3d f_695 = Vec3d.ZERO;

      private EpagZYMJKR4g5bzV(LivingEntity var1) {
         this.f_686 = new WeakReference<>(var1);
      }
   }
}
