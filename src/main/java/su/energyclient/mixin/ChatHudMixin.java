package su.energyclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.MessageIndicator;
import net.minecraft.network.message.MessageSignatureData;
import net.minecraft.text.Text;
import org.joml.Matrix3x2fStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.Animations;

@Mixin({ChatHud.class})
public class ChatHudMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private boolean energy$chatAnimationPushed;
   private static final float f_764 = 0.0F;
   private static final float f_765 = 0.0F;
   private static final float f_766 = 0.0F;
   private static final float f_767 = 0.0F;
   @Inject(
      method = {"addMessage(Lnet/minecraft/text/Text;)V"},
      at = {@At("HEAD")}
   )
   private void energy$onSimpleAddMessage(Text var1, CallbackInfo var2) {
      this.energy$triggerChatAnimation();
   }

   @Inject(
      method = {"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V"},
      at = {@At("HEAD")}
   )
   private void energy$onSignedAddMessage(Text var1, MessageSignatureData var2, MessageIndicator var3, CallbackInfo var4) {
      this.energy$triggerChatAnimation();
   }

   @Inject(
      method = {"render"},
      at = {@At("HEAD")}
   )
   private void energy$onRenderHead(DrawContext var1, TextRenderer var2, int var3, int var4, int var5, boolean var6, boolean var7, CallbackInfo var8) {
      this.energy$chatAnimationPushed = false;
      Animations var9 = this.energy$getAnimationsModule();
      if (var9 != null) {
         float var10 = var9.m_3230();
         if (!(var10 <= f_764)) {
            float var11 = 1.0F + var10 * f_765;
            float var12 = -var10 * f_766;
            Matrix3x2fStack var13 = var1.getMatrices();
            float var14 = 2.0F;
            float var15 = MinecraftClient.getInstance().getWindow().getScaledHeight() - f_767;
            var13.pushMatrix();
            var13.translate(0.0F, var12);
            var13.translate(var14, var15);
            var13.scale(var11, var11);
            var13.translate(-var14, -var15);
            this.energy$chatAnimationPushed = true;
         }
      }
   }

   @Inject(
      method = {"render"},
      at = {@At("RETURN")}
   )
   private void energy$onRenderReturn(DrawContext var1, TextRenderer var2, int var3, int var4, int var5, boolean var6, boolean var7, CallbackInfo var8) {
      if (this.energy$chatAnimationPushed) {
         var1.getMatrices().popMatrix();
         this.energy$chatAnimationPushed = false;
      }
   }

   @Unique
   private void energy$triggerChatAnimation() {
      Animations var1 = this.energy$getAnimationsModule();
      if (var1 != null) {
         var1.m_3211();
      }
   }

   @Unique
   private Animations energy$getAnimationsModule() {
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null) {
         Animations var1 = InitManager.f_2740.f_2741.animations;
         return var1 != null && var1.m_677() ? var1 : null;
      } else {
         return null;
      }
   }

   static {
      VMBridge.identifyClass(ChatHudMixin.class, "KB0XLEuT");
   }
}
