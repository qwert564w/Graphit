package su.energyclient.util;

import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;

public class Util135 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_10588 = "соси хуй";
   private static final String f_10589 = "пососи";

   public static BufferedReader m_3407(Identifier var0) {
      try {
         return new BufferedReader(new InputStreamReader(m_2272(var0), StandardCharsets.UTF_8));
      } catch (Exception var2) {
         System.out.println(f_10589);
         throw var2;
      }
   }

   public static JsonObject O(Identifier var0) {
      try {
         BufferedReader var1 = m_3407(var0);
         JsonObject var2 = JsonHelper.deserialize(var1);
         var1.close();
         return var2;
      } catch (Exception var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public static InputStream m_2272(Identifier var0) {
      try {
         return var0.getClass().getResourceAsStream("/assets/" + var0.getNamespace() + "/" + var0.getPath());
      } catch (Exception var2) {
         System.out.println(f_10588);
         throw var2;
      }
   }
}
