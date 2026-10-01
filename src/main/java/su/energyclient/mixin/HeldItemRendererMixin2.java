package su.energyclient.mixin;

import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({HeldItemRenderer.class})
public interface HeldItemRendererMixin2 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Invoker("applyEquipOffset")
   void invokeApplyEquipOffset(MatrixStack var1, Arm var2, float var3);

   @Invoker("applySwingOffset")
   void invokeApplySwingOffset(MatrixStack var1, Arm var2, float var3);
}
