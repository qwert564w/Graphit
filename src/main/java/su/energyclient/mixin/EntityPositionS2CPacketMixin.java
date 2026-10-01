package su.energyclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.EntityPositionS2CPacket;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.util.Util161;
import su.energyclient.util.Util41;

@Mixin({EntityPositionS2CPacket.class})
public class EntityPositionS2CPacketMixin implements Util161 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Override
   public double getServerX(Entity var1) {
      return this.resolveAxis(var1, PositionFlag.X, ((EntityPositionS2CPacket)(Object)this).change().position().x);
   }

   @Override
   public double getServerY(Entity var1) {
      return this.resolveAxis(var1, PositionFlag.Y, ((EntityPositionS2CPacket)(Object)this).change().position().y);
   }

   @Override
   public double getServerZ(Entity var1) {
      return this.resolveAxis(var1, PositionFlag.Z, ((EntityPositionS2CPacket)(Object)this).change().position().z);
   }

   @Inject(
      method = {"apply(Lnet/minecraft/network/listener/ClientPlayPacketListener;)V"},
      at = {@At("HEAD")}
   )
   private void onApply(ClientPlayPacketListener var1, CallbackInfo var2) {
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var3.world != null) {
         EntityPositionS2CPacket var4 = (EntityPositionS2CPacket)(Object)this;
         Entity var5 = var3.world.getEntityById(var4.entityId());
         if (var5 instanceof LivingEntity && var5 instanceof Util41 var6) {
            var6.setServerPos(this.getServerX(var5), this.getServerY(var5), this.getServerZ(var5));
         }
      }
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Unique
   private double resolveAxis(Entity var1, PositionFlag var2, double var3) {
      EntityPositionS2CPacket var5 = (EntityPositionS2CPacket)(Object)this;

      double var6 = switch (var2) {
         case X -> var1.getX();
         case Y -> var1.getY();
         case Z -> var1.getZ();
         default -> 0.0;
      };
      if (!var5.relatives().contains(var2)) {
         var6 = 0.0;
      }

      return var6 + var3;
   }
}
