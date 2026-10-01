package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.ChestMinecartEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util170;
import su.energyclient.util.Util88;

public class BlockEsp extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_2418;
   private final BooleanSetting f_2419;
   private final BooleanSetting f_2420;
   private final BooleanSetting f_2421;
   private final BooleanSetting f_2422;
   private final BooleanSetting l;
   private final BooleanSetting f_2423;
   private final BooleanSetting f_2424;
   private final BooleanSetting f_2425;
   private final List<BlockEsp.koc8Ole6Np52jQxN> f_2426;
   private int f_2427;
   private static final String f_2428 = "Block ESP";
   private static final String f_2429 = "Подсвечивает блоки через стены";
   private static final String f_2430 = "Радиус";
   private static final float f_2431 = 32.0F;
   private static final float O7 = 8.0F;
   private static final float O9 = 48.0F;
   private static final String f_2432 = "Заливка";
   private static final String O4 = "Сундуки";
   private static final String f_2433 = "Вагонетки с сундуком";
   private static final String f_2434 = "Шалкеры";
   private static final String f_2435 = "Спавнеры";
   private static final String f_2436 = "Порталы";
   private static final String f_2437 = "Кровати";
   private static final String f_2438 = "Руды";
   private static final int f_2439 = -7667457;
   private static final int f_2440 = -3308225;
   private static final int f_2441 = -60269;
   private static final int f_2442 = -16728065;
   private static final int f_2443 = -6606593;
   private static final int f_2444 = -16724271;
   private static final int O3 = -38476;
   private static final int f_2445 = -16711681;
   private static final int f_2446 = -16711936;
   private static final int f_2447 = -47872;
   private static final int f_2448 = -2987746;
   private static final int f_2449 = -16777011;
   private static final int OO = -65536;
   private static final int f_2450 = -11184811;
   private static final int f_2451 = -1606570;
   private static final float f_2452 = 255.0F;
   private static final float f_2453 = 255.0F;
   private static final float f_2454 = 255.0F;
   private static final float f_2455 = 0.15F;
   private static final float f_2456 = 1.5F;
   private static final float f_2457 = 255.0F;
   private static final float f_2458 = 255.0F;
   private static final float f_2459 = 255.0F;
   private static final float f_2460 = 0.8F;

   public BlockEsp() {
      super(f_2428, f_2429, Category.RENDER);
      this.f_2418 = new NumberSetting(f_2430, f_2431, O7, O9, 1.0F);
      this.f_2419 = new BooleanSetting(f_2432, true);
      this.f_2420 = new BooleanSetting(O4, true);
      this.f_2421 = new BooleanSetting(f_2433, true);
      this.f_2422 = new BooleanSetting(f_2434, true);
      this.l = new BooleanSetting(f_2435, true);
      this.f_2423 = new BooleanSetting(f_2436, false);
      this.f_2424 = new BooleanSetting(f_2437, false);
      this.f_2425 = new BooleanSetting(f_2438, false);
      this.f_2426 = new ArrayList<>();
      this.f_2427 = 0;
   }

   private int m_3437(Block var1) {
      if (this.f_2420.m_1163()) {
         if (var1 == Blocks.CHEST || var1 == Blocks.TRAPPED_CHEST) {
            return -22016;
         }

         if (var1 == Blocks.ENDER_CHEST) {
            return f_2439;
         }

         if (var1 == Blocks.BARREL) {
            return f_2440;
         }
      }

      if (this.f_2422.m_1163() && var1 instanceof ShulkerBoxBlock) {
         return f_2441;
      } else if (this.l.m_1163() && var1 == Blocks.SPAWNER) {
         return f_2442;
      } else {
         if (this.f_2423.m_1163()) {
            if (var1 == Blocks.NETHER_PORTAL) {
               return f_2443;
            }

            if (var1 == Blocks.END_PORTAL || var1 == Blocks.END_PORTAL_FRAME) {
               return f_2444;
            }
         }

         if (this.f_2424.m_1163() && var1 instanceof BedBlock) {
            return O3;
         } else {
            if (this.f_2425.m_1163()) {
               if (var1 == Blocks.DIAMOND_ORE || var1 == Blocks.DEEPSLATE_DIAMOND_ORE) {
                  return f_2445;
               }

               if (var1 == Blocks.EMERALD_ORE || var1 == Blocks.DEEPSLATE_EMERALD_ORE) {
                  return f_2446;
               }

               if (var1 == Blocks.ANCIENT_DEBRIS) {
                  return f_2447;
               }

               if (var1 == Blocks.GOLD_ORE || var1 == Blocks.DEEPSLATE_GOLD_ORE || var1 == Blocks.NETHER_GOLD_ORE) {
                  return -10496;
               }

               if (var1 == Blocks.IRON_ORE || var1 == Blocks.DEEPSLATE_IRON_ORE) {
                  return f_2448;
               }

               if (var1 == Blocks.LAPIS_ORE || var1 == Blocks.DEEPSLATE_LAPIS_ORE) {
                  return f_2449;
               }

               if (var1 == Blocks.REDSTONE_ORE || var1 == Blocks.DEEPSLATE_REDSTONE_ORE) {
                  return OO;
               }

               if (var1 == Blocks.COAL_ORE || var1 == Blocks.DEEPSLATE_COAL_ORE) {
                  return f_2450;
               }

               if (var1 == Blocks.COPPER_ORE || var1 == Blocks.DEEPSLATE_COPPER_ORE) {
                  return f_2451;
               }
            }

            return 0;
         }
      }
   }

   private void m_461(
      BufferBuilder var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      var1.vertex(var2, var3, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var8).color(var9, var10, var11, var12);
   }

   @EventHandler
   private void m_4133(Util170 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         if (++this.f_2427 >= 5) {
            this.f_2427 = 0;
            int var2 = this.f_2418.m_134().intValue();
            BlockPos var3 = f_5909.player.getBlockPos();
            this.f_2426.clear();

            for (int var4 = -var2; var4 <= var2; var4++) {
               for (int var5 = -var2; var5 <= var2; var5++) {
                  for (int var6 = -var2; var6 <= var2; var6++) {
                     BlockPos var7 = var3.add(var4, var5, var6);
                     if (f_5909.world.isChunkLoaded(var7.getX() >> 4, var7.getZ() >> 4)) {
                        Block var8 = f_5909.world.getBlockState(var7).getBlock();
                        int var9 = this.m_3437(var8);
                        if (var9 != 0) {
                           Box var10 = new Box(var7.getX(), var7.getY(), var7.getZ(), var7.getX() + 1, var7.getY() + 1, var7.getZ() + 1);
                           this.f_2426.add(new BlockEsp.koc8Ole6Np52jQxN(var10, var9));
                        }
                     }
                  }
               }
            }

            if (this.f_2421.m_1163()) {
               Box var11 = f_5909.player.getBoundingBox().expand(var2);

               for (ChestMinecartEntity var13 : f_5909.world.getEntitiesByClass(ChestMinecartEntity.class, var11, Entity::isAlive)) {
                  this.f_2426.add(new BlockEsp.koc8Ole6Np52jQxN(var13.getBoundingBox(), -10496));
               }
            }
         }
      } else {
         this.f_2426.clear();
      }
   }

   @EventHandler
   private void m_1446(Util88 var1) {
      if (f_5909.world != null && f_5909.player != null && !this.f_2426.isEmpty()) {
         Camera var2 = f_5909.gameRenderer.getCamera();
         Vec3d var3 = var2.getCameraPos();
         Matrix4f var4 = var1.m_213().peek().getPositionMatrix();
         boolean var5 = this.f_2419.m_1163();
         Util114.m_1481();
         Util114.m_542();
         Util114.m_3978();
         Util114.m_672();
         Util114.m_1878(false);
         Util114.m_3784(RenderUtil7.f_13885);
         if (var5) {
            BufferBuilder var6 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

            for (BlockEsp.koc8Ole6Np52jQxN var8 : this.f_2426) {
               float var9 = (float)(var8.box.minX - var3.x);
               float var10 = (float)(var8.box.minY - var3.y);
               float var11 = (float)(var8.box.minZ - var3.z);
               float var12 = (float)(var8.box.maxX - var3.x);
               float var13 = (float)(var8.box.maxY - var3.y);
               float var14 = (float)(var8.box.maxZ - var3.z);
               int var15 = var8.color;
               float var16 = (var15 >> 16 & 0xFF) / f_2452;
               float var17 = (var15 >> 8 & 0xFF) / f_2453;
               float var18 = (var15 & 0xFF) / f_2454;
               this.m_461(var6, var4, var9, var10, var11, var12, var13, var14, var16, var17, var18, f_2455);
            }

            RenderUtil12.I(var6.end());
         }

         Util114.m_2977(f_2456);
         BufferBuilder var19 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

         for (BlockEsp.koc8Ole6Np52jQxN var21 : this.f_2426) {
            float var22 = (float)(var21.box.minX - var3.x);
            float var23 = (float)(var21.box.minY - var3.y);
            float var24 = (float)(var21.box.minZ - var3.z);
            float var25 = (float)(var21.box.maxX - var3.x);
            float var26 = (float)(var21.box.maxY - var3.y);
            float var27 = (float)(var21.box.maxZ - var3.z);
            int var28 = var21.color;
            float var29 = (var28 >> 16 & 0xFF) / f_2457;
            float var30 = (var28 >> 8 & 0xFF) / f_2458;
            float var31 = (var28 & 0xFF) / f_2459;
            this.m_1096(var19, var4, var22, var23, var24, var25, var26, var27, var29, var30, var31, f_2460);
         }

         RenderUtil12.I(var19.end());
         Util114.m_2977(1.0F);
         Util114.m_100();
         Util114.m_1878(true);
         Util114.m_1562();
         Util114.m_963();
      }
   }

   @Override
   public void m_1() {
      this.f_2426.clear();
      this.f_2427 = 0;
      super.m_1();
   }

   private void m_1096(
      BufferBuilder var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      var1.vertex(var2, var3, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var6, var7, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var8).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var7, var8).color(var9, var10, var11, var12);
   }

   private record koc8Ole6Np52jQxN(Box box, int color) {
   }
}
