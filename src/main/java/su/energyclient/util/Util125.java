package su.energyclient.util;

public class Util125 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private long f_10700;
   private final long f_10701 = System.currentTimeMillis();

   public boolean m_762() {
      return this.f_10701 < System.currentTimeMillis();
   }

   public Util125() {
      this.m_3493();
   }

   public boolean m_2884(double var1) {
      return this.m_1913() >= var1;
   }

   public void m_1528(long var1) {
      this.f_10700 = var1;
   }

   public void m_3493() {
      this.f_10700 = System.currentTimeMillis();
   }

   public long m_1913() {
      return System.currentTimeMillis() - this.f_10700;
   }

   public boolean m_522(long var1, boolean var3) {
      boolean var4 = this.m_1913() >= var1;
      if (var4 && var3) {
         this.m_3493();
      }

      return var4;
   }

   public boolean m_2636(long var1) {
      return this.m_1913() >= var1;
   }

   public long m_2984() {
      return this.f_10700;
   }
}
