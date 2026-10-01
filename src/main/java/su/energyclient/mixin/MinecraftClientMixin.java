package su.energyclient.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.command.impl.PanicCommand;
import su.energyclient.event.impl.EventRightClickItemCheck;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.ShaderEsp;
import su.energyclient.module.render.Shaderhands;
import su.energyclient.util.Util124;
import su.energyclient.util.Util16;
import su.energyclient.util.Util164;
import su.energyclient.util.Util19;
import su.energyclient.util.Util90;
import su.energyclient.util.Util92;

@Mixin({MinecraftClient.class})
public abstract class MinecraftClientMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   private ClientWorld world;
   @Unique
   private long lastHookTime = Util.getMeasuringTimeNano();
   @Unique
   private int accumulatedCalls = 0;
   @Unique
   private boolean autoConfigLoaded = false;
   @Unique
   private boolean screenshotSent = false;
   private static final long f_10637 = 16666666L;
   private static final long f_10638 = 16666666L;
   private static final String f_10639 = "Minecraft 1.21.11";
   private static final String f_10640 = "Energy Client | %s | @pointdlc";
   @Inject(
      method = {"stop"},
      at = {@At("HEAD")}
   )
   private void onStop(CallbackInfo var1) {
      if (InitManager.f_2740 != null) {
         if (InitManager.f_2740.f_2743 != null) {
            InitManager.f_2740.f_2743.m_2691();
         }

         if (InitManager.f_2740.f_2753 != null) {
            InitManager.f_2740.f_2753.m_3716();
         }
      }
   }

   @Inject(
      method = {"hasOutline"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$onHasOutline(Entity var1, CallbackInfoReturnable<Boolean> var2) {
      if (ShaderEsp.f_5735 != null && ShaderEsp.f_5735.m_677() && ShaderEsp.f_5735.m_3636(var1)) {
         ShaderEsp.f_5736 = var1;
         ShaderEsp.f_5737 = ShaderEsp.f_5735.m_2057();
         var2.setReturnValue(true);
         var2.cancel();
      }
   }

   @Inject(
      method = {"onResolutionChanged"},
      at = {@At("HEAD")}
   )
   private void energy$onResolutionChanged(CallbackInfo var1) {
      int var2 = MinecraftClient.getInstance().getWindow().getFramebufferWidth();
      int var3 = MinecraftClient.getInstance().getWindow().getFramebufferHeight();
      if (ShaderEsp.f_5735 != null) {
         ShaderEsp.f_5735.m_2638().m_2553(var2, var3);
      }

      if (Shaderhands.f_8823 != null) {
         Shaderhands.f_8823.m_2530(var2, var3);
      }
   }

   @Inject(
      method = {"render"},
      at = {@At("HEAD")}
   )
   private void render(boolean var1, CallbackInfo var2) {
      long var3 = Util.getMeasuringTimeNano();
      long var5 = var3 - this.lastHookTime;
      this.accumulatedCalls = this.accumulatedCalls + (int)(var5 / f_10637);
      this.lastHookTime = this.lastHookTime + this.accumulatedCalls * f_10638;

      for (this.accumulatedCalls = Math.min(this.accumulatedCalls, 240); this.accumulatedCalls > 0; this.accumulatedCalls--) {
         EnergyClient.f_1622.f_1624.m_30(new Util164());
      }
   }

   @Inject(
      method = {"handleBlockBreaking"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/util/hit/BlockHitResult;getSide()Lnet/minecraft/util/math/Direction;",
         shift = Shift.AFTER
      )}
   )
   private void energy$handleBlockBreakingStart(boolean var1, CallbackInfo var2, @Local BlockPos var3) {
      EnergyClient.f_1622.f_1624.m_30(new Util92(this.world.getBlockState(var3), var3, Util92.eYP5T39eaGw7jwf1.START_DESTROY_BLOCK));
   }

   @Inject(
      method = {"handleBlockBreaking"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;swingHand(Lnet/minecraft/util/Hand;)V",
         shift = Shift.AFTER
      )}
   )
   private void energy$handleBlockBreakingStop(boolean var1, CallbackInfo var2, @Local BlockPos var3) {
      EnergyClient.f_1622.f_1624.m_30(new Util92(this.world.getBlockState(var3), var3, Util92.eYP5T39eaGw7jwf1.STOP_DESTROY_BLOCK));
   }

   @Inject(
      method = {"doItemUse"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerInteractionManager;interactItem(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;"
      )},
      cancellable = true
   )
   private void energy$onRightClickItemCheck(CallbackInfo var1, @Local(ordinal = 0) Hand var2, @Local(ordinal = 0) ItemStack var3) {
      EventRightClickItemCheck var4 = new EventRightClickItemCheck(var3, var2);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var1.cancel();
      }
   }

   @Inject(
      method = {"handleInputEvents"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/option/GameOptions;setPerspective(Lnet/minecraft/client/option/Perspective;)V",
         ordinal = 0
      )},
      cancellable = true
   )
   private void energy$onTogglePerspective(CallbackInfo var1) {
      Util19 var2 = new Util19();
      EnergyClient.f_1622.f_1624.m_30(var2);
      if (var2.m_2244()) {
         var1.cancel();
      }
   }

   @Inject(
      method = {"getWindowTitle"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void updateWindowTitle(CallbackInfoReturnable<String> var1) {
      var1.setReturnValue(PanicCommand.m_2020() ? f_10639 : f_10640.formatted(Util90.f_5919));
   }

   @Redirect(
      method = {"handleInputEvents"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/player/PlayerInventory;setSelectedSlot(I)V",
         ordinal = 0
      )
   )
   private void energy$redirectHotbarSlotChange(PlayerInventory var1, int var2) {
      Util16 var3 = EnergyClient.f_1622.f_1624.m_30(new Util16());
      if (!var3.m_2244()) {
         var1.setSelectedSlot(var2);
      }
   }

   @Inject(
      method = {"tick"},
      at = {@At("HEAD")}
   )
   private void preTick(CallbackInfo var1) {
      EnergyClient.f_1622.f_1624.m_30(new Util124());
   }

   static {
      VMBridge.identifyClass(MinecraftClientMixin.class, "AQC4R1zM");
   }
}
