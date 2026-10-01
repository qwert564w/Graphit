package su.energyclient.module.movement;

import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventInventoryClose;
import su.energyclient.event.impl.EventWindowClick;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util106;
import su.energyclient.util.Util121;
import su.energyclient.util.Util166;
import su.energyclient.util.Util168;
import su.energyclient.util.Util170;
import su.energyclient.util.Util66;

public class GuiMove extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_4993;
   private final Util168 f_4994;
   private final Util106 f_4995;
   private static final String f_4996 = "Gui Move";
   private static final String f_4997 = "Позволяет ходить при открытом контейнере";
   private static final String f_4998 = "Режим";
   private static final String f_4999 = "Vanilla";
   private static final String f_5000 = "Vanilla";
   private static final String f_5001 = "ReallyWorld";
   private static final String f_5002 = "FunTime";
   private static final String f_5003 = "HolyWorld";
   private static final String f_5004 = "FunTime";
   private static final String f_5005 = "HolyWorld";
   private static final String f_5006 = "ReallyWorld";
   private static final String f_5007 = "FunTime";
   private static final String f_5008 = "HolyWorld";
   private static final String f_5009 = "FunTime";
   private static final String f_5010 = "HolyWorld";
   private static final String f_5011 = "ReallyWorld";
   private static final String f_5012 = "Vanilla";
   private static final String f_5013 = "FunTime";
   private static final String f_5014 = "HolyWorld";
   private static final String f_5015 = "ReallyWorld";
   private static final String f_5016 = "FunTime";
   private static final String f_5017 = "HolyWorld";
   private static final String f_5018 = "ReallyWorld";
   private static final String f_5019 = "FunTime";
   private static final String f_5020 = "HolyWorld";
   private static final String f_5021 = "ReallyWorld";

   public GuiMove() {
      super(f_4996, f_4997, Category.MOVEMENT);
      this.f_4993 = new ModeSetting(f_4998, f_4999, f_5000, f_5001, f_5002, f_5003);
      this.f_4994 = new Util168(this.f_4993);
      this.f_4995 = new Util106(this.f_4993);
   }

   @Override
   public void m_1() {
      super.m_1();
      if (this.f_4993.m_2073(f_5004) || this.f_4993.m_2073(f_5005)) {
         this.f_4994.m_16();
      } else if (this.f_4993.m_2073(f_5006)) {
         this.f_4995.m_16();
      }
   }

   @EventHandler
   public void m_1473(EventInventoryClose var1) {
      if (this.f_4993.m_2073(f_5015)) {
         this.f_4995.l(var1);
      }
   }

   @EventHandler
   public void m_3810(Util170 var1) {
      if (this.f_4993.m_2073(f_5009) || this.f_4993.m_2073(f_5010)) {
         this.f_4994.m_15(var1);
      } else if (this.f_4993.m_2073(f_5011) || this.f_4993.m_2073(f_5012)) {
         this.f_4995.m_15(var1);
      }
   }

   public ModeSetting m_512() {
      return this.f_4993;
   }

   @EventHandler
   public void m_2920(Util166 var1) {
      if (this.f_4993.m_2073(f_5007) || this.f_4993.m_2073(f_5008)) {
         this.f_4994.m_44(var1);
      }
   }

   @EventHandler
   public void m_1771(EventWindowClick var1) {
      if (this.f_4993.m_2073(f_5019) || this.f_4993.m_2073(f_5020)) {
         this.f_4994.m_19(var1);
      } else if (this.f_4993.m_2073(f_5021)) {
         this.f_4995.m_19(var1);
      }
   }

   @EventHandler
   public void m_1333(Util121 var1) {
      if (this.f_4993.m_2073(f_5016) || this.f_4993.m_2073(f_5017)) {
         this.f_4994.m_17(var1);
      } else if (this.f_4993.m_2073(f_5018)) {
         this.f_4995.m_17(var1);
      }
   }

   @EventHandler
   public void m_1017(Util66 var1) {
      if (this.f_4993.m_2073(f_5013) || this.f_4993.m_2073(f_5014)) {
         this.f_4994.m_42(var1);
      }
   }
}
