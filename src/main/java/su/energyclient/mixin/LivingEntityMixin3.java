package su.energyclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventNoPush;
import su.energyclient.event.impl.EventSwingSpeed;
import su.energyclient.module.combat.Macetarget;
import su.energyclient.util.Util110;
import su.energyclient.util.Util111;
import su.energyclient.util.Util137;
import su.energyclient.util.Util37;
import su.energyclient.util.Util41;
import su.energyclient.util.Util46;
import su.energyclient.util.Util6;

@Mixin({LivingEntity.class})
public abstract class LivingEntityMixin3 implements Util41 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   public Hand preferredHand;
   @Shadow
   private BlockPos lastBlockPos;
   @Unique
   public double backUpX;
   @Unique
   public double backUpY;
   @Unique
   public double backUpZ;
   @Unique
   public double serverX;
   @Unique
   public double serverY;
   @Unique
   public double serverZ;
   @Unique
   public double prevServerX;
   @Unique
   public double prevServerY;
   @Unique
   public double prevServerZ;
   @Unique
   private boolean isInWeb = false;
   @Unique
   private float resolvedYaw = 0.0F;
   @Unique
   private float resolvedPitch = 0.0F;
   @Unique
   private long lastResolveTime = 0L;
   private static final double f_12407 = 0.0;
   private static final double f_12408 = 0.0;
   private static final double f_12409 = 0.0;
   private static final long f_12410 = 0L;
   @Override
   public void energy$setInWeb() {
      this.isInWeb = true;
   }

   @Override
   public boolean energy$getIsInWeb() {
      return this.isInWeb;
   }

   @Override
   public double getServerX() {
      return this.serverX;
   }

   @Override
   public double getServerY() {
      return this.serverY;
   }

   @Override
   public double getServerZ() {
      return this.serverZ;
   }

   @Override
   public double getPrevServerX() {
      return this.prevServerX;
   }

   @Override
   public double getPrevServerY() {
      return this.prevServerY;
   }

   @Override
   public double getPrevServerZ() {
      return this.prevServerZ;
   }

   @Override
   public void setServerPos(double var1, double var3, double var5) {
      this.prevServerX = this.serverX;
      this.prevServerY = this.serverY;
      this.prevServerZ = this.serverZ;
      this.serverX = var1;
      this.serverY = var3;
      this.serverZ = var5;
   }

   @Override
   public float getResolvedYaw() {
      return this.resolvedYaw;
   }

   @Override
   public float getResolvedPitch() {
      return this.resolvedPitch;
   }

   @Override
   public Vec3d getResolvedForward() {
      return Vec3d.fromPolar(this.resolvedPitch, this.resolvedYaw);
   }

   @Inject(
      method = {"isPushable"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onIsPushedByFluid(CallbackInfoReturnable<Boolean> var1) {
      EventNoPush var2 = new EventNoPush(EventNoPush.Inner_4C0TXA9Fous6eGMB.Player);
      EnergyClient.f_1622.f_1624.m_30(var2);
      if (var2.m_2244()) {
         var1.setReturnValue(false);
      }
   }

   @Inject(
      method = {"getHandSwingDuration"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void onHandSwingDuration(CallbackInfoReturnable<Integer> var1) {
      if ((Object)this instanceof ClientPlayerEntity) {
         byte var2 = 6;
         EventSwingSpeed var3 = new EventSwingSpeed(var2, this.preferredHand);
         EnergyClient.f_1622.f_1624.m_30(var3);
         if (var3.m_2244()) {
            var1.setReturnValue(var3.m_1627());
         }
      }
   }

   @Inject(
      method = {"travel"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onTravel(Vec3d var1, CallbackInfo var2) {
      LivingEntity var3 = (LivingEntity)(Object)this;
      Util37 var4 = new Util37(var3);
      EnergyClient.f_1622.f_1624.m_30(var4);
      if (var4.m_2244()) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"calcGlidingVelocity"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void onsetvelocity(Vec3d var1, CallbackInfoReturnable<Vec3d> var2) {
      if ((Object)this != MinecraftClient.getInstance().player || !Macetarget.m_329()) {
         Vec3d var3 = var1.multiply(f_12407, f_12408, f_12409);
         Util137 var4 = new Util137(var3);
         EnergyClient.f_1622.f_1624.m_30(var4);
         var2.setReturnValue(var4.m_3148());
      }
   }

   @Redirect(
      method = {"travelGliding"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/LivingEntity;setVelocity(Lnet/minecraft/util/math/Vec3d;)V"
      ),
      require = 0
   )
   private void onElytraSetVelocity(LivingEntity var1, Vec3d var2) {
      if (var1 != MinecraftClient.getInstance().player) {
         var1.setVelocity(var2);
      } else {
         Util110 var3 = new Util110(var1, var2);
         EnergyClient.f_1622.f_1624.m_30(var3);
         Vec3d var4 = var3.m_2458() == null ? var2 : var3.m_2458();
         var1.setVelocity(var4);
      }
   }

   @Inject(
      method = {"jump"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onJump(CallbackInfo var1) {
      LivingEntity var2 = (LivingEntity)(Object)this;
      if (var2 instanceof ClientPlayerEntity var3) {
         if (var3 == MinecraftClient.getInstance().player) {
            Util111 var4 = new Util111(var3, var3.getEntityPos());
            EnergyClient.f_1622.f_1624.m_30(var4);
            if (var4.m_2244()) {
               var1.cancel();
            }
         }
      }
   }

   @Inject(
      method = {"tick"},
      at = {@At("HEAD")}
   )
   private void onTick(CallbackInfo var1) {
      Entity var2 = (Entity)(Object)this;
      if (System.currentTimeMillis() - this.lastResolveTime > f_12410) {
         float var3 = var2.getYaw();
         float var4 = var2.getPitch();
         float var5 = var2.lastYaw;
         float var6 = var2.lastPitch;
         float var7 = var3 - var5;
         float var8 = var4 - var6;
         this.resolvedYaw = var3 + var7;
         this.resolvedPitch = var4 + var8;
         this.lastResolveTime = System.currentTimeMillis();
      }

      this.isInWeb = false;
   }

   @Inject(
      method = {"tickGliding"},
      at = {@At("HEAD")}
   )
   public void preTickGliding(CallbackInfo var1) {
      EnergyClient.f_1622.f_1624.m_30(new Util6());
   }

   @Inject(
      method = {"animateDamage"},
      at = {@At("HEAD")}
   )
   private void energy$onAnimateDamage(float var1, CallbackInfo var2) {
      EnergyClient.f_1622.f_1624.m_30(new Util46((LivingEntity)(Object)this, var1));
   }

   static {
      VMBridge.identifyClass(LivingEntityMixin3.class, "SckThV7K");
   }
}
