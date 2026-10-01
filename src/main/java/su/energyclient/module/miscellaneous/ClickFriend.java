package su.energyclient.module.miscellaneous;

import net.minecraft.entity.player.PlayerEntity;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.util.Util152;

public class ClickFriend extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final RenderUtil22 f_844;
   private static final String f_845 = "Click Friend";
   private static final String f_846 = "Добавляет и удаляет друзей по нажатию бинда на игроке";
   private static final String f_847 = "Кнопка взаимодействия";

   @EventHandler
   public void m_2771(CancellableEvent var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (!var1.m_3546() && var1.m_1362()) {
            if (this.f_844.m_1958() != -1 && var1.m_2169() == this.f_844.m_1958()) {
               if (f_5909.targetedEntity instanceof PlayerEntity var2) {
                  String var4 = var2.getGameProfile().name();
                  if (InitManager.f_2740.f_2744.m_2704(var4)) {
                     InitManager.f_2740.f_2744.m_3798(var4);
                     Util152.m_662(var4 + " удален из списка друзей!");
                  } else {
                     InitManager.f_2740.f_2744.m_959(var4);
                     Util152.m_662(var4 + " добавлен в список друзей!");
                  }
               }
            }
         }
      }
   }

   public ClickFriend() {
      super(f_845, f_846, Category.MISCELLANEOUS);
      this.f_844 = new RenderUtil22(f_847, -1);
   }
}
