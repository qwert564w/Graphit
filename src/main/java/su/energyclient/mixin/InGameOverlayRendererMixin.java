package su.energyclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.DiffuseLighting.Type;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.util.Util80;

@Mixin({InGameOverlayRenderer.class})
public class InGameOverlayRendererMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   private MinecraftClient client;
   @Shadow
   private ItemStack floatingItem;
   @Shadow
   private int floatingItemTimer;
   @Shadow
   private float floatingItemOffsetX;
   @Shadow
   private float floatingItemOffsetY;
   private static final float f_12088 = 0.0F;
   private static final float f_12089 = 0.0F;
   private static final float f_12090 = 0.0F;
   private static final float f_12091 = 0.0F;
   private static final float f_12092 = 0.0F;
   private static final float f_12093 = 0.0F;
   private static final float f_12094 = 0.0F;
   private static final float f_12095 = 0.0F;
   private static final float f_12096 = 0.0F;
   private static final float f_12097 = 0.0F;
   private static final float f_12098 = 0.0F;
   private static final float f_12099 = 0.0F;
   private static final float f_12100 = 0.0F;
   private static final float f_12101 = 0.0F;
   private static final float f_12102 = 0.0F;
   private static final float f_12103 = 0.0F;
   private static final float f_12104 = 0.0F;
   private static final int f_12105 = 0;
   @Inject(
      method = {"renderFireOverlay"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void renderFireOverlayHook(MatrixStack var0, VertexConsumerProvider var1, Sprite var2, CallbackInfo var3) {
      EventNoRender var4 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.fire);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"renderUnderwaterOverlay"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void renderUnderwaterOverlayHook(MinecraftClient var0, MatrixStack var1, VertexConsumerProvider var2, CallbackInfo var3) {
      EventNoRender var4 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.underwater_blur);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"setFloatingItem"},
      at = {@At("TAIL")}
   )
   private void energy$setFloatingItem(ItemStack var1, Random var2, CallbackInfo var3) {
      Util80 var4 = EnergyClient.f_1622.f_1624.m_30(new Util80());
      if (var4.m_2244()) {
         this.floatingItemTimer = var4.m_1535();
      }
   }

   @Inject(
      method = {"renderFloatingItem"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$renderFloatingItem(MatrixStack var1, float var2, OrderedRenderCommandQueue var3, CallbackInfo var4) {
      Util80 var5 = EnergyClient.f_1622.f_1624.m_30(new Util80());
      if (var5.m_2244()) {
         if (this.floatingItem != null && this.floatingItemTimer > 0) {
            int var6 = var5.m_1535() - this.floatingItemTimer;
            float var7 = (var6 + var2) / var5.m_1535();
            float var8 = var7 * var7;
            float var9 = var7 * var8;
            float var10 = f_12088 * var9 * var8 - f_12089 * var8 * var8 + f_12090 * var9 - f_12091 * var8 + f_12092 * var7;
            float var11 = var10 * f_12093;
            float var12 = (float)this.client.getWindow().getFramebufferWidth() / this.client.getWindow().getFramebufferHeight();
            float var13 = this.floatingItemOffsetX * f_12094 * var12 * (float)var5.m_4068();
            float var14 = this.floatingItemOffsetY * f_12095 * (float)var5.m_3305();
            var1.push();
            var1.translate(
               var13 * MathHelper.abs(MathHelper.sin(var11 * 2.0F)),
               var14 * MathHelper.abs(MathHelper.sin(var11 * 2.0F)),
               f_12096 + f_12097 * MathHelper.sin(var11)
            );
            float var15 = f_12098 + f_12099 * Math.max(0.0F, MathHelper.sin(var11)) * var5.m_2127();
            var1.scale(var15, var15, var15);
            var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_12100 * MathHelper.abs(MathHelper.sin(var11 * var5.m_1932()))));
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_12101 * MathHelper.cos(var7 * f_12102)));
            var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_12103 * MathHelper.cos(var7 * f_12104)));
            this.client.gameRenderer.getDiffuseLighting().setShaderLights(Type.ITEMS_3D);
            ItemRenderState var16 = new ItemRenderState();
            this.client.getItemModelManager().clearAndUpdate(var16, this.floatingItem, ItemDisplayContext.FIXED, this.client.world, null, 0);
            var16.render(var1, var3, f_12105, OverlayTexture.DEFAULT_UV, 0);
            var1.pop();
         }

         var4.cancel();
      }
   }

   static {
      VMBridge.identifyClass(InGameOverlayRendererMixin.class, "9dWOYh9j");
   }
}
