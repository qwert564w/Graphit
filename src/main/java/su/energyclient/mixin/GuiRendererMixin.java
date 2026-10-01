package su.energyclient.mixin;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.render.EntityGuiElementRenderer;
import net.minecraft.client.gui.render.GuiRenderer;
import net.minecraft.client.gui.render.state.GuiRenderState;
import net.minecraft.client.gui.render.state.special.EntityGuiElementRenderState;
import net.minecraft.client.gui.render.state.special.SpecialGuiElementRenderState;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.render.RenderUtil5;

@Mixin({GuiRenderer.class})
public abstract class GuiRendererMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   @Final
   private GuiRenderState state;
   @Shadow
   @Final
   private Immediate vertexConsumers;
   @Unique
   private final List<EntityGuiElementRenderer> energy$cosmeticPreviews = new ArrayList<>();
   @Unique
   private int energy$nextCosmeticPreview;

   @Inject(
      method = {"prepareSpecialElements"},
      at = {@At("HEAD")}
   )
   private void energy$beginCosmeticPreviews(CallbackInfo var1) {
      this.energy$nextCosmeticPreview = 0;
   }

   @Inject(
      method = {"prepareSpecialElement"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$prepareCosmeticPreview(SpecialGuiElementRenderState var1, int var2, CallbackInfo var3) {
      if (var1 instanceof EntityGuiElementRenderState var4 && var4.renderState() instanceof PlayerEntityRenderState var5 && RenderUtil5.isPreview(var5)) {
         int var7 = this.energy$nextCosmeticPreview++;
         if (var7 == this.energy$cosmeticPreviews.size()) {
            this.energy$cosmeticPreviews.add(new EntityGuiElementRenderer(this.vertexConsumers, MinecraftClient.getInstance().getEntityRenderDispatcher()));
         }

         this.energy$cosmeticPreviews.get(var7).render(var4, this.state, var2);
         var3.cancel();
      }
   }

   @Inject(
      method = {"prepareSpecialElements"},
      at = {@At("RETURN")}
   )
   private void energy$releaseUnusedCosmeticPreviews(CallbackInfo var1) {
      for (int var2 = this.energy$cosmeticPreviews.size() - 1; var2 >= this.energy$nextCosmeticPreview; var2--) {
         this.energy$cosmeticPreviews.remove(var2).close();
      }
   }

   @Inject(
      method = {"close"},
      at = {@At("HEAD")}
   )
   private void energy$closeCosmeticPreviews(CallbackInfo var1) {
      for (EntityGuiElementRenderer var3 : this.energy$cosmeticPreviews) {
         var3.close();
      }

      this.energy$cosmeticPreviews.clear();
      this.energy$nextCosmeticPreview = 0;
   }
}
