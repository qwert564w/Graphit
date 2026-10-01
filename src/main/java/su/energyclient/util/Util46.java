package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import su.energyclient.event.Event;

public class Util46 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final LivingEntity f_8095;
   private final float f_8096;

   public float m_3787() {
      return this.f_8096;
   }

   public Util46(LivingEntity var1, float var2) {
      this.f_8095 = var1;
      this.f_8096 = var2;
   }

   public LivingEntity m_2669() {
      return this.f_8095;
   }
}
