package su.energyclient.render;

import java.io.IOException;
import java.io.InputStream;
import java.nio.FloatBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryStack;
import su.energyclient.util.Util114;

public class RenderUtil11 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final int f_1772;
   private final Map<String, Integer> f_1773 = new HashMap<>();
   private int f_1774;
   private static final int f_1775 = 35633;
   private static final int f_1776 = 35632;
   private static final int f_1777 = 35714;
   private static final int f_1778 = 35713;
   private static final int f_1779 = 35725;

   public void m_366(String var1, float var2, float var3) {
      Util114.m_811();
      GL20.glUniform2f(this.m_1419(var1), var2, var3);
   }

   public void m_233() {
      GL20.glUseProgram(this.f_1774);
   }

   public void m_1054(String var1, Vector3f var2) {
      Util114.m_811();
      GL20.glUniform3f(this.m_1419(var1), var2.x, var2.y, var2.z);
   }

   public void m_2024(String var1, float var2) {
      Util114.m_811();
      GL20.glUniform1f(this.m_1419(var1), var2);
   }

   public void m_2989() {
      this.f_1774 = GL11.glGetInteger(f_1779);
      GL20.glUseProgram(this.f_1772);
   }

   private String m_1363(String var1) throws IOException {
      String var3;
      try (InputStream var2 = RenderUtil11.class.getResourceAsStream(var1)) {
         if (var2 == null) {
            throw new IOException("Shader file not found: " + var1);
         }

         var3 = new String(var2.readAllBytes(), StandardCharsets.UTF_8);
      }

      return var3;
   }

   public void m_3397(String var1, boolean var2) {
      this.m_3372(var1, var2 ? 1 : 0);
   }

   private int m_3422(String var1, int var2) throws Exception {
      int var3 = GL20.glCreateShader(var2);
      if (var3 == 0) {
         throw new Exception("Error creating shader of type " + var2);
      } else {
         GL20.glShaderSource(var3, var1);
         GL20.glCompileShader(var3);
         if (GL20.glGetShaderi(var3, f_1778) == 0) {
            throw new Exception("Error compiling shader type " + var2 + ": " + GL20.glGetShaderInfoLog(var3, 1024));
         } else {
            return var3;
         }
      }
   }

   public void m_3372(String var1, int var2) {
      Util114.m_811();
      GL20.glUniform1i(this.m_1419(var1), var2);
   }

   public void m_2005(String var1, Vector2f var2) {
      Util114.m_811();
      GL20.glUniform2f(this.m_1419(var1), var2.x, var2.y);
   }

   public RenderUtil11(String var1, String var2) {
      int var3 = GL20.glCreateProgram();
      int var4 = 0;
      int var5 = 0;

      try {
         String var6 = "/assets/energy/shaders/core/" + var1 + "/";
         String var7 = this.m_1363(var6 + var2 + ".vsh");
         String var8 = this.m_1363(var6 + var2 + ".fsh");
         var4 = this.m_3422(var7, f_1775);
         var5 = this.m_3422(var8, f_1776);
         GL20.glAttachShader(var3, var4);
         GL20.glAttachShader(var3, var5);
         GL20.glLinkProgram(var3);
         if (GL20.glGetProgrami(var3, f_1777) == 0) {
            throw new IllegalStateException("Shader linking failed: " + GL20.glGetProgramInfoLog(var3));
         }
      } catch (Exception var12) {
         GL20.glDeleteProgram(var3);
         throw new RuntimeException("Failed to create shader: " + var2, var12);
      } finally {
         if (var4 != 0) {
            GL20.glDeleteShader(var4);
         }

         if (var5 != 0) {
            GL20.glDeleteShader(var5);
         }
      }

      this.f_1772 = var3;
   }

   public void m_3277(String var1, boolean var2, Matrix4f var3) {
      Util114.m_811();
      MemoryStack var4 = MemoryStack.stackPush();

      try {
         FloatBuffer var5 = var4.mallocFloat(16);
         var3.get(var5);
         GL20.glUniformMatrix4fv(this.m_1419(var1), var2, var5);
      } catch (Throwable var8) {
         if (var4 != null) {
            try {
               var4.close();
            } catch (Throwable var7) {
               var8.addSuppressed(var7);
            }
         }

         throw var8;
      }

      if (var4 != null) {
         var4.close();
      }
   }

   private int m_1419(String var1) {
      return this.f_1773.computeIfAbsent(var1, var1x -> GL20.glGetUniformLocation(this.f_1772, var1x));
   }
}
