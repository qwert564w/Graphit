package su.energyclient.module.player;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.movement.AutoSprint;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util121;
import su.energyclient.util.Util125;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;
import su.energyclient.util.Util38;

public class ClickPearl extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final long f_8325 = 100L;
   private final RenderUtil22 f_8326;
   private final BooleanSetting f_8327;
   private final BooleanSetting f_8328;
   private final int[] f_8329;
   private final Util125 f_8330;
   private ClickPearl.KYaiQI9aNhoHvCcP f_8331;
   private ClickPearl.pQr2tty33gZVnz9K f_8332;
   private int f_8333;
   private boolean f_8334;
   private long f_8335;
   private static final String f_8336 = "Click Pearl";
   private static final String f_8337 = "Кидает перку при нажатии СКМ.";
   private static final String f_8338 = "Бинд";
   private static final String f_8339 = "Легитность";
   private static final String f_8340 = "Обход для HW";
   private static final long f_8341 = 100L;
   private static final String f_8342 = "ReallyWorld";

   @EventHandler
   public void m_2119(CancellableEvent var1) {
      if (!var1.m_3546()) {
         boolean var2 = var1.m_2169() == this.f_8326.m_1958();
         if (var2) {
            if (this.f_8327.m_1163()) {
               int var3 = Util146.m_1302(Items.ENDER_PEARL);
               if (var3 != -1 && !f_5909.player.getItemCooldownManager().isCoolingDown(f_5909.player.getInventory().getStack(var3))) {
                  boolean var4 = f_5909.player.getInventory().getSelectedSlot() == var3;
                  if (!var4) {
                     this.f_8329[0] = this.f_8327.m_1163() ? ThreadLocalRandom.current().nextInt(110, 210) : 1;
                     this.f_8329[1] = this.f_8327.m_1163() ? ThreadLocalRandom.current().nextInt(110, 210) : 1;
                     this.f_8333 = var3;
                     this.f_8331 = ClickPearl.KYaiQI9aNhoHvCcP.PICKUP;
                     this.f_8332 = var3 < 9 ? ClickPearl.pQr2tty33gZVnz9K.HOTBAR : ClickPearl.pQr2tty33gZVnz9K.INVENTORY;
                  } else {
                     f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
                  }
               }
            } else {
               if (this.f_8334) {
                  return;
               }

               if (this.m_3630()) {
                  this.f_8334 = true;
                  this.f_8335 = System.currentTimeMillis();
                  this.m_2590();
               } else {
                  Util146.m_2425(Items.ENDER_PEARL);
               }
            }
         }
      }
   }

   private void m_2136() {
      this.f_8334 = false;
      this.f_8335 = 0L;
      AutoSprint.m_1519(true);
   }

   public ClickPearl() {
      super(f_8336, f_8337, Category.PLAYER);
      this.f_8326 = new RenderUtil22(f_8338, -1);
      this.f_8327 = new BooleanSetting(f_8339, false);
      this.f_8328 = new BooleanSetting(f_8340, false).m_334(this.f_8327::m_1163);
      this.f_8329 = new int[2];
      this.f_8330 = new Util125();
      this.f_8331 = ClickPearl.KYaiQI9aNhoHvCcP.NOTHING;
      this.f_8332 = null;
   }

   private void m_2590() {
      AutoSprint.m_1519(false);
      f_5909.player.setSprinting(false);
      f_5909.options.jumpKey.setPressed(false);
      f_5909.options.forwardKey.setPressed(false);
      f_5909.options.backKey.setPressed(false);
      f_5909.options.leftKey.setPressed(false);
      f_5909.options.rightKey.setPressed(false);
      f_5909.options.sprintKey.setPressed(false);
   }

   @EventHandler
   public void m_2629(Util121 var1) {
      if (this.f_8334) {
         var1.m_433(0.0F);
         var1.m_2791(0.0F);
      }
   }

   @Override
   public void m_1() {
      super.m_1();
      this.m_1556();
      this.m_2136();
   }

   @EventHandler
   public void m_958(Util170 var1) {
      if (this.f_8331 != ClickPearl.KYaiQI9aNhoHvCcP.NOTHING && this.f_8332 != null && this.f_8333 != -1) {
         boolean var2 = this.f_8332 == ClickPearl.pQr2tty33gZVnz9K.HOTBAR;
         Hand var3 = var2 ? Hand.MAIN_HAND : Hand.OFF_HAND;
         switch (this.f_8331) {
            case PICKUP:
               if (var2) {
                  f_5909.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(this.f_8333));
               } else {
                  f_5909.interactionManager.clickSlot(0, this.f_8333, 40, SlotActionType.SWAP, f_5909.player);
               }

               this.f_8331 = ClickPearl.KYaiQI9aNhoHvCcP.USE;
               break;
            case BACK:
               if (this.f_8330.m_2636(this.f_8329[1])) {
                  if (var2) {
                     f_5909.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(f_5909.player.getInventory().getSelectedSlot()));
                  } else {
                     f_5909.interactionManager.clickSlot(0, this.f_8333, 40, SlotActionType.SWAP, f_5909.player);
                     if (this.f_8328.m_1163()) {
                        f_5909.getNetworkHandler().sendPacket(new CloseHandledScreenC2SPacket(0));
                     }
                  }

                  this.m_1556();
               }
               break;
            case USE:
               if (this.f_8330.m_2636(this.f_8329[0])) {
                  f_5909.interactionManager.interactItem(f_5909.player, var3);
                  f_5909.player.swingHand(var3);
                  this.f_8331 = ClickPearl.KYaiQI9aNhoHvCcP.BACK;
               }
         }
      }

      if (this.f_8334) {
         if (f_5909.player == null || f_5909.world == null || f_5909.interactionManager == null) {
            this.m_2136();
            return;
         }

         this.m_2590();
         if (System.currentTimeMillis() - this.f_8335 >= f_8341) {
            this.f_8334 = false;
            this.f_8335 = 0L;
            Util146.m_2425(Items.ENDER_PEARL);
            AutoSprint.m_1519(true);
         }
      }
   }

   private void m_1556() {
      this.f_8332 = null;
      this.f_8331 = ClickPearl.KYaiQI9aNhoHvCcP.NOTHING;
      this.f_8333 = -1;
      this.f_8330.m_3493();
   }

   private boolean m_3630() {
      if (InitManager.f_2740.f_2741.guiMove.m_512().m_2073(f_8342) && Util38.m_469()) {
         if (!f_5909.player.getMainHandStack().isOf(Items.ENDER_PEARL) && !f_5909.player.getOffHandStack().isOf(Items.ENDER_PEARL)) {
            int var1 = Util146.m_1914(Items.ENDER_PEARL);
            return var1 >= 9 || var1 >= 0 && f_5909.player.isUsingItem();
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   static enum KYaiQI9aNhoHvCcP {
      NOTHING,
      PICKUP,
      BACK,
      USE;
   }

   static enum pQr2tty33gZVnz9K {
      INVENTORY,
      HOTBAR;
   }
}
