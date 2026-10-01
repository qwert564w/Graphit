package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil6;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util11;
import su.energyclient.util.Util114;
import su.energyclient.util.Util24;
import su.energyclient.util.Util52;
import su.energyclient.util.Util71;
import su.energyclient.util.Util98;
import su.energyclient.util.math.MathUtil6;

public class Sonar extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_13197;
   private final NumberSetting f_13198;
   private final NumberSetting f_13199;
   private final NumberSetting f_13200;
   private final BooleanSetting f_13201;
   private Framebuffer f_13202;
   private int f_13203;
   private int f_13204;
   private long f_13205;
   private Vec3d f_13206;
   private static final String f_13207 = "Sonar";
   private static final String f_13208 = "Scan effect";
   private static final String f_13209 = "Длительность";
   private static final float f_13210 = 5.6F;
   private static final float f_13211 = 0.8F;
   private static final float f_13212 = 10.0F;
   private static final float f_13213 = 0.1F;
   private static final String f_13214 = "Яркость";
   private static final float f_13215 = 0.1F;
   private static final float f_13216 = 0.01F;
   private static final String f_13217 = "Ширина";
   private static final float f_13218 = 0.35F;
   private static final float f_13219 = 2.2F;
   private static final float f_13220 = 0.05F;
   private static final String f_13221 = "Резкость";
   private static final float f_13222 = 24.0F;
   private static final float f_13223 = 4.0F;
   private static final float f_13224 = 80.0F;
   private static final String f_13225 = "При ударе";
   private static final float f_13226 = 1000.0F;
   private static final float f_13227 = 0.85F;
   private static final float f_13228 = 0.5F;
   private static final float f_13229 = 1.75F;
   private static final float f_13230 = 6.0F;
   private static final float f_13231 = 0.18F;
   private static final float f_13232 = 4.0F;
   private static final float f_13233 = 10.0F;
   private static final float f_13234 = 0.42F;
   private static final float f_13235 = 0.001F;
   private static final float f_13236 = 0.001F;
   private static final String f_13237 = "invViewMat";
   private static final String f_13238 = "invProjMat";
   private static final String f_13239 = "pos";
   private static final String f_13240 = "center";
   private static final String f_13241 = "radius";
   private static final String f_13242 = "width";
   private static final String f_13243 = "sharpness";
   private static final String f_13244 = "outerColor";
   private static final String f_13245 = "midColor";
   private static final String f_13246 = "innerColor";
   private static final String f_13247 = "scanlineColor";
   private static final String f_13248 = "DebugMode";
   private static final int f_13249 = 33984;
   private static final int f_13250 = 34892;
   private static final String f_13251 = "depthTex";
   private static final float f_13252 = -1.0F;
   private static final float f_13253 = -1.0F;
   private static final float f_13254 = -1.0F;
   private static final float f_13255 = -1.0F;
   private static final float f_13256 = 255.0F;
   private static final float f_13257 = 255.0F;
   private static final float f_13258 = 255.0F;
   private static final float f_13259 = 255.0F;
   private static final int f_13260 = 16777215;

   @EventHandler
   public void m_1939(Util52 var1) {
      if (f_5909.player != null) {
         this.m_1310(f_5909.player.getEntityPos());
      }
   }

   @Override
   public void m_2() {
      if (f_5909.player != null) {
         this.m_1310(f_5909.player.getEntityPos());
      }

      super.m_2();
   }

   @EventHandler
   public void m_4122(EventAttack var1) {
      if (this.f_13201.m_1163() && var1.m_1070() != null) {
         this.m_1310(var1.m_1070().getBoundingBox().getCenter());
      }
   }

   private void m_3531(int var1, int var2) {
      if (this.f_13202 == null || this.f_13203 != var1 || this.f_13204 != var2) {
         this.m_1228();
         this.f_13202 = new SimpleFramebuffer(null, var1, var2, true);
         this.f_13203 = var1;
         this.f_13204 = var2;
      }
   }

   private void m_1282() {
      BufferBuilder var1 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
      var1.vertex(f_13252, f_13253, 0.0F).texture(0.0F, 0.0F);
      var1.vertex(f_13254, 1.0F, 0.0F).texture(0.0F, 1.0F);
      var1.vertex(1.0F, 1.0F, 0.0F).texture(1.0F, 1.0F);
      var1.vertex(1.0F, f_13255, 0.0F).texture(1.0F, 0.0F);
      RenderUtil12.I(var1.end());
   }

   private void m_1228() {
      if (this.f_13202 != null) {
         this.f_13202.delete();
         this.f_13202 = null;
      }

      this.f_13203 = -1;
      this.f_13204 = -1;
   }

   private int m_2270(int var1, float var2) {
      int var3 = var1 >> 24 & 0xFF;
      if (var3 == 0) {
         var3 = 255;
      }

      var3 = (int)(var3 * MathHelper.clamp(var2, 0.0F, 1.0F));
      return var1 & f_13260 | var3 << 24;
   }

   public Sonar() {
      super(f_13207, f_13208, Category.RENDER);
      this.f_13197 = new NumberSetting(f_13209, f_13210, f_13211, f_13212, f_13213);
      this.f_13198 = new NumberSetting(f_13214, 1.0F, f_13215, 1.0F, f_13216);
      this.f_13199 = new NumberSetting(f_13217, 1.0F, f_13218, f_13219, f_13220);
      this.f_13200 = new NumberSetting(f_13221, f_13222, f_13223, f_13224, 1.0F);
      this.f_13201 = new BooleanSetting(f_13225, true);
      this.f_13203 = -1;
      this.f_13204 = -1;
      this.f_13206 = Vec3d.ZERO;
   }

   public void m_2035(Matrix4f var1, Matrix4f var2, Vec3d var3) {
      if (f_5909.player != null && f_5909.world != null && this.f_13205 > 0L) {
         float var4 = this.f_13197.m_4046() * f_13226;
         float var5 = (float)(System.currentTimeMillis() - this.f_13205);
         if (var5 >= var4) {
            this.f_13205 = 0L;
         } else {
            Framebuffer var6 = f_5909.getFramebuffer();
            this.m_3531(var6.textureWidth, var6.textureHeight);
            if (this.f_13202 != null) {
               this.f_13202.copyDepthFrom(var6);
               Matrix4f var7 = new Matrix4f(var1).invert();
               Matrix4f var8 = new Matrix4f(var2).invert();
               float var9 = f_5909.gameRenderer.getFarPlaneDistance();
               float var10 = MathHelper.clamp(var5 / var4, 0.0F, 1.0F);
               float var11 = this.m_2580(1.0F, var9, (float)Util11.f_2937.m_1934(var10));
               float var12 = this.m_2580(1.0F, var9, (float)Util11.f_2935.m_1934(var10));
               float var13 = MathHelper.lerp(f_13227, var11, var12);
               float var14 = 1.0F - var10;
               float var15 = (var14 > f_13228 ? 1.0F - var14 : var14) * 2.0F;
               var15 = Math.min(var15 * f_13229, 1.0F);
               float var16 = MathHelper.clamp(this.f_13198.m_4046() * var15, 0.0F, 1.0F);
               int var17 = EnergyClient.getTheme(0);
               int var18 = EnergyClient.getTheme(90);
               int var19 = EnergyClient.getTheme(180);
               int var20 = EnergyClient.getTheme(270);
               float var21 = MathHelper.clamp(f_13230 + var13 * (f_13231 * this.f_13199.m_4046()), f_13232, Math.max(f_13233, var9 * f_13234));
               float var22 = this.f_13200.m_4046();
               this.m_2430(
                  var7,
                  var8,
                  var3,
                  var6,
                  var13,
                  var21,
                  var22,
                  Util71.m_1907(var17, var16),
                  Util71.m_1907(var18, var16),
                  Util71.m_1907(var19, var16),
                  Util71.m_1907(var20, var16)
               );
               Util114.m_542();
            }
         }
      }
   }

   @Override
   public void m_1() {
      this.f_13205 = 0L;
      this.m_1228();
      super.m_1();
   }

   private void m_1310(Vec3d var1) {
      this.f_13205 = System.currentTimeMillis();
      this.f_13206 = var1;
   }

   private void m_2628(MathUtil6 var1, int var2) {
      int var3 = var2 >> 24 & 0xFF;
      int var4 = var2 >> 16 & 0xFF;
      int var5 = var2 >> 8 & 0xFF;
      int var6 = var2 & 0xFF;
      var1.m_41(var4 / f_13256, var5 / f_13257, var6 / f_13258, var3 / f_13259);
   }

   private void m_2430(Matrix4f var1, Matrix4f var2, Vec3d var3, Framebuffer var4, float var5, float var6, float var7, int var8, int var9, int var10, int var11) {
      if (!(var5 <= f_13235) && !(var6 <= f_13236)) {
         Util98 var12 = Util114.m_827(Util24.f_3273);
         MathUtil6 var13 = var12.m_1335(f_13237);
         MathUtil6 var14 = var12.m_1335(f_13238);
         MathUtil6 var15 = var12.m_1335(f_13239);
         MathUtil6 var16 = var12.m_1335(f_13240);
         MathUtil6 var17 = var12.m_1335(f_13241);
         MathUtil6 var18 = var12.m_1335(f_13242);
         MathUtil6 var19 = var12.m_1335(f_13243);
         MathUtil6 var20 = var12.m_1335(f_13244);
         MathUtil6 var21 = var12.m_1335(f_13245);
         MathUtil6 var22 = var12.m_1335(f_13246);
         MathUtil6 var23 = var12.m_1335(f_13247);
         MathUtil6 var24 = var12.m_1335(f_13248);
         if (var13 != null) {
            var13.m_23(var1);
         }

         if (var14 != null) {
            var14.m_23(var2);
         }

         if (var15 != null) {
            var15.m_33((float)var3.x, (float)var3.y, (float)var3.z);
         }

         if (var16 != null) {
            var16.m_33((float)this.f_13206.x, (float)this.f_13206.y, (float)this.f_13206.z);
         }

         if (var17 != null) {
            var17.O(var5);
         }

         if (var18 != null) {
            var18.O(var6);
         }

         if (var19 != null) {
            var19.O(var7);
         }

         if (var20 != null) {
            this.m_2628(var20, var8);
         }

         if (var21 != null) {
            this.m_2628(var21, var9);
         }

         if (var22 != null) {
            this.m_2628(var22, var10);
         }

         if (var23 != null) {
            this.m_2628(var23, var11);
         }

         if (var24 != null) {
            var24.m_55(0);
         }

         Util114.m_1481();
         Util114.m_582(770, 771);
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         Util114.m_672();
         Util114.m_3978();
         Util114.m_1878(false);
         int var25 = RenderUtil6.m_668(this.f_13202.getDepthAttachment());
         if (var25 == 0) {
            var25 = RenderUtil6.m_668(f_5909.getFramebuffer().getDepthAttachment());
         }

         Util114.m_2836(f_13249);
         Util114.m_2012(var25);
         GL11.glTexParameteri(3553, f_13250, 0);
         GL11.glTexParameteri(3553, 10241, 9728);
         GL11.glTexParameteri(3553, 10240, 9728);
         RenderUtil6.m_4071(var4, false);
         var12.m_3726(f_13251, var25);
         Util114.m_3784(Util24.f_3273);
         this.m_1282();
         Util114.m_1878(true);
         Util114.m_1562();
         Util114.m_100();
         Util114.m_963();
      }
   }

   private float m_2580(float var1, float var2, float var3) {
      return var1 + (var2 - var1) * var3;
   }
}
