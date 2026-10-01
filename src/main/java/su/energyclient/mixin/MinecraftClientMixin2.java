package su.energyclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Overlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({MinecraftClient.class})
public interface MinecraftClientMixin2 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Accessor("overlay")
   Overlay getOverlay();

   @Accessor("overlay")
   void setOverlay(Overlay var1);

   @Accessor("itemUseCooldown")
   void setItemUseCooldown(int var1);

   @Accessor("itemUseCooldown")
   int getItemUseCooldown();

   @Invoker("doItemUse")
   void invokeDoItemUse();
}
