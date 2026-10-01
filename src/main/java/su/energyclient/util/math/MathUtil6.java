package su.energyclient.util.math;

import java.nio.FloatBuffer;
import java.util.Arrays;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryStack;

public class MathUtil6 extends MathUtil8 implements AutoCloseable {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final String f_6120;
   private final int f_6121;
   private final int f_6122;
   private int f_6123 = -1;
   private int[] f_6124;
   private float[] f_6125;
   private Matrix4f f_6126;
   private Matrix3f f_6127;
   private boolean f_6128 = true;
   private static final String f_6129 = "int";
   private static final String f_6130 = "ivec2";
   private static final String f_6131 = "ivec3";
   private static final String f_6132 = "ivec4";
   private static final String f_6133 = "float";
   private static final String f_6134 = "vec2";
   private static final String f_6135 = "vec3";
   private static final String f_6136 = "vec4";
   private static final String f_6137 = "matrix2x2";
   private static final String f_6138 = "matrix3x3";
   private static final String f_6139 = "matrix4x4";

   private int m_2810(int var1) {
      return this.f_6124[Math.min(var1, this.f_6124.length - 1)];
   }

   private float m_3316(int var1) {
      return this.f_6125[Math.min(var1, this.f_6125.length - 1)];
   }

   @Override
   public void m_55(int var1) {
      this.m_574(var1, 0, 0, 0, 1);
   }

   public MathUtil6(String var1, int var2, int var3) {
      this.f_6120 = var1;
      this.f_6121 = var2;
      this.f_6122 = var3;
   }

   public static int m_1991(int var0, CharSequence var1) {
      return GL20.glGetUniformLocation(var0, var1);
   }

   @Override
   public void m_51(float var1, float var2, float var3, float var4) {
      this.m_3573(var1, var2, var3, var4, 4);
   }

   @Override
   public void m_34(int var1, int var2, int var3, int var4) {
      this.m_574(var1, var2, var3, var4, 4);
   }

   public String m_3983() {
      return this.f_6120;
   }

   public void m_1707() {
      if (this.f_6123 >= 0 && this.f_6128) {
         if (this.f_6121 == 10 && this.f_6126 != null) {
            MemoryStack var8 = MemoryStack.stackPush();

            try {
               FloatBuffer var9 = var8.mallocFloat(16);
               this.f_6126.get(var9);
               GL20.glUniformMatrix4fv(this.f_6123, false, var9);
            } catch (Throwable var7) {
               if (var8 != null) {
                  try {
                     var8.close();
                  } catch (Throwable var5) {
                     var7.addSuppressed(var5);
                  }
               }

               throw var7;
            }

            if (var8 != null) {
               var8.close();
            }

            this.f_6128 = false;
         } else if (this.f_6121 == 9 && this.f_6127 != null) {
            MemoryStack var1 = MemoryStack.stackPush();

            try {
               FloatBuffer var2 = var1.mallocFloat(9);
               this.f_6127.get(var2);
               GL20.glUniformMatrix3fv(this.f_6123, false, var2);
            } catch (Throwable var6) {
               if (var1 != null) {
                  try {
                     var1.close();
                  } catch (Throwable var4) {
                     var6.addSuppressed(var4);
                  }
               }

               throw var6;
            }

            if (var1 != null) {
               var1.close();
            }

            this.f_6128 = false;
         } else if (this.f_6124 != null) {
            switch (this.f_6121) {
               case 0:
                  GL20.glUniform1i(this.f_6123, this.m_2810(0));
                  break;
               case 1:
                  GL20.glUniform2i(this.f_6123, this.m_2810(0), this.m_2810(1));
                  break;
               case 2:
                  GL20.glUniform3i(this.f_6123, this.m_2810(0), this.m_2810(1), this.m_2810(2));
                  break;
               case 3:
                  GL20.glUniform4i(this.f_6123, this.m_2810(0), this.m_2810(1), this.m_2810(2), this.m_2810(3));
            }

            this.f_6128 = false;
         } else {
            if (this.f_6125 != null) {
               switch (this.f_6121) {
                  case 4:
                     GL20.glUniform1f(this.f_6123, this.m_3316(0));
                     break;
                  case 5:
                     GL20.glUniform2f(this.f_6123, this.m_3316(0), this.m_3316(1));
                     break;
                  case 6:
                     GL20.glUniform3f(this.f_6123, this.m_3316(0), this.m_3316(1), this.m_3316(2));
                     break;
                  case 7:
                     GL20.glUniform4f(this.f_6123, this.m_3316(0), this.m_3316(1), this.m_3316(2), this.m_3316(3));
                     break;
                  case 8:
                     GL20.glUniformMatrix2fv(this.f_6123, false, this.f_6125);
                     break;
                  case 9:
                     GL20.glUniformMatrix3fv(this.f_6123, false, this.f_6125);
                     break;
                  case 10:
                     GL20.glUniformMatrix4fv(this.f_6123, false, this.f_6125);
               }
            }

            this.f_6128 = false;
         }
      }
   }

   private void m_251(float[] var1) {
      if (this.f_6125 == null || !Arrays.equals(this.f_6125, var1)) {
         if (this.f_6125 != null && this.f_6125.length == var1.length) {
            System.arraycopy(var1, 0, this.f_6125, 0, var1.length);
         } else {
            this.f_6125 = Arrays.copyOf(var1, var1.length);
         }

         this.f_6124 = null;
         this.f_6126 = null;
         this.f_6127 = null;
         this.f_6128 = true;
      }
   }

