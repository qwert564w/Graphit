package su.energyclient.module.render;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import su.energyclient.EnergyClient;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil13;
import su.energyclient.render.RenderUtil28;
import su.energyclient.render.RenderUtil6;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util139;
import su.energyclient.util.Util71;

public class Shaderhands extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final String f_8775 = "С шейдером";
   public static final String f_8776 = "";
   public static final String f_8777 = "";
   public static final String f_8778 = "";
   public static final String f_8779 = "";
   public static final String f_8780 = "";
   public static final String f_8781 = "";
   private static final float f_8782 = 0.0F;
   private final ModeSetting f_8783;
   private final ModeSetting f_8784;
   private final ModeSetting f_8785;
   private final NumberSetting f_8786;
   private final NumberSetting f_8787;
   private final NumberSetting f_8788;
   private final NumberSetting f_8789;
   private final NumberSetting f_8790;
   private final NumberSetting f_8791;
   private final NumberSetting f_8792;
   private final NumberSetting f_8793;
   private final NumberSetting f_8794;
   private final NumberSetting f_8795;
   private final NumberSetting f_8796;
   private final BooleanSetting f_8797;
   private final NumberSetting f_8798;
   private final BooleanSetting f_8799;
   private final ModeSetting f_8800;
   private final NumberSetting f_8801;
   private final NumberSetting f_8802;
   private final NumberSetting f_8803;
   private final NumberSetting f_8804;
   private final NumberSetting f_8805;
   private final BooleanSetting f_8806;
   private final NumberSetting f_8807;
   private final BooleanSetting f_8808;
   private final NumberSetting f_8809;
   private final NumberSetting f_8810;
   private final NumberSetting f_8811;
   private final NumberSetting f_8812;
   private final NumberSetting f_8813;
   private final NumberSetting f_8814;
   private final NumberSetting f_8815;
   private final NumberSetting f_8816;
   private final NumberSetting f_8817;
   private final NumberSetting f_8818;
   private final NumberSetting f_8819;
   private final NumberSetting f_8820;
   private final NumberSetting f_8821;
   private final NumberSetting I;
   private final BooleanSetting f_8822;
   public static Shaderhands f_8823;
   private Util139 f_8824;
   private static final String f_8825 = "ShaderHands";
   private static final String f_8826 = "ShaderESP shader on hands";
   private static final String f_8827 = "Режим";
   private static final String f_8828 = "Красивый";
   private static final String f_8829 = "С шейдером";
   private static final String f_8830 = "Только шейдер";
   private static final String f_8831 = "Красивый";
   private static final String f_8832 = "Свечение";
   private static final String f_8833 = "Glass";
   private static final String f_8834 = "Режим цвета";
   private static final String f_8835 = "Интерфейс";
   private static final String f_8836 = "Интерфейс";
   private static final String f_8837 = "Один цвет";
   private static final String f_8838 = "Радуга";
   private static final String f_8839 = "Два цвета";
   private static final String f_8840 = "Эффект обводки";
   private static final String f_8841 = "Выкл";
   private static final String f_8842 = "Контур";
   private static final String f_8843 = "Свечение";
   private static final String f_8844 = "Свечение с контуром";
   private static final String f_8845 = "Выкл";
   private static final String f_8846 = "Качество свечения";
   private static final String f_8847 = "Радиус свечения";
   private static final float f_8848 = 10.0F;
   private static final float f_8849 = 0.1F;
   private static final String f_8850 = "Заливка";
   private static final float f_8851 = 50.0F;
   private static final float f_8852 = 100.0F;
   private static final String f_8853 = "Скорость волн";
   private static final float f_8854 = 1.2F;
   private static final float f_8855 = 0.1F;
   private static final float f_8856 = 5.0F;
   private static final float f_8857 = 0.1F;
   private static final String f_8858 = "Частота волн";
   private static final float f_8859 = 3.0F;
   private static final float f_8860 = 0.1F;
   private static final String f_8861 = "Ширина обводки";
   private static final float f_8862 = 1.2F;
   private static final float f_8863 = 0.1F;
   private static final float f_8864 = 5.0F;
   private static final float f_8865 = 0.1F;
   private static final String f_8866 = "Сила свечения";
   private static final float f_8867 = 0.05F;
   private static final String f_8868 = "Радиус свечения";
   private static final float f_8869 = 4.0F;
   private static final float f_8870 = 4.0F;
   private static final String f_8871 = "Разброс свечения";
   private static final float f_8872 = 4.0F;
   private static final float f_8873 = 0.1F;
   private static final String f_8874 = "Заливка";
   private static final float f_8875 = 0.6F;
   private static final float f_8876 = 0.05F;
   private static final String f_8877 = "Прозрачность";
   private static final float f_8878 = 0.05F;
   private static final String f_8879 = "Цвет предмета";
   private static final String f_8880 = "Насыщенность цвета";
   private static final float f_8881 = 1.4F;
   private static final float f_8882 = 0.5F;
   private static final float f_8883 = 3.0F;
   private static final float f_8884 = 0.1F;
   private static final String f_8885 = "Шлейф";
   private static final String f_8886 = "Тип шлейфа";
   private static final String f_8887 = "Обычный";
   private static final String f_8888 = "Обычный";
   private static final String f_8889 = "Энергичный";
   private static final String f_8890 = "Скорость затухания";
   private static final float f_8891 = 0.012F;
   private static final float f_8892 = 0.002F;
   private static final float f_8893 = 0.2F;
   private static final float f_8894 = 0.002F;
   private static final String f_8895 = "Подъём";
   private static final float f_8896 = 0.2F;
   private static final float f_8897 = 1.5F;
   private static final float f_8898 = 0.05F;
   private static final String f_8899 = "Качание";
   private static final float f_8900 = 0.05F;
   private static final float f_8901 = 0.2F;
   private static final float f_8902 = 0.005F;
   private static final String f_8903 = "Турбулентность";
   private static final float f_8904 = 0.6F;
   private static final float f_8905 = 0.01F;
   private static final String f_8906 = "Мерцание";
   private static final float f_8907 = 0.2F;
   private static final float f_8908 = 0.01F;
   private static final String f_8909 = "Сдув при ударе";
   private static final String f_8910 = "Сила сдува";
   private static final float f_8911 = 4.0F;
   private static final float f_8912 = 10.0F;
   private static final float f_8913 = 0.5F;
   private static final String f_8914 = "Шлейф модели";
   private static final String f_8915 = "Прозрачность модели";
   private static final float f_8916 = 0.6F;
   private static final float f_8917 = 0.1F;
   private static final float f_8918 = 0.05F;
   private static final String f_8919 = "Интенсивность";
   private static final float f_8920 = 1.4F;
   private static final float f_8921 = 0.5F;
   private static final float f_8922 = 4.0F;
   private static final float f_8923 = 0.1F;
   private static final String f_8924 = "Белое ядро";
   private static final float f_8925 = 0.6F;
   private static final float f_8926 = 0.05F;
   private static final String f_8927 = "Пульсация";
   private static final float f_8928 = 0.25F;
   private static final float f_8929 = 0.05F;
   private static final String f_8930 = "Языки пламени";
   private static final float f_8931 = 0.8F;
   private static final float f_8932 = 0.05F;
   private static final String f_8933 = "Расширение";
   private static final float f_8934 = 0.35F;
   private static final float f_8935 = 1.5F;
   private static final float f_8936 = 0.05F;
   private static final String f_8937 = "Мягкость";
   private static final float f_8938 = 1.4F;
   private static final float f_8939 = 0.5F;
   private static final float f_8940 = 3.0F;
   private static final float f_8941 = 0.1F;
   private static final String f_8942 = "Аддитивное свечение";
   private static final float f_8943 = 0.8F;
   private static final float f_8944 = 1.5F;
   private static final float f_8945 = 0.05F;
   private static final String f_8946 = "Плотность";
   private static final float f_8947 = 0.45F;
   private static final float f_8948 = 0.05F;
   private static final String f_8949 = "Засветка рук";
   private static final float f_8950 = 0.35F;
   private static final float f_8951 = 0.05F;
   private static final String f_8952 = "Радиус размытия";
   private static final float f_8953 = 3.0F;
   private static final float f_8954 = 4.0F;
   private static final String f_8955 = "Сила размытия";
   private static final float f_8956 = 4.0F;
   private static final float f_8957 = 0.1F;
   private static final String f_8958 = "Прозрачность стекла";
   private static final float f_8959 = 0.05F;
   private static final String f_8960 = "Яркость";
   private static final float f_8961 = 0.2F;
   private static final float f_8962 = 0.05F;
   private static final String f_8963 = "Тонировка";
   private static final String f_8964 = "energy";
   private static final String f_8965 = "entityshader/postprocess";
   private static final String f_8966 = "Свечение с контуром";
   private static final float f_8967 = 100.0F;
   private static final String f_8968 = "С шейдером";
   private static final String f_8969 = "Только шейдер";
   private static final String f_8970 = "Красивый";
   private static final String f_8971 = "Свечение";
   private static final String f_8972 = "Glass";
   private static final String f_8973 = "Красивый";
   private static final float f_8974 = 0.001F;
   private static final float f_8975 = 0.001F;
   private static final float f_8976 = 0.001F;
   private static final String f_8977 = "Энергичный";
   private static final String f_8978 = "Энергичный";
   private static final float f_8979 = 0.5F;
   private static final float f_8980 = 1.5F;
   private static final String f_8981 = "Контур";
   private static final String f_8982 = "Двойное свечение";
   private static final String f_8983 = "Свечение с контуром";
   private static final String f_8984 = "Радуга";
   private static final String f_8985 = "Два цвета";
   private static final float f_8986 = 0.5F;
   private static final String f_8987 = "С шейдером";
   private static final String f_8988 = "timeMult";
   private static final String f_8989 = "color1";
   private static final String f_8990 = "color2";
   private static final String f_8991 = "noAlphaMode";
   private static final String f_8992 = "colorMode";
   private static final String f_8993 = "blurState";
   private static final String f_8994 = "blurMix";
   private static final String f_8995 = "glowQuality";
   private static final String f_8996 = "glowRadius";
   private static final String f_8997 = "glowAlphaMult";
   private static final String f_8998 = "glowThinOutline";
   private static final String f_8999 = "glowLogic";
   private static final String f_9000 = "fillAlphaMult";
   private static final String f_9001 = "colorRadius";
   private static final float f_9002 = 0.1F;
   private static final String f_9003 = "centred";
   private static final String f_9004 = "saturation";
   private static final String f_9005 = "brightness";
   private static final String f_9006 = "Свечение";
   private static final String f_9007 = "Свечение с контуром";
   private static final String f_9008 = "Свечение";
   private static final String f_9009 = "Свечение с контуром";

   public void m_2530(int var1, int var2) {
      if (this.f_8824 != null) {
         this.f_8824.m_2553(var1, var2);
      }

      RenderUtil13.m_4021().m_523();
   }

   public float m_3552() {
      return this.f_8803.m_4046();
   }

   public boolean m_1201() {
      return this.m_1179() && this.f_8792.m_4046() > f_8974;
   }

   public void I(HeldItemRenderer var1, float var2, MatrixStack var3, OrderedRenderCommandQueue var4, ClientPlayerEntity var5, int var6) {
      if (var5 != null) {
         if (this.m_447()) {
            var1.renderItem(var2, var3, var4, var5, var6);
         } else {
            Util139 var7 = this.m_3766();
            RenderUtil6.m_676(var7.f_10507);
            RenderUtil6.m_676(var7.f_10508);
            var7.m_533();
            var1.renderItem(var2, var3, var4, var5, var6);
            var7.m_410();
            if (this.m_1799()) {
               RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
               Util114.m_1481();
               Util114.m_542();
               RenderUtil28.m_2280(var7.f_10507, f_5909.getWindow().getFramebufferWidth(), f_5909.getWindow().getFramebufferHeight());
               Util114.m_963();
            }

            RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
            this.m_2209();
            var7.m_843();
         }
      }
   }

   public float m_3358() {
      return this.f_8794.m_4046();
   }

   public boolean m_831() {
      return this.m_1201() && this.f_8799.m_1163();
   }

   public boolean m_447() {
      return this.m_1179() || this.m_3321();
   }

   public float m_1676() {
      return this.f_8801.m_4046();
   }

   public float m_2031() {
      return this.f_8811.m_4046();
   }

   public boolean m_2255() {
      return !this.m_1179() ? false : this.m_1201() || this.f_8795.m_4046() > f_8975 && this.f_8796.m_4046() > f_8976;
   }

   public float m_511() {
      return this.f_8796.m_4046();
   }

   public float m_1915() {
      return this.f_8814.m_4046();
   }

   public boolean m_320() {
      return this.m_831() && this.f_8800.m_2073(f_8977);
   }

   public float m_3925() {
      return this.f_8812.m_4046();
   }

   public float m_130() {
      return this.f_8804.m_4046();
   }

   public float m_2108() {
      return this.f_8807.m_4046();
   }

   public Shaderhands() {
      super(f_8825, f_8826, Category.RENDER);
      this.f_8783 = new ModeSetting(f_8827, f_8828, f_8829, f_8830, f_8831, f_8832, f_8833);
      this.f_8784 = new ModeSetting(f_8834, f_8835, f_8836, f_8837, f_8838, f_8839).m_1263(this::m_3777);
      this.f_8785 = new ModeSetting(f_8840, f_8841, f_8842, f_8843, f_8844, f_8845).m_1263(this::m_3777);
      this.f_8786 = new NumberSetting(f_8846, 1.0F, 1.0F, 2.0F, 1.0F).m_356(() -> this.m_3777() && (this.f_8785.m_2073(f_9008) || this.f_8785.m_2073(f_9009)));
      this.f_8787 = new NumberSetting(f_8847, 1.0F, 1.0F, f_8848, f_8849)
         .m_356(() -> this.m_3777() && (this.f_8785.m_2073(f_9006) || this.f_8785.m_2073(f_9007)));
      this.f_8788 = new NumberSetting(f_8850, f_8851, 0.0F, f_8852, 1.0F).m_356(this::m_3777);
      this.f_8789 = new NumberSetting(f_8853, f_8854, f_8855, f_8856, f_8857).m_356(this::m_2377);
      this.f_8790 = new NumberSetting(f_8858, 1.0F, 1.0F, f_8859, f_8860).m_356(this::m_2377);
      this.f_8791 = new NumberSetting(f_8861, f_8862, f_8863, f_8864, f_8865).m_356(this::m_1179);
      this.f_8792 = new NumberSetting(f_8866, 1.0F, 0.0F, 1.0F, f_8867).m_356(this::m_1179);
      this.f_8793 = new NumberSetting(f_8868, f_8869, 1.0F, f_8870, 1.0F).m_356(this::m_1201);
      this.f_8794 = new NumberSetting(f_8871, 2.0F, 1.0F, f_8872, f_8873).m_356(this::m_1201);
      this.f_8795 = new NumberSetting(f_8874, f_8875, 0.0F, 1.0F, f_8876).m_356(this::m_1179);
      this.f_8796 = new NumberSetting(f_8877, 1.0F, 0.0F, 1.0F, f_8878).m_356(this::m_1179);
      this.f_8797 = new BooleanSetting(f_8879, false).m_334(this::m_2255);
      this.f_8798 = new NumberSetting(f_8880, f_8881, f_8882, f_8883, f_8884).m_356(() -> this.m_2255() && this.f_8797.m_1163());
      this.f_8799 = new BooleanSetting(f_8885, true).m_334(this::m_1201);
      this.f_8800 = new ModeSetting(f_8886, f_8887, f_8888, f_8889).m_1263(this::m_1949);
      this.f_8801 = new NumberSetting(f_8890, f_8891, f_8892, f_8893, f_8894).m_356(this::m_1949);
      this.f_8802 = new NumberSetting(f_8895, f_8896, 0.0F, f_8897, f_8898).m_356(this::m_1949);
      this.f_8803 = new NumberSetting(f_8899, f_8900, 0.0F, f_8901, f_8902).m_356(this::m_1949);
      this.f_8804 = new NumberSetting(f_8903, 0.0F, 0.0F, f_8904, f_8905).m_356(this::m_1949);
      this.f_8805 = new NumberSetting(f_8906, 0.0F, 0.0F, f_8907, f_8908).m_356(this::m_1949);
      this.f_8806 = new BooleanSetting(f_8909, true).m_334(this::m_1949);
      this.f_8807 = new NumberSetting(f_8910, f_8911, 1.0F, f_8912, f_8913).m_356(() -> this.m_1949() && this.f_8806.m_1163());
      this.f_8808 = new BooleanSetting(f_8914, false).m_334(this::m_1949);
      this.f_8809 = new NumberSetting(f_8915, f_8916, f_8917, 1.0F, f_8918).m_356(() -> this.m_1949() && this.f_8808.m_1163());
      this.f_8810 = new NumberSetting(f_8919, f_8920, f_8921, f_8922, f_8923).m_356(this::m_3172);
      this.f_8811 = new NumberSetting(f_8924, f_8925, 0.0F, 1.0F, f_8926).m_356(this::m_3172);
      this.f_8812 = new NumberSetting(f_8927, f_8928, 0.0F, 1.0F, f_8929).m_356(this::m_3172);
      this.f_8813 = new NumberSetting(f_8930, f_8931, 0.0F, 2.0F, f_8932).m_356(this::m_3172);
      this.f_8814 = new NumberSetting(f_8933, f_8934, 0.0F, f_8935, f_8936).m_356(this::m_3172);
      this.f_8815 = new NumberSetting(f_8937, f_8938, f_8939, f_8940, f_8941).m_356(this::m_3172);
      this.f_8816 = new NumberSetting(f_8942, f_8943, 0.0F, f_8944, f_8945).m_356(this::m_3172);
      this.f_8817 = new NumberSetting(f_8946, f_8947, 0.0F, 1.0F, f_8948).m_356(this::m_3172);
      this.f_8818 = new NumberSetting(f_8949, f_8950, 0.0F, 1.0F, f_8951).m_356(this::m_3172);
      this.f_8819 = new NumberSetting(f_8952, f_8953, 1.0F, f_8954, 1.0F).m_356(this::m_3321);
      this.f_8820 = new NumberSetting(f_8955, 2.0F, 1.0F, f_8956, f_8957).m_356(this::m_3321);
      this.f_8821 = new NumberSetting(f_8958, 1.0F, 0.0F, 1.0F, f_8959).m_356(this::m_3321);
      this.I = new NumberSetting(f_8960, 1.0F, f_8961, 2.0F, f_8962).m_356(this::m_3321);
      this.f_8822 = new BooleanSetting(f_8963, true).m_334(this::m_3321);
      f_8823 = this;
   }

   public boolean m_3777() {
      return this.f_8783.m_2073(f_8968) || this.f_8783.m_2073(f_8969);
   }

   public boolean m_1949() {
      return this.m_1201() && this.f_8799.m_1163();
   }

   @Override
   public void m_1() {
      super.m_1();
      if (this.f_8824 != null) {
         this.f_8824.f_10507.delete();
         this.f_8824.f_10508.delete();
         this.f_8824 = null;
      }

      RenderUtil13.m_4021().m_1173();
      RenderUtil13.m_4021().m_523();
   }

   public float m_1531() {
      return this.f_8802.m_4046();
   }

   public float m_2144() {
      return this.f_8815.m_4046();
   }

   public float m_3600() {
      return f_8979 + this.f_8792.m_4046() * f_8980;
   }

   public float m_718() {
      return this.f_8790.m_4046();
   }

   public float m_3496() {
      return this.f_8809.m_4046();
   }

   private float[] m_650() {
      return Util71.m_2326(Util71.m_1907(EnergyClient.getTheme(0), f_8986));
   }

   public boolean m_1179() {
      return this.f_8783.m_2073(f_8970) || this.f_8783.m_2073(f_8971);
   }

   public int m_3398() {
      return Math.max(1, Math.round(this.f_8819.m_4046()));
   }

   public boolean m_2377() {
      return this.f_8783.m_2073(f_8973);
   }

   public float m_2914() {
      return this.f_8791.m_4046();
   }

   public float m_2595() {
      return this.f_8817.m_4046();
   }

   public boolean m_1232() {
      return this.f_8822.m_1163();
   }

   public float m_1730() {
      return this.f_8798.m_4046();
   }

   public float m_1578() {
      return this.f_8810.m_4046();
   }

   public float m_2397() {
      return this.f_8818.m_4046();
   }

   private float[] I() {
      return Util71.m_2326(Util71.m_1907(EnergyClient.getTheme(0), 1.0F));
   }

   public float m_3467() {
      return this.I.m_4046();
   }

   public float m_3393() {
      return this.f_8795.m_4046();
   }

   public boolean m_3172() {
      return this.m_1949() && this.f_8800.m_2073(f_8978);
   }

   public boolean m_3321() {
      return this.f_8783.m_2073(f_8972);
   }

   public boolean m_232() {
      return this.f_8806.m_1163();
   }

   public float m_2172() {
      return this.f_8821.m_4046();
   }

   public float m_4123() {
      return this.f_8820.m_4046();
   }

   public boolean m_859() {
      return this.m_447();
   }

   public float m_989() {
      return this.f_8792.m_4046();
   }

   public int m_988() {
      return Math.max(1, Math.round(this.f_8793.m_4046()));
   }

   public boolean m_4012() {
      return this.f_8797.m_1163();
   }

   public float m_3199() {
      return this.f_8813.m_4046();
   }

   public float m_1431() {
      return this.f_8805.m_4046();
   }

   public void m_2209() {
      Util139 var1 = this.m_3766();
      int var2 = this.m_1679();
      int var3 = this.l();
      float[] var4 = this.I();
      float[] var5 = this.m_650();
      int var6 = (int)this.f_8786.m_134().floatValue();
      float var7 = this.f_8787.m_4046();
      int var8 = var2 == 4 && this.f_8785.m_2073(f_8966) ? 1 : 0;
      float var9 = this.f_8788.m_4046() / f_8967;
      var1.m_222(var8x -> {
         var8x.m_3395(f_8988).O(1.0F);
         var8x.m_3395(f_8989).m_46(var4[0], var4[1], var4[2], var4[3]);
         var8x.m_3395(f_8990).m_46(var5[0], var5[1], var5[2], var5[3]);
         var8x.m_3395(f_8991).m_55(var2);
         var8x.m_3395(f_8992).m_55(var3);
         var8x.m_3395(f_8993).m_55(0);
         var8x.m_3395(f_8994).O(0.0F);
         var8x.m_3395(f_8995).m_55(var6);
         var8x.m_3395(f_8996).O(var7);
         var8x.m_3395(f_8997).O(1.0F);
         var8x.m_3395(f_8998).m_55(var8);
         var8x.m_3395(f_8999).m_55(0);
         var8x.m_3395(f_9000).O(var9);
         var8x.m_3395(f_9001).O(f_9002);
         var8x.m_3395(f_9003).m_55(0);
         var8x.m_3395(f_9004).O(1.0F);
         var8x.m_3395(f_9005).O(1.0F);
      });
   }

   public float m_2311() {
      return this.f_8816.m_4046();
   }

   private int l() {
      String var1 = this.f_8784.m_3862();

      return switch (var1) {
         case f_8984 -> 2;
         case f_8985 -> 3;
         default -> 1;
      };
   }

   public Util139 m_3766() {
      if (this.f_8824 == null) {
         this.f_8824 = new Util139(f_8964, f_8965);
         this.f_8824.m_2339();
      }

      return this.f_8824;
   }

   private int m_1679() {
      String var1 = this.f_8785.m_3862();

      return switch (var1) {
         case f_8981 -> 3;
         case f_8982, f_8983 -> 4;
         default -> 0;
      };
   }

   public boolean m_1808() {
      return this.f_8808.m_1163();
   }

   public float m_3135() {
      return this.f_8789.m_4046();
   }

   private boolean m_1799() {
      return this.f_8783.m_2073(f_8987);
   }
}
