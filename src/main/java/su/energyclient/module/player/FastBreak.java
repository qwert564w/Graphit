package su.energyclient.module.player;

import su.energyclient.event.EventHandler;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util92;

public class FastBreak extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_10641;
   private static final String f_10642 = "Fast Break";
   private static final String f_10643 = "Позволяет быстрее ломать блоки";
   private static final String f_10644 = "Скорость";
   private static final float f_10645 = 0.8F;
   private static final float f_10646 = 0.1F;
   private static final float f_10647 = 0.1F;

   @EventHandler
   public void m_2816(Util92 var1) {
      if (f_5909.player != null && f_5909.interactionManager != null && !f_5909.player.isCreative()) {
         if (var1.m_3685() == Util92.eYP5T39eaGw7jwf1.START_DESTROY_BLOCK) {
            ClientPlayerInteractionManagerMixin2 var2 = (ClientPlayerInteractionManagerMixin2)f_5909.interactionManager;
            var2.setblockBreakingCooldown(0);
            if (var2.getcurrentBreakingProgress() > this.f_10641.m_4046()) {
               var2.setcurrentBreakingProgress(1.0F);
            }
         }
      }
   }

   public FastBreak() {
      super(f_10642, f_10643, Category.PLAYER);
      this.f_10641 = new NumberSetting(f_10644, f_10645, f_10646, 1.0F, f_10647);
   }
}
