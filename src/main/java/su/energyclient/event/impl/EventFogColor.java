package su.energyclient.event.impl;

import su.energyclient.event.Event;

public class EventFogColor extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_1408;
   private float f_1409;
   private float f_1410;

   public void m_2096(float var1) {
      this.f_1410 = var1;
   }

   public void m_2168(float var1) {
      this.f_1408 = var1;
   }

   public float m_170() {
      return this.f_1409;
   }

   @Override
   public String toString() {
      return "EventFogColor(red=" + this.m_693() + ", green=" + this.m_170() + ", blue=" + this.m_2055() + ")";
   }

   public float m_693() {
      return this.f_1408;
   }

   public void m_2051(float var1) {
      this.f_1409 = var1;
   }

   protected boolean m_1272(Object var1) {
      return var1 instanceof EventFogColor;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventFogColor var2)) {
         return false;
      } else if (!var2.m_1272(this)) {
         return false;
      } else if (Float.compare(this.m_693(), var2.m_693()) != 0) {
         return false;
      } else {
         return Float.compare(this.m_170(), var2.m_170()) != 0 ? false : Float.compare(this.m_2055(), var2.m_2055()) == 0;
      }
   }

   public float m_2055() {
      return this.f_1410;
   }

   public EventFogColor(float var1, float var2, float var3) {
      this.f_1408 = var1;
      this.f_1409 = var2;
      this.f_1410 = var3;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + Float.floatToIntBits(this.m_693());
      var2 = var2 * 59 + Float.floatToIntBits(this.m_170());
      return var2 * 59 + Float.floatToIntBits(this.m_2055());
   }
}
