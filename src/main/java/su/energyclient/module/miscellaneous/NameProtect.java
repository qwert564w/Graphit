package su.energyclient.module.miscellaneous;

import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.FriendManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;

public class NameProtect extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static BooleanSetting f_8754 = new BooleanSetting(NameProtect.f_8759, false);
   private static final String f_8755 = "Name Protect";
   private static final String f_8756 = "Скрывает ваш ник, обеспечивая конфиденциальность и защиту от преследования";
   private static final String f_8757 = "Protected";
   private static final String f_8758 = "Protected";
   private static final String f_8759 = "Скрывать друзей";

   public NameProtect() {
      super(f_8755, f_8756, Category.MISCELLANEOUS);
   }

   public static String m_1075(String var0) {
      var0 = var0.replace(f_5909.getSession().getUsername(), f_8757);
      if (f_8754.m_1163()) {
         for (FriendManager.Cfsq1JrSJubpZ92Z var2 : InitManager.f_2740.f_2744.m_3756()) {
            var0 = var0.replace(var2.m_173(), f_8758);
         }
      }

      return var0;
   }
}
