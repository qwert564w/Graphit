package su.energyclient.util;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import su.energyclient.render.RenderUtil2;
import su.energyclient.render.RenderUtil26;
import su.energyclient.render.RenderUtil3;

public final class Util5 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_5268 = 7.0F;
   private static final float f_5269 = 0.0F;
   private static final float f_5270 = 0.0F;
   private static final float f_5271 = 0.0F;
   private final Map<String, Util165> f_5272 = new HashMap<>();
   private final Util165 f_5273;
   private final Util165 f_5274;
   private final Util165 f_5275;
   private final RenderUtil26.JyPPeWE08Nc2NqHK f_5276;
   private Util150 f_5277;
   private Util30 f_5278;
   private List<Util30> f_5279;
   private String f_5280;
   private Util150 f_5281;
   private float f_5282;
   private float f_5283;
   private float f_5284;
   private float f_5285;
   private float f_5286;
   private float f_5287;
   private float f_5288;
   private float f_5289;
   private float f_5290;
   private boolean f_5291;
   private static final long f_5292 = 180L;
   private static final long f_5293 = 180L;
   private static final long f_5294 = 150L;
   private static final float f_5295 = 155.0F;
   private static final float f_5296 = -5.0F;
   private static final float f_5297 = 0.01F;
   private static final float f_5298 = 255.0F;
   private static final String f_5299 = "Косметика";
   private static final float f_5300 = 7.0F;
   private static final int f_5301 = 15790323;
   private static final String f_5302 = "Показ";
   private static final float f_5303 = 48.0F;
   private static final float f_5304 = 8.0F;
   private static final int f_5305 = 10264230;
   private static final float f_5306 = 23.0F;
   private static final float f_5307 = 22.0F;
   private static final float f_5308 = 13.0F;
   private static final float f_5309 = 6.0F;
   private static final int f_5310 = 2697777;
   private static final float f_5311 = 16.5F;
   private static final float f_5312 = 8.7F;
   private static final float f_5313 = 8.5F;
   private static final float f_5314 = 9.0F;
   private static final int f_5315 = 15922170;
   private static final float f_5316 = 4.0F;
   private static final float f_5317 = 3.0F;
   private static final float f_5318 = 22.0F;
   private static final float f_5319 = 16.0F;
   private static final float f_5320 = 22.0F;
   private static final float f_5321 = 16.0F;
   private static final float f_5322 = 5.0F;
   private static final float f_5323 = 0.27F;
   private static final int f_5324 = 2039848;
   private static final int f_5325 = 1513502;
   private static final String f_5326 = "На голову";
   private static final float f_5327 = 29.0F;
   private static final int f_5328 = 9935267;
   private static final float f_5329 = 11.0F;
   private static final float f_5330 = 44.0F;
   private static final float f_5331 = 44.0F;
   private static final float f_5332 = 44.0F;
   private static final float f_5333 = 7.0F;
   private static final float f_5334 = 44.0F;
   private static final float f_5335 = 87.0F;
   private static final float f_5336 = 80.0F;
   private static final float f_5337 = 44.0F;
   private static final float f_5338 = 44.0F;
   private static final float f_5339 = 80.0F;
   private static final float f_5340 = 44.0F;
   private static final double f_5341 = 0.42;
   private static final int f_5342 = 2566192;
   private static final float f_5343 = 0.83F;
   private static final float f_5344 = 80.0F;
   private static final float f_5345 = 8.0F;
   private static final float f_5346 = 0.7F;
   private static final float f_5347 = 0.7F;
   private static final float f_5348 = 1.4F;
   private static final float f_5349 = 78.6F;
   private static final float f_5350 = 7.5F;
   private static final int f_5351 = 1381916;
   private static final float f_5352 = 4.0F;
   private static final float f_5353 = 52.0F;
   private static final float f_5354 = 7.0F;
   private static final float f_5355 = 0.18F;
   private static final int f_5356 = 1513503;
   private static final int f_5357 = 1447708;
   private static final float f_5358 = 0.12F;
   private static final float f_5359 = 0.7F;
   private static final float f_5360 = 0.3F;
   private static final float f_5361 = 0.25F;
   private static final float f_5362 = 47.0F;
   private static final float f_5363 = 0.5F;
   private static final float f_5364 = 5.0F;
   private static final float f_5365 = 2.5F;
   private static final int f_5366 = 789778;
   private static final float f_5367 = 3.0F;
   private static final float f_5368 = 3.0F;
   private static final float f_5369 = 6.0F;
   private static final float f_5370 = 49.0F;
   private static final float f_5371 = 155.0F;
   private static final float f_5372 = -20.0F;
   private static final float f_5373 = -5.0F;
   private static final float f_5374 = 7.0F;
   private static final float f_5375 = 59.0F;
   private static final int f_5376 = 16777215;
   private static final int f_5377 = 13882846;
   private static final float f_5378 = 12.0F;
   private static final float f_5379 = 8.0F;
   private static final float f_5380 = 72.0F;
   private static final float f_5381 = 3.5F;
   private static final int f_5382 = 11317441;
   private static final int f_5383 = 5330014;
   private static final String f_5384 = "Надето";
   private static final String f_5385 = "Примерка";
   private static final String f_5386 = "Посмотреть";
   private static final float f_5387 = 13.0F;
   private static final float f_5388 = 71.0F;
   private static final int f_5389 = 7961996;
   private static final String f_5390 = "Ничего не найдено";
   private static final float f_5391 = 12.0F;
   private static final float f_5392 = 44.0F;
   private static final float f_5393 = 66.0F;
   private static final int f_5394 = 10659247;
   private static final String f_5395 = "Попробуйте другое название";
   private static final float f_5396 = 7.0F;
   private static final float f_5397 = 44.0F;
   private static final float f_5398 = 79.0F;
   private static final int f_5399 = 6514549;
   private static final String f_5400 = "Колесо мыши — ещё предметы";
   private static final String f_5401 = "Выберите предмет для примерки";
   private static final float f_5402 = 4.0F;
   private static final int f_5403 = 6448753;
   private static final float f_5404 = 44.0F;
   private static final float f_5405 = 108.0F;
   private static final float f_5406 = 9.0F;
   private static final int f_5407 = 2500656;
   private static final float f_5408 = 0.7F;
   private static final float f_5409 = 0.7F;
   private static final float f_5410 = 106.6F;
   private static final float f_5411 = 1.4F;
   private static final float f_5412 = 8.5F;
   private static final int f_5413 = 1184794;
   private static final float f_5414 = 8.0F;
   private static final float f_5415 = 10.0F;
   private static final int f_5416 = 15790582;
   private static final float f_5417 = 92.0F;
   private static final float f_5418 = 8.0F;
   private static final float f_5419 = 21.0F;
   private static final float f_5420 = 92.0F;
   private static final int f_5421 = 8488597;
   private static final float f_5422 = 7.0F;
   private static final float f_5423 = 16.0F;
   private static final float f_5424 = 94.0F;
   private static final float f_5425 = 13.0F;
   private static final float f_5426 = 30.0F;
   private static final float f_5427 = 79.0F;
   private static final float f_5428 = 3.0F;
   private static final float f_5429 = 102.0F;
   private static final float f_5430 = 8.0F;
   private static final float f_5431 = 0.19F;
   private static final int f_5432 = 1316641;
   private static final int f_5433 = 1250846;
   private static final float f_5434 = 0.1F;
   private static final float f_5435 = 19.0F;
   private static final float f_5436 = 8.0F;
   private static final float f_5437 = 70.0F;
   private static final float f_5438 = 5.0F;
   private static final float f_5439 = 2.5F;
   private static final int f_5440 = 592658;
   private static final float f_5441 = 4.0F;
   private static final float f_5442 = 100.0F;
   private static final float f_5443 = 4.0F;
   private static final String f_5444 = "Вращение модели";
   private static final String f_5445 = "Зажмите и вращайте";
   private static final float f_5446 = 108.0F;
   private static final float f_5447 = 43.0F;
   private static final int f_5448 = 7962254;
   private static final float f_5449 = 7.0F;
   private static final float f_5450 = 29.0F;
   private static final float f_5451 = 94.0F;
   private static final float f_5452 = 20.0F;
   private static final int f_5453 = 2369329;
   private static final int f_5454 = 3422277;
   private static final float f_5455 = 0.72F;
   private static final float f_5456 = 0.32F;
   private static final float f_5457 = 7.0F;
   private static final float f_5458 = 29.0F;
   private static final float f_5459 = 94.0F;
   private static final float f_5460 = 20.0F;
   private static final float f_5461 = 6.0F;
   private static final String f_5462 = "Снять";
   private static final String f_5463 = "Надеть";
   private static final float f_5464 = 108.0F;
   private static final float f_5465 = 20.0F;
   private static final int f_5466 = 13883363;
   private static final int f_5467 = 16316927;
   private static final float f_5468 = 0.04F;
   private static final float f_5469 = 50.0F;
   private static final float f_5470 = 50.0F;
   private static final float f_5471 = 18.0F;
   private static final float f_5472 = 4.0F;
   private static final float f_5473 = 3.0F;
   private static final float f_5474 = 22.0F;
   private static final float f_5475 = 16.0F;
   private static final float f_5476 = 7.0F;
   private static final float f_5477 = 29.0F;
   private static final float f_5478 = 94.0F;
   private static final float f_5479 = 20.0F;
   private static final float f_5480 = 3.0F;
   private static final float f_5481 = 44.0F;
   private static final float f_5482 = 30.0F;
   private static final float f_5483 = 102.0F;
   private static final float f_5484 = 79.0F;
   private static final float f_5485 = 44.0F;
   private static final float f_5486 = 11.0F;
   private static final float f_5487 = 7.0F;
   private static final float f_5488 = 44.0F;
   private static final float f_5489 = 87.0F;
   private static final float f_5490 = 80.0F;
   private static final float f_5491 = 1.7F;
   private static final float f_5492 = 0.65F;
   private static final float f_5493 = -30.0F;
   private static final float f_5494 = 30.0F;
   private static final float f_5495 = 0.04F;
   private static final float f_5496 = 44.0F;
   private static final float f_5497 = 11.0F;
   private static final float f_5498 = 28.0F;
   private static final float f_5499 = 155.0F;
   private static final float f_5500 = -20.0F;
   private static final float f_5501 = -5.0F;
   private static final float f_5502 = 108.0F;
   private static final float f_5503 = 7.0F;
   private static final float f_5504 = 7.0F;
   private static final float f_5505 = 0.5F;
   private static final float f_5506 = 108.0F;
   private static final float f_5507 = 44.0F;
   private static final float f_5508 = 87.0F;
   private static final float f_5509 = 7.0F;
   private static final float f_5510 = 11.0F;
   private static final float f_5511 = 2.2F;
   private static final float f_5512 = 5.6F;
   private static final float f_5513 = 0.8F;
   private static final float f_5514 = 4.0F;
   private static final float f_5515 = 2.2F;
   private static final float f_5516 = 7.6F;
   private static final float f_5517 = 0.8F;
   private static final float f_5518 = 8.0F;
   private static final float f_5519 = 2.2F;
   private static final float f_5520 = 5.6F;
   private static final float f_5521 = 0.8F;
   private static final float f_5522 = 6.1F;
   private static final float f_5523 = 10.2F;
   private static final float f_5524 = 0.7F;
   private static final long f_5525 = 160L;

   private float m_1439() {
      return this.f_5284 - f_5502 - f_5503;
   }

   public boolean m_2894(int var1, double var2, double var4) {
      if (this.f_5291 && var1 == 0) {
         this.f_5289 = MathHelper.wrapDegrees(this.f_5289 + (float)var2 * f_5491);
         this.f_5290 = MathHelper.clamp(this.f_5290 + (float)var4 * f_5492, f_5493, f_5494);
         return true;
      } else {
         return false;
      }
   }

   private float m_3912() {
      return this.f_5285 - f_5507;
   }

   public Util5() {
      this.f_5273 = new Util165(Util153.EASE_OUT_CUBIC, f_5292);
      this.f_5274 = new Util165(Util153.EASE_OUT_CUBIC, f_5293);
      this.f_5275 = new Util165(Util153.EASE_OUT_CUBIC, f_5294);
      this.f_5276 = new RenderUtil26.JyPPeWE08Nc2NqHK();
      this.f_5277 = Util150.WINGS;
      this.f_5279 = List.of();
      this.f_5289 = f_5295;
      this.f_5290 = f_5296;
   }

   private float m_1705() {
      float var1 = (this.f_5279.size() + 1) / 2 * f_5508 - f_5509;
      return Math.min(0.0F, this.m_3912() - f_5510 - Math.max(0.0F, var1));
   }

   private void m_2199(DrawContext var1, int var2, int var3, int var4, int var5, RenderUtil3 var6) {
      float var7 = this.m_3169();
      float var8 = this.f_5283 + f_5404;
      float var9 = this.m_3912();
      Util158.m_1849(var7, var8, f_5405, var9, f_5406, m_2355(f_5407, var5));
      Util158.m_1849(var7 + f_5408, var8 + f_5409, f_5410, var9 - f_5411, f_5412, m_2355(f_5413, var5));
      if (this.f_5278 != null) {
         Util93.f_6001[14].m_1904(var1, this.f_5278.name(), var7 + f_5414, var8 + f_5415, m_2355(f_5416, var5), f_5417);
         Util93.f_6002[10]
            .m_1710(
               var1,
               this.f_5278.description(),
               var7 + f_5418,
               var8 + f_5419,
               f_5420,
               m_2355(f_5421, var5),
               m_1881(var2, var3, var7 + f_5422, var8 + f_5423, f_5424, f_5425),
               this.f_5276
            );
         float var10 = var8 + f_5426;
         float var11 = var9 - f_5427;
         Util158.m_3404(
            var7 + f_5428, var10, f_5429, var11, f_5430, Util71.m_2101(this.f_5278.accent(), f_5431), f_5432, f_5433, Util71.m_2101(var4, f_5434), this.f_5286
         );
         Util158.m_1849(var7 + f_5435, var10 + var11 - f_5436, f_5437, f_5438, f_5439, m_2355(f_5440, var5));
         Util73.m_798(var1, this.f_5278, var7 + f_5441, var10 + 2.0F, f_5442, var11 - f_5443, this.f_5289, this.f_5290, this.f_5286);
         String var12 = this.f_5291 ? f_5444 : f_5445;
         Util93.f_6002[10]
            .m_2915(var1, var12, var7 + (f_5446 - Util93.f_6002[10].m_585(var12)) / 2.0F, var8 + var9 - f_5447, m_2355(this.f_5291 ? var4 : f_5448, var5));
         boolean var13 = var6.m_1396(this.f_5278);
         boolean var14 = m_1881(var2, var3, var7 + f_5449, var8 + var9 - f_5450, f_5451, f_5452);
         this.f_5275.m_3631(var14 ? 1.0 : 0.0);
         float var15 = (float)this.f_5275.m_2276();
         int var16 = var13 ? Util71.m_2924(f_5453, f_5454, var15) : Util71.m_2924(Util71.m_2101(var4, f_5455), var4, var15 * f_5456);
         Util158.m_1849(var7 + f_5457, var8 + var9 - f_5458, f_5459, f_5460, f_5461, m_2355(var16, var5));
         String var17 = var13 ? f_5462 : f_5463;
         Util93.f_6003[13]
            .m_2915(var1, var17, var7 + (f_5464 - Util93.f_6003[13].m_585(var17)) / 2.0F, var8 + var9 - f_5465, m_2355(var13 ? f_5466 : f_5467, var5));
      }
   }

   public void m_580() {
      this.f_5287 = 0.0F;
      this.f_5288 = 0.0F;
      this.f_5274.m_2214(0.0);
      this.f_5274.m_2946(0.0);
      this.f_5274.m_1829(0.0);
      this.f_5274.l(true);
   }

   private static boolean m_1881(double var0, double var2, float var4, float var5, float var6, float var7) {
      return Util39.m_121(var0, var2, var4, var5, var6, var7);
   }

   public static void m_438(float var0, float var1, int var2) {
      Util158.m_1849(var0, var1 + 2.0F, f_5511, f_5512, f_5513, var2);
      Util158.m_1849(var0 + f_5514, var1, f_5515, f_5516, f_5517, var2);
      Util158.m_1849(var0 + f_5518, var1 + 2.0F, f_5519, f_5520, f_5521, var2);
      Util158.m_1849(var0, var1 + f_5522, f_5523, 2.0F, f_5524, var2);
   }

   private static int m_2355(int var0, int var1) {
      return Util71.m_3389(var0, var1);
   }

   public void m_1283() {
      this.f_5291 = false;
   }

   public boolean m_1185(double var1, double var3, double var5) {
      if (!(this.f_5286 <= f_5495) && m_1881(var1, var3, this.f_5282, this.f_5283 + f_5496, this.m_1439(), this.m_3912() - f_5497)) {
         this.f_5287 = MathHelper.clamp(this.f_5287 + (float)var5 * f_5498, this.m_1705(), 0.0F);
         return true;
      } else {
         return false;
      }
   }

   private void m_1102(Util30 var1) {
      boolean var2 = this.f_5278 == null || this.f_5278.slot() != var1.slot();
      if (this.f_5278 == null || !this.f_5278.id().equals(var1.id())) {
         this.f_5276.f_11519 = false;
      }

      this.f_5278 = var1;
      if (var2) {
         this.f_5289 = var1.slot() == Util150.WINGS ? f_5499 : f_5500;
         this.f_5290 = f_5501;
      }

      this.m_1283();
   }

   private void m_1820(DrawContext var1, int var2, int var3, int var4, int var5, RenderUtil3 var6) {
      float var7 = this.m_3912() - f_5329;
      RenderUtil2.m_3624(this.f_5282, this.f_5283 + f_5330, this.m_1439(), var7);
      var1.enableScissor(
         (int)Math.floor(this.f_5282),
         (int)Math.floor(this.f_5283 + f_5331),
         (int)Math.ceil(this.f_5282 + this.m_1439()),
         (int)Math.ceil(this.f_5283 + f_5332 + var7)
      );

      try {
         for (int var8 = 0; var8 < this.f_5279.size(); var8++) {
            Util30 var9 = this.f_5279.get(var8);
            float var10 = this.f_5282 + var8 % 2 * (this.m_874() + f_5333);
            float var11 = this.f_5283 + f_5334 + var8 / 2 * f_5335 + this.f_5288;
            if (!(var11 + f_5336 <= this.f_5283 + f_5337) && !(var11 >= this.f_5283 + f_5338 + var7)) {
               boolean var12 = this.f_5278 != null && this.f_5278.id().equals(var9.id());
               boolean var13 = var6.m_1396(var9);
               boolean var14 = m_1881(var2, var3, var10, var11, this.m_874(), f_5339)
                  && m_1881(var2, var3, this.f_5282, this.f_5283 + f_5340, this.m_1439(), var7);
               Util165 var15 = this.f_5272.computeIfAbsent(var9.id(), var0 -> new Util165(Util153.EASE_OUT_CUBIC, f_5525));
               var15.m_3631(var12 ? 1.0 : (var14 ? f_5341 : 0.0));
               float var16 = (float)var15.m_2276();
               int var17 = Util71.m_2924(f_5342, var4, var16 * f_5343);
               Util158.m_1849(var10, var11, this.m_874(), f_5344, f_5345, m_2355(var17, var5));
               Util158.m_1849(var10 + f_5346, var11 + f_5347, this.m_874() - f_5348, f_5349, f_5350, m_2355(f_5351, var5));
               Util158.m_3404(
                  var10 + 2.0F,
                  var11 + 2.0F,
                  this.m_874() - f_5352,
                  f_5353,
                  f_5354,
                  Util71.m_2101(var9.accent(), f_5355),
                  f_5356,
                  f_5357,
                  Util71.m_2101(var4, f_5358),
                  this.f_5286 * (f_5359 + f_5360 * var16)
               );
               Util158.m_1849(var10 + this.m_874() * f_5361, var11 + f_5362, this.m_874() * f_5363, f_5364, f_5365, m_2355(f_5366, var5));
               Util73.m_798(
                  var1,
                  var9,
                  var10 + f_5367,
                  var11 + f_5368,
                  this.m_874() - f_5369,
                  f_5370,
                  var9.slot() == Util150.WINGS ? f_5371 : f_5372,
                  f_5373,
                  this.f_5286
               );
               Util93.f_6001[13].m_1904(var1, var9.name(), var10 + f_5374, var11 + f_5375, m_2355(var12 ? f_5376 : f_5377, var5), this.m_874() - f_5378);
               Util158.m_1115(var10 + f_5379, var11 + f_5380, f_5381, m_2355(var13 ? var4 : (var12 ? f_5382 : f_5383), var5));
               Util93.f_6002[11].m_2915(var1, var13 ? f_5384 : (var12 ? f_5385 : f_5386), var10 + f_5387, var11 + f_5388, m_2355(var13 ? var4 : f_5389, var5));
            }
         }

         if (this.f_5279.isEmpty()) {
            Util93.f_6001[13].m_2915(var1, f_5390, this.f_5282 + f_5391, this.f_5283 + f_5392 + f_5393, m_2355(f_5394, var5));
            Util93.f_6002[11].m_2915(var1, f_5395, this.f_5282 + f_5396, this.f_5283 + f_5397 + f_5398, m_2355(f_5399, var5));
         }
      } finally {
         var1.disableScissor();
         RenderUtil2.m_1647();
      }

      Util93.f_6002[10].m_2915(var1, this.m_1705() < 0.0F ? f_5400 : f_5401, this.f_5282 + 1.0F, this.f_5283 + this.f_5285 - f_5402, m_2355(f_5403, var5));
   }

   private float m_3169() {
      return this.f_5282 + this.f_5284 - f_5506;
   }

   private void m_629(RenderUtil3 var1) {
      Util30 var2 = var1.m_3164(this.f_5277);
      if (var2 != null) {
         this.m_1102(var2);
      } else {
         Util69.m_2197(this.f_5277).stream().findFirst().ifPresent(this::m_1102);
      }
   }

   public boolean m_4042(double var1, double var3, int var5, boolean var6) {
      if (!m_1881(var1, var3, this.f_5282, this.f_5283, this.f_5284, this.f_5285) || this.f_5286 <= f_5468) {
         return false;
      } else if (var6 && var5 == 0) {
         RenderUtil3 var7 = RenderUtil3.m_844();
         if (m_1881(var1, var3, this.f_5282 + this.f_5284 - f_5469, this.f_5283, f_5470, f_5471)) {
            var7.m_411(!var7.m_1207());
            return true;
         } else {
            float var8 = (this.m_1439() - f_5472) / f_5473;

            for (Util150 var12 : Util150.values()) {
               if (m_1881(var1, var3, this.f_5282 + var12.ordinal() * (var8 + 2.0F), this.f_5283 + f_5474, var8, f_5475)) {
                  if (this.f_5277 != var12) {
                     this.f_5277 = var12;
                     this.f_5278 = null;
                     this.m_1283();
                     this.m_580();
                     this.m_629(var7);
                     this.f_5281 = null;
                  }

                  return true;
               }
            }

            if (m_1881(var1, var3, this.m_3169() + f_5476, this.f_5283 + this.f_5285 - f_5477, f_5478, f_5479)) {
               if (this.f_5278 != null) {
                  if (var7.m_1396(this.f_5278)) {
                     var7.m_2325(this.f_5278.slot());
                  } else {
                     var7.m_1399(this.f_5278);
                  }
               }

               return true;
            } else if (m_1881(var1, var3, this.m_3169() + f_5480, this.f_5283 + f_5481 + f_5482, f_5483, this.m_3912() - f_5484)) {
               this.f_5291 = this.f_5278 != null;
               return true;
            } else {
               if (m_1881(var1, var3, this.f_5282, this.f_5283 + f_5485, this.m_1439(), this.m_3912() - f_5486)) {
                  for (int var13 = 0; var13 < this.f_5279.size(); var13++) {
                     float var14 = this.f_5282 + var13 % 2 * (this.m_874() + f_5487);
                     float var15 = this.f_5283 + f_5488 + var13 / 2 * f_5489 + this.f_5288;
                     if (m_1881(var1, var3, var14, var15, this.m_874(), f_5490)) {
                        this.m_1102(this.f_5279.get(var13));
                        return true;
                     }
                  }
               }

               return true;
            }
         }
      } else {
         return true;
      }
   }

   private void I(String var1) {
      String var2 = var1 == null ? "" : var1.strip().toLowerCase(Locale.ROOT);
      if (this.f_5277 != this.f_5281 || !var2.equals(this.f_5280)) {
         this.f_5279 = Util69.m_2197(this.f_5277)
            .stream()
            .filter(
               var1x -> var2.isEmpty()
                  || var1x.name().toLowerCase(Locale.ROOT).contains(var2)
                  || var1x.description().toLowerCase(Locale.ROOT).contains(var2)
                  || var1x.id().toLowerCase(Locale.ROOT).contains(var2)
            )
            .toList();
         this.f_5281 = this.f_5277;
         this.f_5280 = var2;
         this.m_580();
      }
   }

   public void m_2582(DrawContext var1, int var2, int var3, float var4, float var5, float var6, float var7, float var8, int var9, String var10) {
      this.f_5282 = var4;
      this.f_5283 = var5;
      this.f_5284 = var6;
      this.f_5285 = var7;
      this.f_5286 = MathHelper.clamp(var8, 0.0F, 1.0F);
      if (!(this.f_5286 <= f_5297)) {
         RenderUtil3 var11 = RenderUtil3.m_844();
         this.I(var10);
         if (this.f_5278 == null) {
            this.m_629(var11);
         }

         int var12 = (int)(f_5298 * this.f_5286);
         Util93.f_6001[16].m_2915(var1, f_5299, var4 + 1.0F, var5 + f_5300, m_2355(f_5301, var12));
         Util93.f_6001[12].m_2915(var1, f_5302, var4 + var6 - f_5303, var5 + f_5304, m_2355(f_5305, var12));
         this.f_5273.m_3631(var11.m_1207() ? 1.0 : 0.0);
         float var13 = (float)this.f_5273.m_2276();
         Util158.m_1849(var4 + var6 - f_5306, var5 + 2.0F, f_5307, f_5308, f_5309, m_2355(Util71.m_2924(f_5310, var9, var13), var12));
         Util158.m_1115(var4 + var6 - f_5311 + var13 * f_5312, var5 + f_5313, f_5314, m_2355(f_5315, var12));
         float var14 = (this.m_1439() - f_5316) / f_5317;

         for (Util150 var18 : Util150.values()) {
            float var19 = var4 + var18.ordinal() * (var14 + 2.0F);
            boolean var20 = var18 == this.f_5277;
            boolean var21 = m_1881(var2, var3, var19, var5 + f_5318, var14, f_5319);
            Util158.m_1849(var19, var5 + f_5320, var14, f_5321, f_5322, m_2355(var20 ? Util71.m_2101(var9, f_5323) : (var21 ? f_5324 : f_5325), var12));
            String var22 = var18 == Util150.HEADWEAR ? f_5326 : var18.m_3828();
            Util93.f_6003[12].m_2915(var1, var22, var19 + (var14 - Util93.f_6003[12].m_585(var22)) / 2.0F, var5 + f_5327, m_2355(var20 ? var9 : f_5328, var12));
         }

         this.f_5287 = MathHelper.clamp(this.f_5287, this.m_1705(), 0.0F);
         this.f_5274.m_3631(this.f_5287);
         this.f_5288 = (float)this.f_5274.m_2276();
         this.m_1820(var1, var2, var3, var9, var12, var11);
         this.m_2199(var1, var2, var3, var9, var12, var11);
      }
   }

   private float m_874() {
      return (this.m_1439() - f_5504) * f_5505;
   }
}
