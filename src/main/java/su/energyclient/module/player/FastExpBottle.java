package su.energyclient.module.player;

import net.minecraft.item.Items;
import su.energyclient.event.EventHandler;
import su.energyclient.mixin.MinecraftClientMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util101;
import su.energyclient.util.Util170;

public class FastExpBottle extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BooleanSetting f_8747;
   private final NumberSetting f_8748;
   private static final String f_8749 = "Fast Exp Bottle";
   private static final String f_8750 = "Позволяет быстро бросать пузырьки опыта";
   private static final String f_8751 = "Только без пвп режима";
   private static final String f_8752 = "Задержка";
   private static final float f_8753 = 3.0F;

   @EventHandler
   public void m_2191(Util170 var1) {
      if (!this.f_8747.m_1163() || !Util101.m_2329()) {
         if (f_5909.player.getMainHandStack().getItem() == Items.EXPERIENCE_BOTTLE) {
            ((MinecraftClientMixin2)f_5909).setItemUseCooldown(this.f_8748.m_134().intValue());
         }
      }
   }

   public FastExpBottle() {
      super(f_8749, f_8750, Category.PLAYER);
      this.f_8747 = new BooleanSetting(f_8751, true);
      this.f_8748 = new NumberSetting(f_8752, 1.0F, 0.0F, f_8753, 1.0F);
   }
}
