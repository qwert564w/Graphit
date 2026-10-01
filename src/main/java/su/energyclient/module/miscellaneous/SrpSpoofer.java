package su.energyclient.module.miscellaneous;

import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket;
import net.minecraft.network.packet.c2s.common.ResourcePackStatusC2SPacket.Status;
import net.minecraft.network.packet.s2c.common.ResourcePackSendS2CPacket;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util66;

public class SrpSpoofer extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_8373 = "SRP Spoofer";
   private static final String f_8374 = "description";

   @EventHandler
   public void m_3619(Util66 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (var1.m_2068()) {
            if (var1.m_3295() instanceof ResourcePackSendS2CPacket var2) {
               f_5909.player.networkHandler.sendPacket(new ResourcePackStatusC2SPacket(var2.id(), Status.ACCEPTED));
               f_5909.player.networkHandler.sendPacket(new ResourcePackStatusC2SPacket(var2.id(), Status.SUCCESSFULLY_LOADED));
               var1.m_277(true);
            }
         }
      }
   }

   public SrpSpoofer() {
      super(f_8373, f_8374, Category.MISCELLANEOUS);
   }
}
