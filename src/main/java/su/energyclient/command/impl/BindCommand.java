package su.energyclient.command.impl;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
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
import su.energyclient.manager.impl.ModuleManager;
import su.energyclient.module.Module;
import su.energyclient.module.ToggleMode;
import su.energyclient.util.Util152;
import su.energyclient.util.Util157;
import su.energyclient.util.Util40;

public class BindCommand extends Command implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_63 = "bind";
   private static final String f_64 = "add";
   private static final String f_65 = "args";
   private static final String f_66 = "remove";
   private static final String f_67 = "module";
   private static final String f_68 = "list";
   private static final String f_69 = "clear";
   private static final String f_70 = "args";
   private static final String f_71 = "\\s+";
   private static final String f_72 = " ";
   private static final String f_73 = "hold";
   private static final String f_74 = "toggle";
   private static final String f_75 = "Установлен бинд ";
   private static final String f_76 = " на модуль '";
   private static final String f_77 = "'!";
   private static final String f_78 = "module";
   private static final String f_79 = "Модуль '";
   private static final String f_80 = "' теперь не имеет бинда!";
   private static final String f_81 = "Список биндoв пуст!";
   private static final String f_82 = " клавиша: ";
   private static final String f_83 = " [Удалить]";
   private static final String f_84 = "Клик для удаления бинда";
   private static final String f_85 = "Список биндoв пуст!";
   private static final String f_86 = "Список Биндов очищен!";
   private static final String f_87 = ".bind add ";
   private static final String f_88 = ".bind add ";
   private static final String f_89 = " ";
   private static final String f_90 = "\\s+";
   private static final String f_91 = "toggle";
   private static final String f_92 = "toggle";
   private static final String f_93 = "hold";
   private static final String f_94 = "hold";
   private static final String f_95 = "\\s+";

   private Module m_408(ModuleManager var1, String var2) {
      return var1.m_887(this.m_920(var2)).orElse(null);
   }

   private int m_2627(CommandContext<CommandSource> var1) {
      String var2 = ((String)var1.getArgument(f_70, String.class)).trim();
      if (var2.isEmpty()) {
         return this.m_2444(var1);
      } else {
         String[] var3 = var2.split(f_71);
         if (var3.length < 3) {
            return this.m_2444(var1);
         } else {
            String var4 = var3[var3.length - 1];
            String var5 = var3[var3.length - 2];
            String var6 = String.join(f_72, Arrays.asList(var3).subList(0, var3.length - 2));
            ToggleMode var7;
            if (var4.equalsIgnoreCase(f_73)) {
               var7 = ToggleMode.HOLD;
            } else {
               if (!var4.equalsIgnoreCase(f_74)) {
                  return this.m_2444(var1);
               }

               var7 = ToggleMode.TOGGLE;
            }

            Util40 var8 = Util40.m_1690(var5);
            if (var8 == null) {
               return this.m_2444(var1);
            } else {
               ModuleManager var9 = InitManager.f_2740.f_2741;
               Module var10 = this.m_408(var9, var6);
               if (var10 == null) {
                  return this.m_2444(var1);
               } else {
                  var10.m_1957(var8.m_3576());
                  var10.m_159(var7);
                  MutableText var11 = Text.literal(f_75).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                  MutableText var12 = Text.literal(Util40.m_2030(var10.m_689())).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
                  MutableText var13 = Text.literal(f_76).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                  MutableText var14 = Text.literal(var10.m_1199()).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
                  MutableText var15 = Text.literal(f_77).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
                  Util152.m_662(Text.literal("").append(var11).append(var12).append(var13).append(var14).append(var15));
                  return 1;
               }
            }
         }
      }
   }

   private int m_3919(CommandContext<CommandSource> var1) {
      List<Module> var2 = InitManager.f_2740.f_2741.m_3515().stream().filter(var0 -> var0.m_689() != -1).collect(Collectors.toList());
      if (var2.isEmpty()) {
         MutableText var11 = Text.literal(f_81).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(var11);
         return 1;
      } else {
         for (Module var4 : var2) {
            String var5 = Util40.m_2030(var4.m_689());
            MutableText var6 = Text.literal(var4.m_1199()).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
            MutableText var7 = Text.literal(f_82).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            MutableText var8 = Text.literal(var5).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
            String var9 = InitManager.f_2740.f_2742.m_1465() + this.m_3560() + " remove " + this.m_920(var4.m_1199());
            MutableText var10 = Text.literal(f_83)
               .setStyle(
                  Style.EMPTY
                     .withColor(Formatting.RED)
                     .withClickEvent(new Util157(Action.RUN_COMMAND, var9))
                     .withHoverEvent(new ShowText(Text.literal(f_84).setStyle(Style.EMPTY.withColor(Formatting.RED))))
               );
            Util152.m_662(Text.literal("").append(var6).append(var7).append(var8).append(var10));
         }

         return 1;
      }
   }

   private int m_1154(CommandContext<CommandSource> var1) {
      boolean var2 = InitManager.f_2740.f_2741.m_3515().stream().anyMatch(var0 -> var0.m_689() != -1);
      if (!var2) {
         MutableText var4 = Text.literal(f_85).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(var4);
         return 1;
      } else {
         InitManager.f_2740.f_2741.m_3515().forEach(var0 -> var0.m_1957(-1));
         MutableText var3 = Text.literal(f_86).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(var3);
         return 1;
      }
   }

   private CompletableFuture<Suggestions> m_3976(CommandContext<CommandSource> var1, SuggestionsBuilder var2) {
      List var3 = InitManager.f_2740.f_2741.m_3515().stream().map(Module::m_1199).map(this::m_920).collect(Collectors.toList());
      return CommandSource.suggestMatching(var3, var2);
   }

   public BindCommand() {
      super(f_63);
   }

   private String m_920(String var1) {
      return var1.replaceAll(f_95, "");
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var1x -> this.m_2444(var1x));
      var1.then(m_1192(f_64).then(m_2219(f_65, StringArgumentType.greedyString()).suggests(this::m_431).executes(this::m_2627)));
      var1.then(m_1192(f_66).then(m_2219(f_67, StringArgumentType.greedyString()).suggests(this::m_3976).executes(this::m_773)));
      var1.then(m_1192(f_68).executes(this::m_3919));
      var1.then(m_1192(f_69).executes(this::m_1154));
   }

   private CompletableFuture<Suggestions> m_431(CommandContext<CommandSource> var1, SuggestionsBuilder var2) {
      String var3 = var2.getInput();
      String var4 = var3.toLowerCase(Locale.ROOT);
      int var5 = var4.indexOf(f_87);
      String var6 = var5 == -1 ? "" : var3.substring(var5 + f_88.length());
      boolean var7 = var6.endsWith(f_89);
      String var8 = var6.trim();
      String[] var9 = var8.isEmpty() ? new String[0] : var8.split(f_90);
      int var10;
      if (var9.length == 0) {
         var10 = var3.length();
      } else if (var7) {
         var10 = var3.length();
      } else {
         var10 = var3.length() - var9[var9.length - 1].length();
      }

      SuggestionsBuilder var11 = new SuggestionsBuilder(var3, var10);
      if (var9.length == 0 || var9.length == 1 && !var7) {
         String var18 = var9.length == 0 ? "" : this.m_920(var9[0]);

         for (String var21 : InitManager.f_2740
            .f_2741
            .m_3515()
            .stream()
            .map(Module::m_1199)
            .map(this::m_920)
            .filter(var1x -> var1x.toLowerCase(Locale.ROOT).startsWith(var18.toLowerCase(Locale.ROOT)))
            .collect(Collectors.toList())) {
            var11.suggest(var21);
         }

         return var11.buildFuture();
      } else if (var9.length == 1 || var9.length == 2 && !var7) {
         String var17 = var9.length == 2 ? var9[1].toUpperCase(Locale.ROOT) : "";

         for (Util40 var16 : Util40.values()) {
            if (var16.name().startsWith(var17)) {
               var11.suggest(var16.name());
            }
         }

         return var11.buildFuture();
      } else if (var9.length != 2 && var7) {
         return var11.buildFuture();
      } else {
         String var12 = var9.length >= 3 ? var9[2].toLowerCase(Locale.ROOT) : "";
         if (f_91.startsWith(var12)) {
            var11.suggest(f_92);
         }

         if (f_93.startsWith(var12)) {
            var11.suggest(f_94);
         }

         return var11.buildFuture();
      }
   }

   private int m_773(CommandContext<CommandSource> var1) {
      String var2 = (String)var1.getArgument(f_78, String.class);
      ModuleManager var3 = InitManager.f_2740.f_2741;
      Module var4 = this.m_408(var3, var2);
      if (var4 == null) {
         return this.m_2444(var1);
      } else {
         var4.m_1957(-1);
         MutableText var5 = Text.literal(f_79).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         MutableText var6 = Text.literal(var4.m_1199()).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
         MutableText var7 = Text.literal(f_80).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
         Util152.m_662(Text.literal("").append(var5).append(var6).append(var7));
         return 1;
      }
   }
}
