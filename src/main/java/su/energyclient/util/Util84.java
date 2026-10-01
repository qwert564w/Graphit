package su.energyclient.util;

import java.util.ArrayList;
import java.util.List;

public final class Util84 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_5698 = 0.08F;
   private static final double f_5699 = 0.5;
   private static final double f_5700 = 0.5;
   private static final double f_5701 = 0.5;
   private static final double f_5702 = 12.0;
   private static final double f_5703 = 8.0;
   private static final double f_5704 = 180.0;
   private static final double f_5705 = Math.PI;
   private static final double f_5706 = 90.0;
   private static final double f_5707 = 180.0;
   private static final double f_5708 = Math.PI;
   private static final float f_5709 = 0.1F;
   private static final float f_5710 = 0.1F;
   private static final double f_5711 = -0.5;
   private static final double f_5712 = -0.5;
   private static final float f_5713 = -90.0F;
   private static final float f_5714 = 90.0F;
   private static final double f_5715 = 0.6F;
   private static final double f_5716 = 0.2F;
   private static final double f_5717 = 8.0;
   private static final float f_5718 = 0.15F;
   private static final float f_5719 = 360.0F;
   private static final float f_5720 = 180.0F;
   private static final float f_5721 = 360.0F;
   private static final float f_5722 = -180.0F;
   private static final float f_5723 = 360.0F;

   public static Util84.ADLmJDhJTjAJsXY0 m_1594(Util84.pMle25VTIq1tj2GU var0, Util84.pMle25VTIq1tj2GU var1) {
      double var2 = var1.x - var0.x;
      double var4 = var1.y - var0.y;
      double var6 = var1.z - var0.z;
      return new Util84.ADLmJDhJTjAJsXY0(
         (float)(Math.atan2(var6, var2) * f_5704 / f_5705 - f_5706), (float)(-Math.atan2(var4, Math.sqrt(var2 * var2 + var6 * var6)) * f_5707 / f_5708)
      );
   }

   private static float m_3160(double var0, double var2) {
      double var4 = var2 * f_5715 + f_5716;
      return (float)(var0 * var4 * var4 * var4 * f_5717) * f_5718;
   }

   public static List<Util84.pMle25VTIq1tj2GU> m_2738(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = f_5698;
      double var14 = var0 + var12;
      double var16 = var6 - var12;
      double var18 = var4 + var12;
      double var20 = var10 - var12;
      double var22 = var16 - var14;
      double var24 = var8 - var2;
      if (!(var22 <= 0.0) && !(var20 <= var18) && !(var24 <= 0.0)) {
         ArrayList var26 = new ArrayList(396);

         for (int var27 = 0; var27 < 12; var27++) {
            double var28 = var2 + var24 / f_5702 * var27;

            for (int var30 = 0; var30 < 8; var30++) {
               double var31 = var22 / f_5703 * var30;
               var26.add(new Util84.pMle25VTIq1tj2GU(var14, var28, var18 + var31));
               var26.add(new Util84.pMle25VTIq1tj2GU(var16, var28, var18 + var31));
               var26.add(new Util84.pMle25VTIq1tj2GU(var14 + var31, var28, var18));
               var26.add(new Util84.pMle25VTIq1tj2GU(var14 + var31, var28, var20));
            }

            var26.add(new Util84.pMle25VTIq1tj2GU(var16, var28, var20));
         }

         return var26;
      } else {
         return List.of(new Util84.pMle25VTIq1tj2GU((var0 + var6) * f_5699, (var2 + var8) * f_5700, (var4 + var10) * f_5701));
      }
   }

   private Util84() {
   }

   private static float m_3012(float var0) {
      float var1 = var0 % f_5719;
      if (var1 >= f_5720) {
         var1 -= f_5721;
      }

      if (var1 < f_5722) {
         var1 += f_5723;
      }

      return var1;
   }

   public static double m_1337(Util84.ADLmJDhJTjAJsXY0 var0, Util84.ADLmJDhJTjAJsXY0 var1) {
      return (double)Math.abs(m_3012(var1.yaw - var0.yaw)) + Math.abs(var1.pitch - var0.pitch);
   }

   public static Util84.ADLmJDhJTjAJsXY0 m_1073(
      Util84.ADLmJDhJTjAJsXY0 var0, Util84.ADLmJDhJTjAJsXY0 var1, float var2, boolean var3, int var4, double var5, Util84.MNHgN2rHmi0fQGnX var7
   ) {
      float var8 = var1.yaw;
      float var9 = var1.pitch;
      if (!var3) {
         if (var4 == 1) {
            var8 = var0.yaw + f_5709;
            var9 = var0.pitch + f_5710;
         } else if (var4 > 1) {
            var8 += (float)(f_5711 + var7.m_2846());
            var9 += (float)(f_5712 + var7.m_2846());
         }
      }

      var8 = var2 + m_3012(var8 - var2);
      float var10 = var0.yaw + m_3012(var8 - var0.yaw);
      float var11 = var10 - var0.yaw;
      float var12 = var9 - var0.pitch;
      float var13 = m_3160(1.0, var5);
      float var14 = var0.yaw + m_3160(Math.round(var11 / var13), var5);
      float var15 = var0.pitch + m_3160(Math.round(var12 / var13), var5);
      return new Util84.ADLmJDhJTjAJsXY0(var14, Math.max(f_5713, Math.min(f_5714, var15)));
   }

   public record ADLmJDhJTjAJsXY0(float yaw, float pitch) {
   }

   public static final class MNHgN2rHmi0fQGnX {
      private final long[] f_10749 = new long[4];
      private static final long f_10750 = -7046029254386353131L;
      private static final long f_10751 = -4658895280553007687L;
      private static final long f_10752 = -7723592293110705685L;
      private static final double f_10753 = 1.110223E-16F;

      public double m_2846() {
         long var1 = Long.rotateLeft(this.f_10749[0] + this.f_10749[3], 23) + this.f_10749[0];
         long var3 = this.f_10749[1] << 17;
         this.f_10749[2] = this.f_10749[2] ^ this.f_10749[0];
         this.f_10749[3] = this.f_10749[3] ^ this.f_10749[1];
         this.f_10749[1] = this.f_10749[1] ^ this.f_10749[2];
         this.f_10749[0] = this.f_10749[0] ^ this.f_10749[3];
         this.f_10749[2] = this.f_10749[2] ^ var3;
         this.f_10749[3] = Long.rotateLeft(this.f_10749[3], 45);
         return (var1 >>> 11) * f_10753;
      }

      public MNHgN2rHmi0fQGnX(long var1) {
         for (int var3 = 0; var3 < this.f_10749.length; var3++) {
            var1 += f_10750;
            long var4 = (var1 ^ var1 >>> 30) * f_10751;
            var4 = (var4 ^ var4 >>> 27) * f_10752;
            this.f_10749[var3] = var4 ^ var4 >>> 31;
         }
      }
   }

   public record pMle25VTIq1tj2GU(double x, double y, double z) {
   }
}
