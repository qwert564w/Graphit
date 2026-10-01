package su.energyclient.command.impl;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.command.CommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.ClickEvent.Action;
import net.minecraft.text.HoverEvent.ShowText;
import net.minecraft.util.Formatting;
import su.energyclient.command.Command;
import su.energyclient.manager.InitManager;
import su.energyclient.util.Util152;
import su.energyclient.util.Util154;
import su.energyclient.util.Util157;
import su.energyclient.util.Util42;

public class ConfigCommand extends Command implements ArgumentType<String> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_4965 = "config";
   private static final String f_4966 = "cfg";
   private static final String f_4967 = "save";
   private static final String f_4968 = "name";
   private static final String f_4969 = "load";
   private static final String f_4970 = "name";
   private static final String f_4971 = "remove";
   private static final String f_4972 = "name";
   private static final String f_4973 = "list";
   private static final String f_4974 = "dir";
   private static final String f_4975 = "clear";
   private static final String f_4976 = "reset";
   private static final String f_4977 = "Конфиг сброшен!";
   private static final String f_4978 = "Список конфигов очищен!";
   private static final String f_4979 = "Список конфигураций пуст!";
   private static final String f_4980 = "Список конфигов:";
   private static final String f_4981 = " [Загрузить]";
   private static final String f_4982 = " [Удалить]";
   private static final String f_4983 = "name";
   private static final String f_4984 = "Конфиг с именем ";
   private static final String f_4985 = " удалён!";
   private static final String f_4986 = "name";
   private static final String f_4987 = "Конфиг с именем ";
   private static final String f_4988 = " загружён!";
   private static final String f_4989 = "name";
   private static final String f_4990 = "Нельзя сохранить локально: загружен облачный конфиг. Сбрось его (.config reset) или загрузи локальный.";
   private static final String f_4991 = "Конфиг с именем ";
   private static final String f_4992 = " сохранён!";

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      List<String> var3 = InitManager.f_2740.f_2751.m_1599();
      return CommandSource.suggestMatching(var3, var2);
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var1x -> this.m_2444(var1x));
      var1.then(m_1192(f_4967).then(m_2219(f_4968, StringArgumentType.word()).executes(var0 -> {
         String var1x = (String)var0.getArgument(f_4989, String.class);
         if (Util154.m_3642()) {
            Util152.m_662(Text.literal(f_4990).setStyle(Style.EMPTY.withColor(Formatting.RED)));
            return 1;
         } else {
            InitManager.f_2740.f_2751.m_1961(var1x);
            MutableText var2 = Text.literal(f_4991).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            MutableText var3 = Text.literal("\"" + var1x + "\"").setStyle(Style.EMPTY.withColor(Formatting.WHITE));
            MutableText var4 = Text.literal(f_4992).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            Util152.m_662(Text.literal("").append(var2).append(var3).append(var4));
            return 1;
         }
      })));
      var1.then(m_1192(f_4969).then(m_2219(f_4970, new ConfigCommand()).executes(var1x -> {
         String var2 = (String)var1x.getArgument(f_4986, String.class);
         if (!InitManager.f_2740.f_2751.m_1599().contains(var2)) {
            return this.m_2444(var1x);
         } else {
            InitManager.f_2740.f_2751.m_1074(var2);
            Util154.m_2213();
            MutableText var3 = Text.literal(f_4987).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            MutableText var4 = Text.literal("\"" + var2 + "\"").setStyle(Style.EMPTY.withColor(Formatting.WHITE));
            MutableText var5 = Text.literal(f_4988).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            Util152.m_662(Text.literal("").append(var3).append(var4).append(var5));
            return 1;
         }
      })));
      var1.then(m_1192(f_4971).then(m_2219(f_4972, new ConfigCommand()).executes(var1x -> {
         String var2 = (String)var1x.getArgument(f_4983, String.class);
         if (!InitManager.f_2740.f_2751.m_1599().contains(var2)) {
            return this.m_2444(var1x);
         } else {
            InitManager.f_2740.f_2751.m_1959(var2);
            MutableText var3 = Text.literal(f_4984).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            MutableText var4 = Text.literal("\"" + var2 + "\"").setStyle(Style.EMPTY.withColor(Formatting.WHITE));
            MutableText var5 = Text.literal(f_4985).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            Util152.m_662(Text.literal("").append(var3).append(var4).append(var5));
            return 1;
         }
      })));
      var1.then(
         m_1192(f_4973)
            .executes(
               var1x -> {
                  List<String> var2 = InitManager.f_2740.f_2751.m_1599();
                  if (var2 != null && !var2.isEmpty()) {
                     MutableText var9 = Text.literal(f_4980).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                     Util152.m_662(var9);

                     for (String var5 : var2) {
                        MutableText var6 = Text.literal(var5).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
                        MutableText var7 = Text.literal(f_4981)
                           .setStyle(
                              Style.EMPTY
                                 .withColor(Formatting.GREEN)
                                 .withClickEvent(new Util157(Action.RUN_COMMAND, InitManager.f_2740.f_2742.m_1465() + this.m_3560() + " load " + var5))
                                 .withHoverEvent(new ShowText(Text.literal("Загрузить конфиг " + var5)))
                           );
                        MutableText var8 = Text.literal(f_4982)
                           .setStyle(
                              Style.EMPTY
                                 .withColor(Formatting.RED)
                                 .withClickEvent(new Util157(Action.RUN_COMMAND, InitManager.f_2740.f_2742.m_1465() + this.m_3560() + " remove " + var5))
                                 .withHoverEvent(new ShowText(Text.literal("Удалить конфиг " + var5)))
                           );
                        Util152.m_662(Text.literal("").append(var6).append(var7).append(var8));
                     }

                     return 1;
                  } else {
                     MutableText var3 = Text.literal(f_4979).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                     Util152.m_662(var3);
                     return 1;
                  }
               }
            )
      );
      var1.then(m_1192(f_4974).executes(var0 -> {
         try {
            File var1x = new File(Util42.f_7521 + "data\\custom.sk3d");
            Runtime.getRuntime().exec("explorer " + var1x.getAbsolutePath());
         } catch (IOException var2) {
            var2.printStackTrace();
         }

         return 1;
      }));
      var1.then(m_1192(f_4975).executes(var0 -> {
         List<String> var1x = InitManager.f_2740.f_2751.m_1599();
         var1x.forEach(var0x -> InitManager.f_2740.f_2751.m_1959(var0x));
         MutableText var2 = Text.literal(f_4978).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(var2);
         return 1;
      }));
      var1.then(m_1192(f_4976).executes(var0 -> {
         InitManager.f_2740.f_2751.m_3733();
         Util154.m_763();
         MutableText var1x = Text.literal(f_4977).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(var1x);
         return 1;
      }));
   }

   @Override
   public String parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      boolean var3 = InitManager.f_2740.f_2751.m_1599().contains(var2);
      if (!var3) {
         throw new DynamicCommandExceptionType(var0 -> Text.literal("Конфиг с именем " + var0 + " не существует")).create(var2);
      } else {
         return var2;
      }
   }

   public ConfigCommand() {
      super(f_4965, f_4966);
   }
}
