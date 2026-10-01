package su.energyclient.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import su.energyclient.event.Event;

public class Util64 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final LivingEntity f_8449;
   private final Entity f_8450;
   private final int f_8451;
   private float f_8452;

   public Util64(LivingEntity var1, Entity var2, int var3, float var4) {
      this.f_8449 = var1;
      this.f_8450 = var2;
      this.f_8451 = var3;
      this.f_8452 = var4;
   }

   public float l9() {
      return this.f_8452;
   }

   public int m_2927() {
      return this.f_8451;
   }

   public LivingEntity m_4084() {
      return this.f_8449;
   }

   public void m_440(float var1) {
      this.f_8452 = var1;
   }

   public Entity m_3243() {
      return this.f_8450;
   }
}
