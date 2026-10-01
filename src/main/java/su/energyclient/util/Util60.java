package su.energyclient.util;

import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.util.math.MathHelper;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;

public class Util60 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_8376 = 20.0F;
   private static final float f_8377 = 0.0F;
   private static float f_8378 = Util60.f_8392;
   private static float f_8379 = 0.0F;
   private static long f_8380 = Util60.f_8393;
   private static final long f_8381 = -1L;
   private static final float f_8382 = 20.0F;
   private static final float f_8383 = 1.0E9F;
   private static final float f_8384 = 20.0F;
   private static final float f_8385 = 20.0F;
   private static final float f_8386 = 20.0F;
   private static final float f_8387 = 20.0F;
   private static final float f_8388 = 20.0F;
   private static final long f_8389 = -1L;
   private static final double f_8390 = 100.0;
   private static final double f_8391 = 100.0;
   private static final float f_8392 = 20.0F;
   private static final long f_8393 = -1L;

   private static void m_509() {
      long var0 = System.nanoTime();
      if (f_8380 == f_8381) {
         f_8380 = var0;
      } else {
         long var2 = var0 - f_8380;
         f_8380 = var0;
         if (var2 > 0L) {
            float var4 = f_8382 * (f_8383 / (float)var2);
            if (Float.isFinite(var4)) {
               float var5 = MathHelper.clamp(var4, 0.0F, f_8384);
               f_8378 = (float)m_1628(var5);
               f_8379 = var5 - f_8385;
            }
         }
      }
   }

   public static float m_2077() {
      return f_8378;
   }

   public static float m_1341() {
      return f_8379;
   }

   public static float m_1276() {
      return Float.isFinite(f_8378) && !(f_8378 <= 0.0F) ? MathHelper.clamp(f_8378, 1.0F, f_8387) : f_8386;
   }

   public Util60() {
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   public static void m_3972() {
      f_8378 = f_8388;
      f_8379 = 0.0F;
      f_8380 = f_8389;
   }

   public static double m_1628(double var0) {
      return Math.round(var0 * f_8390) / f_8391;
   }

   @EventHandler
   public void m_1740(Util66 var1) {
      if (var1.m_2068()) {
         if (var1.m_3295() instanceof GameJoinS2CPacket) {
            m_3972();
         } else {
            if (var1.m_3295() instanceof WorldTimeUpdateS2CPacket) {
               m_509();
            }
         }
      }
   }
}
