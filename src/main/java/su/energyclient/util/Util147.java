package su.energyclient.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardEntry;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.Team;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import su.energyclient.QuickImports;

public class Util147 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Pattern f_11521 = Pattern.compile(Util147.f_11742);
   private static final Pattern f_11522 = Pattern.compile(Util147.f_11743);
   private static final String f_11523 = "обновить аукцион";
   private static final String f_11524 = "";
   private static final String f_11525 = "";
   private static final String f_11526 = "";
   private static final String f_11527 = "";
   private static final String f_11528 = "";
   private static final String f_11529 = "";
   private static final String f_11530 = "";
   private static final String f_11531 = "";
   private final List<Util147.qkA6Y4JkO2xPSL6l> f_11532 = new ArrayList<>();
   private final Util125 f_11533 = new Util125();
   private final Util125 f_11534 = new Util125();
   private final Util125 f_11535 = new Util125();
   private final Util125 f_11536 = new Util125();
   private final Util125 f_11537 = new Util125();
   private long f_11538;
   private long f_11539;
   private boolean f_11540;
   private int f_11541;
   private Util147.qkA6Y4JkO2xPSL6l f_11542;
   private Text f_11543;
   private Text l;
   private int f_11544;
   private final Map<String, Long> f_11545;
   private String f_11546;
   private String f_11547;
   private static final int f_11548 = 0;
   private static final int f_11549 = 0;
   private static final int f_11550 = 0;
   private static final int f_11551 = 0;
   private static final int f_11552 = 0;
   private static final int f_11553 = 0;
   private int f_11554;
   private List<Util147.qkA6Y4JkO2xPSL6l> f_11555;
   private int f_11556;
   private long f_11557;
   private final List<String> f_11558;
   private long f_11559;
   private boolean f_11560;
   private int f_11561;
   private static final long f_11562 = 1400L;
   private static final long f_11563 = -1L;
   private static final String f_11564 = "-";
   private static final String f_11565 = "-";
   private static final long f_11566 = Long.MAX_VALUE;
   private static final String f_11567 = "TEST | AutoBuy telegram binding is working";
   private static final long f_11568 = -1L;
   private static final String f_11569 = "-";
   private static final String f_11570 = "-";
   private static final long f_11571 = 60L;
   private static final long f_11572 = 1000L;
   private static final long f_11573 = 185L;
   private static final String f_11574 = "AutoBuy: buying ";
   private static final String f_11575 = "обновить аукцион";
   private static final String f_11576 = "refresh auction";
   private static final long f_11577 = Long.MAX_VALUE;
   private static final long f_11578 = 2600L;
   private static final long f_11579 = Long.MAX_VALUE;
   private static final double f_11580 = 100.0;
   private static final long f_11581 = 1800L;
   private static final String f_11582 = "/ah";
   private static final long f_11583 = Long.MAX_VALUE;
   private static final String f_11584 = "Parsed prices for selected items:";
   private static final String f_11585 = "\n";
   private static final long f_11586 = Long.MAX_VALUE;
   private static final String f_11587 = "обновить аукцион";
   private static final String f_11588 = "купить";
   private static final String f_11589 = " ";
   private static final long f_11590 = 1700L;
   private static final String f_11591 = "/ah";
   private static final String f_11592 = "купить";
   private static final String f_11593 = "buy";
   private static final long f_11594 = 170L;
   private static final String f_11595 = "аукцион";
   private static final String f_11596 = "auction";
   private static final String f_11597 = "обновить аукцион";
   private static final String f_11598 = "refresh auction";
   private static final String f_11599 = "обновить аукцион";
   private static final String f_11600 = "купить";
   private static final String f_11601 = " ";
   private static final String f_11602 = "цена за 1";
   private static final String f_11603 = "price per 1";
   private static final String f_11604 = "[ \\t]";
   private static final long f_11605 = -1L;
   private static final String f_11606 = "монеток";
   private static final String f_11607 = "coins";
   private static final long f_11608 = -1L;
   private static final long f_11609 = -1L;
   private static final String f_11610 = " ";
   private static final String f_11611 = ",";
   private static final String f_11612 = ".";
   private static final long f_11613 = -1L;
   private static final long f_11614 = 2600L;
   private static final long f_11615 = 7000L;
   private static final String f_11616 = "energy-autobuy-tg";
   private static final long f_11617 = 1200L;
   private static final long f_11618 = 2001L;
   private static final String f_11619 = "§";
   private static final String f_11620 = "?";
   private static final String f_11621 = "%,d";
   private static final String f_11622 = "Enchanted/Charodey Book";
   private static final String f_11623 = "чародейская книга";
   private static final long f_11624 = 1000000L;
   private static final String f_11625 = "Trident";
   private static final String f_11626 = "трезубец";
   private static final long f_11627 = 5000000L;
   private static final String f_11628 = "Crossbow";
   private static final String f_11629 = "арбалет";
   private static final long f_11630 = 2000000L;
   private static final String f_11631 = "Totem";
   private static final String f_11632 = "тотем";
   private static final long f_11633 = 1500000L;
   private static final String f_11634 = "Golden Apple";
   private static final String f_11635 = "золотое яблоко";
   private static final long f_11636 = 300000L;
   private static final String f_11637 = "Ench. Golden Apple";
   private static final String f_11638 = "зачарованное золотое яблоко";
   private static final long f_11639 = 3000000L;
   private static final String f_11640 = "Diamond Sword";
   private static final String f_11641 = "алмазный меч";
   private static final long f_11642 = 3000000L;
   private static final String f_11643 = "Diamond Pickaxe";
   private static final String f_11644 = "алмазная кирка";
   private static final long f_11645 = 3000000L;
   private static final String f_11646 = "Diamond Axe";
   private static final String f_11647 = "алмазный топор";
   private static final long f_11648 = 3000000L;
   private static final String f_11649 = "Diamond Shovel";
   private static final String f_11650 = "алмазная лопата";
   private static final long f_11651 = 1500000L;
   private static final String f_11652 = "Diamond Hoe";
   private static final String f_11653 = "алмазная мотыга";
   private static final long f_11654 = 1500000L;
   private static final String f_11655 = "Diamond Helmet";
   private static final String f_11656 = "алмазный шлем";
   private static final long f_11657 = 2500000L;
   private static final String f_11658 = "Diamond Chestplate";
   private static final String f_11659 = "алмазный нагрудник";
   private static final long f_11660 = 4000000L;
   private static final String f_11661 = "Diamond Leggings";
   private static final String f_11662 = "алмазные поножи";
   private static final long f_11663 = 3500000L;
   private static final String f_11664 = "Diamond Boots";
   private static final String f_11665 = "алмазные ботинки";
   private static final long f_11666 = 2500000L;
   private static final String f_11667 = "Netherite Sword";
   private static final String f_11668 = "незеритовый меч";
   private static final long f_11669 = 5000000L;
   private static final String f_11670 = "Netherite Pickaxe";
   private static final String f_11671 = "незеритовая кирка";
   private static final long f_11672 = 5000000L;
   private static final String f_11673 = "Netherite Axe";
   private static final String f_11674 = "незеритовый топор";
   private static final long f_11675 = 5000000L;
   private static final String f_11676 = "Netherite Shovel";
   private static final String f_11677 = "незеритовая лопата";
   private static final long f_11678 = 3000000L;
   private static final String f_11679 = "Netherite Hoe";
   private static final String f_11680 = "незеритовая мотыга";
   private static final long f_11681 = 3000000L;
   private static final String f_11682 = "Netherite Helmet";
   private static final String f_11683 = "незеритовый шлем";
   private static final long f_11684 = 4500000L;
   private static final String f_11685 = "Netherite Chestplate";
   private static final String f_11686 = "незеритовый нагрудник";
   private static final long f_11687 = 7000000L;
   private static final String f_11688 = "Netherite Leggings";
   private static final String f_11689 = "незеритовые поножи";
   private static final long f_11690 = 6000000L;
   private static final String f_11691 = "Netherite Boots";
   private static final String f_11692 = "незеритовые ботинки";
   private static final long f_11693 = 4500000L;
   private static final String f_11694 = "Sphere: Cerberus";
   private static final String f_11695 = "сфера цербера";
   private static final long f_11696 = 10000000L;
   private static final String f_11697 = "Sphere: Legendary";
   private static final String f_11698 = "легендарная сфера";
   private static final long f_11699 = 10000000L;
   private static final String f_11700 = "Sphere: Flash";
   private static final String f_11701 = "сфера флеша";
   private static final long f_11702 = 8000000L;
   private static final String f_11703 = "Sphere: Mythical";
   private static final String f_11704 = "мифическая сфера";
   private static final long f_11705 = 12000000L;
   private static final String f_11706 = "Talisman: Eternity";
   private static final String f_11707 = "талисман eternity";
   private static final long f_11708 = 12000000L;
   private static final String f_11709 = "Talisman: Infinity";
   private static final String f_11710 = "талисман infinity";
   private static final long f_11711 = 12000000L;
   private static final String f_11712 = "Talisman: Stinger";
   private static final String f_11713 = "талисман stinger";
   private static final long f_11714 = 12000000L;
   private static final String f_11715 = "талисман stinger";
   private static final String f_11716 = "stinger";
   private static final String f_11717 = "талисман infinity";
   private static final String f_11718 = "infinity";
   private static final String f_11719 = "талисман eternity";
   private static final String f_11720 = "урон ii";
   private static final String f_11721 = "броня ii";
   private static final String f_11722 = "скорость ii";
   private static final String f_11723 = "мифическая сфера";
   private static final String f_11724 = "урон iii";
   private static final String f_11725 = "броня ii";
   private static final String f_11726 = "сфера флеша";
   private static final String f_11727 = "скорость ii";
   private static final String f_11728 = "броня i";
   private static final String f_11729 = "легендарная сфера";
   private static final String f_11730 = "скорость атаки ii";
   private static final String f_11731 = "шанс здоровья ii";
   private static final String f_11732 = "сфера цербера";
   private static final String f_11733 = "спешка i";
   private static final String f_11734 = "урон v";
   private static final String f_11735 = "чародейск";
   private static final String f_11736 = "книг";
   private static final String f_11737 = "зачар";
   private static final String f_11738 = "книг";
   private static final String f_11739 = "чародейск";
   private static final String f_11740 = "книг";
   private static final String f_11741 = "GET";
   private static final String f_11742 = "\\d[\\d\\s]*";
   private static final String f_11743 = "(\\d[\\d\\s,.]*)";

   private Util147.qkA6Y4JkO2xPSL6l m_2389(ItemStack var1, String var2) {
      for (Util147.qkA6Y4JkO2xPSL6l var4 : this.f_11532) {
         if (var4.f_1760 && var4.f_1762.m_3103(var1, var2)) {
            return var4;
         }
      }

      return null;
   }

   private List<String> m_1925(ItemStack var1) {
      LoreComponent var2 = (LoreComponent)var1.get(DataComponentTypes.LORE);
      if (var2 != null && !var2.lines().isEmpty()) {
         ArrayList var3 = new ArrayList();

         for (Text var5 : var2.lines()) {
            var3.add(this.m_2402(var5.getString()));
         }

         return var3;
      } else {
         return this.m_1499(var1);
      }
   }

   public void m_2768(String var1) {
      this.f_11546 = var1 == null ? "" : var1.trim();
   }

   public void m_3665() {
      this.f_11539 = f_11568;
      this.f_11540 = false;
      this.f_11541 = -1;
      this.f_11542 = null;
      this.f_11543 = Text.literal(f_11569);
      this.l = Text.literal(f_11570);
      this.f_11544 = 0;
      this.f_11545.clear();
      this.f_11554 = 0;
      this.f_11560 = false;
      this.f_11555 = new ArrayList<>();
      this.f_11558.clear();
   }

   public boolean m_484(HandledScreen<?> var1) {
      String var2 = this.m_2402(var1.getTitle().getString());
      if (!var2.contains(f_11595) && !var2.contains(f_11596)) {
         ScreenHandler var3 = f_5909.player.currentScreenHandler;
         return var3 != null && this.m_4041(var3, f_11597, f_11598) != -1;
      } else {
         return true;
      }
   }

   private void m_1735() {
      this.f_11532
         .add(
            new Util147.qkA6Y4JkO2xPSL6l(
               f_11622,
               Items.ENCHANTED_BOOK,
               f_11623,
               false,
               f_11624,
               (var1, var2) -> {
                  String var3 = this.m_2402(var1.getName().getString());
                  return var1.isOf(Items.ENCHANTED_BOOK)
                     || var3.contains(f_11735) && var3.contains(f_11736)
                     || var3.contains(f_11737) && var3.contains(f_11738)
                     || var2.contains(f_11739) && var2.contains(f_11740);
               }
            )
         );
      this.m_2845(f_11625, f_11626, f_11627, Items.TRIDENT);
      this.m_2845(f_11628, f_11629, f_11630, Items.CROSSBOW);
      this.m_2845(f_11631, f_11632, f_11633, Items.TOTEM_OF_UNDYING);
      this.m_2845(f_11634, f_11635, f_11636, Items.GOLDEN_APPLE);
      this.m_2845(f_11637, f_11638, f_11639, Items.ENCHANTED_GOLDEN_APPLE);
      this.m_2845(f_11640, f_11641, f_11642, Items.DIAMOND_SWORD);
      this.m_2845(f_11643, f_11644, f_11645, Items.DIAMOND_PICKAXE);
      this.m_2845(f_11646, f_11647, f_11648, Items.DIAMOND_AXE);
      this.m_2845(f_11649, f_11650, f_11651, Items.DIAMOND_SHOVEL);
      this.m_2845(f_11652, f_11653, f_11654, Items.DIAMOND_HOE);
      this.m_2845(f_11655, f_11656, f_11657, Items.DIAMOND_HELMET);
      this.m_2845(f_11658, f_11659, f_11660, Items.DIAMOND_CHESTPLATE);
      this.m_2845(f_11661, f_11662, f_11663, Items.DIAMOND_LEGGINGS);
      this.m_2845(f_11664, f_11665, f_11666, Items.DIAMOND_BOOTS);
      this.m_2845(f_11667, f_11668, f_11669, Items.NETHERITE_SWORD);
      this.m_2845(f_11670, f_11671, f_11672, Items.NETHERITE_PICKAXE);
      this.m_2845(f_11673, f_11674, f_11675, Items.NETHERITE_AXE);
      this.m_2845(f_11676, f_11677, f_11678, Items.NETHERITE_SHOVEL);
      this.m_2845(f_11679, f_11680, f_11681, Items.NETHERITE_HOE);
      this.m_2845(f_11682, f_11683, f_11684, Items.NETHERITE_HELMET);
      this.m_2845(f_11685, f_11686, f_11687, Items.NETHERITE_CHESTPLATE);
      this.m_2845(f_11688, f_11689, f_11690, Items.NETHERITE_LEGGINGS);
      this.m_2845(f_11691, f_11692, f_11693, Items.NETHERITE_BOOTS);
      this.f_11532
         .add(
            new Util147.qkA6Y4JkO2xPSL6l(
               f_11694, Items.PLAYER_HEAD, f_11695, false, f_11696, (var0, var1) -> var1.contains(f_11732) || var1.contains(f_11733) && var1.contains(f_11734)
            )
         );
      this.f_11532
         .add(
            new Util147.qkA6Y4JkO2xPSL6l(
               f_11697, Items.PLAYER_HEAD, f_11698, false, f_11699, (var0, var1) -> var1.contains(f_11729) || var1.contains(f_11730) && var1.contains(f_11731)
            )
         );
      this.f_11532
         .add(
            new Util147.qkA6Y4JkO2xPSL6l(
               f_11700, Items.PLAYER_HEAD, f_11701, false, f_11702, (var0, var1) -> var1.contains(f_11726) || var1.contains(f_11727) && var1.contains(f_11728)
            )
         );
      this.f_11532
         .add(
            new Util147.qkA6Y4JkO2xPSL6l(
               f_11703, Items.PLAYER_HEAD, f_11704, false, f_11705, (var0, var1) -> var1.contains(f_11723) || var1.contains(f_11724) && var1.contains(f_11725)
            )
         );
      this.f_11532
         .add(
            new Util147.qkA6Y4JkO2xPSL6l(
               f_11706,
               Items.PLAYER_HEAD,
               f_11707,
               false,
               f_11708,
               (var0, var1) -> var1.contains(f_11719) || var1.contains(f_11720) && var1.contains(f_11721) && var1.contains(f_11722)
            )
         );
      this.f_11532
         .add(
            new Util147.qkA6Y4JkO2xPSL6l(f_11709, Items.PLAYER_HEAD, f_11710, false, f_11711, (var0, var1) -> var1.contains(f_11717) || var1.contains(f_11718))
         );
      this.f_11532
         .add(
            new Util147.qkA6Y4JkO2xPSL6l(f_11712, Items.PLAYER_HEAD, f_11713, false, f_11714, (var0, var1) -> var1.contains(f_11715) || var1.contains(f_11716))
         );
   }

   public boolean m_3351() {
      return this.f_11554 != 0;
   }

   public void m_201(int var1, boolean var2, boolean var3, int var4) {
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
         this.f_11539 = this.m_2023();
         long var5 = Math.max(1, Math.min(10, var4)) * f_11571 * f_11572;
         if (this.f_11540 && this.f_11554 == 0) {
            if (var2 && !this.f_11560) {
               this.m_3707(var1);
               this.f_11560 = true;
            } else if (var3 && this.f_11559 > 0L && System.currentTimeMillis() - this.f_11559 >= var5) {
               this.m_3707(var1);
            }
         }

         if (!this.f_11540) {
            this.f_11560 = false;
         }

         if (this.f_11554 != 0) {
            this.m_3280();
         } else if (this.f_11540) {
            if (f_5909.currentScreen instanceof HandledScreen var7) {
               if (!this.m_2687()) {
                  if (this.m_484(var7)) {
                     ScreenHandler var11 = f_5909.player.currentScreenHandler;
                     if (var11 != null && var11.slots != null && !var11.slots.isEmpty()) {
                        this.m_3058();
                        Util147.CN3wr06ILqGrGQMy var9 = this.m_757(var11);
                        if (var9 != null && this.f_11533.m_522(f_11573, true)) {
                           this.m_2489(var11, var9.slotId, var9.mouseButton);
                           this.l = var9.displayName.copy();
                           Util152.m_662(Text.literal(f_11574).append(var9.displayName.copy()));
                           this.m_1437("BUY | " + var9.displayName.getString() + " | price: " + this.m_876(var9.price));
                        } else {
                           if (this.f_11534.m_522(this.f_11538, true)) {
                              int var10 = this.m_4041(var11, f_11575, f_11576);
                              if (var10 != -1) {
                                 this.m_2489(var11, var10, 0);
                              }

                              this.m_2371();
                           }
                        }
                     }
                  }
               }
            } else {
               this.m_3877();
            }
         }
      }
   }

   public boolean m_819() {
      return !this.f_11546.isBlank() && !this.f_11547.isBlank();
   }

   public void m_2663() {
      this.f_11540 = !this.f_11540;
   }

   private String m_876(long var1) {
      return var1 < 0L ? f_11620 : String.format(Locale.US, f_11621, var1);
   }

   private List<Util147.qkA6Y4JkO2xPSL6l> m_122() {
      ArrayList var1 = new ArrayList();

      for (Util147.qkA6Y4JkO2xPSL6l var3 : this.f_11532) {
         if (var3.f_1760 && var3.f_1759 != null && !var3.f_1759.isBlank()) {
            var1.add(var3);
         }
      }

      return var1;
   }

   private Util147.CN3wr06ILqGrGQMy m_757(ScreenHandler var1) {
      Util147.CN3wr06ILqGrGQMy var2 = null;
      int var3 = this.m_1244(var1);

      for (int var4 = 0; var4 < var3; var4++) {
         Slot var5 = (Slot)var1.slots.get(var4);
         ItemStack var6 = var5.getStack();
         if (var6 != null && !var6.isEmpty()) {
            String var7 = this.m_2402(var6.getName().getString());
            if (!var7.contains(f_11599) && !var7.contains(f_11600)) {
               List var8 = this.m_1499(var6);
               String var9 = String.join(f_11601, var8);
               Util147.qkA6Y4JkO2xPSL6l var10 = this.m_2389(var6, var9);
               if (var10 != null && var10.f_1760 && (this.f_11542 == null || var10 == this.f_11542)) {
                  List var11 = this.m_1925(var6);
                  Util147.RuGq4zVDSDonWCIw var12 = this.m_1395(var11);
                  if (var12 != null && var12.price >= 0L) {
                     if (!this.m_2814(var12.price, var10.f_1761)) {
                        this.m_2981(var6.getName().getString(), "price " + this.m_876(var12.price) + " > limit rule");
                     } else if (this.f_11539 > 0L && var12.price > this.f_11539) {
                        this.m_2981(var6.getName().getString(), "not enough coins " + this.m_876(this.f_11539));
                     } else if (var2 == null || var12.price < var2.price) {
                        int var13 = var12.perUnit ? 1 : 0;
                        var2 = new Util147.CN3wr06ILqGrGQMy(var5.id, var12.price, var6.getName().copy(), var13);
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public boolean m_3004() {
      return this.f_11540;
   }

   private void m_1437(String var1) {
      if (this.m_819()) {
         String var2 = this.f_11546;
         String var3 = this.f_11547;
         String var4 = "[AutoBuy] " + var1;
         Thread var5 = new Thread(() -> {
            HttpURLConnection var3x = null;

            try {
               String var4x = URLEncoder.encode(var4, StandardCharsets.UTF_8);
               String var5x = URLEncoder.encode(var3, StandardCharsets.UTF_8);
               String var6 = "https://api.telegram.org/bot" + var2 + "/sendMessage?chat_id=" + var5x + "&text=" + var4x;
               var3x = (HttpURLConnection)new URL(var6).openConnection();
               var3x.setRequestMethod(f_11741);
               var3x.setConnectTimeout(3500);
               var3x.setReadTimeout(3500);
               var3x.getResponseCode();
            } catch (Exception var10) {
            } finally {
               if (var3x != null) {
                  var3x.disconnect();
               }
            }
         }, f_11616);
         var5.setDaemon(true);
         var5.start();
      }
   }

   private void m_2981(String var1, String var2) {
      String var3 = var1 + "|" + var2;
      long var4 = System.currentTimeMillis();
      long var6 = this.f_11545.getOrDefault(var3, 0L);
      if (var4 - var6 >= f_11615) {
         this.f_11545.put(var3, var4);
         this.m_1437("SKIP | " + var1 + " | " + var2);
      }
   }

   public void m_3707(int var1) {
      this.f_11555 = this.m_122();
      if (this.f_11555.isEmpty()) {
         this.f_11554 = 0;
      } else {
         this.f_11561 = Math.max(1, Math.min(100, var1));
         this.f_11556 = 0;
         this.f_11557 = f_11577;
         this.f_11558.clear();
         this.f_11554 = 1;
         this.f_11537.m_3493();
      }
   }

   private String m_2402(String var1) {
      String var2 = Formatting.strip(var1);
      if (var2 == null) {
         var2 = var1;
      }

      return var2.replace(f_11619, "").toLowerCase(Locale.ROOT).trim();
   }

   private void m_3058() {
      List var1 = this.m_122();
      if (var1.isEmpty()) {
         this.f_11542 = null;
         this.f_11541 = -1;
      } else if (this.f_11541 < 0 || this.f_11541 >= var1.size()) {
         this.f_11541 = 0;
         this.f_11542 = (Util147.qkA6Y4JkO2xPSL6l)var1.get(this.f_11541);
         this.m_1529(this.f_11542);
      } else if (this.f_11536.m_522(f_11614, true)) {
         this.f_11541++;
         if (this.f_11541 >= var1.size()) {
            this.f_11541 = 0;
         }

         this.f_11542 = (Util147.qkA6Y4JkO2xPSL6l)var1.get(this.f_11541);
         this.m_1529(this.f_11542);
      }
   }

   public long m_3867() {
      return this.f_11539;
   }

   private long m_3495(ScreenHandler var1, Util147.qkA6Y4JkO2xPSL6l var2) {
      long var3 = f_11586;
      int var5 = this.m_1244(var1);

      for (int var6 = 0; var6 < var5; var6++) {
         Slot var7 = (Slot)var1.slots.get(var6);
         ItemStack var8 = var7.getStack();
         if (var8 != null && !var8.isEmpty()) {
            String var9 = this.m_2402(var8.getName().getString());
            if (!var9.contains(f_11587) && !var9.contains(f_11588)) {
               List var10 = this.m_1499(var8);
               String var11 = String.join(f_11589, var10);
               Util147.qkA6Y4JkO2xPSL6l var12 = this.m_2389(var8, var11);
               if (var12 == var2) {
                  List var13 = this.m_1925(var8);
                  Util147.RuGq4zVDSDonWCIw var14 = this.m_1395(var13);
                  if (var14 != null && var14.price > 0L && var14.perUnit && var14.price < var3) {
                     var3 = var14.price;
                  }
               }
            }
         }
      }

      return var3;
   }

   private void m_3877() {
      if (this.f_11535.m_522(f_11590, true)) {
         f_5909.player.networkHandler.sendChatMessage(f_11591);
      }
   }

   private static Long m_258(String var0) {
      if (var0 == null) {
         return null;
      } else {
         Matcher var1 = f_11521.matcher(var0);
         Long var2 = null;

         while (var1.find()) {
            String var3 = var1.group().replaceAll(f_11604, "");
            if (!var3.isEmpty()) {
               try {
                  var2 = Long.parseLong(var3);
               } catch (NumberFormatException var5) {
               }
            }
         }

         return var2;
      }
   }

   public String m_1963() {
      return this.f_11546;
   }

   public Text m_1643() {
      return this.f_11543;
   }

   public Util147() {
      this.f_11538 = f_11562;
      this.f_11539 = f_11563;
      this.f_11540 = false;
      this.f_11541 = -1;
      this.f_11543 = Text.literal(f_11564);
      this.l = Text.literal(f_11565);
      this.f_11544 = 0;
      this.f_11545 = new HashMap<>();
      this.f_11546 = "";
      this.f_11547 = "";
      this.f_11554 = 0;
      this.f_11555 = new ArrayList<>();
      this.f_11556 = 0;
      this.f_11557 = f_11566;
      this.f_11558 = new ArrayList<>();
      this.f_11559 = 0L;
      this.f_11560 = false;
      this.f_11561 = 20;
      this.m_1735();
      this.m_2371();
   }

   public void m_732(String var1) {
      this.f_11547 = var1 == null ? "" : var1.trim();
   }

   private int m_4041(ScreenHandler var1, String... var2) {
      int var3 = this.m_1244(var1);

      for (int var4 = 0; var4 < var3; var4++) {
         Slot var5 = (Slot)var1.slots.get(var4);
         ItemStack var6 = var5.getStack();
         if (var6 != null && !var6.isEmpty()) {
            String var7 = this.m_2402(var6.getName().getString());

            for (String var11 : var2) {
               if (var7.contains(var11)) {
                  return var5.id;
               }
            }
         }
      }

      return -1;
   }

   private long m_888(String var1) {
      Matcher var2 = f_11522.matcher(var1);
      if (!var2.find()) {
         return f_11609;
      } else {
         String var3 = var2.group(1).replace(f_11610, "").replace(f_11611, "").replace(f_11612, "");

         try {
            return Long.parseLong(var3);
         } catch (NumberFormatException var5) {
            return f_11613;
         }
      }
   }

   private int m_1244(ScreenHandler var1) {
      return var1 instanceof GenericContainerScreenHandler var2 ? var2.getRows() * 9 : Math.max(0, var1.slots.size() - 36);
   }

   private void m_3280() {
      if (f_5909.currentScreen instanceof HandledScreen var1 && this.m_484(var1)) {
         ScreenHandler var9 = f_5909.player.currentScreenHandler;
         if (var9 != null && var9.slots != null && !var9.slots.isEmpty()) {
            if (this.f_11554 == 2) {
               this.m_1529(this.f_11555.get(this.f_11556));
               this.f_11554 = 3;
               this.f_11537.m_3493();
            } else if (this.f_11554 == 3 && this.f_11537.m_522(f_11578, true)) {
               long var3 = this.m_3495(var9, this.f_11555.get(this.f_11556));
               if (var3 < this.f_11557) {
                  this.f_11557 = var3;
               }

               if (this.f_11557 == f_11579) {
                  this.f_11557 = 0L;
               }

               Util147.qkA6Y4JkO2xPSL6l var5 = this.f_11555.get(this.f_11556);
               long var6 = (long)Math.floor(this.f_11557 * (1.0 - this.f_11561 / f_11580));
               var5.f_1761 = Math.max(0L, var6);
               this.f_11558.add(var5.f_1757 + ": " + this.m_876(this.f_11557));
               this.f_11556++;
               this.f_11554 = 4;
            }
         }
      }

      switch (this.f_11554) {
         case 1:
            if (f_5909.currentScreen instanceof HandledScreen && this.m_484((HandledScreen<?>)f_5909.currentScreen)) {
               this.m_1529(this.f_11555.get(this.f_11556));
               this.f_11554 = 3;
               this.f_11537.m_3493();
            } else if (this.f_11537.m_522(f_11581, true) && f_5909.player != null && f_5909.player.networkHandler != null) {
               f_5909.player.networkHandler.sendChatMessage(f_11582);
               this.f_11554 = 2;
               this.f_11537.m_3493();
            }
         case 2:
         case 3:
         default:
            break;
         case 4:
            if (this.f_11556 >= this.f_11555.size()) {
               this.f_11554 = 5;
            } else {
               this.f_11557 = f_11583;
               this.m_1529(this.f_11555.get(this.f_11556));
               this.f_11554 = 3;
               this.f_11537.m_3493();
            }
            break;
         case 5:
            this.f_11559 = System.currentTimeMillis();
            this.m_3447();
            StringBuilder var8 = new StringBuilder(f_11584);

            for (String var11 : this.f_11558) {
               var8.append(f_11585).append(var11);
            }

            Util152.m_662(Text.literal(var8.toString()));
            this.f_11554 = 0;
      }
   }

   private boolean m_2814(long var1, long var3) {
      return var1 <= var3;
   }

   private void m_2845(String var1, String var2, long var3, Item var5) {
      this.f_11532.add(new Util147.qkA6Y4JkO2xPSL6l(var1, var5, var2, false, var3, (var1x, var2x) -> var1x.isOf(var5)));
   }

   private void m_1529(Util147.qkA6Y4JkO2xPSL6l var1) {
      if (f_5909.player != null && f_5909.player.networkHandler != null) {
         f_5909.player.networkHandler.sendChatMessage("/ah search " + var1.f_1759);
         this.f_11543 = Text.literal(var1.f_1759);
         this.f_11534.m_3493();
         this.f_11533.m_3493();
      }
   }

   private void m_3342(String var1, String var2, Item var3, long var4, String... var6) {
      this.f_11532.add(new Util147.qkA6Y4JkO2xPSL6l(var1, var3, var2, false, var4, (var1x, var2x) -> {
         for (String var6x : var6) {
            if (var2x.contains(var6x.toLowerCase(Locale.ROOT))) {
               return true;
            }
         }

         return false;
      }));
   }

   private List<String> m_1499(ItemStack var1) {
      ArrayList var2 = new ArrayList();
      var2.add(this.m_2402(var1.getName().getString()));

      try {
         for (Text var4 : var1.getTooltip(TooltipContext.DEFAULT, f_5909.player, TooltipType.BASIC)) {
            var2.add(this.m_2402(var4.getString()));
         }
      } catch (Exception var5) {
      }

      return var2;
   }

   public void m_583() {
      this.m_1437(f_11567);
   }

   public void m_3447() {
   }

   public int m_1898() {
      return this.f_11544;
   }

   private void m_2371() {
      this.f_11538 = ThreadLocalRandom.current().nextLong(f_11617, f_11618);
   }

   private void m_2489(ScreenHandler var1, int var2, int var3) {
      f_5909.interactionManager.clickSlot(var1.syncId, var2, var3, SlotActionType.PICKUP, f_5909.player);
   }

   public String m_1606() {
      return this.f_11547;
   }

   private long m_2023() {
      Scoreboard var1 = f_5909.world.getScoreboard();
      ScoreboardObjective var2 = var1.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
      if (var2 == null) {
         return f_11605;
      } else {
         ArrayList var3 = new ArrayList();

         for (ScoreboardEntry var5 : var1.getScoreboardEntries(var2)) {
            Team var6 = var1.getScoreHolderTeam(var5.owner());
            String var7 = var6 == null ? var5.owner() : Team.decorateName(var6, Text.literal(var5.owner())).getString();
            String var8 = this.m_2402(var7);
            var3.add(var8);
         }

         for (int var9 = 0; var9 < var3.size(); var9++) {
            String var10 = (String)var3.get(var9);
            if (var10.contains(f_11606) || var10.contains(f_11607)) {
               long var11 = this.m_888(var10);
               if (var11 >= 0L) {
                  return var11;
               }

               if (var9 + 1 < var3.size()) {
                  var11 = this.m_888((String)var3.get(var9 + 1));
                  if (var11 >= 0L) {
                     return var11;
                  }
               }

               if (var9 + 2 < var3.size()) {
                  var11 = this.m_888((String)var3.get(var9 + 2));
                  if (var11 >= 0L) {
                     return var11;
                  }
               }
            }
         }

         return f_11608;
      }
   }

   public List<Util147.qkA6Y4JkO2xPSL6l> m_3250() {
      return Collections.unmodifiableList(this.f_11532);
   }

   private boolean m_2687() {
      ScreenHandler var1 = f_5909.player.currentScreenHandler;
      if (var1 == null) {
         return false;
      } else {
         int var2 = this.m_4041(var1, f_11592, f_11593);
         if (var2 != -1 && this.f_11533.m_522(f_11594, true)) {
            this.m_2489(var1, var2, 0);
            this.f_11544++;
            return true;
         } else {
            return false;
         }
      }
   }

   public Text m_3444() {
      return this.l;
   }

   private Util147.RuGq4zVDSDonWCIw m_1395(List<String> var1) {
      for (String var3 : var1) {
         String var4 = var3.toLowerCase(Locale.ROOT);
         if (var4.contains(f_11602) || var4.contains(f_11603)) {
            Long var5 = m_258(var3);
            if (var5 != null && var5 >= 0L) {
               return new Util147.RuGq4zVDSDonWCIw(var5, true);
            }
         }
      }

      return null;
   }

   private record CN3wr06ILqGrGQMy(int slotId, long price, Text displayName, int mouseButton) {
   }

   private record RuGq4zVDSDonWCIw(long price, boolean perUnit) {
   }

   @FunctionalInterface
   public interface c3xJWkQ26rhHf7jv {
      boolean m_3103(ItemStack var1, String var2);
   }

   public static class qkA6Y4JkO2xPSL6l {
      public final String f_1757;
      public final Item f_1758;
      public final String f_1759;
      public boolean f_1760;
      public long f_1761;
      public final Util147.c3xJWkQ26rhHf7jv f_1762;

      public qkA6Y4JkO2xPSL6l(String var1, Item var2, String var3, boolean var4, long var5, Util147.c3xJWkQ26rhHf7jv var7) {
         this.f_1757 = var1;
         this.f_1758 = var2;
         this.f_1759 = var3;
         this.f_1760 = var4;
         this.f_1761 = var5;
         this.f_1762 = var7;
      }
   }
}
