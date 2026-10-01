package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;
import su.energyclient.module.combat.AttackAura;

public class Util33 implements QuickImports, Util148 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_7718;
   private float f_7719;
   private static final String f_7720 = "AimAssist";
   private static final double f_7721 = 100.0;
   private static final double f_7722 = 90.0;
   private static final float f_7723 = -89.9F;
   private static final float f_7724 = 89.9F;

   @Override
   public void m_5(AttackAura var1, LivingEntity var2) {
      if (f_5909.player != null && f_5909.world != null && var2 != null) {
         float var3 = f_5909.player.getYaw();
         float var4 = f_5909.player.getPitch();
         this.f_7718 = var3;
         this.f_7719 = var4;
         float var5 = Math.abs(MathHelper.wrapDegrees(var3 - f_5909.player.lastYaw));
         float var6 = Math.abs(var4 - f_5909.player.lastPitch);
         boolean var7 = AttackAura.m_204(var3, var4, f_7721, var2);
         if (var7) {
            Util54.m_1085().m_2951();
         } else {
            Vec3d var8 = var2.getBoundingBox().getCenter().subtract(f_5909.player.getEyePos());
            float var9 = (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var8.z, var8.x)) - f_7722);
            float var10 = (float)(-Math.toDegrees(Math.atan2(var8.y, Math.hypot(var8.x, var8.z))));
            var10 = MathHelper.clamp(var10, f_7723, f_7724);
            Util54.m_2145(new Util10(var9, var10), var1.f_3562.m_4046(), var1.f_3562.m_4046(), var1.f_3562.m_4046(), var1.f_3562.m_4046(), 1, 0, true);
         }

         this.f_7718 = f_5909.player.getYaw();
         this.f_7719 = f_5909.player.getPitch();
      }
   }

   @Override
   public String m_3() {
      return f_7720;
   }

   @Override
   public void m_6(AttackAura var1) {
      Util54.m_1085().m_2951();
   }

   @Override
   public void m_8(AttackAura var1) {
      Util54.m_1085().m_2951();
   }
}
