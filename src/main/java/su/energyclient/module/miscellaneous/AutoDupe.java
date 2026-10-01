package su.energyclient.module.miscellaneous;

import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;
import su.energyclient.util.Util66;

public class AutoDupe extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_12126;
   private boolean f_12127;
   private static final String f_12128 = "Auto Dupe";
   private static final String f_12129 = "literal{§fꈁꀀꈂꌲꈂꀁ§0ꈃꄤ}";
   private static final String f_12130 = "literal{§fꈁꀀꈂꌉꈂꀁ§0ꈃꄤ}";
   private static final String f_12131 = "Итого: ";
   private static final String f_12132 = "market search зачарованное золотое яблоко";
   private static final String f_12133 = "У вас недостаточно денег для покупки!";
   private static final String f_12134 = "Идёт расчёт цены. Подождите...";

   private void m_4025(int var1) {
      if (f_5909.player != null && f_5909.player.networkHandler != null) {
         f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(var1));
         f_5909.setScreen(null);
      }
   }

   public AutoDupe() {
      super(f_12128, "", Category.MISCELLANEOUS);
   }

   @Override
   public void m_1() {
      super.m_1();
      this.f_12126 = 0;
      this.f_12127 = false;
   }

   @EventHandler
   public void m_3354(Util170 var1) {
      if (f_5909.currentScreen instanceof GenericContainerScreen var2) {
         ScreenHandler var9 = var2.getScreenHandler();
         int var4 = var9.syncId;
         if (this.f_12126 >= 4) {
            this.f_12126 = 0;
            this.f_12127 = false;
            f_5909.player.closeHandledScreen();
         } else {
            String var5 = var2.getTitle().toString();
            switch (var5) {
               case f_12129:
                  Util146.m_2161(var4, 10, 0, SlotActionType.PICKUP, f_5909.player);
                  break;
               case f_12130:
                  ItemStack var7 = var9.getSlot(22).getStack();
                  LoreComponent var8 = (LoreComponent)var7.getComponents().get(DataComponentTypes.LORE);
                  if (this.f_12127 || var8 != null && var8.lines().toString().contains(f_12131)) {
                     if (var7.getCount() == 64) {
                        if (f_5909.player.age % 5 == 0) {
                           f_5909.interactionManager.clickSlot(var4, 22, 0, SlotActionType.QUICK_MOVE, f_5909.player);
                        }
                     } else if (f_5909.player.age % 4 == 0) {
                        Util146.m_2161(var4, 24, 0, SlotActionType.QUICK_MOVE, f_5909.player);
                     }

                     this.f_12127 = true;
                  }
            }
         }
      } else if (f_5909.player.age % 3 == 0) {
         f_5909.player.networkHandler.sendChatCommand(f_12132);
      }
   }

   @EventHandler
   public void m_3571(Util66 var1) {
      if (var1.m_2068()
         && var1.m_3295() instanceof GameMessageS2CPacket var2
         && (var2.content().toString().contains(f_12133) || var2.content().toString().contains(f_12134))) {
         this.f_12126++;
      }
   }
}
