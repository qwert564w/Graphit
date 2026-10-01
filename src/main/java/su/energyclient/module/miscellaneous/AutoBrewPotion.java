package su.energyclient.module.miscellaneous;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.AirBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.BrewingStandScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Identifier;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util125;
import su.energyclient.util.Util152;
import su.energyclient.util.Util170;

public class AutoBrewPotion extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_5064;
   private final NumberSetting f_5065;
   private final BooleanSetting f_5066;
   private final BooleanSetting f_5067;
   private final Util125 f_5068;
   private static final String f_5069 = "Auto Brew Potion";
   private static final String f_5070 = "Автоматическая варка зелий в варочной стойке";
   private static final String f_5071 = "Зелье";
   private static final String f_5072 = "Скорка";
   private static final String f_5073 = "Скорка";
   private static final String f_5074 = "Силка";
   private static final String f_5075 = "Огнестойка";
   private static final String f_5076 = "Задержка";
   private static final float f_5077 = 100.0F;
   private static final float f_5078 = 100.0F;
   private static final float f_5079 = 1000.0F;
   private static final float f_5080 = 10.0F;
   private static final String f_5081 = "Забирать";
   private static final String f_5082 = "Добавлять порох";
   private static final String f_5083 = "Нет огненного порошка для заправки!";
   private static final String f_5084 = "water";
   private static final String f_5085 = "Нет бутылок с водой!";
   private static final float f_5086 = 3.0F;
   private static final String f_5087 = "water";
   private static final String f_5088 = "Нет нароста!";
   private static final String f_5089 = "Скорка";
   private static final String f_5090 = "awkward";
   private static final String f_5091 = "Нет сахара для зелья скорости!";
   private static final String f_5092 = "Силка";
   private static final String f_5093 = "awkward";
   private static final String f_5094 = "Нет огненного порошка для зелья силы!";
   private static final String f_5095 = "Огнестойка";
   private static final String f_5096 = "awkward";
   private static final String f_5097 = "Нет слизи магмы для зелья огнестойкости!";
   private static final String f_5098 = "strength";
   private static final String f_5099 = "swiftness";
   private static final String f_5100 = "Нет светокамня для усиления зелья!";
   private static final String f_5101 = "fire_resistance";
   private static final String f_5102 = "Нет редстоуна для увеличения длительности зелья!";
   private static final String f_5103 = "strong_strength";
   private static final String f_5104 = "strong_swiftness";
   private static final String f_5105 = "long_fire_resistance";
   private static final String f_5106 = "Нет пороха для создания взрывных зелий!";

   public void m_1836(Item var1, int var2) {
      int var3;
      if (this.f_5068.m_2884(this.f_5065.m_4046() * 2.0F) && (var3 = this.m_1538(var1)) != -1) {
         this.m_3265(var3, var2);
         this.f_5068.m_3493();
      }
   }

   private boolean m_825() {
      boolean var1 = true;

      for (int var2 = 0; var2 < 3; var2++) {
         if (((Slot)f_5909.player.currentScreenHandler.slots.get(var2)).getStack().getItem() != Items.SPLASH_POTION) {
            var1 = false;
         }
      }

      return var1;
   }

   public AutoBrewPotion() {
      super(f_5069, f_5070, Category.MISCELLANEOUS);
      this.f_5064 = new ModeSetting(f_5071, f_5072, f_5073, f_5074, f_5075);
      this.f_5065 = new NumberSetting(f_5076, f_5077, f_5078, f_5079, f_5080);
      this.f_5066 = new BooleanSetting(f_5081, true);
      this.f_5067 = new BooleanSetting(f_5082, false);
      this.f_5068 = new Util125();
   }

   private int m_1538(Item var1) {
      for (int var2 = 5; var2 < 41; var2++) {
         if (this.m_3040(var2) == var1) {
            return var2;
         }
      }

      return -1;
   }

   public void m_3265(int var1, int var2) {
      if (var1 >= 0 && var2 >= 0) {
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, 0, SlotActionType.PICKUP, f_5909.player);
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var2, 1, SlotActionType.PICKUP, f_5909.player);
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, 0, SlotActionType.PICKUP, f_5909.player);
      }
   }

   private Item m_3040(int var1) {
      return ((Slot)f_5909.player.currentScreenHandler.slots.get(var1)).getStack().getItem();
   }

   @EventHandler
   public void m_2731(Util170 var1) {
      if (f_5909.player != null && f_5909.player.currentScreenHandler instanceof BrewingStandScreenHandler) {
         if (this.m_3349()) {
            if (this.m_1538(Items.BLAZE_POWDER) == -1) {
               Util152.m_662(f_5083);
               this.m_680();
            }

            this.m_1836(Items.BLAZE_POWDER, 4);
         }

         for (int var2 = 0; var2 < 3; var2++) {
            if (this.m_3040(var2) instanceof AirBlockItem) {
               int var3 = this.m_3419(f_5084);
               if (var3 == -1) {
                  this.m_680();
                  Util152.m_662(f_5085);
               }

               if (this.f_5068.m_2884(this.f_5065.m_4046() * f_5086)) {
                  this.m_3265(var3, var2);
                  this.f_5068.m_3493();
               }
            }
         }

         if (this.m_3040(3) instanceof AirBlockItem) {
            if (this.m_3430(f_5087)) {
               if (this.m_1538(Items.NETHER_WART) == -1) {
                  this.m_680();
                  Util152.m_662(f_5088);
               }

               this.m_1836(Items.NETHER_WART, 3);
            }

            if (this.f_5064.m_2073(f_5089)) {
               if (this.m_3430(f_5090)) {
                  if (this.m_1538(Items.SUGAR) == -1) {
                     Util152.m_662(f_5091);
                     this.m_680();
                  }

                  this.m_1836(Items.SUGAR, 3);
               }
            } else if (this.f_5064.m_2073(f_5092)) {
               if (this.m_3430(f_5093)) {
                  if (this.m_1538(Items.BLAZE_POWDER) == -1) {
                     Util152.m_662(f_5094);
                     this.m_680();
                  }

                  this.m_1836(Items.BLAZE_POWDER, 3);
               }
            } else if (this.f_5064.m_2073(f_5095) && this.m_3430(f_5096)) {
               if (this.m_1538(Items.MAGMA_CREAM) == -1) {
                  Util152.m_662(f_5097);
                  this.m_680();
               }

               this.m_1836(Items.MAGMA_CREAM, 3);
            }

            if (this.m_3430(f_5098) || this.m_3430(f_5099)) {
               if (this.m_1538(Items.GLOWSTONE_DUST) == -1) {
                  Util152.m_662(f_5100);
                  this.m_680();
               }

               this.m_1836(Items.GLOWSTONE_DUST, 3);
            }

            if (this.m_3430(f_5101)) {
               if (this.m_1538(Items.REDSTONE) == -1) {
                  Util152.m_662(f_5102);
                  this.m_680();
               }

               this.m_1836(Items.REDSTONE, 3);
            }

            if (this.m_3430(f_5103) || this.m_3430(f_5104) || this.m_3430(f_5105)) {
               if (this.f_5067.m_1163()) {
                  if (this.m_1538(Items.GUNPOWDER) == -1) {
                     Util152.m_662(f_5106);
                     this.m_680();
                  }

                  if (this.m_825()) {
                     if (this.f_5066.m_1163()) {
                        this.m_1426();
                     }
                  } else {
                     this.m_1836(Items.GUNPOWDER, 3);
                  }
               } else if (this.f_5066.m_1163()) {
                  this.m_1426();
               }
            }
         }
      }
   }

   private boolean m_3349() {
      return this.m_3040(4) instanceof AirBlockItem;
   }

   private void m_1426() {
      for (int var1 = 0; var1 < 3; var1++) {
         if (this.f_5068.m_2884(this.f_5065.m_4046() * 2.0F)) {
            f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, 0, SlotActionType.QUICK_MOVE, f_5909.player);
         }
      }
   }

   private int m_3419(String var1) {
      Potion var2 = (Potion)Registries.POTION.get(Identifier.ofVanilla(var1));
      if (var2 == null) {
         return -1;
      } else {
         for (int var3 = 5; var3 < 41; var3++) {
            ItemStack var4 = ((Slot)f_5909.player.currentScreenHandler.slots.get(var3)).getStack();
            if (!var4.isEmpty()) {
               PotionContentsComponent var5 = (PotionContentsComponent)var4.get(DataComponentTypes.POTION_CONTENTS);
               if (var5 != null && var5.potion().isPresent()) {
                  Potion var6 = (Potion)((RegistryEntry)var5.potion().get()).value();
                  if (var6.equals(var2)) {
                     return var3;
                  }
               }
            }
         }

         return -1;
      }
   }

   private boolean m_3430(String var1) {
      Potion var2 = (Potion)Registries.POTION.get(Identifier.ofVanilla(var1));
      if (var2 == null) {
         return false;
      } else {
         for (int var3 = 0; var3 < 3; var3++) {
            ItemStack var4 = ((Slot)f_5909.player.currentScreenHandler.slots.get(var3)).getStack();
            if (var4.isEmpty()) {
               return false;
            }

            PotionContentsComponent var5 = (PotionContentsComponent)var4.get(DataComponentTypes.POTION_CONTENTS);
            if (var5 == null || var5.potion().isEmpty()) {
               return false;
            }

            Potion var6 = (Potion)((RegistryEntry)var5.potion().get()).value();
            if (!var6.equals(var2)) {
               return false;
            }
         }

         return true;
      }
   }
}
