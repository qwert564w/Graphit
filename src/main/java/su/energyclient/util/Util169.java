package su.energyclient.util;

import net.minecraft.client.gui.DrawContext;
import su.energyclient.event.Event;

public class Util169 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private DrawContext f_7976;
   private float f_7977;

   public float m_4119() {
      return this.f_7977;
   }

   public DrawContext m_4037() {
      return this.f_7976;
   }

   public Util169(DrawContext var1, float var2) {
      this.f_7976 = var1;
      this.f_7977 = var2;
   }
}
