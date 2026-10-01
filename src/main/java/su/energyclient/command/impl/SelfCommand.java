package su.energyclient.command.impl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import su.energyclient.command.Command;

public class SelfCommand extends Command {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_5107 = "self";

   public SelfCommand() {
      super(f_5107);
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var0 -> {
         PanicCommand.m_1527();
         return 1;
      });
   }
}
