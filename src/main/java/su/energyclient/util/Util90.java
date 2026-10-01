package su.energyclient.util;

import ru.dreamix.protection.api.impl.profile.ProfileAPI;
import ru.dreamix.protection.api.impl.profile.models.ProfileInformationModel;
import ru.dreamix.protection.api.impl.profile.objects.RoleObject;

public class Util90 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static String f_5919;
   public static String f_5920;
   public static String f_5921;
   public static RoleObject f_5922;
   public static String f_5923 = Util90.f_5925;
   private static final String f_5924 = "Whls";
   private static final String f_5925 = "#1.7.8";

   public static void m_3966() {
      ProfileAPI.create(f_5924, 0, RoleObject.ADMIN);
      ProfileInformationModel var0 = ProfileAPI.get().getModel();
      f_5919 = var0.getName();
      f_5920 = String.valueOf(var0.getUserIdentifier());
      f_5922 = var0.getRole();
      f_5921 = var0.getSubscriptionObject().getStringTill();
   }
}
