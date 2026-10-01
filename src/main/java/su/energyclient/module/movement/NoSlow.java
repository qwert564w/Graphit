package su.energyclient.module.movement;

import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.UseAction;
import net.minecraft.network.packet.s2c.play.UpdateSelectedSlotS2CPacket;
import net.minecraft.util.Hand;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util125;
import su.energyclient.util.Util170;
import su.energyclient.util.Util51;
import su.energyclient.util.Util66;

public class NoSlow extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_5205;
   private final ModeSetting f_5206;
   private int f_5207;
   private int f_5208;
   private int f_5209;
   private final Util125 f_5210;
   private static final String f_5211 = "No Slow";
   private static final String f_5212 = "description";
   private static final String f_5213 = "Мод";
   private static final String f_5214 = "Vanilla";
   private static final String f_5215 = "Vanilla";
   private static final String f_5216 = "ReallyWorld";
   private static final String f_5217 = "Grim New";
   private static final String f_5218 = "Мод тикрейта";
   private static final String f_5219 = "Легитный";
   private static final String f_5220 = "Обычный";
   private static final String f_5221 = "Легитный";
   private static final String f_5222 = "ReallyWorld";
   private static final String f_5223 = "Легитный";
   private static final String f_5224 = "Grim New";
   private static final String f_5225 = "Vanilla";
   private static final String f_5226 = "Grim New";
   private static final String f_5227 = "ReallyWorld";
   private static final String f_5228 = "Обычный";
   private static final long f_5229 = 1100L;
   private static final String f_5230 = "ReallyWorld";
   private static final String f_5231 = "Обычный";
   private static final String f_5232 = "ReallyWorld";

   public NoSlow() {
      super(f_5211, f_5212, Category.MOVEMENT);
      this.f_5205 = new ModeSetting(f_5213, f_5214, f_5215, f_5216, f_5217);
      this.f_5206 = new ModeSetting(f_5218, f_5219, f_5220, f_5221).m_1263(() -> this.f_5205.m_2073(f_5232));
      this.f_5210 = new Util125();
   }

   @Override
   public void m_1() {
      this.m_3350();
      super.m_1();
   }

   private void m_3350() {
      this.f_5209 = 0;
   }

   private boolean m_2349() {
      if (f_5909.player == null || f_5909.interactionManager == null || f_5909.world == null) {
         return false;
      } else if (f_5909.player.isUsingItem() && !f_5909.player.hasVehicle() && !f_5909.player.isGliding()) {
         ItemStack var1 = f_5909.player.getActiveItem();
         return !var1.isEmpty() && var1.getUseAction() != UseAction.NONE;
      } else {
         return false;
      }
   }

   private void m_2148(Util51 var1) {
      if (this.f_5209 > 1 && (this.f_5209 & 1) == 0) {
         var1.m_277(true);
      }
   }

   @EventHandler
   public void m_1522(Util51 var1) {
      if (f_5909.player != null) {
         if (f_5909.player.isUsingItem()) {
            if (this.f_5205.m_2073(f_5225)) {
               var1.m_277(true);
            }

            if (this.f_5205.m_2073(f_5226) && this.m_2349()) {
               this.m_2148(var1);
            }

            if (this.f_5205.m_2073(f_5227)) {
               if (this.f_5206.m_2073(f_5228)) {
                  if (this.f_5208 >= 2) {
                     boolean var2 = f_5909.player.getActiveHand() == Hand.OFF_HAND;
                     if (f_5909.player.getActiveHand() == Hand.MAIN_HAND) {
                        boolean var3 = f_5909.player.isTouchingWater();
                        if (f_5909.player.hurtTime != 0) {
                           this.f_5210.m_3493();
                        }

                        if (!this.f_5210.m_2636(f_5229)) {
                           var3 = true;
                        }

                        if (var3 || this.f_5208 >= 3) {
                           var2 = true;
                        }
                     }

                     if (var2) {
                        var1.m_277(true);
                        this.f_5208 = 0;
                     }
                  }
               } else if (!f_5909.player.isTouchingWater() && this.f_5207 > 2) {
                  var1.m_277(true);
                  this.f_5207 = 0;
               }
            }
         }
      }
   }

   @EventHandler
   public void m_2507(Util66 var1) {
      if (f_5909.player != null) {
         if (this.f_5205.m_2073(f_5230)
            && this.f_5206.m_2073(f_5231)
            && f_5909.player.isUsingItem()
            && var1.m_2068()
            && var1.m_3295() instanceof UpdateSelectedSlotS2CPacket var2) {
            int var5 = var2.slot();
            if (var5 != f_5909.player.getInventory().getSelectedSlot()) {
               f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotS2CPacket(f_5909.player.getInventory().getSelectedSlot() % 8 + 1));
               f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotS2CPacket(f_5909.player.getInventory().getSelectedSlot()));
               var1.m_277(true);
            }
         }
      }
   }

   @EventHandler
   public void m_1724(Util170 var1) {
      if (this.f_5205.m_2073(f_5222) && this.f_5206.m_2073(f_5223) && f_5909.player != null && f_5909.player.isUsingItem()) {
         this.f_5207++;
      } else {
         this.f_5207 = 0;
      }

      if (this.f_5205.m_2073(f_5224) && this.m_2349()) {
         this.f_5209++;
      } else {
         this.m_3350();
      }
   }
}
