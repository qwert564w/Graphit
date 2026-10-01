package su.energyclient.module.render;

import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.render.OutlineVertexConsumerProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import su.energyclient.EnergyClient;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil28;
import su.energyclient.render.RenderUtil6;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util139;
import su.energyclient.util.Util63;
import su.energyclient.util.Util71;

public class ShaderEsp extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final ModeSetting f_5728;
   private final ModeSetting f_5729;
   private final ModeSetting f_5730;
   private final NumberSetting f_5731;
   private final NumberSetting f_5732;
   private final NumberSetting f_5733;
   private final Util63 f_5734;
   public static ShaderEsp f_5735;
   public static Entity f_5736 = null;
   public static boolean f_5737;
   public static boolean f_5738 = false;
   private Util139 f_5739;
   private OutlineVertexConsumerProvider f_5740;
   private static final String f_5741 = "Shader ESP";
   private static final String f_5742 = "Красивые эффекты для энтити";
   private static final String f_5743 = "Режим";
   private static final String f_5744 = "С шейдером";
   private static final String f_5745 = "С шейдером";
   private static final String f_5746 = "Только шейдер";
   private static final String f_5747 = "Режим цвета";
   private static final String f_5748 = "Интерфейс";
   private static final String f_5749 = "Интерфейс";
   private static final String f_5750 = "Один цвет";
   private static final String f_5751 = "Радуга";
   private static final String f_5752 = "Два цвета";
   private static final String f_5753 = "Эффект обводки";
   private static final String f_5754 = "Выкл";
   private static final String f_5755 = "Контур";
   private static final String f_5756 = "Свечение";
   private static final String f_5757 = "Свечение с контуром";
   private static final String f_5758 = "Выкл";
   private static final String f_5759 = "Качество свечения";
   private static final String f_5760 = "Радиус свечения";
   private static final float f_5761 = 10.0F;
   private static final float f_5762 = 0.1F;
   private static final String f_5763 = "Заливка";
   private static final float f_5764 = 50.0F;
   private static final float f_5765 = 100.0F;
   private static final String f_5766 = "Отображать";
   private static final String f_5767 = "Игроки";
   private static final String f_5768 = "Голые";
   private static final String f_5769 = "Мобы";
   private static final String f_5770 = "Кристаллы";
   private static final String f_5771 = "Предметы";
   private static final String f_5772 = "energy";
   private static final String f_5773 = "entityshader/postprocess";
   private static final String f_5774 = "Свечение с контуром";
   private static final float f_5775 = 100.0F;
   private static final String f_5776 = "Контур";
   private static final String f_5777 = "Двойное свечение";
   private static final String f_5778 = "Свечение с контуром";
   private static final String f_5779 = "Радуга";
   private static final String f_5780 = "Два цвета";
   private static final float f_5781 = 0.5F;
   private static final String f_5782 = "Игроки";
   private static final String f_5783 = "Голые";
   private static final String f_5784 = "Мобы";
   private static final String f_5785 = "Кристаллы";
   private static final String f_5786 = "Предметы";
   private static final String f_5787 = "С шейдером";
   private static final String f_5788 = "Только шейдер";
   private static final String f_5789 = "С шейдером";
   private static final String f_5790 = "timeMult";
   private static final String f_5791 = "color1";
   private static final String f_5792 = "color2";
   private static final String f_5793 = "noAlphaMode";
   private static final String f_5794 = "colorMode";
   private static final String f_5795 = "blurState";
   private static final String f_5796 = "blurMix";
   private static final String f_5797 = "glowQuality";
   private static final String f_5798 = "glowRadius";
   private static final String f_5799 = "glowAlphaMult";
   private static final String f_5800 = "glowThinOutline";
   private static final String f_5801 = "glowLogic";
   private static final String f_5802 = "fillAlphaMult";
   private static final String f_5803 = "colorRadius";
   private static final float f_5804 = 0.1F;
   private static final String f_5805 = "centred";
   private static final String f_5806 = "saturation";
   private static final String f_5807 = "brightness";
   private static final String f_5808 = "Свечение";
   private static final String f_5809 = "Свечение с контуром";
   private static final String f_5810 = "Свечение";
   private static final String f_5811 = "Свечение с контуром";

   private float[] m_2652() {
      int var1 = Util71.m_1907(EnergyClient.getTheme(0), 1.0F);
      return Util71.m_2326(var1);
   }

   public boolean m_1090(boolean var1) {
      if (this.m_677() && this.m_631() && var1) {
         Framebuffer var2 = f_5909.worldRenderer.getEntityOutlinesFramebuffer();
         if (var2 != null && f_5738) {
            Util139 var3 = this.m_2638();
            var3.m_533();
            RenderUtil28.m_2280(var2, f_5909.getWindow().getFramebufferWidth(), f_5909.getWindow().getFramebufferHeight());
            var3.m_410();
            if (!this.m_2057()) {
               RenderUtil6.m_676(var2);
            }
         }

         return false;
      } else {
         return !var1;
      }
   }

   public void m_1072() {
      Util139 var1 = this.m_2638();
      int var2 = this.m_3855();
      int var3 = this.m_106();
      float[] var4 = this.m_2652();
      float[] var5 = this.m_3973();
      int var6 = (int)this.f_5731.m_134().floatValue();
      float var7 = this.f_5732.m_4046();
      int var8 = var2 == 4 && this.f_5730.m_2073(f_5774) ? 1 : 0;
      float var9 = this.f_5733.m_4046() / f_5775;
      var1.m_222(var8x -> {
         var8x.m_3395(f_5790).O(1.0F);
         var8x.m_3395(f_5791).m_46(var4[0], var4[1], var4[2], var4[3]);
         var8x.m_3395(f_5792).m_46(var5[0], var5[1], var5[2], var5[3]);
         var8x.m_3395(f_5793).m_55(var2);
         var8x.m_3395(f_5794).m_55(var3);
         var8x.m_3395(f_5795).m_55(0);
         var8x.m_3395(f_5796).O(0.0F);
         var8x.m_3395(f_5797).m_55(var6);
         var8x.m_3395(f_5798).O(var7);
         var8x.m_3395(f_5799).O(1.0F);
         var8x.m_3395(f_5800).m_55(var8);
         var8x.m_3395(f_5801).m_55(0);
         var8x.m_3395(f_5802).O(var9);
         var8x.m_3395(f_5803).O(f_5804);
         var8x.m_3395(f_5805).m_55(0);
         var8x.m_3395(f_5806).O(1.0F);
         var8x.m_3395(f_5807).O(1.0F);
      });
   }

   public ShaderEsp() {
      super(f_5741, f_5742, Category.RENDER);
      this.f_5728 = new ModeSetting(f_5743, f_5744, f_5745, f_5746);
      this.f_5729 = new ModeSetting(f_5747, f_5748, f_5749, f_5750, f_5751, f_5752);
      this.f_5730 = new ModeSetting(f_5753, f_5754, f_5755, f_5756, f_5757, f_5758);
      this.f_5731 = new NumberSetting(f_5759, 1.0F, 1.0F, 2.0F, 1.0F).m_356(() -> this.f_5730.m_2073(f_5810) || this.f_5730.m_2073(f_5811));
      this.f_5732 = new NumberSetting(f_5760, 1.0F, 1.0F, f_5761, f_5762).m_356(() -> this.f_5730.m_2073(f_5808) || this.f_5730.m_2073(f_5809));
      this.f_5733 = new NumberSetting(f_5763, f_5764, 0.0F, f_5765, 1.0F);
      this.f_5734 = new Util63(
         f_5766,
         new BooleanSetting(f_5767, true),
         new BooleanSetting(f_5768, true),
         new BooleanSetting(f_5769, false),
         new BooleanSetting(f_5770, true),
         new BooleanSetting(f_5771, false)
      );
      f_5735 = this;
   }

   public boolean m_2057() {
      return this.f_5728.m_2073(f_5789);
   }

   public OutlineVertexConsumerProvider m_1633() {
      if (this.f_5740 == null) {
         this.f_5740 = new OutlineVertexConsumerProvider();
      }

      return this.f_5740;
   }

   public void m_1441() {
      if (f_5738) {
         RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
         this.m_1072();
         this.m_2638().m_843();
         f_5738 = false;
      }
   }

   private int m_106() {
      String var1 = this.f_5729.m_3862();

      return switch (var1) {
         case f_5779 -> 2;
         case f_5780 -> 3;
         default -> 1;
      };
   }

   private boolean m_631() {
      return this.f_5728.m_2073(f_5787) || this.f_5728.m_2073(f_5788);
   }

   private float[] m_3973() {
      int var1 = Util71.m_1907(EnergyClient.getTheme(0), f_5781);
      return Util71.m_2326(var1);
   }

   private int m_3855() {
      String var1 = this.f_5730.m_3862();

      return switch (var1) {
         case f_5776 -> 3;
         case f_5777, f_5778 -> 4;
         default -> 0;
      };
   }

   public boolean m_3636(Entity var1) {
      if (!this.m_677() || !this.m_631() || var1 == null) {
         return false;
      } else if (var1 instanceof PlayerEntity var2) {
         return !this.f_5734.I(f_5782) ? false : this.f_5734.I(f_5783) || var2.getArmor() > 0;
      } else if (var1 instanceof MobEntity) {
         return this.f_5734.I(f_5784);
      } else if (var1 instanceof EndCrystalEntity) {
         return this.f_5734.I(f_5785);
      } else {
         return var1 instanceof ItemEntity ? this.f_5734.I(f_5786) : false;
      }
   }

   public Util139 m_2638() {
      if (this.f_5739 == null) {
         this.f_5739 = new Util139(f_5772, f_5773);
         this.f_5739.m_2339();
      }

      return this.f_5739;
   }
}
