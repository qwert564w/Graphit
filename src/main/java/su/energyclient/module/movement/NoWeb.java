package su.energyclient.module.movement;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.Blocks;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util21;
import su.energyclient.util.Util32;
import su.energyclient.util.Util38;
import su.energyclient.util.Util66;
import su.energyclient.util.Util94;

public class NoWeb extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BooleanSetting f_5051;
   private final ObjectArrayList<BlockUpdateS2CPacket> f_5052;
   int f_5053;
   boolean f_5054;
   private static final String f_5055 = "No Web";
   private static final String f_5056 = "description";
   private static final String f_5057 = "Полноценный";
   private static final double f_5058 = 0.8;
   private static final double f_5059 = -0.8;
   private static final double f_5060 = 0.22F;

   @EventHandler
   public void m_3660(Util66 var1) {
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_5053 = 0;
      Util38.f_7823 = false;
   }

   @Override
   public void m_1() {
      this.f_5054 = false;
      Util21.m_2688(1.0F);
      super.m_1();
   }

   @EventHandler
   public void I(Util32 var1) {
   }

   public NoWeb() {
      super(f_5055, f_5056, Category.MOVEMENT);
      this.f_5051 = new BooleanSetting(f_5057, false);
      this.f_5052 = new ObjectArrayList();
      this.f_5053 = 0;
   }

   @EventHandler
   public void l(Util94 var1) {
      if (!this.f_5051.m_1163()) {
         Box var2 = f_5909.player.getBoundingBox();
         boolean var3 = false;

         for (BlockPos var5 : BlockPos.iterate(
            MathHelper.floor(var2.minX),
            MathHelper.floor(var2.minY),
            MathHelper.floor(var2.minZ),
            MathHelper.floor(var2.maxX),
            MathHelper.floor(var2.maxY),
            MathHelper.floor(var2.maxZ)
         )) {
            if (f_5909.world.getBlockState(var5).isOf(Blocks.COBWEB)) {
               var3 = true;
               break;
            }
         }

         if (!var3) {
            return;
         }

         if (f_5909.options.jumpKey.isPressed()) {
            f_5909.player.setVelocity(new Vec3d(0.0, f_5058, 0.0));
         } else if (f_5909.options.sneakKey.isPressed()) {
            f_5909.player.setVelocity(new Vec3d(0.0, f_5059, 0.0));
         } else {
            f_5909.player.setVelocity(new Vec3d(0.0, 0.0, 0.0));
         }

         Util38.m_3702(f_5060);
      } else {
         ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager)
            .invokeSendSequencedPacket(f_5909.world, var1x -> new PlayerActionC2SPacket(Action.STOP_DESTROY_BLOCK, var1.m_1099(), Direction.UP, var1x));
         var1.m_277(true);
      }
   }
}
