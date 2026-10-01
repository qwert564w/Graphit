package su.energyclient.event.impl;

import net.minecraft.item.ItemStack;
import su.energyclient.event.Event;

public class EventCooldownTracker extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private ItemStack f_1133;
   private float f_1134;

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventCooldownTracker var2)) {
         return false;
      } else if (!var2.m_415(this)) {
         return false;
      } else if (Float.compare(this.m_525(), var2.m_525()) != 0) {
         return false;
      } else {
         ItemStack var3 = this.m_2859();
         ItemStack var4 = var2.m_2859();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + Float.floatToIntBits(this.m_525());
      ItemStack var3 = this.m_2859();
      return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
   }

   public EventCooldownTracker(ItemStack var1, float var2) {
      this.f_1133 = var1;
      this.f_1134 = var2;
   }

   public void m_681(ItemStack var1) {
      this.f_1133 = var1;
   }

   protected boolean m_415(Object var1) {
      return var1 instanceof EventCooldownTracker;
   }

   @Override
   public String toString() {
      return "EventCooldownTracker(item=" + this.m_2859() + ", partialTicks=" + this.m_525() + ")";
   }

   public void m_3359(float var1) {
      this.f_1134 = var1;
   }

   public float m_525() {
      return this.f_1134;
   }

   public ItemStack m_2859() {
      return this.f_1133;
   }
}
