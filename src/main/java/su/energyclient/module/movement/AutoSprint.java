package su.energyclient.module.movement;

import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util124;
import su.energyclient.util.Util159;
import su.energyclient.util.Util170;

public class AutoSprint extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static long f_13080;
   private static boolean f_13081 = true;
   private static final String f_13082 = "Auto Sprint";
   private static final String f_13083 = "Автоматически бегает за вас";

   @EventHandler
   private void m_190(Util124 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (f_5909.player.horizontalCollision && (f_5909.player.input.getMovementInput().y > 0.0F || f_5909.player.input.getMovementInput().x != 0.0F)) {
            f_5909.player.setSprinting(false);
         }
      }
   }

   public AutoSprint() {
      super(f_13082, f_13083, Category.MOVEMENT);
      this.m_1926(true);
   }

   public static void m_1519(boolean var0) {
      f_13081 = var0;
   }

   @EventHandler
   public void m_3871(Util170 var1) {
      if (System.currentTimeMillis() >= f_13080 && !f_13081) {
         f_13081 = true;
         f_13080 = 0L;
      }
   }

   public static void m_824(long var0) {
      f_13080 = var0;
   }

   @EventHandler
   private void m_2292(Util159 var1) {
      if (f_5909.player != null) {
         if (!f_5909.player.horizontalCollision || !(f_5909.player.input.getMovementInput().y > 0.0F) && f_5909.player.input.getMovementInput().x == 0.0F) {
            var1.m_277(true);
         }
      }
   }

   public static long m_3114() {
      return f_13080;
   }

   public static boolean m_1999() {
      return f_13081;
   }
}
