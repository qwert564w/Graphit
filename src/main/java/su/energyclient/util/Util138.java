package su.energyclient.util;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.BeaconBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BrewingStandBlock;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.CartographyTableBlock;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.EnchantingTableBlock;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.GrindstoneBlock;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.block.LecternBlock;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.LoomBlock;
import net.minecraft.block.NoteBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.SmithingTableBlock;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.item.Item;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.EventHandler;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;

public final class Util138 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Util138 f_10474 = new Util138();
   private static final int f_10475 = 10;
   private static final List<Class<? extends Block>> f_10476 = List.of(
      BlockWithEntity.class,
      DoorBlock.class,
      TrapdoorBlock.class,
      FenceGateBlock.class,
      ButtonBlock.class,
      LeverBlock.class,
      NoteBlock.class,
      JukeboxBlock.class,
      CraftingTableBlock.class,
      AbstractFurnaceBlock.class,
      AnvilBlock.class,
      BarrelBlock.class,
      ChestBlock.class,
      EnderChestBlock.class,
      ShulkerBoxBlock.class,
      EnchantingTableBlock.class,
      BrewingStandBlock.class,
      LoomBlock.class,
      StonecutterBlock.class,
      CartographyTableBlock.class,
      SmithingTableBlock.class,
      GrindstoneBlock.class,
      BeaconBlock.class,
      LecternBlock.class
   );
   private final Deque<Util138.Inner_94kKjiTyAQ4ZbSSK> f_10477 = new ArrayDeque<>();
   private final Map<BlockPos, Object> f_10478 = new HashMap<>();
   private Util138.Inner_94kKjiTyAQ4ZbSSK f_10479;
   private Object f_10480;
   private Util10 f_10481;
   private int f_10482;
   private static final int f_10483 = Integer.MIN_VALUE;
   private static final float f_10484 = 1.5F;
   private static final float f_10485 = 1.5F;
   private static final float f_10486 = 0.25F;
   private static final float f_10487 = 0.25F;
   private static final float f_10488 = 9999.0F;
   private static final float f_10489 = 9999.0F;
   private static final float f_10490 = 0.01F;
   private static final float f_10491 = 0.01F;
   private static final float f_10492 = 9999.0F;
   private static final float f_10493 = 9999.0F;
   private static final float f_10494 = Float.MAX_VALUE;
   private static final double f_10495 = Double.MAX_VALUE;
   private static final double f_10496 = 0.5;
   private static final double f_10497 = 20.25;
   private static final double f_10498 = 0.01;
   private static final float f_10499 = 0.5F;
   private static final float f_10500 = 0.001F;
   private static final float f_10501 = 90.0F;
   private static final float f_10502 = -90.0F;
   private static final float f_10503 = 90.0F;

   private Util10 m_1089(Vec3d var1) {
      Vec3d var2 = var1.subtract(f_5909.player.getEyePos());
      return new Util10(
         MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(var2.z, var2.x)) - f_10501),
         MathHelper.clamp((float)(-Math.toDegrees(Math.atan2(var2.y, Math.hypot(var2.x, var2.z)))), f_10502, f_10503)
      );
   }

   public void O(Object var1) {
      this.f_10477.removeIf(var1x -> var1x.f_7049 == var1);
      if (this.f_10479 != null && this.f_10479.f_7049 == var1) {
         this.m_1573();
      } else if (this.f_10480 == var1) {
         this.m_4116();
      }
   }

   private Util138() {
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   public boolean m_915(Object var1, List<BlockPos> var2, Item var3, boolean var4, boolean var5, int var6, boolean var7) {
      if (f_5909.player != null && var2 != null && !var2.isEmpty() && var3 != null) {
         if (this.f_10479 != null && var6 < this.f_10479.f_7054) {
            return false;
         } else if (!this.f_10477.isEmpty() && var6 < this.f_10477.peekFirst().f_7054) {
            return false;
         } else {
            this.f_10477.removeIf(var1x -> var1x.f_7049 == var1);

            for (BlockPos var9 : var2) {
               if (!this.m_1948(var1, var9)) {
                  this.f_10477.addLast(new Util138.Inner_94kKjiTyAQ4ZbSSK(var1, var9.toImmutable(), var3, var4, var5, var6, var7, f_5909.player.age));
               }
            }

            return !this.f_10477.isEmpty();
         }
      } else {
         return false;
      }
   }

   public void m_4125(Object var1, Collection<BlockPos> var2) {
      if (var1 != null) {
         this.m_1018(var1);
         if (var2 != null && !var2.isEmpty()) {
            for (BlockPos var4 : var2) {
               if (var4 != null) {
                  this.f_10478.put(var4.toImmutable(), var1);
               }
            }

            this.f_10477.removeIf(var1x -> this.m_1948(var1x.f_7049, var1x.f_7050));
            if (this.f_10479 != null && this.m_1948(this.f_10479.f_7049, this.f_10479.f_7050)) {
               this.m_1573();
            }
         }
      }
   }

   private void m_1495() {
      while (!this.f_10477.isEmpty()) {
         Util138.Inner_94kKjiTyAQ4ZbSSK var1 = this.f_10477.pollFirst();
         if (!this.m_1948(var1.f_7049, var1.f_7050) && f_5909.world.getBlockState(var1.f_7050).isReplaceable() && this.m_647(var1.f_7050, var1.f_7053) != null) {
            this.f_10479 = var1;
            return;
         }
      }
   }

   private void m_4116() {
      Util54 var1 = Util54.m_1085();
      if (this.f_10481 != null && var1.m_2266() == this.f_10482 && var1.m_340() != null && var1.m_340().m_855(this.f_10481) < f_10491) {
         Util54.m_2498(null, f_10492, f_10493, 1, this.f_10482);
         var1.m_2736(0);
      }

      this.f_10480 = null;
      this.f_10481 = null;
      this.f_10482 = 0;
   }

   public boolean m_3132(Object var1, int var2) {
      int var3 = f_10483;
      if (this.f_10479 != null && this.f_10479.f_7049 != var1) {
         var3 = this.f_10479.f_7054;
      }

      for (Util138.Inner_94kKjiTyAQ4ZbSSK var5 : this.f_10477) {
         if (var5.f_7049 != var1) {
            var3 = Math.max(var3, var5.f_7054);
         }
      }

      return var2 >= var3;
   }

   public boolean m_2896(Object var1) {
      return this.f_10479 != null && this.f_10479.f_7049 == var1 || this.f_10477.stream().anyMatch(var1x -> var1x.f_7049 == var1);
   }

   public static Util138 m_3050() {
      return f_10474;
   }

   public void m_1018(Object var1) {
      if (var1 != null) {
         this.f_10478.entrySet().removeIf(var1x -> var1x.getValue() == var1);
      }
   }

   private static void m_2391(boolean var0) {
      PlayerInput var1 = f_5909.player.input.playerInput;
      f_5909.player
         .networkHandler
         .sendPacket(new PlayerInputC2SPacket(new PlayerInput(var1.forward(), var1.backward(), var1.left(), var1.right(), var1.jump(), var0, var1.sprint())));
   }

   private void m_588(Util138.MbmjP771tKhr1cZ8 var1, Item var2) {
      int var3 = -1;

      for (int var4 = 0; var4 < 9; var4++) {
         if (f_5909.player.getInventory().getStack(var4).isOf(var2)) {
            var3 = var4;
         }
      }

      if (var3 != -1) {
         int var9 = f_5909.player.getInventory().getSelectedSlot();
         boolean var5 = m_4111(f_5909.world.getBlockState(var1.neighbor)) && !f_5909.player.isSneaking();

         try {
            f_5909.player.getInventory().setSelectedSlot(var3);
            ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
            if (var5) {
               m_2391(true);
            }

            f_5909.interactionManager.interactBlock(f_5909.player, Hand.MAIN_HAND, new BlockHitResult(var1.hit, var1.side, var1.neighbor, false));
         } finally {
            if (var5) {
               m_2391(false);
            }

            f_5909.player.getInventory().setSelectedSlot(var9);
            ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
         }
      }
   }

   private void m_1573() {
      Object var1 = this.f_10479 == null ? null : this.f_10479.f_7049;
      this.f_10479 = null;
      if (this.f_10480 != null && (var1 == null || this.f_10480 == var1)) {
         this.m_4116();
      }
   }

   private void m_1827(Util138.Inner_94kKjiTyAQ4ZbSSK var1, Util10 var2) {
      Util54.m_2498(var2, f_10488, f_10489, 60, var1.f_7054);
      Util54 var3 = Util54.m_1085();
      if (var3.m_2266() == var1.f_7054 && var3.m_340() != null && var3.m_340().m_855(var2) < f_10490) {
         this.f_10480 = var1.f_7049;
         this.f_10481 = var2;
         this.f_10482 = var1.f_7054;
      }
   }

   public static boolean m_4111(BlockState var0) {
      for (Class var2 : f_10476) {
         if (var2.isInstance(var0.getBlock())) {
            return true;
         }
      }

      return false;
   }

   private Util138.MbmjP771tKhr1cZ8 m_647(BlockPos var1, boolean var2) {
      Vec3d var3 = f_5909.player.getEyePos();
      Util138.MbmjP771tKhr1cZ8 var4 = null;
      float var5 = f_10494;
      double var6 = f_10495;

      for (Direction var11 : Direction.values()) {
         BlockPos var12 = var1.offset(var11.getOpposite());
         BlockState var13 = f_5909.world.getBlockState(var12);
         boolean var14 = var13.isOf(Blocks.COBWEB);
         if (var14 || !var13.isReplaceable() && var13.isSideSolidFullSquare(f_5909.world, var12, var11)) {
            Vec3d var15 = Vec3d.ofCenter(var12).add(Vec3d.of(var11.getVector()).multiply(f_10496));
            double var16 = var3.squaredDistanceTo(var15);
            if (!(var16 > f_10497)
               && !(var3.subtract(var15).dotProduct(Vec3d.of(var11.getVector())) <= f_10498)
               && (var2 || this.m_1208(var3, var15, var12, var11))) {
               Util10 var18 = this.m_1089(var15);
               float var19 = Math.abs(MathHelper.wrapDegrees(var18.m_2643() - f_5909.player.getYaw()))
                  + Math.abs(var18.m_2573() - f_5909.player.getPitch()) * f_10499;
               if (var19 < var5 || Math.abs(var19 - var5) < f_10500 && var16 < var6) {
                  var5 = var19;
                  var6 = var16;
                  var4 = new Util138.MbmjP771tKhr1cZ8(var12, var11, var15);
               }
            }
         }
      }

      return var4;
   }

   public boolean m_1948(Object var1, BlockPos var2) {
      Object var3 = var2 == null ? null : this.f_10478.get(var2);
      return var3 != null && var3 != var1;
   }

   private boolean m_1208(Vec3d var1, Vec3d var2, BlockPos var3, Direction var4) {
      return f_5909.world.raycast(new RaycastContext(var1, var2, ShapeType.OUTLINE, FluidHandling.NONE, f_5909.player)) instanceof BlockHitResult var6
         && var6.getBlockPos().equals(var3)
         && var6.getSide() == var4;
   }

   @EventHandler
   private void m_3856(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
         if (this.f_10479 == null) {
            this.m_1495();
         }

         if (this.f_10479 != null) {
            if (!this.m_1948(this.f_10479.f_7049, this.f_10479.f_7050)
               && f_5909.player.age - this.f_10479.f_7056 <= 10
               && f_5909.world.getBlockState(this.f_10479.f_7050).isReplaceable()) {
               Util138.MbmjP771tKhr1cZ8 var2 = this.m_647(this.f_10479.f_7050, this.f_10479.f_7053);
               if (var2 == null) {
                  this.m_1573();
               } else {
                  Util10 var3 = this.m_1089(var2.hit);
                  Util10 var4 = Util10.m_3601();
                  float var5 = Math.abs(MathHelper.wrapDegrees(var3.m_2643() - var4.m_2643()));
                  float var6 = Math.abs(var3.m_2573() - var4.m_2573());
                  if (!this.f_10479.f_7052 || !(var5 > f_10484) && !(var6 > f_10485)) {
                     if (this.f_10479.f_7052 && !this.f_10479.f_7055 && (var5 > f_10486 || var6 > f_10487)) {
                        if (this.f_10479.f_7058 < 0) {
                           this.f_10479.f_7058 = f_5909.player.age;
                           this.m_1827(this.f_10479, var3);
                           return;
                        }

                        if (this.f_10479.f_7058 == f_5909.player.age) {
                           return;
                        }
                     }

                     this.m_588(var2, this.f_10479.f_7051);
                     this.m_1573();
                  } else {
                     this.m_1827(this.f_10479, var3);
                     this.f_10479.f_7057 = true;
                     this.f_10479.f_7058 = -1;
                  }
               }
            } else {
               this.m_1573();
            }
         }
      } else {
         this.m_1573();
         this.f_10477.clear();
      }
   }

   private static final class Inner_94kKjiTyAQ4ZbSSK {
      final Object f_7049;
      final BlockPos f_7050;
      final Item f_7051;
      final boolean f_7052;
      final boolean f_7053;
      final int f_7054;
      final boolean f_7055;
      final int f_7056;
      boolean f_7057;
      int f_7058 = -1;

      Inner_94kKjiTyAQ4ZbSSK(Object var1, BlockPos var2, Item var3, boolean var4, boolean var5, int var6, boolean var7, int var8) {
         this.f_7049 = var1;
         this.f_7050 = var2;
         this.f_7051 = var3;
         this.f_7052 = var4;
         this.f_7053 = var5;
         this.f_7054 = var6;
         this.f_7055 = var7;
         this.f_7056 = var8;
      }
   }

   private record MbmjP771tKhr1cZ8(BlockPos neighbor, Direction side, Vec3d hit) {
   }
}
