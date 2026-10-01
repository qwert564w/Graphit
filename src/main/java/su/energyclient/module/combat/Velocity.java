package su.energyclient.module.combat;

import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util66;

public class Velocity extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_2538 = "Velocity";
   private static final String f_2539 = "Reduces knockback from attacks";

   public Velocity() {
      super(f_2538, f_2539, Category.COMBAT);
   }

   @EventHandler
   public void m_3299(Util66 var1) {
      if (f_5909.player != null && var1.m_2068() && var1.m_3295() instanceof EntityVelocityUpdateS2CPacket var2 && var2.getEntityId() == f_5909.player.getId()) {
         var1.m_277(true);
      }
   }
}
