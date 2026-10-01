package su.energyclient.command.impl;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import su.energyclient.QuickImports;
import su.energyclient.command.Command;
import su.energyclient.manager.InitManager;
import su.energyclient.util.Util152;

public class BaritoneCommand extends Command implements QuickImports {
   private static final String f_2383 = "baritone";
   private static final String f_2384 = "path";
   private static final String f_2385 = "args";
   private static final String f_2386 = "args";

   private void m_193(String var1) {
      Util152.m_662(Text.literal(var1).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
   }

   private int m_4043(CommandContext<CommandSource> var1) {
      String var2 = InitManager.f_2740.f_2742.m_1465() + this.m_3560();
      this.m_193("Baritone — отключен и удален из сборки.");
      return 1;
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(this::m_4043);
      var1.then(m_2219(f_2385, StringArgumentType.greedyString()).executes(var1x -> {
         this.m_3196("Baritone удален из клиента.");
         return 1;
      }));
   }

   private void m_3196(String var1) {
      Util152.m_662(Text.literal(var1).setStyle(Style.EMPTY.withColor(Formatting.RED)));
   }

   private void m_1028(String var1) {
      Util152.m_662(Text.literal(var1).setStyle(Style.EMPTY.withColor(Formatting.WHITE)));
   }

   public BaritoneCommand() {
      super(f_2383, f_2384);
   }
}
