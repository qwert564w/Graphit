package su.energyclient.module.miscellaneous;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util125;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;

public class HolyworldHelper extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final RenderUtil22 f_12106;
   private final RenderUtil22 f_12107;
   private final RenderUtil22 f_12108;
   private final RenderUtil22 f_12109;
   private final BooleanSetting f_12110;
   private final BooleanSetting f_12111;
   private final int[] f_12112;
   private final Util125 f_12113;
   private HolyworldHelper.IulX8bZUo7s9IZlf f_12114;
   private HolyworldHelper.MuoG7mmByJro2PWr f_12115;
   private int f_12116;
   private int f_12117;
   private static final String f_12118 = "HolyWorld Helper";
   private static final String f_12119 = "Помощник для быстрого использования предметов на HolyWorld";
   private static final String f_12120 = "Исп трапку";
   private static final String f_12121 = "Исп снежок";
   private static final String f_12122 = "Исп прощальный гул";
   private static final String f_12123 = "Исп стан";
   private static final String f_12124 = "Легитность";
   private static final String f_12125 = "Обход";

   @EventHandler
   public void m_104(Util170 var1) {
      if (this.f_12114 != HolyworldHelper.IulX8bZUo7s9IZlf.NOTHING && this.f_12115 != null && this.f_12116 != -1) {
         boolean var2 = this.f_12115 == HolyworldHelper.MuoG7mmByJro2PWr.HOTBAR;
         Hand var3 = var2 ? Hand.MAIN_HAND : Hand.OFF_HAND;
         switch (this.f_12114) {
            case PICKUP:
               if (var2) {
                  f_5909.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(this.f_12116));
                  f_5909.player.getInventory().setSelectedSlot(this.f_12116);
               } else {
                  f_5909.interactionManager.clickSlot(0, this.m_2834(this.f_12116), 40, SlotActionType.SWAP, f_5909.player);
               }

               this.f_12114 = HolyworldHelper.IulX8bZUo7s9IZlf.USE;
               break;
            case BACK:
               if (this.f_12113.m_2636(this.f_12112[1])) {
                  if (var2) {
                     int var4 = this.f_12117 == -1 ? f_5909.player.getInventory().getSelectedSlot() : this.f_12117;
                     f_5909.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(var4));
                     f_5909.player.getInventory().setSelectedSlot(var4);
                  } else {
                     f_5909.interactionManager.clickSlot(0, this.m_2834(this.f_12116), 40, SlotActionType.SWAP, f_5909.player);
                     if (this.f_12111.m_1163()) {
                        f_5909.getNetworkHandler().sendPacket(new CloseHandledScreenC2SPacket(0));
                     }
                  }

                  this.m_3429();
               }
               break;
            case USE:
               if (this.f_12113.m_2636(this.f_12112[0])) {
                  f_5909.interactionManager.interactItem(f_5909.player, var3);
                  f_5909.player.swingHand(var3);
                  this.f_12114 = HolyworldHelper.IulX8bZUo7s9IZlf.BACK;
               }
         }
      }
   }

   public HolyworldHelper() {
      super(f_12118, f_12119, Category.MISCELLANEOUS);
      this.f_12106 = new RenderUtil22(f_12120, -1);
      this.f_12107 = new RenderUtil22(f_12121, -1);
      this.f_12108 = new RenderUtil22(f_12122, -1);
      this.f_12109 = new RenderUtil22(f_12123, -1);
      this.f_12110 = new BooleanSetting(f_12124, false);
      this.f_12111 = new BooleanSetting(f_12125, false).m_334(this.f_12110::m_1163);
      this.f_12112 = new int[2];
      this.f_12113 = new Util125();
      this.f_12114 = HolyworldHelper.IulX8bZUo7s9IZlf.NOTHING;
      this.f_12115 = null;
      this.f_12116 = -1;
      this.f_12117 = -1;
   }

   @EventHandler
   public void m_2463(CancellableEvent var1) {
      if (!var1.m_3546() && var1.m_1362()) {
         if (var1.m_2169() == this.f_12106.m_1958()) {
            this.m_1367(Items.PRISMARINE_SHARD);
         } else if (var1.m_2169() == this.f_12107.m_1958()) {
            this.m_1367(Items.SNOWBALL);
         } else if (var1.m_2169() == this.f_12108.m_1958()) {
            this.m_1367(Items.FIREWORK_STAR);
         } else if (var1.m_2169() == this.f_12109.m_1958()) {
            this.m_1367(Items.NETHER_STAR);
         }
      }
   }

   private void m_3429() {
      this.f_12115 = null;
      this.f_12114 = HolyworldHelper.IulX8bZUo7s9IZlf.NOTHING;
      this.f_12116 = -1;
      this.f_12117 = -1;
      this.f_12113.m_3493();
   }

   private void m_1367(Item var1) {
      if (!this.f_12110.m_1163()) {
         Util146.m_1314(var1);
      } else {
         int var2 = this.m_1838(var1);
         if (var2 != -1) {
            if (!f_5909.player.getItemCooldownManager().isCoolingDown(var1.getDefaultStack())) {
               boolean var3 = var2 < 9 && f_5909.player.getInventory().getSelectedSlot() == var2;
               if (var3) {
                  f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
               } else {
                  this.f_12112[0] = ThreadLocalRandom.current().nextInt(110, 210);
                  this.f_12112[1] = ThreadLocalRandom.current().nextInt(110, 210);
                  this.f_12117 = f_5909.player.getInventory().getSelectedSlot();
                  this.f_12116 = var2;
                  this.f_12114 = HolyworldHelper.IulX8bZUo7s9IZlf.PICKUP;
                  this.f_12115 = var2 < 9 ? HolyworldHelper.MuoG7mmByJro2PWr.HOTBAR : HolyworldHelper.MuoG7mmByJro2PWr.INVENTORY;
               }
            }
         }
      }
   }

   @Override
   public void m_1() {
      super.m_1();
      this.m_3429();
   }

   private int m_2834(int var1) {
      return var1 < 9 ? var1 + 36 : var1;
   }

   private int m_1838(Item var1) {
      for (int var2 = 0; var2 < 36; var2++) {
         if (f_5909.player.getInventory().getStack(var2).isOf(var1)) {
            return var2;
         }
      }

      return -1;
   }

   private static enum IulX8bZUo7s9IZlf {
      NOTHING,
      PICKUP,
      BACK,
      USE;
   }

   private static enum MuoG7mmByJro2PWr {
      INVENTORY,
      HOTBAR;
   }
}