   private void m_3573(float var1, float var2, float var3, float var4, int var5) {
      boolean var6 = this.f_6125 != null
         && this.f_6125.length == var5
         && Float.floatToIntBits(this.f_6125[0]) == Float.floatToIntBits(var1)
         && (var5 < 2 || Float.floatToIntBits(this.f_6125[1]) == Float.floatToIntBits(var2))
         && (var5 < 3 || Float.floatToIntBits(this.f_6125[2]) == Float.floatToIntBits(var3))
         && (var5 < 4 || Float.floatToIntBits(this.f_6125[3]) == Float.floatToIntBits(var4));
      if (!var6) {
         if (this.f_6125 == null || this.f_6125.length != var5) {
            this.f_6125 = new float[var5];
         }

         this.f_6125[0] = var1;
         if (var5 > 1) {
            this.f_6125[1] = var2;
         }

         if (var5 > 2) {
            this.f_6125[2] = var3;
         }

         if (var5 > 3) {
            this.f_6125[3] = var4;
         }

         this.f_6124 = null;
         this.f_6126 = null;
         this.f_6127 = null;
         this.f_6128 = true;
      }
   }

   @Override
   public void m_46(float var1, float var2, float var3, float var4) {
      this.m_3573(var1, var2, var3, var4, 4);
   }

   @Override
   public void m_27(int var1, int var2, int var3, int var4) {
      this.m_574(var1, var2, var3, var4, 4);
   }

   @Override
   public void close() {
   }

   @Override
   public void m_47(Vector4f var1) {
      this.m_3573(var1.x, var1.y, var1.z, var1.w, 4);
   }

   @Override
   public void m_37(Matrix3f var1) {
      if (this.f_6127 == null || !this.f_6127.equals(var1)) {
         if (this.f_6127 == null) {
            this.f_6127 = new Matrix3f(var1);
         } else {
            this.f_6127.set(var1);
         }

         this.f_6126 = null;
         this.f_6125 = null;
         this.f_6124 = null;
         this.f_6128 = true;
      }
   }

   private void m_574(int var1, int var2, int var3, int var4, int var5) {
      boolean var6 = this.f_6124 != null
         && this.f_6124.length == var5
         && this.f_6124[0] == var1
         && (var5 < 2 || this.f_6124[1] == var2)
         && (var5 < 3 || this.f_6124[2] == var3)
         && (var5 < 4 || this.f_6124[3] == var4);
      if (!var6) {
         if (this.f_6124 == null || this.f_6124.length != var5) {
            this.f_6124 = new int[var5];
         }

         this.f_6124[0] = var1;
         if (var5 > 1) {
            this.f_6124[1] = var2;
         }

         if (var5 > 2) {
            this.f_6124[2] = var3;
         }

         if (var5 > 3) {
            this.f_6124[3] = var4;
         }

         this.f_6125 = null;
         this.f_6126 = null;
         this.f_6127 = null;
         this.f_6128 = true;
      }
   }

   public static void m_2524(int var0, int var1) {
      if (var0 >= 0) {
         GL20.glUniform1i(var0, var1);
      }
   }

   @Override
   public void m_41(float var1, float var2, float var3, float var4) {
      this.m_3573(var1, var2, var3, var4, 4);
   }

   @Override
   public void m_36(Vector3f var1) {
      this.m_3573(var1.x, var1.y, var1.z, 0.0F, 3);
   }

   @Override
   public void m_54(float var1, float var2) {
      this.m_3573(var1, var2, 0.0F, 0.0F, 2);
   }

   @Override
   public void m_33(float var1, float var2, float var3) {
      this.m_3573(var1, var2, var3, 0.0F, 3);
   }

   @Override
   public void m_20(int var1, int var2) {
      this.m_574(var1, var2, 0, 0, 2);
   }

   @Override
   public void m_49(int var1, int var2, int var3) {
      this.m_574(var1, var2, var3, 0, 3);
   }

   public int m_2056() {
      return this.f_6122;
   }

   public int m_1352() {
      return this.f_6121;
   }

   public void m_3843(int var1) {
      this.f_6123 = var1;
      this.f_6128 = true;
   }

   private void m_3965(int[] var1) {
      if (this.f_6124 == null || !Arrays.equals(this.f_6124, var1)) {
         if (this.f_6124 != null && this.f_6124.length == var1.length) {
            System.arraycopy(var1, 0, this.f_6124, 0, var1.length);
         } else {
            this.f_6124 = Arrays.copyOf(var1, var1.length);
         }

         this.f_6125 = null;
         this.f_6126 = null;
         this.f_6127 = null;
         this.f_6128 = true;
      }
   }

   @Override
   public void m_23(Matrix4f var1) {
      if (this.f_6126 == null || !this.f_6126.equals(var1)) {
         if (this.f_6126 == null) {
            this.f_6126 = new Matrix4f(var1);
         } else {
            this.f_6126.set(var1);
         }

         this.f_6127 = null;
         this.f_6125 = null;
         this.f_6124 = null;
         this.f_6128 = true;
      }
   }

   @Override
   public void O(float var1) {
      this.m_3573(var1, 0.0F, 0.0F, 0.0F, 1);
   }

   @Override
   public void m_39(float[] var1) {
      this.m_251(var1);
   }

   public int m_3336() {
      return this.f_6123;
   }

   public static int m_1067(String var0) {
      return switch (var0) {
         case f_6129 -> 0;
         case f_6130 -> 1;
         case f_6131 -> 2;
         case f_6132 -> 3;
         case f_6133 -> 4;
         case f_6134 -> 5;
         case f_6135 -> 6;
         case f_6136 -> 7;
         case f_6137 -> 8;
         case f_6138 -> 9;
         case f_6139 -> 10;
         default -> 4;
      };
   }
}
