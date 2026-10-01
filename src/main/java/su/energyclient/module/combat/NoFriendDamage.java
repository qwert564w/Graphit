package su.energyclient.module.combat;

import net.minecraft.entity.player.PlayerEntity;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;

public class NoFriendDamage extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_3986 = "No Friend Damage";
   private static final String f_3987 = "Prevents attacking friends";

   @EventHandler
   public void m_711(EventAttack var1) {
      if (var1.m_1070() instanceof PlayerEntity var2) {
         if (InitManager.f_2740.f_2744.m_2704(var2.getGameProfile().name())) {
            var1.m_277(true);
         }
      }
   }

   public NoFriendDamage() {
      super(f_3986, f_3987, Category.COMBAT);
   }
}
