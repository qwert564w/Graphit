package su.energyclient.module.movement;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.Full;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util145;
import su.energyclient.util.Util146;
import su.energyclient.util.Util162;
import su.energyclient.util.Util37;
import su.energyclient.util.Util66;

public class AirStuck extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_5027;
   private final BooleanSetting f_5028;
   private boolean f_5029;
   private boolean f_5030;
   private long f_5031;
   private static final String f_5032 = "Air Stuck";
   private static final String f_5033 = "description";
   private static final String f_5034 = "Режим";
   private static final String f_5035 = "RW 1.21";
   private static final String f_5036 = "RW 1.16";
   private static final String f_5037 = "RW 1.21";
   private static final String f_5038 = "Свапнуть нагрудник";
   private static final String f_5039 = "RW 1.16";

   @EventHandler
   public void m_1048(Util37 var1) {
      var1.m_277(true);
   }

   @Override
   public void m_1() {
      this.f_5030 = false;
      super.m_1();
   }

   @EventHandler
   public void m_3008(Util145 var1) {
      if (f_5909.player != null) {
         this.m_2042();
         var1.m_2482(Vec3d.ZERO);
      }
   }

   @EventHandler
   public void m_3593(Util66 var1) {
      if (var1.m_2586()) {
         if (this.f_5027.m_2073(f_5039)) {
            if (var1.m_3295() instanceof PlayerMoveC2SPacket) {
               Util162.m_1605(
                  new Full(f_5909.player.getX(), f_5909.player.getY(), f_5909.player.getZ(), f_5909.player.getYaw(), f_5909.player.getPitch(), false, false)
               );
               var1.m_277(true);
            }
         } else if (var1.m_3295() instanceof PlayerMoveC2SPacket) {
            var1.m_277(true);
         }
      }
   }

   public AirStuck() {
      super(f_5032, f_5033, Category.MOVEMENT);
      this.f_5027 = new ModeSetting(f_5034, f_5035, f_5036, f_5037);
      this.f_5028 = new BooleanSetting(f_5038, false);
      this.f_5031 = 0L;
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_5029 = false;
      this.f_5030 = false;
      this.f_5031 = 0L;
   }

   private void m_2042() {
      if (!this.f_5030 && this.f_5028.m_1163()) {
         if (f_5909.player != null && f_5909.interactionManager != null) {
            if (f_5909.player.currentScreenHandler.syncId == 0) {
               if (!f_5909.player.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.ELYTRA)) {
                  this.f_5030 = true;
               } else {
                  int var1 = Util146.m_3530();
                  if (var1 != -1) {
                     if (var1 < 9) {
                        Util146.m_3282(6, -1, var1, SlotActionType.SWAP);
                     } else {
                        Util146.m_3282(var1, 6, 8, SlotActionType.SWAP);
                     }

                     this.f_5030 = true;
                  }
               }
            }
         }
      }
   }
}
