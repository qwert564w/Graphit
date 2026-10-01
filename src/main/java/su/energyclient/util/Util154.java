package su.energyclient.util;

public final class Util154 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static volatile String f_10917 = null;
   private static volatile boolean f_10918 = false;

   public static boolean m_3642() {
      return f_10918;
   }

   public static void m_274(String var0) {
      f_10917 = var0;
      f_10918 = true;
   }

   public static void m_763() {
      f_10918 = false;
   }

   public static void m_3514(String var0) {
      f_10917 = var0;
      f_10918 = false;
   }

   private Util154() {
   }

   public static void m_2213() {
      f_10918 = false;
   }

   public static String m_481() {
      return f_10917;
   }
}
