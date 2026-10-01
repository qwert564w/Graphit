package su.energyclient.mixin;

import java.nio.ByteBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventFogColor;
import su.energyclient.event.impl.EventFogDistance;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.module.render.Ambience;

@Mixin({FogRenderer.class})
public abstract class FogRendererMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private static boolean minced$fogColorModified;
   private static final float f_4926 = 0.0F;
   @Inject(
      method = {"getFogColor"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void onGetFogColor(Camera var1, float var2, ClientWorld var3, int var4, float var5, CallbackInfoReturnable<Vector4f> var6) {
      Vector4f var7 = (Vector4f)var6.getReturnValue();
      EventFogColor var8 = new EventFogColor(var7.x, var7.y, var7.z);
      EnergyClient.f_1622.f_1624.m_30(var8);
      boolean var9 = var8.m_693() != var7.x || var8.m_170() != var7.y || var8.m_2055() != var7.z;
      if (var9) {
         var6.setReturnValue(new Vector4f(var8.m_693(), var8.m_170(), var8.m_2055(), var7.w));
      }

      minced$fogColorModified = var9;
   }

   @Shadow
   private void applyFog(ByteBuffer var1, int var2, Vector4f var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      throw new AssertionError();
   }

   @Redirect(
      method = {"applyFog(Lnet/minecraft/client/render/Camera;ILnet/minecraft/client/render/RenderTickCounter;FLnet/minecraft/client/world/ClientWorld;)Lorg/joml/Vector4f;"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/fog/FogRenderer;applyFog(Ljava/nio/ByteBuffer;ILorg/joml/Vector4f;FFFFFF)V"
      )
   )
   private void energy$modifyFogDistances(
      FogRenderer var1,
      ByteBuffer var2,
      int var3,
      Vector4f var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      Camera var11,
      int var12,
      RenderTickCounter var13,
      float var14,
      ClientWorld var15
   ) {
      if (!minced$fogColorModified
         && var11.getFocusedEntity() instanceof LivingEntity var17
         && (var17.hasStatusEffect(StatusEffects.BLINDNESS) || var17.hasStatusEffect(StatusEffects.DARKNESS))) {
         EventNoRender var18 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.bad_effects);
         EnergyClient.f_1622.f_1624.m_30(var18);
         if (var18.m_2244()) {
            var5 = var8 * f_4926;
            var6 = var8;
         }
      }

      EventFogDistance var19 = new EventFogDistance(var5, var6);
      EnergyClient.f_1622.f_1624.m_30(var19);
      if (var19.m_960() != var5 || var19.m_604() != var6) {
         var5 = var19.m_960();
         var6 = var19.m_604();
         var7 = var19.m_960();
         var8 = var19.m_604();
      }

      Ambience var20 = Ambience.f_6196;
      if (var20 != null) {
         var20.m_3319(var5, var6, var7, var8);
      }

      this.applyFog(var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   static {
      VMBridge.identifyClass(FogRendererMixin.class, "c9M6iekL");
   }
}
