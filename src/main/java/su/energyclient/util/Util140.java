package su.energyclient.util;

import java.util.Optional;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import su.energyclient.QuickImports;
import su.energyclient.mixin.ClientPlayerEntityMixin2;
import su.energyclient.mixin.LivingEntityMixin;
import su.energyclient.module.combat.AttackAura;

public final class Util140 implements Util148, QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_11880 = 6;
   private final Util84.MNHgN2rHmi0fQGnX f_11881 = new Util84.MNHgN2rHmi0fQGnX(System.nanoTime() ^ System.currentTimeMillis());
   private boolean f_11882 = true;
   private boolean f_11883;
   private int f_11884;
   private int f_11885;
   private ClientPlayerEntity f_11886;
   private ClientWorld f_11887;
   private Util10 f_11888;
   private static final int f_11889 = Integer.MIN_VALUE;
   private static final int f_11890 = Integer.MIN_VALUE;
   private static final String f_11891 = "Snap";
   private static final double f_11892 = 1.0E-7;
   private static final float f_11893 = 360.0F;
   private static final float f_11894 = 360.0F;
   private static final float f_11895 = 360.0F;
   private static final float f_11896 = 360.0F;
   private static final int f_11897 = Integer.MIN_VALUE;
   private static final int f_11898 = Integer.MIN_VALUE;

   @Override
   public boolean m_13(AttackAura var1, LivingEntity var2) {
      return var1.m_3786()
         ? false
         : f_5909.player == null || var2 == null || var2.getId() != this.f_11885 || !this.f_11883 || !this.m_2384() || !this.m_770(var1, var2);
   }

   private boolean m_4108(Vec3d var1, Vec3d var2) {
      BlockHitResult var3 = f_5909.world.raycast(new RaycastContext(var1, var2, ShapeType.OUTLINE, FluidHandling.NONE, f_5909.player));
      return var3.getType() == Type.MISS || var1.squaredDistanceTo(var2) <= var1.squaredDistanceTo(var3.getPos()) + f_11892;
   }

   @Override
   public void m_5(AttackAura var1, LivingEntity var2) {
   }

   @Override
   public void m_8(AttackAura var1) {
      this.m_1336();
   }

   private Util84.ADLmJDhJTjAJsXY0 m_302() {
      ClientPlayerEntityMixin2 var1 = (ClientPlayerEntityMixin2)f_5909.player;
      return new Util84.ADLmJDhJTjAJsXY0(var1.getLastYaw(), var1.getLastPitch());
   }

   private void m_1336() {
      if (this.m_2384()) {
         Util54.m_2145(null, f_11893, f_11894, f_11895, f_11896, 0, 6, false);
      }

      this.m_3473();
   }

   public Util140() {
      this.f_11884 = f_11889;
      this.f_11885 = f_11890;
   }

   private Util84.ADLmJDhJTjAJsXY0 m_1526(AttackAura var1, LivingEntity var2, Util84.ADLmJDhJTjAJsXY0 var3) {
      Box var4 = var2.getBoundingBox();
      Vec3d var5 = f_5909.player.getEyePos();
      Util84.pMle25VTIq1tj2GU var6 = new Util84.pMle25VTIq1tj2GU(var5.x, var5.y, var5.z);
      Util84.ADLmJDhJTjAJsXY0 var7 = null;
      Util84.ADLmJDhJTjAJsXY0 var8 = null;
      Util84.ADLmJDhJTjAJsXY0 var9 = null;
      double var10 = Double.POSITIVE_INFINITY;
      double var12 = Double.POSITIVE_INFINITY;
      double var14 = Double.POSITIVE_INFINITY;
      boolean var16 = false;

      for (Util84.pMle25VTIq1tj2GU var18 : Util84.m_2738(var4.minX, var4.minY, var4.minZ, var4.maxX, var4.maxY, var4.maxZ)) {
         Vec3d var19 = new Vec3d(var18.x(), var18.y(), var18.z());
         Util84.ADLmJDhJTjAJsXY0 var20 = Util84.m_1594(var6, var18);
         double var21 = Util84.m_1337(var3, var20);
         boolean var23 = this.m_4108(var5, var19);
         var16 |= var23;
         if (var21 < var10) {
            var10 = var21;
            var7 = var20;
         }

         Vec3d var24 = var5.add(var19.subtract(var5).normalize().multiply(var1.m_1837()));
         if (var4.contains(var5) || var4.raycast(var5, var24).isPresent()) {
            if (var21 < var12) {
               var12 = var21;
               var8 = var20;
            }

            if (var23 && var21 < var14) {
               var14 = var21;
               var9 = var20;
            }
         }
      }

      Util84.ADLmJDhJTjAJsXY0 var25 = var16 ? var9 : var8;
      return var25 != null ? var25 : var7;
   }

   @Override
   public String m_3() {
      return f_11891;
   }

   @Override
   public void m_28(AttackAura var1, LivingEntity var2, boolean var3) {
      if (f_5909.player != null && f_5909.world != null && var2 != null) {
         if (this.f_11886 != f_5909.player || this.f_11887 != f_5909.world) {
            this.m_3473();
         }

         if (this.f_11884 != f_5909.player.age || this.f_11885 != var2.getId()) {
            this.f_11884 = f_5909.player.age;
            this.f_11885 = var2.getId();
            this.f_11883 = false;
            Util84.ADLmJDhJTjAJsXY0 var4 = this.m_2159();
            Util84.ADLmJDhJTjAJsXY0 var5 = this.m_302();
            Util84.ADLmJDhJTjAJsXY0 var6 = this.f_11882 && !var3 ? var4 : this.m_1526(var1, var2, var5);
            int var7 = ((LivingEntityMixin)f_5909.player).getTicksSinceLastAttack();
            double var8 = (Double)f_5909.options.getMouseSensitivity().getValue();
            Util84.ADLmJDhJTjAJsXY0 var10 = Util84.m_1073(var5, this.f_11882 ? var4 : var6, var4.yaw(), this.f_11882, var7, var8, this.f_11881);
            if (var3) {
               this.f_11882 = false;
               var10 = Util84.m_1073(var5, var6, var4.yaw(), false, var7, var8, this.f_11881);
            } else {
               this.f_11882 = true;
            }

            Util10 var11 = new Util10(var10.yaw(), var10.pitch());
            if (Util54.m_1111(var11, 1, 6)) {
               this.f_11888 = var11;
               this.f_11883 = var3;
            }
         }
      }
   }

   private void m_3473() {
      this.f_11882 = true;
      this.f_11883 = false;
      this.f_11884 = f_11897;
      this.f_11885 = f_11898;
      this.f_11886 = f_5909.player;
      this.f_11887 = f_5909.world;
      this.f_11888 = null;
   }

   private boolean m_2384() {
      Util54 var1 = Util54.m_1085();
      return this.f_11888 != null && var1.m_2266() == 6 && var1.m_340() == this.f_11888;
   }

   @Override
   public void m_6(AttackAura var1) {
      this.m_1336();
   }

   @Override
   public void m_11(AttackAura var1) {
      this.m_3473();
   }

   private boolean m_770(AttackAura var1, LivingEntity var2) {
      Vec3d var3 = f_5909.player.getEyePos();
      Vec3d var4 = var3.add(f_5909.player.getRotationVector().multiply(var1.m_1837()));
      if (var2.getBoundingBox().contains(var3)) {
         return true;
      } else {
         Optional var5 = var2.getBoundingBox().raycast(var3, var4);
         return var5.isPresent() && (var1.m_90().m_1163() || this.m_4108(var3, (Vec3d)var5.get()));
      }
   }

   private Util84.ADLmJDhJTjAJsXY0 m_2159() {
      return Util49.m_2511()
         ? new Util84.ADLmJDhJTjAJsXY0(Util49.m_883(), Util49.m_3811())
         : new Util84.ADLmJDhJTjAJsXY0(f_5909.player.getYaw(), f_5909.player.getPitch());
   }
}
