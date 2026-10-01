package su.energyclient.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.GlTexture;
import net.minecraft.client.texture.GlTextureView;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL33;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil9;
import su.energyclient.util.math.MathUtil6;

public final class Util98 implements AutoCloseable {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final RenderUtil9 f_6068;
   private final Map<String, MathUtil6> f_6069 = new LinkedHashMap<>();
   private final Set<String> l = new HashSet<>();
   private final Map<String, Integer> f_6070 = new LinkedHashMap<>();
   private final Map<String, Object> f_6071 = new LinkedHashMap<>();
   private final Map<String, Integer> f_6072 = new LinkedHashMap<>();
   private int f_6073;
   private static final String f_6074 = "ModelViewMat";
   private static final String f_6075 = "ProjMat";
   private static final String f_6076 = "ColorModulator";
   private static final String f_6077 = "ModelViewMat";
   private static final String f_6078 = "ProjMat";
   private static final String f_6079 = "ColorModulator";
   private static final int f_6080 = 33984;
   private static final int f_6081 = 33984;
   private static final String f_6082 = "vertex";
   private static final String f_6083 = ".vsh";
   private static final String f_6084 = "fragment";
   private static final String f_6085 = ".fsh";
   private static final int f_6086 = 35633;
   private static final int f_6087 = 35632;
   private static final int f_6088 = 35714;
   private static final int f_6089 = 32768;
   private static final String f_6090 = "uniforms";
   private static final String f_6091 = "samplers";
   private static final String f_6092 = "blit_screen";
   private static final String f_6093 = "InSampler";
   private static final String f_6094 = "Sampler0";
   private static final String f_6095 = "name";
   private static final String f_6096 = "type";
   private static final String f_6097 = "type";
   private static final String f_6098 = "float";
   private static final String f_6099 = "count";
   private static final String f_6100 = "count";
   private static final String f_6101 = "float";
   private static final String f_6102 = "int";
   private static final String f_6103 = "values";
   private static final String f_6104 = "values";
   private static final String f_6105 = "name";
   private static final int f_6106 = 35713;
   private static final int f_6107 = 32768;
   private static final String f_6108 = "blit_screen";
   private static final String f_6109 = new String(
      "#version 150\nin vec3 Position;\nout vec2 texCoord;\nvoid main() { texCoord = Position.xy; gl_Position = vec4(Position.xy * 2.0 - 1.0, 0.0, 1.0); }\n"
   );
   private static final String f_6110 = "position_tex_color";
   private static final String f_6111 = new String(
      "#version 150\nin vec3 Position; in vec2 UV0; in vec4 Color;\nuniform mat4 ModelViewMat; uniform mat4 ProjMat;\nout vec2 texCoord; out vec4 vertexColor;\nvoid main() { texCoord=UV0; vertexColor=Color; gl_Position=ProjMat*ModelViewMat*vec4(Position,1.0); }\n"
   );
   private static final String f_6112 = "position_color";
   private static final String f_6113 = new String(
      "#version 150\nin vec3 Position; in vec4 Color;\nuniform mat4 ModelViewMat; uniform mat4 ProjMat;\nout vec4 vertexColor;\nvoid main() { vertexColor=Color; gl_Position=ProjMat*ModelViewMat*vec4(Position,1.0); }\n"
   );
   private static final String f_6114 = new String(
      "#version 150\nin vec3 Position; in vec4 Color;\nuniform mat4 ModelViewMat; uniform mat4 ProjMat;\nout vec4 vertexColor;\nvoid main() { vertexColor=Color; gl_Position=ProjMat*ModelViewMat*vec4(Position,1.0); }\n"
   );
   private static final String f_6115 = "blit_screen";
   private static final String f_6116 = new String(
      "#version 150\nuniform sampler2D InSampler; in vec2 texCoord; out vec4 fragColor;\nvoid main() { fragColor = texture(InSampler, texCoord); }\n"
   );
   private static final String f_6117 = "position_tex_color";
   private static final String f_6118 = new String(
      "#version 150\nuniform sampler2D Sampler0; uniform vec4 ColorModulator;\nin vec2 texCoord; in vec4 vertexColor; out vec4 fragColor;\nvoid main() { fragColor=texture(Sampler0,texCoord)*vertexColor*ColorModulator; }\n"
   );
   private static final String f_6119 = new String(
      "#version 150\nuniform vec4 ColorModulator; in vec4 vertexColor; out vec4 fragColor;\nvoid main() { fragColor=vertexColor*ColorModulator; }\n"
   );

