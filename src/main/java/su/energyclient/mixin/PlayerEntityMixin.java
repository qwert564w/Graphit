package su.energyclient.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoPush;

@Mixin({PlayerEntity.class})
public abstract class PlayerEntityMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"isPushedByFluids"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onIsPushedByFluid(CallbackInfoReturnable<Boolean> var1) {
      EventNoPush var2 = new EventNoPush(EventNoPush.Inner_4C0TXA9Fous6eGMB.Water);
      EnergyClient.f_1622.f_1624.m_30(var2);
      if (var2.m_2244()) {
         var1.setReturnValue(false);
      }
   }
}
