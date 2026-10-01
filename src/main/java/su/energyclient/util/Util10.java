package su.energyclient.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector2f;
import su.energyclient.QuickImports;
import su.energyclient.mixin.ClientPlayerEntityMixin2;
import su.energyclient.util.math.MathUtil9;

public class Util10 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_2727;
   private float f_2728;
   private static final float f_2729 = -90.0F;
   private static final float f_2730 = 90.0F;
   private static final float f_2731 = (float) (Math.PI / 180.0);
   private static final float f_2732 = (float) Math.PI;
   private static final float f_2733 = (float) (Math.PI / 180.0);
   private static final float f_2734 = (float) (Math.PI / 180.0);
   private static final float f_2735 = (float) (Math.PI / 180.0);

   private float m_3806(float var1, float var2) {
      return MathHelper.wrapDegrees(var1 - var2);
   }

   public Util10 m_1331(Util10 var1) {
      if (!this.equals(var1)) {
         MathUtil9 var2 = var1.m_3252(this);
         double var3 = Util36.m_2538();
         int var5 = (int)(var2.m_2647() / var3);
         int var6 = (int)(var2.I() / var3);
         return new Util10((float)(var1.m_2643() + var5 * var3), (float)(var1.m_2573() + var6 * var3));
      } else {
         return this;
      }
   }

   public static Vec3d m_2531(float var0, float var1) {
      float var2 = -var1 * f_2731 - f_2732;
      float var3 = -var0 * f_2733;
      float var4 = (float)Math.cos(var2);
      float var5 = (float)Math.sin(var2);
      float var6 = (float)(-Math.cos(var3));
      float var7 = (float)Math.sin(var3);
      return new Vec3d(var5 * var6, var7, var4 * var6);
   }

   public float m_2573() {
      return this.f_2728;
   }

   public void m_3216(float var1) {
      this.f_2727 = var1;
   }

   public Util10(Entity var1) {
      this.f_2727 = var1.getYaw();
      this.f_2728 = var1.getPitch();
   }

   protected boolean m_1851(Object var1) {
      return var1 instanceof Util10;
   }

   public final Vec3d O() {
      float var1 = this.f_2728 * f_2734;
      float var2 = -this.f_2727 * f_2735;
      float var3 = MathHelper.cos(var2);
      float var4 = MathHelper.sin(var2);
      float var5 = MathHelper.cos(var1);
      float var6 = MathHelper.sin(var1);
      return new Vec3d(var4 * var5, -var6, var3 * var5);
   }

   public MathUtil9 m_3252(Util10 var1) {
      return new MathUtil9(this.m_3806(var1.f_2727, this.f_2727), this.m_3806(var1.f_2728, this.f_2728));
   }

   public Util10() {
   }

   @Override
   public String toString() {
      return "Rotation(yaw=" + this.m_2643() + ", pitch=" + this.m_2573() + ")";
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + Float.floatToIntBits(this.m_2643());
      return var2 * 59 + Float.floatToIntBits(this.m_2573());
   }

   public static float m_3218() {
      return (f_5909.gameRenderer.getCamera().isThirdPerson() ? -1 : 1) * f_5909.gameRenderer.getCamera().getPitch();
   }

   public static Util10 m_3601() {
      return new Util10(((ClientPlayerEntityMixin2)f_5909.player).getLastYaw(), ((ClientPlayerEntityMixin2)f_5909.player).getLastPitch());
   }

   public static Vector2f m_2685() {
      return new Vector2f(m_3958(), m_3218());
   }

   public static float m_1722(float var0) {
      return MathHelper.clamp(var0, f_2729, f_2730);
   }

   public float m_2643() {
      return this.f_2727;
   }

   public static Util10 m_2952(Util10 var0, Util10 var1) {
      float var2 = MathHelper.wrapDegrees(var1.m_2643() - var0.m_2643());
      float var3 = MathHelper.wrapDegrees(var1.m_2573() - var0.m_2573());
      return new Util10(var2, var3);
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Util10 var2)) {
         return false;
      } else if (!var2.m_1851(this)) {
         return false;
      } else {
         return Float.compare(this.m_2643(), var2.m_2643()) != 0 ? false : Float.compare(this.m_2573(), var2.m_2573()) == 0;
      }
   }

   public Util10(float var1, float var2) {
      this.f_2727 = var1;
      this.f_2728 = var2;
   }

   public float m_855(Util10 var1) {
      float var2 = MathHelper.wrapDegrees(var1.m_2643() - this.f_2727);
      float var3 = var1.m_2573() - this.f_2728;
      return (float)Math.hypot(Math.abs(var2), Math.abs(var3));
   }

   public void m_1782(float var1) {
      this.f_2728 = var1;
   }

   public static float m_3958() {
      return MathHelper.wrapDegrees(f_5909.gameRenderer.getCamera().getYaw() + (f_5909.gameRenderer.getCamera().isThirdPerson() ? 180 : 0));
   }
}
