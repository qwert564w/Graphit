package su.energyclient.module.movement;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;

public class ElytraResolver extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final long f_5159 = 2000L;
   public final NumberSetting f_5160;
   public final NumberSetting f_5161;
   public final NumberSetting f_5162;
   public final ModeSetting f_5163;
   public final BooleanSetting f_5164;
   private ElytraResolver.nt5VPIusgGquaiOG f_5165;
   private LivingEntity f_5166;
   private Vec3d f_5167;
   private long f_5168;
   private boolean f_5169;
   private static final String f_5170 = "Elytra Resolver";
   private static final String f_5171 = "Долет и отлет для элитра-ротки";
   private static final String f_5172 = "Долет";
   private static final float f_5173 = 3.0F;
   private static final float f_5174 = 1.5F;
   private static final float f_5175 = 6.0F;
   private static final float f_5176 = 0.1F;
   private static final String f_5177 = "Отлет";
   private static final float f_5178 = 8.0F;
   private static final float f_5179 = 4.0F;
   private static final float f_5180 = 16.0F;
   private static final float f_5181 = 0.5F;
   private static final String f_5182 = "Угол отлета";
   private static final float f_5183 = 50.0F;
   private static final float f_5184 = 90.0F;
   private static final String f_5185 = "Режим отлета";
   private static final String f_5186 = "В сторону";
   private static final String f_5187 = "В сторону";
   private static final String f_5188 = "Вверх";
   private static final String f_5189 = "Диагональ";
   private static final String f_5190 = "Чередовать стороны";
   private static final long f_5191 = 2000L;
   private static final double f_5192 = 1.0E-6;
   private static final double f_5193 = 1.0E-6;
   private static final double f_5194 = -1.0;
   private static final double f_5195 = 1.0E-6;
   private static final String f_5196 = "Вверх";
   private static final String f_5197 = "Диагональ";
   private static final double f_5198 = 0.55;
   private static final double f_5199 = 0.25;
   private static final double f_5200 = 0.06;

   private void m_338() {
      this.f_5165 = ElytraResolver.nt5VPIusgGquaiOG.RETREATING;
      this.f_5167 = null;
      this.f_5168 = System.currentTimeMillis();
   }

   @Override
   public void m_2() {
      super.m_2();
      this.m_2225();
   }

   @Override
   public void m_1() {
      super.m_1();
      this.m_2225();
   }

   public ElytraResolver() {
      super(f_5170, f_5171, Category.MOVEMENT);
      this.f_5160 = new NumberSetting(f_5172, f_5173, f_5174, f_5175, f_5176);
      this.f_5161 = new NumberSetting(f_5177, f_5178, f_5179, f_5180, f_5181);
      this.f_5162 = new NumberSetting(f_5182, f_5183, 0.0F, f_5184, 1.0F);
      this.f_5163 = new ModeSetting(f_5185, f_5186, f_5187, f_5188, f_5189);
      this.f_5164 = new BooleanSetting(f_5190, true);
      this.f_5165 = ElytraResolver.nt5VPIusgGquaiOG.APPROACHING;
   }

   public Vec3d m_2746(LivingEntity var1, Vec3d var2) {
      if (f_5909.player == null || var1 == null || var2 == null) {
         return var2;
      } else if (!f_5909.player.isGliding()) {
         this.m_2225();
         return var2;
      } else {
         if (var1 != this.f_5166) {
            this.f_5166 = var1;
            this.f_5165 = ElytraResolver.nt5VPIusgGquaiOG.APPROACHING;
            this.f_5167 = null;
            this.f_5168 = System.currentTimeMillis();
         }

         double var3 = f_5909.player.getEntityPos().add(0.0, var1.getHeight() / 2.0F, 0.0).distanceTo(var2);
         if (this.f_5165 == ElytraResolver.nt5VPIusgGquaiOG.APPROACHING && var3 <= this.f_5160.m_4046()) {
            this.m_338();
         } else if (this.f_5165 == ElytraResolver.nt5VPIusgGquaiOG.RETREATING) {
            boolean var5 = var3 >= this.f_5161.m_4046();
            boolean var6 = System.currentTimeMillis() - this.f_5168 > f_5191;
            if (var5 || var6) {
               this.m_710();
            }
         }

         if (this.f_5165 == ElytraResolver.nt5VPIusgGquaiOG.APPROACHING) {
            return var2;
         } else {
            if (this.f_5167 == null || this.f_5167.lengthSquared() < f_5192) {
               this.f_5167 = this.m_2302(var2, f_5909.player.getEntityPos());
            }

            return var2.add(this.f_5167.multiply(this.f_5161.m_4046()));
         }
      }
   }

   private void m_710() {
      this.f_5165 = ElytraResolver.nt5VPIusgGquaiOG.APPROACHING;
      this.f_5167 = null;
      this.f_5168 = System.currentTimeMillis();
   }

   public void m_2225() {
      this.f_5165 = ElytraResolver.nt5VPIusgGquaiOG.APPROACHING;
      this.f_5166 = null;
      this.f_5167 = null;
      this.f_5168 = 0L;
   }

   private Vec3d m_2302(Vec3d var1, Vec3d var2) {
      Vec3d var3 = var2.subtract(var1);
      var3 = new Vec3d(var3.x, 0.0, var3.z);
      if (var3.lengthSquared() < f_5193) {
         Vec3d var4 = f_5909.player.getRotationVector().multiply(f_5194);
         var3 = new Vec3d(var4.x, 0.0, var4.z);
      }

      if (var3.lengthSquared() < f_5195) {
         var3 = new Vec3d(0.0, 0.0, 1.0);
      }

      var3 = var3.normalize();
      double var18 = this.f_5162.m_4046();
      if (this.f_5164.m_1163()) {
         var18 = this.f_5169 ? var18 : -var18;
         this.f_5169 = !this.f_5169;
      }

      double var6 = Math.toRadians(var18);
      double var8 = var3.x * Math.cos(var6) - var3.z * Math.sin(var6);
      double var10 = var3.x * Math.sin(var6) + var3.z * Math.cos(var6);
      String var14 = this.f_5163.m_3862();

      double var12 = switch (var14) {
         case f_5196 -> f_5198;
         case f_5197 -> f_5199;
         default -> f_5200;
      };
      return new Vec3d(var8, var12, var10).normalize();
   }

   public void m_1515(LivingEntity var1) {
      if (var1 != null) {
         if (var1 != this.f_5166) {
            this.f_5166 = var1;
         }

         if (this.f_5165 == ElytraResolver.nt5VPIusgGquaiOG.APPROACHING) {
            this.m_338();
         }
      }
   }

   private static enum nt5VPIusgGquaiOG {
      APPROACHING,
      RETREATING;
   }
}
