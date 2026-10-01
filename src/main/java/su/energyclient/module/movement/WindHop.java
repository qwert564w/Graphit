package su.energyclient.module.movement;

import net.minecraft.item.Items;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;
import su.energyclient.util.Util54;

public class WindHop extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_6788;
   private final RenderUtil22 f_6789;
   private boolean f_6790;
   private static final String f_6791 = "Wind Hop";
   private static final String f_6792 = "description";
   private static final String f_6793 = "Мод";
   private static final String f_6794 = "По бинду";
   private static final String f_6795 = "По бинду";
   private static final String f_6796 = "Автоматический";
   private static final String f_6797 = "Бинд";
   private static final float f_6798 = 90.0F;
   private static final String f_6799 = "По бинду";
   private static final float f_6800 = 360.0F;
   private static final String f_6801 = "Автоматический";
   private static final float f_6802 = 360.0F;
   private static final String f_6803 = "По бинду";
   private static final String f_6804 = "По бинду";

   @EventHandler
   public void m_3030(Util170 var1) {
      float var2 = f_6798;
      int var3 = Util146.m_1302(Items.WIND_CHARGE);
      if (var3 != -1) {
         if (this.f_6788.m_2073(f_6799) && f_5909.player.isOnGround() && this.f_6790) {
            Util54.m_3501(new Util10(f_5909.player.getYaw(), var2), f_6800, 1, 19);
            f_5909.player.jump();
            Util146.m_2425(Items.WIND_CHARGE);
            this.f_6790 = false;
         }

         if (this.f_6788.m_2073(f_6801) && f_5909.player.isOnGround()) {
            Util54.m_3501(new Util10(f_5909.player.getYaw(), var2), f_6802, 1, 19);
            f_5909.player.jump();
            Util146.m_2425(Items.WIND_CHARGE);
         }
      }
   }

   @EventHandler
   public void m_3679(CancellableEvent var1) {
      if (!var1.m_3546()) {
         if (this.f_6788.m_2073(f_6803) && var1.m_2169() == this.f_6789.m_1958()) {
            if (this.f_6789.m_766() == RenderUtil22.pqYfuJa0oJD2nAQv.TOGGLE) {
               if (var1.m_1362()) {
                  this.f_6790 = true;
               }
            } else if (this.f_6789.m_766() == RenderUtil22.pqYfuJa0oJD2nAQv.HOLD) {
               this.f_6790 = true;
            }
         }
      }
   }

   public WindHop() {
      super(f_6791, f_6792, Category.MOVEMENT);
      this.f_6788 = new ModeSetting(f_6793, f_6794, f_6795, f_6796);
      this.f_6789 = new RenderUtil22(f_6797, -1).m_2895(() -> this.f_6788.m_2073(f_6804));
   }
}
