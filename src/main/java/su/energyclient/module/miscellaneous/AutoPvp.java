package su.energyclient.module.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util125;
import su.energyclient.util.Util152;
import su.energyclient.util.Util170;

public class AutoPvp extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_2764 = "!all /pvp z4 ezz";
   private static final Pattern f_2765 = Pattern.compile(AutoPvp.f_2841);
   private static final String f_2766 = "";
   private static final String f_2767 = "";
   private static final long O = 0L;
   private static final long f_2768 = 0L;
   private static final long f_2769 = 0L;
   private static final long f_2770 = 0L;
   private static final long f_2771 = 0L;
   private final BooleanSetting f_2772;
   private final NumberSetting f_2773;
   private AutoPvp.Akg42qjw5KuKzo6P f_2774;
   private final Util125 f_2775;
   private final Util125 f_2776;
   private final Util125 f_2777;
   private final Util125 f_2778;
   private long f_2779;
   private final List<String> f_2780;
   private int f_2781;
   private String f_2782;
   private String f_2783;
   private int f_2784;
   private static final String f_2785 = "Auto PVP";
   private static final String f_2786 = "Авто-PVP для ReallyWorld: реклама, вход в /pvp, скан invsee и выбор соперника";
   private static final String f_2787 = "Смотреть invsee";
   private static final String f_2788 = "Мин. ценность инвентаря";
   private static final float f_2789 = 3.0F;
   private static final float f_2790 = 4.0F;
   private static final long f_2791 = 30000L;
   private static final String f_2792 = "!all /pvp z4 ezz";
   private static final long f_2793 = 350L;
   private static final String f_2794 = "/pvp";
   private static final String f_2795 = "Auto PVP: вход в /pvp не открылся, повтор (%d/2)...";
   private static final String f_2796 = "вход в /pvp не открылся";
   private static final long f_2797 = 6000L;
   private static final long f_2798 = 350L;
   private static final String f_2799 = "Auto PVP: вход открыт, ищу %s в списке...";
   private static final long f_2800 = 350L;
   private static final String f_2801 = "/pvp";
   private static final String f_2802 = "список игроков не открылся";
   private static final long f_2803 = 6000L;
   private static final long f_2804 = 350L;
   private static final String f_2805 = "начать pvp";
   private static final String f_2806 = "Protected";
   private static final String f_2807 = "Auto PVP: в очереди (%d игроков), реклама отправлена.";
   private static final long f_2808 = 30000L;
   private static final String f_2809 = "Auto PVP: игроков в списке нет, перезапуск.";
   private static final long f_2810 = 6000L;
   private static final String f_2811 = "Auto PVP: найдено %d игроков, проверяю invsee...";
   private static final String f_2812 = "Auto PVP: ни у кого нет годного инвентаря, перезапуск.";
   private static final long f_2813 = 6000L;
   private static final long f_2814 = 350L;
   private static final String f_2815 = "Auto PVP: invsee %s не открылся, дальше.";
   private static final long f_2816 = 350L;
   private static final String f_2817 = "Auto PVP: у %s годный инвентарь (%d/4) — захожу за ним на /pvp.";
   private static final String f_2818 = "Auto PVP: у %s слабый инвентарь (%d/4), дальше.";
   private static final String f_2819 = "Auto PVP: список для боя не открылся, повтор (%d/2)...";
   private static final String f_2820 = "список для боя не открылся";
   private static final long f_2821 = 6000L;
   private static final long f_2822 = 350L;
   private static final String f_2823 = "Auto PVP: %s уже не в списке, перезапуск.";
   private static final long f_2824 = 6000L;
   private static final String f_2825 = "Auto PVP: выбран %s — тпаюсь, погнали пэхаться! Модуль выключен.";
   private static final String f_2826 = "войти";
   private static final String f_2827 = "войти";
   private static final String f_2828 = "начать pvp";
   private static final String f_2829 = "начать pvp";
   private static final String f_2830 = "незерит";
   private static final String f_2831 = "меч";
   private static final String f_2832 = "топор";
   private static final String f_2833 = "яблоко";
   private static final String f_2834 = "тотем";
   private static final String f_2835 = "чарка";
   private static final String f_2836 = "жемчуг";
   private static final String f_2837 = "перл";
   private static final String f_2838 = "§";
   private static final long f_2839 = 6000L;
   private static final String f_2840 = "Auto PVP: %s, перезапуск.";
   private static final String f_2841 = "[A-Za-z0-9_]{3,16}";

   private void m_1313() {
      if (this.f_2775.m_2636(f_2793)) {
         this.m_2114(f_2794);
         this.m_57(AutoPvp.Akg42qjw5KuKzo6P.WAIT_ENTRY);
      }
   }

   private void m_57(AutoPvp.Akg42qjw5KuKzo6P var1) {
      this.f_2774 = var1;
      this.f_2776.m_3493();
      this.f_2775.m_3493();
   }

   private boolean m_534(String var1) {
      return f_5909.getSession() != null && var1.equalsIgnoreCase(f_5909.getSession().getUsername())
         ? true
         : f_5909.player != null && var1.equalsIgnoreCase(f_5909.player.getGameProfile().name());
   }

   @Override
   public void m_1() {
      this.m_3027();
      this.f_2774 = AutoPvp.Akg42qjw5KuKzo6P.IDLE;
      super.m_1();
   }

   private boolean m_3125(ItemStack var1, String var2) {
      LoreComponent var3 = (LoreComponent)var1.get(DataComponentTypes.LORE);
      if (var3 == null) {
         return false;
      } else {
         for (Text var5 : var3.lines()) {
            if (this.m_2218(var5.getString()).contains(var2)) {
               return true;
            }
         }

         return false;
      }
   }

   private boolean m_3668() {
      return this.f_2776.m_2636(f_2839);
   }

   private String m_2218(String var1) {
      if (var1 == null) {
         return "";
      } else {
         String var2 = Formatting.strip(var1);
         if (var2 == null) {
            var2 = var1;
         }

         return var2.replace(f_2838, "").toLowerCase(Locale.ROOT).trim();
      }
   }

   @Override
   public void m_2() {
      super.m_2();
      this.m_3027();
      this.f_2779 = 0L;
      this.f_2777.m_3493();
      this.f_2778.m_1528(0L);
      this.m_57(AutoPvp.Akg42qjw5KuKzo6P.IDLE);
   }

   private void m_467(GenericContainerScreenHandler var1) {
      if (this.m_3668()) {
         Util152.m_662(f_2815, this.f_2782);
         this.f_2781++;
         this.m_57(AutoPvp.Akg42qjw5KuKzo6P.INVSEE_NEXT);
      } else if (var1 != null && !this.m_464(var1) && !this.m_2040(var1)) {
         if (this.f_2775.m_2636(f_2816)) {
            int var2 = this.m_491(var1);
            if (var2 >= this.f_2773.m_4046()) {
               this.f_2783 = this.f_2782;
               this.f_2784 = 0;
               Util152.m_662(f_2817, this.f_2782, var2);
               this.m_3259();
               this.m_57(AutoPvp.Akg42qjw5KuKzo6P.FIGHT_OPEN);
            } else {
               Util152.m_662(f_2818, this.f_2782, var2);
               this.f_2781++;
               this.m_3259();
               this.m_57(AutoPvp.Akg42qjw5KuKzo6P.INVSEE_NEXT);
            }
         }
      }
   }

   private int m_491(GenericContainerScreenHandler var1) {
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      int var6 = var1.getRows() * 9;

      for (int var7 = 0; var7 < var6; var7++) {
         ItemStack var8 = ((Slot)var1.slots.get(var7)).getStack();
         if (var8 != null && !var8.isEmpty()) {
            String var9 = this.m_2218(this.m_174(var8));
            if (var8.isOf(Items.NETHERITE_SWORD) || var8.isOf(Items.NETHERITE_AXE) || var9.contains(f_2830) && (var9.contains(f_2831) || var9.contains(f_2832))
               )
             {
               var2 = true;
            }

            if (var8.isOf(Items.GOLDEN_APPLE) || var8.isOf(Items.ENCHANTED_GOLDEN_APPLE) || var9.contains(f_2833)) {
               var3 = true;
            }

            if (var8.isOf(Items.TOTEM_OF_UNDYING) || var9.contains(f_2834)) {
               var4 = true;
            }

            if (var8.isOf(Items.ENDER_PEARL) || var9.contains(f_2835) || var9.contains(f_2836) || var9.contains(f_2837)) {
               var5 = true;
            }
         }
      }

      int var10 = 0;
      if (var2) {
         var10++;
      }

      if (var3) {
         var10++;
      }

      if (var4) {
         var10++;
      }

      if (var5) {
         var10++;
      }

      return var10;
   }

   private int m_2833(GenericContainerScreenHandler var1, String var2) {
      int var3 = var1.getRows() * 9;

      for (int var4 = 0; var4 < var3; var4++) {
         ItemStack var5 = ((Slot)var1.slots.get(var4)).getStack();
         if (var5 != null && !var5.isEmpty() && this.m_3125(var5, f_2829) && this.m_572(this.m_174(var5)).equalsIgnoreCase(var2)) {
            return var4;
         }
      }

      return -1;
   }

   private boolean m_2040(GenericContainerScreenHandler var1) {
      int var2 = var1.getRows() * 9;

      for (int var3 = 0; var3 < var2; var3++) {
         ItemStack var4 = ((Slot)var1.slots.get(var3)).getStack();
         if (var4 != null && !var4.isEmpty() && var4.isOf(Items.DIAMOND_SWORD) && this.m_3125(var4, f_2826)) {
            return true;
         }
      }

      return false;
   }

   @EventHandler
   private void m_2962(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null && f_5909.player.networkHandler != null) {
         GenericContainerScreenHandler var2 = this.m_3556();
         switch (this.f_2774) {
            case IDLE:
               this.m_2134();
               break;
            case ADVERTISED:
               this.m_1313();
               break;
            case WAIT_ENTRY:
               this.m_1979(var2, false);
               break;
            case WAIT_LIST:
               this.m_2036(var2);
               break;
            case INVSEE_NEXT:
               this.m_848();
               break;
            case WAIT_INVSEE:
               this.m_467(var2);
               break;
            case FIGHT_OPEN:
               this.m_2072();
               break;
            case FIGHT_ENTRY:
               this.m_1979(var2, true);
               break;
            case FIGHT_LIST:
               this.m_4124(var2);
         }
      }
   }

   private void m_2134() {
      if (this.f_2777.m_2636(this.f_2779)) {
         if (this.f_2778.m_2636(f_2791)) {
            this.m_2114(f_2792);
            this.f_2778.m_3493();
         }

         this.m_57(AutoPvp.Akg42qjw5KuKzo6P.ADVERTISED);
      }
   }

   private void m_848() {
      if (this.f_2781 >= this.f_2780.size()) {
         Util152.m_662(f_2812);
         this.m_2203(f_2813);
      } else if (this.f_2775.m_2636(f_2814)) {
         this.m_3259();
         this.f_2782 = this.f_2780.get(this.f_2781);
         this.m_2114("/invsee " + this.f_2782);
         this.m_57(AutoPvp.Akg42qjw5KuKzo6P.WAIT_INVSEE);
      }
   }

   private void m_2114(String var1) {
      f_5909.player.networkHandler.sendChatMessage(var1);
      this.f_2775.m_3493();
   }

   private void m_2203(long var1) {
      this.m_3027();
      this.f_2779 = var1;
      this.f_2777.m_3493();
      this.m_57(AutoPvp.Akg42qjw5KuKzo6P.IDLE);
   }

   private void m_2072() {
      if (this.f_2775.m_2636(f_2800)) {
         this.m_2114(f_2801);
         this.m_57(AutoPvp.Akg42qjw5KuKzo6P.FIGHT_ENTRY);
      }
   }

   private void m_1979(GenericContainerScreenHandler var1, boolean var2) {
      if (!this.m_3668()) {
         if (var1 != null) {
            int var3 = this.m_2027(var1);
            if (var3 != -1) {
               if (this.f_2775.m_2636(f_2798)) {
                  this.m_1725(var1, var3);
                  if (var2) {
                     Util152.m_662(f_2799, this.f_2783);
                  }

                  this.m_57(var2 ? AutoPvp.Akg42qjw5KuKzo6P.FIGHT_LIST : AutoPvp.Akg42qjw5KuKzo6P.WAIT_LIST);
               }
            }
         }
      } else {
         if (var2 && this.f_2784 < 2) {
            this.f_2784++;
            Util152.m_662(f_2795, this.f_2784);
            this.m_57(AutoPvp.Akg42qjw5KuKzo6P.FIGHT_OPEN);
         } else {
            this.m_1430(f_2796, f_2797);
         }
      }
   }

   private void m_2036(GenericContainerScreenHandler var1) {
      if (this.m_3668()) {
         this.m_1430(f_2802, f_2803);
      } else if (var1 != null && this.m_464(var1)) {
         if (this.f_2775.m_2636(f_2804)) {
            this.f_2780.clear();
            this.f_2781 = 0;
            int var2 = var1.getRows() * 9;

            for (int var3 = 0; var3 < var2; var3++) {
               ItemStack var4 = ((Slot)var1.slots.get(var3)).getStack();
               if (var4 != null && !var4.isEmpty() && this.m_3125(var4, f_2805)) {
                  String var5 = this.m_572(this.m_174(var4));
                  if (!var5.isEmpty() && !this.m_534(var5) && !var5.equalsIgnoreCase(f_2806) && !this.f_2780.contains(var5)) {
                     this.f_2780.add(var5);
                  }
               }
            }

            if (!this.f_2772.m_1163()) {
               Util152.m_662(f_2807, this.f_2780.size());
               this.m_3259();
               this.m_2203(f_2808);
            } else if (this.f_2780.isEmpty()) {
               Util152.m_662(f_2809);
               this.m_3259();
               this.m_2203(f_2810);
            } else {
               Util152.m_662(f_2811, this.f_2780.size());
               this.m_57(AutoPvp.Akg42qjw5KuKzo6P.INVSEE_NEXT);
            }
         }
      }
   }

   private void m_3027() {
      this.f_2780.clear();
      this.f_2781 = 0;
      this.f_2782 = "";
      this.f_2783 = "";
      this.f_2784 = 0;
   }

   private GenericContainerScreenHandler m_3556() {
      return f_5909.currentScreen instanceof HandledScreen var1 && var1.getScreenHandler() instanceof GenericContainerScreenHandler var2 ? var2 : null;
   }

   private void m_4124(GenericContainerScreenHandler var1) {
      if (this.m_3668()) {
         if (this.f_2784 < 2) {
            this.f_2784++;
            Util152.m_662(f_2819, this.f_2784);
            this.m_57(AutoPvp.Akg42qjw5KuKzo6P.FIGHT_OPEN);
         } else {
            this.m_1430(f_2820, f_2821);
         }
      } else if (var1 != null && this.m_464(var1)) {
         if (this.f_2775.m_2636(f_2822)) {
            int var2 = this.m_2833(var1, this.f_2783);
            if (var2 == -1) {
               Util152.m_662(f_2823, this.f_2783);
               this.m_3259();
               this.m_2203(f_2824);
            } else {
               this.m_1725(var1, var2);
               Util152.m_662(f_2825, this.f_2783);
               this.m_3027();
               this.f_2774 = AutoPvp.Akg42qjw5KuKzo6P.IDLE;
               this.m_680();
            }
         }
      }
   }

   private String m_572(String var1) {
      Matcher var2 = f_2765.matcher(var1);
      String var3 = "";

      while (var2.find()) {
         var3 = var2.group();
      }

      return var3;
   }

   private String m_174(ItemStack var1) {
      String var2 = Formatting.strip(var1.getName().getString());
      return var2 == null ? "" : var2.trim();
   }

   public AutoPvp() {
      super(f_2785, f_2786, Category.MISCELLANEOUS);
      this.f_2772 = new BooleanSetting(f_2787, true);
      this.f_2773 = new NumberSetting(f_2788, f_2789, 1.0F, f_2790, 1.0F).m_356(this.f_2772::m_1163);
      this.f_2774 = AutoPvp.Akg42qjw5KuKzo6P.IDLE;
      this.f_2775 = new Util125();
      this.f_2776 = new Util125();
      this.f_2777 = new Util125();
      this.f_2778 = new Util125();
      this.f_2779 = 0L;
      this.f_2780 = new ArrayList<>();
      this.f_2781 = 0;
      this.f_2782 = "";
      this.f_2783 = "";
      this.f_2784 = 0;
   }

   private boolean m_464(GenericContainerScreenHandler var1) {
      int var2 = var1.getRows() * 9;

      for (int var3 = 0; var3 < var2; var3++) {
         ItemStack var4 = ((Slot)var1.slots.get(var3)).getStack();
         if (var4 != null && !var4.isEmpty() && this.m_3125(var4, f_2828)) {
            return true;
         }
      }

      return false;
   }

   private int m_2027(GenericContainerScreenHandler var1) {
      int var2 = var1.getRows() * 9;
      int var3 = -1;

      for (int var4 = 0; var4 < var2; var4++) {
         ItemStack var5 = ((Slot)var1.slots.get(var4)).getStack();
         if (var5 != null && !var5.isEmpty() && var5.isOf(Items.DIAMOND_SWORD)) {
            if (this.m_3125(var5, f_2827)) {
               return var4;
            }

            if (var3 == -1) {
               var3 = var4;
            }
         }
      }

      return var3;
   }

   private void m_1725(GenericContainerScreenHandler var1, int var2) {
      f_5909.interactionManager.clickSlot(var1.syncId, var2, 0, SlotActionType.PICKUP, f_5909.player);
      this.f_2775.m_3493();
   }

   private void m_3259() {
      if (f_5909.player != null) {
         if (f_5909.currentScreen instanceof HandledScreen) {
            f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(f_5909.player.currentScreenHandler.syncId));
            f_5909.setScreen(null);
         }
      }
   }

   private void m_1430(String var1, long var2) {
      Util152.m_662(f_2840, var1);
      this.m_2203(var2);
   }

   private static enum Akg42qjw5KuKzo6P {
      IDLE,
      ADVERTISED,
      WAIT_ENTRY,
      WAIT_LIST,
      INVSEE_NEXT,
      WAIT_INVSEE,
      FIGHT_OPEN,
      FIGHT_ENTRY,
      FIGHT_LIST;
   }
}
