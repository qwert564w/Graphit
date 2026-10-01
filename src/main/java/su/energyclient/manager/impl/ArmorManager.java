package su.energyclient.manager.impl;

import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import su.energyclient.QuickImports;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventHandleMouseClick;
import su.energyclient.event.impl.EventInventoryClose;
import su.energyclient.util.Util152;

public class ArmorManager implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_2406 = 36;
   public static final int f_2407 = 0;
   private int f_2408 = -1;
   private int f_2409 = -1;
   private boolean f_2410 = false;
   private boolean f_2411 = false;
   private final ItemStack[] f_2412 = new ItemStack[3];
   private static final String f_2413 = "Этот предмет уже добавлен в другое деление колеса";

   public boolean m_2780() {
      if (!this.f_2411) {
         return false;
      } else {
         this.f_2411 = false;
         return true;
      }
   }

   public ItemStack m_987(int var1) {
      if (this.m_420(var1) && this.m_626()) {
         ItemStack var2 = this.f_2412[var1];
         if (var2 != null && !var2.isEmpty()) {
            return this.m_2854(var2) ? var2 : ItemStack.EMPTY;
         } else {
            return ItemStack.EMPTY;
         }
      } else {
         return ItemStack.EMPTY;
      }
   }

   private boolean m_2854(ItemStack var1) {
      if (this.m_626() && !var1.isEmpty()) {
         if (this.m_854(f_5909.player.getOffHandStack(), var1)) {
            return true;
         } else if (this.m_854(f_5909.player.getEquippedStack(EquipmentSlot.HEAD), var1)) {
            return true;
         } else {
            for (int var2 = 0; var2 < 36; var2++) {
               ItemStack var3 = f_5909.player.getInventory().getStack(var2);
               if (this.m_854(var3, var1)) {
                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }

   private boolean m_420(int var1) {
      return var1 >= 0 && var1 < this.f_2412.length;
   }

   private boolean m_626() {
      return f_5909.player != null && f_5909.world != null;
   }

   public int m_2248() {
      return this.f_2409;
   }

   public void m_2090(int var1) {
      if (this.m_626() && this.m_420(var1)) {
         this.f_2408 = var1;
         this.f_2410 = true;
         f_5909.setScreen(new InventoryScreen(f_5909.player));
      }
   }

   public boolean m_1702() {
      return this.f_2411;
   }

   @EventHandler
   public void m_1561(EventInventoryClose var1) {
      if (this.f_2410) {
         var1.m_277(true);
         this.f_2410 = false;
         this.f_2408 = -1;
      }
   }

   public void m_91(int var1) {
      if (!this.m_420(var1)) {
         this.f_2409 = -1;
      } else {
         if (this.f_2409 != var1) {
            this.f_2409 = var1;
            this.f_2411 = true;
         }
      }
   }

   @EventHandler
   public void m_578(EventHandleMouseClick var1) {
      if (this.f_2408 >= 0) {
         Slot var2 = var1.m_1480();
         if (var2 != null) {
            if (var1.m_2348() == SlotActionType.PICKUP && (var1.Ol() == 0 || var1.Ol() == 1) || var1.m_2348() == SlotActionType.QUICK_MOVE) {
               var1.m_277(true);
               if (this.m_420(this.f_2408)) {
                  ItemStack var3 = var2.getStack();
                  if (var3.isEmpty()) {
                     return;
                  }

                  if (this.m_126(var3, this.f_2408)) {
                     Util152.m_662(f_2413);
                  } else {
                     this.f_2412[this.f_2408] = var3.copy();
                     if (this.m_626()
                        && (this.m_854(f_5909.player.getOffHandStack(), var3) || this.m_854(f_5909.player.getEquippedStack(EquipmentSlot.HEAD), var3))) {
                        this.f_2409 = this.f_2408;
                        this.f_2411 = false;
                     }
                  }
               }

               this.f_2408 = -1;
               if (f_5909.currentScreen instanceof InventoryScreen) {
                  f_5909.setScreen(null);
               }
            }
         }
      }
   }

   public void m_225(int var1) {
      if (this.m_420(var1)) {
         this.f_2412[var1] = null;
         if (this.f_2409 == var1) {
            this.f_2409 = -1;
         }
      }
   }

   private boolean m_126(ItemStack var1, int var2) {
      for (int var3 = 0; var3 < this.f_2412.length; var3++) {
         if (var3 != var2) {
            ItemStack var4 = this.f_2412[var3];
            if (this.m_854(var4, var1)) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean m_854(ItemStack var1, ItemStack var2) {
      if (var1 == null || var2 == null || var1.isEmpty() || var2.isEmpty()) {
         return false;
      } else {
         return !ItemStack.areItemsAndComponentsEqual(var1, var2) ? false : var1.getName().getString().equals(var2.getName().getString());
      }
   }
}
