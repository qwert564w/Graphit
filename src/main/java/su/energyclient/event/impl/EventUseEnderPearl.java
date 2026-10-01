package su.energyclient.event.impl;

import net.minecraft.item.ItemStack;
import su.energyclient.event.Event;

public class EventUseEnderPearl extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private ItemStack f_763;

   @Override
   public String toString() {
      return "EventUseEnderPearl(itemStack=" + this.m_1071() + ")";
   }

   public EventUseEnderPearl(ItemStack var1) {
      this.f_763 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventUseEnderPearl var2)) {
         return false;
      } else if (!var2.m_3870(this)) {
         return false;
      } else {
         ItemStack var3 = this.m_1071();
         ItemStack var4 = var2.m_1071();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      ItemStack var3 = this.m_1071();
      return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
   }

   protected boolean m_3870(Object var1) {
      return var1 instanceof EventUseEnderPearl;
   }

   public void m_2616(ItemStack var1) {
      this.f_763 = var1;
   }

   public ItemStack m_1071() {
      return this.f_763;
   }
}
