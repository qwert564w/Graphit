package su.energyclient.util;

import com.google.common.collect.UnmodifiableIterator;
import it.unimi.dsi.fastutil.doubles.DoubleListIterator;
import java.util.List;
import java.util.TreeSet;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;

public final class Util17 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_3071 = 1000;
   private final ClientPlayerEntity l;
   private final World f_3072;
   private final Vec3d f_3073;
   private final float f_3074;
   private Box f_3075;
   private Vec3d f_3076;
   private boolean f_3077;
   private double f_3078;
   private static final int f_3079 = Integer.MAX_VALUE;
   private static final double f_3080 = 0.01;
   private static final double f_3081 = -0.500001F;
   private static final float f_3082 = 0.91F;
   private static final float f_3083 = 0.21600002F;
   private static final float f_3084 = 0.025999999F;
   private static final float f_3085 = 0.02F;
   private static final float f_3086 = 0.9F;
   private static final float f_3087 = 0.8F;
   private static final float f_3088 = 0.02F;
   private static final float f_3089 = 0.5F;
   private static final float f_3090 = 0.54600006F;
   private static final float f_3091 = 0.96F;
   private static final float f_3092 = 0.02F;
   private static final double f_3093 = -0.15F;
   private static final double f_3094 = -0.15F;
   private static final double f_3095 = 0.15F;
   private static final double f_3096 = -0.15F;
   private static final double f_3097 = 0.15F;
   private static final double f_3098 = 0.2;
   private static final double f_3099 = -0.500001F;
   private static final double f_3100 = 0.8F;
   private static final double f_3101 = 0.5;
   private static final double f_3102 = 0.8F;
   private static final double f_3103 = 0.5;
   private static final double f_3104 = 0.5;
   private static final double f_3105 = 0.5;
   private static final double f_3106 = 0.5;
   private static final double f_3107 = 4.0;
   private static final double f_3108 = 0.05;
   private static final double f_3109 = 0.2;
   private static final double f_3110 = -0.1;
   private static final double f_3111 = 0.98F;
   private static final double f_3112 = 1.0E-7;
   private static final float f_3113 = (float) (Math.PI / 180.0);
   private static final float f_3114 = (float) (Math.PI / 180.0);
   private static final double f_3115 = 0.005;
   private static final double f_3116 = 0.003;
   private static final double f_3117 = 16.0;
   private static final double f_3118 = 0.003;
   private static final double f_3119 = -0.003;
   private static final double f_3120 = 16.0;
   private static final double f_3121 = -1.0E-5F;
   private static final double f_3122 = 0.5;
   private static final double f_3123 = 0.5;
   private static final double f_3124 = 0.001;

   private double m_2605(TagKey<Fluid> var1) {
      Box var2 = this.f_3075.contract(f_3124);
      double var3 = 0.0;

      for (BlockPos var6 : BlockPos.iterate(
         MathHelper.floor(var2.minX),
         MathHelper.floor(var2.minY),
         MathHelper.floor(var2.minZ),
         MathHelper.ceil(var2.maxX) - 1,
         MathHelper.ceil(var2.maxY) - 1,
         MathHelper.ceil(var2.maxZ) - 1
      )) {
         FluidState var7 = this.f_3072.getFluidState(var6);
         if (var7.isIn(var1)) {
            double var8 = var6.getY() + var7.getHeight(this.f_3072, var6);
            if (var8 >= var2.minY) {
               var3 = Math.max(var3, var8 - var2.minY);
            }
         }
      }

      return var3;
   }

   private BlockPos m_935(double var1) {
      return BlockPos.ofFloored((this.f_3075.minX + this.f_3075.maxX) * f_3122, this.f_3075.minY + var1, (this.f_3075.minZ + this.f_3075.maxZ) * f_3123);
   }

   public void m_3847(int var1) {
      for (int var2 = 0; var2 < Math.min(var1, 1000); var2++) {
         this.m_2677();
      }
   }

   public int m_2196() {
      return this.m_4039(f_3079);
   }

   private Vec3d m_3657(Vec3d var1) {
      Vec3d var2 = Entity.adjustMovementForCollisions(
         this.l, var1, this.f_3075, this.f_3072, this.f_3072.getEntityCollisions(this.l, this.f_3075.stretch(var1))
      );
      boolean var3 = var1.y != var2.y && var1.y < 0.0;
      float var4 = this.l.getStepHeight();
      if (!(var4 <= 0.0F) && (var3 || this.f_3077) && (var1.x != var2.x || var1.z != var2.z)) {
         Box var5 = var3 ? this.f_3075.offset(0.0, var2.y, 0.0) : this.f_3075;
         Box var6 = var5.stretch(var1.x, var4, var1.z);
         if (!var3) {
            var6 = var6.stretch(0.0, f_3121, 0.0);
         }

         List<VoxelShape> var7 = Entity.findCollisions(this.l, this.f_3072, var6);
         TreeSet<Float> var8 = new TreeSet<>();

         for (VoxelShape var10 : var7) {
            DoubleListIterator var11 = var10.getPointPositions(Axis.Y).iterator();

            while (var11.hasNext()) {
               double var12 = (Double)var11.next();
               float var14 = (float)(var12 - var5.minY);
               if (var14 >= 0.0F && var14 <= var4 && var14 != (float)var2.y) {
                  var8.add(var14);
               }
            }
         }

         for (float var18 : var8) {
            Vec3d var19 = new Vec3d(var1.x, var18, var1.z);
            Vec3d var20 = Vec3d.ZERO;
            UnmodifiableIterator var13 = Direction.getCollisionOrder(var19).iterator();

            while (var13.hasNext()) {
               Axis var21 = (Axis)var13.next();
               double var15 = VoxelShapes.calculateMaxOffset(var21, var5.offset(var20), var7, var19.getComponentAlongAxis(var21));
               var20 = var20.withAxis(var21, var15);
            }

            if (var20.horizontalLengthSquared() > var2.horizontalLengthSquared()) {
               return var20.subtract(0.0, this.f_3075.minY - var5.minY, 0.0);
            }
         }

         return var2;
      } else {
         return var2;
      }
   }

   public boolean m_3146() {
      return this.f_3077;
   }

   public int m_4039(int var1) {
      int var2 = 0;

      for (int var3 = 0; !this.f_3077 && var3 < 1000 && var2 < var1; var3++) {
         double var4 = this.f_3078;
         this.m_2677();
         if (this.f_3078 != 0.0 && this.f_3078 != var4) {
            var2++;
         }
      }

      return var2;
   }

   public Util17(ClientPlayerEntity var1) {
      this.l = var1;
      this.f_3072 = var1.getEntityWorld();
      this.f_3075 = var1.getBoundingBox();
      this.f_3076 = var1.getVelocity();
      this.f_3077 = var1.isOnGround();
      this.f_3078 = var1.fallDistance;
      this.f_3073 = new Vec3d(var1.sidewaysSpeed, var1.upwardSpeed, var1.forwardSpeed);
      this.f_3074 = var1.getYaw();
   }

   private Vec3d m_3809(Vec3d var1, double var2, boolean var4) {
      if (var2 != 0.0 && !this.l.isSprinting()) {
         double var5 = var4 && Math.abs(var1.y - f_3115) >= f_3116 && Math.abs(var1.y - var2 / f_3117) < f_3118 ? f_3119 : var1.y - var2 / f_3120;
         return new Vec3d(var1.x, var5, var1.z);
      } else {
         return var1;
      }
   }

   private void m_2677() {
      double var1 = this.m_2605(FluidTags.WATER);
      double var3 = this.m_2605(FluidTags.LAVA);
      boolean var5 = var1 > 0.0;
      boolean var6 = var3 > 0.0;
      boolean var7 = this.f_3076.y <= 0.0;
      double var8 = this.l.getFinalGravity();
      if (var7 && this.l.hasStatusEffect(StatusEffects.SLOW_FALLING)) {
         var8 = Math.min(var8, f_3080);
      }

      BlockPos var10 = this.m_935(f_3081);
      float var11 = this.f_3077 ? this.f_3072.getBlockState(var10).getBlock().getSlipperiness() : 1.0F;
      float var12 = var11 * f_3082;
      float var13 = this.f_3077 ? this.l.getMovementSpeed() * (f_3083 / (var11 * var11 * var11)) : (this.l.isSprinting() ? f_3084 : f_3085);
      if (var5) {
         var12 = this.l.isSprinting() ? f_3086 : f_3087;
         var13 = f_3088;
         float var14 = (float)this.l.getAttributeValue(EntityAttributes.WATER_MOVEMENT_EFFICIENCY);
         if (!this.f_3077) {
            var14 *= f_3089;
         }

         if (var14 > 0.0F) {
            var12 += (f_3090 - var12) * var14;
            var13 += (this.l.getMovementSpeed() - var13) * var14;
         }

         if (this.l.hasStatusEffect(StatusEffects.DOLPHINS_GRACE)) {
            var12 = f_3091;
         }
      } else if (var6) {
         var13 = f_3092;
      }

      this.f_3076 = this.f_3076.add(this.m_330(var13));
      boolean var27 = this.f_3072.getBlockState(this.m_935(0.0)).isIn(BlockTags.CLIMBABLE);
      if (!var5 && !var6 && var27) {
         this.f_3078 = 0.0;
         double var15 = Math.max(this.f_3076.y, f_3093);
         if (var15 < 0.0 && this.l.isSneaking() && !this.f_3072.getBlockState(this.m_935(0.0)).isOf(Blocks.SCAFFOLDING)) {
            var15 = 0.0;
         }

         this.f_3076 = new Vec3d(MathHelper.clamp(this.f_3076.x, f_3094, f_3095), var15, MathHelper.clamp(this.f_3076.z, f_3096, f_3097));
      }

      Vec3d var28 = this.f_3076;
      Vec3d var16 = this.m_3657(var28);
      this.f_3075 = this.f_3075.offset(var16);
      boolean var17 = !MathHelper.approximatelyEquals(var28.x, var16.x) || !MathHelper.approximatelyEquals(var28.z, var16.z);
      boolean var18 = var28.y != var16.y;
      this.f_3077 = var18 && var28.y < 0.0;
      if (this.f_3077 || this.m_2605(FluidTags.WATER) > 0.0) {
         this.f_3078 = 0.0;
      } else if (var16.y < 0.0) {
         this.f_3078 = this.f_3078 - (float)var16.y;
      }

      double var19 = MathHelper.approximatelyEquals(var28.x, var16.x) ? this.f_3076.x : 0.0;
      double var21 = var18 ? 0.0 : this.f_3076.y;
      double var23 = MathHelper.approximatelyEquals(var28.z, var16.z) ? this.f_3076.z : 0.0;
      if (var27 && (var17 || this.l.input.playerInput.jump())) {
         var21 = f_3098;
      }

      float var25 = this.f_3072.getBlockState(this.m_935(0.0)).getBlock().getVelocityMultiplier();
      if (var25 == 1.0F && !var5) {
         var25 = this.f_3072.getBlockState(this.m_935(f_3099)).getBlock().getVelocityMultiplier();
      }

      var19 *= var25;
      var23 *= var25;
      if (!var5 && !var6) {
         StatusEffectInstance var26 = this.l.getStatusEffect(StatusEffects.LEVITATION);
         if (var26 != null) {
            var21 += (f_3108 * (var26.getAmplifier() + 1) - var21) * f_3109;
         } else if (this.f_3072.isChunkLoaded(var10)) {
            var21 -= var8;
         } else {
            var21 = this.f_3075.minY > this.f_3072.getBottomY() ? f_3110 : 0.0;
         }

         this.f_3076 = this.l.hasNoDrag() ? new Vec3d(var19, var21, var23) : new Vec3d(var19 * var12, var21 * f_3111, var23 * var12);
      } else {
         if (var5) {
            this.f_3076 = new Vec3d(var19 * var12, var21 * f_3100, var23 * var12);
            this.f_3076 = this.m_3809(this.f_3076, var8, var7);
         } else if (var3 <= this.l.getSwimHeight()) {
            this.f_3076 = this.m_3809(new Vec3d(var19 * f_3101, var21 * f_3102, var23 * f_3103), var8, var7);
         } else {
            this.f_3076 = new Vec3d(var19 * f_3104, var21 * f_3105, var23 * f_3106);
         }

         if (var6) {
            this.f_3076 = this.f_3076.add(0.0, -var8 / f_3107, 0.0);
         }
      }
   }

   public double m_3632() {
      return this.f_3078;
   }

   private Vec3d m_330(float var1) {
      double var2 = this.f_3073.lengthSquared();
      if (var2 < f_3112) {
         return Vec3d.ZERO;
      } else {
         Vec3d var4 = (var2 > 1.0 ? this.f_3073.normalize() : this.f_3073).multiply(var1);
         float var5 = MathHelper.sin(this.f_3074 * f_3113);
         float var6 = MathHelper.cos(this.f_3074 * f_3114);
         return new Vec3d(var4.x * var6 - var4.z * var5, var4.y, var4.z * var6 + var4.x * var5);
      }
   }
}
