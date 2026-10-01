package su.energyclient.util;

import java.util.Iterator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import su.energyclient.QuickImports;

public final class Util38 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static boolean f_7823 = false;
   private static final float f_7824 = -1.0F;
   private static final float f_7825 = -1.0F;
   private static final float f_7826 = 180.0F;
   private static final float f_7827 = 90.0F;
   private static final float f_7828 = 90.0F;
   private static final float f_7829 = 45.0F;
   private static final float f_7830 = 45.0F;
   private static final float f_7831 = 45.0F;
   private static final float f_7832 = 45.0F;
   private static final float f_7833 = -1.0F;
   private static final float f_7834 = Float.MAX_VALUE;
   private static final float f_7835 = -1.0F;
   private static final float f_7836 = -1.0F;
   private static final float f_7837 = 180.0F;
   private static final float f_7838 = -0.5F;
   private static final float f_7839 = 0.5F;
   private static final float f_7840 = 90.0F;
   private static final float f_7841 = 90.0F;
   private static final float f_7842 = 180.0F;
   private static final float f_7843 = -0.5F;
   private static final float f_7844 = 0.5F;
   private static final float f_7845 = 90.0F;
   private static final float f_7846 = 90.0F;
   private static final double f_7847 = 2.0;
   private static final double f_7848 = 2.0;
   private static final double f_7849 = 20.0;
   private static final String f_7850 = "This is a utility class and cannot be instantiated";

   public static double m_2137(LivingEntity var0) {
      if (var0 == null) {
         return 0.0;
      } else {
         double var1 = Math.sqrt(Math.pow(var0.getX() - var0.lastX, f_7847) + Math.pow(var0.getZ() - var0.lastZ, f_7848));
         return var1 * f_7849;
      }
   }

   private Util38() {
      throw new UnsupportedOperationException(f_7850);
   }

   public static void m_1834(double var0) {
      double var2 = Math.toRadians(f_5909.player.getYaw());
      double var4 = -Math.sin(var2);
      double var6 = Math.cos(var2);
      m_2324(var4 * var0);
      m_3717(var6 * var0);
   }

   public static void m_3702(double var0) {
      if (m_469()) {
         double var2 = m_2235(true);
         f_5909.player.setVelocity(-Math.sin(var2) * var0, f_5909.player.getVelocity().y, Math.cos(var2) * var0);
      }
   }

   public static double m_3364(float var0, double var1, double var3) {
      if (var1 < 0.0) {
         var0 += f_7837;
      }

      float var5 = 1.0F;
      if (var1 < 0.0) {
         var5 = f_7838;
      } else if (var1 > 0.0) {
         var5 = f_7839;
      }

      if (var3 > 0.0) {
         var0 -= f_7840 * var5;
      }

      if (var3 < 0.0) {
         var0 += f_7841 * var5;
      }

      return Math.toRadians(var0);
   }

   public static void m_3123(double var0) {
      f_5909.player.addVelocityInternal(new Vec3d(0.0, var0, 0.0));
   }

   public static void m_2341(double var0) {
      if (m_1412() < var0) {
         m_1834(var0);
      }
   }

   public static double m_1412() {
      double var0 = f_5909.player.getVelocity().getX();
      double var2 = f_5909.player.getVelocity().getZ();
      return Math.sqrt(var0 * var0 + var2 * var2);
   }

   public static void m_3717(double var0) {
      f_5909.player.setVelocity(f_5909.player.getVelocity().getX(), f_5909.player.getVelocity().getY(), var0);
   }

   public static boolean I(float var0) {
      if (f_5909.player.getY() < 0.0) {
         return false;
      } else {
         Box var1 = f_5909.player.getBoundingBox().offset(0.0, -var0, 0.0);
         Iterator var2 = f_5909.world.getCollisions(f_5909.player, var1).iterator();
         return var2.hasNext() && ((VoxelShape)var2.next()).isEmpty();
      }
   }

   public static double m_2235(boolean var0) {
      float var1 = f_5909.player.getYaw();
      if (f_5909.player.forwardSpeed < 0.0F) {
         var1 += f_7842;
      }

      float var2 = 1.0F;
      if (f_5909.player.forwardSpeed < 0.0F) {
         var2 = f_7843;
      } else if (f_5909.player.forwardSpeed > 0.0F) {
         var2 = f_7844;
      }

      if (f_5909.player.sidewaysSpeed > 0.0F) {
         var1 -= f_7845 * var2;
      }

      if (f_5909.player.sidewaysSpeed < 0.0F) {
         var1 += f_7846 * var2;
      }

      return var0 ? Math.toRadians(var1) : var1;
   }

   public static void m_781(double var0) {
      f_5909.player.addVelocityInternal(new Vec3d(0.0, 0.0, var0));
   }

   public static void m_2324(double var0) {
      f_5909.player.setVelocity(var0, f_5909.player.getVelocity().getY(), f_5909.player.getVelocity().getZ());
   }

   public static void m_728(double var0) {
      f_5909.player.setVelocity(f_5909.player.getVelocity().getX(), var0, f_5909.player.getVelocity().getZ());
   }

   public static int m_1210() {
      int var0 = 0;
      if (f_5909.options.jumpKey.isPressed()) {
         var0++;
      }

      boolean var1 = false;
      var1 = f_5909.options.sneakKey.isPressed();
      if (var1) {
         var0--;
      }

      return var0;
   }

   public static float m_547() {
      if (f_5909.player == null) {
         return f_7824;
      } else {
         boolean var0 = f_5909.options.rightKey.isPressed();
         boolean var1 = f_5909.options.leftKey.isPressed();
         boolean var2 = f_5909.options.forwardKey.isPressed();
         boolean var3 = f_5909.options.backKey.isPressed();
         if (!var0 && !var3 && !var1 && !var2) {
            return f_7825;
         } else {
            float var4 = f_5909.player.getYaw();
            if (var3) {
               var4 -= f_7826;
            }

            boolean var5 = (var3 || var2) && (!var3 || !var2);
            if (!var5) {
               if (var1) {
                  var4 -= f_7827;
               }

               if (var0) {
                  var4 += f_7828;
               }
            } else if (var4 == f_5909.player.getYaw()) {
               if (var1) {
                  var4 -= f_7829;
               }

               if (var0) {
                  var4 += f_7830;
               }
            } else {
               if (var1) {
                  var4 += f_7831;
               }

               if (var0) {
                  var4 -= f_7832;
               }
            }

            if (!var5) {
               var5 = (var1 || var0) && (!var1 || !var0);
            }

            return !var5 ? f_7833 : var4;
         }
      }
   }

   public static void m_3088(Util121 var0, float var1) {
      float var2 = var0.m_2210();
      float var3 = var0.m_2113();
      double var4 = MathHelper.wrapDegrees(Math.toDegrees(m_3364(f_5909.player.getYaw(), var2, -var3)));
      if (var2 != 0.0F || var3 != 0.0F) {
         float var6 = 0.0F;
         float var7 = 0.0F;
         float var8 = f_7834;

         for (float var9 = f_7835; var9 <= 1.0F; var9++) {
            for (float var10 = f_7836; var10 <= 1.0F; var10++) {
               if (var10 != 0.0F || var9 != 0.0F) {
                  double var11 = MathHelper.wrapDegrees(Math.toDegrees(m_3364(var1, var9, -var10)));
                  double var13 = Math.abs(MathHelper.wrapDegrees(var4 - var11));
                  if (var13 < var8) {
                     var8 = (float)var13;
                     var6 = var9;
                     var7 = var10;
                  }
               }
            }
         }

         var0.m_433(var6);
         var0.m_2791(var7);
      }
   }

   public static void m_3292(double var0) {
      f_5909.player.addVelocityInternal(new Vec3d(var0, 0.0, 0.0));
   }

   public static boolean m_469() {
      return f_5909.player != null && f_5909.world != null
         ? f_5909.player.input.getMovementInput().x != 0.0 || f_5909.player.input.getMovementInput().y != 0.0
         : false;
   }
}
