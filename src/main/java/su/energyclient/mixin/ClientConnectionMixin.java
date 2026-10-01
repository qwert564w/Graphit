package su.energyclient.mixin;

import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.Full;
import net.minecraft.network.packet.s2c.play.BossBarS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.manager.InitManager;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.module.combat.Macetarget;
import su.energyclient.util.Util101;
import su.energyclient.util.Util128;
import su.energyclient.util.Util162;
import su.energyclient.util.Util50;
import su.energyclient.util.Util66;

@Mixin({ClientConnection.class})
public abstract class ClientConnectionMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/packet/Packet;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void channelRead0(ChannelHandlerContext var1, Packet<?> var2, CallbackInfo var3) {
      Util66 var4 = new Util66(var2, Util66.F3wLV3PCaxhjBqJ6.RECEIVE);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"send(Lnet/minecraft/network/packet/Packet;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void send(Packet<?> var1, CallbackInfo var2) {
      if (Util128.m_406() && var1 instanceof Full) {
         var2.cancel();
      } else {
         if (!Util162.m_531().remove(var1)) {
            Util66 var3 = new Util66(var1, Util66.F3wLV3PCaxhjBqJ6.SEND);
            EnergyClient.f_1622.f_1624.m_30(var3);
            if (var3.m_2244()) {
               var2.cancel();
               return;
            }
         }

         if (var1 instanceof ClientCommandC2SPacket var4) {
            if (var4.getMode() == Mode.START_SPRINTING) {
               Util50.f_7978 = true;
            } else if (var4.getMode() == Mode.STOP_SPRINTING) {
               Util50.f_7978 = false;
            }
         }

         if (InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null) {
            AttackAura var5 = InitManager.f_2740.f_2741.attackAura;
            if (var5 != null && var5.m_677() && !Macetarget.m_329()) {
               var5.m_550().m_2681(var1, var5);
            }
         }
      }
   }

   @Inject(
      method = {"channelRead0"},
      at = {@At("HEAD")}
   )
   private void bossbar(ChannelHandlerContext var1, Packet<?> var2, CallbackInfo var3) {
      if (var2 instanceof BossBarS2CPacket var4) {
         Util101.I(var4);
      }
   }
}
