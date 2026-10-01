package su.energyclient.mixin;

import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventEntityRayTrace;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.InvisibleOpacity;
import su.energyclient.util.Util163;
import su.energyclient.util.Util18;
import su.energyclient.util.Util32;
import su.energyclient.util.Util56;
import su.energyclient.util.Util83;
import su.energyclient.util.Util86;

@Mixin({Entity.class})
public abstract class EntityMixin implements Util86 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   private boolean onGround;
   private static final double f_4173 = 4.0;
   private static final double f_4174 = 2.0;
   private static final double f_4175 = 4.0;
   private static final double f_4176 = 16.0;
   private static final double f_4177 = 4.0;
   @Shadow
   protected abstract void updateSupportingBlockPos(boolean var1, @Nullable Vec3d var2);

   @Inject(
      method = {"isInvisibleTo"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isInvisibleTo(PlayerEntity var1, CallbackInfoReturnable<Boolean> var2) {
      InvisibleOpacity var3 = InitManager.f_2740.f_2741.invisibleOpacity;
      if (var3.m_677()) {
         var2.setReturnValue(false);
      }
   }

   @Override
   public boolean canBeRaytracing() {
      EventEntityRayTrace var1 = new EventEntityRayTrace((Entity)(Object)this);
      EnergyClient.f_1622.f_1624.m_30(var1);
      return !var1.m_2244();
   }

   @Redirect(
      method = {"updateVelocity"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/Entity;getYaw()F"
      )
   )
   public float updateVelocity(Entity var1) {
      if (var1 == MinecraftClient.getInstance().player) {
         Util18 var2 = new Util18(var1.getYaw(), var1.getPitch());
         EnergyClient.f_1622.f_1624.m_30(var2);
         return var2.m_404();
      } else {
         return var1.getYaw();
      }
   }

   @Inject(
      method = {"updateVelocity"},
      at = {@At("TAIL")}
   )
   private void inject2(float var1, Vec3d var2, CallbackInfo var3) {
      if (MinecraftClient.getInstance().player != null && ((Entity)(Object)this).getId() == MinecraftClient.getInstance().player.getId()) {
         Util32 var4 = new Util32();
         EnergyClient.f_1622.f_1624.m_30(var4);
      }
   }

   @Inject(
      method = {"move"},
      at = {@At("TAIL")}
   )
   private void hookPlayerUtil(MovementType var1, Vec3d var2, CallbackInfo var3) {
      if ((Object)this instanceof ClientPlayerEntity var4) {
         boolean var5 = var4.isOnGround();
         if (!var5 && !(var2.y >= 0.0)) {
            Util83.f_5246 = Util83.f_5246 - (float)var2.y;
         } else {
            Util83.f_5246 = 0.0F;
         }

         if (var5) {
            Util83.f_5245 = 0.0F;
         } else if (var2.y <= 0.0) {
            Util83.f_5245 = Util83.f_5245 - (float)var2.y;
         }

         if (var4.isGliding()) {
            Util83.m_2664();
         }
      }
   }

   @Inject(
      method = {"setOnGround"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void setOnGround(boolean var1, CallbackInfo var2) {
      var2.cancel();
      Util56 var3 = EnergyClient.f_1622.f_1624.m_30(new Util56(var1));
      this.onGround = var3.m_3318();
      this.updateSupportingBlockPos(var1, (Vec3d)null);
   }

   @Inject(
      method = {"isGlowing"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isGlowing(CallbackInfoReturnable<Boolean> var1) {
      EventNoRender var2 = new EventNoRender(EventNoRender.fRxH5AVi9McS5OZn.glowing);
      EnergyClient.f_1622.f_1624.m_30(var2);
      if (var2.m_2244()) {
         var1.setReturnValue(false);
      }
   }

   @Inject(
      method = {"onRemoved"},
      at = {@At("TAIL")}
   )
   private void onRemovedClient(CallbackInfo var1) {
      if (MinecraftClient.getInstance().isRunning()) {
         if ((Object)this instanceof PotionEntity var2) {
            World var3 = var2.getEntityWorld();
            if (var3 != null && var3.isClient()) {
               ItemStack var4 = var2.getStack();
               PotionContentsComponent var5 = (PotionContentsComponent)var4.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
               if (var5.hasEffects() && !var5.matches(Potions.WATER) && !var4.isOf(Items.LINGERING_POTION)) {
                  Box var6 = var2.getBoundingBox().expand(f_4173, f_4174, f_4175);
                  List<LivingEntity> var7 = var3.getNonSpectatingEntities(LivingEntity.class, var6);
                  if (!var7.isEmpty()) {
                     Iterable var8 = var5.getEffects();

                     for (LivingEntity var10 : var7) {
                        if (var10.isAffectedBySplashPotions()) {
                           double var11 = var2.squaredDistanceTo(var10);
                           if (!(var11 >= f_4176)) {
                              double var13 = 1.0 - Math.sqrt(var11) / f_4177;
                              Util163 var15 = new Util163(var10, var4, var13, var8);
                              EnergyClient.f_1622.f_1624.m_30(var15);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   static {
      VMBridge.identifyClass(EntityMixin.class, "E49ITq3O");
   }
}
