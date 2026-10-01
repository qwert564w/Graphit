package su.energyclient.mixin;

import net.minecraft.block.AbstractBlock.AbstractBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoRender;

@Mixin({AbstractBlockState.class})
public class AbstractBlockAbstractBlockStateMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"shouldBlockVision"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void shouldBlockVision(BlockView var1, BlockPos var2, CallbackInfoReturnable<Boolean> var3) {
      EventNoRender var4 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.cameraclip);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var3.setReturnValue(false);
      }
   }
}
