package su.energyclient.mixin;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderManager;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.module.render.ShaderEsp;

@Mixin({EntityRenderManager.class})
public class EntityRenderManagerMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private static final Map<EntityRenderState, Entity> ENERGY$STATE_OWNERS = Collections.synchronizedMap(new WeakHashMap<>());

   @Inject(
      method = {"getAndUpdateRenderState"},
      at = {@At("RETURN")}
   )
   private <E extends Entity> void energy$rememberStateOwner(E var1, float var2, CallbackInfoReturnable<EntityRenderState> var3) {
      EntityRenderState var4 = (EntityRenderState)var3.getReturnValue();
      ENERGY$STATE_OWNERS.put(var4, var1);
      ShaderEsp var5 = ShaderEsp.f_5735;
      if (var5 != null && var5.m_3636(var1)) {
         var4.outlineColor = -1;
         ShaderEsp.f_5738 = true;
      }
   }

   @Inject(
      method = {"render"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private <S extends EntityRenderState> void renderEntityPlayer(
      S var1, CameraRenderState var2, double var3, double var5, double var7, MatrixStack var9, OrderedRenderCommandQueue var10, CallbackInfo var11
   ) {
      Entity var12 = ENERGY$STATE_OWNERS.get(var1);
      if (var12 instanceof PlayerEntity && var12 != MinecraftClient.getInstance().player) {
         EventNoRender var13 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.players);
         EnergyClient.f_1622.f_1624.m_30(var13);
         if (var13.m_2244()) {
            var11.cancel();
         }
      }

      EventNoRender var14 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.shadows);
      EnergyClient.f_1622.f_1624.m_30(var14);
      if (var14.m_2244()) {
         var1.shadowPieces.clear();
      }
   }
}
