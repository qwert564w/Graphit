package su.energyclient.module.combat;

import java.util.function.Predicate;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.ArmorManager;
import su.energyclient.manager.impl.RotationManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.render.RenderUtil29;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util121;
import su.energyclient.util.Util170;

public class AutoSwap extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_972 = 36;
   private static final int f_973 = 0;
   private static final int f_974 = 0;
   private final ModeSetting f_975;
   private final ModeSetting f_976;
   private final ModeSetting f_977;
   private final ModeSetting f_978;
   private final ModeSetting f_979;
   private final RenderUtil22 f_980;
   private final RenderUtil22 f_981;
   private final BooleanSetting f_982;
   private final BooleanSetting f_983;
   private boolean f_984;
   private int f_985;
   private int f_986;
   private int f_987;
   private static final String f_988 = "Auto Swap";
   private static final String f_989 = "Автоматически перемещает предметы между главной и второй руками";
   private static final String f_990 = "Мод свап";
   private static final String f_991 = "Рука";
   private static final String f_992 = "Рука";
   private static final String f_993 = "Голова";
   private static final String f_994 = "Режим";
   private static final String f_995 = "Предметы";
   private static final String f_996 = "Предметы";
   private static final String f_997 = "Колесо";
   private static final String f_998 = "Свап головы";
   private static final String f_999 = "Шар и Шар";
   private static final String f_1000 = "Шар и Шар";
   private static final String f_1001 = "Шар и Шлем";
   private static final String f_1002 = "Первый предмет";
   private static final String f_1003 = "Тотем";
   private static final String f_1004 = "Щит";
   private static final String f_1005 = "Тотем";
   private static final String f_1006 = "Фейерверк";
   private static final String f_1007 = "Яблоко";
   private static final String f_1008 = "Любая еда";
   private static final String f_1009 = "Шар";
   private static final String f_1010 = "Второй предмет";
   private static final String f_1011 = "Шар";
   private static final String f_1012 = "Щит";
   private static final String f_1013 = "Тотем";
   private static final String f_1014 = "Фейерверк";
   private static final String f_1015 = "Яблоко";
   private static final String f_1016 = "Любая еда";
   private static final String f_1017 = "Шар";
   private static final String f_1018 = "Кнопка свапа";
   private static final String f_1019 = "Кнопка колеса";
   private static final String f_1020 = "Игнорировать обычные тотемы";
   private static final String f_1021 = "Обход HolyWorld";
   private static final String f_1022 = "Рука";
   private static final String f_1023 = "Голова";
   private static final String f_1024 = "Тотем";
   private static final String f_1025 = "Щит";
   private static final String f_1026 = "Фейерверк";
   private static final String f_1027 = "Яблоко";
   private static final String f_1028 = "Шар";
   private static final String f_1029 = "Шар, Cфера";
   private static final String f_1030 = "Любая еда";
   private static final String f_1031 = "ReallyWorld";
   private static final String f_1032 = "Шар и Шлем";
   private static final String f_1033 = "Шар и Шлем";
   private static final String f_1034 = "Свапнул на ";
   private static final String f_1035 = "Предметы";
   private static final String f_1036 = "Колесо";
   private static final String f_1037 = "Предметы";
   private static final String f_1038 = "Предметы";
   private static final String f_1039 = "Предметы";

   @EventHandler
   public void m_3684(Util121 var1) {
      if (this.f_987 > 0) {
         var1.m_433(0.0F);
         var1.m_2791(0.0F);
         var1.m_564(false);
         var1.m_1269(false);
      }
   }

   private ArmorManager m_2943() {
      InitManager var1 = InitManager.f_2740;
      return var1 != null ? var1.f_2746 : null;
   }

   private boolean m_3083(ItemStack var1) {
      if (var1 != null && !var1.isEmpty() && var1.isIn(ItemTags.HEAD_ARMOR)) {
         EquippableComponent var2 = (EquippableComponent)var1.get(DataComponentTypes.EQUIPPABLE);
         return var2 != null && var2.slot() == EquipmentSlot.HEAD;
      } else {
         return false;
      }
   }

   private int m_3205() {
      ItemStack var1 = this.m_2414();
      return this.f_977.m_2073(f_1032) && this.m_3288(var1) ? this.m_2449(this::m_3083) : this.m_2449(this::m_3288);
   }

   private int m_2449(Predicate<ItemStack> var1) {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var2 = 0; var2 < 36; var2++) {
            ItemStack var3 = f_5909.player.getInventory().getStack(var2);
            if (var1.test(var3)) {
               return this.m_1450(var2);
            }
         }

         return -1;
      }
   }

   private Item m_1046(String var1) {
      return switch (var1) {
         case f_1024 -> Items.TOTEM_OF_UNDYING;
         case f_1025 -> Items.SHIELD;
         case f_1026 -> Items.FIREWORK_ROCKET;
         case f_1027 -> Items.GOLDEN_APPLE;
         case f_1028, f_1029 -> Items.PLAYER_HEAD;
         case f_1030 -> null;
         default -> Items.AIR;
      };
   }

   private int m_1260(Item var1) {
      boolean var2 = this.f_982.m_1163() && this.f_980.m_1326();
      if (var1 == Items.TOTEM_OF_UNDYING && var2) {
         return this.m_2449(var0 -> var0.getItem() == Items.TOTEM_OF_UNDYING && !EnchantmentHelper.getEnchantments(var0).isEmpty());
      } else {
         return var1 == null ? this.m_3653() : this.m_2449(var1x -> var1x.getItem() == var1);
      }
   }

   private int m_276() {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var1 = 0; var1 < 9; var1++) {
            if (f_5909.player.getInventory().getStack(var1).isEmpty()) {
               return var1;
            }
         }

         return f_5909.player.getInventory().getSelectedSlot();
      }
   }

   private void m_1027(int var1, int var2) {
      int var3 = this.m_2467(var2);
      if (var3 >= 0) {
         f_5909.interactionManager.clickSlot(var1, 5, var3, SlotActionType.SWAP, f_5909.player);
      } else {
         int var4 = this.m_276();
         if (var4 >= 0) {
            f_5909.interactionManager.clickSlot(var1, var2, var4, SlotActionType.SWAP, f_5909.player);
            f_5909.interactionManager.clickSlot(var1, 5, var4, SlotActionType.SWAP, f_5909.player);
            f_5909.interactionManager.clickSlot(var1, var2, var4, SlotActionType.SWAP, f_5909.player);
         }
      }
   }

   public AutoSwap() {
      super(f_988, f_989, Category.COMBAT);
      this.f_975 = new ModeSetting(f_990, f_991, f_992, f_993);
      this.f_976 = new ModeSetting(f_994, f_995, f_996, f_997);
      this.f_977 = new ModeSetting(f_998, f_999, f_1000, f_1001).m_1263(this::m_573);
      this.f_978 = new ModeSetting(f_1002, f_1003, f_1004, f_1005, f_1006, f_1007, f_1008, f_1009).m_1263(() -> this.f_976.m_2073(f_1039) && this.m_1791());
      this.f_979 = new ModeSetting(f_1010, f_1011, f_1012, f_1013, f_1014, f_1015, f_1016, f_1017).m_1263(() -> this.f_976.m_2073(f_1038) && this.m_1791());
      this.f_980 = new RenderUtil22(f_1018, -1).m_2895(() -> this.f_976.m_2073(f_1037));
      this.f_981 = new RenderUtil22(f_1019, -1).m_2895(() -> this.f_976.m_2073(f_1036));
      this.f_982 = new BooleanSetting(f_1020, true).m_334(() -> this.f_976.m_2073(f_1035) && this.m_1791());
      this.f_983 = new BooleanSetting(f_1021, true);
      this.f_984 = false;
      this.f_985 = 0;
      this.f_986 = -1;
      this.f_987 = 0;
   }

   private int m_934(int var1) {
      return var1 >= 36 && var1 <= 44 ? var1 - 36 : var1;
   }

   private void m_3249() {
      ItemStack var1 = this.m_2742();
      ItemStack var2 = this.m_2414();
      if (!var1.isEmpty() && !this.m_4110(var2, var1) && (!this.m_573() || this.m_2288(var1))) {
         int var3 = this.m_2776(var1);
         if (var3 < 0) {
            this.f_984 = false;
         } else {
            this.m_3950(var3);
         }
      } else {
         this.f_984 = false;
      }
   }

   private ItemStack m_2414() {
      if (f_5909.player == null) {
         return ItemStack.EMPTY;
      } else {
         return this.m_573() ? f_5909.player.getEquippedStack(EquipmentSlot.HEAD) : f_5909.player.getOffHandStack();
      }
   }

   private int m_4135() {
      if (this.m_573()) {
         return this.m_3205();
      } else {
         ItemStack var1 = this.m_2414();
         Item var2 = var1.getItem();
         Item var3 = this.m_1046(this.f_978.m_3862());
         Item var4 = this.m_1046(this.f_979.m_3862());
         if (var1.isEmpty()) {
            int var6 = this.m_1260(var3);
            return var6 >= 0 ? var6 : this.m_1260(var4);
         } else if ((var3 == null || var2 != var3) && (var3 != null || !var1.contains(DataComponentTypes.FOOD))) {
            if ((var4 == null || var2 != var4) && (var4 != null || !var1.contains(DataComponentTypes.FOOD))) {
               int var5 = this.m_1260(var3);
               return var5 >= 0 ? var5 : this.m_1260(var4);
            } else {
               return this.m_1260(var3);
            }
         } else {
            return this.m_1260(var4);
         }
      }
   }

   private boolean m_4017() {
      return this.m_573()
         ? f_5909.currentScreen == null || f_5909.currentScreen instanceof RenderUtil29
         : f_5909.currentScreen == null || f_5909.currentScreen instanceof RenderUtil29 || f_5909.currentScreen instanceof HandledScreen;
   }

   private boolean m_573() {
      return this.f_975.m_2073(f_1023);
   }

   private boolean m_3288(ItemStack var1) {
      return var1 != null && !var1.isEmpty() && var1.getItem() == Items.PLAYER_HEAD;
   }

   private void m_1478(int var1) {
      if (f_5909.player != null && f_5909.interactionManager != null && this.m_2568(this.m_3500(var1))) {
         int var2 = f_5909.player.currentScreenHandler.syncId;
         if (this.m_1791()) {
            f_5909.interactionManager.clickSlot(var2, var1, 40, SlotActionType.SWAP, f_5909.player);
         } else {
            this.m_1027(var2, var1);
         }

         f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
      }
   }

   private ItemStack m_3500(int var1) {
      return f_5909.player != null && this.m_3312(var1) ? f_5909.player.getInventory().getStack(this.m_934(var1)) : ItemStack.EMPTY;
   }

   private boolean m_2568(ItemStack var1) {
      return !this.m_573() || this.m_2288(var1);
   }

   private int m_2467(int var1) {
      return var1 >= 36 && var1 <= 44 ? var1 - 36 : -1;
   }

   @Override
   public void m_1() {
      this.f_984 = false;
      this.f_985 = 0;
      this.f_986 = -1;
      this.f_987 = 0;
      super.m_1();
   }

   private ItemStack m_2742() {
      ArmorManager var1 = this.m_2943();
      if (var1 != null && f_5909.player != null) {
         int var2 = var1.m_2248();
         return var2 < 0 ? ItemStack.EMPTY : var1.m_987(var2);
      } else {
         return ItemStack.EMPTY;
      }
   }

   private int m_3653() {
      if (f_5909.player == null) {
         return -1;
      } else {
         int var1 = -1;
         int var2 = 0;

         for (int var3 = 0; var3 < 36; var3++) {
            ItemStack var4 = f_5909.player.getInventory().getStack(var3);
            if (!var4.isEmpty() && var4.contains(DataComponentTypes.FOOD) && var4.getCount() > var2) {
               var1 = var3;
               var2 = var4.getCount();
            }
         }

         return var1 == -1 ? -1 : this.m_1450(var1);
      }
   }

   private void m_3950(int var1) {
      ItemStack var2 = this.m_3500(var1);
      if (!this.m_2568(var2)) {
         this.f_984 = false;
      } else {
         if (!this.f_983.m_1163() && !InitManager.f_2740.f_2741.guiMove.m_512().m_2073(f_1031)) {
            this.m_1478(var1);
            this.f_984 = false;
            this.m_427(var2);
         } else {
            this.f_987 = 2;
            this.f_985 = 1;
            this.f_986 = var1;
         }
      }
   }

   private void m_2315() {
      int var1 = this.m_4135();
      if (var1 < 0) {
         this.f_984 = false;
      } else {
         this.m_3950(var1);
      }
   }

   private boolean m_1791() {
      return this.f_975.m_2073(f_1022);
   }

   private int m_1450(int var1) {
      return var1 < 9 ? var1 + 36 : var1;
   }

   @EventHandler
   public void m_2236(CancellableEvent var1) {
      int var2 = var1.m_2169();
      if (this.f_980.m_1326()) {
         if (!var1.m_3546()) {
            if (var2 == this.f_980.m_1958() && var1.m_1362()) {
               this.f_984 = true;
            }
         }
      } else if (this.f_981.m_1326() && var2 == this.f_981.m_1958() && this.m_4017()) {
         if (var1.m_1362()) {
            this.f_984 = true;
            if (!(f_5909.currentScreen instanceof RenderUtil29)) {
               f_5909.setScreen(new RenderUtil29());
            }
         } else if (f_5909.currentScreen instanceof RenderUtil29 var3) {
            int var7 = var3.getHoveredSlot();
            if (var7 >= 0) {
               ArmorManager var5 = this.m_2943();
               if (var5 != null) {
                  ItemStack var6 = var5.m_987(var7);
                  if (!var6.isEmpty()) {
                     var5.m_91(var7);
                  }
               }
            }

            f_5909.setScreen(null);
         }
      }
   }

   private boolean m_3312(int var1) {
      return var1 >= 9 && var1 <= 44;
   }

   private boolean m_4110(ItemStack var1, ItemStack var2) {
      if (var1 == null || var2 == null || var1.isEmpty() || var2.isEmpty()) {
         return false;
      } else {
         return !ItemStack.areItemsAndComponentsEqual(var1, var2) ? false : var1.getName().getString().equals(var2.getName().getString());
      }
   }

   private void m_427(ItemStack var1) {
      if (f_5909.player != null && f_5909.player.isAlive() && var1 != null && !var1.isEmpty()) {
         MutableText var2 = Text.empty().append(Text.literal(f_1034).formatted(Formatting.GRAY)).append(var1.getName().copy().formatted(Formatting.WHITE));
         RotationManager.m_3112(var1, var2);
      }
   }

   @EventHandler
   public void m_1523(Util170 var1) {
      if (this.f_987 > 0) {
         this.f_987--;
      }

      if (this.f_985 == 1 && this.f_986 != -1) {
         ItemStack var7 = this.m_3500(this.f_986);
         this.m_1478(this.f_986);
         this.f_985 = 0;
         this.f_986 = -1;
         this.f_984 = false;
         this.m_427(var7);
      } else if (this.f_985 <= 0) {
         if (this.f_980.m_1326()) {
            if (this.f_984) {
               this.m_2315();
            }
         } else if (this.f_981.m_1326()) {
            ArmorManager var2 = this.m_2943();
            if (var2 == null) {
               return;
            }

            int var3 = var2.m_2248();
            if (var3 >= 0) {
               ItemStack var4 = var2.m_987(var3);
               boolean var5 = var4.isEmpty();
               boolean var6 = !var5 && !this.m_4110(this.m_2414(), var4);
               if (!var2.m_1702() && (var5 || var6)) {
                  var2.m_91(-1);
               }
            }

            if (var2.m_2780() && this.f_984) {
               this.m_3249();
            }
         }
      }
   }

   private boolean m_2288(ItemStack var1) {
      return this.m_3288(var1) ? true : this.f_977.m_2073(f_1033) && this.m_3083(var1);
   }

   private int m_2776(ItemStack var1) {
      if (var1 == null || var1.isEmpty()) {
         return -1;
      } else {
         return !this.f_981.m_1326() ? this.m_1260(var1.getItem()) : this.m_2449(var2 -> this.m_4110(var2, var1));
      }
   }
}
