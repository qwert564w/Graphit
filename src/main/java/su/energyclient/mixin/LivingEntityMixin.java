package su.energyclient.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({LivingEntity.class})
public interface LivingEntityMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Accessor("ticksSinceLastAttack")
   int getTicksSinceLastAttack();

   @Accessor("jumpingCooldown")
   void setJumpCooldown(int var1);

   @Invoker("getEffectiveGravity")
   double invokeGetEffectiveGravity();
}
