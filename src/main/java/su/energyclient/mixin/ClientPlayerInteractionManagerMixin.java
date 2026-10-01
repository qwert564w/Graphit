package su.energyclient.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.event.impl.EventClickBlockRight;
import su.energyclient.event.impl.EventWindowClick;
import su.energyclient.manager.InitManager;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.util.Util128;
import su.energyclient.util.Util160;
import su.energyclient.util.Util29;

@Mixin({ClientPlayerInteractionManager.class})
public abstract class ClientPlayerInteractionManagerMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   @Final
   private ClientPlayNetworkHandler networkHandler;

   @Inject(
      method = {"tick"},
      at = {@At("HEAD")}
   )
   public void tick(CallbackInfo var1) {
      Util160.f_8275++;
   }

   @Inject(
      method = {"interactBlock"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void interactBlock(ClientPlayerEntity var1, Hand var2, BlockHitResult var3, CallbackInfoReturnable<ActionResult> var4) {
      EventClickBlockRight var5 = new EventClickBlockRight(var1, (ClientWorld)var1.getEntityWorld(), var2, var3);
      EnergyClient.f_1622.f_1624.m_30(var5);
      if (var5.m_2244()) {
         ((ClientPlayerInteractionManagerMixin2)(Object)this).invokeSyncSelectedSlot();
         var4.setReturnValue(ActionResult.PASS);
      }
   }

   @Inject(
      method = {"attackEntity"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void attackEntity(PlayerEntity var1, Entity var2, CallbackInfo var3) {
      if (var2 instanceof Util29 var8) {
         AttackAura var5 = InitManager.f_2740.f_2741.attackAura;
         boolean var6 = var5 != null && var5.m_677() && var5.f_3636 && var2 == var5.m_891();
         if (var6 && !var5.m_550().m_2318(var5)) {
            var3.cancel();
         } else {
            float var7 = (float)var1.getAttributeValue(EntityAttributes.ATTACK_DAMAGE);
            var8.takeLocalHit(var1.getDamageSources().playerAttack(var1), var7);
            if (var6) {
               var5.m_2972();
            }

            var1.swingHand(Hand.MAIN_HAND);
            var3.cancel();
         }
      } else {
         EventAttack var4 = new EventAttack(var2);
         EnergyClient.f_1622.f_1624.m_30(var4);
         if (var2.equals(var1) || var4.m_2244()) {
            var3.cancel();
         }

         Util160.f_8275 = 0;
      }
   }

   @Inject(
      method = {"attackEntity"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayNetworkHandler;sendPacket(Lnet/minecraft/network/packet/Packet;)V",
         ordinal = 0
      )},
      cancellable = true
   )
   private void energy$checkAuraCriticalBeforePacket(PlayerEntity var1, Entity var2, CallbackInfo var3) {
      AttackAura var4 = InitManager.f_2740.f_2741.attackAura;
      if (var4 != null && var4.m_677() && var4.f_3636 && var2 == var4.m_891() && !var4.m_550().m_2318(var4)) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"attackEntity"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayNetworkHandler;sendPacket(Lnet/minecraft/network/packet/Packet;)V",
         ordinal = 0,
         shift = Shift.AFTER
      )},
      cancellable = true
   )
   private void energy$skipCancelledAuraAttack(PlayerEntity var1, Entity var2, CallbackInfo var3) {
      AttackAura var4 = InitManager.f_2740.f_2741.attackAura;
      if (var4 != null && var4.m_677() && var4.f_3636 && var2 == var4.m_891() && !var4.m_1068()) {
         var3.cancel();
      }
   }

   @Redirect(
      method = {"clickSlot"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayNetworkHandler;sendPacket(Lnet/minecraft/network/packet/Packet;)V"
      )
   )
   public void onClickSlot(ClientPlayNetworkHandler var1, Packet<?> var2) {
      if (var2 instanceof ClickSlotC2SPacket var3) {
         EventWindowClick var4 = new EventWindowClick(
            var3.syncId(), var3.revision(), var3.slot(), var3.button(), var3.actionType(), var3.cursor(), var3.modifiedStacks()
         );
         EnergyClient.f_1622.f_1624.m_30(var4);
         if (!var4.m_2244()) {
            this.networkHandler
               .sendPacket(new ClickSlotC2SPacket(var4.m_1366(), var4.m_1064(), var4.m_1550(), var4.m_1602(), var4.m_396(), var4.m_2662(), var4.m_1729()));
         }
      }
   }

   @Inject(
      method = {"interactItem"},
      at = {@At("HEAD")}
   )
   private void energy$interactItemEnter(PlayerEntity var1, Hand var2, CallbackInfoReturnable<ActionResult> var3) {
      Util128.m_2307();
   }

   @Inject(
      method = {"interactItem"},
      at = {@At("RETURN")}
   )
   private void energy$interactItemLeave(PlayerEntity var1, Hand var2, CallbackInfoReturnable<ActionResult> var3) {
      Util128.m_2759();
   }
}
