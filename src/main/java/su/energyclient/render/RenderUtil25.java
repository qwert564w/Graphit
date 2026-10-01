package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import org.joml.Matrix4f;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;
import su.energyclient.util.Util7;
import su.energyclient.util.Util71;
import su.energyclient.util.Util77;

public final class RenderUtil25 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final List<RenderUtil25.Inner_31OWsSGzT2jJiJK5> f_1210 = new ArrayList<>();
   private static final List<RenderUtil25.JrUBLgkRUWlcaMFB> f_1211 = new ArrayList<>();
   private static final Map<Identifier, List<RenderUtil25.M1rYPzBPnPSEft1K>> f_1212 = new HashMap<>();
   private static final List<RenderUtil25.f6jjR8U5i2KYUFcs> f_1213 = new ArrayList<>();
   private static Matrix4f f_1214 = null;
   private static boolean f_1215 = false;
   private static BufferBuilder f_1216 = null;
   private static final Map<Identifier, List<RenderUtil25.mEbQe513CN2i8sV3>> f_1217 = new HashMap<>();
   private static final String f_1218 = "Must call begin() before drawing!";
   private static final String f_1219 = "Must call begin() before drawing!";
   private static final String f_1220 = "Must call begin() before drawing!";
   private static final float f_1221 = 0.003921569F;
   private static final float f_1222 = 0.003921569F;
   private static final float f_1223 = 0.003921569F;
   private static final float f_1224 = 0.003921569F;
   private static final float f_1225 = 0.003921569F;
   private static final float f_1226 = 0.003921569F;
   private static final int f_1227 = -16777216;
   private static final int f_1228 = -16777216;
   private static final int f_1229 = -16777216;
   private static final int f_1230 = -16777216;
   private static final int f_1231 = -16777216;
   private static final int f_1232 = -16777216;
   private static final int f_1233 = -16777216;
   private static final int f_1234 = -16777216;
   private static final float f_1235 = 0.003921569F;
   private static final float f_1236 = 0.003921569F;
   private static final float f_1237 = 0.003921569F;
   private static final float f_1238 = 0.003921569F;
   private static final float f_1239 = 0.003921569F;
   private static final float f_1240 = 0.003921569F;
   private static final float f_1241 = 0.003921569F;
   private static final float f_1242 = 0.003921569F;
   private static final float f_1243 = 0.003921569F;
   private static final float f_1244 = 0.003921569F;
   private static final float f_1245 = 0.003921569F;
   private static final float f_1246 = 0.003921569F;
   private static final float f_1247 = 0.003921569F;
   private static final float f_1248 = 0.003921569F;
   private static final float f_1249 = 0.003921569F;
   private static final float f_1250 = 0.003921569F;
   private static final float f_1251 = 0.003921569F;
   private static final float f_1252 = 0.003921569F;
   private static final float f_1253 = 0.003921569F;
   private static final float f_1254 = 0.003921569F;
   private static final float f_1255 = 0.003921569F;
   private static final float f_1256 = 0.1F;
   private static final float f_1257 = 255.0F;
   private static final float f_1258 = 255.0F;
   private static final float f_1259 = 255.0F;
   private static final float f_1260 = 255.0F;
   private static final float f_1261 = 255.0F;
   private static final float f_1262 = 255.0F;
   private static final float f_1263 = 255.0F;
   private static final float f_1264 = 255.0F;
   private static final float f_1265 = 255.0F;
   private static final float f_1266 = 255.0F;
   private static final float f_1267 = 255.0F;
   private static final float f_1268 = 255.0F;
   private static final float f_1269 = 255.0F;
   private static final float f_1270 = 255.0F;
   private static final float f_1271 = 255.0F;
   private static final float f_1272 = 255.0F;
   private static final float f_1273 = 255.0F;
   private static final float f_1274 = 255.0F;
   private static final float f_1275 = 255.0F;
   private static final float f_1276 = 255.0F;
   private static final float f_1277 = 255.0F;
   private static final float f_1278 = 255.0F;
   private static final float f_1279 = 255.0F;
   private static final float f_1280 = 255.0F;
   private static final float f_1281 = 255.0F;
   private static final float f_1282 = 255.0F;
   private static final float f_1283 = 255.0F;
   private static final float f_1284 = 255.0F;
   private static final float f_1285 = 255.0F;
   private static final float f_1286 = 255.0F;
   private static final float f_1287 = 255.0F;
   private static final float f_1288 = 255.0F;
   private static final float f_1289 = 0.003921569F;
   private static final float f_1290 = 0.003921569F;
   private static final float f_1291 = 0.003921569F;
   private static final float f_1292 = 0.003921569F;
   private static final float f_1293 = 0.003921569F;
   private static final float f_1294 = 0.003921569F;
   private static final float f_1295 = 0.003921569F;
   private static final float f_1296 = 0.003921569F;
   private static final float f_1297 = 0.003921569F;
   private static final float f_1298 = 0.003921569F;
   private static final float f_1299 = 0.003921569F;
   private static final float f_1300 = 0.003921569F;
   private static final float f_1301 = 0.003921569F;
   private static final float f_1302 = 0.003921569F;
   private static final float f_1303 = 0.003921569F;
   private static final float f_1304 = 0.003921569F;
   private static final float f_1305 = 0.003921569F;
   private static final String f_1306 = "This is a utility class and cannot be instantiated";

   public static void m_2716(DrawContext var0) {
      if (f_1215) {
         m_2634();
      }

      f_1214 = Util7.m_1924(var0.getMatrices());
      f_1215 = true;
   }

   public static void m_2393(float var0, float var1, float var2, float var3, int var4, int var5, int var6, int var7) {
      if (!f_1215) {
         throw new IllegalStateException(f_1219);
      } else {
         f_1211.add(new RenderUtil25.JrUBLgkRUWlcaMFB(var0, var1, var2, var3, var4, var5, var6, var7));
      }
   }

   public static void m_3752(DrawContext var0, float var1, float var2, float var3, float var4, int var5, int var6, int var7, int var8) {
      if (!Util77.m_2940(var0, var1, var2, var3, var4, var5, var6, var7, var8)) {
         Util114.m_1481();
         Util114.m_542();
         Util114.m_3784(RenderUtil7.f_13885);
         Matrix4f var9 = Util7.m_1924(var0.getMatrices());
         BufferBuilder var10 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         float var11 = (var5 >> 16 & 0xFF) / f_1269;
         float var12 = (var5 >> 8 & 0xFF) / f_1270;
         float var13 = (var5 & 0xFF) / f_1271;
         float var14 = (var5 >> 24 & 0xFF) / f_1272;
         float var15 = (var6 >> 16 & 0xFF) / f_1273;
         float var16 = (var6 >> 8 & 0xFF) / f_1274;
         float var17 = (var6 & 0xFF) / f_1275;
         float var18 = (var6 >> 24 & 0xFF) / f_1276;
         float var19 = (var7 >> 16 & 0xFF) / f_1277;
         float var20 = (var7 >> 8 & 0xFF) / f_1278;
         float var21 = (var7 & 0xFF) / f_1279;
         float var22 = (var7 >> 24 & 0xFF) / f_1280;
         float var23 = (var8 >> 16 & 0xFF) / f_1281;
         float var24 = (var8 >> 8 & 0xFF) / f_1282;
         float var25 = (var8 & 0xFF) / f_1283;
         float var26 = (var8 >> 24 & 0xFF) / f_1284;
         var10.vertex(var9, var1, var2, 0.0F).color(var11, var12, var13, var14);
         var10.vertex(var9, var1, var2 + var4, 0.0F).color(var15, var16, var17, var18);
         var10.vertex(var9, var1 + var3, var2 + var4, 0.0F).color(var19, var20, var21, var22);
         var10.vertex(var9, var1 + var3, var2, 0.0F).color(var23, var24, var25, var26);
         RenderUtil12.I(var10.end());
         Util114.m_963();
      }
   }

   public static void m_605(
      float var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17,
      float var18,
      float var19
   ) {
      f_1216.vertex(f_1214, var0, var1, 0.0F).texture(var8, var9).color(var16, var17, var18, var19);
      f_1216.vertex(f_1214, var2, var3, 0.0F).texture(var10, var11).color(var16, var17, var18, var19);
      f_1216.vertex(f_1214, var4, var5, 0.0F).texture(var12, var13).color(var16, var17, var18, var19);
      f_1216.vertex(f_1214, var6, var7, 0.0F).texture(var14, var15).color(var16, var17, var18, var19);
   }

   private RenderUtil25() {
      throw new UnsupportedOperationException(f_1306);
   }

   private static void m_4064() {
      if (!f_1212.isEmpty()) {
         Util114.m_1481();
         Util114.m_542();
         Util114.m_3784(RenderUtil7.f_13886);
         TextureManager var0 = f_5909.getTextureManager();
         Matrix4f var1 = f_1214;
         float var2 = f_1251;

         for (Entry var4 : f_1212.entrySet()) {
            Identifier var5 = (Identifier)var4.getKey();
            List var6 = (List)var4.getValue();
            if (!var6.isEmpty()) {
               Util114.m_2037(0, var5);
               AbstractTexture var7 = var0.getTexture(var5);
               if (var7 != null) {
                  Util114.m_2012(var7);
               }

               BufferBuilder var8 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
               int var9 = 0;

               for (int var10 = var6.size(); var9 < var10; var9++) {
                  RenderUtil25.M1rYPzBPnPSEft1K var11 = (RenderUtil25.M1rYPzBPnPSEft1K)var6.get(var9);
                  int var12 = var11.f_2712;
                  float var13 = (var12 >> 16 & 0xFF) * f_1252;
                  float var14 = (var12 >> 8 & 0xFF) * f_1253;
                  float var15 = (var12 & 0xFF) * f_1254;
                  float var16 = (var12 >> 24 & 0xFF) * f_1255;
                  float var17 = var11.f_2708;
                  float var18 = var11.f_2709;
                  float var19 = var17 + var11.f_2710;
                  float var20 = var18 + var11.f_2711;
                  var8.vertex(var1, var17, var20, 0.0F).texture(0.0F, 1.0F).color(var13, var14, var15, var16);
                  var8.vertex(var1, var19, var20, 0.0F).texture(1.0F, 1.0F).color(var13, var14, var15, var16);
                  var8.vertex(var1, var19, var18, 0.0F).texture(1.0F, 0.0F).color(var13, var14, var15, var16);
                  var8.vertex(var1, var17, var18, 0.0F).texture(0.0F, 0.0F).color(var13, var14, var15, var16);
               }

               RenderUtil12.I(var8.end());
            }
         }

         Util114.m_963();
      }
   }

   private static void m_1118() {
      if (!f_1210.isEmpty()) {
         Util114.m_1481();
         Util114.m_542();
         Util114.m_3784(RenderUtil7.f_13885);
         BufferBuilder var0 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         Matrix4f var1 = f_1214;
         float var2 = f_1221;
         int var3 = 0;

         for (int var4 = f_1210.size(); var3 < var4; var3++) {
            RenderUtil25.Inner_31OWsSGzT2jJiJK5 var5 = f_1210.get(var3);
            int var6 = var5.f_2631;
            float var7 = (var6 >> 16 & 0xFF) * f_1222;
            float var8 = (var6 >> 8 & 0xFF) * f_1223;
            float var9 = (var6 & 0xFF) * f_1224;
            float var10 = (var6 >> 24 & 0xFF) * f_1225;
            float var11 = var5.f_2627;
            float var12 = var5.f_2628;
            float var13 = var11 + var5.f_2629;
            float var14 = var12 + var5.f_2630;
            var0.vertex(var1, var11, var12, 0.0F).color(var7, var8, var9, var10);
            var0.vertex(var1, var11, var14, 0.0F).color(var7, var8, var9, var10);
            var0.vertex(var1, var13, var14, 0.0F).color(var7, var8, var9, var10);
            var0.vertex(var1, var13, var12, 0.0F).color(var7, var8, var9, var10);
         }

         RenderUtil12.I(var0.end());
         Util114.m_963();
      }
   }

   private static void m_2762(
      BufferBuilder var0,
      Matrix4f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11
   ) {
      var0.vertex(var1, var2, var3, var4).color(var8, var9, var10, var11);
      var0.vertex(var1, var5, var6, var7).color(var8, var9, var10, var11);
   }

   public static void m_2665(float var0, float var1, float var2, float var3, int var4, int var5) {
      m_2393(var0, var1, var2, var3, var4, var5, var5, var4);
   }

   public static void m_246(Identifier var0, float var1, float var2, float var3, float var4, int var5) {
      if (!f_1215) {
         throw new IllegalStateException(f_1220);
      } else {
         f_1212.computeIfAbsent(var0, var0x -> new ArrayList<>()).add(new RenderUtil25.M1rYPzBPnPSEft1K(var1, var2, var3, var4, var5));
      }
   }

   public static void m_724(Box var0, int var1, boolean var2, boolean var3) {
      if (var2 || var3) {
         f_1213.add(new RenderUtil25.f6jjR8U5i2KYUFcs(var0, var1, var2, var3));
      }
   }

   private static void m_3251() {
      if (f_1214 != null) {
         m_1118();
         m_1489();
         m_4064();
         f_1210.clear();
         f_1211.clear();
         f_1212.clear();
      }
   }

   public static void m_1001(
      float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11
   ) {
      f_1216.vertex(f_1214, var0, var1, 0.0F).texture(0.0F, 1.0F).color(var8, var9, var10, var11);
      f_1216.vertex(f_1214, var2, var3, 0.0F).texture(1.0F, 1.0F).color(var8, var9, var10, var11);
      f_1216.vertex(f_1214, var4, var5, 0.0F).texture(1.0F, 0.0F).color(var8, var9, var10, var11);
      f_1216.vertex(f_1214, var6, var7, 0.0F).texture(0.0F, 0.0F).color(var8, var9, var10, var11);
   }

   public static void m_1380(
      float var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17,
      float var18,
      float var19,
      float var20,
      float var21,
      float var22,
      float var23
   ) {
      f_1216.vertex(f_1214, var0, var1, var2).texture(var12, var13).color(var20, var21, var22, var23);
      f_1216.vertex(f_1214, var3, var4, var5).texture(var14, var15).color(var20, var21, var22, var23);
      f_1216.vertex(f_1214, var6, var7, var8).texture(var16, var17).color(var20, var21, var22, var23);
      f_1216.vertex(f_1214, var9, var10, var11).texture(var18, var19).color(var20, var21, var22, var23);
   }

   public static void m_2195(Identifier var0, float var1, float var2, float var3, float var4, Color var5) {
      int var6 = var5.getAlpha() << 24 | var5.getRed() << 16 | var5.getGreen() << 8 | var5.getBlue();
      m_246(var0, var1, var2, var3, var4, var6);
   }

   public static void m_328(float var0, float var1, float var2, float var3, int var4) {
      if (!f_1215) {
         throw new IllegalStateException(f_1218);
      } else {
         f_1210.add(new RenderUtil25.Inner_31OWsSGzT2jJiJK5(var0, var1, var2, var3, var4));
      }
   }

   public static void m_3997(Matrix4f var0) {
      if (f_1215) {
         m_2634();
      }

      f_1214 = var0;
      f_1216 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      f_1215 = true;
   }

   private static void m_1489() {
      if (!f_1211.isEmpty()) {
         Util114.m_1481();
         Util114.m_542();
         Util114.m_3784(RenderUtil7.f_13885);
         BufferBuilder var0 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         Matrix4f var1 = f_1214;
         float var2 = f_1226;
         int var3 = 0;

         for (int var4 = f_1211.size(); var3 < var4; var3++) {
            RenderUtil25.JrUBLgkRUWlcaMFB var5 = f_1211.get(var3);
            int var6 = var5.f_2465;
            int var7 = var5.f_2466;
            int var8 = var5.f_2467;
            int var9 = var5.f_2468;
            if ((var6 & f_1227) == 0) {
               var6 |= f_1228;
            }

            if ((var7 & f_1229) == 0) {
               var7 |= f_1230;
            }

            if ((var8 & f_1231) == 0) {
               var8 |= f_1232;
            }

            if ((var9 & f_1233) == 0) {
               var9 |= f_1234;
            }

            float var10 = (var6 >> 16 & 0xFF) * f_1235;
            float var11 = (var6 >> 8 & 0xFF) * f_1236;
            float var12 = (var6 & 0xFF) * f_1237;
            float var13 = (var6 >> 24 & 0xFF) * f_1238;
            float var14 = (var7 >> 16 & 0xFF) * f_1239;
            float var15 = (var7 >> 8 & 0xFF) * f_1240;
            float var16 = (var7 & 0xFF) * f_1241;
            float var17 = (var7 >> 24 & 0xFF) * f_1242;
            float var18 = (var8 >> 16 & 0xFF) * f_1243;
            float var19 = (var8 >> 8 & 0xFF) * f_1244;
            float var20 = (var8 & 0xFF) * f_1245;
            float var21 = (var8 >> 24 & 0xFF) * f_1246;
            float var22 = (var9 >> 16 & 0xFF) * f_1247;
            float var23 = (var9 >> 8 & 0xFF) * f_1248;
            float var24 = (var9 & 0xFF) * f_1249;
            float var25 = (var9 >> 24 & 0xFF) * f_1250;
            float var26 = var5.f_2461;
            float var27 = var5.f_2462;
            float var28 = var26 + var5.f_2463;
            float var29 = var27 + var5.f_2464;
            var0.vertex(var1, var26, var27, 0.0F).color(var10, var11, var12, var13);
            var0.vertex(var1, var26, var29, 0.0F).color(var14, var15, var16, var17);
            var0.vertex(var1, var28, var29, 0.0F).color(var18, var19, var20, var21);
            var0.vertex(var1, var28, var27, 0.0F).color(var22, var23, var24, var25);
         }

         RenderUtil12.I(var0.end());
         Util114.m_963();
      }
   }

   public static void m_1569(MatrixStack var0) {
      if (!f_1213.isEmpty()) {
         Matrix4f var1 = var0.peek().getPositionMatrix();
         boolean var2 = f_1213.stream().anyMatch(var0x -> var0x.f_7084);
         if (var2) {
            Util114.m_672();
            Util114.m_3978();
            Util114.m_1481();
            Util114.m_542();
            Util114.m_3784(RenderUtil7.f_13885);
            BufferBuilder var3 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

            for (RenderUtil25.f6jjR8U5i2KYUFcs var5 : f_1213) {
               if (var5.f_7084) {
                  Box var6 = var5.f_7082;
                  int var7 = var5.f_7083;
                  int var8 = (int)(Util71.m_2734(var7) * f_1256);
                  int var9 = Util71.m_3389(var7, var8);
                  float var10 = Util71.m_1989(var9) / f_1257;
                  float var11 = Util71.m_644(var9) / f_1258;
                  float var12 = Util71.m_3163(var9) / f_1259;
                  float var13 = Util71.m_2734(var9) / f_1260;
                  float var14 = (float)var6.minX;
                  float var15 = (float)var6.minY;
                  float var16 = (float)var6.minZ;
                  float var17 = (float)var6.maxX;
                  float var18 = (float)var6.maxY;
                  float var19 = (float)var6.maxZ;
                  var3.vertex(var1, var14, var15, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var15, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var15, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var15, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var18, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var18, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var18, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var18, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var15, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var18, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var18, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var15, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var15, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var15, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var18, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var18, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var15, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var15, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var18, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var14, var18, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var15, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var18, var16).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var18, var19).color(var10, var11, var12, var13);
                  var3.vertex(var1, var17, var15, var19).color(var10, var11, var12, var13);
               }
            }

            RenderUtil12.I(var3.end());
            Util114.m_100();
            Util114.m_1562();
            Util114.m_963();
         }

         boolean var20 = f_1213.stream().anyMatch(var0x -> var0x.f_7085);
         if (var20) {
            Util114.m_672();
            Util114.m_3978();
            Util114.m_1481();
            Util114.m_542();
            Util114.m_3784(RenderUtil7.f_13885);
            BufferBuilder var21 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

            for (RenderUtil25.f6jjR8U5i2KYUFcs var23 : f_1213) {
               if (var23.f_7085) {
                  Box var24 = var23.f_7082;
                  int var25 = var23.f_7083;
                  float var26 = Util71.m_1989(var25) / f_1261;
                  float var27 = Util71.m_644(var25) / f_1262;
                  float var28 = Util71.m_3163(var25) / f_1263;
                  float var29 = Util71.m_2734(var25) / f_1264;
                  float var30 = (float)var24.minX;
                  float var31 = (float)var24.minY;
                  float var32 = (float)var24.minZ;
                  float var33 = (float)var24.maxX;
                  float var34 = (float)var24.maxY;
                  float var35 = (float)var24.maxZ;
                  m_2762(var21, var1, var30, var31, var32, var33, var31, var32, var26, var27, var28, var29);
                  m_2762(var21, var1, var33, var31, var32, var33, var31, var35, var26, var27, var28, var29);
                  m_2762(var21, var1, var33, var31, var35, var30, var31, var35, var26, var27, var28, var29);
                  m_2762(var21, var1, var30, var31, var35, var30, var31, var32, var26, var27, var28, var29);
                  m_2762(var21, var1, var30, var34, var32, var33, var34, var32, var26, var27, var28, var29);
                  m_2762(var21, var1, var33, var34, var32, var33, var34, var35, var26, var27, var28, var29);
                  m_2762(var21, var1, var33, var34, var35, var30, var34, var35, var26, var27, var28, var29);
                  m_2762(var21, var1, var30, var34, var35, var30, var34, var32, var26, var27, var28, var29);
                  m_2762(var21, var1, var30, var31, var32, var30, var34, var32, var26, var27, var28, var29);
                  m_2762(var21, var1, var33, var31, var32, var33, var34, var32, var26, var27, var28, var29);
                  m_2762(var21, var1, var33, var31, var35, var33, var34, var35, var26, var27, var28, var29);
                  m_2762(var21, var1, var30, var31, var35, var30, var34, var35, var26, var27, var28, var29);
               }
            }

            RenderUtil12.I(var21.end());
            Util114.m_100();
            Util114.m_1562();
            Util114.m_963();
         }

         f_1213.clear();
      }
   }

   public static void m_2551(DrawContext var0, Identifier var1, float var2, float var3, float var4, float var5, Color var6) {
      int var7 = var6.getAlpha() << 24 | var6.getRed() << 16 | var6.getGreen() << 8 | var6.getBlue();
      m_3570(var0, var1, var2, var3, var4, var5, var7);
   }

   public static void m_3893(
      Identifier var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      int var13,
      int var14,
      int var15,
      int var16,
      float var17,
      float var18,
      float var19,
      float var20,
      float var21,
      float var22,
      float var23,
      float var24
   ) {
      f_1217.computeIfAbsent(var0, var0x -> new ArrayList<>())
         .add(
            new RenderUtil25.mEbQe513CN2i8sV3(
               var1,
               var2,
               var3,
               var4,
               var5,
               var6,
               var7,
               var8,
               var9,
               var10,
               var11,
               var12,
               var13,
               var14,
               var15,
               var16,
               var17,
               var18,
               var19,
               var20,
               var21,
               var22,
               var23,
               var24
            )
         );
   }

   public static void m_1258() {
      if (!f_1217.isEmpty()) {
         Util114.m_1481();
         Util114.m_542();
         Util114.m_672();
         Util114.m_1878(false);
         Util114.m_3978();
         Util114.m_3784(RenderUtil7.f_13886);
         TextureManager var0 = f_5909.getTextureManager();
         float var1 = f_1289;

         for (Entry var3 : f_1217.entrySet()) {
            Identifier var4 = (Identifier)var3.getKey();
            List<RenderUtil25.mEbQe513CN2i8sV3> var5 = (List<RenderUtil25.mEbQe513CN2i8sV3>)var3.getValue();
            if (!var5.isEmpty()) {
               Util114.m_2037(0, var4);
               AbstractTexture var6 = var0.getTexture(var4);
               if (var6 != null) {
                  Util114.m_2012(var6);
               }

               BufferBuilder var7 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

               for (RenderUtil25.mEbQe513CN2i8sV3 var9 : var5) {
                  float var10 = (var9.f_5897 >> 16 & 0xFF) * f_1290;
                  float var11 = (var9.f_5897 >> 8 & 0xFF) * f_1291;
                  float var12 = (var9.f_5897 & 0xFF) * f_1292;
                  float var13 = (var9.f_5897 >> 24 & 0xFF) * f_1293;
                  float var14 = (var9.f_5898 >> 16 & 0xFF) * f_1294;
                  float var15 = (var9.f_5898 >> 8 & 0xFF) * f_1295;
                  float var16 = (var9.f_5898 & 0xFF) * f_1296;
                  float var17 = (var9.f_5898 >> 24 & 0xFF) * f_1297;
                  float var18 = (var9.f_5899 >> 16 & 0xFF) * f_1298;
                  float var19 = (var9.f_5899 >> 8 & 0xFF) * f_1299;
                  float var20 = (var9.f_5899 & 0xFF) * f_1300;
                  float var21 = (var9.f_5899 >> 24 & 0xFF) * f_1301;
                  float var22 = (var9.f_5900 >> 16 & 0xFF) * f_1302;
                  float var23 = (var9.f_5900 >> 8 & 0xFF) * f_1303;
                  float var24 = (var9.f_5900 & 0xFF) * f_1304;
                  float var25 = (var9.f_5900 >> 24 & 0xFF) * f_1305;
                  var7.vertex(var9.f_5885, var9.f_5886, var9.f_5887).texture(var9.f_5901, var9.f_5902).color(var10, var11, var12, var13);
                  var7.vertex(var9.f_5888, var9.f_5889, var9.f_5890).texture(var9.f_5903, var9.f_5904).color(var14, var15, var16, var17);
                  var7.vertex(var9.f_5891, var9.f_5892, var9.f_5893).texture(var9.f_5905, var9.f_5906).color(var18, var19, var20, var21);
                  var7.vertex(var9.f_5894, var9.f_5895, var9.f_5896).texture(var9.f_5907, var9.f_5908).color(var22, var23, var24, var25);
               }

               RenderUtil12.I(var7.end());
            }
         }

         f_1217.clear();
         Util114.m_1878(true);
         Util114.m_100();
         Util114.m_1562();
         Util114.m_963();
      }
   }

   public static void m_3570(DrawContext var0, Identifier var1, float var2, float var3, float var4, float var5, int var6) {
      if (!Util77.m_1368(var0, var1, var2, var3, var4, var5, var6, false)) {
         Util114.m_1481();
         Util114.m_542();
         Util114.m_3784(RenderUtil7.f_13886);
         Util114.m_2037(0, var1);
         TextureManager var7 = f_5909.getTextureManager();
         AbstractTexture var8 = var7.getTexture(var1);
         if (var8 != null) {
            Util114.m_2012(var8);
         }

         float var9 = (var6 >> 16 & 0xFF) / f_1285;
         float var10 = (var6 >> 8 & 0xFF) / f_1286;
         float var11 = (var6 & 0xFF) / f_1287;
         float var12 = (var6 >> 24 & 0xFF) / f_1288;
         BufferBuilder var13 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
         Matrix4f var14 = Util7.m_1924(var0.getMatrices());
         var13.vertex(var14, var2, var3 + var5, 0.0F).texture(0.0F, 1.0F).color(var9, var10, var11, var12);
         var13.vertex(var14, var2 + var4, var3 + var5, 0.0F).texture(1.0F, 1.0F).color(var9, var10, var11, var12);
         var13.vertex(var14, var2 + var4, var3, 0.0F).texture(1.0F, 0.0F).color(var9, var10, var11, var12);
         var13.vertex(var14, var2, var3, 0.0F).texture(0.0F, 0.0F).color(var9, var10, var11, var12);
         RenderUtil12.I(var13.end());
         Util114.m_963();
      }
   }

   public static void m_1557(DrawContext var0, float var1, float var2, float var3, float var4, int var5) {
      if (!Util77.m_1731(var0, var1, var2, var3, var4, var5)) {
         Util114.m_1481();
         Util114.m_542();
         Util114.m_3784(RenderUtil7.f_13885);
         Matrix4f var6 = Util7.m_1924(var0.getMatrices());
         BufferBuilder var7 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         float var8 = (var5 >> 16 & 0xFF) / f_1265;
         float var9 = (var5 >> 8 & 0xFF) / f_1266;
         float var10 = (var5 & 0xFF) / f_1267;
         float var11 = (var5 >> 24 & 0xFF) / f_1268;
         var7.vertex(var6, var1, var2, 0.0F).color(var8, var9, var10, var11);
         var7.vertex(var6, var1, var2 + var4, 0.0F).color(var8, var9, var10, var11);
         var7.vertex(var6, var1 + var3, var2 + var4, 0.0F).color(var8, var9, var10, var11);
         var7.vertex(var6, var1 + var3, var2, 0.0F).color(var8, var9, var10, var11);
         RenderUtil12.I(var7.end());
         Util114.m_963();
      }
   }

   public static void l() {
      if (f_1215 && f_1216 != null) {
         try {
            RenderUtil12.I(f_1216.end());
         } finally {
            f_1214 = null;
            f_1216 = null;
            f_1215 = false;
         }
      }
   }

   public static void m_2848() {
      if (f_1215) {
         try {
            m_3251();
         } finally {
            f_1214 = null;
            f_1215 = false;
         }
      }
   }

   private static void m_2634() {
      f_1210.clear();
      f_1211.clear();
      f_1212.clear();
      f_1213.clear();
      f_1214 = null;
      f_1216 = null;
      f_1215 = false;
   }

   private static class Inner_31OWsSGzT2jJiJK5 {
      final float f_2627;
      final float f_2628;
      final float f_2629;
      final float f_2630;
      final int f_2631;

      Inner_31OWsSGzT2jJiJK5(float var1, float var2, float var3, float var4, int var5) {
         this.f_2627 = var1;
         this.f_2628 = var2;
         this.f_2629 = var3;
         this.f_2630 = var4;
         this.f_2631 = var5;
      }
   }

   private static class JrUBLgkRUWlcaMFB {
      final float f_2461;
      final float f_2462;
      final float f_2463;
      final float f_2464;
      final int f_2465;
      final int f_2466;
      final int f_2467;
      final int f_2468;

      JrUBLgkRUWlcaMFB(float var1, float var2, float var3, float var4, int var5, int var6, int var7, int var8) {
         this.f_2461 = var1;
         this.f_2462 = var2;
         this.f_2463 = var3;
         this.f_2464 = var4;
         this.f_2465 = var5;
         this.f_2466 = var6;
         this.f_2467 = var7;
         this.f_2468 = var8;
      }
   }

   private static class M1rYPzBPnPSEft1K {
      final float f_2708;
      final float f_2709;
      final float f_2710;
      final float f_2711;
      final int f_2712;

      M1rYPzBPnPSEft1K(float var1, float var2, float var3, float var4, int var5) {
         this.f_2708 = var1;
         this.f_2709 = var2;
         this.f_2710 = var3;
         this.f_2711 = var4;
         this.f_2712 = var5;
      }
   }

   private static class f6jjR8U5i2KYUFcs {
      final Box f_7082;
      final int f_7083;
      final boolean f_7084;
      final boolean f_7085;

      f6jjR8U5i2KYUFcs(Box var1, int var2, boolean var3, boolean var4) {
         this.f_7082 = var1;
         this.f_7083 = var2;
         this.f_7084 = var3;
         this.f_7085 = var4;
      }
   }

   private static class mEbQe513CN2i8sV3 {
      final float f_5885;
      final float f_5886;
      final float f_5887;
      final float f_5888;
      final float f_5889;
      final float f_5890;
      final float f_5891;
      final float f_5892;
      final float f_5893;
      final float f_5894;
      final float f_5895;
      final float f_5896;
      final int f_5897;
      final int f_5898;
      final int f_5899;
      final int f_5900;
      final float f_5901;
      final float f_5902;
      final float f_5903;
      final float f_5904;
      final float f_5905;
      final float f_5906;
      final float f_5907;
      final float f_5908;

      mEbQe513CN2i8sV3(
         float var1,
         float var2,
         float var3,
         float var4,
         float var5,
         float var6,
         float var7,
         float var8,
         float var9,
         float var10,
         float var11,
         float var12,
         int var13,
         int var14,
         int var15,
         int var16,
         float var17,
         float var18,
         float var19,
         float var20,
         float var21,
         float var22,
         float var23,
         float var24
      ) {
         this.f_5885 = var1;
         this.f_5886 = var2;
         this.f_5887 = var3;
         this.f_5888 = var4;
         this.f_5889 = var5;
         this.f_5890 = var6;
         this.f_5891 = var7;
         this.f_5892 = var8;
         this.f_5893 = var9;
         this.f_5894 = var10;
         this.f_5895 = var11;
         this.f_5896 = var12;
         this.f_5897 = var13;
         this.f_5898 = var14;
         this.f_5899 = var15;
         this.f_5900 = var16;
         this.f_5901 = var17;
         this.f_5902 = var18;
         this.f_5903 = var19;
         this.f_5904 = var20;
         this.f_5905 = var21;
         this.f_5906 = var22;
         this.f_5907 = var23;
         this.f_5908 = var24;
      }
   }
}
