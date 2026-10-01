package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.math.Vec2f;
import org.joml.Matrix4f;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;
import su.energyclient.util.Util45;
import su.energyclient.util.Util7;

public class RenderUtil24 extends Framebuffer implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private boolean f_1307;
   private final float f_1308;
   private static final float f_1309 = 0.125F;

   public RenderUtil24(int var1, int var2, boolean var3) {
      super(null, var3);
      this.f_1308 = 1.0F;
      this.resize(var1, var2);
   }

   public void setup() {
      this.setup(true);
   }

   public void setup(boolean var1) {
      resizeFramebuffer(this);
      RenderUtil6.m_4071(this, true);
      if (var1) {
         RenderUtil6.m_210(this);
      }
   }

   public static RenderUtil24 createFramebuffer(RenderUtil24 var0) {
      return createFramebuffer(var0, false);
   }

   public static void drawQuads() {
      Vec2f var0 = Util45.m_3227(f_5909.getWindow().getScaledWidth(), f_5909.getWindow().getScaledHeight());
      double var1 = var0.x;
      double var3 = var0.y;
      drawQuads(0.0, 0.0, var1, var3);
   }

   public static void drawQuads(DrawContext var0) {
      Vec2f var1 = Util45.m_3227(f_5909.getWindow().getScaledWidth(), f_5909.getWindow().getScaledHeight());
      double var2 = var1.x;
      double var4 = var1.y;
      drawQuads(var0, 0.0, 0.0, var2, var4);
   }

   public void draw(int var1) {
      RenderUtil6.m_3625(this);
      drawQuads(var1);
   }

   public void draw(Framebuffer var1) {
      RenderUtil6.m_3625(var1);
      drawQuads();
   }

   public void draw() {
      RenderUtil6.m_3625(this);
      drawQuads();
   }

   public void setTexFilter(int var1) {
      RenderUtil6.m_4015(this, this.f_1307 ? 9729 : var1);
   }

   private int targetHeight() {
      return Math.max(1, Math.round(f_5909.getWindow().getFramebufferHeight() * this.f_1308));
   }

   public static void drawQuads(double var0, double var2, double var4, double var6, int var8) {
      Util114.m_3784(RenderUtil7.f_13885);
      BufferBuilder var9 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      var9.vertex((float)var0, (float)var2, 0.0F).color(var8);
      var9.vertex((float)var0, (float)(var2 + var6), 0.0F).color(var8);
      var9.vertex((float)(var0 + var4), (float)(var2 + var6), 0.0F).color(var8);
      var9.vertex((float)(var0 + var4), (float)var2, 0.0F).color(var8);
      RenderUtil12.I(var9.end());
   }

   public RenderUtil24 setLinear() {
      this.f_1307 = true;
      if (this.getColorAttachment() != null) {
         RenderUtil6.m_4015(this, 9729);
      }

      return this;
   }

   public static void drawQuads(DrawContext var0, double var1, double var3) {
      drawQuads(var0, 0.0, 0.0, var1, var3);
   }

   private static void resizeFramebuffer(RenderUtil24 var0) {
      if (var0 != null && f_5909 != null && f_5909.getWindow() != null) {
         int var1 = var0.targetWidth();
         int var2 = var0.targetHeight();
         if (var0.textureWidth != var1 || var0.textureHeight != var2) {
            var0.resize(var1, var2);
            if (var0.f_1307) {
               RenderUtil6.m_4015(var0, 9729);
            }
         }
      }
   }

   public RenderUtil24(boolean var1, float var2) {
      super(null, var1);
      this.f_1308 = Math.max(f_1309, Math.min(1.0F, var2));
      this.resize(1, 1);
   }

   public static void drawQuads(DrawContext var0, double var1, double var3, double var5, double var7, int var9) {
      Matrix4f var10 = Util7.m_1924(var0.getMatrices());
      BufferBuilder var11 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      var11.vertex(var10, (float)var1, (float)var3, 0.0F).texture(0.0F, 0.0F).color(var9);
      var11.vertex(var10, (float)var1, (float)(var3 + var7), 0.0F).texture(0.0F, 1.0F).color(var9);
      var11.vertex(var10, (float)(var1 + var5), (float)(var3 + var7), 0.0F).texture(1.0F, 1.0F).color(var9);
      var11.vertex(var10, (float)(var1 + var5), (float)var3, 0.0F).texture(1.0F, 0.0F).color(var9);
      RenderUtil12.I(var11.end());
   }

   public static RenderUtil24 createFramebuffer(RenderUtil24 var0, boolean var1) {
      if (needsNewFramebuffer(var0)) {
         if (var0 != null) {
            var0.delete();
         }

         int var2 = f_5909 != null && f_5909.getWindow() != null ? f_5909.getWindow().getFramebufferWidth() : 1;
         int var3 = f_5909 != null && f_5909.getWindow() != null ? f_5909.getWindow().getFramebufferHeight() : 1;
         return new RenderUtil24(var2, var3, var1);
      } else {
         return var0;
      }
   }

   public static void drawQuads(double var0, double var2) {
      drawQuads(0.0, 0.0, var0, var2);
   }

   public void stop() {
      RenderUtil6.m_2129(this);
      RenderUtil6.m_4071(f_5909.getFramebuffer(), true);
   }

   public static void drawQuads(DrawContext var0, int var1) {
      Vec2f var2 = Util45.m_3227(f_5909.getWindow().getScaledWidth(), f_5909.getWindow().getScaledHeight());
      double var3 = var2.x;
      double var5 = var2.y;
      drawQuads(var0, 0.0, 0.0, var3, var5, var1);
   }

   public static void drawQuads(double var0, double var2, int var4) {
      drawQuads(0.0, 0.0, var0, var2, var4);
   }

   public RenderUtil24(boolean var1) {
      this(var1, 1.0F);
   }

   public static void drawQuads(int var0) {
      Vec2f var1 = Util45.m_3227(f_5909.getWindow().getScaledWidth(), f_5909.getWindow().getScaledHeight());
      double var2 = var1.x;
      double var4 = var1.y;
      drawQuads(0.0, 0.0, var2, var4, var0);
   }

   public static void drawQuads(DrawContext var0, double var1, double var3, double var5, double var7) {
      Matrix4f var9 = Util7.m_1924(var0.getMatrices());
      BufferBuilder var10 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
      var10.vertex(var9, (float)var1, (float)var3, 0.0F).texture(0.0F, 0.0F);
      var10.vertex(var9, (float)var1, (float)(var3 + var7), 0.0F).texture(0.0F, 1.0F);
      var10.vertex(var9, (float)(var1 + var5), (float)(var3 + var7), 0.0F).texture(1.0F, 1.0F);
      var10.vertex(var9, (float)(var1 + var5), (float)var3, 0.0F).texture(1.0F, 0.0F);
      RenderUtil12.I(var10.end());
   }

   public static void drawQuads(double var0, double var2, double var4, double var6) {
      BufferBuilder var8 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
      var8.vertex((float)var0, (float)var2, 0.0F).texture(0.0F, 0.0F);
      var8.vertex((float)var0, (float)(var2 + var6), 0.0F).texture(0.0F, 1.0F);
      var8.vertex((float)(var0 + var4), (float)(var2 + var6), 0.0F).texture(1.0F, 1.0F);
      var8.vertex((float)(var0 + var4), (float)var2, 0.0F).texture(1.0F, 0.0F);
      RenderUtil12.I(var8.end());
   }

   public static boolean needsNewFramebuffer(RenderUtil24 var0) {
      if (f_5909 != null && f_5909.getWindow() != null) {
         int var1 = var0 == null ? Math.max(f_5909.getWindow().getFramebufferWidth(), 1) : var0.targetWidth();
         int var2 = var0 == null ? Math.max(f_5909.getWindow().getFramebufferHeight(), 1) : var0.targetHeight();
         return var0 == null || var0.textureWidth != var1 || var0.textureHeight != var2;
      } else {
         return var0 == null;
      }
   }

   private int targetWidth() {
      return Math.max(1, Math.round(f_5909.getWindow().getFramebufferWidth() * this.f_1308));
   }

   public static void drawQuads(DrawContext var0, double var1, double var3, int var5) {
      drawQuads(var0, 0.0, 0.0, var1, var3, var5);
   }
}
