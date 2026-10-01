package su.energyclient.mixin;

import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.util.Util159;

@Mixin({KeyBinding.class})
public class KeyBindingMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"isPressed"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void sprintControlPatch(CallbackInfoReturnable<Boolean> var1) {
      if ((Object)this == QuickImports.f_5909.options.sprintKey && QuickImports.f_5909.player != null) {
         Util159 var2 = EnergyClient.f_1622.f_1624.m_30(new Util159());
         if ((Object)this == QuickImports.f_5909.options.sprintKey) {
            var1.setReturnValue(!QuickImports.f_5909.player.isUsingItem() && var2.m_2244());
         }
      }
   }
}
