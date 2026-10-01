package su.energyclient.event.impl;

import net.minecraft.util.Hand;
import su.energyclient.event.Event;

public class EventSwingSpeed extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_4751;
   private Hand f_4752;

   public int m_1627() {
      return this.f_4751;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventSwingSpeed var2)) {
         return false;
      } else if (!var2.m_994(this)) {
         return false;
      } else if (this.m_1627() != var2.m_1627()) {
         return false;
      } else {
         Hand var3 = this.m_3373();
         Hand var4 = var2.m_3373();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   public EventSwingSpeed(int var1, Hand var2) {
      this.f_4751 = var1;
      this.f_4752 = var2;
   }

   @Override
   public String toString() {
      return "EventSwingSpeed(swipeSpeed=" + this.m_1627() + ", hand=" + this.m_3373() + ")";
   }

   public void m_1874(Hand var1) {
      this.f_4752 = var1;
   }

   public Hand m_3373() {
      return this.f_4752;
   }

   public void m_454(int var1) {
      this.f_4751 = var1;
   }

   protected boolean m_994(Object var1) {
      return var1 instanceof EventSwingSpeed;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + this.m_1627();
      Hand var3 = this.m_3373();
      return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
   }
}
