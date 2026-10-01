package su.energyclient.render;

import net.minecraft.util.math.Vec3d;
import su.energyclient.event.Event;

public class RenderUtil8 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Vec3d f_13970;
   private Vec3d f_13971;
   private Vec3d O;

   public Vec3d I() {
      return this.f_13971;
   }

   public RenderUtil8(Vec3d var1, Vec3d var2, Vec3d var3) {
      this.f_13970 = var1;
      this.f_13971 = var2;
      this.O = var3;
   }

   public void m_1280(Vec3d var1) {
      this.f_13970 = var1;
   }

   public Vec3d m_2313() {
      return this.f_13970;
   }

   public Vec3d m_2657() {
      return this.O;
   }

   public void m_4142(Vec3d var1) {
      this.O = var1;
   }

   public void m_1303(Vec3d var1) {
      this.f_13971 = var1;
   }
}
