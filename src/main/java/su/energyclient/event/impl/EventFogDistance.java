package su.energyclient.event.impl;

import su.energyclient.event.Event;

public class EventFogDistance extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_10649;
   private float f_10650;

   protected boolean m_3885(Object var1) {
      return var1 instanceof EventFogDistance;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventFogDistance var2)) {
         return false;
      } else if (!var2.m_3885(this)) {
         return false;
      } else {
         return Float.compare(this.m_960(), var2.m_960()) != 0 ? false : Float.compare(this.m_604(), var2.m_604()) == 0;
      }
   }

   public void m_3355(float var1) {
      this.f_10649 = var1;
   }

   public float m_604() {
      return this.f_10650;
   }

   @Override
   public String toString() {
      return "EventFogDistance(fogStart=" + this.m_960() + ", fogEnd=" + this.m_604() + ")";
   }

   public EventFogDistance(float var1, float var2) {
      this.f_10649 = var1;
      this.f_10650 = var2;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + Float.floatToIntBits(this.m_960());
      return var2 * 59 + Float.floatToIntBits(this.m_604());
   }

   public float m_960() {
      return this.f_10649;
   }

   public void m_3967(float var1) {
      this.f_10650 = var1;
   }
}
