package su.energyclient.module.miscellaneous;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.mixin.MinecraftClientMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util170;

public class CrystalOptimizer extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BooleanSetting f_10400;
   public EndCrystalEntity f_10401;
   private static final String f_10402 = "Crystal Optimizer";
   private static final String f_10403 = "Не взрывать ресурсы";
   private static final double f_10404 = 3.0;
   private static final double f_10405 = 3.0;
   private static final float f_10406 = 0.3F;
   private static final double f_10407 = 3.0;
   private static final double f_10408 = 2.0;

   private boolean m_2609(BlockPos var1) {
      if (f_5909.world == null) {
         return false;
      } else {
         double var2 = f_10407;
         Box var4 = new Box(
            var1.getX() - var2, var1.getY() - var2, var1.getZ() - var2, var1.getX() + var2 + 1.0, var1.getY() + var2 + f_10408, var1.getZ() + var2 + 1.0
         );

         for (Entity var6 : f_5909.world.getOtherEntities(null, var4)) {
            if (var6 instanceof ItemEntity var7) {
               Item var8 = var7.getStack().getItem();
               if (var8 == Items.NETHERITE_HELMET
                  || var8 == Items.NETHERITE_CHESTPLATE
                  || var8 == Items.NETHERITE_LEGGINGS
                  || var8 == Items.NETHERITE_BOOTS
                  || var8 == Items.DIAMOND_HELMET
                  || var8 == Items.DIAMOND_CHESTPLATE
                  || var8 == Items.DIAMOND_LEGGINGS
                  || var8 == Items.DIAMOND_BOOTS
                  || var8 == Items.NETHERITE_SWORD
                  || var8 == Items.DIAMOND_SWORD
                  || var8 == Items.NETHERITE_PICKAXE
                  || var8 == Items.DIAMOND_PICKAXE
                  || var8 == Items.NETHERITE_SHOVEL
                  || var8 == Items.DIAMOND_SHOVEL
                  || var8 == Items.NETHERITE_AXE
                  || var8 == Items.DIAMOND_AXE
                  || var8 == Items.TOTEM_OF_UNDYING
                  || var8 == Items.END_CRYSTAL
                  || var8 == Items.ENCHANTED_GOLDEN_APPLE
                  || var8 == Items.GOLDEN_APPLE
                  || var8 == Items.ENDER_PEARL
                  || var8 == Items.TRIDENT
                  || var8 == Items.CROSSBOW
                  || var8 == Items.ELYTRA) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   private boolean m_442(Entity var1) {
      return var1 instanceof EndCrystalEntity;
   }

   public EndCrystalEntity m_2872() {
      return this.f_10401;
   }

   private EndCrystalEntity m_3801() {
      for (Entity var2 : f_5909.world.getEntities()) {
         if (this.m_442(var2)) {
            EndCrystalEntity var3 = (EndCrystalEntity)var2;
            if (this.m_1737(var3) && this.m_3370(var3) && (!this.f_10400.m_1163() || !this.m_2609(var3.getBlockPos()))) {
               return var3;
            }
         }
      }

      return null;
   }

   private boolean m_1737(EndCrystalEntity var1) {
      double var2 = f_5909.player.distanceTo(var1);
      return var2 <= f_10404;
   }

   @EventHandler
   public void m_3788(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         this.f_10401 = this.m_3801();
         if (this.f_10401 != null && f_5909.options.useKey.isPressed()) {
            ((MinecraftClientMixin2)f_5909).setItemUseCooldown(0);
            this.m_1711(this.f_10401);
         }
      }
   }

   @EventHandler
   public void m_4088(EventAttack var1) {
      if (var1.m_1070() instanceof EndCrystalEntity var2) {
         var2.remove(RemovalReason.DISCARDED);
      }
   }

   public CrystalOptimizer() {
      super(f_10402, "", Category.MISCELLANEOUS);
      this.f_10400 = new BooleanSetting(f_10403, true);
      this.f_10401 = null;
   }

   private boolean m_3370(EndCrystalEntity var1) {
      BlockPos var2 = var1.getBlockPos();
      BlockPos var3 = var2.down();
      Vec3d var4 = f_5909.player.getEyePos();
      Vec3d var5 = var4.add(f_5909.player.getRotationVec(1.0F).multiply(f_10405));
      EntityHitResult var6 = ProjectileUtil.getEntityCollision(
         f_5909.world, f_5909.player, var4, var5, new Box(var4, var5).expand(1.0), var1x -> var1x == var1, f_10406
      );
      if (var6 != null) {
         return true;
      } else {
         BlockHitResult var7 = f_5909.world.raycast(new RaycastContext(var4, var5, ShapeType.OUTLINE, FluidHandling.NONE, f_5909.player));
         if (var7.getType() == Type.BLOCK) {
            BlockPos var8 = var7.getBlockPos();
            return var8.equals(var3);
         } else {
            return false;
         }
      }
   }

   private void m_1711(EndCrystalEntity var1) {
      f_5909.interactionManager.attackEntity(f_5909.player, var1);
      f_5909.player.swingHand(Hand.MAIN_HAND);
   }
}
