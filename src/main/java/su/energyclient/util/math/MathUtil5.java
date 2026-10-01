package su.energyclient.util.math;

import java.util.Optional;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import su.energyclient.QuickImports;

public final class MathUtil5 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_6141 = (float) (Math.PI / 180.0);
   private static final float f_6142 = (float) (Math.PI / 180.0);

   public static Vec3d O(float var0, float var1) {
      float var2 = -var0 * f_6141;
      float var3 = -var1 * f_6142;
      float var4 = (float)Math.cos(var3);
      return new Vec3d(Math.sin(var2) * var4, Math.sin(var3), Math.cos(var2) * var4);
   }

   private static double O(Vec3d var0, Vec3d var1, Vec3d var2) {
      Vec3d var3 = var2.subtract(var1);
      double var4 = var3.lengthSquared();
      if (var4 == 0.0) {
         return var0.squaredDistanceTo(var1);
      } else {
         double var6 = Math.max(0.0, Math.min(1.0, var0.subtract(var1).dotProduct(var3) / var4));
         return var0.squaredDistanceTo(var1.add(var3.multiply(var6)));
      }
   }

   public static boolean O(Box var0, float var1, float var2, double var3, boolean var5) {
      if (f_5909.player != null && f_5909.world != null) {
         Vec3d var6 = f_5909.player.getEyePos();
         if (var0.contains(var6)) {
            return true;
         } else {
            Vec3d var7 = var6.add(O(var1, var2).multiply(var3));
            Optional var8 = var0.raycast(var6, var7);
            if (var8.isEmpty()) {
               return false;
            } else if (!var5) {
               return true;
            } else {
               BlockHitResult var9 = f_5909.world.raycast(new RaycastContext(var6, (Vec3d)var8.get(), ShapeType.OUTLINE, FluidHandling.NONE, f_5909.player));
               return var9.getType() != Type.BLOCK || var6.squaredDistanceTo(var9.getPos()) >= var6.squaredDistanceTo((Vec3d)var8.get());
            }
         }
      } else {
         return false;
      }
   }

   public static boolean O(Vec3d var0, float var1, float var2, double var3, double var5) {
      Vec3d var7 = f_5909.player.getEyePos();
      Vec3d var8 = var7.add(O(var1, var2).multiply(var3));
      return O(var0, var7, var8) <= var5 * var5;
   }

   private MathUtil5() {
   }

   public static boolean O(Entity var0, float var1, float var2, double var3, boolean var5) {
      return O(var0.getBoundingBox(), var1, var2, var3, var5);
   }
}
