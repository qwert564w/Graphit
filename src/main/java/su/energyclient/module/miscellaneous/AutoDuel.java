package su.energyclient.module.miscellaneous;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Formatting;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util125;
import su.energyclient.util.Util170;
import su.energyclient.util.Util66;

public class AutoDuel extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Pattern f_5926 = Pattern.compile(AutoDuel.f_5955);
   private final ModeSetting f_5927;
   private final RenderUtil22 f_5928;
   private final List<String> f_5929;
   private final Util125 f_5930;
   private int f_5931;
   private static final String f_5932 = "Auto Duel";
   private static final String f_5933 = "Автоматически отправляет вызов на дуэль игрокам";
   private static final String f_5934 = "Режим";
   private static final String f_5935 = "Ball";
   private static final String f_5936 = "Ball";
   private static final String f_5937 = "Shield";
   private static final String f_5938 = "Spikes";
   private static final String f_5939 = "Netherite";
   private static final String f_5940 = "CheatParadise";
   private static final String f_5941 = "Bow";
   private static final String f_5942 = "Classic";
   private static final String f_5943 = "Totems";
   private static final String f_5944 = "NoDebuff";
   private static final String f_5945 = "Клавиша отключения";
   private static final long f_5946 = 800L;
   private static final long f_5947 = 1000L;
   private static final String f_5948 = "начало";
   private static final String f_5949 = "через";
   private static final String f_5950 = "секунд";
   private static final String f_5951 = "выбор набора (1/1)";
   private static final long f_5952 = 150L;
   private static final String f_5953 = "настройка поединка";
   private static final long f_5954 = 150L;
   private static final String f_5955 = "^\\w{3,16}$";

   private String m_3607(String var1) {
      if (var1 == null) {
         return "";
      } else {
         String var2 = Formatting.strip(var1);
         if (var2 == null) {
            var2 = var1;
         }

         return var2.toLowerCase();
      }
   }

   @EventHandler
   public void m_4146(Util66 var1) {
      if (var1.m_2068()) {
         if (var1.m_3295() instanceof GameMessageS2CPacket var2) {
            String var4 = this.m_3607(var2.content().getString());
            if (var4.contains(f_5948) && var4.contains(f_5949) && var4.contains(f_5950) || var4.isEmpty()) {
               this.m_680();
            }
         }
      }
   }

   public AutoDuel() {
      super(f_5932, f_5933, Category.MISCELLANEOUS);
      this.f_5927 = new ModeSetting(f_5934, f_5935, f_5936, f_5937, f_5938, f_5939, f_5940, f_5941, f_5942, f_5943, f_5944);
      this.f_5928 = new RenderUtil22(f_5945, -1);
      this.f_5929 = new ArrayList<>();
      this.f_5930 = new Util125();
      this.f_5931 = 0;
   }

   @EventHandler
   public void m_1080(CancellableEvent var1) {
      if (!var1.m_3546() && var1.m_1362()) {
         if (this.f_5928.m_1958() != -1 && var1.m_2169() == this.f_5928.m_1958()) {
            this.m_680();
         }
      }
   }

   private void m_2891(String var1, GenericContainerScreenHandler var2) {
      String var3 = this.m_3607(var1);
      if (var3.contains(f_5951)) {
         if (this.f_5930.m_2636(f_5952)) {
            int var4 = AutoDuel.MzaL6gSkhb4zZrdZ.valueOf(this.f_5927.m_3862()).ordinal();
            f_5909.interactionManager.clickSlot(var2.syncId, var4, 0, SlotActionType.QUICK_MOVE, f_5909.player);
            this.f_5930.m_3493();
         }
      } else {
         if (var3.contains(f_5953) && this.f_5930.m_2636(f_5954)) {
            f_5909.interactionManager.clickSlot(var2.syncId, 0, 0, SlotActionType.QUICK_MOVE, f_5909.player);
            this.f_5930.m_3493();
         }
      }
   }

   @EventHandler
   public void m_1033(Util170 var1) {
      if (f_5909.player != null && f_5909.getNetworkHandler() != null && f_5909.interactionManager != null) {
         List var2 = f_5909.getNetworkHandler()
            .getPlayerList()
            .stream()
            .<GameProfile>map(PlayerListEntry::getProfile)
            .map(var0 -> var0.name())
            .filter(var0 -> f_5926.matcher(var0).matches())
            .collect(Collectors.toList());
         if (this.f_5930.m_2636(f_5946 * Math.max(1, var2.size()))) {
            this.f_5929.clear();
            this.f_5931 = 0;
            this.f_5930.m_3493();
         }

         if (!var2.isEmpty() && this.f_5930.m_2636(f_5947)) {
            if (this.f_5931 >= var2.size()) {
               this.f_5931 = 0;
            }

            String var3 = (String)var2.get(this.f_5931);
            if (!this.f_5929.contains(var3) && !var3.equals(f_5909.player.getGameProfile().name())) {
               f_5909.player.networkHandler.sendChatCommand("duel " + var3);
               this.f_5929.add(var3);
            }

            this.f_5931++;
            this.f_5930.m_3493();
         }

         if (f_5909.currentScreen instanceof HandledScreen var6 && var6.getScreenHandler() instanceof GenericContainerScreenHandler var4) {
            this.m_2891(var6.getTitle().getString(), var4);
         }
      }
   }

   public static enum MzaL6gSkhb4zZrdZ {
      Shield,
      Spikes,
      Bow,
      Totems,
      NoDebuff,
      Ball,
      Classic,
      CheatParadise,
      Netherite;
   }
}
