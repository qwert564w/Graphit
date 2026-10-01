package su.energyclient.util;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Locale;
import java.util.UUID;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.BossBar.Color;
import net.minecraft.entity.boss.BossBar.Style;
import net.minecraft.network.packet.s2c.play.BossBarS2CPacket;
import net.minecraft.network.packet.s2c.play.BossBarS2CPacket.Consumer;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.Text;
import su.energyclient.QuickImports;

public final class Util101 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static boolean f_14316 = false;
   private static UUID f_14317 = null;
   private static final String f_14318 = "funtime";
   private static final String f_14319 = "Здоровья";
   private static final String f_14320 = "❤️";
   private static final String f_14321 = "%.1f";
   private static final double f_14322 = 20.0;
   private static final String f_14323 = "This is a utility class and cannot be instantiated";

   public static int I(LivingEntity var0) {
      if (f_5909.getCurrentServerEntry() != null) {
         if (m_3117(f_14318)) {
            Object2IntMap var5 = f_5909.world.getScoreboard().getScoreHolderObjectives(var0);
            ObjectIterator var6 = var5.keySet().iterator();

            while (var6.hasNext()) {
               ScoreboardObjective var7 = (ScoreboardObjective)var6.next();
               String var4 = var7.getDisplayName().getString();
               if (var4.contains(f_14319) || var4.contains(f_14320)) {
                  return var5.getOrDefault(var7, 20);
               }
            }
         } else {
            Object2IntMap var1 = f_5909.world.getScoreboard().getScoreHolderObjectives(var0);
            ObjectIterator var2 = var1.keySet().iterator();
            if (var2.hasNext()) {
               ScoreboardObjective var3 = (ScoreboardObjective)var2.next();
               return var1.getOrDefault(var3, 20);
            }
         }
      }

      return (int)((int)var0.getHealth() + var0.getAbsorptionAmount());
   }

   public static boolean m_2329() {
      return f_14316;
   }

   public static void I(BossBarS2CPacket var0) {
      var0.accept(new Consumer() {
         private static final String f_2705 = "pvp";
         private static final String f_2706 = "у вас осталось";
         private static final String f_2707 = "режим боя";

         public void add(UUID var1, Text var2, float var3, Color var4, Style var5, boolean var6, boolean var7, boolean var8) {
            String var9 = var2.getString().toLowerCase();
            if (var9.contains(f_2705) || var9.contains(f_2706) || var9.contains(f_2707)) {
               Util101.f_14316 = true;
               Util101.f_14317 = var1;
            }
         }

         public void remove(UUID var1) {
            if (var1.equals(Util101.f_14317)) {
               Util101.f_14316 = false;
               Util101.f_14317 = null;
            }
         }
      });
   }

   private Util101() {
      throw new UnsupportedOperationException(f_14323);
   }

   public static String m_3762() {
      ClientPlayerEntity var0 = f_5909.player;
      double var1 = var0.getX() - var0.lastX;
      double var3 = var0.getZ() - var0.lastZ;
      double var5 = var0.getY() - var0.lastY;
      double var7 = Math.hypot(var1, var3);
      var7 = Math.hypot(var7, var5);
      return String.format(Locale.US, f_14321, var7 * f_14322);
   }

   public static boolean m_3117(String var0) {
      return f_5909.getCurrentServerEntry() != null && f_5909.getCurrentServerEntry().address != null && f_5909.getCurrentServerEntry().address.contains(var0);
   }
}
