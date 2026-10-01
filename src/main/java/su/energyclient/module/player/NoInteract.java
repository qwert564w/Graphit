package su.energyclient.module.player;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventClickBlockRight;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util63;

public class NoInteract extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BooleanSetting f_7147;
   private final BooleanSetting f_7148;
   private final Util63 f_7149;
   private static final String f_7150 = "No Interact";
   private static final String f_7151 = "Отменяет взаимодействие с выбранными блоками";
   private static final String f_7152 = "Не ставить шар/сферу";
   private static final String f_7153 = "Все блоки";
   private static final String f_7154 = "Объекты";
   private static final String f_7155 = "Стойки";
   private static final String f_7156 = "Сундуки";
   private static final String f_7157 = "Двери";
   private static final String f_7158 = "Кнопки";
   private static final String f_7159 = "Воронки";
   private static final String f_7160 = "Раздатчики";
   private static final String f_7161 = "Нотные блоки";
   private static final String f_7162 = "Верстаки";
   private static final String f_7163 = "Люки";
   private static final String f_7164 = "Печки";
   private static final String f_7165 = "Калитки";
   private static final String f_7166 = "Наковальни";
   private static final String f_7167 = "Рычаги";
   private static final String f_7168 = "Двери";
   private static final String f_7169 = "Кнопки";
   private static final String f_7170 = "Сундуки";
   private static final String f_7171 = "Воронки";
   private static final String f_7172 = "Раздатчики";
   private static final String f_7173 = "Нотные блоки";
   private static final String f_7174 = "Верстаки";
   private static final String f_7175 = "Люки";
   private static final String f_7176 = "Печки";
   private static final String f_7177 = "Калитки";
   private static final String f_7178 = "Наковальни";
   private static final String f_7179 = "Рычаги";

   private void m_1389(Set<Block> var1, String var2, Block... var3) {
      if (this.f_7149.I(var2)) {
         Collections.addAll(var1, var3);
      }
   }

   @EventHandler
   private void m_3209(EventClickBlockRight var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (this.f_7147.m_1163() && var1.m_2117() == Hand.OFF_HAND && f_5909.player.getOffHandStack().getItem() == Items.PLAYER_HEAD) {
            var1.m_277(true);
         } else if (this.f_7148.m_1163()) {
            var1.m_277(true);
         } else {
            if (this.m_2536().contains(var1.m_85().getBlockState(var1.m_3080().getBlockPos()).getBlock())) {
               var1.m_277(true);
            }
         }
      }
   }

   public NoInteract() {
      super(f_7150, f_7151, Category.PLAYER);
      this.f_7147 = new BooleanSetting(f_7152, false);
      this.f_7148 = new BooleanSetting(f_7153, false);
      this.f_7149 = new Util63(
            f_7154,
            new BooleanSetting(f_7155, true),
            new BooleanSetting(f_7156, true),
            new BooleanSetting(f_7157, true),
            new BooleanSetting(f_7158, true),
            new BooleanSetting(f_7159, true),
            new BooleanSetting(f_7160, true),
            new BooleanSetting(f_7161, true),
            new BooleanSetting(f_7162, true),
            new BooleanSetting(f_7163, true),
            new BooleanSetting(f_7164, true),
            new BooleanSetting(f_7165, true),
            new BooleanSetting(f_7166, true),
            new BooleanSetting(f_7167, true)
         )
         .m_2120(() -> !this.f_7148.m_1163());
   }

   private Set<Block> m_2536() {
      HashSet var1 = new HashSet();
      this.m_1389(
         var1,
         f_7168,
         Blocks.ACACIA_DOOR,
         Blocks.DARK_OAK_DOOR,
         Blocks.BIRCH_DOOR,
         Blocks.IRON_DOOR,
         Blocks.JUNGLE_DOOR,
         Blocks.OAK_DOOR,
         Blocks.SPRUCE_DOOR,
         Blocks.CHERRY_DOOR,
         Blocks.BAMBOO_DOOR,
         Blocks.MANGROVE_DOOR,
         Blocks.CRIMSON_DOOR,
         Blocks.WARPED_DOOR
      );
      this.m_1389(
         var1,
         f_7169,
         Blocks.OAK_BUTTON,
         Blocks.STONE_BUTTON,
         Blocks.CRIMSON_BUTTON,
         Blocks.WARPED_BUTTON,
         Blocks.ACACIA_BUTTON,
         Blocks.BIRCH_BUTTON,
         Blocks.DARK_OAK_BUTTON,
         Blocks.JUNGLE_BUTTON,
         Blocks.SPRUCE_BUTTON,
         Blocks.CHERRY_BUTTON,
         Blocks.BAMBOO_BUTTON,
         Blocks.MANGROVE_BUTTON,
         Blocks.POLISHED_BLACKSTONE_BUTTON
      );
      this.m_1389(var1, f_7170, Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.BARREL);
      this.m_1389(var1, f_7171, Blocks.HOPPER);
      this.m_1389(var1, f_7172, Blocks.DISPENSER, Blocks.DROPPER);
      this.m_1389(var1, f_7173, Blocks.NOTE_BLOCK, Blocks.JUKEBOX);
      this.m_1389(var1, f_7174, Blocks.CRAFTING_TABLE, Blocks.CARTOGRAPHY_TABLE, Blocks.SMITHING_TABLE, Blocks.LOOM, Blocks.STONECUTTER);
      this.m_1389(
         var1,
         f_7175,
         Blocks.OAK_TRAPDOOR,
         Blocks.IRON_TRAPDOOR,
         Blocks.ACACIA_TRAPDOOR,
         Blocks.BIRCH_TRAPDOOR,
         Blocks.DARK_OAK_TRAPDOOR,
         Blocks.JUNGLE_TRAPDOOR,
         Blocks.SPRUCE_TRAPDOOR,
         Blocks.CHERRY_TRAPDOOR,
         Blocks.BAMBOO_TRAPDOOR,
         Blocks.MANGROVE_TRAPDOOR,
         Blocks.CRIMSON_TRAPDOOR,
         Blocks.WARPED_TRAPDOOR
      );
      this.m_1389(var1, f_7176, Blocks.FURNACE, Blocks.BLAST_FURNACE, Blocks.SMOKER);
      this.m_1389(
         var1,
         f_7177,
         Blocks.ACACIA_FENCE_GATE,
         Blocks.DARK_OAK_FENCE_GATE,
         Blocks.BIRCH_FENCE_GATE,
         Blocks.JUNGLE_FENCE_GATE,
         Blocks.OAK_FENCE_GATE,
         Blocks.SPRUCE_FENCE_GATE,
         Blocks.CHERRY_FENCE_GATE,
         Blocks.BAMBOO_FENCE_GATE,
         Blocks.MANGROVE_FENCE_GATE,
         Blocks.CRIMSON_FENCE_GATE,
         Blocks.WARPED_FENCE_GATE
      );
      this.m_1389(var1, f_7178, Blocks.ANVIL, Blocks.CHIPPED_ANVIL, Blocks.DAMAGED_ANVIL);
      this.m_1389(var1, f_7179, Blocks.LEVER);
      return var1;
   }
}
