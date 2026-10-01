package su.energyclient.util.math;

import net.minecraft.util.math.Vec2f;

public class MathUtil9 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final float f_6053;
   private final float f_6054;

   public MathUtil9(float var1, float var2) {
      this.f_6053 = var1;
      this.f_6054 = var2;
   }

   public float m_2647() {
      return this.f_6053;
   }

   public Vec2f m_105() {
      return new Vec2f(this.f_6053, this.f_6054);
   }

   public boolean m_1472(float var1, float var2) {
      return Math.abs(this.f_6053) < var1 && Math.abs(this.f_6054) < var2;
   }

   public float I() {
      return this.f_6054;
   }

   public float m_3465() {
      return (float)Math.sqrt(this.f_6053 * this.f_6053 + this.f_6054 * this.f_6054);
   }

   public boolean m_3273(float var1) {
      return this.m_1472(var1, var1);
   }
}
