package su.energyclient.module.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util138;
import su.energyclient.util.Util170;
import su.energyclient.util.Util96;

public class WebTrap extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_6281 = 4.5;
   private static final int f_6282 = 0;
   private static final int f_6283 = 0;
   private final ModeSetting f_6284;
   private final BooleanSetting f_6285;
   private static final String f_6286 = "Web Trap";
   private static final String f_6287 = "Ставит паутину по предсказанной позиции цели";
   private static final String f_6288 = "Mode";
   private static final String f_6289 = "Solo";
   private static final String f_6290 = "Solo";
   private static final String f_6291 = "Multi";
   private static final String f_6292 = "RageMode";
   private static final double f_6293 = Double.MAX_VALUE;
   private static final double f_6294 = 4.5;
   private static final String f_6295 = "Multi";

   private BlockPos m_1081(PlayerEntity var1) {
      return BlockPos.ofFloored(Util96.m_2264(var1, 7).position());
   }

   private PlayerEntity m_1581() {
      PlayerEntity var1 = null;
      double var2 = f_6293;

      for (PlayerEntity var5 : f_5909.world.getPlayers()) {
         if (this.m_618(var5) && this.m_2607(var5)) {
            double var6 = var5.squaredDistanceTo(f_5909.player);
            if (var6 < var2) {
               var2 = var6;
               var1 = var5;
            }
         }
      }

      return var1;
   }

   private void m_3553(List<BlockPos> var1, BlockPos var2) {
      BlockPos var3 = f_5909.player.getBlockPos();
      if (!var2.equals(var3) && !var2.equals(var3.up()) && !f_5909.player.getBoundingBox().intersects(new Box(var2)) && !Util138.m_3050().m_1948(this, var2)) {
         var1.add(var2);
      }
   }

   private List<BlockPos> m_2612(BlockPos var1) {
      ArrayList var2 = new ArrayList();
      this.m_3553(var2, var1);
      this.m_3553(var2, var1.up());
      if (this.f_6284.m_2073(f_6295)) {
         for (BlockPos var4 : List.of(
            var1.east(), var1.west(), var1.south(), var1.north(), var1.east().up(), var1.west().up(), var1.south().up(), var1.north().up()
         )) {
            this.m_3553(var2, var4);
         }
      } else {
         this.m_3553(var2, var1.up(2));
      }

      return var2;
   }

   private boolean m_618(PlayerEntity var1) {
      return var1 != f_5909.player
         && var1.isAlive()
         && !var1.isSpectator()
         && !AntiBot.m_79(var1)
         && (InitManager.f_2740.f_2744 == null || !InitManager.f_2740.f_2744.m_3914(var1))
         && f_5909.player.getEyePos().distanceTo(var1.getEyePos()) <= f_6294;
   }

   @EventHandler
   private void m_3120(Util170 var1) {
      Util138 var2 = Util138.m_3050();
      if (f_5909.player == null || f_5909.world == null || this.m_3009() == -1) {
         var2.O(this);
      } else if (!var2.m_2896(this)) {
         PlayerEntity var3 = this.m_1581();
         if (var3 != null) {
            List var4 = this.m_2612(this.m_1081(var3));
            var2.m_915(this, var4, Items.COBWEB, true, true, 100, this.f_6285.m_1163());
         }
      }
   }

   private boolean m_2607(PlayerEntity var1) {
      Vec3d var2 = f_5909.player.getEyePos();
      Vec3d var3 = var1.getEyePos();
      double var4 = var2.distanceTo(var3);
      Optional var6 = var1.getBoundingBox().raycast(var2, var2.add(var3.subtract(var2).normalize().multiply(var4)));
      return var6.isPresent();
   }

   public WebTrap() {
      super(f_6286, f_6287, Category.COMBAT);
      this.f_6284 = new ModeSetting(f_6288, f_6289, f_6290, f_6291);
      this.f_6285 = new BooleanSetting(f_6292, false);
   }

   @Override
   public void m_1() {
      Util138.m_3050().O(this);
      super.m_1();
   }

   private int m_3009() {
      for (int var1 = 0; var1 < 9; var1++) {
         if (f_5909.player.getInventory().getStack(var1).isOf(Items.COBWEB)) {
            return var1;
         }
      }

      return -1;
   }
}
