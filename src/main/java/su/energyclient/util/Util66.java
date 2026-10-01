package su.energyclient.util;

import net.minecraft.network.packet.Packet;
import su.energyclient.event.Event;

public class Util66 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Packet<?> f_10394;
   private final Util66.F3wLV3PCaxhjBqJ6 f_10395;

   public boolean m_2586() {
      return this.f_10395 == Util66.F3wLV3PCaxhjBqJ6.SEND;
   }

   public boolean m_2068() {
      return this.f_10395 == Util66.F3wLV3PCaxhjBqJ6.RECEIVE;
   }

   public Util66(Packet<?> var1, Util66.F3wLV3PCaxhjBqJ6 var2) {
      this.f_10394 = var1;
      this.f_10395 = var2;
   }

   public Util66.F3wLV3PCaxhjBqJ6 m_373() {
      return this.f_10395;
   }

   public Packet<?> m_3295() {
      return this.f_10394;
   }

   public static enum F3wLV3PCaxhjBqJ6 {
      RECEIVE,
      SEND;
   }
}
