package su.energyclient.command.impl;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;
import net.minecraft.command.CommandSource;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.command.Command;
import su.energyclient.event.EventHandler;
import su.energyclient.util.Util170;
import su.energyclient.util.Util72;

public class TeleportCommand extends Command implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_10465 = "teleport";
   private static final String f_10466 = "tp";
   private static final String f_10467 = "player";
   private static final String f_10468 = "x";
   private static final String f_10469 = "z";
   private static final String f_10470 = "x";
   private static final String f_10471 = "z";
   private static final String f_10472 = "player";

   @EventHandler
   private void m_590(Util170 var1) {
      Util72.m_3729();
   }

   private CompletableFuture<Suggestions> m_161(CommandContext<CommandSource> var1, SuggestionsBuilder var2) {
      return f_5909.world == null
         ? Suggestions.empty()
         : CommandSource.suggestMatching(f_5909.world.getPlayers().stream().map(var0 -> var0.getGameProfile().name()).toList(), var2);
   }

   public TeleportCommand() {
      super(f_10465, f_10466);
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var1x -> this.m_2444(var1x));
      var1.then(m_2219(f_10467, StringArgumentType.word()).suggests(this::m_161).executes(var0 -> {
         Util72.m_1742(StringArgumentType.getString(var0, f_10472));
         return 1;
      }));
      var1.then(m_2219(f_10468, IntegerArgumentType.integer()).then(m_2219(f_10469, IntegerArgumentType.integer()).executes(var0 -> {
         Util72.m_785(IntegerArgumentType.getInteger(var0, f_10470), IntegerArgumentType.getInteger(var0, f_10471));
         return 1;
      })));
   }
}
