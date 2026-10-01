package su.energyclient.module.movement;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.gui.screen.ingame.ShulkerBoxScreen;
import net.minecraft.util.math.BlockPos;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util170;

public class ShulkerJump extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_3901 = "Shulker Jump";
   private static final String f_3902 = "description";
   private static final double f_3903 = 2.33F;

   public ShulkerJump() {
      super(f_3901, f_3902, Category.MOVEMENT);
   }

   @EventHandler
   public void m_272(Util170 var1) {
      BlockPos var2 = f_5909.player.getBlockPos();
      boolean var3 = false;

      for (int var4 = -1; var4 <= 1; var4++) {
         for (int var5 = -1; var5 <= 1; var5++) {
            for (int var6 = -1; var6 <= 1; var6++) {
               BlockPos var7 = var2.add(var4, var5, var6);
               BlockState var8 = f_5909.world.getBlockState(var7);
               if (var8.getBlock() instanceof ShulkerBoxBlock) {
                  var3 = true;
                  break;
               }
            }

            if (var3) {
               break;
            }
         }

         if (var3) {
            break;
         }
      }

      if (f_5909.currentScreen instanceof ShulkerBoxScreen && var3) {
         f_5909.player.setVelocity(f_5909.player.getVelocity().x, f_5909.player.getVelocity().y + f_3903, f_5909.player.getVelocity().z);
      }
   }
}
