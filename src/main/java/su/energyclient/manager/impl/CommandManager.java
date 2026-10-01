package su.energyclient.manager.impl;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.command.permission.PermissionPredicate;
import su.energyclient.QuickImports;
import su.energyclient.command.Command;
import su.energyclient.command.impl.BaritoneCommand;
import su.energyclient.command.impl.BindCommand;
import su.energyclient.command.impl.CloudConfigCommand;
import su.energyclient.command.impl.ConfigCommand;
import su.energyclient.command.impl.FriendCommand;
import su.energyclient.command.impl.GpsCommand;
import su.energyclient.command.impl.InventoryCommand;
import su.energyclient.command.impl.JoinCommand;
import su.energyclient.command.impl.MacroCommand;
import su.energyclient.command.impl.PanicCommand;
import su.energyclient.command.impl.SelfCommand;
import su.energyclient.command.impl.TeleportCommand;
import su.energyclient.manager.Manager;

public class CommandManager extends Manager<Command> implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private String f_2387;
   private final CommandDispatcher<CommandSource> f_2388;
   private final CommandSource f_2389;
   private static final String f_2390 = ".";

   public void m_3586(String var1) {
      this.f_2387 = var1;
   }

   public String m_1465() {
      return this.f_2387;
   }

   public CommandManager() {
      this.f_2387 = f_2390;
      this.f_2388 = new CommandDispatcher();
      this.f_2389 = new ClientCommandSource(null, MinecraftClient.getInstance(), PermissionPredicate.ALL);
      this.O(new BindCommand());
      this.O(new ConfigCommand());
      this.O(new FriendCommand());
      this.O(new MacroCommand());
      this.O(new GpsCommand());
      this.O(new JoinCommand());
      this.O(new TeleportCommand());
      this.O(new CloudConfigCommand());
      this.O(new BaritoneCommand());
      this.O(new PanicCommand());
      this.O(new SelfCommand());
      this.O(new InventoryCommand());
   }

   public CommandDispatcher<CommandSource> m_4069() {
      return this.f_2388;
   }

   private void O(Command var1) {
      var1.m_1317(this.f_2388);
      this.m_3515().add(var1);
   }

   public CommandSource O() {
      return this.f_2389;
   }
}
