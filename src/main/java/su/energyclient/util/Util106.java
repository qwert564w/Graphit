package su.energyclient.util;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import su.energyclient.event.impl.EventInventoryClose;
import su.energyclient.event.impl.EventWindowClick;
import su.energyclient.setting.impl.ModeSetting;

public class Util106 extends Util155 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final List<Packet<?>> f_14307 = new ArrayList<>();
   private int f_14308 = 0;
   public boolean f_14309 = false;
   private static final String f_14310 = "ReallyWorld";
   private static final String f_14311 = "ReallyWorld";
   private static final String f_14312 = "ReallyWorld";
   private static final String f_14313 = "ReallyWorld";

   @Override
   public void m_19(EventWindowClick var1) {
      if (this.m_2887()) {
         if (f_5909.currentScreen instanceof InventoryScreen && Util38.m_469()) {
            this.f_14307.add(new ClickSlotC2SPacket(var1.m_1366(), var1.m_1064(), var1.m_1550(), var1.m_1602(), var1.m_396(), var1.m_2662(), var1.m_1729()));
            var1.m_277(true);
         }
      }
   }

   private boolean m_2887() {
      return this.f_10919.m_2073(f_14310);
   }

   @Override
   public void m_17(Util121 var1) {
      if (this.f_10919.m_2073(f_14311) && this.f_14308 > 0) {
         var1.m_433(0.0F);
         var1.m_2791(0.0F);
         var1.m_564(false);
         var1.m_1269(false);
      }
   }

   @Override
   public void m_16() {
      this.f_14307.clear();
      this.f_14308 = 0;
      this.f_14309 = false;
   }

   @Override
   public void l(EventInventoryClose var1) {
      if (this.m_2887()) {
         if (f_5909.currentScreen instanceof InventoryScreen && Util38.m_469()) {
            if (!this.f_14307.isEmpty()) {
               this.f_14309 = true;
               this.f_14308 = 3;
            }

            var1.m_277(true);
         }
      }
   }

   @Override
   public void m_15(Util170 var1) {
      if (this.f_14308 > 0) {
         this.f_14308--;
      }

      KeyBinding[] var2 = new KeyBinding[]{
         f_5909.options.forwardKey, f_5909.options.backKey, f_5909.options.leftKey, f_5909.options.rightKey, f_5909.options.jumpKey
      };
      if (!this.f_10919.m_2073(f_14312) || this.f_14308 <= 0) {
         if (!(f_5909.currentScreen instanceof ChatScreen) && !(f_5909.currentScreen instanceof AbstractSignEditScreen)) {
            long var3 = f_5909.getWindow().getHandle();

            for (KeyBinding var8 : var2) {
               boolean var9 = InputUtil.isKeyPressed(f_5909.getWindow(), var8.getDefaultKey().getCode());
               var8.setPressed(var9);
            }

            if (this.f_14309 && this.f_10919.m_2073(f_14313)) {
               for (Packet var11 : this.f_14307) {
                  f_5909.player.networkHandler.sendPacket(var11);
               }

               f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
               this.f_14307.clear();
               this.f_14309 = false;
            }
         }
      }
   }

   public Util106(ModeSetting var1) {
      super(var1);
   }
}
