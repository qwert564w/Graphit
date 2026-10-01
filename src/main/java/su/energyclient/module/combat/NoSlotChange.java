package su.energyclient.module.combat;

import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.ShulkerBoxScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.TypedEntityData;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.network.packet.s2c.play.UpdateSelectedSlotS2CPacket;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.math.MathHelper;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventHandleMouseClick;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;
import su.energyclient.util.Util63;
import su.energyclient.util.Util66;

public class NoSlotChange extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Util63 f_4906;
   private static final String f_4907 = "No Slot Change";
   private static final String f_4908 = "Исправляет ошибки, связанные со сменой предметов в инвентаре";
   private static final String f_4909 = "На что работать";
   private static final String f_4910 = "Не свапать слоты";
   private static final String f_4911 = "Не выкидывать элитру";
   private static final String f_4912 = "Не выкидывать нагрудник";
   private static final String f_4913 = "Не выкидывать шар";
   private static final String f_4914 = "Не выкидывать осколки";
   private static final String f_4915 = "Не выкидывать элитру";
   private static final String f_4916 = "Не выкидывать нагрудник";
   private static final String f_4917 = "Не выкидывать шар";
   private static final String f_4918 = "Не выкидывать осколки";
   private static final String f_4919 = "Не выкидывать элитру";
   private static final String f_4920 = "Не выкидывать нагрудник";
   private static final String f_4921 = "Не выкидывать шар";
   private static final String f_4922 = "Не выкидывать осколки";
   private static final String f_4923 = "Не свапать слоты";
   private static final String f_4924 = "PublicBukkitValues";
   private static final String f_4925 = "PublicBukkitValues";

   @EventHandler
   public void m_3521(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (!(f_5909.currentScreen instanceof GenericContainerScreen)
            && !(f_5909.currentScreen instanceof CreativeInventoryScreen)
            && !(f_5909.currentScreen instanceof ShulkerBoxScreen)) {
            ItemStack var2 = f_5909.player.currentScreenHandler.getCursorStack();
            int var3 = Util146.m_1128();
            boolean var4 = var3 != -1;
            if (this.f_4906.I(f_4919) && Util146.m_1914(Items.ELYTRA) == -1 && var4 && var2.getItem() == Items.ELYTRA) {
               f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var3, 1, SlotActionType.PICKUP, f_5909.player);
            }

            if (this.f_4906.I(f_4920) && Util146.m_1177() == -1 && var4 && var2.isIn(ItemTags.CHEST_ARMOR) && this.m_3461(var2)) {
               f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var3, 1, SlotActionType.PICKUP, f_5909.player);
            }

            if (this.f_4906.I(f_4921) && Util146.m_1914(Items.PLAYER_HEAD) == -1 && var4 && var2.getItem() == Items.PLAYER_HEAD) {
               f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var3, 1, SlotActionType.PICKUP, f_5909.player);
            }

            if (this.f_4906.I(f_4922) && this.m_388(var2)) {
               f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var3, 1, SlotActionType.PICKUP, f_5909.player);
            }
         }
      }
   }

   private boolean m_3461(ItemStack var1) {
      if (var1 == null || var1.isEmpty()) {
         return false;
      } else if (!var1.contains(DataComponentTypes.EQUIPPABLE)) {
         return false;
      } else {
         EquippableComponent var2 = (EquippableComponent)var1.get(DataComponentTypes.EQUIPPABLE);
         return var2 != null && var2.slot() == EquipmentSlot.CHEST;
      }
   }

   private boolean m_388(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         NbtComponent var3 = (NbtComponent)var1.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
         boolean var2;
         if (!var3.isEmpty() && var3.copyNbt().contains(f_4924)) {
            var2 = true;
         } else {
            TypedEntityData var4 = (TypedEntityData)var1.get(DataComponentTypes.BLOCK_ENTITY_DATA);
            var2 = var4 != null && var4.contains(f_4925);
         }

         boolean var5 = var1.contains(DataComponentTypes.CUSTOM_MODEL_DATA);
         return var2 && var5;
      } else {
         return false;
      }
   }

   @EventHandler
   public void m_3441(Util66 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (this.f_4906.I(f_4923) && var1.m_3295() instanceof UpdateSelectedSlotS2CPacket var2) {
            int var5 = var2.slot();
            if (var1.m_2068() && var5 != f_5909.player.getInventory().getSelectedSlot()) {
               int var7 = MathHelper.clamp(
                  f_5909.player.getInventory().getSelectedSlot() >= 8
                     ? f_5909.player.getInventory().getSelectedSlot() - 1
                     : f_5909.player.getInventory().getSelectedSlot() + 1,
                  0,
                  8
               );
               f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var7));
               f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(f_5909.player.getInventory().getSelectedSlot()));
               var1.m_277(true);
            }
         }
      }
   }

   @EventHandler
   public void m_3594(EventHandleMouseClick var1) {
      Slot var2 = var1.m_1480();
      SlotActionType var3 = var1.m_2348();
      if (var2 != null
         && var3 != SlotActionType.SWAP
         && var3 != SlotActionType.QUICK_MOVE
         && !(f_5909.currentScreen instanceof GenericContainerScreen)
         && !(f_5909.currentScreen instanceof CreativeInventoryScreen)
         && !(f_5909.currentScreen instanceof ShulkerBoxScreen)) {
         ItemStack var4 = var2.getStack();
         Item var5 = var4.getItem();
         if (this.f_4906.I(f_4915) && var5 == Items.ELYTRA) {
            var1.m_277(true);
         }

         if (this.f_4906.I(f_4916) && var4.isIn(ItemTags.CHEST_ARMOR) && this.m_3461(var4)) {
            var1.m_277(true);
         }

         if (this.f_4906.I(f_4917) && var5 == Items.PLAYER_HEAD) {
            var1.m_277(true);
         }

         if (this.f_4906.I(f_4918) && this.m_388(var4)) {
            var1.m_277(true);
         }
      }
   }

   public NoSlotChange() {
      super(f_4907, f_4908, Category.COMBAT);
      this.f_4906 = new Util63(
         f_4909,
         new BooleanSetting(f_4910, true),
         new BooleanSetting(f_4911, false),
         new BooleanSetting(f_4912, false),
         new BooleanSetting(f_4913, false),
         new BooleanSetting(f_4914, false)
      );
   }
}
