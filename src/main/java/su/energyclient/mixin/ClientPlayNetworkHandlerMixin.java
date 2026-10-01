package su.energyclient.mixin;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TrackedPosition;
import net.minecraft.network.packet.s2c.play.EntityS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.manager.InitManager;
import su.energyclient.module.miscellaneous.StaffExploit;
import su.energyclient.util.Util41;

@Mixin({ClientPlayNetworkHandler.class})
public abstract class ClientPlayNetworkHandlerMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"sendChatMessage"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void send(String var1, CallbackInfo var2) {
      if (StaffExploit.m_1648()) {
         var2.cancel();
      } else {
         if (var1.startsWith(InitManager.f_2740.f_2742.m_1465())) {
            try {
               InitManager.f_2740.f_2742.m_4069().execute(var1.substring(InitManager.f_2740.f_2742.m_1465().length()), InitManager.f_2740.f_2742.O());
            } catch (CommandSyntaxException var4) {
            }

            var2.cancel();
         }
      }
   }

   @Inject(
      method = {"onEntityStatus"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/GameRenderer;showFloatingItem(Lnet/minecraft/item/ItemStack;)V"
      )},
      cancellable = true
   )
   private void onRender(EntityStatusS2CPacket var1, CallbackInfo var2) {
      EventNoRender var3 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.totem);
      EnergyClient.f_1622.f_1624.m_30(var3);
      if (var3.m_2244()) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"onEntity"},
      at = {@At("HEAD")}
   )
   private void onEntity(EntityS2CPacket var1, CallbackInfo var2) {
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var3.world != null) {
         Entity var4 = var1.getEntity(var3.world);
         if (var4 instanceof LivingEntity) {
            if (var4 instanceof Util41 var5) {
               Vec3d var6 = var4.getTrackedPosition().getPos();
               double var7 = var6.x;
               double var9 = var6.y;
               double var11 = var6.z;
               if (var1.isPositionChanged()) {
                  TrackedPosition var13 = var4.getTrackedPosition();
                  Vec3d var14 = var13.withDelta(var1.getDeltaX(), var1.getDeltaY(), var1.getDeltaZ());
                  var7 = var14.x;
                  var9 = var14.y;
                  var11 = var14.z;
               }

               var5.setServerPos(var7, var9, var11);
            }
         }
      }
   }
}
