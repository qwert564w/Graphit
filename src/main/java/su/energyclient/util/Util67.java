package su.energyclient.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Util67 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_10396 = "drimixkrasav4ik";
   private static final byte[] f_10397 = new byte[]{-54, -2, -70, -66};
   private static final String f_10398 = "drimixkrasav4ik";
   private static final String f_10399 = "drimixkrasav4ik";

   public static String m_3426(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         try {
            byte[] var1 = var0.getBytes(StandardCharsets.UTF_8);
            byte[] var2 = f_10398.getBytes(StandardCharsets.UTF_8);
            byte[] var3 = new byte[var1.length];

            for (int var4 = 0; var4 < var1.length; var4++) {
               var3[var4] = (byte)(var1[var4] ^ var2[var4 % var2.length]);
            }

            byte[] var6 = new byte[f_10397.length + var3.length];
            System.arraycopy(f_10397, 0, var6, 0, f_10397.length);
            System.arraycopy(var3, 0, var6, f_10397.length, var3.length);
            return Base64.getEncoder().encodeToString(var6);
         } catch (Exception var5) {
            return var0;
         }
      } else {
         return var0;
      }
   }

   public static String m_1160(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         try {
            byte[] var1 = Base64.getDecoder().decode(var0);
            if (var1.length < f_10397.length) {
               return var0;
            } else {
               boolean var2 = true;

               for (int var3 = 0; var3 < f_10397.length; var3++) {
                  if (var1[var3] != f_10397[var3]) {
                     var2 = false;
                     break;
                  }
               }

               if (!var2) {
                  return var0;
               } else {
                  byte[] var8 = new byte[var1.length - f_10397.length];
                  System.arraycopy(var1, f_10397.length, var8, 0, var8.length);
                  byte[] var4 = f_10399.getBytes(StandardCharsets.UTF_8);
                  byte[] var5 = new byte[var8.length];

                  for (int var6 = 0; var6 < var8.length; var6++) {
                     var5[var6] = (byte)(var8[var6] ^ var4[var6 % var4.length]);
                  }

                  return new String(var5, StandardCharsets.UTF_8);
               }
            }
         } catch (Exception var7) {
            return var0;
         }
      } else {
         return var0;
      }
   }
}
