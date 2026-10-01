package su.energyclient.module.render;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil2;
import su.energyclient.render.RenderUtil25;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util102;
import su.energyclient.util.Util115;
import su.energyclient.util.Util132;
import su.energyclient.util.Util144;
import su.energyclient.util.Util153;
import su.energyclient.util.Util158;
import su.energyclient.util.Util165;
import su.energyclient.util.Util169;
import su.energyclient.util.Util170;
import su.energyclient.util.Util22;
import su.energyclient.util.Util48;
import su.energyclient.util.Util61;
import su.energyclient.util.Util63;
import su.energyclient.util.Util71;
import su.energyclient.util.Util93;

public class Interface extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final float f_4770 = 22.0F;
   public static final float f_4771 = 0.0F;
   public static final float f_4772 = 0.0F;
   private static final float f_4773 = 0.0F;
   private static final float f_4774 = 0.0F;
   private static final EquipmentSlot[] f_4775 = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   public final Util63 f_4776;
   public final BooleanSetting f_4777;
   public final BooleanSetting I;
   public final BooleanSetting f_4778;
   private final Util144 f_4779;
   private final Util102 f_4780;
   private final Arraylist f_4781;
   private final Util132 f_4782;
   private final Util48 f_4783;
   private final Util22 f_4784;
   private final Util115 f_4785;
   private final Util61 f_4786;
   private static final String f_4787 = "Interface";
   private static final String f_4788 = "Интерфейс клиента";
   private static final String f_4789 = "Элементы";
   private static final String f_4790 = "Ватермарка";
   private static final String f_4791 = "Информация";
   private static final String f_4792 = "ArrayList";
   private static final String f_4793 = "Кейбинды";
   private static final String f_4794 = "Список эффектов";
   private static final String f_4795 = "Список админов";
   private static final String f_4796 = "Таргет худ";
   private static final String f_4797 = "Задержки";
   private static final String f_4798 = "Броня";
   private static final String f_4799 = "Прозрачный фон";
   private static final String f_4800 = "Суффиксы";
   private static final String f_4801 = "Скрывать Render";
   private static final float f_4802 = 7.0F;
   private static final float f_4803 = 7.0F;
   private static final float f_4804 = 115.0F;
   private static final String f_4805 = "watermark";
   private static final float f_4806 = 7.0F;
   private static final float f_4807 = 7.0F;
   private static final String f_4808 = "information";
   private static final float f_4809 = 7.0F;
   private static final float f_4810 = 31.0F;
   private static final String f_4811 = "arraylist";
   private static final float f_4812 = 7.0F;
   private static final String f_4813 = "hoykeys";
   private static final float f_4814 = 60.0F;
   private static final float f_4815 = 30.0F;
   private static final String f_4816 = "potions";
   private static final float f_4817 = 120.0F;
   private static final float f_4818 = 30.0F;
   private static final String f_4819 = "staffs";
   private static final float f_4820 = 180.0F;
   private static final float f_4821 = 30.0F;
   private static final String f_4822 = "targethud";
   private static final float f_4823 = 7.0F;
   private static final float f_4824 = 70.0F;
   private static final String f_4825 = "cooldowns";
   private static final float f_4826 = 240.0F;
   private static final float f_4827 = 30.0F;
   private static final float f_4828 = 70.0F;
   private static final float f_4829 = 27.0F;
   private static final long f_4830 = 200L;
   private static final float f_4831 = 22.0F;
   private static final float f_4832 = 22.0F;
   private static final float f_4833 = 14.0F;
   private static final float f_4834 = 100.0F;
   private static final float f_4835 = 55.0F;
   private static final float f_4836 = 22.0F;
   private static final float f_4837 = 14.0F;
   private static final float f_4838 = 14.0F;
   private static final float f_4839 = 22.0F;
   private static final float f_4840 = 0.5F;
   private static final float f_4841 = 15.0F;
   private static final float f_4842 = 10.0F;
   private static final float f_4843 = 6.0F;
   private static final float f_4844 = 10.0F;
   private static final String f_4845 = "Список эффектов";
   private static final String f_4846 = "Список админов";
   private static final String f_4847 = "Ватермарка";
   private static final String f_4848 = "Информация";
   private static final String f_4849 = "ArrayList";
   private static final String f_4850 = "Кейбинды";
   private static final String f_4851 = "Список эффектов";
   private static final String f_4852 = "Список админов";
   private static final String f_4853 = "Таргет худ";
   private static final String f_4854 = "Задержки";
   private static final String f_4855 = "Броня";
   private static final String f_4856 = "ArrayList";
   private static final String f_4857 = "ArrayList";

   private static void m_3516(Util165 var0, float var1) {
      long var2 = System.currentTimeMillis();
      var0.m_2214(var1);
      var0.m_2946(var1);
      var0.m_1829(var1);
      var0.m_1876(var2);
      var0.m_1066(var2);
      var0.l(true);
   }

   public static void m_4000(float var0, float var1, float var2, float var3) {
      RenderUtil2.m_3624(var0, var1, var2, var3);
   }

   public Interface() {
      super(f_4787, f_4788, Category.RENDER);
      this.f_4776 = new Util63(
         f_4789,
         BooleanSetting.m_136(f_4790, true),
         BooleanSetting.m_136(f_4791, true),
         BooleanSetting.m_136(f_4792, true),
         BooleanSetting.m_136(f_4793, true),
         BooleanSetting.m_136(f_4794, true),
         BooleanSetting.m_136(f_4795, true),
         BooleanSetting.m_136(f_4796, true),
         BooleanSetting.m_136(f_4797, true),
         BooleanSetting.m_136(f_4798, true)
      );
      this.f_4777 = new BooleanSetting(f_4799, false);
      this.I = new BooleanSetting(f_4800, true).m_334(() -> this.f_4776.I(f_4857));
      this.f_4778 = new BooleanSetting(f_4801, false).m_334(() -> this.f_4776.I(f_4856));
      float var1 = f_4802;
      if (f_5909 != null && f_5909.getWindow() != null) {
         var1 = Math.max(f_4803, f_5909.getWindow().getWidth() / 2.0F - f_4804);
      }

      this.f_4779 = new Util144(EnergyClient.createDrag(this, f_4805, f_4806, f_4807));
      this.f_4780 = new Util102(EnergyClient.createDrag(this, f_4808, f_4809, f_4810));
      this.f_4781 = new Arraylist(EnergyClient.createDrag(this, f_4811, var1, f_4812), this);
      this.f_4782 = new Util132(EnergyClient.createDrag(this, f_4813, f_4814, f_4815));
      this.f_4783 = new Util48(EnergyClient.createDrag(this, f_4816, f_4817, f_4818));
      this.f_4784 = new Util22(EnergyClient.createDrag(this, f_4819, f_4820, f_4821));
      this.f_4785 = new Util115(EnergyClient.createDrag(this, f_4822, f_4823, f_4824));
      this.f_4786 = new Util61(EnergyClient.createDrag(this, f_4825, f_4826, f_4827));
   }

   public static void m_1853() {
      RenderUtil2.m_1647();
   }

   public void m_3910(Util169 var1) {
      if (f_5909.player != null) {
         boolean var2 = false;

         for (EquipmentSlot var6 : f_4775) {
            if (!f_5909.player.getEquippedStack(var6).isEmpty()) {
               var2 = true;
               break;
            }
         }

         if (var2) {
            DrawContext var14 = var1.m_4037();
            int var15 = f_5909.getWindow().getScaledWidth() / 2 + 20;
            int var16 = f_5909.getWindow().getScaledHeight() - 56;
            if (f_5909.player.getAir() < f_5909.player.getMaxAir()) {
               var16 -= 10;
            } else if (f_5909.player.getAbilities().creativeMode) {
               var16 += 8;
            }

            try (Util158.PhIPT3TwNL2N87b8 var17 = Util158.m_3873()) {
               for (EquipmentSlot var10 : f_4775) {
                  ItemStack var11 = f_5909.player.getEquippedStack(var10);
                  if (!var11.isEmpty()) {
                     Util158.m_1974(var14, var11, var15, var16, 1.0F, -1, 1.0F);
                     var15 += 18;
                  }
               }
            }
         }
      }
   }

   public static void m_507() {
      RenderUtil2.m_1647();
   }

   @EventHandler(
      priority = -200
   )
   public void m_999(Util169 var1) {
      if (this.f_4776.I(f_4847)) {
         this.f_4779.m_4(var1);
      }

      if (this.f_4776.I(f_4848)) {
         this.f_4780.m_4(var1);
      }

      if (this.f_4776.I(f_4849)) {
         this.f_4781.m_4(var1);
      }

      if (this.f_4776.I(f_4850)) {
         this.f_4782.m_4(var1);
      }

      if (this.f_4776.I(f_4851)) {
         this.f_4783.m_4(var1);
      }

      if (this.f_4776.I(f_4852)) {
         this.f_4784.m_4(var1);
      }

      if (this.f_4776.I(f_4853)) {
         this.f_4785.m_4(var1);
      }

      if (this.f_4776.I(f_4854)) {
         this.f_4786.m_4(var1);
      }

      if (this.f_4776.I(f_4855)) {
         this.m_3910(var1);
      }
   }

   public static void m_2589(DrawContext var0, float var1, float var2, float var3, float var4, String var5, String var6, float var7, boolean var8) {
      float var9 = Math.max(0.0F, Math.min(1.0F, var7));
      if (!(var9 <= 0.0F) && !(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         if (m_886(255) > 0) {
            Util158.m_3998(var1, var2, var3, var4, f_4833, Util71.m_756(20, 20, 25, m_886(150)), var9);
            int var10 = Util71.m_756(15, 15, 21, m_886(Math.round(f_4834 * var9)));
            int var11 = Util71.m_756(122, 122, 122, m_886((int)(f_4835 * var9)));
            if (var8) {
               Util158.m_3939(var1, var2, var3, f_4836, f_4837, f_4838, 0.0F, 0.0F, var10);
               RenderUtil25.m_1557(var0, var1, var2 + f_4839, var3, f_4840, var11);
            }
         }

         Util93.f_6000[18].m_2915(var0, var5, var1 - f_4841 + var3, var2 + f_4842, Util71.m_1907(EnergyClient.getTheme(0), var9));
         Util93.f_6003[15].m_2915(var0, var6, var1 + f_4843, var2 + f_4844, Util71.m_1907(-1, var9));
      }
   }

   public static void m_3767(float var0, float var1, float var2, float var3) {
      RenderUtil2.m_3624(var0, var1 + f_4831, var2, Math.max(0.0F, var3 - f_4832));
   }

   @EventHandler
   public void m_651(Util170 var1) {
      if (this.f_4776.I(f_4845)) {
         this.f_4783.m_18(var1);
      }

      if (this.f_4776.I(f_4846)) {
         this.f_4784.m_18(var1);
      }
   }

   public static float m_541(String var0) {
      return Math.max(f_4828, f_4829 + Util93.f_6003[15].m_585(var0));
   }

   public static int m_886(int var0) {
      Interface var1 = InitManager.f_2740.f_2741.moduleInterface;
      return var1 != null && var1.f_4777.m_1163() ? 0 : var0;
   }

   public static Util165 m_505(float var0) {
      Util165 var1 = new Util165(Util153.EASE_OUT_CUBIC, f_4830);
      m_3516(var1, var0);
      return var1;
   }

   public static final class emY4NusW0vk412rT {
      private final Util165 f_739;
      private final Util165 f_740;
      private final Util165 f_741;
      private boolean f_742;
      private static final long f_743 = 200L;
      private static final long f_744 = 200L;
      private static final long f_745 = 200L;
      private static final float f_746 = 22.0F;
      private static final float f_747 = 16.0F;
      private static final float f_748 = 70.0F;
      private static final float f_749 = 22.0F;
      private static final float f_750 = 22.0F;

      public float m_1470() {
         return Math.max(0.0F, (float)this.f_741.m_2276());
      }

      public float m_2289() {
         return Math.max(f_750, (float)(this.f_740.m_2276() + this.f_741.m_2276()));
      }

      public float m_3331() {
         return Math.max(1.0F, (float)this.f_739.m_2276());
      }

      public void m_1901(float var1, int var2) {
         float var3 = f_746 + var2 * f_747;
         float var4 = var2 > 0 ? 2.0F : 0.0F;
         if (!this.f_742) {
            Interface.m_3516(this.f_739, Math.max(1.0F, Math.min(f_748, var1)));
            Interface.m_3516(this.f_740, f_749);
            Interface.m_3516(this.f_741, 0.0F);
            this.f_742 = true;
         }

         this.f_739.m_3631(var1);
         this.f_740.m_3631(var3);
         this.f_741.m_3631(var4);
      }

      public emY4NusW0vk412rT() {
         this.f_739 = new Util165(Util153.EASE_OUT_CUBIC, f_743);
         this.f_740 = new Util165(Util153.EASE_OUT_CUBIC, f_744);
         this.f_741 = new Util165(Util153.EASE_OUT_CUBIC, f_745);
      }
   }
}
