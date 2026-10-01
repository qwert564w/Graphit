package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import su.energyclient.EnergyClient;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util24;
import su.energyclient.util.Util71;
import su.energyclient.util.Util98;
import su.energyclient.util.math.MathUtil6;

public class Shadersky extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static Shadersky f_13903;
   private final ModeSetting l;
   private final NumberSetting f_13904;
   private final NumberSetting f_13905;
   private final NumberSetting f_13906;
   private final NumberSetting f_13907;
   private final NumberSetting f_13908;
   private final BooleanSetting f_13909;
   private final long f_13910;
   private static final String f_13911 = "ShaderSky";
   private static final String f_13912 = "Превращает небо в красивое полярное сияние";
   private static final String f_13913 = "Палитра";
   private static final String f_13914 = "Полярное";
   private static final String f_13915 = "Полярное";
   private static final String f_13916 = "Изумруд";
   private static final String f_13917 = "Розовое";
   private static final String f_13918 = "Закат";
   private static final String f_13919 = "Интерфейс";
   private static final String f_13920 = "Скорость";
   private static final float f_13921 = 3.0F;
   private static final float f_13922 = 0.05F;
   private static final String f_13923 = "Интенсивность";
   private static final float f_13924 = 0.1F;
   private static final float f_13925 = 0.05F;
   private static final String f_13926 = "Масштаб волн";
   private static final float f_13927 = 0.3F;
   private static final float f_13928 = 3.0F;
   private static final float f_13929 = 0.05F;
   private static final String f_13930 = "Яркость";
   private static final float f_13931 = 100.0F;
   private static final float f_13932 = 20.0F;
   private static final float f_13933 = 200.0F;
   private static final String f_13934 = "Непрозрачность";
   private static final float f_13935 = 100.0F;
   private static final float f_13936 = 100.0F;
   private static final String f_13937 = "Звёзды";
   private static final float f_13938 = 1.0E9F;
   private static final String f_13939 = "u_WorldFromView";
   private static final String f_13940 = "u_Resolution";
   private static final String f_13941 = "u_Fov";
   private static final String f_13942 = "time";
   private static final String f_13943 = "speed";
   private static final String f_13944 = "intensity";
   private static final String f_13945 = "waveScale";
   private static final String f_13946 = "starStrength";
   private static final String f_13947 = "saturation";
   private static final String f_13948 = "brightness";
   private static final float f_13949 = 100.0F;
   private static final String f_13950 = "skyAlpha";
   private static final float f_13951 = 100.0F;
   private static final String f_13952 = "lowColor";
   private static final String f_13953 = "highColor";
   private static final String f_13954 = "deepColor";
   private static final String f_13955 = "ProjMat";
   private static final String f_13956 = "ProjMat";
   private static final String f_13957 = "ModelViewMat";
   private static final String f_13958 = "ModelViewMat";
   private static final float f_13959 = -1.0F;
   private static final float f_13960 = -1.0F;
   private static final float f_13961 = -1.0F;
   private static final float f_13962 = -1.0F;
   private static final String f_13963 = "Изумруд";
   private static final String f_13964 = "Розовое";
   private static final String f_13965 = "Закат";
   private static final String f_13966 = "Интерфейс";
   private static final float f_13967 = 255.0F;
   private static final float f_13968 = 255.0F;
   private static final float f_13969 = 255.0F;

   public void m_3408() {
      if (f_5909.world != null && f_5909.gameRenderer != null && !f_5909.gameRenderer.isRenderingPanorama()) {
         Util98 var1 = Util114.m_827(Util24.f_3285);
         if (var1 != null) {
            Camera var2 = f_5909.gameRenderer.getCamera();
            Quaternionf var3 = new Quaternionf(var2.getRotation());
            var3.conjugate();
            Matrix4f var4 = new Matrix4f().rotation(var3);
            Matrix4f var5 = new Matrix4f(var4).transpose();
            int var6 = f_5909.getWindow().getFramebufferWidth();
            int var7 = f_5909.getWindow().getFramebufferHeight();
            float var8 = (float)Math.toRadians(((Integer)f_5909.options.getFov().getValue()).intValue());
            float var9 = (float)(System.nanoTime() - this.f_13910) / f_13938;
            float[] var10 = this.m_2801(0);
            float[] var11 = this.m_2801(1);
            float[] var12 = this.m_2801(2);
            this.m_2849(var1, f_13939, var5);
            this.m_862(var1, f_13940, var6, var7);
            this.m_1588(var1, f_13941, var8);
            this.m_1588(var1, f_13942, var9);
            this.m_1588(var1, f_13943, this.f_13904.m_4046());
            this.m_1588(var1, f_13944, this.f_13905.m_4046());
            this.m_1588(var1, f_13945, this.f_13906.m_4046());
            this.m_1588(var1, f_13946, this.f_13909.m_1163() ? 1.0F : 0.0F);
            this.m_1588(var1, f_13947, 1.0F);
            this.m_1588(var1, f_13948, this.f_13907.m_4046() / f_13949);
            this.m_1588(var1, f_13950, this.f_13908.m_4046() / f_13951);
            this.m_2683(var1, f_13952, var10);
            this.m_2683(var1, f_13953, var11);
            this.m_2683(var1, f_13954, var12);
            Matrix4f var13 = new Matrix4f();
            if (var1.m_1335(f_13955) != null) {
               var1.m_1335(f_13956).m_23(var13);
            }

            if (var1.m_1335(f_13957) != null) {
               var1.m_1335(f_13958).m_23(var13);
            }

            Util114.m_1878(false);
            Util114.m_672();
            Util114.m_3978();
            Util114.m_1481();
            Util114.m_542();
            Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
            BufferBuilder var14 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION);
            var14.vertex(var13, f_13959, f_13960, 0.0F);
            var14.vertex(var13, 1.0F, f_13961, 0.0F);
            var14.vertex(var13, 1.0F, 1.0F, 0.0F);
            var14.vertex(var13, f_13962, 1.0F, 0.0F);
            RenderUtil12.I(var14.end());
            Util114.m_963();
            Util114.m_542();
            Util114.m_1562();
            Util114.m_100();
            Util114.m_1878(true);
            Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         }
      }
   }

   private void m_1588(Util98 var1, String var2, float var3) {
      MathUtil6 var4 = var1.m_1335(var2);
      if (var4 != null) {
         var4.O(var3);
      }
   }

   public Shadersky() {
      super(f_13911, f_13912, Category.RENDER);
      this.l = new ModeSetting(f_13913, f_13914, f_13915, f_13916, f_13917, f_13918, f_13919);
      this.f_13904 = new NumberSetting(f_13920, 1.0F, 0.0F, f_13921, f_13922);
      this.f_13905 = new NumberSetting(f_13923, 1.0F, f_13924, 2.0F, f_13925);
      this.f_13906 = new NumberSetting(f_13926, 1.0F, f_13927, f_13928, f_13929);
      this.f_13907 = new NumberSetting(f_13930, f_13931, f_13932, f_13933, 1.0F);
      this.f_13908 = new NumberSetting(f_13934, f_13935, 0.0F, f_13936, 1.0F);
      this.f_13909 = new BooleanSetting(f_13937, true);
      this.f_13910 = System.nanoTime();
      f_13903 = this;
   }

   private void m_2849(Util98 var1, String var2, Matrix4f var3) {
      MathUtil6 var4 = var1.m_1335(var2);
      if (var4 != null) {
         var4.m_23(var3);
      }
   }

   public static boolean m_608() {
      return f_13903 != null && f_13903.m_677() && f_5909.world != null;
   }

   private void m_862(Util98 var1, String var2, float var3, float var4) {
      MathUtil6 var5 = var1.m_1335(var2);
      if (var5 != null) {
         var5.m_54(var3, var4);
      }
   }

   private float[] m_1356(int var1, int var2, int var3) {
      return new float[]{var1 / f_13967, var2 / f_13968, var3 / f_13969, 1.0F};
   }

   private void m_2683(Util98 var1, String var2, float[] var3) {
      MathUtil6 var4 = var1.m_1335(var2);
      if (var4 != null) {
         var4.m_41(var3[0], var3[1], var3[2], var3[3]);
      }
   }

   private float[] m_2801(int var1) {
      String var2 = this.l.m_3862();
      switch (var2) {
         case f_13963:
            return var1 == 0 ? this.m_1356(15, 235, 110) : (var1 == 1 ? this.m_1356(30, 245, 210) : this.m_1356(4, 14, 18));
         case f_13964:
            return var1 == 0 ? this.m_1356(240, 60, 170) : (var1 == 1 ? this.m_1356(135, 80, 255) : this.m_1356(14, 4, 22));
         case f_13965:
            return var1 == 0 ? this.m_1356(255, 120, 40) : (var1 == 1 ? this.m_1356(245, 70, 150) : this.m_1356(20, 6, 14));
         case f_13966:
            int var4 = EnergyClient.getTheme(0);
            if (var1 == 0) {
               return Util71.m_2326(var4);
            } else {
               if (var1 == 1) {
                  return Util71.m_2326(Util71.m_3793(var4, 80));
               }

               return this.m_1356(6, 8, 18);
            }
         default:
            return var1 == 0 ? this.m_1356(25, 240, 120) : (var1 == 1 ? this.m_1356(150, 70, 235) : this.m_1356(4, 8, 20));
      }
   }
}
