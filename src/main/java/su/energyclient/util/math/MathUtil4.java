package su.energyclient.util.math;

import java.time.Duration;
import su.energyclient.util.Util125;
import su.energyclient.util.Util59;

public class MathUtil4 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_6058;
   private float f_6059;
   private Duration f_6060;
   private Util125 f_6061 = new Util125();
   private Util59 f_6062 = Util59.FORWARD;

   public MathUtil4 m_2320(Util125 var1) {
      this.f_6061 = var1;
      return this;
   }

   public float m_1698() {
      float var1 = Math.min(1.0F, (float)this.f_6061.m_1913() / (float)this.f_6060.toMillis());
      return this.f_6058 * (this.f_6062 == Util59.FORWARD ? var1 : 1.0F - var1);
   }

   public void m_1086(float var1) {
      if (this.f_6059 != var1) {
         this.f_6058 = this.m_1698();
         this.f_6059 = var1;
         this.m_2133();
      }
   }

   public MathUtil4 m_1935(Util59 var1) {
      this.f_6062 = var1;
      return this;
   }

   public MathUtil4 m_3071(Duration var1) {
      this.f_6060 = var1;
      return this;
   }

   public Util125 m_641() {
      return this.f_6061;
   }

   public Duration m_1976() {
      return this.f_6060;
   }

   public MathUtil4 m_3906(float var1) {
      this.f_6059 = var1;
      return this;
   }

   public void m_203(boolean var1) {
      this.m_2695(var1 ? Util59.FORWARD : Util59.BACKWARD);
   }

   public float m_153() {
      return this.f_6058;
   }

   public MathUtil4 m_296(float var1) {
      this.f_6058 = var1;
      return this;
   }

   public float m_256() {
      return this.f_6059;
   }

   public boolean m_3640() {
      return this.f_6062 == Util59.FORWARD;
   }

   public boolean m_499() {
      return this.f_6062 == Util59.BACKWARD;
   }

   public void m_2695(Util59 var1) {
      if (this.f_6062 != var1) {
         this.f_6062 = var1;
         this.m_2133();
      }
   }

   public MathUtil4(float var1, Duration var2) {
      this.f_6058 = var1;
      this.f_6060 = var2;
      this.m_2133();
   }

   public boolean m_2897() {
      return this.f_6061.m_2884(this.f_6060.toMillis());
   }

   public void m_2133() {
      this.f_6061.m_3493();
   }

   public boolean m_2659(Util59 var1) {
      return this.m_2897() && this.f_6062 == var1;
   }

   public Util59 m_3241() {
      return this.f_6062;
   }
}
