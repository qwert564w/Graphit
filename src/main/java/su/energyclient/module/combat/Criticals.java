package su.energyclient.module.combat;

import net.minecraft.block.Blocks;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.Full;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.PositionAndOnGround;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.manager.InitManager;
import su.energyclient.mixin.ClientPlayerEntityMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util101;

public class Criticals extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final ModeSetting f_2689;
   private static final String f_2690 = "Criticals";
   private static final String f_2691 = "Always deal critical hits";
   private static final String f_2692 = "Мод";
   private static final String f_2693 = "Grim old";
   private static final String f_2694 = "Grim old";
   private static final String f_2695 = "Slow/Web";
   private static final String f_2696 = "Grim old";
   private static final String f_2697 = "mineblaze";
   private static final double f_2698 = 0.01F;
   private static final double f_2699 = -1.0E-6;
   private static final double f_2700 = 0.01F;
   private static final double f_2701 = -1.0E-6;
   private static final String f_2702 = "Slow/Web";
   private static final double f_2703 = 0.08F;
   private static final double f_2704 = -1.0E-6;

   public Criticals() {
      super(f_2690, f_2691, Category.COMBAT);
      this.f_2689 = new ModeSetting(f_2692, f_2693, f_2694, f_2695);
   }

   private void m_2717(double var1) {
      f_5909.player
         .networkHandler
         .sendPacket(
            new Full(
               f_5909.player.getX(),
               f_5909.player.getY() + var1,
               f_5909.player.getZ(),
               ((ClientPlayerEntityMixin2)f_5909.player).getLastYaw(),
               ((ClientPlayerEntityMixin2)f_5909.player).getLastPitch(),
               false,
               false
            )
         );
   }

   @EventHandler
   public void m_998(EventAttack var1) {
      if (!var1.m_2244() && !Macetarget.m_329()) {
         AttackAura var2 = InitManager.f_2740.f_2741.attackAura;
         if (this.f_2689.m_2073(f_2696)) {
            if (!Util101.m_3117(f_2697)) {
               if (var2.m_891() != null
                  && var1.m_1070() == var2.m_891()
                  && !f_5909.player.isOnGround()
                  && !f_5909.player.isGliding()
                  && !f_5909.player.isTouchingWater()) {
                  f_5909.player.fallDistance = f_2698;
                  this.m_2717(f_2699);
               }
            } else if (var2.m_891() != null && var1.m_1070() == var2.m_891() && !f_5909.player.isTouchingWater()) {
               f_5909.player.fallDistance = f_2700;
               this.m_2717(f_2701);
            }
         }

         if (this.f_2689.m_2073(f_2702)
            && var2.m_891() != null
            && var1.m_1070() == var2.m_891()
            && !f_5909.player.isOnGround()
            && !f_5909.player.isGliding()
            && !f_5909.player.isTouchingWater()) {
            Box var3 = f_5909.player.getBoundingBox();
            boolean var4 = false;

            for (BlockPos var6 : BlockPos.iterate(
               MathHelper.floor(var3.minX),
               MathHelper.floor(var3.minY),
               MathHelper.floor(var3.minZ),
               MathHelper.floor(var3.maxX),
               MathHelper.floor(var3.maxY),
               MathHelper.floor(var3.maxZ)
            )) {
               if (f_5909.world.getBlockState(var6).isOf(Blocks.COBWEB)) {
                  var4 = true;
                  break;
               }
            }

            if (var4) {
               f_5909.player.fallDistance = f_2703;
               f_5909.player
                  .networkHandler
                  .sendPacket(new PositionAndOnGround(f_5909.player.getX(), f_5909.player.getY() + f_2704, f_5909.player.getZ(), false, false));
            }
         }
      }
   }
}
