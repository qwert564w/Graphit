package su.energyclient.module.movement;

import net.minecraft.util.math.MathHelper;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util117;
import su.energyclient.util.Util166;
import su.energyclient.util.Util170;

public class Timer extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public NumberSetting f_560;
   public BooleanSetting f_561;
   public NumberSetting f_562;
   public float f_563;
   public float f_564;
   private float f_565;
   private float f_566;
   private float f_567;
   private float f_568;
   private float f_569;
   private static final String f_570 = "Timer";
   private static final String f_571 = "Изменяет скорость игры";
   private static final String f_572 = "Скорость";
   private static final float f_573 = 1.8F;
   private static final float f_574 = 5.0F;
   private static final float f_575 = 0.1F;
   private static final String f_576 = "Умный";
   private static final String f_577 = "Скорость убывания";
   private static final float f_578 = 0.5F;
   private static final float f_579 = 3.0F;
   private static final float f_580 = 0.1F;
   private static final float f_581 = 100.0F;
   private static final float f_582 = 10.0F;
   private static final float f_583 = 10.0F;

   @EventHandler
   private void m_1253(Util170 var1) {
      if (this.f_561.m_1163()) {
         if (this.f_564 > f_582) {
            Util117.f_13187 = this.f_560.m_134().floatValue();
         } else {
            Util117.f_13187 = 1.0F;
         }
      } else {
         Util117.f_13187 = this.f_560.m_134().floatValue();
      }

      if (this.f_564 < f_583 && this.f_561.m_1163()) {
         this.m_680();
      }
   }

   @EventHandler
   private void m_1715(Util166 var1) {
      this.m_3215((float)var1.m_705(), (float)var1.m_971(), (float)var1.m_3049(), var1.m_1603(), var1.m_921());
   }

   private boolean m_3213(float var1, float var2, float var3, float var4, float var5) {
      return var1 == this.f_565 && var2 == this.f_566 && var3 == this.f_567 && var4 == this.f_568 && var5 == this.f_569;
   }

   public Timer() {
      super(f_570, f_571, Category.MOVEMENT);
      this.f_560 = new NumberSetting(f_572, f_573, 1.0F, f_574, f_575);
      this.f_561 = new BooleanSetting(f_576, true);
      this.f_562 = new NumberSetting(f_577, 1.0F, f_578, f_579, f_580).m_356(() -> this.f_561.m_1163());
      this.f_563 = f_581;
      this.f_564 = 0.0F;
   }

   public void m_3215(float var1, float var2, float var3, float var4, float var5) {
      if (this.m_3213(var1, var2, var3, var4, var5)) {
         this.f_564 += 2.0F;
      } else {
         this.f_564 = this.f_564 - this.f_560.m_134().floatValue() * 2.0F * this.f_562.m_134().floatValue();
      }

      this.f_564 = MathHelper.clamp(this.f_564, 0.0F, this.f_563);
      this.f_565 = var1;
      this.f_566 = var2;
      this.f_567 = var3;
      this.f_568 = var4;
      this.f_569 = var5;
   }

   @Override
   public void m_1() {
      Util117.f_13187 = 1.0F;
      super.m_1();
   }

   @Override
   public void m_2() {
      this.f_564 = 0.0F;
      super.m_2();
   }
}
