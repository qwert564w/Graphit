package su.energyclient.module.player;

import java.util.UUID;
import net.minecraft.entity.player.PlayerEntity;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util170;
import su.energyclient.util.Util90;

public class KillMessage extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private UUID f_6901;
   private static final String f_6902 = "Kill Message";
   private static final String f_6903 = "Sends a chat message when aura target dies";

   public KillMessage() {
      super(f_6902, f_6903, Category.PLAYER);
   }

   @Override
   public void m_1() {
      super.m_1();
      this.f_6901 = null;
   }

   @EventHandler
   public void m_4028(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (!(InitManager.f_2740.f_2741.attackAura.m_891() instanceof PlayerEntity var3)) {
            this.f_6901 = null;
         } else {
            boolean var4 = !var3.isAlive() || var3.isDead() || var3.getHealth() <= 0.0F;
            if (!var4) {
               if (this.f_6901 != null && this.f_6901.equals(var3.getUuid())) {
                  this.f_6901 = null;
               }
            } else if (!var3.getUuid().equals(this.f_6901)) {
               String var5 = var3.getName().getString();
               String var6 = Util90.f_5919;
               f_5909.player.networkHandler.sendChatMessage("! " + var5 + " еззка, когда ты уже наконец купишь Energy Beta 1.21.4 by " + var6);
               this.f_6901 = var3.getUuid();
            }
         }
      }
   }
}
