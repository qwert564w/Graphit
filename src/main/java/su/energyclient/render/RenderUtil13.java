package su.energyclient.render;

import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.Window;
import net.minecraft.item.ItemStack;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.Shaderhands;
import su.energyclient.util.Util114;
import su.energyclient.util.Util24;
import su.energyclient.util.Util71;
import su.energyclient.util.Util98;
import su.energyclient.util.math.MathUtil6;

public final class RenderUtil13 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_1782 = 0.001F;
   private static final int f_1783 = 0;
   private static final int f_1784 = 0;
   private static RenderUtil13 f_1785;
   private Framebuffer f_1786;
   private Framebuffer f_1787;
   private Framebuffer f_1788;
   private Framebuffer f_1789;
   private Framebuffer f_1790;
   private Framebuffer f_1791;
   private final List<Framebuffer> f_1792 = new ArrayList<>();
   private int f_1793 = -1;
   private int f_1794 = -1;
   private boolean f_1795;
   private int f_1796 = -1;
   private int f_1797 = -1;
   private long f_1798;
   private float f_1799;
   private long f_1800;
   private boolean f_1801;
   private boolean f_1802;
   private boolean f_1803;
   private final float[] f_1804;
   private int f_1805;
   private int f_1806;
   private ByteBuffer f_1807;
   private final Deque<RenderUtil13.Inner_38O6aKiwE68GCGmc> f_1808;
   private static final float f_1809 = 0.016666668F;
   private static final long f_1810 = -10000L;
   private static final int f_1811 = Integer.MIN_VALUE;
   private static final float f_1812 = 1000.0F;
   private static final float f_1813 = 3000.0F;
   private static final float f_1814 = -2000.0F;
   private static final float f_1815 = 0.35F;
   private static final float f_1816 = 0.001F;
   private static final float f_1817 = 0.001F;
   private static final float f_1818 = 0.001F;
   private static final String f_1819 = "color";
   private static final String f_1820 = "fill";
   private static final String f_1821 = "alpha";
   private static final String f_1822 = "multiplier";
   private static final long f_1823 = -10000L;
   private static final int f_1824 = Integer.MIN_VALUE;
   private static final int f_1825 = 33071;
   private static final int f_1826 = 33069;
   private static final String f_1827 = "color";
   private static final String f_1828 = "exposure";
   private static final float f_1829 = 1.8F;
   private static final float f_1830 = 0.05F;
   private static final float f_1831 = 1000.0F;
   private static final float f_1832 = 0.016666668F;
   private static final float f_1833 = 0.7F;
   private static final float f_1834 = 0.3F;
   private static final long f_1835 = 100000L;
   private static final float f_1836 = 1000.0F;
   private static final float f_1837 = (float) (Math.PI * 8.0 / 5.0);
   private static final float f_1838 = 1000.0F;
   private static final float f_1839 = 0.35F;
   private static final float f_1840 = 0.025F;
   private static final String f_1841 = "offset";
   private static final String f_1842 = "texSize";
   private static final String f_1843 = "fade";
   private static final String f_1844 = "t";
   private static final String f_1845 = "dt";
   private static final String f_1846 = "turb";
   private static final String f_1847 = "flickAmp";
   private static final String f_1848 = "flames";
   private static final String f_1849 = "expand";
   private static final String f_1850 = "softness";
   private static final String f_1851 = "exposure";
   private static final String f_1852 = "intensity";
   private static final String f_1853 = "core";
   private static final String f_1854 = "pulse";
   private static final String f_1855 = "time";
   private static final float f_1856 = 0.001F;
   private static final float f_1857 = 0.001F;
   private static final float f_1858 = 0.001F;
   private static final String f_1859 = "texelSize";
   private static final String f_1860 = "color";
   private static final String f_1861 = "color2";
   private static final String f_1862 = "time";
   private static final long f_1863 = 100000L;
   private static final float f_1864 = 1000.0F;
   private static final String f_1865 = "speed";
   private static final String f_1866 = "scale";
   private static final String f_1867 = "outline";
   private static final String f_1868 = "glow";
   private static final String f_1869 = "fill";
   private static final String f_1870 = "alpha";
   private static final String f_1871 = "outlineOnly";
   private static final String f_1872 = "autoColor";
   private static final String f_1873 = "saturation";
   private static final int f_1874 = 36010;
   private static final int f_1875 = 36006;
   private static final int f_1876 = 36008;
   private static final int f_1877 = 36009;
   private static final int f_1878 = 36008;
   private static final int f_1879 = 36009;
   private static final int f_1880 = 34892;
   private static final int f_1881 = 34842;
   private static final int f_1882 = 33069;
   private static final int f_1883 = 33069;
   private static final float f_1884 = 0.001F;
   private static final float f_1885 = 0.001F;
   private static final float f_1886 = 0.001F;
   private static final String f_1887 = "autoColor";
   private static final String f_1888 = "saturation";
   private static final String f_1889 = "color";
   private static final String f_1890 = "color2";
   private static final String f_1891 = "autoColor";
   private static final String f_1892 = "saturation";
   private static final String f_1893 = "color";
   private static final String f_1894 = "color2";
   private static final int f_1895 = 36010;
   private static final int f_1896 = 36008;
   private static final int f_1897 = 36008;
   private static final float f_1898 = 255.0F;
   private static final float f_1899 = 255.0F;
   private static final float f_1900 = 255.0F;
   private static final float f_1901 = 255.0F;
   private static final float f_1902 = 0.02F;
   private static final float f_1903 = 0.001F;
   private static final float f_1904 = 0.001F;
   private static final float f_1905 = 0.299F;
   private static final float f_1906 = 0.587F;
   private static final float f_1907 = 0.114F;
   private static final float f_1908 = 255.0F;
   private static final float f_1909 = 255.0F;
   private static final float f_1910 = 255.0F;
   private static final String f_1911 = "uSize";
   private static final String f_1912 = "uOffset";
   private static final String f_1913 = "uHalfPixel";
   private static final float f_1914 = 0.5F;
   private static final float f_1915 = 0.5F;

   private void I(Shaderhands var1) {
      int var2 = var1.m_3398();
      float var3 = var1.m_4123();
      int var4 = this.m_1905(var2, RenderUtil6.m_668(this.f_1786.getColorAttachment()), var3, true);
      Util98 var5 = Util114.m_3784(Util24.f_3296);
      if (var5 == null) {
         this.m_822();
      } else {
         RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
         Util114.m_1481();
         Util114.m_3547(true, true, true, false);
         Util114.m_672();
         Util114.m_582(1, 771);
         Util114.m_2037(0, RenderUtil6.m_668(this.f_1788.getColorAttachment()));
         Util114.m_2037(1, var4);
         float[] var6 = var1.m_1232() ? Util71.m_2326(EnergyClient.getTheme(0)) : new float[]{1.0F, 1.0F, 1.0F};
         float var7 = var1.m_3467();
         float var8 = var1.m_2172();
         this.m_4065(var5, f_1822, var6[0] * var7, var6[1] * var7, var6[2] * var7, var8);
         this.m_1726();
         this.m_822();
      }
   }

   private void m_3823(Shaderhands var1) {
      if (var1.m_320() && this.f_1790 != null) {
         float var2 = var1.m_2397();
         if (!(var2 <= f_1858)) {
            RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
            Util114.m_1481();
            Util114.m_672();
            Util114.m_3547(true, true, true, false);
            Util114.m_582(1, 1);
            Util114.m_3158(var2, var2, var2, var2);
            if (Util114.m_3784(RenderUtil7.f_13886) != null) {
               Util114.m_2037(0, RenderUtil6.m_668(this.f_1790.getColorAttachment()));
               this.m_1726();
            }

            Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
            Util114.m_542();
            Util114.m_3547(true, true, true, true);
         }
      }
   }

   private void m_675(Shaderhands var1) {
      this.f_1803 = false;
      Util114.m_3706();
      boolean var2 = this.m_4137();

      try {
         if (var2) {
            this.m_2502(var1);
         }
      } finally {
         if (var2) {
            this.m_1568();
         }

         Util114.m_3706();
         this.m_1173();
      }
   }

   private int m_969() {
      Window var1 = f_5909.getWindow();
      return var1 != null ? Math.max(1, var1.getFramebufferWidth()) : Math.max(1, this.f_1793);
   }

   private void m_3662(Shaderhands var1, int var2, int var3, int var4, float var5) {
      Util114.m_1206(770, 1, 0, 1);
      Util98 var6 = Util114.m_3784(Util24.f_3287);
      if (var6 != null) {
         Util114.m_2037(0, var2);
         Util114.m_2037(1, RenderUtil6.m_668(this.f_1788.getColorAttachment()));
         float[] var7 = Util71.m_2326(var3);
         float[] var8 = Util71.m_2326(var4);
         this.m_1183(var6, var1, var7, var8);
         this.m_1349(var6, f_1828, 1.0F + var5 * f_1829);
         this.m_1726();
      }
   }

   public void m_3253() {
      Shaderhands var1 = this.m_3759();
      if (!this.m_678(var1)) {
         this.m_1173();
      } else {
         this.m_1112();
         if (this.f_1786 != null && this.f_1787 != null && this.f_1788 != null && this.f_1795) {
            this.m_3723(this.f_1787);
            this.m_675(var1);
         }
      }
   }

   private Shaderhands m_3759() {
      return InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null ? InitManager.f_2740.f_2741.shaderhands : null;
   }

   private void m_2608(Util98 var1, String var2, float var3, float var4, float var5) {
      MathUtil6 var6 = var1.m_1335(var2);
      if (var6 != null) {
         var6.m_33(var3, var4, var5);
      }
   }

   private void m_2922(int var1) {
      for (Framebuffer var3 : this.f_1792) {
         if (var3 != null) {
            int var4 = RenderUtil6.m_668(var3.getColorAttachment());
            if (var4 != 0) {
               Util114.m_2012(var4);
               GL11.glTexParameteri(3553, 10242, var1);
               GL11.glTexParameteri(3553, 10243, var1);
            }
         }
      }

      Util114.m_2012(0);
   }

   private int m_1905(int var1, int var2, float var3, boolean var4) {
      this.m_2254(var1);
      if (this.f_1792.isEmpty()) {
         return var2;
      } else {
         this.m_2922(var4 ? f_1825 : f_1826);
         int var5 = var2;
         Util98 var6 = Util114.m_3784(Util24.f_3289);
         Util98 var7 = Util114.m_3784(Util24.f_3288);
         if (var6 != null && var7 != null) {
            for (int var8 = 0; var8 < var1; var8++) {
               Framebuffer var9 = this.f_1792.get(var8);
               RenderUtil6.m_2715(var9, 0.0F, 0.0F, 0.0F, 0.0F);
               RenderUtil6.m_676(var9);
               RenderUtil6.m_4071(var9, true);
               Util114.m_3784(Util24.f_3289);
               Util114.m_2037(0, var5);
               this.m_2224(var6, var9.textureWidth, var9.textureHeight, (1.0F + var8) * var3);
               this.m_1726();
               var5 = RenderUtil6.m_668(var9.getColorAttachment());
            }

            for (int var10 = var1 - 1; var10 >= 1; var10--) {
               Framebuffer var11 = this.f_1792.get(var10 - 1);
               RenderUtil6.m_2715(var11, 0.0F, 0.0F, 0.0F, 0.0F);
               RenderUtil6.m_676(var11);
               RenderUtil6.m_4071(var11, true);
               Util114.m_3784(Util24.f_3288);
               Util114.m_2037(0, var5);
               this.m_2224(var7, var11.textureWidth, var11.textureHeight, (1.0F + var10) * var3);
               this.m_2608(var7, f_1827, 1.0F, 1.0F, 1.0F);
               this.m_1726();
               var5 = RenderUtil6.m_668(var11.getColorAttachment());
            }

            RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
            return var5;
         } else {
            return var2;
         }
      }
   }

   public RenderUtil13() {
      this.f_1799 = f_1809;
      this.f_1800 = f_1810;
      this.f_1804 = new float[]{1.0F, 1.0F, 1.0F};
      this.f_1806 = f_1811;
      this.f_1808 = new ArrayDeque<>();
   }

   private void m_1726() {
      float var1 = this.m_969();
      float var2 = this.m_3898();
      BufferBuilder var3 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      var3.vertex(0.0F, var2, 0.0F).texture(0.0F, 0.0F).color(1.0F, 1.0F, 1.0F, 1.0F);
      var3.vertex(var1, var2, 0.0F).texture(1.0F, 0.0F).color(1.0F, 1.0F, 1.0F, 1.0F);
      var3.vertex(var1, 0.0F, 0.0F).texture(1.0F, 1.0F).color(1.0F, 1.0F, 1.0F, 1.0F);
      var3.vertex(0.0F, 0.0F, 0.0F).texture(0.0F, 1.0F).color(1.0F, 1.0F, 1.0F, 1.0F);
      RenderUtil12.I(var3.end());
   }

   private int m_3898() {
      Window var1 = f_5909.getWindow();
      return var1 != null ? Math.max(1, var1.getFramebufferHeight()) : Math.max(1, this.f_1794);
   }

   private int m_462(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         int var2 = var1.getItem().hashCode();
         var2 = 31 * var2 + var1.getCount();
         return 31 * var2 + var1.getComponents().hashCode();
      } else {
         return 0;
      }
   }

   private void I(Framebuffer var1) {
      if (var1 != null) {
         try {
            var1.delete();
         } catch (Exception var3) {
         }
      }
   }

   private void m_1505(int var1) {
      Util114.m_2012(var1);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10242, f_1882);
      GL11.glTexParameteri(3553, 10243, f_1883);
      FloatBuffer var2 = BufferUtils.createFloatBuffer(4);
      var2.put(0.0F).put(0.0F).put(0.0F).put(0.0F).flip();
      GL11.glTexParameterfv(3553, 4100, var2);
      Util114.m_2012(0);
   }

   private void m_1112() {
      if (f_5909.getWindow() != null) {
         int var1 = f_5909.getWindow().getFramebufferWidth();
         int var2 = f_5909.getWindow().getFramebufferHeight();
         if (var1 != this.f_1793 || var2 != this.f_1794 || this.f_1786 == null || this.f_1787 == null || this.f_1788 == null) {
            this.I(this.f_1786);
            this.I(this.f_1787);
            this.I(this.f_1788);
            this.I(this.f_1789);
            this.I(this.f_1790);
            this.I(this.f_1791);
            this.f_1789 = null;
            this.f_1790 = null;
            this.f_1791 = null;
            this.f_1802 = false;

            for (Framebuffer var4 : this.f_1792) {
               this.I(var4);
            }

            this.f_1792.clear();
            this.f_1786 = new SimpleFramebuffer(null, var1, var2, true);
            this.f_1787 = new SimpleFramebuffer(null, var1, var2, true);
            this.f_1788 = new SimpleFramebuffer(null, var1, var2, true);
            this.f_1793 = var1;
            this.f_1794 = var2;
            this.f_1796 = -1;
            this.f_1797 = -1;
         }
      }
   }

   private void m_3805() {
      if (!this.f_1803 || this.f_1789 == null) {
         this.m_3529();
         if (this.f_1789 != null) {
            RenderUtil6.m_2715(this.f_1789, 0.0F, 0.0F, 0.0F, 0.0F);
            RenderUtil6.m_676(this.f_1789);
            RenderUtil6.m_4071(this.f_1789, true);
            Util114.m_963();
            Util114.m_672();
            Util98 var1 = Util114.m_3784(Util24.f_3292);
            if (var1 != null) {
               Util114.m_2037(0, RenderUtil6.m_668(this.f_1787.getColorAttachment()));
               Util114.m_2037(1, RenderUtil6.m_668(this.f_1788.getColorAttachment()));
               this.m_1726();
               this.f_1803 = true;
            }
         }
      }
   }

   private void m_2254(int var1) {
      while (this.f_1792.size() > var1) {
         int var2 = this.f_1792.size() - 1;
         this.I(this.f_1792.remove(var2));
      }

      for (int var6 = 0; var6 < var1; var6++) {
         int var3 = Math.max(2, this.f_1793 >> var6 + 1);
         int var4 = Math.max(2, this.f_1794 >> var6 + 1);
         if (var6 >= this.f_1792.size()) {
            SimpleFramebuffer var5 = new SimpleFramebuffer(null, var3, var4, false);
            this.m_2303(var5);
            this.f_1792.add(var5);
         } else {
            Framebuffer var7 = this.f_1792.get(var6);
            if (var7.textureWidth != var3 || var7.textureHeight != var4) {
               this.I(var7);
               SimpleFramebuffer var8 = new SimpleFramebuffer(null, var3, var4, false);
               this.m_2303(var8);
               this.f_1792.set(var6, var8);
            }
         }
      }
   }

   private void m_1155() {
      if (this.f_1793 > 0 && this.f_1794 > 0) {
         int var1 = Math.max(2, this.f_1793 / 2);
         int var2 = Math.max(2, this.f_1794 / 2);
         boolean var3 = this.f_1790 == null || this.f_1791 == null || this.f_1790.textureWidth != var1 || this.f_1790.textureHeight != var2;
         this.f_1790 = this.m_3947(this.f_1790, var1, var2);
         this.f_1791 = this.m_3947(this.f_1791, var1, var2);
         if (var3 || !this.f_1802) {
            RenderUtil6.m_2715(this.f_1790, 0.0F, 0.0F, 0.0F, 0.0F);
            RenderUtil6.m_676(this.f_1790);
            RenderUtil6.m_2715(this.f_1791, 0.0F, 0.0F, 0.0F, 0.0F);
            RenderUtil6.m_676(this.f_1791);
            this.f_1802 = true;
            this.f_1798 = 0L;
         }
      }
   }

   private void m_1141(Shaderhands var1, boolean var2) {
      if (var2 || this.f_1805++ % 24 == 0) {
         if (var2) {
            this.f_1805 = 1;
         }

         Framebuffer var3 = !this.f_1792.isEmpty() ? this.f_1792.get(this.f_1792.size() - 1) : this.f_1787;
         if (var3 != null) {
            int var4 = Math.min(48, var3.textureWidth);
            int var5 = Math.min(48, var3.textureHeight);
            if (var4 > 0 && var5 > 0) {
               int var6 = Math.max(0, (var3.textureWidth - var4) / 2);
               int var7 = Math.max(0, var3.textureHeight / 5);
               int var8 = var4 * var5 * 4;
               if (this.f_1807 == null || this.f_1807.capacity() < var8) {
                  this.f_1807 = BufferUtils.createByteBuffer(var8);
               }

               this.f_1807.clear();
               int var9 = GL11.glGetInteger(f_1895);
               GL30.glBindFramebuffer(f_1896, RenderUtil6.m_823(var3));
               GL11.glReadPixels(var6, var7, var4, var5, 6408, 5121, this.f_1807);
               GL30.glBindFramebuffer(f_1897, var9);
               float var10 = 0.0F;
               float var11 = 0.0F;
               float var12 = 0.0F;
               float var13 = 0.0F;
               int var14 = var4 * var5;

               for (int var15 = 0; var15 < var14; var15++) {
                  int var16 = var15 * 4;
                  float var17 = (this.f_1807.get(var16) & 255) / f_1898;
                  float var18 = (this.f_1807.get(var16 + 1) & 255) / f_1899;
                  float var19 = (this.f_1807.get(var16 + 2) & 255) / f_1900;
                  float var20 = (this.f_1807.get(var16 + 3) & 255) / f_1901;
                  if (!(var20 < f_1902)) {
                     var10 += var17 * var20;
                     var11 += var18 * var20;
                     var12 += var19 * var20;
                     var13 += var20;
                  }
               }

               if (!(var13 < f_1903)) {
                  float var21 = var10 / var13;
                  float var22 = var11 / var13;
                  float var23 = var12 / var13;
                  float var24 = Math.max(var21, Math.max(var22, var23));
                  if (var24 > f_1904) {
                     var21 /= var24;
                     var22 /= var24;
                     var23 /= var24;
                  }

                  float var25 = var1.m_1730();
                  float var26 = f_1905 * var21 + f_1906 * var22 + f_1907 * var23;
                  this.f_1804[0] = m_1600(var26 + (var21 - var26) * var25);
                  this.f_1804[1] = m_1600(var26 + (var22 - var26) * var25);
                  this.f_1804[2] = m_1600(var26 + (var23 - var26) * var25);
               }
            }
         }
      }
   }

   private void m_1568() {
      if (!this.f_1808.isEmpty()) {
         RenderUtil13.Inner_38O6aKiwE68GCGmc var1 = this.f_1808.pop();
         Util114.m_1789().popMatrix();
         Util114.m_2544(var1.f_1, var1.f_2);
      }
   }

   private void m_3529() {
      if (this.f_1793 > 0 && this.f_1794 > 0) {
         if (this.f_1789 == null || this.f_1789.textureWidth != this.f_1793 || this.f_1789.textureHeight != this.f_1794) {
            this.I(this.f_1789);
            this.f_1789 = new SimpleFramebuffer(null, this.f_1793, this.f_1794, false);
            this.m_2303(this.f_1789);
         }
      }
   }

   private void m_1009(Shaderhands var1, int var2, int var3, float var4, float var5, float var6, float var7) {
      Util98 var8 = Util114.m_3784(Util24.f_3286);
      if (var8 != null) {
         RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
         Util114.m_1481();
         Util114.m_542();
         Util114.m_672();
         Util114.m_2037(0, RenderUtil6.m_668(this.f_1788.getColorAttachment()));
         boolean var9 = var1.m_4012() && this.f_1789 != null;
         if (var9) {
            Util114.m_2037(1, RenderUtil6.m_668(this.f_1789.getColorAttachment()));
         } else {
            Util114.m_2037(1, RenderUtil6.m_668(this.f_1788.getColorAttachment()));
         }

         this.m_3246(var8, f_1859, 1.0F / Math.max(1, f_5909.getWindow().getFramebufferWidth()), 1.0F / Math.max(1, f_5909.getWindow().getFramebufferHeight()));
         float[] var10 = Util71.m_2326(var2);
         float[] var11 = Util71.m_2326(var3);
         this.m_2608(var8, f_1860, var10[0], var10[1], var10[2]);
         this.m_2608(var8, f_1861, var11[0], var11[1], var11[2]);
         this.m_1349(var8, f_1862, (float)(System.currentTimeMillis() % f_1863) / f_1864);
         this.m_1349(var8, f_1865, var1.m_3135());
         this.m_1349(var8, f_1866, var1.m_718());
         this.m_1349(var8, f_1867, var7);
         this.m_1349(var8, f_1868, var4);
         this.m_1349(var8, f_1869, var5);
         this.m_1349(var8, f_1870, var6);
         this.m_1349(var8, f_1871, 0.0F);
         this.m_1349(var8, f_1872, var9 ? 1.0F : 0.0F);
         this.m_1349(var8, f_1873, var1.m_1730());
         this.m_1726();
         Util114.m_100();
         Util114.m_963();
         Util114.m_542();
         this.m_822();
      }
   }

   private int m_4070(Shaderhands var1, float var2) {
      int var3 = var1.m_988();
      float var4 = var1.m_3358();
      int var5 = RenderUtil6.m_668(this.f_1788.getColorAttachment());
      if (var1.m_831() || var1.m_4012()) {
         this.m_3805();
         if (this.f_1789 != null) {
            var5 = RenderUtil6.m_668(this.f_1789.getColorAttachment());
         }
      }

      return this.m_1905(var3, var5, var4, false);
   }

   private boolean m_2509(Shaderhands var1) {
      if (var1.m_4012() && f_5909.player != null) {
         int var2 = this.m_3968();
         if (var2 == this.f_1806) {
            return false;
         } else {
            this.f_1806 = var2;
            this.f_1805 = 0;
            if (this.f_1790 != null) {
               RenderUtil6.m_2715(this.f_1790, 0.0F, 0.0F, 0.0F, 0.0F);
               RenderUtil6.m_676(this.f_1790);
            }

            if (this.f_1791 != null) {
               RenderUtil6.m_2715(this.f_1791, 0.0F, 0.0F, 0.0F, 0.0F);
               RenderUtil6.m_676(this.f_1791);
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private void m_1607(Shaderhands var1, int var2, int var3, int var4) {
      Util114.m_3547(true, true, true, true);
      this.m_1155();
      if (this.f_1790 != null && this.f_1791 != null) {
         long var5 = System.currentTimeMillis();
         float var7 = this.f_1798 > 0L ? Math.min(f_1830, (float)(var5 - this.f_1798) / f_1831) : f_1832;
         this.f_1798 = var5;
         this.f_1799 = this.f_1799 * f_1833 + var7 * f_1834;
         float var8 = this.f_1799;
         float var9 = (float)(var5 % f_1835) / f_1836;
         float var10 = f_1837;
         float var11 = var1.m_1531() * var8;
         float var12 = var1.m_3552();
         float var13 = (float)(Math.sin(var9 * var10) - Math.sin((var9 - var8) * var10)) * var12;
         boolean var14 = f_5909.player != null && f_5909.player.handSwinging;
         if (var1.m_232() && var14 && !this.f_1801) {
            this.f_1800 = var5;
         }

         this.f_1801 = var14;
         float var15 = (float)(var5 - this.f_1800) / f_1838;
         float var16 = Math.max(0.0F, 1.0F - var15 / f_1839);
         float var17 = var16 * var1.m_2108() * f_1840;
         boolean var18 = var1.m_320();
         float var19 = var1.m_3600();
         float[] var20 = Util71.m_2326(var3);
         float[] var21 = Util71.m_2326(var4);
         RenderUtil6.m_2715(this.f_1791, 0.0F, 0.0F, 0.0F, 0.0F);
         RenderUtil6.m_676(this.f_1791);
         RenderUtil6.m_4071(this.f_1791, true);
         Util114.m_672();
         Util114.m_963();
         Util98 var22 = Util114.m_3784(var18 ? Util24.f_3295 : Util24.f_3293);
         if (var22 != null) {
            Util114.m_2037(0, RenderUtil6.m_668(this.f_1790.getColorAttachment()));
            this.m_3246(var22, f_1841, var13, var11);
            this.m_3246(var22, f_1842, Math.max(1, this.f_1790.textureWidth), Math.max(1, this.f_1790.textureHeight));
            this.m_1349(var22, f_1843, var1.m_1676() + var17);
            this.m_1349(var22, f_1844, var9);
            this.m_1349(var22, f_1845, var8);
            this.m_1349(var22, f_1846, var1.m_130());
            this.m_1349(var22, f_1847, var1.m_1431());
            if (var18) {
               this.m_1349(var22, f_1848, var1.m_3199());
               this.m_1349(var22, f_1849, var1.m_1915());
               this.m_1349(var22, f_1850, var1.m_2144());
            }

            this.m_1726();
         }

         Util114.m_1481();
         Util114.m_582(1, 771);
         Util98 var23 = Util114.m_3784(var18 ? Util24.O : Util24.f_3294);
         if (var23 != null) {
            Util114.m_2037(0, var2);
            this.m_1183(var23, var1, var20, var21);
            this.m_1349(var23, f_1851, var19);
            if (var18) {
               this.m_1349(var23, f_1852, var1.m_1578());
               this.m_1349(var23, f_1853, var1.m_2031());
               this.m_1349(var23, f_1854, var1.m_3925());
               this.m_1349(var23, f_1855, var9);
            }

            this.m_1726();
         }

         if (var1.m_1808() && this.f_1789 != null) {
            Util114.m_1481();
            Util114.m_582(770, 771);
            Util114.m_3158(1.0F, 1.0F, 1.0F, var1.m_3496());
            if (Util114.m_3784(RenderUtil7.f_13886) != null) {
               Util114.m_2037(0, RenderUtil6.m_668(this.f_1789.getColorAttachment()));
               this.m_1726();
            }

            Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         }

         RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
         Util114.m_1481();
         Util114.m_672();
         Util114.m_3547(true, true, true, false);
         if (var18) {
            this.m_519(var1);
         } else {
            Util114.m_582(1, 771);
            Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
            if (Util114.m_3784(RenderUtil7.f_13886) != null) {
               Util114.m_2037(0, RenderUtil6.m_668(this.f_1791.getColorAttachment()));
               this.m_1726();
            }
         }

         Util114.m_542();
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         Framebuffer var24 = this.f_1790;
         this.f_1790 = this.f_1791;
         this.f_1791 = var24;
      } else {
         this.m_3662(var1, var2, var3, var4, var1.m_989());
      }
   }

   public void m_523() {
      this.m_1173();
      this.f_1808.clear();
      this.I(this.f_1786);
      this.I(this.f_1787);
      this.I(this.f_1788);
      this.I(this.f_1789);
      this.I(this.f_1790);
      this.I(this.f_1791);
      this.f_1786 = null;
      this.f_1787 = null;
      this.f_1788 = null;
      this.f_1789 = null;
      this.f_1790 = null;
      this.f_1791 = null;

      for (Framebuffer var2 : this.f_1792) {
         this.I(var2);
      }

      this.f_1792.clear();
      this.f_1793 = -1;
      this.f_1794 = -1;
      this.f_1798 = 0L;
      this.f_1800 = f_1823;
      this.f_1801 = false;
      this.f_1802 = false;
      this.f_1803 = false;
      this.f_1805 = 0;
      this.f_1806 = f_1824;
      this.f_1807 = null;
      this.f_1804[0] = 1.0F;
      this.f_1804[1] = 1.0F;
      this.f_1804[2] = 1.0F;
   }

   private void m_4065(Util98 var1, String var2, float var3, float var4, float var5, float var6) {
      MathUtil6 var7 = var1.m_1335(var2);
      if (var7 != null) {
         var7.m_41(var3, var4, var5, var6);
      }
   }

   private int m_3968() {
      int var1 = f_5909.player.getInventory().getSelectedSlot();
      var1 = 31 * var1 + this.m_462(f_5909.player.getMainHandStack());
      return 31 * var1 + this.m_462(f_5909.player.getOffHandStack());
   }

   private boolean m_4137() {
      Window var1 = f_5909.getWindow();
      if (var1 == null) {
         return false;
      } else {
         int var2 = Math.max(1, var1.getFramebufferWidth());
         int var3 = Math.max(1, var1.getFramebufferHeight());
         this.f_1808.push(new RenderUtil13.Inner_38O6aKiwE68GCGmc(new Matrix4f(Util114.m_1781()), Util114.m_2545()));
         GL11.glClear(256);
         Matrix4f var4 = new Matrix4f();
         var4.setOrtho(0.0F, var2, var3, 0.0F, f_1812, f_1813);
         Util114.m_2544(var4, ProjectionType.ORTHOGRAPHIC);
         Util114.m_1789().pushMatrix();
         Util114.m_1789().identity();
         Util114.m_1789().translate(0.0F, 0.0F, f_1814);
         return true;
      }
   }

   private void m_2850(int var1) {
      Util114.m_2012(var1);
      GL11.glTexParameteri(3553, f_1880, 0);
      GL11.glTexParameteri(3553, 10241, 9728);
      GL11.glTexParameteri(3553, 10240, 9728);
      Util114.m_2012(0);
   }

   private void m_822() {
      Util114.m_3547(true, true, true, true);
      Util114.m_1878(true);
      Util114.m_100();
      Util114.m_1562();
      Util114.m_963();
      Util114.m_542();
      Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      Util114.m_2037(0, 0);
      Util114.m_2037(1, 0);
      Util114.m_2037(2, 0);
      Util114.m_2037(3, 0);
      RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
   }

   private Framebuffer m_3947(Framebuffer var1, int var2, int var3) {
      if (var1 == null || ((Framebuffer)var1).textureWidth != var2 || ((Framebuffer)var1).textureHeight != var3) {
         this.I((Framebuffer)var1);
         var1 = new SimpleFramebuffer(null, var2, var3, false);
         this.m_2303((Framebuffer)var1);
      }

      return (Framebuffer)var1;
   }

   private void m_3511() {
      if (this.f_1789 != null) {
         RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
         Util114.m_1481();
         Util114.m_672();
         Util114.m_3547(true, true, true, true);
         Util114.m_582(770, 771);
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         if (Util114.m_3784(RenderUtil7.f_13886) != null) {
            Util114.m_2037(0, RenderUtil6.m_668(this.f_1789.getColorAttachment()));
            this.m_1726();
         }

         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   public void m_364() {
      Shaderhands var1 = this.m_3759();
      if (!this.m_678(var1)) {
         this.m_1173();
      } else {
         this.m_1112();
         if (this.f_1786 != null) {
            this.m_3723(this.f_1786);
            this.f_1795 = true;
         }
      }
   }

   private int O() {
      int var1 = Math.round(this.f_1804[0] * f_1908);
      int var2 = Math.round(this.f_1804[1] * f_1909);
      int var3 = Math.round(this.f_1804[2] * f_1910);
      return Util71.m_1415(var1, var2, var3);
   }

   private void m_519(Shaderhands var1) {
      int var2 = RenderUtil6.m_668(this.f_1791.getColorAttachment());
      float var3 = var1.m_2595();
      if (var3 > f_1856) {
         Util114.m_582(1, 771);
         Util114.m_3158(var3, var3, var3, var3);
         if (Util114.m_3784(RenderUtil7.f_13886) != null) {
            Util114.m_2037(0, var2);
            this.m_1726();
         }
      }

      float var4 = var1.m_2311();
      if (var4 > f_1857) {
         Util114.m_582(1, 1);
         Util114.m_3158(var4, var4, var4, var4);
         if (Util114.m_3784(RenderUtil7.f_13886) != null) {
            Util114.m_2037(0, var2);
            this.m_1726();
         }
      }
   }

   public void m_1173() {
      this.f_1795 = false;
      this.f_1796 = -1;
      this.f_1797 = -1;
   }

   private void m_3246(Util98 var1, String var2, float var3, float var4) {
      MathUtil6 var5 = var1.m_1335(var2);
      if (var5 != null) {
         var5.m_54(var3, var4);
      }
   }

   private void m_3723(Framebuffer var1) {
      int var2 = GL11.glGetInteger(f_1874);
      int var3 = GL11.glGetInteger(f_1875);
      GL30.glBindFramebuffer(f_1876, RenderUtil6.m_823(f_5909.getFramebuffer()));
      GL30.glBindFramebuffer(f_1877, RenderUtil6.m_823(var1));
      GL30.glBlitFramebuffer(0, 0, this.f_1793, this.f_1794, 0, 0, this.f_1793, this.f_1794, 16640, 9728);
      GL30.glBindFramebuffer(f_1878, var2);
      GL30.glBindFramebuffer(f_1879, var3);
      RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
   }

   private void m_1349(Util98 var1, String var2, float var3) {
      MathUtil6 var4 = var1.m_1335(var2);
      if (var4 != null) {
         var4.O(var3);
      }
   }

   private void m_1183(Util98 var1, Shaderhands var2, float[] var3, float[] var4) {
      if (var2.m_4012()) {
         this.m_1349(var1, f_1887, 1.0F);
         this.m_1349(var1, f_1888, var2.m_1730());
         this.m_2608(var1, f_1889, var3[0], var3[1], var3[2]);
         this.m_2608(var1, f_1890, var4[0], var4[1], var4[2]);
      } else {
         this.m_1349(var1, f_1891, 0.0F);
         this.m_1349(var1, f_1892, 1.0F);
         this.m_2608(var1, f_1893, var3[0], var3[1], var3[2]);
         this.m_2608(var1, f_1894, var4[0], var4[1], var4[2]);
      }
   }

   private boolean m_678(Shaderhands var1) {
      if (var1 == null || !var1.m_677()) {
         return false;
      } else if (!var1.m_859()) {
         return false;
      } else if (var1.m_3321()) {
         return true;
      } else {
         boolean var2 = var1.m_989() > f_1884;
         boolean var3 = var1.m_3393() > f_1885 && var1.m_511() > f_1886;
         return var2 || var3;
      }
   }

   private void m_2303(Framebuffer var1) {
      if (var1 != null) {
         int var2 = RenderUtil6.m_668(var1.getColorAttachment());
         if (var2 != 0) {
            Util114.m_2012(var2);
            GL11.glTexImage2D(3553, 0, f_1881, var1.textureWidth, var1.textureHeight, 0, 6408, 5131, (ByteBuffer)null);
            this.m_1505(var2);
         }
      }
   }

   private void m_2502(Shaderhands var1) {
      Util98 var2 = Util114.m_3784(Util24.f_3290);
      if (var2 != null) {
         RenderUtil6.m_2715(this.f_1788, 0.0F, 0.0F, 0.0F, 0.0F);
         RenderUtil6.m_676(this.f_1788);
         RenderUtil6.m_4071(this.f_1788, true);
         Util114.m_672();
         Util114.m_963();
         Util114.m_2037(0, RenderUtil6.m_668(this.f_1786.getColorAttachment()));
         Util114.m_2037(1, RenderUtil6.m_668(this.f_1787.getColorAttachment()));
         int var3 = RenderUtil6.m_668(this.f_1786.getDepthAttachment());
         int var4 = RenderUtil6.m_668(this.f_1787.getDepthAttachment());
         if (var3 != 0 && var3 != this.f_1796) {
            this.m_2850(var3);
            this.f_1796 = var3;
         }

         if (var4 != 0 && var4 != this.f_1797) {
            this.m_2850(var4);
            this.f_1797 = var4;
         }

         Util114.m_2037(2, var3);
         Util114.m_2037(3, var4);
         this.m_1726();
         if (var1.m_3321()) {
            this.I(var1);
         } else {
            float var5 = var1.m_989();
            float var6 = var1.m_3393();
            float var7 = var1.m_511();
            float var8 = var1.m_2914();
            int var9 = EnergyClient.getTheme(0);
            int var10 = Util71.m_2101(var9, f_1815);
            boolean var11 = var5 > f_1816;
            boolean var12 = var6 > f_1817 && var7 > f_1818;
            boolean var13 = var1.m_4012() && var12 && !var1.m_2377();
            boolean var14 = this.m_2509(var1);
            if (var1.m_2377()) {
               if (var1.m_4012()) {
                  this.m_3805();
               }

               if (var11) {
                  int var18 = this.m_4070(var1, var8);
                  RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
                  Util114.m_1481();
                  Util114.m_672();
                  if (var1.m_831()) {
                     this.m_1607(var1, var18, var9, var10);
                     this.m_3511();
                     this.m_3823(var1);
                  } else {
                     this.m_3662(var1, var18, var9, var10, var5);
                  }
               }

               this.m_1009(var1, var9, var10, var5, var6, var7, var8);
            } else {
               int var15 = 0;
               if (var11) {
                  var15 = this.m_4070(var1, var8);
               }

               RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
               Util114.m_1481();
               Util114.m_3547(true, true, true, false);
               Util114.m_672();
               if (var11) {
                  if (var1.m_831()) {
                     this.m_1607(var1, var15, var9, var10);
                     this.m_3511();
                     this.m_3823(var1);
                  } else {
                     this.m_3662(var1, var15, var9, var10, var5);
                  }
               }

               if (var12) {
                  Util98 var16 = Util114.m_3784(Util24.f_3291);
                  if (var16 == null) {
                     this.m_822();
                     return;
                  }

                  if (var13) {
                     this.m_1141(var1, var14);
                     var9 = this.O();
                  }

                  Util114.m_1206(770, 771, 0, 1);
                  Util114.m_2037(0, RenderUtil6.m_668(this.f_1788.getColorAttachment()));
                  float[] var17 = Util71.m_2326(var9);
                  this.m_2608(var16, f_1819, var17[0], var17[1], var17[2]);
                  this.m_1349(var16, f_1820, var6);
                  this.m_1349(var16, f_1821, var7);
                  this.m_1726();
               }

               this.m_822();
            }
         }
      }
   }

   private void m_2224(Util98 var1, int var2, int var3, float var4) {
      this.m_3246(var1, f_1911, Math.max(1, var2), Math.max(1, var3));
      this.m_3246(var1, f_1912, var4, var4);
      this.m_3246(var1, f_1913, f_1914 / Math.max(1, var2), f_1915 / Math.max(1, var3));
   }

   public static RenderUtil13 m_4021() {
      if (f_1785 == null) {
         f_1785 = new RenderUtil13();
      }

      return f_1785;
   }

   private static float m_1600(float var0) {
      return var0 < 0.0F ? 0.0F : Math.min(var0, 1.0F);
   }

   private static final class Inner_38O6aKiwE68GCGmc {
      final Matrix4f f_1;
      final ProjectionType f_2;

      Inner_38O6aKiwE68GCGmc(Matrix4f var1, ProjectionType var2) {
         this.f_1 = var1;
         this.f_2 = var2;
      }
   }
}
