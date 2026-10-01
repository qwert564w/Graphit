package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util169;
import su.energyclient.util.Util46;
import su.energyclient.util.Util7;
import su.energyclient.util.Util71;

public class PlayerAlert extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final MinecraftClient f_3155 = MinecraftClient.getInstance();
   private final NumberSetting f_3156;
   private final NumberSetting f_3157;
   private final NumberSetting f_3158;
   private final NumberSetting f_3159;
   private final NumberSetting f_3160;
   private final NumberSetting f_3161;
   private final BooleanSetting f_3162;
   private final BooleanSetting f_3163;
   private final BooleanSetting f_3164;
   private final BooleanSetting f_3165;
   private final BooleanSetting f_3166;
   private final BooleanSetting f_3167;
   private final BooleanSetting f_3168;
   private final ModeSetting f_3169;
   private static final long f_3170 = 130L;
   private static final long f_3171 = 0L;
   private static final int f_3172 = 0;
   private static final int f_3173 = 0;
   private static final int f_3174 = 0;
   private final List<PlayerAlert.oeneDv0P2jqIlSU7> f_3175;
   private final Map<UUID, Float> f_3176;
   private float f_3177;
   private float f_3178;
   private float f_3179;
   private long f_3180;
   private static final String f_3181 = "Player Alert";
   private static final String f_3182 = "Дуга-индикатор урона/хила вокруг прицела";
   private static final String f_3183 = "Дистанция от прицела";
   private static final float f_3184 = 38.0F;
   private static final float f_3185 = 10.0F;
   private static final float f_3186 = 150.0F;
   private static final String f_3187 = "Ширина дуги";
   private static final float f_3188 = 60.0F;
   private static final float f_3189 = 15.0F;
   private static final float f_3190 = 160.0F;
   private static final String f_3191 = "Толщина";
   private static final float f_3192 = 5.0F;
   private static final float f_3193 = 25.0F;
   private static final float f_3194 = 0.5F;
   private static final String f_3195 = "Длительность (мс)";
   private static final float f_3196 = 1500.0F;
   private static final float f_3197 = 250.0F;
   private static final float f_3198 = 5000.0F;
   private static final float f_3199 = 50.0F;
   private static final String f_3200 = "Радиус событий";
   private static final float f_3201 = 30.0F;
   private static final float f_3202 = 4.0F;
   private static final float f_3203 = 64.0F;
   private static final String f_3204 = "Показывать от дистанции";
   private static final float f_3205 = 80.0F;
   private static final String f_3206 = "Когда бьют тебя";
   private static final String f_3207 = "Когда бьют врага";
   private static final String f_3208 = "Хил (зелёным)";
   private static final String f_3209 = "Игнорировать друзей";
   private static final String f_3210 = "Размер от урона";
   private static final String f_3211 = "Яркость от близости";
   private static final String f_3212 = "Свечение";
   private static final String f_3213 = "Цвет";
   private static final String f_3214 = "Урон/Хил";
   private static final String f_3215 = "Урон/Хил";
   private static final String f_3216 = "Тема клиента";
   private static final float f_3217 = 0.5F;
   private static final float f_3218 = -0.05F;
   private static final float f_3219 = 0.05F;
   private static final float f_3220 = -0.05F;
   private static final float f_3221 = 0.05F;
   private static final float f_3222 = 0.5F;
   private static final double f_3223 = -1.0;
   private static final long f_3224 = 130L;
   private static final long f_3225 = 250L;
   private static final float f_3226 = 180.0F;
   private static final float f_3227 = 180.0F;
   private static final float f_3228 = 270.0F;
   private static final float f_3229 = 60.0F;
   private static final float f_3230 = 0.004F;
   private static final float f_3231 = 0.92F;
   private static final float f_3232 = 0.35F;
   private static final float f_3233 = 0.65F;
   private static final float f_3234 = 0.004F;
   private static final float f_3235 = 0.75F;
   private static final float f_3236 = 0.6F;
   private static final float f_3237 = 0.85F;
   private static final float f_3238 = 0.3F;
   private static final float f_3239 = 0.9F;
   private static final float f_3240 = 1.9F;
   private static final float f_3241 = 1.12F;
   private static final float f_3242 = 0.3F;
   private static final float f_3243 = 0.3F;
   private static final float f_3244 = 0.7F;
   private static final float f_3245 = 0.7F;
   private static final float f_3246 = 0.7F;
   private static final float f_3247 = 14.0F;
   private static final float f_3248 = 0.45F;
   private static final double f_3249 = 48.0;
   private static final float f_3250 = 0.85F;
   private static final float f_3251 = 0.25F;
   private static final float f_3252 = 0.75F;
   private static final String f_3253 = "Тема клиента";
   private static final float f_3254 = 0.9F;
   private static final float f_3255 = 255.0F;
   private static final float f_3256 = 255.0F;
   private static final float f_3257 = 255.0F;
   private static final float f_3258 = 3.0F;

   private LivingEntity m_2350() {
      AbstractClientPlayerEntity var1 = null;
      double var2 = this.f_3160.m_4046();

      for (AbstractClientPlayerEntity var5 : this.f_3155.world.getPlayers()) {
         if (var5 != this.f_3155.player && var5.isAlive() && (!this.f_3165.m_1163() || !InitManager.f_2740.f_2744.m_2704(var5.getGameProfile().name()))) {
            double var6 = this.f_3155.player.distanceTo(var5);
            if (var6 < var2) {
               var2 = var6;
               var1 = var5;
            }
         }
      }

      return var1;
   }

   private void m_311(long var1) {
      float var3 = this.f_3155.player.getHealth() + this.f_3155.player.getAbsorptionAmount();
      if (!Float.isNaN(this.f_3177) && this.f_3155.player.isAlive() && this.f_3177 > f_3217) {
         float var4 = var3 - this.f_3177;
         if (var4 < f_3218 && this.f_3162.m_1163()) {
            this.m_2832(false, -var4, this.m_2350(), 0, true);
         } else if (var4 > f_3219 && this.f_3164.m_1163()) {
            this.m_2832(true, var4, this.m_2350(), 1, false);
         }
      }

      this.f_3177 = var3;
   }

   private int m_3166(boolean var1, float var2) {
      if (this.f_3169.m_2073(f_3253)) {
         return EnergyClient.getThemeColor();
      } else {
         return var1
            ? Util71.m_2924(Util71.m_1415(18, 120, 40), Util71.m_1415(60, 235, 110), var2)
            : Util71.m_2924(Util71.m_1415(160, 18, 14), Util71.m_1415(255, 60, 48), var2);
      }
   }

   private float m_1324(LivingEntity var1, float var2, Vec3d var3, float var4) {
      double var5 = MathHelper.lerp(var4, var1.lastX, var1.getX()) - var3.x;
      double var7 = MathHelper.lerp(var4, var1.lastZ, var1.getZ()) - var3.z;
      double var9 = Math.toRadians(var2);
      double var11 = Math.sin(var9);
      double var13 = Math.cos(var9);
      double var15 = var5 * -var11 + var7 * var13;
      double var17 = var5 * -var13 + var7 * -var11;
      return (float)Math.toDegrees(Math.atan2(-var15, var17));
   }

   private void m_3647() {
      this.f_3175.clear();
      this.f_3176.clear();
      this.f_3177 = Float.NaN;
      this.f_3180 = 0L;
   }

   @Override
   public void m_1() {
      super.m_1();
      this.m_3647();
   }

   @EventHandler
   public void m_3217(Util46 var1) {
      if (this.f_3155.player != null && var1.m_2669() == this.f_3155.player) {
         this.f_3178 = var1.m_3787();
         this.f_3179 = this.f_3155.player.getYaw();
         this.f_3180 = System.currentTimeMillis();
      }
   }

   private void m_3161(Matrix4f var1, PlayerAlert.oeneDv0P2jqIlSU7 var2, float var3, float var4, float var5, Vec3d var6, float var7, long var8, float var10) {
      float var11 = (float)(var8 - var2.f_7042);
      float var12 = MathHelper.clamp(var11 / var10, 0.0F, 1.0F);
      float var13 = MathHelper.clamp(var11 / f_3229, 0.0F, 1.0F);
      float var14 = (1.0F - var12) * (1.0F - var12);
      float var15 = var13 * var14;
      if (!(var15 <= f_3230)) {
         double var17 = var2.f_7045;
         float var16;
         if (var2.l != null && var2.l.isAlive() && !var2.l.isRemoved()) {
            var16 = this.m_1324(var2.l, var5, var6, var7);
            var17 = this.f_3155.player.distanceTo(var2.l);
         } else if (var2.f_7048) {
            var16 = var2.f_7046;
         } else {
            var16 = var2.f_7046 + (var2.f_7047 - var5);
         }

         float var19 = this.m_3541(var2.f_7044, var17);
         float var20 = f_3231 * var15 * (this.f_3167.m_1163() ? f_3232 + f_3233 * var19 : 1.0F);
         if (!(var20 <= f_3234)) {
            float var21 = this.f_3166.m_1163() ? f_3235 + f_3236 * var19 : 1.0F;
            float var22 = this.f_3156.m_4046();
            float var23 = this.f_3158.m_4046() * var21;
            float var24 = this.f_3157.m_4046() * (f_3237 + f_3238 * var21);
            int var25 = this.m_3166(var2.f_7043, var19);
            if (this.f_3168.m_1163()) {
               this.m_313(var1, var3, var4, var22 - var23 * f_3239, var22 + var23 * f_3240, var16, var24 * f_3241, var25, var20 * f_3242);
            }

            this.m_313(var1, var3, var4, var22, var22 + var23, var16, var24, var25, var20);
            this.m_313(var1, var3, var4, var22 + var23 * f_3243, var22 + var23 * f_3244, var16, var24 * f_3245, Util71.m_3793(var25, 60), var20 * f_3246);
         }
      }
   }

   public PlayerAlert() {
      super(f_3181, f_3182, Category.RENDER);
      this.f_3156 = new NumberSetting(f_3183, f_3184, f_3185, f_3186, 1.0F);
      this.f_3157 = new NumberSetting(f_3187, f_3188, f_3189, f_3190, 1.0F);
      this.f_3158 = new NumberSetting(f_3191, f_3192, 1.0F, f_3193, f_3194);
      this.f_3159 = new NumberSetting(f_3195, f_3196, f_3197, f_3198, f_3199);
      this.f_3160 = new NumberSetting(f_3200, f_3201, f_3202, f_3203, 1.0F);
      this.f_3161 = new NumberSetting(f_3204, 0.0F, 0.0F, f_3205, 1.0F);
      this.f_3162 = new BooleanSetting(f_3206, true);
      this.f_3163 = new BooleanSetting(f_3207, true);
      this.f_3164 = new BooleanSetting(f_3208, true);
      this.f_3165 = new BooleanSetting(f_3209, true);
      this.f_3166 = new BooleanSetting(f_3210, true);
      this.f_3167 = new BooleanSetting(f_3211, true);
      this.f_3168 = new BooleanSetting(f_3212, true);
      this.f_3169 = new ModeSetting(f_3213, f_3214, f_3215, f_3216);
      this.f_3175 = new ArrayList<>();
      this.f_3176 = new HashMap<>();
      this.f_3177 = Float.NaN;
      this.f_3178 = 0.0F;
      this.f_3179 = 0.0F;
      this.f_3180 = 0L;
   }

   @Override
   public void m_2() {
      super.m_2();
      this.m_3647();
   }

   private void m_313(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8, float var9) {
      if (!(var9 <= 0.0F)) {
         int var10 = Math.max(20, (int)(var7 * f_3254));
         float var11 = Util71.m_1989(var8) / f_3255;
         float var12 = Util71.m_644(var8) / f_3256;
         float var13 = Util71.m_3163(var8) / f_3257;
         float var14 = var6 - var7 / 2.0F;
         BufferBuilder var15 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

         for (int var16 = 0; var16 <= var10; var16++) {
            float var17 = (float)var16 / var10;
            float var18 = (float)Math.toRadians(var14 + var17 * var7);
            float var19 = MathHelper.cos(var18);
            float var20 = MathHelper.sin(var18);
            float var21 = 1.0F - Math.abs(var17 * 2.0F - 1.0F);
            var21 = var21 * var21 * (f_3258 - 2.0F * var21);
            float var22 = var9 * var21;
            var15.vertex(var1, var2 + var19 * var5, var3 + var20 * var5, 0.0F).color(var11, var12, var13, var22);
            var15.vertex(var1, var2 + var19 * var4, var3 + var20 * var4, 0.0F).color(var11, var12, var13, var22);
         }

         RenderUtil12.I(var15.end());
      }
   }

   private void m_3043(long var1) {
      HashMap var3 = new HashMap();
      float var4 = this.f_3160.m_4046();

      for (AbstractClientPlayerEntity var6 : this.f_3155.world.getPlayers()) {
         if (var6 != this.f_3155.player
            && !(this.f_3155.player.distanceTo(var6) > var4)
            && (!this.f_3165.m_1163() || !InitManager.f_2740.f_2744.m_2704(var6.getGameProfile().name()))) {
            UUID var7 = var6.getUuid();
            float var8 = var6.getHealth() + var6.getAbsorptionAmount();
            var3.put(var7, var8);
            Float var9 = this.f_3176.get(var7);
            if (var9 != null) {
               float var10 = var8 - var9;
               if (var10 < f_3220 && this.f_3163.m_1163()) {
                  this.m_2832(false, -var10, var6, 1, false);
               } else if (var10 > f_3221 && var9 > f_3222 && this.f_3164.m_1163()) {
                  this.m_2832(true, var10, var6, 1, false);
               }
            }
         }
      }

      this.f_3176.clear();
      this.f_3176.putAll(var3);
   }

   private void m_2832(boolean var1, float var2, LivingEntity var3, int var4, boolean var5) {
      long var6 = System.currentTimeMillis();
      double var8 = var3 != null ? this.f_3155.player.distanceTo(var3) : f_3223;
      float var10 = this.f_3161.m_4046();
      if (!var5 || !(var10 > 0.0F) || !(var8 >= 0.0) || !(var8 < var10)) {
         if (!this.f_3175.isEmpty()) {
            PlayerAlert.oeneDv0P2jqIlSU7 var11 = this.f_3175.get(this.f_3175.size() - 1);
            if (var6 - var11.f_7042 <= f_3224 && var11.f_7043 == var1 && var11.l == var3) {
               var11.f_7044 += var2;
               if (var3 != null) {
                  var11.f_7045 = var8;
               }

               return;
            }
         }

         PlayerAlert.oeneDv0P2jqIlSU7 var12 = new PlayerAlert.oeneDv0P2jqIlSU7(var6, var1, var2, var8);
         var12.l = var3;
         if (var3 == null) {
            if (var4 == 0 && var6 - this.f_3180 <= f_3225) {
               var12.f_7046 = this.f_3178 + f_3226;
               var12.f_7047 = this.f_3179;
            } else if (var4 == 0) {
               var12.f_7046 = this.f_3155.player.getDamageTiltYaw() + f_3227;
               var12.f_7047 = this.f_3155.player.getYaw();
            } else {
               var12.f_7046 = f_3228;
               var12.f_7048 = true;
            }
         }

         this.f_3175.add(var12);

         while (this.f_3175.size() > 24) {
            this.f_3175.remove(0);
         }
      }
   }

   @EventHandler
   public void m_2960(Util169 var1) {
      if (this.f_3155.player != null && this.f_3155.world != null && !this.f_3155.options.hudHidden) {
         long var2 = System.currentTimeMillis();
         this.m_311(var2);
         this.m_3043(var2);
         float var4 = this.f_3159.m_4046();
         this.f_3175.removeIf(var3 -> (float)(var2 - var3.f_7042) >= var4);
         if (!this.f_3175.isEmpty()) {
            Camera var5 = this.f_3155.gameRenderer.getCamera();
            if (var5 != null) {
               DrawContext var6 = var1.m_4037();
               float var7 = var1.m_4119();
               float var8 = this.f_3155.getWindow().getScaledWidth() / 2.0F;
               float var9 = this.f_3155.getWindow().getScaledHeight() / 2.0F;
               float var10 = var5.getYaw();
               Vec3d var11 = var5.getCameraPos();
               Matrix4f var12 = Util7.m_1924(var6.getMatrices());
               Util114.m_1481();
               Util114.m_542();
               Util114.m_3784(RenderUtil7.f_13885);
               Util114.m_1878(false);

               for (PlayerAlert.oeneDv0P2jqIlSU7 var14 : this.f_3175) {
                  this.m_3161(var12, var14, var8, var9, var10, var11, var7, var2, var4);
               }

               Util114.m_1878(true);
               Util114.m_963();
            }
         }
      }
   }

   private float m_3541(float var1, double var2) {
      float var4 = MathHelper.clamp(var1 / f_3247, 0.0F, 1.0F);
      float var5 = var2 < 0.0 ? f_3248 : MathHelper.clamp(1.0F - (float)(var2 / f_3249), 0.0F, 1.0F);
      float var6 = Math.max(var4, var5 * f_3250);
      return MathHelper.clamp(f_3251 + f_3252 * var6, 0.0F, 1.0F);
   }

   private static final class oeneDv0P2jqIlSU7 {
      long f_7042;
      boolean f_7043;
      float f_7044;
      double f_7045;
      LivingEntity l;
      float f_7046;
      float f_7047;
      boolean f_7048;

      oeneDv0P2jqIlSU7(long var1, boolean var3, float var4, double var5) {
         this.f_7042 = var1;
         this.f_7043 = var3;
         this.f_7044 = var4;
         this.f_7045 = var5;
      }
   }
}
