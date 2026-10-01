package su.energyclient.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Locale;

public final class Util103 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final Path f_14291 = Path.of(Util42.f_7521, Util103.f_14294, Util103.f_14295);
   private static BufferedWriter f_14292;
   private static final String f_14293 = "%.4f";
   private static final String f_14294 = "data";
   private static final String f_14295 = "dataset.csv";

   private Util103() {
   }

   private static void m_93() throws IOException {
      if (f_14292 == null) {
         Path var0 = f_14291.getParent();
         if (var0 != null) {
            Files.createDirectories(var0);
         }

         f_14292 = Files.newBufferedWriter(f_14291, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
      }
   }

   public static synchronized void m_1429() {
      if (f_14292 != null) {
         try {
            f_14292.flush();
            f_14292.close();
         } catch (IOException var4) {
         } finally {
            f_14292 = null;
         }
      }
   }

   private static String m_953(float var0) {
      return String.format(Locale.US, f_14293, var0);
   }

   public static synchronized void m_3041(float var0, float var1) {
      try {
         m_93();
         f_14292.write(m_953(var0));
         f_14292.write(44);
         f_14292.write(m_953(var1));
         f_14292.newLine();
         f_14292.flush();
      } catch (IOException var3) {
         System.err.println("Failed to write dataset row: " + var3.getMessage());
      }
   }

   public static synchronized void m_1995() {
      m_1429();

      try {
         Files.createDirectories(f_14291.getParent());
         Files.writeString(f_14291, "", StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
      } catch (IOException var1) {
         System.err.println("Failed to clear dataset: " + var1.getMessage());
      }
   }
}
