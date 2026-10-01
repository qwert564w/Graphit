package su.energyclient.module.miscellaneous;

import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;

public class ClientSounds extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final ModeSetting f_5040;
   public final NumberSetting f_5041;
   private static final String f_5042 = "Client Sounds";
   private static final String f_5043 = "description";
   private static final String f_5044 = "Мод";
   private static final String f_5045 = "Мод 1";
   private static final String f_5046 = "Мод 1";
   private static final String f_5047 = "Мод 2";
   private static final String f_5048 = "Громкость";
   private static final float f_5049 = 75.0F;
   private static final float f_5050 = 100.0F;

   public ClientSounds() {
      super(f_5042, f_5043, Category.MISCELLANEOUS);
      this.f_5040 = new ModeSetting(f_5044, f_5045, f_5046, f_5047);
      this.f_5041 = new NumberSetting(f_5048, f_5049, 0.0F, f_5050, 1.0F);
   }
}
