package su.energyclient.util;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.util.math.MathHelper;

public class Util71 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_9125 = 255.0F;
   private static final float f_9126 = 255.0F;
   private static final float f_9127 = 255.0F;
   private static final float f_9128 = 255.0F;
   private static final float f_9129 = 255.0F;
   private static final int f_9130 = 16777215;
   private static final float f_9131 = 0.9F;
   private static final int f_9132 = -16777216;
   private static final int f_9133 = 16777215;
   private static final float f_9134 = 255.0F;
   private static final float f_9135 = 255.0F;
   private static final float f_9136 = 255.0F;
   private static final float f_9137 = 255.0F;
   private static final float f_9138 = 255.0F;
   private static final String f_9139 = "#";
   private static final String f_9140 = "0x";
   private static final String f_9141 = "0X";
   private static final long f_9142 = 360L;
   private static final float f_9143 = 180.0F;

   public static int m_1563() {
      float var0 = ThreadLocalRandom.current().nextFloat();
      return Color.HSBtoRGB(var0, f_9131, 1.0F) | f_9132;
   }

   public static int m_2734(int var0) {
      return var0 >> 24 & 0xFF;
   }

   public static int m_2078(String var0) {
      String var1 = var0.trim();
      if (var1.startsWith(f_9139)) {
         var1 = var1.substring(1);
      }

      if (var1.startsWith(f_9140) || var1.startsWith(f_9141)) {
         var1 = var1.substring(2);
      }

      if (var1.length() == 3 || var1.length() == 4) {
         char var2 = var1.charAt(0);
         char var3 = var1.charAt(1);
         char var4 = var1.charAt(2);
         char var5 = var1.length() == 4 ? var1.charAt(3) : 70;
         var1 = "" + var2 + var2 + var3 + var3 + var4 + var4 + var5 + var5;
      }

      if (var1.length() == 6) {
         int var7 = Integer.parseInt(var1.substring(0, 2), 16);
         int var9 = Integer.parseInt(var1.substring(2, 4), 16);
         int var11 = Integer.parseInt(var1.substring(4, 6), 16);
         return m_756(var7, var9, var11, 255);
      } else if (var1.length() == 8) {
         int var6 = Integer.parseInt(var1.substring(0, 2), 16);
         int var8 = Integer.parseInt(var1.substring(2, 4), 16);
         int var10 = Integer.parseInt(var1.substring(4, 6), 16);
         int var12 = Integer.parseInt(var1.substring(6, 8), 16);
         return m_756(var6, var8, var10, var12);
      } else {
         throw new IllegalArgumentException("Unsupported hex format: " + var0);
      }
   }

   public static int m_644(int var0) {
      return var0 >> 8 & 0xFF;
   }

   public static int m_1907(int var0, float var1) {
      return m_3389(var0, (int)(MathHelper.clamp(var1, 0.0F, 1.0F) * f_9134));
   }

   public static int m_1989(int var0) {
      return var0 >> 16 & 0xFF;
   }

   public static int m_1415(int var0, int var1, int var2) {
      return m_756(var0, var1, var2, 255);
   }

   public static int m_120(int var0, int var1) {
      int var2 = Math.min(255, Math.max(0, var1));
      return var0 & f_9133 | var2 << 24;
   }

   public static int m_3793(int var0, int var1) {
      return m_756(Math.min(255, m_1989(var0) + var1), Math.min(255, m_644(var0) + var1), Math.min(255, m_3163(var0) + var1), m_2734(var0));
   }

   public static int m_1784(int var0, int var1, int var2, int var3) {
      int var4 = (int)((System.currentTimeMillis() / var0 + var1) % f_9142);
      var4 = (var4 > 180 ? 360 - var4 : var4) + 180;
      return m_2924(var2, var3, (var4 - 180) / f_9143);
   }

   public static int m_756(int var0, int var1, int var2, int var3) {
      return MathHelper.clamp(var3, 0, 255) << 24 | MathHelper.clamp(var0, 0, 255) << 16 | MathHelper.clamp(var1, 0, 255) << 8 | MathHelper.clamp(var2, 0, 255);
   }

   public static int m_3389(int var0, int var1) {
      return m_756(m_1989(var0), m_644(var0), m_3163(var0), var1);
   }

   public static int m_2101(int var0, float var1) {
      float[] var2 = m_2326(var0);
      float[] var3 = Color.RGBtoHSB((int)(var2[0] * f_9135), (int)(var2[1] * f_9136), (int)(var2[2] * f_9137), null);
      var3[2] *= var1;
      var3[2] = Math.max(0.0F, Math.min(1.0F, var3[2]));
      return m_1907(Color.HSBtoRGB(var3[0], var3[1], var3[2]), var2[3] * f_9138);
   }

   public static int m_2523(int var0, int var1, int var2, int var3) {
      return m_756(var0, var1, var2, var3);
   }

   public static int m_3765(int var0, float var1) {
      int var2 = Math.min(255, Math.max(0, (int)(var1 * f_9129)));
      return var0 & f_9130 | var2 << 24;
   }

   public static int m_3163(int var0) {
      return var0 & 0xFF;
   }

   public static int m_2924(int var0, int var1, float var2) {
      double var3 = MathHelper.clamp(var2, 0.0F, 1.0F);
      return m_756(
         Util39.m_930(m_1989(var0), m_1989(var1), var3),
         Util39.m_930(m_644(var0), m_644(var1), var3),
         Util39.m_930(m_3163(var0), m_3163(var1), var3),
         Util39.m_930(m_2734(var0), m_2734(var1), var3)
      );
   }

   public static float[] m_2326(int var0) {
      return new float[]{m_1989(var0) / f_9125, m_644(var0) / f_9126, m_3163(var0) / f_9127, m_2734(var0) / f_9128};
   }
}
