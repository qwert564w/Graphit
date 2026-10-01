package su.energyclient.mixin;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.ShulkerPreview;

@Mixin({DrawContext.class})
public abstract class DrawContextMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"drawItemTooltip"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$drawShulkerPreview(TextRenderer var1, ItemStack var2, int var3, int var4, CallbackInfo var5) {
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null) {
         ShulkerPreview var6 = InitManager.f_2740.f_2741.shulkerPreview;
         if (var6 != null) {
            DrawContext var7 = (DrawContext)(Object)this;
            var7.createNewRootLayer();
            if (var6.m_1815(var7, var1, var2, var3, var4)) {
               var5.cancel();
            }
         }
      }
   }
}
