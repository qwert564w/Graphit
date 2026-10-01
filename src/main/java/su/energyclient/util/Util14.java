package su.energyclient.util;

import java.util.Random;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.util.math.MathUtil2;

public class Util14 implements Util148, QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_2874 = 0.05F;
   private static final int f_2875 = 0;
   private static final int f_2876 = 0;
   private final Random f_2877 = new Random();
   private Util10 f_2878;
   private int f_2879;
   private int f_2880;
   private int f_2881;
   private boolean l;
   private static final int f_2882 = Integer.MIN_VALUE;
   private static final int f_2883 = Integer.MIN_VALUE;
   private static final String f_2884 = "FunTime";
   private static final int f_2885 = Integer.MIN_VALUE;
   private static final float f_2886 = -1.0F;
   private static final float f_2887 = 0.06F;
   private static final float f_2888 = 0.22F;
   private static final float f_2889 = 52.0F;
   private static final float f_2890 = 67.0F;
   private static final float f_2891 = 1.2F;
   private static final float f_2892 = 24.0F;
   private static final float f_2893 = 34.0F;
   private static final float f_2894 = 21.0F;
   private static final float f_2895 = 31.0F;
   private static final float f_2896 = 26.0F;
   private static final float f_2897 = 32.0F;
   private static final float f_2898 = 23.0F;
   private static final float f_2899 = 29.0F;
   private static final float f_2900 = 28.0F;
   private static final float f_2901 = 45.0F;
   private static final float f_2902 = 20.0F;
   private static final float f_2903 = 34.0F;
   private static final float f_2904 = 60.0F;
   private static final float f_2905 = 90.0F;
   private static final float f_2906 = 60.0F;
   private static final float f_2907 = 90.0F;
   private static final double f_2908 = -0.05F;
   private static final float f_2909 = 0.3F;
   private static final double f_2910 = 1000.0;
   private static final double f_2911 = 12.75;
   private static final double f_2912 = 3.541666666666667;
   private static final double f_2913 = 1.2;
   private static final double f_2914 = 0.3;
   private static final double f_2915 = 0.03;
   private static final double f_2916 = 1.15;
   private static final double f_2917 = 0.8;
   private static final double f_2918 = 0.25;
   private static final double f_2919 = 0.28;
   private static final int f_2920 = Integer.MIN_VALUE;
   private static final int f_2921 = Integer.MIN_VALUE;

   private Util10 m_4001(LivingEntity var1) {
      Vec3d var2 = f_5909.player.getEyePos();
      double var3 = f_5909.player.distanceTo(var1);
      Vec3d var5 = var2.add(f_5909.player.getRotationVector().multiply(var3));
      Box var6 = var1.getBoundingBox().expand(f_2908);
      Vec3d var7 = MathUtil2.m_4038(var5, var6);
      return Util39.m_3442(var7.subtract(var2));
   }

   private boolean m_2944(AttackAura var1, LivingEntity var2) {
      return AttackAura.m_204(f_5909.player.getYaw(), f_5909.player.getPitch(), var1.m_1837() + f_2909, var2);
   }

   @Override
   public void m_5(AttackAura var1, LivingEntity var2) {
      if (f_5909.player != null && f_5909.world != null && var2 != null) {
         if (var2.getId() != this.f_2880) {
            this.f_2880 = var2.getId();
            this.f_2878 = this.m_1433();
            this.f_2881 = f_2885;
            this.l = false;
         }

         boolean var3 = var1.m_2146();
         if (this.f_2881 != f_5909.player.age || var3 != this.l) {
            this.f_2881 = f_5909.player.age;
            this.l = var3;
            Util10 var4 = this.m_1433();
            Util10 var5 = this.m_4001(var2);
            float var6 = MathHelper.clamp(f_5909.player.getAttackCooldownProgress(1.0F), 0.0F, 1.0F);
            float var7 = 1.0F - var6;
            float var8 = this.f_2879 == 0 ? f_2886 : 1.0F;
            double[] var9 = this.m_271(var3);
            float var10 = var3 ? f_2887 : f_2888;
            float var11 = var3 ? 0.0F : var7;
            float var12 = var5.m_2643()
               + this.m_2164(-var10, var10)
               + MathHelper.lerp(this.m_2164(f_2889, f_2890) * var11 * var8, 0, 1)
               + (float)var9[0] * var7;
            float var13 = var5.m_2573() + this.m_2164(-var10, var10) + MathHelper.lerp(this.m_2164(f_2891, 2.0F) * var11 * var8, 0, 1) + (float)var9[1] * var7;
            this.f_2878 = new Util10(var12, Util10.m_1722(var13));
            boolean var14 = this.m_2944(var1, var2);
            float var15 = Math.abs(MathHelper.wrapDegrees(this.f_2878.m_2643() - var4.m_2643()));
            float var16 = Math.abs(this.f_2878.m_2573() - var4.m_2573());
            float var17;
            float var18;
            if (var3 && !var14) {
               var17 = this.m_2164(f_2892, f_2893);
               var18 = this.m_2164(f_2894, f_2895);
            } else if (!var14) {
               var17 = this.m_2164(f_2896, f_2897);
               var18 = this.m_2164(f_2898, f_2899);
            } else {
               var17 = Math.max(this.m_2164(f_2900, f_2901), var15 + 2.0F);
               var18 = Math.max(this.m_2164(f_2902, f_2903), var16 + 2.0F);
            }

            Util54.m_2145(this.f_2878, var17 / 2.0F, var18 / 2.0F, this.m_2164(f_2904, f_2905), this.m_2164(f_2906, f_2907), 1, 6, false);
         }
      }
   }

   @Override
   public boolean m_13(AttackAura var1, LivingEntity var2) {
      return f_5909.player == null || var2 == null;
   }

   public Util14() {
      this.f_2880 = f_2882;
      this.f_2881 = f_2883;
   }

   @Override
   public void m_11(AttackAura var1) {
      this.m_2186();
   }

   @Override
   public void m_6(AttackAura var1) {
      this.m_2186();
   }

   @Override
   public String m_3() {
      return f_2884;
   }

   private double[] m_271(boolean var1) {
      double var2 = System.currentTimeMillis() / f_2910;
      double var4 = f_2911 * var2 - f_2912 * Math.cos(f_2913 * var2);
      double var6 = f_2914 * var2;
      double var8 = var1 ? f_2915 : f_2916 + Math.sin(f_2917 * var2) * f_2918;
      return new double[]{Math.cos(var4 - var6) * var8, Math.sin(var4 + var6) * var8 * f_2919};
   }

   private Util10 m_1433() {
      return new Util10(MathHelper.wrapDegrees(f_5909.player.getYaw()), f_5909.player.getPitch());
   }

   @Override
   public void m_8(AttackAura var1) {
      this.m_2186();
   }

   private void m_2186() {
      this.f_2878 = f_5909.player == null ? null : this.m_1433();
      this.f_2879 = 0;
      this.f_2880 = f_2920;
      this.f_2881 = f_2921;
      this.l = false;
   }

   private float m_2164(float var1, float var2) {
      return var1 + this.f_2877.nextFloat() * (var2 - var1);
   }

   @Override
   public void m_12(AttackAura var1, LivingEntity var2) {
      this.f_2879 = (this.f_2879 + 1) % 2;
   }
}
