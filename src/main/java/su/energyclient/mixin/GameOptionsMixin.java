package su.energyclient.mixin;

import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({GameOptions.class})
public class GameOptionsMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @ModifyConstant(
      method = {"<init>"},
      constant = {@Constant(
         intValue = 110
      )}
   )
   private int increaseMaxFov(int var1) {
      return 140;
   }
}
