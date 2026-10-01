package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util111;
import su.energyclient.util.Util114;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;

public class JumpCircle extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Identifier f_4046 = Identifier.of(JumpCircle.f_4124, JumpCircle.f_4125);
   private final NumberSetting f_4047;
   private final NumberSetting f_4048;
   private final NumberSetting f_4049;
   private final NumberSetting f_4050;
   private final NumberSetting f_4051;
   private final NumberSetting f_4052;
   private final NumberSetting f_4053;
   private final NumberSetting f_4054;
   private final BooleanSetting f_4055;
   private final BooleanSetting f_4056;
   private final List<JumpCircle.vi2kNdLdzZ13Wuww> f_4057;
   private static final String f_4058 = "Jump Circle";
   private static final String f_4059 = "Картинка под игроком при прыжке";
   private static final String f_4060 = "Время жизни (мс)";
   private static final float f_4061 = 900.0F;
   private static final float f_4062 = 200.0F;
   private static final float f_4063 = 3000.0F;
   private static final float f_4064 = 50.0F;
   private static final String f_4065 = "Размер";
   private static final float f_4066 = 1.7F;
   private static final float f_4067 = 0.45F;
   private static final float f_4068 = 5.0F;
   private static final float f_4069 = 0.05F;
   private static final String f_4070 = "Расширение";
   private static final float f_4071 = 1.25F;
   private static final float f_4072 = 0.1F;
   private static final float f_4073 = 2.7F;
   private static final float f_4074 = 0.05F;
   private static final String f_4075 = "Скорость вращения";
   private static final float f_4076 = 95.0F;
   private static final float f_4077 = 360.0F;
   private static final float f_4078 = 5.0F;
   private static final String f_4079 = "Подъем";
   private static final float f_4080 = 0.02F;
   private static final float f_4081 = 0.35F;
   private static final float f_4082 = 0.01F;
   private static final String f_4083 = "Яркость";
   private static final float f_4084 = 0.25F;
   private static final float f_4085 = 0.05F;
   private static final String f_4086 = "Появление (%)";
   private static final float f_4087 = 18.0F;
   private static final float f_4088 = 5.0F;
   private static final float f_4089 = 45.0F;
   private static final String f_4090 = "Исчезание (%)";
   private static final float f_4091 = 35.0F;
   private static final float f_4092 = 10.0F;
   private static final float f_4093 = 70.0F;
   private static final String f_4094 = "Двойной слой";
   private static final String f_4095 = "Аддитив";
   private static final float f_4096 = 3.0F;
   private static final float f_4097 = 0.94F;
   private static final float f_4098 = 0.06F;
   private static final long f_4099 = 37L;
   private static final float f_4100 = 0.012F;
   private static final float f_4101 = 0.65F;
   private static final float f_4102 = 0.01F;
   private static final float f_4103 = 0.01F;
   private static final float f_4104 = 0.98F;
   private static final float f_4105 = 0.98F;
   private static final float f_4106 = 0.01F;
   private static final float f_4107 = 0.01F;
   private static final float f_4108 = 0.01F;
   private static final float f_4109 = 170.0F;
   private static final float f_4110 = 0.035F;
   private static final float f_4111 = 0.001F;
   private static final float f_4112 = 9.0F;
   private static final float f_4113 = 360.0F;
   private static final float f_4114 = 255.0F;
   private static final float f_4115 = 0.001F;
   private static final float f_4116 = 1.18F;
   private static final float f_4117 = 0.82F;
   private static final float f_4118 = 0.5F;
   private static final float f_4119 = 255.0F;
   private static final float f_4120 = 255.0F;
   private static final float f_4121 = 255.0F;
   private static final float f_4122 = 255.0F;
   private static final float f_4123 = 3.0F;
   private static final String f_4124 = "energy";
   private static final String f_4125 = "images/other_visuals/jump.png";

   public JumpCircle() {
      super(f_4058, f_4059, Category.RENDER);
      this.f_4047 = new NumberSetting(f_4060, f_4061, f_4062, f_4063, f_4064);
      this.f_4048 = new NumberSetting(f_4065, f_4066, f_4067, f_4068, f_4069);
      this.f_4049 = new NumberSetting(f_4070, f_4071, f_4072, f_4073, f_4074);
      this.f_4050 = new NumberSetting(f_4075, f_4076, 0.0F, f_4077, f_4078);
      this.f_4051 = new NumberSetting(f_4079, f_4080, 0.0F, f_4081, f_4082);
      this.f_4052 = new NumberSetting(f_4083, 1.0F, f_4084, 1.0F, f_4085);
      this.f_4053 = new NumberSetting(f_4086, f_4087, f_4088, f_4089, 1.0F);
      this.f_4054 = new NumberSetting(f_4090, f_4091, f_4092, f_4093, 1.0F);
      this.f_4055 = new BooleanSetting(f_4094, false);
      this.f_4056 = new BooleanSetting(f_4095, true);
      this.f_4057 = new ArrayList<>();
   }

   @EventHandler
   private void m_3718(Util88 var1) {
      if (f_5909.player != null && f_5909.world != null && !this.f_4057.isEmpty()) {
         long var2 = System.currentTimeMillis();
         long var4 = (long)this.f_4047.m_4046();
         this.f_4057.removeIf(var4x -> var2 - var4x.f_12239 >= var4);
         if (!this.f_4057.isEmpty()) {
            MatrixStack var6 = var1.m_213();
            Vec3d var7 = f_5909.gameRenderer.getCamera().getCameraPos();
            Util114.m_1481();
            if (this.f_4056.m_1163()) {
               Util114.m_1206(770, 1, 1, 0);
            } else {
               Util114.m_542();
            }

            Util114.m_3978();
            Util114.m_100();
            Util114.m_1878(false);
            Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
            Util114.m_3784(RenderUtil7.f_13886);
            Util114.m_2037(0, f_4046);

            try {
               for (int var8 = 0; var8 < this.f_4057.size(); var8++) {
                  this.m_2614(this.f_4057.get(var8), var8, var2, var6, var7);
               }
            } finally {
               Util114.m_1878(true);
               Util114.m_542();
               Util114.m_1562();
               Util114.m_963();
               Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
            }
         }
      }
   }

   @EventHandler(
      priority = -200
   )
   private void m_1835(Util111 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (!var1.m_2244() && var1.m_3034() == f_5909.player) {
            Vec3d var2 = var1.m_2376();
            double var3 = var1.m_3034().getBoundingBox().minY + this.f_4051.m_4046();
            this.f_4057.add(new JumpCircle.vi2kNdLdzZ13Wuww(new Vec3d(var2.x, var3, var2.z), System.currentTimeMillis(), this.f_4057.size() * 19));
         }
      }
   }

   private void m_1409(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      float var8 = var5 * f_4118;
      float var9 = (float)Math.toRadians(var6);
      float var10 = MathHelper.cos(var9);
      float var11 = MathHelper.sin(var9);
      float[] var12 = new float[]{-var8, var8, var8, -var8};
      float[] var13 = new float[]{-var8, -var8, var8, var8};
      float[] var14 = new float[]{0.0F, 1.0F, 1.0F, 0.0F};
      float[] var15 = new float[]{1.0F, 1.0F, 0.0F, 0.0F};
      float var16 = (var7 >> 16 & 0xFF) / f_4119;
      float var17 = (var7 >> 8 & 0xFF) / f_4120;
      float var18 = (var7 & 0xFF) / f_4121;
      float var19 = (var7 >> 24 & 0xFF) / f_4122;
      BufferBuilder var20 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

      for (int var21 = 0; var21 < 4; var21++) {
         float var22 = var12[var21] * var10 - var13[var21] * var11;
         float var23 = var12[var21] * var11 + var13[var21] * var10;
         var20.vertex(var1, var2 + var22, var3, var4 + var23).texture(var14[var21], var15[var21]).color(var16, var17, var18, var19);
      }

      RenderUtil12.I(var20.end());
   }

   private void m_2614(JumpCircle.vi2kNdLdzZ13Wuww var1, int var2, long var3, MatrixStack var5, Vec3d var6) {
      float var7 = MathHelper.clamp((float)(var3 - var1.f_12239) / this.f_4047.m_4046(), 0.0F, 1.0F);
      float var8 = var7 * var7 * (f_4096 - 2.0F * var7);
      float var9 = f_4097 + f_4098 * MathHelper.sin((float)(var3 + var1.f_12240 * f_4099) * f_4100);
      float var10 = this.f_4048.m_4046() * (f_4101 + var8 * this.f_4049.m_4046()) * var9;
      float var11 = this.f_4053.m_4046() * f_4102;
      float var12 = this.f_4054.m_4046() * f_4103;
      float var13 = var11 + var12;
      if (var13 > f_4104) {
         float var14 = f_4105 / var13;
         var11 *= var14;
         var12 *= var14;
      }

      float var26 = this.m_3159(MathHelper.clamp(var7 / Math.max(f_4106, var11), 0.0F, 1.0F));
      float var15 = 1.0F - var12;
      float var16 = 1.0F - MathHelper.clamp((var7 - var15) / Math.max(f_4107, var12), 0.0F, 1.0F);
      var16 = this.m_3159(var16);
      float var17 = MathHelper.clamp(var26 * var16 * this.f_4052.m_4046(), 0.0F, 1.0F);
      if (!(var17 <= f_4108)) {
         int var18 = EnergyClient.getTheme(var2 * 32 + var1.f_12240);
         int var19 = Util71.m_3389(Util71.m_3793(var18, 95), (int)(f_4109 * var17));
         int var20 = Util71.m_1784(10, var2 * 70 + var1.f_12240, EnergyClient.getTheme(var2 * 32 + var1.f_12240), EnergyClient.getTheme(90));
         float var21 = (float)(var1.f_12238.x - var6.x);
         float var22 = (float)(var1.f_12238.y - var6.y + var7 * f_4110);
         float var23 = (float)(var1.f_12238.z - var6.z);
         float var24 = ((float)(var3 - var1.f_12239) * f_4111 * this.f_4050.m_4046() + var1.f_12240 * f_4112) % f_4113;
         Matrix4f var25 = var5.peek().getPositionMatrix();
         this.m_1409(var25, var21, var22, var23, var10, var24, Util71.m_3389(var20, (int)(f_4114 * var17)));
         if (this.f_4055.m_1163()) {
            this.m_1409(var25, var21, var22 + f_4115, var23, var10 * f_4116, -var24 * f_4117, var19);
         }
      }
   }

   private float m_3159(float var1) {
      float var2 = MathHelper.clamp(var1, 0.0F, 1.0F);
      return var2 * var2 * (f_4123 - 2.0F * var2);
   }

   @Override
   public void m_1() {
      this.f_4057.clear();
      super.m_1();
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_4057.clear();
   }

   private static class vi2kNdLdzZ13Wuww {
      private final Vec3d f_12238;
      private final long f_12239;
      private final int f_12240;

      private vi2kNdLdzZ13Wuww(Vec3d var1, long var2, int var4) {
         this.f_12238 = var1;
         this.f_12239 = var2;
         this.f_12240 = var4;
      }
   }
}
