package su.energyclient.util;

public final class Util105 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_14301 = -1;
   private boolean f_14302;
   private Boolean f_14303;
   private boolean f_14304;
   private int f_14305;
   private static final String f_14306 = "An action sequence must be non-negative";

   public synchronized void m_1234(int var1) {
      if (this.f_14301 >= 0 && var1 >= this.f_14301) {
         this.f_14302 = true;
      }
   }

   public synchronized void m_545(boolean var1) {
      if (this.f_14301 >= 0 && !Boolean.FALSE.equals(this.f_14303)) {
         this.f_14303 = var1;
      }
   }

   public synchronized void m_383(int var1) {
      if (var1 < 0) {
         throw new IllegalArgumentException(f_14306);
      } else if (var1 != this.f_14301) {
         this.f_14301 = var1;
         this.f_14302 = false;
         this.f_14303 = null;
         this.f_14304 = false;
      }
   }

   public synchronized Util105.cVP3VyoKPbwWD3Cr m_2228(int var1, boolean var2) {
      if (this.f_14301 >= 0 && (this.f_14302 || this.f_14303 != null)) {
         if (!this.f_14304) {
            this.f_14304 = true;
            this.f_14305 = var1;
            return Util105.cVP3VyoKPbwWD3Cr.WAITING;
         } else if (var1 <= this.f_14305) {
            return Util105.cVP3VyoKPbwWD3Cr.WAITING;
         } else if (Boolean.FALSE.equals(this.f_14303)) {
            return Util105.cVP3VyoKPbwWD3Cr.REJECTED;
         } else if (var2) {
            return Util105.cVP3VyoKPbwWD3Cr.CONFIRMED;
         } else {
            return this.f_14302 ? Util105.cVP3VyoKPbwWD3Cr.REJECTED : Util105.cVP3VyoKPbwWD3Cr.WAITING;
         }
      } else {
         return Util105.cVP3VyoKPbwWD3Cr.WAITING;
      }
   }

   public static enum cVP3VyoKPbwWD3Cr {
      WAITING,
      CONFIRMED,
      REJECTED;
   }
}
