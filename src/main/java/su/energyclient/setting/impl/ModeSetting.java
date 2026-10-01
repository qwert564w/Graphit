package su.energyclient.setting.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.function.Supplier;
import su.energyclient.setting.Setting;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;

public class ModeSetting extends Setting {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private ObjectArrayList<String> f_3066;
   private String O;
   private int f_3067;
   private boolean f_3068;
   private final Util165 f_3069;
   private static final long f_3070 = 200L;

   public int m_2312() {
      return this.f_3067;
   }

   public void m_3344(boolean var1) {
      this.f_3068 = var1;
   }

   public Util165 m_3744() {
      return this.f_3069;
   }

   public ObjectArrayList<String> m_3551() {
      return this.f_3066;
   }

   public void m_755(ObjectArrayList<String> var1) {
      this.f_3066 = var1;
   }

   public void m_786(int var1) {
      this.f_3067 = var1;
   }

   public void m_1159(String var1) {
      this.O = var1;
   }

   public void m_21(String var1) {
      this.O = var1;
      this.f_3067 = this.f_3066.indexOf(var1);
   }

   public ModeSetting(String var1, String var2, String... var3) {
      super(var1);
      this.f_3069 = new Util165(Util153.EASE_OUT_CUBIC, f_3070);
      this.f_3066 = ObjectArrayList.of(var3);
      this.f_3067 = this.f_3066.indexOf(var2);
      this.O = (String)this.f_3066.get(this.f_3067);
   }

   public ModeSetting m_1263(Supplier<Boolean> var1) {
      this.f_7716 = var1;
      return this;
   }

   public boolean m_2073(String var1) {
      return this.O.equals(var1);
   }

   public boolean m_2480() {
      return this.f_3068;
   }

   public String m_3862() {
      return this.O;
   }
}
