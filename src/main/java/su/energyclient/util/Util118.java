package su.energyclient.util;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.text.Style;

public class Util118 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Map<Integer, String> f_12563 = new HashMap<>();
   private static final Map<Integer, Integer> f_12564 = new HashMap<>();
   private static final Map<String, String> f_12565 = new HashMap<>();
   private static final Map<String, Integer> l = new HashMap<>();
   private static final int[] f_12566 = new int[]{
      Util118.f_12568,
      Util118.f_12569,
      Util118.f_12570,
      Util118.f_12571,
      Util118.f_12572,
      Util118.f_12573,
      Util118.f_12574,
      Util118.f_12575,
      Util118.f_12576,
      Util118.f_12577,
      Util118.f_12578,
      Util118.f_12579,
      Util118.f_12580,
      Util118.f_12581,
      Util118.f_12582,
      Util118.f_12583,
      Util118.f_12584,
      Util118.f_12585,
      Util118.f_12586,
      Util118.f_12587,
      Util118.f_12588,
      Util118.f_12589,
      Util118.f_12590,
      Util118.f_12591,
      Util118.f_12592,
      Util118.f_12593,
      Util118.f_12594
   };
   private static final float f_12567 = 0.8F;
   private static final int f_12568 = 42240;
   private static final int f_12569 = 42244;
   private static final int f_12570 = 42248;
   private static final int f_12571 = 42258;
   private static final int f_12572 = 42262;
   private static final int f_12573 = 42272;
   private static final int f_12574 = 42276;
   private static final int f_12575 = 42280;
   private static final int f_12576 = 42336;
   private static final int f_12577 = 42290;
   private static final int f_12578 = 42294;
   private static final int f_12579 = 42308;
   private static final int f_12580 = 42326;
   private static final int f_12581 = 42312;
   private static final int f_12582 = 42304;
   private static final int f_12583 = 42322;
   private static final int f_12584 = 42249;
   private static final int f_12585 = 42259;
   private static final int f_12586 = 42263;
   private static final int f_12587 = 42273;
   private static final int f_12588 = 42277;
   private static final int f_12589 = 42281;
   private static final int f_12590 = 42291;
   private static final int f_12591 = 42295;
   private static final int f_12592 = 42241;
   private static final int f_12593 = 42245;
   private static final int f_12594 = 42313;
   private static final int f_12595 = 42240;
   private static final String f_12596 = "PLAYER";
   private static final int f_12597 = 42244;
   private static final String f_12598 = "HERO";
   private static final int f_12599 = 42248;
   private static final String f_12600 = "TITAN";
   private static final int f_12601 = 42258;
   private static final String f_12602 = "AVENGER";
   private static final int f_12603 = 42262;
   private static final String f_12604 = "OVERLORD";
   private static final int f_12605 = 42272;
   private static final String f_12606 = "MAGISTER";
   private static final int f_12607 = 42276;
   private static final String f_12608 = "IMPERATOR";
   private static final int f_12609 = 42280;
   private static final String f_12610 = "DRAGON";
   private static final int f_12611 = 42336;
   private static final String f_12612 = "D.HELPER";
   private static final int f_12613 = 42290;
   private static final String f_12614 = "BULL";
   private static final int f_12615 = 42294;
   private static final String f_12616 = "TIGER";
   private static final int f_12617 = 42308;
   private static final String f_12618 = "DRACULA";
   private static final int f_12619 = 42326;
   private static final String f_12620 = "BUNNY";
   private static final int f_12621 = 42312;
   private static final String f_12622 = "COBRA";
   private static final int f_12623 = 42304;
   private static final String f_12624 = "HYDRA";
   private static final int f_12625 = 42322;
   private static final String f_12626 = "RABBIT";
   private static final int f_12627 = 42249;
   private static final String f_12628 = "HELPER";
   private static final int f_12629 = 42259;
   private static final String f_12630 = "ML.MODER";
   private static final int f_12631 = 42263;
   private static final String f_12632 = "MODER";
   private static final int f_12633 = 42273;
   private static final String f_12634 = "MODER+";
   private static final int f_12635 = 42277;
   private static final String f_12636 = "ST.MODER";
   private static final int f_12637 = 42281;
   private static final String f_12638 = "GL.MODER";
   private static final int f_12639 = 42291;
   private static final String f_12640 = "ML.ADMIN";
   private static final int f_12641 = 42295;
   private static final String f_12642 = "ADMIN";
   private static final int f_12643 = 42241;
   private static final String f_12644 = "MEDIA";
   private static final int f_12645 = 42245;
   private static final String f_12646 = "YT";
   private static final int f_12647 = 42313;
   private static final String f_12648 = "PEGAS";
   private static final String f_12649 = "A";
   private static final String f_12650 = "B";
   private static final String f_12651 = "C";
   private static final String f_12652 = "D";
   private static final String f_12653 = "E";
   private static final int f_12654 = 42800;
   private static final String f_12655 = "F";
   private static final String f_12656 = "G";
   private static final String f_12657 = "H";
   private static final String f_12658 = "I";
   private static final String f_12659 = "J";
   private static final String f_12660 = "K";
   private static final String f_12661 = "L";
   private static final String f_12662 = "M";
   private static final String f_12663 = "N";
   private static final String f_12664 = "O";
   private static final String f_12665 = "P";
   private static final String f_12666 = "Q";
   private static final String f_12667 = "R";
   private static final String f_12668 = "T";
   private static final String f_12669 = "U";
   private static final int f_12670 = 42801;
   private static final String f_12671 = "S";
   private static final String f_12672 = "V";
   private static final String f_12673 = "W";
   private static final String f_12674 = "X";
   private static final String f_12675 = "Y";
   private static final String f_12676 = "Z";
   private static final String f_12677 = "custom:groups/hydra";
   private static final String f_12678 = "Гидра";
   private static final String f_12679 = "custom:groups/cerberus";
   private static final String f_12680 = "Цербер";
   private static final String f_12681 = "custom:groups/triton";
   private static final String f_12682 = "Тритон";
   private static final String f_12683 = "custom:groups/phoenix";
   private static final String f_12684 = "Феникс";
   private static final String f_12685 = "custom:groups/pandar";
   private static final String f_12686 = "Пандар";
   private static final String f_12687 = "custom:groups/heat";
   private static final String f_12688 = "Жара";
   private static final String f_12689 = "custom:groups/cold";
   private static final String f_12690 = "Холод";
   private static final String f_12691 = "custom:groups/kronos";
   private static final String f_12692 = "Кронос";
   private static final String f_12693 = "custom:groups/summer";
   private static final String f_12694 = "Лето";
   private static final String f_12695 = "custom:groups/winter";
   private static final String f_12696 = "Зима";
   private static final String f_12697 = "custom:groups/phobos";
   private static final String f_12698 = "Фобос";
   private static final String f_12699 = "custom:groups/ares";
   private static final String f_12700 = "Арес";
   private static final String f_12701 = "custom:groups/aristocrat";
   private static final String f_12702 = "Аристократ";
   private static final String f_12703 = "custom:groups/youtuber";
   private static final String f_12704 = "Ютубер";
   private static final String f_12705 = "custom:groups/helper";
   private static final String f_12706 = "Хелпер";
   private static final String f_12707 = "custom:groups/shelper";
   private static final String f_12708 = "Ст Хелпер";
   private static final String f_12709 = "custom:groups/moder";
   private static final String f_12710 = "Модер";
   private static final String f_12711 = "custom:groups/smoder";
   private static final String f_12712 = "Ст Модер";
   private static final String f_12713 = "custom:groups/admin";
   private static final String f_12714 = "Админ";
   private static final String f_12715 = "custom:groups/default";
   private static final String f_12716 = "Игрок";
   private static final String f_12717 = "custom:groups/aristocrat";
   private static final String f_12718 = "custom:groups/ares";
   private static final String f_12719 = "custom:groups/phobos";
   private static final String f_12720 = "custom:groups/kronos";
   private static final String f_12721 = "custom:groups/pandar";
   private static final String f_12722 = "custom:groups/phoenix";
   private static final String f_12723 = "custom:groups/triton";
   private static final String f_12724 = "custom:groups/cerberus";
   private static final String f_12725 = "custom:groups/hydra";
   private static final String f_12726 = "custom:groups/admin";
   private static final String f_12727 = "custom:groups/helper";
   private static final String f_12728 = "custom:groups/shelper";
   private static final String f_12729 = "custom:groups/moder";
   private static final String f_12730 = "custom:groups/smoder";
   private static final String f_12731 = "custom:groups/heat";
   private static final String f_12732 = "custom:groups/cold";
   private static final String f_12733 = "custom:groups/summer";
   private static final String f_12734 = "custom:groups/winter";
   private static final String f_12735 = "custom:groups/youtuber";
   private static final String f_12736 = "custom:groups/default";
   private static final int f_12737 = 42240;
   private static final int f_12738 = 42244;
   private static final int f_12739 = 42248;
   private static final int f_12740 = 42258;
   private static final int f_12741 = 42262;
   private static final int f_12742 = 42272;
   private static final int f_12743 = 42276;
   private static final int f_12744 = 42280;
   private static final int f_12745 = 42336;
   private static final int f_12746 = 42290;
   private static final int f_12747 = 42294;
   private static final int f_12748 = 42308;
   private static final int f_12749 = 42326;
   private static final int f_12750 = 42312;
   private static final int f_12751 = 42304;
   private static final int f_12752 = 42322;
   private static final int f_12753 = 42249;
   private static final int f_12754 = 42259;
   private static final int f_12755 = 42263;
   private static final int f_12756 = 42273;
   private static final int f_12757 = 42277;
   private static final int f_12758 = 42281;
   private static final int f_12759 = 42291;
   private static final int f_12760 = 42295;
   private static final int f_12761 = 42241;
   private static final int f_12762 = 42245;
   private static final int f_12763 = 42313;

   public static String m_1432(Style var0) {
      if (var0 != null && var0.getFont() != null) {
         String var1 = var0.getFont().toString();
         return f_12565.get(var1);
      } else {
         return null;
      }
   }

   public static boolean m_3988(int var0, Style var1) {
      if (var0 == 97 && var1 != null && var1.getFont() != null) {
         String var2 = var1.getFont().toString();
         return f_12565.containsKey(var2);
      } else {
         return false;
      }
   }

   public static int m_2782(String var0, float var1) {
      int var2 = m_2230(var0);
      return var2 == -1 ? -1 : Util71.m_1907(var2, var1);
   }

   public static int m_1170(int var0, int var1, int var2, float var3, int var4) {
      boolean var5 = false;

      for (int var9 : f_12566) {
         if (var9 == var0) {
            var5 = true;
            break;
         }
      }

      if (var5) {
         Integer var10 = f_12564.get(var0);
         int var11 = Util71.m_2101(var10, f_12567);
         float var12 = (float)var1 / (var2 - 1);
         int var13 = Util71.m_2924(var10, var11, var12);
         return Util71.m_1907(var13, var3);
      } else {
         return Util71.m_1907(var4, var3);
      }
   }

   static {
      f_12563.put(9889, "");
      f_12563.put(9733, "");
      f_12563.put(f_12595, f_12596);
      f_12563.put(f_12597, f_12598);
      f_12563.put(f_12599, f_12600);
      f_12563.put(f_12601, f_12602);
      f_12563.put(f_12603, f_12604);
      f_12563.put(f_12605, f_12606);
      f_12563.put(f_12607, f_12608);
      f_12563.put(f_12609, f_12610);
      f_12563.put(f_12611, f_12612);
      f_12563.put(f_12613, f_12614);
      f_12563.put(f_12615, f_12616);
      f_12563.put(f_12617, f_12618);
      f_12563.put(f_12619, f_12620);
      f_12563.put(f_12621, f_12622);
      f_12563.put(f_12623, f_12624);
      f_12563.put(f_12625, f_12626);
      f_12563.put(f_12627, f_12628);
      f_12563.put(f_12629, f_12630);
      f_12563.put(f_12631, f_12632);
      f_12563.put(f_12633, f_12634);
      f_12563.put(f_12635, f_12636);
      f_12563.put(f_12637, f_12638);
      f_12563.put(f_12639, f_12640);
      f_12563.put(f_12641, f_12642);
      f_12563.put(f_12643, f_12644);
      f_12563.put(f_12645, f_12646);
      f_12563.put(f_12647, f_12648);
      f_12563.put(7424, f_12649);
      f_12563.put(665, f_12650);
      f_12563.put(7428, f_12651);
      f_12563.put(7429, f_12652);
      f_12563.put(7431, f_12653);
      f_12563.put(f_12654, f_12655);
      f_12563.put(610, f_12656);
      f_12563.put(668, f_12657);
      f_12563.put(618, f_12658);
      f_12563.put(7434, f_12659);
      f_12563.put(7435, f_12660);
      f_12563.put(671, f_12661);
      f_12563.put(7437, f_12662);
      f_12563.put(628, f_12663);
      f_12563.put(7439, f_12664);
      f_12563.put(7448, f_12665);
      f_12563.put(491, f_12666);
      f_12563.put(640, f_12667);
      f_12563.put(7451, f_12668);
      f_12563.put(7452, f_12669);
      f_12563.put(f_12670, f_12671);
      f_12563.put(7456, f_12672);
      f_12563.put(7457, f_12673);
      f_12563.put(7521, f_12674);
      f_12563.put(655, f_12675);
      f_12563.put(7458, f_12676);
      f_12565.put(f_12677, f_12678);
      f_12565.put(f_12679, f_12680);
      f_12565.put(f_12681, f_12682);
      f_12565.put(f_12683, f_12684);
      f_12565.put(f_12685, f_12686);
      f_12565.put(f_12687, f_12688);
      f_12565.put(f_12689, f_12690);
      f_12565.put(f_12691, f_12692);
      f_12565.put(f_12693, f_12694);
      f_12565.put(f_12695, f_12696);
      f_12565.put(f_12697, f_12698);
      f_12565.put(f_12699, f_12700);
      f_12565.put(f_12701, f_12702);
      f_12565.put(f_12703, f_12704);
      f_12565.put(f_12705, f_12706);
      f_12565.put(f_12707, f_12708);
      f_12565.put(f_12709, f_12710);
      f_12565.put(f_12711, f_12712);
      f_12565.put(f_12713, f_12714);
      f_12565.put(f_12715, f_12716);
      l.put(f_12717, Util71.m_1415(100, 149, 237));
      l.put(f_12718, Util71.m_1415(255, 215, 0));
      l.put(f_12719, Util71.m_1415(255, 165, 0));
      l.put(f_12720, Util71.m_1415(139, 0, 139));
      l.put(f_12721, Util71.m_1415(255, 0, 0));
      l.put(f_12722, Util71.m_1415(187, 0, 0));
      l.put(f_12723, Util71.m_1415(173, 216, 230));
      l.put(f_12724, Util71.m_1415(0, 255, 0));
      l.put(f_12725, Util71.m_1415(144, 238, 144));
      l.put(f_12726, Util71.m_1415(255, 0, 0));
      l.put(f_12727, Util71.m_1415(184, 134, 11));
      l.put(f_12728, Util71.m_1415(255, 215, 0));
      l.put(f_12729, Util71.m_1415(0, 0, 255));
      l.put(f_12730, Util71.m_1415(65, 105, 225));
      l.put(f_12731, Util71.m_1415(255, 69, 0));
      l.put(f_12732, Util71.m_1415(135, 206, 250));
      l.put(f_12733, Util71.m_1415(255, 215, 0));
      l.put(f_12734, Util71.m_1415(240, 248, 255));
      l.put(f_12735, Util71.m_1415(255, 0, 0));
      l.put(f_12736, Util71.m_1415(255, 255, 255));
      f_12564.put(f_12737, Util71.m_1415(120, 120, 120));
      f_12564.put(f_12738, Util71.m_1415(100, 113, 251));
      f_12564.put(f_12739, Util71.m_1415(214, 200, 42));
      f_12564.put(f_12740, Util71.m_1415(101, 189, 56));
      f_12564.put(f_12741, Util71.m_1415(64, 151, 214));
      f_12564.put(f_12742, Util71.m_1415(202, 130, 60));
      f_12564.put(f_12743, Util71.m_1415(202, 60, 60));
      f_12564.put(f_12744, Util71.m_1415(245, 51, 238));
      f_12564.put(f_12745, Util71.m_1415(214, 200, 42));
      f_12564.put(f_12746, Util71.m_1415(121, 81, 202));
      f_12564.put(f_12747, Util71.m_1415(202, 130, 60));
      f_12564.put(f_12748, Util71.m_1415(202, 60, 60));
      f_12564.put(f_12749, Util71.m_1415(68, 65, 66));
      f_12564.put(f_12750, Util71.m_1415(127, 214, 86));
      f_12564.put(f_12751, Util71.m_1415(92, 120, 7));
      f_12564.put(f_12752, Util71.m_1415(120, 120, 120));
      f_12564.put(f_12753, Util71.m_1415(214, 200, 42));
      f_12564.put(f_12754, Util71.m_1415(100, 113, 251));
      f_12564.put(f_12755, Util71.m_1415(100, 113, 251));
      f_12564.put(f_12756, Util71.m_1415(121, 81, 202));
      f_12564.put(f_12757, Util71.m_1415(100, 113, 251));
      f_12564.put(f_12758, Util71.m_1415(121, 81, 202));
      f_12564.put(f_12759, Util71.m_1415(64, 151, 214));
      f_12564.put(f_12760, Util71.m_1415(202, 60, 60));
      f_12564.put(f_12761, Util71.m_1415(121, 81, 202));
      f_12564.put(f_12762, Util71.m_1415(255, 255, 255));
      f_12564.put(f_12763, Util71.m_1415(235, 171, 52));
   }

   public static void m_1218(String var0, String var1) {
      f_12565.put(var0, var1);
   }

   public static String m_1760(String var0) {
      return f_12565.getOrDefault(var0, var0);
   }

   public static String m_540(int var0) {
      return f_12563.get(var0);
   }

   public static int m_2230(String var0) {
      return l.getOrDefault(var0, -1);
   }
}
