package su.energyclient.event.impl;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import su.energyclient.event.Event;

public class EventClickBlockRight extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ClientPlayerEntity f_12559;
   private final ClientWorld f_12560;
   private final Hand f_12561;
   private final BlockHitResult f_12562;

   public ClientPlayerEntity m_1697() {
      return this.f_12559;
   }

   public Hand m_2117() {
      return this.f_12561;
   }

   public ClientWorld m_85() {
      return this.f_12560;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      ClientPlayerEntity var3 = this.m_1697();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      ClientWorld var4 = this.m_85();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      Hand var5 = this.m_2117();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      BlockHitResult var6 = this.m_3080();
      return var2 * 59 + (var6 == null ? 43 : var6.hashCode());
   }

   public BlockHitResult m_3080() {
      return this.f_12562;
   }

   protected boolean m_214(Object var1) {
      return var1 instanceof EventClickBlockRight;
   }

   public EventClickBlockRight(ClientPlayerEntity var1, ClientWorld var2, Hand var3, BlockHitResult var4) {
      this.f_12559 = var1;
      this.f_12560 = var2;
      this.f_12561 = var3;
      this.f_12562 = var4;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventClickBlockRight var2)) {
         return false;
      } else if (!var2.m_214(this)) {
         return false;
      } else {
         ClientPlayerEntity var3 = this.m_1697();
         ClientPlayerEntity var4 = var2.m_1697();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            ClientWorld var5 = this.m_85();
            ClientWorld var6 = var2.m_85();
            if (var5 == null ? var6 == null : var5.equals(var6)) {
               Hand var7 = this.m_2117();
               Hand var8 = var2.m_2117();
               if (var7 == null ? var8 == null : var7.equals(var8)) {
                  BlockHitResult var9 = this.m_3080();
                  BlockHitResult var10 = var2.m_3080();
                  return var9 == null ? var10 == null : var9.equals(var10);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   @Override
   public String toString() {
      return "EventClickBlockRight(player=" + this.m_1697() + ", world=" + this.m_85() + ", hand=" + this.m_2117() + ", result=" + this.m_3080() + ")";
   }
}
