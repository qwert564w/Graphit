package su.energyclient.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import su.energyclient.util.Util109;
import su.energyclient.util.Util136;
import su.energyclient.util.Util44;
import su.energyclient.util.Util65;
import su.energyclient.util.Util78;

public class EventBus implements Util109 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Map<Object, List<Util65>> f_5061 = new ConcurrentHashMap<>();
   private final Map<Class<?>, List<Util65>> f_5062 = new ConcurrentHashMap<>();
   private final Map<Class<?>, List<Util65>> f_5063 = new ConcurrentHashMap<>();
   private final List<EventBus.od0aegD2ptmZSMJQ> O = new ArrayList<>();

   @Override
   public void m_45(String var1, Util78.umVUzGHV95xe8DOi var2) {
      synchronized (this.O) {
         this.O.add(new EventBus.od0aegD2ptmZSMJQ(var1, var2));
      }
   }

   private void m_877(Util65 var1, boolean var2) {
      if (var2) {
         if (var1.m_22()) {
            this.m_611(this.f_5063.computeIfAbsent(var1.m_29(), var0 -> new CopyOnWriteArrayList<>()), var1);
         }
      } else {
         this.m_611(this.f_5063.computeIfAbsent(var1.m_29(), var0 -> new CopyOnWriteArrayList<>()), var1);
      }
   }

   private List<Util65> m_278(Class<?> var1, Object var2) {
      Function var3 = var3x -> {
         CopyOnWriteArrayList var4 = new CopyOnWriteArrayList();
         this.m_2299(var4, var1, var2);
         return var4;
      };
      if (var2 == null) {
         return this.f_5062.computeIfAbsent(var1, var3);
      } else {
         for (Object var5 : this.f_5061.keySet()) {
            if (var5 == var2) {
               return this.f_5061.get(var2);
            }
         }

         List var6 = (List)var3.apply(var2);
         this.f_5061.put(var2, var6);
         return var6;
      }
   }

   @Override
   public <T extends Util44> T m_24(T var1) {
      List<Util65> var2 = this.f_5063.get(var1.getClass());
      if (var2 != null) {
         var1.m_2092(false);

         for (Util65 var4 : var2) {
            var4.m_53(var1);
            if (var1.m_3269()) {
               break;
            }
         }
      }

      return (T)var1;
   }

   private void m_2299(List<Util65> var1, Class<?> var2, Object var3) {
      for (Method var7 : var2.getDeclaredMethods()) {
         if (this.m_1025(var7)) {
            var1.add(new Util78(this.m_3402(var2), var2, var3, var7));
         }
      }

      if (var2.getSuperclass() != null) {
         this.m_2299(var1, var2.getSuperclass(), var3);
      }
   }

   private void m_81(List<Util65> var1, boolean var2) {
      for (Util65 var4 : var1) {
         this.m_877(var4, var2);
      }
   }

   @Override
   public void m_50(Class<?> var1) {
      this.m_2490(this.m_278(var1, null), true);
   }

   @Override
   public void m_52(Object var1) {
      this.m_2490(this.m_278(var1.getClass(), var1), false);
   }

   @Override
   public void m_43(Util65 var1) {
      this.m_3011(var1, false);
   }

   @Override
   public void m_31(Util65 var1) {
      this.m_877(var1, false);
   }

   @Override
   public boolean m_25(Class<?> var1) {
      List var2 = this.f_5063.get(var1);
      return var2 != null && !var2.isEmpty();
   }

   @Override
   public <T> T m_30(T var1) {
      List<Util65> var2 = this.f_5063.get(var1.getClass());
      if (var2 != null) {
         for (Util65 var4 : var2) {
            var4.m_53(var1);
         }
      }

      return (T)var1;
   }

   private void m_611(List<Util65> var1, Util65 var2) {
      int var3 = 0;

      while (var3 < var1.size() && var2.m_48() <= ((Util65)var1.get(var3)).m_48()) {
         var3++;
      }

      var1.add(var3, var2);
   }

   @Override
   public void m_32(Object var1) {
      this.m_81(this.m_278(var1.getClass(), var1), false);
   }

   private void m_2490(List<Util65> var1, boolean var2) {
      for (Util65 var4 : var1) {
         this.m_3011(var4, var2);
      }
   }

   private Util78.umVUzGHV95xe8DOi m_3402(Class<?> var1) {
      synchronized (this.O) {
         for (EventBus.od0aegD2ptmZSMJQ var4 : this.O) {
            if (var1.getName().startsWith(var4.f_11092)) {
               return var4.f_11093;
            }
         }
      }

      throw new Util136(var1);
   }

   private void m_3011(Util65 var1, boolean var2) {
      List var3 = this.f_5063.get(var1.m_29());
      if (var3 != null) {
         if (var2) {
            if (var1.m_22()) {
               var3.remove(var1);
            }
         } else {
            var3.remove(var1);
         }
      }
   }

   private boolean m_1025(Method var1) {
      if (!var1.isAnnotationPresent(EventHandler.class)) {
         return false;
      } else if (var1.getReturnType() != void.class) {
         return false;
      } else {
         return var1.getParameterCount() != 1 ? false : !var1.getParameters()[0].getType().isPrimitive();
      }
   }

   @Override
   public void m_26(Class<?> var1) {
      this.m_81(this.m_278(var1, null), true);
   }

   private static class od0aegD2ptmZSMJQ {
      public final String f_11092;
      public final Util78.umVUzGHV95xe8DOi f_11093;

      public od0aegD2ptmZSMJQ(String var1, Util78.umVUzGHV95xe8DOi var2) {
         this.f_11092 = var1;
         this.f_11093 = var2;
      }
   }
}
