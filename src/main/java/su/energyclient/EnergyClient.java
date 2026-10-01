package su.energyclient;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import net.fabricmc.api.ClientModInitializer;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventBus;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Module;
import su.energyclient.module.ToggleMode;
import su.energyclient.module.combat.ThemeEditor;
import su.energyclient.render.RenderUtil21;
import su.energyclient.render.RenderUtil22;
import su.energyclient.render.RenderUtil3;
import su.energyclient.render.RenderUtil5;
import su.energyclient.setting.Setting;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util112;
import su.energyclient.util.Util120;
import su.energyclient.util.Util123;
import su.energyclient.util.Util2;
import su.energyclient.util.Util60;
import su.energyclient.util.Util71;
import su.energyclient.util.Util90;
import su.energyclient.util.Util93;
import pulse.cosmetic.LocalCosmetics;

public class EnergyClient implements QuickImports, ClientModInitializer {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static EnergyClient f_1622;
   private static int f_1623 = EnergyClient.f_1628;
   public EventBus f_1624;
   public ThemeEditor f_1625;
   private static final String f_1626 = "su.energyclient";
   private static final String f_1627 = "sg.ec";
   private static final int f_1628 = 10857983;

   public void onInitializeClient() {
      f_1622 = this;
      RenderUtil21.m_3785();
      RenderUtil3.m_844();
      RenderUtil5.register();
      Util90.m_3966();
      this.f_1624 = new EventBus();
      this.f_1624.m_45(f_1626, (var0, var1) -> (Lookup)var0.invoke(null, var1, MethodHandles.lookup()));
      this.f_1624.m_45(f_1627, (var0, var1) -> (Lookup)var0.invoke(null, var1, MethodHandles.lookup()));
      this.f_1624.m_32(this);
      this.f_1624.m_32(Util123.f_10760);
      Util93.m_3239();
      new InitManager();
      this.f_1625 = new ThemeEditor();
      new Util2();
      new Util60();
      Util120.m_2406();
      try {
         LocalCosmetics.selectDefault();
      } catch (Throwable t) {
         // cosmetics optional
      }
   }

   public static int getThemeColor() {
      return Util71.m_3389(f_1623, 255);
   }

   public static Util112 createDrag(Module var0, String var1, float var2, float var3) {
      String var4 = var0.m_1199() + "_" + var1;
      Util112 var5 = InitManager.f_2740.f_2743.m_2418().stream().filter(var1x -> var1x.m_1651().equals(var4)).findFirst().orElse(null);
      if (var5 != null) {
         return var5;
      } else {
         Util112 var6 = new Util112(var0, var4, var2, var3);
         InitManager.f_2740.f_2743.m_2418().add(var6);
         InitManager.f_2740.f_2743.m_835().put(var4, var6);
         return var6;
      }
   }

   @EventHandler
   public void onEvent(CancellableEvent var1) {
      if (!var1.m_3546() && var1.m_2169() != -1) {
         ObjectListIterator var2 = InitManager.f_2740.f_2741.m_3515().iterator();

         while (var2.hasNext()) {
            Module var3 = (Module)var2.next();
            if (var3.m_689() == var1.m_2169()) {
               if (var3.m_696() == ToggleMode.TOGGLE) {
                  if (var1.m_1362()) {
                     var3.m_680();
                  }
               } else if (var3.m_696() == ToggleMode.HOLD) {
                  if (var1.m_1362()) {
                     if (!var3.m_677()) {
                        var3.m_1926(true);
                     }
                  } else if (var3.m_677()) {
                     var3.m_1926(false);
                  }
               }
            }

            ObjectListIterator var4 = var3.m_179().iterator();

            while (var4.hasNext()) {
               Setting var5 = (Setting)var4.next();
               if (var5 instanceof RenderUtil22 var6 && var6.m_1958() == var1.m_2169()) {
                  if (var6.m_766() == RenderUtil22.pqYfuJa0oJD2nAQv.TOGGLE) {
                     if (var1.m_1362() && var5 instanceof BooleanSetting var7) {
                        var7.m_1848(!var7.m_1163());
                     }
                  } else if (var6.m_766() == RenderUtil22.pqYfuJa0oJD2nAQv.HOLD && var5 instanceof BooleanSetting var8) {
                     if (var1.m_1362()) {
                        if (!var8.m_1163()) {
                           var8.m_1848(true);
                        }
                     } else if (var8.m_1163()) {
                        var8.m_1848(false);
                     }
                  }
               }
            }
         }
      }
   }

   public static int getTheme(int var0) {
      return Util71.m_3389(f_1623, 255);
   }

   public static void setThemeColor(int var0) {
      f_1623 = Util71.m_3389(var0, 255);
   }
}
