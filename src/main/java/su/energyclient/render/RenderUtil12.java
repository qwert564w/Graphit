package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import com.mojang.blaze3d.vertex.VertexFormatElement.Type;
import com.mojang.blaze3d.vertex.VertexFormatElement.Usage;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.BuiltBuffer.DrawParameters;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryUtil;
import su.energyclient.util.Util114;
import su.energyclient.util.Util98;

public final class RenderUtil12 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_1741 = 1024;
   private static int f_1742;
   private static int f_1743;
   private static int I;
   private static final Map<RenderUtil12.L0tRYq9YgxiisStj, Integer> f_1744 = new HashMap<>();
   private static final int f_1745 = 35725;
   private static final int f_1746 = 35725;
   private static final int f_1747 = 34962;
   private static final int f_1748 = 34962;
   private static final int f_1749 = 35040;
   private static final int f_1750 = 34962;
   private static final int f_1751 = 34962;
   private static final int f_1752 = 34963;
   private static final int f_1753 = 34962;
   private static final int f_1754 = 34963;
   private static final int f_1755 = 34963;
   private static final int f_1756 = 35044;

   private static int I(int var0, VertexFormat var1, Util98 var2) {
      RenderUtil12.L0tRYq9YgxiisStj var3 = new RenderUtil12.L0tRYq9YgxiisStj(var0, var1);
      Integer var4 = f_1744.get(var3);
      if (var4 != null) {
         return var4;
      } else {
         int var5 = GL30.glGenVertexArrays();
         GL30.glBindVertexArray(var5);
         GL15.glBindBuffer(f_1751, f_1742);
         GL15.glBindBuffer(f_1752, f_1743);

         for (int var6 = 0; var6 < var1.getElements().size(); var6++) {
            VertexFormatElement var7 = (VertexFormatElement)var1.getElements().get(var6);
            String var8 = (String)var1.getElementAttributeNames().get(var6);
            int var9 = var2 != null ? var2.m_1888(var8) : GL20.glGetAttribLocation(var0, var8);
            if (var9 >= 0) {
               GL20.glEnableVertexAttribArray(var9);
               GL20.glVertexAttribPointer(var9, var7.count(), I(var7.type()), I(var7), var1.getVertexSize(), var1.getOffset(var7));
            }
         }

         GL30.glBindVertexArray(0);
         GL15.glBindBuffer(f_1753, 0);
         f_1744.put(var3, var5);
         return var5;
      }
   }

   public static void I(BuiltBuffer var0) {
      Util114.m_811();
      int var1 = GL11.glGetInteger(f_1745);
      Util98 var2 = Util114.m_4018();
      int var3 = var1;

      try {
         Util114.m_2606();
         if (var2 != null) {
            var3 = var2.m_4047();
         }

         I(var0, var3, var2);
      } finally {
         if (var1 != var3) {
            GL20.glUseProgram(var1);
         }
      }
   }

   private RenderUtil12() {
   }

   public static void m_1546(BuiltBuffer var0) {
      Util114.m_811();
      I(var0, GL11.glGetInteger(f_1746), null);
   }

   private static void m_807() {
      if (f_1742 == 0) {
         f_1742 = GL15.glGenBuffers();
      }

      if (f_1743 == 0) {
         f_1743 = GL15.glGenBuffers();
      }
   }

   private static void m_1491(int var0) {
      if (var0 > I) {
         int var1 = Math.max(1024, I);

         while (var1 < var0) {
            int var2 = var1 << 1;
            if (var2 <= var1) {
               var1 = var0;
               break;
            }

            var1 = var2;
         }

         IntBuffer var8 = MemoryUtil.memAllocInt(Math.multiplyExact(var1, 6));

         try {
            for (int var3 = 0; var3 < var1; var3++) {
               int var4 = var3 * 4;
               var8.put(var4).put(var4 + 1).put(var4 + 2);
               var8.put(var4 + 2).put(var4 + 3).put(var4);
            }

            var8.flip();
            GL15.glBindBuffer(f_1754, f_1743);
            GL15.glBufferData(f_1755, var8, f_1756);
            I = var1;
         } finally {
            MemoryUtil.memFree(var8);
         }
      }
   }

   private static int I(DrawMode var0) {
      return switch (var0) {
         case LINES, DEBUG_LINES -> 1;
         case DEBUG_LINE_STRIP -> 3;
         case POINTS -> 0;
         case TRIANGLES -> 4;
         case TRIANGLE_STRIP -> 5;
         case TRIANGLE_FAN -> 6;
         case QUADS -> 4;
         default -> throw new MatchException(null, null);
      };
   }

   private static boolean I(VertexFormatElement var0) {
      return var0.usage() == Usage.COLOR || var0.usage() == Usage.NORMAL;
   }

   public static void m_1388(int var0) {
      Util114.m_811();
      Iterator var1 = f_1744.entrySet().iterator();

      while (var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         if (((RenderUtil12.L0tRYq9YgxiisStj)var2.getKey()).program() == var0) {
            GL30.glDeleteVertexArrays((Integer)var2.getValue());
            var1.remove();
         }
      }
   }

   private static void I(BuiltBuffer var0, int var1, Util98 var2) {
      BuiltBuffer var3 = var0;

      try {
         m_807();
         DrawParameters var4 = var0.getDrawParameters();
         VertexFormat var5 = var4.format();
         int var6 = I(var1, var5, var2);
         GL30.glBindVertexArray(var6);
         GL15.glBindBuffer(f_1747, f_1742);
         GL15.glBufferData(f_1748, var0.getBuffer(), f_1749);
         if (var4.mode() == DrawMode.QUADS) {
            int var7 = var4.vertexCount() / 4;
            m_1491(var7);
            GL11.glDrawElements(4, var7 * 6, 5125, 0L);
         } else {
            GL11.glDrawArrays(I(var4.mode()), 0, var4.vertexCount());
         }

         GL30.glBindVertexArray(0);
         GL15.glBindBuffer(f_1750, 0);
      } catch (Throwable var9) {
         if (var0 != null) {
            try {
               var3.close();
            } catch (Throwable var8) {
               var9.addSuppressed(var8);
            }
         }

         throw var9;
      }

      if (var0 != null) {
         var0.close();
      }
   }

   public static void m_692() {
      Util114.m_811();

      for (int var1 : f_1744.values()) {
         GL30.glDeleteVertexArrays(var1);
      }

      f_1744.clear();
      if (f_1742 != 0) {
         GL15.glDeleteBuffers(f_1742);
      }

      if (f_1743 != 0) {
         GL15.glDeleteBuffers(f_1743);
      }

      f_1742 = 0;
      f_1743 = 0;
      I = 0;
   }

   private static int I(Type var0) {
      return switch (var0) {
         case FLOAT -> 5126;
         case UBYTE -> 5121;
         case BYTE -> 5120;
         case USHORT -> 5123;
         case SHORT -> 5122;
         case UINT -> 5125;
         case INT -> 5124;
         default -> throw new MatchException(null, null);
      };
   }

   private record L0tRYq9YgxiisStj(int program, VertexFormat format) {
   }
}
