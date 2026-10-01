package su.energyclient.render;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.GlBackend;
import net.minecraft.client.texture.GlTexture;
import org.lwjgl.opengl.GL11;
import su.energyclient.util.Util114;
import su.energyclient.util.Util98;

public final class RenderUtil6 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Map<Framebuffer, float[]> f_13894 = Collections.synchronizedMap(new WeakHashMap<>());
   private static final float[] f_13895 = new float[]{0.0F, 0.0F, 0.0F, 0.0F};
   private static final int f_13896 = 36160;
   private static final int f_13897 = 36006;
   private static final int f_13898 = 36160;
   private static final int f_13899 = 36160;
   private static final int f_13900 = 33071;
   private static final int f_13901 = 33071;
   private static final String f_13902 = "Energy legacy renderer requires the OpenGL backend";

   public static void m_210(Framebuffer var0) {
      float[] var1 = f_13894.getOrDefault(var0, f_13895);
      GL11.glClearColor(var1[0], var1[1], var1[2], var1[3]);
      GL11.glClear(var0.useDepthAttachment ? 16640 : 16384);
   }

   public static void m_2660(Framebuffer var0) {
   }

   public static void m_4015(Framebuffer var0, int var1) {
      Util114.m_2012(var0.getColorAttachment());
      GL11.glTexParameteri(3553, 10241, var1);
      GL11.glTexParameteri(3553, 10240, var1);
      GL11.glTexParameteri(3553, 10242, f_13900);
      GL11.glTexParameteri(3553, 10243, f_13901);
      Util114.m_2012(0);
   }

   public static void m_3625(Framebuffer var0) {
      Util114.m_2037(0, var0.getColorAttachment());
   }

   public static void m_2715(Framebuffer var0, float var1, float var2, float var3, float var4) {
      f_13894.put(var0, new float[]{var1, var2, var3, var4});
   }

   public static int m_668(Object var0) {
      return Util98.m_1819(var0);
   }

   public static void m_2129(Framebuffer var0) {
      Util114.m_2037(0, 0);
   }

   public static int m_823(Framebuffer var0) {
      if (RenderSystem.getDevice() instanceof GlBackend var1) {
         return ((GlTexture)var0.getColorAttachment()).getOrCreateFramebuffer(var1.getBufferManager(), var0.getDepthAttachment());
      } else {
         throw new IllegalStateException(f_13902);
      }
   }

   private RenderUtil6() {
   }

   public static void m_676(Framebuffer var0) {
      int var1 = GL11.glGetInteger(f_13897);
      GlStateManager._glBindFramebuffer(f_13898, m_823(var0));
      m_210(var0);
      GlStateManager._glBindFramebuffer(f_13899, var1);
   }

   public static void m_4071(Framebuffer var0, boolean var1) {
      GlStateManager._glBindFramebuffer(f_13896, m_823(var0));
      if (var1) {
         GlStateManager._viewport(0, 0, var0.textureWidth, var0.textureHeight);
      }
   }
}
