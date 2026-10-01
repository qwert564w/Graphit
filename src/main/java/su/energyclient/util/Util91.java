package su.energyclient.util;

import net.minecraft.util.math.MathHelper;
import su.energyclient.event.EventHandler;

public class Util91 extends Util31 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Util91.yODkR9SMA0x1MDvS f_6038 = Util91.yODkR9SMA0x1MDvS.IDLE;
   private float f_6039;
   private float f_6040;
   private float f_6041;
   private float f_6042;
   private int f_6043;
   private int f_6044;
   private int f_6045;
   private Util10 l;
   private static final float f_6046 = -90.0F;
   private static final float f_6047 = 90.0F;
   private static final float f_6048 = -90.0F;
   private static final float f_6049 = 90.0F;
   private static final float f_6050 = -90.0F;
   private static final float f_6051 = 90.0F;
   private static final float f_6052 = 0.15F;

   private void m_3087() {
      if (f_5909.player == null) {
         this.m_1776();
      } else {
         Util10 var1 = new Util10(Util49.m_883(), Util49.m_3811());
         if (this.m_3231(var1, this.m_1259(), this.m_3294())) {
            f_5909.player.setYaw(var1.m_2643());
            f_5909.player.setPitch(MathHelper.clamp(var1.m_2573(), f_6046, f_6047));
            Util49.m_3198(f_5909.player.getYaw());
            Util49.m_67(f_5909.player.getPitch());
            this.m_1776();
         }
      }
   }

   public Util91 m_4003(float var1) {
      this.f_6040 = var1;
      return this;
   }

   private boolean m_3231(Util10 var1, float var2, float var3) {
      if (f_5909.player == null) {
         return false;
      } else {
         Util10 var4 = new Util10(f_5909.player);
         float var5 = MathHelper.wrapDegrees(var1.m_2643() - var4.m_2643());
         float var6 = var1.m_2573() - var4.m_2573();
         float var7 = this.m_3263(var2);
         float var8 = this.m_3263(var3);
         float var9 = Math.min(Math.abs(var5), var7);
         float var10 = Math.min(Math.abs(var6), var8);
         f_5909.player
            .setYaw(
               f_5909.player.getYaw() + Util36.m_569(MathHelper.clamp(var5, -var9, var9)) - Util36.m_569(MathHelper.clamp(var5, -var9, var9)) % Util36.m_399()
            );
         f_5909.player
            .setPitch(
               MathHelper.clamp(f_5909.player.getPitch() + Util36.m_569(MathHelper.clamp(var6, -var10, var10)), f_6048, f_6049)
                  - MathHelper.clamp(f_5909.player.getPitch() + Util36.m_569(MathHelper.clamp(var6, -var10, var10)), f_6050, f_6051) % Util36.m_399()
            );
         this.m_1551(0);
         return new Util10(f_5909.player).m_855(var1) < 1.0F;
      }
   }

   public Util91 m_2429(float var1) {
      this.f_6039 = var1;
      return this;
   }

   public Util91 m_1039(float var1) {
      this.f_6042 = var1;
      return this;
   }

   public Util91.yODkR9SMA0x1MDvS m_3081() {
      return this.f_6038;
   }

   public static void m_1467(Util10 var0, float var1, int var2, int var3) {
      m_3699(var0, var1, var1, var2, var3);
   }

   public boolean m_2381() {
      return !this.f_6038.equals(Util91.yODkR9SMA0x1MDvS.IDLE);
   }

   public float m_3294() {
      return this.f_6042;
   }

   public float m_3352() {
      return this.f_6039;
   }

   public Util91 m_1551(int var1) {
      this.f_6045 = var1;
      return this;
   }

   public int m_3727() {
      return this.f_6044;
   }

   private float m_3263(float var1) {
      return var1 * (Util36.m_399() / f_6052);
   }

   public void m_1776() {
      if (f_5909.player != null) {
         Util49.m_3198(f_5909.player.getYaw());
         Util49.m_67(f_5909.player.getPitch());
      }

      this.m_4067(null);
      this.m_1766(Util91.yODkR9SMA0x1MDvS.IDLE);
      this.m_1287(0);
      if (!Util54.m_1085().m_1560() && !Util9.m_3678().m_1751()) {
         Util49.m_2983(false);
      }
   }

   public float m_1259() {
      return this.f_6041;
   }

   public Util91 m_4067(Util10 var1) {
      this.l = var1;
      return this;
   }

   public int m_2829() {
      return this.f_6043;
   }

   public Util91 m_1287(int var1) {
      this.f_6043 = var1;
      return this;
   }

   public static Util91 m_1449() {
      return Util85.m_1797(Util91.class);
   }

   public static void m_838(Util10 var0, float var1, float var2, float var3, float var4, int var5, int var6, boolean var7) {
      Util91 var8 = m_1449();
      if (var8.m_2829() <= var6) {
         if (var0 == null) {
            var8.m_1553(var3);
            var8.m_1039(var4);
            var8.m_1766(Util91.yODkR9SMA0x1MDvS.RESET);
         } else {
            if (var8.m_3081().equals(Util91.yODkR9SMA0x1MDvS.IDLE) && !var7) {
               if (f_5909.player != null) {
                  Util49.m_3198(f_5909.player.getYaw());
                  Util49.m_67(f_5909.player.getPitch());
               }

               Util49.m_2983(true);
            }

            var8.m_2429(var1);
            var8.m_4003(var2);
            var8.m_1553(var3);
            var8.m_1039(var4);
            var8.m_1297(var5);
            var8.m_1287(var6);
            var8.m_1766(Util91.yODkR9SMA0x1MDvS.AIM);
            var8.m_4067(var0);
            var8.m_3231(var0, var1, var2);
         }
      }
   }

   public Util91 m_1297(int var1) {
      this.f_6044 = var1;
      return this;
   }

   @EventHandler
   public void m_2321(Util172 var1) {
      if (this.m_3081().equals(Util91.yODkR9SMA0x1MDvS.AIM) && this.m_796() > this.m_3727()) {
         this.m_1766(Util91.yODkR9SMA0x1MDvS.RESET);
      }

      if (this.m_3081().equals(Util91.yODkR9SMA0x1MDvS.RESET)) {
         this.m_3087();
      }

      this.f_6045++;
   }

   public int m_796() {
      return this.f_6045;
   }

   public Util91 m_1766(Util91.yODkR9SMA0x1MDvS var1) {
      this.f_6038 = var1;
      return this;
   }

   public Util91 m_1553(float var1) {
      this.f_6041 = var1;
      return this;
   }

   public Util10 m_2707() {
      return this.l;
   }

   public static void m_3699(Util10 var0, float var1, float var2, int var3, int var4) {
      m_838(var0, var1, var1, var2, var2, var3, var4, false);
   }

   public float O4() {
      return this.f_6040;
   }

   public static enum yODkR9SMA0x1MDvS {
      AIM,
      RESET,
      IDLE;
   }
}
