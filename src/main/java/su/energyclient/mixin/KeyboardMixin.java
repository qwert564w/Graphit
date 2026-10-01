package su.energyclient.mixin;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Keyboard;
import net.minecraft.client.input.KeyInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.command.impl.PanicCommand;
import su.energyclient.event.CancellableEvent;
import su.energyclient.util.Util52;

@Mixin({Keyboard.class})
public class KeyboardMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Map<Integer, Boolean> keyScreenStates = new HashMap<>();

   @Inject(
      method = {"onKey"},
      at = {@At("HEAD")}
   )
   private void onKeyInject(long var1, int var3, KeyInput var4, CallbackInfo var5) {
      if (var1 == QuickImports.f_5909.getWindow().getHandle()) {
         int var6 = var4.key();
         if (var6 == -1) {
            return;
         }

         boolean var7 = QuickImports.f_5909.currentScreen != null;
         if (var3 == 1) {
            keyScreenStates.put(var6, var7);
            EnergyClient.f_1622.f_1624.m_30(new CancellableEvent(var6, true, var7));
            if (var6 == 344
               && !PanicCommand.m_2020()
               && QuickImports.f_5909.currentScreen == null
               && QuickImports.f_5909.player != null
               && QuickImports.f_5909.world != null) {
               QuickImports.f_5909.setScreen(EnergyClient.f_1622.f_1625);
            }
         } else if (var3 == 0) {
            Boolean var8 = keyScreenStates.remove(var6);
            boolean var9 = var8 != null ? var8 : false;
            EnergyClient.f_1622.f_1624.m_30(new CancellableEvent(var6, false, var9));
         }
      }
   }

   @Inject(
      method = {"processF3"},
      at = {@At("RETURN")}
   )
   private void processF3(KeyInput var1, CallbackInfoReturnable<Boolean> var2) {
      if (var1.key() == 65 && (Boolean)var2.getReturnValue()) {
         EnergyClient.f_1622.f_1624.m_30(new Util52());
      }
   }
}
