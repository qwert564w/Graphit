package su.energyclient.command.impl;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.command.CommandSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.command.Command;
import su.energyclient.event.EventHandler;
import su.energyclient.util.Util101;
import su.energyclient.util.Util125;
import su.energyclient.util.Util152;
import su.energyclient.util.Util170;
import su.energyclient.util.Util66;

public class JoinCommand extends Command implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Util125 f_783 = new Util125();
   private boolean f_784;
   private int f_785 = -1;
   private static final String f_786 = "join";
   private static final String f_787 = "joiner";
   private static final String f_788 = "grief";
   private static final String f_789 = "stop";
   private static final String f_790 = "Компас не найден в хотбаре.";
   private static final long f_791 = 100L;
   private static final String f_792 = "гриф #";
   private static final String f_793 = "гриферское выживание";
   private static final String f_794 = "ru";
   private static final String f_795 = "следующ";
   private static final String f_796 = "reallyworld";
   private static final String f_797 = "Joiner сейчас не запущен.";
   private static final String f_798 = "Joiner остановлен.";
   private static final String f_799 = "grief";

   private void m_1998() {
      this.f_784 = false;
      this.f_785 = -1;
      this.f_783.m_3493();
   }

   private String m_2045(String var1) {
      String var2 = Formatting.strip(var1);
      if (var2 == null) {
         var2 = var1;
      }

      return var2.toLowerCase();
   }

   private void O(ScreenHandler var1, int var2) {
      f_5909.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, f_5909.player);
      this.f_783.m_3493();
   }

   public JoinCommand() {
      super(f_786, f_787);
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   @EventHandler
   private void m_3129(Util170 var1) {
      if (this.f_784 && f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
         if (f_5909.currentScreen == null) {
            if (f_5909.player.age < 5) {
               this.m_2900();
            }
         } else if (f_5909.currentScreen instanceof HandledScreen var2) {
            if (f_5909.player.currentScreenHandler instanceof GenericContainerScreenHandler) {
               this.m_4011(var2.getScreenHandler());
            }
         }
      }
   }

   private void m_535(int var1) {
      this.f_785 = var1;
      this.f_784 = true;
      this.f_783.m_3493();
      Util152.m_662(Text.literal("Пробую зайти на гриф #" + var1 + ".").setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
      if (!this.m_2900()) {
         this.m_1998();
         Util152.m_662(Text.literal(f_790).setStyle(Style.EMPTY.withColor(Formatting.RED)));
      }
   }

   @EventHandler
   private void m_4114(Util66 var1) {
      if (this.f_784 && var1.m_2068()) {
         if (var1.m_3295() instanceof GameJoinS2CPacket) {
            this.m_1998();
         }
      }
   }

   private boolean m_2900() {
      if (f_5909.player != null && f_5909.interactionManager != null && f_5909.player.networkHandler != null) {
         int var1 = this.m_2485();
         if (var1 == -1) {
            return false;
         } else {
            f_5909.player.getInventory().setSelectedSlot(var1);
            f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var1));
            f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
            return true;
         }
      } else {
         return false;
      }
   }

   private boolean m_596(String var1) {
      String var2 = "гриф #" + this.f_785;
      return var1.contains(var2 + " ") || var1.endsWith(var2);
   }

   private int m_2485() {
      for (int var1 = 0; var1 < 9; var1++) {
         ItemStack var2 = f_5909.player.getInventory().getStack(var1);
         if (!var2.isEmpty() && var2.getItem() == Items.COMPASS) {
            return var1;
         }
      }

      return -1;
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var1x -> this.m_2444(var1x));
      var1.then(m_2219(f_788, IntegerArgumentType.integer(1)).executes(var1x -> {
         this.m_535((Integer)var1x.getArgument(f_799, Integer.class));
         return 1;
      }));
      var1.then(m_1192(f_789).executes(var1x -> {
         if (!this.f_784) {
            Util152.m_662(Text.literal(f_797).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
            return 1;
         } else {
            this.m_1998();
            Util152.m_662(Text.literal(f_798).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
            return 1;
         }
      }));
   }

   private void m_4011(ScreenHandler var1) {
      if (this.f_783.m_2636(f_791)) {
         int var2 = -1;
         int var3 = -1;
         int var4 = -1;
         boolean var5 = false;

         for (Slot var7 : var1.slots) {
            ItemStack var8 = var7.getStack();
            if (var8 != null && !var8.isEmpty()) {
               String var9 = this.m_2045(var8.getName().getString());
               if (this.m_596(var9)) {
                  var2 = var7.id;
               }

               if (var9.contains(f_792)) {
                  var5 = true;
               }

               if (var9.contains(f_793) && !var9.contains(f_794)) {
                  var3 = var7.id;
               }

               if (var9.contains(f_795)) {
                  var4 = var7.id;
               }
            }
         }

         if (var2 != -1) {
            this.O(var1, var2);
         } else if (var3 != -1 && !var5 && Util101.m_3117(f_796)) {
            this.O(var1, var3);
         }
      }
   }
}
