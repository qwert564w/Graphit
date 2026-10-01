package su.energyclient.mixin;

import net.minecraft.client.render.OutlineVertexConsumerProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.OutlineVertexConsumerProvider.OutlineVertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.module.render.ShaderEsp;

@Mixin({OutlineVertexConsumerProvider.class})
public class OutlineVertexConsumerProviderMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   private Immediate plainDrawer;
   @Shadow
   private int OUTLINE_COLOR;

   @Inject(
      method = {"getBuffer"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$hook(RenderLayer var1, CallbackInfoReturnable<VertexConsumer> var2) {
      if (ShaderEsp.f_5736 != null && !ShaderEsp.f_5737 && !var1.isOutline()) {
         var1.getAffectedOutline().ifPresent(var2x -> {
            VertexConsumer var3 = this.plainDrawer.getBuffer(var2x);
            OutlineVertexConsumer var4 = new OutlineVertexConsumer(var3, this.OUTLINE_COLOR);
            var2.setReturnValue(var4);
            var2.cancel();
         });
      }
   }
}
