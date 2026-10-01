package su.energyclient.render;

import java.util.function.Supplier;
import su.energyclient.setting.Setting;

public class RenderUtil22 extends Setting {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_1207;
   private RenderUtil22.pqYfuJa0oJD2nAQv f_1208 = RenderUtil22.pqYfuJa0oJD2nAQv.TOGGLE;
   private boolean f_1209 = false;

   public RenderUtil22(String var1) {
      super(var1);
      this.f_1207 = -1;
   }

   public void m_3523(boolean var1) {
      this.f_1209 = var1;
   }

   public void m_3210(RenderUtil22.pqYfuJa0oJD2nAQv var1) {
      this.f_1208 = var1;
   }

   public RenderUtil22 m_2895(Supplier<Boolean> var1) {
      this.f_7716 = var1;
      return this;
   }

   public void m_466(int var1) {
      this.f_1207 = var1;
   }

   public RenderUtil22(String var1, int var2) {
      super(var1);
      this.f_1207 = var2;
   }

   public int m_1958() {
      return this.f_1207;
   }

   public RenderUtil22.pqYfuJa0oJD2nAQv m_766() {
      return this.f_1208;
   }

   public boolean m_1137() {
      return this.f_1209;
   }

   public static enum pqYfuJa0oJD2nAQv {
      TOGGLE,
      HOLD;
   }
}
