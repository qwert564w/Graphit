package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector3f;
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
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;

public class Lineglyphs extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_4655;
   private final NumberSetting f_4656;
   private final NumberSetting f_4657;
   private final NumberSetting f_4658;
   private final ModeSetting f_4659;
   private final BooleanSetting f_4660;
   private final BooleanSetting f_4661;
   private final BooleanSetting f_4662;
   private final NumberSetting f_4663;
   private static final Vec3d[] f_4664 = new Vec3d[]{
      new Vec3d(1.0, 0.0, 0.0),
      new Vec3d(Lineglyphs.f_4740, 0.0, 0.0),
      new Vec3d(0.0, 1.0, 0.0),
      new Vec3d(0.0, Lineglyphs.f_4741, 0.0),
      new Vec3d(0.0, 0.0, 1.0),
      new Vec3d(0.0, 0.0, Lineglyphs.f_4742)
   };
   private static final float f_4665 = 0.16F;
   private static final float f_4666 = 0.0F;
   private static final int f_4667 = 0;
   private final ObjectArrayList<Lineglyphs.anKplR6DQHuOcXWq> f_4668;
   private long f_4669;
   private static final String f_4670 = "LineGlyphs";
   private static final String f_4671 = "Рисует растущие неоновые линии вокруг игрока";
   private static final String f_4672 = "Количество";
   private static final float f_4673 = 70.0F;
   private static final float f_4674 = 10.0F;
   private static final float f_4675 = 200.0F;
   private static final float f_4676 = 5.0F;
   private static final String f_4677 = "Радиус";
   private static final float f_4678 = 24.0F;
   private static final float f_4679 = 8.0F;
   private static final float f_4680 = 48.0F;
   private static final String f_4681 = "Скорость";
   private static final float f_4682 = 0.25F;
   private static final float f_4683 = 3.0F;
   private static final float f_4684 = 0.05F;
   private static final String f_4685 = "Толщина";
   private static final float f_4686 = 1.5F;
   private static final float f_4687 = 0.5F;
   private static final float f_4688 = 4.0F;
   private static final float f_4689 = 0.1F;
   private static final String f_4690 = "Цвет";
   private static final String f_4691 = "Градиент";
   private static final String f_4692 = "Тема";
   private static final String f_4693 = "Градиент";
   private static final String f_4694 = "Радуга";
   private static final String f_4695 = "Свечение";
   private static final String f_4696 = "Узлы";
   private static final String f_4697 = "Пунктир";
   private static final String f_4698 = "Длина штриха";
   private static final float f_4699 = 0.35F;
   private static final float f_4700 = 0.1F;
   private static final float f_4701 = 1.5F;
   private static final float f_4702 = 0.05F;
   private static final float f_4703 = 2.6F;
   private static final float f_4704 = 0.16F;
   private static final float f_4705 = 5.0F;
   private static final float f_4706 = 0.06F;
   private static final float f_4707 = 1.0E9F;
   private static final float f_4708 = 0.1F;
   private static final double f_4709 = 1.5;
   private static final double f_4710 = 16.0;
   private static final double f_4711 = 2.0;
   private static final float f_4712 = 0.75F;
   private static final double f_4713 = 6.0;
   private static final double f_4714 = 7.0;
   private static final double f_4715 = -4.0;
   private static final double f_4716 = 12.0;
   private static final float f_4717 = 255.0F;
   private static final double f_4718 = 1.0E-4;
   private static final double f_4719 = 2.0;
   private static final double f_4720 = 1.0E-6;
   private static final double f_4721 = 2.0;
   private static final double f_4722 = 0.5;
   private static final float f_4723 = 1.6F;
   private static final float f_4724 = 255.0F;
   private static final float f_4725 = 0.25F;
   private static final float f_4726 = 0.75F;
   private static final String f_4727 = "Тема";
   private static final String f_4728 = "Радуга";
   private static final float f_4729 = 24.0F;
   private static final float f_4730 = 360.0F;
   private static final float f_4731 = 360.0F;
   private static final float f_4732 = 0.7F;
   private static final int f_4733 = -16777216;
   private static final float f_4734 = 0.4F;
   private static final double f_4735 = 12.0;
   private static final double f_4736 = 0.8;
   private static final double f_4737 = 2.0;
   private static final double f_4738 = 0.4;
   private static final double f_4739 = 1.0E-6;
   private static final double f_4740 = -1.0;
   private static final double f_4741 = -1.0;
   private static final double f_4742 = -1.0;

   private void m_2152(BufferBuilder var1, Matrix4f var2, double var3, double var5, double var7, int var9) {
      var1.vertex(var2, (float)var3, (float)var5, (float)var7).color(var9);
   }

   private void m_2625(BufferBuilder var1, MatrixStack var2, Matrix4f var3, Vec3d var4, int var5, Vector3f var6, float var7) {
      var1.vertex(var3, (float)var4.x, (float)var4.y, (float)var4.z).color(var5).normal(var2.peek(), var6.x(), var6.y(), var6.z()).lineWidth(var7);
   }

   private float m_950() {
      long var1 = System.nanoTime();
      if (this.f_4669 == 0L) {
         this.f_4669 = var1;
         return 0.0F;
      } else {
         float var3 = (float)(var1 - this.f_4669) / f_4707;
         this.f_4669 = var1;
         return Math.min(var3, f_4708);
      }
   }

   private int m_2970(int var1) {
      String var2 = this.f_4659.m_3862();

      return switch (var2) {
         case f_4727 -> EnergyClient.getTheme(0);
         case f_4728 -> Color.HSBtoRGB(((float)System.currentTimeMillis() / f_4729 + var1) % f_4730 / f_4731, f_4732, 1.0F) | f_4733;
         default -> Util71.m_1784(4, var1, EnergyClient.getTheme(0), Util71.m_2101(EnergyClient.getTheme(0), f_4734));
      };
   }

   private static Vector3f m_2010(Vec3d var0, Vec3d var1) {
      Vec3d var2 = var1.subtract(var0);
      double var3 = var2.length();
      return var3 < f_4739 ? new Vector3f(0.0F, 1.0F, 0.0F) : new Vector3f((float)(var2.x / var3), (float)(var2.y / var3), (float)(var2.z / var3));
   }

   private void m_458(MatrixStack var1, Vec3d var2, float var3, float var4) {
      Util114.m_3784(RenderUtil7.f_13887);
      Util114.m_2977(var3);
      BufferBuilder var5 = Tessellator.getInstance().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR_NORMAL_LINE_WIDTH);
      Matrix4f var6 = var1.peek().getPositionMatrix();
      boolean var7 = this.f_4662.m_1163();
      float var8 = this.f_4663.m_4046();
      ObjectListIterator var9 = this.f_4668.iterator();

      while (var9.hasNext()) {
         Lineglyphs.anKplR6DQHuOcXWq var10 = (Lineglyphs.anKplR6DQHuOcXWq)var9.next();
         float var11 = var10.f_3149 * var4 * this.m_3264(var10.m_1971(), var2);
         if (!(var11 * f_4717 < 1.0F)) {
            int var12 = var10.m_1669();
            if (var12 >= 2) {
               Vec3d var13 = var10.l(0);
               int var14 = this.m_3606(var10, 0, var12, var11);

               for (int var15 = 1; var15 < var12; var15++) {
                  Vec3d var16 = var10.l(var15);
                  int var17 = this.m_3606(var10, var15, var12, var11);
                  if (var7) {
                     this.m_2869(var5, var1, var6, var13, var16, var14, var17, var8, var3);
                  } else {
                     this.m_1619(var5, var1, var6, var13, var16, var14, var17, var3);
                  }

                  var13 = var16;
                  var14 = var17;
               }
            }
         }
      }

      BuiltBuffer var18 = var5.endNullable();
      if (var18 != null) {
         RenderUtil12.I(var18);
      }
   }

   private float m_3264(Vec3d var1, Vec3d var2) {
      double var3 = this.f_4656.m_4046() + f_4735;
      double var5 = var1.distanceTo(var2);
      float var7 = MathHelper.clamp((float)((var5 - f_4736) / f_4737), 0.0F, 1.0F);
      float var8 = MathHelper.clamp((float)((var3 - var5) / (var3 * f_4738)), 0.0F, 1.0F);
      return var7 * var8;
   }

   private void m_385(float var1, Vec3d var2) {
      double var3 = Math.pow(this.f_4656.m_4046() * f_4709 + f_4710, f_4711);
      ObjectListIterator var5 = this.f_4668.iterator();

      while (var5.hasNext()) {
         Lineglyphs.anKplR6DQHuOcXWq var6 = (Lineglyphs.anKplR6DQHuOcXWq)var5.next();
         if (var6.m_1971().squaredDistanceTo(var2) > var3) {
            var6.m_1696();
         }

         var6.m_2526(var1, this.f_4657.m_4046());
      }

      this.f_4668.removeIf(Lineglyphs.anKplR6DQHuOcXWq::m_1498);
      int var8 = 0;
      ObjectListIterator var9 = this.f_4668.iterator();

      while (var9.hasNext()) {
         Lineglyphs.anKplR6DQHuOcXWq var7 = (Lineglyphs.anKplR6DQHuOcXWq)var9.next();
         if (!var7.f_3150) {
            var8++;
         }
      }

      int var10 = this.f_4655.m_134().intValue();

      for (int var11 = 0; var11 < 4 && var8 < var10; var8++) {
         this.f_4668.add(new Lineglyphs.anKplR6DQHuOcXWq(this.m_1291(var2)));
         var11++;
      }
   }

   @Override
   public void m_1() {
      this.f_4668.clear();
      super.m_1();
   }

   private void m_2869(BufferBuilder var1, MatrixStack var2, Matrix4f var3, Vec3d var4, Vec3d var5, int var6, int var7, float var8, float var9) {
      double var10 = var4.distanceTo(var5);
      if (!(var10 <= f_4718)) {
         Vector3f var12 = m_2010(var4, var5);
         double var13 = var8 * f_4719;

         for (double var15 = 0.0; var15 < var10; var15 += var13) {
            double var17 = var15 / var10;
            double var19 = Math.min(var15 + var8, var10) / var10;
            this.m_2625(var1, var2, var3, var4.lerp(var5, var17), Util71.m_2924(var6, var7, (float)var17), var12, var9);
            this.m_2625(var1, var2, var3, var4.lerp(var5, var19), Util71.m_2924(var6, var7, (float)var19), var12, var9);
         }
      }
   }

   private Vec3d m_1291(Vec3d var1) {
      ThreadLocalRandom var2 = ThreadLocalRandom.current();
      float var3 = ((Integer)f_5909.options.getFov().getValue()).intValue() * f_4712;
      double var4 = Math.toRadians(f_5909.player.getYaw() + var2.nextFloat(-var3, var3));
      double var6 = var2.nextDouble(f_4713, Math.max(f_4714, (double)this.f_4656.m_4046()));
      return new Vec3d(
         Math.round(var1.x - Math.sin(var4) * var6), Math.round(var1.y + var2.nextDouble(f_4715, f_4716)), Math.round(var1.z + Math.cos(var4) * var6)
      );
   }

   private void m_1619(BufferBuilder var1, MatrixStack var2, Matrix4f var3, Vec3d var4, Vec3d var5, int var6, int var7, float var8) {
      Vector3f var9 = m_2010(var4, var5);
      this.m_2625(var1, var2, var3, var4, var6, var9, var8);
      this.m_2625(var1, var2, var3, var5, var7, var9, var8);
   }

   private void m_1497(BufferBuilder var1, Matrix4f var2, Vec3d var3, Vec3d var4, Vec3d var5, double var6, int var8) {
      double var9 = var4.x * var6;
      double var11 = var4.y * var6;
      double var13 = var4.z * var6;
      double var15 = var5.x * var6;
      double var17 = var5.y * var6;
      double var19 = var5.z * var6;
      this.m_2152(var1, var2, var3.x - var9 - var15, var3.y - var11 - var17, var3.z - var13 - var19, var8);
      this.m_2152(var1, var2, var3.x + var9 - var15, var3.y + var11 - var17, var3.z + var13 - var19, var8);
      this.m_2152(var1, var2, var3.x + var9 + var15, var3.y + var11 + var17, var3.z + var13 + var19, var8);
      this.m_2152(var1, var2, var3.x - var9 + var15, var3.y - var11 + var17, var3.z - var13 + var19, var8);
   }

   private void m_1516(MatrixStack var1, Camera var2, Vec3d var3) {
      int var4 = f_5909.getWindow().getFramebufferHeight();
      if (var4 > 0) {
         Vec3d var5 = Vec3d.fromPolar(var2.getPitch(), var2.getYaw());
         Vec3d var6 = var5.crossProduct(new Vec3d(0.0, 1.0, 0.0));
         Vec3d var7 = var6.lengthSquared() < f_4720 ? new Vec3d(1.0, 0.0, 0.0) : var6.normalize();
         Vec3d var8 = var7.crossProduct(var5).normalize();
         double var9 = f_4721 * Math.tan(Math.toRadians(((Integer)f_5909.options.getFov().getValue()).intValue()) * f_4722) / var4;
         float var11 = this.f_4658.m_4046() * f_4723;
         Util114.m_3784(RenderUtil7.f_13885);
         BufferBuilder var12 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         Matrix4f var13 = var1.peek().getPositionMatrix();
         ObjectListIterator var14 = this.f_4668.iterator();

         while (var14.hasNext()) {
            Lineglyphs.anKplR6DQHuOcXWq var15 = (Lineglyphs.anKplR6DQHuOcXWq)var14.next();
            float var16 = var15.f_3149 * this.m_3264(var15.m_1971(), var3);
            if (!(var16 * f_4724 < 1.0F)) {
               int var17 = var15.m_1669();

               for (int var18 = 0; var18 < var17; var18++) {
                  Vec3d var19 = var15.l(var18);
                  double var20 = var19.distanceTo(var3) * var9 * var11;
                  this.m_1497(var12, var13, var19, var7, var8, var20, this.m_3606(var15, var18, var17, var16));
               }
            }
         }

         BuiltBuffer var22 = var12.endNullable();
         if (var22 != null) {
            RenderUtil12.I(var22);
         }
      }
   }

   public Lineglyphs() {
      super(f_4670, f_4671, Category.RENDER);
      this.f_4655 = new NumberSetting(f_4672, f_4673, f_4674, f_4675, f_4676);
      this.f_4656 = new NumberSetting(f_4677, f_4678, f_4679, f_4680, 1.0F);
      this.f_4657 = new NumberSetting(f_4681, 1.0F, f_4682, f_4683, f_4684);
      this.f_4658 = new NumberSetting(f_4685, f_4686, f_4687, f_4688, f_4689);
      this.f_4659 = new ModeSetting(f_4690, f_4691, f_4692, f_4693, f_4694);
      this.f_4660 = new BooleanSetting(f_4695, true);
      this.f_4661 = new BooleanSetting(f_4696, true);
      this.f_4662 = new BooleanSetting(f_4697, false);
      this.f_4663 = new NumberSetting(f_4698, f_4699, f_4700, f_4701, f_4702).m_356(this.f_4662::m_1163);
      this.f_4668 = new ObjectArrayList();
   }

   @EventHandler
   private void m_2966(Util88 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         Camera var2 = f_5909.gameRenderer.getCamera();
         Vec3d var3 = var2.getCameraPos();
         this.m_385(this.m_950(), var3);
         if (!this.f_4668.isEmpty()) {
            MatrixStack var4 = var1.m_213();
            var4.push();
            var4.translate(-var3.x, -var3.y, -var3.z);
            Util114.m_1481();
            Util114.m_3978();
            Util114.m_100();
            Util114.m_1878(false);
            if (this.f_4660.m_1163()) {
               Util114.m_582(770, 1);
               this.m_458(var4, var3, this.f_4658.m_4046() * f_4703, f_4704);
               this.m_458(var4, var3, this.f_4658.m_4046() * f_4705, f_4706);
            }

            Util114.m_542();
            this.m_458(var4, var3, this.f_4658.m_4046(), 1.0F);
            if (this.f_4661.m_1163()) {
               Util114.m_582(770, 1);
               this.m_1516(var4, var2, var3);
               Util114.m_542();
            }

            Util114.m_2977(1.0F);
            Util114.m_1878(true);
            Util114.m_1562();
            Util114.m_963();
            var4.pop();
         }
      }
   }

   private int m_3606(Lineglyphs.anKplR6DQHuOcXWq var1, int var2, int var3, float var4) {
      float var5 = f_4725 + f_4726 * var2 / Math.max(1, var3 - 1);
      return Util71.m_3765(this.m_2970(var1.f_3144 + var2 * 12), var4 * var5);
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_4668.clear();
      this.f_4669 = 0L;
   }

   private static final class anKplR6DQHuOcXWq {
      private final ObjectArrayList<Vec3d> f_3143 = new ObjectArrayList();
      private final int f_3144;
      private Vec3d f_3145;
      private Vec3d f_3146;
      private int f_3147;
      private float f_3148;
      private float f_3149;
      private boolean f_3150;
      private static final float f_3151 = 4.5F;
      private static final float f_3152 = -1.0F;
      private static final float f_3153 = 0.16F;
      private static final float f_3154 = 0.004F;

      private void m_1386() {
         ThreadLocalRandom var1 = ThreadLocalRandom.current();

         Vec3d var2;
         do {
            var2 = Lineglyphs.f_4664[var1.nextInt(Lineglyphs.f_4664.length)];
         } while (O(var2, this.f_3145));

         this.f_3145 = var2;
      }

      private Vec3d l(int var1) {
         return var1 < this.f_3143.size() ? (Vec3d)this.f_3143.get(var1) : ((Vec3d)this.f_3143.get(this.f_3143.size() - 1)).lerp(this.f_3146, this.f_3148);
      }

      private void m_2526(float var1, float var2) {
         this.f_3149 = MathHelper.clamp(this.f_3149 + var1 * f_3151 * (this.f_3150 ? f_3152 : 1.0F), 0.0F, 1.0F);
         if (!this.f_3150) {
            for (this.f_3148 = this.f_3148 + var1 * var2 / f_3153; this.f_3148 >= 1.0F; this.f_3146 = this.O(this.f_3146)) {
               this.f_3148--;
               this.f_3143.add(this.f_3146);
               if (--this.f_3147 <= 0) {
                  this.m_1696();
                  return;
               }

               this.m_1386();
            }
         }
      }

      private int m_1669() {
         return this.f_3143.size() + (this.f_3150 ? 0 : 1);
      }

      private Vec3d m_1971() {
         return (Vec3d)this.f_3143.get(0);
      }

      private boolean m_1498() {
         return this.f_3150 && this.f_3149 <= f_3154;
      }

      private anKplR6DQHuOcXWq(Vec3d var1) {
         ThreadLocalRandom var2 = ThreadLocalRandom.current();
         this.f_3144 = var2.nextInt(360);
         this.f_3147 = var2.nextInt(7, 13);
         this.f_3145 = Lineglyphs.f_4664[var2.nextInt(Lineglyphs.f_4664.length)];
         this.f_3143.add(var1);
         this.f_3146 = this.O(var1);
      }

      private static boolean O(Vec3d var0, Vec3d var1) {
         return var0.x != 0.0 && var1.x != 0.0 || var0.y != 0.0 && var1.y != 0.0 || var0.z != 0.0 && var1.z != 0.0;
      }

      private Vec3d O(Vec3d var1) {
         return var1.add(this.f_3145.multiply(ThreadLocalRandom.current().nextInt(1, 4)));
      }

      private void m_1696() {
         this.f_3150 = true;
      }
   }
}
