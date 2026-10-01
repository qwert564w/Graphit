package su.energyclient.module.movement;

import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.c2s.play.TeleportConfirmC2SPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.module.combat.Macetarget;
import su.energyclient.render.RenderUtil8;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util34;
import su.energyclient.util.Util38;
import su.energyclient.util.Util66;
import su.energyclient.util.Util8;

public class ElytraBooster extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_270 = 1.5;
   private static final double f_271 = 0.0;
   public static final String f_272 = "";
   public static final String f_273 = "";
   public static final String f_274 = "";
   public static final String f_275 = "";
   public static final String f_276 = "";
   public static final String f_277 = "";
   public static final String f_278 = "";
   public final ModeSetting f_279;
   public final NumberSetting f_280;
   public final BooleanSetting f_281;
   public final NumberSetting f_282;
   public final NumberSetting f_283;
   private final NumberSetting f_284;
   private final NumberSetting f_285;
   private final NumberSetting f_286;
   private final NumberSetting f_287;
   private final NumberSetting f_288;
   private final NumberSetting f_289;
   private final NumberSetting f_290;
   private final NumberSetting f_291;
   private final NumberSetting f_292;
   private final NumberSetting f_293;
   private final NumberSetting f_294;
   private final NumberSetting f_295;
   private final NumberSetting f_296;
   private final NumberSetting f_297;
   private final NumberSetting f_298;
   private final NumberSetting f_299;
   private final NumberSetting f_300;
   private final NumberSetting f_301;
   private final NumberSetting[] f_302;
   private final NumberSetting[] f_303;
   private final float[] f_304;
   private final float[] f_305;
   private float f_306;
   private float f_307;
   private final Util34 f_308;
   private boolean f_309;
   private double f_310;
   private static final String f_311 = "Elytra Booster";
   private static final String f_312 = "description";
   private static final String f_313 = "Режим";
   private static final String f_314 = "Статический";
   private static final String f_315 = "Статический";
   private static final String f_316 = "Динамический";
   private static final String f_317 = "Neuro";
   private static final String f_318 = "Кастомный";
   private static final String f_319 = "ReallyWorld";
   private static final String f_320 = "RW 1.21";
   private static final String f_321 = "BravoHvH";
   private static final String f_322 = "Сила Буста";
   private static final float f_323 = 1.5F;
   private static final float f_324 = 0.1F;
   private static final float f_325 = 6.0F;
   private static final float f_326 = 0.05F;
   private static final String f_327 = "Анти Перелет";
   private static final String f_328 = "Дистанция Срабатывания";
   private static final float f_329 = 0.5F;
   private static final float f_330 = 6.0F;
   private static final float f_331 = 0.1F;
   private static final String f_332 = "Скорость Коррекции";
   private static final float f_333 = 1.5F;
   private static final float f_334 = 1.6F;
   private static final float f_335 = 0.1F;
   private static final String f_336 = "Yaw 0-5";
   private static final float f_337 = 1.52F;
   private static final float f_338 = 1.5F;
   private static final float f_339 = 3.0F;
   private static final float f_340 = 0.01F;
   private static final String f_341 = "Yaw 5-10";
   private static final float f_342 = 1.53F;
   private static final float f_343 = 1.5F;
   private static final float f_344 = 3.0F;
   private static final float f_345 = 0.01F;
   private static final String f_346 = "Yaw 10-15";
   private static final float f_347 = 1.54F;
   private static final float f_348 = 1.5F;
   private static final float f_349 = 3.0F;
   private static final float f_350 = 0.01F;
   private static final String f_351 = "Yaw 15-20";
   private static final float f_352 = 1.55F;
   private static final float f_353 = 1.5F;
   private static final float f_354 = 3.0F;
   private static final float f_355 = 0.01F;
   private static final String f_356 = "Yaw 20-25";
   private static final float f_357 = 1.56F;
   private static final float f_358 = 1.5F;
   private static final float f_359 = 3.0F;
   private static final float f_360 = 0.01F;
   private static final String f_361 = "Yaw 25-30";
   private static final float f_362 = 1.57F;
   private static final float f_363 = 1.5F;
   private static final float f_364 = 3.0F;
   private static final float f_365 = 0.01F;
   private static final String f_366 = "Yaw 30-35";
   private static final float f_367 = 1.58F;
   private static final float f_368 = 1.5F;
   private static final float f_369 = 3.0F;
   private static final float f_370 = 0.01F;
   private static final String f_371 = "Yaw 35-40";
   private static final float f_372 = 1.59F;
   private static final float f_373 = 1.5F;
   private static final float f_374 = 3.0F;
   private static final float f_375 = 0.01F;
   private static final String f_376 = "Yaw 40-45";
   private static final float f_377 = 1.6F;
   private static final float f_378 = 1.5F;
   private static final float f_379 = 3.0F;
   private static final float f_380 = 0.01F;
   private static final String f_381 = "Pitch 0-5";
   private static final float f_382 = 1.51F;
   private static final float f_383 = 1.5F;
   private static final float f_384 = 3.0F;
   private static final float f_385 = 0.01F;
   private static final String f_386 = "Pitch 5-10";
   private static final float f_387 = 1.52F;
   private static final float f_388 = 1.5F;
   private static final float f_389 = 3.0F;
   private static final float f_390 = 0.01F;
   private static final String f_391 = "Pitch 10-15";
   private static final float f_392 = 1.53F;
   private static final float f_393 = 1.5F;
   private static final float f_394 = 3.0F;
   private static final float f_395 = 0.01F;
   private static final String f_396 = "Pitch 15-20";
   private static final float f_397 = 1.54F;
   private static final float f_398 = 1.5F;
   private static final float f_399 = 3.0F;
   private static final float f_400 = 0.01F;
   private static final String f_401 = "Pitch 20-25";
   private static final float f_402 = 1.55F;
   private static final float f_403 = 1.5F;
   private static final float f_404 = 3.0F;
   private static final float f_405 = 0.01F;
   private static final String f_406 = "Pitch 25-30";
   private static final float f_407 = 1.56F;
   private static final float f_408 = 1.5F;
   private static final float f_409 = 3.0F;
   private static final float f_410 = 0.01F;
   private static final String f_411 = "Pitch 30-35";
   private static final float f_412 = 1.57F;
   private static final float f_413 = 1.5F;
   private static final float f_414 = 3.0F;
   private static final float f_415 = 0.01F;
   private static final String f_416 = "Pitch 35-40";
   private static final float f_417 = 1.58F;
   private static final float f_418 = 1.5F;
   private static final float f_419 = 3.0F;
   private static final float f_420 = 0.01F;
   private static final String f_421 = "Pitch 40-45";
   private static final float f_422 = 1.59F;
   private static final float f_423 = 1.5F;
   private static final float f_424 = 3.0F;
   private static final float f_425 = 0.01F;
   private static final float f_426 = 1.63F;
   private static final float f_427 = 1.62F;
   private static final float f_428 = 1.66F;
   private static final float f_429 = 1.7F;
   private static final float f_430 = 1.77F;
   private static final float f_431 = 1.83F;
   private static final float f_432 = 1.94F;
   private static final float f_433 = 1.96F;
   private static final float f_434 = 1.96F;
   private static final float f_435 = 1.62F;
   private static final float f_436 = 1.63F;
   private static final float f_437 = 1.64F;
   private static final float f_438 = 1.67F;
   private static final float f_439 = 1.77F;
   private static final float f_440 = 1.84F;
   private static final float f_441 = 1.97F;
   private static final float f_442 = 1.98F;
   private static final float f_443 = 1.99F;
   private static final double f_444 = 1.5;
   private static final String f_445 = "Neuro";
   private static final String f_446 = "Статический";
   private static final String f_447 = "Динамический";
   private static final String f_448 = "Neuro";
   private static final String f_449 = "Кастомный";
   private static final String f_450 = "ReallyWorld";
   private static final String f_451 = "RW 1.21";
   private static final String f_452 = "BravoHvH";
   private static final String f_453 = "Neuro";
   private static final String f_454 = "Neuro";
   private static final double f_455 = 0.1;
   private static final double f_456 = 1.5;
   private static final double f_457 = 33.5;
   private static final float f_458 = 5.0F;
   private static final float f_459 = 5.0F;
   private static final float f_460 = 90.0F;
   private static final float f_461 = 180.0F;
   private static final float f_462 = 45.0F;
   private static final float f_463 = 90.0F;
   private static final float f_464 = 5.0F;
   private static final float f_465 = 1.5F;
   private static final float f_466 = 1.5F;
   private static final float f_467 = 1.5F;
   private static final float f_468 = 1.5F;
   private static final float f_469 = 1.7F;
   private static final float f_470 = 1.81F;
   private static final float f_471 = 1.81F;
   private static final float f_472 = 5.0F;
   private static final float f_473 = 1.5F;
   private static final float f_474 = 1.5F;
   private static final float f_475 = 1.5F;
   private static final float f_476 = 1.5F;
   private static final float f_477 = 1.5F;
   private static final float f_478 = 1.5F;
   private static final float f_479 = 1.75F;
   private static final float f_480 = 1.9F;
   private static final float f_481 = 5.0F;
   private static final float f_482 = 1.6F;
   private static final float f_483 = 1.63F;
   private static final float f_484 = 1.66F;
   private static final float f_485 = 1.71F;
   private static final float f_486 = 1.73F;
   private static final float f_487 = 1.81F;
   private static final float f_488 = 1.81F;
   private static final float f_489 = 1.81F;
   private static final float f_490 = 1.81F;
   private static final float f_491 = 5.0F;
   private static final float f_492 = 1.6F;
   private static final float f_493 = 1.62F;
   private static final float f_494 = 1.6F;
   private static final float f_495 = 1.62F;
   private static final float f_496 = 1.64F;
   private static final float f_497 = 1.68F;
   private static final float f_498 = 1.75F;
   private static final float f_499 = 1.9F;
   private static final float f_500 = 2.16F;
   private static final float f_501 = 5.0F;
   private static final float f_502 = 1.65F;
   private static final float f_503 = 1.68F;
   private static final float f_504 = 1.73F;
   private static final float f_505 = 1.78F;
   private static final float f_506 = 1.84F;
   private static final float f_507 = 1.89F;
   private static final float f_508 = 1.98F;
   private static final float f_509 = 2.05F;
   private static final float f_510 = 2.04F;
   private static final float f_511 = 5.0F;
   private static final float f_512 = 1.61F;
   private static final float f_513 = 1.66F;
   private static final float f_514 = 1.76F;
   private static final float f_515 = 1.84F;
   private static final float f_516 = 1.87F;
   private static final float f_517 = 1.93F;
   private static final float f_518 = 1.98F;
   private static final float f_519 = 2.05F;
   private static final float f_520 = 2.04F;
   private static final String f_521 = "Кастомный";
   private static final String f_522 = "Кастомный";
   private static final String f_523 = "Кастомный";
   private static final String f_524 = "Кастомный";
   private static final String f_525 = "Кастомный";
   private static final String f_526 = "Кастомный";
   private static final String f_527 = "Кастомный";
   private static final String f_528 = "Кастомный";
   private static final String f_529 = "Кастомный";
   private static final String f_530 = "Кастомный";
   private static final String f_531 = "Кастомный";
   private static final String f_532 = "Кастомный";
   private static final String f_533 = "Кастомный";
   private static final String f_534 = "Кастомный";
   private static final String f_535 = "Кастомный";
   private static final String f_536 = "Кастомный";
   private static final String f_537 = "Кастомный";
   private static final String f_538 = "Кастомный";
   private static final String f_539 = "Статический";

   private double m_3517() {
      LivingEntity var1 = this.m_1646();
      if (var1 == null) {
         return this.f_283.m_4046();
      } else {
         double var2 = Util38.m_2137(var1);
         if (var2 <= 0.0) {
            return this.f_283.m_4046();
         } else {
            double var4 = var2 * f_456 / f_457;
            return MathHelper.clamp(var4, this.f_283.m_925(), this.f_280.m_2596());
         }
      }
   }

   @EventHandler
   public void m_3838(RenderUtil8 var1) {
      this.f_309 = false;
      this.f_310 = this.f_283.m_4046();
      if (Macetarget.m_329()) {
         this.f_308.m_3322();
      } else {
         if (!this.f_279.m_2073(f_445)) {
            this.f_308.m_3322();
         }

         if (f_5909.player == null) {
            this.f_308.m_3322();
         } else if (this.f_281.m_1163() && this.m_2947()) {
            this.f_308.m_3322();
            double var11 = this.m_3517();
            this.f_309 = true;
            this.f_310 = var11;
            var1.m_4142(new Vec3d(var11, var11, var11));
         } else if (this.f_279.m_2073(f_446)) {
            double var10 = this.f_280.m_4046();
            var1.m_4142(new Vec3d(var10, var10, var10));
         } else if (this.f_279.m_2073(f_447)) {
            var1.m_1303(Util8.m_2252(f_5909.player));
         } else if (this.f_279.m_2073(f_448)) {
            Util34.mLtmL0uyhGuxQYhV var9 = this.f_308.m_3385(f_5909.player);
            this.f_306 = var9.horizontal();
            this.f_307 = var9.vertical();
            var1.m_4142(new Vec3d(var9.horizontal(), var9.vertical(), var9.horizontal()));
         } else if (this.f_279.m_2073(f_449)) {
            float var8 = MathHelper.wrapDegrees(f_5909.player.getYaw());
            float var14 = f_5909.player.getPitch();
            float var17 = this.m_2296(var8);
            float var20 = this.m_2723(var14);
            if (var20 > var17) {
               var17 = var20;
            }

            this.f_306 = var17;
            this.f_307 = var20;
            var1.m_1303(Util8.m_2151(f_5909.player, var17, var20));
            var1.m_4142(new Vec3d(var17, var20, var17));
         } else if (this.f_279.m_2073(f_450)) {
            float var7 = MathHelper.wrapDegrees(f_5909.player.getYaw());
            float var13 = f_5909.player.getPitch();
            float var16 = this.m_2565(var7);
            float var19 = this.m_3831(var13);
            if (var19 > var16) {
               var16 = var19;
            }

            this.f_306 = var16;
            this.f_307 = var19;
            var1.m_4142(new Vec3d(var16, var19, var16));
         } else if (this.f_279.m_2073(f_451)) {
            float var6 = MathHelper.wrapDegrees(f_5909.player.getYaw());
            float var12 = f_5909.player.getPitch();
            float var15 = this.m_956(var6);
            float var18 = this.m_1844(var12);
            if (var18 > var15) {
               var15 = var18;
            }

            this.f_306 = var15;
            this.f_307 = var18;
            var1.m_4142(new Vec3d(var15, var18, var15));
         } else {
            if (this.f_279.m_2073(f_452)) {
               float var2 = MathHelper.wrapDegrees(f_5909.player.getYaw());
               float var3 = f_5909.player.getPitch();
               float var4 = this.m_2205(var2);
               float var5 = this.m_2234(var3);
               if (var5 > var4) {
                  var4 = var5;
               }

               this.f_306 = var4;
               this.f_307 = var5;
               var1.m_4142(new Vec3d(var4, var5, var4));
            }
         }
      }
   }

   public ElytraBooster() {
      super(f_311, f_312, Category.MOVEMENT);
      this.f_279 = new ModeSetting(f_313, f_314, f_315, f_316, f_317, f_318, f_319, f_320, f_321);
      this.f_280 = new NumberSetting(f_322, f_323, f_324, f_325, f_326).m_356(() -> this.f_279.m_2073(f_539));
      this.f_281 = new BooleanSetting(f_327, true);
      this.f_282 = new NumberSetting(f_328, 2.0F, f_329, f_330, f_331).m_356(this.f_281::m_1163);
      this.f_283 = new NumberSetting(f_332, f_333, 1.0F, f_334, f_335).m_356(this.f_281::m_1163);
      this.f_284 = new NumberSetting(f_336, f_337, f_338, f_339, f_340).m_356(() -> this.f_279.m_2073(f_538));
      this.f_285 = new NumberSetting(f_341, f_342, f_343, f_344, f_345).m_356(() -> this.f_279.m_2073(f_537));
      this.f_286 = new NumberSetting(f_346, f_347, f_348, f_349, f_350).m_356(() -> this.f_279.m_2073(f_536));
      this.f_287 = new NumberSetting(f_351, f_352, f_353, f_354, f_355).m_356(() -> this.f_279.m_2073(f_535));
      this.f_288 = new NumberSetting(f_356, f_357, f_358, f_359, f_360).m_356(() -> this.f_279.m_2073(f_534));
      this.f_289 = new NumberSetting(f_361, f_362, f_363, f_364, f_365).m_356(() -> this.f_279.m_2073(f_533));
      this.f_290 = new NumberSetting(f_366, f_367, f_368, f_369, f_370).m_356(() -> this.f_279.m_2073(f_532));
      this.f_291 = new NumberSetting(f_371, f_372, f_373, f_374, f_375).m_356(() -> this.f_279.m_2073(f_531));
      this.f_292 = new NumberSetting(f_376, f_377, f_378, f_379, f_380).m_356(() -> this.f_279.m_2073(f_530));
      this.f_293 = new NumberSetting(f_381, f_382, f_383, f_384, f_385).m_356(() -> this.f_279.m_2073(f_529));
      this.f_294 = new NumberSetting(f_386, f_387, f_388, f_389, f_390).m_356(() -> this.f_279.m_2073(f_528));
      this.f_295 = new NumberSetting(f_391, f_392, f_393, f_394, f_395).m_356(() -> this.f_279.m_2073(f_527));
      this.f_296 = new NumberSetting(f_396, f_397, f_398, f_399, f_400).m_356(() -> this.f_279.m_2073(f_526));
      this.f_297 = new NumberSetting(f_401, f_402, f_403, f_404, f_405).m_356(() -> this.f_279.m_2073(f_525));
      this.f_298 = new NumberSetting(f_406, f_407, f_408, f_409, f_410).m_356(() -> this.f_279.m_2073(f_524));
      this.f_299 = new NumberSetting(f_411, f_412, f_413, f_414, f_415).m_356(() -> this.f_279.m_2073(f_523));
      this.f_300 = new NumberSetting(f_416, f_417, f_418, f_419, f_420).m_356(() -> this.f_279.m_2073(f_522));
      this.f_301 = new NumberSetting(f_421, f_422, f_423, f_424, f_425).m_356(() -> this.f_279.m_2073(f_521));
      this.f_302 = new NumberSetting[]{this.f_284, this.f_285, this.f_286, this.f_287, this.f_288, this.f_289, this.f_290, this.f_291, this.f_292};
      this.f_303 = new NumberSetting[]{this.f_293, this.f_294, this.f_295, this.f_296, this.f_297, this.f_298, this.f_299, this.f_300, this.f_301};
      this.f_304 = new float[]{f_426, f_427, f_428, f_429, f_430, f_431, f_432, f_433, f_434};
      this.f_305 = new float[]{f_435, f_436, f_437, f_438, f_439, f_440, f_441, f_442, f_443};
      this.f_308 = new Util34();
      this.f_310 = f_444;
   }

   private boolean m_2947() {
      LivingEntity var1 = this.m_1646();
      if (var1 == null) {
         return false;
      } else {
         Vec3d var2 = f_5909.player.getVelocity();
         if (var2.horizontalLength() < f_455) {
            return false;
         } else {
            Vec3d var3 = var2.normalize();
            Vec3d var4 = var1.getEntityPos().subtract(f_5909.player.getEntityPos());
            double var5 = var4.dotProduct(var3);
            return var5 < -this.f_282.m_4046();
         }
      }
   }

   public boolean m_188() {
      return this.f_309;
   }

   private LivingEntity m_1646() {
      if (f_5909.player != null && f_5909.player.isGliding()) {
         AttackAura var1 = InitManager.f_2740.f_2741.attackAura;
         if (var1 == null) {
            return null;
         } else {
            LivingEntity var2 = var1.m_891();
            return var2 != null && var2.isGliding() ? var2 : null;
         }
      } else {
         return null;
      }
   }

   private float m_2296(float var1) {
      float var2 = this.m_1890(var1);
      int var3 = (int)(var2 / f_458);
      if (var3 >= this.f_302.length) {
         var3 = this.f_302.length - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      return this.f_302[var3].m_4046();
   }

   private float m_3831(float var1) {
      float var2 = this.m_1890(var1);
      int var3 = (int)(var2 / f_491);
      float[] var4 = new float[]{f_492, f_493, f_494, f_495, f_496, f_497, f_498, f_499, f_500};
      if (var3 >= var4.length) {
         var3 = var4.length - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      return var4[var3];
   }

   @Override
   public void m_2() {
      this.f_308.m_847();
      super.m_2();
   }

   private float m_2565(float var1) {
      float var2 = this.m_1890(var1);
      int var3 = (int)(var2 / f_481);
      float[] var4 = new float[]{f_482, f_483, f_484, f_485, f_486, f_487, f_488, f_489, f_490};
      if (var3 >= var4.length) {
         var3 = var4.length - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      return var4[var3];
   }

   @Override
   public void m_1() {
      this.f_308.m_3322();
      super.m_1();
   }

   private float m_1844(float var1) {
      float var2 = this.m_1890(var1);
      int var3 = (int)(var2 / f_472);
      float[] var4 = new float[]{f_473, f_474, f_475, f_476, f_477, f_478, f_479, f_480, 2.0F};
      if (var3 >= var4.length) {
         var3 = var4.length - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      return var4[var3];
   }

   @EventHandler
   public void m_1088(Util66 var1) {
      if (var1.m_2586() && this.f_279.m_2073(f_453) && f_5909.player != null && f_5909.player.isGliding() && var1.m_3295() instanceof TeleportConfirmC2SPacket) {
         this.f_308.m_2419();
      }

      if (var1.m_2068()
         && this.f_279.m_2073(f_454)
         && f_5909.player != null
         && f_5909.player.isGliding()
         && var1.m_3295() instanceof PlayerPositionLookS2CPacket) {
         this.f_308.m_2419();
      }
   }

   private float m_2234(float var1) {
      float var2 = this.m_1890(var1);
      int var3 = (int)(var2 / f_511);
      float[] var4 = new float[]{f_512, f_513, f_514, f_515, f_516, f_517, f_518, f_519, f_520};
      if (var3 >= var4.length) {
         var3 = var4.length - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      return var4[var3];
   }

   private float m_1890(float var1) {
      float var2 = Math.abs(var1);
      if (var2 > f_460) {
         var2 = f_461 - var2;
      }

      if (var2 > f_462) {
         var2 = f_463 - var2;
      }

      return var2;
   }

   private float m_2205(float var1) {
      float var2 = this.m_1890(var1);
      int var3 = (int)(var2 / f_501);
      float[] var4 = new float[]{f_502, f_503, f_504, f_505, f_506, f_507, f_508, f_509, f_510};
      if (var3 >= var4.length) {
         var3 = var4.length - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      return var4[var3];
   }

   public double m_1704() {
      return this.f_310;
   }

   private float m_956(float var1) {
      float var2 = this.m_1890(var1);
      int var3 = (int)(var2 / f_464);
      float[] var4 = new float[]{f_465, f_466, f_467, f_468, f_469, f_470, f_471, 2.0F, 2.0F};
      if (var3 >= var4.length) {
         var3 = var4.length - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      return var4[var3];
   }

   private float m_2723(float var1) {
      float var2 = this.m_1890(var1);
      int var3 = (int)(var2 / f_459);
      if (var3 >= this.f_303.length) {
         var3 = this.f_303.length - 1;
      }

      if (var3 < 0) {
         var3 = 0;
      }

      return this.f_303[var3].m_4046();
   }
}
