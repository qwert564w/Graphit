package su.energyclient.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.network.packet.Packet;
import su.energyclient.QuickImports;

public final class Util162 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final ObjectArrayList<Packet<?>> f_8097 = new ObjectArrayList();
   private static final String f_8098 = "This is a utility class and cannot be instantiated";

   public static void m_1605(Packet<?> var0) {
      f_8097.add(var0);
      f_5909.player.networkHandler.sendPacket(var0);
   }

   private Util162() {
      throw new UnsupportedOperationException(f_8098);
   }

   public static void m_526(Packet<?> var0) {
      f_5909.player.networkHandler.sendPacket(var0);
   }

   public static ObjectArrayList<Packet<?>> m_531() {
      return f_8097;
   }
}
