package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.util.Util114;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;
import su.energyclient.util.Util24;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;
import su.energyclient.util.Util98;
import su.energyclient.util.math.MathUtil6;

public class BlockHighlight extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Util165 f_2469;
   private final Util165 f_2470;
   private final Util165 O;
   private final Util165 f_2471;
   private final Util165 f_2472;
   private final Util165 f_2473;
   private final Util165 f_2474;
   private boolean f_2475;
   private static final String f_2476 = "Block HighLight";
   private static final long f_2477 = 150L;
   private static final long f_2478 = 150L;
   private static final long f_2479 = 150L;
   private static final long f_2480 = 150L;
   private static final long f_2481 = 150L;
   private static final long f_2482 = 150L;
   private static final long f_2483 = 180L;
   private static final float f_2484 = 0.01F;
   private static final double f_2485 = 0.002;
   private static final int f_2486 = 32969;
   private static final int f_2487 = 32968;
   private static final int f_2488 = 32971;
   private static final int f_2489 = 32970;
   private static final float f_2490 = 0.58F;
   private static final float f_2491 = 0.34F;
   private static final String f_2492 = "time";
   private static final String f_2493 = "alpha";
   private static final String f_2494 = "baseColor";
   private static final float f_2495 = 255.0F;
   private static final float f_2496 = 255.0F;
   private static final float f_2497 = 255.0F;
   private static final String f_2498 = "accentColor";
   private static final float f_2499 = 255.0F;
   private static final float f_2500 = 255.0F;
   private static final float f_2501 = 255.0F;
   private static final String f_2502 = "softness";
   private static final float f_2503 = 0.08F;
   private static final float f_2504 = 222.0F;
   private static final float f_2505 = 190.0F;
   private static final float f_2506 = 0.78F;
   private static final float f_2507 = 160.0F;
   private static final float f_2508 = 0.74F;
   private static final float f_2509 = 0.26F;
   private static final float f_2510 = 2.15F;
   private static final double f_2511 = 2.0;
   private static final float f_2512 = 125.0F;
   private static final float f_2513 = 240.0F;
   private static final float f_2514 = 0.52F;
   private static final float f_2515 = 58.0F;
   private static final float f_2516 = 2.3F;
   private static final float f_2517 = 1.35F;
   private static final float f_2518 = 255.0F;
   private static final float f_2519 = 255.0F;
   private static final float f_2520 = 255.0F;
   private static final float f_2521 = 255.0F;
   private static final float f_2522 = 255.0F;
   private static final float f_2523 = 255.0F;
   private static final float f_2524 = 255.0F;
   private static final float f_2525 = 255.0F;
   private static final float f_2526 = 20.0F;
   private static final long f_2527 = 100000L;
   private static final float f_2528 = 1000.0F;

   private float m_163(float var1) {
      return f_5909.world != null ? ((float)f_5909.world.getTime() + var1) / f_2526 : (float)(System.currentTimeMillis() % f_2527) / f_2528;
   }

   public BlockHighlight() {
      super(f_2476, "", Category.RENDER);
      this.f_2469 = new Util165(Util153.EASE_OUT_CUBIC, f_2477);
      this.f_2470 = new Util165(Util153.EASE_OUT_CUBIC, f_2478);
      this.O = new Util165(Util153.EASE_OUT_CUBIC, f_2479);
      this.f_2471 = new Util165(Util153.EASE_OUT_CUBIC, f_2480);
      this.f_2472 = new Util165(Util153.EASE_OUT_CUBIC, f_2481);
      this.f_2473 = new Util165(Util153.EASE_OUT_CUBIC, f_2482);
      this.f_2474 = new Util165(Util153.EASE_OUT_CUBIC, f_2483);
      this.I(this.f_2474, 0.0);
   }

   private void I(BufferBuilder var1, Matrix4f var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      float var10 = Util71.m_1989(var9) / f_2522;
      float var11 = Util71.m_644(var9) / f_2523;
      float var12 = Util71.m_3163(var9) / f_2524;
      float var13 = Util71.m_2734(var9) / f_2525;
      var1.vertex(var2, var3, var4, var5).color(var10, var11, var12, var13);
      var1.vertex(var2, var6, var7, var8).color(var10, var11, var12, var13);
   }

   private void I(Box var1) {
      this.f_2469.m_3631(var1.minX);
      this.f_2470.m_3631(var1.minY);
      this.O.m_3631(var1.minZ);
      this.f_2471.m_3631(var1.maxX);
      this.f_2472.m_3631(var1.maxY);
      this.f_2473.m_3631(var1.maxZ);
   }

   private Box I() {
      if (f_5909.crosshairTarget instanceof BlockHitResult var1) {
         if (var1.getType() != Type.BLOCK) {
            return null;
         } else {
            BlockPos var5 = var1.getBlockPos();
            if (var5 != null && f_5909.world != null) {
               BlockState var3 = f_5909.world.getBlockState(var5);
               VoxelShape var4 = var3.getOutlineShape(f_5909.world, var5);
               return var4.isEmpty() ? null : var4.getBoundingBox().offset(var5).expand(f_2485);
            } else {
               return null;
            }
         }
      } else {
         return null;
      }
   }

   private void m_2331(MatrixStack var1, Box var2, float var3, float var4) {
      Vec3d var5 = f_5909.gameRenderer.getCamera().getCameraPos();
      Box var6 = var2.offset(-var5.x, -var5.y, -var5.z);
      Util114.m_1481();
      Util114.m_1206(770, 1, 1, 771);
      Util114.m_100();
      Util114.m_3978();
      Util114.m_1878(false);
      Util98 var7 = Util114.m_827(Util24.f_3274);
      if (var7 != null) {
         int var8 = EnergyClient.getTheme(0);
         int var9 = EnergyClient.getTheme(90);
         int var10 = Util71.m_2924(Util71.m_2101(var8, f_2490), var9, f_2491);
         int var11 = Util71.m_3793(var9, 30);
         this.m_1140(var7, f_2492, this.m_163(var4));
         this.m_1140(var7, f_2493, var3);
         this.m_1140(var7, f_2494, Util71.m_1989(var10) / f_2495, Util71.m_644(var10) / f_2496, Util71.m_3163(var10) / f_2497, 1.0F);
         this.m_1140(var7, f_2498, Util71.m_1989(var11) / f_2499, Util71.m_644(var11) / f_2500, Util71.m_3163(var11) / f_2501, 1.0F);
         this.m_1140(var7, f_2502, f_2503);
      }

      Util114.m_3784(Util24.f_3274);
      int var15 = EnergyClient.getTheme(0);
      int var16 = EnergyClient.getTheme(90);
      int var17 = Util71.m_3389(Util71.m_3793(var16, 36), (int)(var3 * f_2504));
      int var18 = Util71.m_3389(var15, (int)(var3 * f_2505));
      int var12 = Util71.m_3389(Util71.m_2101(var15, f_2506), (int)(var3 * f_2507));
      BufferBuilder var13 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      Matrix4f var14 = var1.peek().getPositionMatrix();
      this.I(var13, var14, var6, var17, var18, var12);
      RenderUtil12.I(var13.end());
      Util114.m_1878(true);
      Util114.m_1562();
      Util114.m_542();
      Util114.m_963();
   }

   private void m_1209(MatrixStack var1, Box var2, float var3, float var4) {
      Vec3d var5 = f_5909.gameRenderer.getCamera().getCameraPos();
      Box var6 = var2.offset(-var5.x, -var5.y, -var5.z);
      float var7 = this.m_163(var4);
      float var8 = f_2508 + f_2509 * (float)Math.sin(var7 * f_2510 + (float)((var2.minX + var2.minZ) * f_2511));
      int var9 = EnergyClient.getTheme(0);
      int var10 = EnergyClient.getTheme(90);
      int var11 = Util71.m_3389(Util71.m_3793(var10, 88), (int)(var3 * var8 * f_2512));
      int var12 = Util71.m_3389(Util71.m_3793(var10, 62), (int)(var3 * var8 * f_2513));
      int var13 = Util71.m_3389(Util71.m_2924(var9, var10, f_2514), (int)(var3 * var8 * f_2515));
      Util114.m_1481();
      Util114.m_100();
      Util114.m_3978();
      Util114.m_1878(false);
      Util114.m_3784(RenderUtil7.f_13885);
      Matrix4f var14 = var1.peek().getPositionMatrix();
      Util114.m_1206(770, 1, 0, 1);
      this.I(var14, var6, var13);
      Util114.m_2977(f_2516);
      this.m_3971(var14, var6, var11);
      Util114.m_1206(770, 771, 1, 771);
      Util114.m_2977(f_2517);
      this.m_3971(var14, var6, var12);
      Util114.m_2977(1.0F);
      Util114.m_1878(true);
      Util114.m_1562();
      Util114.m_542();
      Util114.m_963();
   }

   private void I(BufferBuilder var1, Matrix4f var2, Box var3, int var4, int var5, int var6) {
      float var7 = (float)var3.minX;
      float var8 = (float)var3.minY;
      float var9 = (float)var3.minZ;
      float var10 = (float)var3.maxX;
      float var11 = (float)var3.maxY;
      float var12 = (float)var3.maxZ;
      this.I(var1, var2, var7, var11, var9, var10, var11, var9, var10, var11, var12, var7, var11, var12, var4);
      this.I(var1, var2, var7, var8, var12, var10, var8, var12, var10, var8, var9, var7, var8, var9, var6);
      this.I(var1, var2, var7, var8, var9, var10, var8, var9, var10, var11, var9, var7, var11, var9, var5);
      this.I(var1, var2, var10, var8, var12, var7, var8, var12, var7, var11, var12, var10, var11, var12, var5);
      this.I(var1, var2, var7, var8, var12, var7, var8, var9, var7, var11, var9, var7, var11, var12, var5);
      this.I(var1, var2, var10, var8, var9, var10, var8, var12, var10, var11, var12, var10, var11, var9, var5);
   }

   private void m_3055(Box var1) {
      this.I(this.f_2469, var1.minX);
      this.I(this.f_2470, var1.minY);
      this.I(this.O, var1.minZ);
      this.I(this.f_2471, var1.maxX);
      this.I(this.f_2472, var1.maxY);
      this.I(this.f_2473, var1.maxZ);
   }

   private void m_1140(Util98 var1, String var2, float... var3) {
      MathUtil6 var4 = var1.m_1335(var2);
      if (var4 != null) {
         switch (var3.length) {
            case 1:
               var4.O(var3[0]);
               break;
            case 2:
               var4.m_54(var3[0], var3[1]);
               break;
            case 3:
               var4.m_33(var3[0], var3[1], var3[2]);
               break;
            case 4:
               var4.m_41(var3[0], var3[1], var3[2], var3[3]);
         }
      }
   }

   private void I(MatrixStack var1, Box var2, float var3, float var4) {
      boolean var5 = GL11.glIsEnabled(3042);
      boolean var6 = GL11.glIsEnabled(2929);
      boolean var7 = GL11.glIsEnabled(2884);
      boolean var8 = GL11.glGetBoolean(2930);
      int var9 = GL11.glGetInteger(2932);
      int var10 = GL11.glGetInteger(f_2486);
      int var11 = GL11.glGetInteger(f_2487);
      int var12 = GL11.glGetInteger(f_2488);
      int var13 = GL11.glGetInteger(f_2489);

      try {
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         Util114.m_3188(515);
         this.m_2331(var1, var2, var3, var4);
         this.m_1209(var1, var2, var3, var4);
      } finally {
         Util114.m_1878(var8);
         Util114.m_3188(var9);
         if (var7) {
            Util114.m_1562();
         } else {
            Util114.m_3978();
         }

         Util114.m_1206(var10, var11, var12, var13);
         if (var5) {
            Util114.m_1481();
         } else {
            Util114.m_963();
         }

         if (var6) {
            Util114.m_100();
         } else {
            Util114.m_672();
         }

         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   private Box m_229() {
      return new Box(this.f_2469.m_2276(), this.f_2470.m_2276(), this.O.m_2276(), this.f_2471.m_2276(), this.f_2472.m_2276(), this.f_2473.m_2276());
   }

   private void I(Util165 var1, double var2) {
      var1.m_2214(var2);
      var1.m_2946(var2);
      var1.m_1829(var2);
      var1.m_1876(System.currentTimeMillis());
      var1.l(true);
   }

   private void I(Matrix4f var1, Box var2, int var3) {
      BufferBuilder var4 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      float var5 = (float)var2.minX;
      float var6 = (float)var2.minY;
      float var7 = (float)var2.minZ;
      float var8 = (float)var2.maxX;
      float var9 = (float)var2.maxY;
      float var10 = (float)var2.maxZ;
      this.I(var4, var1, var5, var9, var7, var8, var9, var7, var8, var9, var10, var5, var9, var10, var3);
      this.I(var4, var1, var5, var6, var10, var8, var6, var10, var8, var6, var7, var5, var6, var7, var3);
      this.I(var4, var1, var5, var6, var7, var8, var6, var7, var8, var9, var7, var5, var9, var7, var3);
      this.I(var4, var1, var8, var6, var10, var5, var6, var10, var5, var9, var10, var8, var9, var10, var3);
      this.I(var4, var1, var5, var6, var10, var5, var6, var7, var5, var9, var7, var5, var9, var10, var3);
      this.I(var4, var1, var8, var6, var7, var8, var6, var10, var8, var9, var10, var8, var9, var7, var3);
      RenderUtil12.I(var4.end());
   }

   @Override
   public void m_1() {
      super.m_1();
      this.f_2475 = false;
      this.I(this.f_2474, 0.0);
   }

   private void I(
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
      float var12,
      float var13,
      float var14,
      int var15
   ) {
      float var16 = Util71.m_1989(var15) / f_2518;
      float var17 = Util71.m_644(var15) / f_2519;
      float var18 = Util71.m_3163(var15) / f_2520;
      float var19 = Util71.m_2734(var15) / f_2521;
      var1.vertex(var2, var3, var4, var5).color(var16, var17, var18, var19);
      var1.vertex(var2, var6, var7, var8).color(var16, var17, var18, var19);
      var1.vertex(var2, var9, var10, var11).color(var16, var17, var18, var19);
      var1.vertex(var2, var12, var13, var14).color(var16, var17, var18, var19);
   }

   @EventHandler
   private void m_269(Util88 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         Box var2 = this.I();
         if (var2 != null) {
            if (!this.f_2475) {
               this.m_3055(var2);
               this.f_2475 = true;
            }

            this.I(var2);
            this.f_2474.m_3631(1.0);
         } else {
            this.f_2474.m_3631(0.0);
         }

         float var3 = (float)this.f_2474.m_2276();
         if (this.f_2475 && !(var3 <= f_2484)) {
            Box var4 = this.m_229();
            this.I(var1.m_213(), var4, var3, var1.m_191());
         }
      }
   }

   private void m_3971(Matrix4f var1, Box var2, int var3) {
      BufferBuilder var4 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
      float var5 = (float)var2.minX;
      float var6 = (float)var2.minY;
      float var7 = (float)var2.minZ;
      float var8 = (float)var2.maxX;
      float var9 = (float)var2.maxY;
      float var10 = (float)var2.maxZ;
      this.I(var4, var1, var5, var6, var7, var8, var6, var7, var3);
      this.I(var4, var1, var8, var6, var7, var8, var6, var10, var3);
      this.I(var4, var1, var8, var6, var10, var5, var6, var10, var3);
      this.I(var4, var1, var5, var6, var10, var5, var6, var7, var3);
      this.I(var4, var1, var5, var9, var7, var8, var9, var7, var3);
      this.I(var4, var1, var8, var9, var7, var8, var9, var10, var3);
      this.I(var4, var1, var8, var9, var10, var5, var9, var10, var3);
      this.I(var4, var1, var5, var9, var10, var5, var9, var7, var3);
      this.I(var4, var1, var5, var6, var7, var5, var9, var7, var3);
      this.I(var4, var1, var8, var6, var7, var8, var9, var7, var3);
      this.I(var4, var1, var8, var6, var10, var8, var9, var10, var3);
      this.I(var4, var1, var5, var6, var10, var5, var9, var10, var3);
      RenderUtil12.I(var4.end());
   }
}
