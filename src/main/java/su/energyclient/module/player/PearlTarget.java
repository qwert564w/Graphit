package su.energyclient.module.player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.module.render.Prediction;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util121;
import su.energyclient.util.Util125;
import su.energyclient.util.Util146;
import su.energyclient.util.Util16;
import su.energyclient.util.Util170;
import su.energyclient.util.Util54;

public class PearlTarget extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_11102 = 1.5;
   private static final double f_11103 = 0.0;
   private static final float f_11104 = 0.0F;
   private final BooleanSetting f_11105;
   private final BooleanSetting f_11106;
   private Util10 f_11107;
   private boolean f_11108;
   private UUID f_11109;
   private Vec3d f_11110;
   private boolean f_11111;
   private final Util125 f_11112;
   private final Set<UUID> f_11113;
   private int f_11114;
   private int f_11115;
   private int f_11116;
   private int f_11117;
   private int f_11118;
   private static final String f_11119 = "Pearl Target";
   private static final String f_11120 = "Бросает эндер-жемчуг за таргетом из киллауры";
   private static final String f_11121 = "Обход HolyWorld";
   private static final String f_11122 = "Не бросать через энтити";
   private static final float f_11123 = 360.0F;
   private static final float O_ = 360.0F;
   private static final float f_11124 = 360.0F;
   private static final float f_11125 = 360.0F;
   private static final float f_11126 = 0.35F;
   private static final long O8 = 500L;
   private static final double f_11127 = 0.3;
   private static final float f_11128 = 90.0F;
   private static final float f_11129 = -8.0F;
   private static final float f_11130 = 8.0F;
   private static final float f_11131 = -89.0F;
   private static final float f_11132 = 89.0F;
   private static final float f_11133 = 3.0F;
   private static final float O0 = -89.0F;
   private static final float f_11134 = 89.0F;
   private static final float f_11135 = 0.35F;
   private static final float f_11136 = 0.12F;
   private static final float O6 = 0.04F;
   private static final float f_11137 = -89.0F;
   private static final float f_11138 = 89.0F;
   private static final double f_11139 = 0.1;
   private static final double f_11140 = 1.5;

   private Vec3d m_2089(Util10 var1) {
      Vec3d var2 = Util10.m_2531(var1.m_2573(), var1.m_2643()).multiply(f_11140);
      Vec3d var3 = f_5909.player.getMovement();
      return var2.add(var3.x, f_5909.player.isOnGround() ? 0.0 : var3.y, var3.z);
   }

   @Override
   public void m_1() {
      super.m_1();
      this.f_11107 = null;
      this.f_11108 = false;
      this.f_11109 = null;
      this.f_11110 = null;
      this.f_11111 = false;
      this.f_11112.m_3493();
      this.f_11113.clear();
      this.f_11114 = 0;
      this.f_11115 = -1;
      this.f_11116 = -1;
      this.f_11117 = 0;
      this.f_11118 = 0;
   }

   public PearlTarget() {
      super(f_11119, f_11120, Category.PLAYER);
      this.f_11105 = new BooleanSetting(f_11121, true);
      this.f_11106 = new BooleanSetting(f_11122, false);
      this.f_11112 = new Util125();
      this.f_11113 = new HashSet<>();
      this.f_11114 = 0;
      this.f_11115 = -1;
      this.f_11116 = -1;
      this.f_11117 = 0;
      this.f_11118 = 0;
   }

   private Vec3d m_739() {
      return new Vec3d(f_5909.player.getX(), f_5909.player.getEyeY() - f_11139, f_5909.player.getZ());
   }

   private Util10 m_3769(Vec3d var1) {
      Vec3d var2 = this.m_739();
      Vec3d var3 = var1.subtract(var2);
      float var4 = (float)Math.toDegrees(Math.atan2(var3.z, var3.x)) - f_11128;
      var4 = MathHelper.wrapDegrees(var4);
      PearlTarget.Inner_6LCJphIQ31GKwcDk var5 = null;

      for (float var6 = f_11129; var6 <= f_11130; var6 += 2.0F) {
         for (float var7 = f_11131; var7 <= f_11132; var7 += f_11133) {
            var5 = this.m_1908(var5, var4 + var6, var7, var1);
         }
      }

      if (var5 == null) {
         double var17 = Math.sqrt(var3.x * var3.x + var3.z * var3.z);
         float var19 = (float)(-Math.toDegrees(Math.atan2(var3.y, var17)));
         return new Util10(var4, MathHelper.clamp(var19, O0, f_11134));
      } else {
         float[] var16 = new float[]{1.0F, f_11135, f_11136, O6};

         for (float var10 : var16) {
            Util10 var11 = var5.rotation();
            PearlTarget.Inner_6LCJphIQ31GKwcDk var12 = var5;

            for (int var13 = -4; var13 <= 4; var13++) {
               for (int var14 = -4; var14 <= 4; var14++) {
                  var12 = this.m_1908(var12, var11.m_2643() + var13 * var10, var11.m_2573() + var14 * var10, var1);
               }
            }

            var5 = var12;
         }

         return var5.rotation();
      }
   }

   private Vec3d m_2267(LivingEntity var1) {
      if (this.f_11113.size() > 256) {
         this.f_11113.clear();
      }

      for (Entity var3 : f_5909.world.getEntities()) {
         if (var3 instanceof EnderPearlEntity var4 && var4.age <= 2) {
            UUID var5 = var4.getUuid();
            if (!this.f_11113.contains(var5)) {
               Entity var6 = var4.getOwner();
               if (var6 == null) {
                  PlayerEntity var7 = null;

                  for (PlayerEntity var9 : f_5909.world.getPlayers()) {
                     if (var7 == null || var9.squaredDistanceTo(var4) < var7.squaredDistanceTo(var4)) {
                        var7 = var9;
                     }
                  }

                  var6 = var7;
               }

               if (var6 != null && var6.getUuid().equals(var1.getUuid())) {
                  this.f_11113.add(var5);
                  return Prediction.m_1261(var4);
               }
            }
         }
      }

      return null;
   }

   @EventHandler
   public void m_637(Util16 var1) {
      if (this.f_11118 > 0 || this.f_11114 >= 1 && this.f_11114 <= 6) {
         var1.m_277(true);
      }
   }

   @EventHandler
   public void m_510(Util121 var1) {
      if (this.f_11118 > 0 || this.f_11114 >= 1 && this.f_11114 <= 4) {
         var1.m_433(0.0F);
         var1.m_2791(0.0F);
         var1.m_564(false);
         var1.m_1269(false);
      }
   }

   private boolean m_1035(Entity var1, Vec3d var2, Vec3d var3) {
      Box var4 = new Box(var2, var3).expand(f_11127);
      EntityHitResult var5 = ProjectileUtil.raycast(
         f_5909.player,
         var2,
         var3,
         var4,
         var1x -> EntityPredicates.CAN_HIT.test(var1x) && var1x != f_5909.player && var1x != var1 && !(var1x instanceof EnderPearlEntity),
         var2.squaredDistanceTo(var3)
      );
      return var5 != null;
   }

   private Vec3d m_3575(Util10 var1) {
      return Prediction.m_3433(this.m_739(), this.m_2089(var1));
   }

   @EventHandler
   public void m_602(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (this.f_11118 > 0) {
            this.f_11118--;
         }

         if (this.f_11107 != null && this.f_11114 != 0) {
            Util54.m_2498(this.f_11107, f_11123, O_, 5, 1000);
         }

         if (this.f_11114 == 6 && f_5909.player.age >= this.f_11117) {
            f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
            this.f_11114 = 5;
            this.f_11117 = f_5909.player.age + 2;
         }

         if (this.f_11114 == 5 && f_5909.player.age >= this.f_11117) {
            f_5909.player.getInventory().setSelectedSlot(this.f_11115);
            ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
            this.f_11115 = -1;
            this.f_11114 = 0;
            this.f_11107 = null;
         }

         if (this.f_11114 == 1 && this.f_11118 == 0) {
            this.f_11114 = 2;
         }

         if (this.f_11114 == 2 && this.f_11116 != -1) {
            f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, this.f_11116, this.f_11115, SlotActionType.SWAP, f_5909.player);
            f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(f_5909.player.currentScreenHandler.syncId));
            this.f_11114 = 3;
            this.f_11117 = f_5909.player.age + 2;
         }

         if (this.f_11114 == 3 && f_5909.player.age >= this.f_11117) {
            f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
            this.f_11114 = 4;
            this.f_11117 = f_5909.player.age + 3;
         }

         if (this.f_11114 == 4 && f_5909.player.age >= this.f_11117) {
            f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, this.f_11116, this.f_11115, SlotActionType.SWAP, f_5909.player);
            f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(f_5909.player.currentScreenHandler.syncId));
            this.f_11114 = 0;
            this.f_11116 = -1;
            this.f_11115 = -1;
            this.f_11107 = null;
         }

         if (this.f_11114 == 0 && this.f_11118 <= 0) {
            AttackAura var2 = InitManager.f_2740.f_2741.attackAura;
            LivingEntity var3 = var2.m_891();
            if (var2 != null && var2.m_677() && var3 != null && var3.isAlive()) {
               if (!this.f_11108) {
                  Vec3d var4 = this.m_2267(var3);
                  if (var4 == null) {
                     return;
                  }

                  this.f_11108 = true;
                  this.f_11109 = var3.getUuid();
                  this.f_11110 = var4;
                  this.f_11107 = null;
                  this.f_11111 = false;
                  this.f_11112.m_3493();
               }

               if (this.f_11109 != null && !this.f_11109.equals(var3.getUuid())) {
                  this.f_11108 = false;
                  this.f_11109 = null;
                  this.f_11110 = null;
                  this.f_11107 = null;
                  this.f_11111 = false;
                  this.f_11112.m_3493();
               } else if (this.f_11110 == null) {
                  this.f_11108 = false;
                  this.f_11109 = null;
                  this.f_11107 = null;
                  this.f_11111 = false;
                  this.f_11112.m_3493();
               } else if (f_5909.player.getItemCooldownManager().isCoolingDown(Items.ENDER_PEARL.getDefaultStack())) {
                  this.f_11108 = false;
                  this.f_11109 = null;
                  this.f_11110 = null;
                  this.f_11107 = null;
                  this.f_11111 = false;
                  this.f_11112.m_3493();
               } else if (Util146.m_1302(Items.ENDER_PEARL) == -1) {
                  this.f_11108 = false;
                  this.f_11109 = null;
                  this.f_11110 = null;
                  this.f_11107 = null;
                  this.f_11111 = false;
                  this.f_11112.m_3493();
               } else {
                  if (this.f_11107 == null) {
                     this.f_11107 = this.m_3769(this.f_11110);
                  }

                  Util54.m_2498(this.f_11107, f_11124, f_11125, 5, 1000);
                  if (!(Util10.m_3601().m_855(this.f_11107) > f_11126)) {
                     if (this.f_11106.m_1163()) {
                        boolean var6 = this.m_1035(var3, f_5909.player.getEyePos(), this.f_11110);
                        if (var6) {
                           if (!this.f_11111) {
                              this.f_11111 = true;
                              this.f_11112.m_3493();
                           }

                           if (!this.f_11112.m_2636(O8)) {
                              return;
                           }

                           this.f_11108 = false;
                           this.f_11109 = null;
                           this.f_11110 = null;
                           this.f_11107 = null;
                           this.f_11111 = false;
                           this.f_11112.m_3493();
                           return;
                        }

                        this.f_11111 = false;
                        this.f_11112.m_3493();
                     }

                     int var7 = Util146.m_1302(Items.ENDER_PEARL);
                     int var5 = f_5909.player.getInventory().getSelectedSlot();
                     if (var7 < 9) {
                        if (this.f_11105.m_1163()) {
                           f_5909.player.getInventory().setSelectedSlot(var7);
                           ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
                           this.f_11115 = var5;
                           this.f_11114 = 6;
                           this.f_11117 = f_5909.player.age + 2;
                           this.f_11108 = false;
                           this.f_11109 = null;
                           this.f_11110 = null;
                           this.f_11111 = false;
                           this.f_11112.m_3493();
                        } else {
                           f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var7));
                           f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
                           f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var5));
                           this.f_11107 = null;
                           this.f_11108 = false;
                           this.f_11109 = null;
                           this.f_11110 = null;
                           this.f_11111 = false;
                           this.f_11112.m_3493();
                        }
                     } else if (this.f_11105.m_1163()) {
                        this.f_11118 = 2;
                        this.f_11114 = 1;
                        this.f_11116 = var7;
                        this.f_11115 = var5;
                        this.f_11108 = false;
                        this.f_11109 = null;
                        this.f_11110 = null;
                        this.f_11111 = false;
                        this.f_11112.m_3493();
                     } else {
                        f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var7, var5, SlotActionType.SWAP, f_5909.player);
                        f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
                        f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var7, var5, SlotActionType.SWAP, f_5909.player);
                        this.f_11107 = null;
                        this.f_11108 = false;
                        this.f_11109 = null;
                        this.f_11110 = null;
                        this.f_11111 = false;
                        this.f_11112.m_3493();
                     }
                  }
               }
            } else {
               this.f_11107 = null;
               this.f_11108 = false;
               this.f_11109 = null;
               this.f_11110 = null;
               this.f_11111 = false;
               this.f_11112.m_3493();
            }
         }
      }
   }

   private PearlTarget.Inner_6LCJphIQ31GKwcDk m_1908(PearlTarget.Inner_6LCJphIQ31GKwcDk var1, float var2, float var3, Vec3d var4) {
      var3 = MathHelper.clamp(var3, f_11137, f_11138);
      var2 = MathHelper.wrapDegrees(var2);
      Util10 var5 = new Util10(var2, var3);
      Vec3d var6 = this.m_3575(var5);
      double var7 = var6.squaredDistanceTo(var4);
      return var1 != null && !(var7 < var1.score()) ? var1 : new PearlTarget.Inner_6LCJphIQ31GKwcDk(var5, var6, var7);
   }

   private record Inner_6LCJphIQ31GKwcDk(Util10 rotation, Vec3d landing, double score) {
   }
}
