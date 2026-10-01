package su.energyclient.util;

import su.energyclient.event.Event;

public class Util121 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_10745;
   private float f_10746;
   private boolean f_10747;
   private boolean f_10748;

   public void m_1269(boolean var1) {
      this.f_10748 = var1;
   }

   public void m_433(float var1) {
      this.f_10745 = var1;
   }

   public void m_564(boolean var1) {
      this.f_10747 = var1;
   }

   public void m_2791(float var1) {
      this.f_10746 = var1;
   }

   public boolean m_2407() {
      return this.f_10747;
   }

   public Util121(float var1, float var2, boolean var3, boolean var4) {
      this.f_10745 = var1;
      this.f_10746 = var2;
      this.f_10747 = var3;
      this.f_10748 = var4;
   }

   public boolean m_1400() {
      return this.f_10748;
   }

   public float m_2113() {
      return this.f_10746;
   }

   public float m_2210() {
      return this.f_10745;
   }
}
