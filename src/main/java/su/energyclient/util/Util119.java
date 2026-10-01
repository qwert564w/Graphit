package su.energyclient.util;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;
import su.energyclient.module.combat.AttackAura;

public class Util119 implements Util148, QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final int f_12764 = 6;
   private static final float f_12765 = 0.0F;
   private static final float f_12766 = 0.0F;
   private static final float f_12767 = 0.0F;
   private int f_12768;
   private int f_12769;
   private int f_12770;
   private int f_12771;
   private int f_12772;
   private int f_12773;
   private int f_12774;
   private int f_12775;
   private int f_12776;
   private int f_12777;
   private int f_12778;
   private int f_12779;
   private int f_12780;
   private int f_12781;
   private int f_12782;
   private float f_12783;
   private float f_12784;
   private float f_12785;
   private float f_12786;
   private boolean f_12787;
   private boolean f_12788;
   private float f_12789;
   private float f_12790;
   private float f_12791;
   private float f_12792;
   private float f_12793;
   private float f_12794;
   private float f_12795;
   private double f_12796;
   private double f_12797;
   private double f_12798;
   private boolean f_12799;
   private float f_12800;
   private float f_12801;
   private float f_12802;
   private float f_12803;
   private float f_12804;
   private float f_12805;
   private float f_12806;
   private float f_12807;
   private boolean f_12808;
   private float f_12809;
   private float f_12810;
   private float f_12811;
   private float f_12812;
   private float f_12813;
   private float f_12814;
   private float f_12815;
   private float f_12816;
   private float f_12817;
   private float f_12818;
   private float f_12819;
   private float f_12820;
   private float f_12821;
   private float f_12822;
   private float f_12823;
   private float f_12824;
   private float f_12825;
   private float f_12826;
   private float f_12827;
   private float f_12828;
   private float f_12829;
   private float f_12830;
   private float f_12831;
   private float f_12832;
   private float f_12833;
   private float f_12834;
   private float f_12835;
   private float f_12836;
   private float f_12837;
   private float f_12838;
   private float f_12839;
   private float f_12840;
   private float f_12841;
   private float f_12842;
   private float f_12843;
   private float f_12844;
   private float f_12845;
   private float f_12846;
   private float f_12847;
   private float f_12848;
   private float f_12849;
   private static final int f_12850 = Integer.MIN_VALUE;
   private static final int f_12851 = Integer.MIN_VALUE;
   private static final float f_12852 = 0.5F;
   private static final float f_12853 = 0.5F;
   private static final String f_12854 = "Spooky";
   private static final double f_12855 = 1.0E-7;
   private static final float f_12856 = -89.0F;
   private static final float f_12857 = 89.0F;
   private static final float f_12858 = -18.0F;
   private static final float f_12859 = 18.0F;
   private static final float f_12860 = -12.0F;
   private static final float f_12861 = 12.0F;
   private static final float f_12862 = 0.18F;
   private static final float f_12863 = 0.42F;
   private static final float f_12864 = -89.0F;
   private static final float f_12865 = 89.0F;
   private static final float f_12866 = 1.12F;
   private static final float f_12867 = 1.08F;
   private static final float f_12868 = 12.0F;
   private static final float f_12869 = 48.0F;
   private static final float f_12870 = 1.08F;
   private static final float f_12871 = 8.0F;
   private static final float f_12872 = 42.0F;
   private static final float f_12873 = 20.0F;
   private static final float f_12874 = 20.0F;
   private static final float f_12875 = 1.04F;
   private static final float f_12876 = 1.22F;
   private static final float f_12877 = 1.28F;
   private static final float f_12878 = 0.72F;
   private static final float f_12879 = 1.22F;
   private static final float f_12880 = 0.92F;
   private static final float f_12881 = 0.88F;
   private static final double f_12882 = 0.35;
   private static final float f_12883 = 0.12F;
   private static final float f_12884 = 0.34F;
   private static final float f_12885 = 0.1F;
   private static final float f_12886 = 0.3F;
   private static final int f_12887 = Integer.MIN_VALUE;
   private static final float f_12888 = 0.12F;
   private static final float f_12889 = 0.34F;
   private static final float f_12890 = 0.1F;
   private static final float f_12891 = 0.28F;
   private static final float f_12892 = 0.16F;
   private static final float f_12893 = 0.4F;
   private static final float f_12894 = 0.68F;
   private static final float f_12895 = 0.16F;
   private static final float f_12896 = 0.14F;
   private static final float f_12897 = 0.31F;
   private static final float f_12898 = 0.18F;
   private static final float f_12899 = 0.38F;
   private static final float f_12900 = 0.48F;
   private static final float f_12901 = 0.74F;
   private static final float f_12902 = 0.86F;
   private static final float f_12903 = 1.14F;
   private static final float f_12904 = 0.18F;
   private static final float f_12905 = 0.34F;
   private static final float f_12906 = 0.84F;
   private static final float f_12907 = 1.2F;
   private static final float f_12908 = 0.78F;
   private static final float f_12909 = 1.18F;
   private static final float f_12910 = 0.3F;
   private static final float f_12911 = 0.64F;
   private static final float f_12912 = 0.3F;
   private static final float f_12913 = 1.15F;
   private static final float f_12914 = 23.0F;
   private static final float f_12915 = 36.0F;
   private static final float f_12916 = 0.45F;
   private static final float f_12917 = 0.68F;
   private static final float f_12918 = 3.6F;
   private static final float f_12919 = 7.8F;
   private static final float f_12920 = 2.2F;
   private static final float f_12921 = 5.4F;
   private static final float f_12922 = 5.2F;
   private static final float f_12923 = 10.5F;
   private static final float f_12924 = 4.0F;
   private static final float f_12925 = 8.2F;
   private static final float f_12926 = 0.68F;
   private static final float f_12927 = 0.88F;
   private static final float f_12928 = 0.92F;
   private static final float f_12929 = 1.34F;
   private static final float f_12930 = 0.18F;
   private static final float f_12931 = 0.72F;
   private static final float f_12932 = 0.07F;
   private static final float f_12933 = 0.12F;
   private static final float f_12934 = 0.3F;
   private static final float f_12935 = 0.9F;
   private static final float f_12936 = 0.25F;
   private static final float f_12937 = 0.78F;
   private static final float f_12938 = 0.16F;
   private static final float f_12939 = 0.82F;
   private static final float f_12940 = 1.18F;
   private static final float f_12941 = 0.18F;
   private static final float f_12942 = 0.34F;
   private static final float f_12943 = 0.13F;
   private static final float f_12944 = 0.24F;
   private static final float f_12945 = -0.28F;
   private static final float f_12946 = 0.28F;
   private static final float f_12947 = -0.28F;
   private static final float f_12948 = 0.28F;
   private static final float f_12949 = 0.09F;
   private static final float f_12950 = 0.18F;
   private static final float f_12951 = 0.32F;
   private static final float f_12952 = 0.76F;
   private static final float f_12953 = 0.24F;
   private static final float f_12954 = 0.12F;
   private static final float f_12955 = 0.42F;
   private static final float f_12956 = 0.3F;
   private static final double f_12957 = 1.0E-4;
   private static final double f_12958 = 1.0E-4;
   private static final double f_12959 = 1.0E-4;
   private static final double f_12960 = -0.65;
   private static final double f_12961 = 0.65;
   private static final double f_12962 = -0.5;
   private static final double f_12963 = 0.5;
   private static final double f_12964 = -0.65;
   private static final double f_12965 = 0.65;
   private static final double f_12966 = 0.62;
   private static final double f_12967 = 0.35;
   private static final double f_12968 = 0.08;
   private static final double f_12969 = 0.08;
   private static final double f_12970 = 0.2;
   private static final double f_12971 = 0.12;
   private static final double f_12972 = 0.08;
   private static final double f_12973 = 0.08;
   private static final float f_12974 = 0.62F;
   private static final double f_12975 = 0.04;
   private static final double f_12976 = 0.04;
   private static final double f_12977 = 0.16;
   private static final double f_12978 = 0.08;
   private static final double f_12979 = 0.04;
   private static final double f_12980 = 0.04;
   private static final float f_12981 = 0.34F;
   private static final float f_12982 = 180.0F;
   private static final float f_12983 = 0.34F;
   private static final float f_12984 = 0.82F;
   private static final float f_12985 = 9.0F;
   private static final float f_12986 = 18.0F;
   private static final float f_12987 = 0.35F;
   private static final float f_12988 = 4.2F;
   private static final float f_12989 = 0.55F;
   private static final float f_12990 = 0.035F;
   private static final float f_12991 = 0.075F;
   private static final float f_12992 = 5.0F;
   private static final float f_12993 = 12.0F;
   private static final float f_12994 = 0.62F;
   private static final float f_12995 = 0.16F;
   private static final float f_12996 = 2.1F;
   private static final float f_12997 = 0.25F;
   private static final float f_12998 = 0.025F;
   private static final float f_12999 = 0.06F;
   private static final float f_13000 = 0.48F;
   private static final float f_13001 = 0.74F;
   private static final float f_13002 = 0.05F;
   private static final float f_13003 = 2.25F;
   private static final float f_13004 = 8.0F;
   private static final float f_13005 = 0.55F;
   private static final float f_13006 = 1.15F;
   private static final float f_13007 = 7.5F;
   private static final float f_13008 = 0.15F;
   private static final float f_13009 = 0.055F;
   private static final float f_13010 = 0.11F;
   private static final float f_13011 = -1.0F;
   private static final float f_13012 = 0.58F;
   private static final float f_13013 = 0.92F;
   private static final float f_13014 = 1.0E-4F;
   private static final float f_13015 = 0.32F;
   private static final float f_13016 = 0.24F;
   private static final float f_13017 = 3.4F;
   private static final float f_13018 = 24.0F;
   private static final float f_13019 = -0.45F;
   private static final float f_13020 = 1.25F;
   private static final float f_13021 = 4.0F;
   private static final float f_13022 = 10.0F;
   private static final float f_13023 = 1.12F;
   private static final float f_13024 = 1.08F;
   private static final float f_13025 = 16.0F;
   private static final float f_13026 = 0.65F;
   private static final float f_13027 = 5.0F;
   private static final float f_13028 = 10.0F;
   private static final float f_13029 = 0.34F;
   private static final float f_13030 = 0.18F;
   private static final float f_13031 = 1.8F;
   private static final float f_13032 = 0.13F;
   private static final float f_13033 = 0.08F;
   private static final float f_13034 = 0.9F;
   private static final float f_13035 = 0.1F;
   private static final float f_13036 = 0.52F;
   private static final float f_13037 = 0.78F;
   private static final float f_13038 = 1.4F;
   private static final float f_13039 = 1.4F;
   private static final float f_13040 = 1.4F;
   private static final float f_13041 = 0.48F;
   private static final float f_13042 = 0.015F;
   private static final float f_13043 = 0.012F;
   private static final float f_13044 = 45.0F;
   private static final float f_13045 = 0.08F;
   private static final float f_13046 = 0.82F;
   private static final float f_13047 = 1.28F;
   private static final float f_13048 = 0.42F;
   private static final float f_13049 = 0.38F;
   private static final float f_13050 = 0.32F;
   private static final float f_13051 = 0.36F;
   private static final float f_13052 = 0.62F;
   private static final float f_13053 = 0.18F;
   private static final float f_13054 = 0.42F;
   private static final float f_13055 = 0.86F;
   private static final float f_13056 = 3.0F;
   private static final float f_13057 = 48.0F;
   private static final float f_13058 = 0.34F;
   private static final float f_13059 = 0.12F;
   private static final float f_13060 = 0.46F;
   private static final float f_13061 = 0.001F;
   private static final float f_13062 = 0.28F;
   private static final float f_13063 = 0.35F;
   private static final float f_13064 = 0.01F;
   private static final float f_13065 = 0.001F;
   private static final float f_13066 = -48.0F;
   private static final float f_13067 = 48.0F;
   private static final float f_13068 = -42.0F;
   private static final float f_13069 = 42.0F;
   private static final float f_13070 = -89.0F;
   private static final float f_13071 = 89.0F;
   private static final float f_13072 = 0.45F;
   private static final float f_13073 = 0.4F;
   private static final float f_13074 = 360.0F;
   private static final float f_13075 = 360.0F;
   private static final int f_13076 = Integer.MIN_VALUE;
   private static final int f_13077 = Integer.MIN_VALUE;
   private static final float f_13078 = 0.68F;
   private static final float f_13079 = 0.94F;

   private void m_1792() {
      this.f_12768 = f_13076;
      this.f_12769 = f_13077;
      this.f_12770 = 0;
      this.f_12771 = 0;
      this.f_12772 = 0;
      this.f_12773 = 0;
      this.f_12774 = 0;
      this.f_12775 = 0;
      this.f_12776 = 0;
      this.f_12777 = 0;
      this.f_12778 = 0;
      this.f_12779 = 0;
      this.f_12780 = 0;
      this.f_12781 = 0;
      this.f_12782 = 0;
      this.f_12783 = this.f_12784 = 0.0F;
      this.f_12785 = this.f_12786 = 0.0F;
      this.f_12787 = false;
      this.f_12788 = false;
      this.f_12808 = false;
      this.f_12789 = this.f_12790 = this.f_12791 = 0.0F;
      this.f_12792 = this.f_12793 = this.f_12794 = 0.0F;
      this.f_12796 = this.f_12797 = this.f_12798 = 0.0;
      this.f_12799 = false;
      this.f_12800 = this.f_12801 = 0.0F;
      this.f_12802 = this.f_12803 = 0.0F;
      this.f_12805 = this.f_12806 = 0.0F;
      this.f_12809 = 1.0F;
      this.f_12810 = 1.0F;
      this.f_12811 = this.f_12812 = 0.0F;
      this.f_12813 = this.f_12814 = 0.0F;
      this.f_12815 = this.f_12816 = 0.0F;
      this.f_12844 = this.f_12845 = 1.0F;
      this.f_12846 = 0.0F;
      this.f_12847 = 1.0F;
   }

   private void m_1384(float var1, float var2, float var3, float var4) {
      float var5 = Float.isFinite(var3) ? MathHelper.clamp(var3, f_13066, f_13067) : 0.0F;
      float var6 = Float.isFinite(var4) ? MathHelper.clamp(var4, f_13068, f_13069) : 0.0F;
      float var7 = var1 + var5;
      float var8 = MathHelper.clamp(var2 + var6, f_13070, f_13071);
      Util10 var9 = new Util10(var7, var8);
      float var10 = Math.max(Math.abs(var5) + this.f_12848, f_13072);
      float var11 = Math.max(Math.abs(var6) + this.f_12849, f_13073);
      Util54.m_2145(var9, var10, var11, f_13074, f_13075, 1, 6, false);
      Util54 var12 = Util54.m_1085();
      if (var12.m_340() == var9 && var12.m_813() == Util54.qN3BdDWeCOfQ39UG.AIM && var12.m_2266() == 6 && f_5909.player != null) {
         this.f_12783 = MathHelper.wrapDegrees(f_5909.player.getYaw() - var1);
         this.f_12784 = f_5909.player.getPitch() - var2;
      }
   }

   private void m_1266(float var1, float var2, float var3, float var4, boolean var5, boolean var6) {
      float var7 = Math.abs(MathHelper.wrapDegrees(var1 - var3));
      float var8 = Math.abs(var2 - var4);
      float var9 = MathHelper.sqrt(var7 * var7 + var8 * var8);
      if (--this.f_12774 <= 0) {
         float var10 = MathHelper.lerp(MathHelper.clamp(var9 / f_13044, 0.0F, 1.0F), f_13045, f_13046);
         var10 *= f_13047 - this.f_12819 * f_13048;
         if (var5) {
            var10 *= f_13049;
         }

         if (var6) {
            var10 *= f_13050;
         }

         this.f_12802 = m_1806(var10);
         this.f_12803 = m_1806(var10 * m_1785(f_13051, f_13052));
         this.f_12804 = m_1785(f_13053, f_13054);
         this.f_12774 = m_858(2, var5 ? 5 : 7);
      }

      this.f_12800 = MathHelper.lerp(this.f_12804, this.f_12800, this.f_12802);
      this.f_12801 = MathHelper.lerp(this.f_12804 * f_13055, this.f_12801, this.f_12803);
   }

   @Override
   public void m_11(AttackAura var1) {
      this.m_1792();
   }

   private static float m_1806(float var0) {
      ThreadLocalRandom var1 = ThreadLocalRandom.current();
      return (var1.nextFloat() + var1.nextFloat() - 1.0F) * var0;
   }

   @Override
   public void m_12(AttackAura var1, LivingEntity var2) {
      this.f_12780 = m_858(1, 3);
      this.f_12773 = Math.max(this.f_12773, this.f_12780 + m_858(2, 5));
      this.f_12802 = this.f_12802 * m_1785(f_12883, f_12884);
      this.f_12803 = this.f_12803 * m_1785(f_12885, f_12886);
      this.f_12777 = 0;
      this.f_12781 = 0;
      this.f_12782 = m_1462();
   }

   private float m_146(float var1, float var2, float var3, float var4) {
      boolean var5 = Math.signum(var1) != 0.0F && Math.signum(var2) != 0.0F && Math.signum(var1) != Math.signum(var2);
      boolean var6 = Math.abs(var2) < Math.abs(var1);
      float var7 = !var5 && !var6 ? var3 : var4;
      return m_1036(var1, var2, Math.max(f_13064, var7));
   }

   private void m_3440(float var1, float var2, float var3, float var4, boolean var5) {
      float var6 = Math.abs(MathHelper.wrapDegrees(var1 - var3));
      float var7 = Math.abs(var2 - var4);
      boolean var8 = var6 <= Math.max(2.0F, Math.abs(this.f_12805) * f_13038) && var7 <= Math.max(f_13039, Math.abs(this.f_12806) * f_13040);
      if (this.f_12778 <= 0 || var5 && var8) {
         float var9 = var5 && var8 ? Math.min(this.f_12807, f_13041) : this.f_12807;
         this.f_12805 *= var9;
         this.f_12806 *= var9;
         if (Math.abs(this.f_12805) < f_13042) {
            this.f_12805 = 0.0F;
         }

         if (Math.abs(this.f_12806) < f_13043) {
            this.f_12806 = 0.0F;
         }
      } else {
         if (var8) {
            this.f_12778--;
         }
      }
   }

   @Override
   public void m_8(AttackAura var1) {
      this.m_1792();
   }

   private float m_3807(float var1, float var2, float var3, float var4, float var5) {
      float var6 = Math.abs(var1);
      if (var6 < f_13061) {
         return 0.0F;
      } else {
         float var7 = f_13062 + (float)Math.pow(var6, this.f_12837) * var5;
         float var8 = (float)Math.sqrt(Math.max(0.0F, 2.0F * var4 * var6));
         float var9 = Math.min(var3, Math.min(var7, var8 + Math.abs(var2) * f_13063));
         float var10 = var2 * this.f_12841;
         return MathHelper.clamp(Math.copySign(var9, var1) + var10, -var3, var3);
      }
   }

   private void m_110(boolean var1) {
      if (--this.f_12772 <= 0) {
         this.m_3643(false);
      }

      float var2 = var1 ? Math.max(this.f_12843, f_12938) : this.f_12843;
      this.f_12817 = MathHelper.lerp(var2, this.f_12817, this.f_12818);
      this.f_12819 = MathHelper.lerp(var2, this.f_12819, this.f_12820);
      this.f_12821 = MathHelper.lerp(var2, this.f_12821, this.f_12822);
      this.f_12823 = MathHelper.lerp(var2, this.f_12823, this.f_12824);
      this.f_12825 = MathHelper.lerp(var2, this.f_12825, this.f_12826);
      this.f_12827 = MathHelper.lerp(var2, this.f_12827, this.f_12828);
      this.f_12829 = MathHelper.lerp(var2, this.f_12829, this.f_12830);
      this.f_12831 = MathHelper.lerp(var2, this.f_12831, this.f_12832);
      this.f_12833 = MathHelper.lerp(var2, this.f_12833, this.f_12834);
      this.f_12835 = MathHelper.lerp(var2, this.f_12835, this.f_12836);
      this.f_12837 = MathHelper.lerp(var2, this.f_12837, this.f_12838);
      this.f_12839 = MathHelper.lerp(var2, this.f_12839, this.f_12840);
      this.f_12841 = MathHelper.lerp(var2, this.f_12841, this.f_12842);
      if (--this.f_12775 <= 0) {
         this.f_12845 = m_1785(f_12939, f_12940);
         this.f_12846 = m_1785(f_12941, f_12942);
         this.f_12775 = m_858(2, 6);
      }

      this.f_12844 = MathHelper.lerp(this.f_12846, this.f_12844, this.f_12845);
      if (this.f_12780 > 0) {
         this.f_12780--;
      }
   }

   @Override
   public void m_35(AttackAura var1, LivingEntity var2) {
      if (f_5909.player != null && f_5909.world != null && var2 != null) {
         Util54 var3 = Util54.m_1085();
         if (var3.m_2266() > 6) {
            this.m_1792();
         } else if (f_5909.player.age != this.f_12768) {
            this.f_12768 = f_5909.player.age;
            float var4 = f_5909.player.getYaw();
            float var5 = f_5909.player.getPitch();
            if (var2.getId() != this.f_12769) {
               this.m_395(var2, var4, var5);
            } else {
               this.f_12770++;
            }

            boolean var6 = var1.m_2934();
            this.m_110(var6);
            Vec3d var7 = f_5909.player.getCameraPosVec(1.0F);
            Vec3d var8 = this.m_3270(var2, var6);
            Vec3d var9 = var8.subtract(var7);
            if (var9.lengthSquared() < f_12855) {
               this.m_1384(var4, var5, 0.0F, 0.0F);
            } else {
               Util10 var10 = Util39.m_3442(var9);
               float var11 = var10.m_2643();
               float var12 = MathHelper.clamp(var10.m_2573(), f_12856, f_12857);
               if (Float.isFinite(var11) && Float.isFinite(var12)) {
                  float var13 = this.f_12787 ? MathHelper.clamp(MathHelper.wrapDegrees(var11 - this.f_12785), f_12858, f_12859) : 0.0F;
                  float var14 = this.f_12787 ? MathHelper.clamp(var12 - this.f_12786, f_12860, f_12861) : 0.0F;
                  if (!this.f_12787) {
                     this.f_12785 = var11;
                     this.f_12786 = var12;
                     this.f_12787 = true;
                  }

                  if (this.f_12788) {
                     this.m_1379(var11, var12, var4, var5);
                     this.f_12788 = false;
                  } else {
                     this.m_3435(var13, var14);
                  }

                  if (this.f_12808) {
                     this.m_1109(var11, var12, var4, var5);
                     this.f_12808 = false;
                  }

                  boolean var15 = AttackAura.m_204(var4, var5, var1.m_1837() + var1.m_4121().m_4046(), var2);
                  this.m_1266(var11, var12, var4, var5, var6, var15);
                  this.m_3440(var11, var12, var4, var5, var6);
                  this.m_4007(var11, var4, var6);
                  this.f_12785 = var11;
                  this.f_12786 = var12;
                  if (this.f_12771 > 0) {
                     this.f_12771--;
                     this.f_12783 = m_1036(this.f_12783, 0.0F, this.f_12833 * this.f_12844);
                     this.f_12784 = m_1036(this.f_12784, 0.0F, this.f_12835 * this.f_12844);
                     float var30 = this.f_12771 == 0 ? f_12862 : f_12863;
                     this.m_1384(var4, var5, this.f_12783 * var30, this.f_12784 * var30);
                  } else {
                     this.m_2880(var6, var15);
                     float var16 = var11 + this.f_12815 + this.f_12805 + this.f_12800;
                     float var17 = MathHelper.clamp(var12 + this.f_12816 + this.f_12806 + this.f_12801, f_12864, f_12865);
                     float var18 = MathHelper.wrapDegrees(var16 - var4);
                     float var19 = var17 - var5;
                     boolean var20 = m_3106();
                     boolean var21 = var2.getBoundingBox().contains(var7);
                     float var22 = this.f_12825 * (var20 ? f_12866 : 1.0F);
                     if (var21) {
                        var22 *= f_12867;
                     }

                     var22 = MathHelper.clamp(var22, f_12868, f_12869);
                     float var23 = this.f_12827 * (var20 ? f_12870 : 1.0F);
                     var23 = MathHelper.clamp(var23, f_12871, f_12872);
                     float var24 = var6 ? MathHelper.lerp(MathHelper.clamp((f_12873 - Math.abs(var18)) / f_12874, 0.0F, 1.0F), f_12875, f_12876) : 1.0F;
                     float var25 = this.f_12777 > 0 ? this.f_12847 : 1.0F;
                     float var26 = this.m_3807(var18, var13, var22 * var24, this.f_12833, this.f_12839 * this.f_12817 * var25 * (var6 ? f_12877 : 1.0F));
                     float var27 = this.m_3807(
                        var19, var14, var23 * var24, this.f_12835, this.f_12839 * f_12878 * this.f_12817 * var25 * (var6 ? f_12879 : 1.0F)
                     );
                     this.f_12783 = this.m_146(this.f_12783, var26, this.f_12829 * this.f_12844 * var24, this.f_12833 * this.f_12844);
                     this.f_12784 = this.m_146(this.f_12784, var27, this.f_12831 * this.f_12844 * var24, this.f_12835 * this.f_12844);
                     float var28 = this.m_1936(this.f_12783, var18, var22);
                     float var29 = this.m_1936(this.f_12784, var19, var23);
                     if (var15 && var6) {
                        var28 *= f_12880;
                        var29 *= f_12881;
                     }

                     this.m_1384(var4, var5, var28, var29);
                  }
               } else {
                  this.m_1384(var4, var5, 0.0F, 0.0F);
               }
            }
         }
      } else {
         this.m_1792();
      }
   }

   @Override
   public String m_3() {
      return f_12854;
   }

   @Override
   public boolean m_13(AttackAura var1, LivingEntity var2) {
      if (var1.m_3786()) {
         return false;
      } else if (f_5909.player == null || var2 == null || var2.getId() != this.f_12769) {
         this.f_12781 = 0;
         return true;
      } else if (this.f_12771 > 0) {
         this.f_12781 = 0;
         return true;
      } else {
         boolean var3 = AttackAura.m_204(f_5909.player.getYaw(), f_5909.player.getPitch(), var1.m_1837() + f_12882, var2);
         if (!var3) {
            this.f_12781 = 0;
            return true;
         } else {
            this.f_12781++;
            return this.f_12781 <= this.f_12782;
         }
      }
   }

   private static boolean m_3106() {
      if (f_5909.player != null && f_5909.player.input != null) {
         PlayerInput var0 = f_5909.player.input.playerInput;
         return var0.left() || var0.right();
      } else {
         return false;
      }
   }

   @Override
   public void m_5(AttackAura var1, LivingEntity var2) {
   }

   private void m_3643(boolean var1) {
      this.f_12818 = m_1785(f_12906, f_12907);
      this.f_12820 = m_1785(f_12908, f_12909);
      this.f_12822 = m_1785(f_12910, f_12911);
      this.f_12824 = m_1785(f_12912, f_12913);
      this.f_12826 = m_1785(f_12914, f_12915);
      this.f_12828 = this.f_12826 * m_1785(f_12916, f_12917);
      this.f_12830 = m_1785(f_12918, f_12919);
      this.f_12832 = m_1785(f_12920, f_12921);
      this.f_12834 = m_1785(f_12922, f_12923);
      this.f_12836 = m_1785(f_12924, f_12925);
      this.f_12838 = m_1785(f_12926, f_12927);
      this.f_12840 = m_1785(f_12928, f_12929);
      this.f_12842 = m_1785(f_12930, f_12931);
      this.f_12843 = m_1785(f_12932, f_12933);
      this.f_12848 = m_1785(f_12934, f_12935);
      this.f_12849 = m_1785(f_12936, f_12937);
      this.f_12772 = m_858(14, 38);
      if (var1) {
         this.f_12817 = this.f_12818;
         this.f_12819 = this.f_12820;
         this.f_12821 = this.f_12822;
         this.f_12823 = this.f_12824;
         this.f_12825 = this.f_12826;
         this.f_12827 = this.f_12828;
         this.f_12829 = this.f_12830;
         this.f_12831 = this.f_12832;
         this.f_12833 = this.f_12834;
         this.f_12835 = this.f_12836;
         this.f_12837 = this.f_12838;
         this.f_12839 = this.f_12840;
         this.f_12841 = this.f_12842;
      }
   }

   private static float m_1036(float var0, float var1, float var2) {
      return var0 < var1 ? Math.min(var0 + var2, var1) : Math.max(var0 - var2, var1);
   }

   private void m_395(LivingEntity var1, float var2, float var3) {
      boolean var4 = this.f_12769 != f_12887;
      float var5 = var4 ? this.f_12783 * m_1785(f_12888, f_12889) : 0.0F;
      float var6 = var4 ? this.f_12784 * m_1785(f_12890, f_12891) : 0.0F;
      this.f_12769 = var1.getId();
      this.f_12770 = 0;
      this.f_12771 = m_858(var4 ? 1 : 0, 3);
      this.f_12782 = m_1462();
      this.f_12781 = 0;
      this.f_12783 = var5;
      this.f_12784 = var6;
      this.f_12785 = var2;
      this.f_12786 = var3;
      this.f_12787 = false;
      this.f_12788 = true;
      this.f_12808 = true;
      this.f_12789 = this.f_12792 = m_1806(f_12892);
      this.f_12790 = this.f_12793 = m_1785(f_12893, f_12894);
      this.f_12791 = this.f_12794 = m_1806(f_12895);
      this.f_12795 = m_1785(f_12896, f_12897);
      this.f_12773 = m_858(4, 10);
      this.f_12799 = false;
      this.f_12800 = this.f_12801 = 0.0F;
      this.f_12802 = this.f_12803 = 0.0F;
      this.f_12804 = m_1785(f_12898, f_12899);
      this.f_12774 = m_858(2, 6);
      this.f_12805 = this.f_12806 = 0.0F;
      this.f_12778 = 0;
      this.f_12779 = m_858(5, 11);
      this.f_12807 = m_1785(f_12900, f_12901);
      this.f_12809 = 1.0F;
      this.f_12810 = 1.0F;
      this.f_12811 = this.f_12812 = 0.0F;
      this.f_12813 = this.f_12814 = 0.0F;
      this.f_12815 = this.f_12816 = 0.0F;
      this.f_12777 = 0;
      this.f_12776 = m_858(6, 18);
      this.f_12780 = 0;
      this.m_3643(true);
      this.f_12844 = this.f_12845 = m_1785(f_12902, f_12903);
      this.f_12846 = m_1785(f_12904, f_12905);
      this.f_12775 = m_858(2, 6);
   }

   @Override
   public void m_6(AttackAura var1) {
      this.m_1792();
   }

   private float m_1936(float var1, float var2, float var3) {
      if (!(Math.abs(var2) < f_13065) && Math.signum(var1) == Math.signum(var2)) {
         float var4 = Math.min(Math.abs(var1), Math.min(Math.abs(var2), var3));
         return Math.copySign(var4, var2);
      } else {
         return MathHelper.clamp(var1, -var3, var3);
      }
   }

   private static int m_1462() {
      float var0 = ThreadLocalRandom.current().nextFloat();
      if (var0 < f_13078) {
         return 0;
      } else {
         return var0 < f_13079 ? 1 : 2;
      }
   }

   private void m_2880(boolean var1, boolean var2) {
      if (this.f_12809 >= 1.0F) {
         this.f_12815 = this.f_12816 = 0.0F;
      } else {
         float var3 = this.f_12810;
         if (var1) {
            var3 *= f_13023;
         }

         if (var2) {
            var3 *= f_13024;
         }

         this.f_12809 = Math.min(1.0F, this.f_12809 + var3);
         float var4 = this.f_12809;
         float var5 = 1.0F - var4;
         float var6 = f_13025 * var4 * var4 * var5 * var5;
         float var7 = var6 * (2.0F * var4 - 1.0F);
         this.f_12815 = this.f_12811 * var6 + this.f_12813 * var7;
         this.f_12816 = this.f_12812 * var6 + this.f_12814 * var7;
         if (this.f_12809 >= 1.0F) {
            this.f_12815 = this.f_12816 = 0.0F;
         }
      }
   }

   private static int m_858(int var0, int var1) {
      return ThreadLocalRandom.current().nextInt(var0, var1 + 1);
   }

   private void m_4007(float var1, float var2, boolean var3) {
      if (var3) {
         this.f_12777 = 0;
      } else if (this.f_12777 > 0) {
         this.f_12777--;
      } else if (--this.f_12776 <= 0) {
         float var4 = Math.abs(MathHelper.wrapDegrees(var1 - var2));
         if (this.f_12770 > this.f_12771 && var4 > f_13056 && var4 < f_13057 && m_1785(0.0F, 1.0F) < f_13058) {
            this.f_12777 = m_858(1, 2);
            this.f_12847 = m_1785(f_13059, f_13060);
         }

         this.f_12776 = m_858(8, 24);
      }
   }

   private Vec3d m_3270(LivingEntity var1, boolean var2) {
      Box var3 = var1.getBoundingBox();
      if (--this.f_12773 <= 0 && this.f_12780 <= 0) {
         float var4 = var2 ? f_12943 : f_12944;
         this.f_12792 = MathHelper.clamp(this.f_12792 + m_1806(var4), f_12945, f_12946);
         this.f_12794 = MathHelper.clamp(this.f_12794 + m_1806(var4), f_12947, f_12948);
         float var5 = m_1806(var2 ? f_12949 : f_12950);
         this.f_12793 = MathHelper.clamp(this.f_12793 + var5, f_12951, f_12952);
         this.f_12795 = m_1785(var2 ? f_12953 : f_12954, var2 ? f_12955 : f_12956);
         this.f_12773 = m_858(4, var2 ? 8 : 12);
      }

      this.f_12789 = MathHelper.lerp(this.f_12795, this.f_12789, this.f_12792);
      this.f_12790 = MathHelper.lerp(this.f_12795, this.f_12790, this.f_12793);
      this.f_12791 = MathHelper.lerp(this.f_12795, this.f_12791, this.f_12794);
      double var25 = Math.max(var3.getLengthX(), f_12957);
      double var6 = Math.max(var3.getLengthY(), f_12958);
      double var8 = Math.max(var3.getLengthZ(), f_12959);
      double var10 = MathHelper.clamp(var1.getX() - var1.lastX, f_12960, f_12961);
      double var12 = MathHelper.clamp(var1.getY() - var1.lastY, f_12962, f_12963);
      double var14 = MathHelper.clamp(var1.getZ() - var1.lastZ, f_12964, f_12965);
      double var16 = this.f_12823 * (var2 ? f_12966 : 1.0);
      double var10001 = this.f_12789;
      double var18 = var3.getCenter().x + var10001 * var25 + var10 * var16;
      double var20 = var3.minY + this.f_12790 * var6 + var12 * var16 * f_12967;
      var10001 = this.f_12791;
      double var22 = var3.getCenter().z + var10001 * var8 + var14 * var16;
      var18 = MathHelper.clamp(var18, var3.minX + var25 * f_12968, var3.maxX - var25 * f_12969);
      var20 = MathHelper.clamp(var20, var3.minY + var6 * f_12970, var3.maxY - var6 * f_12971);
      var22 = MathHelper.clamp(var22, var3.minZ + var8 * f_12972, var3.maxZ - var8 * f_12973);
      if (!this.f_12799) {
         this.f_12796 = var18;
         this.f_12797 = var20;
         this.f_12798 = var22;
         this.f_12799 = true;
      } else {
         float var24 = var2 ? Math.max(this.f_12821, f_12974) : this.f_12821;
         this.f_12796 = this.f_12796 + (var18 - this.f_12796) * var24;
         this.f_12797 = this.f_12797 + (var20 - this.f_12797) * var24;
         this.f_12798 = this.f_12798 + (var22 - this.f_12798) * var24;
      }

      if (var2) {
         this.f_12796 = MathHelper.clamp(this.f_12796, var3.minX + var25 * f_12975, var3.maxX - var25 * f_12976);
         this.f_12797 = MathHelper.clamp(this.f_12797, var3.minY + var6 * f_12977, var3.maxY - var6 * f_12978);
         this.f_12798 = MathHelper.clamp(this.f_12798, var3.minZ + var8 * f_12979, var3.maxZ - var8 * f_12980);
      }

      return new Vec3d(this.f_12796, this.f_12797, this.f_12798);
   }

   private void m_1379(float var1, float var2, float var3, float var4) {
      float var5 = MathHelper.wrapDegrees(var1 - var3);
      float var6 = var2 - var4;
      float var7 = Math.abs(var5);
      float var8 = Math.abs(var6);
      float var9 = MathHelper.clamp(f_12981 + var7 / f_12982, f_12983, f_12984);
      if (var7 > m_1785(f_12985, f_12986) && m_1785(0.0F, 1.0F) < var9) {
         float var10 = m_1785(f_12987, Math.min(f_12988, f_12989 + var7 * m_1785(f_12990, f_12991)));
         this.f_12805 = Math.copySign(var10, var5);
      }

      if (var8 > m_1785(f_12992, f_12993) && m_1785(0.0F, 1.0F) < var9 * f_12994) {
         float var11 = m_1785(f_12995, Math.min(f_12996, f_12997 + var8 * m_1785(f_12998, f_12999)));
         this.f_12806 = Math.copySign(var11, var6);
      }

      this.f_12778 = m_858(1, 4);
      this.f_12779 = m_858(7, 16);
      this.f_12807 = m_1785(f_13000, f_13001);
   }

   public Util119() {
      this.f_12768 = f_12850;
      this.f_12769 = f_12851;
      this.f_12847 = 1.0F;
      this.f_12848 = f_12852;
      this.f_12849 = f_12853;
   }

   private void m_3435(float var1, float var2) {
      if (this.f_12779 > 0) {
         this.f_12779--;
      } else {
         float var3 = Math.abs(var1) + Math.abs(var2) * f_13026;
         if (!(var3 < m_1785(f_13027, f_13028)) && !(m_1785(0.0F, 1.0F) > f_13029)) {
            this.f_12805 = this.f_12805 + Math.copySign(m_1785(f_13030, Math.min(f_13031, var3 * f_13032)), var1);
            if (Math.abs(var2) > 1.0F) {
               this.f_12806 = this.f_12806 + Math.copySign(m_1785(f_13033, Math.min(f_13034, Math.abs(var2) * f_13035)), var2);
            }

            this.f_12778 = m_858(1, 3);
            this.f_12779 = m_858(8, 18);
            this.f_12807 = m_1785(f_13036, f_13037);
         } else {
            this.f_12779 = m_858(3, 8);
         }
      }
   }

   private void m_1109(float var1, float var2, float var3, float var4) {
      float var5 = MathHelper.wrapDegrees(var1 - var3);
      float var6 = var2 - var4;
      float var7 = MathHelper.sqrt(var5 * var5 + var6 * var6);
      if (var7 < 2.0F) {
         this.f_12809 = 1.0F;
         this.f_12815 = this.f_12816 = 0.0F;
      } else {
         float var8 = Math.max(Util36.m_399(), f_13002);
         float var9 = Math.max(var8 * f_13003, var7 < f_13004 ? f_13005 : f_13006);
         float var10 = Math.min(f_13007, Math.max(var9 + f_13008, var7 * m_1785(f_13009, f_13010)));
         float var11 = m_1785(var9, var10);
         float var12 = ThreadLocalRandom.current().nextBoolean() ? 1.0F : f_13011;
         float var13 = 1.0F / var7;
         float var14 = -var6 * var13;
         float var15 = var5 * var13 * m_1785(f_13012, f_13013);
         float var16 = Math.max(MathHelper.sqrt(var14 * var14 + var15 * var15), f_13014);
         float var17 = var11 / var16;
         this.f_12811 = var14 * var17 * var12;
         this.f_12812 = var15 * var17 * var12;
         this.f_12813 = m_1806(var11 * f_13015);
         this.f_12814 = m_1806(var11 * f_13016);
         float var18 = MathHelper.clamp(f_13017 + var7 / f_13018 + m_1785(f_13019, f_13020), f_13021, f_13022);
         this.f_12810 = 1.0F / var18;
         this.f_12809 = 0.0F;
         this.f_12815 = this.f_12816 = 0.0F;
      }
   }

   private static float m_1785(float var0, float var1) {
      return var0 + (var1 - var0) * ThreadLocalRandom.current().nextFloat();
   }
}
