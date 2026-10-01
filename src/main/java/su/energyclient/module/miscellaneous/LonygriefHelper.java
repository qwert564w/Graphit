package su.energyclient.module.miscellaneous;

import net.minecraft.item.Items;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;

public class LonygriefHelper extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final RenderUtil22 f_2581;
   private final RenderUtil22 f_2582;
   private final RenderUtil22 f_2583;
   private final RenderUtil22 f_2584;
   private boolean f_2585;
   private boolean f_2586;
   private boolean f_2587;
   private boolean f_2588;
   private static final String f_2589 = "LonyGrief Helper";
   private static final String f_2590 = "Быстрое использование предметов для LonyGrief";
   private static final String f_2591 = "Исп. Обычная ливалка";
   private static final String f_2592 = "Исп. Ливалка с платформой";
   private static final String f_2593 = "Исп. Уникальная трапка";
   private static final String f_2594 = "Исп. Уникальное перо";

   public LonygriefHelper() {
      super(f_2589, f_2590, Category.MISCELLANEOUS);
      this.f_2581 = new RenderUtil22(f_2591, -1);
      this.f_2582 = new RenderUtil22(f_2592, -1);
      this.f_2583 = new RenderUtil22(f_2593, -1);
      this.f_2584 = new RenderUtil22(f_2594, -1);
   }

   @EventHandler
   public void m_3167(Util170 var1) {
      if (this.f_2586) {
         Util146.m_1314(Items.CLAY_BALL);
         this.f_2586 = false;
      }

      if (this.f_2585) {
         Util146.m_1314(Items.MAGMA_CREAM);
         this.f_2585 = false;
      }

      if (this.f_2587) {
         Util146.m_1314(Items.CRYING_OBSIDIAN);
         this.f_2587 = false;
      }

      if (this.f_2588) {
         Util146.m_1314(Items.FEATHER);
         this.f_2588 = false;
      }
   }

   @EventHandler
   public void m_3574(CancellableEvent var1) {
      if (!var1.m_3546() && var1.m_1362()) {
         if (var1.m_2169() == this.f_2581.m_1958()) {
            this.f_2585 = true;
         } else if (var1.m_2169() == this.f_2582.m_1958()) {
            this.f_2586 = true;
         } else if (var1.m_2169() == this.f_2584.m_1958()) {
            this.f_2588 = true;
         } else if (var1.m_2169() == this.f_2583.m_1958()) {
            this.f_2587 = true;
         }
      }
   }
}
