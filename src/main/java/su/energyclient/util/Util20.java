package su.energyclient.util;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import su.energyclient.event.Event;

public class Util20 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private MatrixStack f_2871;
   private Arm f_2872;

   public MatrixStack m_486() {
      return this.f_2871;
   }

   public Arm m_2883() {
      return this.f_2872;
   }

   public Util20(MatrixStack var1, Arm var2) {
      this.f_2871 = var1;
      this.f_2872 = var2;
   }

   public void m_653(MatrixStack var1) {
      this.f_2871 = var1;
   }

   public void m_2820(Arm var1) {
      this.f_2872 = var1;
   }
}
