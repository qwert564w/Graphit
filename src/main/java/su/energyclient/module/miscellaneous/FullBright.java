package su.energyclient.module.miscellaneous;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util170;

public class FullBright extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_2415 = "Full Bright";
   private static final String f_2416 = "See in the dark";
   private static final int f_2417 = 9999999;

   @Override
   public void m_1() {
      super.m_1();
      f_5909.player.removeStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION).getEffectType());
   }

   public FullBright() {
      super(f_2415, f_2416, Category.MISCELLANEOUS);
   }

   @EventHandler
   public void m_3824(Util170 var1) {
      f_5909.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, f_2417, 1));
   }
}
