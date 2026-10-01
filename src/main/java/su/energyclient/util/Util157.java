package su.energyclient.util;

import net.minecraft.text.ClickEvent;
import net.minecraft.text.ClickEvent.Action;

public class Util157 implements ClickEvent {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Action f_10921;
   private final String f_10922;

   public Action getAction() {
      return this.f_10921;
   }

   public String getValue() {
      return this.f_10922;
   }

   public Util157(Action var1, String var2) {
      this.f_10921 = var1;
      this.f_10922 = var2;
   }
}
