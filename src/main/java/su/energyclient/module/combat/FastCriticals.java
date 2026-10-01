package su.energyclient.module.combat;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.AttributeModifiersComponent.Entry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.registry.tag.ItemTags;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.manager.InitManager;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util162;

public class FastCriticals extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final ModeSetting f_5967;
   private int l;
   private static final String f_5968 = "Fast Criticals";
   private static final String f_5969 = "Быстро свапает на оружие из хотбара только на момент крита AttackAura";
   private static final String f_5970 = "Оружие";
   private static final String f_5971 = "Меч";
   private static final String f_5972 = "Меч";
   private static final String f_5973 = "Топор";
   private static final float f_5974 = 0.5F;
   private static final float f_5975 = 0.9F;
   private static final String f_5976 = "Меч";

   private double m_2937(ItemStack var1) {
      AttributeModifiersComponent var2 = (AttributeModifiersComponent)var1.getOrDefault(
         DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT
      );
      double var3 = 1.0;
      double var5 = 0.0;
      double var7 = 0.0;
      double var9 = 1.0;

      for (Entry var12 : var2.modifiers()) {
         if (var12.attribute().equals(EntityAttributes.ATTACK_DAMAGE) && var12.slot().matches(EquipmentSlot.MAINHAND)) {
            EntityAttributeModifier var13 = var12.modifier();
            switch (var13.operation()) {
               case ADD_VALUE:
                  var5 += var13.value();
                  break;
               case ADD_MULTIPLIED_BASE:
                  var7 += var13.value();
                  break;
               case ADD_MULTIPLIED_TOTAL:
                  var9 *= 1.0 + var13.value();
            }
         }
      }

      return (var3 + var5 + var3 * var7) * var9;
   }

   private boolean m_2921(ItemStack var1) {
      if (var1.isEmpty()) {
         return false;
      } else {
         return this.f_5967.m_2073(f_5976) ? var1.isIn(ItemTags.SWORDS) : var1.isIn(ItemTags.AXES);
      }
   }

   private boolean m_729(Entity var1) {
      if (var1 instanceof LivingEntity
         && f_5909.player != null
         && !(f_5909.player.getAttackCooldownProgress(f_5974) <= f_5975)
         && !(f_5909.player.fallDistance <= 0.0)
         && !f_5909.player.isClimbing()
         && !f_5909.player.isTouchingWater()
         && !f_5909.player.hasStatusEffect(StatusEffects.BLINDNESS)
         && !f_5909.player.hasVehicle()
         && !f_5909.player.isSprinting()) {
         Criticals var2 = InitManager.f_2740.f_2741.criticals;
         boolean var3 = var2 != null && var2.m_677() && f_5909.player.fallDistance > 0.0;
         return !f_5909.player.isOnGround() || var3;
      } else {
         return false;
      }
   }

   @Override
   public void m_1() {
      this.m_1537();
      super.m_1();
   }

   private int m_2415() {
      int var1 = -1;
      double var2 = Double.NEGATIVE_INFINITY;
      int var4 = -1;

      for (int var5 = 0; var5 < 9; var5++) {
         ItemStack var6 = f_5909.player.getInventory().getStack(var5);
         if (this.m_2921(var6)) {
            double var7 = this.m_2937(var6);
            int var9 = var6.getEnchantments().getSize();
            if (var7 > var2 || var7 == var2 && var9 > var4) {
               var1 = var5;
               var2 = var7;
               var4 = var9;
            }
         }
      }

      return var1;
   }

   @EventHandler(
      priority = -201
   )
   public void m_2048(EventAttack var1) {
      this.m_1537();
      if (!var1.m_2244()
         && f_5909.player != null
         && f_5909.world != null
         && f_5909.interactionManager != null
         && f_5909.player.networkHandler != null
         && !f_5909.player.isUsingItem()) {
         AttackAura var2 = InitManager.f_2740.f_2741.attackAura;
         if (var2 != null && var2.m_677() && var2.f_3636 && var2.m_891() != null && var1.m_1070() == var2.m_891() && this.m_729(var1.m_1070())) {
            ItemStack var3 = f_5909.player.getMainHandStack();
            if (!var3.isOf(Items.MACE) || !MaceItem.shouldDealAdditionalDamage(f_5909.player)) {
               int var4 = f_5909.player.getInventory().getSelectedSlot();
               int var5 = this.m_2415();
               if (var5 >= 0 && var5 != var4) {
                  ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
                  this.l = var4;
                  Util162.m_1605(new UpdateSelectedSlotC2SPacket(var5));
               }
            }
         }
      }
   }

   public boolean m_2778(Entity var1) {
      if (this.m_677()
         && f_5909.player != null
         && f_5909.world != null
         && f_5909.interactionManager != null
         && f_5909.player.networkHandler != null
         && !f_5909.player.isUsingItem()
         && this.m_729(var1)) {
         ItemStack var2 = f_5909.player.getMainHandStack();
         return (!var2.isOf(Items.MACE) || !MaceItem.shouldDealAdditionalDamage(f_5909.player)) && !this.m_2921(var2) ? this.m_2415() >= 0 : false;
      } else {
         return false;
      }
   }

   public void m_1537() {
      int var1 = this.l;
      this.l = -1;
      if (var1 >= 0 && var1 <= 8 && f_5909.player != null && f_5909.player.networkHandler != null) {
         Util162.m_1605(new UpdateSelectedSlotC2SPacket(var1));
      }
   }

   public FastCriticals() {
      super(f_5968, f_5969, Category.COMBAT);
      this.f_5967 = new ModeSetting(f_5970, f_5971, f_5972, f_5973);
      this.l = -1;
   }
}
