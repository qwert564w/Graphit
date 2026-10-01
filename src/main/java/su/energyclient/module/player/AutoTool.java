package su.energyclient.module.player;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util146;
import su.energyclient.util.Util92;

public class AutoTool extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_5022 = -1;
   private int f_5023 = -1;
   private boolean f_5024;
   private static final String f_5025 = "Auto Tool";
   private static final String f_5026 = "Automatically uses the best tool";

   private int m_496(int var1) {
      return var1 < 9 ? var1 + 36 : var1;
   }

   public AutoTool() {
      super(f_5025, f_5026, Category.PLAYER);
   }

   private void m_1589(BlockState var1) {
      if (var1 != null && !var1.isAir()) {
         int var2 = this.m_2714(var1);
         if (var2 != -1) {
            if (!this.f_5024) {
               this.f_5022 = f_5909.player.getInventory().getSelectedSlot();
               this.f_5024 = true;
            }

            if (var2 < 9) {
               this.f_5023 = -1;
               f_5909.player.getInventory().setSelectedSlot(var2);
            } else {
               int var3 = this.m_496(var2);
               f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var3, this.f_5022, SlotActionType.SWAP, f_5909.player);
               this.f_5023 = var2;
               f_5909.player.getInventory().setSelectedSlot(this.f_5022);
            }
         }
      }
   }

   @EventHandler
   public void m_324(Util92 var1) {
      if (f_5909.player != null && f_5909.interactionManager != null && !f_5909.player.isCreative()) {
         if (var1.m_3685() == Util92.eYP5T39eaGw7jwf1.START_DESTROY_BLOCK) {
            this.m_1589(var1.m_1818());
         } else if (var1.m_3685() == Util92.eYP5T39eaGw7jwf1.STOP_DESTROY_BLOCK) {
            this.m_2217();
         }
      }
   }

   @Override
   public void m_1() {
      this.m_2217();
      super.m_1();
   }

   private void m_2217() {
      if (f_5909.player != null && f_5909.interactionManager != null && this.f_5024) {
         if (this.f_5023 >= 9 && this.f_5022 >= 0 && this.f_5022 <= 8) {
            int var1 = this.m_496(this.f_5023);
            f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, this.f_5022, SlotActionType.SWAP, f_5909.player);
         }

         if (this.f_5022 >= 0 && this.f_5022 <= 8) {
            f_5909.player.getInventory().setSelectedSlot(this.f_5022);
         }

         this.f_5022 = -1;
         this.f_5023 = -1;
         this.f_5024 = false;
      }
   }

   private int m_2714(BlockState var1) {
      if (var1.isOf(Blocks.COBWEB)) {
         int var2 = this.m_559(Items.SHEARS);
         if (var2 != -1) {
            return var2;
         }
      }

      int var7 = -1;
      float var3 = 1.0F;

      for (int var4 = 0; var4 < 9; var4++) {
         ItemStack var5 = f_5909.player.getInventory().getStack(var4);
         if (!var5.isEmpty()) {
            float var6 = Util146.m_141(var1, var5);
            if (var6 > var3) {
               var3 = var6;
               var7 = var4;
            }
         }
      }

      return var7;
   }

   private int m_559(Item var1) {
      for (int var2 = 0; var2 < 9; var2++) {
         ItemStack var3 = f_5909.player.getInventory().getStack(var2);
         if (!var3.isEmpty() && var3.getItem() == var1) {
            return var2;
         }
      }

      return -1;
   }
}
