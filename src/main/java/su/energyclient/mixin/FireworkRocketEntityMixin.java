package su.energyclient.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.manager.InitManager;
import su.energyclient.module.combat.Macetarget;
import su.energyclient.module.movement.ElytraBooster;
import su.energyclient.render.RenderUtil8;
import su.energyclient.util.Util18;
import su.energyclient.util.Util8;

@Mixin({FireworkRocketEntity.class})
public abstract class FireworkRocketEntityMixin extends ProjectileEntity {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private Vec3d rotation;
   @Shadow
   private LivingEntity shooter;
   private static final double f_7060 = 0.0;
   private static final double f_7061 = 0.0;
   private static final double f_7062 = 0.0;
   private static final String f_7063 = "";
   private static final String f_7064 = "";
   private static final String f_7065 = "";
   private static final String f_7066 = "";
   private static final String f_7067 = "";
   private static final String f_7068 = "";
   private static final double f_7069 = 0.0;
   private static final double f_7070 = 0.0;
   private static final double f_7071 = 0.0;
   private static final double f_7072 = 0.0;
   private static final double f_7073 = 0.0;
   private static final double f_7074 = 0.0;
   private static final double f_7075 = 0.0;
   private static final double f_7076 = 0.0;
   private static final double f_7077 = 0.0;
   public FireworkRocketEntityMixin(EntityType<? extends ProjectileEntity> var1, World var2) {
      super(var1, var2);
   }

   @ModifyExpressionValue(
      method = {"tick"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/LivingEntity;getRotationVector()Lnet/minecraft/util/math/Vec3d;"
      )}
   )
   public Vec3d captureRotation(Vec3d var1) {
      if (this.shooter == MinecraftClient.getInstance().player) {
         Util18 var2 = new Util18(this.shooter.getYaw(), this.shooter.getPitch());
         EnergyClient.f_1622.f_1624.m_30(var2);
         this.rotation = this.getRotationVector(var2.m_2469(), var2.m_404());
      } else {
         this.rotation = var1;
      }

      return this.rotation;
   }

   @Redirect(
      method = {"tick"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/util/math/Vec3d;add(DDD)Lnet/minecraft/util/math/Vec3d;",
         ordinal = 0
      )
   )
   public Vec3d redirectAdd(Vec3d var1, double var2, double var4, double var6) {
      if (this.shooter == MinecraftClient.getInstance().player && Macetarget.m_329()) {
         return var1.add(var2, var4, var6);
      } else if (this.rotation == null) {
         return var1.add(var2, var4, var6);
      } else {
         MinecraftClient var8 = MinecraftClient.getInstance();
         ElytraBooster var9 = InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null ? InitManager.f_2740.f_2741.elytraBooster : null;
         if (var9 != null
            && var9.m_677()
            && var8.player != null
            && var8.player.isGliding()
            && this.shooter instanceof ClientPlayerEntity
            && this.shooter == var8.player) {
            RenderUtil8 var10 = new RenderUtil8(this.rotation, var1, new Vec3d(f_7060, f_7061, f_7062));
            EnergyClient.f_1622.f_1624.m_30(var10);
            Vec3d var11 = var10.m_2657();
            if (var9.m_188()) {
               double var15 = var9.m_1704();
               return this.addBoost(var1, var15, var15, var15);
            }

            if (var9.f_279.m_2073(f_7063)) {
               double var14 = var9.f_280.m_4046();
               return this.addBoost(var1, var14, var14, var14);
            }

            if (var9.f_279.m_2073(f_7064)) {
               Vec3d var12 = Util8.m_2252(var8.player);
               return this.addBoost(var1, var12.x, var12.y, var12.z);
            }

            if (var9.f_279.m_2073(f_7065) || var9.f_279.m_2073(f_7066) || var9.f_279.m_2073(f_7067) || var9.f_279.m_2073(f_7068)) {
               return this.addBoost(var1, var11.x, var11.y, var11.z);
            }
         }

         return this.addBoost(var1, f_7069, f_7070, f_7071);
      }
   }

   @Unique
   private Vec3d addBoost(Vec3d var1, double var2, double var4, double var6) {
      return var1.add(
         this.rotation.x * f_7072 + (this.rotation.x * var2 - var1.x) * f_7073,
         this.rotation.y * f_7074 + (this.rotation.y * var4 - var1.y) * f_7075,
         this.rotation.z * f_7076 + (this.rotation.z * var6 - var1.z) * f_7077
      );
   }

   static {
      VMBridge.identifyClass(FireworkRocketEntityMixin.class, "hH38RASc");
   }
}
