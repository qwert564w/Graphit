package su.energyclient.command.impl;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
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
import su.energyclient.manager.impl.WaypointsManager;
import su.energyclient.util.Util152;
import su.energyclient.util.Util157;
import su.energyclient.util.Util40;

public class MacroCommand extends Command implements ArgumentType<String>, QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_10672 = "mac";
   private static final String f_10673 = "macros";
   private static final String f_10674 = "add";
   private static final String f_10675 = "args";
   private static final String f_10676 = "remove";
   private static final String f_10677 = "name";
   private static final String f_10678 = "list";
   private static final String f_10679 = "clear";
   private static final String f_10680 = "args";
   private static final String f_10681 = "\\s+";
   private static final String f_10682 = " ";
   private static final String f_10683 = "Макрос с именем '";
   private static final String f_10684 = "' и кнопкой активации: ";
   private static final String f_10685 = " добавлен!";
   private static final String f_10686 = " ";
   private static final String f_10687 = "\\s+";
   private static final String f_10688 = "Список макросов пуст!";
   private static final String f_10689 = "Список макросов очищен!";
   private static final String f_10690 = "Список макросов пуст!";
   private static final String f_10691 = "Список макросов:";
   private static final String f_10692 = "Имя: ";
   private static final String f_10693 = " Клавиша: ";
   private static final String f_10694 = " Текст: ";
   private static final String f_10695 = " [Удалить]";
   private static final String f_10696 = "Клик для удаления макроса";
   private static final String f_10697 = "name";
   private static final String f_10698 = "Макрос c именем '";
   private static final String f_10699 = "' удален!";

   public String parse(StringReader var1) throws CommandSyntaxException {
      return var1.readString();
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var1x -> this.m_2444(var1x));
      var1.then(m_1192(f_10674).then(m_2219(f_10675, StringArgumentType.greedyString()).suggests(this::suggestAdd).executes(this::executeAdd)));
      var1.then(
         m_1192(f_10676)
            .then(
               m_2219(f_10677, StringArgumentType.word())
                  .suggests(this::suggestMacroNames)
                  .executes(
                     var0 -> {
                        String var1x = (String)var0.getArgument(f_10697, String.class);
                        InitManager.f_2740.f_2752.m_606(var1x);
                        MutableText var2 = Text.literal(f_10698)
                           .setStyle(Style.EMPTY.withColor(Formatting.GRAY))
                           .append(Text.literal(var1x).setStyle(Style.EMPTY.withColor(Formatting.WHITE)))
                           .append(Text.literal(f_10699).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
                        Util152.m_662(var2);
                        return 1;
                     }
                  )
            )
      );
      var1.then(
         m_1192(f_10678)
            .executes(
               var1x -> {
                  List<WaypointsManager.Inner_9JcfksyJpnbcaVkW> var2 = InitManager.f_2740.f_2752.m_817();
                  if (var2.isEmpty()) {
                     Util152.m_662(Text.literal(f_10690).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
                     return 1;
                  } else {
                     Util152.m_662(Text.literal(f_10691).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));

                     for (WaypointsManager.Inner_9JcfksyJpnbcaVkW var4 : var2) {
                        String var5 = Util40.m_2030(var4.m_3326());
                        MutableText var6 = Text.literal(f_10692).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                        MutableText var7 = Text.literal(var4.m_3303()).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
                        MutableText var8 = Text.literal(f_10693).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                        MutableText var9 = Text.literal(var5).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
                        MutableText var10 = Text.literal(f_10694).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                        MutableText var11 = Text.literal(var4.m_1474()).setStyle(Style.EMPTY.withColor(Formatting.GREEN));
                        String var12 = InitManager.f_2740.f_2742.m_1465() + this.m_3560() + " remove " + var4.m_3303();
                        MutableText var13 = Text.literal(f_10695)
                           .setStyle(
                              Style.EMPTY
                                 .withColor(Formatting.RED)
                                 .withClickEvent(new Util157(Action.RUN_COMMAND, var12))
                                 .withHoverEvent(new ShowText(Text.literal(f_10696).setStyle(Style.EMPTY.withColor(Formatting.RED))))
                           );
                        Util152.m_662(Text.literal("").append(var6).append(var7).append(var8).append(var9).append(var10).append(var11).append(var13));
                     }

                     Util152.m_662(Text.literal("Всего: " + var2.size()).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
                     return 1;
                  }
               }
            )
      );
      var1.then(m_1192(f_10679).executes(var0 -> {
         List var1x = InitManager.f_2740.f_2752.m_817();
         if (var1x.isEmpty()) {
            Util152.m_662(Text.literal(f_10688).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
            return 1;
         } else {
            InitManager.f_2740.f_2752.m_1975();
            Util152.m_662(Text.literal(f_10689).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
            return 1;
         }
      }));
   }

   private CompletableFuture<Suggestions> suggestMacroNames(CommandContext<CommandSource> var1, SuggestionsBuilder var2) {
      List var3 = InitManager.f_2740.f_2752.m_817().stream().map(WaypointsManager.Inner_9JcfksyJpnbcaVkW::m_3303).collect(Collectors.toList());
      return CommandSource.suggestMatching(var3, var2);
   }

   private int executeAdd(CommandContext<CommandSource> var1) {
      String var2 = ((String)var1.getArgument(f_10680, String.class)).trim();
      if (var2.isEmpty()) {
         return this.m_2444(var1);
      } else {
         String[] var3 = var2.split(f_10681);
         if (var3.length < 3) {
            return this.m_2444(var1);
         } else {
            String var4 = var3[0];
            String var5 = var3[1];
            String var6 = String.join(f_10682, Arrays.asList(var3).subList(2, var3.length));
            Util40 var7 = Util40.m_1690(var5);
            if (var7 == null) {
               return this.m_2444(var1);
            } else {
               InitManager.f_2740.f_2752.m_456(var4, var7.m_3576(), var6);
               MutableText var8 = Text.literal(f_10683)
                  .setStyle(Style.EMPTY.withColor(Formatting.GRAY))
                  .append(Text.literal(var4).setStyle(Style.EMPTY.withColor(Formatting.WHITE)))
                  .append(Text.literal(f_10684).setStyle(Style.EMPTY.withColor(Formatting.GRAY)))
                  .append(Text.literal(Util40.m_2030(var7.m_3576())).setStyle(Style.EMPTY.withColor(Formatting.WHITE)))
                  .append(Text.literal(f_10685).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
               Util152.m_662(var8);
               return 1;
            }
         }
      }
   }

   private CompletableFuture<Suggestions> suggestAdd(CommandContext<CommandSource> var1, SuggestionsBuilder var2) {
      String var3 = var1.getInput();
      String var4 = var2.getRemaining();
      boolean var5 = var4.endsWith(f_10686);
      String var6 = var4.trim();
      String[] var7 = var6.isEmpty() ? new String[0] : var6.split(f_10687);
      int var8;
      if (var7.length == 0) {
         var8 = var3.length();
      } else if (var5) {
         var8 = var3.length();
      } else {
         var8 = var3.length() - var7[var7.length - 1].length();
      }

      SuggestionsBuilder var9 = new SuggestionsBuilder(var3, var8);
      if (var7.length != 0 && (var7.length != 1 || var5)) {
         if (var7.length == 1 || var7.length == 2 && !var5) {
            String var10 = var7.length == 2 ? var7[1].toUpperCase(Locale.ROOT) : "";

            for (Util40 var14 : Util40.values()) {
               if (var14.name().startsWith(var10)) {
                  var9.suggest(var14.name());
               }
            }

            return var9.buildFuture();
         } else {
            return var9.buildFuture();
         }
      } else {
         return var9.buildFuture();
      }
   }

   public MacroCommand() {
      super(f_10672, f_10673);
   }
}
