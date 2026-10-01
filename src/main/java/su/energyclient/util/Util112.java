package su.energyclient.util;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.lwjgl.glfw.GLFW;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Module;

public class Util112 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_13261 = 2.0F;
   private static final float f_13262 = 0.0F;
   private static final float f_13263 = 0.0F;
   private static final float f_13264 = 0.0F;
   private static final float f_13265 = 0.0F;
   private static final float f_13266 = 0.0F;
   private static final float f_13267 = 0.0F;
   private static final float f_13268 = 0.0F;
   private static final float f_13269 = 0.0F;
   private static final float f_13270 = 0.0F;
   private static final int f_13271 = 0;
   private static final float f_13272 = 0.0F;
   private static final float f_13273 = 0.0F;
   private static final float f_13274 = 0.0F;
   private static final long f_13275 = 0L;
   private static final float[] f_13276 = new float[]{Util112.f_13393, Util112.f_13394, Util112.f_13395, Util112.f_13396, Util112.f_13397};
   private float f_13277;
   private float f_13278;
   private final float f_13279;
   private final float f_13280;
   private float f_13281;
   private float f_13282;
   private boolean f_13283;
   private boolean f_13284;
   private boolean f_13285;
   private float f_13286;
   private float f_13287;
   private final String f_13288;
   private final Module f_13289;
   private float f_13290;
   private float f_13291;
   private float f_13292;
   private float f_13293;
   private boolean f_13294;
   private final Util165 f_13295;
   private final Util165 f_13296;
   private final Util165 f_13297;
   private final Util165 f_13298;
   private final Util165 f_13299;
   private Util112.CtTBIDR0bpZdLsPH f_13300;
   private Util112.CtTBIDR0bpZdLsPH f_13301;
   private Util112.CtTBIDR0bpZdLsPH f_13302;
   private Util112.CtTBIDR0bpZdLsPH f_13303;
   private long f_13304;
   private long f_13305;
   private static final long f_13306 = 165L;
   private static final long f_13307 = 145L;
   private static final long f_13308 = 145L;
   private static final long f_13309 = 190L;
   private static final long f_13310 = 240L;
   private static final float f_13311 = 29.0F;
   private static final float f_13312 = 24.0F;
   private static final float f_13313 = 0.025F;
   private static final float f_13314 = 0.025F;
   private static final float f_13315 = 0.025F;
   private static final float f_13316 = 0.025F;
   private static final double f_13317 = 0.001;
   private static final double f_13318 = 0.001;
   private static final float f_13319 = 6.0F;
   private static final float f_13320 = 6.0F;
   private static final float f_13321 = 6.0F;
   private static final float f_13322 = 6.0F;
   private static final float f_13323 = 6.0F;
   private static final float f_13324 = 6.0F;
   private static final float f_13325 = 6.0F;
   private static final float f_13326 = 6.0F;
   private static final float f_13327 = 6.0F;
   private static final float f_13328 = 6.0F;
   private static final float f_13329 = 7.0F;
   private static final float f_13330 = 7.0F;
   private static final float f_13331 = 6.0F;
   private static final float f_13332 = 6.0F;
   private static final float f_13333 = 6.0F;
   private static final float f_13334 = 6.0F;
   private static final float f_13335 = 6.0F;
   private static final float f_13336 = 6.0F;
   private static final float f_13337 = 6.0F;
   private static final float f_13338 = 6.0F;
   private static final float f_13339 = 6.0F;
   private static final float f_13340 = 6.0F;
   private static final float f_13341 = 7.0F;
   private static final float f_13342 = 7.0F;
   private static final float f_13343 = 13.0F;
   private static final float f_13344 = 7.5F;
   private static final float f_13345 = 1.5F;
   private static final float f_13346 = 1.5F;
   private static final long f_13347 = 750000000L;
   private static final float f_13348 = 0.001F;
   private static final float f_13349 = 0.001F;
   private static final float f_13350 = 0.001F;
   private static final float f_13351 = 8.0F;
   private static final float f_13352 = 0.001F;
   private static final float f_13353 = 0.86F;
   private static final float f_13354 = 0.14F;
   private static final double f_13355 = 1.7E8;
   private static final float f_13356 = 1.5F;
   private static final float f_13357 = 3.25F;
   private static final float f_13358 = 2.4F;
   private static final float f_13359 = 0.1F;
   private static final float f_13360 = 0.75F;
   private static final float f_13361 = 0.7F;
   private static final float f_13362 = 0.95F;
   private static final float f_13363 = 0.7F;
   private static final float f_13364 = 0.95F;
   private static final float f_13365 = 0.5F;
   private static final float f_13366 = 0.5F;
   private static final double f_13367 = 1.05E8;
   private static final float f_13368 = 8.0F;
   private static final float f_13369 = 0.1F;
   private static final float f_13370 = 0.06F;
   private static final float f_13371 = 4.6F;
   private static final int f_13372 = -16250354;
   private static final float f_13373 = 0.92F;
   private static final float f_13374 = 2.35F;
   private static final float f_13375 = 0.92F;
   private static final float f_13376 = 0.08F;
   private static final double f_13377 = 1.5E8;
   private static final float f_13378 = 0.24F;
   private static final float f_13379 = 3.0F;
   private static final float f_13380 = 9.0F;
   private static final float f_13381 = 0.45F;
   private static final float f_13382 = 1.5F;
   private static final float f_13383 = 1.75F;
   private static final float f_13384 = 2.4F;
   private static final float f_13385 = 0.11F;
   private static final float f_13386 = 0.75F;
   private static final float f_13387 = 1.0E9F;
   private static final float f_13388 = 0.05F;
   private static final double f_13389 = 2.0;
   private static final double f_13390 = 2.0;
   private static final double f_13391 = 2.0;
   private static final double f_13392 = 2.0;
   private static final float f_13393 = 0.125F;
   private static final float f_13394 = 0.25F;
   private static final float f_13395 = 0.5F;
   private static final float f_13396 = 0.75F;
   private static final float f_13397 = 0.875F;

   private static float m_3833(float var0) {
      return !Float.isFinite(var0) ? 0.0F : Math.round(var0 * 2.0F) / 2.0F;
   }

   public boolean m_1504() {
      return this.f_13294;
   }

   public float m_2021() {
      return this.f_13278;
   }

   private static float m_3996(float var0, float var1) {
      return Float.isFinite(var0) ? var0 : var1;
   }

   public Util112.CtTBIDR0bpZdLsPH m_2632() {
      return this.f_13302;
   }

   private static void m_2436(float var0, float var1, float var2, int var3, Window var4) {
      float var5 = m_3390(var2, var4);
      float var6 = m_459(var2, var4);
      Util158.m_1849(m_3390(var0, var4) - var5 / 2.0F, m_459(var1, var4) - var6 / 2.0F, var5, var6, Math.min(var5, var6) / 2.0F, var3);
   }

   public float m_527() {
      return this.f_13277;
   }

   public void m_1709() {
      this.f_13285 = false;
      if (!this.f_13283 && !this.f_13284) {
         this.f_13300 = null;
         this.f_13301 = null;
         this.m_3920();
      } else {
         this.m_1822();
      }
   }

   public Util112.CtTBIDR0bpZdLsPH m_1683() {
      return this.f_13301;
   }

   private static float m_459(float var0, Window var1) {
      return var0 * 2.0F * var1.getScaledHeight() / Math.max(1.0F, (float)var1.getHeight());
   }

   public Util165 m_1980() {
      return this.f_13296;
   }

   public void m_1405(double var1, double var3, int var5) {
      if (var5 == 1) {
         this.f_13285 = false;
         this.m_3920();
      } else if (var5 == 0 && this.f_13283) {
         MinecraftClient var6 = MinecraftClient.getInstance();
         Window var7 = var6 != null ? var6.getWindow() : null;
         if (var7 != null) {
            float var8 = Math.max(0.0F, var7.getWidth() / 2.0F);
            float var9 = Math.max(0.0F, var7.getHeight() / 2.0F);
            if (var8 > 0.0F && var9 > 0.0F) {
               this.m_2060(m_1390(var1, var7), m_181(var3, var7), var8, var9, System.nanoTime());
            }
         }

         this.m_1575();
      }
   }

   public void m_1817(float var1) {
      this.f_13277 = m_3833(m_3996(var1, this.f_13279));
      this.f_13290 = this.f_13277;
      this.f_13292 = this.f_13277;
   }

   private boolean m_918(float var1, float var2, long var3) {
      float var5 = this.m_2227();
      float var6 = this.m_2310();
      return this.m_1193(var3) && var1 >= var5 && var1 <= var5 + this.f_13286 && var2 >= var6 && var2 <= var6 + this.f_13287;
   }

   public float m_671() {
      return m_3833(this.f_13278);
   }

   private static float m_181(double var0, Window var2) {
      return (float)(var0 * var2.getHeight() / Math.max(1.0, (double)var2.getScaledHeight()) / f_13390);
   }

   private List<Util112.CtTBIDR0bpZdLsPH> m_3007(float var1, float var2, float var3, float var4, long var5) {
      ArrayList var7 = new ArrayList();
      float var8 = Math.max(0.0F, var3 - this.f_13286);
      float var9 = this.m_671();
      m_3799(var7, null, 0, f_13319, f_13320, f_13321, var4 - f_13322, var1, var8);

      for (int var10 = 0; var10 < f_13276.length; var10++) {
         float var11 = var3 * f_13276[var10];
         float var12 = var11 - this.f_13286 / 2.0F;
         m_3799(var7, null, var10 + 1, var12, var11, f_13323, var4 - f_13324, var1, var8);
      }

      float var19 = var3 - f_13325 - this.f_13286;
      m_3799(var7, null, 100, var19, var3 - f_13326, f_13327, var4 - f_13328, var1, var8);

      for (Util112 var21 : this.m_1146()) {
         if (var21 != this && var21.m_1193(var5)) {
            float var13 = var21.m_2838();
            float var14 = var21.m_671();
            float var15 = m_2001(Math.min(Math.min(var2, var9), var14) - f_13329, 0.0F, var4);
            float var16 = m_2001(Math.max(Math.max(var2 + this.f_13287, var9 + this.f_13287), var14 + var21.f_13287) + f_13330, 0.0F, var4);
            m_3799(var7, var21, 0, var13, var13, var15, var16, var1, var8);
            float var17 = var13 + var21.f_13286 / 2.0F;
            m_3799(var7, var21, 1, var17 - this.f_13286 / 2.0F, var17, var15, var16, var1, var8);
            float var18 = var13 + var21.f_13286;
            m_3799(var7, var21, 2, var18 - this.f_13286, var18, var15, var16, var1, var8);
         }
      }

      return var7;
   }

   private float m_3667(long var1) {
      long var3 = var1 - this.f_13304;
      this.f_13304 = var1;
      return var3 <= 0L ? 0.0F : Math.min((float)var3 / f_13387, f_13388);
   }

   public void m_1597(float var1) {
      this.f_13286 = l(var1);
      this.f_13305 = System.nanoTime();
   }

   private static void m_1694(Util112.CtTBIDR0bpZdLsPH var0, float var1, int var2, Window var3) {
      float var4 = m_3390(var0.f_3982, var3);
      float var5 = m_459(var0.f_3983, var3);
      float var6 = m_459(var0.f_3984 - var0.f_3983, var3);
      float var7 = m_3390(f_13361, var3);
      Util158.m_1849(var4 - var7 / 2.0F, var5, var7, var6, var7 / 2.0F, Util71.m_1907(var2, var1 * f_13362));
   }

   public Util165 m_2373() {
      return this.f_13299;
   }

   private boolean m_1193(long var1) {
      return this.f_13286 >= f_13345
         && this.f_13287 >= f_13346
         && this.f_13305 != 0L
         && var1 - this.f_13305 <= f_13347
         && (this.f_13289 == null || this.f_13289.m_677());
   }

   public Module m_84() {
      return this.f_13289;
   }

   public boolean m_2481() {
      return this.f_13283;
   }

   public float m_774() {
      return this.f_13282;
   }

   private static float m_3390(float var0, Window var1) {
      return var0 * 2.0F * var1.getScaledWidth() / Math.max(1.0F, (float)var1.getWidth());
   }

   public void m_1076(float var1) {
      this.f_13287 = l(var1);
      this.f_13305 = System.nanoTime();
   }

   public float m_1078() {
      return this.f_13286;
   }

   public void m_3694(float var1) {
      this.f_13278 = m_3833(m_3996(var1, this.f_13280));
      this.f_13291 = this.f_13278;
      this.f_13293 = this.f_13278;
   }

   public float m_707() {
      return this.f_13279;
   }

   private void m_1267(float var1, float var2, float var3, Window var4, long var5) {
      float var7 = m_2001(var3, 0.0F, 1.0F);
      float var8 = f_13353 + f_13354 * (float)Math.sin(var5 / f_13355);
      float var9 = f_13356 + f_13357 * (1.0F - var3);
      this.m_970(var1, var2, var9, f_13358, Util71.m_1907(-1, var7 * f_13359), var4);
      this.m_970(var1, var2, var9, f_13360, Util71.m_1907(-1, var7 * var8), var4);
   }

   public Util112.CtTBIDR0bpZdLsPH m_1667() {
      return this.f_13300;
   }

   private List<Util112> m_1146() {
      return (List<Util112>)(InitManager.f_2740 != null && InitManager.f_2740.f_2743 != null ? InitManager.f_2740.f_2743.m_2418() : List.of());
   }

   private void m_2052(float var1, float var2, float var3, float var4, float var5, int var6, Window var7) {
      m_3659(var1 - var3, var2 - var3, var4, var5, var5 / 2.0F, var6, var7);
      m_3659(var1 - var3, var2 - var3, var5, var4, var5 / 2.0F, var6, var7);
      m_3659(var1 + this.f_13286 + var3 - var4, var2 - var3, var4, var5, var5 / 2.0F, var6, var7);
      m_3659(var1 + this.f_13286 + var3 - var5, var2 - var3, var5, var4, var5 / 2.0F, var6, var7);
      m_3659(var1 - var3, var2 + this.f_13287 + var3 - var5, var4, var5, var5 / 2.0F, var6, var7);
      m_3659(var1 - var3, var2 + this.f_13287 + var3 - var4, var5, var4, var5 / 2.0F, var6, var7);
      m_3659(var1 + this.f_13286 + var3 - var4, var2 + this.f_13287 + var3 - var5, var4, var5, var5 / 2.0F, var6, var7);
      m_3659(var1 + this.f_13286 + var3 - var5, var2 + this.f_13287 + var3 - var4, var5, var4, var5 / 2.0F, var6, var7);
   }

   private void m_3450() {
      this.f_13286 = l(this.f_13286);
      this.f_13287 = l(this.f_13287);
      this.f_13277 = m_3996(this.f_13277, this.f_13279);
      this.f_13278 = m_3996(this.f_13278, this.f_13280);
      this.f_13290 = m_3996(this.f_13290, this.f_13277);
      this.f_13291 = m_3996(this.f_13291, this.f_13278);
   }

   private static float m_2001(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   private static void m_878(Util112.CtTBIDR0bpZdLsPH var0, float var1, int var2, Window var3) {
      float var4 = m_3390(var0.f_3983, var3);
      float var5 = m_459(var0.f_3982, var3);
      float var6 = m_3390(var0.f_3984 - var0.f_3983, var3);
      float var7 = m_459(f_13363, var3);
      Util158.m_1849(var4, var5 - var7 / 2.0F, var6, var7, var7 / 2.0F, Util71.m_1907(var2, var1 * f_13364));
   }

   private void m_1575() {
      this.m_2281();
      this.f_13283 = false;
      this.f_13290 = m_3833(m_3996(this.f_13290, this.f_13277));
      this.f_13291 = m_3833(m_3996(this.f_13291, this.f_13278));
      this.f_13284 = Math.abs(this.f_13290 - this.f_13277) > f_13315 || Math.abs(this.f_13291 - this.f_13278) > f_13316;
      this.f_13300 = null;
      this.f_13301 = null;
      if (!this.f_13284) {
         this.f_13277 = m_3996(this.f_13290, this.f_13277);
         this.f_13278 = m_3996(this.f_13291, this.f_13278);
      }

      this.m_3920();
   }

   public void m_1618(int var1, int var2, Window var3) {
      if (var3 != null) {
         long var4 = System.nanoTime();
         float var6 = this.m_3667(var4);
         float var7 = Math.max(0.0F, var3.getWidth() / 2.0F);
         float var8 = Math.max(0.0F, var3.getHeight() / 2.0F);
         if (!(var7 <= 0.0F) && !(var8 <= 0.0F)) {
            this.m_3450();
            float var9 = this.m_2838();
            float var10 = this.m_671();
            this.f_13292 = var9;
            this.f_13293 = var10;
            this.f_13294 = true;
            if (this.f_13285 && GLFW.glfwGetMouseButton(var3.getHandle(), 1) != 1) {
               this.f_13285 = false;
            }

            if (this.f_13283 && GLFW.glfwGetMouseButton(var3.getHandle(), 0) != 1) {
               this.m_2060(m_1408(var1, var3), m_1758(var2, var3), var7, var8, var4);
               this.m_1575();
            }

            if (this.f_13283) {
               float var11 = m_1408(var1, var3);
               float var12 = m_1758(var2, var3);
               this.m_2060(var11, var12, var7, var8, var4);
            } else {
               this.f_13300 = null;
               this.f_13301 = null;
            }

            this.f_13290 = m_2122(this.f_13290, this.f_13286, var7);
            this.f_13291 = m_2122(this.f_13291, this.f_13287, var8);
            if (!this.f_13283 && !this.f_13284) {
               this.f_13277 = m_2122(this.f_13277, this.f_13286, var7);
               this.f_13278 = m_2122(this.f_13278, this.f_13287, var8);
               this.f_13290 = this.f_13277;
               this.f_13291 = this.f_13278;
            } else {
               float var15 = this.f_13283 ? f_13311 : f_13312;
               float var16 = 1.0F - (float)Math.exp(-var15 * var6);
               this.f_13277 = this.f_13277 + (this.f_13290 - this.f_13277) * var16;
               this.f_13278 = this.f_13278 + (this.f_13291 - this.f_13278) * var16;
               boolean var13 = Math.abs(this.f_13290 - this.f_13277) <= f_13313;
               boolean var14 = Math.abs(this.f_13291 - this.f_13278) <= f_13314;
               if (var13) {
                  this.f_13277 = this.f_13290;
               }

               if (var14) {
                  this.f_13278 = this.f_13291;
               }

               if (this.f_13284 && var13 && var14) {
                  this.f_13284 = false;
               }
            }

            this.f_13277 = m_3704(this.f_13277, this.f_13286, var7);
            this.f_13278 = m_3704(this.f_13278, this.f_13287, var8);
            this.m_3920();
            this.m_1116(var3, var4, var9, var10);
         }
      }
   }

   private void m_2060(float var1, float var2, float var3, float var4, long var5) {
      float var7 = m_3704(var1 - this.f_13281, this.f_13286, var3);
      float var8 = m_3704(var2 - this.f_13282, this.f_13287, var4);
      List var9 = this.m_3007(var7, var8, var3, var4, var5);
      List var10 = this.m_2693(var7, var8, var3, var4, var5);
      this.f_13300 = m_1069(var9, this.f_13300);
      this.f_13301 = m_1069(var10, this.f_13301);
      this.f_13290 = this.f_13300 != null ? this.f_13300.f_3981 : var7;
      this.f_13291 = this.f_13301 != null ? this.f_13301.f_3981 : var8;
      this.f_13290 = m_2122(this.f_13290, this.f_13286, var3);
      this.f_13291 = m_2122(this.f_13291, this.f_13287, var4);
   }

   private void m_3048(float var1, float var2, float var3, int var4, Window var5, long var6) {
      float var8 = f_13375 + f_13376 * (float)Math.sin(var6 / f_13377);
      float var9 = Math.min(this.f_13286, this.f_13287);
      float var10 = m_2001(var9 * f_13378, f_13379, Math.min(f_13380, var9 * f_13381));
      float var11 = f_13382 + (1.0F - var3) * f_13383;
      this.m_2052(var1, var2, var11, var10, f_13384, Util71.m_1907(var4, var3 * f_13385), var5);
      this.m_2052(var1, var2, var11, var10, f_13386, Util71.m_1907(var4, var3 * var8), var5);
   }

   public Util112(Module var1, String var2, float var3, float var4) {
      this.f_13295 = new Util165(Util153.EASE_OUT_CUBIC, f_13306);
      this.f_13296 = new Util165(Util153.EASE_OUT_CUBIC, f_13307);
      this.f_13297 = new Util165(Util153.EASE_OUT_CUBIC, f_13308);
      this.f_13298 = new Util165(Util153.EASE_OUT_CUBIC, f_13309);
      this.f_13299 = new Util165(Util153.EASE_OUT_BACK, f_13310);
      this.f_13289 = var1;
      this.f_13288 = var2;
      this.f_13279 = m_3833(m_3996(var3, 0.0F));
      this.f_13280 = m_3833(m_3996(var4, 0.0F));
      this.f_13277 = this.f_13279;
      this.f_13278 = this.f_13280;
      this.f_13290 = this.f_13277;
      this.f_13291 = this.f_13278;
      this.f_13292 = this.f_13277;
      this.f_13293 = this.f_13278;
      this.f_13304 = System.nanoTime();
   }

   private void m_1822() {
      this.m_2281();
      this.f_13283 = false;
      this.f_13284 = false;
      this.f_13277 = this.m_2227();
      this.f_13278 = this.m_2310();
      this.f_13290 = this.f_13277;
      this.f_13291 = this.f_13278;
      this.f_13300 = null;
      this.f_13301 = null;
      this.m_3920();
   }

   public float m_292() {
      return this.f_13281;
   }

   public float m_1224() {
      return this.f_13292;
   }

   private static void m_3799(
      List<Util112.CtTBIDR0bpZdLsPH> var0, Util112 var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8
   ) {
      if (Float.isFinite(var3) && Float.isFinite(var4) && !(var3 < 0.0F) && !(var3 > var8) && !(var6 <= var5)) {
         var0.add(new Util112.CtTBIDR0bpZdLsPH(var1, var2, var3, var4, var5, var6, Math.abs(var7 - var3)));
      }
   }

   public boolean m_1719() {
      return this.f_13284;
   }

   private static float m_2122(float var0, float var1, float var2) {
      float var3 = Math.max(0.0F, var2 - l(var1));
      float var4 = (float)Math.floor(var3 * 2.0F) / 2.0F;
      return m_2001(m_3833(m_3996(var0, 0.0F)), 0.0F, var4);
   }

   public Util165 m_3039() {
      return this.f_13295;
   }

   public float m_1434() {
      return this.f_13293;
   }

   public Util165 m_1214() {
      return this.f_13297;
   }

   private void m_970(float var1, float var2, float var3, float var4, int var5, Window var6) {
      float var7 = var1 - var3;
      float var8 = var2 - var3;
      float var9 = this.f_13286 + var3 * 2.0F;
      float var10 = this.f_13287 + var3 * 2.0F;
      float var11 = var4 / 2.0F;
      float var12 = Math.max(0.0F, var10 - var4 * 2.0F);
      m_3659(var7, var8, var9, var4, var11, var5, var6);
      m_3659(var7, var8 + var10 - var4, var9, var4, var11, var5, var6);
      m_3659(var7, var8 + var4, var4, var12, var11, var5, var6);
      m_3659(var7 + var9 - var4, var8 + var4, var4, var12, var11, var5, var6);
   }

   public long m_2995() {
      return this.f_13304;
   }

   private List<Util112.CtTBIDR0bpZdLsPH> m_2693(float var1, float var2, float var3, float var4, long var5) {
      ArrayList var7 = new ArrayList();
      float var8 = Math.max(0.0F, var4 - this.f_13287);
      float var9 = this.m_2838();
      m_3799(var7, null, 0, f_13331, f_13332, f_13333, var3 - f_13334, var2, var8);

      for (int var10 = 0; var10 < f_13276.length; var10++) {
         float var11 = var4 * f_13276[var10];
         float var12 = var11 - this.f_13287 / 2.0F;
         m_3799(var7, null, var10 + 1, var12, var11, f_13335, var3 - f_13336, var2, var8);
      }

      float var19 = var4 - f_13337 - this.f_13287;
      m_3799(var7, null, 100, var19, var4 - f_13338, f_13339, var3 - f_13340, var2, var8);

      for (Util112 var21 : this.m_1146()) {
         if (var21 != this && var21.m_1193(var5)) {
            float var13 = var21.m_2838();
            float var14 = var21.m_671();
            float var15 = m_2001(Math.min(Math.min(var1, var9), var13) - f_13341, 0.0F, var3);
            float var16 = m_2001(Math.max(Math.max(var1 + this.f_13286, var9 + this.f_13286), var13 + var21.f_13286) + f_13342, 0.0F, var3);
            m_3799(var7, var21, 0, var14, var14, var15, var16, var2, var8);
            float var17 = var14 + var21.f_13287 / 2.0F;
            m_3799(var7, var21, 1, var17 - this.f_13287 / 2.0F, var17, var15, var16, var2, var8);
            float var18 = var14 + var21.f_13287;
            m_3799(var7, var21, 2, var18 - this.f_13287, var18, var15, var16, var2, var8);
         }
      }

      return var7;
   }

   public long m_1743() {
      return this.f_13305;
   }

   private static void m_3568(float var0, float var1, float var2, int var3, Window var4, long var5) {
      float var7 = f_13365 + f_13366 * (float)Math.sin(var5 / f_13367);
      m_2436(var0, var1, f_13368 + var7 * 2.0F, Util71.m_1907(var3, var2 * (f_13369 + var7 * f_13370)), var4);
      m_2436(var0, var1, f_13371, Util71.m_1907(f_13372, var2 * f_13373), var4);
      m_2436(var0, var1, f_13374, Util71.m_1907(var3, var2), var4);
   }

   private static float m_1408(double var0, Window var2) {
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var3 != null && var3.mouse != null) {
         double var4 = var3.mouse.getX();
         if (Double.isFinite(var4)) {
            return (float)(var4 / f_13391);
         }
      }

      return m_1390(var0, var2);
   }

   private float m_2227() {
      return this.f_13294 ? this.f_13292 : this.m_2838();
   }

   private static Util112.CtTBIDR0bpZdLsPH m_1069(List<Util112.CtTBIDR0bpZdLsPH> var0, Util112.CtTBIDR0bpZdLsPH var1) {
      if (var1 != null) {
         for (Util112.CtTBIDR0bpZdLsPH var3 : var0) {
            if (var3.m_3921(var1) && var3.f_3985 <= f_13343) {
               return var3;
            }
         }
      }

      Util112.CtTBIDR0bpZdLsPH var5 = null;

      for (Util112.CtTBIDR0bpZdLsPH var4 : var0) {
         if (var5 == null || var4.f_3985 < var5.f_3985) {
            var5 = var4;
         }
      }

      return var5 != null && var5.f_3985 <= f_13344 ? var5 : null;
   }

   public float m_2774() {
      return this.f_13291;
   }

   private static float m_1758(double var0, Window var2) {
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var3 != null && var3.mouse != null) {
         double var4 = var3.mouse.getY();
         if (Double.isFinite(var4)) {
            return (float)(var4 / f_13392);
         }
      }

      return m_181(var0, var2);
   }

   public float m_2505() {
      return this.f_13290;
   }

   private static float m_3704(float var0, float var1, float var2) {
      return m_2001(m_3996(var0, 0.0F), 0.0F, Math.max(0.0F, var2 - l(var1)));
   }

   private void m_3920() {
      if (this.f_13300 != null) {
         this.f_13302 = this.f_13300;
      }

      if (this.f_13301 != null) {
         this.f_13303 = this.f_13301;
      }

      this.f_13295.m_3631(this.f_13283 ? 1.0 : 0.0);
      this.f_13296.m_3631(this.f_13300 != null ? 1.0 : 0.0);
      this.f_13297.m_3631(this.f_13301 != null ? 1.0 : 0.0);
      this.f_13298.m_3631(this.f_13300 != null && this.f_13301 != null ? 1.0 : 0.0);
      this.f_13299.m_3631(this.f_13285 ? 1.0 : 0.0);
      if (this.f_13300 == null && this.f_13296.m_2276() <= f_13317) {
         this.f_13302 = null;
      }

      if (this.f_13301 == null && this.f_13297.m_2276() <= f_13318) {
         this.f_13303 = null;
      }
   }

   private static void m_3659(float var0, float var1, float var2, float var3, float var4, int var5, Window var6) {
      Util158.m_1849(m_3390(var0, var6), m_459(var1, var6), m_3390(var2, var6), m_459(var3, var6), Math.min(m_3390(var4, var6), m_459(var4, var6)), var5);
   }

   private float m_2310() {
      return this.f_13294 ? this.f_13293 : this.m_671();
   }

   public void m_69(int var1) {
      if (var1 == 1) {
         this.f_13285 = false;
         this.m_3920();
      } else {
         if (var1 == 0 && this.f_13283) {
            this.m_1575();
         }
      }
   }

   public float m_1180() {
      return this.f_13287;
   }

   private void m_2281() {
      if (this.f_13300 != null) {
         this.f_13302 = this.f_13300;
      }

      if (this.f_13301 != null) {
         this.f_13303 = this.f_13301;
      }
   }

   private static float m_135(Util165 var0) {
      return m_2001((float)var0.m_2276(), 0.0F, 1.0F);
   }

   private static float m_1390(double var0, Window var2) {
      return (float)(var0 * var2.getWidth() / Math.max(1.0, (double)var2.getScaledWidth()) / f_13389);
   }

   public Util112.CtTBIDR0bpZdLsPH m_638() {
      return this.f_13303;
   }

   private void m_1116(Window var1, long var2, float var4, float var5) {
      float var6 = m_135(this.f_13296);
      float var7 = m_135(this.f_13297);
      float var8 = m_135(this.f_13295);
      byte var9 = -1;
      if (this.f_13302 != null && var6 > f_13348) {
         m_1694(this.f_13302, var6, var9, var1);
      }

      if (this.f_13303 != null && var7 > f_13349) {
         m_878(this.f_13303, var7, var9, var1);
      }

      float var10 = m_135(this.f_13298);
      if (var8 > f_13350 && Math.min(this.f_13286, this.f_13287) >= f_13351) {
         this.m_3048(var4, var5, var8, var9, var1, var2);
      }

      float var11 = (float)this.f_13299.m_2276();
      if (m_135(this.f_13299) > f_13352 && this.f_13286 > 0.0F && this.f_13287 > 0.0F) {
         this.m_1267(var4, var5, var11, var1, var2);
      }
   }

   private static float l(float var0) {
      return Float.isFinite(var0) ? Math.max(0.0F, var0) : 0.0F;
   }

   public boolean m_2074() {
      return this.f_13285;
   }

   public String m_1651() {
      return this.f_13288;
   }

   public float m_1241() {
      return this.f_13280;
   }

   public boolean m_1403(double var1, double var3, int var5) {
      if (var5 != 0 && var5 != 1) {
         return false;
      } else {
         MinecraftClient var6 = MinecraftClient.getInstance();
         Window var7 = var6 != null ? var6.getWindow() : null;
         if (var7 == null) {
            return false;
         } else {
            float var8 = m_1390(var1, var7);
            float var9 = m_181(var3, var7);
            if (!this.m_918(var8, var9, System.nanoTime())) {
               return false;
            } else if (var5 == 1) {
               this.f_13285 = true;
               this.m_3920();
               return true;
            } else {
               float var10 = this.m_2227();
               float var11 = this.m_2310();
               this.f_13277 = var10;
               this.f_13278 = var11;
               this.f_13283 = true;
               this.f_13284 = false;
               this.f_13281 = var8 - var10;
               this.f_13282 = var9 - var11;
               this.f_13290 = var10;
               this.f_13291 = var11;
               this.f_13300 = null;
               this.f_13301 = null;
               return true;
            }
         }
      }
   }

   public float m_2838() {
      return m_3833(this.f_13277);
   }

   public Util165 m_3101() {
      return this.f_13298;
   }

   private static final class CtTBIDR0bpZdLsPH {
      private final Util112 f_3979;
      private final int f_3980;
      private final float f_3981;
      private final float f_3982;
      private final float f_3983;
      private final float f_3984;
      private final float f_3985;

      private CtTBIDR0bpZdLsPH(Util112 var1, int var2, float var3, float var4, float var5, float var6, float var7) {
         this.f_3979 = var1;
         this.f_3980 = var2;
         this.f_3981 = var3;
         this.f_3982 = var4;
         this.f_3983 = var5;
         this.f_3984 = var6;
         this.f_3985 = var7;
      }

      private boolean m_3921(Util112.CtTBIDR0bpZdLsPH var1) {
         return var1 != null && this.f_3979 == var1.f_3979 && this.f_3980 == var1.f_3980;
      }
   }
}
