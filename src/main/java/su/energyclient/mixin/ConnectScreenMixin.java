package su.energyclient.mixin;

import java.util.Locale;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.client.network.ServerAddress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import ru.dreamix.fabricloader.VMBridge;

@Mixin({ConnectScreen.class})
public abstract class ConnectScreenMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private static final String energy$redirectIP = "mc.bravohvh.fun";
   private static final String f_7038 = "";
   private static final String f_7039 = "";
   private static final String f_7040 = "";
   private static final String f_7041 = "";
   @ModifyVariable(
      method = {"connect(Lnet/minecraft/client/gui/screen/Screen;Lnet/minecraft/client/MinecraftClient;Lnet/minecraft/client/network/ServerAddress;Lnet/minecraft/client/network/ServerInfo;ZLnet/minecraft/client/network/CookieStorage;)V"},
      at = @At("HEAD"),
      argsOnly = true,
      index = 2
   )
   private static ServerAddress energy$redirectServer(ServerAddress var0) {
      String var1 = var0.getAddress().toLowerCase(Locale.ROOT);
      return !var1.contains(f_7038) && !var1.contains(f_7039) && !var1.contains(f_7040) ? var0 : ServerAddress.parse(f_7041);
   }

   static {
      VMBridge.identifyClass(ConnectScreenMixin.class, "1AapB4gp");
   }
}
