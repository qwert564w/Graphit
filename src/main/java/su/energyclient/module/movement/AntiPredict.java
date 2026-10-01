package su.energyclient.module.movement;

import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util170;

public class AntiPredict extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_2724 = "Anti Predict";
   private static final String f_2725 = "Ломает серверный предикт элитры противника";
   private static final float f_2726 = -30.0F;

   @Override
   public void m_2() {
      super.m_2();
   }

   @EventHandler
   public void m_1383(Util170 var1) {
      if (f_5909.player.isGliding()) {
         f_5909.player.updateTrackedAngles(f_5909.player.getYaw(), f_2726);
      }
   }

   public AntiPredict() {
      super(f_2724, f_2725, Category.MOVEMENT);
   }
}
