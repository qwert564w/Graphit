package su.energyclient.command.impl;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.command.CommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.ClickEvent.Action;
import net.minecraft.text.HoverEvent.ShowText;
import net.minecraft.util.Formatting;
import su.energyclient.QuickImports;
import su.energyclient.command.Command;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.InventoryManager;
import su.energyclient.util.Util152;
import su.energyclient.util.Util157;

public class InventoryCommand extends Command implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_645 = "inventory";
   private static final String f_646 = "inv";
   private static final String f_647 = "save";
   private static final String f_648 = "name";
   private static final String f_649 = "load";
   private static final String f_650 = "name";
   private static final String f_651 = "delete";
   private static final String f_652 = "name";
   private static final String f_653 = "list";
   private static final String f_654 = "off";
   private static final String f_655 = "name";
   private static final String f_656 = "Инвентарь ";
   private static final String f_657 = " сохранён!";
   private static final String f_658 = "name";
   private static final String f_659 = "Инвентарь ";
   private static final String f_660 = " будет показан справа при открытом инвентаре!";
   private static final String f_661 = "name";
   private static final String f_662 = "Инвентарь ";
   private static final String f_663 = " удалён!";
   private static final String f_664 = "Показ сохранённого инвентаря выключен!";
   private static final String f_665 = "Сохранённых инвентарей нет!";
   private static final String f_666 = "--- Сохранённые инвентари ---";
   private static final String f_667 = " (активен)";
   private static final String f_668 = " [Показать]";
   private static final String f_669 = "Показывать этот инвентарь справа";
   private static final String f_670 = " [Удалить]";

   private int m_3554(CommandContext<CommandSource> var1) {
      String var2 = (String)var1.getArgument(f_661, String.class);
      InventoryManager var3 = this.m_1237();
      if (var3 != null && var3.m_1636(var2)) {
         MutableText var4 = Text.literal(f_662).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         MutableText var5 = Text.literal("\"" + var2 + "\"").setStyle(Style.EMPTY.withColor(Formatting.WHITE));
         MutableText var6 = Text.literal(f_663).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(Text.literal("").append(var4).append(var5).append(var6));
         return 1;
      } else {
         Util152.m_662(Text.literal("Инвентарь \"" + var2 + "\" не найден!").setStyle(Style.EMPTY.withColor(Formatting.RED)));
         return 1;
      }
   }

   private int m_3526(CommandContext<CommandSource> var1) {
      InventoryManager var2 = this.m_1237();
      List<String> var3 = var2 == null ? List.of() : var2.m_1873();
      String var4 = InitManager.f_2740.f_2742.m_1465() + this.m_3560();
      if (var3.isEmpty()) {
         Util152.m_662(Text.literal(f_665).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
         Util152.m_662(Text.literal("Сохранить текущий: " + var4 + " save <имя>").setStyle(Style.EMPTY.withColor(Formatting.DARK_GRAY)));
         return 1;
      } else {
         String var5 = var2.m_1593();
         Util152.m_662(Text.literal(f_666).setStyle(Style.EMPTY.withColor(Formatting.GOLD)));

         for (String var7 : var3) {
            boolean var8 = var7.equals(var5);
            MutableText var9 = Text.literal(var7).setStyle(Style.EMPTY.withColor(var8 ? Formatting.GREEN : Formatting.WHITE));
            MutableText var10 = Text.literal(var8 ? f_667 : "").setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            MutableText var11 = Text.literal(f_668)
               .setStyle(
                  Style.EMPTY
                     .withColor(Formatting.GREEN)
                     .withClickEvent(new Util157(Action.RUN_COMMAND, var4 + " load " + var7))
                     .withHoverEvent(new ShowText(Text.literal(f_669).setStyle(Style.EMPTY.withColor(Formatting.GREEN))))
               );
            MutableText var12 = Text.literal(f_670)
               .setStyle(
                  Style.EMPTY
                     .withColor(Formatting.RED)
                     .withClickEvent(new Util157(Action.RUN_COMMAND, var4 + " delete " + var7))
                     .withHoverEvent(new ShowText(Text.literal("Удалить набор " + var7).setStyle(Style.EMPTY.withColor(Formatting.RED))))
               );
            Util152.m_662(Text.literal("").append(var9).append(var10).append(var11).append(var12));
         }

         return 1;
      }
   }

   private int m_1866(CommandContext<CommandSource> var1) {
      String var2 = (String)var1.getArgument(f_658, String.class);
      InventoryManager var3 = this.m_1237();
      if (var3 != null && var3.m_3886(var2)) {
         MutableText var4 = Text.literal(f_659).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         MutableText var5 = Text.literal("\"" + var2 + "\"").setStyle(Style.EMPTY.withColor(Formatting.WHITE));
         MutableText var6 = Text.literal(f_660).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(Text.literal("").append(var4).append(var5).append(var6));
         return 1;
      } else {
         Util152.m_662(Text.literal("Инвентарь \"" + var2 + "\" не найден!").setStyle(Style.EMPTY.withColor(Formatting.RED)));
         return 1;
      }
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var1x -> this.m_2444(var1x));
      var1.then(m_1192(f_647).then(m_2219(f_648, StringArgumentType.word()).executes(this::m_87)));
      var1.then(m_1192(f_649).then(m_2219(f_650, StringArgumentType.word()).suggests(this::m_1749).executes(this::m_1866)));
      var1.then(m_1192(f_651).then(m_2219(f_652, StringArgumentType.word()).suggests(this::m_1749).executes(this::m_3554)));
      var1.then(m_1192(f_653).executes(this::m_3526));
      var1.then(m_1192(f_654).executes(this::m_1223));
   }

   private int m_87(CommandContext<CommandSource> var1) {
      String var2 = (String)var1.getArgument(f_655, String.class);
      InventoryManager var3 = this.m_1237();
      if (var3 != null && f_5909.player != null && var3.m_2567(var2)) {
         MutableText var4 = Text.literal(f_656).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         MutableText var5 = Text.literal("\"" + var2 + "\"").setStyle(Style.EMPTY.withColor(Formatting.WHITE));
         MutableText var6 = Text.literal(f_657).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(Text.literal("").append(var4).append(var5).append(var6));
         return 1;
      } else {
         return this.m_2444(var1);
      }
   }

   private int m_1223(CommandContext<CommandSource> var1) {
      InventoryManager var2 = this.m_1237();
      if (var2 != null) {
         var2.m_2091();
      }

      Util152.m_662(Text.literal(f_664).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
      return 1;
   }

   public InventoryCommand() {
      super(f_645, f_646);
   }

   private CompletableFuture<Suggestions> m_1749(CommandContext<CommandSource> var1, SuggestionsBuilder var2) {
      InventoryManager var3 = this.m_1237();
      return CommandSource.suggestMatching(var3 == null ? List.of() : var3.m_1873(), var2);
   }

   private InventoryManager m_1237() {
      return InitManager.f_2740.f_2745;
   }
}
