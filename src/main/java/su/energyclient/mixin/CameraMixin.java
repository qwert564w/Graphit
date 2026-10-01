package su.energyclient.mixin;

import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({Camera.class})
public interface CameraMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Invoker("setRotation")
   void invokeSetRotation(float var1, float var2);

   @Invoker("setPos")
   void invokeSetPos(Vec3d var1);
}
