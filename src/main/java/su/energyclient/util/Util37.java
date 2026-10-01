package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import su.energyclient.event.Event;

public class Util37 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private LivingEntity f_7778;

   public void m_3240(LivingEntity var1) {
      this.f_7778 = var1;
   }

   public LivingEntity m_515() {
      return this.f_7778;
   }

   public Util37(LivingEntity var1) {
      this.f_7778 = var1;
   }
}
