package su.energyclient.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.function.Supplier;
import su.energyclient.setting.Setting;
import su.energyclient.setting.impl.BooleanSetting;

public class Util63 extends Setting {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public ObjectArrayList<BooleanSetting> f_8487;
   private boolean f_8488;
   private final Util165 f_8489;
   private static final long f_8490 = 200L;

   public Util165 m_3994() {
      return this.f_8489;
   }

   public void m_3622(ObjectArrayList<BooleanSetting> var1) {
      this.f_8487 = var1;
   }

   public Util63(String var1, BooleanSetting... var2) {
      super(var1);
      this.f_8489 = new Util165(Util153.EASE_OUT_CUBIC, f_8490);
      this.f_8487 = ObjectArrayList.of(var2);
   }

   public Util63 m_1570(String var1, BooleanSetting... var2) {
      return new Util63(var1, var2);
   }

   public boolean m_1931() {
      return this.f_8488;
   }

   public void m_2410(boolean var1) {
      this.f_8488 = var1;
   }

   public boolean I(String var1) {
      return this.f_8487.stream().filter(var1x -> var1x.m_1488().equalsIgnoreCase(var1)).findFirst().map(BooleanSetting::m_1163).orElse(false);
   }

   public void m_2656(String var1, boolean var2) {
      this.f_8487.stream().filter(var1x -> var1x.m_1488().equalsIgnoreCase(var1)).findFirst().ifPresent(var1x -> var1x.m_1848(var2));
   }

   public ObjectArrayList<BooleanSetting> m_841() {
      return this.f_8487;
   }

   public Util63 m_2120(Supplier<Boolean> var1) {
      this.f_7716 = var1;
      return this;
   }
}
