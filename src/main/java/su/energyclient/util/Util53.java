package su.energyclient.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.System.Logger.Level;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.model.CubeFace;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import su.energyclient.ui.UIElement1;

public final class Util53 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_7979 = "/assets/energy/cosmetics/hatcosmetics/";
   private static final String f_7980 = "energy";
   private static final String f_7981 = "staff_hat";
   private static final String f_7982 = "disguise";
   private static final String f_7983 = "display";
   private static final String f_7984 = "head";
   private static final String f_7985 = "translation";
   private static final float f_7986 = 16.0F;
   private static final String f_7987 = "rotation";
   private static final float f_7988 = (float) (Math.PI / 180.0);
   private static final String f_7989 = "scale";
   private static final float f_7990 = -0.25F;
   private static final float f_7991 = (float) Math.PI;
   private static final float f_7992 = 0.625F;
   private static final float f_7993 = -0.625F;
   private static final float f_7994 = -0.625F;
   private static final float f_7995 = -0.5F;
   private static final float f_7996 = -0.5F;
   private static final float f_7997 = -0.5F;
   private static final String f_7998 = "textures";
   private static final String f_7999 = "elements";
   private static final String f_8000 = "from";
   private static final float f_8001 = 16.0F;
   private static final String f_8002 = "to";
   private static final float f_8003 = 16.0F;
   private static final String f_8004 = "rotation";
   private static final String f_8005 = "rotation";
   private static final String f_8006 = "origin";
   private static final float f_8007 = 16.0F;
   private static final String f_8008 = "angle";
   private static final String f_8009 = "axis";
   private static final String f_8010 = "x";
   private static final String f_8011 = "y";
   private static final String f_8012 = "z";
   private static final String f_8013 = "Invalid model rotation axis";
   private static final String f_8014 = "rescale";
   private static final String f_8015 = "rescale";
   private static final String f_8016 = "x";
   private static final String f_8017 = "y";
   private static final String f_8018 = "z";
   private static final String f_8019 = "faces";
   private static final String f_8020 = "texture";
   private static final String f_8021 = "#";
   private static final String f_8022 = "uv";
   private static final String f_8023 = "rotation";
   private static final String f_8024 = "rotation";
   private static final float f_8025 = 16.0F;
   private static final float f_8026 = 16.0F;
   private static final String f_8027 = "Energy/Cosmetics";

   public static void m_2578(Util30 var0, MatrixStack var1, OrderedRenderCommandQueue var2, int var3, int var4) {
      boolean var5 = var0.style() == UIElement1.STAFF_CAP;
      List<Util53.gbyh0b7RQrU4rbmR> var6 = var5 ? Util53.DHEpKRfmUvjswBLh.f_13432 : Util53.DHEpKRfmUvjswBLh.f_13433;
      Identifier var7 = Identifier.of(f_7980, "cosmetics/hatcosmetics/" + (var5 ? f_7981 : f_7982) + ".png");
      var2.submitCustom(
         var1,
         RenderLayers.entityCutoutNoCull(var7),
         (var3x, var4x) -> {
            for (Util53.gbyh0b7RQrU4rbmR var6x : var6) {
               var4x.vertex(var3x, var6x.x, var6x.y, var6x.z)
                  .color(-1)
                  .texture(var6x.u, var6x.v)
                  .overlay(var4)
                  .light(var3)
                  .normal(var3x, var6x.nx, var6x.ny, var6x.nz);
            }
         }
      );
   }

   private static Vector3f m_997(JsonObject var0, String var1, Vector3f var2) {
      if (!var0.has(var1)) {
         return var2;
      } else {
         JsonArray var3 = var0.getAsJsonArray(var1);
         return new Vector3f(var3.get(0).getAsFloat(), var3.get(1).getAsFloat(), var3.get(2).getAsFloat());
      }
   }

   static List<Util53.gbyh0b7RQrU4rbmR> m_792(String var0) {
      try {
         List var34;
         try (InputStream var1 = Util53.class.getResourceAsStream("/assets/energy/cosmetics/hatcosmetics/" + var0 + ".json")) {
            if (var1 == null) {
               throw new IOException("Missing bundled cosmetic " + var0);
            }

            JsonObject var2 = JsonParser.parseReader(new InputStreamReader(var1, StandardCharsets.UTF_8)).getAsJsonObject();
            JsonObject var3 = var2.getAsJsonObject(f_7983).getAsJsonObject(f_7984);
            Vector3f var4 = m_997(var3, f_7985, new Vector3f()).div(f_7986);
            Vector3f var5 = m_997(var3, f_7987, new Vector3f()).mul(f_7988);
            Vector3f var6 = m_997(var3, f_7989, new Vector3f(1.0F));
            Matrix4f var7 = new Matrix4f()
               .translate(0.0F, f_7990, 0.0F)
               .rotateY(f_7991)
               .scale(f_7992, f_7993, f_7994)
               .translate(var4)
               .rotateXYZ(var5.x, var5.y, var5.z)
               .scale(var6)
               .translate(f_7995, f_7996, f_7997);
            JsonObject var8 = var2.getAsJsonObject(f_7998);
            ArrayList var9 = new ArrayList();

            for (JsonElement var11 : var2.getAsJsonArray(f_7999)) {
               JsonObject var12 = var11.getAsJsonObject();
               Vector3f var13 = m_997(var12, f_8000, new Vector3f()).div(f_8001);
               Vector3f var14 = m_997(var12, f_8002, new Vector3f()).div(f_8003);
               Matrix4f var15 = new Matrix4f(var7);
               if (var12.has(f_8004)) {
                  JsonObject var16 = var12.getAsJsonObject(f_8005);
                  Vector3f var17 = m_997(var16, f_8006, new Vector3f()).div(f_8007);
                  float var18 = (float)Math.toRadians(var16.get(f_8008).getAsFloat());
                  String var19 = var16.get(f_8009).getAsString();
                  var15.translate(var17);
                  switch (var19) {
                     case f_8010:
                        var15.rotateX(var18);
                        break;
                     case f_8011:
                        var15.rotateY(var18);
                        break;
                     case f_8012:
                        var15.rotateZ(var18);
                        break;
                     default:
                        throw new IOException(f_8013);
                  }

                  if (var16.has(f_8014) && var16.get(f_8015).getAsBoolean()) {
                     float var20 = 1.0F / (float)Math.cos(var18);
                     var15.scale(var19.equals(f_8016) ? 1.0F : var20, var19.equals(f_8017) ? 1.0F : var20, var19.equals(f_8018) ? 1.0F : var20);
                  }

                  var15.translate(-var17.x, -var17.y, -var17.z);
               }

               Matrix3f var35 = var15.normal(new Matrix3f());

               for (Entry var37 : var12.getAsJsonObject(f_8019).entrySet()) {
                  JsonObject var38 = ((JsonElement)var37.getValue()).getAsJsonObject();
                  String var39 = var38.get(f_8020).getAsString();
                  if (var39.startsWith(f_8021) && var8.has(var39.substring(1))) {
                     Direction var40 = Direction.valueOf(((String)var37.getKey()).toUpperCase(Locale.ROOT));
                     CubeFace var22 = CubeFace.getFace(var40);
                     Vector3f var23 = new Vector3f(var40.getFloatVector()).mul(var35).normalize();
                     JsonArray var24 = var38.getAsJsonArray(f_8022);
                     int var25 = var38.has(f_8023) ? var38.get(f_8024).getAsInt() / 90 : 0;

                     for (int var26 = 0; var26 < 4; var26++) {
                        Vector3f var27 = var22.getCorner(var26).get(var13, var14).mulPosition(var15);
                        int var28 = Math.floorMod(var26 + var25, 4);
                        float var29 = var24.get(var28 != 0 && var28 != 1 ? 2 : 0).getAsFloat() / f_8025;
                        float var30 = var24.get(var28 != 0 && var28 != 3 ? 3 : 1).getAsFloat() / f_8026;
                        var9.add(new Util53.gbyh0b7RQrU4rbmR(var27.x, var27.y, var27.z, var29, var30, var23.x, var23.y, var23.z));
                     }
                  }
               }
            }

            var34 = List.copyOf(var9);
         }

         return var34;
      } catch (RuntimeException | IOException var33) {
         System.getLogger(f_8027).log(Level.WARNING, "Cannot load cosmetic " + var0, var33);
         return List.of();
      }
   }

   private Util53() {
   }

   private static final class DHEpKRfmUvjswBLh {
      static final List<Util53.gbyh0b7RQrU4rbmR> f_13432 = Util53.m_792(Util53.DHEpKRfmUvjswBLh.f_13434);
      static final List<Util53.gbyh0b7RQrU4rbmR> f_13433 = Util53.m_792(Util53.DHEpKRfmUvjswBLh.f_13435);
      private static final String f_13434 = "staff_hat";
      private static final String f_13435 = "disguise";
   }

   record gbyh0b7RQrU4rbmR(float x, float y, float z, float u, float v, float nx, float ny, float nz) {
   }
}
