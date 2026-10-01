package su.energyclient.util;

import com.mojang.blaze3d.systems.ProjectionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import net.minecraft.util.math.Vec2f;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.lwjgl.opengl.GL11;
import su.energyclient.QuickImports;

public class Util45 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_8190 = 1000.0F;
   private static final float f_8191 = 3000.0F;
   private static final float f_8192 = -2000.0F;

   public static Vec2f m_3227(int var0, int var1) {
      return Util45.zkARAhsLIKMAvcvv.m_3162(var0, var1);
   }

   public static Util45.LMzZzDWjhPUT0g02 m_1273(float var0) {
      if (!(var0 <= 0.0F) && f_5909 != null && f_5909.getWindow() != null) {
         Window var1 = f_5909.getWindow();
         int var2 = var1.getScaleFactor();
         Matrix4f var3 = new Matrix4f(Util114.m_1781());
         Matrix4fStack var4 = Util114.m_1789();
         Matrix4f var5 = new Matrix4f(var4);
         ProjectionType var6 = Util114.m_2545();
         boolean var7 = GL11.glIsEnabled(2929);
         boolean var8 = GL11.glIsEnabled(2884);
         boolean var9 = GL11.glGetBoolean(2930);
         int var10 = Math.max(1, Math.round(var0));
         var1.setScaleFactor(var10);
         float var11 = var1.getScaledWidth();
         float var12 = var1.getScaledHeight();
         Matrix4f var13 = new Matrix4f().setOrtho(0.0F, var11, var12, 0.0F, f_8190, f_8191);
         Util114.m_2544(var13, ProjectionType.ORTHOGRAPHIC);
         var4.identity();
         var4.translation(0.0F, 0.0F, f_8192);
         Util114.m_672();
         Util114.m_1878(false);
         Util114.m_3978();
         return new Util45.LMzZzDWjhPUT0g02(var2, var3, var5, var6, var7, var8, var9);
      } else {
         return null;
      }
   }

   public static void m_3922(Util45.LMzZzDWjhPUT0g02 var0) {
      if (var0 != null && f_5909 != null && f_5909.getWindow() != null) {
         Window var1 = f_5909.getWindow();
         Matrix4fStack var2 = Util114.m_1789();
         var1.setScaleFactor(var0.f_8394);
         Util114.m_2544(var0.f_8395, var0.f_8397);
         var2.identity();
         var2.mul(var0.f_8396);
         Util114.m_1878(var0.f_8400);
         if (var0.f_8398) {
            Util114.m_100();
         } else {
            Util114.m_672();
         }

         if (var0.f_8399) {
            Util114.m_1562();
         } else {
            Util114.m_3978();
         }
      }
   }

   public static class LMzZzDWjhPUT0g02 {
      public final int f_8394;
      public final Matrix4f f_8395;
      public final Matrix4f f_8396;
      public final ProjectionType f_8397;
      public final boolean f_8398;
      public final boolean f_8399;
      public final boolean f_8400;

      public LMzZzDWjhPUT0g02(int var1, Matrix4f var2, Matrix4f var3, ProjectionType var4, boolean var5, boolean var6, boolean var7) {
         this.f_8394 = var1;
         this.f_8395 = new Matrix4f(var2);
         this.f_8396 = new Matrix4f(var3);
         this.f_8397 = var4;
         this.f_8398 = var5;
         this.f_8399 = var6;
         this.f_8400 = var7;
      }
   }

   public static class zkARAhsLIKMAvcvv {
      private static final double f_9167 = 2.0;
      private static final double f_9168 = 2.0;
      private static final double f_9169 = 2.0;

      public static Vec2f m_3162(float var0, float var1) {
         MinecraftClient var2 = MinecraftClient.getInstance();
         Window var3 = var2 != null ? var2.getWindow() : null;
         double var4 = var3 != null ? var3.getScaleFactor() : f_9167;
         float var6 = (float)(var0 * (var4 / f_9168));
         float var7 = (float)(var1 * (var4 / f_9169));
         return new Vec2f(var6, var7);
      }
   }
}
