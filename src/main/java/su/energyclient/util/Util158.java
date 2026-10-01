package su.energyclient.util;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.awt.Color;
import java.nio.IntBuffer;
import net.minecraft.client.font.TextRenderer.TextLayerType;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.DiffuseLighting.Type;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.Window;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector2d;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.system.MemoryStack;
import su.energyclient.QuickImports;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil24;
import su.energyclient.render.RenderUtil7;

public final class Util158 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final ItemRenderState f_10814 = new ItemRenderState();
   private static Util158.Uq6qxP4XnscWlGVb f_10815;
   private static int f_10816;
   private static final String f_10817 = "size";
   private static final String f_10818 = "radius";
   private static final String f_10819 = "color0";
   private static final float f_10820 = 255.0F;
   private static final float f_10821 = 255.0F;
   private static final float f_10822 = 255.0F;
   private static final String f_10823 = "color1";
   private static final float f_10824 = 255.0F;
   private static final float f_10825 = 255.0F;
   private static final float f_10826 = 255.0F;
   private static final String f_10827 = "color2";
   private static final float f_10828 = 255.0F;
   private static final float f_10829 = 255.0F;
   private static final float f_10830 = 255.0F;
   private static final String f_10831 = "color3";
   private static final float f_10832 = 255.0F;
   private static final float f_10833 = 255.0F;
   private static final float f_10834 = 255.0F;
   private static final String f_10835 = "alpha";
   private static final String f_10836 = "size";
   private static final String f_10837 = "radius";
   private static final String f_10838 = "color";
   private static final float f_10839 = 255.0F;
   private static final float f_10840 = 255.0F;
   private static final float f_10841 = 255.0F;
   private static final String f_10842 = "alpha";
   private static final String f_10843 = "glowRadius";
   private static final String f_10844 = "size";
   private static final String f_10845 = "radius";
   private static final String f_10846 = "color";
   private static final String f_10847 = "size";
   private static final String f_10848 = "radius";
   private static final String f_10849 = "color";
   private static final float f_10850 = 10.0F;
   private static final float f_10851 = 255.0F;
   private static final float f_10852 = 255.0F;
   private static final float f_10853 = 255.0F;
   private static final float f_10854 = 255.0F;
   private static final String f_10855 = "resolution";
   private static final String f_10856 = "resolution";
   private static final String f_10857 = "size";
   private static final String f_10858 = "size";
   private static final String f_10859 = "radius";
   private static final String f_10860 = "radius";
   private static final String f_10861 = "alpha";
   private static final String f_10862 = "alpha";
   private static final String f_10863 = "color";
   private static final String f_10864 = "color";
   private static final float f_10865 = 0.25F;
   private static final String f_10866 = "size";
   private static final String f_10867 = "radius";
   private static final String f_10868 = "hurt_time";
   private static final String f_10869 = "alpha";
   private static final String f_10870 = "texXSize";
   private static final float f_10871 = 64.0F;
   private static final String f_10872 = "texYSize";
   private static final float f_10873 = 64.0F;
   private static final float f_10874 = 255.0F;
   private static final float f_10875 = 255.0F;
   private static final float f_10876 = 255.0F;
   private static final float f_10877 = 255.0F;
   private static final float f_10878 = 255.0F;
   private static final int f_10879 = 16777215;
   private static final float f_10880 = 255.0F;
   private static final float f_10881 = 255.0F;
   private static final float f_10882 = 255.0F;
   private static final float f_10883 = 255.0F;
   private static final int f_10884 = 16777215;
   private static final float f_10885 = 400.0F;
   private static final int f_10886 = 15728880;
   private static final float f_10887 = 13.0F;
   private static final float f_10888 = 13.0F;
   private static final float f_10889 = 255.0F;
   private static final float f_10890 = 255.0F;
   private static final float f_10891 = 13.0F;
   private static final float f_10892 = 15.0F;
   private static final float f_10893 = 15.0F;
   private static final float f_10894 = 13.0F;
   private static final float f_10895 = 14.0F;
   private static final float f_10896 = 255.0F;
   private static final float f_10897 = 255.0F;
   private static final float f_10898 = 255.0F;
   private static final float f_10899 = 255.0F;
   private static final float f_10900 = 8.0F;
   private static final float f_10901 = 8.0F;
   private static final float f_10902 = 150.0F;
   private static final float f_10903 = 16.0F;
   private static final float f_10904 = -16.0F;
   private static final float f_10905 = 16.0F;
   private static final int f_10906 = 15728880;
   private static final double f_10907 = 2.0;
   private static final double f_10908 = 2.0;
   private static final double f_10909 = 2.0;
   private static final float f_10910 = 0.15F;
   private static final double f_10911 = 2.0;
   private static final float f_10912 = 255.0F;
   private static final float f_10913 = 255.0F;
   private static final float f_10914 = 255.0F;
   private static final float f_10915 = 255.0F;
   private static final String f_10916 = "This is a utility class and cannot be instantiated";

   public static void m_1000(MatrixStack var0, Identifier var1, double var2, double var4, double var6, double var8, Color var10) {
      if (!Util77.m_1427(var1, var0, var2, var4, var6, var8, var10, true)) {
         Util114.m_1481();
         Util114.m_542();
         Util114.m_1206(770, 1, 0, 1);
         Util114.m_3784(RenderUtil7.f_13886);
         Util114.m_2037(0, var1);
         TextureManager var11 = f_5909.getTextureManager();
         AbstractTexture var12 = var11.getTexture(var1);
         if (var12 != null) {
            Util114.m_2012(var12);
         }

         float var13 = var10.getRed() / f_10912;
         float var14 = var10.getGreen() / f_10913;
         float var15 = var10.getBlue() / f_10914;
         float var16 = var10.getAlpha() / f_10915;
         BufferBuilder var17 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         Matrix4f var18 = var0.peek().getPositionMatrix();
         var17.vertex(var18, (float)var2, (float)var4 + (float)var8, 0.0F).texture(0.0F, 1.0F).color(var13, var14, var15, var16);
         var17.vertex(var18, (float)var2 + (float)var6, (float)var4 + (float)var8, 0.0F).texture(1.0F, 1.0F).color(var13, var14, var15, var16);
         var17.vertex(var18, (float)var2 + (float)var6, (float)var4, 0.0F).texture(1.0F, 0.0F).color(var13, var14, var15, var16);
         var17.vertex(var18, (float)var2, (float)var4, 0.0F).texture(0.0F, 0.0F).color(var13, var14, var15, var16);
         RenderUtil12.I(var17.end());
         Util114.m_963();
      }
   }

   public static void m_1974(DrawContext var0, ItemStack var1, float var2, float var3, float var4, int var5, float var6) {
      m_3781(var0, var1, var2, var3, var4, var5, var6, true);
   }

   public static void m_1031(float var0, float var1, float var2, float var3, float var4, int var5, float var6) {
      if (!Util77.m_996(var0, var1, var2, var3, var4, var5, var6)) {
         if (Util142.f_12027.m_2282()) {
            Util114.m_1481();
            Util114.m_542();
            Util114.m_3784(Util24.f_3264);
            Util98 var7 = Util114.m_4018();
            if (var7 == null) {
               Util114.m_963();
            } else {
               Util114.m_2037(0, Util142.f_12027.f_12028.getColorAttachment());
               float var8 = (var5 >> 16 & 0xFF) / f_10851;
               float var9 = (var5 >> 8 & 0xFF) / f_10852;
               float var10 = (var5 & 0xFF) / f_10853;
               float var11 = (var5 >> 24 & 0xFF) / f_10854;
               if (var7.m_1335(f_10855) != null) {
                  var7.m_1335(f_10856).m_54(f_5909.getFramebuffer().textureWidth, f_5909.getFramebuffer().textureHeight);
               }

               if (var7.m_1335(f_10857) != null) {
                  var7.m_1335(f_10858).m_54(var2, var3);
               }

               if (var7.m_1335(f_10859) != null) {
                  var7.m_1335(f_10860).O(var4);
               }

               if (var7.m_1335(f_10861) != null) {
                  var7.m_1335(f_10862).O(var6);
               }

               if (var7.m_1335(f_10863) != null) {
                  var7.m_1335(f_10864).m_41(var8, var9, var10, var11);
               }

               RenderUtil24.drawQuads(var0, var1, var2, var3);
               Util114.m_963();
            }
         }
      }
   }

   public static void m_3781(DrawContext var0, ItemStack var1, float var2, float var3, float var4, int var5, float var6, boolean var7) {
      m_4093(var0, var1, var2, var3, var4, var5, var6, var7, null);
   }

   public static void m_1115(float var0, float var1, float var2, int var3) {
      m_1849(var0 - var2 / 2.0F, var1 - var2 / 2.0F, var2, var2, var2 / 2.0F - 1.0F, var3);
   }

   public static void m_125(float var0, float var1, float var2, float var3, Vector4f var4, int var5) {
      if (!Util77.m_2229(var0, var1, var2, var3, var4, var5)) {
         Util114.m_1481();
         Util114.m_542();
         Util98 var6 = Util114.m_3784(Util24.f_3261);
         var6.m_1335(f_10844).m_54(var2, var3);
         var6.m_1335(f_10845).m_41(var4.x, var4.y, var4.z, var4.w);
         var6.m_1335(f_10846).m_39(Util71.m_2326(var5));
         RenderUtil24.drawQuads(var0, var1, var2, var3);
         Util114.m_963();
      }
   }

   public static void m_4093(DrawContext var0, ItemStack var1, float var2, float var3, float var4, int var5, float var6, boolean var7, String var8) {
      if (!var1.isEmpty()) {
         float var9 = Math.max(0.0F, Math.min(1.0F, var6));
         if (!(var9 <= 0.0F)) {
            if (Util77.m_71(var0)) {
               var0.getMatrices().pushMatrix();
               var0.getMatrices().translate(var2, var3);
               var0.getMatrices().scale(var4, var4);

               try {
                  var0.drawItem(var1, 0, 0);
                  if (var7) {
                     var0.drawStackOverlay(f_5909.textRenderer, var1, 0, 0, var8);
                  } else if (var8 != null || var1.getCount() != 1) {
                     String var29 = var8 != null ? var8 : String.valueOf(var1.getCount());
                     if (!var29.isEmpty()) {
                        int var30 = Math.round(var9 * f_10878) << 24 | f_10879;
                        var0.drawText(f_5909.textRenderer, var29, 17 - f_5909.textRenderer.getWidth(var29), 9, var30, true);
                     }
                  }
               } finally {
                  var0.getMatrices().popMatrix();
               }
            } else {
               float var10 = (var5 >> 16 & 0xFF) / f_10880;
               float var11 = (var5 >> 8 & 0xFF) / f_10881;
               float var12 = (var5 & 0xFF) / f_10882;

               try (Util158.PhIPT3TwNL2N87b8 var13 = m_3873()) {
                  MatrixStack var14 = new MatrixStack();
                  var14.push();
                  var14.translate(var2, var3, 0.0F);
                  var14.scale(var4, var4, var4);

                  try {
                     Util114.m_1481();
                     Util114.m_542();
                     m_463(var14, var1, var10, var11, var12, var9);
                     m_3651();
                     if (var8 != null || var1.getCount() != 1) {
                        String var15 = var8 != null ? var8 : String.valueOf(var1.getCount());
                        m_769(var14, var15, var9);
                        m_3651();
                     }

                     if (var7 && var1.isDamaged()) {
                        m_3137(var14.peek().getPositionMatrix(), var1, var9);
                     }
                  } finally {
                     Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
                     var14.pop();
                  }
               }
            }
         }
      }
   }

   private static void m_463(MatrixStack var0, ItemStack var1, float var2, float var3, float var4, float var5) {
      f_10814.clear();
      f_5909.getItemModelManager().clearAndUpdate(f_10814, var1, ItemDisplayContext.GUI, f_5909.world, f_5909.player, 0);
      var0.push();
      var0.translate(f_10900, f_10901, f_10902);
      var0.scale(f_10903, f_10904, f_10905);
      boolean var6 = !f_10814.isSideLit();
      if (var6) {
         f_5909.gameRenderer.getDiffuseLighting().setShaderLights(Type.ITEMS_FLAT);
      } else {
         f_5909.gameRenderer.getDiffuseLighting().setShaderLights(Type.ITEMS_3D);
      }

      try {
         Immediate var7 = f_5909.getBufferBuilders().getEntityVertexConsumers();
         f_10814.render(var0, f_5909.gameRenderer.getEntityRenderCommandQueue(), f_10906, OverlayTexture.DEFAULT_UV, 0);
         f_5909.gameRenderer.getEntityRenderDispatcher().render();
         var7.draw();
      } finally {
         f_5909.gameRenderer.getDiffuseLighting().setShaderLights(Type.ITEMS_3D);
         var0.pop();
      }
   }

   public static void m_335(float var0, float var1, float var2, float var3, float var4, int var5) {
      m_1919(var0, var1, var2, var3, new Vector4f(var4, var4, var4, var4), var5);
   }

   public static void m_3404(float var0, float var1, float var2, float var3, float var4, int var5, int var6, int var7, int var8, float var9) {
      m_1084(var0, var1, var2, var3, new Vector4f(var4, var4, var4, var4), var5, var6, var7, var8, var9);
   }

   public static void m_3939(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      m_1919(var0, var1, var2, var3, new Vector4f(var4, var7, var5, var6), var8);
   }

   private static void m_3137(Matrix4f var0, ItemStack var1, float var2) {
      int var3 = var1.getMaxDamage();
      if (var3 > 0) {
         int var4 = var1.getDamage();
         int var5 = Math.round(f_10887 - var4 * f_10888 / var3);
         int var6 = Math.round((1.0F - (float)var4 / var3) * f_10889);
         int var7 = Math.round(var2 * f_10890);
         int var8 = var7 << 24 | 255 - var6 << 16 | var6 << 8;
         int var9 = var7 << 24;
         Util114.m_1481();
         Util114.m_542();
         Util114.m_3784(RenderUtil7.f_13885);
         BufferBuilder var10 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         m_614(var10, var0, 2.0F, f_10891, f_10892, f_10893, var9);
         if (var5 > 0) {
            m_614(var10, var0, 2.0F, f_10894, 2.0F + var5, f_10895, var8);
         }

         RenderUtil12.I(var10.end());
      }
   }

   public static Util158.PhIPT3TwNL2N87b8 m_3873() {
      Util114.m_811();
      if (Util77.m_3042() != null) {
         return new Util158.PhIPT3TwNL2N87b8(false);
      } else {
         if (f_10816 == 0) {
            f_10815 = Util158.Uq6qxP4XnscWlGVb.m_2905();
         }

         f_10816++;
         return new Util158.PhIPT3TwNL2N87b8(true);
      }
   }

   public static void m_1919(float var0, float var1, float var2, float var3, Vector4f var4, int var5) {
      if (!Util77.m_1143(var0, var1, var2, var3, var4, var5)) {
         Util114.m_1481();
         Util114.m_542();
         Util98 var6 = Util114.m_3784(Util24.f_3262);
         var6.m_1335(f_10847).m_54(var2, var3);
         var6.m_1335(f_10848).m_41(var4.x, var4.y, var4.z, var4.w);
         var6.m_1335(f_10849).m_39(Util71.m_2326(var5));
         RenderUtil24.drawQuads(var0, var1, var2, var3);
         Util114.m_963();
      }
   }

   public static void m_1849(float var0, float var1, float var2, float var3, float var4, int var5) {
      m_125(var0, var1, var2, var3, new Vector4f(var4, var4, var4, var4), var5);
   }

   public static void m_3998(float var0, float var1, float var2, float var3, float var4, int var5, float var6) {
      float var7 = f_10850;
      m_162(var0 - var7, var1 - var7, var2 + var7 * 2.0F, var3 + var7 * 2.0F, var4, var5, var6, var7);
      m_1031(var0, var1, var2, var3, var4, var5, var6);
   }

   public static void m_1084(float var0, float var1, float var2, float var3, Vector4f var4, int var5, int var6, int var7, int var8, float var9) {
      if (!Util77.m_3837(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9)) {
         Util114.m_1481();
         Util114.m_542();
         Util98 var10 = Util114.m_3784(Util24.f_3265);
         var10.m_1335(f_10817).m_54(var2, var3);
         var10.m_1335(f_10818).m_41(var4.x, var4.y, var4.z, var4.w);
         var10.m_1335(f_10819).m_33((var5 >> 16 & 0xFF) / f_10820, (var5 >> 8 & 0xFF) / f_10821, (var5 & 0xFF) / f_10822);
         var10.m_1335(f_10823).m_33((var6 >> 16 & 0xFF) / f_10824, (var6 >> 8 & 0xFF) / f_10825, (var6 & 0xFF) / f_10826);
         var10.m_1335(f_10827).m_33((var7 >> 16 & 0xFF) / f_10828, (var7 >> 8 & 0xFF) / f_10829, (var7 & 0xFF) / f_10830);
         var10.m_1335(f_10831).m_33((var8 >> 16 & 0xFF) / f_10832, (var8 >> 8 & 0xFF) / f_10833, (var8 & 0xFF) / f_10834);
         var10.m_1335(f_10835).O(var9);
         RenderUtil24.drawQuads(var0, var1, var2, var3);
         Util114.m_963();
      }
   }

   public static void m_666(float var0, float var1, float var2, float var3, Vector4f var4, int var5, float var6, float var7) {
      if (!Util77.m_1065(var0, var1, var2, var3, var4, var5, var6, var7)) {
         Util114.m_1481();
         Util114.m_542();
         Util98 var8 = Util114.m_3784(Util24.f_3267);
         var8.m_1335(f_10836).m_54(var2, var3);
         var8.m_1335(f_10837).m_41(var4.x, var4.y, var4.z, var4.w);
         var8.m_1335(f_10838).m_33((var5 >> 16 & 0xFF) / f_10839, (var5 >> 8 & 0xFF) / f_10840, (var5 & 0xFF) / f_10841);
         var8.m_1335(f_10842).O(var6);
         var8.m_1335(f_10843).O(var7);
         RenderUtil24.drawQuads(var0, var1, var2, var3);
         Util114.m_963();
      }
   }

   public static <T extends Number> T m_954(T var0, T var1, double var2) {
      double var4 = var0.doubleValue();
      double var6 = var1.doubleValue();
      double var8 = var4 + var2 * (var6 - var4);
      if (var0 instanceof Integer) {
         return (T)Integer.valueOf((int)Math.round(var8));
      } else if (var0 instanceof Double) {
         return (T)Double.valueOf(var8);
      } else if (var0 instanceof Float) {
         return (T)Float.valueOf((float)var8);
      } else if (var0 instanceof Long) {
         return (T)Long.valueOf(Math.round(var8));
      } else if (var0 instanceof Short) {
         return (T)Short.valueOf((short)Math.round(var8));
      } else if (var0 instanceof Byte) {
         return (T)Byte.valueOf((byte)Math.round(var8));
      } else {
         throw new IllegalArgumentException("Unsupported type: " + var0.getClass().getSimpleName());
      }
   }

   public static Vector2d m_1969(double var0, double var2, double var4) {
      Camera var6 = f_5909.gameRenderer.getCamera();
      if (var6 == null) {
         return null;
      } else {
         Vec3d var7 = var6.getCameraPos();
         Vector3f var8 = new Vector3f((float)(var0 - var7.x), (float)(var2 - var7.y), (float)(var4 - var7.z));
         Quaternionf var9 = new Quaternionf(var6.getRotation());
         var9.conjugate();
         var9.transform(var8);
         if (var8.z > 0.0F) {
            return null;
         } else {
            Window var10 = f_5909.getWindow();
            double var11 = Math.toRadians(m_2754());
            float var13 = (float)var10.getScaledWidth() / var10.getScaledHeight();
            float var14 = (float)Math.tan(var11 / f_10911);
            float var15 = var14 * var13;
            float var16 = (var8.x / -var8.z / var15 + 1.0F) / 2.0F * var10.getScaledWidth();
            float var17 = (1.0F - var8.y / -var8.z / var14) / 2.0F * var10.getScaledHeight();
            return new Vector2d(var16, var17);
         }
      }
   }

   public static Vector2d m_1364(double var0, double var2, double var4) {
      Camera var6 = f_5909.gameRenderer.getCamera();
      if (var6 == null) {
         return null;
      } else {
         Vec3d var7 = var6.getCameraPos();
         Quaternionf var8 = new Quaternionf(var6.getRotation());
         var8.conjugate();
         Vector3f var9 = new Vector3f((float)(var7.x - var0), (float)(var7.y - var2), (float)(var7.z - var4));
         var8.transform(var9);
         double var10 = ((Integer)f_5909.options.getFov().getValue()).intValue();
         Window var12 = f_5909.getWindow();
         float var13 = var12.getScaledHeight() / 2.0F;
         float var14 = var13 / (var9.z * (float)Math.tan(Math.toRadians(var10 / f_10907)));
         return var9.z < 0.0F ? new Vector2d(-var9.x * var14 + var12.getScaledWidth() / f_10908, var12.getScaledHeight() / f_10909 - var9.y * var14) : null;
      }
   }

   public static void m_4005(Identifier var0, LivingEntity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (!Util77.m_1916(var0, var1, var2, var3, var4, var5, var6, var7)) {
         float var8 = var1 != null ? var1.hurtTime : 0.0F;
         var8 = var8 > 0.0F ? Math.min(f_10865, var8 / var1.maxHurtTime) : 0.0F;
         Util114.m_1481();
         Util114.m_542();
         Util98 var9 = Util114.m_3784(Util24.f_3269);
         Util114.m_2037(0, var0);
         var9.m_1335(f_10866).m_54(var4, var5);
         var9.m_1335(f_10867).O(var6);
         var9.m_1335(f_10868).O(var8);
         var9.m_1335(f_10869).O(var7);
         var9.m_1335(f_10870).O(f_10871);
         var9.m_1335(f_10872).O(f_10873);
         BufferBuilder var10 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         var10.vertex(var2, var3, 0.0F).texture(0.0F, 0.0F).color(255, 255, 255, (int)(var7 * f_10874));
         var10.vertex(var2, var3 + var5, 0.0F).texture(0.0F, 1.0F).color(255, 255, 255, (int)(var7 * f_10875));
         var10.vertex(var2 + var4, var3 + var5, 0.0F).texture(1.0F, 1.0F).color(255, 255, 255, (int)(var7 * f_10876));
         var10.vertex(var2 + var4, var3, 0.0F).texture(1.0F, 0.0F).color(255, 255, 255, (int)(var7 * f_10877));
         RenderUtil12.I(var10.end());
         Util114.m_963();
      }
   }

   private static void m_769(MatrixStack var0, String var1, float var2) {
      int var3 = 17 - f_5909.textRenderer.getWidth(var1);
      byte var4 = 9;
      int var5 = Math.round(var2 * f_10883) << 24 | f_10884;
      var0.push();
      var0.translate(0.0F, 0.0F, f_10885);

      try {
         Immediate var6 = f_5909.getBufferBuilders().getEntityVertexConsumers();
         f_5909.textRenderer.draw(var1, var3, var4, var5, true, var0.peek().getPositionMatrix(), var6, TextLayerType.NORMAL, 0, f_10886);
         var6.draw();
      } finally {
         var0.pop();
      }
   }

   public static void m_162(float var0, float var1, float var2, float var3, float var4, int var5, float var6, float var7) {
      m_666(var0, var1, var2, var3, new Vector4f(var4, var4, var4, var4), var5, var6, var7);
   }

   private static double m_2754() {
      double var0 = ((Integer)f_5909.options.getFov().getValue()).intValue();
      float var2 = 1.0F;
      if (f_5909.getCameraEntity() instanceof PlayerEntity var3 && var3.isSprinting()) {
         var2 += f_10910;
      }

      float var6 = ((Double)f_5909.options.getFovEffectScale().getValue()).floatValue();
      var2 = 1.0F + (var2 - 1.0F) * var6;
      return var0 * var2;
   }

   private static void m_614(BufferBuilder var0, Matrix4f var1, float var2, float var3, float var4, float var5, int var6) {
      float var7 = (var6 >>> 16 & 0xFF) / f_10896;
      float var8 = (var6 >>> 8 & 0xFF) / f_10897;
      float var9 = (var6 & 0xFF) / f_10898;
      float var10 = (var6 >>> 24 & 0xFF) / f_10899;
      var0.vertex(var1, var2, var3, 0.0F).color(var7, var8, var9, var10);
      var0.vertex(var1, var2, var5, 0.0F).color(var7, var8, var9, var10);
      var0.vertex(var1, var4, var5, 0.0F).color(var7, var8, var9, var10);
      var0.vertex(var1, var4, var3, 0.0F).color(var7, var8, var9, var10);
   }

   private Util158() {
      throw new UnsupportedOperationException(f_10916);
   }

   public static void m_3024(Matrix3x2fc var0, Identifier var1, double var2, double var4, double var6, double var8, Color var10) {
      if (!Util77.m_4130(var1, var0, var2, var4, var6, var8, var10, true)) {
         m_1000(Util7.m_2022(var0), var1, var2, var4, var6, var8, var10);
      }
   }

   public static Vector3d m_508(Entity var0, float var1) {
      double var2 = m_954(var0.lastRenderX, var0.getX(), var1);
      double var4 = m_954(var0.lastRenderY, var0.getY(), var1);
      double var6 = m_954(var0.lastRenderZ, var0.getZ(), var1);
      return new Vector3d(var2, var4, var6);
   }

   private static int m_1443(int var0, float var1) {
      return Math.max(0, Math.min(255, Math.round(var0 * var1)));
   }

   private static void m_3651() {
      Util114.m_672();
      Util114.m_1878(false);
      Util114.m_3978();
      Util114.m_1481();
      Util114.m_542();
   }

   private static final class IQrZktSR4lN1Hmov implements VertexConsumer {
      private final VertexConsumer f_6893;
      private final float f_6894;
      private final float f_6895;
      private final float f_6896;
      private final float f_6897;

      private IQrZktSR4lN1Hmov(VertexConsumer var1, float var2, float var3, float var4, float var5) {
         this.f_6893 = var1;
         this.f_6894 = var2;
         this.f_6895 = var3;
         this.f_6896 = var4;
         this.f_6897 = var5;
      }

      public VertexConsumer lineWidth(float var1) {
         this.f_6893.lineWidth(var1);
         return this;
      }

      public VertexConsumer light(int var1, int var2) {
         this.f_6893.light(var1, var2);
         return this;
      }

      public VertexConsumer overlay(int var1, int var2) {
         this.f_6893.overlay(var1, var2);
         return this;
      }

      public VertexConsumer vertex(float var1, float var2, float var3) {
         this.f_6893.vertex(var1, var2, var3);
         return this;
      }

      public VertexConsumer texture(float var1, float var2) {
         this.f_6893.texture(var1, var2);
         return this;
      }

      public VertexConsumer color(int var1, int var2, int var3, int var4) {
         this.f_6893
            .color(Util158.m_1443(var1, this.f_6894), Util158.m_1443(var2, this.f_6895), Util158.m_1443(var3, this.f_6896), Util158.m_1443(var4, this.f_6897));
         return this;
      }

      public VertexConsumer normal(float var1, float var2, float var3) {
         this.f_6893.normal(var1, var2, var3);
         return this;
      }

      public VertexConsumer color(int var1) {
         int var2 = var1 >>> 24 & 0xFF;
         int var3 = var1 >>> 16 & 0xFF;
         int var4 = var1 >>> 8 & 0xFF;
         int var5 = var1 & 0xFF;
         return this.color(var3, var4, var5, var2);
      }
   }

   public static final class PhIPT3TwNL2N87b8 implements AutoCloseable {
      private final boolean f_584;
      private boolean f_585;

      @Override
      public void close() {
         if (!this.f_585) {
            this.f_585 = true;
            if (this.f_584) {
               if (Util158.f_10816 <= 0) {
                  Util158.f_10816 = 0;
                  Util158.f_10815 = null;
               } else {
                  Util158.f_10816--;
                  if (Util158.f_10816 == 0) {
                     Util158.Uq6qxP4XnscWlGVb var1 = Util158.f_10815;
                     Util158.f_10815 = null;
                     if (var1 != null) {
                        var1.m_2991();
                     }
                  }
               }
            }
         }
      }

      private PhIPT3TwNL2N87b8(boolean var1) {
         this.f_584 = var1;
      }
   }

   private static final class Uq6qxP4XnscWlGVb {
      private final boolean f_671;
      private final boolean f_672;
      private final boolean f_673;
      private final boolean f_674;
      private final boolean f_675;
      private final int f_676;
      private final int f_677;
      private final int f_678;
      private final int f_679;
      private final int f_680;
      private final int[] f_681;
      private static final int f_682 = 32969;
      private static final int f_683 = 32968;
      private static final int f_684 = 32971;
      private static final int f_685 = 32970;

      private void m_2991() {
         Util114.m_3188(this.f_676);
         GL11.glDepthFunc(this.f_676);
         Util114.m_1878(this.f_675);
         GL11.glDepthMask(this.f_675);
         if (this.f_672) {
            Util114.m_100();
            GL11.glEnable(2929);
         } else {
            Util114.m_672();
            GL11.glDisable(2929);
         }

         if (this.f_673) {
            Util114.m_1562();
            GL11.glEnable(2884);
         } else {
            Util114.m_3978();
            GL11.glDisable(2884);
         }

         Util114.m_1206(this.f_677, this.f_678, this.f_679, this.f_680);
         GL14.glBlendFuncSeparate(this.f_677, this.f_678, this.f_679, this.f_680);
         if (this.f_671) {
            Util114.m_1481();
            GL11.glEnable(3042);
         } else {
            Util114.m_963();
            GL11.glDisable(3042);
         }

         if (this.f_674 && this.f_681 != null) {
            Util114.m_2740(this.f_681[0], this.f_681[1], this.f_681[2], this.f_681[3]);
            GL11.glEnable(3089);
            GL11.glScissor(this.f_681[0], this.f_681[1], this.f_681[2], this.f_681[3]);
         } else {
            Util114.m_3706();
            GL11.glDisable(3089);
         }
      }

      private Uq6qxP4XnscWlGVb(
         boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6, int var7, int var8, int var9, int var10, int[] var11
      ) {
         this.f_671 = var1;
         this.f_672 = var2;
         this.f_673 = var3;
         this.f_674 = var4;
         this.f_675 = var5;
         this.f_676 = var6;
         this.f_677 = var7;
         this.f_678 = var8;
         this.f_679 = var9;
         this.f_680 = var10;
         this.f_681 = var11;
      }

      private static Util158.Uq6qxP4XnscWlGVb m_2905() {
         boolean var0 = GL11.glIsEnabled(3089);
         int[] var1 = null;
         if (var0) {
            MemoryStack var2 = MemoryStack.stackPush();

            try {
               IntBuffer var3 = var2.mallocInt(4);
               GL11.glGetIntegerv(3088, var3);
               var1 = new int[]{var3.get(0), var3.get(1), var3.get(2), var3.get(3)};
            } catch (Throwable var6) {
               if (var2 != null) {
                  try {
                     var2.close();
                  } catch (Throwable var5) {
                     var6.addSuppressed(var5);
                  }
               }

               throw var6;
            }

            if (var2 != null) {
               var2.close();
            }
         }

         return new Util158.Uq6qxP4XnscWlGVb(
            GL11.glIsEnabled(3042),
            GL11.glIsEnabled(2929),
            GL11.glIsEnabled(2884),
            var0,
            GL11.glGetBoolean(2930),
            GL11.glGetInteger(2932),
            GL11.glGetInteger(f_682),
            GL11.glGetInteger(f_683),
            GL11.glGetInteger(f_684),
            GL11.glGetInteger(f_685),
            var1
         );
      }
   }
}
