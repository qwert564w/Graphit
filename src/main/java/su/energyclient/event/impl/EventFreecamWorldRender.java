package su.energyclient.event.impl;

import su.energyclient.event.Event;

public class EventFreecamWorldRender extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private boolean f_8375;

   public boolean m_780() {
      return this.f_8375;
   }

   protected boolean m_2709(Object var1) {
      return var1 instanceof EventFreecamWorldRender;
   }

   public void m_3732(boolean var1) {
      this.f_8375 = var1;
   }

   @Override
   public String toString() {
      return "EventFreecamWorldRender(isFreecam=" + this.m_780() + ")";
   }

   public EventFreecamWorldRender(boolean var1) {
      this.f_8375 = var1;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      return var2 * 59 + (this.m_780() ? 79 : 97);
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventFreecamWorldRender var2)) {
         return false;
      } else {
         return !var2.m_2709(this) ? false : this.m_780() == var2.m_780();
      }
   }
}
