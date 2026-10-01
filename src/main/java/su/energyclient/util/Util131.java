package su.energyclient.util;

import java.util.ArrayDeque;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.util.Hand;
import su.energyclient.QuickImports;
import su.energyclient.module.miscellaneous.ObsidianFarm;

public class Util131 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ObsidianFarm f_10625;
   public boolean f_10626 = false;
   private long f_10627 = 0L;
   private final long f_10628;
   private final ArrayDeque<Runnable> f_10629;
   private static final String f_10630 = "Команда";
   private static final long f_10631 = 5000L;
   private static final String f_10632 = "/fix";
   private static final String f_10633 = "Опыт в хотбаре не найден, отключение...";
   private static final long f_10634 = 100L;
   private static final long f_10635 = 100L;
   private static final float f_10636 = 90.0F;

   public Util131(ObsidianFarm var1) {
      this.f_10628 = f_10635;
      this.f_10629 = new ArrayDeque<>();
      this.f_10625 = var1;
   }

   public void m_2967() {
      Runnable var1 = this.f_10629.poll();
      if (var1 != null) {
         var1.run();
      }
   }

   public void m_3293() {
      Runnable var1;
      while ((var1 = this.f_10629.poll()) != null) {
         var1.run();
      }
   }

   public void m_2139() {
      ItemStack var1 = f_5909.player.getMainHandStack();
      Integer var2 = (Integer)var1.get(DataComponentTypes.DAMAGE);
      if (var2 != null && var2 >= 200) {
         this.f_10626 = true;
         if (this.f_10625.f_11072.m_2073(f_10630)) {
            long var5 = System.currentTimeMillis();
            if (var5 - this.f_10627 >= f_10631) {
               this.f_10627 = var5;
               this.f_10625.m_74(f_10632);
            }
         } else {
            int var3 = this.f_10625.f_11059.m_3382(Items.EXPERIENCE_BOTTLE);
            if (var3 == -1) {
               this.f_10625.m_3314(f_10633);
               this.f_10625.m_680();
            } else {
               if (this.f_10629.isEmpty() && System.currentTimeMillis() - this.f_10627 > f_10634) {
                  this.f_10629.add(() -> {
                     this.f_10625.f_11059.m_3891();
                     this.f_10627 = System.currentTimeMillis();
                  });
                  this.f_10629.add(() -> {
                     this.f_10625.f_11059.m_2540(var3);
                     f_5909.player.networkHandler.sendPacket(new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, f_5909.player.getYaw(), f_10636));
                     this.f_10627 = System.currentTimeMillis();
                  });
                  this.f_10629.add(() -> {
                     this.f_10625.f_11059.m_3891();
                     this.f_10627 = System.currentTimeMillis();
                  });
               }
            }
         }
      } else {
         this.f_10626 = false;
      }
   }
}
