package su.energyclient.module.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.ItemPickupAnimationS2CPacket;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.impl.RotationManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util104;
import su.energyclient.util.Util66;

public class LootAlert extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Set<Item> f_881 = Set.of(
      Items.ELYTRA,
      Items.GOLDEN_APPLE,
      Items.ENCHANTED_GOLDEN_APPLE,
      Items.PLAYER_HEAD,
      Items.POTION,
      Items.SPLASH_POTION,
      Items.LINGERING_POTION,
      Items.TOTEM_OF_UNDYING
   );
   private final Map<Integer, ItemStack> f_882 = new HashMap<>();
   private static final String f_883 = "Loot Alert";
   private static final String f_884 = "Оповещает о подборе ценных предметов";
   private static final double f_885 = 4096.0;
   private static final String f_886 = "Подобрал: ";
   private static final String f_887 = "netherite";

   private void m_3688(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         if (this.m_248(var1)) {
            MutableText var2 = Text.literal(f_886).formatted(Formatting.GRAY).append(var1.getName().copy().formatted(Formatting.WHITE));
            RotationManager.m_3112(var1.copy(), var2);
         }
      }
   }

   @EventHandler
   public void m_1422(Util104 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         this.f_882.clear();

         for (Entity var3 : f_5909.world.getEntities()) {
            if (var3 instanceof ItemEntity var4 && !(var4.squaredDistanceTo(f_5909.player) > f_885)) {
               ItemStack var5 = var4.getStack();
               if (!var5.isEmpty()) {
                  this.f_882.put(var4.getId(), var5.copy());
               }
            }
         }
      }
   }

   public LootAlert() {
      super(f_883, f_884, Category.MISCELLANEOUS);
   }

   @Override
   public void m_1() {
      this.f_882.clear();
      super.m_1();
   }

   private boolean m_248(ItemStack var1) {
      if (f_881.contains(var1.getItem())) {
         return true;
      } else {
         String var2 = var1.getItem().getTranslationKey();
         return var2 != null && var2.contains(f_887);
      }
   }

   @EventHandler
   public void m_808(Util66 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (var1.m_2068()) {
            if (var1.m_3295() instanceof ItemPickupAnimationS2CPacket var2) {
               if (var2.getCollectorEntityId() == f_5909.player.getId()) {
                  int var7 = var2.getEntityId();
                  ItemStack var4 = ItemStack.EMPTY;
                  if (f_5909.world.getEntityById(var7) instanceof ItemEntity var6) {
                     var4 = var6.getStack().copy();
                  }

                  if (var4.isEmpty()) {
                     ItemStack var8 = this.f_882.get(var7);
                     if (var8 != null) {
                        var4 = var8.copy();
                     }
                  }

                  if (!var4.isEmpty()) {
                     int var9 = Math.max(1, var2.getStackAmount());
                     var4.setCount(Math.min(var9, var4.getMaxCount()));
                     this.m_3688(var4);
                     this.f_882.remove(var7);
                  }
               }
            }
         }
      }
   }
}
