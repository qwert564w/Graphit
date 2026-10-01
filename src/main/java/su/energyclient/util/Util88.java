package su.energyclient.util;

import net.minecraft.client.util.math.MatrixStack;
import su.energyclient.event.Event;

public class Util88 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private MatrixStack f_6192;
   private final float f_6193;

   public void m_806(MatrixStack var1) {
      this.f_6192 = var1;
   }

   public Util88(MatrixStack var1, float var2) {
      this.f_6192 = var1;
      this.f_6193 = var2;
   }

   public MatrixStack m_213() {
      return this.f_6192;
   }

   public float m_191() {
      return this.f_6193;
   }
}
