package su.energyclient.module.combat;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.client.util.InputUtil.Type;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.KineticWeaponComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util121;
import su.energyclient.util.Util152;
import su.energyclient.util.Util16;
import su.energyclient.util.Util164;
import su.energyclient.util.Util167;
import su.energyclient.util.Util170;
import su.energyclient.util.Util18;
import su.energyclient.util.Util54;
import su.energyclient.util.Util81;
import su.energyclient.util.math.MathUtil7;

public class Macetarget extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_9170 = 1100;
   private final ModeSetting f_9171;
   private final ModeSetting f_9172;
   private final BooleanSetting f_9173;
   private final BooleanSetting f_9174;
   private final BooleanSetting f_9175;
   private final BooleanSetting f_9176;
   private final NumberSetting f_9177;
   private final NumberSetting f_9178;
   private final NumberSetting f_9179;
   private final NumberSetting f_9180;
   private final Util167 f_9181;
   private final Macetarget.aQvLgqTan9md55UO f_9182;
   private Macetarget.Inner_74pX2twtMWER1ElV f_9183;
   private LivingEntity f_9184;
   private ClientPlayerEntity f_9185;
   private ClientPlayerEntity f_9186;
   private Util10 f_9187;
   private Vec3d f_9188;
   private Vec3d f_9189;
   private Vec3d f_9190;
   private int f_9191;
   private int f_9192;
   private int f_9193;
   private int f_9194;
   private int f_9195;
   private int f_9196;
   private int f_9197;
   private int f_9198;
   private boolean f_9199;
   private boolean f_9200;
   private boolean f_9201;
   private int f_9202;
   private int f_9203;
   private float f_9204;
   private double l;
   private Vec3d f_9205;
   private boolean f_9206;
   private boolean f_9207;
   private boolean f_9208;
   private String f_9209;
   private static final String f_9210 = "MaceTarget";
   private static final String f_9211 = "Выбирает цель, взлетает и атакует булавой; копьё на подлёте";
   private static final String f_9212 = "Подъём";
   private static final String f_9213 = "Авто";
   private static final String f_9214 = "Авто";
   private static final String f_9215 = "Заряд ветра";
   private static final String f_9216 = "Элитры";
   private static final String f_9217 = "Выбор цели";
   private static final String f_9218 = "Авто";
   private static final String f_9219 = "Авто";
   private static final String f_9220 = "Только Aura";
   private static final String f_9221 = "Игроки";
   private static final String f_9222 = "Мобы";
   private static final String f_9223 = "Подходить к цели";
   private static final String f_9224 = "Копьё при подлёте";
   private static final String f_9225 = "Радиус цели";
   private static final float f_9226 = 32.0F;
   private static final float f_9227 = 4.0F;
   private static final float f_9228 = 64.0F;
   private static final String f_9229 = "Высота захода";
   private static final float f_9230 = 14.0F;
   private static final float f_9231 = 6.0F;
   private static final float f_9232 = 26.0F;
   private static final String f_9233 = "Минимум падения";
   private static final float f_9234 = 1.5F;
   private static final float f_9235 = 1.5F;
   private static final float f_9236 = 8.0F;
   private static final float f_9237 = 0.5F;
   private static final String f_9238 = "Интервал ракет";
   private static final float f_9239 = 30.0F;
   private static final float f_9240 = 20.0F;
   private static final float f_9241 = 60.0F;
   private static final String f_9242 = "Ожидание цели";
   private static final String f_9243 = "Подход";
   private static final String f_9244 = "Заряд под ноги";
   private static final String f_9245 = "Раскрытие элитр";
   private static final String f_9246 = "Проход с копьём";
   private static final String f_9247 = "Набор высоты";
   private static final String f_9248 = "Заход сверху";
   private static final String f_9249 = "Удар в падении";
   private static final String f_9250 = "Следующий заход";
   private static final String f_9251 = "Только Aura";
   private static final String f_9252 = "Положи булаву на хотбар.";
   private static final String f_9253 = "Булава пропала с хотбара — атака остановлена.";
   private static final String f_9254 = "Не удалось завершить заход; повтор после паузы.";
   private static final float f_9255 = 90.0F;
   private static final String f_9256 = "Только Aura";
   private static final double f_9257 = 64.0;
   private static final double f_9258 = 3.0;
   private static final String f_9259 = "Заряд ветра";
   private static final String f_9260 = "Элитры";
   private static final double f_9261 = 6.0;
   private static final String f_9262 = "Не удалось надеть элитры. Проверь броню и инвентарь.";
   private static final String f_9263 = "Элитры";
   private static final String f_9264 = "Для элитр нужны исправные крылья, нагрудник и ракеты на хотбаре или во второй руке.";
   private static final String f_9265 = "Для удара сначала нужен нагрудник: MaceTarget не снимает крылья без замены.";
   private static final String f_9266 = "Положи заряды ветра на хотбар или во вторую руку.";
   private static final double f_9267 = 3.5;
   private static final double f_9268 = 4.0;
   private static final String f_9269 = "Над головой мало места для подброса.";
   private static final float f_9270 = 90.0F;
   private static final float f_9271 = -65.0F;
   private static final double f_9272 = 2.0;
   private static final double f_9273 = 3.0;
   private static final String f_9274 = "Ракеты закончились — управление полётом возвращено.";
   private static final double f_9275 = 3.0;
   private static final double f_9276 = 6.0;
   private static final float f_9277 = -80.0F;
   private static final float f_9278 = -55.0F;
   private static final double f_9279 = 1.6;
   private static final double f_9280 = 0.6;
   private static final double f_9281 = 4.5;
   private static final double f_9282 = 8.0;
   private static final double f_9283 = 0.65;
   private static final double f_9284 = 7.0;
   private static final float f_9285 = 0.01F;
   private static final double f_9286 = 7.0;
   private static final double f_9287 = 1.25;
   private static final double f_9288 = 0.1;
   private static final double f_9289 = 0.6;
   private static final double f_9290 = 8.0;
   private static final float f_9291 = -30.0F;
   private static final float f_9292 = 35.0F;
   private static final double f_9293 = 8.0;
   private static final double f_9294 = 4.5;
   private static final String f_9295 = "Смена нагрудника не удалась; повторяю заход.";
   private static final double f_9296 = 4.0;
   private static final double f_9297 = 0.4;
   private static final double f_9298 = 8.0;
   private static final double f_9299 = 2.0;
   private static final double f_9300 = 2.0;
   private static final double f_9301 = 3.0;
   private static final double f_9302 = 3.0;
   private static final double f_9303 = 0.1;
   private static final float f_9304 = 2.5F;
   private static final float f_9305 = 0.35F;
   private static final float f_9306 = 0.35F;
   private static final double f_9307 = 0.4;
   private static final double f_9308 = 0.05;
   private static final double f_9309 = 0.05;
   private static final double f_9310 = 0.05;
   private static final double f_9311 = 0.05;
   private static final double f_9312 = 0.05;
   private static final double f_9313 = 0.05;
   private static final float f_9314 = 90.0F;
   private static final float f_9315 = 180.0F;
   private static final float f_9316 = 180.0F;
   private static final float f_9317 = 180.0F;
   private static final float f_9318 = 180.0F;

   public static boolean l() {
      Macetarget var0 = InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null ? InitManager.f_2740.f_2741.macetarget : null;
      return var0 != null && var0.f_9206;
   }

   private void m_2574() {
      Vec3d var1 = this.f_9184.getEntityPos();
      int var2 = f_5909.player.age;
      if (this.f_9190 != null && var2 > this.f_9191) {
         Vec3d var3 = var1.subtract(this.f_9190);
         this.f_9189 = var3.lengthSquared() > f_9257 ? Vec3d.ZERO : MathUtil7.m_3377(var3.multiply(1.0 / (var2 - this.f_9191)), f_9258);
      }

      this.f_9190 = var1;
      this.f_9191 = var2;
   }

   private boolean m_1700() {
      int var1 = Util167.m_1987(var0 -> var0.contains(DataComponentTypes.KINETIC_WEAPON));
      if (var1 < 0) {
         return false;
      } else {
         if (this.f_9199 && f_5909.player.getInventory().getSelectedSlot() != var1) {
            this.m_845();
         }

         if (Util167.m_3423(var1)) {
            this.f_9198 = var1;
            this.f_9199 = true;
            f_5909.options.useKey.setPressed(true);
            KineticWeaponComponent var2 = (KineticWeaponComponent)f_5909.player.getMainHandStack().get(DataComponentTypes.KINETIC_WEAPON);
            if (f_5909.player.isUsingItem() && var2 != null && f_5909.player.getItemUseTime() >= var2.getUseTicks()) {
               f_5909.interactionManager.stopUsingItem(f_5909.player);
            }

            return true;
         } else {
            return false;
         }
      }
   }

   private void m_1996(Vec3d var1) {
      Vec3d var2 = var1.subtract(f_5909.player.getEntityPos());
      double var3 = Math.hypot(var2.x, var2.z);
      if (var3 > f_9307) {
         this.f_9188 = new Vec3d(var2.x / var3, 0.0, var2.z / var3);
      }
   }

   @EventHandler
   public void m_2259(Util16 var1) {
      if (m_329()) {
         var1.m_277(true);
      }
   }

   private boolean m_3315() {
      return f_5909.interactionManager != null
         && f_5909.currentScreen == null
         && f_5909.player.currentScreenHandler == f_5909.player.playerScreenHandler
         && f_5909.player.playerScreenHandler.getCursorStack().isEmpty()
         && f_5909.player.isAlive()
         && !f_5909.player.isSpectator()
         && !f_5909.player.getAbilities().flying
         && !f_5909.player.hasVehicle()
         && !f_5909.player.isTouchingWater()
         && !f_5909.player.isInLava()
         && !f_5909.player.isClimbing()
         && !f_5909.player.hasStatusEffect(StatusEffects.LEVITATION)
         && !f_5909.player.hasStatusEffect(StatusEffects.SLOW_FALLING);
   }

   public LivingEntity m_2382() {
      return this.f_9184;
   }

   public String m_3272() {
      return switch (this.f_9183) {
         case IDLE -> f_9242;
         case APPROACH -> f_9243;
         case WIND_AIM -> f_9244;
         case TAKEOFF -> f_9245;
         case SPEAR_PASS -> f_9246;
         case CLIMB -> f_9247;
         case DIVE -> f_9248;
         case FALL -> f_9249;
         case RECOVER -> f_9250;
      };
   }

   @EventHandler(
      priority = -200
   )
   public void m_3585(Util81 var1) {
      if (m_329() && this.m_3315() && this.m_3931(this.f_9184) && this.f_9187 != null && !(Util10.m_3601().m_855(this.f_9187) > f_9304)) {
         if (this.f_9183 == Macetarget.Inner_74pX2twtMWER1ElV.WIND_AIM && f_5909.player.isOnGround()) {
            if (Util167.m_2327(Items.WIND_CHARGE)) {
               f_5909.player.jump();
               this.f_9209 = "";
               this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.FALL);
            }
         } else if (this.f_9183 == Macetarget.Inner_74pX2twtMWER1ElV.CLIMB
            && f_5909.player.isGliding()
            && f_5909.player.age - this.f_9194 >= this.f_9180.m_4046()) {
            if (Util167.m_2327(Items.FIREWORK_ROCKET)) {
               this.f_9194 = f_5909.player.age;
               this.f_9209 = "";
            }
         } else if (this.f_9183 == Macetarget.Inner_74pX2twtMWER1ElV.SPEAR_PASS) {
            if (this.f_9201) {
               if (Util167.m_2327(Items.FIREWORK_ROCKET)) {
                  this.f_9194 = f_5909.player.age;
               }

               this.f_9201 = false;
            }

            if (!this.m_1700() || !f_5909.player.isUsingItem() && !f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND).isAccepted()) {
               this.m_3457();
            }
         } else if (this.f_9183 == Macetarget.Inner_74pX2twtMWER1ElV.FALL) {
            this.m_2784();
         }
      }
   }

   private void m_2304() {
      if (!f_5909.player.isGliding()) {
         this.m_845();
         this.m_864();
         this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.FALL);
      } else {
         Vec3d var1 = this.f_9184.getBoundingBox().getCenter();
         Vec3d var2 = f_5909.player.getVelocity();
         if (MathUtil7.m_735(f_5909.player.getEntityPos(), var2, var1, this.f_9189, this.f_9184.getWidth())) {
            this.m_845();
            this.m_864();
            if (this.f_9181.m_226()) {
               this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.FALL);
               this.m_2479(this.m_2160(var1));
            } else {
               this.m_2593(f_9295);
               this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.CLIMB);
            }
         } else if (f_5909.player.getY() < var1.y + f_9296) {
            this.m_845();
            this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.CLIMB);
            this.m_2232();
         } else {
            double var3 = Math.clamp(f_5909.player.distanceTo(this.f_9184) / Math.max(f_9297, var2.length()), 1.0, f_9298);
            Vec3d var5 = MathUtil7.m_3466(var1, this.f_9189, var3);
            Vec3d var6 = var5.subtract(var2.x * f_9299, 0.0, var2.z * f_9300);
            this.m_2479(this.m_2160(var6));
         }
      }
   }

   private void m_2784() {
      if (MathUtil7.m_968(
            f_5909.player.isGliding(), f_5909.player.isOnGround(), f_5909.player.getVelocity().y, f_5909.player.fallDistance, this.f_9179.m_4046()
         )
         && MaceItem.shouldDealAdditionalDamage(f_5909.player)
         && f_5909.player.getMainHandStack().isOf(Items.MACE)
         && !f_5909.player.isUsingItem()
         && f_5909.player.age - this.f_9196 >= 10) {
         if (f_5909.player.getAttackRange().isWithinRange(f_5909.player, this.f_9184.getBoundingBox(), 0.0)) {
            if (f_5909.player.getAttackRange().getHitResult(f_5909.player, 1.0F, EntityPredicates.CAN_HIT) instanceof EntityHitResult var2
               && var2.getEntity() == this.f_9184) {
               this.f_9206 = true;

               try {
                  f_5909.interactionManager.attackEntity(f_5909.player, this.f_9184);
                  f_5909.player.swingHand(Hand.MAIN_HAND);
                  this.f_9196 = f_5909.player.age;
                  this.f_9193 = f_5909.player.age + 10;
                  this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.RECOVER);
               } finally {
                  this.f_9206 = false;
               }
            }
         }
      }
   }

   private void m_2408() {
      if (!f_5909.player.isOnGround() && !f_5909.player.isGliding() && f_5909.player.age - this.f_9195 >= 5) {
         f_5909.player.startGliding();
         f_5909.player.networkHandler.sendPacket(new ClientCommandC2SPacket(f_5909.player, Mode.START_FALL_FLYING));
         this.f_9195 = f_5909.player.age;
      }
   }

   @Override
   public void m_2() {
      EnergyClient.f_1622.f_1624.m_52(this.f_9182);
      this.f_9209 = "";
      this.f_9193 = 0;
      this.f_9194 = this.f_9195 = this.f_9196 = -100;
      super.m_2();
   }

   private boolean m_1927() {
      return !this.f_9171.m_2073(f_9259)
         && this.f_9181.m_1922()
         && this.f_9181.m_2142()
         && (Util167.m_2330(Items.FIREWORK_ROCKET) || f_5909.player.isGliding() && f_5909.player.getY() > this.f_9184.getY() + this.f_9178.m_4046());
   }

   @EventHandler(
      priority = -200
   )
   public void m_2822(Util18 var1) {
      if (m_329()) {
         var1.m_1148(f_5909.player.getYaw());
         var1.m_3969(f_5909.player.getPitch());
      }
   }

   private void m_845() {
      if (this.f_9199) {
         if (f_5909.player == this.f_9185
            && f_5909.interactionManager != null
            && f_5909.player.isUsingItem()
            && f_5909.player.getActiveItem().contains(DataComponentTypes.KINETIC_WEAPON)) {
            f_5909.interactionManager.stopUsingItem(f_5909.player);
         }

         this.f_9199 = false;
         Key var1 = InputUtil.fromTranslationKey(f_5909.options.useKey.getBoundKeyTranslationKey());
         boolean var2 = var1.getCategory() == Type.MOUSE
            ? GLFW.glfwGetMouseButton(f_5909.getWindow().getHandle(), var1.getCode()) == 1
            : var1.getCategory() == Type.KEYSYM && InputUtil.isKeyPressed(f_5909.getWindow(), var1.getCode());
         f_5909.options.useKey.setPressed(var2);
      }
   }

   private void m_1281() {
      this.m_2479(new Util10(this.m_1983(this.f_9184.getEntityPos()), f_9271));
      if (f_5909.player.isGliding()) {
         this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.CLIMB);
      } else if (f_5909.player.isOnGround()) {
         if (f_5909.world.isSpaceEmpty(f_5909.player, f_5909.player.getBoundingBox().stretch(0.0, f_9272, 0.0))) {
            f_5909.player.jump();
         }
      } else {
         this.m_2408();
      }
   }

   private void m_2232() {
      this.m_845();
      this.m_864();
      if (!f_5909.player.isGliding()) {
         this.m_1772(f_5909.player.isOnGround() ? Macetarget.Inner_74pX2twtMWER1ElV.APPROACH : Macetarget.Inner_74pX2twtMWER1ElV.TAKEOFF);
      } else if (this.f_9200 || !(f_5909.player.getY() >= this.f_9184.getY() + f_9273) || !this.m_3381()) {
         double var1 = f_5909.player.getY() - this.f_9184.getBoundingBox().maxY;
         if (var1 >= this.f_9178.m_4046()) {
            this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.DIVE);
            this.m_2304();
         } else if (!Util167.m_2330(Items.FIREWORK_ROCKET)) {
            this.m_2593(f_9274);
            this.m_3538();
         } else {
            double var3 = MathUtil7.m_145(f_5909.player.getEntityPos(), this.f_9184.getEntityPos());
            this.m_2479(new Util10(this.m_1983(MathUtil7.m_3466(this.f_9184.getEntityPos(), this.f_9189, f_9275)), var3 < f_9276 ? f_9277 : f_9278));
         }
      }
   }

   private Vec3d m_2470(Box var1) {
      Vec3d var2 = f_5909.player.getEyePos();
      return new Vec3d(
         MathHelper.clamp(var2.x, var1.minX + f_9308, var1.maxX - f_9309),
         MathHelper.clamp(var2.y, var1.minY + f_9310, var1.maxY - f_9311),
         MathHelper.clamp(var2.z, var1.minZ + f_9312, var1.maxZ - f_9313)
      );
   }

   private void m_2479(Util10 var1) {
      this.f_9187 = var1;
      Util54.m_2498(var1, f_9315, f_9316, 2, 1100);
   }

   public Macetarget() {
      super(f_9210, f_9211, Category.COMBAT);
      this.f_9171 = new ModeSetting(f_9212, f_9213, f_9214, f_9215, f_9216);
      this.f_9172 = new ModeSetting(f_9217, f_9218, f_9219, f_9220);
      this.f_9173 = new BooleanSetting(f_9221, true);
      this.f_9174 = new BooleanSetting(f_9222, false);
      this.f_9175 = new BooleanSetting(f_9223, true);
      this.f_9176 = new BooleanSetting(f_9224, true);
      this.f_9177 = new NumberSetting(f_9225, f_9226, f_9227, f_9228, 1.0F);
      this.f_9178 = new NumberSetting(f_9229, f_9230, f_9231, f_9232, 1.0F);
      this.f_9179 = new NumberSetting(f_9233, f_9234, f_9235, f_9236, f_9237);
      this.f_9180 = new NumberSetting(f_9238, f_9239, f_9240, f_9241, 1.0F);
      this.f_9181 = new Util167();
      this.f_9182 = new Macetarget.aQvLgqTan9md55UO();
      this.f_9183 = Macetarget.Inner_74pX2twtMWER1ElV.IDLE;
      this.f_9188 = Vec3d.ZERO;
      this.f_9189 = Vec3d.ZERO;
      this.f_9194 = -100;
      this.f_9195 = -100;
      this.f_9196 = -100;
      this.f_9197 = -1;
      this.f_9198 = -1;
      this.f_9205 = Vec3d.ZERO;
      this.f_9209 = "";
   }

   @EventHandler(
      priority = 100
   )
   public void m_501(Util170 var1) {
      if (f_5909.player == null || f_5909.world == null || this.f_9186 != f_5909.player) {
         this.m_3538();
         this.f_9181.m_922();
         this.f_9207 = false;
         this.f_9185 = null;
         this.f_9186 = f_5909.player;
         this.f_9193 = 0;
         this.f_9194 = this.f_9195 = this.f_9196 = -100;
         if (f_5909.player == null || f_5909.world == null) {
            return;
         }
      }

      this.m_3984();
      if (!this.m_3315()) {
         this.m_3538();
      } else if (this.f_9172.m_2073(f_9251) && !InitManager.f_2740.f_2741.attackAura.m_677()) {
         this.m_3538();
      } else {
         if (!this.m_3931(this.f_9184)) {
            if (this.f_9183 != Macetarget.Inner_74pX2twtMWER1ElV.IDLE) {
               this.m_3538();
            }

            this.f_9184 = this.m_1270();
            this.f_9190 = null;
            this.f_9189 = Vec3d.ZERO;
         }

         if (this.f_9184 != null && (this.f_9183 != Macetarget.Inner_74pX2twtMWER1ElV.IDLE || f_5909.player.age >= this.f_9193)) {
            this.m_2574();
            if (this.f_9183 == Macetarget.Inner_74pX2twtMWER1ElV.IDLE) {
               if (this.f_9207 || f_5909.player.isUsingItem()) {
                  return;
               }

               if (Util167.m_474(Items.MACE) < 0) {
                  this.m_2593(f_9252);
                  return;
               }

               this.f_9185 = f_5909.player;
               this.f_9181.m_1293();
               this.f_9197 = f_5909.player.getInventory().getSelectedSlot();
               this.f_9200 = false;
               this.m_864();
               this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.APPROACH);
            }

            if (Util167.m_474(Items.MACE) < 0) {
               this.m_2593(f_9253);
               this.m_3538();
            } else if (f_5909.player.isUsingItem() && !this.f_9199) {
               this.m_3538();
            } else if (f_5909.player.age - this.f_9192 > 160) {
               this.m_2593(f_9254);
               this.f_9193 = f_5909.player.age + 20;
               this.m_3538();
            } else {
               this.f_9188 = Vec3d.ZERO;
               switch (this.f_9183) {
                  case APPROACH:
                     this.m_2770();
                     break;
                  case WIND_AIM:
                     this.m_2479(new Util10(this.m_1983(this.f_9184.getEntityPos()), f_9255));
                     break;
                  case TAKEOFF:
                     this.m_1281();
                     break;
                  case SPEAR_PASS:
                     this.I();
                     break;
                  case CLIMB:
                     this.m_2232();
                     break;
                  case DIVE:
                     this.m_2304();
                     break;
                  case FALL:
                     this.m_4036();
                     break;
                  case RECOVER:
                     this.m_4117();
               }
            }
         }
      }
   }

   @Override
   public void m_1() {
      this.m_3538();
      super.m_1();
      if (this.f_9207) {
         EnergyClient.f_1622.f_1624.m_32(this.f_9182);
      }
   }

   private Util10 m_2160(Vec3d var1) {
      Vec3d var2 = var1.subtract(f_5909.player.getEyePos());
      return new Util10(this.m_1983(var1), (float)(-Math.toDegrees(Math.atan2(var2.y, Math.hypot(var2.x, var2.z)))));
   }

   private void m_864() {
      int var1 = Util167.m_474(Items.MACE);
      if (Util167.m_3423(var1)) {
         this.f_9198 = var1;
      }
   }

   private void m_3538() {
      this.m_845();
      if (f_5909.player != null && f_5909.player == this.f_9185 && this.f_9197 >= 0 && f_5909.player.getInventory().getSelectedSlot() == this.f_9198) {
         Util167.m_3423(this.f_9197);
      }

      if (this.f_9187 != null && Util54.m_1085().m_2266() == 1100) {
         Util54.m_2498(null, f_9317, f_9318, 0, 1100);
      }

      this.f_9183 = Macetarget.Inner_74pX2twtMWER1ElV.IDLE;
      this.f_9184 = null;
      this.f_9187 = null;
      this.f_9188 = Vec3d.ZERO;
      this.f_9197 = this.f_9198 = -1;
      this.f_9206 = false;
      this.f_9200 = false;
      this.f_9201 = false;
      this.f_9205 = Vec3d.ZERO;
      this.f_9207 = this.f_9185 != null;
      this.m_3984();
   }

   private boolean m_3931(LivingEntity var1) {
      if (var1 == null
         || var1 == f_5909.player
         || !var1.isAlive()
         || var1.isRemoved()
         || var1.isInvulnerable()
         || var1.getEntityWorld() != f_5909.world
         || f_5909.player.squaredDistanceTo(var1) > this.f_9177.m_4046() * this.f_9177.m_4046()) {
         return false;
      } else {
         return var1 instanceof PlayerEntity var2
            ? this.f_9173.m_1163() && !var2.isSpectator() && !var2.isCreative() && !AntiBot.m_79(var2) && !InitManager.f_2740.f_2744.m_3914(var2)
            : this.f_9174.m_1163() && var1 instanceof MobEntity;
      }
   }

   private void I() {
      if (this.f_9176.m_1163()
         && f_5909.player.isGliding()
         && !f_5909.player.horizontalCollision
         && f_5909.player.canSee(this.f_9184)
         && f_5909.player.age - this.f_9192 <= 80
         && Util167.m_1987(var0 -> var0.contains(DataComponentTypes.KINETIC_WEAPON)) >= 0) {
         double var1 = f_5909.player.distanceTo(this.f_9184);
         boolean var3 = var1 <= f_9284;
         if (var3) {
            this.f_9203 = f_5909.player.age;
         }

         float var4 = this.f_9184.getHealth() + this.f_9184.getAbsorptionAmount();
         boolean var5 = this.f_9184.hurtTime > this.f_9202 || var4 < this.f_9204 - f_9285;
         this.f_9202 = this.f_9184.hurtTime;
         this.f_9204 = var4;
         Vec3d var6 = this.f_9184.getEntityPos().subtract(f_5909.player.getEntityPos());
         boolean var7 = this.l <= f_9286 && (var6.dotProduct(this.f_9205) <= 0.0 || var1 > this.l + f_9287);
         if ((!var5 || f_5909.player.age - this.f_9203 > 5) && !var7) {
            this.l = Math.min(this.l, var1);
            double var8 = Math.max(f_9288, f_5909.player.getVelocity().subtract(this.f_9189).dotProduct(var6.normalize()));
            double var10 = Math.clamp(var1 / Math.max(f_9289, var8), 1.0, f_9290);
            Vec3d var12 = MathUtil7.m_3466(this.f_9184.getBoundingBox().getCenter(), this.f_9189, var10);
            Util10 var13 = this.m_2160(var12);
            this.m_2479(new Util10(var13.m_2643(), MathHelper.clamp(var13.m_2573(), f_9291, f_9292)));
            if (!this.f_9201 && !this.m_1700()) {
               this.m_3457();
            } else {
               if (this.f_9199 && f_5909.player.isUsingItem()) {
                  KineticWeaponComponent var14 = (KineticWeaponComponent)f_5909.player.getMainHandStack().get(DataComponentTypes.KINETIC_WEAPON);
                  int var15 = var14 == null ? 0 : Math.max(0, var14.delayTicks() - f_5909.player.getItemUseTime());
                  if (var15 > 0 && var1 < f_9293 && (var1 - f_9294) / var8 < var15) {
                     this.m_3457();
                  }
               }
            }
         } else {
            this.m_3457();
         }
      } else {
         this.m_3457();
      }
   }

   private float m_1983(Vec3d var1) {
      Vec3d var2 = var1.subtract(f_5909.player.getEyePos());
      return (float)Math.toDegrees(Math.atan2(var2.z, var2.x)) - f_9314;
   }

   private void m_3457() {
      this.f_9201 = false;
      this.m_845();
      this.m_864();
      this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.CLIMB);
      this.m_2232();
   }

   @EventHandler
   public void m_3486(Util164 var1) {
      if (this.f_9186 != f_5909.player || f_5909.world == null) {
         this.m_3538();
         this.f_9186 = f_5909.player;
         this.f_9193 = 0;
         this.f_9194 = this.f_9195 = this.f_9196 = -100;
      }
   }

   private void m_2593(String var1) {
      if (!this.f_9209.equals(var1)) {
         Util152.m_662("MaceTarget: " + var1);
         this.f_9209 = var1;
      }
   }

   private void m_4036() {
      this.m_845();
      this.m_864();
      this.m_2479(this.m_2160(this.m_2470(this.f_9184.getBoundingBox())));
      if (!f_5909.player.isGliding()) {
         double var1 = Math.max(0.0, f_5909.player.getY() - this.f_9184.getY());
         double var3 = MathUtil7.m_2338(var1, f_5909.player.getVelocity()).ticks();
         Vec3d var5 = MathUtil7.m_3466(this.f_9184.getEntityPos(), this.f_9189, var3);
         Vec3d var6 = var5.subtract(f_5909.player.getVelocity().x * f_9301, 0.0, f_5909.player.getVelocity().z * f_9302);
         this.m_1996(var6);
      }

      if (f_5909.player.isOnGround() && f_5909.player.age - this.f_9192 > 3) {
         this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.RECOVER);
      }
   }

   private void m_2770() {
      double var1 = MathUtil7.m_145(f_5909.player.getEntityPos(), this.f_9184.getEntityPos());
      if (!this.m_1927() || !this.f_9171.m_2073(f_9260) && !f_5909.player.isGliding() && !(var1 > f_9261) && Util167.m_2330(Items.WIND_CHARGE)) {
         if (this.f_9171.m_2073(f_9263)) {
            this.m_2593(f_9264);
            this.m_3538();
         } else if (f_5909.player.isGliding()) {
            this.m_2593(f_9265);
            this.m_3538();
         } else if (!f_5909.player.isOnGround()) {
            this.f_9208 = false;
            this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.FALL);
         } else if (!Util167.m_2330(Items.WIND_CHARGE)) {
            this.m_2593(f_9266);
            this.m_3538();
         } else if (var1 > f_9267) {
            this.m_2479(this.m_2160(this.f_9184.getBoundingBox().getCenter()));
            if (this.f_9175.m_1163() && f_5909.player.canSee(this.f_9184)) {
               this.m_1996(this.f_9184.getEntityPos());
            }
         } else if (f_5909.player.canSee(this.f_9184)) {
            if (!f_5909.world.isSpaceEmpty(f_5909.player, f_5909.player.getBoundingBox().stretch(0.0, f_9268, 0.0))) {
               this.m_2593(f_9269);
               this.m_3538();
               this.f_9193 = f_5909.player.age + 20;
            } else {
               this.f_9208 = false;
               this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.WIND_AIM);
               this.m_2479(new Util10(this.m_1983(this.f_9184.getEntityPos()), f_9270));
            }
         }
      } else {
         this.f_9208 = true;
         if (!this.f_9181.m_3184()) {
            this.m_2593(f_9262);
            this.m_3538();
         } else {
            this.m_1772(f_5909.player.isGliding() ? Macetarget.Inner_74pX2twtMWER1ElV.CLIMB : Macetarget.Inner_74pX2twtMWER1ElV.TAKEOFF);
         }
      }
   }

   private void m_4117() {
      this.m_864();
      this.m_2479(this.m_2160(this.m_2470(this.f_9184.getBoundingBox())));
      if (!f_5909.player.isOnGround() && f_5909.player.getVelocity().y > f_9303) {
         this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.FALL);
      } else if (f_5909.player.age >= this.f_9193 && f_5909.player.isOnGround()) {
         this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.APPROACH);
      } else if (this.f_9208 && f_5909.player.age >= this.f_9193 && this.f_9181.m_1922() && this.f_9181.m_3184()) {
         this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.TAKEOFF);
      }
   }

   private boolean m_3381() {
      this.f_9200 = true;
      if (this.f_9176.m_1163() && f_5909.player.canSee(this.f_9184)) {
         int var1 = Util167.m_1987(var0 -> var0.contains(DataComponentTypes.KINETIC_WEAPON));
         if (var1 < 0) {
            return false;
         } else {
            KineticWeaponComponent var2 = (KineticWeaponComponent)f_5909.player.getInventory().getStack(var1).get(DataComponentTypes.KINETIC_WEAPON);
            Vec3d var3 = this.f_9184.getBoundingBox().getCenter().subtract(f_5909.player.getEyePos());
            double var4 = Math.hypot(var3.x, var3.z);
            boolean var6 = Util167.m_2330(Items.FIREWORK_ROCKET) && f_5909.player.age - this.f_9194 >= this.f_9180.m_4046();
            boolean var7 = var6 || f_5909.player.age - this.f_9194 < 60;
            double var8 = Math.max(f_5909.player.getVelocity().length(), var7 ? f_9279 : f_9280);
            double var10 = f_9281 + (var2.delayTicks() + 2) * var8;
            if (!(var4 < Math.max(f_9282, var10)) && !(Math.abs(var3.y) > var4 * f_9283)) {
               this.f_9201 = var6;
               this.f_9202 = this.f_9184.hurtTime;
               this.f_9204 = this.f_9184.getHealth() + this.f_9184.getAbsorptionAmount();
               this.l = f_5909.player.distanceTo(this.f_9184);
               this.f_9203 = -100;
               this.f_9205 = new Vec3d(var3.x / var4, 0.0, var3.z / var4);
               this.m_1772(Macetarget.Inner_74pX2twtMWER1ElV.SPEAR_PASS);
               this.I();
               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private void m_1772(Macetarget.Inner_74pX2twtMWER1ElV var1) {
      this.f_9183 = var1;
      this.f_9192 = f_5909.player.age;
      if (var1 != Macetarget.Inner_74pX2twtMWER1ElV.SPEAR_PASS) {
         this.m_845();
      }

      if (var1 == Macetarget.Inner_74pX2twtMWER1ElV.RECOVER) {
         this.f_9200 = false;
      }
   }

   public static boolean m_329() {
      Macetarget var0 = InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null ? InitManager.f_2740.f_2741.macetarget : null;
      return var0 != null
         && var0.m_677()
         && var0.f_9183 != Macetarget.Inner_74pX2twtMWER1ElV.IDLE
         && f_5909.player != null
         && f_5909.player == var0.f_9185
         && f_5909.currentScreen == null;
   }

   @EventHandler(
      priority = 200
   )
   public void m_3492(EventAttack var1) {
      if (m_329() && !this.f_9206) {
         var1.m_277(true);
      }
   }

   private void m_3984() {
      if (this.f_9207) {
         if (f_5909.player != this.f_9185 || f_5909.world == null || !f_5909.player.isAlive()) {
            this.f_9181.m_922();
            this.f_9207 = false;
            this.f_9185 = null;
         } else if (f_5909.player.isOnGround() && this.f_9181.m_743()) {
            this.f_9207 = false;
            this.f_9185 = null;
         }
      }
   }

   @EventHandler(
      priority = -200
   )
   public void m_3771(Util121 var1) {
      if (m_329() && (this.f_9183 != Macetarget.Inner_74pX2twtMWER1ElV.APPROACH || this.f_9175.m_1163())) {
         double var2 = Math.toRadians(f_5909.player.getYaw());
         var1.m_433((float)(this.f_9188.z * Math.cos(var2) - this.f_9188.x * Math.sin(var2)));
         var1.m_2791((float)(this.f_9188.x * Math.cos(var2) + this.f_9188.z * Math.sin(var2)));
         if (Math.abs(var1.m_2210()) < f_9305) {
            var1.m_433(0.0F);
         }

         if (Math.abs(var1.m_2113()) < f_9306) {
            var1.m_2791(0.0F);
         }

         var1.m_564(this.f_9183 == Macetarget.Inner_74pX2twtMWER1ElV.APPROACH && f_5909.player.horizontalCollision && f_5909.player.isOnGround());
         var1.m_1269(false);
      }
   }

   private LivingEntity m_1270() {
      AttackAura var1 = InitManager.f_2740.f_2741.attackAura;
      if (var1 != null && var1.m_677() && this.m_3931(var1.m_891()) && f_5909.player.canSee(var1.m_891())) {
         return var1.m_891();
      } else if (this.f_9172.m_2073(f_9256)) {
         return null;
      } else {
         LivingEntity var2 = null;

         for (Entity var4 : f_5909.world.getEntities()) {
            if (var4 instanceof LivingEntity var5
               && this.m_3931(var5)
               && f_5909.player.canSee(var5)
               && (var2 == null || f_5909.player.squaredDistanceTo(var5) < f_5909.player.squaredDistanceTo(var2))) {
               var2 = var5;
            }
         }

         return var2;
      }
   }

   private static enum Inner_74pX2twtMWER1ElV {
      IDLE,
      APPROACH,
      WIND_AIM,
      TAKEOFF,
      SPEAR_PASS,
      CLIMB,
      DIVE,
      FALL,
      RECOVER;
   }

   private final class aQvLgqTan9md55UO {
      private void m_1240() {
         Macetarget.this.m_3984();
         if (!Macetarget.this.f_9207) {
            EnergyClient.f_1622.f_1624.m_52(this);
         }
      }

      @EventHandler
      public void m_3346(Util170 var1) {
         this.m_1240();
      }

      @EventHandler
      public void m_882(Util164 var1) {
         this.m_1240();
      }
   }
}
