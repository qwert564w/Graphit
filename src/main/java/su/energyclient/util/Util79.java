package su.energyclient.util;

import net.minecraft.client.util.math.MatrixStack;
import su.energyclient.event.Event;

public class Util79 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private MatrixStack f_5726;
   private float f_5727;

   public MatrixStack m_3935() {
      return this.f_5726;
   }

   public float m_4008() {
      return this.f_5727;
   }

   public Util79(MatrixStack var1, float var2) {
      this.f_5726 = var1;
      this.f_5727 = var2;
   }
}
