package su.energyclient.util;

import net.minecraft.block.AirBlock;
import net.minecraft.block.BannerBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SignBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.energyclient.QuickImports;

public class Util141 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final int f_11899;
   private final int f_11900;
   private final Util125 f_11901 = new Util125();
   private final Util165 f_11902;
   private double f_11903;
   private double f_11904;
   private double f_11905;
   private double f_11906;
   private double f_11907;
   private double f_11908;
   private float f_11909;
   private float f_11910;
   private boolean f_11911;
   private long f_11912;
   private double f_11913;
   private double f_11914;
   private double f_11915;
   private double f_11916;
   private double f_11917;
   private double f_11918;
   private double f_11919;
   private double f_11920;
   private double f_11921;
   private double f_11922;
   private double f_11923;
   private double f_11924;
   private double f_11925;
   private double O;
   private double f_11926;
   private double f_11927;
   private float f_11928;
   private float f_11929;
   private static final double f_11930 = 1.5E-4;
   private static final double f_11931 = 0.0;
   private static final double f_11932 = 0.0;
   private static final double f_11933 = 0.0;
   private static final long f_11934 = 500L;
   private static final double f_11935 = 0.5;
   private static final double f_11936 = 0.02;
   private static final double f_11937 = 0.02;
   private static final double f_11938 = 0.5;
   private static final double f_11939 = 0.02;
   private static final long f_11940 = 500L;
   private static final double f_11941 = 2.0;
   private static final double f_11942 = Math.PI;
   private static final double f_11943 = 2.0;
   private static final double f_11944 = 0.02;
   private static final double f_11945 = 0.03;
   private static final double f_11946 = 0.02;
   private static final double f_11947 = 0.3;
   private static final double f_11948 = 0.001;
   private static final double f_11949 = Math.PI;
   private static final double f_11950 = 2.0;
   private static final double f_11951 = 0.55;
   private static final double f_11952 = 0.45;
   private static final double f_11953 = 0.82;
   private static final double f_11954 = -1.0;
   private static final double f_11955 = 0.22;
   private static final double f_11956 = 0.3;
   private static final double f_11957 = 0.55;
   private static final double f_11958 = 0.6;
   private static final double f_11959 = 0.85;
   private static final double f_11960 = 0.3;
   private static final double f_11961 = 0.4;
   private static final double f_11962 = 0.015;
   private static final double f_11963 = 0.03;
   private static final double f_11964 = 0.5;
   private static final double f_11965 = 0.7;
   private static final double f_11966 = Math.PI;
   private static final double f_11967 = 2.0;
   private static final double f_11968 = 0.03;
   private static final double f_11969 = 0.04;
   private static final double f_11970 = 0.3;
   private static final double f_11971 = 0.4;
   private static final double f_11972 = 1.4;
   private static final double f_11973 = 1.2;
   private static final double f_11974 = 0.75;
   private static final double f_11975 = 0.35;
   private static final double f_11976 = Math.PI;
   private static final double f_11977 = 2.0;
   private static final double f_11978 = 1.2;
   private static final float f_11979 = 0.55F;
   private static final float f_11980 = 0.85F;
   private static final double f_11981 = 0.5;
   private static final float f_11982 = 50.0F;
   private static final double f_11983 = 360.0;
   private static final double f_11984 = 0.5;
   private static final float f_11985 = 8.0F;
   private static final double f_11986 = -0.6;
   private static final float f_11987 = -0.6F;
   private static final double f_11988 = 0.7;
   private static final double f_11989 = 0.7;
   private static final double f_11990 = -0.6;
   private static final float f_11991 = 0.7F;
   private static final double f_11992 = 1.0E-4;
   private static final double f_11993 = -0.6;
   private static final float f_11994 = -0.6F;
   private static final double f_11995 = 2.399;
   private static final double f_11996 = 0.62;
   private static final double f_11997 = 2.618;
   private static final double f_11998 = 1.7;
   private static final double f_11999 = 0.38;
   private static final double f_12000 = 1.0E9;
   private static final double f_12001 = 0.05;
   private static final double f_12002 = 0.07;
   private static final double f_12003 = 0.5;
   private static final double f_12004 = 0.5;
   private static final double f_12005 = 2.0;
   private static final double f_12006 = 0.8;
   private static final double f_12007 = 6.0;
   private static final double f_12008 = 0.8;
   private static final double f_12009 = -0.2;
   private static final double f_12010 = -0.2;
   private static final double f_12011 = -0.2;
   private static final double f_12012 = 0.1;
   private static final double f_12013 = 2.0;
   private static final double f_12014 = 0.5;
   private static final double f_12015 = 1.6;
   private static final double f_12016 = 0.9;
   private static final double f_12017 = 0.6;
   private static final double f_12018 = 2.7;
   private static final double f_12019 = 2.1;
   private static final double f_12020 = 0.4;
   private static final float f_12021 = 0.55F;
   private static final float f_12022 = 0.45F;
   private static final double f_12023 = 0.5;
   private static final double f_12024 = 1.5E-4;
   private static final float f_12025 = 0.995F;

   public float m_2787() {
      return this.f_11909;
   }

   public double m_4118() {
      return this.f_11906;
   }

   public Util141(Vec3d var1, Vec3d var2, int var3, int var4) {
      this.f_11902 = new Util165(Util153.LINEAR, f_11940);
      this.f_11929 = 1.0F;
      this.f_11903 = var1.x;
      this.f_11904 = var1.y;
      this.f_11905 = var1.z;
      this.f_11906 = var2.x;
      this.f_11907 = var2.y;
      this.f_11908 = var2.z;
      this.f_11899 = var3;
      this.f_11900 = var4;
      this.m_1015();
      this.f_11901.m_3493();
   }

   public Util165 m_3687() {
      return this.f_11902;
   }

   public double m_231() {
      return this.f_11922;
   }

   public float m_567() {
      return this.f_11910;
   }

   public double m_2363() {
      return this.f_11904;
   }

   public Util125 m_2301() {
      return this.f_11901;
   }

   public double m_2804() {
      return this.f_11920;
   }

   public double m_976() {
      return this.O;
   }

   public double m_2177() {
      return this.f_11923;
   }

   public Util141(Vec3d var1, int var2, int var3) {
      this.f_11902 = new Util165(Util153.LINEAR, f_11934);
      this.f_11929 = 1.0F;
      this.f_11903 = var1.x;
      this.f_11904 = var1.y;
      this.f_11905 = var1.z;
      this.f_11900 = var3;
      this.f_11906 = (Math.random() - f_11935) * f_11936;
      this.f_11907 = Math.random() * f_11937;
      this.f_11908 = (Math.random() - f_11938) * f_11939;
      this.f_11899 = var2;
      this.m_1015();
      this.f_11901.m_3493();
   }

   public double m_3376() {
      return this.f_11925;
   }

   public double m_1176() {
      return this.f_11908;
   }

   private boolean m_1319(Block var1) {
      if (var1 instanceof AirBlock) {
         return false;
      } else if (var1 instanceof PlantBlock) {
         return false;
      } else if (var1 instanceof ButtonBlock) {
         return false;
      } else if (var1 instanceof TorchBlock) {
         return false;
      } else if (var1 instanceof LeverBlock) {
         return false;
      } else if (var1 instanceof PressurePlateBlock) {
         return false;
      } else if (var1 instanceof CarpetBlock) {
         return false;
      } else if (var1 instanceof FluidBlock) {
         return false;
      } else {
         return var1 instanceof SignBlock ? false : !(var1 instanceof BannerBlock);
      }
   }

   public boolean m_2604() {
      return this.f_11911;
   }

   public void m_2516() {
      if (this.f_11911) {
         this.m_3141();
      } else {
         Block var1 = this.m_3928(this.f_11903, this.f_11904, this.f_11905 + this.f_11908);
         if (this.m_1319(var1)) {
            this.f_11908 = this.f_11908 * f_11986;
            this.f_11910 = this.f_11910 * f_11987;
         }

         Block var2 = this.m_3928(this.f_11903, this.f_11904 + this.f_11907, this.f_11905);
         if (this.m_1319(var2)) {
            this.f_11906 = this.f_11906 * f_11988;
            this.f_11908 = this.f_11908 * f_11989;
            this.f_11907 = this.f_11907 * f_11990;
            this.f_11910 = this.f_11910 * f_11991;
            if (Math.abs(this.f_11907) < f_11992) {
               this.f_11907 = 0.0;
            }
         }

         Block var3 = this.m_3928(this.f_11903 + this.f_11906, this.f_11904, this.f_11905);
         if (this.m_1319(var3)) {
            this.f_11906 = this.f_11906 * f_11993;
            this.f_11910 = this.f_11910 * f_11994;
         }

         this.m_3017();
      }
   }

   public double m_1268() {
      return this.f_11916;
   }

   public double m_3902() {
      return this.f_11926;
   }

   public double m_3691() {
      return this.f_11919;
   }

   public int m_1763() {
      return this.f_11899;
   }

   public Vec3d m_140() {
      return new Vec3d(this.f_11903, this.f_11904, this.f_11905);
   }

   public float m_597() {
      if (!this.f_11911) {
         return 1.0F;
      } else {
         double var1 = Math.sin(this.f_11914 * f_12015 + this.f_11899 * f_12016) * f_12017
            + Math.sin(this.f_11914 * f_12018 + this.f_11899 * f_12019) * f_12020;
         return f_12021 + f_12022 * (float)((var1 + 1.0) * f_12023);
      }
   }

   public double m_1738() {
      return this.f_11915;
   }

   public double m_4131() {
      return this.f_11913;
   }

   private void m_1015() {
      this.f_11909 = (float)(Math.random() * f_11983);
      this.f_11910 = (float)(Math.random() - f_11984) * f_11985;
   }

   public double m_1622() {
      return this.f_11903;
   }

   public boolean m_304(long var1) {
      return this.f_11901.m_2884(var1);
   }

   public double m_360() {
      return this.f_11917;
   }

   public static Util141 m_2532(Vec3d var0, int var1, int var2, double var3) {
      Util141 var5 = new Util141(var0, Vec3d.ZERO, var1, var2);
      var5.f_11911 = true;
      var5.f_11926 = var3;
      double var6 = 0.0;
      double var8 = 0.0;
      double var10 = 0.0;
      if (f_5909.player != null) {
         var6 = var0.x - f_5909.player.getX();
         var8 = var0.y - f_5909.player.getEyeY();
         var10 = var0.z - f_5909.player.getZ();
      }

      double var12 = Math.sqrt(var6 * var6 + var10 * var10);
      var5.f_11916 = Math.min(var3, Math.max(var3 * f_11947, var12));
      var5.f_11917 = var12 > f_11948 ? Math.atan2(var10, var6) : Math.random() * f_11949 * f_11950;
      var5.f_11927 = Math.min(var3 * f_11951, Math.max(-var3 * f_11952, var8));
      double var14 = Math.random() < f_11953 ? 1.0 : f_11954;
      double var16 = (f_11955 + Math.random() * f_11956) * Math.pow(var3 * f_11957 / var5.f_11916, f_11958);
      var5.f_11918 = var14 * Math.min(f_11959, var16);
      var5.f_11919 = f_11960 + Math.random() * f_11961;
      var5.f_11920 = var3 * (f_11962 + Math.random() * f_11963);
      var5.f_11921 = f_11964 + Math.random() * f_11965;
      var5.f_11922 = Math.random() * f_11966 * f_11967;
      var5.f_11923 = var3 * (f_11968 + Math.random() * f_11969);
      var5.f_11924 = f_11970 + Math.random() * f_11971;
      var5.f_11925 = f_11972 + Math.random() * f_11973;
      var5.O = f_11974 + Math.random() * f_11975;
      var5.f_11914 = Math.random() * f_11976 * f_11977;
      var5.f_11915 = 1.0 + Math.random() * f_11978;
      var5.f_11928 = f_11979 + (float)Math.random() * f_11980;
      var5.f_11929 = var5.f_11928;
      var5.f_11910 = (float)(Math.random() - f_11981) * f_11982;
      double var18 = var5.f_11918 * var5.f_11916;
      var5.f_11906 = -Math.sin(var5.f_11917) * var18;
      var5.f_11907 = 0.0;
      var5.f_11908 = Math.cos(var5.f_11917) * var18;
      return var5;
   }

   public void m_761(double var1, double var3, double var5) {
      this.f_11903 = var1;
      this.f_11904 = var3;
      this.f_11905 = var5;
   }

   public double m_2978() {
      return this.f_11921;
   }

   public static Util141 m_1301(Vec3d var0, int var1, int var2) {
      double var3 = Math.random() * f_11941 * f_11942;
      double var5 = Math.acos(f_11943 * Math.random() - 1.0);
      double var7 = f_11944 + Math.random() * f_11945;
      double var9 = var7 * Math.sin(var5) * Math.cos(var3);
      double var11 = var7 * Math.cos(var5) + f_11946;
      double var13 = var7 * Math.sin(var5) * Math.sin(var3);
      return new Util141(var0, new Vec3d(var9, var11, var13), var1, var2);
   }

   public long m_3748() {
      return this.f_11912;
   }

   public float O() {
      return this.f_11928;
   }

   public double m_247() {
      return this.f_11924;
   }

   private void m_3141() {
      long var1 = System.nanoTime();
      double var3 = this.f_11912 == 0L ? 0.0 : Math.min((var1 - this.f_11912) / f_12000, f_12001);
      this.f_11912 = var1;
      if (!(var3 <= 0.0)) {
         this.f_11913 += var3;
         this.f_11914 = this.f_11914 + this.f_11915 * var3;
         this.f_11917 = this.f_11917 + this.f_11918 * var3;
         double var5;
         double var7;
         double var9;
         if (f_5909.player != null) {
            double var11 = this.f_11916 * (1.0 + f_12002 * Math.sin(this.f_11913 * this.f_11919 + this.f_11922));
            var5 = f_5909.player.getX() + Math.cos(this.f_11917) * var11 + this.m_377(0);
            var9 = f_5909.player.getZ() + Math.sin(this.f_11917) * var11 + this.m_377(2);
            var7 = f_5909.player.getEyeY() + this.f_11927 + Math.sin(this.f_11913 * this.f_11921 + this.f_11922) * this.f_11920 + this.m_377(1) * f_12003;
         } else {
            var5 = this.f_11903 + this.m_377(0);
            var7 = this.f_11904 + this.m_377(1) * f_12004;
            var9 = this.f_11905 + this.m_377(2);
         }

         double var25 = this.f_11925;
         double var13 = f_12005 * this.O * var25;
         this.f_11906 = this.f_11906 + (var25 * var25 * (var5 - this.f_11903) - var13 * this.f_11906) * var3;
         this.f_11907 = this.f_11907 + (var25 * var25 * f_12006 * (var7 - this.f_11904) - var13 * this.f_11907) * var3;
         this.f_11908 = this.f_11908 + (var25 * var25 * (var9 - this.f_11905) - var13 * this.f_11908) * var3;
         double var15 = Math.max(f_12007, this.f_11926 * f_12008);
         double var17 = Math.sqrt(this.f_11906 * this.f_11906 + this.f_11907 * this.f_11907 + this.f_11908 * this.f_11908);
         if (var17 > var15) {
            double var19 = var15 / var17;
            this.f_11906 *= var19;
            this.f_11907 *= var19;
            this.f_11908 *= var19;
         }

         double var26 = this.f_11906 * var3;
         double var21 = this.f_11907 * var3;
         double var23 = this.f_11908 * var3;
         if (!this.m_1319(this.m_3928(this.f_11903 + var26, this.f_11904, this.f_11905))) {
            this.f_11903 += var26;
         } else {
            this.f_11906 = this.f_11906 * f_12009;
         }

         if (!this.m_1319(this.m_3928(this.f_11903, this.f_11904 + var21, this.f_11905))) {
            this.f_11904 += var21;
         } else {
            this.f_11907 = this.f_11907 * f_12010;
         }

         if (!this.m_1319(this.m_3928(this.f_11903, this.f_11904, this.f_11905 + var23))) {
            this.f_11905 += var23;
         } else {
            this.f_11908 = this.f_11908 * f_12011;
         }

         this.f_11909 = (float)(this.f_11909 + this.f_11910 * var3);
         this.f_11929 = this.f_11928 * (float)(1.0 + f_12012 * Math.sin(this.f_11914 * f_12013 + this.f_11899 * f_12014));
      }
   }

   public double m_2251() {
      return this.f_11918;
   }

   public void m_4040(double var1, double var3, double var5) {
      this.f_11906 = var1;
      this.f_11907 = var3;
      this.f_11908 = var5;
   }

   public double m_1565() {
      return this.f_11907;
   }

   public int m_2431() {
      return this.f_11900;
   }

   public Vec3d m_2181() {
      return new Vec3d(this.f_11906, this.f_11907, this.f_11908);
   }

   public double m_628() {
      return this.f_11914;
   }

   public float m_3147() {
      return this.f_11929;
   }

   public Block m_3928(double var1, double var3, double var5) {
      return f_5909.world == null ? Blocks.AIR : f_5909.world.getBlockState(BlockPos.ofFloored(var1, var3, var5)).getBlock();
   }

   public void m_3017() {
      this.f_11903 = this.f_11903 + this.f_11906;
      this.f_11904 = this.f_11904 + this.f_11907;
      this.f_11905 = this.f_11905 + this.f_11908;
      this.f_11907 = this.f_11907 - f_12024;
      this.f_11906 *= 1.0;
      this.f_11907 *= 1.0;
      this.f_11908 *= 1.0;
      this.f_11909 = this.f_11909 + this.f_11910;
      this.f_11910 = this.f_11910 * f_12025;
   }

   public double m_3796() {
      return this.f_11927;
   }

   public double m_3616() {
      return this.f_11905;
   }

   private double m_377(int var1) {
      double var2 = this.f_11922 + var1 * f_11995;
      return this.f_11923
         * (Math.sin(this.f_11913 * this.f_11924 + var2) * f_11996 + Math.sin(this.f_11913 * this.f_11924 * f_11997 + var2 * f_11998) * f_11999);
   }
}
