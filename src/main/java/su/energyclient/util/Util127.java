package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;
import su.energyclient.module.combat.AttackAura;

public class Util127 implements QuickImports, Util148 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_10740 = "ReallyWorld";
   private static final double f_10741 = 90.0;
   private static final float f_10742 = 360.0F;
   private static final float f_10743 = 360.0F;

   @Override
   public String m_3() {
      return f_10740;
   }

   @Override
   public void m_5(AttackAura var1, LivingEntity var2) {
      if (f_5909.player != null && var2 != null) {
         Vec3d var3 = var2.getBoundingBox().getCenter().subtract(f_5909.player.getEyePos());
         float var4 = (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var3.z, var3.x)) - f_10741);
         float var5 = (float)(-Math.toDegrees(Math.atan2(var3.y, Math.hypot(var3.x, var3.z))));
         float var6 = AttackAura.m_204(f_5909.player.getYaw(), f_5909.player.getPitch(), var1.m_1837(), var2) ? 0.0F : f_10742;
         Util54.m_2498(new Util10(var4, var5), var6, f_10743, 1, 6);
      }
   }
}
