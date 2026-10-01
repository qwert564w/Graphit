package su.energyclient.module.combat;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;

public class AutoMace extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_2679 = -1;
   private boolean f_2680;
   private static final String f_2681 = "Auto Mace";
   private static final String f_2682 = "Берёт булаву с хотбара перед ударом с размаха, затем возвращает слот";
   private static final double f_2683 = 1.5;

   public AutoMace() {
      super(f_2681, f_2682, Category.COMBAT);
   }

   @Override
   public void m_1() {
      this.f_2680 = false;
      this.m_2192(this.f_2679);
      this.f_2679 = -1;
      super.m_1();
   }

   @EventHandler
   public void m_245(EventAttack var1) {
      if (!var1.m_2244() && !Macetarget.m_329()) {
         if (f_5909.player != null && f_5909.interactionManager != null && f_5909.currentScreen == null) {
            if (var1.m_1070() instanceof LivingEntity) {
               if (f_5909.player.getMainHandStack().getItem().equals(Items.MACE)) {
                  if (f_5909.player.fallDistance < f_2683) {
                     var1.m_277(true);
                  }
               } else if (MaceItem.shouldDealAdditionalDamage(f_5909.player)) {
                  int var2 = Util146.m_1914(Items.MACE);
                  if (var2 >= 0 && var2 < 9) {
                     int var3 = f_5909.player.getInventory().getSelectedSlot();
                     if (var2 != var3) {
                        this.f_2679 = var3;
                        f_5909.player.getInventory().setSelectedSlot(var2);
                        ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
                        this.f_2680 = true;
                     }
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void m_1843(Util170 var1) {
      if (Macetarget.m_329()) {
         this.f_2680 = false;
         this.f_2679 = -1;
      } else if (this.f_2680 && this.f_2679 >= 0) {
         this.f_2680 = false;
         this.m_2192(this.f_2679);
         this.f_2679 = -1;
      }
   }

   private void m_2192(int var1) {
      if (var1 >= 0 && f_5909.player != null && f_5909.interactionManager != null) {
         f_5909.player.getInventory().setSelectedSlot(var1);
         ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
      }
   }
}
