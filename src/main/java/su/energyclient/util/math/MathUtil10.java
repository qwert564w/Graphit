package su.energyclient.util.math;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Frustum;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector4f;
import su.energyclient.QuickImports;
import su.energyclient.mixin.GameRendererMixin;

public class MathUtil10 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_14407 = (float) Math.PI;
   private static final float f_14408 = 0.5F;
   private static final float f_14409 = (float) Math.PI;
   private static final float f_14410 = (float) Math.PI;
   private static final float f_14411 = 3.0F;
   private static final float f_14412 = (float) Math.PI;
   private static final float f_14413 = 0.2F;
   private static final float f_14414 = 5.0F;
   private static final float f_14415 = 20.0F;
   private static final float f_14416 = 40.0F;
   private static final float f_14417 = 8000.0F;
   private static final float f_14418 = 200.0F;
   private static final float f_14419 = (float) Math.PI;
   private static final float f_14420 = 14.0F;
   private static final float f_14421 = Float.MAX_VALUE;
   private static final float f_14422 = Float.MAX_VALUE;
   private static final float f_14423 = 0.5F;
   private static final float f_14424 = 0.5F;
   private static final float f_14425 = 0.5F;
   private static final float f_14426 = 0.5F;
   private static final float f_14427 = 0.2F;
   private static final float f_14428 = 0.1F;
   private static final double f_14429 = 2.0;
   private static final double f_14430 = 2.0;
   private static final double f_14431 = 2.0;
   private static final double f_14432 = 2.0;
   private static final float f_14433 = Float.MAX_VALUE;
   private static final float f_14434 = Float.MAX_VALUE;

   public static Vector2f m_1972(double var0, double var2, double var4) {
      return m_362(var0, var2, var4, true, true);
   }

   public static Vector2f m_2018(Vec3d var0) {
      return m_1972(var0.x, var0.y, var0.z);
   }

   private static Matrix4f m_2837(float var0) {
      Matrix4f var1 = new Matrix4f();
      if (f_5909.getCameraEntity() instanceof LivingEntity var3) {
         float var4 = var3.hurtTime - var0;
         if (var3.isDead()) {
            float var5 = Math.min(var3.deathTime + var0, f_14415);
            float var6 = f_14416 - f_14417 / (var5 + f_14418);
            var1.rotateZ((float)Math.toRadians(var6));
         }

         if (var4 >= 0.0F) {
            var4 /= var3.maxHurtTime;
            var4 = MathHelper.sin(var4 * var4 * var4 * var4 * f_14419);
            float var11 = m_2779(var3);
            var1.rotateY((float)Math.toRadians(-var11));
            double var12 = (Double)f_5909.options.getDamageTiltStrength().getValue();
            float var8 = (float)(-var4 * f_14420 * var12);
            var1.rotateZ((float)Math.toRadians(var8));
            var1.rotateY((float)Math.toRadians(var11));
         }
      }

      return var1;
   }

   public static Vec3d m_516(Entity var0, float var1) {
      double var2 = MathHelper.lerp(var1, var0.lastX, var0.getX());
      double var4 = MathHelper.lerp(var1, var0.lastY, var0.getY());
      double var6 = MathHelper.lerp(var1, var0.lastZ, var0.getZ());
      return new Vec3d(var2, var4, var6);
   }

   public static Box m_2297(Entity var0, Vec3d var1) {
      Box var2 = var0.getBoundingBox();
      Vec3d var3 = new Vec3d(var2.maxX - var2.minX, var2.maxY - var2.minY, var2.maxZ - var2.minZ);
      float var4 = f_14427 - (var0.isSneaking() && !f_5909.player.getAbilities().flying ? f_14428 : 0.0F);
      return new Box(var1.x - var3.x / f_14429, var1.y, var1.z - var3.z / f_14430, var1.x + var3.x / f_14431, var1.y + var3.y + var4, var1.z + var3.z / f_14432);
   }

   public static Vector2f m_362(double var0, double var2, double var4, boolean var6, boolean var7) {
      Vector4f var8 = m_1359(var0, var2, var4, var6, var7);
      return m_1166(var8);
   }

   private static Matrix4f m_3903(float var0) {
      Matrix4f var1 = new Matrix4f();
      if (!(Boolean)f_5909.options.getBobView().getValue()) {
         return var1;
      } else {
         if (f_5909.getCameraEntity() instanceof AbstractClientPlayerEntity var3) {
            float var4 = -var3.limbAnimator.getAnimationProgress(var0);
            float var5 = var3.limbAnimator.getAmplitude(var0);
            var5 = Math.min(var5, 1.0F);
            var1.translate(MathHelper.sin(var4 * f_14407) * var5 * f_14408, -Math.abs(MathHelper.cos(var4 * f_14409) * var5), 0.0F);
            float var6 = MathHelper.sin(var4 * f_14410) * var5 * f_14411;
            var1.rotateZ((float)Math.toRadians(var6));
            float var7 = Math.abs(MathHelper.cos(var4 * f_14412 - f_14413) * var5) * f_14414;
            var1.rotateX((float)Math.toRadians(var7));
         }

         return var1;
      }
   }

   private static Vector2f m_1166(Vector4f var0) {
      if (var0.w <= 0.0F) {
         return new Vector2f(f_14421, f_14422);
      } else {
         var0.div(var0.w);
         float var1 = var0.x;
         float var2 = var0.y;
         int var3 = f_5909.getWindow().getScaledWidth();
         int var4 = f_5909.getWindow().getScaledHeight();
         float var5 = (var1 * f_14423 + f_14424) * var3;
         float var6 = (1.0F - (var2 * f_14425 + f_14426)) * var4;
         return new Vector2f(var5, var6);
      }
   }

   public static Vec3d[] m_1801(Box var0) {
      return new Vec3d[]{
         new Vec3d(var0.minX, var0.minY, var0.minZ),
         new Vec3d(var0.minX, var0.minY, var0.maxZ),
         new Vec3d(var0.minX, var0.maxY, var0.minZ),
         new Vec3d(var0.minX, var0.maxY, var0.maxZ),
         new Vec3d(var0.maxX, var0.minY, var0.minZ),
         new Vec3d(var0.maxX, var0.minY, var0.maxZ),
         new Vec3d(var0.maxX, var0.maxY, var0.minZ),
         new Vec3d(var0.maxX, var0.maxY, var0.maxZ)
      };
   }

   public static boolean m_1509(Entity var0) {
      if (f_5909.getCameraEntity() != null && f_5909.worldRenderer != null) {
         Frustum var1 = f_5909.worldRenderer.getCapturedFrustum();
         if (var1 == null) {
            return true;
         } else {
            Camera var2 = f_5909.gameRenderer.getCamera();
            if (var2 == null) {
               return false;
            } else {
               Vec3d var3 = var2.getCameraPos();
               return f_5909.getEntityRenderDispatcher().shouldRender(var0, var1, var3.x, var3.y, var3.z);
            }
         }
      } else {
         return false;
      }
   }

   private static float m_2779(LivingEntity var0) {
      try {
         return var0.getDamageTiltYaw();
      } catch (Exception var2) {
         return 0.0F;
      }
   }

   public static Vector2f m_2788(double var0, double var2, double var4, boolean var6) {
      return m_362(var0, var2, var4, var6, true);
   }

   public static boolean m_1452(Vector2f var0) {
      return var0.x != f_14433
         && var0.y != f_14434
         && var0.x >= 0.0F
         && var0.x <= f_5909.getWindow().getScaledWidth()
         && var0.y >= 0.0F
         && var0.y <= f_5909.getWindow().getScaledHeight();
   }

   private static Vector4f m_1359(double var0, double var2, double var4, boolean var6, boolean var7) {
      Camera var8 = f_5909.gameRenderer.getCamera();
      if (var8 == null) {
         return new Vector4f(0.0F, 0.0F, 0.0F, 0.0F);
      } else {
         Vec3d var9 = var8.getCameraPos();
         float var10 = f_5909.getRenderTickCounter().getTickProgress(true);
         float var11 = ((GameRendererMixin)f_5909.gameRenderer).invokeGetFov(var8, var10, true);
         Matrix4f var12 = f_5909.gameRenderer.getBasicProjectionMatrix(var11);
         Quaternionf var13 = new Quaternionf(var8.getRotation());
         var13.conjugate();
         Matrix4f var14 = new Matrix4f().rotation(var13).translate(-((float)var9.x), -((float)var9.y), -((float)var9.z));
         Matrix4f var15 = var7 ? m_2837(var10) : new Matrix4f();
         Matrix4f var16 = var6 ? m_3903(var10) : new Matrix4f();
         Matrix4f var17 = new Matrix4f(var12).mul(var15).mul(var16).mul(var14);
         Vector4f var18 = new Vector4f((float)var0, (float)var2, (float)var4, 1.0F);
         var17.transform(var18);
         return var18;
      }
   }
}
