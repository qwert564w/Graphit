package su.energyclient.event.impl;

import su.energyclient.event.Event;

public class EventNoPush extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final EventNoPush.Inner_4C0TXA9Fous6eGMB f_8760;

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventNoPush var2)) {
         return false;
      } else if (!var2.m_2823(this)) {
         return false;
      } else {
         EventNoPush.Inner_4C0TXA9Fous6eGMB var3 = this.m_1188();
         EventNoPush.Inner_4C0TXA9Fous6eGMB var4 = var2.m_1188();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   public EventNoPush(EventNoPush.Inner_4C0TXA9Fous6eGMB var1) {
      this.f_8760 = var1;
   }

   @Override
   public String toString() {
      return "EventNoPush(noPushType=" + this.m_1188() + ")";
   }

   protected boolean m_2823(Object var1) {
      return var1 instanceof EventNoPush;
   }

   public EventNoPush.Inner_4C0TXA9Fous6eGMB m_1188() {
      return this.f_8760;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      EventNoPush.Inner_4C0TXA9Fous6eGMB var3 = this.m_1188();
      return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
   }

   public static enum Inner_4C0TXA9Fous6eGMB {
      Block,
      Water,
      Player,
      FishingRod;
   }
}
