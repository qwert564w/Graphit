package su.energyclient.util;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.text.Text;

public final class Util87 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final List<Util87.AViZ7vtC7O35PbTb> f_5534 = List.of(
      m_1120(Util87.f_5536, (char)Util87.f_5537),
      m_1120(Util87.f_5538, (char)Util87.f_5539),
      m_1120(Util87.f_5540, (char)Util87.f_5541),
      m_1120(Util87.f_5542, (char)Util87.f_5543),
      m_1120(Util87.f_5544, (char)Util87.f_5545),
      m_1120(Util87.f_5546, (char)Util87.f_5547),
      m_1120(Util87.f_5548, (char)Util87.f_5549),
      m_1120(Util87.f_5550, (char)Util87.f_5551),
      m_1120(Util87.f_5552, (char)Util87.f_5553),
      m_1120(Util87.f_5554, (char)Util87.f_5555),
      m_1120(Util87.f_5556, (char)Util87.f_5557),
      m_1120(Util87.f_5558, (char)Util87.f_5559),
      m_1120(Util87.f_5560, (char)Util87.f_5561),
      m_1120(Util87.f_5562, (char)Util87.f_5563),
      m_1120(Util87.f_5564, (char)Util87.f_5565),
      m_1120(Util87.f_5566, (char)Util87.f_5567),
      m_1120(Util87.f_5568, (char)Util87.f_5569),
      m_1120(Util87.f_5570, (char)Util87.f_5571),
      m_1120(Util87.f_5572, (char)Util87.f_5573),
      m_1120(Util87.f_5574, (char)Util87.f_5575),
      m_1120(Util87.f_5576, (char)Util87.f_5577),
      m_1120(Util87.f_5578, (char)Util87.f_5579),
      m_1120(Util87.f_5580, (char)Util87.f_5581),
      m_1120(Util87.f_5582, (char)Util87.f_5583),
      m_1120(Util87.f_5584, (char)Util87.f_5585),
      m_1120(Util87.f_5586, (char)Util87.f_5587),
      m_1120(Util87.f_5588, (char)Util87.f_5589),
      m_1120(Util87.f_5590, (char)Util87.f_5591),
      m_1120(Util87.f_5592, (char)Util87.f_5593),
      m_1120(Util87.f_5594, (char)Util87.f_5595),
      m_1120(Util87.f_5596, (char)Util87.f_5597),
      m_1120(Util87.f_5598, (char)Util87.f_5599),
      m_1120(Util87.f_5600, (char)Util87.f_5601),
      m_1120(Util87.f_5602, (char)Util87.f_5603),
      m_1120(Util87.f_5604, (char)Util87.f_5605),
      m_1120(Util87.f_5606, (char)Util87.f_5607),
      m_1120(Util87.f_5608, (char)Util87.f_5609),
      m_1120(Util87.f_5610, (char)Util87.f_5611),
      m_1120(Util87.f_5612, (char)Util87.f_5613),
      m_1120(Util87.f_5614, (char)Util87.f_5615),
      m_1120(Util87.f_5616, (char)Util87.f_5617),
      m_1120(Util87.f_5618, (char)Util87.f_5619),
      m_1120(Util87.f_5620, (char)Util87.f_5621),
      m_1120(Util87.f_5622, (char)Util87.f_5623),
      m_1120(Util87.f_5624, (char)Util87.f_5625),
      m_1120(Util87.f_5626, (char)Util87.f_5627),
      m_1120(Util87.f_5628, (char)Util87.f_5629),
      m_1120(Util87.f_5630, (char)Util87.f_5631),
      m_1120(Util87.f_5632, (char)Util87.f_5633),
      m_1120(Util87.f_5634, (char)Util87.f_5635),
      m_1120(Util87.f_5636, (char)Util87.f_5637),
      m_1120(Util87.f_5638, (char)Util87.f_5639),
      m_1120(Util87.f_5640, (char)Util87.f_5641),
      m_1120(Util87.f_5642, (char)Util87.f_5643),
      m_1120(Util87.f_5644, (char)Util87.f_5645),
      m_1120(Util87.f_5646, (char)Util87.f_5647),
      m_1120(Util87.f_5648, (char)Util87.f_5649),
      m_1120(Util87.f_5650, (char)Util87.f_5651),
      m_1120(Util87.f_5652, (char)Util87.f_5653),
      m_1120(Util87.f_5654, (char)Util87.f_5655),
      m_1120(Util87.f_5656, (char)Util87.f_5657),
      m_1120(Util87.f_5658, (char)Util87.f_5659),
      m_1120(Util87.f_5660, (char)Util87.f_5661),
      m_1120(Util87.f_5662, (char)Util87.f_5663),
      m_1120(Util87.f_5664, (char)Util87.f_5665),
      m_1120(Util87.f_5666, (char)Util87.f_5667),
      m_1120(Util87.f_5668, (char)Util87.f_5669),
      m_1120(Util87.f_5670, (char)Util87.f_5671),
      m_1120(Util87.f_5672, (char)Util87.f_5673),
      m_1120(Util87.f_5674, (char)Util87.f_5675),
      m_1120(Util87.f_5676, (char)Util87.f_5677),
      m_1120(Util87.f_5678, (char)Util87.f_5679),
      m_1120(Util87.f_5680, (char)Util87.f_5681),
      m_1120(Util87.f_5682, (char)Util87.f_5683),
      m_1120(Util87.f_5684, (char)Util87.f_5685),
      m_1120(Util87.f_5686, (char)Util87.f_5687),
      m_1120(Util87.f_5688, (char)Util87.f_5689),
      m_1120(Util87.f_5690, (char)Util87.f_5691),
      m_1120(Util87.f_5692, (char)Util87.f_5693),
      m_1120(Util87.f_5694, (char)Util87.f_5695),
      m_1120(Util87.f_5696, (char)Util87.f_5697)
   );
   private static final Set<String> f_5535 = ConcurrentHashMap.newKeySet();
   private static final String f_5536 = "essq";
   private static final int f_5537 = 42277;
   private static final String f_5538 = "tachenok";
   private static final int f_5539 = 42263;
   private static final String f_5540 = "xXxCaXaPoKxXx";
   private static final int f_5541 = 42263;
   private static final String f_5542 = "tt_dayener";
   private static final int f_5543 = 42259;
   private static final String f_5544 = "1mper4ik";
   private static final int f_5545 = 42259;
   private static final String f_5546 = "almaz_1298";
   private static final int f_5547 = 42259;
   private static final String f_5548 = "meowikis";
   private static final int f_5549 = 42277;
   private static final String f_5550 = "trapshark";
   private static final int f_5551 = 42273;
   private static final String f_5552 = "zombichka";
   private static final int f_5553 = 42273;
   private static final String f_5554 = "_Denely_";
   private static final int f_5555 = 42263;
   private static final String f_5556 = "JuliaSwettie";
   private static final int f_5557 = 42263;
   private static final String f_5558 = "Zlyka_HiFis";
   private static final int f_5559 = 42263;
   private static final String f_5560 = "Boss_kPOC";
   private static final int f_5561 = 42277;
   private static final String f_5562 = "thecokieboiyt";
   private static final int f_5563 = 42263;
   private static final String f_5564 = "cBeTuk";
   private static final int f_5565 = 42263;
   private static final String f_5566 = "NeOnOvaa";
   private static final int f_5567 = 42263;
   private static final String f_5568 = "Sikret_blook";
   private static final int f_5569 = 42259;
   private static final String f_5570 = "omega2010";
   private static final int f_5571 = 42259;
   private static final String f_5572 = "dashutka123";
   private static final int f_5573 = 42277;
   private static final String f_5574 = "tragedia";
   private static final int f_5575 = 42273;
   private static final String f_5576 = "Andza";
   private static final int f_5577 = 42263;
   private static final String f_5578 = "Repaction";
   private static final int f_5579 = 42263;
   private static final String f_5580 = "ML_Pelmen";
   private static final int f_5581 = 42277;
   private static final String f_5582 = "N0RK";
   private static final int f_5583 = 42273;
   private static final String f_5584 = "maviushka";
   private static final int f_5585 = 42273;
   private static final String f_5586 = "AtomniyGeniy";
   private static final int f_5587 = 42263;
   private static final String f_5588 = "3EFIIPKA_";
   private static final int f_5589 = 42263;
   private static final String f_5590 = "Lardi";
   private static final int f_5591 = 42259;
   private static final String f_5592 = "palpemambo";
   private static final int f_5593 = 42277;
   private static final String f_5594 = "vmbill";
   private static final int f_5595 = 42273;
   private static final String f_5596 = "svv";
   private static final int f_5597 = 42263;
   private static final String f_5598 = "AQM_Bull";
   private static final int f_5599 = 42263;
   private static final String f_5600 = "xBadMoode_";
   private static final int f_5601 = 42259;
   private static final String f_5602 = "mantastyle";
   private static final int f_5603 = 42277;
   private static final String f_5604 = "HarukaKasugano_";
   private static final int f_5605 = 42273;
   private static final String f_5606 = "Regalia";
   private static final int f_5607 = 42273;
   private static final String f_5608 = "Savelka2001";
   private static final int f_5609 = 42263;
   private static final String f_5610 = "Mist1kMan";
   private static final int f_5611 = 42263;
   private static final String f_5612 = "VexedUSSS";
   private static final int f_5613 = 42259;
   private static final String f_5614 = "vkss";
   private static final int f_5615 = 42259;
   private static final String f_5616 = "6ubaa";
   private static final int f_5617 = 42277;
   private static final String f_5618 = "TrapJoker";
   private static final int f_5619 = 42273;
   private static final String f_5620 = "Zwiex";
   private static final int f_5621 = 42263;
   private static final String f_5622 = "MsTank";
   private static final int f_5623 = 42263;
   private static final String f_5624 = "_qwersii_";
   private static final int f_5625 = 42263;
   private static final String f_5626 = "NoGletcherGang";
   private static final int f_5627 = 42263;
   private static final String f_5628 = "Farika12";
   private static final int f_5629 = 42259;
   private static final String f_5630 = "SheWantsIt";
   private static final int f_5631 = 42277;
   private static final String f_5632 = "MelissAzeRo_";
   private static final int f_5633 = 42273;
   private static final String f_5634 = "bybJl1k";
   private static final int f_5635 = 42263;
   private static final String f_5636 = "MrMegaRW";
   private static final int f_5637 = 42263;
   private static final String f_5638 = "FlameRW";
   private static final int f_5639 = 42263;
   private static final String f_5640 = "soloila";
   private static final int f_5641 = 42259;
   private static final String f_5642 = "S1cr3tNet";
   private static final int f_5643 = 42259;
   private static final String f_5644 = "Maxx___";
   private static final int f_5645 = 42277;
   private static final String f_5646 = "Petruco890";
   private static final int f_5647 = 42273;
   private static final String f_5648 = "niwones_";
   private static final int f_5649 = 42273;
   private static final String f_5650 = "Misantro";
   private static final int f_5651 = 42263;
   private static final String f_5652 = "Dead_Insidi4ik";
   private static final int f_5653 = 42263;
   private static final String f_5654 = "xProblemAxq";
   private static final int f_5655 = 42263;
   private static final String f_5656 = "We4okop";
   private static final int f_5657 = 42259;
   private static final String f_5658 = "X_Freez_X";
   private static final int f_5659 = 42277;
   private static final String f_5660 = "MineFix909";
   private static final int f_5661 = 42273;
   private static final String f_5662 = "_Pon41k_";
   private static final int f_5663 = 42263;
   private static final String f_5664 = "Pa3rushitel_Mira";
   private static final int f_5665 = 42263;
   private static final String f_5666 = "Sh1k1mor1";
   private static final int f_5667 = 42263;
   private static final String f_5668 = "NebesniyDemon_";
   private static final int f_5669 = 42277;
   private static final String f_5670 = "Zloy___banan4ik";
   private static final int f_5671 = 42273;
   private static final String f_5672 = "Alles_Fur_Dich";
   private static final int f_5673 = 42273;
   private static final String f_5674 = "Silently";
   private static final int f_5675 = 42263;
   private static final String f_5676 = "SoraYosuga";
   private static final int f_5677 = 42263;
   private static final String f_5678 = "MrDomer";
   private static final int f_5679 = 42295;
   private static final String f_5680 = "AngelForch";
   private static final int f_5681 = 42295;
   private static final String f_5682 = "3lobniy_Geniy";
   private static final int f_5683 = 42291;
   private static final String f_5684 = "Gagarna";
   private static final int f_5685 = 42295;
   private static final String f_5686 = "NetherPlay";
   private static final int f_5687 = 42295;
   private static final String f_5688 = "AndreyPL";
   private static final int f_5689 = 42295;
   private static final String f_5690 = "Mr_Bibys_YT";
   private static final int f_5691 = 42295;
   private static final String f_5692 = "XenTai4IK";
   private static final int f_5693 = 42291;
   private static final String f_5694 = "KondrMS";
   private static final int f_5695 = 42295;
   private static final String f_5696 = "ShuKuriNay";
   private static final int f_5697 = 42295;

   public static void m_2954() {
      f_5535.clear();
   }

   public static boolean m_1877() {
      return !f_5535.isEmpty();
   }

   public static Text m_1332(String var0) {
      return f_5534.stream().filter(var1 -> var1.f_268.equalsIgnoreCase(var0)).findFirst().map(Util87.AViZ7vtC7O35PbTb::m_58).orElse(Text.empty());
   }

   public static List<String> m_1012() {
      return f_5535.stream().sorted(String.CASE_INSENSITIVE_ORDER).toList();
   }

   private static Util87.AViZ7vtC7O35PbTb m_1120(String var0, char var1) {
      return new Util87.AViZ7vtC7O35PbTb(var0, var1);
   }

   public static List<Util87.AViZ7vtC7O35PbTb> m_88() {
      return f_5534;
   }

   public static void m_2547(String var0) {
      if (var0 != null) {
         f_5535.removeIf(var1 -> var1.equalsIgnoreCase(var0.trim()));
      }
   }

   public static void m_2398(String var0) {
      if (var0 != null && !var0.isBlank()) {
         f_5535.add(var0.trim());
      }
   }

   private Util87() {
   }

   public static final class AViZ7vtC7O35PbTb {
      public final String f_268;
      private final char f_269;

      private AViZ7vtC7O35PbTb(String var1, char var2) {
         this.f_268 = var1;
         this.f_269 = var2;
      }

      public Text m_58() {
         return Text.literal(String.valueOf(this.f_269));
      }
   }
}
