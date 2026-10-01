package su.energyclient.module.player;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventCooldownTracker;
import su.energyclient.event.impl.EventRightClickItemCheck;
import su.energyclient.event.impl.EventUseEnderPearl;
import su.energyclient.event.impl.EventUseFinish;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util101;
import su.energyclient.util.Util125;
import su.energyclient.util.Util63;

public class ItemsCooldown extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Util63 f_12048 = new Util63(
      ItemsCooldown.f_12062,
      new BooleanSetting(ItemsCooldown.f_12063, true),
      new BooleanSetting(ItemsCooldown.f_12064, true),
      new BooleanSetting(ItemsCooldown.f_12065, true),
      new BooleanSetting(ItemsCooldown.f_12066, true)
   );
   private static final NumberSetting f_12049 = new NumberSetting(
         ItemsCooldown.f_12067, ItemsCooldown.f_12068, ItemsCooldown.f_12069, ItemsCooldown.f_12070, ItemsCooldown.f_12071
      )
      .m_356(() -> f_12048.I(ItemsCooldown.f_12061));
   private static final NumberSetting f_12050 = new NumberSetting(
         ItemsCooldown.f_12072, ItemsCooldown.f_12073, ItemsCooldown.f_12074, ItemsCooldown.f_12075, ItemsCooldown.f_12076
      )
      .m_356(() -> f_12048.I(ItemsCooldown.f_12060));
   private static final NumberSetting f_12051 = new NumberSetting(
         ItemsCooldown.f_12077, ItemsCooldown.f_12078, ItemsCooldown.f_12079, ItemsCooldown.f_12080, ItemsCooldown.f_12081
      )
      .m_356(() -> f_12048.I(ItemsCooldown.f_12059));
   private static final NumberSetting f_12052 = new NumberSetting(
         ItemsCooldown.f_12082, ItemsCooldown.f_12083, ItemsCooldown.f_12084, ItemsCooldown.f_12085, ItemsCooldown.f_12086
      )
      .m_356(() -> f_12048.I(ItemsCooldown.f_12058));
   private static final BooleanSetting f_12053 = new BooleanSetting(ItemsCooldown.f_12087, true);
   private final Map<Item, Util125> f_12054 = new HashMap<>();
   private static final String f_12055 = "Items Cooldown";
   private static final String f_12056 = "Отображает оставшееся время восстановления для предметов, имеющих перезарядку";
   private static final float f_12057 = 1000.0F;
   private static final String f_12058 = "Эндер жемчуг";
   private static final String f_12059 = "Золотое зачарованное яблоко";
   private static final String f_12060 = "Хорус";
   private static final String f_12061 = "Золотое яблоко";
   private static final String f_12062 = "Применять на";
   private static final String f_12063 = "Золотое яблоко";
   private static final String f_12064 = "Золотое зачарованное яблоко";
   private static final String f_12065 = "Эндер жемчуг";
   private static final String f_12066 = "Хорус";
   private static final String f_12067 = "Задержка золотого яблока";
   private static final float f_12068 = 4.5F;
   private static final float f_12069 = 0.5F;
   private static final float f_12070 = 15.0F;
   private static final float f_12071 = 0.05F;
   private static final String f_12072 = "Задержка золотого зачарованного яблока";
   private static final float f_12073 = 4.5F;
   private static final float f_12074 = 0.5F;
   private static final float f_12075 = 15.0F;
   private static final float f_12076 = 0.05F;
   private static final String f_12077 = "Задержка эндер жемчуга";
   private static final float f_12078 = 14.05F;
   private static final float f_12079 = 0.5F;
   private static final float f_12080 = 15.0F;
   private static final float f_12081 = 0.05F;
   private static final String f_12082 = "Задержка хоруса";
   private static final float f_12083 = 2.3F;
   private static final float f_12084 = 0.5F;
   private static final float f_12085 = 15.0F;
   private static final float f_12086 = 0.05F;
   private static final String f_12087 = "Только при пвп";

   @EventHandler
   public void m_2577(EventUseFinish var1) {
      if (!f_12053.m_1163() || Util101.m_2329()) {
         Item var2 = var1.m_3888().getItem();
         if (ItemsCooldown.W8FDgAK141wv8Snj.m_3348(var2) != null) {
            this.f_12054.put(var2, new Util125());
         }
      }
   }

   @EventHandler
   public void m_3611(EventRightClickItemCheck var1) {
      if (!f_12053.m_1163() || Util101.m_2329()) {
         Item var2 = var1.m_401().getItem();
         ItemsCooldown.W8FDgAK141wv8Snj var3 = ItemsCooldown.W8FDgAK141wv8Snj.m_3348(var2);
         if (var3 != null && this.f_12054.containsKey(var3.m_282()) && f_5909.player.getItemCooldownManager().isCoolingDown(var3.m_282().getDefaultStack())) {
            var1.m_277(true);
         }
      }
   }

   public ItemsCooldown() {
      super(f_12055, f_12056, Category.PLAYER);
   }

   @EventHandler
   public void m_2912(EventCooldownTracker var1) {
      if (!f_12053.m_1163() || Util101.m_2329()) {
         Item var2 = var1.m_2859().getItem();
         Util125 var3 = this.f_12054.get(var2);
         if (var3 != null) {
            float var4 = ItemsCooldown.W8FDgAK141wv8Snj.m_3348(var2).m_1968() * f_12057;
            long var5 = var3.m_1913();
            if ((float)var5 >= var4) {
               this.f_12054.remove(var2);
            } else {
               var1.m_3359((float)var5 / var4);
            }
         }
      }
   }

   @EventHandler
   public void m_1106(EventUseEnderPearl var1) {
      if (!f_12053.m_1163() || Util101.m_2329()) {
         Item var2 = var1.m_1071().getItem();
         if (ItemsCooldown.W8FDgAK141wv8Snj.m_3348(var2) != null) {
            this.f_12054.put(var2, new Util125());
         }
      }
   }

   private static enum W8FDgAK141wv8Snj {
      GOLDEN_APPLE(Items.GOLDEN_APPLE, ItemsCooldown.f_12049.m_4046()),
      CHORUS(Items.CHORUS_FRUIT, ItemsCooldown.f_12052.m_4046()),
      PEARL(Items.ENDER_PEARL, ItemsCooldown.f_12051.m_4046()),
      ENC_GOLDEN_APPLE(Items.ENCHANTED_GOLDEN_APPLE, ItemsCooldown.f_12050.m_4046());

      private final Item f_7091;
      private final float f_7092;

      public static ItemsCooldown.W8FDgAK141wv8Snj m_3348(Item var0) {
         for (ItemsCooldown.W8FDgAK141wv8Snj var4 : values()) {
            if (var4.f_7091 == var0) {
               return var4;
            }
         }

         return null;
      }

      public Item m_282() {
         return this.f_7091;
      }

      public float m_1968() {
         return this.f_7092;
      }

      private W8FDgAK141wv8Snj(Item var3, float var4) {
         this.f_7091 = var3;
         this.f_7092 = var4;
      }
   }
}
