package su.energyclient.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventUseEnderPearl;

@Mixin({EnderPearlItem.class})
public class EnderPearlItemMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"use"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/Entity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V",
         shift = Shift.AFTER
      )}
   )
   private void energy$onUse(World var1, PlayerEntity var2, Hand var3, CallbackInfoReturnable<ActionResult> var4, @Local ItemStack var5) {
      EnergyClient.f_1622.f_1624.m_30(new EventUseEnderPearl(var5));
   }
}
