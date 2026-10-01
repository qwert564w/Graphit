package su.energyclient.util;

import net.minecraft.util.math.MathHelper;
import su.energyclient.event.EventHandler;

public class Util54 extends Util31 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Util54.qN3BdDWeCOfQ39UG f_8036 = Util54.qN3BdDWeCOfQ39UG.IDLE;
   private float f_8037;
   private float f_8038;
   private float f_8039;
   private float f_8040;
   private int f_8041;
   private int f_8042;
   private int f_8043;
   private Util10 f_8044;
   private static final float f_8045 = -90.0F;
   private static final float f_8046 = 90.0F;
   private static final float f_8047 = 360.0F;
   private static final float f_8048 = 360.0F;
   private static final float f_8049 = 360.0F;
   private static final float f_8050 = 360.0F;
   private static final float f_8051 = -90.0F;
   private static final float f_8052 = 90.0F;
   private static final float f_8053 = -90.0F;
   private static final float f_8054 = 90.0F;
   private static final float f_8055 = -90.0F;
   private static final float f_8056 = 90.0F;

   private boolean m_1002(Util10 var1, float var2, float var3) {
      if (f_5909.player == null) {
         return false;
      } else {
         Util10 var4 = new Util10(f_5909.player);
         float var5 = MathHelper.wrapDegrees(var1.m_2643() - var4.m_2643());
         float var6 = var1.m_2573() - var4.m_2573();
         float var7 = Math.min(Math.abs(var5), var2);
         float var8 = Math.min(Math.abs(var6), var3);
         f_5909.player
            .setYaw(
               f_5909.player.getYaw() + Util36.m_569(MathHelper.clamp(var5, -var7, var7)) - Util36.m_569(MathHelper.clamp(var5, -var7, var7)) % Util36.m_399()
            );
         f_5909.player
            .setPitch(
               MathHelper.clamp(f_5909.player.getPitch() + Util36.m_569(MathHelper.clamp(var6, -var8, var8)), f_8053, f_8054)
                  - MathHelper.clamp(f_5909.player.getPitch() + Util36.m_569(MathHelper.clamp(var6, -var8, var8)), f_8055, f_8056) % Util36.m_399()
            );
         this.m_3520(0);
         return new Util10(f_5909.player).m_855(var1) < 1.0F;
      }
   }

   public Util54 m_3379(int var1) {
      this.f_8042 = var1;
      return this;
   }

   public void m_2951() {
      if (f_5909.player != null) {
         Util49.m_3198(f_5909.player.getYaw());
         Util49.m_67(f_5909.player.getPitch());
      }

      this.m_492(null);
      this.m_3093(Util54.qN3BdDWeCOfQ39UG.IDLE);
      this.m_2736(0);
      if (!Util9.m_3678().m_1751() && !Util91.m_1449().m_2381()) {
         Util49.m_2983(false);
      }
   }

   private void m_3504() {
      if (f_5909.player == null) {
         this.m_2951();
      } else {
         Util10 var1 = new Util10(Util49.m_883(), Util49.m_3811());
         if (this.m_1002(var1, this.m_380(), this.m_942())) {
            f_5909.player.setYaw(var1.m_2643());
            f_5909.player.setPitch(MathHelper.clamp(var1.m_2573(), f_8045, f_8046));
            Util49.m_3198(f_5909.player.getYaw());
            Util49.m_67(f_5909.player.getPitch());
            this.m_2951();
         }
      }
   }

   public float m_101() {
      return this.f_8038;
   }

   public static boolean m_1111(Util10 var0, int var1, int var2) {
      if (var0 != null && f_5909.player != null) {
         Util54 var3 = m_1085();
         if (!var3.m_2830(var0, f_8047, f_8048, f_8049, f_8050, var1, var2, false)) {
            return false;
         } else {
            f_5909.player.setYaw(var0.m_2643());
            f_5909.player.setPitch(MathHelper.clamp(var0.m_2573(), f_8051, f_8052));
            var3.m_3520(0);
            return true;
         }
      } else {
         return false;
      }
   }

   public Util54 m_280(float var1) {
      this.f_8038 = var1;
      return this;
   }

   private boolean m_2830(Util10 var1, float var2, float var3, float var4, float var5, int var6, int var7, boolean var8) {
      if (this.m_2266() > var7) {
         return false;
      } else if (var1 == null) {
         this.m_1753(var4);
         this.m_215(var5);
         this.m_3093(Util54.qN3BdDWeCOfQ39UG.RESET);
         return false;
      } else {
         if (this.m_813().equals(Util54.qN3BdDWeCOfQ39UG.IDLE) && !var8) {
            if (f_5909.player != null) {
               Util49.m_3198(f_5909.player.getYaw());
               Util49.m_67(f_5909.player.getPitch());
            }

            Util49.m_2983(true);
         }

         this.m_3255(var2);
         this.m_280(var3);
         this.m_1753(var4);
         this.m_215(var5);
         this.m_3379(var6);
         this.m_2736(var7);
         this.m_3093(Util54.qN3BdDWeCOfQ39UG.AIM);
         this.m_492(var1);
         return true;
      }
   }

   public Util54 m_492(Util10 var1) {
      this.f_8044 = var1;
      return this;
   }

   public boolean m_1560() {
      return !this.f_8036.equals(Util54.qN3BdDWeCOfQ39UG.IDLE);
   }

   @EventHandler
   public void m_1100(Util172 var1) {
      if (this.m_813().equals(Util54.qN3BdDWeCOfQ39UG.AIM) && this.m_2817() > this.m_3779()) {
         this.m_3093(Util54.qN3BdDWeCOfQ39UG.RESET);
      }

      if (this.m_813().equals(Util54.qN3BdDWeCOfQ39UG.RESET)) {
         this.m_3504();
      }

      this.f_8043++;
   }

   public static void m_2498(Util10 var0, float var1, float var2, int var3, int var4) {
      m_2145(var0, var1, var1, var2, var2, var3, var4, false);
   }

   public Util54 m_215(float var1) {
      this.f_8040 = var1;
      return this;
   }

   public float m_380() {
      return this.f_8039;
   }

   public Util54 m_3520(int var1) {
      this.f_8043 = var1;
      return this;
   }

   public Util54 m_3255(float var1) {
      this.f_8037 = var1;
      return this;
   }

   public int m_2266() {
      return this.f_8041;
   }

   public Util10 m_340() {
      return this.f_8044;
   }

   public int m_2817() {
      return this.f_8043;
   }

   public float m_2109() {
      return this.f_8037;
   }

   public Util54 m_2736(int var1) {
      this.f_8041 = var1;
      return this;
   }

   public int m_3779() {
      return this.f_8042;
   }

   public static void m_2145(Util10 var0, float var1, float var2, float var3, float var4, int var5, int var6, boolean var7) {
      Util54 var8 = m_1085();
      if (var8.m_2830(var0, var1, var2, var3, var4, var5, var6, var7)) {
         var8.m_1002(var0, var1, var2);
      }
   }

   public float m_942() {
      return this.f_8040;
   }

   public Util54 m_3093(Util54.qN3BdDWeCOfQ39UG var1) {
      this.f_8036 = var1;
      return this;
   }

   public Util54.qN3BdDWeCOfQ39UG m_813() {
      return this.f_8036;
   }

   public Util54 m_1753(float var1) {
      this.f_8039 = var1;
      return this;
   }

   public static void m_3501(Util10 var0, float var1, int var2, int var3) {
      m_2498(var0, var1, var1, var2, var3);
   }

   public static Util54 m_1085() {
      return Util85.m_1797(Util54.class);
   }

   public static enum qN3BdDWeCOfQ39UG {
      AIM,
      RESET,
      IDLE;
   }
}
