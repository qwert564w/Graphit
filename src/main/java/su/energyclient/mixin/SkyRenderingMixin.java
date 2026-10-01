package su.energyclient.mixin;

import net.minecraft.client.render.SkyRendering;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.world.MoonPhase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.module.render.Shadersky;

@Mixin({SkyRendering.class})
public class SkyRenderingMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"renderTopSky"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$shaderSky(int var1, CallbackInfo var2) {
      if (Shadersky.m_608()) {
         var2.cancel();
         Shadersky.f_13903.m_3408();
      }
   }

   @Inject(
      method = {"renderCelestialBodies"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$skipCelestialWhenShaderSky(
      MatrixStack var1, float var2, float var3, float var4, MoonPhase var5, float var6, float var7, CallbackInfo var8
   ) {
      if (Shadersky.m_608()) {
         var8.cancel();
      }
   }
}
