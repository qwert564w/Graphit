package su.energyclient.module.movement;

import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.module.combat.Macetarget;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util110;
import su.energyclient.util.Util37;
import su.energyclient.util.Util39;

public class ElytraWhatsapp extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final NumberSetting f_541;
   private static final String f_542 = "Elytra Whatsapp";
   private static final String f_543 = "отца ебал";
   private static final String f_544 = "Дистанция";
   private static final float f_545 = 1.25F;
   private static final float f_546 = 2.5F;
   private static final float f_547 = 0.05F;
   private static final double f_548 = 24.0;

   private boolean m_3307() {
      if (Macetarget.m_329()) {
         return false;
      } else {
         AttackAura var1 = InitManager.f_2740.f_2741.attackAura;
         return var1.m_891() == null
            ? false
            : f_5909.player.isGliding() && Util39.m_1252(var1.m_891(), 1) <= f_548 && f_5909.player.distanceTo(var1.m_891()) <= this.f_541.m_4046();
      }
   }

   @EventHandler
   private void m_3772(Util37 var1) {
      if (var1.m_515() == f_5909.player && this.m_3307()) {
         f_5909.player.setVelocity(Vec3d.ZERO);
         var1.m_277(true);
      }
   }

   public ElytraWhatsapp() {
      super(f_542, f_543, Category.MOVEMENT);
      this.f_541 = new NumberSetting(f_544, 2.0F, f_545, f_546, f_547);
   }

   @EventHandler
   private void m_1060(Util110 var1) {
      if (var1.m_1807() == f_5909.player && this.m_3307()) {
         var1.m_1249(Vec3d.ZERO);
      }
   }
}
