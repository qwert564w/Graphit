package su.energyclient.event.impl;

import su.energyclient.event.Event;

public class EventNoRender extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final EventNoRender.fRxH5AVi9McS5OZn f_800;

   public EventNoRender.fRxH5AVi9McS5OZn m_3456() {
      return this.f_800;
   }

   public EventNoRender(EventNoRender.fRxH5AVi9McS5OZn var1) {
      this.f_800 = var1;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      EventNoRender.fRxH5AVi9McS5OZn var3 = this.m_3456();
      return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
   }

   protected boolean I(Object var1) {
      return var1 instanceof EventNoRender;
   }

   @Override
   public String toString() {
      return "EventNoRender(norenderType=" + this.m_3456() + ")";
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof EventNoRender var2)) {
         return false;
      } else if (!var2.I(this)) {
         return false;
      } else {
         EventNoRender.fRxH5AVi9McS5OZn var3 = this.m_3456();
         EventNoRender.fRxH5AVi9McS5OZn var4 = var2.m_3456();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }

   public static enum fRxH5AVi9McS5OZn {
      fire,
      bossbar,
      scoreboard,
      title,
      totem,
      hurttime,
      fishingrod,
      destroyparticles,
      rain,
      shadows,
      smoke,
      vignette,
      arrows,
      players,
      bad_effects,
      underwater_blur,
      container_background,
      lava,
      cameraclip,
      glowing;
   }
}
