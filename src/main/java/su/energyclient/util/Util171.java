package su.energyclient.util;

import java.util.Locale;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Util171 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final float f_7780 = 50.0F;
   private final Item f_7781;
   private final String f_7782;
   private final long f_7783;
   private final long f_7784;
   private static final int f_7785 = 2764339;
   private static final float f_7786 = 0.88F;
   private static final int f_7787 = 1777186;
   private static final float f_7788 = 0.88F;
   private static final float f_7789 = 50.0F;
   private static final float f_7790 = 4.0F;
   private static final float f_7791 = 255.0F;
   private static final float f_7792 = 0.8F;
   private static final float f_7793 = 0.8F;
   private static final float f_7794 = 1.6F;
   private static final float f_7795 = 48.4F;
   private static final float f_7796 = 3.5F;
   private static final int f_7797 = 1119255;
   private static final float f_7798 = 0.7F;
   private static final float f_7799 = 8.0F;
   private static final float f_7800 = 9.0F;
   private static final float f_7801 = 32.0F;
   private static final float f_7802 = 8.0F;
   private static final float f_7803 = 8.0F;
   private static final float f_7804 = 10.0F;
   private static final float f_7805 = 9.0F;
   private static final float f_7806 = 8.0F;
   private static final float f_7807 = 50.0F;
   private static final int f_7808 = 16777215;
   private static final float f_7809 = 0.68F;
   private static final int f_7810 = 16777215;
   private static final float f_7811 = 0.62F;
   private static final int f_7812 = 16777215;
   private static final float f_7813 = 0.26F;
   private static final String f_7814 = "%,d";
   private static final long f_7815 = 1000L;
   private static final long f_7816 = 60L;
   private static final String f_7817 = "Меньше минуты назад";
   private static final long f_7818 = 60L;
   private static final long f_7819 = 60L;
   private static final long f_7820 = 60L;
   private static final long f_7821 = 24L;
   private static final long f_7822 = 24L;

   private static String m_3070(long var0) {
      return String.format(Locale.US, f_7814, var0);
   }

   public Util171(Item var1, String var2, long var3, long var5) {
      this.f_7781 = var1;
      this.f_7782 = var2;
      this.f_7783 = var3;
      this.f_7784 = var5;
   }

   public void m_1674(DrawContext var1, float var2, float var3, float var4, int var5) {
      int var6 = Util71.m_3389(f_7785, (int)(var5 * f_7786));
      int var7 = Util71.m_3389(f_7787, (int)(var5 * f_7788));
      Util158.m_3404(var2, var3, var4, f_7789, f_7790, var6, var7, var6, var7, var5 / f_7791);
      Util158.m_1849(var2 + f_7792, var3 + f_7793, var4 - f_7794, f_7795, f_7796, Util71.m_3389(f_7797, (int)(var5 * f_7798)));
      float var8 = var2 + f_7799;
      float var9 = var3 + f_7800;
      Util158.m_1974(var1, new ItemStack(this.f_7781), var8, var9, 2.0F, -1, 1.0F);
      float var10 = var8 + f_7801 + f_7802;
      float var11 = var4 - var10 + var2 - f_7803;
      float var12 = f_7804;
      float var13 = f_7805;
      float var14 = f_7806;
      float var15 = 1.0F;
      float var16 = var12 + var15 + var13 + var15 + var14;
      float var17 = var3 + (f_7807 - var16) / 2.0F;
      Util93.f_6001[14].m_1904(var1, this.f_7782, var10, var17, Util71.m_3389(f_7808, (int)(var5 * f_7809)), var11);
      Util93.f_6001[12].m_1904(var1, "Куплен за $" + m_3070(this.f_7783), var10, var17 + var12 + var15, Util71.m_3389(f_7810, (int)(var5 * f_7811)), var11);
      Util93.f_6001[11].m_1904(var1, m_1658(this.f_7784), var10, var17 + var12 + var15 + var13 + var15, Util71.m_3389(f_7812, (int)(var5 * f_7813)), var11);
   }

   private static String m_1658(long var0) {
      long var2 = (System.currentTimeMillis() - var0) / f_7815;
      if (var2 < f_7816) {
         return f_7817;
      } else {
         long var4 = var2 / f_7818;
         if (var4 < f_7819) {
            return var4 + " мин. назад";
         } else {
            long var6 = var4 / f_7820;
            if (var6 < f_7821) {
               return var6 + " ч. назад";
            } else {
               long var8 = var6 / f_7822;
               return var8 + " дн. назад";
            }
         }
      }
   }
}
