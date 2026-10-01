package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.util.function.Consumer;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;
import su.energyclient.util.Util24;
import su.energyclient.util.Util98;
import su.energyclient.util.math.MathUtil6;

public class RenderUtil16 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final long f_1916 = System.nanoTime();
   private static final int f_1917 = 33985;
   private static final int f_1918 = 33984;
   private static final int f_1919 = 33985;
   private static final int f_1920 = 33984;
   private static final float f_1921 = 0.01F;
   private static final float f_1922 = 3.0F;
   private static final float f_1923 = -1.0F;
   private static final float f_1924 = -1.0F;
   private static final float f_1925 = -1.0F;
   private static final float f_1926 = -1.0F;
   private static final float f_1927 = 2.50662F;
   private static final float f_1928 = -0.5F;
   private static final float f_1929 = 2.50662F;
   private static final int f_1930 = 34892;
   private static final int f_1931 = 33984;
   private static final String f_1932 = "Tex0";
   private static final String f_1933 = "Alpha";
   private static final String f_1934 = "Tex0";
   private static final String f_1935 = "Tex1";
   private static final String f_1936 = "Near";
   private static final float f_1937 = 0.05F;
   private static final String f_1938 = "Far";
   private static final String f_1939 = "MinThreshold";
   private static final float f_1940 = 0.1F;
   private static final float f_1941 = 100.0F;
   private static final String f_1942 = "MaxThreshold";
   private static final float f_1943 = 0.28F;
   private static final float f_1944 = 100.0F;
   private static final String f_1945 = "Tex0";
   private static final String f_1946 = "Alpha";
   private static final String f_1947 = "Gaussian";
   private static final String f_1948 = "Support";
   private static final String f_1949 = "LinearSampling";
   private static final String f_1950 = "Direction";
   private static final String f_1951 = "TexelSize";
   private static final String f_1952 = "Tex0";
   private static final String f_1953 = "Alpha";
   private static final String f_1954 = "Gaussian";
   private static final String f_1955 = "Support";
   private static final String f_1956 = "LinearSampling";
   private static final String f_1957 = "Direction";
   private static final String f_1958 = "TexelSize";
   private static final String f_1959 = "Tex0";
   private static final String f_1960 = "RGBPuke";
   private static final String f_1961 = "SV";
   private static final String f_1962 = "Opacity";
   private static final String f_1963 = "Time";
   private static final float f_1964 = 1.0E9F;
   private static final String f_1965 = "Yaw";
   private static final String f_1966 = "Pitch";
   private static final String f_1967 = "Tex0";
   private static final String f_1968 = "Alpha";

   private static void m_1323(SimpleFramebuffer var0, SimpleFramebuffer var1, SimpleFramebuffer var2, float var3) {
      int var4 = RenderUtil6.m_668(var2.getDepthAttachment());
      m_2876(var4);
      RenderUtil6.m_4071(var0, true);
      m_2892(Util24.f_3277, var3x -> {
         var3x.m_3726(f_1934, RenderUtil6.m_668(var1.getColorAttachment()));
         var3x.m_3726(f_1935, var4);
         l(var3x, f_1936, f_1937);
         l(var3x, f_1938, f_5909.gameRenderer.getFarPlaneDistance());
         l(var3x, f_1939, f_1940 * var3 / f_1941);
         l(var3x, f_1942, f_1943 * var3 / f_1944);
      });
   }

   private static void m_2953(Util98 var0, String var1, Vector3f var2) {
      MathUtil6 var3 = var0.m_1335(var1);
      if (var3 != null) {
         var3.m_33(var2.x, var2.y, var2.z);
      }
   }

   private static void m_3863(Framebuffer var0, SimpleFramebuffer var1) {
      RenderUtil6.m_4071(var1, true);
      m_2892(Util24.f_3278, var1x -> {
         var1x.m_3726(f_1967, RenderUtil6.m_668(var0.getColorAttachment()));
         m_493(var1x, f_1968, true);
      });
      var1.copyDepthFrom(var0);
   }

   private static void l(Util98 var0, String var1, float var2) {
      MathUtil6 var3 = var0.m_1335(var1);
      if (var3 != null) {
         var3.O(var2);
      }
   }

   private static void m_828() {
      BufferBuilder var0 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
      var0.vertex(f_1923, f_1924, 0.0F).texture(0.0F, 0.0F);
      var0.vertex(f_1925, 1.0F, 0.0F).texture(0.0F, 1.0F);
      var0.vertex(1.0F, 1.0F, 0.0F).texture(1.0F, 1.0F);
      var0.vertex(1.0F, f_1926, 0.0F).texture(1.0F, 0.0F);
      RenderUtil12.I(var0.end());
   }

   private static void m_2892(RenderUtil9 var0, Consumer<Util98> var1) {
      Util98 var2 = Util114.m_827(var0);
      if (var2 != null) {
         var1.accept(var2);
         Util114.m_3784(var0);
         m_828();
      }
   }

   private static void m_493(Util98 var0, String var1, boolean var2) {
      m_1213(var0, var1, var2 ? 1 : 0);
   }

   private static void m_3458(int var0) {
      Util114.m_2836(var0);
      Util114.m_2012(0);
      Util114.m_2836(f_1931);
   }

   private static void m_3139(SimpleFramebuffer var0, SimpleFramebuffer var1, float var2, float var3, float var4) {
      RenderUtil6.m_4071(var0, true);
      m_2892(Util24.f_3275, var4x -> {
         var4x.m_3726(f_1959, RenderUtil6.m_668(var1.getColorAttachment()));
         m_493(var4x, f_1960, true);
         l(var4x, f_1961, var3, var4);
         l(var4x, f_1962, var2);
         l(var4x, f_1963, (float)(System.nanoTime() - f_1916) / f_1964);
         if (f_5909.player != null) {
            l(var4x, f_1965, f_5909.player.getYaw());
            l(var4x, f_1966, f_5909.player.getPitch());
         }
      });
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static void m_2901(float var0, float var1, boolean var2, boolean var3, float var4, float var5, float var6) {
      RenderUtil23.m_695();
      SimpleFramebuffer var7 = RenderUtil23.m_2271();
      SimpleFramebuffer var8 = RenderUtil23.m_3416();
      SimpleFramebuffer var9 = RenderUtil23.m_2806();
      SimpleFramebuffer var10 = RenderUtil23.m_1062();
      SimpleFramebuffer var11 = RenderUtil23.m_4082();
      if (var8 != null && var9 != null && var10 != null && var11 != null && var7 != null) {
         Framebuffer var12 = f_5909.getFramebuffer();
         Util114.m_3978();
         Util114.m_672();
         Util114.m_1878(false);
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         boolean var15 = false /* VF: Semaphore variable */;

         try {
            var15 = true;
            m_3863(var12, var8);
            if (var3) {
               m_3139(var7, var8, var4, var5, var6);
            }

            m_405(var9, var10, var7, var8, var0, var2, var3);
            m_1323(var11, var10, var8, var1);
            m_1571(var11);
            var15 = false;
         } finally {
            if (var15) {
               m_3458(f_1919);
               m_3458(f_1920);
               Util114.m_963();
               Util114.m_542();
               Util114.m_1878(true);
               Util114.m_100();
               Util114.m_1562();
               Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
               RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
            }
         }

         m_3458(f_1917);
         m_3458(f_1918);
         Util114.m_963();
         Util114.m_542();
         Util114.m_1878(true);
         Util114.m_100();
         Util114.m_1562();
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
      }
   }

   private static void m_405(
      SimpleFramebuffer var0, SimpleFramebuffer var1, SimpleFramebuffer var2, SimpleFramebuffer var3, float var4, boolean var5, boolean var6
   ) {
      float var7 = Math.max(var4, f_1921);
      Vector3f var8 = m_2552(var7);
      int var9 = Math.max(1, (int)Math.ceil(var7 * f_1922));
      int var10 = var6 ? RenderUtil6.m_668(var2.getColorAttachment()) : RenderUtil6.m_668(var3.getColorAttachment());
      RenderUtil6.m_4071(var0, true);
      m_2892(Util24.f_3276, var5x -> {
         var5x.m_3726(f_1952, var10);
         m_493(var5x, f_1953, false);
         m_2953(var5x, f_1954, var8);
         m_1213(var5x, f_1955, var9);
         m_493(var5x, f_1956, var5);
         l(var5x, f_1957, 1.0F, 0.0F);
         l(var5x, f_1958, 1.0F / var0.textureWidth, 1.0F / var0.textureHeight);
      });
      RenderUtil6.m_4071(var1, true);
      m_2892(Util24.f_3276, var5x -> {
         var5x.m_3726(f_1945, RenderUtil6.m_668(var0.getColorAttachment()));
         m_493(var5x, f_1946, false);
         m_2953(var5x, f_1947, var8);
         m_1213(var5x, f_1948, var9);
         m_493(var5x, f_1949, var5);
         l(var5x, f_1950, 0.0F, 1.0F);
         l(var5x, f_1951, 1.0F / var1.textureWidth, 1.0F / var1.textureHeight);
      });
   }

   private static void m_1213(Util98 var0, String var1, int var2) {
      MathUtil6 var3 = var0.m_1335(var1);
      if (var3 != null) {
         var3.m_55(var2);
      }
   }

   private static Vector3f m_2552(float var0) {
      float var1 = f_1927;
      float var2 = (float)Math.exp(f_1928 / (var0 * var0));
      return new Vector3f(1.0F / (f_1929 * var0), var2, var2 * var2);
   }

   private static void l(Util98 var0, String var1, float var2, float var3) {
      MathUtil6 var4 = var0.m_1335(var1);
      if (var4 != null) {
         var4.m_54(var2, var3);
      }
   }

   private static void m_2876(int var0) {
      Util114.m_2012(var0);
      GL11.glTexParameteri(3553, f_1930, 0);
      GL11.glTexParameteri(3553, 10241, 9728);
      GL11.glTexParameteri(3553, 10240, 9728);
   }

   private static void m_1571(SimpleFramebuffer var0) {
      RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
      Util114.m_1481();
      Util114.m_542();
      m_2892(Util24.f_3278, var1 -> {
         var1.m_3726(f_1932, RenderUtil6.m_668(var0.getColorAttachment()));
         m_493(var1, f_1933, true);
      });
      Util114.m_963();
   }
}
