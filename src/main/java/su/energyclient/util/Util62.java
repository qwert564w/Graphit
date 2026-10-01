package su.energyclient.util;

import su.energyclient.QuickImports;
import su.energyclient.module.miscellaneous.ObsidianFarm;

public class Util62 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ObsidianFarm f_8483;
   private long f_8484 = 0L;
   private static final long f_8485 = 5000L;
   private static final String O5 = "/spawn";
   private static final String f_8486 = "Успешно тепнул на спавн!";

   public Util62(ObsidianFarm var1) {
      this.f_8483 = var1;
   }

   public void m_3033() {
      if (f_5909.player.getY() < 0.0) {
         long var1 = System.currentTimeMillis();
         if (var1 - this.f_8484 >= f_8485) {
            this.f_8484 = var1;
            this.f_8483.m_74(O5);
            this.f_8483.m_3314(f_8486);
         }
      }
   }
}
