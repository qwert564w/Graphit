package su.energyclient.util;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import java.awt.Color;
import java.util.Arrays;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureSetup;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.jspecify.annotations.Nullable;
import su.energyclient.render.RenderUtil21;

public final class Util77 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_5812 = 6;
   @Nullable
   private static DrawContext f_5813;
   private static double f_5814 = 1.0;
   private static float f_5815 = 1.0F;
   private static final float f_5816 = 5.0F;
   private static final float f_5817 = 0.5F;
   private static final float f_5818 = 0.001F;
   private static final float f_5819 = 0.001F;
   private static final int f_5820 = 16777215;
   private static final float f_5821 = 0.5F;
   private static final float f_5822 = 0.5F;
   private static final float f_5823 = 0.25F;
   private static final float f_5824 = 255.0F;
   private static final int f_5825 = 16777215;
   private static final float f_5826 = 3.0F;
   private static final float f_5827 = 3.0F;
   private static final float f_5828 = 64.0F;
   private static final float f_5829 = 0.001F;
   private static final float f_5830 = 0.001F;
   private static final float f_5831 = 0.001F;
   private static final float f_5832 = 0.001F;
   private static final float f_5833 = 0.001F;
   private static final float f_5834 = 0.001F;
   private static final float f_5835 = 0.001F;
   private static final float f_5836 = 0.5F;
   private static final double f_5837 = -Math.PI / 2;
   private static final double f_5838 = Math.PI / 2;
   private static final double f_5839 = Math.PI / 2;
   private static final double f_5840 = Math.PI;
   private static final double f_5841 = Math.PI;
   private static final double f_5842 = Math.PI * 3.0 / 2.0;
   private static final double f_5843 = 2.0;
   private static final double f_5844 = 2.0;
   private static final float f_5845 = 255.0F;
   private static final int f_5846 = 16777215;
   private static final int f_5847 = 16777215;
   private static final float f_5848 = 255.0F;

   @Nullable
   public static DrawContext m_3042() {
      return f_5813;
   }

   public static boolean m_3837(float var0, float var1, float var2, float var3, Vector4f var4, int var5, int var6, int var7, int var8, float var9) {
      DrawContext var10 = f_5813;
      if (var10 == null) {
         return false;
      } else {
         m_3304(var10, new Matrix3x2f(var10.getMatrices()), var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, 2.0F);
         return true;
      }
   }

   public static Util77.aCGpp65d9SM4uNz7 m_216(DrawContext var0, RenderPipeline var1, TextureSetup var2, Matrix3x2fc var3) {
      return new Util77.aCGpp65d9SM4uNz7(var0, var1, var2, var3, 4);
   }

   private static void m_3476(Util77.jFlgXQoS7z2JQwl5 var0, float[] var1, float var2, float var3, int var4, Util77.z8YkIj4DT5WYzcsi var5) {
      int var6 = var1.length / 2;

      for (int var7 = 0; var7 < var6; var7++) {
         int var8 = (var7 + 1) % var6;
         float var9 = var1[var7 * 2];
         float var10 = var1[var7 * 2 + 1];
         float var11 = var1[var8 * 2];
         float var12 = var1[var8 * 2 + 1];
         var0.m_3144(var2, var3, var4, var11, var12, var5.O(var11, var12), var9, var10, var5.O(var9, var10), var2, var3, var4);
      }
   }

   public static boolean m_1143(float var0, float var1, float var2, float var3, Vector4f var4, int var5) {
      DrawContext var6 = f_5813;
      if (var6 == null) {
         return false;
      } else {
         m_3142(var6, new Matrix3x2f(var6.getMatrices()), var0, var1, var2, var3, var4, var5, f_5816);
         return true;
      }
   }

   public static boolean m_2229(float var0, float var1, float var2, float var3, Vector4f var4, int var5) {
      DrawContext var6 = f_5813;
      if (var6 == null) {
         return false;
      } else {
         m_3142(var6, new Matrix3x2f(var6.getMatrices()), var0, var1, var2, var3, var4, var5, 2.0F);
         return true;
      }
   }

   private static int m_3170(int var0, float var1) {
      int var2 = var0 >>> 24 & 0xFF;
      int var3 = Math.round(var2 * m_1960(var1));
      return var0 & f_5846 | var3 << 24;
   }

   private static void m_1200(float[] var0, int var1, Matrix3x2fc var2, float var3, float var4, float var5, float var6, float var7) {
      int var8 = var1 * 5;
      var0[var8] = var2.m00() * var3 + var2.m10() * var4 + var2.m20();
      var0[var8 + 1] = var2.m01() * var3 + var2.m11() * var4 + var2.m21();
      var0[var8 + 2] = var5;
      var0[var8 + 3] = var6;
      var0[var8 + 4] = var7;
   }

   public static boolean m_996(float var0, float var1, float var2, float var3, float var4, int var5, float var6) {
      DrawContext var7 = f_5813;
      if (var7 == null) {
         return false;
      } else if (var2 <= 0.0F || var3 <= 0.0F || var6 <= 0.0F) {
         return true;
      } else if (!Util142.f_12027.m_2282()) {
         return true;
      } else if (Util142.f_12027.f_12028.getColorAttachmentView() == null) {
         return true;
      } else {
         Matrix3x2f var8 = new Matrix3x2f(var7.getMatrices());
         TextureSetup var9 = TextureSetup.of(Util142.f_12027.f_12028.getColorAttachmentView(), RenderSystem.getSamplerCache().get(FilterMode.LINEAR));
         float var10 = Math.max(0.0F, var4);
         m_941(
            var7,
            RenderUtil21.l,
            var9,
            var8,
            var0,
            var1,
            var2,
            var3,
            m_1960(var6),
            var2,
            var3,
            new Vector4f(var10, var10, var10, var10),
            var5,
            var5,
            var5,
            var5
         );
         return true;
      }
   }

   public static Util77.spzMrT3b6LRsUJ1m m_2198(DrawContext var0, float var1) {
      DrawContext var2 = f_5813;
      double var3 = f_5814;
      float var5 = f_5815;
      float var6 = Float.isFinite(var1) && var1 > 0.0F ? var1 : 1.0F;
      f_5813 = var0;
      f_5815 = var6;
      MinecraftClient var7 = MinecraftClient.getInstance();
      double var8 = var7 != null && var7.getWindow() != null ? Math.max(1.0, (double)var7.getWindow().getScaleFactor()) : 1.0;
      f_5814 = var8 / var6;
      var0.getMatrices().pushMatrix();
      var0.getMatrices().scale(var6, var6);
      return new Util77.spzMrT3b6LRsUJ1m(var0, var2, var3, var5);
   }

   private static boolean m_1279(DrawContext var0, Identifier var1, Matrix3x2fc var2, float var3, float var4, float var5, float var6, int var7, boolean var8) {
      AbstractTexture var9 = MinecraftClient.getInstance().getTextureManager().getTexture(var1);
      TextureSetup var10 = TextureSetup.of(var9.getGlTextureView(), var9.getSampler());
      RenderPipeline var11 = var8 ? RenderUtil21.f_1148 : RenderPipelines.GUI_TEXTURED;
      Util77.aCGpp65d9SM4uNz7 var12 = m_216(var0, var11, var10, var2);
      var12.m_3698(var3, var4, var3 + var5, var4 + var6, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      var12.m_1205();
      return true;
   }

   public static boolean m_71(@Nullable DrawContext var0) {
      return var0 != null && var0 == f_5813;
   }

   private static boolean m_1225(Vector4f var0) {
      return Math.abs(var0.x - var0.y) <= f_5833 && Math.abs(var0.x - var0.z) <= f_5834 && Math.abs(var0.x - var0.w) <= f_5835;
   }

   private static Util77.jFlgXQoS7z2JQwl5 m_375(DrawContext var0, RenderPipeline var1, TextureSetup var2, Matrix3x2fc var3) {
      return new Util77.jFlgXQoS7z2JQwl5(var0, var1, var2, var3);
   }

   public static void m_2075() {
      f_5813 = null;
      f_5814 = 1.0;
      f_5815 = 1.0F;
   }

   private static void m_941(
      DrawContext var0,
      RenderPipeline var1,
      TextureSetup var2,
      Matrix3x2fc var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      Vector4f var11,
      int var12,
      int var13,
      int var14,
      int var15
   ) {
      float[] var16 = new float[20];
      int[] var17 = new int[]{var12, var13, var14, var15};
      m_1200(var16, 0, var3, var4, var5, var8, var9, var10);
      m_1200(var16, 1, var3, var4, var5 + var7, var8, var9, var10);
      m_1200(var16, 2, var3, var4 + var6, var5 + var7, var8, var9, var10);
      m_1200(var16, 3, var3, var4 + var6, var5, var8, var9, var10);
      ScreenRect var18 = var0.scissorStack.peekLast();
      ScreenRect var19 = m_880(var16, 5, var18);
      if (var19 != null) {
         var0.state
            .addSimpleElement(
               new Util77.GH1dIGS7BHnpFkgP(var1, var2, var16, var17, m_1870(var11.x), m_1870(var11.y), m_1870(var11.z), m_1870(var11.w), var18, var19)
            );
      }
   }

   private Util77() {
   }

   private static int m_3056(int var0, float var1) {
      return var0 & f_5847 | Math.round(m_1960(var1) * f_5848) << 24;
   }

   private static float m_2852(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   @Nullable
   private static ScreenRect m_880(float[] var0, int var1, @Nullable ScreenRect var2) {
      float var3 = Float.POSITIVE_INFINITY;
      float var4 = Float.POSITIVE_INFINITY;
      float var5 = Float.NEGATIVE_INFINITY;
      float var6 = Float.NEGATIVE_INFINITY;
      int var7 = 0;

      while (var7 < var0.length) {
         var3 = Math.min(var3, var0[var7]);
         var4 = Math.min(var4, var0[var7 + 1]);
         var5 = Math.max(var5, var0[var7]);
         var6 = Math.max(var6, var0[var7 + 1]);
         var7 += var1;
      }

      var7 = (int)Math.floor(var3);
      int var8 = (int)Math.floor(var4);
      int var9 = (int)Math.ceil(var5);
      int var10 = (int)Math.ceil(var6);
      if (var9 > var7 && var10 > var8) {
         ScreenRect var11 = new ScreenRect(var7, var8, var9 - var7, var10 - var8);
         return var2 == null ? var11 : var2.intersection(var11);
      } else {
         return null;
      }
   }

   public static void m_73(DrawContext var0) {
      f_5813 = var0;
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1 != null && var1.getWindow() != null) {
         f_5814 = Math.max(1.0, (double)var1.getWindow().getScaleFactor());
      }
   }

   private static void m_2684(
      DrawContext var0,
      Matrix3x2fc var1,
      float var2,
      float var3,
      float var4,
      float var5,
      Vector4f var6,
      int var7,
      int var8,
      int var9,
      int var10,
      RenderPipeline var11
   ) {
      m_941(var0, var11, TextureSetup.empty(), var1, var2, var3, var4, var5, 0.0F, var4, var5, var6, var7, var8, var10, var9);
   }

   public static boolean m_4130(Identifier var0, Matrix3x2fc var1, double var2, double var4, double var6, double var8, Color var10, boolean var11) {
      DrawContext var12 = f_5813;
      return var12 == null ? false : m_1279(var12, var0, new Matrix3x2f(var1), (float)var2, (float)var4, (float)var6, (float)var8, var10.getRGB(), var11);
   }

   private static float[] m_2996(float var0, float var1, float var2, float var3, Vector4f var4, float var5, int var6) {
      float var7 = Math.max(0.0F, Math.min(var2, var3) * f_5836);
      float var8 = Math.min(var7, Math.max(0.0F, var4.x));
      float var9 = Math.min(var7, Math.max(0.0F, var4.y));
      float var10 = Math.min(var7, Math.max(0.0F, var4.z));
      float var11 = Math.min(var7, Math.max(0.0F, var4.w));
      float[] var12 = new float[(var6 + 1) * 4 * 2];
      int var13 = 0;
      var13 = m_3152(var12, var13, var0 + var2 - var10, var1 + var10, var10, f_5837, 0.0, var5, var6);
      var13 = m_3152(var12, var13, var0 + var2 - var11, var1 + var3 - var11, var11, 0.0, f_5838, var5, var6);
      var13 = m_3152(var12, var13, var0 + var9, var1 + var3 - var9, var9, f_5839, f_5840, var5, var6);
      var13 = m_3152(var12, var13, var0 + var8, var1 + var8, var8, f_5841, f_5842, var5, var6);
      return var13 == var12.length ? var12 : Arrays.copyOf(var12, var13);
   }

   private static void m_3304(
      DrawContext var0,
      Matrix3x2fc var1,
      float var2,
      float var3,
      float var4,
      float var5,
      Vector4f var6,
      int var7,
      int var8,
      int var9,
      int var10,
      float var11,
      float var12
   ) {
      if (!(var4 <= 0.0F) && !(var5 <= 0.0F) && !(var11 <= 0.0F)) {
         int var13 = m_3056(var7, var11);
         int var14 = m_3056(var8, var11);
         int var15 = m_3056(var9, var11);
         int var16 = m_3056(var10, var11);
         m_2684(var0, var1, var2, var3, var4, var5, var6, var13, var14, var15, var16, var12 > f_5827 ? RenderUtil21.f_1146 : RenderUtil21.f_1145);
      }
   }

   public static boolean m_1368(DrawContext var0, Identifier var1, float var2, float var3, float var4, float var5, int var6, boolean var7) {
      return !m_71(var0) ? false : m_1279(var0, var1, new Matrix3x2f(var0.getMatrices()), var2, var3, var4, var5, var6, var7);
   }

   public static boolean m_2940(DrawContext var0, float var1, float var2, float var3, float var4, int var5, int var6, int var7, int var8) {
      if (!m_71(var0)) {
         return false;
      } else {
         Util77.jFlgXQoS7z2JQwl5 var9 = m_375(var0, RenderPipelines.GUI, TextureSetup.empty(), new Matrix3x2f(var0.getMatrices()));
         var9.m_3144(var1, var2, var5, var1, var2 + var4, var6, var1 + var3, var2 + var4, var7, var1 + var3, var2, var8);
         var9.m_3143();
         return true;
      }
   }

   private static int m_1870(float var0) {
      return Math.min(32767, Math.max(0, Math.round(var0 * f_5828)));
   }

   public static Util77.aCGpp65d9SM4uNz7 m_866(DrawContext var0, RenderPipeline var1, TextureSetup var2, Matrix3x2fc var3, int var4) {
      return new Util77.aCGpp65d9SM4uNz7(var0, var1, var2, var3, var4);
   }

   private static void m_3142(DrawContext var0, Matrix3x2fc var1, float var2, float var3, float var4, float var5, Vector4f var6, int var7, float var8) {
      if (!(var4 <= 0.0F) && !(var5 <= 0.0F) && (var7 >>> 24 & 0xFF) != 0) {
         m_2684(var0, var1, var2, var3, var4, var5, var6, var7, var7, var7, var7, var8 > f_5826 ? RenderUtil21.f_1146 : RenderUtil21.f_1145);
      }
   }

   private static int m_1713(int var0, int var1, int var2, int var3, float var4, float var5, float var6) {
      int var7 = Math.round(m_1960(var6) * f_5845);
      int var8 = Math.round(m_2852(m_2852(var0 >>> 16 & 0xFF, var1 >>> 16 & 0xFF, var5), m_2852(var2 >>> 16 & 0xFF, var3 >>> 16 & 0xFF, var5), var4));
      int var9 = Math.round(m_2852(m_2852(var0 >>> 8 & 0xFF, var1 >>> 8 & 0xFF, var5), m_2852(var2 >>> 8 & 0xFF, var3 >>> 8 & 0xFF, var5), var4));
      int var10 = Math.round(m_2852(m_2852(var0 & 0xFF, var1 & 0xFF, var5), m_2852(var2 & 0xFF, var3 & 0xFF, var5), var4));
      return var7 << 24 | var8 << 16 | var9 << 8 | var10;
   }

   private static boolean m_832(Vector4f var0) {
      return var0.x <= f_5829 && var0.y <= f_5830 && var0.z <= f_5831 && var0.w <= f_5832;
   }

   public static boolean m_1916(Identifier var0, @Nullable LivingEntity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      DrawContext var8 = f_5813;
      if (var8 == null) {
         return false;
      } else if (!(var4 <= 0.0F) && !(var5 <= 0.0F) && !(var7 <= 0.0F)) {
         AbstractTexture var9 = MinecraftClient.getInstance().getTextureManager().getTexture(var0);
         TextureSetup var10 = TextureSetup.of(var9.getGlTextureView(), var9.getSampler());
         Matrix3x2f var11 = new Matrix3x2f(var8.getMatrices());
         float var12 = var1 != null && var1.hurtTime > 0 && var1.maxHurtTime > 0 ? Math.min(f_5823, (float)var1.hurtTime / var1.maxHurtTime) : 0.0F;
         int var13 = (Math.round(m_1960(var7) * f_5824) & 0xFF) << 24 | f_5825;
         float var14 = Math.max(0.0F, var6);
         m_941(
            var8,
            RenderUtil21.f_1149,
            var10,
            var11,
            var2,
            var3,
            var4,
            var5,
            var12,
            var4,
            var5,
            new Vector4f(var14, var14, var14, var14),
            var13,
            var13,
            var13,
            var13
         );
         return true;
      } else {
         return true;
      }
   }

   public static boolean m_1427(Identifier var0, MatrixStack var1, double var2, double var4, double var6, double var8, Color var10, boolean var11) {
      DrawContext var12 = f_5813;
      if (var12 == null) {
         return false;
      } else {
         Matrix4f var13 = var1.peek().getPositionMatrix();
         Matrix3x2f var14 = new Matrix3x2f(var13.m00(), var13.m01(), var13.m10(), var13.m11(), var13.m30(), var13.m31());
         Matrix3x2f var15 = new Matrix3x2f().scale(f_5815, f_5815).mul(var14);
         return m_1279(var12, var0, var15, (float)var2, (float)var4, (float)var6, (float)var8, var10.getRGB(), var11);
      }
   }

   public static boolean m_1731(DrawContext var0, float var1, float var2, float var3, float var4, int var5) {
      if (!m_71(var0)) {
         return false;
      } else {
         Util77.jFlgXQoS7z2JQwl5 var6 = m_375(var0, RenderPipelines.GUI, TextureSetup.empty(), new Matrix3x2f(var0.getMatrices()));
         var6.m_3144(var1, var2, var5, var1, var2 + var4, var5, var1 + var3, var2 + var4, var5, var1 + var3, var2, var5);
         var6.m_3143();
         return true;
      }
   }

   private static float m_1960(float var0) {
      return Math.max(0.0F, Math.min(1.0F, var0));
   }

   public static boolean m_1065(float var0, float var1, float var2, float var3, Vector4f var4, int var5, float var6, float var7) {
      DrawContext var8 = f_5813;
      if (var8 == null) {
         return false;
      } else if (!(var2 <= 0.0F) && !(var3 <= 0.0F) && !(var6 <= 0.0F)) {
         Matrix3x2f var9 = new Matrix3x2f(var8.getMatrices());
         float var10 = Math.max(0.0F, Math.min(var7, Math.min(var2, var3) * f_5817));
         if (var10 <= f_5818) {
            m_3142(var8, var9, var0, var1, var2, var3, var4, m_3170(var5, var6), 2.0F);
            return true;
         } else if (m_1225(var4)) {
            float var20 = Math.max(f_5819, Math.min(var2, var3));
            float var21 = Math.max(0.0F, var4.x) / var20;
            float var22 = var10 / var20;
            int var23 = m_3056(var5, var6);
            Util77.aCGpp65d9SM4uNz7 var24 = m_216(var8, RenderUtil21.f_1147, TextureSetup.empty(), var9);
            var24.m_1052(var0, var1, 0.0F, var21, var22, var23);
            var24.m_1052(var0, var1 + var3, 0.0F, var21, var22, var23);
            var24.m_1052(var0 + var2, var1 + var3, 0.0F, var21, var22, var23);
            var24.m_1052(var0 + var2, var1, 0.0F, var21, var22, var23);
            var24.m_1205();
            return true;
         } else {
            float[] var11 = m_2996(var0, var1, var2, var3, var4, 2.0F, 6);
            Vector4f var12 = new Vector4f(
               Math.max(0.0F, var4.x - var10), Math.max(0.0F, var4.y - var10), Math.max(0.0F, var4.z - var10), Math.max(0.0F, var4.w - var10)
            );
            float[] var13 = m_2996(var0 + var10, var1 + var10, var2 - var10 * 2.0F, var3 - var10 * 2.0F, var12, 2.0F, 6);
            int var14 = m_3056(var5, var6);
            int var15 = var5 & f_5820;
            Util77.jFlgXQoS7z2JQwl5 var16 = m_375(var8, RenderPipelines.GUI, TextureSetup.empty(), var9);
            int var17 = Math.min(var11.length, var13.length) / 2;

            for (int var18 = 0; var18 < var17; var18++) {
               int var19 = (var18 + 1) % var17;
               var16.m_3144(
                  var11[var18 * 2],
                  var11[var18 * 2 + 1],
                  var15,
                  var13[var18 * 2],
                  var13[var18 * 2 + 1],
                  var14,
                  var13[var19 * 2],
                  var13[var19 * 2 + 1],
                  var14,
                  var11[var19 * 2],
                  var11[var19 * 2 + 1],
                  var15
               );
            }

            m_3476(var16, var13, var0 + var2 * f_5821, var1 + var3 * f_5822, var14, (var1x, var2x) -> var14);
            var16.m_3143();
            return true;
         }
      } else {
         return true;
      }
   }

   public static Util77.spzMrT3b6LRsUJ1m m_266(DrawContext var0) {
      return m_2198(var0, 1.0F);
   }

   private static int m_3152(float[] var0, int var1, float var2, float var3, float var4, double var5, double var7, float var9, int var10) {
      double var11 = f_5843 / Math.max(f_5844, (double)var9);

      for (int var13 = 0; var13 <= var10; var13++) {
         double var14 = var5 + (var7 - var5) * var13 / var10;
         double var16 = Math.cos(var14);
         double var18 = Math.sin(var14);
         var0[var1++] = var2 + var4 * (float)Math.copySign(Math.pow(Math.abs(var16), var11), var16);
         var0[var1++] = var3 + var4 * (float)Math.copySign(Math.pow(Math.abs(var18), var11), var18);
      }

      return var1;
   }

   private record GH1dIGS7BHnpFkgP(
      RenderPipeline pipeline,
      TextureSetup textureSetup,
      float[] data,
      int[] colors,
      int topLeftRadius,
      int bottomLeftRadius,
      int topRightRadius,
      int bottomRightRadius,
      @Nullable ScreenRect scissorArea,
      ScreenRect bounds
   ) implements SimpleGuiElementRenderState {
      public void setupVertices(VertexConsumer var1) {
         for (int var2 = 0; var2 < 4; var2++) {
            int var3 = var2 * 5;
            var1.vertex(this.data[var3], this.data[var3 + 1], this.data[var3 + 2])
               .color(this.colors[var2])
               .texture(this.data[var3 + 3], this.data[var3 + 4])
               .overlay(this.topLeftRadius, this.bottomLeftRadius)
               .light(this.topRightRadius, this.bottomRightRadius);
         }
      }
   }

   private record IJtQCqgyI336vbWe(
      RenderPipeline pipeline, TextureSetup textureSetup, float[] data, int[] colors, @Nullable ScreenRect scissorArea, ScreenRect bounds
   ) implements SimpleGuiElementRenderState {
      public void setupVertices(VertexConsumer var1) {
         for (int var2 = 0; var2 < this.colors.length; var2++) {
            int var3 = var2 * 5;
            var1.vertex(this.data[var3], this.data[var3 + 1], this.data[var3 + 2]).texture(this.data[var3 + 3], this.data[var3 + 4]).color(this.colors[var2]);
         }
      }
   }

   public static final class aCGpp65d9SM4uNz7 {
      private final DrawContext f_2595;
      private final RenderPipeline f_2596;
      private final TextureSetup f_2597;
      private final Matrix3x2f f_2598;
      private float[] f_2599;
      private int[] f_2600;
      private int f_2601;

      public void m_1205() {
         if (this.f_2601 != 0) {
            float[] var1 = this.f_2599.length == this.f_2601 * 5 ? this.f_2599 : Arrays.copyOf(this.f_2599, this.f_2601 * 5);
            int[] var2 = this.f_2600.length == this.f_2601 ? this.f_2600 : Arrays.copyOf(this.f_2600, this.f_2601);
            ScreenRect var3 = this.f_2595.scissorStack.peekLast();
            ScreenRect var4 = Util77.m_880(var1, 5, var3);
            if (var4 != null) {
               this.f_2595.state.addSimpleElement(new Util77.IJtQCqgyI336vbWe(this.f_2596, this.f_2597, var1, var2, var3, var4));
            }
         }
      }

      public void m_1052(float var1, float var2, float var3, float var4, float var5, int var6) {
         this.m_1793(this.f_2601 + 1);
         int var7 = this.f_2601 * 5;
         this.f_2599[var7] = this.f_2598.m00() * var1 + this.f_2598.m10() * var2 + this.f_2598.m20();
         this.f_2599[var7 + 1] = this.f_2598.m01() * var1 + this.f_2598.m11() * var2 + this.f_2598.m21();
         this.f_2599[var7 + 2] = var3;
         this.f_2599[var7 + 3] = var4;
         this.f_2599[var7 + 4] = var5;
         this.f_2600[this.f_2601] = var6;
         this.f_2601++;
      }

      public void m_3698(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
         this.m_1052(var1, var2, 0.0F, var5, var6, var9);
         this.m_1052(var1, var4, 0.0F, var5, var8, var9);
         this.m_1052(var3, var4, 0.0F, var7, var8, var9);
         this.m_1052(var3, var2, 0.0F, var7, var6, var9);
      }

      private aCGpp65d9SM4uNz7(DrawContext var1, RenderPipeline var2, TextureSetup var3, Matrix3x2fc var4, int var5) {
         this.f_2595 = var1;
         this.f_2596 = var2;
         this.f_2597 = var3;
         this.f_2598 = new Matrix3x2f(var4);
         int var6 = Math.max(4, var5);
         this.f_2599 = new float[5 * var6];
         this.f_2600 = new int[var6];
      }

      private void m_1793(int var1) {
         if (var1 > this.f_2600.length) {
            int var2 = Math.max(var1, this.f_2600.length * 2);
            this.f_2600 = Arrays.copyOf(this.f_2600, var2);
            this.f_2599 = Arrays.copyOf(this.f_2599, var2 * 5);
         }
      }
   }

   private static final class jFlgXQoS7z2JQwl5 {
      private final DrawContext f_588;
      private final RenderPipeline f_589;
      private final TextureSetup f_590;
      private final Matrix3x2f f_591;
      private float[] f_592 = new float[12];
      private int[] f_593 = new int[4];
      private int f_594;

      private jFlgXQoS7z2JQwl5(DrawContext var1, RenderPipeline var2, TextureSetup var3, Matrix3x2fc var4) {
         this.f_588 = var1;
         this.f_589 = var2;
         this.f_590 = var3;
         this.f_591 = new Matrix3x2f(var4);
      }

      private void m_2179(float var1, float var2, int var3) {
         this.m_2070(this.f_594 + 1);
         int var4 = this.f_594 * 3;
         this.f_592[var4] = this.f_591.m00() * var1 + this.f_591.m10() * var2 + this.f_591.m20();
         this.f_592[var4 + 1] = this.f_591.m01() * var1 + this.f_591.m11() * var2 + this.f_591.m21();
         this.f_592[var4 + 2] = 0.0F;
         this.f_593[this.f_594] = var3;
         this.f_594++;
      }

      private void m_3144(
         float var1, float var2, int var3, float var4, float var5, int var6, float var7, float var8, int var9, float var10, float var11, int var12
      ) {
         this.m_2179(var1, var2, var3);
         this.m_2179(var4, var5, var6);
         this.m_2179(var7, var8, var9);
         this.m_2179(var10, var11, var12);
      }

      private void m_3143() {
         if (this.f_594 != 0) {
            float[] var1 = this.f_592.length == this.f_594 * 3 ? this.f_592 : Arrays.copyOf(this.f_592, this.f_594 * 3);
            int[] var2 = this.f_593.length == this.f_594 ? this.f_593 : Arrays.copyOf(this.f_593, this.f_594);
            ScreenRect var3 = this.f_588.scissorStack.peekLast();
            ScreenRect var4 = Util77.m_880(var1, 3, var3);
            if (var4 != null) {
               this.f_588.state.addSimpleElement(new Util77.uWjj8NkvFAA95SdD(this.f_589, this.f_590, var1, var2, var3, var4));
            }
         }
      }

      private void m_2070(int var1) {
         if (var1 > this.f_593.length) {
            int var2 = Math.max(var1, this.f_593.length * 2);
            this.f_593 = Arrays.copyOf(this.f_593, var2);
            this.f_592 = Arrays.copyOf(this.f_592, var2 * 3);
         }
      }
   }

   public static final class spzMrT3b6LRsUJ1m implements AutoCloseable {
      private final DrawContext f_2757;
      @Nullable
      private final DrawContext f_2758;
      private final double f_2759;
      private final float f_2760;
      private boolean f_2761;

      @Override
      public void close() {
         if (!this.f_2761) {
            this.f_2761 = true;
            this.f_2757.getMatrices().popMatrix();
            Util77.f_5813 = this.f_2758;
            Util77.f_5814 = this.f_2759;
            Util77.f_5815 = this.f_2760;
         }
      }

      private spzMrT3b6LRsUJ1m(DrawContext var1, @Nullable DrawContext var2, double var3, float var5) {
         this.f_2757 = var1;
         this.f_2758 = var2;
         this.f_2759 = var3;
         this.f_2760 = var5;
      }
   }

   private record uWjj8NkvFAA95SdD(
      RenderPipeline pipeline, TextureSetup textureSetup, float[] positions, int[] colors, @Nullable ScreenRect scissorArea, ScreenRect bounds
   ) implements SimpleGuiElementRenderState {
      public void setupVertices(VertexConsumer var1) {
         for (int var2 = 0; var2 < this.colors.length; var2++) {
            int var3 = var2 * 3;
            var1.vertex(this.positions[var3], this.positions[var3 + 1], this.positions[var3 + 2]).color(this.colors[var2]);
         }
      }
   }

   @FunctionalInterface
   private interface z8YkIj4DT5WYzcsi {
      int O(float var1, float var2);
   }
}
