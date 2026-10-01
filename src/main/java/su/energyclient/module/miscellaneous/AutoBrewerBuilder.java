package su.energyclient.module.miscellaneous;

import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util152;

public final class AutoBrewerBuilder extends Module {
   private static final String f_3514 = "Auto Brewer Builder";

   public AutoBrewerBuilder() {
      super(f_3514, f_3515, Category.MISCELLANEOUS);
   }

   @Override
   public void m_2() {
      super.m_2();
      if (this.m_677()) {
         this.m_1926(false);
      }
   }
}
