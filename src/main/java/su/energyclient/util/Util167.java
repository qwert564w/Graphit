package su.energyclient.util;

import java.util.function.Predicate;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import su.energyclient.QuickImports;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;

public final class Util167 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_8065 = 6;
   private ClientPlayerEntity f_8066;
   private ItemStack l;
   private ItemStack f_8067;
   private boolean f_8068;

   private static int m_879(Predicate<ItemStack> var0) {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var1 = 0; var1 < 36; var1++) {
            if (var0.test(f_5909.player.getInventory().getStack(var1))) {
               return var1;
            }
         }

         return -1;
      }
   }

   private boolean m_2344() {
      if (this.l != null && this.f_8066 == f_5909.player && !this.f_8068) {
         if (!m_551(m_1775(), this.f_8067)) {
            this.f_8068 = true;
            return false;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean m_2142() {
      return f_5909.player != null && (m_913(m_1775()) || m_879(Util167::m_913) >= 0);
   }

   public static int m_1987(Predicate<ItemStack> var0) {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var1 = 0; var1 < 9; var1++) {
            ItemStack var2 = f_5909.player.getInventory().getStack(var1);
            if (!var2.isEmpty() && var0.test(var2)) {
               return var1;
            }
         }

         return -1;
      }
   }

   private boolean m_207(int var1) {
      if (m_1348() && this.m_2344()) {
         PlayerScreenHandler var2 = f_5909.player.playerScreenHandler;
         Slot var3 = var2.getSlot(6);
         int var4 = var1 < 9 ? var1 + 36 : var1;
         Slot var5 = var2.getSlot(var4);
         ItemStack var6 = var5.getStack().copy();
         if (var3.canTakeItems(f_5909.player)
            && var5.canTakeItems(f_5909.player)
            && (var6.isEmpty() || var3.canInsert(var6) && var6.getCount() == 1)
            && (m_1775().isEmpty() || var5.canInsert(m_1775()))) {
            if (var1 < 9) {
               f_5909.interactionManager.clickSlot(var2.syncId, 6, var1, SlotActionType.SWAP, f_5909.player);
            } else {
               f_5909.interactionManager.clickSlot(var2.syncId, var4, 0, SlotActionType.PICKUP, f_5909.player);
               f_5909.interactionManager.clickSlot(var2.syncId, 6, 0, SlotActionType.PICKUP, f_5909.player);
               f_5909.interactionManager.clickSlot(var2.syncId, var4, 0, SlotActionType.PICKUP, f_5909.player);
            }

            if (var2.getCursorStack().isEmpty() && m_551(m_1775(), var6)) {
               this.f_8067 = m_1775().copy();
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean m_226() {
      return this.m_1977(Util167::m_913);
   }

   public void m_1293() {
      if (this.l == null && f_5909.player != null) {
         this.f_8066 = f_5909.player;
         this.l = m_1775().copy();
         this.f_8067 = this.l.copy();
         this.f_8068 = false;
      }
   }

   private static boolean m_551(ItemStack var0, ItemStack var1) {
      if (!var0.isEmpty() && !var1.isEmpty()) {
         if (var0.isOf(var1.getItem()) && var0.getCount() == var1.getCount()) {
            ItemStack var2 = var0.copy();
            ItemStack var3 = var1.copy();
            var2.remove(DataComponentTypes.DAMAGE);
            var3.remove(DataComponentTypes.DAMAGE);
            return ItemStack.areItemsAndComponentsEqual(var2, var3);
         } else {
            return false;
         }
      } else {
         return var0.isEmpty() && var1.isEmpty();
      }
   }

   public void m_922() {
      this.f_8066 = null;
      this.l = null;
      this.f_8067 = null;
      this.f_8068 = false;
   }

   public static int m_474(Item var0) {
      return m_1987(var1 -> var1.isOf(var0));
   }

   private static ItemStack m_1775() {
      return f_5909.player.getEquippedStack(EquipmentSlot.CHEST);
   }

   private static boolean m_913(ItemStack var0) {
      return !var0.isEmpty() && var0.isIn(ItemTags.CHEST_ARMOR) && f_5909.player.canEquip(var0, EquipmentSlot.CHEST);
   }

   public boolean m_3184() {
      return this.m_1977(Util167::m_171);
   }

   private boolean m_1977(Predicate<ItemStack> var1) {
      if (!this.m_2344() || !m_1348()) {
         return false;
      } else if (var1.test(m_1775())) {
         return true;
      } else {
         int var2 = var1.test(this.l) ? m_879(var1x -> m_551(var1x, this.l)) : -1;
         if (var2 < 0) {
            var2 = m_879(var1);
         }

         return var2 >= 0 && this.m_207(var2) && var1.test(m_1775());
      }
   }

   public static boolean m_3423(int var0) {
      if (m_3468() && var0 >= 0 && var0 < 9) {
         f_5909.player.getInventory().setSelectedSlot(var0);
         ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
         return true;
      } else {
         return false;
      }
   }

   public boolean m_1922() {
      return f_5909.player != null && (m_171(m_1775()) || m_879(Util167::m_171) >= 0);
   }

   public boolean m_743() {
      if (this.l == null) {
         return true;
      } else if (!this.m_2344()) {
         this.m_922();
         return true;
      } else if (m_551(m_1775(), this.l)) {
         this.m_922();
         return true;
      } else if (!m_1348()) {
         return false;
      } else {
         int var1 = m_879(var1x -> m_551(var1x, this.l));
         if (var1 < 0 && !this.l.isEmpty()) {
            this.m_922();
            return true;
         } else if (var1 >= 0 && this.m_207(var1)) {
            if (!m_551(m_1775(), this.l)) {
               return false;
            } else {
               this.m_922();
               return true;
            }
         } else {
            return false;
         }
      }
   }

   public static boolean m_2330(Item var0) {
      return f_5909.player != null && (!f_5909.player.getOffHandStack().isEmpty() && f_5909.player.getOffHandStack().isOf(var0) || m_474(var0) >= 0);
   }

   private static boolean m_3468() {
      return f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null;
   }

   private static boolean m_1348() {
      return m_3468()
         && f_5909.currentScreen == null
         && f_5909.player.currentScreenHandler == f_5909.player.playerScreenHandler
         && f_5909.player.playerScreenHandler.getCursorStack().isEmpty();
   }

   private static boolean m_171(ItemStack var0) {
      return !var0.isEmpty() && f_5909.player.canEquip(var0, EquipmentSlot.CHEST) && LivingEntity.canGlideWith(var0, EquipmentSlot.CHEST);
   }

   public static boolean m_2327(Item var0) {
      if (m_1348() && !f_5909.player.isUsingItem()) {
         ItemStack var1 = f_5909.player.getOffHandStack();
         if (!var1.isEmpty() && var1.isOf(var0) && !f_5909.player.getItemCooldownManager().isCoolingDown(var1)) {
            return f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND).isAccepted();
         } else {
            int var2 = m_1987(var1x -> var1x.isOf(var0) && !f_5909.player.getItemCooldownManager().isCoolingDown(var1x));
            if (var2 < 0) {
               return false;
            } else {
               int var3 = f_5909.player.getInventory().getSelectedSlot();

               boolean var4;
               try {
                  if (m_3423(var2)) {
                     return f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND).isAccepted();
                  }

                  var4 = false;
               } finally {
                  m_3423(var3);
               }

               return var4;
            }
         }
      } else {
         return false;
      }
   }
}
