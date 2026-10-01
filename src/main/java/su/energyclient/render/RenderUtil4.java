package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;

public class RenderUtil4 extends RenderUtil11 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_13869 = "effects";
   private static final String f_13870 = "reflection";
   private static final String f_13871 = "ModelViewMat";
   private static final String f_13872 = "ProjMat";
   private static final String f_13873 = "Tex0";
   private static final String f_13874 = "Freq";
   private static final String f_13875 = "CamPos";
   private static final int f_13876 = 33984;
   private static final String f_13877 = "Position";
   private static final String f_13878 = "Normal";
   private static final double f_13879 = Math.PI * 2;
   private static final double f_13880 = Math.PI * 2;
   private static final double f_13881 = Math.PI * 2;
   private static final double f_13882 = Math.PI * 2;
   private static final String f_13883 = "Tex0";
   private static final String f_13884 = "Alpha";

   public RenderUtil4() {
      super(f_13869, f_13870);
   }

   public static void m_3361(Matrix4f var0, Matrix4f var1, float var2, float var3, float var4) {
      if (RenderUtil23.m_1445()) {
         RenderUtil4 var5 = RenderUtil23.m_1879();
         SimpleFramebuffer var6 = RenderUtil23.m_3416();
         var5.m_2989();
         var5.m_3277(f_13871, false, var0);
         var5.m_3277(f_13872, false, var1);
         var5.m_3372(f_13873, 0);
         var5.m_2024(f_13874, var2);
         if (f_5909.gameRenderer.getCamera() != null) {
            Vec3d var7 = f_5909.gameRenderer.getCamera().getCameraPos();
            var5.m_1054(f_13875, new Vector3f((float)var7.x, (float)var7.y, (float)var7.z));
         }

         Util114.m_2836(f_13876);
         Util114.m_2012(RenderUtil6.m_668(var6.getColorAttachment()));
         VertexFormat var37 = VertexFormat.builder().add(f_13877, VertexFormatElement.POSITION).add(f_13878, VertexFormatElement.NORMAL).build();
         BufferBuilder var8 = Tessellator.getInstance().begin(DrawMode.QUADS, var37);
         byte var9 = 10;
         byte var10 = 30;
         Vector3f var11 = new Vector3f();
         Vector3f var12 = new Vector3f();
         Vector3f var13 = new Vector3f();
         Vector3f var14 = new Vector3f();

         for (int var15 = 0; var15 < var9; var15++) {
            double var16 = f_13879 * var15 / var9;
            double var18 = f_13880 * (var15 + 1) / var9;

            for (int var20 = 0; var20 < var10; var20++) {
               double var21 = f_13881 * var20 / var10;
               double var23 = f_13882 * (var20 + 1) / var10;
               float var25 = (float)((var3 + var4 * Math.cos(var16)) * Math.cos(var21));
               float var26 = (float)((var3 + var4 * Math.cos(var16)) * Math.sin(var21));
               float var27 = (float)(var4 * Math.sin(var16));
               float var28 = (float)((var3 + var4 * Math.cos(var18)) * Math.cos(var21));
               float var29 = (float)((var3 + var4 * Math.cos(var18)) * Math.sin(var21));
               float var30 = (float)(var4 * Math.sin(var18));
               float var31 = (float)((var3 + var4 * Math.cos(var18)) * Math.cos(var23));
               float var32 = (float)((var3 + var4 * Math.cos(var18)) * Math.sin(var23));
               float var33 = (float)(var4 * Math.sin(var18));
               float var34 = (float)((var3 + var4 * Math.cos(var16)) * Math.cos(var23));
               float var35 = (float)((var3 + var4 * Math.cos(var16)) * Math.sin(var23));
               float var36 = (float)(var4 * Math.sin(var16));
               var11.set((float)(Math.cos(var16) * Math.cos(var21)), (float)(Math.cos(var16) * Math.sin(var21)), (float)Math.sin(var16)).normalize();
               var12.set((float)(Math.cos(var18) * Math.cos(var21)), (float)(Math.cos(var18) * Math.sin(var21)), (float)Math.sin(var18)).normalize();
               var13.set((float)(Math.cos(var18) * Math.cos(var23)), (float)(Math.cos(var18) * Math.sin(var23)), (float)Math.sin(var18)).normalize();
               var14.set((float)(Math.cos(var16) * Math.cos(var23)), (float)(Math.cos(var16) * Math.sin(var23)), (float)Math.sin(var16)).normalize();
               var8.vertex(var25, var26, var27).normal(var11.x, var11.y, var11.z);
               var8.vertex(var28, var29, var30).normal(var12.x, var12.y, var12.z);
               var8.vertex(var31, var32, var33).normal(var13.x, var13.y, var13.z);
               var8.vertex(var34, var35, var36).normal(var14.x, var14.y, var14.z);
            }
         }

         RenderUtil12.m_1546(var8.end());
         var5.m_233();
      }
   }

   public static void m_3747(boolean var0) {
      RenderUtil23.m_2825();
      if (RenderUtil23.m_1445()) {
         RenderUtil23.m_695();
         SimpleFramebuffer var1 = RenderUtil23.m_2522();
         SimpleFramebuffer var2 = RenderUtil23.m_3416();
         Framebuffer var3 = f_5909.getFramebuffer();
         RenderUtil23.m_180(var3, var2);
         RenderUtil6.m_676(var1);
         if (var0) {
            var1.copyDepthFrom(var3);
            Util114.m_100();
         } else {
            Util114.m_672();
         }

         RenderUtil6.m_4071(var1, false);
      }
   }

   public static void m_1613(boolean var0) {
      if (RenderUtil23.m_1445()) {
         SimpleFramebuffer var1 = RenderUtil23.m_2522();
         RenderUtil10 var2 = RenderUtil23.m_3189();
         RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
         Util114.m_1878(false);
         Util114.m_672();
         var2.m_2989();
         var2.m_3372(f_13883, 0);
         var2.m_3397(f_13884, true);
         Util114.m_1481();
         Util114.m_542();
         Util114.m_2012(RenderUtil6.m_668(var1.getColorAttachment()));
         RenderUtil23.m_1477();
         Util114.m_963();
         var2.m_233();
         Util114.m_1878(true);
         if (var0) {
            Util114.m_100();
         }
      }
   }
}
