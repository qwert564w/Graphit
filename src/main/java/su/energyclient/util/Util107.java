package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;
import su.energyclient.module.combat.AttackAura;

public class Util107 implements QuickImports, Util148 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_14157 = "ML";
   private static final double f_14158 = 0.15F;
   private static final float f_14159 = 0.07F;
   private static final float f_14160 = 50.0F;
   private static final float f_14161 = 1.05F;
   private static final float f_14162 = 90.0F;
   private static final float f_14163 = -90.0F;
   private static final float f_14164 = 999.0F;
   private static final float f_14165 = 999.0F;
   private static final float f_14166 = -45.0F;
   private static final float f_14167 = 45.0F;
   private static final float f_14168 = 360.0F;
   private static final float f_14169 = 360.0F;
   private static final double f_14170 = 5.0;
   private static final double f_14171 = 5.0;

   @Override
   public String m_3() {
      return f_14157;
   }

   @Override
   public void m_5(AttackAura var1, LivingEntity var2) {
      if (f_5909.player != null) {
         Vec3d var3 = var2.getBoundingBox().getCenter().add(0.0, f_14158, 0.0);
         Util10 var4 = Util39.m_2474(var3);
         float var5 = f_5909.player.getYaw();
         float var6 = f_5909.player.getPitch();
         float var7 = MathHelper.wrapDegrees(var4.m_2643() - var5);
         float var8 = var4.m_2573() - var6;
         float var9 = Math.abs(f_14159);
         if (Math.abs(var7) > f_14160) {
            var9 /= f_14161;
         }

         float var10 = MathHelper.clamp(
            Math.abs(var7)
               * (
                  var6 != f_14162
                        && var6 != f_14163
                        && (!f_5909.player.getBoundingBox().intersects(var2.getBoundingBox()) || !f_5909.player.horizontalCollision)
                     ? var9
                     : 0.0F
               ),
            0.0F,
            f_14164
         );
         float var11 = MathHelper.clamp(Math.abs(var8) * (var1.f_3640 ? 0.0F : var9 / 2.0F), 0.0F, f_14165);
         float var12 = MathHelper.clamp(var7, -var10, var10);
         float var13 = MathHelper.clamp(var8, -var11, var11);
         float var14 = var5 + var12;
         float var15 = MathHelper.clamp(var6 + var13, f_14166, f_14167);
         Util10 var16 = new Util10(var14, var15);
         Util54.m_2145(var16, f_14168, f_14169, 0.0F, 0.0F, 1, 1, var1.f_3570.m_1163());
         float var17 = (float)(f_5909.mouse.cursorDeltaX / f_14170);
         float var18 = (float)(f_5909.mouse.cursorDeltaY / f_14171);
         var1.f_3641.add(new AttackAura.XG2B0wLrQB0BY1qL(var17, var18));
         Util103.m_3041(var17, var18);
      }
   }
}
