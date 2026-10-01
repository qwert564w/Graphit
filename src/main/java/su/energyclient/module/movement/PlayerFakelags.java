package su.energyclient.module.movement;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util125;
import su.energyclient.util.Util170;
import su.energyclient.util.Util66;

public class PlayerFakelags extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_7020;
   private final NumberSetting f_7021;
   private final BooleanSetting f_7022;
   private final ObjectArrayList<Packet<?>> f_7023;
   private final Util125 f_7024;
   private boolean f_7025;
   private static final String f_7026 = "Player FakeLags";
   private static final String f_7027 = "Режим";
   private static final String f_7028 = "Blink";
   private static final String f_7029 = "Blink";
   private static final String f_7030 = "Pulse";
   private static final String f_7031 = "Задержка (MS)";
   private static final float f_7032 = 500.0F;
   private static final float f_7033 = 50.0F;
   private static final float f_7034 = 2000.0F;
   private static final float f_7035 = 50.0F;
   private static final String f_7036 = "Только движение";
   private static final String f_7037 = "Pulse";

   @EventHandler
   public void m_1037(Util170 var1) {
      if (f_5909.player != null) {
         if (this.f_7020.m_2073(f_7037) && this.f_7024.m_2636(this.f_7021.m_134().longValue())) {
            this.m_2390();
            this.f_7024.m_3493();
         }
      }
   }

   public PlayerFakelags() {
      super(f_7026, "", Category.MOVEMENT);
      this.f_7020 = new ModeSetting(f_7027, f_7028, f_7029, f_7030);
      this.f_7021 = new NumberSetting(f_7031, f_7032, f_7033, f_7034, f_7035);
      this.f_7022 = new BooleanSetting(f_7036, true);
      this.f_7023 = new ObjectArrayList();
      this.f_7024 = new Util125();
      this.f_7025 = false;
   }

   private void m_2390() {
      if (!this.f_7023.isEmpty()) {
         this.f_7025 = true;
         ObjectListIterator var1 = this.f_7023.iterator();

         while (var1.hasNext()) {
            Packet var2 = (Packet)var1.next();
            f_5909.player.networkHandler.sendPacket(var2);
         }

         this.f_7023.clear();
         this.f_7025 = false;
      }
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_7023.clear();
      this.f_7024.m_3493();
      this.f_7025 = false;
   }

   @Override
   public void m_1() {
      super.m_1();
      this.m_2390();
   }

   @EventHandler
   public void m_1788(Util66 var1) {
      if (f_5909.player != null && !this.f_7025) {
         if (var1.m_2586()) {
            if (this.f_7022.m_1163()) {
               if (var1.m_3295() instanceof PlayerMoveC2SPacket) {
                  var1.m_277(true);
                  this.f_7023.add(var1.m_3295());
               }
            } else {
               var1.m_277(true);
               this.f_7023.add(var1.m_3295());
            }
         }
      }
   }
}
