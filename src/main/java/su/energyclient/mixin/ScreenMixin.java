package su.energyclient.mixin;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.ClickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.CommandManager;
import su.energyclient.util.Util157;
import su.energyclient.util.Util77;

@Mixin({Screen.class})
public abstract class ScreenMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private Util77.spzMrT3b6LRsUJ1m energy$retainedHudScope;

   @Inject(
      method = {"renderWithTooltip"},
      at = {@At("HEAD")}
   )
   private void energy$beginRetainedHud(DrawContext var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (this.energy$retainedHudScope != null) {
         this.energy$retainedHudScope.close();
      }

      this.energy$retainedHudScope = Util77.m_266(var1);
   }

   @Inject(
      method = {"renderWithTooltip"},
      at = {@At("RETURN")}
   )
   private void energy$endRetainedHud(DrawContext var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (this.energy$retainedHudScope != null) {
         this.energy$retainedHudScope.close();
         this.energy$retainedHudScope = null;
      }
   }

   @Inject(
      method = {"handleClickEvent"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void onRunCommand(ClickEvent var0, MinecraftClient var1, Screen var2, CallbackInfo var3) {
      if (var0 instanceof Util157 var4) {
         String var5 = var4.getValue();
         CommandManager var6 = InitManager.f_2740.f_2742;
         String var7 = var6.m_1465();

         try {
            if (var5.startsWith(var7)) {
               var6.m_4069().execute(var5.substring(var7.length()), var6.O());
            } else {
               var6.m_4069().execute(var5, var6.O());
            }

            var3.cancel();
         } catch (CommandSyntaxException var9) {
         }
      }
   }

   @Inject(
      method = {"renderInGameBackground"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void renderInGameBackground(DrawContext var1, CallbackInfo var2) {
      EventNoRender var3 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.container_background);
      EnergyClient.f_1622.f_1624.m_30(var3);
      if (var3.m_2244()) {
         var2.cancel();
      }
   }
}
