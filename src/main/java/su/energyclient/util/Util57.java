package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;
import su.energyclient.module.combat.AttackAura;

public class Util57 implements Util148, QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_8491 = "HolyWorld";
   private static final double f_8492 = 0.15F;
   private static final float f_8493 = 0.07F;
   private static final float f_8494 = 50.0F;
   private static final float f_8495 = 1.05F;
   private static final float f_8496 = 1.25F;
   private static final float f_8497 = 90.0F;
   private static final float f_8498 = -90.0F;
   private static final float f_8499 = 999.0F;
   private static final float f_8500 = 999.0F;
   private static final float f_8501 = -45.0F;
   private static final float f_8502 = 45.0F;
   private static final float f_8503 = 360.0F;
   private static final float f_8504 = 360.0F;
   private static final double f_8505 = 10.0;

   @Override
   public String m_3() {
      return f_8491;
   }

   @Override
   public void m_5(AttackAura var1, LivingEntity var2) {
      if (f_5909.player != null) {
         var1.f_3642++;
         Vec3d var3 = var2.getBoundingBox().getCenter().add(0.0, f_8492, 0.0);
         Util10 var4 = Util39.m_2474(var3);
         float var5 = f_5909.player.getYaw();
         float var6 = f_5909.player.getPitch();
         float var7 = MathHelper.wrapDegrees(var4.m_2643() - var5);
         float var8 = var4.m_2573() - var6;
         boolean var9 = f_5909.targetedEntity == var2
            || Util36.m_1308(f_5909.player.getRotationVector(), var1.m_1837(), var2.getBoundingBox())
            || Util36.m_1308(f_5909.player.getRotationVector(Util123.f_10760.m_3186(), Util123.f_10760.m_627()), var1.m_1837(), var2.getBoundingBox());
         float var10 = Math.abs(f_8493);
         if (Math.abs(var7) > f_8494 || f_5909.player.getBoundingBox().intersects(var2.getBoundingBox())) {
            var10 /= f_8495;
         }

         if (var9) {
            var10 /= f_8496;
         }

         float var11 = MathHelper.clamp(
            Math.abs(var7)
               * (
                  var6 != f_8497 && var6 != f_8498 && (!f_5909.player.getBoundingBox().intersects(var2.getBoundingBox()) || !f_5909.player.horizontalCollision)
                     ? var10
                     : 0.0F
               ),
            0.0F,
            f_8499
         );
         float var12 = MathHelper.clamp(Math.abs(var8) * (var1.f_3640 ? 0.0F : var10 / 2.0F), 0.0F, f_8500);
         float var13 = MathHelper.clamp(var7, -var11, var11);
         float var14 = MathHelper.clamp(var8, -var12, var12);
         float var15 = var5 + var13;
         float var16 = MathHelper.clamp(var6 + var14, f_8501, f_8502);
         Util10 var17 = new Util10(var15, var16);
         Util54.m_2145(var17, f_8503, f_8504, 0.0F, 0.0F, 1, 1, var1.f_3570.m_1163());
         if (var1.f_3642 > var1.f_3641.size() - 1) {
            var1.f_3642 = 0;
         }

         double var18 = f_5909.player.getEyePos().distanceTo(var2.getBoundingBox().getCenter())
            * (f_5909.player.getEyePos().distanceTo(var2.getBoundingBox().getCenter()) / f_8505);
         if (!var1.f_3641.isEmpty()) {
            f_5909.player
               .changeLookDirection(
                  ((AttackAura.XG2B0wLrQB0BY1qL)var1.f_3641.get(var1.f_3642)).f_10812 / (1.0 + Math.max(var18 - 1.0, 0.0)),
                  ((AttackAura.XG2B0wLrQB0BY1qL)var1.f_3641.get(var1.f_3642)).f_10813 / (1.0 + Math.max(var18 - 1.0, 0.0))
               );
         }
      }
   }
}
