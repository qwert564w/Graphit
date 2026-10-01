package su.energyclient.module.miscellaneous;

import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AirBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.RenameItemC2SPacket;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util125;
import su.energyclient.util.Util170;
import su.energyclient.util.Util54;

public class PotionCombiner extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_6993;
   private final BooleanSetting f_6994;
   private final NumberSetting f_6995;
   private final Util125 f_6996;
   private String f_6997;
   private boolean f_6998;
   private static final String f_6999 = "Potion Combiner";
   private static final String f_7000 = "Объединяет зелья силы/скорости в наковальне";
   private static final String f_7001 = "Зелье";
   private static final String f_7002 = "Силы";
   private static final String f_7003 = "Силы";
   private static final String f_7004 = "Скорости";
   private static final String f_7005 = "Авто опыт";
   private static final String f_7006 = "Порог опыта";
   private static final float f_7007 = 15.0F;
   private static final float f_7008 = 5.0F;
   private static final float f_7009 = 100.0F;
   private static final float f_7010 = 80.0F;
   private static final float f_7011 = 180.0F;
   private static final double f_7012 = 300.0;
   private static final float f_7013 = 180.0F;
   private static final double f_7014 = 100.0;
   private static final String f_7015 = "Силы";
   private static final String f_7016 = "Скорости";
   private static final double f_7017 = 300.0;
   private static final String f_7018 = "Силы";
   private static final String f_7019 = "Скорости";

   private void m_3333() {
      if (this.f_6996.m_2884(f_7014)) {
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, 2, 0, SlotActionType.QUICK_MOVE, f_5909.player);
         this.f_6996.m_3493();
         this.f_6997 = "";
      }
   }

   private boolean m_799(ItemStack var1) {
      if (var1.isEmpty()) {
         return false;
      } else if (!(var1.getItem() instanceof PotionItem)) {
         return false;
      } else {
         PotionContentsComponent var2 = (PotionContentsComponent)var1.get(DataComponentTypes.POTION_CONTENTS);
         if (var2 == null) {
            return false;
         } else {
            for (StatusEffectInstance var4 : var2.getEffects()) {
               if ((
                     this.f_6993.m_2073(f_7015) && var4.getEffectType().value() == StatusEffects.STRENGTH.value()
                        || this.f_6993.m_2073(f_7016) && var4.getEffectType().value() == StatusEffects.SPEED.value()
                  )
                  && var4.getAmplifier() == 1) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @Override
   public void m_1() {
      super.m_1();
      this.f_6998 = false;
      this.f_6997 = "";
      Util54.m_3501(null, f_7013, 5, 3);
   }

   public PotionCombiner() {
      super(f_6999, f_7000, Category.MISCELLANEOUS);
      this.f_6993 = new ModeSetting(f_7001, f_7002, f_7003, f_7004);
      this.f_6994 = new BooleanSetting(f_7005, false);
      this.f_6995 = new NumberSetting(f_7006, f_7007, f_7008, f_7009, 1.0F).m_356(this.f_6994::m_1163);
      this.f_6996 = new Util125();
      this.f_6997 = "";
   }

   private ItemStack m_520(int var1) {
      return ((Slot)f_5909.player.currentScreenHandler.slots.get(var1)).getStack();
   }

   private void m_1043() {
      if (f_5909.player != null && f_5909.interactionManager != null && f_5909.currentScreen instanceof AnvilScreen) {
         for (int var1 = 0; var1 < 2; var1++) {
            if (this.m_3119(var1) instanceof AirBlockItem && this.f_6996.m_2884(f_7017)) {
               this.m_3470(this.m_4132(), var1);
               this.f_6996.m_3493();
            }
         }
      }
   }

   private void m_3878() {
      this.f_6997 = this.f_6997 + "!";
      f_5909.player.networkHandler.sendPacket(new RenameItemC2SPacket(this.f_6997));
   }

   private Item m_3119(int var1) {
      return ((Slot)f_5909.player.currentScreenHandler.slots.get(var1)).getStack().getItem();
   }

   @EventHandler
   public void m_3697(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (this.f_6998) {
            Util54.m_3501(new Util10(f_5909.player.getYaw(), f_7010), f_7011, 5, 3);
         }

         if (f_5909.currentScreen instanceof AnvilScreen var2 && !this.f_6998) {
            this.m_1043();
            if (this.m_4099() && f_5909.player.experienceLevel >= 5) {
               if (((AnvilScreenHandler)var2.getScreenHandler()).getLevelCost() <= 5) {
                  this.m_3333();
               }

               this.m_3878();
            }
         }

         if (f_5909.player.experienceLevel < 5 && this.m_2386() != -1) {
            this.f_6998 = true;
         }

         if (this.f_6994.m_1163() && this.f_6998) {
            if (f_5909.currentScreen instanceof AnvilScreen) {
               this.m_2100();
            }

            if (f_5909.player.getMainHandStack().getItem() != Items.EXPERIENCE_BOTTLE) {
               int var4 = this.m_2386();
               if (var4 != -1 && var4 != f_5909.player.getInventory().getSelectedSlot() + 36) {
                  f_5909.interactionManager
                     .clickSlot(
                        f_5909.player.currentScreenHandler.syncId, var4, f_5909.player.getInventory().getSelectedSlot(), SlotActionType.SWAP, f_5909.player
                     );
               } else if (var4 == -1) {
                  this.f_6998 = false;
               }
            } else if (this.f_6996.m_2884(f_7012)) {
               f_5909.player.networkHandler.sendPacket(new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, f_5909.player.getYaw(), f_5909.player.getPitch()));
               this.f_6996.m_3493();
               if (f_5909.player.experienceLevel >= this.f_6995.m_4046()) {
                  this.f_6998 = false;
               }
            }
         }
      }
   }

   private void m_2100() {
      if (f_5909.currentScreen instanceof AnvilScreen) {
         f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(f_5909.player.currentScreenHandler.syncId));
         f_5909.setScreen(null);
      }
   }

   private int m_4132() {
      if (f_5909.player != null && f_5909.player.currentScreenHandler != null) {
         int var1 = f_5909.player.currentScreenHandler.slots.size();

         for (int var2 = 5; var2 < var1; var2++) {
            ItemStack var3 = ((Slot)f_5909.player.currentScreenHandler.slots.get(var2)).getStack();
            if (!var3.isEmpty() && var3.getItem() instanceof PotionItem) {
               PotionContentsComponent var4 = (PotionContentsComponent)var3.get(DataComponentTypes.POTION_CONTENTS);
               if (var4 != null) {
                  for (StatusEffectInstance var6 : var4.getEffects()) {
                     if ((
                           this.f_6993.m_2073(f_7018) && var6.getEffectType().value() == StatusEffects.STRENGTH.value()
                              || this.f_6993.m_2073(f_7019) && var6.getEffectType().value() == StatusEffects.SPEED.value()
                        )
                        && var6.getAmplifier() == 1) {
                        return var2;
                     }
                  }
               }
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   public void m_3470(int var1, int var2) {
      if (var1 >= 0 && var2 >= 0) {
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, 0, SlotActionType.PICKUP, f_5909.player);
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var2, 1, SlotActionType.PICKUP, f_5909.player);
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, 0, SlotActionType.PICKUP, f_5909.player);
      }
   }

   private int m_2386() {
      if (f_5909.player.getOffHandStack().getItem() == Items.EXPERIENCE_BOTTLE) {
         return 45;
      } else {
         for (int var1 = 0; var1 < f_5909.player.getInventory().getMainStacks().size(); var1++) {
            ItemStack var2 = (ItemStack)f_5909.player.getInventory().getMainStacks().get(var1);
            if (var2.getItem() == Items.EXPERIENCE_BOTTLE) {
               return var1 < 9 ? 36 + var1 : var1;
            }
         }

         return -1;
      }
   }

   private boolean m_4099() {
      return this.m_799(this.m_520(0)) && this.m_799(this.m_520(1));
   }
}
