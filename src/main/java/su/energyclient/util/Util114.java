package su.energyclient.util;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.systems.ProjectionType;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents.ClientStarted;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents.ClientStopping;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RawProjectionMatrix;
import net.minecraft.client.render.Tessellator;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;
import org.lwjgl.opengl.GL11;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil9;
import su.energyclient.util.math.MathUtil6;

public final class Util114 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Map<RenderUtil9, Util98> f_13100 = new HashMap<>();
   private static final Object[] f_13101 = new Object[16];
   private static final float[] l = new float[]{1.0F, 1.0F, 1.0F, 1.0F};
   private static Util98 f_13102;
   private static Matrix4f f_13103;
   private static RawProjectionMatrix f_13104;
   private static final Queue<Runnable> f_13105 = new ConcurrentLinkedQueue<>();
   private static volatile boolean f_13106;
   private static final int f_13107 = 33984;
   private static final int f_13108 = 33984;
   private static final String f_13109 = "ColorModulator";
   private static final float f_13110 = 1000.0F;
   private static final float f_13111 = 11000.0F;
   private static final String f_13112 = "energy legacy projection";
   private static final long f_13113 = 240000L;
   private static final float f_13114 = 240000.0F;

   public static void m_672() {
      GlStateManager._disableDepthTest();
   }

   public static void m_963() {
      GlStateManager._disableBlend();
   }

   public static Matrix4fStack m_1789() {
      return RenderSystem.getModelViewStack();
   }

   public static void m_3158(float var0, float var1, float var2, float var3) {
      l[0] = var0;
      l[1] = var1;
      l[2] = var2;
      l[3] = var3;
      if (f_13102 != null) {
         MathUtil6 var4 = f_13102.m_1335(f_13109);
         if (var4 != null) {
            var4.m_41(var0, var1, var2, var3);
         }
      }
   }

   public static void m_542() {
      GlStateManager._blendFuncSeparate(770, 771, 1, 771);
   }

   public static ProjectionType m_2545() {
      return RenderSystem.getProjectionType();
   }

   public static void m_2697(Runnable var0) {
      if (!f_13106) {
         f_13105.add(var0);
      } else {
         if (RenderSystem.isOnRenderThread()) {
            var0.run();
         } else {
            MinecraftClient.getInstance().execute(var0);
         }
      }
   }

   public static void m_2977(float var0) {
      GL11.glLineWidth(1.0F);
   }

   public static void m_2740(int var0, int var1, int var2, int var3) {
      GlStateManager._enableScissorTest();
      GL11.glScissor(var0, var1, var2, var3);
   }

   public static Util98 m_3784(RenderUtil9 var0) {
      f_13102 = m_827(var0);
      f_13102.m_548(m_1712(), m_663(), l);
      return f_13102;
   }

   public static Util98 m_827(RenderUtil9 var0) {
      return f_13100.computeIfAbsent(var0, Util98::new);
   }

   private static Matrix4f m_663() {
      if (f_13103 != null) {
         return f_13103;
      } else {
         MinecraftClient var0 = MinecraftClient.getInstance();
         if (m_2545() == ProjectionType.ORTHOGRAPHIC) {
            float var1 = (float)var0.getWindow().getFramebufferWidth() / var0.getWindow().getScaleFactor();
            float var2 = (float)var0.getWindow().getFramebufferHeight() / var0.getWindow().getScaleFactor();
            return new Matrix4f().setOrtho(0.0F, var1, var2, 0.0F, f_13110, f_13111);
         } else {
            return var0.gameRenderer.getBasicProjectionMatrix(((Integer)var0.options.getFov().getValue()).intValue());
         }
      }
   }

   public static void m_2012(Object var0) {
      int var1 = Util98.m_1819(var0);
      GL11.glBindTexture(3553, var1);
      GlStateManager._bindTexture(var1);
   }

   public static Tessellator m_2494() {
      return Tessellator.getInstance();
   }

   public static void m_1481() {
      GlStateManager._enableBlend();
   }

   public static Matrix4f m_1712() {
      return RenderSystem.getModelViewMatrix();
   }

   public static void m_3188(int var0) {
      GlStateManager._depthFunc(var0);
   }

   public static void m_3706() {
      GlStateManager._disableScissorTest();
   }

   public static void m_582(int var0, int var1) {
      GlStateManager._blendFuncSeparate(var0, var1, var0, var1);
   }

   public static void m_2544(Matrix4f var0, ProjectionType var1) {
      f_13103 = new Matrix4f(var0);
      if (f_13104 == null) {
         f_13104 = new RawProjectionMatrix(f_13112);
      }

      RenderSystem.setProjectionMatrix(f_13104.set(var0), var1);
   }

   public static void m_2836(int var0) {
      GlStateManager._activeTexture(var0);
   }

   private Util114() {
   }

   public static float m_3256() {
      return (float)(System.currentTimeMillis() % f_13113) / f_13114;
   }

   public static void m_3978() {
      GlStateManager._disableCull();
   }

   public static void m_1878(boolean var0) {
      GlStateManager._depthMask(var0);
   }

   static {
      ClientLifecycleEvents.CLIENT_STARTED.register((ClientStarted)var0 -> {
         f_13106 = true;

         Runnable var1;
         while ((var1 = f_13105.poll()) != null) {
            var1.run();
         }
      });
      ClientLifecycleEvents.CLIENT_STOPPING.register((ClientStopping)var0 -> {
         f_13100.values().forEach(Util98::close);
         f_13100.clear();
         RenderUtil12.m_692();
         f_13102 = null;
         Arrays.fill(f_13101, null);
         f_13105.clear();
         f_13103 = null;
         f_13106 = false;
      });
   }

   public static void m_100() {
      GlStateManager._enableDepthTest();
   }

   public static void m_1206(int var0, int var1, int var2, int var3) {
      GlStateManager._blendFuncSeparate(var0, var1, var2, var3);
   }

   public static void m_811() {
      RenderSystem.assertOnRenderThread();
   }

   public static Matrix4f m_1781() {
      Matrix4f var0 = m_663();
      return f_13103 != null ? new Matrix4f(var0) : var0;
   }

   public static void m_2037(int var0, Object var1) {
      if (var0 >= 0 && var0 < f_13101.length) {
         f_13101[var0] = var1;
      }

      m_2836(f_13107 + var0);
      m_2012(var1);
      m_2836(f_13108);
   }

   public static void m_2606() {
      if (f_13102 != null) {
         f_13102.m_701(f_13101);
      }
   }

   public static void m_1562() {
      GlStateManager._enableCull();
   }

   public static void m_2265(int var0, int var1, int var2, int var3) {
      GlStateManager._viewport(var0, var1, var2, var3);
   }

   public static Util114.v4av9TJhTFdXLTYo m_220(Matrix4f var0) {
      Matrix4f var1 = f_13103 == null ? null : new Matrix4f(f_13103);
      f_13103 = new Matrix4f(var0);
      return new Util114.v4av9TJhTFdXLTYo(var1);
   }

   public static void m_3547(boolean var0, boolean var1, boolean var2, boolean var3) {
      GlStateManager._colorMask(var0, var1, var2, var3);
   }

   public static Util98 m_4018() {
      return f_13102;
   }

   public static final class v4av9TJhTFdXLTYo implements AutoCloseable {
      private Matrix4f f_842;
      private boolean f_843;

      @Override
      public void close() {
         if (!this.f_843) {
            Util114.f_13103 = this.f_842;
            this.f_842 = null;
            this.f_843 = true;
         }
      }

      private v4av9TJhTFdXLTYo(Matrix4f var1) {
         this.f_842 = var1;
      }
   }
}
