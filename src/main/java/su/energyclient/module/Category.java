package su.energyclient.module;

public enum Category {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   COMBAT("Combat", "j"),
   MOVEMENT("Movement", "k"),
   RENDER("Render", "l"),
   PLAYER("Player", "m"),
   MISCELLANEOUS("Miscellaneous", "n"),
   COSMETICS("Cosmetics", "m");

   final String f_4768;
   final String f_4769;

   private Category(String var3, String var4) {
      this.f_4768 = var3;
      this.f_4769 = var4;
   }

   public String m_2294() {
      return this.f_4768;
   }

   public String m_3343() {
      return this.f_4769;
   }
}
