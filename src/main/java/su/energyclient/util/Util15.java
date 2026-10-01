package su.energyclient.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import su.energyclient.QuickImports;

public class Util15 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public void m_205(int var1, int var2) {
      if (f_5909.player != null) {
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, var2, SlotActionType.SWAP, f_5909.player);
      }
   }

   public int m_625(Item var1) {
      if (f_5909.player == null) {
         return 0;
      } else {
         int var2 = 0;

         for (int var3 = 0; var3 < f_5909.player.getInventory().getMainStacks().size(); var3++) {
            ItemStack var4 = (ItemStack)f_5909.player.getInventory().getMainStacks().get(var3);
            if (var4.getItem() == var1) {
               var2 += var4.getCount();
            }
         }

         return var2;
      }
   }

   public int m_1865(int var1) {
      if (f_5909.player == null) {
         return var1 == 0 ? 1 : 0;
      } else {
         for (int var2 = 0; var2 < 9; var2++) {
            if (var2 != var1) {
               ItemStack var3 = f_5909.player.getInventory().getStack(var2);
               if (var3.isEmpty() || var3.getItem() == Items.OBSIDIAN) {
                  return var2;
               }
            }
         }

         for (int var4 = 0; var4 < 9; var4++) {
            if (var4 != var1) {
               return var4;
            }
         }

         return var1 == 0 ? 1 : 0;
      }
   }

   public int m_2233() {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var1 = 0; var1 < 36; var1++) {
            if (f_5909.player.getInventory().getStack(var1).isIn(ItemTags.PICKAXES)) {
               return var1;
            }
         }

         return -1;
      }
   }

   public void m_3891() {
      if (f_5909.player != null) {
         int var1 = 36 + f_5909.player.getInventory().getSelectedSlot();
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, 40, SlotActionType.SWAP, f_5909.player);
      }
   }

   public void m_2913(int var1) {
      this.m_2540(var1);
   }

   public void m_2540(int var1) {
      if (f_5909.player != null && var1 >= 0 && var1 <= 8) {
         f_5909.player.getInventory().setSelectedSlot(var1);
         f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var1));
      }
   }

   public int m_3452() {
      if (f_5909.player == null) {
         return -1;
      } else {
         int var1 = -1;

         for (Slot var3 : f_5909.player.currentScreenHandler.slots) {
            ItemStack var4 = var3.getStack();
            if (!var4.isEmpty() && var4.getItem() == Items.OBSIDIAN) {
               if (var1 == -1) {
                  var1 = var3.id;
               }

               if (var4.getCount() == var4.getMaxCount()) {
                  return var3.id;
               }
            }
         }

         return var1;
      }
   }

   public int m_2367(int var1) {
      return var1;
   }

   public int m_3382(Item var1) {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var2 = 0; var2 < 9; var2++) {
            if (f_5909.player.getInventory().getStack(var2).getItem() == var1) {
               return var2;
            }
         }

         return -1;
      }
   }
}
