package su.energyclient.util;

import net.minecraft.util.math.MathHelper;
import su.energyclient.event.EventHandler;

public class Util9 extends Util31 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Util9.cNZoM5LXM6zOvJ8t f_5112 = Util9.cNZoM5LXM6zOvJ8t.IDLE;
   private float f_5113;
   private float f_5114;
   private float f_5115;
   private float f_5116;
   private int f_5117;
   private int f_5118;
   private int f_5119;
   private Util10 f_5120;
   private static final float f_5121 = -90.0F;
   private static final float f_5122 = 90.0F;
   private static final float f_5123 = -90.0F;
   private static final float f_5124 = 90.0F;

   public int m_2543() {
      return this.f_5119;
   }

   public void m_902() {
      if (f_5909.player != null) {
         Util49.m_3198(f_5909.player.getYaw());
         Util49.m_67(f_5909.player.getPitch());
      }

      this.m_472(null);
      this.m_3964(Util9.cNZoM5LXM6zOvJ8t.IDLE);
      this.m_521(0);
      if (!Util54.m_1085().m_1560() && !Util91.m_1449().m_2381()) {
         Util49.m_2983(false);
      }
   }

   public float m_2671() {
      return this.f_5116;
   }

   public Util9 m_521(int var1) {
      this.f_5117 = var1;
      return this;
   }

   public Util9 m_712(int var1) {
      this.f_5118 = var1;
      return this;
   }

   public Util9.cNZoM5LXM6zOvJ8t m_3985() {
      return this.f_5112;
   }

   public boolean m_1751() {
      return !this.f_5112.equals(Util9.cNZoM5LXM6zOvJ8t.IDLE);
   }

   public Util9 m_2223(float var1) {
      this.f_5116 = var1;
      return this;
   }

   public Util9 m_1708(float var1) {
      this.f_5115 = var1;
      return this;
   }

   public Util9 m_4106(float var1) {
      this.f_5114 = var1;
      return this;
   }

   @EventHandler
   public void m_3637(Util170 var1) {
      if (this.m_3985().equals(Util9.cNZoM5LXM6zOvJ8t.AIM) && this.m_2543() > this.I()) {
         this.m_3964(Util9.cNZoM5LXM6zOvJ8t.RESET);
      }

      if (this.m_3985().equals(Util9.cNZoM5LXM6zOvJ8t.RESET)) {
         this.m_1534();
      }

      this.f_5119++;
   }

   public Util10 m_1923() {
      return this.f_5120;
   }

   private void m_1534() {
      if (f_5909.player == null) {
         this.m_902();
      } else {
         Util10 var1 = new Util10(Util49.m_883(), Util49.m_3811());
         if (this.m_2305(var1, this.m_268(), this.m_2671())) {
            f_5909.player.setYaw(var1.m_2643());
            f_5909.player.setPitch(MathHelper.clamp(var1.m_2573(), f_5121, f_5122));
            Util49.m_3198(f_5909.player.getYaw());
            Util49.m_67(f_5909.player.getPitch());
            this.m_902();
         }
      }
   }

   public static void m_1895(Util10 var0, float var1, float var2, int var3, int var4) {
      m_1981(var0, var1, var1, var2, var2, var3, var4, false);
   }

   public Util9 m_1592(int var1) {
      this.f_5119 = var1;
      return this;
   }

   public Util9 m_3720(float var1) {
      this.f_5113 = var1;
      return this;
   }

   public float m_2658() {
      return this.f_5113;
   }

   public int I() {
      return this.f_5118;
   }

   private boolean m_2305(Util10 var1, float var2, float var3) {
      if (f_5909.player == null) {
         return false;
      } else {
         f_5909.player.setYaw(this.m_3245(f_5909.player.getYaw(), var1.m_2643(), var2));
         f_5909.player.setPitch(MathHelper.clamp(this.m_3245(f_5909.player.getPitch(), var1.m_2573(), var3), f_5123, f_5124));
         this.m_1592(0);
         return new Util10(f_5909.player).m_855(var1) < 1.0F;
      }
   }

   public static Util9 m_3678() {
      return Util85.m_1797(Util9.class);
   }

   public int m_833() {
      return this.f_5117;
   }

   public float m_2497() {
      return this.f_5114;
   }

   public float m_268() {
      return this.f_5115;
   }

   public Util9 m_3964(Util9.cNZoM5LXM6zOvJ8t var1) {
      this.f_5112 = var1;
      return this;
   }

   public static void m_1981(Util10 var0, float var1, float var2, float var3, float var4, int var5, int var6, boolean var7) {
      Util9 var8 = m_3678();
      if (var8.m_833() <= var6) {
         if (var0 == null) {
            var8.m_1708(var3);
            var8.m_2223(var4);
            var8.m_3964(Util9.cNZoM5LXM6zOvJ8t.RESET);
         } else {
            if (var8.m_3985().equals(Util9.cNZoM5LXM6zOvJ8t.IDLE) && !var7) {
               if (f_5909.player != null) {
                  Util49.m_3198(f_5909.player.getYaw());
                  Util49.m_67(f_5909.player.getPitch());
               }

               Util49.m_2983(true);
            }

            var8.m_3720(var1);
            var8.m_4106(var2);
            var8.m_1708(var3);
            var8.m_2223(var4);
            var8.m_712(var5);
            var8.m_521(var6);
            var8.m_3964(Util9.cNZoM5LXM6zOvJ8t.AIM);
            var8.m_472(var0);
            var8.m_2305(var0, var1, var2);
         }
      }
   }

   public Util9 m_472(Util10 var1) {
      this.f_5120 = var1;
      return this;
   }

   private float m_3245(float var1, double var2, float var4) {
      float var5 = (float)MathHelper.wrapDegrees(var2 - var1);
      float var6 = Math.abs(var5 / var4);
      float var7 = var6 * Math.signum(Math.signum(var5));
      if (Math.abs(var7) > Math.abs(var5)) {
         var7 = var5;
      }

      return var1 + Util36.m_569(var7) - Util36.m_569(var7) % Util36.m_399();
   }

   public static enum cNZoM5LXM6zOvJ8t {
      AIM,
      RESET,
      IDLE;
   }
}
