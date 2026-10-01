package su.energyclient.module.render;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util20;

public class ViewModel extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final NumberSetting f_11026;
   public final NumberSetting f_11027;
   public final NumberSetting f_11028;
   public final NumberSetting f_11029;
   public final NumberSetting f_11030;
   public final NumberSetting f_11031;
   public final BooleanSetting f_11032;
   private static final String f_11033 = "View Model";
   private static final String f_11034 = "Позволяет изменить положение рук";
   private static final String f_11035 = "Правая рука X";
   private static final float f_11036 = -2.0F;
   private static final float f_11037 = 0.1F;
   private static final String f_11038 = "Правая рука Y";
   private static final float f_11039 = -2.0F;
   private static final float f_11040 = 0.1F;
   private static final String f_11041 = "Правая рука Z";
   private static final float f_11042 = -2.0F;
   private static final float f_11043 = 0.1F;
   private static final String f_11044 = "Левая рука X";
   private static final float f_11045 = -2.0F;
   private static final float f_11046 = 0.1F;
   private static final String f_11047 = "Левая рука Y";
   private static final float f_11048 = -2.0F;
   private static final float f_11049 = 0.1F;
   private static final String f_11050 = "Левая рука Z";
   private static final float f_11051 = -2.0F;
   private static final float f_11052 = 0.1F;
   private static final String f_11053 = "Только с аурой";

   public ViewModel() {
      super(f_11033, f_11034, Category.RENDER);
      this.f_11026 = new NumberSetting(f_11035, 0.0F, f_11036, 2.0F, f_11037);
      this.f_11027 = new NumberSetting(f_11038, 0.0F, f_11039, 2.0F, f_11040);
      this.f_11028 = new NumberSetting(f_11041, 0.0F, f_11042, 2.0F, f_11043);
      this.f_11029 = new NumberSetting(f_11044, 0.0F, f_11045, 2.0F, f_11046);
      this.f_11030 = new NumberSetting(f_11047, 0.0F, f_11048, 2.0F, f_11049);
      this.f_11031 = new NumberSetting(f_11050, 0.0F, f_11051, 2.0F, f_11052);
      this.f_11032 = new BooleanSetting(f_11053, false);
   }

   private boolean O() {
      if (!this.f_11032.m_1163()) {
         return true;
      } else {
         AttackAura var1 = InitManager.f_2740.f_2741.attackAura;
         return var1 != null && var1.m_891() != null;
      }
   }

   @EventHandler
   public void m_669(Util20 var1) {
      if (this.O()) {
         MatrixStack var2 = var1.m_486();
         if (var1.m_2883() == Arm.RIGHT) {
            var2.translate(this.f_11026.m_4046(), this.f_11027.m_4046(), this.f_11028.m_4046());
         } else {
            var2.translate(this.f_11029.m_4046(), this.f_11030.m_4046(), this.f_11031.m_4046());
         }
      }
   }
}
