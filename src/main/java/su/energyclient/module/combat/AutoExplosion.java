package su.energyclient.module.combat;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventClickBlockRight;
import su.energyclient.event.impl.EventPlaceBlock;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util138;
import su.energyclient.util.Util170;
import su.energyclient.util.Util36;
import su.energyclient.util.Util54;

public class AutoExplosion extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private BlockPos f_12420;
   private int f_12421;
   private boolean f_12422;
   private int f_12423;
   private boolean f_12424;
   private Box f_12425;
   private BlockPos f_12426;
   private boolean f_12427;
   private final BooleanSetting f_12428;
   private final BooleanSetting f_12429;
   private static final String f_12430 = "Auto Explosion";
   private static final String f_12431 = "Автоматичeски взрывает кристаллы";
   private static final String f_12432 = "Не взрывать себя";
   private static final String f_12433 = "Не взрывать ресурсы";
   private static final double f_12434 = 90.0;
   private static final float f_12435 = 180.0F;
   private static final double f_12436 = 90.0;
   private static final float f_12437 = 180.0F;
   private static final double f_12438 = 0.1;
   private static final double f_12439 = 6.0;
   private static final String f_12440 = "netherite";

   public int m_1539(Item var1, boolean var2) {
      byte var3 = 0;
      int var4 = var2 ? 9 : 36;
      int var5 = -1;

      for (int var6 = var3; var6 < var4; var6++) {
         if (f_5909.player.getInventory().getStack(var6).getItem() == var1) {
            var5 = var6;
         }
      }

      return var5;
   }

   @EventHandler
   private void m_3328(Util170 var1) {
      if (this.f_12424) {
         this.f_12424 = false;
         f_5909.player.getInventory().setSelectedSlot(this.f_12423);
         ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
      } else if (this.f_12420 != null) {
         if (this.m_3488(this.f_12420) || f_5909.world.getBlockState(this.f_12420).isAir()) {
            this.m_2802();
         } else if (this.f_12427) {
            this.f_12427 = false;
         } else {
            Vec3d var2 = f_5909.player.getCameraPosVec(f_5909.getRenderTickCounter().getTickProgress(true));
            Vec3d var3 = Util36.m_3001(var2, new Box(this.f_12420));
            Vec3d var4 = var3.subtract(var2);
            float var5 = (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var4.z, var4.x)) - f_12434);
            float var6 = (float)(-Math.toDegrees(Math.atan2(var4.y, Math.hypot(var4.x, var4.z))));
            Util54.m_3501(new Util10(var5, var6), f_12435, 1, 6);
            this.f_12423 = f_5909.player.getInventory().getSelectedSlot();
            f_5909.player.getInventory().setSelectedSlot(this.f_12421);
            ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
            var4 = var4.negate();
            f_5909.interactionManager
               .interactBlock(
                  f_5909.player,
                  Hand.MAIN_HAND,
                  new BlockHitResult(var3, Direction.getFacing((float)var4.x, (float)var4.y, (float)var4.z), this.f_12420, false)
               );
            f_5909.player.swingHand(Hand.MAIN_HAND);
            this.f_12424 = true;
            if (this.f_12422) {
               this.f_12421 = this.f_12423;
               this.f_12422 = false;
            } else {
               this.m_2802();
            }
         }
      }
   }

   private void m_1887() {
      this.f_12425 = null;
      this.f_12426 = null;
   }

   public AutoExplosion() {
      super(f_12430, f_12431, Category.COMBAT);
      this.f_12428 = new BooleanSetting(f_12432, true);
      this.f_12429 = new BooleanSetting(f_12433, true);
   }

   @EventHandler
   private void m_196(Util170 var1) {
      if (this.f_12425 != null) {
         if (this.f_12426 != null && this.m_3488(this.f_12426)) {
            this.m_1887();
            return;
         }

         for (Entity var3 : f_5909.world.getEntities()) {
            if (var3 instanceof EndCrystalEntity && this.f_12425.contains(var3.getEntityPos())) {
               EndCrystalEntity var4 = (EndCrystalEntity)var3;
               BlockPos var5 = BlockPos.ofFloored(var4.getX(), var4.getY() - 1.0, var4.getZ());
               if (this.m_3488(var5)) {
                  this.m_1887();
                  return;
               }

               if (this.f_12428.m_1163()) {
                  double var6 = f_5909.player.getY();
                  double var8 = var4.getY();
                  if (Math.abs(var6 - var8) < 1.0) {
                     this.m_1887();
                     return;
                  }
               }

               if (this.m_1147(var4)) {
                  this.m_1887();
                  return;
               }

               if (!var4.getBoundingBox().contains(f_5909.player.getCameraPosVec(f_5909.getRenderTickCounter().getTickProgress(true)))) {
                  Vec3d var10 = Util36.m_3448(var4);
                  float var7 = (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var10.z, var10.x)) - f_12436);
                  float var11 = (float)(-Math.toDegrees(Math.atan2(var10.y, Math.hypot(var10.x, var10.z))));
                  Util54.m_3501(new Util10(var7, var11), f_12437, 1, 6);
               }

               f_5909.interactionManager.attackEntity(f_5909.player, var4);
               f_5909.player.swingHand(Hand.MAIN_HAND);
               this.m_1887();
               return;
            }
         }
      }
   }

   @EventHandler
   private void m_702(EventClickBlockRight var1) {
      BlockPos var2 = var1.m_3080().getBlockPos();
      if (this.m_3488(var2)) {
         if (var2.equals(this.f_12426)) {
            this.m_1887();
         }
      } else {
         if (!f_5909.player.getItemCooldownManager().isCoolingDown(Items.END_CRYSTAL.getDefaultStack())) {
            Block var3 = var1.m_85().getBlockState(var1.m_3080().getBlockPos()).getBlock();
            if (var3 == Blocks.OBSIDIAN || var3 == Blocks.BEDROCK) {
               this.f_12426 = var2.toImmutable();
               this.f_12425 = new Box(var1.m_3080().getBlockPos().up()).expand(f_12438);
            }
         }
      }
   }

   private boolean m_1147(EndCrystalEntity var1) {
      if (this.f_12429.m_1163() && f_5909.world != null) {
         Vec3d var2 = new Vec3d(var1.getX(), var1.getY(), var1.getZ());
         Box var3 = new Box(var2, var2).expand(f_12439);

         for (ItemEntity var5 : f_5909.world.getEntitiesByClass(ItemEntity.class, var3, Entity::isAlive)) {
            if (this.m_851(var5.getStack().getItem())) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean m_3488(BlockPos var1) {
      Util138 var2 = Util138.m_3050();
      return var2.m_1948(this, var1) || var2.m_1948(this, var1.up());
   }

   private void m_2802() {
      this.f_12420 = null;
      this.f_12422 = false;
      this.f_12427 = false;
   }

   private boolean m_851(Item var1) {
      if (var1 != Items.GOLDEN_APPLE && var1 != Items.ENCHANTED_GOLDEN_APPLE && var1 != Items.ELYTRA && var1 != Items.PLAYER_HEAD && var1 != Items.END_CRYSTAL) {
         String var2 = var1.getTranslationKey();
         return var2 != null && var2.contains(f_12440);
      } else {
         return true;
      }
   }

   @EventHandler
   public void m_4002(EventPlaceBlock var1) {
      if (this.m_3488(var1.m_1421())) {
         if (var1.m_1421().equals(this.f_12420)) {
            this.m_2802();
         }

         if (var1.m_1421().equals(this.f_12426)) {
            this.m_1887();
         }
      } else {
         if (var1.m_2404() == Blocks.OBSIDIAN) {
            if (f_5909.player.getItemCooldownManager().isCoolingDown(Items.END_CRYSTAL.getDefaultStack())) {
               return;
            }

            int var2 = this.m_1539(Items.END_CRYSTAL, true);
            if (var2 == -1) {
               return;
            }

            this.f_12420 = var1.m_1421().toImmutable();
            this.f_12421 = var2;
         } else if (var1.m_2404() instanceof RespawnAnchorBlock) {
            int var3 = this.m_1539(Items.GLOWSTONE, true);
            if (var3 == -1) {
               return;
            }

            this.f_12420 = var1.m_1421().toImmutable();
            this.f_12421 = var3;
            this.f_12422 = true;
         }

         this.f_12427 = true;
      }
   }
}
