package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.text.DecimalFormat;
import java.util.List;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil25;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util158;
import su.energyclient.util.Util169;
import su.energyclient.util.Util63;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;
import su.energyclient.util.Util93;
import su.energyclient.util.math.MathUtil10;

public class Prediction extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Util63 f_12443;
   private final BooleanSetting f_12444;
   private static final DecimalFormat f_12445 = new DecimalFormat(Prediction.f_12534);
   private static final String f_12446 = "Prediction";
   private static final String f_12447 = "Предугадывает куда и за сколько времени упадет предмет";
   private static final String f_12448 = "Снаряды";
   private static final String f_12449 = "Эндер Пёрл";
   private static final String f_12450 = "Стрела";
   private static final String f_12451 = "Трезубец";
   private static final String f_12452 = "Показывать кружок";
   private static final String f_12453 = "Эндер Пёрл";
   private static final String f_12454 = "Стрела";
   private static final String f_12455 = "Трезубец";
   private static final float f_12456 = 0.8F;
   private static final float f_12457 = 0.6F;
   private static final double f_12458 = 0.99F;
   private static final double f_12459 = 0.03;
   private static final double f_12460 = 0.05;
   private static final float f_12461 = Float.MAX_VALUE;
   private static final float f_12462 = Float.MAX_VALUE;
   private static final float f_12463 = 0.05F;
   private static final float f_12464 = 3.0F;
   private static final float f_12465 = 20.0F;
   private static final float f_12466 = 3.0F;
   private static final float f_12467 = 15.5F;
   private static final float f_12468 = 11.0F;
   private static final float f_12469 = 18.0F;
   private static final float f_12470 = 0.5F;
   private static final float f_12471 = 6.0F;
   private static final float f_12472 = 0.5F;
   private static final float f_12473 = 3.0F;
   private static final String f_12474 = "Эндер Пёрл";
   private static final String f_12475 = "Стрела";
   private static final String f_12476 = "Трезубец";
   private static final double f_12477 = 0.8F;
   private static final double f_12478 = 0.99F;
   private static final double f_12479 = 0.03;
   private static final double f_12480 = 0.8F;
   private static final double f_12481 = 0.99F;
   private static final double f_12482 = 0.03;
   private static final float f_12483 = 6.0F;
   private static final float f_12484 = 0.8F;
   private static final float f_12485 = 0.6F;
   private static final double f_12486 = 0.99F;
   private static final double f_12487 = 0.03;
   private static final double f_12488 = 0.05;
   private static final float f_12489 = 6.0F;
   private static final float f_12490 = 6.0F;
   private static final float f_12491 = 0.5F;
   private static final float f_12492 = 0.5F;
   private static final float f_12493 = 255.0F;
   private static final float f_12494 = 255.0F;
   private static final float f_12495 = 255.0F;
   private static final float f_12496 = 255.0F;
   private static final float f_12497 = 255.0F;
   private static final float f_12498 = 255.0F;
   private static final float f_12499 = 255.0F;
   private static final float f_12500 = 255.0F;
   private static final float f_12501 = 1.0E-6F;
   private static final float f_12502 = 3.0F;
   private static final float f_12503 = 3.0F;
   private static final float f_12504 = 0.3F;
   private static final float f_12505 = 255.0F;
   private static final float f_12506 = 255.0F;
   private static final float f_12507 = 255.0F;
   private static final float f_12508 = 90.0F;
   private static final float f_12509 = 90.0F;
   private static final double f_12510 = Math.PI * 2;
   private static final double f_12511 = Math.PI * 2;
   private static final float f_12512 = 1.0E-6F;
   private static final float f_12513 = 1.0E-6F;
   private static final float f_12514 = 3.0F;
   private static final float f_12515 = 3.0F;
   private static final float f_12516 = 3.0F;
   private static final float f_12517 = 3.0F;
   private static final float f_12518 = 3.0F;
   private static final float f_12519 = 3.0F;
   private static final double f_12520 = -1.0;
   private static final double f_12521 = 0.03;
   private static final String f_12522 = "Эндер Пёрл";
   private static final double f_12523 = 1.5;
   private static final double f_12524 = 0.03;
   private static final String f_12525 = "Стрела";
   private static final double f_12526 = 3.0;
   private static final double f_12527 = 0.05;
   private static final String f_12528 = "Трезубец";
   private static final double f_12529 = 2.5;
   private static final double f_12530 = 0.05;
   private static final double f_12531 = 0.8;
   private static final double f_12532 = 0.99;
   private static final float f_12533 = 3.0F;
   private static final String f_12534 = "0.0";

   private void m_601(MatrixStack var1, BufferBuilder var2, Entity var3) {
      Vec3d var4 = var3.getEntityPos();
      Vec3d var5 = var3.getVelocity();
      Matrix4f var7 = var1.peek().getPositionMatrix();
      float var8 = 0.0F;
      float var9 = f_12483;

      for (int var10 = 0; var10 <= 150; var10++) {
         Vec3d var6 = var4;
         var4 = var4.add(var5);
         Vec3d var11;
         if ((var3.isTouchingWater() || f_5909.world.getBlockState(BlockPos.ofFloored(var6)).getBlock() == Blocks.WATER) && !(var3 instanceof TridentEntity)) {
            float var12 = var3 instanceof EnderPearlEntity ? f_12484 : f_12485;
            var11 = var5.multiply(var12);
         } else {
            var11 = var5.multiply(f_12486);
         }

         if (!var3.hasNoGravity()) {
            var11 = new Vec3d(var11.x, var11.y - (var3 instanceof EnderPearlEntity ? f_12487 : f_12488), var11.z);
         }

         var5 = var11;
         RaycastContext var35 = new RaycastContext(var6, var4, ShapeType.COLLIDER, FluidHandling.NONE, f_5909.player);
         BlockHitResult var36 = f_5909.world.raycast(var35);
         if (var36.getType() == Type.BLOCK || var4.y <= 0.0) {
            if (this.f_12444.m_1163() && var36.getType() == Type.BLOCK) {
               this.m_635(var1, var2, var36.getPos(), var36.getSide());
            }
            break;
         }

         float var13 = (float)var6.distanceTo(var4);
         float var14 = this.m_3670(0.0F, f_12489, var8);
         float var15 = this.m_3670(0.0F, f_12490, var8 + var13);
         int var16 = Util71.m_1784(3, var10 * 8, EnergyClient.getTheme(0), Util71.m_2101(EnergyClient.getTheme(0), f_12491));
         int var17 = Util71.m_1784(3, (var10 + 1) * 8, EnergyClient.getTheme(0), Util71.m_2101(EnergyClient.getTheme(0), f_12492));
         int var18 = Util71.m_3765(var16, var14);
         int var19 = Util71.m_3765(var17, var15);
         float var20 = Util71.m_1989(var18) / f_12493;
         float var21 = Util71.m_644(var18) / f_12494;
         float var22 = Util71.m_3163(var18) / f_12495;
         float var23 = Util71.m_2734(var18) / f_12496;
         float var24 = Util71.m_1989(var19) / f_12497;
         float var25 = Util71.m_644(var19) / f_12498;
         float var26 = Util71.m_3163(var19) / f_12499;
         float var27 = Util71.m_2734(var19) / f_12500;
         float var28 = (float)(var4.x - var6.x);
         float var29 = (float)(var4.y - var6.y);
         float var30 = (float)(var4.z - var6.z);
         float var31 = (float)Math.sqrt(var28 * var28 + var29 * var29 + var30 * var30);
         float var32 = 0.0F;
         float var33 = 1.0F;
         float var34 = 0.0F;
         if (var31 > f_12501) {
            var32 = var28 / var31;
            var33 = var29 / var31;
            var34 = var30 / var31;
         }

         var2.vertex(var7, (float)var6.x, (float)var6.y, (float)var6.z)
            .color(var20, var21, var22, var23)
            .normal(var1.peek(), var32, var33, var34)
            .lineWidth(f_12502);
         var2.vertex(var7, (float)var4.x, (float)var4.y, (float)var4.z)
            .color(var24, var25, var26, var27)
            .normal(var1.peek(), var32, var33, var34)
            .lineWidth(f_12503);
         var8 += var13;
      }
   }

   public static Vec3d m_3433(Vec3d var0, Vec3d var1) {
      if (f_5909.world != null && f_5909.player != null) {
         Vec3d var2 = var0;
         Vec3d var3 = var1;
         Vec3d var4 = var0;

         for (int var5 = 0; var5 <= 300; var5++) {
            var4 = var2;
            var2 = var2.add(var3);
            Vec3d var6;
            if (f_5909.world.getBlockState(BlockPos.ofFloored(var2)).getBlock() == Blocks.WATER) {
               var6 = var3.multiply(f_12477);
            } else {
               var6 = var3.multiply(f_12478);
            }

            var6 = new Vec3d(var6.x, var6.y - f_12479, var6.z);
            var3 = var6;
            RaycastContext var7 = new RaycastContext(var4, var2, ShapeType.COLLIDER, FluidHandling.NONE, f_5909.player);
            BlockHitResult var8 = f_5909.world.raycast(var7);
            if (var8.getType() == Type.BLOCK || var2.y <= 0.0) {
               return var8.getPos();
            }
         }

         return var4;
      } else {
         return var0;
      }
   }

   public Prediction() {
      super(f_12446, f_12447, Category.RENDER);
      this.f_12443 = new Util63(f_12448, new BooleanSetting(f_12449, true), new BooleanSetting(f_12450, true), new BooleanSetting(f_12451, true));
      this.f_12444 = new BooleanSetting(f_12452, true);
   }

   private float m_3670(float var1, float var2, float var3) {
      float var4 = MathHelper.clamp((var3 - var1) / (var2 - var1), 0.0F, 1.0F);
      return var4 * var4 * (f_12533 - 2.0F * var4);
   }

   @EventHandler
   public void l(Util88 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         MatrixStack var2 = var1.m_213();
         Vec3d var3 = f_5909.gameRenderer.getCamera().getCameraPos();
         var2.push();
         var2.translate(-var3.x, -var3.y, -var3.z);
         Util114.m_672();
         Util114.m_3978();
         Util114.m_1481();
         Util114.m_3784(RenderUtil7.f_13887);
         Util114.m_2977(f_12473);
         BufferBuilder var4 = Tessellator.getInstance().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR_NORMAL_LINE_WIDTH);

         for (Entity var6 : f_5909.world.getEntities()) {
            if ((
                  var6 instanceof EnderPearlEntity && this.f_12443.I(f_12474)
                     || var6 instanceof ArrowEntity && this.f_12443.I(f_12475)
                     || var6 instanceof TridentEntity && this.f_12443.I(f_12476)
               )
               && (var6.lastY != var6.getY() || var6.lastX != var6.getX() || var6.lastZ != var6.getZ())) {
               this.m_601(var2, var4, var6);
            }
         }

         this.m_1861(var2, var4);
         BuiltBuffer var7 = var4.endNullable();
         if (var7 != null) {
            RenderUtil12.I(var7);
         }

         Util114.m_100();
         Util114.m_1562();
         var2.pop();
      }
   }

   public static Vec3d m_1261(EnderPearlEntity var0) {
      if (f_5909.world != null && var0 != null) {
         Vec3d var1 = var0.getEntityPos();
         Vec3d var2 = var0.getVelocity();
         Vec3d var3 = var1;

         for (int var4 = 0; var4 <= 300; var4++) {
            var3 = var1;
            var1 = var1.add(var2);
            Vec3d var5;
            if (!var0.isTouchingWater() && f_5909.world.getBlockState(BlockPos.ofFloored(var1)).getBlock() != Blocks.WATER) {
               var5 = var2.multiply(f_12481);
            } else {
               var5 = var2.multiply(f_12480);
            }

            if (!var0.hasNoGravity()) {
               var5 = new Vec3d(var5.x, var5.y - f_12482, var5.z);
            }

            var2 = var5;
            RaycastContext var6 = new RaycastContext(var3, var1, ShapeType.COLLIDER, FluidHandling.NONE, (Entity)(f_5909.player == null ? var0 : f_5909.player));
            BlockHitResult var7 = f_5909.world.raycast(var6);
            if (var7.getType() == Type.BLOCK || var1.y <= 0.0) {
               return var7.getPos();
            }
         }

         return var3;
      } else {
         return Vec3d.ZERO;
      }
   }

   private void m_1861(MatrixStack var1, BufferBuilder var2) {
      if (f_5909.player != null && f_5909.world != null && this.f_12444.m_1163()) {
         double var3 = f_12520;
         double var5 = f_12521;

         for (ItemStack var8 : List.of(f_5909.player.getMainHandStack(), f_5909.player.getOffHandStack())) {
            Item var9 = var8.getItem();
            if (var9 == Items.ENDER_PEARL && this.f_12443.I(f_12522)) {
               var3 = f_12523;
               var5 = f_12524;
               break;
            }

            if (var9 instanceof BowItem && this.f_12443.I(f_12525) && f_5909.player.isUsingItem()) {
               float var10 = BowItem.getPullProgress(f_5909.player.getItemUseTime());
               var3 = var10 * f_12526;
               var5 = f_12527;
               break;
            }

            if (var9 == Items.TRIDENT && this.f_12443.I(f_12528)) {
               var3 = f_12529;
               var5 = f_12530;
               break;
            }
         }

         if (!(var3 <= 0.0)) {
            float var17 = f_5909.getRenderTickCounter().getTickProgress(true);
            Vec3d var18 = f_5909.player.getRotationVec(var17);
            Vec3d var19 = f_5909.player.getEyePos();
            Vec3d var20 = var18.multiply(var3);

            for (int var11 = 0; var11 < 300; var11++) {
               Vec3d var12 = var19;
               var19 = var19.add(var20);
               boolean var13 = f_5909.world.getBlockState(BlockPos.ofFloored(var12)).getBlock() == Blocks.WATER;
               double var14 = var13 ? f_12531 : f_12532;
               var20 = var20.multiply(var14).add(0.0, -var5, 0.0);
               BlockHitResult var16 = f_5909.world.raycast(new RaycastContext(var12, var19, ShapeType.COLLIDER, FluidHandling.NONE, f_5909.player));
               if (var16.getType() == Type.BLOCK) {
                  this.m_635(var1, var2, var16.getPos(), var16.getSide());
                  return;
               }

               if (var19.y < f_5909.world.getBottomY() - 16) {
                  return;
               }
            }
         }
      }
   }

   @EventHandler(
      priority = 200
   )
   public void m_984(Util169 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         for (Entity var3 : f_5909.world.getEntities()) {
            if ((
                  var3 instanceof EnderPearlEntity && this.f_12443.I(f_12453)
                     || var3 instanceof ArrowEntity && this.f_12443.I(f_12454)
                     || var3 instanceof TridentEntity && this.f_12443.I(f_12455)
               )
               && (var3.lastY != var3.getY() || var3.lastX != var3.getX() || var3.lastZ != var3.getZ())) {
               Item var4 = var3 instanceof EnderPearlEntity ? Items.ENDER_PEARL : (var3 instanceof ArrowEntity ? Items.ARROW : Items.TRIDENT);
               Vec3d var5 = var3.getEntityPos();
               Vec3d var6 = var3.getVelocity();
               Vec3d var7 = var5;
               int var8 = 0;

               for (int var9 = 0; var9 <= 150; var9++) {
                  var8++;
                  var7 = var5;
                  var5 = var5.add(var6);
                  Vec3d var10;
                  if ((var3.isTouchingWater() || f_5909.world.getBlockState(BlockPos.ofFloored(var5)).getBlock() == Blocks.WATER)
                     && !(var3 instanceof TridentEntity)) {
                     float var11 = var3 instanceof EnderPearlEntity ? f_12456 : f_12457;
                     var10 = var6.multiply(var11);
                  } else {
                     var10 = var6.multiply(f_12458);
                  }

                  if (!var3.hasNoGravity()) {
                     var10 = new Vec3d(var10.x, var10.y - (var3 instanceof EnderPearlEntity ? f_12459 : f_12460), var10.z);
                  }

                  var6 = var10;
                  RaycastContext var16 = new RaycastContext(var7, var5, ShapeType.COLLIDER, FluidHandling.NONE, f_5909.player);
                  BlockHitResult var18 = f_5909.world.raycast(var16);
                  if (var18.getType() == Type.BLOCK || var5.y <= 0.0) {
                     break;
                  }
               }

               Vector2f var15 = MathUtil10.m_2788(var7.x, var7.y, var7.z, false);
               if (var15.x != f_12461 || var15.y != f_12462) {
                  float var17 = var8 * f_12463;
                  float var19 = var15.x;
                  float var12 = var15.y + f_12464;
                  String var13 = f_12445.format(var17) + " сек.";
                  float var14 = Util93.f_6001[14].m_585(var13);
                  RenderUtil25.m_1557(var1.m_4037(), var19 - f_12465, var12 - f_12466, var14 + f_12467, f_12468, Util71.m_756(0, 0, 0, 120));
                  Util158.m_1974(var1.m_4037(), new ItemStack(var4), var19 - f_12469, var12 - 2.0F, f_12470, -1, 1.0F);
                  Util93.f_6001[14].m_2915(var1.m_4037(), var13, var19 - var14 / 2.0F + f_12471, var12 + f_12472, -1);
               }
            }
         }
      }
   }

   private void m_635(MatrixStack var1, BufferBuilder var2, Vec3d var3, Direction var4) {
      float var5 = f_12504;
      byte var6 = 64;
      int var7 = EnergyClient.getTheme(0);
      float var8 = Util71.m_1989(var7) / f_12505;
      float var9 = Util71.m_644(var7) / f_12506;
      float var10 = Util71.m_3163(var7) / f_12507;
      var1.push();
      var1.translate(var3.x, var3.y, var3.z);
      if (var4 == Direction.WEST || var4 == Direction.EAST) {
         var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_12508));
      } else if (var4 == Direction.SOUTH || var4 == Direction.NORTH) {
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_12509));
      }

      Matrix4f var11 = var1.peek().getPositionMatrix();

      for (int var12 = 0; var12 < var6; var12++) {
         double var13 = f_12510 * var12 / var6;
         double var15 = f_12511 * (var12 + 1) / var6;
         float var17 = (float)(Math.cos(var13) * var5);
         float var18 = (float)(Math.sin(var13) * var5);
         float var19 = (float)(Math.cos(var15) * var5);
         float var20 = (float)(Math.sin(var15) * var5);
         float var21 = var19 - var17;
         float var22 = var20 - var18;
         float var23 = (float)Math.sqrt(var21 * var21 + var22 * var22);
         float var24 = var23 > f_12512 ? var21 / var23 : 0.0F;
         float var25 = var23 > f_12513 ? var22 / var23 : 0.0F;
         var2.vertex(var11, var17, 0.0F, var18).color(var8, var9, var10, 1.0F).normal(var1.peek(), var24, 0.0F, var25).lineWidth(f_12514);
         var2.vertex(var11, var19, 0.0F, var20).color(var8, var9, var10, 1.0F).normal(var1.peek(), var24, 0.0F, var25).lineWidth(f_12515);
      }

      var2.vertex(var11, -var5, 0.0F, 0.0F).color(var8, var9, var10, 1.0F).normal(var1.peek(), 1.0F, 0.0F, 0.0F).lineWidth(f_12516);
      var2.vertex(var11, var5, 0.0F, 0.0F).color(var8, var9, var10, 1.0F).normal(var1.peek(), 1.0F, 0.0F, 0.0F).lineWidth(f_12517);
      var2.vertex(var11, 0.0F, 0.0F, -var5).color(var8, var9, var10, 1.0F).normal(var1.peek(), 0.0F, 0.0F, 1.0F).lineWidth(f_12518);
      var2.vertex(var11, 0.0F, 0.0F, var5).color(var8, var9, var10, 1.0F).normal(var1.peek(), 0.0F, 0.0F, 1.0F).lineWidth(f_12519);
      var1.pop();
   }
}
