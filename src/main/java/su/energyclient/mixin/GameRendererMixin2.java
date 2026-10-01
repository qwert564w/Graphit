package su.energyclient.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import java.nio.IntBuffer;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.event.impl.EventThirdPersonRender;
import su.energyclient.render.RenderUtil6;
import su.energyclient.util.Util114;
import su.energyclient.util.Util26;
import su.energyclient.util.Util88;

@Mixin({GameRenderer.class})
public abstract class GameRendererMixin2 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_7771 = 36010;
   private static final int f_7772 = 36006;
   private static final int f_7773 = 36160;
   private static final int f_7774 = 36008;
   private static final int f_7775 = 36009;
   private static final int f_7776 = 36008;
   private static final int f_7777 = 36009;
   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Inject(
      method = {"renderWorld"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/WorldRenderer;render(Lnet/minecraft/client/util/memory/ObjectAllocator;Lnet/minecraft/client/render/RenderTickCounter;ZLnet/minecraft/client/render/Camera;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lorg/joml/Vector4f;Z)V",
         shift = Shift.AFTER
      )}
   )
   public void hookWorldRender(RenderTickCounter var1, CallbackInfo var2, @Local(ordinal = 0) Matrix4f var3, @Local(ordinal = 1) Matrix4f var4) {
      MatrixStack var5 = new MatrixStack();
      var5.multiplyPositionMatrix(var4);
      Util88 var6 = new Util88(var5, var1.getTickProgress(true));
      int var7 = GL11.glGetInteger(f_7771);
      int var8 = GL11.glGetInteger(f_7772);
      MemoryStack var9 = MemoryStack.stackPush();

      try {
         IntBuffer var10 = var9.mallocInt(4);
         GL11.glGetIntegerv(2978, var10);
         boolean var20 = false /* VF: Semaphore variable */;

         try {
            var20 = true;
            GL30.glBindFramebuffer(f_7773, RenderUtil6.m_823(f_5909.getFramebuffer()));
            GL11.glViewport(0, 0, f_5909.getFramebuffer().textureWidth, f_5909.getFramebuffer().textureHeight);

            try (Util114.v4av9TJhTFdXLTYo var11 = Util114.m_220(var3)) {
               EnergyClient.f_1622.f_1624.m_30(var6);
            }
         } finally {
            if (var20) {
               GL30.glBindFramebuffer(f_7776, var7);
               GL30.glBindFramebuffer(f_7777, var8);
               GL11.glViewport(var10.get(0), var10.get(1), var10.get(2), var10.get(3));
            }
         }

         GL30.glBindFramebuffer(f_7774, var7);
         GL30.glBindFramebuffer(f_7775, var8);
         GL11.glViewport(var10.get(0), var10.get(1), var10.get(2), var10.get(3));
      } catch (Throwable var25) {
         if (var9 != null) {
            try {
               var9.close();
            } catch (Throwable var21) {
               var25.addSuppressed(var21);
            }
         }

         throw var25;
      }

      if (var9 != null) {
         var9.close();
      }
   }

   @ModifyArg(
      method = {"getBasicProjectionMatrix"},
      at = @At(
         value = "INVOKE",
         target = "Lorg/joml/Matrix4f;perspective(FFFF)Lorg/joml/Matrix4f;"
      ),
      index = 1
   )
   private float modifyAspectRatio(float var1) {
      Util26 var2 = new Util26(var1);
      EnergyClient.f_1622.f_1624.m_30(var2);
      return !var2.m_2244() ? var2.m_3791() : var1;
   }

   @Inject(
      method = {"tiltViewWhenHurt"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onTiltViewWhenHurt(MatrixStack var1, float var2, CallbackInfo var3) {
      if (f_5909.player != null && f_5909.world != null) {
         EventNoRender var4 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.hurttime);
         EnergyClient.f_1622.f_1624.m_30(var4);
         if (var4.m_2244()) {
            var3.cancel();
         }
      }
   }

   @Redirect(
      method = {"renderHand"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/option/Perspective;isFirstPerson()Z",
         ordinal = 0
      )
   )
   private boolean onRenderHand(Perspective var1) {
      EventThirdPersonRender var2 = new EventThirdPersonRender(var1.isFirstPerson());
      EnergyClient.f_1622.f_1624.m_30(var2);
      return var2.m_152();
   }

   static {
      VMBridge.identifyClass(GameRendererMixin2.class, "GE3XBlD7");
   }
}
