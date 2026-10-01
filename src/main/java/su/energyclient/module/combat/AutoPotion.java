package su.energyclient.module.combat;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util101;
import su.energyclient.util.Util170;
import su.energyclient.util.Util38;
import su.energyclient.util.Util54;
import su.energyclient.util.Util63;

public class AutoPotion extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_595;
   private final BooleanSetting f_596;
   private final BooleanSetting f_597;
   private final Util63 f_598;
   private static final String f_599 = "Auto Potion";
   private static final String f_600 = "Автоматически использует зелья, бросая их под себя";
   private static final String f_601 = "Только при пвп";
   private static final String f_602 = "Только с хотбара";
   private static final String f_603 = "Бросать";
   private static final String f_604 = "Скорость";
   private static final String f_605 = "Сила";
   private static final String f_606 = "Огнестойкость";
   private static final String f_607 = "Скорость";
   private static final String f_608 = "Сила";
   private static final String f_609 = "Огнестойкость";
   private static final float f_610 = 0.5F;
   private static final float f_611 = 90.0F;
   private static final float f_612 = 360.0F;

   public AutoPotion() {
      super(f_599, f_600, Category.COMBAT);
      this.f_596 = new BooleanSetting(f_601, true);
      this.f_597 = new BooleanSetting(f_602, false);
      this.f_598 = new Util63(f_603, new BooleanSetting(f_604, true), new BooleanSetting(f_605, true), new BooleanSetting(f_606, true));
   }

   private void m_1370(List<Integer> var1, boolean var2, RegistryEntry<StatusEffect> var3) {
      if (var2) {
         if (!f_5909.player.hasStatusEffect(var3)) {
            int var4 = this.m_1114(true, var3);
            if (var4 != -1) {
               var1.add(var4);
            } else if (!this.f_597.m_1163()) {
               int var5 = this.m_1114(false, var3);
               if (var5 != -1) {
                  var1.add(var5);
               }
            }
         }
      }
   }

   private boolean m_2928(ItemStack var1, RegistryEntry<StatusEffect> var2) {
      if (var1 != null && !var1.isEmpty() && var1.getItem() == Items.SPLASH_POTION) {
         PotionContentsComponent var3 = (PotionContentsComponent)var1.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);

         for (StatusEffectInstance var5 : var3.getEffects()) {
            if (var5.getEffectType().equals(var2)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_595 = 20;
   }

   @EventHandler
   private void m_350(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
         if (f_5909.player.isOnGround()) {
            this.f_595++;
            ArrayList<Integer> var2 = new ArrayList<>();
            this.m_1370(var2, this.f_598.I(f_607), StatusEffects.SPEED);
            this.m_1370(var2, this.f_598.I(f_608), StatusEffects.STRENGTH);
            this.m_1370(var2, this.f_598.I(f_609), StatusEffects.FIRE_RESISTANCE);
            if ((!this.f_596.m_1163() || Util101.m_2329()) && this.f_595 >= 20 && !Util38.I(f_610) && !var2.isEmpty()) {
               Util54.m_3501(new Util10(f_5909.player.getYaw(), f_611), f_612, 1, 10);
               int var3 = f_5909.player.getInventory().getSelectedSlot();

               for (Integer var5 : var2) {
                  if (var5 < 9) {
                     f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var5));
                     f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
                  } else {
                     f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var5, var3, SlotActionType.SWAP, f_5909.player);
                     f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
                     f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var5, var3, SlotActionType.SWAP, f_5909.player);
                  }
               }

               f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var3));
               this.f_595 = 0;
            }
         }
      }
   }

   private int m_1114(boolean var1, RegistryEntry<StatusEffect> var2) {
      if (f_5909.player == null) {
         return -1;
      } else {
         int var3 = var1 ? 0 : 9;
         int var4 = var1 ? 9 : 36;

         for (int var5 = var3; var5 < var4; var5++) {
            ItemStack var6 = f_5909.player.getInventory().getStack(var5);
            if (this.m_2928(var6, var2)) {
               return var5;
            }
         }

         return -1;
      }
   }
}
