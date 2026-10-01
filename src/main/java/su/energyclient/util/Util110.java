package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.Event;

public class Util110 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private LivingEntity f_13188;
   private Vec3d f_13189;

   public Vec3d m_2458() {
      return this.f_13189;
   }

   public void m_1249(Vec3d var1) {
      this.f_13189 = var1;
   }

   public Util110(LivingEntity var1, Vec3d var2) {
      this.f_13188 = var1;
      this.f_13189 = var2;
   }

   public LivingEntity m_1807() {
      return this.f_13188;
   }

   public void m_2584(LivingEntity var1) {
      this.f_13188 = var1;
   }
}
