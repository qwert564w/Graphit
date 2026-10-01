package su.energyclient.util;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.MathHelper;

public class Util29 extends OtherClientPlayerEntity {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final double f_3456 = 180.0 / Math.PI;
   private static final double f_3457 = 90.0;

   protected void tickCramming() {
   }

   private float damageYaw(DamageSource var1) {
      Entity var2 = var1.getAttacker();
      if (var2 == null) {
         return this.getYaw();
      } else {
         double var3 = var2.getX() - this.getX();
         double var5 = var2.getZ() - this.getZ();
         return (float)(MathHelper.atan2(var5, var3) * f_3456 - f_3457);
      }
   }

   public boolean collidesWith(Entity var1) {
      return false;
   }

   public void healFully() {
      this.setHealth(this.getMaxHealth());
   }

   public boolean isPushable() {
      return false;
   }

   public void takeLocalHit(DamageSource var1, float var2) {
      this.onDamaged(var1);
      this.animateDamage(this.damageYaw(var1));
      float var3 = this.getHealth() - Math.max(0.0F, var2);
      this.setHealth(var3 > 0.0F ? var3 : this.getMaxHealth());
   }

   public void pushAwayFrom(Entity var1) {
   }

   public Util29(ClientWorld var1, GameProfile var2) {
      super(var1, var2);
   }
}
