package su.energyclient.util;

import java.util.List;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public final class Util12 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Util12() {
   }

   public static List<ItemStack> m_1105(LivingEntity var0) {
      return List.of(
         var0.getEquippedStack(EquipmentSlot.FEET),
         var0.getEquippedStack(EquipmentSlot.LEGS),
         var0.getEquippedStack(EquipmentSlot.CHEST),
         var0.getEquippedStack(EquipmentSlot.HEAD)
      );
   }
}
