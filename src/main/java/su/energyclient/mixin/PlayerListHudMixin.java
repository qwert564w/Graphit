package su.energyclient.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.PlayerListHud;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardObjective;
import org.joml.Matrix3x2fStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.Animations;

@Mixin({PlayerListHud.class})
public class PlayerListHudMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private boolean energy$tabAnimationPushed;
   private static final float f_4650 = 0.0F;
   private static final float f_4651 = 0.0F;
   private static final float f_4652 = 0.0F;
   private static final float f_4653 = 0.0F;
   private static final float f_4654 = 0.0F;
   @Inject(
      method = {"render"},
      at = {@At("HEAD")}
   )
   private void energy$onRenderHead(DrawContext var1, int var2, Scoreboard var3, ScoreboardObjective var4, CallbackInfo var5) {
      this.energy$tabAnimationPushed = false;
      Animations var6 = this.energy$getAnimationsModule();
      if (var6 != null) {
         float var7 = var6.m_1947();
         if (!(var7 >= f_4650)) {
            float var8 = f_4651 + f_4652 * var7;
            float var9 = -(1.0F - var7) * f_4653;
            Matrix3x2fStack var10 = var1.getMatrices();
            float var11 = var2 / 2.0F;
            float var12 = f_4654;
            var10.pushMatrix();
            var10.translate(0.0F, var9);
            var10.translate(var11, var12);
            var10.scale(var8, var8);
            var10.translate(-var11, -var12);
            this.energy$tabAnimationPushed = true;
         }
      }
   }

   @Inject(
      method = {"render"},
      at = {@At("RETURN")}
   )
   private void energy$onRenderReturn(DrawContext var1, int var2, Scoreboard var3, ScoreboardObjective var4, CallbackInfo var5) {
      if (this.energy$tabAnimationPushed) {
         var1.getMatrices().popMatrix();
         this.energy$tabAnimationPushed = false;
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
      VMBridge.identifyClass(PlayerListHudMixin.class, "gLEK4tWG");
   }
}
