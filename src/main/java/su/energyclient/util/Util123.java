package su.energyclient.util;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import su.energyclient.QuickImports;
import su.energyclient.event.EventHandler;
import su.energyclient.mixin.ClientPlayerEntityMixin2;

public class Util123 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final Util123 f_10760 = new Util123();
   public final Util125 f_10761 = new Util125();
   public int f_10762 = 0;
   public boolean f_10763 = false;

   public float m_3186() {
      return f_5909.player == null ? 0.0F : ((ClientPlayerEntityMixin2)f_5909.player).getLastPitch();
   }

   public static void m_1885(Packet<?> var0) {
      m_3191(var0, 0, false);
   }

   public static void m_3191(Packet<?> var0, int var1, boolean var2) {
      f_10760.f_10762 = var1;
      f_10760.f_10763 = var2;
      if (var2) {
         Util162.m_1605(var0);
      } else {
         Util162.m_526(var0);
      }

      f_10760.f_10762 = 0;
      f_10760.f_10763 = false;
   }

   public static void m_2706(Packet<?> var0, int var1) {
      m_3191(var0, var1, false);
   }

   private Util123() {
   }

   @EventHandler
   public void m_3258(Util66 var1) {
      if (var1.m_2068()) {
         if (var1.m_3295() instanceof PlayerPositionLookS2CPacket) {
            this.f_10761.m_3493();
         }
      }
   }

   public float m_627() {
      return f_5909.player == null ? 0.0F : ((ClientPlayerEntityMixin2)f_5909.player).getLastYaw();
   }
}
