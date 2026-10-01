package su.energyclient.render;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import su.energyclient.QuickImports;
import su.energyclient.util.Util114;
import su.energyclient.util.Util93;

public abstract class RenderUtil27 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   protected final Map<Character, RenderUtil27.OXbEjfdEAtRJiAJX> f_1310 = new HashMap<>();
   protected int f_1311;
   protected int f_1312;
   protected float f_1313;
   protected String f_1314;
   protected boolean f_1315;
   protected volatile Identifier f_1316;
   protected volatile NativeImageBackedTexture f_1317;
   private static final String f_1318 = "energy";
   private static final int f_1319 = 32873;
   private static final int f_1320 = 33071;
   private static final int f_1321 = 33071;
   private static final String f_1322 = "/assets/energy/fonts/";
   private static final String f_1323 = "Dialog";
   private static final float f_1324 = 255.0F;
   private static final float f_1325 = 255.0F;
   private static final float f_1326 = 255.0F;
   private static final float f_1327 = 255.0F;

   public NativeImageBackedTexture m_2844() {
      return this.f_1317;
   }

   public String m_1455() {
      return this.f_1314;
   }

   public abstract float m_38();

   public Map<Character, RenderUtil27.OXbEjfdEAtRJiAJX> m_1005() {
      return this.f_1310;
   }

   protected final void m_1942(BufferedImage var1, String var2) {
      RenderSystem.assertOnRenderThread();
      int var3 = var1.getWidth();
      int var4 = var1.getHeight();
      int[] var5 = var1.getRGB(0, 0, var3, var4, null, 0, var3);
      NativeImage var6 = new NativeImage(var3, var4, false);

      for (int var7 = 0; var7 < var5.length; var7++) {
         var6.setColorArgb(var7 % var3, var7 / var3, var5[var7]);
      }

      Identifier var10 = Identifier.of(f_1318, var2);
      NativeImageBackedTexture var8 = new NativeImageBackedTexture(() -> "Energy font atlas " + var2, var6);
      MinecraftClient.getInstance().getTextureManager().registerTexture(var10, var8);
      int var9 = GL11.glGetInteger(f_1319);
      Util114.m_2012(var8);
      GL11.glTexParameteri(3553, 10241, 9728);
      GL11.glTexParameteri(3553, 10240, 9728);
      GL11.glTexParameteri(3553, 10242, f_1320);
      GL11.glTexParameteri(3553, 10243, f_1321);
      Util114.m_2012(var9);
      this.f_1317 = var8;
      this.f_1316 = var10;
   }

   protected final float m_3588(BufferBuilder var1, Matrix4f var2, char var3, float var4, float var5, int var6) {
      RenderUtil27.OXbEjfdEAtRJiAJX var7 = this.f_1310.get(var3);
      if (var7 == null) {
         return 0.0F;
      } else {
         if (var7.f_5913 > 0 && var7.f_5914 > 0) {
            float var8 = (float)var7.f_5911 / this.f_1311;
            float var9 = (float)var7.f_5912 / this.f_1312;
            float var10 = (float)(var7.f_5911 + var7.f_5913) / this.f_1311;
            float var11 = (float)(var7.f_5912 + var7.f_5914) / this.f_1312;
            float var12 = (var6 >> 16 & 0xFF) / f_1324;
            float var13 = (var6 >> 8 & 0xFF) / f_1325;
            float var14 = (var6 & 0xFF) / f_1326;
            float var15 = (var6 >> 24 & 0xFF) / f_1327;
            var1.vertex(var2, var4, var5 + var7.f_5914, 0.0F).texture(var8, var11).color(var12, var13, var14, var15);
            var1.vertex(var2, var4 + var7.f_5913, var5 + var7.f_5914, 0.0F).texture(var10, var11).color(var12, var13, var14, var15);
            var1.vertex(var2, var4 + var7.f_5913, var5, 0.0F).texture(var10, var9).color(var12, var13, var14, var15);
            var1.vertex(var2, var4, var5, 0.0F).texture(var8, var9).color(var12, var13, var14, var15);
         }

         return var7.f_5913 + this.m_38();
      }
   }

   public final Graphics2D m_1872(BufferedImage var1, Font var2) {
      Graphics2D var3 = var1.createGraphics();
      var3.setFont(var2);
      var3.setColor(new Color(255, 255, 255, 0));
      var3.fillRect(0, 0, this.f_1311, this.f_1312);
      var3.setColor(Color.WHITE);
      if (this.f_1315) {
         var3.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
         var3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         var3.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      }

      return var3;
   }

   public boolean m_2372() {
      return this.f_1315;
   }

   public int m_2815() {
      return this.f_1312;
   }

   public float m_1621(char var1) {
      RenderUtil27.OXbEjfdEAtRJiAJX var2 = this.f_1310.get(var1);
      return var2 != null ? var2.f_5913 : 0.0F;
   }

   public float m_1875() {
      return this.f_1313;
   }

   public static Font m_3850(String var0, int var1, int var2) {
      String var3 = f_1322.concat(var0);
      Font var4 = new Font(f_1323, var1, var2);

      try {
         Font var6;
         try (InputStream var5 = Util93.class.getResourceAsStream(var3)) {
            if (var5 == null) {
               return var4;
            }

            var6 = Font.createFont(0, var5).deriveFont(var1, var2);
         }

         return var6;
      } catch (IOException | RuntimeException | FontFormatException var10) {
         return var4;
      }
   }

   public int m_1903() {
      return this.f_1311;
   }

   public Identifier m_117() {
      return this.f_1316;
   }

   public static class OXbEjfdEAtRJiAJX {
      public int f_5911;
      public int f_5912;
      public int f_5913;
      public int f_5914;
   }
}
