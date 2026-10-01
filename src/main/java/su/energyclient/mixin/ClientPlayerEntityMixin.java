package su.energyclient.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.authlib.GameProfile;
import java.util.function.Predicate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventInventoryClose;
import su.energyclient.event.impl.EventMouseOver;
import su.energyclient.event.impl.EventNoPush;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.manager.InitManager;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.module.combat.Macetarget;
import su.energyclient.util.Util13;
import su.energyclient.util.Util145;
import su.energyclient.util.Util166;
import su.energyclient.util.Util170;
import su.energyclient.util.Util172;
import su.energyclient.util.Util49;
import su.energyclient.util.Util51;
import su.energyclient.util.Util68;
import su.energyclient.util.Util74;
import su.energyclient.util.Util81;
import su.energyclient.util.Util86;

@Mixin({ClientPlayerEntity.class})
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity implements Util74 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private int energy$airTicks;
   @Unique
   private Util166 eventMotion;
   @Unique
   private float energy$origYaw;
   @Unique
   private float energy$origPitch;
   @Unique
   private double energy$origX;
   @Unique
   private double energy$origY;
   @Unique
   private double energy$origZ;
   private static final float f_7970 = 0.0F;
   private static final float f_7971 = 0.0F;
   private static final float f_7972 = 0.0F;
   private static final float f_7973 = 0.0F;
   private static final float f_7974 = 0.0F;
   private static final float f_7975 = 0.0F;
   @Shadow
   protected abstract void autoJump(float var1, float var2);

   protected ClientPlayerEntityMixin(ClientWorld var1, GameProfile var2) {
      super(var1, var2);
   }

   @Inject(
      method = {"canStartSprinting"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$blockAuraSprintReset(CallbackInfoReturnable<Boolean> var1) {
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null && !Macetarget.m_329()) {
         AttackAura var2 = InitManager.f_2740.f_2741.attackAura;
         if (var2 != null && var2.m_677() && var2.m_550().m_2998()) {
            var1.setReturnValue(false);
         }
      }
   }

   @Inject(
      method = {"tick"},
      at = {@At("HEAD")}
   )
   private void renderPostHook(CallbackInfo var1) {
      EnergyClient.f_1622.f_1624.m_30(new Util170());
   }

   @Inject(
      method = {"tick"},
      at = {@At("TAIL")}
   )
   private void renderPreHook(CallbackInfo var1) {
      EnergyClient.f_1622.f_1624.m_30(new Util68());
   }

   @Inject(
      method = {"tick"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;tick()V",
         shift = Shift.AFTER
      )}
   )
   private void tickPost(CallbackInfo var1) {
      EnergyClient.f_1622.f_1624.m_30(new Util13());
   }

   @Inject(
      method = {"tick"},
      at = {@At("HEAD")}
   )
   public void tick(CallbackInfo var1) {
      Util172 var2 = new Util172();
      EnergyClient.f_1622.f_1624.m_30(var2);
   }

   @ModifyArg(
      method = {"getCrosshairTarget(Lnet/minecraft/entity/Entity;DDF)Lnet/minecraft/util/hit/HitResult;"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/projectile/ProjectileUtil;raycast(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Box;Ljava/util/function/Predicate;D)Lnet/minecraft/util/hit/EntityHitResult;"
      ),
      index = 4
   )
   private static Predicate<Entity> energy$modifyEntityPredicate(Predicate<Entity> var0) {
      return var1 -> var0.test(var1) && ((Util86)var1).canBeRaytracing();
   }

   @Inject(
      method = {"getCrosshairTarget(Lnet/minecraft/entity/Entity;DDF)Lnet/minecraft/util/hit/HitResult;"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void energy$onGetCrosshairTarget(Entity var0, double var1, double var3, float var5, CallbackInfoReturnable<HitResult> var6) {
      Vec3d var7 = var0.getCameraPosVec(var5);
      Vec2f var8 = new Vec2f(var0.getYaw(var5), var0.getPitch(var5));
      EventMouseOver var9 = new EventMouseOver(var7, var8);
      EnergyClient.f_1622.f_1624.m_30(var9);
      if (!var9.m_1884().equals(var7) || !var9.m_3518().equals(var8)) {
         MinecraftClient var10 = MinecraftClient.getInstance();
         if (var10.world != null) {
            Vec3d var11 = var9.m_1884();
            Vec3d var12 = energy$getRotationVector(var9.m_3518());
            double var13 = Math.max(var1, var3);
            double var15 = MathHelper.square(var13);
            BlockHitResult var17 = var10.world
               .raycast(new RaycastContext(var11, var11.add(var12.multiply(var13)), ShapeType.OUTLINE, FluidHandling.NONE, var0));
            double var18 = var17.getPos().squaredDistanceTo(var11);
            if (var17.getType() != Type.MISS) {
               var15 = var18;
               var13 = Math.sqrt(var18);
            }

            Vec3d var20 = var11.add(var12.multiply(var13));
            Box var21 = var0.getBoundingBox().stretch(var12.multiply(var13)).expand(1.0);
            EntityHitResult var22 = ProjectileUtil.raycast(
               var0, var11, var20, var21, var0x -> EntityPredicates.CAN_HIT.test(var0x) && ((Util86)var0x).canBeRaytracing(), var15
            );
            HitResult var23 = var22 != null && var22.getPos().squaredDistanceTo(var11) < var18
               ? energy$ensureTargetInRange(var22, var11, var3)
               : energy$ensureTargetInRange(var17, var11, var1);
            var6.setReturnValue(var23);
         }
      }
   }

   @Unique
   private static Vec3d energy$getRotationVector(Vec2f var0) {
      float var1 = var0.x;
      float var2 = var0.y;
      float var3 = MathHelper.cos(-var1 * f_7970 - f_7971);
      float var4 = MathHelper.sin(-var1 * f_7972 - f_7973);
      float var5 = -MathHelper.cos(-var2 * f_7974);
      float var6 = MathHelper.sin(-var2 * f_7975);
      return new Vec3d(var4 * var5, var6, var3 * var5);
   }

   @Unique
   private static HitResult energy$ensureTargetInRange(HitResult var0, Vec3d var1, double var2) {
      Vec3d var4 = var0.getPos();
      if (var4.isInRange(var1, var2)) {
         return var0;
      } else {
         Direction var5 = Direction.getFacing(var4.x - var1.x, var4.y - var1.y, var4.z - var1.z);
         return BlockHitResult.createMissed(var4, var5, BlockPos.ofFloored(var4));
      }
   }

   @Redirect(
      method = {"tickMovementInput"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;getPitch()F"
      )
   )
   private float pitchAi(ClientPlayerEntity var1) {
      return Util49.m_3811();
   }

   @Redirect(
      method = {"tickMovementInput"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;getYaw()F"
      )
   )
   private float yawAi(ClientPlayerEntity var1) {
      return Util49.m_883();
   }

   @Inject(
      method = {"closeHandledScreen"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onCloseScreen(CallbackInfo var1) {
      ClientPlayerEntity var2 = (ClientPlayerEntity)(Object)this;
      int var3 = var2.currentScreenHandler.syncId;
      EventInventoryClose var4 = new EventInventoryClose(var3);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var1.cancel();
      }
   }

   @Inject(
      method = {"wouldCollideAt"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void wouldCollideAt(BlockPos var1, CallbackInfoReturnable<Boolean> var2) {
      EventNoPush var3 = new EventNoPush(EventNoPush.Inner_4C0TXA9Fous6eGMB.Block);
      EnergyClient.f_1622.f_1624.m_30(var3);
      if (var3.m_2244()) {
         var2.setReturnValue(false);
      }
   }

   @ModifyConstant(
      method = {"tickNausea"},
      constant = {@Constant(
         floatValue = 0.0125F
      )}
   )
   private float modifyNauseaIntensity(float var1) {
      EventNoRender var2 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.bad_effects);
      EnergyClient.f_1622.f_1624.m_30(var2);
      return var2.m_2244() ? 0.0F : var1;
   }

   @Inject(
      method = {"sendMovementPackets"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onSendMovementPackets(CallbackInfo var1) {
      ClientPlayerEntity var2 = (ClientPlayerEntity)(Object)this;
      this.energy$origYaw = var2.getYaw();
      this.energy$origPitch = var2.getPitch();
      this.energy$origX = var2.getX();
      this.energy$origY = var2.getY();
      this.energy$origZ = var2.getZ();
      this.eventMotion = new Util166(
         var2.getX(), var2.getY(), var2.getZ(), var2.getYaw(), var2.getPitch(), var2.isOnGround(), var2.isSneaking(), var2.isSprinting()
      );
      EnergyClient.f_1622.f_1624.m_30(this.eventMotion);
      if (this.eventMotion.m_2244()) {
         var1.cancel();
      } else {
         var2.setYaw(this.eventMotion.m_1603());
         var2.setPitch(this.eventMotion.m_921());
         var2.setPosition(this.eventMotion.m_705(), this.eventMotion.m_971(), this.eventMotion.m_3049());
      }
   }

   @Inject(
      method = {"sendMovementPackets"},
      at = {@At("TAIL")}
   )
   public void onSendMovementPacketsTail(CallbackInfo var1) {
      ClientPlayerEntity var2 = (ClientPlayerEntity)(Object)this;
      var2.setYaw(this.energy$origYaw);
      var2.setPitch(this.energy$origPitch);
      var2.setPosition(this.energy$origX, this.energy$origY, this.energy$origZ);
      EnergyClient.f_1622.f_1624.m_30(new Util81());
   }

   @Inject(
      method = {"move"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;move(Lnet/minecraft/entity/MovementType;Lnet/minecraft/util/math/Vec3d;)V"
      )},
      cancellable = true
   )
   public void onMoveHook(MovementType var1, Vec3d var2, CallbackInfo var3) {
      Util145 var4 = EnergyClient.f_1622.f_1624.m_30(new Util145(var2));
      double var5 = this.getX();
      double var7 = this.getZ();
      super.move(var1, var4.m_3620());
      if (this.isOnGround()) {
         this.energy$airTicks = 0;
      } else {
         this.energy$airTicks++;
      }

      this.autoJump((float)(this.getX() - var5), (float)(this.getZ() - var7));
      var3.cancel();
   }

   @Override
   public int energy$getAirTicks() {
      return this.energy$airTicks;
   }

   @ModifyExpressionValue(
      method = {"applyMovementSpeedFactors"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;isUsingItem()Z"
      )}
   )
   private boolean onNoSlow(boolean var1) {
      ClientPlayerEntity var2 = (ClientPlayerEntity)(Object)this;
      if (var1 && !var2.hasVehicle()) {
         Util51 var3 = new Util51();
         EnergyClient.f_1622.f_1624.m_30(var3);
         if (var3.m_2244()) {
            return false;
         }
      }

      return var1;
   }

   @ModifyExpressionValue(
      method = {"canStartSprinting"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;isBlockedFromSprinting()Z"
      )}
   )
   private boolean redirectCanStartSprintIsUsingItem(boolean var1) {
      Util51 var2 = new Util51();
      EnergyClient.f_1622.f_1624.m_30(var2);
      return var2.m_2244() ? false : var1;
   }

   static {
      VMBridge.identifyClass(ClientPlayerEntityMixin.class, "LsMOw51g");
   }
}
