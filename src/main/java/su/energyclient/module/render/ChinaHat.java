package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil3;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util108;
import su.energyclient.util.Util114;
import su.energyclient.util.Util150;
import su.energyclient.util.Util71;

public class ChinaHat extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_12241;
   private final BooleanSetting f_12242;
   private static final float f_12243 = 0.06981317F;
   private static final int f_12244 = 0;
   private static final String f_12245 = "China Hat";
   private static final String f_12246 = "description";
   private static final String f_12247 = "Мод";
   private static final String f_12248 = "Стандарт";
   private static final String f_12249 = "Стандарт";
   private static final String f_12250 = "Аврора";
   private static final String f_12251 = "Кристалл";
   private static final String f_12252 = "Нимб";
   private static final String f_12253 = "Вихрь";
   private static final String f_12254 = "Отображать на друзьях";
   private static final float f_12255 = 0.5F;
   private static final float f_12256 = 0.42F;
   private static final String f_12257 = "Стандарт";
   private static final String f_12258 = "Аврора";
   private static final String f_12259 = "Кристалл";
   private static final String f_12260 = "Нимб";
   private static final String f_12261 = "Вихрь";
   private static final float f_12262 = 180.0F;
   private static final float f_12263 = 90.0F;
   private static final float f_12264 = 0.06981317F;
   private static final float f_12265 = 0.5F;
   private static final float f_12266 = 0.5F;
   private static final float f_12267 = 0.3F;
   private static final float f_12268 = 0.06981317F;
   private static final float f_12269 = 0.5F;
   private static final float f_12270 = 180.0F;
   private static final float f_12271 = 90.0F;
   private static final long f_12272 = 100000L;
   private static final float f_12273 = 0.001F;
   private static final float f_12274 = 0.42F;
   private static final float f_12275 = 0.08F;
   private static final float f_12276 = 0.28F;
   private static final float f_12277 = 0.07F;
   private static final float f_12278 = 0.13F;
   private static final float f_12279 = 2.5F;
   private static final float f_12280 = 0.6F;
   private static final float f_12281 = 0.03F;
   private static final float f_12282 = 0.01F;
   private static final float f_12283 = 30.0F;
   private static final float f_12284 = 0.06981317F;
   private static final float f_12285 = 4.0F;
   private static final float f_12286 = 7.0F;
   private static final float f_12287 = 1.3F;
   private static final float f_12288 = 0.5F;
   private static final float f_12289 = 1.8F;
   private static final float f_12290 = 0.06981317F;
   private static final float f_12291 = 4.0F;
   private static final float f_12292 = 2.5F;
   private static final float f_12293 = 0.03F;
   private static final float f_12294 = 0.5F;
   private static final float f_12295 = 0.5F;
   private static final float f_12296 = 6.0F;
   private static final float f_12297 = 5.0F;
   private static final float f_12298 = 30.0F;
   private static final float f_12299 = 0.85F;
   private static final long f_12300 = 100000L;
   private static final float f_12301 = 0.001F;
   private static final float f_12302 = 0.015F;
   private static final double f_12303 = 0.08;
   private static final float f_12304 = 180.0F;
   private static final float f_12305 = 35.0F;
   private static final float f_12306 = 5.0F;
   private static final float f_12307 = 0.7F;
   private static final float f_12308 = 5.0F;
   private static final float f_12309 = 0.9F;
   private static final float f_12310 = 0.5F;
   private static final float f_12311 = 0.55F;
   private static final float f_12312 = 0.3F;
   private static final float f_12313 = 0.1F;
   private static final float f_12314 = (float) (Math.PI * 2);
   private static final float f_12315 = 0.45F;
   private static final float f_12316 = 0.55F;
   private static final float f_12317 = 1.8F;
   private static final float f_12318 = 1.1F;
   private static final float f_12319 = 25.0F;
   private static final float f_12320 = 110.0F;
   private static final float f_12321 = 0.72F;
   private static final float f_12322 = 0.35F;
   private static final float f_12323 = 0.55F;
   private static final float f_12324 = 1.35F;
   private static final float f_12325 = 0.15F;
   private static final float f_12326 = 3.0F;
   private static final float f_12327 = (float) (Math.PI * 2);
   private static final float f_12328 = 25.0F;
   private static final float f_12329 = 0.08F;
   private static final float f_12330 = 0.04F;
   private static final float f_12331 = 3.0F;
   private static final float f_12332 = 25.0F;
   private static final float f_12333 = 0.85F;
   private static final long f_12334 = 100000L;
   private static final float f_12335 = 0.001F;
   private static final float f_12336 = 180.0F;
   private static final float f_12337 = 1.05F;
   private static final float f_12338 = 0.06F;
   private static final float f_12339 = 2.5F;
   private static final float f_12340 = 0.42F;
   private static final float f_12341 = 0.025F;
   private static final float f_12342 = 1.5F;
   private static final float f_12343 = 8.0F;
   private static final float f_12344 = 0.7F;
   private static final float f_12345 = 0.06981317F;
   private static final float f_12346 = 0.038F;
   private static final float f_12347 = 45.0F;
   private static final float f_12348 = 0.7F;
   private static final float f_12349 = 0.3F;
   private static final float f_12350 = 3.0F;
   private static final float f_12351 = 3.0F;
   private static final float f_12352 = 0.55F;
   private static final float f_12353 = 0.13F;
   private static final float f_12354 = 45.0F;
   private static final float f_12355 = 0.1F;
   private static final float f_12356 = 0.06F;
   private static final float f_12357 = 5.0F;
   private static final float f_12358 = (float) (Math.PI * 2);
   private static final float f_12359 = 1.8F;
   private static final float f_12360 = 0.02F;
   private static final float f_12361 = 5.0F;
   private static final float f_12362 = 1.5F;
   private static final float f_12363 = 0.03F;
   private static final float f_12364 = 0.012F;
   private static final float f_12365 = 4.0F;
   private static final float f_12366 = 0.9F;
   private static final float f_12367 = 1.5F;
   private static final float f_12368 = 45.0F;
   private static final float f_12369 = 0.7F;
   private static final float f_12370 = 180.0F;
   private static final long f_12371 = 100000L;
   private static final float f_12372 = 0.001F;
   private static final float f_12373 = 1.35F;
   private static final float f_12374 = 0.38F;
   private static final float f_12375 = (float) (Math.PI * 2);
   private static final float f_12376 = (float) (Math.PI * 2);
   private static final float f_12377 = 2.5F;
   private static final float f_12378 = 0.04F;
   private static final float f_12379 = 0.55F;
   private static final float f_12380 = 0.012F;
   private static final float f_12381 = 6.0F;
   private static final float f_12382 = 0.4F;
   private static final float f_12383 = 200.0F;
   private static final float f_12384 = 35.0F;
   private static final float f_12385 = 0.75F;
   private static final float f_12386 = 0.6F;
   private static final float f_12387 = 0.4F;
   private static final float f_12388 = 3.5F;
   private static final float f_12389 = 0.3F;
   private static final float f_12390 = (float) (Math.PI * 2);
   private static final float f_12391 = (float) (Math.PI * 2);
   private static final float f_12392 = 2.5F;
   private static final float f_12393 = 0.12F;
   private static final float f_12394 = 0.5F;
   private static final float f_12395 = 200.0F;
   private static final float f_12396 = 35.0F;
   private static final float f_12397 = 0.85F;
   private static final float f_12398 = 0.08F;
   private static final float f_12399 = 0.045F;
   private static final float f_12400 = 0.02F;
   private static final float f_12401 = 3.0F;
   private static final float f_12402 = 0.85F;
   private static final float f_12403 = 255.0F;
   private static final float f_12404 = 255.0F;
   private static final float f_12405 = 255.0F;
   private static final float f_12406 = 255.0F;

   private int m_549(int var1, float var2) {
      int var3 = (int)(Util71.m_2734(var1) * MathHelper.clamp(var2, 0.0F, 1.0F));
      return Util71.m_3389(var1, var3);
   }

   private void m_1107(BufferBuilder var1, Matrix4f var2, float var3, float var4, float var5, int var6) {
      float var7 = (var6 >> 24 & 0xFF) / f_12403;
      float var8 = (var6 >> 16 & 0xFF) / f_12404;
      float var9 = (var6 >> 8 & 0xFF) / f_12405;
      float var10 = (var6 & 0xFF) / f_12406;
      var1.vertex(var2, var3, var4, var5).color(var8, var9, var10, var7);
   }

   private void m_439(MatrixStack var1, ModelWithHead var2, float var3, float var4) {
      var1.push();
      var2.getHead().applyTransform(var1);
      this.m_2730();
      Util114.m_1206(770, 1, 0, 1);
      float var5 = (float)(System.currentTimeMillis() % f_12334) * f_12335;
      var1.translate(0.0F, -var4, 0.0F);
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_12336));
      float var6 = var3 * f_12337;
      float var7 = 1.0F + f_12338 * MathHelper.sin(var5 * f_12339);
      var6 *= var7;
      float var8 = f_12340 + f_12341 * MathHelper.sin(var5 * f_12342);
      float var9 = f_12343 * MathHelper.sin(var5 * f_12344);
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var9));
      Matrix4f var10 = var1.peek().getPositionMatrix();
      float var11 = f_12345;
      float var12 = f_12346;
      BufferBuilder var13 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

      for (int var14 = 0; var14 <= 90; var14++) {
         float var15 = var14 * var11;
         float var16 = var6 - var12;
         float var17 = var6 + var12;
         float var18 = MathHelper.sin(var15) * var16;
         float var19 = MathHelper.cos(var15) * var16;
         float var20 = MathHelper.sin(var15) * var17;
         float var21 = MathHelper.cos(var15) * var17;
         int var22 = EnergyClient.getTheme(var14 * 4 + (int)(var5 * f_12347));
         float var23 = f_12348 + f_12349 * MathHelper.sin(var15 * f_12350 + var5 * f_12351);
         int var24 = this.m_549(Util71.m_3793(var22, 110), var23);
         int var25 = this.m_549(var22, var23 * f_12352);
         this.m_1107(var13, var10, var18, var8, var19, var25);
         this.m_1107(var13, var10, var20, var8, var21, var24);
      }

      RenderUtil12.I(var13.end());
      float var27 = f_12353;
      BufferBuilder var28 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

      for (int var29 = 0; var29 <= 90; var29++) {
         float var31 = var29 * var11;
         float var34 = var6 - var27;
         float var37 = var6 + var27;
         float var40 = MathHelper.sin(var31) * var34;
         float var43 = MathHelper.cos(var31) * var34;
         float var46 = MathHelper.sin(var31) * var37;
         float var49 = MathHelper.cos(var31) * var37;
         int var52 = EnergyClient.getTheme(var29 * 4 + (int)(var5 * f_12354));
         int var54 = this.m_549(var52, f_12355 + f_12356 * MathHelper.sin(var31 * f_12357 + var5 * 2.0F));
         this.m_1107(var28, var10, var40, var8, var43, var54);
         this.m_1107(var28, var10, var46, var8, var49, var54);
      }

      RenderUtil12.I(var28.end());
      byte var30 = 8;

      for (int var32 = 0; var32 < var30; var32++) {
         float var35 = f_12358 / var30 * var32 + var5 * f_12359;
         float var38 = MathHelper.sin(var35) * var6;
         float var41 = MathHelper.cos(var35) * var6;
         float var44 = f_12360 * MathHelper.sin(var5 * f_12361 + var32 * f_12362);
         float var47 = f_12363 + f_12364 * MathHelper.sin(var5 * f_12365 + var32 * 2.0F);
         int var50 = this.m_549(Util71.m_3793(EnergyClient.getTheme(var32 * 45), 160), f_12366);
         BufferBuilder var53 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
         float var55 = var8 + var44;
         this.m_1107(var53, var10, var38 - var47, var55 + var47, var41, var50);
         this.m_1107(var53, var10, var38 + var47, var55 + var47, var41, var50);
         this.m_1107(var53, var10, var38 - var47, var55 - var47, var41, var50);
         this.m_1107(var53, var10, var38 + var47, var55 - var47, var41, var50);
         RenderUtil12.I(var53.end());
      }

      Util114.m_1878(false);
      Util114.m_2977(f_12367);
      GL11.glEnable(2848);
      BufferBuilder var33 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);

      for (int var36 = 0; var36 <= 90; var36++) {
         float var39 = var36 * var11;
         float var42 = MathHelper.sin(var39) * var6;
         float var45 = MathHelper.cos(var39) * var6;
         int var48 = EnergyClient.getTheme(var36 * 4 + (int)(var5 * f_12368));
         int var51 = this.m_549(Util71.m_3793(var48, 140), f_12369);
         this.m_1107(var33, var10, var42, var8, var45, var51);
      }

      RenderUtil12.I(var33.end());
      GL11.glDisable(2848);
      Util114.m_1878(true);
      this.m_3650();
      var1.pop();
   }

   private void m_1680(MatrixStack var1, ModelWithHead var2, float var3, float var4) {
      var1.push();
      var2.getHead().applyTransform(var1);
      this.m_2730();
      var1.translate(0.0F, -var4, 0.0F);
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_12270));
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_12271));
      float var5 = (float)(System.currentTimeMillis() % f_12272) * f_12273;
      Matrix4f var6 = var1.peek().getPositionMatrix();

      for (int var7 = 0; var7 < 4; var7++) {
         float var8 = f_12274 - var7 * f_12275;
         float var9 = f_12276 + var7 * f_12277;
         float var10 = var3 * (1.0F + var7 * f_12278);
         float var11 = f_12279 + var7 * f_12280;
         float var12 = f_12281 + var7 * f_12282;
         int var13 = var7 * 40 + (int)(var5 * f_12283);
         BufferBuilder var14 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

         for (int var15 = 0; var15 <= 180; var15++) {
            float var16 = var15 * f_12284;
            float var17 = MathHelper.sin(var16 * f_12285 + var5 * var11) * var12 + MathHelper.sin(var16 * f_12286 + var5 * var11 * f_12287) * var12 * f_12288;
            float var18 = MathHelper.sin(var16) * var10;
            float var19 = MathHelper.cos(var16) * var10;
            int var20 = EnergyClient.getTheme(var15 * 4 + var13);
            int var21 = this.m_549(Util71.m_3793(var20, 40 + var7 * 25), var8);
            int var22 = this.m_549(var20, Math.min(1.0F, var8 * f_12289));
            this.m_1107(var14, var6, var18, var17, var19, var21);
            this.m_1107(var14, var6, 0.0F, var9, 0.0F, var22);
         }

         RenderUtil12.I(var14.end());
      }

      Util114.m_1878(false);
      Util114.m_2977(2.0F);
      GL11.glEnable(2848);
      BufferBuilder var23 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);
      float var24 = 0.0F;
      float var25 = 0.0F;
      int var26 = 0;

      for (int var27 = 0; var27 <= 180; var27++) {
         float var28 = var27 * f_12290;
         float var29 = MathHelper.sin(var28 * f_12291 + var5 * f_12292) * f_12293;
         float var30 = MathHelper.sin(var28) * var3;
         float var31 = MathHelper.cos(var28) * var3;
         float var32 = f_12294 + f_12295 * MathHelper.sin(var28 * f_12296 + var5 * f_12297);
         int var33 = EnergyClient.getTheme(var27 * 4 + (int)(var5 * f_12298));
         int var34 = this.m_549(Util71.m_3793(var33, 120), var32 * f_12299);
         if (var27 == 0) {
            var24 = var30;
            var25 = var31;
            var26 = var34;
         }

         this.m_1107(var23, var6, var30, var29, var31, var34);
      }

      this.m_1107(var23, var6, var24, 0.0F, var25, var26);
      RenderUtil12.I(var23.end());
      GL11.glDisable(2848);
      Util114.m_1878(true);
      this.m_3650();
      var1.pop();
   }

   public ChinaHat() {
      super(f_12245, f_12246, Category.RENDER);
      this.f_12241 = new ModeSetting(f_12247, f_12248, f_12249, f_12250, f_12251, f_12252, f_12253);
      this.f_12242 = new BooleanSetting(f_12254, true);
   }

   @EventHandler
   private void m_1325(Util108 var1) {
      LivingEntity var2 = var1.m_315();
      if (var2 instanceof PlayerEntity var3) {
         if (var1.m_3626() instanceof ModelWithHead var5) {
            boolean var6 = InitManager.f_2740.f_2744.m_2704(var3.getGameProfile().name());
            boolean var7 = var3 == f_5909.player;
            if (!var7 || !RenderUtil3.m_844().m_1207() || RenderUtil3.m_844().m_3164(Util150.HEADWEAR) == null) {
               if (var7 || this.f_12242.m_1163() && var6) {
                  MatrixStack var8 = var1.m_2094();
                  Box var9 = var2.getBoundingBox();
                  float var10 = (float)(var9.maxX - var9.minX);
                  boolean var11 = !var3.getEquippedStack(EquipmentSlot.HEAD).isEmpty();
                  float var12 = var11 ? f_12255 : f_12256;
                  String var13 = this.f_12241.m_3862();
                  switch (var13) {
                     case f_12257:
                        this.m_2033(var8, var5, var10, var12);
                        break;
                     case f_12258:
                        this.m_1680(var8, var5, var10, var12);
                        break;
                     case f_12259:
                        this.m_3649(var8, var5, var10, var12);
                        break;
                     case f_12260:
                        this.m_439(var8, var5, var10, var12);
                        break;
                     case f_12261:
                        this.m_1387(var8, var5, var10, var12);
                  }
               }
            }
         }
      }
   }

   private void m_3650() {
      Util114.m_1562();
      Util114.m_542();
   }

   private void m_2730() {
      Util114.m_1481();
      Util114.m_100();
      Util114.m_3978();
      Util114.m_542();
      Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      Util114.m_3784(RenderUtil7.f_13885);
      Util114.m_1206(770, 1, 1, 0);
   }

   private void m_1387(MatrixStack var1, ModelWithHead var2, float var3, float var4) {
      var1.push();
      var2.getHead().applyTransform(var1);
      this.m_2730();
      Util114.m_1206(770, 1, 0, 1);
      var1.translate(0.0F, -var4, 0.0F);
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_12370));
      float var5 = (float)(System.currentTimeMillis() % f_12371) * f_12372;
      Matrix4f var6 = var1.peek().getPositionMatrix();
      byte var7 = 4;
      byte var8 = 50;
      float var9 = var3 * f_12373;
      float var10 = f_12374;

      for (int var11 = 0; var11 < var7; var11++) {
         float var12 = f_12375 / var7 * var11;
         BufferBuilder var13 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

         for (int var14 = 0; var14 <= var8; var14++) {
            float var15 = (float)var14 / var8;
            float var16 = var12 + var15 * f_12376 * 2.0F + var5 * f_12377;
            float var17 = var9 * var15;
            float var18 = var10 * (1.0F - var15 * var15);
            float var19 = f_12378 * (1.0F - var15 * f_12379);
            float var20 = f_12380 * MathHelper.sin(var5 * f_12381 + var14 * f_12382 + var11);
            var18 += var20;
            float var21 = MathHelper.sin(var16) * (var17 - var19);
            float var22 = MathHelper.cos(var16) * (var17 - var19);
            float var23 = MathHelper.sin(var16) * (var17 + var19);
            float var24 = MathHelper.cos(var16) * (var17 + var19);
            int var25 = EnergyClient.getTheme((int)(var15 * f_12383) + var11 * 50 + (int)(var5 * f_12384));
            float var26 = (1.0F - var15 * f_12385) * (f_12386 + f_12387 * MathHelper.sin(var5 * f_12388 + var14 * f_12389));
            int var27 = this.m_549(Util71.m_3793(var25, 65), var26);
            this.m_1107(var13, var6, var21, var18, var22, var27);
            this.m_1107(var13, var6, var23, var18, var24, var27);
         }

         RenderUtil12.I(var13.end());
      }

      for (int var28 = 0; var28 < var7; var28++) {
         float var30 = f_12390 / var7 * var28;
         BufferBuilder var32 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

         for (int var34 = 0; var34 <= var8; var34++) {
            float var35 = (float)var34 / var8;
            float var36 = var30 + var35 * f_12391 * 2.0F + var5 * f_12392;
            float var37 = var9 * var35;
            float var39 = var10 * (1.0F - var35 * var35);
            float var40 = f_12393 * (1.0F - var35 * f_12394);
            float var41 = MathHelper.sin(var36) * (var37 - var40);
            float var42 = MathHelper.cos(var36) * (var37 - var40);
            float var43 = MathHelper.sin(var36) * (var37 + var40);
            float var44 = MathHelper.cos(var36) * (var37 + var40);
            int var45 = EnergyClient.getTheme((int)(var35 * f_12395) + var28 * 50 + (int)(var5 * f_12396));
            float var46 = (1.0F - var35 * f_12397) * f_12398;
            int var47 = this.m_549(var45, var46);
            this.m_1107(var32, var6, var41, var39, var42, var47);
            this.m_1107(var32, var6, var43, var39, var44, var47);
         }

         RenderUtil12.I(var32.end());
      }

      float var29 = f_12399 + f_12400 * MathHelper.sin(var5 * f_12401);
      int var31 = this.m_549(Util71.m_3793(EnergyClient.getTheme(0), 180), f_12402);
      BufferBuilder var33 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
      this.m_1107(var33, var6, -var29, var10 + var29, 0.0F, var31);
      this.m_1107(var33, var6, var29, var10 + var29, 0.0F, var31);
      this.m_1107(var33, var6, -var29, var10 - var29, 0.0F, var31);
      this.m_1107(var33, var6, var29, var10 - var29, 0.0F, var31);
      RenderUtil12.I(var33.end());
      this.m_3650();
      var1.pop();
   }

   private void m_2033(MatrixStack var1, ModelWithHead var2, float var3, float var4) {
      var1.push();
      ModelPart var5 = var2.getHead();
      var5.applyTransform(var1);
      this.m_2730();
      Util114.m_2977(2.0F);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      var1.translate(0.0, -var4, 0.0);
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_12262));
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_12263));
      Matrix4f var6 = var1.peek().getPositionMatrix();
      BufferBuilder var7 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

      for (int var8 = 0; var8 <= 180; var8++) {
         float var9 = var8 * f_12264;
         int var10 = var8 * 8;
         int var11 = EnergyClient.getTheme(0);
         float var12 = MathHelper.sin(var9) * var3;
         float var13 = MathHelper.cos(var9) * var3;
         int var14 = Util71.m_1784(3, var10, EnergyClient.getTheme(0), Util71.m_2101(EnergyClient.getTheme(90), f_12265));
         int var15 = this.m_549(var14, f_12266);
         this.m_1107(var7, var6, var12, 0.0F, var13, var15);
         this.m_1107(var7, var6, 0.0F, f_12267, 0.0F, var11);
      }

      RenderUtil12.I(var7.end());
      Util114.m_1878(false);
      BufferBuilder var18 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);
      int var19 = 0;
      float var20 = 0.0F;
      float var21 = 0.0F;

      for (int var22 = 0; var22 <= 180; var22++) {
         float var23 = var22 * f_12268;
         int var24 = var22 * 8;
         float var25 = MathHelper.sin(var23) * var3;
         float var16 = MathHelper.cos(var23) * var3;
         int var17 = Util71.m_1784(3, var24, EnergyClient.getTheme(0), Util71.m_2101(EnergyClient.getTheme(90), f_12269));
         if (var22 == 0) {
            var19 = var17;
            var20 = var25;
            var21 = var16;
         }

         this.m_1107(var18, var6, var25, 0.0F, var16, var17);
      }

      this.m_1107(var18, var6, var20, 0.0F, var21, var19);
      RenderUtil12.I(var18.end());
      Util114.m_1878(true);
      GL11.glDisable(2848);
      this.m_3650();
      var1.pop();
   }

   private void m_3649(MatrixStack var1, ModelWithHead var2, float var3, float var4) {
      var1.push();
      var2.getHead().applyTransform(var1);
      this.m_2730();
      Util114.m_1206(770, 1, 0, 1);
      float var5 = (float)(System.currentTimeMillis() % f_12300) * f_12301;
      float var6 = f_12302 * MathHelper.sin(var5 * 2.0F);
      var1.translate(0.0, -(var4 + f_12303) + var6, 0.0);
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_12304));
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var5 * f_12305));
      float var7 = f_12306 * MathHelper.sin(var5 * f_12307);
      float var8 = f_12308 * MathHelper.cos(var5 * f_12309);
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var7));
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var8));
      byte var9 = 6;
      float var10 = var3 * f_12310;
      float var11 = f_12311;
      float var12 = f_12312;
      float var13 = f_12313;
      float[][] var14 = new float[var9][2];

      for (int var15 = 0; var15 < var9; var15++) {
         float var16 = f_12314 / var9 * var15;
         var14[var15][0] = MathHelper.sin(var16) * var10;
         var14[var15][1] = MathHelper.cos(var16) * var10;
      }

      Matrix4f var29 = var1.peek().getPositionMatrix();
      BufferBuilder var30 = Tessellator.getInstance().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);

      for (int var17 = 0; var17 < var9; var17++) {
         int var18 = (var17 + 1) % var9;
         float var19 = f_12315 + f_12316 * MathHelper.sin(var5 * f_12317 + var17 * f_12318);
         int var20 = EnergyClient.getTheme(var17 * (360 / var9) + (int)(var5 * f_12319));
         int var21 = this.m_549(Util71.m_3793(var20, (int)(var19 * f_12320)), f_12321);
         int var22 = this.m_549(Util71.m_2101(var20, f_12322), f_12323);
         this.m_1107(var30, var29, 0.0F, var11, 0.0F, var21);
         this.m_1107(var30, var29, var14[var17][0], var12, var14[var17][1], var21);
         this.m_1107(var30, var29, var14[var18][0], var12, var14[var18][1], var21);
         this.m_1107(var30, var29, 0.0F, var13, 0.0F, var22);
         this.m_1107(var30, var29, var14[var18][0], var12, var14[var18][1], var22);
         this.m_1107(var30, var29, var14[var17][0], var12, var14[var17][1], var22);
      }

      RenderUtil12.I(var30.end());
      float var31 = f_12324 + f_12325 * MathHelper.sin(var5 * f_12326);
      float var32 = var10 * var31;
      float[][] var33 = new float[var9][2];

      for (int var34 = 0; var34 < var9; var34++) {
         float var36 = f_12327 / var9 * var34;
         var33[var34][0] = MathHelper.sin(var36) * var32;
         var33[var34][1] = MathHelper.cos(var36) * var32;
      }

      BufferBuilder var35 = Tessellator.getInstance().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
      float var37 = var12 + (var11 - var12) * var31;
      float var38 = var12 - (var12 - var13) * var31;

      for (int var23 = 0; var23 < var9; var23++) {
         int var24 = (var23 + 1) % var9;
         int var25 = EnergyClient.getTheme(var23 * (360 / var9) + (int)(var5 * f_12328));
         int var26 = this.m_549(var25, f_12329 + f_12330 * MathHelper.sin(var5 * f_12331 + var23));
         this.m_1107(var35, var29, 0.0F, var37, 0.0F, var26);
         this.m_1107(var35, var29, var33[var23][0], var12, var33[var23][1], var26);
         this.m_1107(var35, var29, var33[var24][0], var12, var33[var24][1], var26);
         this.m_1107(var35, var29, 0.0F, var38, 0.0F, var26);
         this.m_1107(var35, var29, var33[var24][0], var12, var33[var24][1], var26);
         this.m_1107(var35, var29, var33[var23][0], var12, var33[var23][1], var26);
      }

      RenderUtil12.I(var35.end());
      Util114.m_1878(false);
      Util114.m_2977(2.0F);
      GL11.glEnable(2848);

      for (int var39 = 0; var39 < var9; var39++) {
         int var40 = (var39 + 1) % var9;
         int var41 = EnergyClient.getTheme(var39 * (360 / var9) + (int)(var5 * f_12332));
         int var42 = this.m_549(Util71.m_3793(var41, 140), f_12333);
         BufferBuilder var27 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);
         this.m_1107(var27, var29, 0.0F, var11, 0.0F, var42);
         this.m_1107(var27, var29, var14[var39][0], var12, var14[var39][1], var42);
         this.m_1107(var27, var29, var14[var40][0], var12, var14[var40][1], var42);
         this.m_1107(var27, var29, 0.0F, var11, 0.0F, var42);
         RenderUtil12.I(var27.end());
         BufferBuilder var28 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);
         this.m_1107(var28, var29, 0.0F, var13, 0.0F, var42);
         this.m_1107(var28, var29, var14[var39][0], var12, var14[var39][1], var42);
         RenderUtil12.I(var28.end());
      }

      GL11.glDisable(2848);
      Util114.m_1878(true);
      this.m_3650();
      var1.pop();
   }
}
