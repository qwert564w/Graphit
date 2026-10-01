package su.energyclient.util;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;
import su.energyclient.event.EventHandler;

public class Util78 implements Util65 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static boolean f_5858;
   private static Constructor<Lookup> f_5859;
   private static Method f_5860;
   private final Class<?> f_5861;
   private final boolean f_5862;
   private final int f_5863;
   private Consumer<Object> f_5864;
   private static final String f_5865 = "accept";
   private static final String f_5866 = "java.version";
   private static final String f_5867 = "1.8";
   private static final String f_5868 = "privateLookupIn";

   @Override
   public int m_48() {
      return this.f_5863;
   }

   @Override
   public void m_53(Object var1) {
      this.f_5864.accept(var1);
   }

   static {
      try {
         f_5858 = System.getProperty(f_5866).startsWith(f_5867);
         if (f_5858) {
            f_5859 = Lookup.class.getDeclaredConstructor(Class.class);
         } else {
            f_5860 = MethodHandles.class.getDeclaredMethod(f_5868, Class.class, Lookup.class);
         }
      } catch (NoSuchMethodException var1) {
         var1.printStackTrace();
      }
   }

   @Override
   public boolean m_22() {
      return this.f_5862;
   }

   public Util78(Util78.umVUzGHV95xe8DOi var1, Class<?> var2, Object var3, Method var4) {
      this.f_5861 = var4.getParameters()[0].getType();
      this.f_5862 = Modifier.isStatic(var4.getModifiers());
      this.f_5863 = var4.getAnnotation(EventHandler.class).priority();

      try {
         String var5 = var4.getName();
         Lookup var6;
         if (f_5858) {
            boolean var7 = f_5859.isAccessible();
            f_5859.setAccessible(true);
            var6 = f_5859.newInstance(var2);
            f_5859.setAccessible(var7);
         } else {
            var6 = var1.m_1108(f_5860, var2);
         }

         MethodType var12 = MethodType.methodType(void.class, var4.getParameters()[0].getType());
         MethodHandle var8;
         MethodType var9;
         if (this.f_5862) {
            var8 = var6.findStatic(var2, var5, var12);
            var9 = MethodType.methodType(Consumer.class);
         } else {
            var8 = var6.findVirtual(var2, var5, var12);
            var9 = MethodType.methodType(Consumer.class, var2);
         }

         MethodHandle var10 = LambdaMetafactory.metafactory(var6, f_5865, var9, MethodType.methodType(void.class, Object.class), var8, var12).getTarget();
         if (this.f_5862) {
            this.f_5864 = (Consumer)var10.invoke();
         } else {
            this.f_5864 = (Consumer)var10.invoke((Object)var3);
         }
      } catch (Throwable var11) {
         var11.printStackTrace();
      }
   }

   @Override
   public Class<?> m_29() {
      return this.f_5861;
   }

   public interface umVUzGHV95xe8DOi {
      Lookup m_1108(Method var1, Class<?> var2) throws IllegalAccessException, InvocationTargetException;
   }
}
