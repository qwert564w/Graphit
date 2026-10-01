package su.energyclient.module.render;

import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.NumberSetting;

public class InvisibleOpacity extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_12413;
   private static final String f_12414 = "Invisible Opacity";
   private static final String f_12415 = "Позволяет изменить прозрачность невидимых игроков, облегчая их обнаружение";
   private static final String f_12416 = "Прозрачность";
   private static final float f_12417 = 0.5F;
   private static final float f_12418 = 0.3F;
   private static final float f_12419 = 0.1F;

   public NumberSetting m_3327() {
      return this.f_12413;
   }

   public InvisibleOpacity() {
      super(f_12414, f_12415, Category.RENDER);
      this.f_12413 = new NumberSetting(f_12416, f_12417, f_12418, 1.0F, f_12419);
   }
}
