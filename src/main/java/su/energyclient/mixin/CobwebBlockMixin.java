package su.energyclient.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CobwebBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.util.Util38;
import su.energyclient.util.Util94;

@Mixin({CobwebBlock.class})
public class CobwebBlockMixin implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"onEntityCollision"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onEntityCollision(BlockState var1, World var2, BlockPos var3, Entity var4, EntityCollisionHandler var5, boolean var6, CallbackInfo var7) {
      if (var4 == f_5909.player) {
         Util94 var8 = EnergyClient.f_1622.f_1624.m_30(new Util94(var3));
         if (var8.m_2244()) {
            var7.cancel();
         } else {
            Util38.f_7823 = true;
         }
      }
   }
}
