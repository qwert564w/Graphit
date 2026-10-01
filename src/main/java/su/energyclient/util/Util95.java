package su.energyclient.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.EventHandler;

public class Util95 implements QuickImports {
   private boolean f_6140;

   public static void m_3955(int var0, int var1) {}
   public static void m_1717(Entity var0) {}

   public Util95() {
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   public static void m_3356(String var0, Object var1, BlockPos var2) {}

   @EventHandler
   public void m_1973(Util170 var1) {
      if (!this.f_6140) {
         this.f_6140 = true;
      }
   }

   public static Object m_1152() { return null; }
   public static Object m_2576() { return null; }
   public static boolean m_1591() { return false; }
   public static void m_4051(BlockPos var0, int var1) {}
   public static void m_3301(int var0, String... var1) {}
   public static void m_3206() {}
   public static boolean m_3722() { return false; }
   public static String m_3686() { return "#"; }
   public static Object m_227() { return null; }
   public static Object m_1583() { return null; }
   public static void m_1869(int var0, int var1, int var2) {}
   public static boolean m_3639(String var0) { return false; }
   public static void m_3951(Object var0) {}
   public static void m_1863(BlockPos var0) {}
}
