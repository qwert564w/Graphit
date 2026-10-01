package su.energyclient.module.movement;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util166;
import su.energyclient.util.Util170;
import su.energyclient.util.Util49;
import su.energyclient.util.Util54;

public class ElytraDesync extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final String f_10409 = "Реал";
   public static final String f_10410 = "";
   public final ModeSetting f_10411;
   public final NumberSetting f_10412;
   public final NumberSetting f_10413;
   public final BooleanSetting f_10414;
   public final NumberSetting f_10415;
   public final NumberSetting f_10416;
   public final BooleanSetting f_10417;
   public final NumberSetting f_10418;
   private double f_10419;
   private float f_10420;
   private float f_10421;
   private float f_10422;
   private float f_10423;
   private static final String f_10424 = "Elytra Desync";
   private static final String f_10425 = "Ломает перегон врага на элитре чтобы ливнуть. Реал = безопасно для Grim";
   private static final String f_10426 = "Режим";
   private static final String f_10427 = "Реал";
   private static final String f_10428 = "Реал";
   private static final String f_10429 = "Пакет";
   private static final String f_10430 = "Сила yaw";
   private static final float f_10431 = 25.0F;
   private static final float f_10432 = 5.0F;
   private static final float f_10433 = 60.0F;
   private static final String f_10434 = "Скорость виляния";
   private static final float f_10435 = 0.35F;
   private static final float f_10436 = 0.05F;
   private static final float f_10437 = 0.05F;
   private static final String f_10438 = "Вилять питчем";
   private static final String f_10439 = "Сила питч";
   private static final float f_10440 = 8.0F;
   private static final float f_10441 = 25.0F;
   private static final String f_10442 = "Мин. скорость";
   private static final float f_10443 = 15.0F;
   private static final float f_10444 = 40.0F;
   private static final String f_10445 = "Только если враг рядом";
   private static final String f_10446 = "Радиус врага";
   private static final float f_10447 = 30.0F;
   private static final float f_10448 = 5.0F;
   private static final float f_10449 = 64.0F;
   private static final String f_10450 = "Реал";
   private static final double f_10451 = Math.PI / 2;
   private static final float f_10452 = 360.0F;
   private static final float f_10453 = -90.0F;
   private static final float f_10454 = 90.0F;
   private static final float f_10455 = 360.0F;
   private static final String f_10456 = "Пакет";
   private static final float f_10457 = 1.0E-4F;
   private static final double f_10458 = Math.PI / 2;
   private static final float f_10459 = -90.0F;
   private static final float f_10460 = 90.0F;
   private static final float f_10461 = 1.0E-4F;
   private static final double f_10462 = 20.0;
   private static final float f_10463 = -90.0F;
   private static final float f_10464 = 90.0F;

   @Override
   public void m_1() {
      this.m_1212();
      this.m_3879();
      super.m_1();
   }

   @EventHandler
   public void m_2798(Util166 var1) {
      if (f_5909.player != null && this.m_677() && this.f_10411.m_2073(f_10456) && this.m_1566()) {
         this.f_10419 = this.f_10419 + this.f_10413.m_4046();
         float var2 = var1.m_1603() + (float)(this.f_10412.m_4046() * Math.sin(this.f_10419));
         if (var2 == this.f_10422) {
            var2 += f_10457;
         }

         var1.m_3905(var2);
         this.f_10422 = var2;
         if (this.f_10414.m_1163()) {
            float var3 = MathHelper.clamp(var1.m_921() + (float)(this.f_10415.m_4046() * Math.sin(this.f_10419 + f_10458)), f_10459, f_10460);
            if (var3 == this.f_10423) {
               var3 += f_10461;
            }

            var1.m_764(var3);
            this.f_10423 = var3;
         }
      }
   }

   @EventHandler
   public void m_2105(Util170 var1) {
      if (f_5909.player != null) {
         if (this.m_677() && this.f_10411.m_2073(f_10450) && this.m_1566()) {
            this.f_10419 = this.f_10419 + this.f_10413.m_4046();
            float var2 = (float)(this.f_10412.m_4046() * Math.sin(this.f_10419));
            float var3 = this.f_10414.m_1163() ? (float)(this.f_10415.m_4046() * Math.sin(this.f_10419 + f_10451)) : 0.0F;
            float var4 = f_5909.player.getYaw() - this.f_10420;
            Util54.m_3501(new Util10(var4 + var2, Util49.m_3811()), f_10452, 1, 8);
            this.f_10420 = var2;
            float var5 = f_5909.player.getPitch() - this.f_10421;
            float var6 = MathHelper.clamp(var5 + var3, f_10453, f_10454);
            Util54.m_3501(new Util10(Util49.m_883(), var6), f_10455, 1, 9);
            this.f_10421 = var6 - var5;
         } else {
            this.m_1212();
         }
      }
   }

   private boolean m_745() {
      if (!this.f_10417.m_1163()) {
         return true;
      } else if (f_5909.world == null) {
         return false;
      } else {
         double var1 = this.f_10418.m_4046();

         for (AbstractClientPlayerEntity var4 : f_5909.world.getPlayers()) {
            if (var4 != f_5909.player && var4.isAlive() && f_5909.player.distanceTo(var4) <= var1) {
               return true;
            }
         }

         return false;
      }
   }

   private void m_1212() {
      if (f_5909.player != null && (this.f_10420 != 0.0F || this.f_10421 != 0.0F)) {
         f_5909.player.setYaw(f_5909.player.getYaw() - this.f_10420);
         float var1 = f_5909.player.getPitch() - this.f_10421;
         f_5909.player.setPitch(MathHelper.clamp(var1, f_10463, f_10464));
      }

      this.f_10420 = 0.0F;
      this.f_10421 = 0.0F;
   }

   private boolean m_1566() {
      if (!f_5909.player.isGliding()) {
         return false;
      } else {
         Vec3d var1 = f_5909.player.getVelocity();
         double var2 = Math.sqrt(var1.x * var1.x + var1.z * var1.z) * f_10462;
         return var2 < this.f_10416.m_4046() ? false : this.m_745();
      }
   }

   private void m_3879() {
      this.f_10419 = 0.0;
      this.f_10420 = 0.0F;
      this.f_10421 = 0.0F;
      this.f_10422 = Float.NaN;
      this.f_10423 = Float.NaN;
   }

   public ElytraDesync() {
      super(f_10424, f_10425, Category.MOVEMENT);
      this.f_10411 = new ModeSetting(f_10426, f_10427, f_10428, f_10429);
      this.f_10412 = new NumberSetting(f_10430, f_10431, f_10432, f_10433, 1.0F);
      this.f_10413 = new NumberSetting(f_10434, f_10435, f_10436, 1.0F, f_10437);
      this.f_10414 = new BooleanSetting(f_10438, false);
      this.f_10415 = new NumberSetting(f_10439, f_10440, 1.0F, f_10441, 1.0F).m_356(this.f_10414::m_1163);
      this.f_10416 = new NumberSetting(f_10442, f_10443, 0.0F, f_10444, 1.0F);
      this.f_10417 = new BooleanSetting(f_10445, true);
      this.f_10418 = new NumberSetting(f_10446, f_10447, f_10448, f_10449, 1.0F).m_356(this.f_10417::m_1163);
      this.f_10422 = Float.NaN;
      this.f_10423 = Float.NaN;
   }

   @Override
   public void m_2() {
      super.m_2();
      this.m_3879();
   }
}
