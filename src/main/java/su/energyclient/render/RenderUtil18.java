package su.energyclient.render;

import net.minecraft.util.Arm;
import su.energyclient.event.Event;

public class RenderUtil18 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Arm f_1413;
   private float f_1414;
   private float f_1415;

   public Arm m_742() {
      return this.f_1413;
   }

   public float m_3200() {
      return this.f_1415;
   }

   public void m_4048(float var1) {
      this.f_1415 = var1;
   }

   public float m_1604() {
      return this.f_1414;
   }

   public void m_3822(float var1) {
      this.f_1414 = var1;
   }

   public void m_2964(Arm var1) {
      this.f_1413 = var1;
   }

   public RenderUtil18(Arm var1, float var2, float var3) {
      this.f_1413 = var1;
      this.f_1414 = var2;
      this.f_1415 = var3;
   }
}
