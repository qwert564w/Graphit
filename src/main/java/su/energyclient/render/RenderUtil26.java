package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Locale;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.TextureSetup;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import org.joml.Matrix3x2f;
import org.joml.Matrix4f;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;
import su.energyclient.util.Util118;
import su.energyclient.util.Util7;
import su.energyclient.util.Util71;
import su.energyclient.util.Util77;

public final class RenderUtil26 extends RenderUtil27 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final float f_1328;
   private static final int f_1329 = 1024;
   private static final int[] f_1330 = new int[]{31, 256, 1024, 1106, 9728, 9984, 9632, 9728};
   private static final char[] f_1331;
   private static final double f_1332 = 0.5;
   private static final double f_1333 = 0.5;
   private static final double f_1334 = 0.5;
   private static final double f_1335 = 0.5;
   private static final float f_1336 = 3.0F;
   private static final float f_1337 = 40.0F;
   private static final float f_1338 = 10.0F;
   private static final float f_1339 = 1000.0F;
   private static final float f_1340 = 600.0F;
   private static final float f_1341 = 1000.0F;
   private static final float f_1342 = 10.0F;
   private static final double f_1343 = 3.0;
   private static final float f_1344 = 0.5F;
   private static final float f_1345 = 0.5F;
   private static final float f_1346 = 0.5F;
   private static final float f_1347 = 0.5F;
   private static final float f_1348 = 0.5F;
   private static final double f_1349 = 3.0;
   private static final float f_1350 = 255.0F;
   private static final float f_1351 = 0.5F;
   private static final float f_1352 = 0.5F;
   private static final float f_1353 = 0.5F;
   private static final float f_1354 = 0.5F;
   private static final float f_1355 = 0.5F;
   private static final float f_1356 = 255.0F;
   private static final String f_1357 = "Dialog";
   private static final float f_1358 = 3.0F;
   private static final float f_1359 = 3.0F;
   private static final float f_1360 = 3.0F;
   private static final float f_1361 = 4.0F;
   private static final String f_1362 = "[^a-z0-9/_-]";
   private static final String f_1363 = "_";

   public float m_765(DrawContext var1, String var2, double var3, double var5, int var7) {
      return this.m_2915(var1, var2, var3 - this.m_585(var2) / 2.0F, var5, var7);
   }

   private float m_2611(Util77.aCGpp65d9SM4uNz7 var1, char var2, float var3, float var4, int var5) {
      RenderUtil27.OXbEjfdEAtRJiAJX var6 = this.f_1310.get(var2);
      if (var6 == null) {
         return 0.0F;
      } else {
         if (var6.f_5913 > 0 && var6.f_5914 > 0) {
            float var7 = (float)var6.f_5911 / this.f_1311;
            float var8 = (float)var6.f_5912 / this.f_1312;
            float var9 = (float)(var6.f_5911 + var6.f_5913) / this.f_1311;
            float var10 = (float)(var6.f_5912 + var6.f_5914) / this.f_1312;
            var1.m_3698(var3, var4, var3 + var6.f_5913, var4 + var6.f_5914, var7, var8, var9, var10, var5);
         }

         return var6.f_5913 + this.m_38();
      }
   }

   public float m_2915(DrawContext var1, String var2, double var3, double var5, int var7) {
      return m_297(var1, this, var2, var3, var5, var7);
   }

   private void m_1451(DrawContext var1, float var2, float var3, float var4, Runnable var5) {
      boolean var6 = Util77.m_71(var1);
      if (var6) {
         var1.enableScissor((int)Math.floor(var2), (int)Math.floor(var3 - f_1359), (int)Math.ceil(var2 + var4), (int)Math.ceil(var3 + this.m_619() + 1.0F));
      } else {
         RenderUtil2.m_3624(var2, var3 - f_1360, var4, this.m_619() + f_1361);
      }

      try {
         var5.run();
      } finally {
         if (var6) {
            var1.disableScissor();
         } else {
            RenderUtil2.m_1647();
         }
      }
   }

   public float m_3324(Text var1) {
      if (var1 == null) {
         return 0.0F;
      } else {
         float[] var2 = new float[]{0.0F};
         OrderedText var3 = var1.asOrderedText();
         var3.accept((var2x, var3x, var4) -> {
            String var6 = Util118.m_540(var4);
            String var5;
            if (Util118.m_3988(var4, var3x)) {
               var5 = Util118.m_1432(var3x);
            } else if (var6 != null) {
               var5 = var6;
            } else {
               var5 = new String(Character.toChars(var4));
            }

            if (var5 != null && !var5.isEmpty()) {
               for (int var7 = 0; var7 < var5.length(); var7++) {
                  char var8 = var5.charAt(var7);
                  var2[0] += this.m_1621(var8) + this.m_38();
               }

               return true;
            } else {
               return true;
            }
         });
         return var2[0] <= 0.0F ? 0.0F : (var2[0] - this.m_38()) / 2.0F;
      }
   }

   public float m_619() {
      return this.m_1875() / 2.0F - f_1358;
   }

   public void m_2929(DrawContext var1, String var2, double var3, double var5, int var7, boolean var8, boolean var9, boolean var10, boolean var11, int var12) {
      if (var8) {
         m_297(var1, this, var2, var3 - f_1332, var5, var12);
      }

      if (var9) {
         m_297(var1, this, var2, var3 + f_1333, var5, var12);
      }

      if (var10) {
         m_297(var1, this, var2, var3, var5 - f_1334, var12);
      }

      if (var11) {
         m_297(var1, this, var2, var3, var5 + f_1335, var12);
      }

      this.m_2915(var1, var2, var3, var5, var7);
   }

   static {
      int var0 = f_1330[1] - f_1330[0] + (f_1330[3] - f_1330[2]) + (f_1330[5] - f_1330[4]) + (f_1330[7] - f_1330[6]);
      f_1331 = new char[var0];
      int var1 = 0;

      for (int var2 = f_1330[0]; var2 < f_1330[1]; var2++) {
         f_1331[var1++] = (char)var2;
      }

      for (int var3 = f_1330[2]; var3 < f_1330[3]; var3++) {
         f_1331[var1++] = (char)var3;
      }

      for (int var4 = f_1330[4]; var4 < f_1330[5]; var4++) {
         f_1331[var1++] = (char)var4;
      }

      for (int var5 = f_1330[6]; var5 < f_1330[7]; var5++) {
         f_1331[var1++] = (char)var5;
      }
   }

   public void m_417(DrawContext var1, Text var2, float var3, float var4, int var5, float var6) {
      if (var2 != null && !(var6 <= 0.0F)) {
         if (this.m_3324(var2) <= var6) {
            this.m_3431(var1, var2, var3, var4, var5);
         } else {
            this.m_1451(var1, var3, var4, var6, () -> this.m_3431(var1, var2, var3, var4, var5));
         }
      }
   }

   private static float m_297(DrawContext var0, RenderUtil26 var1, String var2, double var3, double var5, int var7) {
      if (var2 != null && !var2.isEmpty()) {
         var5 -= f_1343;
         float var8 = (float)var3 * 2.0F;
         float var9 = var8;
         float var10 = (float)var5 * 2.0F;
         if (var1.f_1317 == null) {
            return var1.m_585(var2);
         } else if (Util77.m_71(var0)) {
            float var20 = (float)var3 * 2.0F;
            float var21 = var20;
            float var22 = (float)var5 * 2.0F;
            Util77.aCGpp65d9SM4uNz7 var24 = Util77.m_866(
               var0,
               RenderPipelines.GUI_TEXTURED,
               TextureSetup.of(var1.f_1317.getGlTextureView(), var1.f_1317.getSampler()),
               new Matrix3x2f(var0.getMatrices()).scale(f_1344, f_1345),
               Math.max(4, var2.length() * 4)
            );

            for (int var25 = 0; var25 < var2.length(); var25++) {
               var21 += var1.m_2611(var24, var2.charAt(var25), var21, var22, var7);
            }

            var24.m_1205();
            return (var21 - var20) * f_1346;
         } else {
            Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
            Util114.m_1481();
            Util114.m_542();
            Util114.m_3784(RenderUtil7.f_13886);
            Util114.m_2037(0, var1.f_1317);
            var0.getMatrices().pushMatrix();
            var0.getMatrices().scale(f_1347, f_1348);

            try {
               Matrix4f var11 = Util7.m_1924(var0.getMatrices());
               BufferBuilder var12 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
               int var13 = var2.length();

               for (int var14 = 0; var14 < var13; var14++) {
                  char var15 = var2.charAt(var14);
                  var9 += var1.m_3588(var12, var11, var15, var9, var10, var7);
               }

               BuiltBuffer var23 = var12.endNullable();
               if (var23 != null) {
                  RenderUtil12.I(var23);
               }
            } finally {
               var0.getMatrices().popMatrix();
               Util114.m_963();
            }

            return (var9 - var8) / 2.0F;
         }
      } else {
         return 0.0F;
      }
   }

   public float m_3431(DrawContext var1, Text var2, double var3, double var5, int var7) {
      if (var2 == null) {
         return 0.0F;
      } else {
         var5 -= f_1349;
         float var8 = (float)var3 * 2.0F;
         float[] var9 = new float[]{var8};
         float var10 = (float)var5 * 2.0F;
         if (this.f_1317 == null) {
            return this.m_3324(var2);
         } else if (Util77.m_71(var1)) {
            float var21 = (float)var3 * 2.0F;
            float var22 = (float)var5 * 2.0F;
            float[] var23 = new float[]{var21};
            int var24 = Util71.m_2734(var7);
            float var25 = var24 / f_1350;
            Util77.aCGpp65d9SM4uNz7 var16 = Util77.m_866(
               var1,
               RenderPipelines.GUI_TEXTURED,
               TextureSetup.of(this.f_1317.getGlTextureView(), this.f_1317.getSampler()),
               new Matrix3x2f(var1.getMatrices()).scale(f_1351, f_1352),
               Math.max(4, var2.getString().length() * 4)
            );
            var2.asOrderedText().accept((var7x, var8x, var9x) -> {
               int var10x = var7;
               TextColor var11x = var8x.getColor();
               if (var11x != null) {
                  var10x = Util71.m_3389(var11x.getRgb(), var24);
               }

               if (Util118.m_3988(var9x, var8x) && var8x.getFont() != null) {
                  int var12x = Util118.m_2782(var8x.getFont().toString(), var25);
                  if (var12x != -1) {
                     var10x = var12x;
                  }
               }

               String var16x = Util118.m_540(var9x);
               String var13x = Util118.m_3988(var9x, var8x) ? Util118.m_1432(var8x) : (var16x != null ? var16x : new String(Character.toChars(var9x)));
               if (var13x != null && !var13x.isEmpty()) {
                  for (int var14x = 0; var14x < var13x.length(); var14x++) {
                     int var15x = var16x != null && !var16x.isEmpty() ? Util118.m_1170(var9x, var14x, var13x.length(), var25, var10x) : var10x;
                     var23[0] += this.m_2611(var16, var13x.charAt(var14x), var23[0], var22, var15x);
                  }

                  return true;
               } else {
                  return true;
               }
            });
            var16.m_1205();
            return (var23[0] - var21) * f_1353;
         } else {
            Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
            Util114.m_1481();
            Util114.m_542();
            Util114.m_3784(RenderUtil7.f_13886);
            Util114.m_2037(0, this.f_1317);
            var1.getMatrices().pushMatrix();
            var1.getMatrices().scale(f_1354, f_1355);
            int var11 = Util71.m_2734(var7);
            float var12 = var11 / f_1356;

            try {
               Matrix4f var13 = Util7.m_1924(var1.getMatrices());
               BufferBuilder var14 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
               var2.asOrderedText().accept((var8x, var9x, var10x) -> {
                  int var11x = var7;
                  TextColor var12x = var9x.getColor();
                  if (var12x != null) {
                     var11x = Util71.m_3389(var12x.getRgb(), var11);
                  }

                  if (Util118.m_3988(var10x, var9x) && var9x.getFont() != null) {
                     int var13x = Util118.m_2782(var9x.getFont().toString(), var12);
                     if (var13x != -1) {
                        var11x = var13x;
                     }
                  }

                  String var18 = Util118.m_540(var10x);
                  String var14x;
                  if (Util118.m_3988(var10x, var9x)) {
                     var14x = Util118.m_1432(var9x);
                  } else if (var18 != null) {
                     var14x = var18;
                  } else {
                     var14x = new String(Character.toChars(var10x));
                  }

                  if (var14x != null && !var14x.isEmpty()) {
                     int var15x = var14x.length();

                     for (int var16x = 0; var16x < var15x; var16x++) {
                        int var17 = var18 != null && !var18.isEmpty() ? Util118.m_1170(var10x, var16x, var15x, var12, var11x) : var11x;
                        var9[0] += this.m_3588(var14, var13, var14x.charAt(var16x), var9[0], var10, var17);
                     }

                     return true;
                  } else {
                     return true;
                  }
               });
               BuiltBuffer var15 = var14.endNullable();
               if (var15 != null) {
                  RenderUtil12.I(var15);
               }
            } finally {
               var1.getMatrices().popMatrix();
               Util114.m_963();
            }

            return (var9[0] - var8) / 2.0F;
         }
      }
   }

   public float m_2959(DrawContext var1, Text var2, double var3, double var5, int var7) {
      return this.m_3431(var1, var2, var3, var5, var7);
   }

   public float m_585(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         float var2 = 0.0F;
         int var3 = 0;

         while (var3 < var1.length()) {
            int var4 = var1.codePointAt(var3);
            var3 += Character.charCount(var4);
            String var5 = Util118.m_540(var4);
            if (var5 == null) {
               char[] var6 = Character.toChars(var4);

               for (char var10 : var6) {
                  var2 += this.m_1621(var10) + this.m_38();
               }
            } else if (!var5.isEmpty()) {
               for (int var11 = 0; var11 < var5.length(); var11++) {
                  char var12 = var5.charAt(var11);
                  var2 += this.m_1621(var12) + this.m_38();
               }
            }
         }

         return (var2 - this.m_38()) / 2.0F;
      } else {
         return 0.0F;
      }
   }

   @Override
   public float m_38() {
      return this.f_1328;
   }

   private static String m_3151(String var0) {
      return var0.toLowerCase(Locale.ROOT).replace('.', '_').replaceAll(f_1362, f_1363);
   }

   public void m_1710(DrawContext var1, String var2, float var3, float var4, float var5, int var6, boolean var7, RenderUtil26.JyPPeWE08Nc2NqHK var8) {
      float var9 = this.m_585(var2);
      float var10 = this.m_619();
      boolean var11 = var9 > var5;
      if (!var11) {
         var8.f_11519 = false;
         this.m_2915(var1, var2, var3, var4, var6);
      } else {
         boolean var12 = Util77.m_71(var1);
         if (var12) {
            var1.enableScissor((int)Math.floor(var3), (int)Math.floor(var4 - 1.0F), (int)Math.ceil(var3 + var5), (int)Math.ceil(var4 + var10 + 2.0F));
         } else {
            RenderUtil2.m_3624(var3, var4 - 1.0F, var5, var10 + f_1336);
         }

         try {
            long var13 = System.currentTimeMillis();
            float var15 = f_1337;
            float var16 = var9 + f_1338;
            float var17 = var16 / var15 * f_1339;
            float var18 = f_1340;
            float var19 = var17 + var18;
            float var20 = 0.0F;
            if (var7 && !var8.f_11519) {
               var8.f_11520 = var13;
               var8.f_11519 = true;
            }

            if (var8.f_11519) {
               long var21 = var13 - var8.f_11520;
               if ((float)var21 < var19) {
                  if ((float)var21 < var17) {
                     var20 = (float)var21 / f_1341 * var15;
                  } else {
                     var20 = 0.0F;
                  }
               } else {
                  var8.f_11519 = false;
                  var20 = 0.0F;
               }
            }

            this.m_2915(var1, var2, var3 - var20, var4, var6);
            if (var20 > 0.0F) {
               this.m_2915(var1, var2, var3 - var20 + var9 + f_1342, var4, var6);
            }
         } finally {
            if (var12) {
               var1.disableScissor();
            } else {
               RenderUtil2.m_1647();
            }
         }
      }
   }

   public void m_1904(DrawContext var1, String var2, float var3, float var4, int var5, float var6) {
      if (var2 != null && !var2.isEmpty() && !(var6 <= 0.0F)) {
         if (this.m_585(var2) <= var6) {
            m_297(var1, this, var2, var3, var4, var5);
         } else {
            this.m_1451(var1, var3, var4, var6, () -> m_297(var1, this, var2, var3, var4, var5));
         }
      }
   }

   public RenderUtil26(String var1, int var2, float var3, boolean var4) {
      Font var5 = m_3850(var1, 0, var2);
      if (var5 == null) {
         var5 = new Font(f_1357, 0, var2);
      }

      this.f_1314 = var5.getFontName(Locale.ENGLISH);
      this.f_1328 = var3;
      this.f_1315 = var4;
      this.f_1311 = 1024;
      this.f_1312 = 1024;
      BufferedImage var6 = new BufferedImage(1, 1, 2);
      Graphics2D var7 = this.m_1872(var6, var5);
      FontMetrics var8 = var7.getFontMetrics();
      this.f_1313 = var8.getHeight();
      byte var9 = 2;
      int var10 = 0;
      int var11 = 0;
      int var12 = 0;

      for (char var16 : f_1331) {
         Rectangle2D var17 = var8.getStringBounds(String.valueOf(var16), var7);
         int var18 = var17.getBounds().width + 4;
         int var19 = var17.getBounds().height + 4;
         if (var10 > 0 && var10 + var18 > 1024) {
            var10 = 0;
            var11 += var12;
            var12 = 0;
         }

         var10 += var18;
         var12 = Math.max(var12, var19);
      }

      this.f_1312 = Math.max(1, var11 + var12);
      var7.dispose();
      var6.flush();
      BufferedImage var29 = new BufferedImage(this.f_1311, this.f_1312, 2);
      Graphics2D var30 = this.m_1872(var29, var5);
      FontMetrics var31 = var30.getFontMetrics();
      this.f_1313 = var31.getHeight();
      int var32 = 0;
      int var33 = 0;
      var12 = 0;

      for (char var21 : f_1331) {
         Rectangle2D var22 = var31.getStringBounds(String.valueOf(var21), var30);
         int var23 = var22.getBounds().width;
         int var24 = var22.getBounds().height;
         int var25 = var23 + 4;
         int var26 = var24 + 4;
         if (var32 > 0 && var32 + var25 > 1024) {
            var32 = 0;
            var33 += var12;
            var12 = 0;
         }

         RenderUtil27.OXbEjfdEAtRJiAJX var27 = new RenderUtil27.OXbEjfdEAtRJiAJX();
         var27.f_5913 = var23;
         var27.f_5914 = var24;
         var27.f_5911 = var32 + 2;
         var27.f_5912 = var33 + 2;
         var30.drawString(String.valueOf(var21), var32 + 2, var33 + 2 + var31.getAscent());
         this.f_1310.put(var21, var27);
         var32 += var25;
         var12 = Math.max(var12, var26);
      }

      String var36 = "font_atlas/" + m_3151(var1) + "/" + var2;
      Util114.m_2697(() -> {
         try {
            this.m_1942(var29, var36);
         } finally {
            var29.flush();
         }
      });
      var30.dispose();
   }

   public static class JyPPeWE08Nc2NqHK {
      public boolean f_11519 = false;
      public long f_11520 = 0L;
   }
}
