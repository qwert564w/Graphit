package su.energyclient.mixin;

import net.minecraft.client.render.entity.feature.StuckArrowsFeatureRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoRender;

@Mixin({StuckArrowsFeatureRenderer.class})
public class StuckArrowsFeatureRendererMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"getObjectCount"},
      at = {@At("HEAD")},
      cancellable = true
   )
   protected void getObjectCount(PlayerEntityRenderState var1, CallbackInfoReturnable<Integer> var2) {
      EventNoRender var3 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.arrows);
      EnergyClient.f_1622.f_1624.m_30(var3);
      if (var3.m_2244()) {
         var2.setReturnValue(0);
      }
   }
}
