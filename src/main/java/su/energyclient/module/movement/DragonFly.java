package su.energyclient.module.movement;

import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util170;
import su.energyclient.util.Util38;

public class DragonFly extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_751;
   private final NumberSetting f_752;
   private static final String f_753 = "Dragon Fly";
   private static final String f_754 = "description";
   private static final String f_755 = "Скорость XZ";
   private static final float f_756 = 1.1F;
   private static final float f_757 = 0.5F;
   private static final float f_758 = 0.1F;
   private static final String f_759 = "Скорость y";
   private static final float f_760 = 0.3F;
   private static final float f_761 = 0.1F;
   private static final float f_762 = 0.1F;

   @EventHandler
   public void m_3991(Util170 var1) {
      if (f_5909.player.getAbilities().flying) {
         f_5909.player.setVelocity(new Vec3d(f_5909.player.getVelocity().getX(), 0.0, f_5909.player.getVelocity().getZ()));
         if (f_5909.options.jumpKey.isPressed()) {
            f_5909.player
               .setVelocity(
                  new Vec3d(f_5909.player.getVelocity().getX(), f_5909.player.getVelocity().y + this.f_752.m_4046(), f_5909.player.getVelocity().getZ())
               );
         }

         if (f_5909.options.sneakKey.isPressed()) {
            f_5909.player
               .setVelocity(
                  new Vec3d(f_5909.player.getVelocity().getX(), f_5909.player.getVelocity().y - this.f_752.m_4046(), f_5909.player.getVelocity().getZ())
               );
         }

         Util38.m_3702(this.f_751.m_4046());
      }
   }

   public DragonFly() {
      super(f_753, f_754, Category.MOVEMENT);
      this.f_751 = new NumberSetting(f_755, f_756, f_757, 2.0F, f_758);
      this.f_752 = new NumberSetting(f_759, f_760, f_761, 1.0F, f_762);
   }
}
