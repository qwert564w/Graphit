package su.energyclient.module.player;

import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;

public class KtLeave extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final RenderUtil22 f_1970;
   private boolean f_1971;
   private static final String f_1972 = "KT Leave";
   private static final String f_1973 = "description";
   private static final String f_1974 = "Кнопка лива";
   private static final String f_1975 = "/gmsp";
   private static final String f_1976 = "/gms";

   @Override
   public void m_1() {
      super.m_1();
      this.f_1971 = false;
   }

   @EventHandler
   public void m_2226(CancellableEvent var1) {
      if (f_5909.player != null) {
         if (!var1.m_3546()) {
            if (var1.m_2169() == this.f_1970.m_1958()) {
               this.f_1971 = !this.f_1971;
               if (this.f_1971) {
                  f_5909.player.networkHandler.sendChatMessage(f_1975);
               } else {
                  f_5909.player.networkHandler.sendChatMessage(f_1976);
               }
            }
         }
      }
   }

   public KtLeave() {
      super(f_1972, f_1973, Category.PLAYER);
      this.f_1970 = new RenderUtil22(f_1974, -1);
   }
}
