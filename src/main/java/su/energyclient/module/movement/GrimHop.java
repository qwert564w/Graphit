package su.energyclient.module.movement;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util121;
import su.energyclient.util.Util125;
import su.energyclient.util.Util162;
import su.energyclient.util.Util166;
import su.energyclient.util.Util170;
import su.energyclient.util.Util21;
import su.energyclient.util.Util32;
import su.energyclient.util.Util38;
import su.energyclient.util.Util66;
import su.energyclient.util.Util81;
import su.energyclient.util.math.MathUtil3;

public class GrimHop extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_12158 = "Grim Hop";
   private static final int f_12159 = 0;
   private final ModeSetting f_12160;
   public NumberSetting f_12161;
   public NumberSetting f_12162;
   public NumberSetting f_12163;
   private BooleanSetting f_12164;
   private final Util125 f_12165;
   private int f_12166;
   private int f_12167;
   private int f_12168;
   private int f_12169;
   private String f_12170;
   private int f_12171;
   private volatile boolean f_12172;
   private static final String f_12173 = "Speed";
   private static final String OI = "description";
   private static final String f_12174 = "Мод";
   private static final String f_12175 = "Grim New";
   private static final String f_12176 = "Коллизия";
   private static final String f_12177 = "Grim New";
   private static final String f_12178 = "Grim LowHop";
   private static final String f_12179 = "Grim Hop";
   private static final String f_12180 = "Сила";
   private static final float f_12181 = 0.03F;
   private static final float f_12182 = 0.01F;
   private static final float f_12183 = 0.1F;
   private static final float f_12184 = 0.001F;
   private static final String f_12185 = "Радиус";
   private static final float f_12186 = 0.35F;
   private static final float f_12187 = 0.1F;
   private static final float f_12188 = 0.05F;
   private static final String f_12189 = "Кол-во тиков для предикта";
   private static final float f_12190 = 5.0F;
   private static final float f_12191 = 10.0F;
   private static final String f_12192 = "Авто прыжок";
   private static final String f_12193 = "Grim Hop";
   private static final String f_12194 = "Коллизия";
   private static final double f_12195 = 0.1;
   private static final String f_12196 = "Grim New";
   private static final String f_12197 = "Grim Hop";
   private static final double f_12198 = 0.03;
   private static final String f_12199 = "Grim New";
   private static final float f_12200 = 1.75F;
   private static final double f_12201 = 0.03F;
   private static final double f_12202 = 0.0855;
   private static final float f_12203 = -1.0F;
   private static final String f_12204 = "Grim LowHop";
   private static final double f_12205 = -0.03;
   private static final double f_12206 = -0.0199;
   private static final double f_12207 = 0.03;
   private static final String f_12208 = "Grim Hop";
   private static final String f_12209 = "Grim New";
   private static final String f_12210 = "Grim Hop";
   private static final String f_12211 = "Grim New";
   private static final float f_12212 = 0.01F;
   private static final float f_12213 = 0.3F;
   private static final String f_12214 = "Grim Hop";
   private static final String f_12215 = "Grim New";
   private static final long f_12216 = 50L;
   private static final float f_12217 = 10.0F;
   private static final String f_12218 = "Grim LowHop";
   private static final String f_12219 = "Grim Hop";
   private static final String f_12220 = "Grim Hop";
   private static final float f_12221 = 10.0F;
   private static final String f_12222 = "Grim Hop";
   private static final double f_12223 = 360.0;
   private static final float f_12224 = 180.0F;
   private static final float f_12225 = 360.0F;
   private static final String f_12226 = "Grim New";
   private static final String f_12227 = "Коллизия";
   private static final String f_12228 = "Коллизия";
   private static final String f_12229 = "Коллизия";

   @Override
   public void m_2() {
      super.m_2();
      this.m_1151();
      this.f_12170 = this.f_12160.m_3862();
      MathUtil3.f_6063 = !this.f_12160.m_2073(f_12219) && InitManager.f_2740.f_2741.disabler.m_677();
      if (this.f_12160.m_2073(f_12220)) {
         Util21.m_2688(1.0F);
      }

      MathUtil3.f_6064 = f_12221;
   }

   @EventHandler
   public void m_182(Util66 var1) {
      if (this.f_12160.m_2073(f_12214)) {
         if (var1.m_2068() && var1.m_3295() instanceof PlayerPositionLookS2CPacket) {
            this.f_12172 = true;
         }
      } else if (this.m_4077()) {
         Disabler var2 = InitManager.f_2740.f_2741.disabler;
         if (var1.m_2068()) {
            if (this.f_12160.m_2073(f_12215) && var1.m_3295() instanceof PlayerPositionLookS2CPacket) {
               if (this.f_12166 % 2 == 1) {
                  this.f_12166++;
               }

               if (!var2.m_677()) {
                  this.f_12167 = 2;
                  Util21.m_2688(1.0F + Math.max((float)(this.f_12165.m_1913() - f_12216) / f_12217, 0.0F));
               } else {
                  Util21.m_2688(1.0F);
               }
            }

            if (this.f_12160.m_2073(f_12218) && var1.m_3295() instanceof PlayerPositionLookS2CPacket && this.f_12168 > 0) {
               this.f_12168 = 0;
            }
         }
      }
   }

   public float m_3242(float var1, float var2) {
      float var3 = (float)(Math.abs(var1 - var2) % f_12223);
      if (var3 > f_12224) {
         var3 = f_12225 - var3;
      }

      return var3;
   }

   @EventHandler
   public void m_165(Util81 var1) {
      if (this.m_4077() && !this.f_12160.m_2073(f_12210)) {
         Disabler var2 = InitManager.f_2740.f_2741.disabler;
         if (this.f_12160.m_2073(f_12211)) {
            if (!var2.m_677() && this.f_12167 > 0) {
               this.f_12167--;
            }

            if (this.f_12166 % 2 == 0) {
               if (!var2.m_677()) {
                  Util21.m_2688(f_12212);
                  this.f_12165.m_3493();
               } else {
                  Util21.m_2688(f_12213);
               }

               Util162.m_1605(new ClientCommandC2SPacket(f_5909.player, Mode.START_FALL_FLYING));
               if (var2.m_677()) {
                  Util162.m_1605(new ClientCommandC2SPacket(f_5909.player, Mode.START_FALL_FLYING));
               }
            }
         }
      }
   }

   @EventHandler
   public void m_2354(Util166 var1) {
      if (this.m_4077()) {
         if (this.f_12160.m_2073(f_12196)) {
            f_5909.player.setSprinting(false);
         }
      }
   }

   private boolean m_4077() {
      return f_5909.player != null && f_5909.world != null && f_5909.getNetworkHandler() != null;
   }

   private boolean m_3543(Util121 var1) {
      return !this.f_12172
         && this.f_12171 == 0
         && f_5909.currentScreen == null
         && var1.m_2210() > 0.0F
         && !var1.m_1400()
         && !f_5909.player.shouldSlowDown()
         && !f_5909.player.isUsingItem()
         && f_5909.player.isAlive()
         && !f_5909.player.isSpectator()
         && !f_5909.player.hasVehicle()
         && !f_5909.player.getAbilities().flying
         && !f_5909.player.isGliding()
         && !f_5909.player.isClimbing()
         && !f_5909.player.isTouchingWater()
         && !f_5909.player.isInLava()
         && !f_5909.player.horizontalCollision
         && !f_5909.player.hasStatusEffect(StatusEffects.BLINDNESS)
         && (f_5909.player.getHungerManager().canSprint() || f_5909.player.getAbilities().allowFlying);
   }

   @EventHandler
   public void m_3929(Util170 var1) {
      this.m_3233();
      if (this.m_4077()) {
         if (this.f_12160.m_2073(f_12193)) {
            if (this.f_12172) {
               this.f_12172 = false;
               this.f_12171 = 10;
            } else if (this.f_12171 > 0) {
               this.f_12171--;
            }
         } else {
            if (this.f_12160.m_2073(f_12194)) {
               LivingEntity var2 = InitManager.f_2740.f_2741.attackAura.m_891();
               if (!(var2 instanceof PlayerEntity var3) || var2 == f_5909.player || !Util38.m_469() || f_5909.player.isOnGround()) {
                  return;
               }

               if (f_5909.player.getBoundingBox().expand(this.f_12162.m_4046()).intersects(var2.getBoundingBox())) {
                  Vec3d var4 = this.f_12163.m_4046() > 0.0F ? var3.getLerpedPos(this.f_12163.m_134().intValue()) : var3.getEntityPos();
                  double var5 = var4.getX() - f_5909.player.getX();
                  double var7 = var4.getZ() - f_5909.player.getZ();
                  double var9 = Math.hypot(var5, var7);
                  if (var9 > f_12195) {
                     double var11 = this.f_12161.m_4046() / var9;
                     f_5909.player.addVelocity(var5 * var11, 0.0, var7 * var11);
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void m_3498(Util121 var1) {
      this.m_3233();
      if (this.m_4077()) {
         if (this.f_12160.m_2073(f_12208)) {
            if (this.m_3543(var1)) {
               if (!f_5909.player.isSprinting()) {
                  f_5909.player.setSprinting(true);
               }

               if (f_5909.player.isOnGround()) {
                  var1.m_564(true);
               }
            }
         } else {
            if (this.f_12160.m_2073(f_12209)) {
               if (f_5909.player.verticalCollision) {
                  this.f_12167++;
               } else {
                  this.f_12167 = 0;
               }

               if (this.f_12164.m_1163() && this.f_12167 >= 1) {
                  f_5909.player.jump();
               }
            }
         }
      }
   }

   @Override
   public void m_1() {
      MathUtil3.f_6063 = false;
      Util21.m_2688(1.0F);
      this.m_1151();
      this.f_12170 = null;
      super.m_1();
   }

   private void m_1151() {
      this.f_12166 = 0;
      this.f_12167 = 0;
      this.f_12169 = 0;
      this.f_12168 = 0;
      this.f_12171 = 0;
      this.f_12172 = false;
   }

   public GrimHop() {
      super(f_12173, OI, Category.MOVEMENT);
      this.f_12160 = new ModeSetting(f_12174, f_12175, f_12176, f_12177, f_12178, f_12179);
      this.f_12161 = new NumberSetting(f_12180, f_12181, f_12182, f_12183, f_12184).m_356(() -> this.f_12160.m_2073(f_12229));
      this.f_12162 = new NumberSetting(f_12185, f_12186, f_12187, 1.0F, f_12188).m_356(() -> this.f_12160.m_2073(f_12228));
      this.f_12163 = new NumberSetting(f_12189, f_12190, 0.0F, f_12191, 1.0F).m_356(() -> this.f_12160.m_2073(f_12227));
      this.f_12164 = new BooleanSetting(f_12192, true).m_334(() -> this.f_12160.m_2073(f_12226));
      this.f_12165 = new Util125();
   }

   private void m_3233() {
      if (!this.f_12160.m_3862().equals(this.f_12170)) {
         Util21.m_2688(1.0F);
         MathUtil3.f_6063 = !this.f_12160.m_2073(f_12222) && InitManager.f_2740.f_2741.disabler.m_677();
         this.m_1151();
         this.f_12170 = this.f_12160.m_3862();
      }
   }

   @EventHandler
   public void m_679(Util32 var1) {
      if (this.m_4077() && !this.f_12160.m_2073(f_12197)) {
         Disabler var2 = InitManager.f_2740.f_2741.disabler;
         double var3 = Math.toRadians(Util38.m_2235(false));
         double var5 = -Math.sin(var3);
         double var7 = Math.cos(var3);
         double var9 = f_12198;
         if (this.f_12160.m_2073(f_12199)) {
            if (var2.m_677()) {
               Util21.m_2688(f_12200);
            }

            if (this.f_12166 > 3) {
               if (this.f_12166 % 2 == 0) {
                  if (!f_5909.player.isTouchingWater()) {
                     f_5909.player.addVelocityInternal(new Vec3d(0.0, f_12201, 0.0));
                  }

                  if (f_5909.player.isOnGround()) {
                     var9 = f_12202;
                  }
               }

               if (Util38.m_547() == f_12203) {
                  var5 = 0.0;
                  var7 = 0.0;
               }

               f_5909.player.addVelocityInternal(new Vec3d(var5 * var9, 0.0, var7 * var9));
            }

            this.f_12166++;
         }

         if (this.f_12160.m_2073(f_12204)) {
            if (f_5909.player.verticalCollision && f_5909.player.isOnGround() && this.f_12166 > 2) {
               this.f_12169++;
               this.f_12166 = 0;
               f_5909.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(f_5909.player, Mode.START_FALL_FLYING));
               f_5909.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(f_5909.player, Mode.START_FALL_FLYING));
               this.f_12168++;
            }

            if (this.f_12166 == 1 && this.f_12169 > 0) {
               f_5909.player.jump();
               Util38.m_3123(f_12205);
               Util38.m_3292(var5 * var9);
               Util38.m_781(var7 * var9);
            }

            if (this.f_12166 == 2 && this.f_12169 > 0) {
               Util38.m_3123(f_12206);
               var9 = f_12207;
               Util38.m_3292(var5 * var9);
               Util38.m_781(var7 * var9);
            }

            this.f_12166++;
         }
      }
   }
}
