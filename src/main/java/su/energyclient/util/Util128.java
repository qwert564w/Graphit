package su.energyclient.util;

public final class Util128 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static int f_10744;

   public static boolean m_406() {
      return f_10744 > 0;
   }

   public static void m_2307() {
      f_10744++;
   }

   private Util128() {
   }

   public static void m_2759() {
      if (f_10744 > 0) {
         f_10744--;
      }
   }
}
