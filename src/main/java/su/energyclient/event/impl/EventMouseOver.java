package su.energyclient.event.impl;

import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.Event;

public class EventMouseOver extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Vec3d f_1097;
   private Vec2f f_1098;

   public void m_3310(Vec3d var1) {
      this.f_1097 = var1;
   }

   @Override
   public String toString() {
      return "EventMouseOver(position=" + this.m_1884() + ", rotation=" + this.m_3518() + ")";
   }

   public Vec3d m_1884() {
      return this.f_1097;
   }

   public void m_1496(Vec2f var1) {
      this.f_1098 = var1;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      Vec3d var3 = this.m_1884();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      Vec2f var4 = this.m_3518();
      return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
   }

   protected boolean m_4016(Object var1) {
      return var1 instanceof EventMouseOver;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventMouseOver var2)) {
         return false;
      } else if (!var2.m_4016(this)) {
         return false;
      } else {
         Vec3d var3 = this.m_1884();
         Vec3d var4 = var2.m_1884();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            Vec2f var5 = this.m_3518();
            Vec2f var6 = var2.m_3518();
            return var5 == null ? var6 == null : var5.equals(var6);
         } else {
            return false;
         }
      }
   }

   public EventMouseOver(Vec3d var1, Vec2f var2) {
      this.f_1097 = var1;
      this.f_1098 = var2;
   }

   public Vec2f m_3518() {
      return this.f_1098;
   }
}
