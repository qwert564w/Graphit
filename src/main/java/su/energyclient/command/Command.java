package su.energyclient.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.Arrays;
import java.util.List;
import net.minecraft.command.CommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import su.energyclient.util.Util152;

public abstract class Command {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public List<String> f_3988;
   private static final String f_3989 = "Для помощи - .help";

   protected int m_2444(CommandContext<CommandSource> var1) {
      String var2 = var1.getInput();
      MutableText var3 = Text.literal("Неверно указаны аргументы - \"" + var2 + "\"").setStyle(Style.EMPTY.withColor(Formatting.RED));
      Util152.m_662(var3);
      MutableText var4 = Text.literal(f_3989).setStyle(Style.EMPTY.withColor(Formatting.RED));
      Util152.m_662(var4);
      return 1;
   }

   public void m_1317(CommandDispatcher<CommandSource> var1) {
      for (String var3 : this.f_3988) {
         LiteralArgumentBuilder var4 = LiteralArgumentBuilder.literal(var3);
         this.run(var4);
         var1.register(var4);
      }
   }

   public Command(String... var1) {
      this.f_3988 = Arrays.asList(var1);
   }

   public static LiteralArgumentBuilder<CommandSource> m_1192(String var0) {
      return LiteralArgumentBuilder.literal(var0);
   }

   public String m_3560() {
      return this.f_3988.get(0);
   }

   public abstract void run(LiteralArgumentBuilder<CommandSource> var1);

   public static <T> RequiredArgumentBuilder<CommandSource, T> m_2219(String var0, ArgumentType<T> var1) {
      return RequiredArgumentBuilder.argument(var0, var1);
   }
}
