package su.energyclient.event.impl;

import su.energyclient.event.Event;

public class EventInventoryClose extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_8482;

   public int m_3721() {
      return this.f_8482;
   }

   protected boolean m_1826(Object var1) {
      return var1 instanceof EventInventoryClose;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventInventoryClose var2)) {
         return false;
      } else {
         return !var2.m_1826(this) ? false : this.m_3721() == var2.m_3721();
      }
   }

   public EventInventoryClose(int var1) {
      this.f_8482 = var1;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      return var2 * 59 + this.m_3721();
   }

   @Override
   public String toString() {
      return "EventInventoryClose(windowId=" + this.m_3721() + ")";
   }

   public void m_1918(int var1) {
      this.f_8482 = var1;
   }
}
