package su.energyclient.util;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket.Handler;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardEntry;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.ModuleManager;
import su.energyclient.mixin.ClientPlayerEntityMixin2;
import su.energyclient.mixin.LivingEntityMixin;
import su.energyclient.mixin.PlayerInteractEntityC2SPacketMixin;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.util.math.MathUtil1;

public class Util129 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final MathUtil1 f_10652 = new MathUtil1();
   private ClientPlayerEntity f_10653;
   private ClientWorld f_10654;
   private long f_10655;
   private boolean f_10656;
   private boolean f_10657;
   private static final float f_10658 = 0.5F;
   private static final String f_10659 = "Только криты";
   private static final float f_10660 = 0.5F;
   private static final float f_10661 = 0.5F;
   private static final float f_10662 = 0.9F;
   private static final String f_10663 = "Только криты";
   private static final double f_10664 = 20.0;
   private static final float f_10665 = 0.9F;
   private static final String f_10666 = "Только криты";
   private static final String f_10667 = "Legit";
   private static final String f_10668 = "Spooky";
   private static final String f_10669 = "spookytime";
   private static final String f_10670 = "Время боя: ";
   private static final String f_10671 = "Противник: ";

   private boolean m_295() {
      return f_5909.player != null && (f_5909.player.isSprinting() || Util50.f_7978 || ((ClientPlayerEntityMixin2)f_5909.player).getLastSprinting());
   }

   public void m_3987(Util66 var1, AttackAura var2) {
      if (!var1.m_2244()) {
         if (var1.m_2068() && var1.m_3295() instanceof PlayerPositionLookS2CPacket) {
            this.m_2572();
         }
      }
   }

   public void m_2681(Packet<?> var1, final AttackAura var2) {
      if (f_5909.player != null && f_5909.world != null) {
         if (var1 instanceof PlayerMoveC2SPacket var3) {
            if (!var3.changesPosition()) {
               if (var3.isOnGround()) {
                  this.f_10652.m_2111(0.0, true);
               }

               return;
            }

            double var5 = ((ClientPlayerEntityMixin2)f_5909.player).getLastYClient();
            int var7 = ((Util74)f_5909.player).energy$getAirTicks();
            this.f_10652.m_2111(var3.getY(f_5909.player.getY()) - var5, this.f_10657 || var7 >= 3);
         } else if (var1 instanceof PlayerInteractEntityC2SPacket var4) {
            final int var8 = ((PlayerInteractEntityC2SPacketMixin)var4).getEntityId();
            final boolean var6 = f_5909.world.getEntityById(var8) instanceof PlayerEntity;
            var4.handle(new Handler() {
               public void interactAt(Hand var1, Vec3d var2x) {
               }

               public void attack() {
                  if (var6) {
                     Util129.this.f_10652.O(System.currentTimeMillis());
                  }

                  if (var2.f_3636 && var2.m_891() != null && var2.m_891().getId() == var8) {
                     var2.m_2972();
                  }
               }

               public void interact(Hand var1) {
               }
            });
         }
      }
   }

   private boolean m_2323(AttackAura var1, float var2, int var3) {
      if (f_5909.player != null && f_5909.world != null) {
         ModuleManager var4 = InitManager.f_2740.f_2741;
         double var5 = var4.tickrateSync != null && var4.tickrateSync.m_677() ? Util60.m_1276() : f_10664;
         float var7 = this.m_4023(var1, var2, var5);
         if (var4.fastCriticals != null && var4.fastCriticals.m_2778(var1.m_891())) {
            return var7 > f_10665;
         } else {
            long var8 = System.currentTimeMillis();
            return MathUtil1.m_3417(var7, var8 - this.f_10655, var3);
         }
      } else {
         return false;
      }
   }

   private boolean m_990() {
      if (!Util101.m_3117(f_10669)) {
         return false;
      } else {
         Scoreboard var1 = f_5909.world.getScoreboard();
         ScoreboardObjective var2 = var1.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
         if (var2 == null) {
            return false;
         } else {
            boolean var3 = false;
            boolean var4 = false;

            for (ScoreboardEntry var6 : var1.getScoreboardEntries(var2)) {
               Team var7 = var1.getScoreHolderTeam(var6.owner());
               String var8 = Team.decorateName(var7, Text.literal(var6.owner())).getString();
               if (var8.contains(f_10670)) {
                  var3 = true;
               } else if (var8.contains(f_10671)) {
                  var4 = true;
               }

               if (var3 && var4) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   public boolean m_3815(AttackAura var1) {
      return Util75.m_2491(var1.m_857().m_1163());
   }

   public void m_2274(AttackAura var1) {
      if (f_5909.player != null) {
         this.f_10655 = System.currentTimeMillis();
         StatusEffectInstance var2 = f_5909.player.getStatusEffect(StatusEffects.MINING_FATIGUE);
         this.f_10652.m_740(var2 == null ? -1 : var2.getAmplifier(), f_5909.player.getVelocity().y);
         if (this.f_10657 && this.m_599(var1)) {
            this.f_10652.m_1215();
         }
      }
   }

   public boolean m_2998() {
      return this.f_10652.m_2562();
   }

   public void m_2004() {
      if (this.f_10656) {
         this.f_10656 = false;
         if (f_5909.player != null && f_5909.player.networkHandler != null) {
            f_5909.player.networkHandler.sendPacket(new ClientCommandC2SPacket(f_5909.player, Mode.START_SPRINTING));
            f_5909.player.setSprinting(true);
            ((ClientPlayerEntityMixin2)f_5909.player).setLastSprinting(Util50.f_7978);
         }
      }
   }

   public void m_1142(AttackAura var1) {
      if (!var1.m_1871() && this.m_599(var1) && this.m_295() && this.m_1145(var1)) {
         if (this.m_2323(var1, 2.0F, 50) && this.m_794(var1, false, false, 1)) {
            f_5909.player.setSprinting(false);
            this.f_10652.m_1215();
         }
      }
   }

   public boolean m_2318(AttackAura var1) {
      if (var1.m_1871() || !this.m_2323(var1, f_10660, 0) || f_5909.player.getAttackCooldownProgress(f_10661) <= f_10662 || !this.m_794(var1, true, false, 0)) {
         return false;
      } else {
         return var1.m_1233().I(f_10663) && this.m_3815(var1)
            ? !f_5909.player.isClimbing()
               && !f_5909.player.isTouchingWater()
               && !f_5909.player.hasStatusEffect(StatusEffects.BLINDNESS)
               && !f_5909.player.hasVehicle()
               && !f_5909.player.isSprinting()
               && !Util50.f_7978
            : true;
      }
   }

   public float m_1567(AttackAura var1, double var2) {
      return f_5909.player == null ? 0.0F : MathUtil1.m_3099(f_5909.player.getAttributeValue(EntityAttributes.ATTACK_SPEED), Util117.f_13187, var2);
   }

   public void m_2572() {
      this.f_10652.m_3713();
      this.f_10653 = f_5909.player;
      this.f_10654 = f_5909.world;
      this.f_10655 = 0L;
      this.f_10656 = false;
      this.f_10657 = false;
   }

   public boolean m_2385() {
      return this.f_10652.m_1764();
   }

   public boolean m_794(AttackAura var1, boolean var2, boolean var3, int var4) {
      if (f_5909.player != null && f_5909.world != null) {
         if (!var1.m_1233().I(f_10659)) {
            return true;
         } else if (var2 && !this.m_3815(var1)) {
            return true;
         } else {
            if (var3) {
               this.f_10652.m_1512(f_5909.player.getY());
            }

            boolean var5;
            if (var4 > 0) {
               Util17 var6 = new Util17(f_5909.player);
               var6.m_3847(var4);
               var5 = !var6.m_3146() && var6.m_3632() > 0.0;
            } else {
               var5 = !f_5909.player.isOnGround() && f_5909.player.fallDistance > 0.0 && f_5909.player.getVelocity().y < 0.0;
            }

            return this.f_10652.m_1928() && new Util17(f_5909.player).m_4039(2) > 1 ? false : var5;
         }
      } else {
         return false;
      }
   }

   public boolean m_1110(AttackAura var1) {
      if (f_5909.player == null || f_5909.world == null) {
         return false;
      } else if (!this.m_1145(var1)) {
         return true;
      } else {
         boolean var2 = f_5909.player.isSprinting();
         ClientPlayerEntityMixin2 var3 = (ClientPlayerEntityMixin2)f_5909.player;
         boolean var4 = Util50.f_7978 || var3.getLastSprinting();
         f_5909.player.setSprinting(false);
         if (this.m_599(var1)) {
            if (var4) {
               var3.setLastSprinting(true);
               this.f_10652.m_1215();
               return false;
            } else {
               return true;
            }
         } else {
            if (var4) {
               f_5909.player.networkHandler.sendPacket(new ClientCommandC2SPacket(f_5909.player, Mode.STOP_SPRINTING));
               if (Util50.f_7978) {
                  return false;
               }

               var3.setLastSprinting(false);
            }

            this.f_10656 = var2 || var4;
            return true;
         }
      }
   }

   public float m_4023(AttackAura var1, float var2, double var3) {
      if (f_5909.player == null) {
         return 0.0F;
      } else {
         int var5 = ((LivingEntityMixin)f_5909.player).getTicksSinceLastAttack();
         return MathHelper.clamp((var5 + var2) / this.m_1567(var1, var3), 0.0F, 1.0F);
      }
   }

   private boolean m_1145(AttackAura var1) {
      return var1.m_1233().I(f_10666) && this.m_3815(var1);
   }

   private boolean m_599(AttackAura var1) {
      return var1.m_1920().m_2073(f_10667) || var1.m_2597().m_2073(f_10668);
   }

   public void m_2015() {
      if (this.f_10653 != f_5909.player || this.f_10654 != f_5909.world) {
         this.m_2572();
      }

      if (f_5909.player != null && f_5909.world != null) {
         this.f_10652.m_1802(f_5909.player.isOnGround());
         this.f_10657 = this.m_990();
      }
   }

   public boolean m_2980(AttackAura var1) {
      return f_5909.player != null && f_5909.world != null && this.m_2323(var1, f_10658, 0) && this.m_794(var1, true, true, 0);
   }
}
