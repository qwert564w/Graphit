package su.energyclient.command.impl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.command.CommandSource;
import org.lwjgl.glfw.GLFW;
import su.energyclient.QuickImports;
import su.energyclient.command.Command;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.Setting;

public class PanicCommand extends Command implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final List<Module> f_12230 = new ArrayList<>();
   private static final Map<Module, Integer> f_12231 = new IdentityHashMap<>();
   private static final Map<RenderUtil22, Integer> f_12232 = new IdentityHashMap<>();
   private static boolean f_12233;
   private static final String f_12234 = "p";
   private static final String f_12235 = "panic";
   private static final String f_12236 = "Minecraft 1.21.4";

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var1x -> {
         this.m_4094();
         return 1;
      });
   }

   public static void m_1527() {
      if (f_12233) {
         Module.m_2182(true);

         try {
            for (Module var1 : f_12230) {
               if (!var1.m_677()) {
                  try {
                     var1.m_1926(true);
                  } catch (RuntimeException var6) {
                  }
               }
            }
         } finally {
            Module.m_2182(false);
         }

         f_12231.forEach(Module::m_1957);
         f_12232.forEach((var0, var1x) -> {
            var0.m_466(var1x);
            var0.m_3523(false);
         });
         f_12230.clear();
         f_12231.clear();
         f_12232.clear();
         f_12233 = false;
         f_5909.updateWindowTitle();
      }
   }

   private void m_4094() {
      if (!f_12233) {
         f_12230.clear();
         f_12231.clear();
         f_12232.clear();
         ObjectListIterator var1 = InitManager.f_2740.f_2741.m_3515().iterator();

         while (var1.hasNext()) {
            Module var2 = (Module)var1.next();
            if (var2.m_677()) {
               f_12230.add(var2);
            }

            f_12231.put(var2, var2.m_689());
            ObjectListIterator var3 = var2.m_179().iterator();

            while (var3.hasNext()) {
               Setting var4 = (Setting)var3.next();
               if (var4 instanceof RenderUtil22 var5) {
                  f_12232.put(var5, var5.m_1958());
               }
            }
         }
      }

      ObjectListIterator var11 = InitManager.f_2740.f_2741.m_3515().iterator();

      while (var11.hasNext()) {
         Module var13 = (Module)var11.next();
         var13.m_1957(-1);
         ObjectListIterator var15 = var13.m_179().iterator();

         while (var15.hasNext()) {
            Setting var16 = (Setting)var15.next();
            if (var16 instanceof RenderUtil22 var17) {
               var17.m_466(-1);
               var17.m_3523(false);
            }
         }
      }

      Module.m_2182(true);

      try {
         var11 = InitManager.f_2740.f_2741.m_3515().iterator();

         while (var11.hasNext()) {
            Module var14 = (Module)var11.next();
            if (var14.m_677()) {
               try {
                  var14.m_1926(false);
               } catch (RuntimeException var9) {
               }
            }
         }
      } finally {
         Module.m_2182(false);
      }

      f_12233 = true;
      f_5909.inGameHud.getChatHud().clear(false);
      GLFW.glfwSetWindowTitle(f_5909.getWindow().getHandle(), f_12236);
   }

   public PanicCommand() {
      super(f_12234, f_12235);
   }

   public static boolean m_2020() {
      return f_12233;
   }
}
