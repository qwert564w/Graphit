package su.energyclient.module.render;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import su.energyclient.EnergyClient;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.Setting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util112;
import su.energyclient.util.Util153;
import su.energyclient.util.Util156;
import su.energyclient.util.Util158;
import su.energyclient.util.Util165;
import su.energyclient.util.Util169;
import su.energyclient.util.Util71;
import su.energyclient.util.Util93;

public class Arraylist extends Util156 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_805 = 14.0F;
   private static final float f_806 = 0.0F;
   private final Interface f_807;
   private final Util165 f_808;
   private static final long f_809 = 200L;
   private static final float f_810 = 0.01F;
   private static final String f_811 = "ArrayList";
   private static final float f_812 = 8.0F;
   private static final float f_813 = 8.0F;
   private static final float f_814 = 14.0F;
   private static final float f_815 = 0.01F;
   private static final float f_816 = 8.0F;
   private static final float f_817 = 7.5F;
   private static final float f_818 = 0.2F;
   private static final int f_819 = 1315865;
   private static final float f_820 = 14.0F;
   private static final float f_821 = 0.5F;
   private static final float f_822 = 14.0F;
   private static final float f_823 = 0.5F;
   private static final float f_824 = 14.0F;
   private static final float f_825 = 4.0F;
   private static final float f_826 = 4.0F;
   private static final float f_827 = 5.5F;
   private static final float f_828 = 5.5F;
   private static final float f_829 = 14.0F;
   private static final float f_830 = 14.0F;
   private static final float f_831 = 14.0F;
   private static final float f_832 = 0.5F;
   private static final float f_833 = 14.0F;
   private static final float f_834 = 0.5F;
   private static final float f_835 = 14.0F;
   private static final String f_836 = "ArrayList";
   private static final float f_837 = 4.0F;
   private static final float f_838 = 4.0F;
   private static final float f_839 = 5.5F;
   private static final double f_840 = 0.01;
   private static final double f_841 = 0.01;

   private void m_3174(DrawContext var1, float var2, float var3, float var4, float var5, boolean var6) {
      int var7 = Util71.m_1907(EnergyClient.getTheme(0), var5);
      int var8 = Util71.m_756(20, 20, 25, Interface.m_886(160));
      Util158.m_1031(var2, var3, var4, f_831, 0.0F, var8, var5);
      if (var6) {
         Util158.m_1849(var2 - f_832, var3, 1.0F, f_833, 0.0F, var7);
      } else {
         Util158.m_1849(var2 + var4 - f_834, var3, 1.0F, f_835, 0.0F, var7);
      }

      String var9 = f_836;
      float var10 = var6 ? var2 + f_837 : var2 + var4 - Util93.f_6001[15].m_585(var9) - f_838;
      Util93.f_6001[15].m_2915(var1, var9, var10, var3 + f_839, var7);
   }

   @Override
   public void m_4(Util169 var1) {
      if (Util93.f_6002[15] != null) {
         ObjectListIterator var2 = InitManager.f_2740.f_2741.m_3515().iterator();

         while (var2.hasNext()) {
            Module var3 = (Module)var2.next();
            var3.m_2432().m_3631(var3.m_677() ? 1.0 : 0.0);
         }

         List<Module> var33 = InitManager.f_2740
            .f_2741
            .m_3515()
            .stream()
            .filter(this::m_3208)
            .filter(var0 -> var0.m_2432().m_2276() > f_841)
            .sorted(Comparator.comparingDouble(this::m_219).reversed())
            .toList();
         boolean var34 = f_5909.currentScreen instanceof ChatScreen || !var33.isEmpty();
         this.f_808.m_3631(var34 ? 1.0 : 0.0);
         float var4 = (float)this.f_808.m_2276();
         if (var4 <= f_810) {
            this.f_10920.m_1597(0.0F);
            this.f_10920.m_1076(0.0F);
         } else {
            DrawContext var5 = var1.m_4037();
            float var6 = this.f_10920.m_2838();
            float var7 = this.f_10920.m_671();
            float var8 = Util93.f_6001[15].m_585(f_811) + f_812;
            float var9 = var8;

            for (Module var11 : var33) {
               var9 = Math.max(var9, this.m_219(var11) + f_813);
            }

            boolean var35 = this.m_3907(var6, var9);
            if (var33.isEmpty()) {
               this.m_3174(var5, var6, var7, var9, var4, var35);
               this.f_10920.m_1597(var9);
               this.f_10920.m_1076(f_814);
            } else {
               float var36 = 0.0F;
               int var12 = 0;

               for (Module var14 : var33) {
                  float var15 = (float)var14.m_2432().m_2276();
                  float var16 = var15 * var4;
                  if (!(var16 <= f_815)) {
                     String var17 = var14.m_1199().toLowerCase();
                     String var18 = this.f_807.I.m_1163() ? this.m_899(var14) : "";
                     boolean var19 = !var18.isEmpty();
                     float var20 = Util93.f_6002[15].m_585(var17);
                     float var21 = var19 ? Util93.f_6002[15].m_585(" " + var18) : 0.0F;
                     float var22 = var20 + var21 + f_816;
                     float var23 = (1.0F - var15) * f_817;
                     float var24 = var35 ? var6 - var23 : var6 + (var9 - var22) + var23;
                     float var25 = var7 + var36;
                     int var26 = EnergyClient.getTheme(0);
                     int var27 = Util71.m_2101(var26, f_818);
                     int var28 = Util71.m_1784(5, var12 * 30, var26, var27);
                     int var29 = Util71.m_1907(var28, var16);
                     int var30 = Util71.m_3389(f_819, Interface.m_886(100));
                     Util158.m_1031(var24, var25, var22, f_820, 0.0F, var30, var16);
                     if (var35) {
                        Util158.m_1849(var24 - f_821, var25, 2.0F, f_822, 0.0F, var29);
                     } else {
                        Util158.m_1849(var24 + var22 - f_823, var25, 2.0F, f_824, 0.0F, var29);
                     }

                     float var31 = var35 ? var24 + f_825 : var24 + var22 - var20 - var21 - f_826;
                     Util93.f_6002[15].m_2915(var5, var17, var31, var25 + f_827, var29);
                     if (var19) {
                        int var32 = Util71.m_1907(-1, var16);
                        Util93.f_6002[15].m_2915(var5, " " + var18, var31 + var20, var25 + f_828, var32);
                     }

                     var36 += f_829 * var15 - 2.0F;
                     var12++;
                  }
               }

               this.f_10920.m_1597(var9);
               this.f_10920.m_1076(Math.max(f_830, var36));
            }
         }
      }
   }

   private String m_899(Module var1) {
      ObjectListIterator var2 = var1.m_179().iterator();

      while (var2.hasNext()) {
         Setting var3 = (Setting)var2.next();
         if (var3 instanceof ModeSetting var4 && var4.m_1326()) {
            String var5 = var4.m_3862();
            if (var5 != null && !var5.isEmpty()) {
               return var5.toLowerCase();
            }
         }
      }

      return "";
   }

   private boolean m_3208(Module var1) {
      return !this.f_807.f_4778.m_1163() || var1.m_2409() != Category.RENDER && var1.m_2409() != Category.MISCELLANEOUS
         ? var1.m_677() || var1.m_2432().m_2276() > f_840
         : false;
   }

   public Arraylist(Util112 var1, Interface var2) {
      super(var1);
      this.f_808 = new Util165(Util153.LINEAR, f_809);
      this.f_807 = var2;
   }

   private boolean m_3907(float var1, float var2) {
      if (f_5909.getWindow() == null) {
         return true;
      } else {
         float var3 = f_5909.getWindow().getScaledWidth() / 2.0F;
         return var1 + var2 / 2.0F <= var3;
      }
   }

   private float m_219(Module var1) {
      float var2 = Util93.f_6001[15].m_585(var1.m_1199().toLowerCase());
      if (!this.f_807.I.m_1163()) {
         return var2;
      } else {
         String var3 = this.m_899(var1);
         return (float)(var3.isEmpty() ? var2 : var2 + Util93.f_6001[15].m_585(" " + var3));
      }
   }
}
