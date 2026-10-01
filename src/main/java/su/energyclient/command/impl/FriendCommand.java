package su.energyclient.command.impl;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
import su.energyclient.manager.impl.FriendManager;
import su.energyclient.util.Util152;
import su.energyclient.util.Util157;

public class FriendCommand extends Command implements ArgumentType<String>, QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_2602 = "fr";
   private static final String f_2603 = "friend";
   private static final String f_2604 = "add";
   private static final String f_2605 = "player";
   private static final String f_2606 = "remove";
   private static final String f_2607 = "friend";
   private static final String f_2608 = "list";
   private static final String f_2609 = "clear";
   private static final String f_2610 = "remove";
   private static final String f_2611 = " ";
   private static final String f_2612 = " ";
   private static final String f_2613 = "remove";
   private static final String f_2614 = "Список друзей очищен!";
   private static final String f_2615 = "Список друзей пуст!";
   private static final String f_2616 = "Список друзей:";
   private static final String f_2617 = "dd.MM.yyyy HH:mm";
   private static final String f_2618 = " Добавлен: ";
   private static final String f_2619 = " [Удалить]";
   private static final String f_2620 = "friend";
   private static final String f_2621 = "Друг с именем ";
   private static final String f_2622 = " удалён!";
   private static final String f_2623 = "player";
   private static final String f_2624 = "Друг с именем ";
   private static final String f_2625 = " уже существует!";
   private static final String f_2626 = " добавлен!";

   public FriendCommand() {
      super(f_2602, f_2603);
   }

   public String parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      if (!f_2610.equals(var1.getString().split(f_2611)[1]) || InitManager.f_2740.f_2744 != null && InitManager.f_2740.f_2744.m_2704(var2)) {
         return var2;
      } else {
         throw new DynamicCommandExceptionType(var0 -> Text.literal("Друга с именем " + var0 + " не существует")).create(var2);
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String[] var4 = var1.getInput().split(f_2612);
      boolean var5 = var4.length > 1 && f_2613.equals(var4[1]);
      List var3;
      if (var5) {
         var3 = InitManager.f_2740.f_2744.m_3756().stream().map(FriendManager.Cfsq1JrSJubpZ92Z::m_173).collect(Collectors.toList());
      } else {
         var3 = f_5909.getNetworkHandler().getListedPlayerListEntries().stream().map(var0 -> var0.getProfile().name()).collect(Collectors.toList());
      }

      return CommandSource.suggestMatching(var3, var2);
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var1x -> this.m_2444(var1x));
      var1.then(m_1192(f_2604).then(m_2219(f_2605, new FriendCommand()).executes(var0 -> {
         String var1x = (String)var0.getArgument(f_2623, String.class);
         boolean var2 = InitManager.f_2740.f_2744.m_2704(var1x);
         MutableText var3 = Text.literal(f_2624).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         MutableText var4 = Text.literal("\"" + var1x + "\"").setStyle(Style.EMPTY.withColor(Formatting.WHITE));
         MutableText var5 = Text.literal(var2 ? f_2625 : f_2626).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         if (!var2) {
            InitManager.f_2740.f_2744.m_959(var1x);
         }

         Util152.m_662(Text.literal("").append(var3).append(var4).append(var5));
         return 1;
      })));
      var1.then(m_1192(f_2606).then(m_2219(f_2607, new FriendCommand()).executes(var1x -> {
         String var2 = (String)var1x.getArgument(f_2620, String.class);
         boolean var3 = InitManager.f_2740.f_2744.m_2704(var2);
         if (!var3) {
            return this.m_2444(var1x);
         } else {
            InitManager.f_2740.f_2744.m_3798(var2);
            MutableText var4 = Text.literal(f_2621).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            MutableText var5 = Text.literal("\"" + var2 + "\"").setStyle(Style.EMPTY.withColor(Formatting.WHITE));
            MutableText var6 = Text.literal(f_2622).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            Util152.m_662(Text.literal("").append(var4).append(var5).append(var6));
            return 1;
         }
      })));
      var1.then(
         m_1192(f_2608)
            .executes(
               var1x -> {
                  List<FriendManager.Cfsq1JrSJubpZ92Z> var2 = InitManager.f_2740.f_2744.m_3756();
                  if (var2 != null && !var2.isEmpty()) {
                     MutableText var12 = Text.literal(f_2616).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                     Util152.m_662(var12);
                     DateTimeFormatter var4 = DateTimeFormatter.ofPattern(f_2617);

                     for (FriendManager.Cfsq1JrSJubpZ92Z var6 : var2) {
                        String var7 = var6.m_173();
                        MutableText var8 = Text.literal(var7).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
                        MutableText var9 = Text.literal(f_2618).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                        MutableText var10 = Text.literal(var6.m_4092().format(var4)).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
                        MutableText var11 = Text.literal(f_2619)
                           .setStyle(
                              Style.EMPTY
                                 .withColor(Formatting.RED)
                                 .withClickEvent(new Util157(Action.RUN_COMMAND, InitManager.f_2740.f_2742.m_1465() + this.m_3560() + " remove " + var7))
                                 .withHoverEvent(new ShowText(Text.literal("Клик для удаления" + var7).setStyle(Style.EMPTY.withColor(Formatting.RED))))
                           );
                        Util152.m_662(Text.literal("").append(var8).append(var9).append(var10).append(var11));
                     }

                     MutableText var13 = Text.literal("Всего: " + var2.size()).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                     Util152.m_662(var13);
                     return 1;
                  } else {
                     MutableText var3 = Text.literal(f_2615).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                     Util152.m_662(var3);
                     return 1;
                  }
               }
            )
      );
      var1.then(m_1192(f_2609).executes(var0 -> {
         InitManager.f_2740.f_2744.m_1236();
         MutableText var1x = Text.literal(f_2614).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(var1x);
         return 1;
      }));
   }
}
