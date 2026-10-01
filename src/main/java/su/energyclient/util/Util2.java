package su.energyclient.util;

import java.util.ArrayList;
import java.util.List;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.command.impl.PanicCommand;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.WaypointsManager;
import su.energyclient.module.movement.AutoSprint;

public class Util2 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final long f_5262 = 100L;
   private final List<String> f_5263 = new ArrayList<>();
   private boolean f_5264;
   private long f_5265;
   private static final long f_5266 = 100L;
   private static final String f_5267 = "/";

   private void m_2790(String var1) {
      if (f_5909.player != null && f_5909.player.networkHandler != null) {
         if (var1.startsWith(f_5267)) {
            f_5909.player.networkHandler.sendChatCommand(var1.substring(1));
         } else {
            f_5909.player.networkHandler.sendChatMessage(var1);
         }
      }
   }

   public Util2() {
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   @EventHandler
   public void O(Util121 var1) {
      if (this.f_5264) {
         var1.m_433(0.0F);
         var1.m_2791(0.0F);
      }
   }

   @EventHandler
   public void m_1103(Util170 var1) {
      if (PanicCommand.m_2020()) {
         this.m_3460();
      } else if (this.f_5264) {
         if (f_5909.player != null && f_5909.world != null) {
            this.m_2476();
            if (System.currentTimeMillis() - this.f_5265 >= f_5266) {
               ArrayList<String> var2 = new ArrayList<>(this.f_5263);
               this.m_3460();
               var2.forEach(this::m_2790);
            }
         } else {
            this.m_3460();
         }
      }
   }

   @EventHandler
   public void m_1736(CancellableEvent var1) {
      if (!PanicCommand.m_2020() && f_5909.player != null && !var1.m_1362() && f_5909.world != null && var1.m_2169() != -1) {
         ArrayList<String> var2 = new ArrayList<>();

         for (WaypointsManager.Inner_9JcfksyJpnbcaVkW var4 : InitManager.f_2740.f_2752.m_817()) {
            if (var4.m_3326() == var1.m_2169() && !var1.m_3546()) {
               String var5 = var4.m_1474();
               if (var5 != null && !var5.isEmpty()) {
                  var2.add(var5);
               }
            }
         }

         if (!var2.isEmpty()) {
            if (!this.f_5264 && !Util38.m_469()) {
               var2.forEach(this::m_2790);
            } else {
               this.f_5263.addAll(var2);
               if (!this.f_5264) {
                  this.f_5264 = true;
                  this.f_5265 = System.currentTimeMillis();
               }

               this.m_2476();
            }
         }
      }
   }

   private void m_3460() {
      this.f_5263.clear();
      this.f_5264 = false;
      this.f_5265 = 0L;
      AutoSprint.m_1519(true);
   }

   private void m_2476() {
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
}
