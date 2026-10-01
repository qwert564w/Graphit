package su.energyclient.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public final class Util3 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_5249 = 3;
   private static final String f_5250 = "Brewer direction must be horizontal";
   private static final double f_5251 = 0.375;
   private static final double f_5252 = 0.375;
   private static final double f_5253 = 0.3;
   private static final double f_5254 = 0.499;
   private static final double f_5255 = 0.499;
   private static final double f_5256 = 0.499;

   private static void m_2737(
      Util3.cnzWk9fPk59HdF3l var0,
      Util3.TpxqsZ4xHRaf3kJA var1,
      int var2,
      int var3,
      int var4,
      BlockState var5,
      int var6,
      int var7,
      int var8,
      Util3.Inner_2B3aZqCz4ltKA6p0 var9,
      double var10,
      double var12,
      double var14,
      int var16,
      int var17,
      int var18,
      boolean var19,
      Util3.uHlXErCRIc79AkE3 var20
   ) {
      var0.m_2340(
         new Util3.D7sPArcYOVamY1AK(
            var1.pos(var2, var3, var4),
            var5,
            var1.pos(var6, var7, var8),
            var1.map(var9),
            var1.offset(var10, var12, var14),
            var1.pos(var16, var17, var18),
            var19,
            var20
         )
      );
   }

   private Util3() {
   }

   private static Map<BlockPos, BlockState> m_446(Map<BlockPos, BlockState> var0) {
      return Collections.unmodifiableMap(new LinkedHashMap<>(var0));
   }

   private static BlockState m_2222(Direction var0) {
      return (BlockState)Blocks.REDSTONE_WALL_TORCH.getDefaultState().with(Properties.HORIZONTAL_FACING, var0);
   }

   private static BlockState m_3926(Direction var0) {
      return (BlockState)((BlockState)Blocks.REPEATER.getDefaultState().with(Properties.HORIZONTAL_FACING, var0)).with(Properties.DELAY, 1);
   }

   public static Util3.wTUpIpIowbV03OJe m_2050(Direction var0, Block var1) {
      if (!var0.getAxis().isHorizontal()) {
         throw new IllegalArgumentException(f_5250);
      } else {
         Util3.TpxqsZ4xHRaf3kJA var2 = new Util3.TpxqsZ4xHRaf3kJA(var0);
         Util3.cnzWk9fPk59HdF3l var3 = new Util3.cnzWk9fPk59HdF3l();
         m_3484(var3, var2, var1, -2, 0, 0);
         m_3484(var3, var2, var1, -2, 0, 1);
         m_3484(var3, var2, var1, -2, 0, 2);
         m_3484(var3, var2, var1, -1, 0, 1);
         m_3484(var3, var2, var1, -1, 0, 2);
         m_3484(var3, var2, var1, 0, 0, 2);

         for (int var4 = 1; var4 <= 3; var4++) {
            m_3484(var3, var2, var1, var4, 0, 0);
            m_3484(var3, var2, var1, var4, 0, -1);
         }

         for (int var5 = 1; var5 <= 3; var5++) {
            m_3484(var3, var2, var1, var5, 0, 1);
            m_3484(var3, var2, var1, var5, 1, 1);
            m_3484(var3, var2, var1, var5, 0, 2);
            m_3484(var3, var2, var1, var5, 1, 2);
         }

         m_1320(
            var3,
            var2,
            -1,
            1,
            1,
            m_3926(var2.map(Util3.Inner_2B3aZqCz4ltKA6p0.LEFT)),
            -1,
            0,
            1,
            Util3.Inner_2B3aZqCz4ltKA6p0.UP,
            -3,
            0,
            1,
            true,
            Util3.uHlXErCRIc79AkE3.STRUCTURAL
         );

         for (int var6 = 1; var6 <= 3; var6++) {
            m_1320(
               var3,
               var2,
               var6,
               2,
               1,
               m_532(var2.map(Util3.Inner_2B3aZqCz4ltKA6p0.BACK)),
               var6,
               1,
               1,
               Util3.Inner_2B3aZqCz4ltKA6p0.UP,
               var6,
               1,
               0,
               true,
               Util3.uHlXErCRIc79AkE3.STRUCTURAL
            );
         }

         m_1320(
            var3,
            var2,
            0,
            0,
            -1,
            m_2291(var2.map(Util3.Inner_2B3aZqCz4ltKA6p0.BACK)),
            0,
            -1,
            -1,
            Util3.Inner_2B3aZqCz4ltKA6p0.UP,
            0,
            0,
            -2,
            true,
            Util3.uHlXErCRIc79AkE3.STRUCTURAL
         );
         m_1320(
            var3,
            var2,
            0,
            0,
            0,
            m_1728(var2.map(Util3.Inner_2B3aZqCz4ltKA6p0.BACK)),
            0,
            0,
            -1,
            Util3.Inner_2B3aZqCz4ltKA6p0.FORWARD,
            0,
            0,
            1,
            true,
            Util3.uHlXErCRIc79AkE3.STRUCTURAL
         );
         m_1320(
            var3,
            var2,
            0,
            1,
            0,
            Blocks.BREWING_STAND.getDefaultState(),
            0,
            0,
            0,
            Util3.Inner_2B3aZqCz4ltKA6p0.UP,
            1,
            1,
            0,
            true,
            Util3.uHlXErCRIc79AkE3.BLOCK_ONLY
         );
         m_1320(
            var3,
            var2,
            0,
            1,
            1,
            m_1728(var2.map(Util3.Inner_2B3aZqCz4ltKA6p0.BACK)),
            0,
            1,
            0,
            Util3.Inner_2B3aZqCz4ltKA6p0.FORWARD,
            0,
            1,
            2,
            true,
            Util3.uHlXErCRIc79AkE3.STRUCTURAL
         );
         m_1320(
            var3,
            var2,
            0,
            2,
            1,
            m_2291(var2.map(Util3.Inner_2B3aZqCz4ltKA6p0.FORWARD)),
            0,
            1,
            1,
            Util3.Inner_2B3aZqCz4ltKA6p0.UP,
            0,
            1,
            2,
            true,
            Util3.uHlXErCRIc79AkE3.STRUCTURAL
         );
         m_2737(
            var3,
            var2,
            0,
            2,
            0,
            m_1728(Direction.DOWN),
            0,
            1,
            0,
            Util3.Inner_2B3aZqCz4ltKA6p0.UP,
            0.0,
            f_5251,
            0.0,
            1,
            1,
            0,
            true,
            Util3.uHlXErCRIc79AkE3.STRUCTURAL
         );

         for (int var7 = 1; var7 <= 3; var7++) {
            m_2737(
               var3,
               var2,
               var7,
               2,
               0,
               m_1728(var2.map(Util3.Inner_2B3aZqCz4ltKA6p0.LEFT)),
               var7 - 1,
               2,
               0,
               Util3.Inner_2B3aZqCz4ltKA6p0.RIGHT,
               f_5252,
               f_5253,
               0.0,
               var7,
               1,
               -1,
               true,
               Util3.uHlXErCRIc79AkE3.STRUCTURAL
            );
         }

         m_1320(
            var3,
            var2,
            -1,
            0,
            0,
            m_2222(var2.map(Util3.Inner_2B3aZqCz4ltKA6p0.RIGHT)),
            -2,
            0,
            0,
            Util3.Inner_2B3aZqCz4ltKA6p0.RIGHT,
            -1,
            0,
            -1,
            true,
            Util3.uHlXErCRIc79AkE3.STRUCTURAL
         );
         m_1320(
            var3,
            var2,
            -3,
            0,
            0,
            m_947(var2.map(Util3.Inner_2B3aZqCz4ltKA6p0.LEFT)),
            -2,
            0,
            0,
            Util3.Inner_2B3aZqCz4ltKA6p0.LEFT,
            -3,
            0,
            -1,
            true,
            Util3.uHlXErCRIc79AkE3.STRUCTURAL
         );
         m_3989(var3, var2, var1.getDefaultState(), 0, 1, 2);
         m_3989(var3, var2, m_1682(), -2, 1, 0);
         m_3989(var3, var2, m_1682(), -2, 1, 1);
         m_3989(var3, var2, m_1682(), -2, 1, 2);
         m_3989(var3, var2, m_1682(), -1, 1, 2);
         m_3989(var3, var2, Blocks.REDSTONE_TORCH.getDefaultState(), 0, 2, 2);

         for (int var8 = 1; var8 <= 3; var8++) {
            m_3989(var3, var2, m_1682(), var8, 2, 2);
            m_3989(var3, var2, m_1682(), var8, 3, 1);
         }

         return var3.m_1748();
      }
   }

   public static boolean m_2512(BlockState var0, Util3.D7sPArcYOVamY1AK var1) {
      return var1.matchRule() == Util3.uHlXErCRIc79AkE3.BLOCK_ONLY ? var0.getBlock() == var1.state().getBlock() : m_3035(var0, var1.state());
   }

   private static BlockState m_2291(Direction var0) {
      return (BlockState)Blocks.CHEST.getDefaultState().with(Properties.HORIZONTAL_FACING, var0);
   }

   public static boolean m_3035(BlockState var0, BlockState var1) {
      if (var0.getBlock() != var1.getBlock()) {
         return false;
      } else {
         Block var2 = var1.getBlock();
         if (var2 == Blocks.HOPPER) {
            return var0.get(Properties.HOPPER_FACING) == var1.get(Properties.HOPPER_FACING);
         } else if (var2 == Blocks.DROPPER) {
            return var0.get(Properties.FACING) == var1.get(Properties.FACING);
         } else if (var2 == Blocks.REPEATER) {
            return var0.get(Properties.HORIZONTAL_FACING) == var1.get(Properties.HORIZONTAL_FACING)
               && ((Integer)var0.get(Properties.DELAY)).equals(var1.get(Properties.DELAY));
         } else if (var2 == Blocks.CHEST) {
            return var0.get(Properties.HORIZONTAL_FACING) == var1.get(Properties.HORIZONTAL_FACING)
               && var0.get(Properties.CHEST_TYPE) == var1.get(Properties.CHEST_TYPE);
         } else if (var2 == Blocks.REDSTONE_WALL_TORCH) {
            return var0.get(Properties.HORIZONTAL_FACING) == var1.get(Properties.HORIZONTAL_FACING);
         } else {
            return var2 != Blocks.OAK_BUTTON
               ? true
               : var0.get(Properties.BLOCK_FACE) == var1.get(Properties.BLOCK_FACE)
                  && var0.get(Properties.HORIZONTAL_FACING) == var1.get(Properties.HORIZONTAL_FACING);
         }
      }
   }

   private static BlockState m_947(Direction var0) {
      return (BlockState)((BlockState)Blocks.OAK_BUTTON.getDefaultState().with(Properties.BLOCK_FACE, BlockFace.WALL)).with(Properties.HORIZONTAL_FACING, var0);
   }

   private static void m_3484(Util3.cnzWk9fPk59HdF3l var0, Util3.TpxqsZ4xHRaf3kJA var1, Block var2, int var3, int var4, int var5) {
      var0.m_3738(var1.pos(var3, var4, var5), var2.getDefaultState());
   }

   private static void m_1320(
      Util3.cnzWk9fPk59HdF3l var0,
      Util3.TpxqsZ4xHRaf3kJA var1,
      int var2,
      int var3,
      int var4,
      BlockState var5,
      int var6,
      int var7,
      int var8,
      Util3.Inner_2B3aZqCz4ltKA6p0 var9,
      int var10,
      int var11,
      int var12,
      boolean var13,
      Util3.uHlXErCRIc79AkE3 var14
   ) {
      Direction var15 = var1.map(var9);
      var0.m_2340(
         new Util3.D7sPArcYOVamY1AK(
            var1.pos(var2, var3, var4),
            var5,
            var1.pos(var6, var7, var8),
            var15,
            new Vec3d(var15.getOffsetX() * f_5254, var15.getOffsetY() * f_5255, var15.getOffsetZ() * f_5256),
            var1.pos(var10, var11, var12),
            var13,
            var14
         )
      );
   }

   private static BlockState m_532(Direction var0) {
      return (BlockState)Blocks.DROPPER.getDefaultState().with(Properties.FACING, var0);
   }

   private static void m_3989(Util3.cnzWk9fPk59HdF3l var0, Util3.TpxqsZ4xHRaf3kJA var1, BlockState var2, int var3, int var4, int var5) {
      var0.I(var1.pos(var3, var4, var5), var2);
   }

   private static BlockState m_1728(Direction var0) {
      return (BlockState)Blocks.HOPPER.getDefaultState().with(Properties.HOPPER_FACING, var0);
   }

   private static BlockState m_1682() {
      return Blocks.REDSTONE_WIRE.getDefaultState();
   }

   public static Item m_2710(Block var0) {
      if (var0 == Blocks.REDSTONE_WIRE) {
         return Items.REDSTONE;
      } else {
         return var0 != Blocks.REDSTONE_WALL_TORCH && var0 != Blocks.REDSTONE_TORCH ? var0.asItem() : Items.REDSTONE_TORCH;
      }
   }

   public record D7sPArcYOVamY1AK(
      BlockPos pos, BlockState state, BlockPos support, Direction face, Vec3d hitOffset, BlockPos stand, boolean sneak, Util3.uHlXErCRIc79AkE3 matchRule
   ) {
      public Item item() {
         return Util3.m_2710(this.state.getBlock());
      }
   }

   public static enum Inner_2B3aZqCz4ltKA6p0 {
      FORWARD,
      BACK,
      RIGHT,
      LEFT,
      UP,
      DOWN;
   }

   public record TpxqsZ4xHRaf3kJA(Direction forward) {
      public Direction map(Util3.Inner_2B3aZqCz4ltKA6p0 var1) {
         return switch (var1) {
            case FORWARD -> this.forward;
            case BACK -> this.forward.getOpposite();
            case RIGHT -> this.right();
            case LEFT -> this.right().getOpposite();
            case UP -> Direction.UP;
            case DOWN -> Direction.DOWN;
         };
      }

      public Vec3d offset(double var1, double var3, double var5) {
         Direction var7 = this.right();
         return new Vec3d(var7.getOffsetX() * var1 + this.forward.getOffsetX() * var5, var3, var7.getOffsetZ() * var1 + this.forward.getOffsetZ() * var5);
      }

      public BlockPos pos(int var1, int var2, int var3) {
         Direction var4 = this.right();
         int var5 = var3 + 3;
         return new BlockPos(var4.getOffsetX() * var1 + this.forward.getOffsetX() * var5, var2, var4.getOffsetZ() * var1 + this.forward.getOffsetZ() * var5);
      }

      public Direction right() {
         return this.forward.rotateYClockwise();
      }
   }

   private static final class cnzWk9fPk59HdF3l {
      private final Map<BlockPos, BlockState> f_1368 = new LinkedHashMap<>();
      private final Map<BlockPos, BlockState> f_1369 = new LinkedHashMap<>();
      private final Map<BlockPos, BlockState> f_1370 = new LinkedHashMap<>();
      private final ArrayList<Util3.D7sPArcYOVamY1AK> f_1371 = new ArrayList<>();
      private final Set<BlockPos> f_1372 = new LinkedHashSet<>();
      private static final int f_1373 = Integer.MAX_VALUE;
      private static final int f_1374 = Integer.MAX_VALUE;
      private static final int f_1375 = Integer.MAX_VALUE;
      private static final int f_1376 = Integer.MIN_VALUE;
      private static final int f_1377 = Integer.MIN_VALUE;
      private static final int f_1378 = Integer.MIN_VALUE;

      void I(BlockPos var1, BlockState var2) {
         this.m_2680(var1, var2);
         this.f_1370.put(var1, var2);
      }

      void m_2340(Util3.D7sPArcYOVamY1AK var1) {
         this.m_2680(var1.pos(), var1.state());
         this.f_1371.add(var1);
         this.f_1372.add(var1.stand());
      }

      private void m_2680(BlockPos var1, BlockState var2) {
         BlockState var3 = this.f_1368.putIfAbsent(var1, var2);
         if (var3 != null) {
            throw new IllegalStateException("Duplicate brewer coordinate " + var1);
         }
      }

      void m_3738(BlockPos var1, BlockState var2) {
         this.m_2680(var1, var2);
         this.f_1369.put(var1, var2);
      }

      Util3.wTUpIpIowbV03OJe m_1748() {
         int var1 = f_1373;
         int var2 = f_1374;
         int var3 = f_1375;
         int var4 = f_1376;
         int var5 = f_1377;
         int var6 = f_1378;

         for (BlockPos var8 : this.f_1368.keySet()) {
            var1 = Math.min(var1, var8.getX());
            var2 = Math.min(var2, var8.getY());
            var3 = Math.min(var3, var8.getZ());
            var4 = Math.max(var4, var8.getX());
            var5 = Math.max(var5, var8.getY());
            var6 = Math.max(var6, var8.getZ());
         }

         return new Util3.wTUpIpIowbV03OJe(
            this.f_1368, this.f_1369, this.f_1370, this.f_1371, this.f_1372, new BlockPos(var1, var2, var3), new BlockPos(var4, var5, var6)
         );
      }
   }

   public static enum uHlXErCRIc79AkE3 {
      BLOCK_ONLY,
      STRUCTURAL;
   }

   public record wTUpIpIowbV03OJe(
      Map<BlockPos, BlockState> blocks,
      Map<BlockPos, BlockState> foundationBlocks,
      Map<BlockPos, BlockState> redstoneBlocks,
      List<Util3.D7sPArcYOVamY1AK> placements,
      Set<BlockPos> approachFeet,
      BlockPos min,
      BlockPos max
   ) {
      public wTUpIpIowbV03OJe(
         Map<BlockPos, BlockState> blocks,
         Map<BlockPos, BlockState> foundationBlocks,
         Map<BlockPos, BlockState> redstoneBlocks,
         List<Util3.D7sPArcYOVamY1AK> placements,
         Set<BlockPos> approachFeet,
         BlockPos min,
         BlockPos max
      ) {
         blocks = Util3.m_446(blocks);
         foundationBlocks = Util3.m_446(foundationBlocks);
         redstoneBlocks = Util3.m_446(redstoneBlocks);
         placements = List.copyOf(placements);
         approachFeet = Collections.unmodifiableSet(new LinkedHashSet(approachFeet));
         this.blocks = blocks;
         this.foundationBlocks = foundationBlocks;
         this.redstoneBlocks = redstoneBlocks;
         this.placements = placements;
         this.approachFeet = approachFeet;
         this.min = min;
         this.max = max;
      }
   }
}
