package su.energyclient.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.module.render.ShaderEsp;
import su.energyclient.util.Util142;
import su.energyclient.util.Util169;
import su.energyclient.util.Util45;
import su.energyclient.util.Util77;

@Mixin({InGameHud.class})
public class InGameHudMixin2 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"render"},
      at = {@At("HEAD")}
   )
   private void onRender2D(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
      if (ShaderEsp.f_5735 != null && ShaderEsp.f_5735.m_677()) {
         ShaderEsp.f_5735.m_1441();
      }

      Util45.LMzZzDWjhPUT0g02 var4 = Util45.m_1273(2.0F);
      float var5 = var4 != null && var4.f_8394 > 0 ? 2.0F / var4.f_8394 : 1.0F;

      try (Util77.spzMrT3b6LRsUJ1m var6 = Util77.m_2198(var1, var5)) {
         Util142.f_12027.m_1746(2.0F, 4);
         EnergyClient.f_1622.f_1624.m_30(new Util169(var1, var2.getTickProgress(false)));
      } finally {
         Util45.m_3922(var4);
      }
   }

   @Inject(
      method = {"renderScoreboardSidebar"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRenderScoreboard(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
      EventNoRender var4 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.scoreboard);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"renderVignetteOverlay"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void vignetta(DrawContext var1, Entity var2, CallbackInfo var3) {
      EventNoRender var4 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.vignette);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"renderTitleAndSubtitle"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderStatusBars(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
      EventNoRender var4 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.title);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var3.cancel();
      }
   }
}