   @Override
   public void close() {
      if (this.f_6073 != 0) {
         RenderUtil12.m_1388(this.f_6073);
         GL20.glDeleteProgram(this.f_6073);
         this.f_6073 = 0;
      }

      this.f_6069.values().forEach(MathUtil6::close);
      this.f_6069.clear();
      this.f_6071.clear();
      this.f_6072.clear();
      this.f_6070.clear();
      this.l.clear();
   }

   public int m_1888(String var1) {
      this.m_506();
      Integer var2 = this.f_6070.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         int var3 = GL20.glGetAttribLocation(this.f_6073, var1);
         this.f_6070.put(var1, var3);
         return var3;
      }
   }

   private JsonObject m_571() {
      Identifier var1 = this.f_6068.configId();
      String var2 = "/assets/" + var1.getNamespace() + "/shaders/" + var1.getPath() + ".json";

      try {
         JsonObject var4;
         try (InputStream var3 = Util98.class.getResourceAsStream(var2)) {
            if (var3 == null) {
               return null;
            }

            var4 = JsonParser.parseReader(new InputStreamReader(var3, StandardCharsets.UTF_8)).getAsJsonObject();
         }

         return var4;
      } catch (IOException var8) {
         throw new IllegalStateException("Cannot read shader config " + var1, var8);
      }
   }

   private int m_2517(int var1, String var2) {
      int var3 = GL20.glCreateShader(var1);
      GL20.glShaderSource(var3, var2);
      GL20.glCompileShader(var3);
      if (GL20.glGetShaderi(var3, f_6106) == 0) {
         String var4 = GL20.glGetShaderInfoLog(var3, f_6107);
         GL20.glDeleteShader(var3);
         throw new IllegalStateException("Cannot compile legacy shader " + this.f_6068.configId() + ": " + var4);
      } else {
         return var3;
      }
   }

   private String m_3780(String var1) {
      if (var1.endsWith(f_6115)) {
         return f_6116;
      } else {
         return var1.endsWith(f_6117) ? f_6118 : f_6119;
      }
   }

   private String m_911(Identifier var1, String var2) {
      String var3 = "/assets/" + var1.getNamespace() + "/shaders/" + var1.getPath() + var2;

      try {
         String var5;
         try (InputStream var4 = Util98.class.getResourceAsStream(var3)) {
            if (var4 == null) {
               throw new IllegalStateException("Missing shader source " + var3);
            }

            var5 = new String(var4.readAllBytes(), StandardCharsets.UTF_8);
         }

         return var5;
      } catch (IOException var9) {
         throw new IllegalStateException("Cannot read shader source " + var3, var9);
      }
   }

   void m_548(Matrix4f var1, Matrix4f var2, float[] var3) {
      MathUtil6 var4 = this.m_1335(f_6077);
      if (var4 != null) {
         var4.m_23(var1);
      }

      MathUtil6 var5 = this.m_1335(f_6078);
      if (var5 != null) {
         var5.m_23(var2);
      }

      MathUtil6 var6 = this.m_1335(f_6079);
      if (var6 != null) {
         var6.m_41(var3[0], var3[1], var3[2], var3[3]);
      }
   }

   public static int m_1819(Object var0) {
      if (var0 == null) {
         return 0;
      } else if (var0 instanceof Integer var9) {
         return var9;
      } else if (var0 instanceof GlTexture var8) {
         return var8.getGlId();
      } else if (var0 instanceof GlTextureView var7) {
         return var7.texture().getGlId();
      } else if (var0 instanceof GpuTexture var1 && var1 instanceof GlTexture var10) {
         return var10.getGlId();
      } else if (var0 instanceof GpuTextureView var4 && var4.texture() instanceof GlTexture var2) {
         return var2.getGlId();
      } else if (var0 instanceof AbstractTexture var6) {
         return ((GlTexture)var6.getGlTexture()).getGlId();
      } else if (var0 instanceof Identifier var5) {
         return ((GlTexture)MinecraftClient.getInstance().getTextureManager().getTexture(var5).getGlTexture()).getGlId();
      } else {
         throw new IllegalArgumentException("Unsupported OpenGL texture handle: " + var0.getClass().getName());
      }
   }

   private Identifier m_3308(String var1) {
      return var1.indexOf(58) >= 0 ? Identifier.of(var1) : Identifier.of(this.f_6068.configId().getNamespace(), var1);
   }

   void m_701(Object[] var1) {
      this.m_506();
      GL20.glUseProgram(this.f_6073);
      int var2 = 0;

      for (Entry var4 : this.f_6072.entrySet()) {
         Object var5 = this.f_6071.get(var4.getKey());
         if (var5 == null && var2 < var1.length) {
            var5 = var1[var2];
         }

         GL33.glBindSampler(var2, 0);
         GlStateManager._activeTexture(f_6080 + var2);
         int var6 = m_1819(var5);
         GL11.glBindTexture(3553, var6);
         GlStateManager._bindTexture(var6);
         MathUtil6.m_2524((Integer)var4.getValue(), var2);
         var2++;
      }

      GlStateManager._activeTexture(f_6081);
      this.f_6069.values().forEach(MathUtil6::m_1707);
   }

   private void m_506() {
      if (this.f_6073 == 0) {
         Util114.m_811();
         JsonObject var1 = this.m_571();
         String var2;
         String var3;
         if (var1 == null) {
            var2 = this.m_2661(this.f_6068.configId().getPath());
            var3 = this.m_3780(this.f_6068.configId().getPath());
         } else {
            var2 = this.m_911(this.m_3308(var1.get(f_6082).getAsString()), f_6083);
            var3 = this.m_911(this.m_3308(var1.get(f_6084).getAsString()), f_6085);
         }

         int var4 = this.m_2517(f_6086, var2);
         int var5 = this.m_2517(f_6087, var3);
         int var6 = GL20.glCreateProgram();
         GL20.glAttachShader(var6, var4);
         GL20.glAttachShader(var6, var5);
         VertexFormat var7 = this.f_6068.vertexFormat();

         for (int var8 = 0; var8 < var7.getElementAttributeNames().size(); var8++) {
            GL20.glBindAttribLocation(var6, var8, (CharSequence)var7.getElementAttributeNames().get(var8));
         }

         GL20.glLinkProgram(var6);
         GL20.glDeleteShader(var4);
         GL20.glDeleteShader(var5);
         if (GL20.glGetProgrami(var6, f_6088) == 0) {
            String var10 = GL20.glGetProgramInfoLog(var6, f_6089);
            GL20.glDeleteProgram(var6);
            throw new IllegalStateException("Cannot link legacy shader " + this.f_6068.configId() + ": " + var10);
         } else {
            this.f_6073 = var6;
            if (var1 != null) {
               this.m_3021(var1.getAsJsonArray(f_6090));
               this.m_3693(var1.getAsJsonArray(f_6091));
            } else {
               String var9 = this.f_6068.configId().getPath().endsWith(f_6092) ? f_6093 : f_6094;
               this.m_2988(var9);
            }
         }
      }
   }

   public int m_4047() {
      this.m_506();
      return this.f_6073;
   }

   private String m_2661(String var1) {
      if (var1.endsWith(f_6108)) {
         return f_6109;
      } else if (var1.endsWith(f_6110)) {
         return f_6111;
      } else {
         return var1.endsWith(f_6112) ? f_6113 : f_6114;
      }
   }

   private void m_2988(String var1) {
      int var2 = GL20.glGetUniformLocation(this.f_6073, var1);
      if (var2 >= 0) {
         this.f_6072.put(var1, var2);
      }
   }

   Util98(RenderUtil9 var1) {
      this.f_6068 = var1;
   }

   private void m_3693(JsonArray var1) {
      if (var1 != null) {
         for (JsonElement var3 : var1) {
            this.m_2988(var3.getAsJsonObject().get(f_6105).getAsString());
         }
      }
   }

   public RenderUtil9 m_589() {
      return this.f_6068;
   }

   private void m_3021(JsonArray var1) {
      if (var1 != null) {
         for (JsonElement var3 : var1) {
            JsonObject var4 = var3.getAsJsonObject();
            String var5 = var4.get(f_6095).getAsString();
            int var6 = GL20.glGetUniformLocation(this.f_6073, var5);
            if (var6 >= 0) {
               String var7 = var4.has(f_6096) ? var4.get(f_6097).getAsString() : f_6098;
               int var8 = var4.has(f_6099) ? var4.get(f_6100).getAsInt() : 1;
               int var9 = MathUtil6.m_1067(var7);
               if ((var7.equals(f_6101) || var7.equals(f_6102)) && var8 > 1 && var8 <= 4) {
                  var9 += var8 - 1;
               }

               MathUtil6 var10 = new MathUtil6(var5, var9, var8);
               var10.m_3843(var6);
               if (var4.has(f_6103)) {
                  JsonArray var11 = var4.getAsJsonArray(f_6104);
                  float[] var12 = new float[var11.size()];

                  for (int var13 = 0; var13 < var12.length; var13++) {
                     var12[var13] = var11.get(var13).getAsFloat();
                  }

                  if (var9 > 3) {
                     if (var12.length == 16) {
                        var10.m_23(new Matrix4f().set(var12));
                     } else {
                        var10.m_39(var12);
                     }
                  } else {
                     int[] var15 = new int[Math.max(1, Math.min(4, var12.length))];

                     for (int var14 = 0; var14 < var15.length; var14++) {
                        var15[var14] = (int)var12[var14];
                     }

                     switch (var15.length) {
                        case 1:
                           var10.m_55(var15[0]);
                           break;
                        case 2:
                           var10.m_20(var15[0], var15[1]);
                           break;
                        case 3:
                           var10.m_49(var15[0], var15[1], var15[2]);
                           break;
                        default:
                           var10.m_27(var15[0], var15[1], var15[2], var15[3]);
                     }
                  }
               }

               this.f_6069.put(var5, var10);
            }
         }
      }
   }

   public void m_3726(String var1, Object var2) {
      this.f_6071.put(var1, var2);
   }

   public MathUtil6 m_1335(String var1) {
      this.m_506();
      MathUtil6 var2 = this.f_6069.get(var1);
      if (var2 != null) {
         return var2;
      } else if (this.l.contains(var1)) {
         return null;
      } else {
         int var3 = GL20.glGetUniformLocation(this.f_6073, var1);
         if (var3 < 0) {
            this.l.add(var1);
            return null;
         } else {
            byte var4 = switch (var1) {
               case f_6074, f_6075 -> 10;
               case f_6076 -> 7;
               default -> 4;
            };

            byte var5 = switch (var4) {
               case 7 -> 4;
               case 10 -> 16;
               default -> 1;
            };
            MathUtil6 var7 = new MathUtil6(var1, var4, var5);
            var7.m_3843(var3);
            this.f_6069.put(var1, var7);
            return var7;
         }
      }
   }
}
