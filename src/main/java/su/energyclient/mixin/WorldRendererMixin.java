package su.energyclient.mixin;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import net.minecraft.client.gl.PostEffectProcessor;
import net.minecraft.client.gl.PostEffectProcessor.FramebufferSet;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.FrameGraphBuilder;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.memory.ObjectAllocator;
import net.minecraft.util.profiler.Profilers;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.impl.EventFreecamWorldRender;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.Ambience;
import su.energyclient.module.render.RealisticRain;
import su.energyclient.module.render.ShaderEsp;
import su.energyclient.module.render.Sonar;
import su.energyclient.util.Util79;

@Mixin({WorldRenderer.class})
public abstract class WorldRendererMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_3491 = "";
   @Inject(
      method = {"render"},
      at = {@At("RETURN")}
   )
   private void render(
      ObjectAllocator var1,
      RenderTickCounter var2,
      boolean var3,
      Camera var4,
      Matrix4f var5,
      Matrix4f var6,
      Matrix4f var7,
      GpuBufferSlice var8,
      Vector4f var9,
      boolean var10,
      CallbackInfo var11
   ) {
      Profilers.get().swap(f_3491);
      MatrixStack var12 = new MatrixStack();
      var12.multiplyPositionMatrix(var5);
      Sonar var13 = InitManager.f_2740.f_2741.sonar;
      if (var13 != null && var13.m_677()) {
         var13.m_2035(var5, var6, var4.getCameraPos());
      }

      RealisticRain var14 = RealisticRain.f_4178;
      if (var14 != null && var14.m_677()) {
         var14.m_657(var5, var6, var4, var2.getTickProgress(false));
      }

      Ambience var15 = Ambience.f_6196;
      if (var15 != null) {
         var15.m_777(var5, var6, var9);
      }
   }

   @ModifyVariable(
      method = {"render"},
      at = @At("HEAD"),
      ordinal = 0,
      argsOnly = true
   )
   private boolean energy$disableVanillaBlockOutline(boolean var1) {
      return InitManager.f_2740 != null
            && InitManager.f_2740.f_2741 != null
            && InitManager.f_2740.f_2741.blockHighlight != null
            && InitManager.f_2740.f_2741.blockHighlight.m_677()
         ? false
         : var1;
   }

   @Inject(
      method = {"method_62214"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/util/profiler/Profiler;pop()V"
      )}
   )
   private void onEventLevel(CallbackInfo var1) {
      MatrixStack var2 = new MatrixStack();
      float var3 = QuickImports.f_5909.getRenderTickCounter().getTickProgress(false);
      Util79 var4 = new Util79(var2, var3);
      EnergyClient.f_1622.f_1624.m_30(var4);
   }

   @ModifyArg(
      method = {"render"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/WorldRenderer;updateCamera(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/Frustum;Z)V"
      ),
      index = 2
   )
   private boolean modifySpectator(boolean var1) {
      EventFreecamWorldRender var2 = new EventFreecamWorldRender(var1);
      EnergyClient.f_1622.f_1624.m_30(var2);
      return var2.m_780();
   }

   @Inject(
      method = {"renderWeather"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRenderWeather(CallbackInfo var1) {
      EventNoRender var2 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.rain);
      EnergyClient.f_1622.f_1624.m_30(var2);
      if (var2.m_2244()) {
         var1.cancel();
      }
   }

   @Redirect(
      method = {"render"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/gl/PostEffectProcessor;render(Lnet/minecraft/client/render/FrameGraphBuilder;IILnet/minecraft/client/gl/PostEffectProcessor$FramebufferSet;)V",
         ordinal = 0
      )
   )
   private void energy$onPostEffectRender(PostEffectProcessor var1, FrameGraphBuilder var2, int var3, int var4, FramebufferSet var5) {
      if (ShaderEsp.f_5735 == null || ShaderEsp.f_5735.m_1090(false)) {
         var1.render(var2, var3, var4, var5);
      }
   }

   @Inject(
      method = {"drawEntityOutlinesFramebuffer"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$onDrawEntityOutlines(CallbackInfo var1) {
      if (ShaderEsp.f_5735 != null && ShaderEsp.f_5735.m_677()) {
         var1.cancel();
      }
   }

   @Inject(
      method = {"method_62214"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/OutlineVertexConsumerProvider;draw()V"
      )}
   )
   private void energy$onOutlineDraw(CallbackInfo var1) {
      if (ShaderEsp.f_5735 != null) {
         ShaderEsp.f_5735.m_1090(true);
      }
   }

   static {
      VMBridge.identifyClass(WorldRendererMixin.class, "igdcFz4s");
   }
}
