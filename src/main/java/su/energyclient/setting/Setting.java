package su.energyclient.setting;

import java.awt.Color;
import java.util.function.Supplier;
import su.energyclient.QuickImports;

public abstract class Setting implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final String f_7715;
   public Supplier<Boolean> f_7716 = () -> true;
   public Color f_7717 = Color.WHITE;

   public Boolean m_1326() {
      return this.f_7716.get();
   }

   public Supplier<Boolean> m_3719() {
      return this.f_7716;
   }

   public Setting(String var1) {
      this.f_7715 = var1;
   }

   public String m_1488() {
      return this.f_7715;
   }

   public Color m_3758() {
      return this.f_7717;
   }
}
