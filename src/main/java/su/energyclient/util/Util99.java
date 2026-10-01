package su.energyclient.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import su.energyclient.QuickImports;

public final class Util99 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_6885 = 6;
   private static final double f_6886 = 0.0;
   private static final Direction[] f_6887 = new Direction[]{Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST, Direction.DOWN};
   private static final double f_6888 = 0.001;
   private static final double f_6889 = 0.5;
   private static final double f_6890 = 0.5;
   private static final double f_6891 = 0.5;
   private static final double f_6892 = 0.001;

   private Util99() {
   }

   private static boolean m_1469(LinkedHashSet<BlockPos> var0, BlockPos var1, BlockPos var2, double var3, Predicate<BlockPos> var5) {
      if (var0.contains(var1)) {
         return true;
      } else if (var0.size() < 6 && m_3111(var1, var2, var3, var5)) {
         var0.add(var1.toImmutable());
         return true;
      } else {
         return false;
      }
   }

   private static boolean m_3535(
      Util99.L9EWNXGyvAtV8sC9 var0, BlockPos var1, BlockPos var2, LinkedHashSet<BlockPos> var3, double var4, Predicate<BlockPos> var6
   ) {
      Vec3d var7 = f_5909.player.getEyePos();
      Vec3d var8 = var0.point().subtract(Vec3d.of(var0.side().getVector()).multiply(f_6888));
      int var9 = 0;

      while (var9 <= 6) {
         BlockHitResult var10 = m_1909(var7, var8, var1, var3);
         if (var10 != null && var10.getType() == Type.BLOCK) {
            BlockPos var11 = var10.getBlockPos();
            if (var11.equals(var0.block())) {
               return var10.getSide() == var0.side();
            }

            if (!var11.equals(var1) && m_1469(var3, var11, var2, var4, var6)) {
               var9++;
               continue;
            }

            return false;
         }

         return false;
      }

      return false;
   }

   private static BlockHitResult m_1123(BlockPos var0) {
      BlockState var1 = f_5909.world.getBlockState(var0);
      VoxelShape var2 = var1.getOutlineShape(f_5909.world, var0, ShapeContext.of(f_5909.player));
      if (var2.isEmpty()) {
         return null;
      } else {
         Vec3d var3 = var2.getBoundingBox().getCenter().add(var0.getX(), var0.getY(), var0.getZ());
         return f_5909.world.raycast(new RaycastContext(f_5909.player.getEyePos(), var3, ShapeType.OUTLINE, FluidHandling.NONE, f_5909.player));
      }
   }

   public static Util99.SfIKBt5vqdTr90GS m_1750(BlockPos var0, boolean var1, double var2, boolean var4, Predicate<BlockPos> var5) {
      if (f_5909.world != null && f_5909.player != null && var0 != null && var5 != null && Double.isFinite(var2) && !(var2 <= 0.0)) {
         var0 = var0.toImmutable();
         BlockState var6 = f_5909.world.getBlockState(var0);
         if (!var1 && !m_3219(var6)) {
            return null;
         } else if (var1 && m_3219(var6)) {
            return null;
         } else {
            BlockPos var7 = var1 ? null : var0;
            Predicate<BlockPos> var8 = var2x -> !var2x.equals(var7) && var5.test(var2x);
            LinkedHashSet var9 = new LinkedHashSet();
            if (var1 && !var6.isReplaceable() && !m_1469(var9, var0, null, var2, var8)) {
               return null;
            } else if (!f_5909.world.isAir(var0.up()) && !m_1469(var9, var0.up(), null, var2, var8)) {
               return null;
            } else {
               List<Util99.L9EWNXGyvAtV8sC9> var10 = m_2084(var0, new Box(0.0, 0.0, 0.0, 1.0, 1.0, 1.0), var2);
               if (var10.isEmpty()) {
                  return null;
               } else {
                  ArrayList<Util99.L9EWNXGyvAtV8sC9> var11 = new ArrayList<>();
                  if (var1) {
                     for (Direction var15 : f_6887) {
                        BlockPos var16 = var0.offset(var15.getOpposite());
                        if (!var9.contains(var16)) {
                           BlockState var17 = f_5909.world.getBlockState(var16);
                           if (!var17.isReplaceable() && !var17.getCollisionShape(f_5909.world, var16).isEmpty() && (var4 || !Util138.m_4111(var17))) {
                              VoxelShape var18 = var17.getOutlineShape(f_5909.world, var16, ShapeContext.of(f_5909.player));
                              if (!var18.isEmpty()) {
                                 Util99.L9EWNXGyvAtV8sC9 var19 = m_2818(var16, var15, var18.getBoundingBox());
                                 if (m_3375(var19, var2)) {
                                    var11.add(var19);
                                 }
                              }
                           }
                        }
                     }

                     if (var11.isEmpty()) {
                        return null;
                     }
                  } else {
                     var11.add(null);
                  }

                  Util99.SfIKBt5vqdTr90GS var21 = null;

                  for (Util99.L9EWNXGyvAtV8sC9 var23 : var11) {
                     for (Util99.L9EWNXGyvAtV8sC9 var25 : var10) {
                        Util99.SfIKBt5vqdTr90GS var26 = m_374(var0, var23, var25, var9, var2, var8);
                        if (var26 != null && (var21 == null || var26.removedBlocks().size() < var21.removedBlocks().size())) {
                           var21 = var26;
                           if (var26.removedBlocks().size() == var9.size()) {
                              return var26;
                           }
                        }
                     }
                  }

                  return var21;
               }
            }
         }
      } else {
         return null;
      }
   }

   private static boolean m_3375(Util99.L9EWNXGyvAtV8sC9 var0, double var1) {
      Vec3d var3 = f_5909.player.getEyePos();
      return var3.squaredDistanceTo(var0.point()) <= var1 * var1 && var3.subtract(var0.point()).dotProduct(Vec3d.of(var0.side().getVector())) > f_6892;
   }

   private static List<Util99.L9EWNXGyvAtV8sC9> m_2084(BlockPos var0, Box var1, double var2) {
      ArrayList var4 = new ArrayList();

      for (Direction var8 : f_6887) {
         Util99.L9EWNXGyvAtV8sC9 var9 = m_2818(var0, var8, var1);
         if (m_3375(var9, var2)) {
            var4.add(var9);
         }
      }

      return var4;
   }

   private static Util99.L9EWNXGyvAtV8sC9 m_2818(BlockPos var0, Direction var1, Box var2) {
      double var3 = (var2.minX + var2.maxX) * f_6889;
      double var5 = (var2.minY + var2.maxY) * f_6890;
      double var7 = (var2.minZ + var2.maxZ) * f_6891;
      switch (var1) {
         case DOWN:
            var5 = var2.minY;
            break;
         case UP:
            var5 = var2.maxY;
            break;
         case NORTH:
            var7 = var2.minZ;
            break;
         case SOUTH:
            var7 = var2.maxZ;
            break;
         case WEST:
            var3 = var2.minX;
            break;
         case EAST:
            var3 = var2.maxX;
      }

      return new Util99.L9EWNXGyvAtV8sC9(var0.toImmutable(), var1, new Vec3d(var0.getX() + var3, var0.getY() + var5, var0.getZ() + var7));
   }

   private static boolean m_3219(BlockState var0) {
      return var0.isOf(Blocks.OBSIDIAN) || var0.isOf(Blocks.BEDROCK);
   }

   private static BlockHitResult m_1909(Vec3d var0, Vec3d var1, BlockPos var2, Set<BlockPos> var3) {
      return (BlockHitResult)BlockView.raycast(var0, var1, f_5909.world, (var4, var5) -> {
         boolean var6 = var5.equals(var2);
         if (!var6 && var3.contains(var5)) {
            return null;
         } else {
            BlockState var7 = var6 ? Blocks.OBSIDIAN.getDefaultState() : var4.getBlockState(var5);
            VoxelShape var8 = var7.getOutlineShape(var4, var5, ShapeContext.of(f_5909.player));
            return var4.raycastBlock(var0, var1, var5, var8, var7);
         }
      }, var0x -> null);
   }

   private static Util99.SfIKBt5vqdTr90GS m_374(
      BlockPos var0, Util99.L9EWNXGyvAtV8sC9 var1, Util99.L9EWNXGyvAtV8sC9 var2, Set<BlockPos> var3, double var4, Predicate<BlockPos> var6
   ) {
      LinkedHashSet<BlockPos> var7 = new LinkedHashSet<>(var3);
      BlockPos var8 = var1 == null ? null : var1.block();

      for (int var9 = 0; var9 <= 6; var9++) {
         if (var1 != null && !m_3535(var1, null, var8, var7, var4, var6)) {
            return null;
         }

         if (!m_3535(var2, var0, var8, var7, var4, var6)) {
            return null;
         }

         if (var7.isEmpty()) {
            return new Util99.SfIKBt5vqdTr90GS(var7, null);
         }

         BlockPos var10 = null;

         for (BlockPos var12 : var7) {
            BlockHitResult var13 = m_1123(var12);
            if (var13 != null && var13.getType() == Type.BLOCK) {
               BlockPos var14 = var13.getBlockPos();
               if (var7.contains(var14)) {
                  return new Util99.SfIKBt5vqdTr90GS(var7, var14);
               }

               if (var10 == null && m_3111(var14, var8, var4, var6)) {
                  var10 = var14.toImmutable();
               }
            }
         }

         if (var10 == null || !m_1469(var7, var10, var8, var4, var6)) {
            return null;
         }
      }

      return null;
   }

   private static boolean m_3111(BlockPos var0, BlockPos var1, double var2, Predicate<BlockPos> var4) {
      if (var0.equals(var1)) {
         return false;
      } else {
         BlockState var5 = f_5909.world.getBlockState(var0);
         return !var5.isAir()
            && var5.getFluidState().isEmpty()
            && var5.getHardness(f_5909.world, var0) >= 0.0F
            && f_5909.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var0)) <= var2 * var2
            && var4.test(var0);
      }
   }

   private record L9EWNXGyvAtV8sC9(BlockPos block, Direction side, Vec3d point) {
   }

   public record SfIKBt5vqdTr90GS(Set<BlockPos> removedBlocks, BlockPos nextBlock) {
      public SfIKBt5vqdTr90GS(Set<BlockPos> removedBlocks, BlockPos nextBlock) {
         LinkedHashSet var3 = new LinkedHashSet();

         for (BlockPos var5 : removedBlocks) {
            var3.add(var5.toImmutable());
         }

         removedBlocks = Collections.unmodifiableSet(var3);
         nextBlock = nextBlock == null ? null : nextBlock.toImmutable();
         this.removedBlocks = removedBlocks;
         this.nextBlock = nextBlock;
      }
   }
}
