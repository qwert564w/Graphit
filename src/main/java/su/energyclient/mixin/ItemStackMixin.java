package su.energyclient.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventUseFinish;

@Mixin({ItemStack.class})
public class ItemStackMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"finishUsing"},
      at = {@At("HEAD")}
   )
   private void energy$onFinishUsing(World var1, LivingEntity var2, CallbackInfoReturnable<ItemStack> var3) {
      EnergyClient.f_1622.f_1624.m_30(new EventUseFinish((ItemStack)(Object)this, var1, var2));
   }
}
