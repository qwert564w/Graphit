package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;
import su.energyclient.util.Util70;

public class RenderUtil23 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static Util70 f_1189;
   private static RenderUtil1 f_1190;
   private static RenderUtil10 f_1191;
   private static RenderUtil20 f_1192;
   private static RenderUtil4 f_1193;
   private static SimpleFramebuffer f_1194;
   private static SimpleFramebuffer l;
   private static SimpleFramebuffer f_1195;
   private static SimpleFramebuffer f_1196;
   private static SimpleFramebuffer f_1197;
   private static SimpleFramebuffer f_1198;
   private static boolean f_1199 = false;
   private static final String f_1200 = "Failed to initialize runtime shaders.";
   private static final float f_1201 = -1.0F;
   private static final float f_1202 = -1.0F;
   private static final float f_1203 = -1.0F;
   private static final float f_1204 = -1.0F;
   private static final String f_1205 = "Tex0";
   private static final String f_1206 = "Alpha";

   public static void m_695() {
      int var0 = Math.max(f_5909.getWindow().getFramebufferWidth(), 1);
      int var1 = Math.max(f_5909.getWindow().getFramebufferHeight(), 1);
      if (f_1194 == null || f_1194.textureWidth != var0 || f_1194.textureHeight != var1) {
         m_166();
         f_1194 = new SimpleFramebuffer(null, var0, var1, true);
         l = new SimpleFramebuffer(null, var0, var1, true);
         f_1195 = new SimpleFramebuffer(null, var0, var1, true);
         f_1196 = new SimpleFramebuffer(null, var0, var1, true);
         f_1197 = new SimpleFramebuffer(null, var0, var1, true);
         f_1198 = new SimpleFramebuffer(null, var0, var1, true);
      }
   }

   public static boolean m_1445() {
      return f_1199;
   }

   public static RenderUtil10 m_3189() {
      return f_1191;
   }

   public static SimpleFramebuffer m_3416() {
      return f_1194;
   }

   public static void m_1477() {
      Util114.m_811();
      BufferBuilder var0 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION);
      var0.vertex(f_1201, f_1202, 0.0F);
      var0.vertex(1.0F, f_1203, 0.0F);
      var0.vertex(1.0F, 1.0F, 0.0F);
      var0.vertex(f_1204, 1.0F, 0.0F);
      RenderUtil12.m_1546(var0.end());
   }

   public static SimpleFramebuffer m_1062() {
      return f_1195;
   }

   public static Util70 m_776() {
      return f_1189;
   }

   public static void m_180(Framebuffer var0, SimpleFramebuffer var1) {
      if (f_1199 && var0 != null && var1 != null) {
         RenderUtil6.m_4071(var1, true);
         f_1191.m_2989();
         f_1191.m_3372(f_1205, 0);
         f_1191.m_3397(f_1206, true);
         Util114.m_2012(RenderUtil6.m_668(var0.getColorAttachment()));
         m_1477();
         f_1191.m_233();
         var1.copyDepthFrom(var0);
      }
   }

   public static SimpleFramebuffer m_2522() {
      return f_1198;
   }

   private static void m_166() {
      if (f_1194 != null) {
         f_1194.delete();
         f_1194 = null;
      }

      if (l != null) {
         l.delete();
         l = null;
      }

      if (f_1195 != null) {
         f_1195.delete();
         f_1195 = null;
      }

      if (f_1196 != null) {
         f_1196.delete();
         f_1196 = null;
      }

      if (f_1197 != null) {
         f_1197.delete();
         f_1197 = null;
      }

      if (f_1198 != null) {
         f_1198.delete();
         f_1198 = null;
      }
   }

   public static SimpleFramebuffer m_2806() {
      return l;
   }

   public static RenderUtil4 m_1879() {
      return f_1193;
   }

   public static RenderUtil1 m_1906() {
      return f_1190;
   }

   public static void m_2825() {
      if (!f_1199) {
         try {
            f_1189 = new Util70();
            f_1190 = new RenderUtil1();
            f_1191 = new RenderUtil10();
            f_1192 = new RenderUtil20();
            f_1193 = new RenderUtil4();
            f_1199 = true;
         } catch (Exception var1) {
            System.err.println(f_1200);
            var1.printStackTrace();
         }
      }
   }

   public static RenderUtil20 m_3755() {
      return f_1192;
   }

   public static SimpleFramebuffer m_2271() {
      return f_1197;
   }

   public static SimpleFramebuffer m_4082() {
      return f_1196;
   }
}
