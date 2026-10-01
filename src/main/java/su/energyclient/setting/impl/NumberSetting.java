package su.energyclient.setting.impl;

import java.util.function.Supplier;
import net.minecraft.util.math.MathHelper;
import su.energyclient.render.RenderUtil26;
import su.energyclient.setting.Setting;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;

public class NumberSetting extends Setting {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_5956;
   private final float f_5957;
   private final float f_5958;
   private final float f_5959;
   private boolean f_5960;
   private final Util165 f_5961;
   private final Util165 f_5962;
   private boolean f_5963;
   private final RenderUtil26.JyPPeWE08Nc2NqHK f_5964;
   private static final long f_5965 = 155L;
   private static final long f_5966 = 300L;

   public Util165 m_1997() {
      return this.f_5961;
   }

   public float m_4046() {
      return this.m_134().floatValue();
   }

   public void m_3690(float var1) {
      this.f_5956 = MathHelper.clamp(var1, this.m_925(), this.m_2596());
   }

   public void m_544(boolean var1) {
      this.f_5963 = var1;
   }

   public Number m_134() {
      return MathHelper.clamp(this.f_5956, this.m_925(), this.m_2596());
   }

   public RenderUtil26.JyPPeWE08Nc2NqHK m_575() {
      return this.f_5964;
   }

   public float m_2596() {
      return this.f_5958;
   }

   public NumberSetting(String var1, float var2, float var3, float var4, float var5) {
      super(var1);
      this.f_5961 = new Util165(Util153.LINEAR, f_5965);
      this.f_5962 = new Util165(Util153.LINEAR, f_5966);
      this.f_5964 = new RenderUtil26.JyPPeWE08Nc2NqHK();
      this.f_5956 = var2;
      this.f_5957 = var3;
      this.f_5958 = var4;
      this.f_5959 = var5;
   }

   public NumberSetting m_356(Supplier<Boolean> var1) {
      this.f_7716 = var1;
      return this;
   }

   public Util165 m_2103() {
      return this.f_5962;
   }

   public boolean m_2619() {
      return this.f_5960;
   }

   public float m_2099() {
      return this.f_5959;
   }

   public void m_1584(boolean var1) {
      this.f_5960 = var1;
   }

   public float m_925() {
      return this.f_5957;
   }

   public boolean m_1345() {
      return this.f_5963;
   }
}
