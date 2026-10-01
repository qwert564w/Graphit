package su.energyclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import su.energyclient.EnergyClient;
import su.energyclient.util.Util113;

@Mixin({PersistentProjectileEntity.class})
public abstract class PersistentProjectileEntityMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @ModifyArg(
      method = {"applyDamageModifier(F)V"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;setDamage(D)V"
      ),
      index = 0
   )
   private double energy$modifyProjectileDamage(double var1) {
      Util113 var3 = EnergyClient.f_1622.f_1624.m_30(new Util113(var1));
      return MinecraftClient.getInstance().player != null ? var3.m_1402() : var1;
   }
}
