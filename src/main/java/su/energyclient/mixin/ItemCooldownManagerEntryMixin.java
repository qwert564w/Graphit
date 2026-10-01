package su.energyclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(
   targets = {"net/minecraft/entity/player/ItemCooldownManager$Entry"}
)
public interface ItemCooldownManagerEntryMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Invoker("startTick")
   int callStartTick();

   @Invoker("endTick")
   int callEndTick();
}
