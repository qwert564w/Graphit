package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Precipitation;
import org.joml.Matrix4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil6;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util169;
import su.energyclient.util.Util24;
import su.energyclient.util.Util98;
import su.energyclient.util.math.MathUtil6;

public final class RealisticRain extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static RealisticRain f_4178;
   private static final int f_4179 = 64;
   private static final float f_4180 = 0.0F;
   private final ModeSetting f_4181;
   private final ModeSetting f_4182;
   private final ModeSetting f_4183;
   private final NumberSetting f_4184;
   private final BooleanSetting f_4185;
   private final NumberSetting f_4186;
   private final NumberSetting f_4187;
   private final NumberSetting f_4188;
   private final BooleanSetting f_4189;
   private final NumberSetting f_4190;
   private final NumberSetting f_4191;
   private final BooleanSetting f_4192;
   private final BooleanSetting f_4193;
   private final NumberSetting f_4194;
   private final NumberSetting f_4195;
   private final NumberSetting O;
   private final BooleanSetting f_4196;
   private final BooleanSetting f_4197;
   private final Map<Long, RealisticRain.dKyU7a2S3OlUijCp> f_4198;
   private final IntBuffer f_4199;
   private final FloatBuffer f_4200;
   private SimpleFramebuffer f_4201;
   private int f_4202;
   private int f_4203;
   private int f_4204;
   private int f_4205;
   private int f_4206;
   private int f_4207;
   private int f_4208;
   private long f_4209;
   private float f_4210;
   private float f_4211;
   private ClientWorld f_4212;
   private long f_4213;
   private long f_4214;
   private long f_4215;
   private float f_4216;
   private float f_4217;
   private float f_4218;
   private float f_4219;
   private float f_4220;
   private boolean f_4221;
   private boolean f_4222;
   private float f_4223;
   private float f_4224;
   private float f_4225;
   private float f_4226;
   private static final String f_4227 = "Realistic Rain";
   private static final String f_4228 = "Объёмный дождь, капли на объективе, мокрые поверхности, отражения и живые лужи";
   private static final String f_4229 = "Стиль";
   private static final String f_4230 = "Кинематографичный";
   private static final String f_4231 = "Кинематографичный";
   private static final String f_4232 = "Ночной";
   private static final String f_4233 = "Летний";
   private static final String f_4234 = "Шторм";
   private static final String f_4235 = "Показывать";
   private static final String f_4236 = "По погоде";
   private static final String f_4237 = "По погоде";
   private static final String f_4238 = "Всегда";
   private static final String f_4239 = "Качество";
   private static final String f_4240 = "Высокое";
   private static final String f_4241 = "Высокое";
   private static final String f_4242 = "Среднее";
   private static final String f_4243 = "FPS";
   private static final String f_4244 = "Интенсивность";
   private static final float f_4245 = 82.0F;
   private static final float f_4246 = 10.0F;
   private static final float f_4247 = 100.0F;
   private static final String f_4248 = "Объёмные струи";
   private static final String f_4249 = "Плотность струй";
   private static final float f_4250 = 68.0F;
   private static final float f_4251 = 10.0F;
   private static final float f_4252 = 100.0F;
   private static final String f_4253 = "Длина струй";
   private static final float f_4254 = 72.0F;
   private static final float f_4255 = 10.0F;
   private static final float f_4256 = 100.0F;
   private static final String f_4257 = "Ветер";
   private static final float f_4258 = 34.0F;
   private static final float f_4259 = 100.0F;
   private static final String f_4260 = "Лужи";
   private static final String f_4261 = "Количество луж";
   private static final float f_4262 = 72.0F;
   private static final float f_4263 = 100.0F;
   private static final String f_4264 = "Отражения";
   private static final float f_4265 = 68.0F;
   private static final float f_4266 = 100.0F;
   private static final String f_4267 = "Круги на воде";
   private static final String f_4268 = "Капли на объективе";
   private static final String f_4269 = "Количество капель";
   private static final float f_4270 = 68.0F;
   private static final float f_4271 = 100.0F;
   private static final String f_4272 = "Преломление капель";
   private static final float f_4273 = 58.0F;
   private static final float f_4274 = 100.0F;
   private static final String f_4275 = "Высыхание (сек)";
   private static final float f_4276 = 35.0F;
   private static final float f_4277 = 5.0F;
   private static final float f_4278 = 120.0F;
   private static final String f_4279 = "Эхо молнии";
   private static final String f_4280 = "Заменить обычный дождь";
   private static final int f_4281 = Integer.MIN_VALUE;
   private static final int f_4282 = Integer.MIN_VALUE;
   private static final float f_4283 = 99.0F;
   private static final float f_4284 = 0.01F;
   private static final float f_4285 = 0.005F;
   private static final float f_4286 = 0.004F;
   private static final String f_4287 = "Всегда";
   private static final float f_4288 = 0.01F;
   private static final long f_4289 = 1000000L;
   private static final float f_4290 = 0.016666668F;
   private static final float f_4291 = 1.0E9F;
   private static final float f_4292 = 0.1F;
   private static final String f_4293 = "Всегда";
   private static final float f_4294 = 100.0F;
   private static final float f_4295 = 0.72F;
   private static final float f_4296 = 1.15F;
   private static final float f_4297 = 1.8F;
   private static final float f_4298 = 0.9F;
   private static final float f_4299 = 1.65F;
   private static final int f_4300 = 32768;
   private static final long f_4301 = 5000000000L;
   private static final float f_4302 = 7.5F;
   private static final float f_4303 = -1.0F;
   private static final float f_4304 = 6.0F;
   private static final float f_4305 = -1.0F;
   private static final float f_4306 = 0.38F;
   private static final float f_4307 = 0.085F;
   private static final float f_4308 = 0.38F;
   private static final float f_4309 = 0.085F;
   private static final double f_4310 = 1.28;
   private static final float f_4311 = 100.0F;
   private static final float f_4312 = 0.45F;
   private static final float f_4313 = 100.0F;
   private static final float f_4314 = 2.05F;
   private static final double f_4315 = 0.12;
   private static final double f_4316 = 0.76;
   private static final double f_4317 = 0.12;
   private static final double f_4318 = 0.76;
   private static final String f_4319 = "Всегда";
   private static final double f_4320 = 17.0;
   private static final double f_4321 = 0.04;
   private static final double f_4322 = 7.0;
   private static final double f_4323 = 0.2;
   private static final float f_4324 = 1.05F;
   private static final float f_4325 = 1.7F;
   private static final double f_4326 = 0.72;
   private static final double f_4327 = 0.46;
   private static final double f_4328 = 0.08;
   private static final double f_4329 = 0.48;
   private static final double f_4330 = 0.48;
   private static final double f_4331 = 5.0;
   private static final float f_4332 = 0.72F;
   private static final float f_4333 = 0.28F;
   private static final float f_4334 = 0.01F;
   private static final double f_4335 = 0.5;
   private static final double f_4336 = 1.0E-6;
   private static final double f_4337 = 0.008;
   private static final double f_4338 = 28.0;
   private static final double f_4339 = 5.2E-4;
   private static final float f_4340 = 18.0F;
   private static final float f_4341 = 54.0F;
   private static final float f_4342 = 54.0F;
   private static final float f_4343 = 178.0F;
   private static final double f_4344 = 3.2;
   private static final int f_4345 = 9551103;
   private static final int f_4346 = 14148562;
   private static final int f_4347 = 10004665;
   private static final int f_4348 = 12376556;
   private static final int f_4349 = 16777215;
   private static final String f_4350 = "SceneSampler";
   private static final String f_4351 = "DepthSampler";
   private static final String f_4352 = "ExposureSampler";
   private static final String f_4353 = "InvViewMat";
   private static final String f_4354 = "InvProjMat";
   private static final String f_4355 = "Resolution";
   private static final String f_4356 = "CameraPos";
   private static final String f_4357 = "PatternOrigin";
   private static final String f_4358 = "ExposureCameraOffset";
   private static final String f_4359 = "ExposureMapSize";
   private static final float f_4360 = 64.0F;
   private static final String f_4361 = "CameraHeight";
   private static final String f_4362 = "Time";
   private static final String f_4363 = "RainStrength";
   private static final String f_4364 = "Wetness";
   private static final float f_4365 = 100.0F;
   private static final String f_4366 = "PuddleAmount";
   private static final float f_4367 = 100.0F;
   private static final String f_4368 = "ReflectionStrength";
   private static final float f_4369 = 100.0F;
   private static final String f_4370 = "RippleStrength";
   private static final String f_4371 = "Wind";
   private static final String f_4372 = "Lightning";
   private static final String f_4373 = "LightningAge";
   private static final String f_4374 = "Preset";
   private static final String f_4375 = "Quality";
   private static final String f_4376 = "SceneSampler";
   private static final String f_4377 = "Resolution";
   private static final String f_4378 = "Time";
   private static final String f_4379 = "RainStrength";
   private static final String f_4380 = "Wetness";
   private static final float f_4381 = 100.0F;
   private static final String f_4382 = "LensAmount";
   private static final float f_4383 = 100.0F;
   private static final String f_4384 = "Refraction";
   private static final float f_4385 = 100.0F;
   private static final String f_4386 = "Wind";
   private static final String f_4387 = "CameraMotion";
   private static final String f_4388 = "Lightning";
   private static final String f_4389 = "Preset";
   private static final String f_4390 = "Quality";
   private static final long f_4391 = 4294967295L;
   private static final float f_4392 = 100.0F;
   private static final double f_4393 = 0.78;
   private static final double f_4394 = 0.041;
   private static final double f_4395 = 0.72;
   private static final double f_4396 = 0.013;
   private static final double f_4397 = 0.43;
   private static final double f_4398 = 0.35;
   private static final double f_4399 = 0.65;
   private static final double f_4400 = 0.5;
   private static final double f_4401 = 0.5;
   private static final double f_4402 = 0.37;
   private static final float f_4403 = 1.0E9F;
   private static final double f_4404 = 1048576.0;
   private static final double f_4405 = 524288.0;
   private static final double f_4406 = 1048576.0;
   private static final double f_4407 = 1048576.0;
   private static final int f_4408 = Integer.MIN_VALUE;
   private static final long f_4409 = 5000000000L;
   private static final String f_4410 = "Всегда";
   private static final float f_4411 = -10000.0F;
   private static final float f_4412 = -10000.0F;
   private static final int f_4413 = 34016;
   private static final int f_4414 = 33984;
   private static final int f_4415 = 32873;
   private static final int f_4416 = 35055;
   private static final int f_4417 = 35052;
   private static final int f_4418 = 33071;
   private static final int f_4419 = 33071;
   private static final int f_4420 = 33326;
   private static final int f_4421 = 35052;
   private static final int f_4422 = 35052;
   private static final int f_4423 = 36008;
   private static final int f_4424 = 36009;
   private static final int f_4425 = 33984;
   private static final int f_4426 = 34892;
   private static final int f_4427 = 34016;
   private static final int f_4428 = 33984;
   private static final int f_4429 = 32873;
   private static final int f_4430 = 33985;
   private static final int f_4431 = 32873;
   private static final int f_4432 = 33986;
   private static final int f_4433 = 32873;
   private static final int f_4434 = 33984;
   private static final int f_4435 = 33985;
   private static final int f_4436 = 33986;
   private static final int f_4437 = 33986;
   private static final int f_4438 = 33985;
   private static final int f_4439 = 33984;
   private static final float f_4440 = -1.0F;
   private static final float f_4441 = -1.0F;
   private static final float f_4442 = -1.0F;
   private static final float f_4443 = -1.0F;
   private static final float f_4444 = 99.0F;
   private static final int f_4445 = Integer.MIN_VALUE;
   private static final int f_4446 = Integer.MIN_VALUE;
   private static final int f_4447 = 522133279;
   private static final int f_4448 = 1831565813;
   private static final int f_4449 = 73244475;
   private static final int f_4450 = 2146121005;
   private static final int f_4451 = 16777215;
   private static final float f_4452 = 1.6777215E7F;

   private void m_3044(BufferBuilder var1, Matrix4f var2, Vec3d var3, Vec3d var4, Vec3d var5, int var6, int var7) {
      this.m_3957(var1, var2, var3.subtract(var5), var6);
      this.m_3957(var1, var2, var3.add(var5), var6);
      this.m_3957(var1, var2, var4.add(var5), var7);
      this.m_3957(var1, var2, var4.subtract(var5), var7);
   }

   private void m_3849(Camera var1) {
      float var2 = var1.getYaw();
      float var3 = var1.getPitch();
      float var4 = 0.0F;
      float var5 = 0.0F;
      if (this.f_4222) {
         var4 = MathHelper.clamp(MathHelper.wrapDegrees(var2 - this.f_4223) / f_4302, f_4303, 1.0F);
         var5 = MathHelper.clamp((var3 - this.f_4224) / f_4304, f_4305, 1.0F);
      }

      this.f_4223 = var2;
      this.f_4224 = var3;
      this.f_4222 = true;
      this.f_4225 = this.f_4225 + (var4 - this.f_4225) * (Math.abs(var4) > Math.abs(this.f_4225) ? f_4306 : f_4307);
      this.f_4226 = this.f_4226 + (var5 - this.f_4226) * (Math.abs(var5) > Math.abs(this.f_4226) ? f_4308 : f_4309);
   }

   private boolean m_3289() {
      return f_5909.world != null
         && f_5909.player != null
         && f_5909.gameRenderer != null
         && !f_5909.gameRenderer.isRenderingPanorama()
         && f_5909.getWindow() != null;
   }

   private static float m_1548(float var0) {
      return var0 - (float)Math.floor(var0);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void m_1586(Camera var1) {
      Vec3d var2 = var1.getCameraPos();
      int var3 = MathHelper.floor(var2.x);
      int var4 = MathHelper.floor(var2.z);
      long var5 = System.nanoTime();
      boolean var7 = this.f_4207 == f_4408 || Math.abs(var3 - this.f_4207) >= 4 || Math.abs(var4 - this.f_4208) >= 4;
      boolean var8 = this.f_4209 == 0L || var5 - this.f_4209 >= f_4409;
      if (this.f_4204 == 0 || var7 || var8) {
         this.f_4205 = var3 - 32;
         this.f_4206 = var4 - 32;
         this.f_4200.clear();
         boolean var9 = this.f_4182.m_2073(f_4410);

         for (int var10 = 0; var10 < 64; var10++) {
            for (int var11 = 0; var11 < 64; var11++) {
               int var12 = this.f_4205 + var11;
               int var13 = this.f_4206 + var10;
               if (!f_5909.world.isChunkLoaded(var12 >> 4, var13 >> 4)) {
                  this.f_4200.put(f_4411);
               } else {
                  RealisticRain.dKyU7a2S3OlUijCp var14 = this.m_3003(var12, var13);
                  this.f_4200.put(!var9 && !var14.rainable() ? f_4412 : var14.topY());
               }
            }
         }

         this.f_4200.flip();
         int var21 = GL11.glGetInteger(f_4413);
         Util114.m_2836(f_4414);
         int var22 = GL11.glGetInteger(f_4415);
         int var23 = GL11.glGetInteger(3317);
         int var24 = GL11.glGetInteger(3314);
         int var25 = GL11.glGetInteger(3316);
         int var15 = GL11.glGetInteger(3315);
         int var16 = GL11.glGetInteger(f_4416);
         boolean var19 = false /* VF: Semaphore variable */;

         try {
            var19 = true;
            GL11.glPixelStorei(3317, 4);
            GL11.glPixelStorei(3314, 0);
            GL11.glPixelStorei(3316, 0);
            GL11.glPixelStorei(3315, 0);
            GL15.glBindBuffer(f_4417, 0);
            if (this.f_4204 == 0) {
               this.f_4204 = GL11.glGenTextures();
               Util114.m_2012(this.f_4204);
               GL11.glTexParameteri(3553, 10241, 9728);
               GL11.glTexParameteri(3553, 10240, 9728);
               GL11.glTexParameteri(3553, 10242, f_4418);
               GL11.glTexParameteri(3553, 10243, f_4419);
               GL11.glTexImage2D(3553, 0, f_4420, 64, 64, 0, 6403, 5126, this.f_4200);
               var19 = false;
            } else {
               Util114.m_2012(this.f_4204);
               GL11.glTexSubImage2D(3553, 0, 0, 0, 64, 64, 6403, 5126, this.f_4200);
               var19 = false;
            }
         } finally {
            if (var19) {
               GL15.glBindBuffer(f_4422, var16);
               GL11.glPixelStorei(3317, var23);
               GL11.glPixelStorei(3314, var24);
               GL11.glPixelStorei(3316, var25);
               GL11.glPixelStorei(3315, var15);
               Util114.m_2012(var22);
               Util114.m_2836(var21);
            }
         }

         GL15.glBindBuffer(f_4421, var16);
         GL11.glPixelStorei(3317, var23);
         GL11.glPixelStorei(3314, var24);
         GL11.glPixelStorei(3316, var25);
         GL11.glPixelStorei(3315, var15);
         Util114.m_2012(var22);
         Util114.m_2836(var21);
         this.f_4207 = var3;
         this.f_4208 = var4;
         this.f_4209 = var5;
      }

      this.f_4210 = (float)(var2.x - this.f_4205);
      this.f_4211 = (float)(var2.z - this.f_4206);
   }

   private void m_1045(BufferBuilder var1, Matrix4f var2, Vec3d var3, Vec3d var4, Vec3d var5, float var6, double var7) {
      Vec3d var9 = var4.subtract(var3).normalize();
      Vec3d var10 = var3.add(var4).multiply(f_4335);
      Vec3d var11 = var5.subtract(var10).normalize();
      Vec3d var12 = var9.crossProduct(var11);
      if (var12.lengthSquared() < f_4336) {
         var12 = new Vec3d(1.0, 0.0, 0.0);
      } else {
         var12 = var12.normalize();
      }

      double var13 = f_4337 + Math.min(var7, f_4338) * f_4339;
      int var15 = this.m_568();
      int var16 = this.m_3019(var15, (int)(var6 * f_4340));
      int var17 = this.m_3019(var15, (int)(var6 * f_4341));
      int var18 = this.m_3019(var15, (int)(var6 * f_4342));
      int var19 = this.m_3019(var15, (int)(var6 * f_4343));
      this.m_3044(var1, var2, var3, var4, var12.multiply(var13 * f_4344), var16, var17);
      this.m_3044(var1, var2, var3, var4, var12.multiply(var13), var18, var19);
   }

   private void m_336() {
      int var1 = this.f_4204;
      this.f_4204 = 0;
      if (var1 != 0) {
         Util114.m_2697(() -> GL11.glDeleteTextures(var1));
      }
   }

   private int m_3019(int var1, int var2) {
      return MathHelper.clamp(var2, 0, 255) << 24 | var1 & f_4349;
   }

   private float m_1653(double var1) {
      double var3 = f_4404;
      return (float)(var1 - Math.floor((var1 + f_4405) / f_4406) * f_4407);
   }

   @Override
   public void m_2() {
      this.m_299();
      this.f_4213 = System.nanoTime();
      super.m_2();
   }

   private float m_2678() {
      return (float)(System.nanoTime() - this.f_4213) / f_4403;
   }

   private void m_1003(Util98 var1, String var2, float var3) {
      MathUtil6 var4 = var1.m_1335(var2);
      if (var4 != null) {
         var4.O(var3);
      }
   }

   private void m_2178() {
      Framebuffer var1 = f_5909.getFramebuffer();
      int var2 = Math.max(1, var1.textureWidth);
      int var3 = Math.max(1, var1.textureHeight);
      if (this.f_4201 == null || var2 != this.f_4202 || var3 != this.f_4203) {
         if (this.f_4201 != null) {
            this.f_4201.delete();
         }

         this.f_4201 = new SimpleFramebuffer(null, var2, var3, true);
         RenderUtil6.m_4015(this.f_4201, 9728);
         RenderUtil6.m_2715(this.f_4201, 0.0F, 0.0F, 0.0F, 1.0F);
         this.f_4202 = var2;
         this.f_4203 = var3;
      }
   }

   @Override
   public void m_1() {
      this.m_2411();
      this.m_336();
      this.m_299();
      super.m_1();
   }

   private void m_2107(boolean var1) {
      Framebuffer var2 = f_5909.getFramebuffer();
      int var3 = 16384 | (var1 ? 256 : 0);
      GL30.glBindFramebuffer(f_4423, RenderUtil6.m_823(var2));
      GL30.glBindFramebuffer(f_4424, RenderUtil6.m_823(this.f_4201));
      GL30.glBlitFramebuffer(0, 0, var2.textureWidth, var2.textureHeight, 0, 0, this.f_4201.textureWidth, this.f_4201.textureHeight, var3, 9728);
      RenderUtil6.m_4071(var2, true);
   }

   private void m_1626() {
      Util114.m_2836(f_4437);
      Util114.m_2012(0);
      Util114.m_2836(f_4438);
      Util114.m_2012(0);
      Util114.m_2836(f_4439);
      Util114.m_2012(0);
   }

   private void m_3703(Matrix4f var1, Camera var2) {
      Vec3d var3 = var2.getCameraPos();
      MatrixStack var4 = new MatrixStack();
      var4.multiplyPositionMatrix(new Matrix4f(var1));
      var4.translate(-var3.x, -var3.y, -var3.z);
      Matrix4f var5 = var4.peek().getPositionMatrix();
      double var6 = f_4310;
      byte var8 = 15;
      int var9 = (int)Math.floor(var3.x / var6);
      int var10 = (int)Math.floor(var3.z / var6);
      float var11 = this.f_4186.m_4046() / f_4311;
      float var12 = f_4312 + this.f_4187.m_4046() / f_4313 * f_4314;
      float var13 = this.m_2678();
      Vec3d var14 = this.m_3671(var13);
      Util114.m_1481();
      Util114.m_542();
      Util114.m_100();
      Util114.m_1878(false);
      Util114.m_3978();
      Util114.m_3784(RenderUtil7.f_13885);
      BufferBuilder var15 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

      for (int var16 = -var8; var16 <= var8; var16++) {
         for (int var17 = -var8; var17 <= var8; var17++) {
            int var18 = var9 + var16;
            int var19 = var10 + var17;
            float var20 = m_2974(var18, var19, 17);
            if (!(var20 > var11)) {
               double var21 = (var18 + f_4315 + m_2974(var18, var19, 31) * f_4316) * var6;
               double var23 = (var19 + f_4317 + m_2974(var18, var19, 47) * f_4318) * var6;
               double var25 = Math.hypot(var21 - var3.x, var23 - var3.z);
               if (!(var25 > var8 * var6)) {
                  int var27 = MathHelper.floor(var21);
                  int var28 = MathHelper.floor(var23);
                  RealisticRain.dKyU7a2S3OlUijCp var29 = this.m_3003(var27, var28);
                  if (this.f_4182.m_2073(f_4319) || var29.rainable()) {
                     double var30 = var3.y + f_4320;
                     double var32 = Math.max(var29.topY() + f_4321, var3.y - f_4322);
                     double var34 = var30 - var32;
                     if (!(var34 <= f_4323)) {
                        float var36 = m_1548(var13 * (f_4324 + this.f_4216 * f_4325) + m_2974(var18, var19, 73));
                        double var37 = var30 - var36 * var34;
                        double var39 = Math.max(var32, var37 - var12 * (f_4326 + m_2974(var18, var19, 91) * f_4327));
                        if (!(var37 - var39 < f_4328)) {
                           Vec3d var41 = new Vec3d(var21, var37, var23);
                           Vec3d var42 = new Vec3d(var21 + var14.x * var12 * f_4329, var39, var23 + var14.z * var12 * f_4330);
                           float var43 = MathHelper.clamp((float)((var8 * var6 - var25) / f_4331), 0.0F, 1.0F);
                           float var44 = this.f_4216 * var43 * (f_4332 + var20 * f_4333);
                           if (!(var44 <= f_4334)) {
                              this.m_1045(var15, var5, var41, var42, var3, var44, var25);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      BuiltBuffer var45 = var15.endNullable();
      if (var45 != null) {
         RenderUtil12.I(var45);
      }

      Util114.m_1878(true);
      Util114.m_1562();
      Util114.m_963();
   }

   private void m_421() {
      BufferBuilder var1 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
      var1.vertex(f_4440, f_4441, 0.0F).texture(0.0F, 0.0F);
      var1.vertex(f_4442, 1.0F, 0.0F).texture(0.0F, 1.0F);
      var1.vertex(1.0F, 1.0F, 0.0F).texture(1.0F, 1.0F);
      var1.vertex(1.0F, f_4443, 0.0F).texture(1.0F, 0.0F);
      RenderUtil12.I(var1.end());
   }

   public void m_657(Matrix4f var1, Matrix4f var2, Camera var3, float var4) {
      if (this.m_3289()) {
         this.m_600(var3, var4);
         if (this.f_4185.m_1163() && this.f_4216 > f_4284) {
            this.m_3703(var1, var3);
         }

         if (this.f_4189.m_1163() && this.f_4217 > f_4285) {
            this.m_594(var1, var2, var3);
         }
      }
   }

   private float m_1047(float var1, float var2, float var3, float var4, float var5) {
      float var6 = var2 > var1 ? var4 : var5;
      float var7 = var6 * var3;
      return var1 < var2 ? Math.min(var2, var1 + var7) : Math.max(var2, var1 - var7);
   }

   private void m_1438(Util98 var1, String var2, int var3) {
      MathUtil6 var4 = var1.m_1335(var2);
      if (var4 != null) {
         var4.m_55(var3);
      }
   }

   private void m_783(Util98 var1, String var2, float var3, float var4) {
      MathUtil6 var5 = var1.m_1335(var2);
      if (var5 != null) {
         var5.m_54(var3, var4);
      }
   }

   private void m_3957(BufferBuilder var1, Matrix4f var2, Vec3d var3, int var4) {
      var1.vertex(var2, (float)var3.x, (float)var3.y, (float)var3.z).color(var4);
   }

   private void m_299() {
      this.f_4212 = null;
      this.f_4214 = 0L;
      this.f_4215 = 0L;
      this.f_4216 = 0.0F;
      this.f_4217 = 0.0F;
      this.f_4218 = 0.0F;
      this.f_4219 = 0.0F;
      this.f_4220 = f_4444;
      this.f_4221 = false;
      this.f_4222 = false;
      this.f_4225 = 0.0F;
      this.f_4226 = 0.0F;
      this.f_4207 = f_4445;
      this.f_4208 = f_4446;
      this.f_4209 = 0L;
      this.f_4210 = 0.0F;
      this.f_4211 = 0.0F;
      this.f_4198.clear();
   }

   @EventHandler(
      priority = 250
   )
   private void m_4010(Util169 var1) {
      if (this.m_3289() && this.f_4193.m_1163()) {
         Camera var2 = f_5909.gameRenderer.getCamera();
         if (this.f_4212 != f_5909.world || this.f_4214 == 0L) {
            this.m_600(var2, var1.m_4119());
         }

         if (!(this.f_4218 <= f_4286)) {
            this.m_3480();
         }
      }
   }

   private void m_1825(Util98 var1, String var2, Matrix4f var3) {
      MathUtil6 var4 = var1.m_1335(var2);
      if (var4 != null) {
         var4.m_23(var3);
      }
   }

   @EventHandler(
      priority = 200
   )
   private void m_1032(EventNoRender var1) {
      if (var1.m_3456() == EventNoRender.fRxH5AVi9McS5OZn.rain && this.f_4197.m_1163() && f_5909.world != null) {
         if (this.f_4182.m_2073(f_4287) || f_5909.world.getRainGradient(1.0F) > f_4288 && this.m_2258(f_5909.gameRenderer.getCamera().getCameraPos())) {
            var1.m_277(true);
         }
      }
   }

   private void m_1572(int var1) {
      Util114.m_2836(f_4425);
      Util114.m_2012(var1);
      GL11.glTexParameteri(3553, f_4426, 0);
      GL11.glTexParameteri(3553, 10241, 9728);
      GL11.glTexParameteri(3553, 10240, 9728);
      Util114.m_2012(0);
   }

   public RealisticRain() {
      super(f_4227, f_4228, Category.RENDER);
      this.f_4181 = new ModeSetting(f_4229, f_4230, f_4231, f_4232, f_4233, f_4234);
      this.f_4182 = new ModeSetting(f_4235, f_4236, f_4237, f_4238);
      this.f_4183 = new ModeSetting(f_4239, f_4240, f_4241, f_4242, f_4243);
      this.f_4184 = new NumberSetting(f_4244, f_4245, f_4246, f_4247, 1.0F);
      this.f_4185 = new BooleanSetting(f_4248, true);
      this.f_4186 = new NumberSetting(f_4249, f_4250, f_4251, f_4252, 1.0F).m_356(this.f_4185::m_1163);
      this.f_4187 = new NumberSetting(f_4253, f_4254, f_4255, f_4256, 1.0F).m_356(this.f_4185::m_1163);
      this.f_4188 = new NumberSetting(f_4257, f_4258, 0.0F, f_4259, 1.0F);
      this.f_4189 = new BooleanSetting(f_4260, true);
      this.f_4190 = new NumberSetting(f_4261, f_4262, 0.0F, f_4263, 1.0F).m_356(this.f_4189::m_1163);
      this.f_4191 = new NumberSetting(f_4264, f_4265, 0.0F, f_4266, 1.0F).m_356(this.f_4189::m_1163);
      this.f_4192 = new BooleanSetting(f_4267, true).m_334(this.f_4189::m_1163);
      this.f_4193 = new BooleanSetting(f_4268, true);
      this.f_4194 = new NumberSetting(f_4269, f_4270, 0.0F, f_4271, 1.0F).m_356(this.f_4193::m_1163);
      this.f_4195 = new NumberSetting(f_4272, f_4273, 0.0F, f_4274, 1.0F).m_356(this.f_4193::m_1163);
      this.O = new NumberSetting(f_4275, f_4276, f_4277, f_4278, 1.0F);
      this.f_4196 = new BooleanSetting(f_4279, true);
      this.f_4197 = new BooleanSetting(f_4280, true);
      this.f_4198 = new HashMap<>();
      this.f_4199 = BufferUtils.createIntBuffer(4);
      this.f_4200 = BufferUtils.createFloatBuffer(4096);
      this.f_4202 = -1;
      this.f_4203 = -1;
      this.f_4207 = f_4281;
      this.f_4208 = f_4282;
      this.f_4213 = System.nanoTime();
      this.f_4220 = f_4283;
      f_4178 = this;
   }

   private Vec3d m_3671(float var1) {
      float var2 = this.f_4188.m_4046() / f_4392;
      double var3 = f_4393 + Math.sin(var1 * f_4394) * f_4395 + Math.sin(var1 * f_4396) * f_4397;
      double var5 = var2 * (f_4398 + f_4399 * (f_4400 + f_4401 * Math.sin(var1 * f_4402)));
      return new Vec3d(Math.cos(var3) * var5, 0.0, Math.sin(var3) * var5);
   }

   private static float m_2974(int var0, int var1, int var2) {
      int var3 = var0 * f_4447 ^ var1 * f_4448 ^ var2 * f_4449;
      var3 ^= var3 >>> 16;
      var3 *= f_4450;
      var3 ^= var3 >>> 15;
      return (var3 & f_4451) / f_4452;
   }

   private RealisticRain.PWjx7DWtx3rGGtxX m_1277() {
      boolean var1 = GL11.glIsEnabled(3089);
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      if (var1) {
         this.f_4199.clear();
         GL11.glGetIntegerv(3088, this.f_4199);
         var2 = this.f_4199.get(0);
         var3 = this.f_4199.get(1);
         var4 = this.f_4199.get(2);
         var5 = this.f_4199.get(3);
      }

      int var6 = GL11.glGetInteger(f_4427);
      Util114.m_2836(f_4428);
      int var7 = GL11.glGetInteger(f_4429);
      Util114.m_2836(f_4430);
      int var8 = GL11.glGetInteger(f_4431);
      Util114.m_2836(f_4432);
      int var9 = GL11.glGetInteger(f_4433);
      Util114.m_2836(var6);
      return new RealisticRain.PWjx7DWtx3rGGtxX(
         GL11.glIsEnabled(3042), GL11.glIsEnabled(2929), GL11.glIsEnabled(2884), var1, GL11.glGetBoolean(2930), var2, var3, var4, var5, var6, var7, var8, var9
      );
   }

   private RealisticRain.dKyU7a2S3OlUijCp m_3003(int var1, int var2) {
      long var3 = (long)var1 << 32 ^ var2 & f_4391;
      RealisticRain.dKyU7a2S3OlUijCp var5 = this.f_4198.get(var3);
      if (var5 != null) {
         return var5;
      } else {
         int var6 = f_5909.world.getTopY(Type.MOTION_BLOCKING, var1, var2);
         BlockPos var7 = new BlockPos(var1, var6, var2);
         boolean var8 = ((Biome)f_5909.world.getBiome(var7).value()).getPrecipitation(var7, f_5909.world.getSeaLevel()) == Precipitation.RAIN;
         RealisticRain.dKyU7a2S3OlUijCp var9 = new RealisticRain.dKyU7a2S3OlUijCp(var6, var8);
         this.f_4198.put(var3, var9);
         return var9;
      }
   }

   private boolean m_2258(Vec3d var1) {
      BlockPos var2 = BlockPos.ofFloored(var1);
      return ((Biome)f_5909.world.getBiome(var2).value()).getPrecipitation(var2, f_5909.world.getSeaLevel()) == Precipitation.RAIN;
   }

   private int m_568() {
      return switch (this.f_4181.m_2312()) {
         case 1 -> f_4345;
         case 2 -> f_4346;
         case 3 -> f_4347;
         default -> f_4348;
      };
   }

   private void m_600(Camera var1, float var2) {
      long var3 = System.nanoTime();
      if (this.f_4212 != f_5909.world) {
         this.m_299();
         this.f_4212 = f_5909.world;
         this.f_4213 = var3;
      }

      if (this.f_4214 == 0L || var3 - this.f_4214 >= f_4289) {
         float var5 = this.f_4214 == 0L ? f_4290 : (float)(var3 - this.f_4214) / f_4291;
         var5 = Math.min(var5, f_4292);
         this.f_4214 = var3;
         boolean var6 = this.f_4182.m_2073(f_4293);
         Vec3d var7 = var1.getCameraPos();
         float var8 = var6 ? 1.0F : f_5909.world.getRainGradient(var2);
         boolean var9 = var6 || this.m_2258(var7);
         float var10 = var9 ? var8 : 0.0F;
         this.f_4216 = var10 * this.f_4184.m_4046() / f_4294;
         float var11 = Math.max(1.0F, this.O.m_4046());
         this.f_4217 = this.m_1047(this.f_4217, var10, var5, f_4295, 1.0F / var11);
         boolean var12 = var6 || f_5909.world.hasRain(BlockPos.ofFloored(var7));
         float var13 = var12 ? var8 : 0.0F;
         this.f_4218 = this.m_1047(this.f_4218, var13, var5, f_4296, f_4297 / var11);
         boolean var14 = f_5909.world.getThunderGradient(1.0F) > f_4298;
         if (var14 && !this.f_4221) {
            this.f_4219 = 1.0F;
            this.f_4220 = 0.0F;
         } else {
            this.f_4219 = Math.max(0.0F, this.f_4219 - var5 * f_4299);
            this.f_4220 += var5;
         }

         this.f_4221 = var14;
         this.m_3849(var1);
         if (this.f_4198.size() > f_4300 && (this.f_4215 == 0L || var3 - this.f_4215 > f_4301)) {
            this.f_4198.clear();
            this.f_4215 = var3;
         }
      }
   }

   private void m_3480() {
      Util98 var1 = Util114.m_827(Util24.f_3284);
      if (var1 != null) {
         this.m_2178();
         if (this.f_4201 != null) {
            Framebuffer var2 = f_5909.getFramebuffer();
            RealisticRain.PWjx7DWtx3rGGtxX var3 = this.m_1277();

            try {
               Util114.m_3706();
               this.m_2107(false);
               RenderUtil6.m_4071(var2, true);
               Util114.m_963();
               Util114.m_672();
               Util114.m_1878(false);
               Util114.m_3978();
               Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
               var1.m_3726(f_4376, RenderUtil6.m_668(this.f_4201.getColorAttachment()));
               this.m_783(var1, f_4377, this.f_4202, this.f_4203);
               this.m_1003(var1, f_4378, this.m_2678());
               this.m_1003(var1, f_4379, this.f_4216);
               this.m_1003(var1, f_4380, this.f_4218 * this.f_4184.m_4046() / f_4381);
               this.m_1003(var1, f_4382, this.f_4194.m_4046() / f_4383);
               this.m_1003(var1, f_4384, this.f_4195.m_4046() / f_4385);
               Vec3d var4 = this.m_3671(this.m_2678());
               this.m_783(var1, f_4386, (float)var4.x, (float)var4.z);
               this.m_783(var1, f_4387, this.f_4225, this.f_4226);
               this.m_1003(var1, f_4388, this.f_4196.m_1163() ? this.f_4219 : 0.0F);
               this.m_1438(var1, f_4389, this.f_4181.m_2312());
               this.m_1438(var1, f_4390, this.f_4183.m_2312());
               Util114.m_3784(Util24.f_3284);
               this.m_421();
            } finally {
               this.m_1626();
               this.m_3819(var3);
               RenderUtil6.m_4071(var2, true);
            }
         }
      }
   }

   private void m_594(Matrix4f var1, Matrix4f var2, Camera var3) {
      Util98 var4 = Util114.m_827(Util24.f_3283);
      if (var4 != null) {
         this.m_1586(var3);
         if (this.f_4204 != 0) {
            this.m_2178();
            if (this.f_4201 != null) {
               Framebuffer var5 = f_5909.getFramebuffer();
               RealisticRain.PWjx7DWtx3rGGtxX var6 = this.m_1277();

               try {
                  Util114.m_3706();
                  this.m_2107(true);
                  this.m_1572(RenderUtil6.m_668(this.f_4201.getDepthAttachment()));
                  RenderUtil6.m_4071(var5, true);
                  Util114.m_963();
                  Util114.m_672();
                  Util114.m_1878(false);
                  Util114.m_3978();
                  Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
                  var4.m_3726(f_4350, RenderUtil6.m_668(this.f_4201.getColorAttachment()));
                  var4.m_3726(f_4351, RenderUtil6.m_668(this.f_4201.getDepthAttachment()));
                  var4.m_3726(f_4352, this.f_4204);
                  this.m_1825(var4, f_4353, new Matrix4f(var1).invert());
                  this.m_1825(var4, f_4354, new Matrix4f(var2).invert());
                  this.m_783(var4, f_4355, this.f_4202, this.f_4203);
                  Vec3d var7 = var3.getCameraPos();
                  this.m_3054(var4, f_4356, (float)var7.x, (float)var7.y, (float)var7.z);
                  this.m_783(var4, f_4357, this.m_1653(var7.x), this.m_1653(var7.z));
                  this.m_783(var4, f_4358, this.f_4210, this.f_4211);
                  this.m_1003(var4, f_4359, f_4360);
                  this.m_1003(var4, f_4361, (float)var7.y);
                  this.m_1003(var4, f_4362, this.m_2678());
                  this.m_1003(var4, f_4363, this.f_4216);
                  this.m_1003(var4, f_4364, this.f_4217 * this.f_4184.m_4046() / f_4365);
                  this.m_1003(var4, f_4366, this.f_4190.m_4046() / f_4367);
                  this.m_1003(var4, f_4368, this.f_4191.m_4046() / f_4369);
                  this.m_1003(var4, f_4370, this.f_4192.m_1163() ? 1.0F : 0.0F);
                  Vec3d var8 = this.m_3671(this.m_2678());
                  this.m_783(var4, f_4371, (float)var8.x, (float)var8.z);
                  this.m_1003(var4, f_4372, this.f_4196.m_1163() ? this.f_4219 : 0.0F);
                  this.m_1003(var4, f_4373, this.f_4220);
                  this.m_1438(var4, f_4374, this.f_4181.m_2312());
                  this.m_1438(var4, f_4375, this.f_4183.m_2312());
                  Util114.m_3784(Util24.f_3283);
                  this.m_421();
               } finally {
                  this.m_1626();
                  this.m_3819(var6);
                  RenderUtil6.m_4071(var5, true);
               }
            }
         }
      }
   }

   private void m_2411() {
      SimpleFramebuffer var1 = this.f_4201;
      this.f_4201 = null;
      this.f_4202 = -1;
      this.f_4203 = -1;
      if (var1 != null) {
         Util114.m_2697(var1::delete);
      }
   }

   private void m_3054(Util98 var1, String var2, float var3, float var4, float var5) {
      MathUtil6 var6 = var1.m_1335(var2);
      if (var6 != null) {
         var6.m_33(var3, var4, var5);
      }
   }

   private void m_3819(RealisticRain.PWjx7DWtx3rGGtxX var1) {
      Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      Util114.m_1878(var1.depthWrite());
      if (var1.blend()) {
         Util114.m_1481();
      } else {
         Util114.m_963();
      }

      if (var1.depth()) {
         Util114.m_100();
      } else {
         Util114.m_672();
      }

      if (var1.cull()) {
         Util114.m_1562();
      } else {
         Util114.m_3978();
      }

      if (var1.scissor()) {
         Util114.m_2740(var1.x(), var1.y(), var1.width(), var1.height());
      } else {
         Util114.m_3706();
      }

      Util114.m_2836(f_4434);
      Util114.m_2012(var1.texture0());
      Util114.m_2836(f_4435);
      Util114.m_2012(var1.texture1());
      Util114.m_2836(f_4436);
      Util114.m_2012(var1.texture2());
      Util114.m_2836(var1.activeTexture());
   }

   private record PWjx7DWtx3rGGtxX(
      boolean blend,
      boolean depth,
      boolean cull,
      boolean scissor,
      boolean depthWrite,
      int x,
      int y,
      int width,
      int height,
      int activeTexture,
      int texture0,
      int texture1,
      int texture2
   ) {
   }

   private record dKyU7a2S3OlUijCp(int topY, boolean rainable) {
   }
}
