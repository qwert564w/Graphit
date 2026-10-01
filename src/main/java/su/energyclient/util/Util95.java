package su.energyclient.util;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.Settings;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.pathing.goals.GoalNear;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.process.IBuilderProcess;
import baritone.api.schematic.ISchematic;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.EventHandler;

public class Util95 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private boolean f_6140;

   public static void m_3955(int var0, int var1) {
      m_3951(new GoalXZ(var0, var1));
   }

   public static void m_1717(Entity var0) {
      try {
         m_1583().getFollowProcess().follow(var0::equals);
      } catch (Throwable t) { /* baritone not ready */ }
   }

   public Util95() {
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   public static void m_3356(String var0, ISchematic var1, BlockPos var2) {
      try { m_227().build(var0, var1, var2); } catch (Throwable t) {}
   }

   @EventHandler
   public void m_1973(Util170 var1) {
      if (!this.f_6140) {
         this.f_6140 = true;
         try {
            Settings s = m_2576();
            if (s != null && s.chatControl != null) {
               s.chatControl.value = false;
            }
         } catch (Throwable t) {}
      }
   }

   public static Goal m_1152() {
      try { return m_1583().getPathingBehavior().getGoal(); } catch (Throwable t) { return null; }
   }

   public static Settings m_2576() {
      try { return BaritoneAPI.getSettings(); } catch (Throwable t) { return null; }
   }

   public static boolean m_1591() {
      try { return m_1583().getPathingBehavior().isPathing(); } catch (Throwable t) { return false; }
   }

   public static void m_4051(BlockPos var0, int var1) {
      m_3951(new GoalNear(var0, var1));
   }

   public static void m_3301(int var0, String... var1) {
      try { m_1583().getMineProcess().mineByName(var0, var1); } catch (Throwable t) {}
   }

   public static void m_3206() {
      try { m_1583().getPathingBehavior().cancelEverything(); } catch (Throwable t) {}
   }

   public static boolean m_3722() {
      try { return m_227().isActive(); } catch (Throwable t) { return false; }
   }

   public static String m_3686() {
      try {
         Settings s = m_2576();
         return s != null && s.prefix != null && s.prefix.value != null ? (String) s.prefix.value : "#";
      } catch (Throwable t) { return "#"; }
   }

   public static IBuilderProcess m_227() {
      try { return m_1583().getBuilderProcess(); } catch (Throwable t) { return null; }
   }

   public static IBaritone m_1583() {
      try { return BaritoneAPI.getProvider().getPrimaryBaritone(); } catch (Throwable t) { return null; }
   }

   public static void m_1869(int var0, int var1, int var2) {
      m_3951(new GoalBlock(var0, var1, var2));
   }

   public static boolean m_3639(String var0) {
      try {
         IBaritone b = m_1583();
         return b != null && b.getCommandManager() != null && b.getCommandManager().execute(var0);
      } catch (Throwable t) { return false; }
   }

   public static void m_3951(Goal var0) {
      try { m_1583().getCustomGoalProcess().setGoalAndPath(var0); } catch (Throwable t) {}
   }

   public static void m_1863(BlockPos var0) {
      m_3951(new GoalBlock(var0));
   }
}
