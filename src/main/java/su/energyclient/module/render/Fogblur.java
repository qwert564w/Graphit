package su.energyclient.module.render;

import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil16;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util79;

public class Fogblur extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_14365;
   private final NumberSetting f_14366;
   private final BooleanSetting f_14367;
   private final BooleanSetting f_14368;
   private final NumberSetting f_14369;
   private final NumberSetting f_14370;
   private final NumberSetting f_14371;
   private static final String f_14372 = "FogBlur";
   private static final String f_14373 = "Добавляет эффект размытого тумана на дальнем расстоянии.";
   private static final String f_14374 = "Сила размытия";
   private static final float f_14375 = 6.0F;
   private static final float f_14376 = 20.0F;
   private static final float f_14377 = 0.1F;
   private static final String f_14378 = "Дистанция тумана";
   private static final float f_14379 = 50.0F;
   private static final float f_14380 = 200.0F;
   private static final String f_14381 = "Линейная выборка";
   private static final String f_14382 = "RGB эффект";
   private static final String f_14383 = "RGB прозрачность";
   private static final float f_14384 = 30.0F;
   private static final float f_14385 = 100.0F;
   private static final String f_14386 = "RGB насыщенность";
   private static final float f_14387 = 70.0F;
   private static final float f_14388 = 100.0F;
   private static final String f_14389 = "RGB яркость";
   private static final float f_14390 = 100.0F;
   private static final float f_14391 = 100.0F;
   private static final float f_14392 = 100.0F;
   private static final float f_14393 = 100.0F;
   private static final float f_14394 = 100.0F;

   public Fogblur() {
      super(f_14372, f_14373, Category.RENDER);
      this.f_14365 = new NumberSetting(f_14374, f_14375, 1.0F, f_14376, f_14377);
      this.f_14366 = new NumberSetting(f_14378, f_14379, 0.0F, f_14380, 1.0F);
      this.f_14367 = new BooleanSetting(f_14381, true);
      this.f_14368 = new BooleanSetting(f_14382, false);
      this.f_14369 = new NumberSetting(f_14383, f_14384, 1.0F, f_14385, 1.0F).m_356(this.f_14368::m_1163);
      this.f_14370 = new NumberSetting(f_14386, f_14387, 0.0F, f_14388, 1.0F).m_356(this.f_14368::m_1163);
      this.f_14371 = new NumberSetting(f_14389, f_14390, 0.0F, f_14391, 1.0F).m_356(this.f_14368::m_1163);
   }

   @EventHandler
   private void m_337(Util79 var1) {
      if (f_5909.player != null && f_5909.world != null && f_5909.gameRenderer != null && !f_5909.gameRenderer.isRenderingPanorama()) {
         RenderUtil16.m_2901(
            this.f_14365.m_4046(),
            this.f_14366.m_4046(),
            this.f_14367.m_1163(),
            this.f_14368.m_1163(),
            this.f_14369.m_4046() / f_14392,
            this.f_14370.m_4046() / f_14393,
            this.f_14371.m_4046() / f_14394
         );
      }
   }
}
