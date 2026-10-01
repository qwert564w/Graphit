package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;
import su.energyclient.util.Util71;

public final class RenderUtil14 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final ObjectArrayList<RenderUtil14.uN6wUb3e0j7J5fg9> f_1780 = new ObjectArrayList();
   private static final String f_1781 = "This is a utility class and cannot be instantiated";

   public static float m_1190(float var0, float var1) {
      return (float)m_2473(var0, var1);
   }

   private RenderUtil14() {
      throw new UnsupportedOperationException(f_1781);
   }

   public static void m_1354(MatrixStack var0, ObjectArrayList<RenderUtil14.uN6wUb3e0j7J5fg9> var1, DrawMode var2, boolean var3, boolean var4) {
      if (!var1.isEmpty()) {
         m_187(var3, var4);
         Matrix4f var5 = var0.peek().getPositionMatrix();
         Tessellator var6 = Tessellator.getInstance();
         BufferBuilder var7 = var6.begin(var2, var3 ? VertexFormats.POSITION_TEXTURE_COLOR : VertexFormats.POSITION_COLOR);
         int var8 = 0;

         for (ObjectListIterator var9 = var1.iterator(); var9.hasNext(); var8++) {
            RenderUtil14.uN6wUb3e0j7J5fg9 var10 = (RenderUtil14.uN6wUb3e0j7J5fg9)var9.next();
            float[] var11 = Util71.m_2326(var10.m_2157());
            if (var3) {
               float var12 = var8 != 0 && var8 != 3 ? 1.0F : 0.0F;
               float var13 = var8 != 0 && var8 != 1 ? 1.0F : 0.0F;
               var7.vertex(var5, var10.m_3911(), var10.m_2843(), 0.0F).texture(var12, var13).color(var11[0], var11[1], var11[2], var11[3]);
            } else {
               var7.vertex(var5, var10.m_3911(), var10.m_2843(), 0.0F).color(var11[0], var11[1], var11[2], var11[3]);
            }
         }

         RenderUtil12.I(var7.end());
         m_2333(var4);
      }
   }

   public static void m_187(boolean var0, boolean var1) {
      Util114.m_1481();
      Util114.m_3978();
      Util114.m_672();
      if (var1) {
         Util114.m_582(770, 1);
      } else {
         Util114.m_542();
      }

      if (var0) {
         Util114.m_3784(RenderUtil7.f_13886);
      } else {
         Util114.m_3784(RenderUtil7.f_13885);
      }
   }

   public static void m_2352(
      MatrixStack var0, float var1, float var2, float var3, float var4, int var5, int var6, int var7, int var8, boolean var9, boolean var10
   ) {
      f_1780.clear();
      f_1780.add(new RenderUtil14.uN6wUb3e0j7J5fg9(var1, var2, var5));
      f_1780.add(new RenderUtil14.uN6wUb3e0j7J5fg9(var3, var2, var6));
      f_1780.add(new RenderUtil14.uN6wUb3e0j7J5fg9(var3, var4, var7));
      f_1780.add(new RenderUtil14.uN6wUb3e0j7J5fg9(var1, var4, var8));
      m_1354(var0, f_1780, DrawMode.QUADS, var10, var9);
   }

   public static void m_2333(boolean var0) {
      if (var0) {
         Util114.m_542();
      }

      Util114.m_100();
      Util114.m_1562();
      Util114.m_963();
   }

   public static int m_2286(int var0, int var1, int var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   public static double m_1985(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   public static void m_1681(Identifier var0) {
      Util114.m_2037(0, var0);
   }

   public static void m_646(MatrixStack var0, float var1, float var2, float var3, float var4, int var5, boolean var6) {
      m_2352(var0, var1, var2, var3, var4, var5, var5, var5, var5, var6, false);
   }

   public static void m_1034(MatrixStack var0, ObjectArrayList<RenderUtil14.uN6wUb3e0j7J5fg9> var1, float var2, boolean var3) {
      if (!var1.isEmpty()) {
         Util114.m_2977(var2);
         m_1354(var0, var1, DrawMode.DEBUG_LINES, false, var3);
         Util114.m_2977(1.0F);
      }
   }

   public static double m_2867(double var0, double var2, double var4) {
      return Math.max(var2, Math.min(var4, var0));
   }

   public static float m_4030(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   public static double m_2473(double var0, double var2) {
      if (var0 == var2) {
         return var0;
      } else {
         if (var0 > var2) {
            double var4 = var0;
            var0 = var2;
            var2 = var4;
         }

         return ThreadLocalRandom.current().nextDouble() * (var2 - var0) + var0;
      }
   }

   public static int m_2284(int var0, int var1) {
      if (var0 == var1) {
         return var0;
      } else {
         if (var0 > var1) {
            int var2 = var0;
            var0 = var1;
            var1 = var2;
         }

         return ThreadLocalRandom.current().nextInt(var1 - var0 + 1) + var0;
      }
   }

   public static void m_1175(MatrixStack var0, ObjectArrayList<RenderUtil14.uN6wUb3e0j7J5fg9> var1, boolean var2) {
      m_1354(var0, var1, DrawMode.TRIANGLES, false, var2);
   }

   public static float m_2421(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   public static class uN6wUb3e0j7J5fg9 {
      private final float f_3127;
      private final float f_3128;
      private final int f_3129;

      public RenderUtil14.uN6wUb3e0j7J5fg9 m_1609(float var1, float var2) {
         return new RenderUtil14.uN6wUb3e0j7J5fg9(this.f_3127 + var1, this.f_3128 + var2, this.f_3129);
      }

      public uN6wUb3e0j7J5fg9(float var1, float var2, int var3) {
         this.f_3127 = var1;
         this.f_3128 = var2;
         this.f_3129 = var3;
      }

      public RenderUtil14.uN6wUb3e0j7J5fg9 m_83(int var1) {
         return new RenderUtil14.uN6wUb3e0j7J5fg9(this.f_3127, this.f_3128, var1);
      }

      public float m_3911() {
         return this.f_3127;
      }

      public int m_2157() {
         return this.f_3129;
      }

      public float m_2843() {
         return this.f_3128;
      }
   }
}
