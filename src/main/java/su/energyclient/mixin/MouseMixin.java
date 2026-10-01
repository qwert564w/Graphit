package su.energyclient.mixin;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Mouse;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.CancellableEvent;
import su.energyclient.util.Util100;
import su.energyclient.util.Util16;
import su.energyclient.util.Util40;

@Mixin({Mouse.class})
public class MouseMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Map<Integer, Boolean> mouseScreenStates = new HashMap<>();

   @Inject(
      method = {"onMouseButton"},
      at = {@At("HEAD")}
   )
   private void onMouseButtonInject(long var1, MouseInput var3, int var4, CallbackInfo var5) {
      if (var1 == QuickImports.f_5909.getWindow().getHandle()) {
         boolean var6 = QuickImports.f_5909.currentScreen != null;
         int var7 = var3.button();
         int var8 = Util40.m_3418(var7);
         if (var4 == 1) {
            mouseScreenStates.put(var7, var6);
            EnergyClient.f_1622.f_1624.m_30(new CancellableEvent(var8, true, var6));
         } else if (var4 == 0) {
            Boolean var9 = mouseScreenStates.remove(var7);
            boolean var10 = var9 != null ? var9 : false;
            EnergyClient.f_1622.f_1624.m_30(new CancellableEvent(var8, false, var10));
         }
      }
   }

   @Redirect(
      method = {"updateMouse"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;changeLookDirection(DD)V"
      )
   )
   private void redirectChangeLookDirection(ClientPlayerEntity var1, double var2, double var4) {
      Util100 var6 = new Util100((float)var2, (float)var4);
      EnergyClient.f_1622.f_1624.m_30(var6);
      if (!var6.m_2244()) {
         var1.changeLookDirection(var2, var4);
      }
   }

   @Inject(
      method = {"onMouseScroll"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/network/ClientPlayerEntity;getInventory()Lnet/minecraft/entity/player/PlayerInventory;"
      )},
      cancellable = true
   )
   private void MouseScroll(long var1, double var3, double var5, CallbackInfo var7) {
      Util16 var8 = EnergyClient.f_1622.f_1624.m_30(new Util16());
      if (var8.m_2244()) {
         var7.cancel();
      }
   }
}
