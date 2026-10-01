package su.energyclient.event.impl;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import su.energyclient.event.Event;

public class EventUseFinish extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private ItemStack f_2842;
   private World f_2843;
   private LivingEntity f_2844;

   public void m_1239(ItemStack var1) {
      this.f_2842 = var1;
   }

   public void m_3102(LivingEntity var1) {
      this.f_2844 = var1;
   }

   public World m_936() {
      return this.f_2843;
   }

   public ItemStack m_3888() {
      return this.f_2842;
   }

   protected boolean m_579(Object var1) {
      return var1 instanceof EventUseFinish;
   }

   public LivingEntity m_842() {
      return this.f_2844;
   }

   public EventUseFinish(ItemStack var1, World var2, LivingEntity var3) {
      this.f_2842 = var1;
      this.f_2843 = var2;
      this.f_2844 = var3;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventUseFinish var2)) {
         return false;
      } else if (!var2.m_579(this)) {
         return false;
      } else {
         ItemStack var3 = this.m_3888();
         ItemStack var4 = var2.m_3888();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            World var5 = this.m_936();
            World var6 = var2.m_936();
            if (var5 == null ? var6 == null : var5.equals(var6)) {
               LivingEntity var7 = this.m_842();
               LivingEntity var8 = var2.m_842();
               return var7 == null ? var8 == null : var7.equals(var8);
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      ItemStack var3 = this.m_3888();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      World var4 = this.m_936();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      LivingEntity var5 = this.m_842();
      return var2 * 59 + (var5 == null ? 43 : var5.hashCode());
   }

   public void m_3428(World var1) {
      this.f_2843 = var1;
   }

   @Override
   public String toString() {
      return "EventUseFinish(itemStack=" + this.m_3888() + ", worldIn=" + this.m_936() + ", entityLiving=" + this.m_842() + ")";
   }
}
