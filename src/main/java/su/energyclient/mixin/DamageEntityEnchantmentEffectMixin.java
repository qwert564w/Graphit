package su.energyclient.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.entity.DamageEntityEnchantmentEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import su.energyclient.EnergyClient;
import su.energyclient.util.Util64;

@Mixin({DamageEntityEnchantmentEffect.class})
public abstract class DamageEntityEnchantmentEffectMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   @Final
   private RegistryEntry<DamageType> damageType;

   @WrapOperation(
      method = {"apply"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/damage/DamageSource;F)Z"
      )}
   )
   private boolean energy$onThornsDamage(
      Entity var1,
      ServerWorld var2,
      DamageSource var3,
      float var4,
      Operation<Boolean> var5,
      @Local(argsOnly = true) int var6,
      @Local(argsOnly = true) EnchantmentEffectContext var7
   ) {
      if (!this.damageType.matchesKey(DamageTypes.THORNS)) {
         return (Boolean)var5.call(new Object[]{var1, var2, var3, var4});
      } else {
         LivingEntity var8 = var7.owner();
         Util64 var9 = new Util64(var8, var1, var6, var4);
         EnergyClient.f_1622.f_1624.m_30(var9);
         return var9.m_2244() ? false : (Boolean)var5.call(new Object[]{var1, var2, var3, var9.l9()});
      }
   }
}
