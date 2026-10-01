package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util125;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;
import su.energyclient.util.Util170;
import su.energyclient.util.Util39;
import su.energyclient.util.Util88;

public class CosmicSwarm extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final List<CosmicSwarm.jvqmUIUVyypSdSyd> f_14175 = new ArrayList<>();
   public final ModeSetting f_14176;
   public final NumberSetting f_14177;
   public final NumberSetting f_14178;
   public final NumberSetting f_14179;
   public final NumberSetting f_14180;
   public final BooleanSetting f_14181;
   private long f_14182;
   private String f_14183;
   private static final String f_14184 = "Cosmic Swarm";
   private static final String f_14185 = "Космические частицы в мире";
   private static final String f_14186 = "Мод";
   private static final String f_14187 = "Кубы";
   private static final String f_14188 = "Кубы";
   private static final String f_14189 = "Личинки";
   private static final String f_14190 = "Максимальное кол-во партиклов";
   private static final float f_14191 = 80.0F;
   private static final float f_14192 = 20.0F;
   private static final float f_14193 = 150.0F;
   private static final String f_14194 = "Размер свечения";
   private static final float f_14195 = 6.0F;
   private static final float f_14196 = 12.0F;
   private static final String f_14197 = "Размер партиклов";
   private static final float f_14198 = 0.2F;
   private static final float f_14199 = 0.1F;
   private static final String f_14200 = "Радиус спавна";
   private static final float f_14201 = 20.0F;
   private static final float f_14202 = 5.0F;
   private static final float f_14203 = 40.0F;
   private static final String f_14204 = "Радужный цвет";
   private static final String f_14205 = "energy";
   private static final String f_14206 = "images/esp/glow.png";
   private static final double f_14207 = 255.0;
   private static final double f_14208 = 0.4F;
   private static final double f_14209 = 205.0;
   private static final double f_14210 = -0.5;
   private static final double f_14211 = -0.5;
   private static final double f_14212 = -0.5;
   private static final double f_14213 = 0.5;
   private static final double f_14214 = 0.5;
   private static final double f_14215 = 0.5;
   private static final String f_14216 = "Личинки";
   private static final float f_14217 = 5.0F;
   private static final float f_14218 = -1.0F;
   private static final float f_14219 = -1.0F;
   private static final float f_14220 = -1.0F;
   private static final float f_14221 = -1.0F;
   private static final float f_14222 = -1.0F;
   private static final float f_14223 = 1500.0F;
   private static final float f_14224 = 4500.0F;
   private static final float f_14225 = 0.1F;
   private static final float f_14226 = 0.3F;
   private static final float f_14227 = 0.5F;
   private static final float f_14228 = 0.5F;
   private static final float f_14229 = 9.0F;
   private static final float f_14230 = -1.0F;
   private static final float f_14231 = -0.15F;
   private static final float f_14232 = 0.25F;
   private static final float f_14233 = -1.0F;
   private static final float f_14234 = -0.2F;
   private static final float f_14235 = 0.2F;
   private static final float f_14236 = -0.2F;
   private static final float f_14237 = 0.2F;
   private static final float f_14238 = -0.2F;
   private static final float f_14239 = 0.2F;
   private static final float f_14240 = 3500.0F;
   private static final float f_14241 = 8500.0F;
   private static final float f_14242 = 0.28F;
   private static final float f_14243 = 0.65F;
   private static final float f_14244 = 255.0F;
   private static final float f_14245 = 255.0F;
   private static final float f_14246 = 255.0F;
   private static final float f_14247 = 255.0F;
   private static final float f_14248 = 0.95F;
   private static final float f_14249 = 1.55F;
   private static final float f_14250 = 90.0F;
   private static final float f_14251 = 0.02F;
   private static final float f_14252 = 0.72F;
   private static final float f_14253 = 230.0F;
   private static final float f_14254 = 0.02F;
   private static final float f_14255 = 0.92F;
   private static final float f_14256 = 0.55F;
   private static final float f_14257 = 135.0F;
   private static final float f_14258 = 0.02F;
   private static final float f_14259 = 0.22F;
   private static final float f_14260 = 0.16F;
   private static final float f_14261 = 160.0F;
   private static final float f_14262 = 0.35F;
   private static final double f_14263 = 190.0;
   private static final float f_14264 = 90.0F;
   private static final float f_14265 = 0.2F;
   private static final float f_14266 = 255.0F;
   private static final float f_14267 = 255.0F;
   private static final float f_14268 = 255.0F;
   private static final float f_14269 = 255.0F;
   private static final float f_14270 = 255.0F;
   private static final float f_14271 = 255.0F;
   private static final float f_14272 = 255.0F;
   private static final float f_14273 = 255.0F;
   private static final float f_14274 = 255.0F;
   private static final float f_14275 = 255.0F;
   private static final float f_14276 = 255.0F;
   private static final float f_14277 = 255.0F;
   private static final float f_14278 = 0.15F;
   private static final float f_14279 = 0.1F;
   private static final float f_14280 = 0.005F;
   private static final float f_14281 = 255.0F;
   private static final float f_14282 = 5000.0F;
   private static final float f_14283 = 0.8F;
   private static final float f_14284 = 255.0F;
   private static final float f_14285 = 255.0F;
   private static final float f_14286 = 4200.0F;
   private static final float f_14287 = 0.12F;
   private static final float f_14288 = 0.22F;
   private static final float f_14289 = 0.9F;
   private static final double f_14290 = 0.01F;

   private void m_3383(MatrixStack var1, BufferBuilder var2, CosmicSwarm.jvqmUIUVyypSdSyd var3, Vec3d var4, float var5) {
      int var6 = var3.f_1051.size();
      if (var6 > 1) {
         Vec3d var7 = var3.f_1051.get(0);

         for (int var8 = 1; var8 < var6; var8++) {
            Vec3d var9 = var3.f_1051.get(var8);
            float var10 = (float)var8 / (var6 - 1);
            float var11 = (float)(var3.f_1048.m_2276() * var10 * f_14263);
            this.m_4050(var1, var2, var7, var9, var4, this.m_3741(var3, var11, 1.0F - var10));
            var7 = var9;
         }
      }

      for (CosmicSwarm.E6XZfexSovxDMzCo var13 : var3.f_1052) {
         float var14 = (1.0F - var13.m_1030()) * f_14264 * (float)var3.f_1048.m_2276();
         this.m_4050(var1, var2, var13.m_2193(var5), var13.m_3623(var5), var4, this.m_3741(var3, var14, var13.m_1030() + f_14265));
      }
   }

   private void m_2908(MatrixStack var1, BufferBuilder var2, double var3, double var5, double var7, double var9, double var11, int var13) {
      Matrix4f var14 = var1.peek().getPositionMatrix();
      float var15 = (var13 >> 16 & 0xFF) / f_14244;
      float var16 = (var13 >> 8 & 0xFF) / f_14245;
      float var17 = (var13 & 0xFF) / f_14246;
      float var18 = (var13 >> 24 & 0xFF) / f_14247;
      var2.vertex(var14, (float)var3, (float)(var5 + var11), (float)var7).texture(0.0F, 1.0F).color(var15, var16, var17, var18);
      var2.vertex(var14, (float)(var3 + var9), (float)(var5 + var11), (float)var7).texture(1.0F, 1.0F).color(var15, var16, var17, var18);
      var2.vertex(var14, (float)(var3 + var9), (float)var5, (float)var7).texture(1.0F, 0.0F).color(var15, var16, var17, var18);
      var2.vertex(var14, (float)var3, (float)var5, (float)var7).texture(0.0F, 0.0F).color(var15, var16, var17, var18);
   }

   private int m_3741(CosmicSwarm.jvqmUIUVyypSdSyd var1, float var2, float var3) {
      int var4 = (int)Math.min(f_14285, Math.max(0.0F, var2));
      if (!this.f_14181.m_1163()) {
         int var11 = EnergyClient.getTheme(0);
         int var12 = var11 >> 16 & 0xFF;
         int var13 = var11 >> 8 & 0xFF;
         int var14 = var11 & 0xFF;
         return var4 << 24 | var12 << 16 | var13 << 8 | var14;
      } else {
         float var5 = (float)(System.currentTimeMillis() - this.f_14182) / f_14286;
         float var6 = (var1.f_1050 + var3 * f_14287 + var5 * f_14288) % 1.0F;
         int var7 = Color.HSBtoRGB(var6, f_14289, 1.0F);
         int var8 = var7 >> 16 & 0xFF;
         int var9 = var7 >> 8 & 0xFF;
         int var10 = var7 & 0xFF;
         return var4 << 24 | var8 << 16 | var9 << 8 | var10;
      }
   }

   public CosmicSwarm() {
      super(f_14184, f_14185, Category.RENDER);
      this.f_14176 = new ModeSetting(f_14186, f_14187, f_14188, f_14189);
      this.f_14177 = new NumberSetting(f_14190, f_14191, f_14192, f_14193, 1.0F);
      this.f_14178 = new NumberSetting(f_14194, f_14195, 2.0F, f_14196, 1.0F);
      this.f_14179 = new NumberSetting(f_14197, 1.0F, f_14198, 2.0F, f_14199);
      this.f_14180 = new NumberSetting(f_14200, f_14201, f_14202, f_14203, 1.0F);
      this.f_14181 = new BooleanSetting(f_14204, false);
      this.f_14182 = System.currentTimeMillis();
      this.f_14183 = this.f_14176.m_3862();
   }

   private CosmicSwarm.jvqmUIUVyypSdSyd m_2631(float var1) {
      if (this.f_14176.m_2073(f_14216)) {
         return this.m_242(var1);
      } else {
         Vec3d var2 = f_5909.player.getEntityPos();
         Vec3d var3 = var2.add(Util39.m_2499(-var1, var1), Util39.m_2499(0.0F, f_14217), Util39.m_2499(-var1, var1));
         Vec3d var4 = new Vec3d(Util39.m_2499(f_14218, 1.0F), Util39.m_2499(0.0F, 2.0F), Util39.m_2499(f_14219, 1.0F));
         Vec3d var5 = new Vec3d(Util39.m_2499(f_14220, 1.0F), Util39.m_2499(f_14221, 1.0F), Util39.m_2499(f_14222, 1.0F));
         long var6 = (long)Util39.m_2499(f_14223, f_14224);
         float var8 = Util39.m_2499(f_14225, f_14226);
         return new CosmicSwarm.jvqmUIUVyypSdSyd(var3, Vec3d.ZERO, var4, var5, var6, var8, CosmicSwarm.Inner_9zz1kLxC4F4J6YGU.CUBE);
      }
   }

   private void m_4050(MatrixStack var1, BufferBuilder var2, Vec3d var3, Vec3d var4, Vec3d var5, int var6) {
      Matrix4f var7 = var1.peek().getPositionMatrix();
      float var8 = (var6 >> 16 & 0xFF) / f_14266;
      float var9 = (var6 >> 8 & 0xFF) / f_14267;
      float var10 = (var6 & 0xFF) / f_14268;
      float var11 = (var6 >> 24 & 0xFF) / f_14269;
      var2.vertex(var7, (float)(var3.x - var5.x), (float)(var3.y - var5.y), (float)(var3.z - var5.z)).color(var8, var9, var10, var11);
      var2.vertex(var7, (float)(var4.x - var5.x), (float)(var4.y - var5.y), (float)(var4.z - var5.z)).color(var8, var9, var10, var11);
   }

   private int m_382(float var1) {
      int var2 = EnergyClient.getTheme(0);
      int var3 = var2 >> 16 & 0xFF;
      int var4 = var2 >> 8 & 0xFF;
      int var5 = var2 & 0xFF;
      int var6 = (int)Math.min(f_14281, Math.max(0.0F, var1));
      return var6 << 24 | var3 << 16 | var4 << 8 | var5;
   }

   private void m_892(MatrixStack var1, BufferBuilder var2, Camera var3, Vec3d var4, Vec3d var5, float var6, int var7) {
      var1.push();
      this.m_2441(var1, var5, var4);
      var1.multiply(var3.getRotation());
      this.m_2908(var1, var2, -var6 / 2.0F, -var6 / 2.0F, 0.0, var6, var6, var7);
      var1.pop();
   }

   private void m_402(MatrixStack var1, BufferBuilder var2, Box var3, int var4) {
      Matrix4f var5 = var1.peek().getPositionMatrix();
      float var6 = (var4 >> 16 & 0xFF) / f_14274;
      float var7 = (var4 >> 8 & 0xFF) / f_14275;
      float var8 = (var4 & 0xFF) / f_14276;
      float var9 = (var4 >> 24 & 0xFF) / f_14277;
      float var10 = (float)var3.minX;
      float var11 = (float)var3.minY;
      float var12 = (float)var3.minZ;
      float var13 = (float)var3.maxX;
      float var14 = (float)var3.maxY;
      float var15 = (float)var3.maxZ;
      float var16 = f_14278;
      float var17 = f_14279;
      float var18 = f_14280;
      float[][] var19 = new float[][]{
         {var10, var11, var12, var13, var11, var12},
         {var13, var11, var12, var13, var11, var15},
         {var13, var11, var15, var10, var11, var15},
         {var10, var11, var15, var10, var11, var12},
         {var10, var14, var12, var13, var14, var12},
         {var13, var14, var12, var13, var14, var15},
         {var13, var14, var15, var10, var14, var15},
         {var10, var14, var15, var10, var14, var12},
         {var10, var11, var12, var10, var14, var12},
         {var13, var11, var12, var13, var14, var12},
         {var13, var11, var15, var13, var14, var15},
         {var10, var11, var15, var10, var14, var15}
      };
      float[][] var20 = new float[][]{
         {0.0F, 0.0F, 0.0F},
         {var18, 0.0F, 0.0F},
         {-var18, 0.0F, 0.0F},
         {0.0F, var18, 0.0F},
         {0.0F, -var18, 0.0F},
         {0.0F, 0.0F, var18},
         {0.0F, 0.0F, -var18},
         {var18, var18, 0.0F},
         {-var18, -var18, 0.0F},
         {var18, 0.0F, var18},
         {-var18, 0.0F, -var18},
         {0.0F, var18, var18},
         {0.0F, -var18, -var18}
      };

      for (float[] var24 : var19) {
         float var25 = var24[3] - var24[0];
         float var26 = var24[4] - var24[1];
         float var27 = var24[5] - var24[2];
         float var28 = (float)Math.sqrt(var25 * var25 + var26 * var26 + var27 * var27);
         if (var28 != 0.0F) {
            float var29 = var25 / var28;
            float var30 = var26 / var28;
            float var31 = var27 / var28;

            for (float[] var35 : var20) {
               for (float var36 = 0.0F; var36 < var28; var36 += var16 + var17) {
                  float var37 = Math.min(var36 + var16, var28);
                  var2.vertex(var5, var24[0] + var29 * var36 + var35[0], var24[1] + var30 * var36 + var35[1], var24[2] + var31 * var36 + var35[2])
                     .color(var6, var7, var8, var9);
                  var2.vertex(var5, var24[0] + var29 * var37 + var35[0], var24[1] + var30 * var37 + var35[1], var24[2] + var31 * var37 + var35[2])
                     .color(var6, var7, var8, var9);
               }
            }
         }
      }
   }

   private void m_2441(MatrixStack var1, Vec3d var2, Vec3d var3) {
      var1.translate(var2.x - var3.x, var2.y - var3.y, var2.z - var3.z);
   }

   private CosmicSwarm.jvqmUIUVyypSdSyd m_242(float var1) {
      Vec3d var2 = f_5909.player.getEntityPos();
      double var3 = Util39.m_2499(0.0F, 1.0F) > f_14227 ? var1 : -var1;
      boolean var5 = Util39.m_2499(0.0F, 1.0F) > f_14228;
      Vec3d var6 = var2.add(var5 ? var3 : Util39.m_2499(-var1, var1), Util39.m_2499(2.0F, f_14229), var5 ? Util39.m_2499(-var1, var1) : var3);
      Vec3d var7 = new Vec3d(Util39.m_2499(f_14230, 1.0F), Util39.m_2499(f_14231, f_14232), Util39.m_2499(f_14233, 1.0F));
      Vec3d var8 = new Vec3d(Util39.m_2499(f_14234, f_14235), Util39.m_2499(f_14236, f_14237), Util39.m_2499(f_14238, f_14239));
      long var9 = (long)Util39.m_2499(f_14240, f_14241);
      float var11 = Util39.m_2499(f_14242, f_14243);
      return new CosmicSwarm.jvqmUIUVyypSdSyd(var6, Vec3d.ZERO, var7, var8, var9, var11, CosmicSwarm.Inner_9zz1kLxC4F4J6YGU.LARVA);
   }

   private void m_3368(MatrixStack var1, BufferBuilder var2, Box var3, int var4) {
      Matrix4f var5 = var1.peek().getPositionMatrix();
      float var6 = (var4 >> 16 & 0xFF) / f_14270;
      float var7 = (var4 >> 8 & 0xFF) / f_14271;
      float var8 = (var4 & 0xFF) / f_14272;
      float var9 = (var4 >> 24 & 0xFF) / f_14273;
      float var10 = (float)var3.minX;
      float var11 = (float)var3.minY;
      float var12 = (float)var3.minZ;
      float var13 = (float)var3.maxX;
      float var14 = (float)var3.maxY;
      float var15 = (float)var3.maxZ;
      var2.vertex(var5, var10, var11, var12).color(var6, var7, var8, var9);
      var2.vertex(var5, var13, var14, var15).color(var6, var7, var8, var9);
      var2.vertex(var5, var13, var11, var12).color(var6, var7, var8, var9);
      var2.vertex(var5, var10, var14, var15).color(var6, var7, var8, var9);
      var2.vertex(var5, var13, var11, var15).color(var6, var7, var8, var9);
      var2.vertex(var5, var10, var14, var12).color(var6, var7, var8, var9);
      var2.vertex(var5, var10, var11, var15).color(var6, var7, var8, var9);
      var2.vertex(var5, var13, var14, var12).color(var6, var7, var8, var9);
   }

   private Vec3d m_1631(Vec3d var1, Vec3d var2, float var3) {
      return new Vec3d(var1.x + (var2.x - var1.x) * var3, var1.y + (var2.y - var1.y) * var3, var1.z + (var2.z - var1.z) * var3);
   }

   @EventHandler
   private void m_1164(Util88 var1) {
      MatrixStack var2 = var1.m_213();
      Camera var3 = f_5909.gameRenderer.getCamera();
      Vec3d var4 = var3.getCameraPos();
      var2.push();
      Util114.m_1481();
      Util114.m_582(770, 1);
      Util114.m_100();
      Util114.m_3978();
      Util114.m_1878(false);
      Identifier var5 = Identifier.of(f_14205, f_14206);
      Util114.m_2037(0, var5);
      Util114.m_3784(RenderUtil7.f_13886);
      BufferBuilder var6 = Util114.m_2494().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      float var7 = this.f_14179.m_4046();

      for (CosmicSwarm.jvqmUIUVyypSdSyd var9 : this.f_14175) {
         Vec3d var10 = this.m_1631(var9.l, var9.f_1041, var1.m_191());
         if (var9.f_1049 == CosmicSwarm.Inner_9zz1kLxC4F4J6YGU.LARVA) {
            this.m_2416(var2, var6, var3, var4, var9, var10, var1.m_191(), var7);
         } else {
            float var11 = this.f_14178.m_4046() * var9.f_1046 * var7;
            var2.push();
            this.m_2441(var2, var10, var4);
            var2.multiply(var3.getRotation());
            int var12 = this.m_198(var9, (float)(f_14207 * var9.f_1048.m_2276() * f_14208));
            this.m_2908(var2, var6, -var11 / 2.0F, -var11 / 2.0F, 0.0, var11, var11, var12);
            var2.pop();
         }
      }

      BuiltBuffer var16 = var6.endNullable();
      if (var16 != null) {
         RenderUtil12.I(var16);
      }

      Util114.m_1878(true);
      Util114.m_2037(0, 0);
      Util114.m_963();
      Util114.m_1562();
      Util114.m_672();
      var2.pop();
      Util114.m_1481();
      Util114.m_672();
      Util114.m_582(770, 1);
      Util114.m_100();
      Util114.m_3978();
      Util114.m_1878(false);
      Util114.m_3784(RenderUtil7.f_13885);
      BufferBuilder var17 = Util114.m_2494().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

      for (CosmicSwarm.jvqmUIUVyypSdSyd var20 : this.f_14175) {
         var20.f_1048.m_3631(var20.f_1047.m_2636(var20.f_1045) ? 0.0 : 1.0);
         Vec3d var21 = this.m_1631(var20.l, var20.f_1041, var1.m_191());
         Vec3d var13 = this.m_1631(var20.f_1040, var20.f_1042, var1.m_191());
         if (var20.f_1049 == CosmicSwarm.Inner_9zz1kLxC4F4J6YGU.LARVA) {
            this.m_3383(var2, var17, var20, var4, var1.m_191());
         } else {
            var2.push();
            var2.translate(var21.x - var4.x, var21.y - var4.y, var21.z - var4.z);
            var2.multiply(new Quaternionf().rotationXYZ((float)var13.x, (float)var13.y, (float)var13.z));
            float var14 = var20.f_1046 * this.f_14179.m_4046();
            var2.scale(var14, var14, var14);
            int var15 = this.m_198(var20, (float)(f_14209 * var20.f_1048.m_2276()));
            this.m_402(var2, var17, new Box(f_14210, f_14211, f_14212, f_14213, f_14214, f_14215), var15);
            var2.pop();
         }
      }

      BuiltBuffer var19 = var17.endNullable();
      if (var19 != null) {
         RenderUtil12.I(var19);
      }

      Util114.m_1878(true);
      Util114.m_542();
      Util114.m_1562();
      Util114.m_100();
      Util114.m_963();
   }

   private int m_198(CosmicSwarm.jvqmUIUVyypSdSyd var1, float var2) {
      if (this.f_14181.m_1163()) {
         float var3 = ((float)(System.currentTimeMillis() - this.f_14182) / f_14282 + var1.f_1050) % 1.0F;
         int var4 = Color.HSBtoRGB(var3, f_14283, 1.0F);
         int var5 = var4 >> 16 & 0xFF;
         int var6 = var4 >> 8 & 0xFF;
         int var7 = var4 & 0xFF;
         int var8 = (int)Math.min(f_14284, Math.max(0.0F, var2));
         return var8 << 24 | var5 << 16 | var6 << 8 | var7;
      } else {
         return this.m_382(var2);
      }
   }

   @EventHandler
   private void m_3339(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (!this.f_14176.m_3862().equals(this.f_14183)) {
            this.f_14175.clear();
            this.f_14183 = this.f_14176.m_3862();
         }

         this.f_14175.removeIf(var0 -> var0.f_1048.m_2276() <= f_14290 && var0.f_1047.m_2636(var0.f_1045));

         for (CosmicSwarm.jvqmUIUVyypSdSyd var3 : this.f_14175) {
            var3.m_436();
            if (!var3.f_1047.m_2636(var3.f_1045)) {
               var3.m_910();
               if (var3.f_1049 == CosmicSwarm.Inner_9zz1kLxC4F4J6YGU.LARVA) {
                  var3.m_1334();
               }
            } else if (var3.f_1049 == CosmicSwarm.Inner_9zz1kLxC4F4J6YGU.LARVA) {
               for (CosmicSwarm.E6XZfexSovxDMzCo var5 : var3.f_1052) {
                  var5.m_494();
               }

               var3.f_1052.removeIf(CosmicSwarm.E6XZfexSovxDMzCo::m_2548);
               var3.f_1053.removeIf(CosmicSwarm.Inner_0ryR0G08ldv76mGA::m_3131);
            }
         }

         int var6 = this.f_14177.m_134().intValue();
         float var7 = this.f_14180.m_4046();
         if (this.f_14175.size() < var6) {
            CosmicSwarm.jvqmUIUVyypSdSyd var8 = this.m_2631(var7);
            if (var8 != null) {
               this.f_14175.add(var8);
            }
         }
      }
   }

   private void m_2416(MatrixStack var1, BufferBuilder var2, Camera var3, Vec3d var4, CosmicSwarm.jvqmUIUVyypSdSyd var5, Vec3d var6, float var7, float var8) {
      float var9 = (float)var5.f_1048.m_2276();
      float var10 = this.f_14178.m_4046() * var5.f_1046 * var8 * f_14248;
      this.m_892(var1, var2, var3, var4, var6, var10 * f_14249, this.m_3741(var5, f_14250 * var9, f_14251));
      this.m_892(var1, var2, var3, var4, var6, var10 * f_14252, this.m_3741(var5, f_14253 * var9, 0.0F));

      for (CosmicSwarm.Inner_0ryR0G08ldv76mGA var12 : var5.f_1053) {
         float var13 = var12.m_3960();
         float var14 = (1.0F - var13) * var9;
         if (!(var14 <= f_14254)) {
            float var15 = var10 * (f_14255 - var13 * f_14256);
            Vec3d var16 = new Vec3d(var12.f_13192, var12.f_13193, var12.f_13194);
            this.m_892(var1, var2, var3, var4, var16, var15, this.m_3741(var5, f_14257 * var14, var13));
         }
      }

      for (CosmicSwarm.E6XZfexSovxDMzCo var18 : var5.f_1052) {
         float var19 = var18.m_1030();
         float var20 = (1.0F - var19) * var9;
         if (!(var20 <= f_14258)) {
            float var21 = var10 * (f_14259 + (1.0F - var19) * f_14260);
            this.m_892(var1, var2, var3, var4, var18.m_3623(var7), var21, this.m_3741(var5, f_14261 * var20, var19 + f_14262));
         }
      }
   }

   static class E6XZfexSovxDMzCo {
      double f_10764;
      double f_10765;
      double f_10766;
      double f_10767;
      double f_10768;
      double f_10769;
      double f_10770;
      double f_10771;
      double f_10772;
      long f_10773;
      int f_10774;
      private static final double f_10775 = 12.0;
      private static final double f_10776 = 0.02;
      private static final double f_10777 = 360.0;
      private static final double f_10778 = -90.0;
      private static final double f_10779 = 180.0;
      private static final double f_10780 = 90.0;
      private static final float f_10781 = 0.45F;
      private static final float f_10782 = 0.45F;
      private static final float f_10783 = 0.45F;

      Vec3d m_3623(float var1) {
         return new Vec3d(
            this.f_10767 + (this.f_10764 - this.f_10767) * var1,
            this.f_10768 + (this.f_10765 - this.f_10768) * var1,
            this.f_10769 + (this.f_10766 - this.f_10769) * var1
         );
      }

      boolean m_2548() {
         return this.m_1030() >= 1.0F;
      }

      void m_494() {
         double var1 = Math.toRadians(this.f_10771);
         this.f_10767 = this.f_10764;
         this.f_10768 = this.f_10765;
         this.f_10769 = this.f_10766;
         this.f_10764 = this.f_10764 + Math.sin(var1) * this.f_10770;
         this.f_10765 = this.f_10765 + Math.cos(Math.toRadians(this.f_10772 - f_10780)) * this.f_10770;
         this.f_10766 = this.f_10766 + Math.cos(var1) * this.f_10770;
      }

      Vec3d m_2193(float var1) {
         return new Vec3d(
            this.f_10767 + (this.f_10764 - this.f_10767) * Math.max(0.0F, var1 - f_10781),
            this.f_10768 + (this.f_10765 - this.f_10768) * Math.max(0.0F, var1 - f_10782),
            this.f_10769 + (this.f_10766 - this.f_10769) * Math.max(0.0F, var1 - f_10783)
         );
      }

      float m_1030() {
         return Math.min(1.0F, (float)(System.currentTimeMillis() - this.f_10773) / this.f_10774);
      }

      E6XZfexSovxDMzCo(Vec3d var1, int var2) {
         this.f_10764 = var1.x;
         this.f_10765 = var1.y;
         this.f_10766 = var1.z;
         this.f_10767 = this.f_10764;
         this.f_10768 = this.f_10765;
         this.f_10769 = this.f_10766;
         this.f_10770 = Math.random() / f_10775 + f_10776;
         this.f_10771 = Math.random() * f_10777;
         this.f_10772 = f_10778 + Math.random() * f_10779;
         this.f_10773 = System.currentTimeMillis();
         this.f_10774 = var2;
      }
   }

   static class Inner_0ryR0G08ldv76mGA {
      double f_13192;
      double f_13193;
      double f_13194;
      long f_13195;
      int f_13196;

      Inner_0ryR0G08ldv76mGA(Vec3d var1, int var2) {
         this.f_13192 = var1.x;
         this.f_13193 = var1.y;
         this.f_13194 = var1.z;
         this.f_13195 = System.currentTimeMillis();
         this.f_13196 = var2;
      }

      float m_3960() {
         return Math.min(1.0F, (float)(System.currentTimeMillis() - this.f_13195) / this.f_13196);
      }

      boolean m_3131() {
         return this.m_3960() >= 1.0F;
      }
   }

   static enum Inner_9zz1kLxC4F4J6YGU {
      CUBE,
      LARVA;
   }

   static class jvqmUIUVyypSdSyd {
      Vec3d l;
      Vec3d f_1040;
      Vec3d f_1041;
      Vec3d f_1042;
      Vec3d f_1043;
      Vec3d f_1044;
      final long f_1045;
      float f_1046;
      final Util125 f_1047 = new Util125();
      final Util165 f_1048;
      final CosmicSwarm.Inner_9zz1kLxC4F4J6YGU f_1049;
      final float f_1050;
      final List<Vec3d> f_1051;
      final List<CosmicSwarm.E6XZfexSovxDMzCo> f_1052;
      final List<CosmicSwarm.Inner_0ryR0G08ldv76mGA> f_1053;
      static final int f_1054 = 42;
      float f_1055;
      float f_1056;
      float f_1057;
      float f_1058;
      int f_1059;
      long f_1060;
      private static final long f_1061 = 400L;
      private static final double f_1062 = 0.04F;
      private static final double f_1063 = 0.04F;
      private static final float f_1064 = 360.0F;
      private static final float f_1065 = 0.12F;
      private static final float f_1066 = 0.34F;
      private static final float f_1067 = -0.045F;
      private static final float f_1068 = 0.07F;
      private static final float f_1069 = 450.0F;
      private static final float f_1070 = 1200.0F;
      private static final double f_1071 = 0.98;
      private static final double f_1072 = 0.98;
      private static final float f_1073 = 450.0F;
      private static final float f_1074 = 1200.0F;
      private static final float f_1075 = -105.0F;
      private static final float f_1076 = 105.0F;
      private static final float f_1077 = 0.045F;
      private static final float f_1078 = 0.997F;
      private static final float f_1079 = 9000.0F;
      private static final float f_1080 = 0.0018F;
      private static final double f_1081 = 9.0E-4F;
      private static final float f_1082 = 0.08F;
      private static final float f_1083 = 0.36F;
      private static final float f_1084 = 0.965F;
      private static final float f_1085 = 6000.0F;
      private static final float f_1086 = 0.0045F;
      private static final double f_1087 = 0.0035F;
      private static final float f_1088 = 0.06F;
      private static final float f_1089 = 0.08F;
      private static final float f_1090 = 0.06F;
      private static final float f_1091 = 360.0F;
      private static final float f_1092 = 180.0F;
      private static final float f_1093 = 360.0F;
      private static final float f_1094 = -180.0F;
      private static final float f_1095 = 360.0F;
      private static final double f_1096 = 0.45;

      void m_3751() {
         for (CosmicSwarm.E6XZfexSovxDMzCo var2 : this.f_1052) {
            var2.m_494();
         }

         this.f_1052.removeIf(CosmicSwarm.E6XZfexSovxDMzCo::m_2548);
      }

      void m_1334() {
         this.f_1053.add(new CosmicSwarm.Inner_0ryR0G08ldv76mGA(this.f_1041, 760));
         this.f_1053.removeIf(CosmicSwarm.Inner_0ryR0G08ldv76mGA::m_3131);

         while (this.f_1053.size() > 54) {
            this.f_1053.remove(0);
         }

         if (this.f_1052.size() < 22) {
            this.f_1052.add(new CosmicSwarm.E6XZfexSovxDMzCo(this.f_1041, 650));
            if (Math.random() > f_1096) {
               this.f_1052.add(new CosmicSwarm.E6XZfexSovxDMzCo(this.f_1041, 520));
            }
         }

         for (CosmicSwarm.E6XZfexSovxDMzCo var2 : this.f_1052) {
            var2.m_494();
         }

         this.f_1052.removeIf(CosmicSwarm.E6XZfexSovxDMzCo::m_2548);
      }

      void m_436() {
         this.l = this.f_1041;
         this.f_1040 = this.f_1042;
         if (this.f_1049 == CosmicSwarm.Inner_9zz1kLxC4F4J6YGU.LARVA) {
            this.m_3710();
         } else {
            this.f_1041 = this.f_1041.add(this.f_1043);
            this.f_1042 = this.f_1042.add(this.f_1044);
            this.f_1043 = this.f_1043.multiply(f_1071);
            this.f_1044 = this.f_1044.multiply(f_1072);
         }
      }

      public jvqmUIUVyypSdSyd(Vec3d var1, Vec3d var2, Vec3d var3, Vec3d var4, long var5, float var7) {
         this(var1, var2, var3, var4, var5, var7, CosmicSwarm.Inner_9zz1kLxC4F4J6YGU.CUBE);
      }

      void m_3710() {
         if (System.currentTimeMillis() - this.f_1060 >= this.f_1059) {
            this.f_1059 = (int)Util39.m_2499(f_1073, f_1074);
            this.f_1060 = System.currentTimeMillis();
            this.f_1056 = this.f_1056 + Util39.m_2499(f_1075, f_1076);
         }

         float var1 = this.m_1517(this.f_1056 - this.f_1055);
         this.f_1055 = this.f_1055 + var1 * f_1077;
         double var2 = Math.toRadians(this.f_1055);
         this.f_1057 = (float)(this.f_1057 * f_1078 + Math.sin(((float)System.currentTimeMillis() + this.f_1050 * f_1079) * f_1080) * f_1081);
         this.f_1057 = Math.max(f_1082, Math.min(f_1083, this.f_1057));
         float var4 = (float)(-Math.sin(var2) * this.f_1057);
         float var5 = (float)(Math.cos(var2) * this.f_1057);
         this.f_1058 = (float)(this.f_1058 * f_1084 + Math.sin(((float)System.currentTimeMillis() + this.f_1050 * f_1085) * f_1086) * f_1087);
         this.f_1041 = this.f_1041.add(var4, this.f_1058, var5);
         this.f_1042 = this.f_1042.add(this.f_1044.x + var4 * f_1088, this.f_1044.y + this.f_1058 * f_1089, this.f_1044.z + var5 * f_1090);
      }

      void m_910() {
         this.f_1051.add(this.f_1041);
         if (this.f_1051.size() > 42) {
            this.f_1051.remove(0);
         }
      }

      private float m_1517(float var1) {
         var1 %= f_1091;
         if (var1 >= f_1092) {
            var1 -= f_1093;
         }

         if (var1 < f_1094) {
            var1 += f_1095;
         }

         return var1;
      }

      public jvqmUIUVyypSdSyd(Vec3d var1, Vec3d var2, Vec3d var3, Vec3d var4, long var5, float var7, CosmicSwarm.Inner_9zz1kLxC4F4J6YGU var8) {
         this.f_1048 = new Util165(Util153.LINEAR, f_1061);
         this.f_1051 = new ArrayList<>();
         this.f_1052 = new ArrayList<>();
         this.f_1053 = new ArrayList<>();
         this.f_1041 = var1;
         this.f_1042 = var2;
         this.f_1043 = var3.multiply(f_1062);
         this.f_1044 = var4.multiply(f_1063);
         this.f_1045 = var5;
         this.f_1046 = var7;
         this.f_1040 = var2;
         this.l = var1;
         this.f_1049 = var8;
         this.f_1050 = Util39.m_2499(0.0F, 1.0F);
         this.f_1048.m_3631(1.0);
         if (var8 == CosmicSwarm.Inner_9zz1kLxC4F4J6YGU.LARVA) {
            this.f_1056 = Util39.m_2499(0.0F, f_1064);
            this.f_1055 = this.f_1056;
            this.f_1057 = Util39.m_2499(f_1065, f_1066);
            this.f_1058 = Util39.m_2499(f_1067, f_1068);
            this.f_1059 = (int)Util39.m_2499(f_1069, f_1070);
            this.f_1060 = System.currentTimeMillis();
         }
      }

      Vec3d m_869(float var1) {
         return new Vec3d(
            this.l.x + (this.f_1041.x - this.l.x) * var1, this.l.y + (this.f_1041.y - this.l.y) * var1, this.l.z + (this.f_1041.z - this.l.z) * var1
         );
      }
   }
}
