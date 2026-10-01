package su.energyclient.module.render;

import net.minecraft.client.option.Perspective;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventThirdPersonDistance;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util153;
import su.energyclient.util.Util164;
import su.energyclient.util.Util165;
import su.energyclient.util.Util63;

public class Animations extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_125 = "Таб";
   private static final String f_126 = "";
   private static final String f_127 = "";
   public final Util63 f_128;
   private final Util165 f_129;
   private final Util165 f_130;
   private final Util165 f_131;
   private Perspective f_132;
   private static final String f_133 = "Animations";
   private static final String f_134 = "Анимации интерфейса и камеры";
   private static final String f_135 = "Анимации";
   private static final String f_136 = "Таб";
   private static final String f_137 = "Чат";
   private static final String f_138 = "Перспектива (F5)";
   private static final long f_139 = 220L;
   private static final long f_140 = 380L;
   private static final long f_141 = 280L;
   private static final String f_142 = "Таб";
   private static final String f_143 = "Чат";
   private static final String f_144 = "Перспектива (F5)";
   private static final String f_145 = "Перспектива (F5)";
   private static final float f_146 = 0.2F;
   private static final float f_147 = 0.8F;
   private static final String f_148 = "Чат";
   private static final String f_149 = "Таб";
   private static final String f_150 = "Чат";

   private void m_3549(Util165 var1, double var2) {
      var1.m_2214(var2);
      var1.m_2946(var2);
      var1.m_1829(var2);
      var1.m_1876(System.currentTimeMillis());
      var1.l(true);
   }

   public float m_3230() {
      return this.m_677() && this.f_128.I(f_150) ? this.m_2722(this.f_130.m_2276()) : 0.0F;
   }

   public Animations() {
      super(f_133, f_134, Category.RENDER);
      this.f_128 = new Util63(f_135, BooleanSetting.m_136(f_136, true), BooleanSetting.m_136(f_137, true), BooleanSetting.m_136(f_138, true));
      this.f_129 = new Util165(Util153.EASE_OUT_CUBIC, f_139);
      this.f_130 = new Util165(Util153.EASE_OUT_QUAD, f_140);
      this.f_131 = new Util165(Util153.EASE_OUT_CUBIC, f_141);
      this.f_132 = Perspective.FIRST_PERSON;
   }

   @EventHandler
   public void m_485(Util164 var1) {
      this.f_129.m_3631(this.f_128.I(f_142) && this.m_1156() ? 1.0 : 0.0);
      if (this.f_128.I(f_143)) {
         this.f_130.m_3631(0.0);
      } else {
         this.m_3549(this.f_130, 0.0);
      }

      if (this.f_128.I(f_144)) {
         Perspective var2 = f_5909.options.getPerspective();
         if (var2 != this.f_132) {
            this.f_132 = var2;
            this.m_2356(this.f_131, 0.0, 1.0);
         }

         this.f_131.m_3631(1.0);
      } else {
         this.f_132 = f_5909.options.getPerspective();
         this.m_3549(this.f_131, 1.0);
      }
   }

   @EventHandler
   public void m_3894(EventThirdPersonDistance var1) {
      if (this.f_128.I(f_145)) {
         if (!f_5909.options.getPerspective().isFirstPerson()) {
            float var2 = this.m_2722(this.f_131.m_2276());
            float var3 = f_146 + f_147 * var2;
            var1.m_4098(var1.m_2439() * var3);
         }
      }
   }

   @Override
   public void m_2() {
      super.m_2();
      this.m_3549(this.f_129, this.m_1156() ? 1.0 : 0.0);
      this.m_3549(this.f_130, 0.0);
      this.f_132 = f_5909.options.getPerspective();
      this.m_3549(this.f_131, 1.0);
   }

   public float m_1947() {
      return this.m_677() && this.f_128.I(f_149) ? this.m_2722(this.f_129.m_2276()) : 1.0F;
   }

   private float m_2722(double var1) {
      return (float)Math.max(0.0, Math.min(1.0, var1));
   }

   @Override
   public void m_1() {
      super.m_1();
   }

   public void m_3211() {
      if (this.m_677() && this.f_128.I(f_148)) {
         this.m_3549(this.f_130, 1.0);
         this.f_130.m_3631(0.0);
      }
   }

   private boolean m_1156() {
      return f_5909.player != null
         && f_5909.world != null
         && f_5909.options != null
         && f_5909.options.playerListKey != null
         && f_5909.options.playerListKey.isPressed();
   }

   private void m_2356(Util165 var1, double var2, double var4) {
      var1.m_2214(var2);
      var1.m_2946(var2);
      var1.m_1829(var4);
      var1.m_1876(System.currentTimeMillis());
      var1.l(false);
   }
}
