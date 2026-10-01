package su.energyclient.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoPush;

@Mixin({FishingBobberEntity.class})
public class FishingBobberEntityMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"pullHookedEntity"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onPullHookedEntity(Entity var1, CallbackInfo var2) {
      EventNoPush var3 = new EventNoPush(EventNoPush.Inner_4C0TXA9Fous6eGMB.FishingRod);
      EnergyClient.f_1622.f_1624.m_30(var3);
      if (var3.m_2244()) {
         var2.cancel();
      }
   }
}
