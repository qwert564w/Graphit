package su.energyclient.mixin;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({PlayerMoveC2SPacket.class})
public interface PlayerMoveC2SPacketMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Accessor("x")
   double getX();

   @Mutable
   @Accessor("x")
   void setX(double var1);

   @Accessor("y")
   double getY();

   @Mutable
   @Accessor("y")
   void setY(double var1);

   @Accessor("z")
   double getZ();

   @Mutable
   @Accessor("z")
   void setZ(double var1);

   @Accessor("yaw")
   float getYaw();

   @Mutable
   @Accessor("yaw")
   void setYaw(float var1);

   @Accessor("pitch")
   float getPitch();

   @Mutable
   @Accessor("pitch")
   void setPitch(float var1);

   @Accessor("onGround")
   boolean isOnGround();

   @Mutable
   @Accessor("onGround")
   void setOnGround(boolean var1);

   @Accessor("changePosition")
   boolean isChangingPosition();

   @Accessor("changeLook")
   boolean isChangingLook();
}
