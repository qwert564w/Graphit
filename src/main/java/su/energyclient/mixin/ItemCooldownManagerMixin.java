package su.energyclient.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventCooldownTracker;

@Mixin({ItemCooldownManager.class})
public class ItemCooldownManagerMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @ModifyReturnValue(
      method = {"getCooldownProgress"},
      at = {@At("RETURN")}
   )
   private float energy$onGetCooldownProgress(float var1, ItemStack var2, float var3) {
      EventCooldownTracker var4 = new EventCooldownTracker(var2, var1);
      EnergyClient.f_1622.f_1624.m_30(var4);
      return var4.m_525();
   }
}
