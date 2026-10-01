package su.energyclient.module.movement;

import su.energyclient.event.EventHandler;
import su.energyclient.mixin.LivingEntityMixin;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util170;

public class NoJumpDelay extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_11100 = "No Jump Delay";
   private static final String f_11101 = "description";

   public NoJumpDelay() {
      super(f_11100, f_11101, Category.MOVEMENT);
   }

   @EventHandler
   private void m_3599(Util170 var1) {
      ((LivingEntityMixin)f_5909.player).setJumpCooldown(0);
   }
}
