package su.energyclient.event.impl;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import su.energyclient.event.Event;

public class EventRightClickItemCheck extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private ItemStack f_2762;
   private Hand f_2763;

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventRightClickItemCheck var2)) {
         return false;
      } else if (!var2.l(this)) {
         return false;
      } else {
         ItemStack var3 = this.m_401();
         ItemStack var4 = var2.m_401();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            Hand var5 = this.m_195();
            Hand var6 = var2.m_195();
            return var5 == null ? var6 == null : var5.equals(var6);
         } else {
            return false;
         }
      }
   }

   @Override
   public String toString() {
      return "EventRightClickItemCheck(itemStack=" + this.m_401() + ", hand=" + this.m_195() + ")";
   }

   public void m_2599(ItemStack var1) {
      this.f_2762 = var1;
   }

   public EventRightClickItemCheck(ItemStack var1, Hand var2) {
      this.f_2762 = var1;
      this.f_2763 = var2;
   }

   public ItemStack m_401() {
      return this.f_2762;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      ItemStack var3 = this.m_401();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      Hand var4 = this.m_195();
      return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
   }

   public void m_1564(Hand var1) {
      this.f_2763 = var1;
   }

   protected boolean l(Object var1) {
      return var1 instanceof EventRightClickItemCheck;
   }

   public Hand m_195() {
      return this.f_2763;
   }
}
