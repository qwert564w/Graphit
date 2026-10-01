package su.energyclient.manager;

import su.energyclient.EnergyClient;
import su.energyclient.manager.impl.AccountManager;
import su.energyclient.manager.impl.ArmorManager;
import su.energyclient.manager.impl.CommandManager;
import su.energyclient.manager.impl.ConfigManager;
import su.energyclient.manager.impl.DraggableManager;
import su.energyclient.manager.impl.FriendManager;
import su.energyclient.manager.impl.InventoryManager;
import su.energyclient.manager.impl.MacroManager;
import su.energyclient.manager.impl.ModuleManager;
import su.energyclient.manager.impl.NotificationManager;
import su.energyclient.manager.impl.RotationManager;
import su.energyclient.manager.impl.TargetManager;
import su.energyclient.manager.impl.WaypointsManager;

public class InitManager {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static InitManager f_2740;
   public ModuleManager f_2741;
   public CommandManager f_2742;
   public DraggableManager f_2743;
   public FriendManager f_2744;
   public InventoryManager f_2745;
   public ArmorManager f_2746;
   public MacroManager f_2747;
   public AccountManager f_2748;
   public NotificationManager f_2749;
   public RotationManager f_2750;
   public TargetManager f_2751;
   public WaypointsManager f_2752;
   public ConfigManager f_2753;

   public InitManager() {
      EnergyClient.f_1622.f_1624.m_32(this);
      this.m_3477();
   }

   private void m_1023() {
      this.f_2741 = new ModuleManager();
      this.f_2751 = new TargetManager();
      this.f_2751.m_40();
      this.f_2753 = new ConfigManager();
      this.f_2753.m_40();
      this.f_2743.m_40();
      this.f_2752 = new WaypointsManager();
      this.f_2752.m_40();
      this.f_2744 = new FriendManager();
      this.f_2744.m_40();
      this.f_2745 = new InventoryManager();
      this.f_2745.m_1265();
      this.f_2747 = new MacroManager();
      this.f_2747.m_3226();
   }

   public void m_3477() {
      f_2740 = this;
      this.f_2743 = new DraggableManager();
      this.m_1023();
      this.f_2742 = new CommandManager();
      this.f_2746 = new ArmorManager();
      this.f_2748 = new AccountManager();
      this.f_2749 = new NotificationManager();
      this.f_2750 = new RotationManager();
   }
}
