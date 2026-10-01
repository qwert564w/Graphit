package su.energyclient.util;

public class Util165 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Util153 f_8028;
   private long f_8029;
   private long f_8030;
   private long f_8031;
   private double f_8032;
   private double f_8033;
   private double f_8034;
   private boolean f_8035;

   public void m_3631(double var1) {
      this.f_8030 = System.currentTimeMillis();
      if (this.f_8033 != var1) {
         this.f_8033 = var1;
         this.m_2903();
      } else {
         this.f_8035 = this.f_8030 - this.f_8029 > this.f_8031;
         if (this.f_8035) {
            this.f_8034 = var1;
            return;
         }
      }

      double var3 = this.f_8028.m_2093().apply(this.m_1912());
      if (this.f_8034 > var1) {
         this.f_8034 = this.f_8032 - (this.f_8032 - var1) * var3;
      } else {
         this.f_8034 = this.f_8032 + (var1 - this.f_8032) * var3;
      }
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Util165 var2)) {
         return false;
      } else if (!var2.m_2761(this)) {
         return false;
      } else if (this.m_2019() != var2.m_2019()) {
         return false;
      } else if (this.m_977() != var2.m_977()) {
         return false;
      } else if (this.m_952() != var2.m_952()) {
         return false;
      } else if (Double.compare(this.m_1585(), var2.m_1585()) != 0) {
         return false;
      } else if (Double.compare(this.m_1040(), var2.m_1040()) != 0) {
         return false;
      } else if (Double.compare(this.m_2276(), var2.m_2276()) != 0) {
         return false;
      } else if (this.m_2546() != var2.m_2546()) {
         return false;
      } else {
         Util153 var3 = this.m_3474();
         Util153 var4 = var2.m_3474();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   public long m_977() {
      return this.f_8030;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      long var3 = this.m_2019();
      var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = this.m_977();
      var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
      long var7 = this.m_952();
      var2 = var2 * 59 + (int)(var7 >>> 32 ^ var7);
      long var9 = Double.doubleToLongBits(this.m_1585());
      var2 = var2 * 59 + (int)(var9 >>> 32 ^ var9);
      long var11 = Double.doubleToLongBits(this.m_1040());
      var2 = var2 * 59 + (int)(var11 >>> 32 ^ var11);
      long var13 = Double.doubleToLongBits(this.m_2276());
      var2 = var2 * 59 + (int)(var13 >>> 32 ^ var13);
      var2 = var2 * 59 + (this.m_2546() ? 79 : 97);
      Util153 var15 = this.m_3474();
      return var2 * 59 + (var15 == null ? 43 : var15.hashCode());
   }

   public double m_2276() {
      return this.f_8034;
   }

   public long m_952() {
      return this.f_8031;
   }

   public Util153 m_3474() {
      return this.f_8028;
   }

   public void m_1066(long var1) {
      this.f_8030 = var1;
   }

   public double m_1912() {
      return (double)(System.currentTimeMillis() - this.f_8031) / this.f_8029;
   }

   public void l(boolean var1) {
      this.f_8035 = var1;
   }

   public double m_1585() {
      return this.f_8032;
   }

   protected boolean m_2761(Object var1) {
      return var1 instanceof Util165;
   }

   public void m_2903() {
      this.f_8031 = System.currentTimeMillis();
      this.f_8032 = this.f_8034;
      this.f_8035 = false;
   }

   public void m_444(Util153 var1) {
      this.f_8028 = var1;
   }

   public void m_1876(long var1) {
      this.f_8031 = var1;
   }

   public double m_1040() {
      return this.f_8033;
   }

   public long m_2019() {
      return this.f_8029;
   }

   public void m_2946(double var1) {
      this.f_8032 = var1;
   }

   public void m_2214(double var1) {
      this.f_8034 = var1;
   }

   public void m_1347(long var1) {
      this.f_8029 = var1;
   }

   public void m_1829(double var1) {
      this.f_8033 = var1;
   }

   public Util165(Util153 var1, long var2) {
      this.f_8028 = var1;
      this.f_8031 = System.currentTimeMillis();
      this.f_8029 = var2;
   }

   public boolean m_2546() {
      return this.f_8035;
   }

   @Override
   public String toString() {
      return "Animation(easing="
         + this.m_3474()
         + ", duration="
         + this.m_2019()
         + ", millis="
         + this.m_977()
         + ", startTime="
         + this.m_952()
         + ", startValue="
         + this.m_1585()
         + ", destinationValue="
         + this.m_1040()
         + ", value="
         + this.m_2276()
         + ", finished="
         + this.m_2546()
         + ")";
   }
}
