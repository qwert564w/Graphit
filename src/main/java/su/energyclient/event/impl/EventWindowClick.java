package su.energyclient.event.impl;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.sync.ItemStackHash;
import su.energyclient.event.Event;

public class EventWindowClick extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private int f_3904;
   private int f_3905;
   private short f_3906;
   private byte f_3907;
   private SlotActionType f_3908;
   private ItemStackHash f_3909;
   private Int2ObjectMap<ItemStackHash> f_3910;

   public byte m_1602() {
      return this.f_3907;
   }

   public void m_691(Int2ObjectMap<ItemStackHash> var1) {
      this.f_3910 = var1;
   }

   public void m_2141(short var1) {
      this.f_3906 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventWindowClick var2)) {
         return false;
      } else if (!var2.m_2493(this)) {
         return false;
      } else if (this.m_1366() != var2.m_1366()) {
         return false;
      } else if (this.m_1064() != var2.m_1064()) {
         return false;
      } else if (this.m_1550() != var2.m_1550()) {
         return false;
      } else if (this.m_1602() != var2.m_1602()) {
         return false;
      } else {
         SlotActionType var3 = this.m_396();
         SlotActionType var4 = var2.m_396();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            ItemStackHash var5 = this.m_1729();
            ItemStackHash var6 = var2.m_1729();
            if (var5 == null ? var6 == null : var5.equals(var6)) {
               Int2ObjectMap var7 = this.m_2662();
               Int2ObjectMap var8 = var2.m_2662();
               return var7 == null ? var8 == null : var7.equals(var8);
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   public int m_1366() {
      return this.f_3904;
   }

   protected boolean m_2493(Object var1) {
      return var1 instanceof EventWindowClick;
   }

   public ItemStackHash m_1729() {
      return this.f_3909;
   }

   public EventWindowClick(int var1, int var2, short var3, byte var4, SlotActionType var5, ItemStackHash var6, Int2ObjectMap<ItemStackHash> var7) {
      this.f_3904 = var1;
      this.f_3905 = var2;
      this.f_3906 = var3;
      this.f_3907 = var4;
      this.f_3908 = var5;
      this.f_3909 = var6;
      this.f_3910 = var7;
   }

   public void m_2309(ItemStackHash var1) {
      this.f_3909 = var1;
   }

   public int m_1064() {
      return this.f_3905;
   }

   public void m_358(SlotActionType var1) {
      this.f_3908 = var1;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + this.m_1366();
      var2 = var2 * 59 + this.m_1064();
      var2 = var2 * 59 + this.m_1550();
      var2 = var2 * 59 + this.m_1602();
      SlotActionType var3 = this.m_396();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      ItemStackHash var4 = this.m_1729();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      Int2ObjectMap var5 = this.m_2662();
      return var2 * 59 + (var5 == null ? 43 : var5.hashCode());
   }

   public void m_290(int var1) {
      this.f_3904 = var1;
   }

   public Int2ObjectMap<ItemStackHash> m_2662() {
      return this.f_3910;
   }

   public void m_2165(byte var1) {
      this.f_3907 = var1;
   }

   public short m_1550() {
      return this.f_3906;
   }

   public void m_3121(int var1) {
      this.f_3905 = var1;
   }

   @Override
   public String toString() {
      return "EventWindowClick(pContainerId="
         + this.m_1366()
         + ", pStateId="
         + this.m_1064()
         + ", pSlotNum="
         + this.m_1550()
         + ", pButtonNum="
         + this.m_1602()
         + ", pClickType="
         + this.m_396()
         + ", pCarriedItem="
         + this.m_1729()
         + ", pChangedSlots="
         + this.m_2662()
         + ")";
   }

   public SlotActionType m_396() {
      return this.f_3908;
   }
}
