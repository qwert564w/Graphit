package su.energyclient.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.ingame.AbstractSignEditScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.s2c.play.CloseScreenS2CPacket;
import net.minecraft.screen.slot.SlotActionType;
import su.energyclient.event.impl.EventWindowClick;
import su.energyclient.module.movement.AutoSprint;
import su.energyclient.setting.impl.ModeSetting;

public class Util168 extends Util155 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Util125 f_8069 = new Util125();
   private final ObjectArrayList<Packet<?>> f_8070 = new ObjectArrayList();
   private long f_8071;
   private Util168.o6tQHpXpHIBkM7hF f_8072;
   private boolean f_8073;
   private boolean f_8074;
   private static final long f_8075 = 150L;
   private static final String f_8076 = "FunTime";
   private static final String f_8077 = "HolyWorld";
   private static final String f_8078 = "FunTime";
   private static final String f_8079 = "HolyWorld";
   private static final String f_8080 = "HolyWorld";
   private static final long f_8081 = 50L;
   private static final String f_8082 = "FunTime";
   private static final String f_8083 = "HolyWorld";
   private static final String f_8084 = "FunTime";
   private static final String f_8085 = "HolyWorld";
   private static final long f_8086 = 150L;
   private static final String f_8087 = "HolyWorld";
   private static final String f_8088 = "FunTime";
   private static final String f_8089 = "FunTime";
   private static final String f_8090 = "HolyWorld";
   private static final String f_8091 = "FunTime";
   private static final String f_8092 = "HolyWorld";
   private static final String f_8093 = "FunTime";
   private static final String f_8094 = "HolyWorld";

   public Util168.o6tQHpXpHIBkM7hF m_995() {
      return this.f_8072;
   }

   @Override
   public void m_16() {
      this.f_8073 = false;
      this.f_8074 = false;
      this.f_8069.m_3493();
      this.f_8072 = Util168.o6tQHpXpHIBkM7hF.NOTHING;
      this.f_8070.clear();
      this.m_700(false);
      AutoSprint.m_1519(true);
   }

   private void m_700(boolean var1) {
      if (f_5909.world != null && f_5909.player != null) {
         AutoSprint.m_1519(false);
         f_5909.player.setSprinting(false);
         f_5909.options.jumpKey.setPressed(false);
         f_5909.options.forwardKey.setPressed(false);
         f_5909.options.backKey.setPressed(false);
         f_5909.options.leftKey.setPressed(false);
         f_5909.options.rightKey.setPressed(false);
         f_5909.options.sprintKey.setPressed(false);
         if (var1) {
            this.f_8072 = Util168.o6tQHpXpHIBkM7hF.EXECUTING;
         }
      }
   }

   @Override
   public void m_44(Util166 var1) {
      if ((this.f_8072 == Util168.o6tQHpXpHIBkM7hF.EXECUTING || this.f_8072 == Util168.o6tQHpXpHIBkM7hF.SENDING) && !this.f_8074 && !var1.m_2364()) {
         this.f_8074 = true;
         this.f_8069.m_3493();
      }
   }

   public Util168(ModeSetting var1) {
      super(var1);
      this.f_8071 = f_8075;
      this.f_8072 = Util168.o6tQHpXpHIBkM7hF.NOTHING;
      this.f_8073 = false;
      this.f_8074 = false;
   }

   @Override
   public void m_15(Util170 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         if ((this.f_10919.m_2073(f_8076) || this.f_10919.m_2073(f_8077))
            && this.f_8074
            && (this.f_8072 == Util168.o6tQHpXpHIBkM7hF.EXECUTING || this.f_8072 == Util168.o6tQHpXpHIBkM7hF.SENDING)) {
            this.m_700(false);
            if (this.f_8069.m_2636(this.f_8071)) {
               this.f_8072 = Util168.o6tQHpXpHIBkM7hF.NOTHING;
               if (this.f_10919.m_2073(f_8078) || this.f_10919.m_2073(f_8079)) {
                  f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
               }

               this.f_8073 = false;
               this.f_8074 = false;
               AutoSprint.m_1519(true);
            } else if (this.f_8069.m_2636(this.f_10919.m_2073(f_8080) ? 1L : f_8081)) {
               this.f_8072 = Util168.o6tQHpXpHIBkM7hF.SENDING;
               ArrayList<Packet<?>> var2 = new ArrayList<>(this.f_8070);
               this.f_8070.clear();
               var2.forEach(var0 -> f_5909.player.networkHandler.sendPacket(var0));
            }
         }

         if (this.f_8072 == Util168.o6tQHpXpHIBkM7hF.NOTHING
            && !(f_5909.currentScreen instanceof ChatScreen)
            && !(f_5909.currentScreen instanceof AbstractSignEditScreen)
            && f_5909.player.currentScreenHandler.syncId == 0) {
            long var4 = f_5909.getWindow().getHandle();
            f_5909.options.jumpKey.setPressed(InputUtil.isKeyPressed(f_5909.getWindow(), f_5909.options.jumpKey.getDefaultKey().getCode()));
            f_5909.options.forwardKey.setPressed(InputUtil.isKeyPressed(f_5909.getWindow(), f_5909.options.forwardKey.getDefaultKey().getCode()));
            f_5909.options.backKey.setPressed(InputUtil.isKeyPressed(f_5909.getWindow(), f_5909.options.backKey.getDefaultKey().getCode()));
            f_5909.options.leftKey.setPressed(InputUtil.isKeyPressed(f_5909.getWindow(), f_5909.options.leftKey.getDefaultKey().getCode()));
            f_5909.options.rightKey.setPressed(InputUtil.isKeyPressed(f_5909.getWindow(), f_5909.options.rightKey.getDefaultKey().getCode()));
            f_5909.options.sprintKey.setPressed(InputUtil.isKeyPressed(f_5909.getWindow(), f_5909.options.sprintKey.getDefaultKey().getCode()));
         }
      }
   }

   @Override
   public void m_17(Util121 var1) {
      if ((this.f_10919.m_2073(f_8093) || this.f_10919.m_2073(f_8094)) && this.f_8072 != Util168.o6tQHpXpHIBkM7hF.NOTHING) {
         var1.m_433(0.0F);
         var1.m_2791(0.0F);
      }
   }

   @Override
   public void m_19(EventWindowClick var1) {
      if (f_5909.world != null && f_5909.player != null) {
         if ((this.f_10919.m_2073(f_8091) || this.f_10919.m_2073(f_8092))
            && Util38.m_469()
            && f_5909.player.currentScreenHandler.syncId == 0
            && f_5909.currentScreen instanceof InventoryScreen
            && (var1.m_396() == SlotActionType.PICKUP || var1.m_396() == SlotActionType.PICKUP_ALL)) {
            var1.m_277(true);
         }
      }
   }

   @Override
   public void m_42(Util66 var1) {
      if (var1.m_2586() && (this.f_10919.m_2073(f_8082) || this.f_10919.m_2073(f_8083))) {
         Packet var2 = var1.m_3295();
         boolean var3 = var2 instanceof ClickSlotC2SPacket;
         boolean var4 = this.f_8073
            && this.f_10919.m_2073(f_8084)
            && (var2 instanceof HandSwingC2SPacket || var2 instanceof PlayerInteractItemC2SPacket || var2 instanceof PlayerInteractBlockC2SPacket);
         if (!Util38.m_469() && !this.f_8073 || !var3 && !var4) {
            if (var2 instanceof CloseHandledScreenC2SPacket
               && (this.f_10919.m_2073(f_8087) || this.f_10919.m_2073(f_8088))
               && this.f_8070.isEmpty()
               && (Util38.m_469() || this.f_8073)) {
               var1.m_277(true);
            }
         } else {
            if (this.f_8072 == Util168.o6tQHpXpHIBkM7hF.SENDING) {
               return;
            }

            if (this.f_10919.m_2073(f_8085)) {
               switch (this.f_8072) {
                  case EXECUTING:
                     this.m_700(false);
                     break;
                  case NOTHING:
                     this.m_700(true);
                     this.f_8071 = ThreadLocalRandom.current().nextInt(55, 75);
                     this.f_8070.add(var1.m_3295());
               }
            } else {
               switch (this.f_8072) {
                  case EXECUTING:
                     this.f_8070.add(var1.m_3295());
                     this.m_700(false);
                     break;
                  case NOTHING:
                     this.f_8073 = true;
                     this.f_8070.add(var1.m_3295());
                     this.m_700(true);
                     this.f_8071 = f_8086;
               }
            }

            var1.m_277(true);
         }
      }

      if (var1.m_2068()
         && (this.f_10919.m_2073(f_8089) || this.f_10919.m_2073(f_8090))
         && var1.m_3295() instanceof CloseScreenS2CPacket var5
         && var5.getSyncId() == 0) {
         var1.m_277(true);
      }
   }

   public static enum o6tQHpXpHIBkM7hF {
      SENDING,
      EXECUTING,
      NOTHING;
   }
}
