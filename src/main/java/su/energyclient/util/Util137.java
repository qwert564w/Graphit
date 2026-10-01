package su.energyclient.util;

import net.minecraft.util.math.Vec3d;
import su.energyclient.event.Event;

public class Util137 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Vec3d f_10473;

   public Util137(Vec3d var1) {
      this.f_10473 = var1;
   }

   public void m_1744(Vec3d var1) {
      this.f_10473 = var1;
   }

   public Vec3d m_3148() {
      return this.f_10473;
   }
}
