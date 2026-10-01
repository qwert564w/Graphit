package su.energyclient.util;

import dev.firstdark.rpc.DiscordRpc;
import dev.firstdark.rpc.enums.ErrorCode;
import dev.firstdark.rpc.exceptions.UnsupportedOsType;
import dev.firstdark.rpc.handlers.RPCEventHandler;
import dev.firstdark.rpc.models.DiscordRichPresence;
import dev.firstdark.rpc.models.User;
import su.energyclient.QuickImports;

public class Util120 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_10790 = Util120.f_10805.trim();
   private static long f_10791;
   private static final DiscordRpc f_10792 = new DiscordRpc();
   private static final long f_10793 = 1000L;
   private static final String f_10794 = "Energy-DiscordRPC";
   private static final String f_10795 = "В меню";
   private static final String f_10796 = "Singleplayer";
   private static final String f_10797 = "хз";
   private static final String f_10798 = "play2go";
   private static final String f_10799 = "aurorix";
   private static final String f_10800 = "секретный";
   private static final String f_10801 = "Uid » %s";
   private static final String f_10802 = "https://imgbob.net/ib/dwrKAMdMJdmRRE4_1787504594.gif";
   private static final String f_10803 = "singleplayer";
   private static final long f_10804 = 2000L;
   private static final String f_10805 = "1544800904899723364";

   public static String m_2399() {
      return f_5909.getCurrentServerEntry() == null ? f_10803 : f_5909.getCurrentServerEntry().address;
   }

   public static void m_2406() {
      f_10791 = System.currentTimeMillis() / f_10793;
      RPCEventHandler var0 = new RPCEventHandler() {
         public void disconnected(ErrorCode var1, String var2) {
            System.out.println("[Energy] Discord RPC disconnected: " + var2);
         }

         public void errored(ErrorCode var1, String var2) {
            System.out.println("[Energy] Discord RPC error: " + var2);
         }

         public void ready(User var1) {
            System.out.println("[Energy] Discord RPC Ready: " + var1.getUsername());
            Util120.m_1703();
         }
      };

      try {
         f_10792.init(f_10790, var0, false);
      } catch (UnsupportedOsType var2) {
         f_10792.shutdown();
      }

      f_10792.setDebugMode(false);
      Thread var1 = new Thread(() -> {
         while (!Thread.currentThread().isInterrupted()) {
            try {
               m_1703();
               Thread.sleep(f_10804);
            } catch (InterruptedException var1x) {
               Thread.currentThread().interrupt();
            } catch (Throwable var2x) {
               System.out.println("[Energy] DiscordRPC callbacks error: " + var2x.getMessage());
            }
         }
      }, f_10794);
      var1.setDaemon(true);
      var1.start();
   }

   private static void m_1703() {
      try {
         if (f_5909 == null) {
            return;
         }

         String var0;
         if (f_5909.player == null || f_5909.world == null) {
            var0 = f_10795;
         } else if (f_5909.isInSingleplayer()) {
            var0 = f_10796;
         } else {
            String var1 = m_2399();
            var0 = "Сервер: " + (var1 == null ? f_10797 : (!var1.contains(f_10798) && !var1.contains(f_10799) ? var1 : f_10800));
         }

         DiscordRichPresence var3 = DiscordRichPresence.builder()
            .startTimestamp(f_10791)
            .details(f_10801.formatted(Util90.f_5920))
            .state(var0)
            .largeImageKey(f_10802)
            .largeImageText(Util90.f_5919)
            .build();
         f_10792.updatePresence(var3);
      } catch (Throwable var2) {
         System.out.println("[Energy] DiscordRPC update failed: " + var2.getMessage());
      }
   }
}
