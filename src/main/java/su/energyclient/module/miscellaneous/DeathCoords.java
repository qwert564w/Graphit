package su.energyclient.module.miscellaneous;

import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.util.Formatting;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util152;
import su.energyclient.util.Util170;

public class DeathCoords extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_2579 = "Death Coords";
   private static final String f_2580 = "description";

   @EventHandler
   public void m_1113(Util170 var1) {
      if (f_5909.player.getHealth() < 1.0F && f_5909.currentScreen instanceof DeathScreen) {
         int var2 = (int)f_5909.player.getX();
         int var3 = (int)f_5909.player.getY();
         int var4 = (int)f_5909.player.getZ();
         if (f_5909.player.deathTime < 1) {
            String var5 = "Координаты: " + Formatting.GRAY + "X: " + var2 + " Y: " + var3 + " Z: " + var4 + Formatting.RESET;
            Util152.m_662(var5);
         }
      }
   }

   public DeathCoords() {
      super(f_2579, f_2580, Category.MISCELLANEOUS);
   }
}
