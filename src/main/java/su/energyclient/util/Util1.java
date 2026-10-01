package su.energyclient.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import su.energyclient.QuickImports;
import su.energyclient.module.miscellaneous.ObsidianFarm;

public class Util1 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ObsidianFarm f_5201;
   private static final double f_5202 = Double.MAX_VALUE;
   private static final double f_5203 = 2.0;
   private static final double f_5204 = 2.0;

   private List<BlockPos> m_1962(BlockPos var1, BlockPos var2) {
      ArrayList var3 = new ArrayList();

      for (BlockPos var5 : BlockPos.iterate(var1, var2)) {
         var3.add(var5.toImmutable());
      }

      return var3;
   }

   public int m_2353(BlockPos var1) {
      int var2 = 0;

      for (int var3 = -1; var3 <= 1; var3++) {
         for (int var4 = -1; var4 <= 1; var4++) {
            if (this.m_3880(var1.add(var3, 0, var4))) {
               var2++;
            }
         }
      }

      return var2;
   }

   public BlockPos m_1300(boolean var1) {
      int var2 = f_5909.player.getBlockPos().getY();
      List<BlockPos> var3 = this.m_1962(f_5909.player.getBlockPos().add(-5, -5, -5), f_5909.player.getBlockPos().add(5, 5, 5));
      if (var1) {
         BlockPos var4 = var3.stream()
            .filter(this::m_3880)
            .filter(this.f_5201::m_933)
            .filter(var1x -> var1x.getY() > var2)
            .filter(var1x -> this.m_2353(var1x) >= 2)
            .max(Comparator.comparingInt(BlockPos::getY).thenComparingDouble(var1x -> -this.m_2357(var1x)))
            .orElse(null);
         if (var4 == null) {
            var4 = var3.stream()
               .filter(this::m_3880)
               .filter(this.f_5201::m_933)
               .filter(var1x -> var1x.getY() > var2)
               .max(Comparator.comparingInt(BlockPos::getY).thenComparingDouble(var0 -> f_5909.player.squaredDistanceTo(var0.toCenterPos())))
               .orElse(null);
         }

         if (var4 == null) {
            var4 = var3.stream()
               .filter(this::m_3880)
               .filter(this.f_5201::m_933)
               .filter(var1x -> var1x.getY() == var2)
               .filter(var1x -> this.m_2353(var1x) >= 2)
               .max(Comparator.comparingDouble(var1x -> -this.m_2357(var1x)))
               .orElse(null);
         }

         if (var4 == null) {
            var4 = var3.stream()
               .filter(this::m_3880)
               .filter(this.f_5201::m_933)
               .filter(var1x -> var1x.getY() == var2)
               .min(Comparator.comparingDouble(var0 -> f_5909.player.squaredDistanceTo(var0.toCenterPos())))
               .orElse(null);
         }

         if (var4 == null) {
            var4 = var3.stream()
               .filter(this::m_3880)
               .filter(this.f_5201::m_933)
               .filter(var1x -> var1x.getY() < var2)
               .filter(var1x -> this.m_2353(var1x) >= 2)
               .max(Comparator.comparingInt(BlockPos::getY).thenComparingDouble(var1x -> -this.m_2357(var1x)))
               .orElse(null);
         }

         if (var4 == null) {
            var4 = var3.stream()
               .filter(this::m_3880)
               .filter(this.f_5201::m_933)
               .filter(var1x -> var1x.getY() < var2)
               .max(Comparator.comparingInt(BlockPos::getY).thenComparingDouble(var0 -> f_5909.player.squaredDistanceTo(var0.toCenterPos())))
               .orElse(null);
         }

         return var4;
      } else {
         return var3.stream()
            .filter(this::m_3880)
            .filter(this.f_5201::m_933)
            .max(Comparator.comparingInt(BlockPos::getY).thenComparingDouble(var0 -> f_5909.player.squaredDistanceTo(var0.toCenterPos())))
            .orElse(null);
      }
   }

   public boolean m_3880(BlockPos var1) {
      return f_5909.world != null && f_5909.world.getBlockState(var1).getBlock() == Blocks.OBSIDIAN;
   }

   public double m_2357(BlockPos var1) {
      int var2 = 0;
      double var3 = 0.0;
      double var5 = 0.0;

      for (int var7 = -1; var7 <= 1; var7++) {
         for (int var8 = -1; var8 <= 1; var8++) {
            BlockPos var9 = var1.add(var7, 0, var8);
            if (this.m_3880(var9) && this.f_5201.m_933(var9)) {
               var3 += var9.getX();
               var5 += var9.getZ();
               var2++;
            }
         }
      }

      return var2 == 0 ? f_5202 : Math.sqrt(Math.pow(var1.getX() - var3 / var2, f_5203) + Math.pow(var1.getZ() - var5 / var2, f_5204));
   }

   public Util1(ObsidianFarm var1) {
      this.f_5201 = var1;
   }
}
