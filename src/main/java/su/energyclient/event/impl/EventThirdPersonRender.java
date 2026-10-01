package su.energyclient.event.impl;

import su.energyclient.event.Event;

public class EventThirdPersonRender extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private boolean f_7779;

   public boolean m_152() {
      return this.f_7779;
   }

   @Override
   public String toString() {
      return "EventThirdPersonRender(thirdperson=" + this.m_152() + ")";
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      return var2 * 59 + (this.m_152() ? 79 : 97);
   }

   public EventThirdPersonRender(boolean var1) {
      this.f_7779 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventThirdPersonRender var2)) {
         return false;
      } else {
         return !var2.m_118(this) ? false : this.m_152() == var2.m_152();
      }
   }

   protected boolean m_118(Object var1) {
      return var1 instanceof EventThirdPersonRender;
   }

   public void m_957(boolean var1) {
      this.f_7779 = var1;
   }
}
