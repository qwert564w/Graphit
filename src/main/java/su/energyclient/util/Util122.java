package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;
import su.energyclient.manager.InitManager;
import su.energyclient.module.movement.ElytraSample;

public final class Util122 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_10754 = 1.0E-8;
   private static final float f_10755 = 999.0F;
   private static final float f_10756 = 999.0F;
   private static final float f_10757 = 999.0F;
   private static final float f_10758 = 999.0F;
   private static final String f_10759 = "This is a utility class and cannot be instantiated";

   public static boolean m_3954(LivingEntity var0) {
      if (f_5909.player != null
         && f_5909.world != null
         && var0 != null
         && var0.isAlive()
         && var0.getEntityWorld() == f_5909.world
         && f_5909.player.isGliding()
         && !f_5909.player.isTouchingWater()
         && !f_5909.player.isInLava()
         && !var0.isRemoved()
         && var0.isGliding()
         && !var0.isOnGround()
         && !var0.isTouchingWater()
         && !var0.isInLava()) {
         ElytraSample var1 = InitManager.f_2740.f_2741.elytraSample;
         if (var1 != null && var1.m_677()) {
            Vec3d var2 = var0.getEntityPos();
            Vec3d var3 = var1.m_2961(var0, var2, var0.getVelocity());
            Vec3d var4 = f_5909.player.getEyePos();
            Vec3d var5 = Util130.m_1511(var0.getBoundingBox(), var3.subtract(var2), var4);
            if (Util130.m_1552(var5) && !(var5.lengthSquared() < f_10754)) {
               Util10 var6 = Util39.m_3442(var5);
               Util54.m_2145(var6, f_10755, f_10756, f_10757, f_10758, 1, 2, false);
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private Util122() {
      throw new UnsupportedOperationException(f_10759);
   }
}
