package su.energyclient.mixin;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.network.SequencedPacketCreator;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({ClientPlayerInteractionManager.class})
public interface ClientPlayerInteractionManagerMixin2 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Invoker("syncSelectedSlot")
   void invokeSyncSelectedSlot();

   @Accessor("blockBreakingCooldown")
   void setblockBreakingCooldown(int var1);

   @Accessor("currentBreakingProgress")
   void setcurrentBreakingProgress(float var1);

   @Accessor("currentBreakingProgress")
   float getcurrentBreakingProgress();

   @Invoker("sendSequencedPacket")
   void invokeSendSequencedPacket(ClientWorld var1, SequencedPacketCreator var2);
}
