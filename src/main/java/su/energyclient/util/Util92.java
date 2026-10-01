package su.energyclient.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import su.energyclient.event.Event;

public class Util92 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BlockState f_6055;
   private final BlockPos f_6056;
   private final Util92.eYP5T39eaGw7jwf1 f_6057;

   public Util92.eYP5T39eaGw7jwf1 m_3685() {
      return this.f_6057;
   }

   public Util92(BlockState var1, BlockPos var2, Util92.eYP5T39eaGw7jwf1 var3) {
      this.f_6055 = var1;
      this.f_6056 = var2;
      this.f_6057 = var3;
   }

   public BlockState m_1818() {
      return this.f_6055;
   }

   public BlockPos m_2696() {
      return this.f_6056;
   }

   public static enum eYP5T39eaGw7jwf1 {
      START_DESTROY_BLOCK,
      STOP_DESTROY_BLOCK;
   }
}
