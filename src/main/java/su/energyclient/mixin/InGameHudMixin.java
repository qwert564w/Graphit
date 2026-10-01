package su.energyclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.module.combat.ThemeEditor;

@Mixin({InGameHud.class})
public class InGameHudMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"renderCrosshair"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$hideCrosshairInClickGui(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
      if (MinecraftClient.getInstance().currentScreen instanceof ThemeEditor) {
         var3.cancel();
      }
   }
}
