package su.energyclient.module.miscellaneous;

import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util170;

public class TapeMouse extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final ModeSetting O;
   public final NumberSetting f_6296;
   private int f_6297;
   private static final String f_6298 = "Tape Mouse";
   private static final String f_6299 = "Автоматические клики с задержкой";
   private static final String f_6300 = "Клавиша";
   private static final String f_6301 = "Левая";
   private static final String f_6302 = "Левая";
   private static final String f_6303 = "Правая";
   private static final String f_6304 = "Задержка";
   private static final float f_6305 = 30.0F;
   private static final String f_6306 = "Левая";

   private void m_263() {
      f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
   }

   public TapeMouse() {
      super(f_6298, f_6299, Category.MISCELLANEOUS);
      this.O = new ModeSetting(f_6300, f_6301, f_6302, f_6303);
      this.f_6296 = new NumberSetting(f_6304, 1.0F, 1.0F, f_6305, 1.0F);
   }

   private void m_4014() {
      if (f_5909.targetedEntity != null) {
         f_5909.interactionManager.attackEntity(f_5909.player, f_5909.targetedEntity);
         f_5909.player.swingHand(Hand.MAIN_HAND);
      } else {
         if (f_5909.crosshairTarget instanceof BlockHitResult var1 && f_5909.interactionManager.attackBlock(var1.getBlockPos(), var1.getSide())) {
            f_5909.player.swingHand(Hand.MAIN_HAND);
         }
      }
   }

   @EventHandler
   public void m_2201(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
         this.f_6297++;
         if (!(this.f_6297 < this.f_6296.m_4046())) {
            this.f_6297 = 0;
            if (this.O.m_2073(f_6306)) {
               this.m_4014();
            } else {
               this.m_263();
            }
         }
      }
   }
}
