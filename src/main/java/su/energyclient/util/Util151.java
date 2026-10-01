package su.energyclient.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.util.math.MathUtil2;

public class Util151 implements QuickImports, Util148 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_10924 = 24.0F;
   private static final float f_10925 = 0.0F;
   private static final float f_10926 = 0.0F;
   private static final float f_10927 = 0.0F;
   private static final float f_10928 = 0.0F;
   private static final int f_10929 = 0;
   private static final int f_10930 = 0;
   private static final int f_10931 = 0;
   private static final float f_10932 = 0.0F;
   private static final float f_10933 = 0.0F;
   private static final float f_10934 = 0.0F;
   private static final float f_10935 = 0.0F;
   private static final float f_10936 = 0.0F;
   private static final float f_10937 = 0.0F;
   private static final float f_10938 = 0.0F;
   private static final float f_10939 = 0.0F;
   private float f_10940;
   private float f_10941;
   private float f_10942;
   private float f_10943;
   private int f_10944;
   private int f_10945;
   private int f_10946;
   private boolean f_10947;
   private int f_10948;
   private static final int f_10949 = Integer.MIN_VALUE;
   private static final int f_10950 = Integer.MIN_VALUE;
   private static final int f_10951 = Integer.MIN_VALUE;
   private static final String f_10952 = "Ares/FT";
   private static final double f_10953 = 0.15F;
   private static final float f_10954 = 2.75F;
   private static final float f_10955 = 1.9F;
   private static final float f_10956 = 0.7F;
   private static final float f_10957 = 0.3F;
   private static final float f_10958 = 360.0F;
   private static final float f_10959 = 360.0F;
   private static final float f_10960 = 360.0F;
   private static final float f_10961 = 360.0F;
   private static final float f_10962 = 0.137F;
   private static final int f_10963 = Integer.MIN_VALUE;
   private static final int f_10964 = Integer.MIN_VALUE;
   private static final float f_10965 = 0.41F;
   private static final double f_10966 = 24.0;
   private static final double f_10967 = 0.48;
   private static final float f_10968 = 0.27F;
   private static final double f_10969 = 1.31;
   private static final double f_10970 = 24.0;
   private static final double f_10971 = 0.3;
   private static final float f_10972 = 0.58F;
   private static final double f_10973 = 2.47;
   private static final double f_10974 = 0.19;
   private static final double f_10975 = 0.6;
   private static final double f_10976 = 24.0;
   private static final double f_10977 = 0.22;
   private static final float f_10978 = 0.72F;
   private static final double f_10979 = 0.84;
   private static final double f_10980 = 16.5;
   private static final double f_10981 = 0.55;
   private static final float f_10982 = 0.54F;
   private static final double f_10983 = 2.17;
   private static final double f_10984 = 16.5;
   private static final double f_10985 = 0.38;
   private static final float f_10986 = 0.91F;
   private static final double f_10987 = 1.62;
   private static final double f_10988 = 0.38;
   private static final double f_10989 = 16.5;
   private static final double f_10990 = 0.32;
   private static final int f_10991 = Integer.MIN_VALUE;
   private static final int f_10992 = Integer.MIN_VALUE;
   private static final int f_10993 = Integer.MIN_VALUE;

   @Override
   public void m_11(AttackAura var1) {
      this.m_1059();
   }

   @Override
   public void m_5(AttackAura var1, LivingEntity var2) {
      if (f_5909.player != null && var2 != null) {
         boolean var3 = var2.getId() != this.f_10944;
         if (var3) {
            this.l(var2);
         }

         if (var3 || this.f_10945 != f_5909.player.age) {
            this.f_10945 = f_5909.player.age;
            this.m_3932();
            Vec3d var4 = f_5909.player.getCameraPosVec(1.0F);
            float var5 = var1.f_3566.m_4046();
            double var6 = MathHelper.clamp(f_5909.player.getEyeY() - var2.getY(), 0.0, var2.getHeight() * (f_5909.player.getStandingEyeHeight() / var5));
            Vec3d var8 = var2.getBoundingBox().getHorizontalCenter().add(0.0, f_10953, 0.0).subtract(var4);
            Util10 var9 = Util39.m_3442(var8);
            float var10 = f_5909.player.age + this.f_10940;
            float var11 = this.f_10947 ? f_10954 : 1.0F;
            float var12 = this.f_10947 ? f_10955 : 1.0F;
            boolean var13 = var1.m_2146();
            if (var13) {
               var11 /= 2.0F;
            }

            float var14 = this.l(var10, var11, var12);
            float var15 = this.m_2426(var10);
            float var16 = var9.m_2643() + var14;
            float var17 = Util10.m_1722(this.f_10943 + var15);
            float var18;
            if (var13) {
               this.f_10941 = var16;
               var18 = var16;
            } else {
               this.f_10941 = this.m_2748(this.f_10941, var16, f_10956);
               var18 = this.f_10941;
            }

            if (var13 && !MathUtil2.m_3975(f_5909.player.getYaw(), var17, var5, var2, true)) {
               this.f_10943 = this.m_1796(this.f_10943, var9.m_2573(), f_10957);
               var17 = Util10.m_1722(this.f_10943 + var15);
            }

            this.f_10942 = var17;
            this.m_2374(new Util10(var18, var17));
         }
      }
   }

   private float l(float var1, float var2, float var3) {
      return (float)(
         Math.sin(var1 * f_10965 * var3) * f_10966 * f_10967 * var2
            + Math.cos(var1 * f_10968 * var3 + f_10969) * f_10970 * f_10971 * var2
            + Math.sin(var1 * f_10972 * var3 + f_10973) * Math.cos(var1 * f_10974 * var3 + f_10975) * f_10976 * f_10977 * var2
      );
   }

   public Util151() {
      this.f_10944 = f_10949;
      this.f_10945 = f_10950;
      this.f_10946 = f_10951;
   }

   private void m_1059() {
      this.f_10940 = 0.0F;
      this.f_10941 = 0.0F;
      this.f_10942 = 0.0F;
      this.f_10943 = 0.0F;
      this.f_10944 = f_10991;
      this.f_10945 = f_10992;
      this.f_10946 = f_10993;
      this.f_10947 = false;
      this.f_10948 = 0;
   }

   private float m_2748(float var1, float var2, float var3) {
      return var1 + MathHelper.wrapDegrees(var2 - var1) * var3;
   }

   @Override
   public String m_3() {
      return f_10952;
   }

   private void m_2374(Util10 var1) {
      Util54.m_2145(var1, f_10958, f_10959, f_10960, f_10961, 1, 6, false);
   }

   private float m_1796(float var1, float var2, float var3) {
      return Util10.m_1722(var1 + (var2 - var1) * var3);
   }

   private float m_2426(float var1) {
      return (float)(
         Math.cos(var1 * f_10978 + f_10979) * f_10980 * f_10981
            + Math.sin(var1 * f_10982 + f_10983) * f_10984 * f_10985
            + Math.cos(var1 * f_10986 + f_10987) * Math.sin(var1 * f_10988) * f_10989 * f_10990
      );
   }

   private void l(LivingEntity var1) {
      this.f_10944 = var1.getId();
      this.f_10940 = var1.getId() * f_10962;
      this.f_10941 = f_5909.player.getYaw();
      this.f_10942 = f_5909.player.getPitch();
      this.f_10943 = f_5909.player.getPitch();
      this.f_10945 = f_10963;
      this.f_10946 = f_10964;
   }

   @Override
   public void m_6(AttackAura var1) {
      this.m_1059();
   }

   private void m_3932() {
      if (this.f_10946 != f_5909.player.age) {
         this.f_10946 = f_5909.player.age;
         if (this.f_10947 && --this.f_10948 <= 0) {
            this.f_10947 = false;
            this.f_10948 = 0;
         }
      }
   }

   @Override
   public void m_12(AttackAura var1, LivingEntity var2) {
      this.f_10947 = true;
      this.f_10948 = 6;
   }

   @Override
   public void m_8(AttackAura var1) {
      this.m_1059();
   }
}
