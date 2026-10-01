package su.energyclient.util;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Hand;
import su.energyclient.event.Event;

public class Util116 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_13161;
   private Hand f_13162;
   private MatrixStack f_13163;

   public void m_158(MatrixStack var1) {
      this.f_13163 = var1;
   }

   public void m_1133(Hand var1) {
      this.f_13162 = var1;
   }

   public void m_2510(float var1) {
      this.f_13161 = var1;
   }

   public Hand m_538() {
      return this.f_13162;
   }

   public float m_1770() {
      return this.f_13161;
   }

   public Util116(float var1, Hand var2, MatrixStack var3) {
      this.f_13161 = var1;
      this.f_13162 = var2;
      this.f_13163 = var3;
   }

   public MatrixStack m_3181() {
      return this.f_13163;
   }
}
