package su.energyclient.util;

import baritone.api.schematic.AbstractSchematic;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public final class Util4 extends AbstractSchematic {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BlockState[] f_5526;
   private final BlockPos l;
   private static final String f_5527 = "A builder phase cannot be empty";
   private static final int f_5528 = Integer.MAX_VALUE;
   private static final int f_5529 = Integer.MAX_VALUE;
   private static final int f_5530 = Integer.MAX_VALUE;
   private static final int f_5531 = Integer.MIN_VALUE;
   private static final int f_5532 = Integer.MIN_VALUE;
   private static final int f_5533 = Integer.MIN_VALUE;

   private boolean outside(int var1, int var2, int var3) {
      return var1 < 0 || var2 < 0 || var3 < 0 || var1 >= this.widthX() || var2 >= this.heightY() || var3 >= this.lengthZ();
   }

   public BlockState desiredState(int var1, int var2, int var3, BlockState var4, List<BlockState> var5) {
      if (this.outside(var1, var2, var3)) {
         return var4;
      } else {
         BlockState var6 = this.f_5526[this.index(var1, var2, var3)];
         if (var6 == null) {
            return var4;
         } else {
            return var4.getBlock() == var6.getBlock() ? var4 : var6;
         }
      }
   }

   public BlockPos origin() {
      return this.l;
   }

   public boolean inSchematic(int var1, int var2, int var3, BlockState var4) {
      return !this.outside(var1, var2, var3) && this.f_5526[this.index(var1, var2, var3)] != null;
   }

   private Util4(Map<BlockPos, BlockState> var1, BlockPos var2, Util4.HfQCoyNm6bTdghyo var3) {
      super(var3.sizeX(), var3.sizeY(), var3.sizeZ());
      this.l = var2.add(var3.min());
      this.f_5526 = new BlockState[this.widthX() * this.heightY() * this.lengthZ()];

      for (Entry var5 : var1.entrySet()) {
         BlockPos var6 = ((BlockPos)var5.getKey()).subtract(var3.min());
         this.f_5526[this.index(var6.getX(), var6.getY(), var6.getZ())] = (BlockState)var5.getValue();
      }
   }

   private static Util4.HfQCoyNm6bTdghyo bounds(Map<BlockPos, BlockState> var0) {
      if (var0.isEmpty()) {
         throw new IllegalArgumentException(f_5527);
      } else {
         int var1 = f_5528;
         int var2 = f_5529;
         int var3 = f_5530;
         int var4 = f_5531;
         int var5 = f_5532;
         int var6 = f_5533;

         for (BlockPos var8 : var0.keySet()) {
            var1 = Math.min(var1, var8.getX());
            var2 = Math.min(var2, var8.getY());
            var3 = Math.min(var3, var8.getZ());
            var4 = Math.max(var4, var8.getX());
            var5 = Math.max(var5, var8.getY());
            var6 = Math.max(var6, var8.getZ());
         }

         return new Util4.HfQCoyNm6bTdghyo(new BlockPos(var1, var2, var3), new BlockPos(var4, var5, var6));
      }
   }

   public Util4(Map<BlockPos, BlockState> var1, BlockPos var2) {
      this(var1, var2, bounds(var1));
   }

   private int index(int var1, int var2, int var3) {
      return (var2 * this.lengthZ() + var3) * this.widthX() + var1;
   }

   private record HfQCoyNm6bTdghyo(BlockPos min, BlockPos max) {
      int sizeY() {
         return this.max.getY() - this.min.getY() + 1;
      }

      int sizeX() {
         return this.max.getX() - this.min.getX() + 1;
      }

      int sizeZ() {
         return this.max.getZ() - this.min.getZ() + 1;
      }
   }
}
