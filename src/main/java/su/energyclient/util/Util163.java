package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import su.energyclient.event.Event;

public class Util163 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final LivingEntity f_8186;
   private final ItemStack f_8187;
   private final double f_8188;
   private final Iterable<StatusEffectInstance> f_8189;

   public Util163(LivingEntity var1, ItemStack var2, double var3, Iterable<StatusEffectInstance> var5) {
      this.f_8186 = var1;
      this.f_8187 = var2;
      this.f_8188 = var3;
      this.f_8189 = var5;
   }

   public Iterable<StatusEffectInstance> m_2300() {
      return this.f_8189;
   }

   public LivingEntity m_530() {
      return this.f_8186;
   }

   public double m_1174() {
      return this.f_8188;
   }

   public ItemStack m_1417() {
      return this.f_8187;
   }
}
