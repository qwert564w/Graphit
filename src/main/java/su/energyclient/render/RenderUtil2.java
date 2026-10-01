package su.energyclient.render;

import java.awt.Rectangle;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.Window;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.system.MemoryStack;
import su.energyclient.util.Util77;

public class RenderUtil2 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final List<Rectangle> f_13428 = new ArrayList<>();
   private static Rectangle f_13429 = null;
   private static final List<RenderUtil2.tWD1IzEb3yUDPck2> f_13430 = new ArrayList<>();
   private static final List<DrawContext> f_13431 = new ArrayList<>();

   public static void m_3624(double var0, double var2, double var4, double var6) {
      DrawContext var8 = Util77.m_3042();
      f_13431.add(var8);
      if (var8 != null) {
         int var28 = (int)Math.floor(var0);
         int var29 = (int)Math.floor(var2);
         int var31 = (int)Math.ceil(var0 + Math.max(0.0, var4));
         int var33 = (int)Math.ceil(var2 + Math.max(0.0, var6));
         var8.enableScissor(var28, var29, var31, var33);
      } else {
         boolean var9 = GL11C.glIsEnabled(3089);
         int[] var10 = null;
         if (var9) {
            MemoryStack var11 = MemoryStack.stackPush();

            try {
               IntBuffer var12 = var11.mallocInt(4);
               GL11C.glGetIntegerv(3088, var12);
               var10 = new int[]{var12.get(0), var12.get(1), var12.get(2), var12.get(3)};
            } catch (Throwable var27) {
               if (var11 != null) {
                  try {
                     var11.close();
                  } catch (Throwable var26) {
                     var27.addSuppressed(var26);
                  }
               }

               throw var27;
            }

            if (var11 != null) {
               var11.close();
            }
         }

         f_13430.add(new RenderUtil2.tWD1IzEb3yUDPck2(var9, var10));
         f_13428.add(f_13429);
         MinecraftClient var30 = MinecraftClient.getInstance();
         Window var32 = var30 != null ? var30.getWindow() : null;
         if (var32 != null) {
            double var13 = var32.getScaleFactor();
            int var15 = (int)(var0 * var13);
            int var16 = (int)(var2 * var13);
            int var17 = (int)(var4 * var13);
            int var18 = (int)(var6 * var13);
            int var19 = var32.getFramebufferWidth();
            int var20 = var32.getFramebufferHeight();
            int var21 = var20 - var16 - var18;
            Rectangle var22 = new Rectangle(var15, var21, Math.max(0, var17), Math.max(0, var18));
            Rectangle var23 = new Rectangle(0, 0, var19, var20);
            Rectangle var24 = f_13429;
            if (var24 == null || var24.width <= 0 || var24.height <= 0) {
               var24 = var23;
            }

            Rectangle var25 = m_2132(var22, var24);
            var25 = m_2132(var25, var23);
            if (var25.width < 0) {
               var25.width = 0;
            }

            if (var25.height < 0) {
               var25.height = 0;
            }

            GL11C.glEnable(3089);
            GL11C.glScissor(var25.x, var25.y, var25.width, var25.height);
            if (!f_13428.isEmpty()) {
               f_13428.set(f_13428.size() - 1, new Rectangle(var25));
            }

            f_13429 = new Rectangle(var25);
         }
      }
   }

   private static Rectangle m_2132(Rectangle var0, Rectangle var1) {
      return var0 != null && var1 != null ? var0.intersection(var1) : new Rectangle(0, 0, 0, 0);
   }

   public static void m_1647() {
      DrawContext var0 = f_13431.isEmpty() ? null : f_13431.remove(f_13431.size() - 1);
      if (var0 != null) {
         var0.disableScissor();
      } else {
         RenderUtil2.tWD1IzEb3yUDPck2 var1 = f_13430.isEmpty() ? null : f_13430.remove(f_13430.size() - 1);
         if (var1 == null) {
            GL11C.glDisable(3089);
         } else if (var1.f_10320) {
            GL11C.glEnable(3089);
            int[] var2 = var1.f_10321;
            if (var2 != null) {
               GL11C.glScissor(var2[0], var2[1], var2[2], var2[3]);
            }
         } else {
            GL11C.glDisable(3089);
         }

         if (!f_13428.isEmpty()) {
            f_13428.remove(f_13428.size() - 1);
            f_13429 = f_13428.isEmpty() ? null : f_13428.get(f_13428.size() - 1);
         } else {
            f_13429 = null;
         }
      }
   }

   private static final class tWD1IzEb3yUDPck2 {
      final boolean f_10320;
      final int[] f_10321;

      tWD1IzEb3yUDPck2(boolean var1, int[] var2) {
         this.f_10320 = var1;
         this.f_10321 = var2;
      }
   }
}
