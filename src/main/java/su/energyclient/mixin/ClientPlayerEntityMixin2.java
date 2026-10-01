package su.energyclient.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({ClientPlayerEntity.class})
public interface ClientPlayerEntityMixin2 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Accessor("lastYClient")
   double getLastYClient();

   @Accessor("lastOnGround")
   boolean lastOnGround();

   @Accessor("lastSprinting")
   void setLastSprinting(boolean var1);

   @Accessor("lastSprinting")
   boolean getLastSprinting();

   @Accessor("lastYawClient")
   float getLastYaw();

   @Accessor("lastPitchClient")
   float getLastPitch();

   @Invoker("canStartSprinting")
   boolean invokeCanStartSprinting();
}
