package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.util.ArrayDeque;
import java.util.Deque;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;

public class Trails extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Identifier f_11330 = Identifier.of(Trails.f_11467, Trails.f_11468);
   private final ModeSetting f_11331;
   private final NumberSetting f_11332;
   private final NumberSetting f_11333;
   private final NumberSetting f_11334;
   private final NumberSetting f_11335;
   private final NumberSetting f_11336;
   private final NumberSetting f_11337;
   private final NumberSetting f_11338;
   private final NumberSetting f_11339;
   private final NumberSetting f_11340;
   private final Deque<Trails.J0jpQ87RyzyY6GPL> f_11341;
   private static final String f_11342 = "Trails";
   private static final String f_11343 = "Красивый хвост за игроком";
   private static final String f_11344 = "Мод";
   private static final String f_11345 = "Свечение";
   private static final String f_11346 = "Свечение";
   private static final String f_11347 = "Лента Авроры";
   private static final String f_11348 = "Количество точек";
   private static final float f_11349 = 48.0F;
   private static final float f_11350 = 12.0F;
   private static final float f_11351 = 120.0F;
   private static final String f_11352 = "Шаг хвоста";
   private static final float f_11353 = 0.08F;
   private static final float f_11354 = 0.02F;
   private static final float f_11355 = 0.35F;
   private static final float f_11356 = 0.01F;
   private static final String f_11357 = "Время жизни (мс)";
   private static final float f_11358 = 900.0F;
   private static final float f_11359 = 250.0F;
   private static final float f_11360 = 3000.0F;
   private static final float f_11361 = 50.0F;
   private static final String f_11362 = "Размер";
   private static final float f_11363 = 0.28F;
   private static final float f_11364 = 0.08F;
   private static final float f_11365 = 0.7F;
   private static final float f_11366 = 0.01F;
   private static final String f_11367 = "Вращение";
   private static final float f_11368 = 7.0F;
   private static final float f_11369 = 20.0F;
   private static final float f_11370 = 0.5F;
   private static final String f_11371 = "Ширина ленты";
   private static final float f_11372 = 0.7F;
   private static final float f_11373 = 0.2F;
   private static final float f_11374 = 0.05F;
   private static final String f_11375 = "Закрутка";
   private static final float f_11376 = 1.2F;
   private static final float f_11377 = 3.0F;
   private static final float f_11378 = 0.1F;
   private static final String f_11379 = "Волна";
   private static final float f_11380 = 0.25F;
   private static final float f_11381 = 0.05F;
   private static final String f_11382 = "Слои";
   private static final float f_11383 = 3.0F;
   private static final float f_11384 = 5.0F;
   private static final String f_11385 = "Лента Авроры";
   private static final double f_11386 = 0.5;
   private static final double f_11387 = 100.0;
   private static final float f_11388 = 0.01F;
   private static final float f_11389 = 0.35F;
   private static final float f_11390 = 0.65F;
   private static final float f_11391 = 0.82F;
   private static final float f_11392 = 0.18F;
   private static final float f_11393 = 0.0075F;
   private static final float f_11394 = 0.65F;
   private static final float f_11395 = 0.55F;
   private static final float f_11396 = 1.05F;
   private static final float f_11397 = 165.0F;
   private static final float f_11398 = 255.0F;
   private static final double f_11399 = 0.05F;
   private static final float f_11400 = 0.025F;
   private static final float f_11401 = 0.1F;
   private static final float f_11402 = 13.0F;
   private static final float f_11403 = 360.0F;
   private static final float f_11404 = 1.8F;
   private static final float f_11405 = 0.001F;
   private static final float f_11406 = 0.9F;
   private static final float f_11407 = 0.08F;
   private static final float f_11408 = 40.0F;
   private static final float f_11409 = 0.55F;
   private static final float f_11410 = 0.38F;
   private static final float f_11411 = 0.06F;
   private static final float f_11412 = 0.08F;
   private static final double f_11413 = Math.PI;
   private static final float f_11414 = 0.25F;
   private static final float f_11415 = 0.75F;
   private static final float f_11416 = 0.001F;
   private static final double f_11417 = 1.0E-4;
   private static final float f_11418 = 180.0F;
   private static final float f_11419 = 12.0F;
   private static final float f_11420 = 0.4F;
   private static final float f_11421 = 8.0F;
   private static final float f_11422 = 2.5F;
   private static final float f_11423 = 220.0F;
   private static final float f_11424 = 0.25F;
   private static final float f_11425 = 0.75F;
   private static final float f_11426 = 0.85F;
   private static final float f_11427 = 0.15F;
   private static final float f_11428 = 4.0F;
   private static final float f_11429 = 0.5F;
   private static final float f_11430 = 120.0F;
   private static final float f_11431 = 255.0F;
   private static final float f_11432 = 0.6F;
   private static final float f_11433 = 0.4F;
   private static final float f_11434 = 6.0F;
   private static final float f_11435 = 1.3F;
   private static final float f_11436 = 0.7F;
   private static final float f_11437 = 0.02F;
   private static final float f_11438 = 0.8F;
   private static final float f_11439 = 0.6F;
   private static final float f_11440 = 180.0F;
   private static final float f_11441 = 12.0F;
   private static final double f_11442 = 1.0E-4;
   private static final float f_11443 = 0.4F;
   private static final float f_11444 = 8.0F;
   private static final float f_11445 = 2.5F;
   private static final float f_11446 = 0.25F;
   private static final float f_11447 = 0.75F;
   private static final double f_11448 = Math.PI;
   private static final float f_11449 = 200.0F;
   private static final float f_11450 = 200.0F;
   private static final float f_11451 = 0.7F;
   private static final float f_11452 = 0.7F;
   private static final float f_11453 = 150.0F;
   private static final float f_11454 = 0.4F;
   private static final double f_11455 = 1.0E-5;
   private static final double f_11456 = 1.0E-5;
   private static final double f_11457 = 1.0E-5;
   private static final float f_11458 = 0.5F;
   private static final float f_11459 = 255.0F;
   private static final float f_11460 = 255.0F;
   private static final float f_11461 = 255.0F;
   private static final float f_11462 = 255.0F;
   private static final String f_11463 = "Лента Авроры";
   private static final String f_11464 = "Лента Авроры";
   private static final String f_11465 = "Лента Авроры";
   private static final String f_11466 = "Лента Авроры";
   private static final String f_11467 = "energy";
   private static final String f_11468 = "images/esp/glow.png";

   private void m_2824(Matrix4f var1, float var2, int var3) {
      float var4 = var2 * f_11458;
      float var5 = (var3 >> 16 & 0xFF) / f_11459;
      float var6 = (var3 >> 8 & 0xFF) / f_11460;
      float var7 = (var3 & 0xFF) / f_11461;
      float var8 = (var3 >> 24 & 0xFF) / f_11462;
      BufferBuilder var9 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      var9.vertex(var1, -var4, var4, 0.0F).texture(0.0F, 1.0F).color(var5, var6, var7, var8);
      var9.vertex(var1, var4, var4, 0.0F).texture(1.0F, 1.0F).color(var5, var6, var7, var8);
      var9.vertex(var1, var4, -var4, 0.0F).texture(1.0F, 0.0F).color(var5, var6, var7, var8);
      var9.vertex(var1, -var4, -var4, 0.0F).texture(0.0F, 0.0F).color(var5, var6, var7, var8);
      RenderUtil12.I(var9.end());
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_11341.clear();
   }

   private void m_249(long var1) {
      long var3 = (long)this.f_11334.m_4046();
      this.f_11341.removeIf(var4 -> var1 - var4.f_12044 > var3);
   }

   private Vec3d m_1514(Trails.J0jpQ87RyzyY6GPL[] var1, int var2) {
      if (var1.length < 2) {
         return new Vec3d(0.0, 0.0, 1.0);
      } else if (var2 == 0) {
         Vec3d var7 = var1[1].f_12043.subtract(var1[0].f_12043);
         return var7.lengthSquared() < f_11455 ? new Vec3d(0.0, 0.0, 1.0) : var7.normalize();
      } else if (var2 >= var1.length - 1) {
         Vec3d var6 = var1[var1.length - 1].f_12043.subtract(var1[var1.length - 2].f_12043);
         return var6.lengthSquared() < f_11456 ? new Vec3d(0.0, 0.0, 1.0) : var6.normalize();
      } else {
         Vec3d var3 = var1[var2 + 1].f_12043.subtract(var1[var2].f_12043);
         Vec3d var4 = var1[var2].f_12043.subtract(var1[var2 - 1].f_12043);
         Vec3d var5 = var3.add(var4);
         return var5.lengthSquared() < f_11457 ? new Vec3d(0.0, 0.0, 1.0) : var5.normalize();
      }
   }

   private void m_1756(float var1, long var2) {
      Vec3d var4 = f_5909.player.getLerpedPos(var1).add(0.0, f_11386, 0.0);
      Trails.J0jpQ87RyzyY6GPL var5 = this.f_11341.peekLast();
      if (var5 != null) {
         double var6 = var5.f_12043.squaredDistanceTo(var4);
         if (var6 > f_11387) {
            this.f_11341.clear();
         } else {
            float var8 = this.f_11333.m_4046();
            if (var6 < var8 * var8) {
               return;
            }
         }
      }

      this.f_11341.addLast(new Trails.J0jpQ87RyzyY6GPL(var4, var2));
      int var9 = this.f_11332.m_134().intValue();

      while (this.f_11341.size() > var9) {
         this.f_11341.removeFirst();
      }
   }

   private Vec3d m_826(Vec3d var1, Vec3d var2, float var3) {
      double var4 = Math.cos(var3);
      double var6 = Math.sin(var3);
      Vec3d var8 = var2.crossProduct(var1);
      double var9 = var2.dotProduct(var1);
      return var1.multiply(var4).add(var8.multiply(var6)).add(var2.multiply(var9 * (1.0 - var4)));
   }

   private void m_2180(MatrixStack var1, Trails.J0jpQ87RyzyY6GPL[] var2, Vec3d var3, float var4, float var5, long var6, int var8) {
      Matrix4f var9 = var1.peek().getPositionMatrix();

      for (int var10 = 0; var10 < var8; var10++) {
         float var11 = var10 * f_11406;
         float var12 = var10 * f_11407;
         float var13 = var10 * f_11408;
         float var14 = var10 == 0 ? f_11409 : f_11410 - var10 * f_11411;
         var14 = Math.max(var14, f_11412);
         Util114.m_1206(770, 1, 0, 1);
         Util114.m_3784(RenderUtil7.f_13885);
         BufferBuilder var15 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
         boolean var16 = false;

         for (int var17 = 0; var17 < var2.length; var17++) {
            float var18 = (float)var17 / (var2.length - 1);
            float var19 = (float)(var6 - var2[var17].f_12044) / var4;
            float var20 = 1.0F - MathHelper.clamp(var19, 0.0F, 1.0F);
            float var21 = (float)Math.sin(var18 * f_11413);
            float var22 = this.f_11337.m_4046() * (f_11414 + f_11415 * var21) * var20;
            if (!(var22 < f_11416)) {
               Vec3d var23 = this.m_1514(var2, var17);
               Vec3d var24 = new Vec3d(0.0, 1.0, 0.0);
               Vec3d var25 = var23.crossProduct(var24);
               if (var25.lengthSquared() < f_11417) {
                  var25 = new Vec3d(1.0, 0.0, 0.0);
               } else {
                  var25 = var25.normalize();
               }

               Vec3d var26 = var25.crossProduct(var23).normalize();
               float var27 = (float)Math.toRadians(var18 * f_11418 * this.f_11338.m_4046() + var5 * this.f_11336.m_4046() * f_11419 + var13);
               Vec3d var28 = this.m_826(var25, var23, var27);
               float var29 = this.f_11339.m_4046() * f_11420 * MathHelper.sin(var18 * f_11421 + var5 * f_11422 + var11);
               Vec3d var30 = var2[var17].f_12043.add(0.0, var29 + var12, 0.0).subtract(var3);
               Vec3d var31 = var30.add(var28.multiply(var22));
               Vec3d var32 = var30.subtract(var28.multiply(var22));
               int var33 = EnergyClient.getTheme((int)(var18 * f_11423) + var10 * 55);
               int var34 = Util71.m_3793(var33, 50 + var10 * 20);
               float var35 = var20 * var14 * (f_11424 + f_11425 * var18);
               float var36 = f_11426 + f_11427 * MathHelper.sin(var5 * f_11428 + var17 * f_11429 + var10);
               int var37 = (int)(var35 * var36 * f_11430);
               int var38 = (int)(var35 * var36 * f_11431);
               int var39 = Util71.m_3389(var33, MathHelper.clamp(var37, 0, 255));
               int var40 = Util71.m_3389(var34, MathHelper.clamp(var38, 0, 255));
               float[] var41 = Util71.m_2326(var39);
               float[] var42 = Util71.m_2326(var40);
               var15.vertex(var9, (float)var31.x, (float)var31.y, (float)var31.z).color(var41[0], var41[1], var41[2], var41[3]);
               var15.vertex(var9, (float)var32.x, (float)var32.y, (float)var32.z).color(var42[0], var42[1], var42[2], var42[3]);
               var16 = true;
            }
         }

         if (var16) {
            RenderUtil12.I(var15.end());
         }
      }
   }

   private void m_4138(MatrixStack var1, Camera var2, Vec3d var3, float var4, int var5) {
      var1.push();
      var1.translate(var3.x, var3.y, var3.z);
      var1.multiply(var2.getRotation());
      this.m_2824(var1.peek().getPositionMatrix(), var4, var5);
      var1.pop();
   }

   private void l(MatrixStack var1, long var2) {
      Trails.J0jpQ87RyzyY6GPL[] var4 = this.f_11341.toArray(new Trails.J0jpQ87RyzyY6GPL[0]);
      if (var4.length >= 3) {
         Camera var5 = f_5909.gameRenderer.getCamera();
         Vec3d var6 = var5.getCameraPos();
         float var7 = this.f_11334.m_4046();
         float var8 = (float)var2 * f_11405;
         int var9 = this.f_11340.m_134().intValue();
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         Util114.m_1481();
         Util114.m_3978();
         Util114.m_100();
         Util114.m_1878(false);
         this.m_2180(var1, var4, var6, var7, var8, var2, var9);
         this.m_3735(var1, var4, var5, var6, var7, var8, var2);
         Util114.m_1878(true);
         Util114.m_963();
         Util114.m_542();
         Util114.m_1562();
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   public Trails() {
      super(f_11342, f_11343, Category.RENDER);
      this.f_11331 = new ModeSetting(f_11344, f_11345, f_11346, f_11347);
      this.f_11332 = new NumberSetting(f_11348, f_11349, f_11350, f_11351, 1.0F);
      this.f_11333 = new NumberSetting(f_11352, f_11353, f_11354, f_11355, f_11356);
      this.f_11334 = new NumberSetting(f_11357, f_11358, f_11359, f_11360, f_11361);
      this.f_11335 = new NumberSetting(f_11362, f_11363, f_11364, f_11365, f_11366);
      this.f_11336 = new NumberSetting(f_11367, f_11368, 0.0F, f_11369, f_11370);
      this.f_11337 = new NumberSetting(f_11371, f_11372, f_11373, 2.0F, f_11374).m_356(() -> this.f_11331.m_2073(f_11466));
      this.f_11338 = new NumberSetting(f_11375, f_11376, 0.0F, f_11377, f_11378).m_356(() -> this.f_11331.m_2073(f_11465));
      this.f_11339 = new NumberSetting(f_11379, f_11380, 0.0F, 1.0F, f_11381).m_356(() -> this.f_11331.m_2073(f_11464));
      this.f_11340 = new NumberSetting(f_11382, f_11383, 1.0F, f_11384, 1.0F).m_356(() -> this.f_11331.m_2073(f_11463));
      this.f_11341 = new ArrayDeque<>();
   }

   @EventHandler
   private void m_2566(Util88 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         long var2 = System.currentTimeMillis();
         this.m_1756(var1.m_191(), var2);
         this.m_249(var2);
         Perspective var4 = f_5909.options.getPerspective();
         if (!var4.isFirstPerson()) {
            if (!this.f_11341.isEmpty()) {
               if (this.f_11331.m_2073(f_11385)) {
                  this.l(var1.m_213(), var2);
               } else {
                  this.m_3126(var1.m_213(), var2);
               }
            }
         }
      }
   }

   private void m_3126(MatrixStack var1, long var2) {
      Camera var4 = f_5909.gameRenderer.getCamera();
      Vec3d var5 = var4.getCameraPos();
      Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      Util114.m_3784(RenderUtil7.f_13886);
      Util114.m_2037(0, f_11330);
      Util114.m_1481();
      Util114.m_1206(770, 1, 0, 1);
      Util114.m_3978();
      Util114.m_100();
      Util114.m_1878(false);
      float var6 = this.f_11334.m_4046();
      float var7 = this.f_11335.m_4046();
      float var8 = this.f_11336.m_4046();
      int var9 = this.f_11341.size();
      int var10 = 0;
      var1.push();

      for (Trails.J0jpQ87RyzyY6GPL var12 : this.f_11341) {
         float var13 = (float)(var2 - var12.f_12044) / var6;
         float var14 = 1.0F - MathHelper.clamp(var13, 0.0F, 1.0F);
         if (var14 <= f_11388) {
            var10++;
         } else {
            float var15 = var9 <= 1 ? 1.0F : (float)var10 / (var9 - 1);
            float var16 = f_11389 + var15 * f_11390;
            float var17 = var14 * var16;
            float var18 = f_11391 + f_11392 * MathHelper.sin((float)var2 * f_11393 + var12.f_12045 * f_11394);
            float var19 = var7 * (f_11395 + var15 * f_11396) * var18;
            int var20 = EnergyClient.getTheme(var10 * 24);
            int var21 = Util71.m_3389(Util71.m_3793(var20, 75), (int)(var17 * f_11397));
            int var22 = Util71.m_3389(var20, (int)(var17 * f_11398));
            Vec3d var23 = var12.f_12043.subtract(var5);
            var1.push();
            var1.translate(var23.x, var23.y + f_11399 + (1.0F - var15) * f_11400, var23.z);
            var1.multiply(var4.getRotation());
            var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(((float)var2 * var8 * f_11401 + var10 * f_11402) % f_11403));
            Matrix4f var24 = var1.peek().getPositionMatrix();
            this.m_2824(var24, var19 * f_11404, var21);
            this.m_2824(var24, var19, var22);
            var1.pop();
            var10++;
         }
      }

      var1.pop();
      Util114.m_100();
      Util114.m_1878(true);
      Util114.m_963();
      Util114.m_542();
      Util114.m_1562();
      Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
   }

   @Override
   public void m_1() {
      this.f_11341.clear();
      super.m_1();
   }

   private void m_3735(MatrixStack var1, Trails.J0jpQ87RyzyY6GPL[] var2, Camera var3, Vec3d var4, float var5, float var6, long var7) {
      Util114.m_3784(RenderUtil7.f_13886);
      Util114.m_2037(0, f_11330);
      Util114.m_1206(770, 1, 0, 1);
      int var9 = Math.max(1, var2.length / 30);

      for (int var10 = 0; var10 < var2.length; var10 += var9) {
         float var11 = (float)var10 / (var2.length - 1);
         float var12 = (float)(var7 - var2[var10].f_12044) / var5;
         float var13 = 1.0F - MathHelper.clamp(var12, 0.0F, 1.0F);
         float var14 = f_11432 + f_11433 * MathHelper.sin(var6 * f_11434 + var10 * f_11435);
         float var15 = var13 * var11 * var14 * f_11436;
         if (!(var15 < f_11437)) {
            float var16 = this.f_11335.m_4046() * (f_11438 + f_11439 * var11) * var14;
            Vec3d var17 = this.m_1514(var2, var10);
            float var18 = (float)Math.toRadians(var11 * f_11440 * this.f_11338.m_4046() + var6 * this.f_11336.m_4046() * f_11441);
            Vec3d var19 = new Vec3d(0.0, 1.0, 0.0);
            Vec3d var20 = var17.crossProduct(var19);
            if (var20.lengthSquared() < f_11442) {
               var20 = new Vec3d(1.0, 0.0, 0.0);
            } else {
               var20 = var20.normalize();
            }

            Vec3d var21 = this.m_826(var20, var17, var18);
            float var22 = this.f_11339.m_4046() * f_11443 * MathHelper.sin(var11 * f_11444 + var6 * f_11445);
            float var23 = this.f_11337.m_4046() * (f_11446 + f_11447 * (float)Math.sin(var11 * f_11448)) * var13;
            Vec3d var24 = var2[var10].f_12043.add(0.0, var22, 0.0).subtract(var4);
            Vec3d var25 = var24.add(var21.multiply(var23));
            Vec3d var26 = var24.subtract(var21.multiply(var23));
            int var27 = EnergyClient.getTheme((int)(var11 * f_11449));
            int var28 = Util71.m_3389(Util71.m_3793(var27, 90), MathHelper.clamp((int)(var15 * f_11450), 0, 255));
            this.m_4138(var1, var3, var25, var16 * f_11451, var28);
            this.m_4138(var1, var3, var26, var16 * f_11452, var28);
            if (var10 % (var9 * 3) == 0) {
               int var30 = Util71.m_3389(-1, MathHelper.clamp((int)(var15 * f_11453), 0, 255));
               this.m_4138(var1, var3, var24, var16 * f_11454, var30);
            }
         }
      }
   }

   private static class J0jpQ87RyzyY6GPL {
      private final Vec3d f_12043;
      private final long f_12044;
      private final float f_12045;
      private static final double f_12046 = 20.0;

      private J0jpQ87RyzyY6GPL(Vec3d var1, long var2) {
         this.f_12043 = var1;
         this.f_12044 = var2;
         this.f_12045 = (float)(Math.random() * f_12046);
      }
   }
}
