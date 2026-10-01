package su.energyclient.util;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.PlayerListEntry;
import su.energyclient.EnergyClient;
import su.energyclient.module.render.Interface;
import su.energyclient.render.RenderUtil25;

public class Util144 extends Util156 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_11793 = 22.0F;
   private static final float f_11794 = 0.0F;
   private static final float f_11795 = 0.0F;
   private static final float f_11796 = 0.0F;
   private static final float f_11797 = 0.0F;
   private static final float f_11798 = 0.0F;
   private static final float f_11799 = 0.0F;
   private static final String f_11800 = "";
   private static final String f_11801 = "";
   private final Util165 f_11802;
   private boolean f_11803;
   private static final long f_11804 = 200L;
   private static final String f_11805 = "m";
   private static final String f_11806 = "t";
   private static final String f_11807 = "FPS";
   private static final String f_11808 = "u";
   private static final String f_11809 = "MS";
   private static final float f_11810 = 12.0F;
   private static final float f_11811 = 3.0F;
   private static final float f_11812 = 22.0F;
   private static final float f_11813 = 14.0F;
   private static final int f_11814 = 1315865;
   private static final float f_11815 = 6.0F;
   private static final String f_11816 = "m";
   private static final String f_11817 = "t";
   private static final String f_11818 = "FPS";
   private static final String f_11819 = "u";
   private static final String f_11820 = "MS";
   private static final float f_11821 = 22.0F;
   private static final String f_11822 = "a";
   private static final float f_11823 = 4.0F;
   private static final String f_11824 = "Energy";
   private static final String f_11825 = "1.21.11";
   private static final float f_11826 = 4.0F;
   private static final float f_11827 = 12.5F;
   private static final String f_11828 = "a";
   private static final float f_11829 = 9.25F;
   private static final String f_11830 = "a";
   private static final float f_11831 = 4.0F;
   private static final String f_11832 = "Energy";
   private static final float f_11833 = 9.5F;
   private static final String f_11834 = "Energy";
   private static final String f_11835 = "1.21.11";
   private static final float f_11836 = 10.0F;
   private static final int f_11837 = -4869442;
   private static final String f_11838 = "1.21.11";
   private static final float f_11839 = 9.25F;
   private static final float f_11840 = 4.0F;
   private static final float f_11841 = 9.5F;
   private static final float f_11842 = 10.0F;
   private static final int f_11843 = -4869442;
   private static final float f_11844 = 6.0F;
   private static final float f_11845 = 6.0F;
   private static final float f_11846 = 0.5F;
   private static final float f_11847 = 10.0F;
   private static final float f_11848 = 0.5F;
   private static final float f_11849 = 6.0F;

   private void m_1670(float var1) {
      long var2 = System.currentTimeMillis();
      this.f_11802.m_2214(var1);
      this.f_11802.m_2946(var1);
      this.f_11802.m_1829(var1);
      this.f_11802.m_1876(var2);
      this.f_11802.m_1066(var2);
      this.f_11802.l(true);
   }

   private float m_2645(DrawContext var1, float var2, float var3) {
      Util93.f_6000[18].m_2915(var1, f_11828, var2, var3 + f_11829, EnergyClient.getTheme(0));
      var2 += Util93.f_6000[18].m_585(f_11830) + f_11831;
      Util93.f_6003[15].m_2915(var1, f_11832, var2, var3 + f_11833, -1);
      var2 += Util93.f_6003[15].m_585(f_11834) + 2.0F;
      Util93.f_6001[13].m_2915(var1, f_11835, var2, var3 + f_11836, f_11837);
      return var2 + Util93.f_6001[13].m_585(f_11838);
   }

   public Util144(Util112 var1) {
      super(var1);
      this.f_11802 = new Util165(Util153.EASE_OUT_CUBIC, f_11804);
   }

   @Override
   public void m_4(Util169 var1) {
      if (f_5909.player == null) {
         this.f_11803 = false;
         this.f_10920.m_1597(0.0F);
         this.f_10920.m_1076(0.0F);
      } else {
         DrawContext var2 = var1.m_4037();
         float var3 = this.f_10920.m_2838();
         float var4 = this.f_10920.m_671();
         PlayerListEntry var5 = f_5909.player.networkHandler.getPlayerListEntry(f_5909.player.getUuid());
         int var6 = var5 != null ? var5.getLatency() : 0;
         String var7 = Util90.f_5919;
         String var8 = Integer.toString(f_5909.getCurrentFps());
         String var9 = Integer.toString(var6);
         float var10 = this.m_2569();
         float var11 = this.m_758(f_11805, var7, "");
         float var12 = this.m_758(f_11806, var8, f_11807);
         float var13 = this.m_758(f_11808, var9, f_11809);
         float var14 = f_11810 + var10 + var11 + var12 + var13 + this.m_2898() * f_11811;
         float var15 = this.m_412(var14);
         if (Interface.m_886(255) > 0) {
            Util158.m_3998(var3, var4, var15, f_11812, f_11813, Util71.m_3389(f_11814, Interface.m_886(150)), 1.0F);
         }

         float var16 = var3 + f_11815;
         var16 = this.m_2645(var2, var16, var4);
         var16 = this.m_1374(var2, var16, var4);
         var16 = this.m_3078(var2, var16, var4, f_11816, var7, "");
         var16 = this.m_1374(var2, var16, var4);
         var16 = this.m_3078(var2, var16, var4, f_11817, var8, f_11818);
         var16 = this.m_1374(var2, var16, var4);
         this.m_3078(var2, var16, var4, f_11819, var9, f_11820);
         this.f_10920.m_1597(var15);
         this.f_10920.m_1076(f_11821);
      }
   }

   private float m_2898() {
      return f_11827;
   }

   private float m_3078(DrawContext var1, float var2, float var3, String var4, String var5, String var6) {
      Util93.f_6000[18].m_2915(var1, var4, var2, var3 + f_11839, EnergyClient.getTheme(0));
      var2 += Util93.f_6000[18].m_585(var4) + f_11840;
      Util93.f_6001[15].m_2915(var1, var5, var2, var3 + f_11841, -1);
      var2 += Util93.f_6001[15].m_585(var5);
      if (!var6.isEmpty()) {
         var2 += 2.0F;
         Util93.f_6001[13].m_2915(var1, var6, var2, var3 + f_11842, f_11843);
         var2 += Util93.f_6001[13].m_585(var6);
      }

      return var2;
   }

   private float m_1374(DrawContext var1, float var2, float var3) {
      var2 += f_11844;
      if (Interface.m_886(255) > 0) {
         int var4 = Util71.m_756(122, 122, 122, Interface.m_886(100));
         RenderUtil25.m_3752(var1, var2, var3 + f_11845, f_11846, f_11847, var4, var4, var4, var4);
      }

      return var2 + f_11848 + f_11849;
   }

   private float m_758(String var1, String var2, String var3) {
      float var4 = Util93.f_6000[18].m_585(var1) + f_11826 + Util93.f_6001[15].m_585(var2);
      if (!var3.isEmpty()) {
         var4 += 2.0F + Util93.f_6001[13].m_585(var3);
      }

      return var4;
   }

   private float m_2569() {
      return Util93.f_6000[18].m_585(f_11822) + f_11823 + Util93.f_6003[15].m_585(f_11824) + 2.0F + Util93.f_6001[13].m_585(f_11825);
   }

   private float m_412(float var1) {
      if (this.f_11803 && !(var1 > this.f_11802.m_2276())) {
         this.f_11802.m_3631(var1);
         return Math.max(var1, (float)this.f_11802.m_2276());
      } else {
         this.m_1670(var1);
         this.f_11803 = true;
         return var1;
      }
   }
}
