package su.energyclient.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.ColorHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.QuickImports;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.InvisibleOpacity;

@Mixin({PlayerEntityRenderer.class})
public abstract class PlayerEntityRendererMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Redirect(
      method = {"renderArm"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;submitModelPart(Lnet/minecraft/client/model/ModelPart;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/RenderLayer;IILnet/minecraft/client/texture/Sprite;)V"
      )
   )
   private void redirectArmRender(OrderedRenderCommandQueue var1, ModelPart var2, MatrixStack var3, RenderLayer var4, int var5, int var6, Sprite var7) {
      InvisibleOpacity var8 = InitManager.f_2740.f_2741.invisibleOpacity;
      boolean var9 = QuickImports.f_5909.player != null && QuickImports.f_5909.player.isInvisible();
      int var10 = ColorHelper.fromFloats(var8.m_677() && var9 ? var8.m_3327().m_4046() : 1.0F, 1.0F, 1.0F, 1.0F);
      var1.submitModelPart(var2, var3, var4, var5, var6, var7, var10, null);
   }

   @Inject(
      method = {"renderLabelIfPresent*", "renderLabelIfPresent*"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRenderLabel(PlayerEntityRenderState var1, MatrixStack var2, OrderedRenderCommandQueue var3, CameraRenderState var4, CallbackInfo var5) {
      if (InitManager.f_2740.f_2741.tags.m_677()) {
         var5.cancel();
      }
   }
}
