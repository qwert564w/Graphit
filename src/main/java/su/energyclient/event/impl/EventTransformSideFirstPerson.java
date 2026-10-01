package su.energyclient.event.impl;

import net.minecraft.util.Arm;
import su.energyclient.event.Event;

public class EventTransformSideFirstPerson extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Arm f_696;
   private float f_697;

   @Override
   public String toString() {
      return "EventTransformSideFirstPerson(handSide=" + this.m_142() + ", equippedProg=" + this.m_3338() + ")";
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + Float.floatToIntBits(this.m_3338());
      Arm var3 = this.m_142();
      return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventTransformSideFirstPerson var2)) {
         return false;
      } else if (!var2.m_3154(this)) {
         return false;
      } else if (Float.compare(this.m_3338(), var2.m_3338()) != 0) {
         return false;
      } else {
         Arm var3 = this.m_142();
         Arm var4 = var2.m_142();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   public EventTransformSideFirstPerson(Arm var1, float var2) {
      this.f_696 = var1;
      this.f_697 = var2;
   }

   public void m_327(Arm var1) {
      this.f_696 = var1;
   }

   protected boolean m_3154(Object var1) {
      return var1 instanceof EventTransformSideFirstPerson;
   }

   public float m_3338() {
      return this.f_697;
   }

   public void m_684(float var1) {
      this.f_697 = var1;
   }

   public Arm m_142() {
      return this.f_696;
   }
}
