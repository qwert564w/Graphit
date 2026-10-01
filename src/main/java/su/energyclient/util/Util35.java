package su.energyclient.util;

import java.util.Set;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public final class Util35 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_7686 = 12.0;
   private static final double f_7687 = 0.5;
   private static final double f_7688 = 0.5;
   private static final double f_7689 = 12.0;
   private static final double f_7690 = 42.0;
   private static final float f_7691 = 0.5F;
   private static final float f_7692 = 1.5F;
   private static final float f_7693 = 4.0F;
   private static final float f_7694 = 0.2F;
   private static final float f_7695 = 20.0F;
   private static final float f_7696 = 25.0F;
   private static final float f_7697 = 25.0F;
   private static final float f_7698 = 0.2F;
   private static final double f_7699 = 2.0;
   private static final double f_7700 = 2.0;
   private static final double f_7701 = 2.0;
   private static final double f_7702 = 2.0;
   private static final double f_7703 = 2.0;

   private static double m_3595(Vec3d var0, LivingEntity var1, Box var2, BlockPos var3, Set<BlockPos> var4) {
      double var5 = 1.0 / ((var2.maxX - var2.minX) * f_7699 + 1.0);
      double var7 = 1.0 / ((var2.maxY - var2.minY) * f_7700 + 1.0);
      double var9 = 1.0 / ((var2.maxZ - var2.minZ) * f_7701 + 1.0);
      double var11 = (1.0 - Math.floor(1.0 / var5) * var5) / f_7702;
      double var13 = (1.0 - Math.floor(1.0 / var9) * var9) / f_7703;
      int var15 = 0;
      int var16 = 0;

      for (double var17 = 0.0; var17 <= 1.0; var17 += var5) {
         for (double var19 = 0.0; var19 <= 1.0; var19 += var7) {
            for (double var21 = 0.0; var21 <= 1.0; var21 += var9) {
               Vec3d var23 = new Vec3d(
                  MathHelper.lerp(var17, var2.minX, var2.maxX) + var11,
                  MathHelper.lerp(var19, var2.minY, var2.maxY),
                  MathHelper.lerp(var21, var2.minZ, var2.maxZ) + var13
               );
               if (O(var23, var0, var1, var3, var4)) {
                  var15++;
               }

               var16++;
            }
         }
      }

      return var16 == 0 ? 0.0 : (double)var15 / var16;
   }

   private static boolean O(Vec3d var0, Vec3d var1, LivingEntity var2, BlockPos var3, Set<BlockPos> var4) {
      if (var3 == null && var4.isEmpty()) {
         BlockHitResult var5 = var2.getEntityWorld().raycast(new RaycastContext(var0, var1, ShapeType.COLLIDER, FluidHandling.NONE, var2));
         return var5.getType() == Type.MISS;
      } else {
         return (Boolean)BlockView.raycast(var0, var1, var2.getEntityWorld(), (var5x, var6) -> {
            boolean var7 = var6.equals(var3);
            if (!var7 && var4.contains(var6)) {
               return null;
            } else {
               BlockState var8 = var7 ? Blocks.OBSIDIAN.getDefaultState() : var5x.getBlockState(var6);
               VoxelShape var9 = var8.getCollisionShape(var5x, var6, ShapeContext.of(var2));
               return var5x.raycastBlock(var0, var1, var6, var9, var8) == null ? null : Boolean.FALSE;
            }
         }, var0x -> Boolean.TRUE);
      }
   }

   public static float O(Vec3d var0, LivingEntity var1, Box var2, BlockPos var3, BlockPos var4) {
      return O(var0, var1, var2, var3, var4 == null ? Set.of() : Set.of(var4));
   }

   private Util35() {
   }

   public static float O(Vec3d var0, LivingEntity var1, Box var2, BlockPos var3, Set<BlockPos> var4) {
      Set var5 = var4 == null ? Set.of() : var4;
      Vec3d var6 = new Vec3d((var2.minX + var2.maxX) * f_7687, var2.minY, (var2.minZ + var2.maxZ) * f_7688);
      double var7 = var6.distanceTo(var0) / f_7689;
      if (var7 > 1.0) {
         return 0.0F;
      } else {
         double var9 = (1.0 - var7) * m_3595(var0, var1, var2, var3, var5);
         float var11 = (float)((var9 * var9 + var9) * f_7690 + 1.0);
         if (var1 instanceof PlayerEntity) {
            Difficulty var12 = var1.getEntityWorld().getDifficulty();

            var11 = switch (var12) {
               case PEACEFUL -> 0.0F;
               case EASY -> Math.min(var11 * f_7691 + 1.0F, var11);
               case HARD -> var11 * f_7692;
               case NORMAL -> var11;
               default -> throw new MatchException(null, null);
            };
         }

         float var22 = var1.getArmor();
         float var13 = (float)var1.getAttributeValue(EntityAttributes.ARMOR_TOUGHNESS);
         float var14 = MathHelper.clamp(var22 - var11 / (2.0F + var13 / f_7693), var22 * f_7694, f_7695);
         float var15 = var11 * (1.0F - var14 / f_7696);
         int var16 = 0;

         for (EquipmentSlot var20 : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
            ItemStack var21 = var1.getEquippedStack(var20);
            var16 += O(var1, var21, Enchantments.PROTECTION);
            var16 += O(var1, var21, Enchantments.BLAST_PROTECTION) * 2;
         }

         var16 = MathHelper.clamp(var16, 0, 20);
         var15 *= 1.0F - var16 / f_7697;
         StatusEffectInstance var26 = var1.getStatusEffect(StatusEffects.RESISTANCE);
         if (var26 != null) {
            float var27 = MathHelper.clamp((var26.getAmplifier() + 1) * f_7698, 0.0F, 1.0F);
            var15 *= 1.0F - var27;
         }

         return Math.max(0.0F, var15);
      }
   }

   public static float O(Vec3d var0, LivingEntity var1, Box var2, BlockPos var3) {
      return O(var0, var1, var2, null, var3 == null ? Set.of() : Set.of(var3));
   }

   public static float O(Vec3d var0, LivingEntity var1, Box var2) {
      return O(var0, var1, var2, null, Set.of());
   }

   private static int O(LivingEntity var0, ItemStack var1, RegistryKey<Enchantment> var2) {
      if (var1.isEmpty()) {
         return 0;
      } else {
         try {
            return var0.getRegistryManager()
               .getOrThrow(RegistryKeys.ENCHANTMENT)
               .getOptional(var2)
               .map(var1x -> EnchantmentHelper.getLevel(var1x, var1))
               .orElse(0);
         } catch (RuntimeException var4) {
            return 0;
         }
      }
   }

   public static float O(Vec3d var0, LivingEntity var1) {
      return O(var0, var1, var1.getBoundingBox(), null, Set.of());
   }
}
