package su.energyclient.util;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL33;
import org.lwjgl.system.MemoryStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import su.energyclient.QuickImports;
import su.energyclient.render.RenderUtil6;
import su.energyclient.util.math.MathUtil6;

public final class Util149 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Logger f_11744 = LoggerFactory.getLogger(Util149.class);
   private final Matrix4f f_11745 = new Matrix4f();
   private final Matrix4f f_11746 = new Matrix4f();
   private SimpleFramebuffer f_11747;
   private SimpleFramebuffer f_11748;
   private SimpleFramebuffer f_11749;
   private int f_11750;
   private int f_11751;
   private int f_11752;
   private int f_11753;
   private boolean f_11754;
   private static final int f_11755 = 36281;
   private static final int f_11756 = 36008;
   private static final int f_11757 = 36009;
   private static final String f_11758 = "SceneSampler";
   private static final String f_11759 = "DepthSampler";
   private static final String f_11760 = "FogColor";
   private static final float f_11761 = 8.0F;
   private static final float f_11762 = 1080.0F;
   private static final String f_11763 = "GlowSampler";
   private static final String f_11764 = "Direction";
   private static final String f_11765 = "Radius";
   private static final String f_11766 = "GlowSampler";
   private static final String f_11767 = "Direction";
   private static final String f_11768 = "SceneSampler";
   private static final String f_11769 = "GlowSampler";
   private static final String f_11770 = "DepthSampler";
   private static final String f_11771 = "Intensity";
   private static final String f_11772 = "Unable to render fog glow; disabled until Ambience is re-enabled";
   private static final String f_11773 = "Energy fog scene";
   private static final String f_11774 = "Energy fog glow";
   private static final String f_11775 = "Energy fog blur";
   private static final int f_11776 = 34962;
   private static final int f_11777 = 34962;
   private static final float f_11778 = -1.0F;
   private static final float f_11779 = -1.0F;
   private static final float f_11780 = -1.0F;
   private static final float f_11781 = -1.0F;
   private static final int f_11782 = 35044;
   private static final long f_11783 = 12L;
   private static final int f_11784 = 33984;
   private static final int f_11785 = 33071;
   private static final int f_11786 = 33071;
   private static final int f_11787 = 34892;
   private static final int f_11788 = 36009;
   private static final int f_11789 = 33984;
   private static final String f_11790 = "InvViewMat";
   private static final String f_11791 = "InvProjMat";
   private static final String f_11792 = "FogRanges";

   public void m_1486(Matrix4f var1, Matrix4f var2, Vector4f var3, Vector4f var4, float var5, float var6) {
      if (!this.f_11754 && !(var5 <= 0.0F)) {
         Framebuffer var7 = f_5909.getFramebuffer();
         if (var7 != null && var7.getDepthAttachment() != null && var7.textureWidth > 0 && var7.textureHeight > 0) {
            Util114.m_811();

            try (Util149.EqrjW8ItkXuaTrQm var8 = new Util149.EqrjW8ItkXuaTrQm()) {
               try {
                  this.m_228(var7.textureWidth, var7.textureHeight);
                  this.f_11745.set(var1).invert();
                  this.f_11746.set(var2).invert();
                  if (!this.f_11745.isFinite() || !this.f_11746.isFinite()) {
                     return;
                  }

                  m_1246(3089, false);
                  m_1246(3042, false);
                  m_1246(2929, false);
                  m_1246(2884, false);
                  GL11.glDisable(f_11755);
                  GL11.glDepthMask(false);
                  GlStateManager._depthMask(false);
                  GL11.glColorMask(true, true, true, true);
                  GlStateManager._colorMask(true, true, true, true);
                  m_2633(f_11756, RenderUtil6.m_823(var7));
                  m_2633(f_11757, RenderUtil6.m_823(this.f_11747));
                  GL30.glBlitFramebuffer(0, 0, this.f_11750, this.f_11751, 0, 0, this.f_11750, this.f_11751, 16640, 9728);
                  Util98 var9 = Util114.m_827(Util24.f_3279);
                  this.m_1930(this.f_11748, var9);
                  this.m_3391(var9, f_11758, 0, this.f_11747.getColorAttachment());
                  this.m_3391(var9, f_11759, 1, this.f_11747.getDepthAttachment());
                  this.m_59(var9, var3);
                  MathUtil6 var10 = var9.m_1335(f_11760);
                  if (var10 != null) {
                     var10.m_33(var4.x, var4.y, var4.z);
                     var10.m_1707();
                  }

                  this.m_3904();
                  Util98 var11 = Util114.m_827(Util24.f_3280);
                  float var12 = Math.max(1.0F, var6 * f_11761 * this.f_11751 / f_11762);
                  this.m_1930(this.f_11749, var11);
                  this.m_3391(var11, f_11763, 0, this.f_11748.getColorAttachment());
                  this.O(var11, f_11764, 1.0F / this.f_11748.textureWidth, 0.0F);
                  this.O(var11, f_11765, var12);
                  this.m_3904();
                  this.m_1930(this.f_11748, var11);
                  this.m_3391(var11, f_11766, 0, this.f_11749.getColorAttachment());
                  this.O(var11, f_11767, 0.0F, 1.0F / this.f_11748.textureHeight);
                  this.m_3904();
                  Util98 var13 = Util114.m_827(Util24.f_3281);
                  this.m_1930(var7, var13);
                  this.m_3391(var13, f_11768, 0, this.f_11747.getColorAttachment());
                  this.m_3391(var13, f_11769, 1, this.f_11748.getColorAttachment());
                  this.m_3391(var13, f_11770, 2, this.f_11747.getDepthAttachment());
                  this.m_59(var13, var3);
                  this.O(var13, f_11771, var5);
                  this.m_3904();
               } catch (RuntimeException var15) {
                  this.f_11754 = true;
                  f_11744.error(f_11772, var15);
                  this.m_2240();
               }
            }
         }
      }
   }

   private static void m_1246(int var0, boolean var1) {
      if (var1) {
         GL11.glEnable(var0);
      } else {
         GL11.glDisable(var0);
      }

      switch (var0) {
         case 2884:
            if (var1) {
               Util114.m_1562();
            } else {
               Util114.m_3978();
            }
            break;
         case 2929:
            if (var1) {
               Util114.m_100();
            } else {
               Util114.m_672();
            }
            break;
         case 3042:
            if (var1) {
               Util114.m_1481();
            } else {
               Util114.m_963();
            }
            break;
         case 3089:
            if (var1) {
               GlStateManager._enableScissorTest();
            } else {
               Util114.m_3706();
            }
      }
   }

   private static void m_430(int var0) {
      GL13.glActiveTexture(var0);
      GlStateManager._activeTexture(var0);
   }

   private void m_3391(Util98 var1, String var2, int var3, Object var4) {
      m_430(f_11789 + var3);
      GL33.glBindSampler(var3, 0);
      Util114.m_2012(var4);
      GL20.glUniform1i(GL20.glGetUniformLocation(var1.m_4047(), var2), var3);
   }

   public void m_1952() {
      this.f_11754 = false;
   }

   private void O(Util98 var1, String var2, float var3, float var4) {
      MathUtil6 var5 = var1.m_1335(var2);
      if (var5 != null) {
         var5.m_54(var3, var4);
         var5.m_1707();
      }
   }

   private void O(Util98 var1, String var2, float var3) {
      MathUtil6 var4 = var1.m_1335(var2);
      if (var4 != null) {
         var4.O(var3);
         var4.m_1707();
      }
   }

   private void m_3904() {
      GL30.glBindVertexArray(this.f_11752);
      GL11.glDrawArrays(5, 0, 4);
   }

   private void m_1930(Framebuffer var1, Util98 var2) {
      m_2633(f_11788, RenderUtil6.m_823(var1));
      GL11.glViewport(0, 0, var1.textureWidth, var1.textureHeight);
      GlStateManager._viewport(0, 0, var1.textureWidth, var1.textureHeight);
      GL20.glUseProgram(var2.m_4047());
   }

   private void m_2819(Object var1, int var2, boolean var3) {
      m_430(f_11784);
      Util114.m_2012(var1);
      GL11.glTexParameteri(3553, 10241, var2);
      GL11.glTexParameteri(3553, 10240, var2);
      GL11.glTexParameteri(3553, 10242, f_11785);
      GL11.glTexParameteri(3553, 10243, f_11786);
      if (var3) {
         GL11.glTexParameteri(3553, f_11787, 0);
      }
   }

   private void m_59(Util98 var1, Vector4f var2) {
      MathUtil6 var3 = var1.m_1335(f_11790);
      if (var3 != null) {
         var3.m_23(this.f_11745);
         var3.m_1707();
      }

      MathUtil6 var4 = var1.m_1335(f_11791);
      if (var4 != null) {
         var4.m_23(this.f_11746);
         var4.m_1707();
      }

      MathUtil6 var5 = var1.m_1335(f_11792);
      if (var5 != null) {
         var5.m_41(var2.x, var2.y, var2.z, var2.w);
         var5.m_1707();
      }
   }

   private static void m_2633(int var0, int var1) {
      GL30.glBindFramebuffer(var0, var1);
      GlStateManager._glBindFramebuffer(var0, var1);
   }

   private void m_228(int var1, int var2) {
      if (this.f_11747 == null || this.f_11750 != var1 || this.f_11751 != var2) {
         this.m_2240();
         this.f_11750 = var1;
         this.f_11751 = var2;
         this.f_11747 = new SimpleFramebuffer(f_11773, this.f_11750, this.f_11751, true);
         this.f_11748 = new SimpleFramebuffer(f_11774, (this.f_11750 + 1) / 2, (this.f_11751 + 1) / 2, false);
         this.f_11749 = new SimpleFramebuffer(f_11775, (this.f_11750 + 1) / 2, (this.f_11751 + 1) / 2, false);
         this.m_2819(this.f_11747.getColorAttachment(), 9728, false);
         this.m_2819(this.f_11747.getDepthAttachment(), 9728, true);
         this.m_2819(this.f_11748.getColorAttachment(), 9729, false);
         this.m_2819(this.f_11749.getColorAttachment(), 9729, false);
         this.f_11752 = GL30.glGenVertexArrays();
         this.f_11753 = GL15.glGenBuffers();
         GL30.glBindVertexArray(this.f_11752);
         GL15.glBindBuffer(f_11776, this.f_11753);
         GL15.glBufferData(
            f_11777,
            new float[]{f_11778, f_11779, 0.0F, 0.0F, 0.0F, 1.0F, f_11780, 0.0F, 1.0F, 0.0F, f_11781, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F},
            f_11782
         );
         GL20.glEnableVertexAttribArray(0);
         GL20.glVertexAttribPointer(0, 3, 5126, false, 20, 0L);
         GL20.glEnableVertexAttribArray(1);
         GL20.glVertexAttribPointer(1, 2, 5126, false, 20, f_11783);
      }
   }

   public void m_2240() {
      SimpleFramebuffer var1 = this.f_11747;
      SimpleFramebuffer var2 = this.f_11748;
      SimpleFramebuffer var3 = this.f_11749;
      int var4 = this.f_11752;
      int var5 = this.f_11753;
      this.f_11747 = this.f_11748 = this.f_11749 = null;
      this.f_11750 = this.f_11751 = this.f_11752 = this.f_11753 = 0;
      if (var1 != null || var2 != null || var3 != null || var4 != 0 || var5 != 0) {
         Runnable var6 = () -> {
            if (var1 != null) {
               var1.delete();
            }

            if (var2 != null) {
               var2.delete();
            }

            if (var3 != null) {
               var3.delete();
            }

            if (var4 != 0) {
               GL30.glDeleteVertexArrays(var4);
            }

            if (var5 != 0) {
               GL15.glDeleteBuffers(var5);
            }
         };
         if (RenderSystem.isOnRenderThread()) {
            var6.run();
         } else {
            Util114.m_2697(var6);
         }
      }
   }

   private static final class EqrjW8ItkXuaTrQm implements AutoCloseable {
      private final int f_613;
      private final int f_614;
      private final int f_615;
      private final int f_616;
      private final int f_617;
      private final int f_618;
      private final boolean f_619;
      private final boolean f_620;
      private final boolean f_621;
      private final boolean f_622;
      private final boolean f_623;
      private final boolean f_624;
      private final int[] f_625;
      private final int[] f_626;
      private final int[] f_627;
      private final boolean[] f_628;
      private static final int f_629 = 36010;
      private static final int f_630 = 36006;
      private static final int f_631 = 35725;
      private static final int f_632 = 34229;
      private static final int f_633 = 34964;
      private static final int f_634 = 34016;
      private static final int f_635 = 36281;
      private static final int f_636 = 33984;
      private static final int f_637 = 32873;
      private static final int f_638 = 35097;
      private static final int f_639 = 36008;
      private static final int f_640 = 36009;
      private static final int f_641 = 34962;
      private static final int f_642 = 36281;
      private static final int f_643 = 36281;
      private static final int f_644 = 33984;

      private EqrjW8ItkXuaTrQm() {
         this.f_613 = GL11.glGetInteger(f_629);
         this.f_614 = GL11.glGetInteger(f_630);
         this.f_615 = GL11.glGetInteger(f_631);
         this.f_616 = GL11.glGetInteger(f_632);
         this.f_617 = GL11.glGetInteger(f_633);
         this.f_618 = GL11.glGetInteger(f_634);
         this.f_619 = GL11.glIsEnabled(3042);
         this.f_620 = GL11.glIsEnabled(2929);
         this.f_621 = GL11.glIsEnabled(2884);
         this.f_622 = GL11.glIsEnabled(3089);
         this.f_623 = GL11.glIsEnabled(f_635);
         this.f_624 = GL11.glGetBoolean(2930);
         this.f_625 = new int[3];
         this.f_626 = new int[3];
         this.f_627 = new int[4];
         this.f_628 = new boolean[4];
         MemoryStack var1 = MemoryStack.stackPush();

         try {
            IntBuffer var2 = var1.mallocInt(4);
            GL11.glGetIntegerv(2978, var2);
            var2.get(this.f_627);
            ByteBuffer var3 = var1.malloc(4);
            GL11.glGetBooleanv(3107, var3);

            for (int var4 = 0; var4 < 4; var4++) {
               this.f_628[var4] = var3.get(var4) != 0;
            }
         } catch (Throwable var6) {
            if (var1 != null) {
               try {
                  var1.close();
               } catch (Throwable var5) {
                  var6.addSuppressed(var5);
               }
            }

            throw var6;
         }

         if (var1 != null) {
            var1.close();
         }

         for (int var7 = 0; var7 < 3; var7++) {
            Util149.m_430(f_636 + var7);
            this.f_625[var7] = GL11.glGetInteger(f_637);
            this.f_626[var7] = GL11.glGetInteger(f_638);
         }

         Util149.m_430(this.f_618);
      }

      @Override
      public void close() {
         Util149.m_2633(f_639, this.f_613);
         Util149.m_2633(f_640, this.f_614);
         GL11.glViewport(this.f_627[0], this.f_627[1], this.f_627[2], this.f_627[3]);
         GlStateManager._viewport(this.f_627[0], this.f_627[1], this.f_627[2], this.f_627[3]);
         GL20.glUseProgram(this.f_615);
         GL30.glBindVertexArray(this.f_616);
         GL15.glBindBuffer(f_641, this.f_617);
         Util149.m_1246(3042, this.f_619);
         Util149.m_1246(2929, this.f_620);
         Util149.m_1246(2884, this.f_621);
         Util149.m_1246(3089, this.f_622);
         if (this.f_623) {
            GL11.glEnable(f_642);
         } else {
            GL11.glDisable(f_643);
         }

         GL11.glDepthMask(this.f_624);
         GlStateManager._depthMask(this.f_624);
         GL11.glColorMask(this.f_628[0], this.f_628[1], this.f_628[2], this.f_628[3]);
         GlStateManager._colorMask(this.f_628[0], this.f_628[1], this.f_628[2], this.f_628[3]);

         for (int var1 = 0; var1 < 3; var1++) {
            Util149.m_430(f_644 + var1);
            Util114.m_2012(this.f_625[var1]);
            GL33.glBindSampler(var1, this.f_626[var1]);
         }

         Util149.m_430(this.f_618);
      }
   }
}
