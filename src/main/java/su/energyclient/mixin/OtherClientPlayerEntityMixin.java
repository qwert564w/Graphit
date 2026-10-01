package su.energyclient.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.util.Util143;
import su.energyclient.util.Util41;

@Mixin({OtherClientPlayerEntity.class})
public class OtherClientPlayerEntityMixin extends AbstractClientPlayerEntity implements Util143 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Unique
   private double backUpX;
   @Unique
   private double backUpY;
   @Unique
   private double backUpZ;
   private static final double f_14324 = 0.0;
   private static final double f_14325 = 0.0;
   public OtherClientPlayerEntityMixin(ClientWorld var1, GameProfile var2) {
      super(var1, var2);
   }

   @Override
   public void resolve() {
      this.backUpX = this.getX();
      this.backUpY = this.getY();
      this.backUpZ = this.getZ();
      Vec3d var1 = this.getEntityPos();
      Vec3d var3 = new Vec3d(((Util41)(Object)this).getPrevServerX(), ((Util41)(Object)this).getPrevServerY(), ((Util41)(Object)this).getPrevServerZ());
      Vec3d var4 = new Vec3d(((Util41)(Object)this).getServerX(), ((Util41)(Object)this).getServerY(), ((Util41)(Object)this).getServerZ());
      Vec3d var2;
      if (var1.distanceTo(var3) > var1.distanceTo(var4)) {
         var2 = var4;
      } else {
         var2 = var3;
      }

      this.setPos(var2.x, var2.y, var2.z);
   }

   @Override
   public void releaseResolver() {
      if (this.backUpY != f_14324) {
         this.setPos(this.backUpX, this.backUpY, this.backUpZ);
         this.backUpY = f_14325;
      }
   }

   static {
      VMBridge.identifyClass(OtherClientPlayerEntityMixin.class, "eUSo5XUe");
   }
}
