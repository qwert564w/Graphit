package su.energyclient.module.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.FriendManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.movement.AutoSprint;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util101;
import su.energyclient.util.Util121;
import su.energyclient.util.Util170;
import su.energyclient.util.Util38;
import su.energyclient.util.Util66;

public class AutoAccept extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final long f_14436 = 100L;
   private final List<String> f_14437 = new ArrayList<>();
   private boolean f_14438;
   private long f_14439;
   private final BooleanSetting f_14440;
   private static final String f_14441 = "Auto Accept";
   private static final String f_14442 = "Автоматически принимает запросы";
   private static final String f_14443 = "Только от друзей";
   private static final String f_14444 = "телепортироваться";
   private static final String f_14445 = "funtime";
   private static final String f_14446 = "tpyes";
   private static final String f_14447 = "tpaccept";
   private static final long f_14448 = 100L;
   private static final String f_14449 = "reallyworld";
   private static final String f_14450 = "playrw";

   private void m_298() {
      if (f_5909.player != null) {
         AutoSprint.m_1519(false);
         f_5909.player.setSprinting(false);
         f_5909.options.jumpKey.setPressed(false);
         f_5909.options.forwardKey.setPressed(false);
         f_5909.options.backKey.setPressed(false);
         f_5909.options.leftKey.setPressed(false);
         f_5909.options.rightKey.setPressed(false);
         f_5909.options.sprintKey.setPressed(false);
      }
   }

   @EventHandler
   private void m_392(Util66 var1) {
      if (var1.m_2068() && var1.m_3295() instanceof GameMessageS2CPacket var2 && var2.content().getString().contains(f_14444)) {
         String var6 = Util101.m_3117(f_14445) ? f_14446 : f_14447;
         if (this.f_14440.m_1163()) {
            for (FriendManager.Cfsq1JrSJubpZ92Z var5 : InitManager.f_2740.f_2744.m_3756()) {
               if (var2.content().getString().contains(var5.m_173())) {
                  this.m_788(var6);
                  return;
               }
            }
         } else {
            this.m_788(var6);
         }
      }
   }

   private void m_351() {
      this.f_14437.clear();
      this.f_14438 = false;
      this.f_14439 = 0L;
      AutoSprint.m_1519(true);
   }

   @Override
   public void m_1() {
      this.m_351();
      super.m_1();
   }

   @EventHandler
   private void m_3761(Util170 var1) {
      if (this.f_14438) {
         if (f_5909.player != null && f_5909.world != null) {
            this.m_298();
            if (System.currentTimeMillis() - this.f_14439 >= f_14448) {
               ArrayList<String> var2 = new ArrayList<>(this.f_14437);
               this.m_351();
               var2.forEach(this::m_871);
            }
         } else {
            this.m_351();
         }
      }
   }

   @EventHandler
   private void m_3682(Util121 var1) {
      if (this.f_14438) {
         var1.m_433(0.0F);
         var1.m_2791(0.0F);
      }
   }

   public AutoAccept() {
      super(f_14441, f_14442, Category.MISCELLANEOUS);
      this.f_14440 = new BooleanSetting(f_14443, false);
   }

   private void m_788(String var1) {
      if (this.f_14438 || (Util101.m_3117(f_14449) || Util101.m_3117(f_14450)) && Util38.m_469()) {
         this.f_14437.add(var1);
         if (!this.f_14438) {
            this.f_14438 = true;
            this.f_14439 = System.currentTimeMillis();
         }

         this.m_298();
      } else {
         this.m_871(var1);
      }
   }

   private void m_871(String var1) {
      if (f_5909.player != null && f_5909.player.networkHandler != null) {
         f_5909.player.networkHandler.sendChatMessage("/" + var1);
      }
   }
}
