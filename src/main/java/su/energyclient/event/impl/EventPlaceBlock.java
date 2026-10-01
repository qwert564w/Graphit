package su.energyclient.event.impl;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import su.energyclient.event.Event;

public class EventPlaceBlock extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Block f_1411;
   private final BlockPos f_1412;

   public Block m_2404() {
      return this.f_1411;
   }

   protected boolean m_3736(Object var1) {
      return var1 instanceof EventPlaceBlock;
   }

   public BlockPos m_1421() {
      return this.f_1412;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      Block var3 = this.m_2404();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      BlockPos var4 = this.m_1421();
      return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
   }

   @Override
   public String toString() {
      return "EventPlaceBlock(block=" + this.m_2404() + ", pos=" + this.m_1421() + ")";
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventPlaceBlock var2)) {
         return false;
      } else if (!var2.m_3736(this)) {
         return false;
      } else {
         Block var3 = this.m_2404();
         Block var4 = var2.m_2404();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            BlockPos var5 = this.m_1421();
            BlockPos var6 = var2.m_1421();
            return var5 == null ? var6 == null : var5.equals(var6);
         } else {
            return false;
         }
      }
   }

   public EventPlaceBlock(Block var1, BlockPos var2) {
      this.f_1411 = var1;
      this.f_1412 = var2;
   }
}
