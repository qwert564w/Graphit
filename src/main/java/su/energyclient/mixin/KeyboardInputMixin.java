package su.energyclient.mixin;

import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.util.PlayerInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.util.Util121;

@Mixin({KeyboardInput.class})
public class KeyboardInputMixin extends Input {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_3492 = 0.0F;
   private static float getMovementMultiplier(boolean var0, boolean var1) {
      if (var0 == var1) {
         return 0.0F;
      } else {
         return var0 ? 1.0F : f_3492;
      }
   }

   @Inject(
      method = {"tick"},
      at = {@At(
         value = "FIELD",
         target = "Lnet/minecraft/client/input/KeyboardInput;playerInput:Lnet/minecraft/util/PlayerInput;",
         opcode = 181,
         shift = Shift.AFTER
      )}
   )
   private void energy$onInput(CallbackInfo var1) {
      PlayerInput var2 = this.playerInput;
      float var3 = getMovementMultiplier(var2.forward(), var2.backward());
      float var4 = getMovementMultiplier(var2.left(), var2.right());
      Util121 var5 = new Util121(var3, var4, var2.jump(), var2.sneak());
      EnergyClient.f_1622.f_1624.m_30(var5);
      var3 = var5.m_2210();
      var4 = var5.m_2113();
      this.playerInput = new PlayerInput(var3 > 0.0F, var3 < 0.0F, var4 > 0.0F, var4 < 0.0F, var5.m_2407(), var5.m_1400(), var2.sprint());
   }

   static {
      VMBridge.identifyClass(KeyboardInputMixin.class, "jpzt917u");
   }
}
