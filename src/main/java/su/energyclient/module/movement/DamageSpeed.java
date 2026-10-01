package su.energyclient.module.movement;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.CommonPongC2SPacket;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.util.Util124;
import su.energyclient.util.Util152;
import su.energyclient.util.Util162;
import su.energyclient.util.Util170;
import su.energyclient.util.Util32;
import su.energyclient.util.Util66;

public class DamageSpeed extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final RenderUtil22 f_8288;
   private final ObjectArrayList<Packet<?>> f_8289;
   private boolean f_8290;
   private Vec3d f_8291;
   private static final String f_8292 = "Damage Speed";
   private static final String f_8293 = "description";
   private static final String f_8294 = "Бинд";
   private static final double f_8295 = 3.0;
   private static final double f_8296 = 3.0;
   private static final double f_8297 = 3.0;
   private static final String f_8298 = "УЛЕТАЕМ НАХУЙ";

   @EventHandler
   public void m_3330(Util32 var1) {
   }

   @EventHandler
   public void m_3525(Util170 var1) {
      if (this.f_8289.size() > 150) {
         this.m_2366();
      }
   }

   @EventHandler
   public void m_1821(Util124 var1) {
   }

   @EventHandler
   public void m_2554(Util66 var1) {
      if (var1.m_3295() instanceof CommonPongC2SPacket) {
         this.f_8289.add(var1.m_3295());
         var1.m_277(true);
      }

      if (var1.m_3295() instanceof EntityVelocityUpdateS2CPacket var2 && var2.getEntityId() == f_5909.player.getId()) {
         this.f_8291 = var2.getVelocity();
         var1.m_277(true);
      }
   }

   @EventHandler
   public void m_3360(CancellableEvent var1) {
      if (var1.m_2169() == this.f_8288.m_1958() && this.f_8291 != null) {
         f_5909.player.setVelocity(this.f_8291.getX() * f_8295, this.f_8291.getY() * f_8296, this.f_8291.getZ() * f_8297);
         this.f_8291 = null;
         Util152.m_662(f_8298);
         this.m_2366();
      }
   }

   public void m_2366() {
      int var1 = 0;
      ObjectListIterator var2 = this.f_8289.iterator();

      while (var2.hasNext()) {
         Packet var3 = (Packet)var2.next();
         var1++;
         Util162.m_1605(var3);
         if (var1 >= 1000) {
            break;
         }
      }

      this.f_8289.clear();
   }

   public DamageSpeed() {
      super(f_8292, f_8293, Category.MOVEMENT);
      this.f_8288 = new RenderUtil22(f_8294, -1);
      this.f_8289 = new ObjectArrayList();
      this.f_8291 = null;
   }
}
