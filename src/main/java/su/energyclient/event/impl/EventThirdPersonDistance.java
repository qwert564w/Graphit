package su.energyclient.event.impl;

import su.energyclient.event.Event;

public class EventThirdPersonDistance extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_10811;

   protected boolean m_2029(Object var1) {
      return var1 instanceof EventThirdPersonDistance;
   }

   public float m_2439() {
      return this.f_10811;
   }

   public void m_4098(float var1) {
      this.f_10811 = var1;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      return var2 * 59 + Float.floatToIntBits(this.m_2439());
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventThirdPersonDistance var2)) {
         return false;
      } else {
         return !var2.m_2029(this) ? false : Float.compare(this.m_2439(), var2.m_2439()) == 0;
      }
   }

   @Override
   public String toString() {
      return "EventThirdPersonDistance(distance=" + this.m_2439() + ")";
   }

   public EventThirdPersonDistance(float var1) {
      this.f_10811 = var1;
   }
}
