package su.energyclient.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.EnergyClient;
import su.energyclient.event.impl.EventPlaceBlock;

@Mixin({Block.class})
public class BlockMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Inject(
      method = {"onPlaced"},
      at = {@At("HEAD")}
   )
   private void onPlaced(World var1, BlockPos var2, BlockState var3, LivingEntity var4, ItemStack var5, CallbackInfo var6) {
      if (var1.isClient() && var4 == MinecraftClient.getInstance().player && var3.isOf(Blocks.OBSIDIAN)) {
         EnergyClient.f_1622.f_1624.m_30(new EventPlaceBlock(var3.getBlock(), var2.toImmutable()));
      }
   }
}
