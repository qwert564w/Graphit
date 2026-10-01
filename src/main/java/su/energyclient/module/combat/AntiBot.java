package su.energyclient.module.combat;

import com.google.common.collect.Lists;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Uuids;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util101;
import su.energyclient.util.Util170;

public class AntiBot extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final CopyOnWriteArrayList<PlayerEntity> f_3 = Lists.newCopyOnWriteArrayList();
   private final BooleanSetting f_4;
   private static final String f_5 = "Anti Bot";
   private static final String f_6 = "Не дает бить ботов";
   private static final String f_7 = "Удалять из мира";
   private static final String f_8 = "reallyworld";
   private static final String f_9 = "lonygrief";

   public AntiBot() {
      super(f_5, f_6, Category.COMBAT);
      this.f_4 = new BooleanSetting(f_7, false);
   }

   private void m_3392() {
      for (PlayerEntity var2 : f_5909.world.getPlayers()) {
         if (f_5909.player != var2 && !var2.getUuid().equals(Uuids.getOfflinePlayerUuid(var2.getName().getString())) && !f_3.contains(var2)) {
            f_3.add(var2);
         }
      }

      if (this.f_4.m_1163()) {
         try {
            f_5909.world.getPlayers().removeIf(f_3::contains);
         } catch (Exception var3) {
         }
      }
   }

   public static boolean m_2561() {
      return f_3.isEmpty();
   }

   @EventHandler
   private void m_3483(Util170 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         if (Util101.m_3117(f_8)) {
            this.m_3621();
         } else if (Util101.m_3117(f_9)) {
            this.m_3889();
         } else {
            this.m_3392();
         }
      }
   }

   private boolean m_565(ItemStack var1) {
      return var1.isEmpty() ? false : var1.hasGlint();
   }

   public static boolean m_79(LivingEntity var0) {
      return var0 instanceof PlayerEntity var1 ? f_3.contains(var1) : false;
   }

   private void m_3621() {
      for (PlayerEntity var2 : f_5909.world.getPlayers()) {
         if (f_5909.player != var2) {
            ItemStack var3 = var2.getEquippedStack(EquipmentSlot.FEET);
            ItemStack var4 = var2.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack var5 = var2.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack var6 = var2.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack var7 = var2.getOffHandStack();
            ItemStack var8 = var2.getMainHandStack();
            boolean var9 = !var3.isEmpty() && !var4.isEmpty() && !var5.isEmpty() && !var6.isEmpty();
            boolean var10 = var3.isEnchantable() && var4.isEnchantable() && var5.isEnchantable() && var6.isEnchantable();
            boolean var11 = var3.isOf(Items.LEATHER_BOOTS)
               || var4.isOf(Items.LEATHER_LEGGINGS)
               || var5.isOf(Items.LEATHER_CHESTPLATE)
               || var6.isOf(Items.LEATHER_HELMET)
               || var3.isOf(Items.IRON_BOOTS)
               || var4.isOf(Items.IRON_LEGGINGS)
               || var5.isOf(Items.IRON_CHESTPLATE)
               || var6.isOf(Items.IRON_HELMET);
            boolean var12 = !var3.isDamaged() && !var4.isDamaged() && !var5.isDamaged() && !var6.isDamaged();
            boolean var13 = var2.getHungerManager().getFoodLevel() == 20;
            if (var9 && var10 && var7.isEmpty() && var11 && !var8.isEmpty() && var12 && var13) {
               if (!f_3.contains(var2)) {
                  f_3.add(var2);
               }

               return;
            }

            f_3.remove(var2);
         }
      }
   }

   @Override
   public void m_1() {
      super.m_1();
      f_3.clear();
   }

   private void m_3889() {
      for (PlayerEntity var2 : f_5909.world.getPlayers()) {
         if (f_5909.player != var2) {
            ItemStack var3 = var2.getEquippedStack(EquipmentSlot.FEET);
            ItemStack var4 = var2.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack var5 = var2.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack var6 = var2.getEquippedStack(EquipmentSlot.HEAD);
            boolean var7 = var3.isEmpty();
            boolean var8 = var4.isEmpty();
            boolean var9 = var5.isEmpty();
            boolean var10 = var6.isEmpty();
            boolean var11 = !var3.isEmpty();
            boolean var12 = !var4.isEmpty();
            boolean var13 = !var5.isEmpty();
            boolean var14 = !var6.isEmpty();
            boolean var15 = this.m_565(var3);
            boolean var16 = this.m_565(var4);
            boolean var17 = this.m_565(var5);
            boolean var18 = this.m_565(var6);
            boolean var19 = var7 || var11 && !var15;
            boolean var20 = var8 || var12 && !var16;
            boolean var21 = var9 || var13 && !var17;
            boolean var22 = var10 || var14 && !var18;
            boolean var23 = var2.getArmor() == 0;
            boolean var24 = InitManager.f_2740.f_2744.m_3914(var2);
            boolean var25 = var3.isDamaged() && var4.isDamaged() && var5.isDamaged() && var6.isDamaged();
            boolean var26 = var2.getName().getString().length() == 6;
            boolean var27 = var19 && var20 && var21 && var22;
            if (var26 && !var24 && !var23 && !var25 && var27) {
               if (!f_3.contains(var2)) {
                  f_3.add(var2);
               }

               return;
            }

            f_3.remove(var2);
         }
      }
   }

   @Override
   public void m_2() {
      super.m_2();
      f_3.clear();
   }
}
