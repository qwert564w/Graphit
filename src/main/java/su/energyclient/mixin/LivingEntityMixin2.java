package su.energyclient.mixin;

import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.ColorHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.InvisibleOpacity;
import su.energyclient.render.RenderUtil5;
import su.energyclient.util.Util108;

@Mixin({LivingEntityRenderer.class})
public abstract class LivingEntityMixin2<T extends LivingEntity, S extends LivingEntityRenderState, M extends EntityModel<? super S>> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   protected M model;
   @Unique
   private LivingEntity energy$lastEntity;
   private static final int f_12411 = 0;
   private static final float f_12412 = 0.0F;
   @Inject(
      method = {"updateRenderState(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;F)V"},
      at = {@At("HEAD")}
   )
   private void onUpdateRenderState(T var1, S var2, float var3, CallbackInfo var4) {
      this.energy$lastEntity = var1;
   }

   @Inject(
      method = {"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/util/math/MatrixStack;pop()V",
         shift = Shift.BEFORE
      )}
   )
   private void onRenderLayerHead(S var1, MatrixStack var2, OrderedRenderCommandQueue var3, CameraRenderState var4, CallbackInfo var5) {
      if (!(var1 instanceof PlayerEntityRenderState var6 && RenderUtil5.isPreview(var6))) {
         if (this.energy$lastEntity != null) {
            EnergyClient.f_1622.f_1624.m_30(new Util108(this.energy$lastEntity, var2, this.model));
         }
      }
   }

   @ModifyArg(
      method = {"render(Lnet/minecraft/client/render/entity/state/LivingEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/util/math/ColorHelper;mix(II)I"
      ),
      index = 0
   )
   private int modifyInvisibleColor(int var1) {
      if (var1 != f_12411) {
         return var1;
      } else {
         InvisibleOpacity var2 = InitManager.f_2740.f_2741.invisibleOpacity;
         float var3 = var2 != null && var2.m_677() ? var2.m_3327().m_4046() : f_12412;
         return ColorHelper.fromFloats(var3, 1.0F, 1.0F, 1.0F);
      }
   }

   static {
      VMBridge.identifyClass(LivingEntityMixin2.class, "XGDC8jc2");
   }
}
