package su.energyclient.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.InvisibleOpacity;
import su.energyclient.module.render.Shaderhands;
import su.energyclient.module.render.SwordAnimations;
import su.energyclient.render.RenderUtil13;
import su.energyclient.render.RenderUtil18;
import su.energyclient.util.Util116;
import su.energyclient.util.Util20;
import su.energyclient.util.Util49;

@Mixin({HeldItemRenderer.class})
public abstract class HeldItemRendererMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private static boolean energy$shaderHandsCapturing;
   @Unique
   private Hand currentHand;
   @Unique
   private Arm energy$equipArm;
   @Unique
   private float energy$equipProgress;
   @Shadow
   private ItemStack offHand;
   private static final float f_4753 = 0.0F;
   private static final float f_4754 = 0.0F;
   private static final float f_4755 = 0.0F;
   private static final float f_4756 = 0.0F;
   private static final float f_4757 = 0.0F;
   private static final float f_4758 = 0.0F;
   private static final float f_4759 = 0.0F;
   private static final float f_4760 = 0.0F;
   private static final float f_4761 = 0.0F;
   private static final float f_4762 = 0.0F;
   private static final float f_4763 = 0.0F;
   private static final float f_4764 = 0.0F;
   @Shadow
   private void renderArmHoldingItem(MatrixStack var1, OrderedRenderCommandQueue var2, int var3, float var4, float var5, Arm var6) {
   }

   @Shadow
   private void renderMapInBothHands(MatrixStack var1, OrderedRenderCommandQueue var2, int var3, float var4, float var5, float var6) {
   }

   @Shadow
   private void renderMapInOneHand(MatrixStack var1, OrderedRenderCommandQueue var2, int var3, float var4, Arm var5, float var6, ItemStack var7) {
   }

   @Inject(
      method = {"renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$wrapRenderItem(float var1, MatrixStack var2, OrderedRenderCommandQueue var3, ClientPlayerEntity var4, int var5, CallbackInfo var6) {
      Shaderhands var7 = InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null ? InitManager.f_2740.f_2741.shaderhands : null;
      if (!energy$shaderHandsCapturing && var7 != null && var7.m_677()) {
         if (var7.m_859()) {
            RenderUtil13.m_4021().m_364();
         } else {
            energy$shaderHandsCapturing = true;

            try {
               var7.I((HeldItemRenderer)(Object)this, var1, var2, var3, var4, var5);
            } finally {
               energy$shaderHandsCapturing = false;
            }

            var6.cancel();
         }
      }
   }

   @Inject(
      method = {"renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"},
      at = {@At("RETURN")}
   )
   private void energy$finishMincedHandsPass(float var1, MatrixStack var2, OrderedRenderCommandQueue var3, ClientPlayerEntity var4, int var5, CallbackInfo var6) {
      Shaderhands var7 = InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null ? InitManager.f_2740.f_2741.shaderhands : null;
      if (var7 != null && var7.m_677() && var7.m_859()) {
         RenderUtil13.m_4021().m_3253();
      }
   }

   @ModifyVariable(
      method = {"renderFirstPersonItem"},
      at = @At("HEAD"),
      argsOnly = true
   )
   private Hand captureHand(Hand var1) {
      this.currentHand = var1;
      return var1;
   }

   @Redirect(
      method = {"renderFirstPersonItem"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/render/item/HeldItemRenderer;swingArm(FLnet/minecraft/client/util/math/MatrixStack;ILnet/minecraft/util/Arm;)V",
         ordinal = 2
      )
   )
   private void redirectSwingArm(HeldItemRenderer var1, float var2, MatrixStack var3, int var4, Arm var5) {
      HeldItemRendererMixin2 var6 = (HeldItemRendererMixin2)var1;
      Util116 var7 = new Util116(var2, this.currentHand, var3);
      EnergyClient.f_1622.f_1624.m_30(var7);
      float var8 = f_4753 * MathHelper.sin(MathHelper.sqrt(var2) * f_4754);
      float var9 = f_4755 * MathHelper.sin(MathHelper.sqrt(var2) * f_4756);
      float var10 = f_4757 * MathHelper.sin(var2 * f_4758);
      if (!var7.m_2244()) {
         var3.translate(var4 * var8, var9, var10);
         var6.invokeApplySwingOffset(var3, var5, var2);
      }
   }

   @Inject(
      method = {"renderFirstPersonItem"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$renderHmiFirstPerson(
      AbstractClientPlayerEntity var1,
      float var2,
      float var3,
      Hand var4,
      float var5,
      ItemStack var6,
      float var7,
      MatrixStack var8,
      OrderedRenderCommandQueue var9,
      int var10,
      CallbackInfo var11
   ) {
      SwordAnimations var12 = this.energy$getHmiSwordAnimations();
      if (var12 != null && !var1.isUsingSpyglass()) {
         boolean var13 = var4 == Hand.MAIN_HAND;
         Arm var14 = var13 ? var1.getMainArm() : var1.getMainArm().getOpposite();
         boolean var15 = var14 == Arm.RIGHT;
         InvisibleOpacity var16 = InitManager.f_2740.f_2741.invisibleOpacity;
         boolean var17 = var1.isInvisible() && (var16 == null || !var16.m_677());
         var8.push();
         EnergyClient.f_1622.f_1624.m_30(new Util20(var8, var14));
         if (var6.isEmpty()) {
            if (var13 && !var17) {
               var12.m_772(var8, var1, var4, var6, var5, var2);
               var12.m_3750(var8, var14, var5);
               this.renderArmHoldingItem(var8, var9, var10, 0.0F, 0.0F, var14);
            }

            var8.pop();
            var11.cancel();
         } else {
            if (var12.m_2805(var1, var6, this.offHand.isEmpty())) {
               var8.push();
               var12.m_3617(var8, var14, var5);
               this.renderArmHoldingItem(var8, var9, var10, var7, 0.0F, var14.getOpposite());
               var8.pop();
            }

            var12.m_3155(var8, var6, var4, var14, var5);
            var12.m_772(var8, var1, var4, var6, var5, var2);
            if (!var6.contains(DataComponentTypes.MAP_ID)) {
               var12.m_2316(var8, var6, var14, var7, var5);
               if (!var17) {
                  this.renderArmHoldingItem(var8, var9, var10, 0.0F, 0.0F, var14);
               }

               var12.m_1545(var8, var6, var14);
               var12.m_1220(var8, var6, var5);
               var12.m_816(var8, var6, var14);
               ((HeldItemRenderer)(Object)this)
                  .renderItem(var1, var6, var15 ? ItemDisplayContext.FIRST_PERSON_RIGHT_HAND : ItemDisplayContext.FIRST_PERSON_LEFT_HAND, var8, var9, var10);
               var8.pop();
               var11.cancel();
            } else {
               if (var13 && this.offHand.isEmpty()) {
                  var8.translate(0.0F, f_4759, 0.0F);
                  this.renderMapInBothHands(var8, var9, var10, var3, var7, var5);
               } else {
                  var8.translate(var13 ? f_4760 : f_4761, f_4762, 0.0F);
                  this.renderMapInOneHand(var8, var9, var10, var7, var14, var5, var6);
               }

               var8.pop();
               var11.cancel();
            }
         }
      }
   }

   @Unique
   private SwordAnimations energy$getHmiSwordAnimations() {
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null) {
         SwordAnimations var1 = InitManager.f_2740.f_2741.swordAnimations;
         return var1 != null && var1.m_907() ? var1 : null;
      } else {
         return null;
      }
   }

   @Redirect(
      method = {"renderMapInOneHand"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;isInvisible()Z"
      )
   )
   private boolean redirectIsInvisibleInMapOneHand(ClientPlayerEntity var1) {
      InvisibleOpacity var2 = InitManager.f_2740.f_2741.invisibleOpacity;
      return var1.isInvisible() && (var2 == null || !var2.m_677());
   }

   @Redirect(
      method = {"renderMapInBothHands"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;isInvisible()Z"
      )
   )
   private boolean redirectIsInvisibleInMapBothHands(ClientPlayerEntity var1) {
      InvisibleOpacity var2 = InitManager.f_2740.f_2741.invisibleOpacity;
      return var1.isInvisible() && (var2 == null || !var2.m_677());
   }

   @Redirect(
      method = {"renderFirstPersonItem"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;isInvisible()Z"
      )
   )
   private boolean redirectIsInvisibleInFirstPerson(AbstractClientPlayerEntity var1) {
      InvisibleOpacity var2 = InitManager.f_2740.f_2741.invisibleOpacity;
      return var1.isInvisible() && (var2 == null || !var2.m_677());
   }

   @Redirect(
      method = {"renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;getPitch(F)F"
      )
   )
   private float pitch(ClientPlayerEntity var1, float var2) {
      return Util49.m_2701();
   }

   @Redirect(
      method = {"renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;getYaw(F)F"
      )
   )
   private float yaw(ClientPlayerEntity var1, float var2) {
      return Util49.m_3248();
   }

   @Inject(
      method = {"renderFirstPersonItem"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/util/math/MatrixStack;push()V",
         shift = Shift.AFTER
      )},
      locals = LocalCapture.CAPTURE_FAILHARD
   )
   private void render(
      AbstractClientPlayerEntity var1,
      float var2,
      float var3,
      Hand var4,
      float var5,
      ItemStack var6,
      float var7,
      MatrixStack var8,
      OrderedRenderCommandQueue var9,
      int var10,
      CallbackInfo var11,
      boolean var12,
      Arm var13
   ) {
      EnergyClient.f_1622.f_1624.m_30(new Util20(var8, var13));
   }

   @Inject(
      method = {"applyEquipOffset"},
      at = {@At("HEAD")}
   )
   private void energy$captureEquipArgs(MatrixStack var1, Arm var2, float var3, CallbackInfo var4) {
      this.energy$equipArm = var2;
      this.energy$equipProgress = var3;
   }

   @ModifyArg(
      method = {"applyEquipOffset"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
      ),
      index = 1
   )
   private float modifyEquipOffsetY(float var1) {
      RenderUtil18 var2 = new RenderUtil18(this.energy$equipArm, this.energy$equipProgress, f_4763);
      EnergyClient.f_1622.f_1624.m_30(var2);
      float var3 = var1 - this.energy$equipProgress * f_4764;
      return var3 + this.energy$equipProgress * var2.m_3200();
   }

   static {
      VMBridge.identifyClass(HeldItemRendererMixin.class, "coMm5OvQ");
   }
}
