package su.energyclient.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Supplier;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import su.energyclient.QuickImports;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil6;
import su.energyclient.util.math.MathUtil6;
import su.energyclient.util.math.MathUtil8;

public class Util134 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public Identifier f_10569;
   public Framebuffer l;
   public HashMap<String, Framebuffer> f_10570 = new HashMap<>();
   public ArrayList<Framebuffer> f_10571 = new ArrayList<>();
   public ArrayList<Util134.Inner_9mk4GwN4EhqDDhDZ> f_10572 = new ArrayList<>();
   public Matrix4f f_10573;
   private static final float f_10574 = 0.1F;
   private static final float f_10575 = 1000.0F;
   private static final String f_10576 = "targets";
   private static final String f_10577 = "passes";
   private static final String f_10578 = "minecraft:main";
   private static final String f_10579 = "pass";
   private static final String f_10580 = "name";
   private static final String f_10581 = "intarget";
   private static final String f_10582 = "outtarget";
   private static final String f_10583 = "uniforms";
   private static final String f_10584 = "uniform";
   private static final String f_10585 = "name";
   private static final String f_10586 = "values";
   private static final String f_10587 = "value";

   public void I(JsonElement var1) {
      JsonObject var2 = JsonHelper.asObject(var1, f_10579);
      String var3 = JsonHelper.getString(var2, f_10580);
      String var4 = JsonHelper.getString(var2, f_10581);
      String var5 = JsonHelper.getString(var2, f_10582);
      boolean var6 = false;
      Framebuffer var7 = this.m_432(var4);
      Framebuffer var8 = this.m_432(var5);
      Util134.Inner_9mk4GwN4EhqDDhDZ var9 = this.m_3814(var3, var7, var8, var6);
      JsonArray var10 = JsonHelper.getArray(var2, f_10583, null);
      if (var10 != null) {
         var10.forEach(var2x -> this.m_529(var9, var2x));
      }
   }

   public void m_1144(String var1, int var2, int var3) {
      SimpleFramebuffer var4 = new SimpleFramebuffer(null, var2, var3, true);
      RenderUtil6.m_2715(var4, 0.0F, 0.0F, 0.0F, 0.0F);
      this.f_10570.put(var1, var4);
      if (var2 == this.m_3029() && var3 == this.m_4009()) {
         this.f_10571.add(var4);
      }
   }

   public void m_1485(String var1, Framebuffer var2) {
      Framebuffer var3 = this.f_10570.get(var1);

      for (Util134.Inner_9mk4GwN4EhqDDhDZ var5 : this.f_10572) {
         if (var5.f_11008.equals(var3)) {
            var5.f_11008 = var2;
         }

         if (var5.f_11009.equals(var3)) {
            var5.f_11009 = var2;
         }
      }

      this.f_10570.put(var1, var2);
   }

   public int m_4009() {
      return this.l.textureHeight;
   }

   public Util134.Inner_9mk4GwN4EhqDDhDZ m_3814(String var1, Framebuffer var2, Framebuffer var3, boolean var4) {
      Util134.Inner_9mk4GwN4EhqDDhDZ var5 = new Util134.Inner_9mk4GwN4EhqDDhDZ(var1, var2, var3, var4, this.f_10569.getNamespace());
      this.f_10572.add(var5);
      return var5;
   }

   public Util134(String var1) {
      this(Identifier.ofVanilla(var1));
   }

   public void m_2025(JsonElement var1) {
      if (JsonHelper.isString(var1)) {
         String var2 = var1.getAsString();
         this.m_1144(var2, this.m_3029(), this.m_4009());
      }
   }

   public void m_254() {
      for (Util134.Inner_9mk4GwN4EhqDDhDZ var2 : this.f_10572) {
         var2.m_2751();
      }
   }

   public void m_529(Util134.Inner_9mk4GwN4EhqDDhDZ var1, JsonElement var2) {
      JsonObject var3 = JsonHelper.asObject(var2, f_10584);
      String var4 = JsonHelper.getString(var3, f_10585);
      MathUtil8 var5 = var1.f_11013.m_2888(var4, null);
      if (var5 != null) {
         JsonArray var6 = JsonHelper.getArray(var3, f_10586);
         List var7 = var6.asList().stream().map(var0 -> JsonHelper.asFloat(var0, f_10587)).toList();
         switch (var7.size()) {
            case 1:
               var5.O((Float)var7.get(0));
            case 2:
               var5.m_54((Float)var7.get(0), (Float)var7.get(1));
            case 3:
               var5.m_33((Float)var7.get(0), (Float)var7.get(1), (Float)var7.get(2));
            case 4:
               var5.m_46((Float)var7.get(0), (Float)var7.get(1), (Float)var7.get(2), (Float)var7.get(3));
         }
      }
   }

   public Framebuffer m_432(String var1) {
      return var1.equals(f_10578) ? this.l : this.f_10570.get(var1);
   }

   public Util134(Identifier var1) {
      this.f_10569 = var1;
      this.l = QuickImports.f_5909.getFramebuffer();
      this.m_347();
      this.m_3602(QuickImports.f_5909.getWindow().getFramebufferWidth(), QuickImports.f_5909.getWindow().getFramebufferHeight());
   }

   public void m_347() {
      JsonObject var1 = Util135.O(this.f_10569);
      if (var1 == null) {
         throw new IllegalStateException("Failed to load post effect json: " + this.f_10569);
      } else {
         JsonArray var2 = var1.getAsJsonArray(f_10576);
         JsonArray var3 = var1.getAsJsonArray(f_10577);
         var2.forEach(this::m_2025);
         var3.forEach(this::I);
      }
   }

   public int m_3029() {
      return this.l.textureWidth;
   }

   public void m_4026() {
      float var1 = this.l.textureWidth;
      float var2 = this.l.textureHeight;
      this.f_10573 = new Matrix4f().setOrtho(0.0F, var1, 0.0F, var2, f_10574, f_10575);
   }

   public void m_3602(int var1, int var2) {
      this.m_4026();

      for (Util134.Inner_9mk4GwN4EhqDDhDZ var4 : this.f_10572) {
         var4.f_11014 = this.f_10573;
      }

      for (Framebuffer var6 : this.f_10571) {
         var6.resize(var1, var2);
      }
   }

   public class AUOfBKNWVIeMtDlp {
      public int f_698 = -1;
      private int f_699;
      public String f_700;
      public Identifier f_701;
      public ArrayList<MutablePair<String, Integer>> f_702 = new ArrayList<>();
      public ArrayList<Util134InnerItem> f_703 = new ArrayList<>();
      public HashMap<String, Util134InnerItem> f_704 = new HashMap<>();
      public HashMap<String, MathUtil6> f_705 = new HashMap<>();
      public static final MathUtil8 f_706 = new MathUtil8();
      public static int f_707 = -1;
      private static final String f_708 = "minecraft";
      private static final String f_709 = "vertex";
      private static final String f_710 = "fragment";
      private static final String f_711 = "samplers";
      private static final String f_712 = "attributes";
      private static final String f_713 = "uniforms";
      private static final int f_714 = 35633;
      private static final String f_715 = ".vsh";
      private static final int f_716 = 35632;
      private static final String f_717 = ".fsh";
      private static final int f_718 = 35714;
      private static final int f_719 = 32768;
      private static final String f_720 = "minecraft";
      private static final int f_721 = 35713;
      private static final int f_722 = 32768;
      private static final String f_723 = "sampler";
      private static final String f_724 = "name";
      private static final String f_725 = "attribute";
      private static final String f_726 = "uniform";
      private static final String f_727 = "name";
      private static final String f_728 = "type";
      private static final String f_729 = "count";
      private static final String f_730 = "values";
      private static final String f_731 = "int";
      private static final String f_732 = "float";
      private static final int f_733 = 35725;
      private static final int f_734 = 34016;
      private static final int f_735 = 33984;
      private static final int f_736 = 34016;
      private static final int f_737 = 33984;
      private static final String f_738 = "value";

      public AUOfBKNWVIeMtDlp(String var2, String var3) {
         this.f_700 = var2;
         this.f_701 = Identifier.of(var3, "shaders/program/" + var2 + ".json");
         JsonObject var4 = Util135.O(this.f_701);
         if (var4 == null) {
            throw new IllegalStateException("Failed to load shader program json: " + this.f_701);
         } else {
            String var5 = JsonHelper.getString(var4, f_709);
            String var6 = JsonHelper.getString(var4, f_710);
            JsonArray var7 = JsonHelper.getArray(var4, f_711, null);
            JsonArray var8 = JsonHelper.getArray(var4, f_712, null);
            JsonArray var9 = JsonHelper.getArray(var4, f_713, null);
            if (var7 != null) {
               var7.forEach(this::m_1231);
            }

            if (var8 != null) {
               var8.forEach(this::m_1338);
            }

            if (var9 != null) {
               var9.forEach(this::m_452);
            }

            int var10 = this.m_1091(var5, f_714, f_715, var3);
            int var11 = this.m_1091(var6, f_716, f_717, var3);
            int var12 = GlStateManager.glCreateProgram();
            this.f_698 = var12;
            GlStateManager.glAttachShader(var12, var10);
            GlStateManager.glAttachShader(var12, var11);
            GlStateManager.glLinkProgram(var12);
            if (GlStateManager.glGetProgrami(var12, f_718) == 0) {
               String var17 = GlStateManager.glGetProgramInfoLog(var12, f_719);
               throw new RuntimeException(new IOException("Error while linking " + var5 + " with " + var6 + "\n" + var17));
            } else {
               Iterator var13 = this.f_703.iterator();

               while (var13.hasNext()) {
                  Util134InnerItem var14 = (Util134InnerItem)var13.next();
                  int var15 = MathUtil6.m_1991(var12, var14.f_7088);
                  if (var15 == -1) {
                     System.out.println("no sampler " + var14.f_7088 + " in " + this.f_700 + " program");
                     var13.remove();
                  } else {
                     var14.f_7089 = var15;
                  }
               }

               for (Entry var19 : this.f_705.entrySet()) {
                  int var16 = MathUtil6.m_1991(var12, (CharSequence)var19.getKey());
                  if (var16 == -1) {
                     System.out.println("no uniform  " + (String)var19.getKey() + " in " + this.f_700 + " program");
                  } else {
                     ((MathUtil6)var19.getValue()).m_3843(var16);
                  }
               }
            }
         }
      }

      public int m_3892(String var1, int var2, String var3) {
         return this.m_1091(var1, var2, var3, f_720);
      }

      public void m_1338(JsonElement var1) {
         String var2 = JsonHelper.asString(var1, f_725);
         this.f_702.add(new MutablePair(var2, -1));
      }

      public AUOfBKNWVIeMtDlp(String var2) {
         this(var2, f_708);
      }

      public MathUtil8 m_2888(String var1, MathUtil8 var2) {
         MathUtil6 var3 = this.f_705.get(var1);
         return (MathUtil8)(var3 == null ? var2 : var3);
      }

      public int m_1091(String var1, int var2, String var3, String var4) {
         Identifier var5 = Identifier.of(var4, "shaders/program/" + var1 + var3);

         String var6;
         try (InputStream var7 = Util135.m_2272(var5)) {
            if (var7 == null) {
               throw new IllegalStateException("Failed to load shader source: " + var5);
            }

            var6 = IOUtils.toString(var7, StandardCharsets.UTF_8);
         } catch (IOException var12) {
            throw new RuntimeException(var12);
         }

         int var13 = GlStateManager.glCreateShader(var2);
         GlStateManager.glShaderSource(var13, var6);
         GlStateManager.glCompileShader(var13);
         if (GlStateManager.glGetShaderi(var13, f_721) == 0) {
            String var8 = GlStateManager.glGetShaderInfoLog(var13, f_722);
            System.out.println("Error while compiling " + var1 + " " + var2 + " shader\n" + var8);
            throw new RuntimeException();
         } else {
            return var13;
         }
      }

      public void m_1503(String var1, Supplier<?> var2) {
         Util134InnerItem var3 = this.f_704.get(var1);
         if (var3 != null) {
            var3.f_7090 = var2;
         }
      }

      public MathUtil8 m_3395(String var1) {
         return this.m_2888(var1, f_706);
      }

      public void m_257() {
         this.f_699 = GL11.glGetInteger(f_733);
         GL20.glUseProgram(this.f_698);
         f_707 = this.f_698;
         int var1 = GL11.glGetInteger(f_734);

         for (int var2 = 0; var2 < this.f_703.size(); var2++) {
            Util134InnerItem var3 = this.f_703.get(var2);
            if (var3.f_7090 != null) {
               Object var4 = var3.f_7090.get();
               Util114.m_2836(f_735 + var2);
               Util114.m_2012(var4);
               MathUtil6.m_2524(var3.f_7089, var2);
            }
         }

         GlStateManager._activeTexture(var1);

         for (MathUtil6 var6 : this.f_705.values()) {
            var6.m_1707();
         }
      }

      public void m_452(JsonElement var1) {
         JsonObject var2 = JsonHelper.asObject(var1, f_726);
         String var3 = JsonHelper.getString(var2, f_727);
         String var4 = JsonHelper.getString(var2, f_728);
         int var5 = MathUtil6.m_1067(var4);
         int var6 = JsonHelper.getInt(var2, f_729);
         JsonArray var7 = JsonHelper.getArray(var2, f_730);
         ArrayList var8 = new ArrayList<>(var7.asList().stream().map(var0 -> JsonHelper.asFloat(var0, f_738)).toList());
         if (var6 <= 4 && var8.size() < 4 || var6 > 1 && var8.size() == 1) {
            for (int var9 = 1; var9 < Math.max(var6, 4); var9++) {
               var8.add((Float)var8.getFirst());
            }
         }

         int var13;
         if (var6 <= 1 || var6 > 4 || !var4.equals(f_731) && !var4.equals(f_732)) {
            var13 = 0;
         } else {
            var13 = var6 - 1;
         }

         MathUtil6 var10 = new MathUtil6(var3, var5 + var13, var6);
         if (var5 <= 3) {
            var10.m_34(((Float)var8.get(0)).intValue(), ((Float)var8.get(1)).intValue(), ((Float)var8.get(2)).intValue(), ((Float)var8.get(3)).intValue());
         } else if (var5 <= 7) {
            var10.m_51((Float)var8.get(0), (Float)var8.get(1), (Float)var8.get(2), (Float)var8.get(3));
         } else {
            float[] var11 = new float[var8.size()];

            for (int var12 = 0; var12 < var8.size(); var12++) {
               var11[var12] = (Float)var8.get(var12);
            }

            var10.m_39(var11);
         }

         this.f_705.put(var3, var10);
      }

      public void m_3818() {
         Util114.m_963();
         int var1 = GL11.glGetInteger(f_736);

         for (int var2 = 0; var2 < this.f_703.size(); var2++) {
            Util134InnerItem var3 = this.f_703.get(var2);
            if (var3.f_7090 != null) {
               Util114.m_2836(f_737 + var2);
               Util114.m_2012(0);
            }
         }

         GlStateManager._activeTexture(var1);
         GL20.glUseProgram(this.f_699);
         f_707 = -1;
      }

      public void m_1231(JsonElement var1) {
         JsonObject var2 = JsonHelper.asObject(var1, f_723);
         String var3 = JsonHelper.getString(var2, f_724);
         Util134InnerItem var4 = new Util134InnerItem(this, var3, -1, null);
         this.f_703.add(var4);
         this.f_704.put(var3, var4);
      }
   }

   public class Inner_9mk4GwN4EhqDDhDZ {
      public String f_11007;
      public Framebuffer f_11008;
      public Framebuffer f_11009;
      public boolean f_11010;
      public boolean f_11011 = false;
      public int f_11012;
      public Util134.AUOfBKNWVIeMtDlp f_11013;
      public Matrix4f f_11014 = new Matrix4f();
      public Supplier<Boolean> f_11015 = null;
      public static boolean f_11016 = true;
      private static final String f_11017 = "DiffuseSampler";
      private static final String f_11018 = "ProjMat";
      private static final String f_11019 = "InSize";
      private static final String f_11020 = "OutSize";
      private static final String f_11021 = "ScreenSize";
      private static final float f_11022 = 500.0F;
      private static final float f_11023 = 500.0F;
      private static final float f_11024 = 500.0F;
      private static final float f_11025 = 500.0F;

      public Inner_9mk4GwN4EhqDDhDZ(String var2, Framebuffer var3, Framebuffer var4, boolean var5, String var6) {
         this.f_11007 = var2;
         this.f_11008 = var3;
         this.f_11009 = var4;
         this.f_11010 = var5;
         this.f_11013 = Util134.this.new AUOfBKNWVIeMtDlp(var2, var6);
         if (this.f_11011) {
            this.f_11012 = 9729;
         } else {
            this.f_11012 = 9728;
         }
      }

      public void m_2751() {
         float var1 = this.f_11008.textureWidth;
         float var2 = this.f_11008.textureHeight;
         float var3 = this.f_11009.textureWidth;
         float var4 = this.f_11009.textureHeight;
         float var5 = QuickImports.f_5909.getWindow().getFramebufferWidth();
         float var6 = QuickImports.f_5909.getWindow().getFramebufferHeight();
         RenderUtil6.m_2660(this.f_11008);
         Util114.m_2265(0, 0, (int)var3, (int)var4);
         this.f_11013.m_1503(f_11017, () -> RenderUtil6.m_668(this.f_11008.getColorAttachment()));
         this.f_11013.m_3395(f_11018).m_23(this.f_11014);
         this.f_11013.m_3395(f_11019).m_54(var1, var2);
         this.f_11013.m_3395(f_11020).m_54(var3, var4);
         this.f_11013.m_3395(f_11021).m_54(var5, var6);
         this.f_11013.m_257();
         if (f_11016) {
            RenderUtil6.m_676(this.f_11009);
         }

         RenderUtil6.m_4071(this.f_11009, false);
         Util114.m_3188(519);
         BufferBuilder var7 = Util114.m_2494().begin(DrawMode.QUADS, VertexFormats.POSITION);
         var7.vertex(0.0F, 0.0F, f_11022).vertex(var3, 0.0F, f_11023).vertex(var3, var4, f_11024).vertex(0.0F, var4, f_11025);
         RenderUtil12.m_1546(var7.end());
         Util114.m_3188(515);
         this.f_11013.m_3818();
         RenderUtil6.m_2660(this.f_11009);
         RenderUtil6.m_2129(this.f_11008);
      }
   }
}
