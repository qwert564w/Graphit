package su.energyclient.module.movement;

import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventNoPush;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util63;

public class NoPush extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public Util63 f_2632;
   private static final String f_2633 = "No Push";
   private static final String f_2634 = "Позволяет не отталкиваться при определенных условиях, обеспечивая стабильное передвижение";
   private static final String f_2635 = "Тип";
   private static final String f_2636 = "Игроки";
   private static final String f_2637 = "Блоки";
   private static final String f_2638 = "Вода";
   private static final String f_2639 = "Удочки";
   private static final String f_2640 = "Блоки";
   private static final String f_2641 = "Вода";
   private static final String f_2642 = "Игроки";
   private static final String f_2643 = "Удочки";

   @EventHandler
   public void m_2097(EventNoPush var1) {
      boolean var2 = switch (var1.f_8760) {
         case Block -> this.f_2632.I(f_2640);
         case Water -> this.f_2632.I(f_2641);
         case Player -> this.f_2632.I(f_2642);
         case FishingRod -> this.f_2632.I(f_2643);
      };
      if (var2) {
         var1.m_277(true);
      }
   }

   public NoPush() {
      super(f_2633, f_2634, Category.MOVEMENT);
      this.f_2632 = new Util63(
         f_2635, new BooleanSetting(f_2636, true), new BooleanSetting(f_2637, true), new BooleanSetting(f_2638, true), new BooleanSetting(f_2639, true)
      );
   }
}
