package su.energyclient.util;

import com.google.common.collect.Lists;
import com.mojang.text2speech.Narrator;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.InputUtil.Key;
import net.minecraft.client.util.InputUtil.Type;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.consume.UseAction;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.sync.ItemStackHash;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult.Success;
import net.minecraft.util.ActionResult.SwingSource;
import net.minecraft.util.collection.DefaultedList;
import org.lwjgl.glfw.GLFW;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.EventHandler;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;
import su.energyclient.mixin.MinecraftClientMixin2;

public final class Util146 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Util146.NYOkRSu3beLt4KKK f_11851 = new Util146.NYOkRSu3beLt4KKK();
   private static boolean f_11852;
   private static final String f_11853 = "bravo";
   private static final float f_11854 = 0.2F;
   private static final float f_11855 = 0.3F;
   private static final float f_11856 = 0.09F;
   private static final float f_11857 = 0.0027F;
   private static final float f_11858 = 8.1E-4F;
   private static final float f_11859 = 5.0F;
   private static final String f_11860 = "Ignoring click in mismatching container. Click in {}, player has {}.";
   private static final String f_11861 = "Ignoring click in mismatching container. Click in {}, player has {}.";
   private static final double f_11862 = -1.0;
   private static final double f_11863 = 10.0;
   private static final double f_11864 = -1.0;
   private static final double f_11865 = 10000.0;
   private static final double f_11866 = 100.0;
   private static final double f_11867 = 10.0;
   private static final double f_11868 = 10.0;
   private static final String f_11869 = "This is a utility class and cannot be instantiated";

   public static int m_3938() {
      if (f_5909 != null && f_5909.player != null) {
         int var0 = -1;
         int var1 = 0;

         for (int var2 = 0; var2 < 45; var2++) {
            ItemStack var3 = f_5909.player.getInventory().getStack(var2);
            if (!var3.isEmpty() && var3.contains(DataComponentTypes.FOOD) && var3.getCount() > var1) {
               var0 = var2;
               var1 = var3.getCount();
            }
         }

         return var0;
      } else {
         return -1;
      }
   }

   public static int m_3530() {
      if (f_5909.player == null) {
         return -1;
      } else {
         int var0 = -1;
         double var1 = f_11864;

         for (int var3 = 0; var3 < 36; var3++) {
            ItemStack var4 = f_5909.player.getInventory().getStack(var3);
            if (var4.isIn(ItemTags.CHEST_ARMOR)) {
               EquippableComponent var5 = (EquippableComponent)var4.get(DataComponentTypes.EQUIPPABLE);
               if (var5 != null && var5.slot() == EquipmentSlot.CHEST) {
                  int var6 = m_3176(var4, Enchantments.PROTECTION);
                  int var7 = m_3176(var4, Enchantments.UNBREAKING);
                  int var8 = m_3176(var4, Enchantments.MENDING);
                  int var9 = m_1842(var4.getItem());
                  int var10 = var4.getMaxDamage();
                  int var11 = var4.getDamage();
                  double var12 = var10 == 0 ? 1.0 : (double)(var10 - var11) / var10;
                  double var14 = var9 * f_11865 + var6 * f_11866 + var7 * f_11867 + (var8 > 0 ? 1 : 0) + var12 * f_11868;
                  if (var14 > var1) {
                     var1 = var14;
                     var0 = var3;
                  }
               }
            }
         }

         return var0;
      }
   }

   @EventHandler(
      priority = -200
   )
   private static void m_1574(Util170 var0) {
      f_11851.m_3053();
   }

   private Util146() {
      throw new UnsupportedOperationException(f_11869);
   }

   public static void m_2425(Item var0) {
      int var1 = m_3290(var0, 9, 45);
      int var2 = m_3290(var0, 0, 8);
      int var3 = f_5909.player.getInventory().getSelectedSlot();
      boolean var4 = f_5909.player.isUsingItem();
      if (!f_5909.player.getItemCooldownManager().isCoolingDown(new ItemStack(var0))) {
         if (f_5909.player.getMainHandStack().getItem() == var0) {
            if (!var4) {
               f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
            }
         } else if (f_5909.player.getOffHandStack().getItem() == var0) {
            f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND);
         } else if (var4) {
            if (var2 != -1) {
               f_5909.interactionManager.clickSlot(0, 36 + var2, 40, SlotActionType.SWAP, f_5909.player);
               f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
               f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND);
               f_5909.interactionManager.clickSlot(0, 36 + var2, 40, SlotActionType.SWAP, f_5909.player);
               f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
            } else if (var1 != -1) {
               f_5909.interactionManager.clickSlot(0, var1, 40, SlotActionType.SWAP, f_5909.player);
               f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
               f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND);
               f_5909.interactionManager.clickSlot(0, var1, 40, SlotActionType.SWAP, f_5909.player);
               f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
            }
         } else if (var2 != -1) {
            f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var2));
            f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
            f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var3));
         } else {
            if (var1 != -1) {
               int var5 = -1;

               for (int var6 = 0; var6 < 8; var6++) {
                  ItemStack var7 = f_5909.player.getInventory().getStack(var6);
                  if (var7.isEmpty()) {
                     var5 = var6;
                     break;
                  }

                  UseAction var8 = var7.getUseAction();
                  if (var8 == UseAction.NONE) {
                     var5 = var6;
                  }
               }

               if (var5 == -1) {
                  f_5909.interactionManager.clickSlot(0, var1, 8, SlotActionType.SWAP, f_5909.player);
                  f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
                  f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(8));
                  f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
                  f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var3));
               } else {
                  f_5909.interactionManager.clickSlot(0, var1, var5, SlotActionType.SWAP, f_5909.player);
                  f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
                  f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var5));
                  f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
                  f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var3));
                  f_5909.interactionManager.clickSlot(0, var1, var5, SlotActionType.SWAP, f_5909.player);
                  f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
               }
            }
         }
      }
   }

   public static void m_904() {
      if (f_5909.interactionManager != null && f_5909.player != null && f_5909.world != null) {
         if (f_5909.player.getOffHandStack().getItem() == Items.FIREWORK_ROCKET) {
            f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND);
         } else {
            int var0 = m_1302(Items.FIREWORK_ROCKET);
            if (var0 != -1) {
               if (var0 >= 0 && var0 < 9) {
                  f_5909.interactionManager.clickSlot(0, 45, var0, SlotActionType.SWAP, f_5909.player);
                  f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND);
                  m_2112(0, 45, var0, SlotActionType.SWAP, f_5909.player.getInventory().getStack(45));
               } else {
                  f_5909.interactionManager.clickSlot(0, var0, 40, SlotActionType.SWAP, f_5909.player);
                  f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND);
                  m_2112(0, var0, 40, SlotActionType.SWAP, f_5909.player.getInventory().getStack(40));
               }
            }
         }
      }
   }

   public static void m_1954(int var0, int var1, int var2, SlotActionType var3, ItemStack var4, PlayerEntity var5) {
      ScreenHandler var6 = var5.currentScreenHandler;
      if (var0 != var6.syncId) {
         Narrator.LOGGER.warn(f_11860, var0, var6.syncId);
      } else {
         DefaultedList<Slot> var7 = var6.slots;
         int var8 = var7.size();
         ArrayList var9 = Lists.newArrayListWithCapacity(var8);

         for (Slot var11 : var7) {
            var9.add(var11.getStack().copy());
         }

         var6.onSlotClick(var1, var2, var3, var5);
         Int2ObjectOpenHashMap var14 = new Int2ObjectOpenHashMap();

         for (int var15 = 0; var15 < var8; var15++) {
            ItemStack var12 = (ItemStack)var9.get(var15);
            ItemStack var13 = ((Slot)var7.get(var15)).getStack();
            if (!ItemStack.areEqual(var12, var13)) {
               var14.put(var15, var13.copy());
            }
         }

         f_5909.player.networkHandler.sendPacket(new ClickSlotC2SPacket(var0, var6.getRevision(), (short)var1, (byte)var2, var3, m_686(var14), m_775(var4)));
      }
   }

   private static void m_1365(int var0, int var1) {
      if (f_5909.player != null) {
         if (f_5909.player.isUsingItem()) {
            m_1841(var0, 45);
            f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND);
            m_1841(var0, 45);
         } else {
            f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var0));
            f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
            f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var1));
         }
      }
   }

   private static void m_2112(int var0, int var1, int var2, SlotActionType var3, ItemStack var4) {
      if (f_5909.player != null) {
         ScreenHandler var5 = f_5909.player.currentScreenHandler;
         DefaultedList<Slot> var6 = var5.slots;
         int var7 = var6.size();
         ArrayList var8 = Lists.newArrayListWithCapacity(var7);

         for (Slot var10 : var6) {
            var8.add(var10.getStack().copy());
         }

         var5.onSlotClick(var1, var2, var3, f_5909.player);
         Int2ObjectOpenHashMap var13 = new Int2ObjectOpenHashMap();

         for (int var14 = 0; var14 < var7; var14++) {
            ItemStack var11 = (ItemStack)var8.get(var14);
            ItemStack var12 = ((Slot)var6.get(var14)).getStack();
            if (!ItemStack.areEqual(var11, var12)) {
               var13.put(var14, var12.copy());
            }
         }

         f_5909.player.networkHandler.sendPacket(new ClickSlotC2SPacket(var0, var5.getRevision(), (short)var1, (byte)var2, var3, m_686(var13), m_775(var4)));
      }
   }

   public static int m_1914(Item var0) {
      if (f_5909 != null && f_5909.player != null) {
         for (int var1 = 0; var1 < 36; var1++) {
            ItemStack var2 = f_5909.player.getInventory().getStack(var1);
            if (!var2.isEmpty() && var2.getItem() == var0) {
               return var1;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   @EventHandler(
      priority = -200
   )
   private static void m_2963(Util68 var0) {
      f_11851.m_2965();
   }

   public static int m_3290(Item var0, int var1, int var2) {
      if (f_5909.player != null) {
         for (int var3 = var2; var3 >= var1; var3--) {
            if (f_5909.player.currentScreenHandler.syncId != 0 && f_5909.player.currentScreenHandler.getSlot(var3).getStack().getItem() == var0) {
               return var3;
            }

            if (f_5909.player.currentScreenHandler.syncId == 0 && f_5909.player.getInventory().getStack(var3).getItem() == var0) {
               return var3;
            }
         }
      }

      return -1;
   }

   public static void m_2161(int var0, int var1, int var2, SlotActionType var3, PlayerEntity var4) {
      ScreenHandler var5 = var4.currentScreenHandler;
      if (var0 != var5.syncId) {
         Narrator.LOGGER.warn(f_11861, var0, var5.syncId);
      } else {
         DefaultedList<Slot> var6 = var5.slots;
         int var7 = var6.size();
         ArrayList var8 = Lists.newArrayListWithCapacity(var7);

         for (Slot var10 : var6) {
            var8.add(var10.getStack().copy());
         }

         Int2ObjectOpenHashMap var13 = new Int2ObjectOpenHashMap();

         for (int var14 = 0; var14 < var7; var14++) {
            ItemStack var11 = (ItemStack)var8.get(var14);
            ItemStack var12 = ((Slot)var6.get(var14)).getStack();
            if (!ItemStack.areEqual(var11, var12)) {
               var13.put(var14, var12.copy());
            }
         }

         f_5909.player
            .networkHandler
            .sendPacket(new ClickSlotC2SPacket(var0, var5.getRevision(), (short)var1, (byte)var2, var3, m_686(var13), m_775(var5.getCursorStack())));
      }
   }

   public static int m_1842(Item var0) {
      if (var0 == Items.NETHERITE_CHESTPLATE) {
         return 5;
      } else if (var0 == Items.DIAMOND_CHESTPLATE) {
         return 4;
      } else if (var0 == Items.IRON_CHESTPLATE) {
         return 3;
      } else if (var0 == Items.GOLDEN_CHESTPLATE) {
         return 2;
      } else if (var0 == Items.CHAINMAIL_CHESTPLATE) {
         return 2;
      } else {
         return var0 == Items.LEATHER_CHESTPLATE ? 1 : 0;
      }
   }

   public static int m_1177() {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var0 = 0; var0 < f_5909.player.getInventory().getMainStacks().size(); var0++) {
            ItemStack var1 = (ItemStack)f_5909.player.getInventory().getMainStacks().get(var0);
            if (!var1.isEmpty() && var1.isIn(ItemTags.CHEST_ARMOR) && var1.contains(DataComponentTypes.EQUIPPABLE)) {
               EquippableComponent var2 = (EquippableComponent)var1.get(DataComponentTypes.EQUIPPABLE);
               if (var2 != null && var2.slot() == EquipmentSlot.CHEST) {
                  return var0;
               }
            }
         }

         return -1;
      }
   }

   public static int m_3176(ItemStack var0, RegistryKey<Enchantment> var1) {
      ItemEnchantmentsComponent var2 = (ItemEnchantmentsComponent)var0.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);

      for (RegistryEntry var4 : var2.getEnchantments()) {
         if (var4.matchesKey(var1)) {
            return var2.getLevel(var4);
         }
      }

      return 0;
   }

   private static void m_1856() {
      if (f_5909.player != null) {
         if (f_5909.player.isUsingItem()) {
            f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND);
         } else {
            f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
         }
      }
   }

   public static int m_2581() {
      for (int var0 = 0; var0 < 45; var0++) {
         ItemStack var1 = f_5909.player.getInventory().getStack(var0);
         if (!var1.isEmpty() && var1.getItem() instanceof AxeItem) {
            return var0;
         }
      }

      return -1;
   }

   public static int m_149(String var0) {
      if (f_5909 != null && f_5909.player != null) {
         for (int var1 = 0; var1 < 36; var1++) {
            ItemStack var2 = f_5909.player.getInventory().getStack(var1);
            if (!var2.isEmpty() && var2.getName().getString().contains(var0)) {
               return var1 < 9 ? var1 + 36 : var1;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   @EventHandler(
      priority = -200
   )
   private static void m_1245(Util124 var0) {
      f_11851.m_3175();
   }

   public static void m_1841(int var0, int var1) {
      if (var0 != var1) {
         var0 = var0 < 9 ? var0 + 36 : var0;
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var0, 0, SlotActionType.SWAP, f_5909.player);
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, 0, SlotActionType.SWAP, f_5909.player);
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var0, 0, SlotActionType.SWAP, f_5909.player);
      }
   }

   private static Int2ObjectMap<ItemStackHash> m_686(Int2ObjectMap<ItemStack> var0) {
      Int2ObjectOpenHashMap var1 = new Int2ObjectOpenHashMap();
      var0.forEach((var1x, var2) -> var1.put(var1x, m_775(var2)));
      return var1;
   }

   public static void m_1314(Item var0) {
      if (f_5909.player != null && f_5909.interactionManager != null) {
         int var1 = m_1302(var0);
         if (var1 != -1) {
            int var2 = f_5909.player.getInventory().getSelectedSlot();
            boolean var3 = var1 < 9;
            if (var3 && var1 == var2) {
               m_1856();
            } else if (var3) {
               m_1365(var1, var2);
            } else {
               int var4 = var2 % 8 + 1;
               f_5909.interactionManager.clickSlot(0, var1, var4, SlotActionType.SWAP, f_5909.player);
               m_1365(var4, var2);
               f_5909.interactionManager.clickSlot(0, var1, var4, SlotActionType.SWAP, f_5909.player);
            }
         }
      }
   }

   public static float m_141(BlockState var0, ItemStack var1) {
      float var2 = var1.getMiningSpeedMultiplier(var0);
      if (var2 > 1.0F) {
         var2 += (float)f_5909.player.getAttributeValue(EntityAttributes.MINING_EFFICIENCY);
      }

      if (StatusEffectUtil.hasHaste(f_5909.player)) {
         var2 *= 1.0F + (StatusEffectUtil.getHasteAmplifier(f_5909.player) + 1) * f_11854;
      }

      if (f_5909.player.hasStatusEffect(StatusEffects.MINING_FATIGUE)) {
         var2 *= switch (f_5909.player.getStatusEffect(StatusEffects.MINING_FATIGUE).getAmplifier()) {
            case 0 -> f_11855;
            case 1 -> f_11856;
            case 2 -> f_11857;
            default -> f_11858;
         };
      }

      var2 *= (float)f_5909.player.getAttributeValue(EntityAttributes.BLOCK_BREAK_SPEED);
      if (f_5909.player.isSubmergedIn(FluidTags.WATER)) {
         var2 *= (float)f_5909.player.getAttributeInstance(EntityAttributes.SUBMERGED_MINING_SPEED).getValue();
      }

      if (!f_5909.player.isOnGround()) {
         var2 /= f_11859;
      }

      return var2;
   }

   public static boolean m_3282(int var0, int var1, int var2, SlotActionType var3) {
      f_5909.interactionManager.clickSlot(0, var0, var2, var3, f_5909.player);
      if (var1 != -1) {
         f_5909.interactionManager.clickSlot(0, var1, var2, var3, f_5909.player);
         f_5909.interactionManager.clickSlot(0, var0, var2, var3, f_5909.player);
      }

      if (!Util101.m_3117(f_11853)) {
         f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
      }

      return true;
   }

   public static int m_1128() {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var0 = 0; var0 < 36; var0++) {
            ItemStack var1 = f_5909.player.getInventory().getStack(var0);
            if (var1.isEmpty()) {
               return var0 < 9 ? var0 + 36 : var0;
            }
         }

         return -1;
      }
   }

   public static int m_1630(BlockState var0) {
      if (f_5909.player == null) {
         return -1;
      } else {
         int var1 = -1;
         float var2 = 1.0F;

         for (int var3 = 0; var3 < 9; var3++) {
            ItemStack var4 = f_5909.player.getInventory().getStack(var3);
            if (!var4.isEmpty() && (var4.isIn(ItemTags.AXES) || var4.isIn(ItemTags.PICKAXES) || var4.isIn(ItemTags.SHOVELS) || var4.isIn(ItemTags.HOES))) {
               float var5 = m_141(var0, var4);
               if (var5 > var2) {
                  var2 = var5;
                  var1 = var3;
               }
            }
         }

         return var1;
      }
   }

   public static void m_1911(Item var0) {
      if (var0 != null && f_5909 != null) {
         if (!f_5909.isOnThread()) {
            f_5909.execute(() -> m_1911(var0));
         } else if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
            if (m_2008()) {
               f_11851.m_169(var0);
            }
         }
      }
   }

   public static int m_2906() {
      if (f_5909.player == null) {
         return -1;
      } else {
         int var0 = -1;
         double var1 = f_11862;

         for (int var3 = 0; var3 < 36; var3++) {
            ItemStack var4 = f_5909.player.getInventory().getStack(var3);
            if (var4.getItem() == Items.ELYTRA) {
               int var5 = m_3176(var4, Enchantments.PROTECTION);
               int var6 = m_3176(var4, Enchantments.UNBREAKING);
               int var7 = m_3176(var4, Enchantments.MENDING);
               int var8 = var4.getMaxDamage();
               int var9 = var4.getDamage();
               double var10 = (double)(var8 - var9) / var8;
               double var12 = var5 * 100 + var6 * 10 + (var7 > 0 ? 1 : 0) + var10 * f_11863;
               if (var12 > var1) {
                  var1 = var12;
                  var0 = var3;
               }
            }
         }

         return var0;
      }
   }

   private static ItemStackHash m_775(ItemStack var0) {
      return ItemStackHash.fromItemStack(var0, f_5909.player.networkHandler.getComponentHasher());
   }

   public static int m_1302(Item var0) {
      for (ItemStack var2 : Util12.m_1105(f_5909.player)) {
         if (var2.getItem() == var0) {
            return -2;
         }
      }

      int var4 = -1;

      for (int var5 = 0; var5 < 36; var5++) {
         ItemStack var3 = f_5909.player.getInventory().getStack(var5);
         if (var3.getItem() == var0) {
            var4 = var5;
            break;
         }
      }

      if (var4 < 9 && var4 != -1) {
         var4 += 36;
      }

      return var4;
   }

   private static synchronized boolean m_2008() {
      if (f_11852) {
         return true;
      } else if (EnergyClient.f_1622 != null && EnergyClient.f_1622.f_1624 != null) {
         EnergyClient.f_1622.f_1624.m_26(Util146.class);
         f_11852 = true;
         return true;
      } else {
         return false;
      }
   }

   public static int m_566() {
      if (f_5909 != null && f_5909.player != null) {
         for (int var0 = 0; var0 < 45; var0++) {
            ItemStack var1 = f_5909.player.getInventory().getStack(var0);
            if (!var1.isEmpty() && var1.getItem() == Items.TOTEM_OF_UNDYING && !EnchantmentHelper.getEnchantments(var1).isEmpty()) {
               return var0;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private static enum EJtYLjUuQB7UGmfv {
      IDLE,
      WAITING_TO_SELECT,
      WAITING_TO_USE,
      HOLDING_USE,
      WAITING_TO_RESTORE;
   }

   private static final class NYOkRSu3beLt4KKK {
      private static final int f_12535 = 4;
      private static final int f_12536 = 0;
      private static final int f_12537 = 0;
      private final ArrayDeque<Item> f_12538 = new ArrayDeque<>();
      private Util146.EJtYLjUuQB7UGmfv f_12539 = Util146.EJtYLjUuQB7UGmfv.IDLE;
      private Item l;
      private PlayerEntity f_12540;
      private Hand f_12541 = Hand.MAIN_HAND;
      private int f_12542;
      private int f_12543;
      private int f_12544;
      private int f_12545;
      private int f_12546 = -1;
      private int f_12547 = -1;
      private int f_12548 = -1;
      private int f_12549 = -1;
      private boolean f_12550;
      private boolean f_12551;
      private boolean f_12552;
      private ItemStack f_12553 = ItemStack.EMPTY;
      private static final long f_12554 = 5L;
      private static final long f_12555 = 1200L;
      private static final String f_12556 = "Skipping legit-use inventory restore because its source slot changed";

      private boolean m_1644(Item var1) {
         return !this.m_322(var1).isEmpty();
      }

      private void m_363() {
         if (this.f_12541 == Hand.MAIN_HAND) {
            ((MinecraftClientMixin2)QuickImports.f_5909).invokeDoItemUse();
         } else {
            if (QuickImports.f_5909.interactionManager.interactItem(QuickImports.f_5909.player, Hand.OFF_HAND) instanceof Success var2
               && var2.swingSource() == SwingSource.CLIENT) {
               QuickImports.f_5909.player.swingHand(Hand.OFF_HAND);
            }
         }
      }

      private int m_2745(ItemStack var1) {
         UseAction var2 = var1.getUseAction();
         if (var2 == UseAction.BOW || var2 == UseAction.SPEAR || var2 == UseAction.CROSSBOW) {
            return this.m_1082(26, 31);
         } else if (var2 != UseAction.BLOCK && var2 != UseAction.SPYGLASS) {
            long var3 = var1.getMaxUseTime(QuickImports.f_5909.player) + f_12554;
            return (int)Math.min(f_12555, Math.max(1L, var3));
         } else {
            return this.m_1082(8, 14);
         }
      }

      private void m_2245() {
         this.m_721();
         if (!this.f_12552 && !this.m_2277() && !QuickImports.f_5909.options.useKey.isPressed()) {
            if (!this.m_3229()) {
               int var1 = -1;
               if (this.f_12551) {
                  if (!QuickImports.f_5909.player.currentScreenHandler.getCursorStack().isEmpty()) {
                     return;
                  }

                  var1 = this.m_3311(this.f_12548);
                  if (var1 == -1) {
                     return;
                  }
               }

               if (this.f_12550 && this.f_12547 != -1 && QuickImports.f_5909.player.getInventory().getSelectedSlot() == this.f_12547) {
                  QuickImports.f_5909.player.getInventory().setSelectedSlot(this.f_12546);
                  ((ClientPlayerInteractionManagerMixin2)QuickImports.f_5909.interactionManager).invokeSyncSelectedSlot();
               }

               if (this.f_12551) {
                  ItemStack var2 = QuickImports.f_5909.player.getInventory().getStack(this.f_12548);
                  if (ItemStack.areEqual(var2, this.f_12553)) {
                     QuickImports.f_5909
                        .interactionManager
                        .clickSlot(QuickImports.f_5909.player.currentScreenHandler.syncId, var1, this.f_12549, SlotActionType.SWAP, QuickImports.f_5909.player);
                  } else {
                     Narrator.LOGGER.warn(f_12556);
                  }
               }

               this.m_4103();
            }
         }
      }

      private int m_3311(int var1) {
         for (Slot var3 : QuickImports.f_5909.player.currentScreenHandler.slots) {
            if (var3.inventory == QuickImports.f_5909.player.getInventory() && var3.getIndex() == var1) {
               return var3.id;
            }
         }

         return -1;
      }

      private void m_3175() {
         if (this.f_12539 != Util146.EJtYLjUuQB7UGmfv.IDLE || !this.f_12538.isEmpty()) {
            if (!this.m_1986()) {
               this.m_482();
            }
         }
      }

      private void m_4103() {
         this.m_721();
         this.l = null;
         this.f_12540 = null;
         this.f_12541 = Hand.MAIN_HAND;
         this.f_12539 = Util146.EJtYLjUuQB7UGmfv.IDLE;
         this.f_12542 = 0;
         this.f_12543 = 0;
         this.f_12544 = 0;
         this.f_12545 = 0;
         this.f_12546 = -1;
         this.f_12547 = -1;
         this.f_12548 = -1;
         this.f_12549 = -1;
         this.f_12550 = false;
         this.f_12551 = false;
         this.f_12552 = false;
         this.f_12553 = ItemStack.EMPTY;
         this.m_1555();
      }

      private ItemStack m_322(Item var1) {
         if (QuickImports.f_5909.player != null && var1 != null) {
            if (QuickImports.f_5909.player.getMainHandStack().isOf(var1)) {
               return QuickImports.f_5909.player.getMainHandStack();
            } else if (QuickImports.f_5909.player.getOffHandStack().isOf(var1)) {
               return QuickImports.f_5909.player.getOffHandStack();
            } else {
               int var2 = this.m_4147(var1, 0, 36);
               return var2 == -1 ? ItemStack.EMPTY : QuickImports.f_5909.player.getInventory().getStack(var2);
            }
         } else {
            return ItemStack.EMPTY;
         }
      }

      private void m_169(Item var1) {
         if (this.m_1644(var1) && !this.m_1524(this.m_322(var1))) {
            if (this.l != var1 && !this.f_12538.contains(var1)) {
               if (this.f_12539 == Util146.EJtYLjUuQB7UGmfv.IDLE && this.l == null) {
                  this.m_2758(var1);
               } else {
                  if (this.f_12538.size() < 4) {
                     this.f_12538.addLast(var1);
                  }
               }
            }
         }
      }

      private void m_3948() {
         if (QuickImports.f_5909.player != null && QuickImports.f_5909.interactionManager != null && QuickImports.f_5909.getNetworkHandler() != null) {
            if (this.f_12540 == QuickImports.f_5909.player
               && this.f_12550
               && this.f_12547 != -1
               && this.f_12546 >= 0
               && this.f_12546 < 9
               && QuickImports.f_5909.player.getInventory().getSelectedSlot() == this.f_12547) {
               QuickImports.f_5909.player.getInventory().setSelectedSlot(this.f_12546);
               ((ClientPlayerInteractionManagerMixin2)QuickImports.f_5909.interactionManager).invokeSyncSelectedSlot();
            }

            if (this.f_12551 && QuickImports.f_5909.player.currentScreenHandler.getCursorStack().isEmpty()) {
               int var1 = this.m_3311(this.f_12548);
               if (var1 != -1) {
                  ItemStack var2 = QuickImports.f_5909.player.getInventory().getStack(this.f_12548);
                  if (ItemStack.areEqual(var2, this.f_12553)) {
                     QuickImports.f_5909
                        .interactionManager
                        .clickSlot(QuickImports.f_5909.player.currentScreenHandler.syncId, var1, this.f_12549, SlotActionType.SWAP, QuickImports.f_5909.player);
                     this.f_12551 = false;
                  }
               }
            }
         }
      }

      private void m_482() {
         this.m_3948();
         this.m_721();
         this.f_12538.clear();
         this.l = null;
         this.f_12540 = null;
         this.f_12541 = Hand.MAIN_HAND;
         this.f_12539 = Util146.EJtYLjUuQB7UGmfv.IDLE;
         this.f_12542 = 0;
         this.f_12543 = 0;
         this.f_12544 = 0;
         this.f_12545 = 0;
         this.f_12546 = -1;
         this.f_12547 = -1;
         this.f_12548 = -1;
         this.f_12549 = -1;
         this.f_12550 = false;
         this.f_12551 = false;
         this.f_12552 = false;
         this.f_12553 = ItemStack.EMPTY;
      }

      private void m_3116() {
         this.f_12540 = QuickImports.f_5909.player;
         this.f_12546 = QuickImports.f_5909.player.getInventory().getSelectedSlot();
         if (QuickImports.f_5909.player.getMainHandStack().isOf(this.l)) {
            this.f_12541 = Hand.MAIN_HAND;
            this.f_12547 = this.f_12546;
            this.m_972();
         } else {
            int var1 = this.m_4147(this.l, 0, 9);
            if (var1 != -1) {
               this.f_12541 = Hand.MAIN_HAND;
               this.m_2827(var1);
               this.m_972();
            } else {
               int var2 = this.m_4147(this.l, 9, 36);
               if (var2 != -1) {
                  int var3 = this.m_3872(this.f_12546);
                  this.f_12553 = QuickImports.f_5909.player.getInventory().getStack(var3).copy();
                  this.f_12548 = var2;
                  this.f_12549 = var3;
                  QuickImports.f_5909.interactionManager.clickSlot(0, this.f_12548, this.f_12549, SlotActionType.SWAP, QuickImports.f_5909.player);
                  if (!QuickImports.f_5909.player.getInventory().getStack(this.f_12549).isOf(this.l)) {
                     this.m_4103();
                  } else {
                     this.f_12551 = true;
                     this.f_12541 = Hand.MAIN_HAND;
                     this.m_2827(this.f_12549);
                     this.m_972();
                  }
               } else if (QuickImports.f_5909.player.getOffHandStack().isOf(this.l)) {
                  this.f_12541 = Hand.OFF_HAND;
                  this.m_972();
               } else {
                  this.m_4103();
               }
            }
         }
      }

      private int m_3872(int var1) {
         int[] var2 = new int[9];
         int var3 = 0;

         for (int var4 = 0; var4 < 9; var4++) {
            if (var4 != var1 && QuickImports.f_5909.player.getInventory().getStack(var4).isEmpty()) {
               var2[var3++] = var4;
            }
         }

         if (var3 == 0) {
            for (int var5 = 0; var5 < 9; var5++) {
               if (var5 != var1 && QuickImports.f_5909.player.getInventory().getStack(var5).getUseAction() == UseAction.NONE) {
                  var2[var3++] = var5;
               }
            }
         }

         if (var3 == 0) {
            for (int var6 = 0; var6 < 9; var6++) {
               if (var6 != var1) {
                  var2[var3++] = var6;
               }
            }
         }

         return var2[ThreadLocalRandom.current().nextInt(var3)];
      }

      private boolean m_1524(ItemStack var1) {
         return !var1.isEmpty() && QuickImports.f_5909.player.getItemCooldownManager().isCoolingDown(var1);
      }

      private void m_1555() {
         if (this.f_12539 == Util146.EJtYLjUuQB7UGmfv.IDLE && this.l == null) {
            Item var1 = this.f_12538.pollFirst();
            if (var1 != null) {
               this.m_2758(var1);
            }
         }
      }

      private void m_751() {
         this.m_721();
         this.f_12539 = Util146.EJtYLjUuQB7UGmfv.WAITING_TO_RESTORE;
         this.f_12542 = this.f_12551 ? this.m_1082(3, 6) : this.m_1082(1, 3);
         this.f_12543 = 0;
      }

      private boolean m_3229() {
         if (this.f_12542 <= 0) {
            return false;
         } else {
            this.f_12542--;
            return true;
         }
      }

      private void m_2758(Item var1) {
         this.l = var1;
         this.f_12540 = null;
         this.f_12541 = Hand.MAIN_HAND;
         this.f_12542 = this.m_1082(1, 3);
         this.f_12543 = 0;
         this.f_12544 = 0;
         this.f_12545 = 0;
         this.f_12546 = -1;
         this.f_12547 = -1;
         this.f_12548 = -1;
         this.f_12549 = -1;
         this.f_12550 = false;
         this.f_12551 = false;
         this.f_12552 = false;
         this.f_12553 = ItemStack.EMPTY;
         this.f_12539 = Util146.EJtYLjUuQB7UGmfv.WAITING_TO_SELECT;
      }

      private void m_917() {
         this.m_721();
         if (!this.f_12552 && !this.m_2277()) {
            if (QuickImports.f_5909.player != null
               && QuickImports.f_5909.interactionManager != null
               && QuickImports.f_5909.player.isUsingItem()
               && QuickImports.f_5909.player.getActiveItem().isOf(this.l)) {
               QuickImports.f_5909.interactionManager.stopUsingItem(QuickImports.f_5909.player);
            }
         }
      }

      private void m_972() {
         this.f_12539 = Util146.EJtYLjUuQB7UGmfv.WAITING_TO_USE;
         this.f_12542 = this.m_1082(2, 4);
         this.f_12543 = 0;
      }

      private boolean m_2277() {
         if (QuickImports.f_5909 != null && QuickImports.f_5909.getWindow() != null) {
            Key var1 = InputUtil.fromTranslationKey(QuickImports.f_5909.options.useKey.getBoundKeyTranslationKey());
            long var2 = QuickImports.f_5909.getWindow().getHandle();
            if (var1.getCategory() == Type.MOUSE) {
               return GLFW.glfwGetMouseButton(var2, var1.getCode()) == 1;
            } else {
               return var1.getCategory() == Type.KEYSYM ? InputUtil.isKeyPressed(QuickImports.f_5909.getWindow(), var1.getCode()) : false;
            }
         } else {
            return false;
         }
      }

      private int m_1082(int var1, int var2) {
         return ThreadLocalRandom.current().nextInt(var1, var2 + 1);
      }

      private void m_721() {
         if (this.f_12552 && QuickImports.f_5909.options != null) {
            if (!this.m_2277()) {
               QuickImports.f_5909.options.useKey.setPressed(false);
               this.f_12552 = false;
            }
         }
      }

      private void m_3053() {
         if (this.f_12539 == Util146.EJtYLjUuQB7UGmfv.IDLE) {
            this.m_1555();
         } else if (!this.m_1986()) {
            this.m_482();
         } else if (this.f_12540 != null && this.f_12540 != QuickImports.f_5909.player) {
            this.m_482();
         } else {
            if (this.f_12547 != -1 && QuickImports.f_5909.player.getInventory().getSelectedSlot() != this.f_12547) {
               this.f_12550 = false;
               if (this.f_12539 != Util146.EJtYLjUuQB7UGmfv.WAITING_TO_RESTORE) {
                  this.m_917();
                  this.f_12539 = Util146.EJtYLjUuQB7UGmfv.WAITING_TO_RESTORE;
                  this.f_12542 = 0;
               }
            }

            switch (this.f_12539) {
               case IDLE:
               case HOLDING_USE:
               default:
                  break;
               case WAITING_TO_SELECT:
                  this.m_1547();
                  break;
               case WAITING_TO_USE:
                  this.m_2368();
                  break;
               case WAITING_TO_RESTORE:
                  this.m_2245();
            }
         }
      }

      private void m_1547() {
         if (!this.m_3229()) {
            if (QuickImports.f_5909.currentScreen == null
               && QuickImports.f_5909.player.currentScreenHandler.syncId == 0
               && !QuickImports.f_5909.player.isUsingItem()
               && !QuickImports.f_5909.options.useKey.isPressed()
               && !QuickImports.f_5909.interactionManager.isBreakingBlock()
               && ((MinecraftClientMixin2)QuickImports.f_5909).getItemUseCooldown() <= 0) {
               ItemStack var1 = this.m_322(this.l);
               if (!var1.isEmpty() && !this.m_1524(var1)) {
                  this.m_3116();
               } else {
                  this.m_4103();
               }
            } else {
               if (++this.f_12543 > 100) {
                  this.m_4103();
               }
            }
         }
      }

      private void m_2965() {
         if (this.f_12539 == Util146.EJtYLjUuQB7UGmfv.HOLDING_USE) {
            if (this.m_1986() && this.f_12540 == QuickImports.f_5909.player) {
               if (this.f_12547 != -1 && QuickImports.f_5909.player.getInventory().getSelectedSlot() != this.f_12547) {
                  this.f_12550 = false;
                  this.m_917();
                  this.m_751();
               } else {
                  boolean var1 = QuickImports.f_5909.player.isUsingItem()
                     && QuickImports.f_5909.player.getActiveHand() == this.f_12541
                     && QuickImports.f_5909.player.getActiveItem().isOf(this.l);
                  if (!var1) {
                     this.m_721();
                     this.m_751();
                  } else {
                     this.f_12544++;
                     if (this.f_12552 && this.f_12544 >= this.f_12545) {
                        this.m_721();
                        if (this.f_12552) {
                           return;
                        }

                        QuickImports.f_5909.interactionManager.stopUsingItem(QuickImports.f_5909.player);
                        this.m_751();
                     }
                  }
               }
            } else {
               this.m_482();
            }
         }
      }

      private void m_2827(int var1) {
         this.f_12547 = var1;
         this.f_12550 = var1 != this.f_12546;
         QuickImports.f_5909.player.getInventory().setSelectedSlot(var1);
         ((ClientPlayerInteractionManagerMixin2)QuickImports.f_5909.interactionManager).invokeSyncSelectedSlot();
      }

      private void m_3414(ItemStack var1) {
         this.f_12539 = Util146.EJtYLjUuQB7UGmfv.HOLDING_USE;
         this.f_12544 = 0;
         this.f_12545 = this.m_2745(var1);
         if (!QuickImports.f_5909.options.useKey.isPressed()) {
            QuickImports.f_5909.options.useKey.setPressed(true);
            this.f_12552 = true;
         }
      }

      private boolean m_1986() {
         return QuickImports.f_5909 != null
            && QuickImports.f_5909.player != null
            && QuickImports.f_5909.world != null
            && QuickImports.f_5909.interactionManager != null;
      }

      private void m_2368() {
         if (QuickImports.f_5909.currentScreen == null && QuickImports.f_5909.player.currentScreenHandler.syncId == 0) {
            ItemStack var1 = QuickImports.f_5909.player.getStackInHand(this.f_12541);
            if (!var1.isOf(this.l) || this.m_1524(var1)) {
               this.m_917();
               this.m_751();
            } else if (QuickImports.f_5909.player.isUsingItem()) {
               if (QuickImports.f_5909.player.getActiveHand() == this.f_12541 && QuickImports.f_5909.player.getActiveItem().isOf(this.l)) {
                  this.m_3414(QuickImports.f_5909.player.getActiveItem());
               } else {
                  this.m_917();
                  this.m_751();
               }
            } else if (!this.m_3229()) {
               if (!QuickImports.f_5909.options.useKey.isPressed()
                  && !QuickImports.f_5909.interactionManager.isBreakingBlock()
                  && ((MinecraftClientMixin2)QuickImports.f_5909).getItemUseCooldown() <= 0) {
                  this.m_363();
                  if (QuickImports.f_5909.player.isUsingItem()
                     && QuickImports.f_5909.player.getActiveHand() == this.f_12541
                     && QuickImports.f_5909.player.getActiveItem().isOf(this.l)) {
                     this.m_3414(QuickImports.f_5909.player.getActiveItem());
                  } else {
                     this.m_751();
                  }
               } else {
                  if (++this.f_12543 > 40) {
                     this.m_751();
                  }
               }
            }
         } else {
            this.m_917();
            this.m_751();
         }
      }

      private int m_4147(Item var1, int var2, int var3) {
         if (QuickImports.f_5909.player == null) {
            return -1;
         } else {
            for (int var4 = var2; var4 < var3; var4++) {
               if (QuickImports.f_5909.player.getInventory().getStack(var4).isOf(var1)) {
                  return var4;
               }
            }

            return -1;
         }
      }
   }
}
