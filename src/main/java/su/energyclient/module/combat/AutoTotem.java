package su.energyclient.module.combat;

import java.util.Iterator;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.movement.AutoSprint;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util121;
import su.energyclient.util.Util158;
import su.energyclient.util.Util169;
import su.energyclient.util.Util170;
import su.energyclient.util.Util38;
import su.energyclient.util.Util63;

public class AutoTotem extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_6805 = "По здоровью";
   private static final String f_6806 = "";
   private static final String f_6807 = "";
   private static final String f_6808 = "";
   private static final String f_6809 = "";
   private static final long f_6810 = 0L;
   private final Util63 f_6811;
   private final NumberSetting f_6812;
   private final BooleanSetting f_6813;
   private final BooleanSetting f_6814;
   private final NumberSetting f_6815;
   private final NumberSetting f_6816;
   private final NumberSetting f_6817;
   private final NumberSetting f_6818;
   private final BooleanSetting f_6819;
   private final NumberSetting f_6820;
   private final BooleanSetting O;
   private final BooleanSetting f_6821;
   private final NumberSetting f_6822;
   private final BooleanSetting f_6823;
   private Item f_6824;
   private ItemStack f_6825;
   private int f_6826;
   private AutoTotem.u6y7RRsL6inPYVjo f_6827;
   private long f_6828;
   private long f_6829;
   private int f_6830;
   private static final String f_6831 = "Auto Totem";
   private static final String f_6832 = "Automatically keeps a totem in your offhand";
   private static final String f_6833 = "Условия активации";
   private static final String f_6834 = "По здоровью";
   private static final String f_6835 = "По кристаллам";
   private static final String f_6836 = "При падении";
   private static final String f_6837 = "С элитрой";
   private static final String f_6838 = "В пустоте";
   private static final String f_6839 = "Порог здоровья";
   private static final float f_6840 = 6.0F;
   private static final float f_6841 = 20.0F;
   private static final float f_6842 = 0.5F;
   private static final String f_6843 = "Учитывать золотые сердца";
   private static final String f_6844 = "Безопасность";
   private static final String f_6845 = "Защитный порог здоровья";
   private static final float f_6846 = 6.0F;
   private static final float f_6847 = 20.0F;
   private static final float f_6848 = 0.5F;
   private static final String f_6849 = "Радиус кристаллов";
   private static final float f_6850 = 6.0F;
   private static final float f_6851 = 12.0F;
   private static final float f_6852 = 0.5F;
   private static final String f_6853 = "Дистанция падения";
   private static final float f_6854 = 10.0F;
   private static final float f_6855 = 3.0F;
   private static final float f_6856 = 50.0F;
   private static final String f_6857 = "Порог здоровья с элитрой";
   private static final float f_6858 = 10.0F;
   private static final float f_6859 = 20.0F;
   private static final float f_6860 = 0.5F;
   private static final String f_6861 = "Проверка если шар по HP";
   private static final String f_6862 = "HP для шаров у кристаллов";
   private static final float f_6863 = 10.0F;
   private static final float f_6864 = 20.0F;
   private static final float f_6865 = 0.5F;
   private static final String f_6866 = "Обход RW";
   private static final String f_6867 = "Возвращать прошлый предмет";
   private static final String f_6868 = "Откат свапа";
   private static final float f_6869 = 100.0F;
   private static final float f_6870 = 500.0F;
   private static final float f_6871 = 25.0F;
   private static final String f_6872 = "Показывать количество тотемов";
   private static final String f_6873 = "ReallyWorld";
   private static final long f_6874 = 100L;
   private static final String f_6875 = "ReallyWorld";
   private static final long f_6876 = 200L;
   private static final String f_6877 = "ReallyWorld";
   private static final long f_6878 = 100L;
   private static final String f_6879 = "По кристаллам";
   private static final String f_6880 = "При падении";
   private static final float f_6881 = 3.0F;
   private static final String f_6882 = "С элитрой";
   private static final float f_6883 = 9.0F;
   private static final float f_6884 = 52.5F;

   private boolean m_986(ItemStack var1) {
      return this.f_6825 != null && !this.f_6825.isEmpty() ? ItemStack.areItemsAndComponentsEqual(var1, this.f_6825) : false;
   }

   private void m_2718() {
      ItemStack var1 = f_5909.player.getOffHandStack();
      Item var2 = var1.getItem();
      if (var2 != Items.TOTEM_OF_UNDYING && var2 != Items.AIR) {
         this.f_6824 = var2;
         this.f_6825 = var1.copy();
      } else {
         this.f_6824 = null;
         this.f_6825 = null;
      }
   }

   private boolean m_3036() {
      if (!this.f_6811.I(f_6880)) {
         return false;
      } else if (!f_5909.player.isOnGround() && f_5909.player.fallDistance > this.f_6817.m_4046()) {
         float var1 = f_5909.player.getHealth() + (this.f_6813.m_1163() ? f_5909.player.getAbsorptionAmount() : 0.0F);
         float var2 = (float)f_5909.player.fallDistance - f_6881;
         return var2 >= var1;
      } else {
         return false;
      }
   }

   @Override
   public void m_1() {
      this.m_570();
      this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.IDLE;
      this.f_6828 = 0L;
      this.f_6829 = 0L;
      this.f_6830 = -1;
      AutoSprint.m_1519(true);
      super.m_1();
   }

   private boolean m_1466() {
      float var1 = f_5909.player.getHealth() + (this.f_6813.m_1163() ? f_5909.player.getAbsorptionAmount() : 0.0F);
      return var1 <= this.f_6815.m_4046();
   }

   @EventHandler
   public void m_3830(Util121 var1) {
      if (this.f_6827 == AutoTotem.u6y7RRsL6inPYVjo.STOPPING_EQUIP || this.f_6827 == AutoTotem.u6y7RRsL6inPYVjo.STOPPING_SWAP_BACK) {
         var1.m_433(0.0F);
         var1.m_2791(0.0F);
      }
   }

   private boolean m_477(long var1) {
      return var1 - this.f_6829 >= (long)this.f_6822.m_4046();
   }

   private boolean m_2559() {
      if (!this.f_6811.I(f_6879)) {
         return false;
      } else {
         double var1 = this.f_6816.m_4046();
         double var3 = var1 * var1;
         Iterator var5 = f_5909.world.getEntities().iterator();

         while (true) {
            if (!var5.hasNext()) {
               return false;
            }

            Entity var6 = (Entity)var5.next();
            if (var6 instanceof EndCrystalEntity var7 && f_5909.player.squaredDistanceTo(var7) <= var3) {
               boolean var8 = f_5909.player.getY() >= var7.getY();
               if (var8) {
                  boolean var9 = f_5909.player.getOffHandStack().getItem() == Items.PLAYER_HEAD;
                  if (!var9 || !this.f_6819.m_1163()) {
                     break;
                  }

                  float var10 = f_5909.player.getHealth() + (this.f_6813.m_1163() ? f_5909.player.getAbsorptionAmount() : 0.0F);
                  if (!(var10 > this.f_6820.m_4046())) {
                     break;
                  }
               }
            }
         }

         return true;
      }
   }

   private void m_1554(DrawContext var1) {
      if (f_5909.player != null) {
         int var2 = 0;

         for (int var3 = 0; var3 < 45; var3++) {
            ItemStack var4 = f_5909.player.getInventory().getStack(var3);
            if (var4.getItem() == Items.TOTEM_OF_UNDYING) {
               var2 += var4.getCount();
            }
         }

         float var7 = f_5909.getWindow().getScaledWidth();
         float var8 = f_5909.getWindow().getScaledHeight();
         float var5 = var7 / 2.0F - f_6883;
         float var6 = var8 - f_6884;
         Util158.m_4093(var1, new ItemStack(Items.TOTEM_OF_UNDYING), var5, var6, 1.0F, -1, 1.0F, false, String.valueOf(var2));
      }
   }

   public AutoTotem() {
      super(f_6831, f_6832, Category.COMBAT);
      this.f_6811 = new Util63(
         f_6833,
         BooleanSetting.m_136(f_6834, true),
         BooleanSetting.m_136(f_6835, false),
         BooleanSetting.m_136(f_6836, false),
         BooleanSetting.m_136(f_6837, false),
         BooleanSetting.m_136(f_6838, false)
      );
      this.f_6812 = new NumberSetting(f_6839, f_6840, 1.0F, f_6841, f_6842);
      this.f_6813 = new BooleanSetting(f_6843, true);
      this.f_6814 = new BooleanSetting(f_6844, true);
      this.f_6815 = new NumberSetting(f_6845, f_6846, 1.0F, f_6847, f_6848).m_356(this.f_6814::m_1163);
      this.f_6816 = new NumberSetting(f_6849, f_6850, 1.0F, f_6851, f_6852);
      this.f_6817 = new NumberSetting(f_6853, f_6854, f_6855, f_6856, 1.0F);
      this.f_6818 = new NumberSetting(f_6857, f_6858, 1.0F, f_6859, f_6860);
      this.f_6819 = new BooleanSetting(f_6861, false);
      this.f_6820 = new NumberSetting(f_6862, f_6863, 1.0F, f_6864, f_6865).m_356(this.f_6819::m_1163);
      this.O = new BooleanSetting(f_6866, false);
      this.f_6821 = new BooleanSetting(f_6867, true);
      this.f_6822 = new NumberSetting(f_6868, f_6869, 0.0F, f_6870, f_6871);
      this.f_6823 = new BooleanSetting(f_6872, true);
      this.f_6826 = -1;
      this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.IDLE;
      this.f_6830 = -1;
   }

   private int m_2775() {
      if (this.f_6826 != -1) {
         int var1 = this.f_6826 >= 36 ? this.f_6826 - 36 : this.f_6826;
         if (var1 >= 0 && var1 < 36) {
            ItemStack var2 = f_5909.player.getInventory().getStack(var1);
            if (this.m_986(var2)) {
               return this.f_6826;
            }
         }
      }

      if (this.f_6825 != null && !this.f_6825.isEmpty()) {
         for (int var3 = 0; var3 < 36; var3++) {
            ItemStack var4 = f_5909.player.getInventory().getStack(var3);
            if (ItemStack.areItemsAndComponentsEqual(var4, this.f_6825)) {
               return var3 < 9 ? var3 + 36 : var3;
            }
         }
      }

      return this.m_4027(this.f_6824);
   }

   private void m_2131(int var1) {
      int var2 = f_5909.player.currentScreenHandler.syncId;
      f_5909.interactionManager.clickSlot(var2, var1, 40, SlotActionType.SWAP, f_5909.player);
      f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(0));
      this.f_6829 = System.currentTimeMillis();
   }

   private boolean m_4056() {
      float var1 = f_5909.player.getHealth() + (this.f_6813.m_1163() ? f_5909.player.getAbsorptionAmount() : 0.0F);
      return var1 <= this.f_6812.m_4046();
   }

   private int m_4027(Item var1) {
      for (int var2 = 0; var2 < 36; var2++) {
         if (f_5909.player.getInventory().getStack(var2).getItem() == var1) {
            return var2 < 9 ? var2 + 36 : var2;
         }
      }

      return -1;
   }

   @EventHandler
   private void m_2712(Util169 var1) {
      if (this.f_6823.m_1163()) {
         this.m_1554(var1.m_4037());
      }
   }

   private void m_473(long var1) {
      if (this.f_6821.m_1163() && this.f_6824 != null && this.f_6824 != Items.AIR) {
         this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.WAITING_SWAP;
         this.f_6828 = var1;
      } else {
         this.m_570();
         this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.IDLE;
      }
   }

   private void m_218(long var1) {
      if (this.f_6821.m_1163() && this.f_6824 != null && this.f_6824 != Items.AIR) {
         int var3 = this.m_2775();
         if (var3 != -1) {
            this.m_2131(var3);
         }
      }

      this.m_570();
      this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.IDLE;
   }

   private boolean m_2620() {
      return this.m_4056() || this.m_2559() || this.m_3036() || this.m_1649();
   }

   private boolean m_3487() {
      for (Hand var4 : Hand.values()) {
         if (f_5909.player.getStackInHand(var4).getItem() == Items.TOTEM_OF_UNDYING) {
            return true;
         }
      }

      return false;
   }

   private boolean m_1286() {
      return this.m_1466() || this.m_2559() || this.m_3036() || this.m_1649();
   }

   private void m_782() {
      AutoSprint.m_1519(false);
      f_5909.player.setSprinting(false);
      f_5909.options.jumpKey.setPressed(false);
      f_5909.options.forwardKey.setPressed(false);
      f_5909.options.backKey.setPressed(false);
      f_5909.options.leftKey.setPressed(false);
      f_5909.options.rightKey.setPressed(false);
      f_5909.options.sprintKey.setPressed(false);
   }

   @EventHandler
   private void m_60(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
         long var2 = System.currentTimeMillis();
         boolean var4 = f_5909.player.getOffHandStack().getItem() == Items.TOTEM_OF_UNDYING;
         boolean var5 = this.m_2620();
         boolean var6 = this.f_6814.m_1163() ? this.m_1286() : var5;
         switch (this.f_6827) {
            case IDLE:
               if (var5 && !this.m_3487()) {
                  int var10 = this.m_4027(Items.TOTEM_OF_UNDYING);
                  if (var10 != -1 && this.m_477(var2)) {
                     this.m_2718();
                     this.f_6826 = var10;
                     if ((this.O.m_1163() || InitManager.f_2740.f_2741.guiMove.m_512().m_2073(f_6873)) && Util38.m_469()) {
                        this.f_6830 = var10;
                        this.m_782();
                        this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.STOPPING_EQUIP;
                        this.f_6828 = var2;
                     } else {
                        this.m_2131(var10);
                        this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.TOTEM_EQUIPPED;
                        this.f_6828 = var2;
                     }
                  }
               }
               break;
            case STOPPING_EQUIP:
               this.m_782();
               if (var2 - this.f_6828 >= f_6874 && this.m_477(var2)) {
                  this.m_2131(this.f_6830);
                  this.f_6830 = -1;
                  this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.TOTEM_EQUIPPED;
                  this.f_6828 = var2;
                  AutoSprint.m_1519(true);
               }
               break;
            case TOTEM_EQUIPPED:
               if (!var4) {
                  if (var6) {
                     if (this.m_477(var2)) {
                        int var9 = this.m_4027(Items.TOTEM_OF_UNDYING);
                        if (var9 != -1) {
                           if ((this.O.m_1163() || InitManager.f_2740.f_2741.guiMove.m_512().m_2073(f_6875)) && Util38.m_469()) {
                              this.f_6830 = var9;
                              this.m_782();
                              this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.STOPPING_EQUIP;
                              this.f_6828 = var2;
                           } else {
                              this.m_2131(var9);
                              this.f_6828 = var2;
                           }
                        } else {
                           this.m_218(var2);
                        }
                     }
                  } else {
                     this.m_473(var2);
                  }
               } else if (!var6) {
                  this.m_473(var2);
               }
               break;
            case WAITING_SWAP:
               if (var6) {
                  if (var4) {
                     this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.TOTEM_EQUIPPED;
                  } else if (this.m_477(var2)) {
                     int var7 = this.m_4027(Items.TOTEM_OF_UNDYING);
                     if (var7 != -1) {
                        this.m_2131(var7);
                        this.f_6828 = var2;
                        this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.TOTEM_EQUIPPED;
                     }
                  }
               } else if (var2 - this.f_6828 >= f_6876 && this.m_477(var2)) {
                  if (this.f_6821.m_1163() && this.f_6824 != null && this.f_6824 != Items.AIR) {
                     int var8 = this.m_2775();
                     if (var8 == -1) {
                        this.m_570();
                        this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.IDLE;
                     } else if ((this.O.m_1163() || InitManager.f_2740.f_2741.guiMove.m_512().m_2073(f_6877)) && Util38.m_469()) {
                        this.f_6830 = var8;
                        this.m_782();
                        this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.STOPPING_SWAP_BACK;
                        this.f_6828 = var2;
                     } else {
                        this.m_2131(var8);
                        this.m_570();
                        this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.IDLE;
                     }
                  } else {
                     this.m_570();
                     this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.IDLE;
                  }
               }
               break;
            case STOPPING_SWAP_BACK:
               this.m_782();
               if (var2 - this.f_6828 >= f_6878 && this.m_477(var2)) {
                  this.m_2131(this.f_6830);
                  this.f_6830 = -1;
                  this.f_6827 = AutoTotem.u6y7RRsL6inPYVjo.IDLE;
                  this.m_570();
                  AutoSprint.m_1519(true);
               }
         }
      }
   }

   private void m_570() {
      this.f_6824 = null;
      this.f_6825 = null;
      this.f_6826 = -1;
   }

   private boolean m_1649() {
      if (!this.f_6811.I(f_6882)) {
         return false;
      } else {
         boolean var1 = f_5909.player.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.ELYTRA;
         return var1 && f_5909.player.getHealth() + (this.f_6813.m_1163() ? f_5909.player.getAbsorptionAmount() : 0.0F) <= this.f_6818.m_4046();
      }
   }

   private static enum u6y7RRsL6inPYVjo {
      IDLE,
      STOPPING_EQUIP,
      TOTEM_EQUIPPED,
      WAITING_SWAP,
      STOPPING_SWAP_BACK;
   }
}
