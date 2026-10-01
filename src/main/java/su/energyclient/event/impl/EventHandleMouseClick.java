package su.energyclient.event.impl;

import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import su.energyclient.event.Event;

public class EventHandleMouseClick extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Slot f_7078;
   private int f_7079;
   private int f_7080;
   private SlotActionType f_7081;

   public SlotActionType m_2348() {
      return this.f_7081;
   }

   public void m_4089(int var1) {
      this.f_7079 = var1;
   }

   public Slot m_1480() {
      return this.f_7078;
   }

   public EventHandleMouseClick(Slot var1, int var2, int var3, SlotActionType var4) {
      this.f_7078 = var1;
      this.f_7079 = var2;
      this.f_7080 = var3;
      this.f_7081 = var4;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventHandleMouseClick var2)) {
         return false;
      } else if (!var2.m_3937(this)) {
         return false;
      } else if (this.m_1424() != var2.m_1424()) {
         return false;
      } else if (this.Ol() != var2.Ol()) {
         return false;
      } else {
         Slot var3 = this.m_1480();
         Slot var4 = var2.m_1480();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            SlotActionType var5 = this.m_2348();
            SlotActionType var6 = var2.m_2348();
            return var5 == null ? var6 == null : var5.equals(var6);
         } else {
            return false;
         }
      }
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + this.m_1424();
      var2 = var2 * 59 + this.Ol();
      Slot var3 = this.m_1480();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      SlotActionType var4 = this.m_2348();
      return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
   }

   public void m_3075(Slot var1) {
      this.f_7078 = var1;
   }

   @Override
   public String toString() {
      return "EventHandleMouseClick(slotIn=" + this.m_1480() + ", slotId=" + this.m_1424() + ", mouseButton=" + this.Ol() + ", type=" + this.m_2348() + ")";
   }

   public int m_1424() {
      return this.f_7079;
   }

   public int Ol() {
      return this.f_7080;
   }

   public void m_966(int var1) {
      this.f_7080 = var1;
   }

   public void m_3536(SlotActionType var1) {
      this.f_7081 = var1;
   }

   protected boolean m_3937(Object var1) {
      return var1 instanceof EventHandleMouseClick;
   }
}
