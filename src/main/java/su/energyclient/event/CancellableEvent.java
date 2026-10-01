package su.energyclient.event;

public class CancellableEvent extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_6898;
   private boolean f_6899;
   private boolean f_6900;

   public void m_4035(int var1) {
      this.f_6898 = var1;
   }

   public int m_2169() {
      return this.f_6898;
   }

   public boolean m_3546() {
      return this.f_6900;
   }

   public void m_314(boolean var1) {
      this.f_6899 = var1;
   }

   public boolean m_1362() {
      return this.f_6899;
   }

   public void m_2460(boolean var1) {
      this.f_6900 = var1;
   }

   public CancellableEvent(int var1, boolean var2, boolean var3) {
      this.f_6898 = var1;
      this.f_6899 = var2;
      this.f_6900 = var3;
   }
}
