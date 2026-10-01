package su.energyclient.mixin;

import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventThirdPersonDistance;
import su.energyclient.util.Util173;

@Mixin({Camera.class})
public abstract class CameraMixin2 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"update"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/Camera;setPos(DDD)V",
         shift = Shift.AFTER
      )}
   )
   private void onUpdateInject(World var1, Entity var2, boolean var3, boolean var4, float var5, CallbackInfo var6) {
      Util173 var7 = new Util173(((Camera)(Object)this).getCameraPos(), new Vec2f(var2.getYaw(var5), var2.getPitch(var5)));
      EnergyClient.f_1622.f_1624.m_30(var7);
      Vec2f var8 = var7.m_556();
      ((CameraMixin)(Object)this).invokeSetRotation(var8.x, var8.y);
      ((CameraMixin)(Object)this).invokeSetPos(var7.m_2454());
   }

   @Inject(
      method = {"clipToSpace"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void onClipToSpace(float var1, CallbackInfoReturnable<Float> var2) {
      EventThirdPersonDistance var3 = new EventThirdPersonDistance((Float)var2.getReturnValue());
      EnergyClient.f_1622.f_1624.m_30(var3);
      var2.setReturnValue(var3.m_2439());
   }
}
