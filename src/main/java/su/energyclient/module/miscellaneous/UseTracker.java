package su.energyclient.module.miscellaneous;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.consume.UseAction;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.impl.RotationManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util104;
import su.energyclient.util.Util66;

public class UseTracker extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BooleanSetting f_2529;
   private final BooleanSetting f_2530;
   private final Map<UUID, UseTracker.Inner_7M0PHPQ6IBoqmxmX> f_2531;
   private static final String f_2532 = "Use Tracker";
   private static final String f_2533 = "Оповещает о тотемах и использовании еды/зелий";
   private static final String f_2534 = "Трекинг тотемов";
   private static final String f_2535 = "Трекинг еды/зелий";
   private static final String f_2536 = " потерял ";
   private static final String f_2537 = " использовал ";

   private ItemStack m_3705(PlayerEntity var1) {
      ItemStack var2 = var1.getOffHandStack();
      if (var2.getItem() == Items.TOTEM_OF_UNDYING) {
         return var2.copy();
      } else {
         ItemStack var3 = var1.getMainHandStack();
         return var3.getItem() == Items.TOTEM_OF_UNDYING ? var3.copy() : new ItemStack(Items.TOTEM_OF_UNDYING);
      }
   }

   private boolean m_1197(ItemStack var1, ItemStack var2) {
      if (var2.isEmpty()) {
         return true;
      } else {
         return var1.getItem() == var2.getItem()
            ? var2.getCount() < var1.getCount()
            : var2.getItem() == Items.GLASS_BOTTLE || !ItemStack.areItemsAndComponentsEqual(var1, var2);
      }
   }

   @EventHandler
   public void m_3795(Util104 var1) {
      if (this.f_2530.m_1163()) {
         if (f_5909.world != null && f_5909.player != null) {
            HashSet var2 = new HashSet();

            for (PlayerEntity var4 : f_5909.world.getPlayers()) {
               if (var4 != f_5909.player) {
                  UUID var5 = var4.getUuid();
                  var2.add(var5);
                  this.m_3463(var4, var5);
               }
            }

            this.f_2531.keySet().removeIf(var1x -> !var2.contains(var1x));
         }
      }
   }

   @Override
   public void m_1() {
      this.f_2531.clear();
      super.m_1();
   }

   public UseTracker() {
      super(f_2532, f_2533, Category.MISCELLANEOUS);
      this.f_2529 = new BooleanSetting(f_2534, true);
      this.f_2530 = new BooleanSetting(f_2535, true);
      this.f_2531 = new HashMap<>();
   }

   private void m_3463(PlayerEntity var1, UUID var2) {
      UseTracker.Inner_7M0PHPQ6IBoqmxmX var3 = this.f_2531.computeIfAbsent(var2, var0 -> new UseTracker.Inner_7M0PHPQ6IBoqmxmX());
      if (var1.isUsingItem()) {
         ItemStack var10 = var1.getActiveItem();
         if (!var10.isEmpty()) {
            UseAction var11 = var10.getUseAction();
            if (var11 == UseAction.EAT || var11 == UseAction.DRINK) {
               if (!var3.f_6188) {
                  var3.f_6188 = true;
                  var3.f_6189 = var1.getActiveHand();
                  var3.f_6190 = var10.copy();
                  var3.f_6191 = var1.age;
               }
            }
         }
      } else if (var3.f_6188) {
         ItemStack var4 = var3.f_6190.copy();
         Hand var5 = var3.f_6189;
         int var6 = Math.max(0, var1.age - var3.f_6191);
         var3.m_737();
         if (!var4.isEmpty()) {
            if (var6 >= 6) {
               ItemStack var7 = var5 == Hand.OFF_HAND ? var1.getOffHandStack() : var1.getMainHandStack();
               if (this.m_1197(var4, var7)) {
                  ItemStack var8 = var4.copy();
                  var8.setCount(Math.max(1, Math.min(this.m_2359(var4, var7), var8.getMaxCount())));
                  MutableText var9 = Text.empty()
                     .append(var1.getName())
                     .append(Text.literal(f_2537).formatted(Formatting.GRAY))
                     .append(var4.getName().copy().formatted(Formatting.WHITE));
                  RotationManager.m_3112(var8, var9);
               }
            }
         }
      }
   }

   @EventHandler
   public void m_2102(Util66 var1) {
      if (this.f_2529.m_1163()) {
         if (f_5909.world != null && f_5909.player != null) {
            if (var1.m_2068()) {
               if (var1.m_3295() instanceof EntityStatusS2CPacket var2) {
                  if (var2.getStatus() == 35) {
                     if (var2.getEntity(f_5909.world) instanceof PlayerEntity var4) {
                        if (var4 != f_5909.player) {
                           ItemStack var5 = this.m_3705(var4);
                           MutableText var6 = Text.empty()
                              .append(var4.getName())
                              .append(Text.literal(f_2536).formatted(Formatting.GRAY))
                              .append(var5.getName().copy().formatted(Formatting.WHITE));
                           RotationManager.m_3112(var5.copy(), var6);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private int m_2359(ItemStack var1, ItemStack var2) {
      if (var2.isEmpty()) {
         return var1.getCount();
      } else {
         return var1.getItem() != var2.getItem() ? 1 : Math.max(1, var1.getCount() - var2.getCount());
      }
   }

   private static final class Inner_7M0PHPQ6IBoqmxmX {
      private boolean f_6188;
      private Hand f_6189 = Hand.MAIN_HAND;
      private ItemStack f_6190 = ItemStack.EMPTY;
      private int f_6191;

      private void m_737() {
         this.f_6188 = false;
         this.f_6189 = Hand.MAIN_HAND;
         this.f_6190 = ItemStack.EMPTY;
         this.f_6191 = 0;
      }
   }
}
