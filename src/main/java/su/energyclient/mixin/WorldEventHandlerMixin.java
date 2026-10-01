package su.energyclient.mixin;

import net.minecraft.client.world.WorldEventHandler;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoRender;

@Mixin({WorldEventHandler.class})
public class WorldEventHandlerMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"processWorldEvent"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/world/ClientWorld;addBlockBreakParticles(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V",
         ordinal = 0
      )},
      cancellable = true
   )
   private void processworldevent(int var1, BlockPos var2, int var3, CallbackInfo var4) {
      EventNoRender var5 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.destroyparticles);
      EnergyClient.f_1622.f_1624.m_30(var5);
      if (var5.m_2244()) {
         var4.cancel();
      }
   }
}
