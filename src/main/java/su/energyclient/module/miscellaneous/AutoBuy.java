package su.energyclient.module.miscellaneous;

import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util147;
import su.energyclient.util.Util170;
import su.energyclient.util.Util58;

public class AutoBuy extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Util147 f_2391 = new Util147();
   private final NumberSetting f_2392;
   private final BooleanSetting f_2393;
   private final BooleanSetting f_2394;
   private final NumberSetting f_2395;
   private static final String f_2396 = "Auto Buy";
   private static final String f_2397 = "Авто-покупка предметов с аукциона";
   private static final String f_2398 = "Parse % below market";
   private static final float f_2399 = 20.0F;
   private static final float f_2400 = 100.0F;
   private static final String f_2401 = "Auto parse on enable";
   private static final String f_2402 = "Auto reparse";
   private static final String f_2403 = "Reparse interval (min)";
   private static final float f_2404 = 5.0F;
   private static final float f_2405 = 10.0F;

   public NumberSetting I() {
      return this.f_2395;
   }

   public NumberSetting l() {
      return this.f_2392;
   }

   public BooleanSetting m_230() {
      return this.f_2393;
   }

   @Override
   public void m_1() {
      this.f_2391.m_3665();
      if (f_5909.currentScreen instanceof Util58) {
         f_5909.setScreen(null);
      }

      super.m_1();
   }

   public AutoBuy() {
      super(f_2396, f_2397, Category.MISCELLANEOUS);
      this.f_2392 = new NumberSetting(f_2398, f_2399, 1.0F, f_2400, 1.0F);
      this.f_2393 = new BooleanSetting(f_2401, true);
      this.f_2394 = new BooleanSetting(f_2402, false);
      this.f_2395 = new NumberSetting(f_2403, f_2404, 1.0F, f_2405, 1.0F).m_356(this.f_2394::m_1163);
   }

   @EventHandler
   private void m_1194(CancellableEvent var1) {
      if (!var1.m_3546()) {
         if (var1.m_1362()) {
            if (var1.m_2169() == 96) {
               if (f_5909.currentScreen instanceof Util58) {
                  f_5909.setScreen(null);
               } else {
                  f_5909.setScreen(new Util58(this.f_2391, this));
               }
            }
         }
      }
   }

   @EventHandler
   private void m_2600(Util170 var1) {
      this.f_2391.m_201((int)this.f_2392.m_4046(), this.f_2393.m_1163(), this.f_2394.m_1163(), (int)this.f_2395.m_4046());
   }

   public Util147 m_1361() {
      return this.f_2391;
   }

   public BooleanSetting m_2990() {
      return this.f_2394;
   }
}
