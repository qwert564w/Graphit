package su.energyclient.util;

public class Util82 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private long f_5233;
   private double f_5234;
   private double f_5235;
   private double f_5236;
   private double f_5237;
   private double f_5238;
   private Util97 f_5239 = Util11.f_2927;
   private boolean f_5240 = false;
   private Runnable f_5241;
   private boolean I = false;
   private static final String f_5242 = "Animate cancelled due to target val equals from val";
   private static final double f_5243 = 1000.0;
   private static final double f_5244 = 1.5;

   public Util82 m_965(boolean var1) {
      this.f_5240 = var1;
      return this;
   }

   public long m_790() {
      return this.f_5233;
   }

   public Util82 m_2086(double var1, double var3, boolean var5) {
      return this.m_1803(var1, var3, Util11.f_2927, var5);
   }

   public boolean m_434() {
      return this.m_2610() >= 1.0;
   }

   public Util82 m_316(Runnable var1) {
      this.f_5241 = var1;
      return this;
   }

   public boolean m_1221() {
      return !this.m_434();
   }

   public boolean m_2285() {
      return this.f_5240;
   }

   public boolean m_1860() {
      return this.I;
   }

   public double m_345() {
      return this.f_5234;
   }

   public Util82 m_546(double var1) {
      this.f_5237 = var1;
      return this;
   }

   public double m_2054(double var1, double var3, double var5) {
      return var1 + (var3 - var1) * var5;
   }

   public float m_398() {
      return (float)this.m_384();
   }

   public Util82 m_1803(double var1, double var3, Util97 var5, boolean var6) {
      if (this.m_3113(var6, var1)) {
         if (this.m_2285()) {
            System.out.println(f_5242);
         }
      } else {
         this.m_1461(var5).m_2772(var3 * f_5243).m_3193(System.currentTimeMillis()).m_4004(this.m_979()).m_1601(var1);
         boolean var7 = this.I = this.m_3212() == this.m_3185();
         if (this.m_2285()) {
            System.out.println("#animate {\n    to value: " + this.m_3185() + "\n    from value: " + this.m_979() + "\n    duration: " + this.m_345() + "\n}");
         }
      }

      return this;
   }

   public Util82 m_2739(double var1, double var3) {
      return this.m_1803(var1, var3, Util11.f_2927, false);
   }

   public double m_979() {
      return this.f_5237;
   }

   public Util82 m_1285(double var1, double var3, Util97 var5) {
      return this.m_1803(var1, var3, var5, false);
   }

   public Util82 m_1461(Util97 var1) {
      this.f_5239 = var1;
      return this;
   }

   public Util82 m_2772(double var1) {
      this.f_5234 = var1;
      return this;
   }

   public boolean m_3113(boolean var1, double var2) {
      return var1 && this.m_1221() && (var2 == this.m_3212() || var2 == this.m_3185() || var2 == this.m_979());
   }

   public Util82 m_621(double var1) {
      this.f_5238 = var1;
      return this;
   }

   public float m_2453() {
      return (float)this.m_979();
   }

   public double m_3212() {
      return this.f_5235;
   }

   public Runnable m_2813() {
      return this.f_5241;
   }

   public Util97 m_234() {
      return this.f_5239;
   }

   public void m_867(double var1) {
      this.m_2739(var1, 0.0);
      this.m_1596();
      this.m_546(var1);
   }

   public Util82 m_1601(double var1) {
      this.f_5236 = var1;
      return this;
   }

   public double m_2610() {
      return (System.currentTimeMillis() - this.m_790()) / this.m_345();
   }

   public double m_384() {
      return this.f_5238;
   }

   public boolean m_1596() {
      this.m_621(this.m_979());
      boolean var1 = this.m_1221();
      if (System.currentTimeMillis() - this.m_790() > this.m_345() / f_5244) {
         boolean var2 = this.I = this.m_3212() == this.m_3185();
      }

      if (var1) {
         this.m_546(this.m_2054(this.m_3212(), this.m_3185(), this.m_234().m_1934(this.m_2610())));
      } else {
         this.m_3193(0L);
         this.m_546(this.m_3185());
         if (this.f_5241 != null) {
            this.f_5241.run();
            this.f_5241 = null;
         }
      }

      return var1;
   }

   public double m_3185() {
      return this.f_5236;
   }

   public Util82 m_3193(long var1) {
      this.f_5233 = var1;
      return this;
   }

   public Util82 m_4004(double var1) {
      this.f_5235 = var1;
      return this;
   }
}
