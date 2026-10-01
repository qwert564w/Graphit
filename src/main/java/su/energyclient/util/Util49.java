package su.energyclient.util;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import su.energyclient.event.EventHandler;

public class Util49 extends Util31 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static boolean f_8276;
   private static float f_8277;
   private static float f_8278;
   private static boolean f_8279;
   private static float f_8280;
   private static float f_8281;
   private static final double f_8282 = 0.15;
   private static final float f_8283 = -90.0F;
   private static final float f_8284 = 90.0F;
   private static final double f_8285 = 0.15;
   private static final float f_8286 = -90.0F;
   private static final float f_8287 = 90.0F;

   @EventHandler
   private void m_418(Util173 var1) {
      if (f_8279) {
         if (!f_8276) {
            f_8277 = var1.m_556().x;
            f_8278 = var1.m_556().y;
         }

         var1.m_884(new Vec2f(f_8280, f_8281));
      } else {
         if (f_8276) {
            var1.m_884(new Vec2f(f_8277, f_8278));
         } else {
            f_8277 = var1.m_556().x;
            f_8278 = var1.m_556().y;
         }
      }
   }

   private void m_3778(double var1, double var3) {
      f_8278 = MathHelper.clamp((float)(f_8278 + var3 * f_8282), f_8283, f_8284);
      f_8277 = (float)(f_8277 + var1 * f_8285);
   }

   public static float m_3248() {
      return f_8279 ? f_8280 : f_8277;
   }

   public static void m_3528() {
      f_8279 = false;
   }

   @EventHandler
   private void m_3286(Util100 var1) {
      if (f_8276) {
         this.m_3778(var1.m_655(), var1.m_2116());
         var1.m_277(true);
      }
   }

   public static float m_883() {
      return f_8277;
   }

   public static boolean m_2511() {
      return f_8276;
   }

   public static void m_3300(float var0, float var1) {
      f_8279 = true;
      f_8280 = MathHelper.wrapDegrees(var0);
      f_8281 = MathHelper.clamp(var1, f_8286, f_8287);
   }

   public static void m_2983(boolean var0) {
      f_8276 = var0;
   }

   public static float m_2701() {
      return f_8279 ? f_8281 : f_8278;
   }

   public static float m_3811() {
      return f_8278;
   }

   public static void m_67(float var0) {
      f_8278 = var0;
   }

   public static void m_3198(float var0) {
      f_8277 = var0;
   }
}
