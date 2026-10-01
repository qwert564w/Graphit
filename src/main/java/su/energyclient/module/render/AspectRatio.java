package su.energyclient.module.render;

import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util26;

public class AspectRatio extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final ModeSetting f_12135;
   public final NumberSetting f_12136;
   private static final String f_12137 = "Aspect Ratio";
   private static final String f_12138 = "Изменяет соотношение сторон экрана";
   private static final String f_12139 = "Соотношение";
   private static final String f_12140 = "Кастомное";
   private static final String f_12141 = "4:3";
   private static final String f_12142 = "16:9";
   private static final String f_12143 = "1:1";
   private static final String f_12144 = "16:10";
   private static final String f_12145 = "Кастомное";
   private static final String f_12146 = "Значение";
   private static final float f_12147 = 0.1F;
   private static final float f_12148 = 5.0F;
   private static final float f_12149 = 0.1F;
   private static final String f_12150 = "4:3";
   private static final String f_12151 = "16:9";
   private static final String f_12152 = "1:1";
   private static final String f_12153 = "16:10";
   private static final float f_12154 = 1.3333334F;
   private static final float f_12155 = 1.7777778F;
   private static final float f_12156 = 1.6F;
   private static final String f_12157 = "Кастомное";

   @EventHandler
   public void m_1229(Util26 var1) {
      String var3 = this.f_12135.m_3862();

      float var2 = switch (var3) {
         case f_12150 -> f_12154;
         case f_12151 -> f_12155;
         case f_12152 -> 1.0F;
         case f_12153 -> f_12156;
         default -> this.f_12136.m_4046();
      };
      var1.m_252(var2);
   }

   public AspectRatio() {
      super(f_12137, f_12138, Category.RENDER);
      this.f_12135 = new ModeSetting(f_12139, f_12140, f_12141, f_12142, f_12143, f_12144, f_12145);
      this.f_12136 = new NumberSetting(f_12146, 1.0F, f_12147, f_12148, f_12149).m_356(() -> this.f_12135.m_2073(f_12157));
   }
}
