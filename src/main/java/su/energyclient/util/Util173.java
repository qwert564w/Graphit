package su.energyclient.util;

import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.Event;

public class Util173 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Vec3d f_7713;
   private Vec2f f_7714;

   public Util173(Vec3d var1, Vec2f var2) {
      this.f_7713 = var1;
      this.f_7714 = var2;
   }

   public Vec3d m_2454() {
      return this.f_7713;
   }

   public Vec2f m_556() {
      return this.f_7714;
   }

   public void m_1672(Vec3d var1) {
      this.f_7713 = var1;
   }

   public void m_884(Vec2f var1) {
      this.f_7714 = var1;
   }
}
