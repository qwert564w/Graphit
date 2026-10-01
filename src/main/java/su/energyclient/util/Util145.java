package su.energyclient.util;

import net.minecraft.util.math.Vec3d;
import su.energyclient.event.Event;

public class Util145 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Vec3d f_11850;

   public void m_2482(Vec3d var1) {
      this.f_11850 = var1;
   }

   public Util145(Vec3d var1) {
      this.f_11850 = var1;
   }

   public Vec3d m_3620() {
      return this.f_11850;
   }
}
