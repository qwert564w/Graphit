package su.energyclient.util;

import su.energyclient.event.Event;

public class Util100 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_14314;
   private float f_14315;

   public void m_2365(float var1) {
      this.f_14314 = var1;
   }

   public Util100(float var1, float var2) {
      this.f_14314 = var1;
      this.f_14315 = var2;
   }

   public float m_2116() {
      return this.f_14315;
   }

   public float m_655() {
      return this.f_14314;
   }

   public void m_3388(float var1) {
      this.f_14315 = var1;
   }
}
