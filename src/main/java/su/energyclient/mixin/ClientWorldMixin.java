package su.energyclient.mixin;

import java.util.function.BooleanSupplier;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.util.Util104;

@Mixin({ClientWorld.class})
public class ClientWorldMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"tick"},
      at = {@At("HEAD")}
   )
   public void preWorldTick(BooleanSupplier var1, CallbackInfo var2) {
      EnergyClient.f_1622.f_1624.m_30(new Util104());
   }
}
