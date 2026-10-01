package su.energyclient.manager.impl;

import java.util.HashMap;
import su.energyclient.EnergyClient;
import su.energyclient.util.Util31;
import su.energyclient.util.Util49;
import su.energyclient.util.Util54;
import su.energyclient.util.Util9;
import su.energyclient.util.Util91;

public final class MacroManager extends HashMap<Class<? extends Util31>, Util31> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public void m_3226() {
      this.m_1479(new Util49(), new Util54(), new Util9(), new Util91());
      this.values().forEach(var0 -> EnergyClient.f_1622.f_1624.m_32(var0));
   }

   public void m_1479(Util31... var1) {
      for (Util31 var5 : var1) {
         this.put((Class<? extends Util31>)var5.getClass(), var5);
      }
   }

   public <T extends Util31> T m_2975(Class<T> var1) {
      return this.values().stream().filter(var1x -> var1x.getClass() == var1).map(var1::cast).findFirst().orElse(null);
   }
}
