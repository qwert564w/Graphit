package su.energyclient.util;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.Event;

public class Util111 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private ClientPlayerEntity f_13190;
   private Vec3d f_13191;

   public void m_2153(Vec3d var1) {
      this.f_13191 = var1;
   }

   public ClientPlayerEntity m_3034() {
      return this.f_13190;
   }

   public Util111(ClientPlayerEntity var1, Vec3d var2) {
      this.f_13190 = var1;
      this.f_13191 = var2;
   }

   public Vec3d m_2376() {
      return this.f_13191;
   }

   public void m_3232(ClientPlayerEntity var1) {
      this.f_13190 = var1;
   }
}
