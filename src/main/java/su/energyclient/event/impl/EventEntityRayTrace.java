package su.energyclient.event.impl;

import net.minecraft.entity.Entity;
import su.energyclient.event.Event;

public class EventEntityRayTrace extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Entity f_14435;

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventEntityRayTrace var2)) {
         return false;
      } else if (!var2.m_2158(this)) {
         return false;
      } else {
         Entity var3 = this.m_1053();
         Entity var4 = var2.m_1053();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      Entity var3 = this.m_1053();
      return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
   }

   @Override
   public String toString() {
      return "EventEntityRayTrace(entity=" + this.m_1053() + ")";
   }

   public EventEntityRayTrace(Entity var1) {
      this.f_14435 = var1;
   }

   public Entity m_1053() {
      return this.f_14435;
   }

   protected boolean m_2158(Object var1) {
      return var1 instanceof EventEntityRayTrace;
   }
}
