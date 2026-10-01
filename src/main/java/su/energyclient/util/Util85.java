package su.energyclient.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import su.energyclient.manager.InitManager;

public final class Util85 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final ConcurrentMap<Class<? extends Util31>, Util31> f_5724 = new ConcurrentHashMap<>();
   private static final String f_5725 = "This is a utility class and cannot be instantiated";

   public static <T extends Util31> T m_1797(Class<T> var0) {
      return (T)var0.cast(f_5724.computeIfAbsent(var0, var0x -> InitManager.f_2740.f_2747.m_2975((Class<? extends Util31>)var0x)));
   }

   private Util85() {
      throw new UnsupportedOperationException(f_5725);
   }
}
