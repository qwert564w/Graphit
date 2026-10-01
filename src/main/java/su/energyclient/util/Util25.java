package su.energyclient.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public final class Util25 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final int f_3337 = 80000;
   private final List<Util25.Inner_9EgOTnVBQxu2yODn> f_3338 = new ArrayList<>();
   private int[] f_3339 = new int[0];
   private static final Util25 f_3340 = new Util25();
   private static boolean f_3341 = false;
   private static final String l = "";
   private static final int f_3342 = 80000;
   private static final float f_3343 = 0.001F;
   private static final float f_3344 = 0.001F;
   private static final float f_3345 = 30.0F;
   private static final float f_3346 = 12.0F;
   private static final float f_3347 = 3.0F;
   private static final float f_3348 = 4.0F;
   private static final float f_3349 = 4.0F;
   private static final float f_3350 = 30.0F;
   private static final float f_3351 = 12.0F;
   private static final float f_3352 = 3.0F;
   private static final float f_3353 = 4.0F;
   private static final float f_3354 = 4.0F;
   private static final float f_3355 = 0.3F;
   private static final float f_3356 = 0.3F;
   private static final double f_3357 = 0.001;
   private static final String f_3358 = "err_yaw,err_pitch,prev_dy,prev_dp,dist,target_speed,delta_yaw,delta_pitch";
   private static final String f_3359 = "err_yaw";
   private static final String f_3360 = ",";
   private static final int f_3361 = 80000;

   public synchronized void m_3026() {
      this.f_3338.clear();
      this.f_3339 = new int[0];
   }

   public static synchronized Util25 m_3590() {
      if (!f_3341) {
         f_3341 = true;

         try {
            f_3340.m_3555(Util103.f_14291);
         } catch (IOException var1) {
         }
      }

      return f_3340;
   }

   public synchronized int m_3930() {
      return this.f_3338.size();
   }

   public synchronized Util25.Inner_9EgOTnVBQxu2yODn m_821(int var1) {
      return this.f_3338.get(var1);
   }

   public synchronized void m_3555(Path var1) throws IOException {
      this.f_3338.clear();
      this.f_3339 = new int[0];
      if (Files.exists(var1)) {
         try (BufferedReader var2 = Files.newBufferedReader(var1)) {
            String var3 = var2.readLine();
            if (var3 == null) {
               return;
            }

            if (!var3.startsWith(f_3359)) {
               this.m_2556(var3);
            }

            while ((var3 = var2.readLine()) != null) {
               this.m_2556(var3);
            }
         }

         this.m_1530();
      }
   }

   public synchronized void m_1530() {
      int var1 = this.f_3338.size();
      int[] var2 = new int[var1];
      if (var1 == 0) {
         this.f_3339 = var2;
      } else {
         int var3 = 0;

         for (int var4 = 1; var4 < var1; var4++) {
            Util25.Inner_9EgOTnVBQxu2yODn var5 = this.f_3338.get(var4 - 1);
            Util25.Inner_9EgOTnVBQxu2yODn var6 = this.f_3338.get(var4);
            boolean var7 = Math.abs(var6.f_4745 - var5.f_4749) < f_3343 && Math.abs(var6.f_4746 - var5.f_4750) < f_3344;
            if (!var7) {
               for (int var8 = var3; var8 < var4; var8++) {
                  var2[var8] = var4;
               }

               var3 = var4;
            }
         }

         for (int var9 = var3; var9 < var1; var9++) {
            var2[var9] = var1;
         }

         this.f_3339 = var2;
      }
   }

   public synchronized float[] m_2110(float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      List<Util25.agixeqIxLnQtZWsb> var8 = this.m_3084(var1, var2, var3, var4, var5, var6, var7);
      if (var8.isEmpty()) {
         return null;
      } else {
         double var9 = 0.0;
         double var11 = 0.0;
         double var13 = 0.0;

         for (Util25.agixeqIxLnQtZWsb var16 : var8) {
            double var17 = 1.0 / (Math.sqrt(var16.f_5996) + f_3357);
            var9 += var17;
            var11 += var17 * var16.m_3235();
            var13 += var17 * var16.m_2812();
         }

         return var9 <= 0.0 ? null : new float[]{(float)(var11 / var9), (float)(var13 / var9)};
      }
   }

   public static synchronized void m_2405() {
      f_3340.m_3026();
      f_3341 = true;
   }

   private void m_2556(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         String[] var2 = var1.split(f_3360);
         if (var2.length >= 8) {
            try {
               this.f_3338
                  .add(
                     new Util25.Inner_9EgOTnVBQxu2yODn(
                        Float.parseFloat(var2[0]),
                        Float.parseFloat(var2[1]),
                        Float.parseFloat(var2[2]),
                        Float.parseFloat(var2[3]),
                        Float.parseFloat(var2[4]),
                        Float.parseFloat(var2[5]),
                        Float.parseFloat(var2[6]),
                        Float.parseFloat(var2[7])
                     )
                  );
               if (this.f_3338.size() > f_3361) {
                  this.f_3338.remove(0);
               }
            } catch (NumberFormatException var4) {
            }
         }
      }
   }

   public synchronized void m_698(Util25.Inner_9EgOTnVBQxu2yODn var1) {
      if (this.f_3338.size() >= f_3342) {
         this.f_3338.remove(0);
      }

      this.f_3338.add(var1);
      this.f_3339 = new int[0];
   }

   public synchronized void m_2034(Path var1) throws IOException {
      Path var2 = var1.getParent();
      if (var2 != null) {
         Files.createDirectories(var2);
      }

      try (BufferedWriter var3 = Files.newBufferedWriter(var1)) {
         var3.write(f_3358);
         var3.write(10);
         StringBuilder var4 = new StringBuilder(96);

         for (Util25.Inner_9EgOTnVBQxu2yODn var6 : this.f_3338) {
            var4.setLength(0);
            var4.append(var6.f_4743)
               .append(',')
               .append(var6.f_4744)
               .append(',')
               .append(var6.f_4745)
               .append(',')
               .append(var6.f_4746)
               .append(',')
               .append(var6.f_4747)
               .append(',')
               .append(var6.f_4748)
               .append(',')
               .append(var6.f_4749)
               .append(',')
               .append(var6.f_4750)
               .append('\n');
            var3.write(var4.toString());
         }
      }
   }

   public synchronized int m_2942(int var1) {
      if (this.f_3339.length != this.f_3338.size()) {
         this.m_1530();
      }

      return var1 >= 0 && var1 < this.f_3339.length ? this.f_3339[var1] : this.f_3338.size();
   }

   public synchronized List<Util25.agixeqIxLnQtZWsb> m_3084(float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      if (!this.f_3338.isEmpty() && var7 > 0) {
         boolean var8 = var1 < 0.0F;
         float var9 = var8 ? -var1 : var1;
         float var10 = var8 ? -var3 : var3;
         float var11 = f_3345;
         float var12 = f_3346;
         float var13 = f_3347;
         float var14 = 2.0F;
         float var15 = f_3348;
         float var16 = f_3349;
         PriorityQueue var17 = new PriorityQueue<>(Math.max(2, var7), Comparator.<Util25.agixeqIxLnQtZWsb>comparingDouble(var0 -> var0.f_5996).reversed());

         for (int var18 = 0; var18 < this.f_3338.size(); var18++) {
            Util25.Inner_9EgOTnVBQxu2yODn var19 = this.f_3338.get(var18);
            float var20 = (var19.f_4743 - var9) / f_3350;
            float var21 = (var19.f_4744 - var2) / f_3351;
            float var22 = (var19.f_4745 - var10) / f_3352;
            float var23 = (var19.f_4746 - var4) / 2.0F;
            float var24 = (var19.f_4747 - var5) / f_3353;
            float var25 = (var19.f_4748 - var6) / f_3354;
            float var26 = var20 * var20 + var21 * var21 + var22 * var22 + var23 * var23 + f_3355 * var24 * var24 + f_3356 * var25 * var25;
            if (var17.size() < var7) {
               var17.add(new Util25.agixeqIxLnQtZWsb(var18, var19, var8, var26));
            } else if (var26 < ((Util25.agixeqIxLnQtZWsb)var17.peek()).f_5996) {
               var17.poll();
               var17.add(new Util25.agixeqIxLnQtZWsb(var18, var19, var8, var26));
            }
         }

         ArrayList<Util25.agixeqIxLnQtZWsb> var27 = new ArrayList<>(var17);
         var27.sort(Comparator.comparingDouble(var0 -> var0.f_5996));
         return var27;
      } else {
         return Collections.emptyList();
      }
   }

   public static final class Inner_9EgOTnVBQxu2yODn {
      public final float f_4743;
      public final float f_4744;
      public final float f_4745;
      public final float f_4746;
      public final float f_4747;
      public final float f_4748;
      public final float f_4749;
      public final float f_4750;

      public Inner_9EgOTnVBQxu2yODn(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
         this.f_4743 = var1;
         this.f_4744 = var2;
         this.f_4745 = var3;
         this.f_4746 = var4;
         this.f_4747 = var5;
         this.f_4748 = var6;
         this.f_4749 = var7;
         this.f_4750 = var8;
      }
   }

   public static final class agixeqIxLnQtZWsb {
      public final int f_5993;
      public final Util25.Inner_9EgOTnVBQxu2yODn f_5994;
      public final boolean f_5995;
      public final float f_5996;

      public float m_2279() {
         return this.f_5995 ? -this.f_5994.f_4743 : this.f_5994.f_4743;
      }

      public float m_2039() {
         return this.f_5995 ? -this.f_5994.f_4745 : this.f_5994.f_4745;
      }

      public float m_3235() {
         return this.f_5995 ? -this.f_5994.f_4749 : this.f_5994.f_4749;
      }

      public agixeqIxLnQtZWsb(int var1, Util25.Inner_9EgOTnVBQxu2yODn var2, boolean var3, float var4) {
         this.f_5993 = var1;
         this.f_5994 = var2;
         this.f_5995 = var3;
         this.f_5996 = var4;
      }

      public float m_2812() {
         return this.f_5994.f_4750;
      }
   }
}
