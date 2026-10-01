package su.energyclient.manager.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.util.Util169;
import su.energyclient.util.Util170;
import su.energyclient.util.Util47;

public class RotationManager implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Object f_3927 = new Object();
   private static final LinkedList<Util47> f_3928 = new LinkedList<>();
   private static final float f_3929 = 18.0F;
   private static final float f_3930 = 35.0F;

   @EventHandler(
      priority = -200
   )
   public void m_3519(Util169 var1) {
      if (f_5909 != null && f_5909.getWindow() != null) {
         if (InitManager.f_2740.f_2741.notifications.m_677()) {
            int var2 = f_5909.getWindow().getScaledWidth();
            int var3 = f_5909.getWindow().getScaledHeight();
            float var4 = var3 / 2.0F + f_3929;
            ArrayList<Util47> var5;
            synchronized (f_3927) {
               var5 = new ArrayList<>(f_3928);
            }

            for (Util47 var7 : var5) {
               float var8 = var7.m_1189();
               var7.m_3220((var2 - var8) / 2.0F, var4 + f_3930, var1.m_4037());
               var4 += var7.m_3281() + 1.0F;
            }

            synchronized (f_3927) {
               f_3928.removeIf(Util47::m_3899);
            }
         }
      }
   }

   @EventHandler
   public void m_422(Util170 var1) {
      synchronized (f_3927) {
         f_3928.removeIf(Util47::m_3899);
      }
   }

   public RotationManager() {
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   private static void m_267(Util47 var0) {
      synchronized (f_3927) {
         f_3928.addFirst(var0);
         if (f_3928.size() > 10) {
            f_3928.subList(10, f_3928.size()).forEach(Util47::m_3577);
         }
      }
   }

   public static void m_2424(Identifier var0, Text var1, int var2) {
      m_267(new Util47(var0, var1, Integer.valueOf(var2)));
   }

   public static void m_3112(ItemStack var0, Text var1) {
      m_267(new Util47(var0, var1));
   }

   public static void m_260(String var0, String var1, int var2) {
      m_267(new Util47(var0, var1, var2));
   }

   public static boolean m_3201() {
      synchronized (f_3927) {
         return !f_3928.isEmpty();
      }
   }

   public static void m_3074(Identifier var0, Text var1) {
      m_267(new Util47(var0, var1, null));
   }
}
