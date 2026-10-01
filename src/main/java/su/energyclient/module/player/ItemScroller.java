package su.energyclient.module.player;

import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil15;
import su.energyclient.setting.impl.NumberSetting;

public class ItemScroller extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_11094;
   private static final String f_11095 = "Item Scroller";
   private static final String f_11096 = "description";
   private static final String f_11097 = "Задержка";
   private static final float f_11098 = 8.0F;
   private static final float f_11099 = 10.0F;

   @EventHandler
   public void m_2506(RenderUtil15 var1) {
      var1.m_2343(this.f_11094.m_134().intValue());
   }

   public ItemScroller() {
      super(f_11095, f_11096, Category.PLAYER);
      this.f_11094 = new NumberSetting(f_11097, f_11098, 0.0F, f_11099, 1.0F);
   }
}
