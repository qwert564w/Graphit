package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil3;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util150;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;

public class Wings extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_9010 = 8.0F;
   private static final int f_9011 = 0;
   private static final int f_9012 = m_1732(255, 255, 255, 255);
   private static final Wings.tuwKlyxj9UZo8SXY[] f_9013 = new Wings.tuwKlyxj9UZo8SXY[]{
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9086, Wings.f_9087, Wings.f_9088),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9089, Wings.f_9090, Wings.f_9091),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9092, Wings.f_9093, Wings.f_9094),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9095, Wings.f_9096, Wings.f_9097),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9098, Wings.f_9099, Wings.f_9100),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9101, Wings.f_9102, Wings.f_9103),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9104, Wings.f_9105, Wings.f_9106),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9107, Wings.f_9108, Wings.f_9109),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9110, Wings.f_9111, Wings.f_9112),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9113, Wings.f_9114, Wings.f_9115),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9116, Wings.f_9117, Wings.f_9118),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9119, Wings.f_9120, Wings.f_9121),
      new Wings.tuwKlyxj9UZo8SXY(Wings.f_9122, Wings.f_9123, Wings.f_9124)
   };
   private final BooleanSetting f_9014;
   private final BooleanSetting f_9015;
   private final NumberSetting f_9016;
   private final NumberSetting f_9017;
   private final NumberSetting f_9018;
   private float f_9019;
   private boolean f_9020;
   private static final String f_9021 = "Wings";
   private static final String f_9022 = "Отрисовывает декоративные крылья";
   private static final String f_9023 = "Себя";
   private static final String f_9024 = "Игроков";
   private static final String f_9025 = "Размер";
   private static final float f_9026 = 0.75F;
   private static final float f_9027 = 1.35F;
   private static final float f_9028 = 0.05F;
   private static final String f_9029 = "Ширина";
   private static final float f_9030 = 8.0F;
   private static final float f_9031 = 14.0F;
   private static final float f_9032 = 0.25F;
   private static final String f_9033 = "Прозрачность";
   private static final float f_9034 = 220.0F;
   private static final float f_9035 = 30.0F;
   private static final float f_9036 = 255.0F;
   private static final float f_9037 = 180.0F;
   private static final float f_9038 = -1.0F;
   private static final float f_9039 = 1.22F;
   private static final float f_9040 = 0.22F;
   private static final float f_9041 = 0.84F;
   private static final float f_9042 = 0.26F;
   private static final float f_9043 = 0.22F;
   private static final float f_9044 = 0.62F;
   private static final float f_9045 = 0.96F;
   private static final float f_9046 = 0.2F;
   private static final float f_9047 = 1.35F;
   private static final float f_9048 = 0.9F;
   private static final float f_9049 = 0.75F;
   private static final int f_9050 = 16777215;
   private static final float f_9051 = 0.28F;
   private static final float f_9052 = 0.55F;
   private static final float f_9053 = 14.0F;
   private static final float f_9054 = 100.0F;
   private static final float f_9055 = -90.0F;
   private static final float f_9056 = 0.34F;
   private static final float f_9057 = 0.46F;
   private static final float f_9058 = 0.76F;
   private static final float f_9059 = 0.92F;
   private static final float f_9060 = 0.1F;
   private static final float f_9061 = 0.58F;
   private static final float f_9062 = 0.05F;
   private static final float f_9063 = 0.06F;
   private static final float f_9064 = -5.0F;
   private static final float f_9065 = -2.0F;
   private static final float f_9066 = 0.13F;
   private static final float f_9067 = 0.96F;
   private static final float f_9068 = 0.1F;
   private static final float f_9069 = 18.0F;
   private static final float f_9070 = 0.18F;
   private static final float f_9071 = 4.5F;
   private static final float f_9072 = 0.06F;
   private static final float f_9073 = 0.02F;
   private static final float f_9074 = -11.0F;
   private static final float f_9075 = -4.0F;
   private static final float f_9076 = 0.12F;
   private static final float f_9077 = 1.38F;
   private static final float f_9078 = 0.1F;
   private static final float f_9079 = 0.18F;
   private static final float f_9080 = 4.5F;
   private static final float f_9081 = 0.06F;
   private static final float f_9082 = 0.02F;
   private static final float f_9083 = -11.0F;
   private static final float f_9084 = -4.0F;
   private static final float f_9085 = 0.12F;
   private static final float f_9086 = 0.08F;
   private static final float f_9087 = 0.1F;
   private static final float f_9088 = 0.88F;
   private static final float f_9089 = 0.28F;
   private static final float f_9090 = 0.34F;
   private static final float f_9091 = 0.78F;
   private static final float f_9092 = 0.56F;
   private static final float f_9093 = 0.82F;
   private static final float f_9094 = 0.62F;
   private static final float f_9095 = 0.86F;
   private static final float f_9096 = 0.3F;
   private static final float f_9097 = 0.52F;
   private static final float f_9098 = 1.14F;
   private static final float f_9099 = 0.46F;
   private static final float f_9100 = 0.4F;
   private static final float f_9101 = 1.24F;
   private static final float f_9102 = 0.04F;
   private static final float f_9103 = 0.3F;
   private static final float f_9104 = 1.02F;
   private static final float f_9105 = -0.18F;
   private static final float f_9106 = 0.28F;
   private static final float f_9107 = 1.18F;
   private static final float f_9108 = -0.64F;
   private static final float f_9109 = 0.22F;
   private static final float f_9110 = 0.86F;
   private static final float f_9111 = -0.46F;
   private static final float f_9112 = 0.2F;
   private static final float f_9113 = 0.8F;
   private static final float f_9114 = -0.98F;
   private static final float f_9115 = 0.14F;
   private static final float f_9116 = 0.54F;
   private static final float f_9117 = -0.74F;
   private static final float f_9118 = 0.16F;
   private static final float f_9119 = 0.3F;
   private static final float f_9120 = -1.16F;
   private static final float f_9121 = 0.12F;
   private static final float f_9122 = 0.1F;
   private static final float f_9123 = -0.54F;
   private static final float f_9124 = 0.18F;

   private void m_961(MatrixStack var1, float var2, float var3, int var4) {
      Matrix4f var5 = var1.peek().getPositionMatrix();
      int[] var6 = new int[]{2, 4, 7, 9, 11};
      Util114.m_2977(f_9048);
      BufferBuilder var7 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

      for (int var11 : var6) {
         Wings.tuwKlyxj9UZo8SXY var12 = f_9013[var11];
         this.m_3675(var7, var5, 0.0F, 0.0F, 0.0F, m_3940(var4, Math.max(8, Math.round(m_1518(var4) * f_9049))));
         this.m_3675(var7, var5, var2 * var12.f_2754 * var3, var12.f_2755 * var3, 0.0F, this.m_2585(var4, var12.f_2756));
      }

      RenderUtil12.I(var7.end());
      Util114.m_2977(1.0F);
   }

   private static int m_3940(int var0, int var1) {
      return MathHelper.clamp(var1, 0, 255) << 24 | var0 & f_9050;
   }

   private int m_2585(int var1, float var2) {
      return m_3940(var1, Math.max(0, Math.min(255, Math.round(m_1518(var1) * var2))));
   }

   private void m_303(MatrixStack var1, float var2, float var3, int var4) {
      Matrix4f var5 = var1.peek().getPositionMatrix();
      Util114.m_2977(f_9047);
      GL11.glEnable(2848);
      BufferBuilder var6 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);

      for (Wings.tuwKlyxj9UZo8SXY var10 : f_9013) {
         this.m_3675(var6, var5, var2 * var10.f_2754 * var3, var10.f_2755 * var3, 0.0F, var4);
      }

      this.m_3675(var6, var5, var2 * f_9013[0].f_2754 * var3, f_9013[0].f_2755 * var3, 0.0F, var4);
      RenderUtil12.I(var6.end());
      GL11.glDisable(2848);
      Util114.m_2977(1.0F);
   }

   private void m_3675(BufferBuilder var1, Matrix4f var2, float var3, float var4, float var5, int var6) {
      var1.vertex(var2, var3, var4, var5).color(m_537(var6), m_2626(var6), m_3550(var6), m_1518(var6));
   }

   private void m_4054(MatrixStack var1, PlayerEntity var2, float var3, Vec3d var4) {
      Vec3d var5 = var2.getLerpedPos(var3);
      double var6 = var5.x - var4.x;
      double var8 = var5.y - var4.y;
      double var10 = var5.z - var4.z;
      float var12 = this.m_116(var2, var3);
      float var13 = MathHelper.clamp(var2.limbAnimator.getAmplitude(var3), 0.0F, 1.0F);
      Wings.Z3alJTOQiSz8phy4 var14 = this.m_488(var2, var3);
      if (var14 != null) {
         float var15 = (float)Math.sin((var2.age + var3) * var14.f_3926) * var14.f_3920;
         float var16 = (this.f_9017.m_4046() + var15 + var13 * var14.f_3919) * var14.f_3917;
         float var17 = this.f_9016.m_4046() * var14.f_3918;
         int var18 = MathHelper.clamp(Math.round(this.f_9018.m_4046()), 0, 255);
         int var19 = this.m_1378();
         int var20 = this.m_2537(var19);
         int var21 = this.m_2521(var19);
         var1.push();
         var1.translate(var6, var8, var10);
         var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_9037 - var12));
         if (var14.f_3911 != 0.0F || var14.f_3912 != 0.0F) {
            var1.translate(0.0, var14.f_3911, var14.f_3912);
         }

         if (var14.f_3915 != 0.0F) {
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var14.f_3915));
         }

         if (var14.f_3916 != 0.0F) {
            var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var14.f_3916));
         }

         var1.translate(0.0, var14.f_3913, var14.f_3914);
         var1.scale(var17, var17, var17);
         this.m_3839(var1, f_9038, var16, var19, var20, var21, var19, var14, var18);
         this.m_3839(var1, 1.0F, var16, var19, var20, var21, var19, var14, var18);
         var1.pop();
      }
   }

   private static int m_537(int var0) {
      return var0 >> 16 & 0xFF;
   }

   @Override
   public void m_1() {
      this.f_9020 = false;
      super.m_1();
   }

   @EventHandler
   public void m_1019(Util88 var1) {
      if (f_5909.player != null && f_5909.world != null && f_5909.gameRenderer != null) {
         MatrixStack var2 = var1.m_213();
         float var3 = var1.m_191();
         Camera var4 = f_5909.gameRenderer.getCamera();
         Vec3d var5 = var4.getCameraPos();
         Util114.m_3784(RenderUtil7.f_13885);
         Util114.m_1481();
         Util114.m_3978();
         Util114.m_100();
         Util114.m_1878(false);

         try {
            Perspective var6 = f_5909.options.getPerspective();
            if (this.f_9014.m_1163()
               && (!RenderUtil3.m_844().m_1207() || RenderUtil3.m_844().m_3164(Util150.WINGS) == null)
               && !var6.isFirstPerson()
               && f_5909.player.isAlive()
               && !this.m_1344(f_5909.player)) {
               this.m_4054(var2, f_5909.player, var3, var5);
            }

            if (this.f_9015.m_1163()) {
               for (PlayerEntity var8 : f_5909.world.getPlayers()) {
                  if (var8 != f_5909.player && var8.isAlive() && !this.m_1344(var8)) {
                     this.m_4054(var2, var8, var3, var5);
                  }
               }
            }
         } catch (Exception var12) {
         } finally {
            Util114.m_1878(true);
            Util114.m_1562();
            Util114.m_963();
            Util114.m_542();
         }
      }
   }

   private static float m_371(float var0, float var1, float var2) {
      float var3 = MathHelper.wrapDegrees(var1 - var0);
      var3 = MathHelper.clamp(var3, -var2, var2);
      return var0 + var3;
   }

   private void m_4081(MatrixStack var1, float var2, float var3, int var4, int var5) {
      Matrix4f var6 = var1.peek().getPositionMatrix();
      BufferBuilder var7 = Tessellator.getInstance().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);

      for (int var8 = 0; var8 < f_9013.length; var8++) {
         Wings.tuwKlyxj9UZo8SXY var9 = f_9013[var8];
         Wings.tuwKlyxj9UZo8SXY var10 = f_9013[(var8 + 1) % f_9013.length];
         this.m_3675(var7, var6, 0.0F, 0.0F, 0.0F, var4);
         this.m_3675(var7, var6, var2 * var9.f_2754 * var3, var9.f_2755 * var3, 0.0F, this.m_2585(var5, var9.f_2756));
         this.m_3675(var7, var6, var2 * var10.f_2754 * var3, var10.f_2755 * var3, 0.0F, this.m_2585(var5, var10.f_2756));
      }

      RenderUtil12.I(var7.end());
   }

   private float m_116(PlayerEntity var1, float var2) {
      float var3 = MathHelper.lerpAngleDegrees(var2, var1.lastBodyYaw, var1.bodyYaw);
      if (var1 != f_5909.player) {
         return var3;
      } else if (this.f_9020 && var1.age >= 2) {
         this.f_9019 = m_371(this.f_9019, var3, f_9053);
         return this.f_9019;
      } else {
         this.f_9019 = var3;
         this.f_9020 = true;
         return this.f_9019;
      }
   }

   private static int m_1518(int var0) {
      return var0 >> 24 & 0xFF;
   }

   private int m_2521(int var1) {
      return Util71.m_2924(var1, f_9012, f_9052);
   }

   private boolean m_1344(PlayerEntity var1) {
      return var1.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.ELYTRA;
   }

   private int m_1378() {
      return EnergyClient.getTheme(0);
   }

   private int m_2537(int var1) {
      return Util71.m_2924(var1, f_9012, f_9051);
   }

   private Wings.Z3alJTOQiSz8phy4 m_488(PlayerEntity var1, float var2) {
      float var3 = MathHelper.lerp(var2, var1.lastPitch, var1.getPitch());
      if (var1.isGliding()) {
         float var4 = var1.age + var2;
         float var5 = MathHelper.clamp(var4 * var4 / f_9054, 0.0F, 1.0F);
         float var6 = var5 * (f_9055 - var3);
         return new Wings.Z3alJTOQiSz8phy4(f_9056, f_9057, 0.0F, 0.0F, var6, 0.0F, f_9058, f_9059, f_9060, f_9061, f_9062, f_9063, f_9064, f_9065, f_9066);
      } else if (var1.isTouchingWater()) {
         return null;
      } else {
         return var1.isSneaking()
            ? new Wings.Z3alJTOQiSz8phy4(0.0F, 0.0F, f_9067, f_9068, f_9069, 0.0F, 1.0F, 1.0F, f_9070, f_9071, f_9072, f_9073, f_9074, f_9075, f_9076)
            : new Wings.Z3alJTOQiSz8phy4(0.0F, 0.0F, f_9077, f_9078, 0.0F, 0.0F, 1.0F, 1.0F, f_9079, f_9080, f_9081, f_9082, f_9083, f_9084, f_9085);
      }
   }

   private void m_3839(MatrixStack var1, float var2, float var3, int var4, int var5, int var6, int var7, Wings.Z3alJTOQiSz8phy4 var8, int var9) {
      var1.push();
      var1.translate(var2 * var8.f_3921, var8.f_3922, var8.f_3923);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var2 * var3));
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var2 * var8.f_3924));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var8.f_3925));
      Util114.m_582(770, 1);
      this.m_4081(var1, var2, f_9039, m_3940(var5, Math.round(var9 * f_9040)), m_3940(var5, 0));
      this.m_4081(var1, var2, f_9041, m_3940(var6, Math.round(var9 * f_9042)), m_3940(var6, 0));
      Util114.m_582(770, 771);
      this.m_4081(var1, var2, 1.0F, m_3940(var4, var9), m_3940(var4, Math.max(18, Math.round(var9 * f_9043))));
      Util114.m_582(770, 1);
      this.m_303(var1, var2, 1.0F, m_3940(var7, Math.round(var9 * f_9044)));
      this.m_961(var1, var2, f_9045, m_3940(var5, Math.round(var9 * f_9046)));
      var1.pop();
   }

   private static int m_2626(int var0) {
      return var0 >> 8 & 0xFF;
   }

   public Wings() {
      super(f_9021, f_9022, Category.RENDER);
      this.f_9014 = new BooleanSetting(f_9023, true);
      this.f_9015 = new BooleanSetting(f_9024, false);
      this.f_9016 = new NumberSetting(f_9025, 1.0F, f_9026, f_9027, f_9028);
      this.f_9017 = new NumberSetting(f_9029, f_9030, 2.0F, f_9031, f_9032);
      this.f_9018 = new NumberSetting(f_9033, f_9034, f_9035, f_9036, 1.0F);
   }

   private static int m_3550(int var0) {
      return var0 & 0xFF;
   }

   private static int m_1732(int var0, int var1, int var2, int var3) {
      return var3 << 24 | var0 << 16 | var1 << 8 | var2;
   }

   private static final class Z3alJTOQiSz8phy4 {
      private final float f_3911;
      private final float f_3912;
      private final float f_3913;
      private final float f_3914;
      private final float f_3915;
      private final float f_3916;
      private final float f_3917;
      private final float f_3918;
      private final float f_3919;
      private final float f_3920;
      private final float f_3921;
      private final float f_3922;
      private final float f_3923;
      private final float f_3924;
      private final float f_3925;
      private final float f_3926;

      private Z3alJTOQiSz8phy4(
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
         float var16
      ) {
         this.f_3911 = var1;
         this.f_3912 = var2;
         this.f_3913 = var3;
         this.f_3914 = var4;
         this.f_3915 = var5;
         this.f_3916 = var6;
         this.f_3917 = var7;
         this.f_3918 = var8;
         this.f_3919 = var9;
         this.f_3920 = var10;
         this.f_3921 = var11;
         this.f_3922 = var12;
         this.f_3923 = var13;
         this.f_3924 = var14;
         this.f_3925 = var15;
         this.f_3926 = var16;
      }

      private Z3alJTOQiSz8phy4(
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
         float var15
      ) {
         this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, 0.0F, var12, var13, var14, var15);
      }
   }

   private static final class tuwKlyxj9UZo8SXY {
      private final float f_2754;
      private final float f_2755;
      private final float f_2756;

      private tuwKlyxj9UZo8SXY(float var1, float var2, float var3) {
         this.f_2754 = var1;
         this.f_2755 = var2;
         this.f_2756 = var3;
      }
   }
}
