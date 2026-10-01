package su.energyclient.event.impl;

import net.minecraft.entity.Entity;
import su.energyclient.event.Event;

public class EventAttack extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Entity f_10651;

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventAttack var2)) {
         return false;
      } else if (!var2.m_3689(this)) {
         return false;
      } else {
         Entity var3 = this.m_1070();
         Entity var4 = var2.m_1070();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   @Override
   public String toString() {
      return "EventAttack(target=" + this.m_1070() + ")";
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      Entity var3 = this.m_1070();
      return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
   }

   public EventAttack(Entity var1) {
      this.f_10651 = var1;
   }

   protected boolean m_3689(Object var1) {
      return var1 instanceof EventAttack;
   }

   public void m_1372(Entity var1) {
      this.f_10651 = var1;
   }

   public Entity m_1070() {
      return this.f_10651;
   }
}
