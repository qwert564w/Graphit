package su.energyclient.setting.impl;

import java.util.function.Supplier;
import su.energyclient.setting.Setting;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;

public class BooleanSetting extends Setting {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private boolean f_14298;
   private final Util165 f_14299;
   private static final long f_14300 = 150L;

   public BooleanSetting(String var1, boolean var2) {
      super(var1);
      this.f_14299 = new Util165(Util153.LINEAR, f_14300);
      this.f_14298 = var2;
   }

   public Util165 l() {
      return this.f_14299;
   }

   public BooleanSetting m_334(Supplier<Boolean> var1) {
      this.f_7716 = var1;
      return this;
   }

   public boolean m_1163() {
      return this.f_14298;
   }

   public static BooleanSetting m_136(String var0, boolean var1) {
      return new BooleanSetting(var0, var1);
   }

   public void m_1848(boolean var1) {
      this.f_14298 = var1;
   }
}
