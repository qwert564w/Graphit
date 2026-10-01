package su.energyclient.module.combat;

import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util125;
import su.energyclient.util.Util170;

public class BowSpammer extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_8343;
   private final Util125 f_8344;
   private boolean f_8345;
   private Hand f_8346;
   private static final String f_8347 = "Bow Spammer";
   private static final String f_8348 = "Быстрый цикл отпускания и натяжки лука";
   private static final String f_8349 = "Скорость";
   private static final float f_8350 = 250.0F;
   private static final float f_8351 = 1000.0F;

   @EventHandler
   public void m_3420(Util170 var1) {
      if (f_5909.player != null && f_5909.interactionManager != null) {
         if (this.f_8345) {
            if (this.f_8346 != null) {
               f_5909.interactionManager.interactItem(f_5909.player, this.f_8346);
            }

            this.f_8345 = false;
            this.f_8346 = null;
         } else if (f_5909.player.isUsingItem()) {
            if (f_5909.player.getActiveItem().isOf(Items.BOW)) {
               if (f_5909.player.getItemUseTime() >= 3) {
                  if (this.f_8344.m_2636(this.f_8343.m_134().longValue())) {
                     this.f_8346 = f_5909.player.getActiveHand();
                     f_5909.interactionManager.stopUsingItem(f_5909.player);
                     this.f_8345 = true;
                     this.f_8344.m_3493();
                  }
               }
            }
         }
      }
   }

   public BowSpammer() {
      super(f_8347, f_8348, Category.COMBAT);
      this.f_8343 = new NumberSetting(f_8349, f_8350, 1.0F, f_8351, 1.0F);
      this.f_8344 = new Util125();
   }

   @Override
   public void m_1() {
      super.m_1();
      this.f_8345 = false;
      this.f_8346 = null;
   }
}
