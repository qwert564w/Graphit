package su.energyclient.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.BossBarHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoRender;

@Mixin({BossBarHud.class})
public class BossBarHudMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"render"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRender(DrawContext var1, CallbackInfo var2) {
      EventNoRender var3 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.bossbar);
      EnergyClient.f_1622.f_1624.m_30(var3);
      if (var3.m_2244()) {
         var2.cancel();
      }
   }
}
