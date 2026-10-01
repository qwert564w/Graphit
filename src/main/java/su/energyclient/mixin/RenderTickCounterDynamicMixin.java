package su.energyclient.mixin;

import it.unimi.dsi.fastutil.floats.FloatUnaryOperator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderTickCounter.Dynamic;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.util.Util117;
import su.energyclient.util.math.MathUtil3;

@Mixin({Dynamic.class})
public class RenderTickCounterDynamicMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   private float dynamicDeltaTicks;
   @Shadow
   private float tickProgress;
   @Shadow
   private long lastTimeMillis;
   @Final
   @Shadow
   private float tickTime;
   @Final
   @Shadow
   private FloatUnaryOperator targetMillisPerTick;

   @Inject(
      method = {"beginRenderTick(J)I"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void beginRenderTickHook(long var1, CallbackInfoReturnable<Integer> var3) {
      if (MinecraftClient.getInstance().player != null && !MathUtil3.m_3596()) {
         var3.setReturnValue(0);
      } else {
         if (Util117.f_13187 != 1.0F) {
            this.dynamicDeltaTicks = (float)(var1 - this.lastTimeMillis) / this.targetMillisPerTick.apply(this.tickTime) * Util117.f_13187;
            this.lastTimeMillis = var1;
            this.tickProgress = this.tickProgress + this.dynamicDeltaTicks;
            int var4 = (int)this.tickProgress;
            this.tickProgress -= var4;
            var3.setReturnValue(var4);
         }
      }
   }
}
