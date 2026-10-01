package su.energyclient.module.combat;

import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket.Handler;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.mixin.PlayerInteractEntityC2SPacketMixin;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util170;
import su.energyclient.util.Util64;
import su.energyclient.util.Util66;

public class AntiThorns extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_5916;
   private static final String f_5917 = "Anti Thorns";
   private static final String f_5918 = "Убирает откид от шипов когда ты и таргет летите на элитре";

   @EventHandler
   public void m_2992(Util66 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (var1.m_2586() && var1.m_3295() instanceof PlayerInteractEntityC2SPacket var2 && this.l(var2) && f_5909.player.isGliding()) {
            int var8 = ((PlayerInteractEntityC2SPacketMixin)var2).getEntityId();
            if (f_5909.world.getEntityById(var8) instanceof LivingEntity var5 && this.l(var5)) {
               this.f_5916 = 10;
            }
         } else if (var1.m_2068()) {
            if (var1.m_3295() instanceof EntityVelocityUpdateS2CPacket var6 && var6.getEntityId() == f_5909.player.getId() && this.m_2500()) {
               var1.m_277(true);
            }
         }
      } else {
         this.f_5916 = 0;
      }
   }

   @Override
   public void m_1() {
      this.f_5916 = 0;
      super.m_1();
   }

   private boolean l(PlayerInteractEntityC2SPacket var1) {
      final boolean[] var2 = new boolean[]{false};
      var1.handle(new Handler() {
         public void attack() {
            var2[0] = true;
         }

         public void interact(Hand var1) {
         }

         public void interactAt(Hand var1, Vec3d var2x) {
         }
      });
      return var2[0];
   }

   private boolean l(LivingEntity var1) {
      return var1 != null && var1.isGliding();
   }

   public AntiThorns() {
      super(f_5917, f_5918, Category.COMBAT);
   }

   @EventHandler
   public void l(Util64 var1) {
      if (f_5909.player != null && var1.m_3243() == f_5909.player) {
         if (f_5909.player.isGliding() && this.l(var1.m_4084())) {
            this.f_5916 = 10;
            var1.m_277(true);
         }
      }
   }

   @Override
   public void m_2() {
      this.f_5916 = 0;
      super.m_2();
   }

   @EventHandler
   public void m_3696(Util170 var1) {
      if (f_5909.player != null && f_5909.player.isGliding()) {
         if (this.f_5916 > 0) {
            this.f_5916--;
         }
      } else {
         this.f_5916 = 0;
      }
   }

   private boolean m_2500() {
      return this.f_5916 > 0 && f_5909.player.isGliding();
   }
}
