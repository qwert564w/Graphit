package su.energyclient.module.movement;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util133;

public class ElytraSample extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final ModeSetting f_768;
   public final NumberSetting f_769;
   public final BooleanSetting f_770;
   private static final String f_771 = "Elytra Sample";
   private static final String f_772 = "Режим точки предикта";
   private static final String f_773 = "Плавная";
   private static final String f_774 = "Плавная";
   private static final String f_775 = "Резкая";
   private static final String f_776 = "Сила предикта";
   private static final float f_777 = 2.5F;
   private static final float f_778 = 0.5F;
   private static final float f_779 = 5.0F;
   private static final float f_780 = 0.5F;
   private static final String f_781 = "Показывать предикт";
   private static final String f_782 = "Плавная";

   @Override
   public void m_1() {
      super.m_1();
      Util133.m_805();
   }

   public Vec3d m_699(LivingEntity var1, Vec3d var2) {
      if (var1 == null) {
         return Vec3d.ZERO;
      } else {
         Vec3d var3 = var1.getEntityPos();
         return this.m_2961(var1, var3, var2).subtract(var3).normalize();
      }
   }

   public ElytraSample() {
      super(f_771, "", Category.MOVEMENT);
      this.f_768 = new ModeSetting(f_772, f_773, f_774, f_775);
      this.f_769 = new NumberSetting(f_776, f_777, f_778, f_779, f_780);
      this.f_770 = new BooleanSetting(f_781, true);
   }

   @Override
   public void m_2() {
      super.m_2();
      Util133.m_805();
   }

   public Vec3d m_2961(LivingEntity var1, Vec3d var2, Vec3d var3) {
      if (!this.m_677() || var1 == null || var2 == null) {
         return var2;
      } else {
         return !var1.isGliding() ? var2 : Util133.m_1391(var1, var2, var3, this.f_769.m_4046(), this.f_768.m_2073(f_782));
      }
   }
}
