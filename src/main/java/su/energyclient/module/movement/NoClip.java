package su.energyclient.module.movement;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.PositionAndOnGround;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventNoPush;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util162;
import su.energyclient.util.Util170;
import su.energyclient.util.Util49;

public class NoClip extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_4042 = "No Clip";
   private static final String f_4043 = "Клипает через блоки по одному блоку в направлении взгляда";
   private static final double f_4044 = 0.001;
   private static final double f_4045 = 0.15;

   @EventHandler
   public void m_3061(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null && f_5909.player.isAlive() && !f_5909.player.hasVehicle()) {
         if (f_5909.player.getAbilities().flying) {
            Vec3d var2 = (Util49.m_2511() ? Vec3d.fromPolar(Util49.m_3811(), Util49.m_883()) : f_5909.player.getRotationVector()).normalize();
            Box var3 = f_5909.player.getBoundingBox().contract(f_4044).stretch(var2.multiply(f_4045));
            if (f_5909.world.getBlockCollisions(f_5909.player, var3).iterator().hasNext()) {
               Vec3d var4 = f_5909.player.getEntityPos().add(var2.multiply(1.0));
               Util162.m_1605(new PositionAndOnGround(var4.x, var4.y, var4.z, false, f_5909.player.horizontalCollision));
            }
         }
      }
   }

   public NoClip() {
      super(f_4042, f_4043, Category.MOVEMENT);
   }

   @EventHandler
   public void m_3434(EventNoPush var1) {
      if (var1.f_8760 == EventNoPush.Inner_4C0TXA9Fous6eGMB.Block) {
         var1.m_277(true);
      }
   }
}
