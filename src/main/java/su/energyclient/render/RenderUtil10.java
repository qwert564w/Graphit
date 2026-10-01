package su.energyclient.render;

import net.minecraft.client.gl.SimpleFramebuffer;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;

public class RenderUtil10 extends RenderUtil11 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_1629 = "effects";
   private static final String f_1630 = "passthrough";
   private static final String f_1631 = "Tex0";
   private static final String f_1632 = "Alpha";

   public static void m_1044(RenderUtil10 var0, SimpleFramebuffer var1) {
      RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
      var0.m_2989();
      var0.m_3372(f_1631, 0);
      var0.m_3397(f_1632, true);
      Util114.m_1481();
      Util114.m_542();
      Util114.m_2012(RenderUtil6.m_668(var1.getColorAttachment()));
      RenderUtil23.m_1477();
      Util114.m_963();
      var0.m_233();
   }

   public RenderUtil10() {
      super(f_1629, f_1630);
   }
}
