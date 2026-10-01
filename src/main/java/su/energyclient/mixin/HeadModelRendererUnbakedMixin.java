package su.energyclient.mixin;

import net.minecraft.block.SkullBlock.Type;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer;
import net.minecraft.client.render.item.model.special.HeadModelRenderer.Unbaked;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer.BakeContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Unbaked.class})
public abstract class HeadModelRendererUnbakedMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"bake"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$playerHeadUsesProfile(BakeContext var1, CallbackInfoReturnable<SpecialModelRenderer<?>> var2) {
      Unbaked var3 = (Unbaked)(Object)this;
      if (var3.kind() == Type.PLAYER && var3.textureOverride().isEmpty()) {
         var2.setReturnValue(new net.minecraft.client.render.item.model.special.PlayerHeadModelRenderer.Unbaked().bake(var1));
      }
   }
}
