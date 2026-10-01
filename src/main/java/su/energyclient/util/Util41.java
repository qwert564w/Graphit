package su.energyclient.util;

import net.minecraft.util.math.Vec3d;

public interface Util41 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   double getServerY();

   double getPrevServerY();

   float getResolvedYaw();

   double getPrevServerX();

   float getResolvedPitch();

   double getPrevServerZ();

   double getServerZ();

   Vec3d getResolvedForward();

   void setServerPos(double var1, double var3, double var5);

   boolean energy$getIsInWeb();

   void energy$setInWeb();

   double getServerX();
}
