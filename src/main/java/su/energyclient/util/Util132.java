package su.energyclient.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import su.energyclient.EnergyClient;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Module;
import su.energyclient.module.render.Interface;

public class Util132 extends Util156 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private float f_10520 = 0.0F;
   private final Util165 f_10521;
   private final Map<Module, Util165> f_10522;
   private static final long f_10523 = 200L;
   private static final String f_10524 = "Hotkeys";
   private static final float f_10525 = 23.0F;
   private static final float f_10526 = 18.0F;
   private static final float f_10527 = 0.01F;
   private static final float f_10528 = 15.0F;
   private static final float f_10529 = 10.0F;
   private static final float f_10530 = 8.0F;
   private static final float f_10531 = 0.1F;
   private static final float f_10532 = 10.0F;
   private static final String f_10533 = "p";
   private static final float f_10534 = 5.0F;
   private static final float f_10535 = 7.5F;
   private static final float f_10536 = 17.0F;
   private static final float f_10537 = 7.5F;
   private static final float f_10538 = 0.001F;
   private static final float f_10539 = 255.0F;
   private static final float f_10540 = 20.0F;
   private static final float f_10541 = 0.5F;
   private static final float f_10542 = 19.0F;
   private static final float f_10543 = 16.0F;
   private static final float f_10544 = 10.0F;
   private static final int f_10545 = 1315865;
   private static final float f_10546 = 10.0F;
   private static final float f_10547 = 20.0F;
   private static final float f_10548 = 0.5F;
   private static final float f_10549 = 16.0F;
   private static final float f_10550 = 10.0F;
   private static final int f_10551 = 1315865;
   private static final float f_10552 = 5.0F;
   private static final float f_10553 = 20.0F;
   private static final float f_10554 = 7.0F;
   private static final float f_10555 = 0.5F;
   private static final float f_10556 = 15.0F;
   private static final float f_10557 = 20.0F;
   private static final float f_10558 = 7.0F;
   private static final float f_10559 = 0.5F;
   private static final float f_10560 = 5.0F;
   private static final float f_10561 = 20.0F;
   private static final float f_10562 = 7.0F;
   private static final float f_10563 = 0.5F;
   private static final float f_10564 = 16.5F;
   private static final double f_10565 = 0.001F;
   private static final long f_10566 = 200L;

   private float m_2858(Module var1) {
      return Util93.f_6001[15].m_585(var1.m_1199()) + Util93.f_6001[15].m_585(Util40.m_2030(var1.m_689()));
   }

   @Override
   public void m_4(Util169 var1) {
      DrawContext var2 = var1.m_4037();
      ObjectArrayList<Module> var3 = InitManager.f_2740.f_2741.m_3515();
      float var4 = this.f_10920.m_2838();
      float var5 = this.f_10920.m_671();
      String var6 = f_10524;
      float var7 = Util93.f_6001[16].m_585(var6);
      float var8 = f_10525 + var7;
      float var10 = f_10526;
      this.f_10522.keySet().removeIf(var1x -> !var3.contains(var1x));
      ObjectListIterator var11 = var3.iterator();

      while (var11.hasNext()) {
         Module var12 = (Module)var11.next();
         Util165 var13 = this.f_10522.computeIfAbsent(var12, var0 -> new Util165(Util153.LINEAR, f_10566));
         var13.m_3631(var12.m_689() != -1 && var12.m_677() ? 1.0 : 0.0);
      }

      List<Module> var28 = var3.stream().filter(var1x -> {
         Util165 var2x = this.f_10522.get(var1x);
         return var1x.m_689() != -1 && var2x != null && var2x.m_2276() > f_10565;
      }).sorted(Comparator.comparingDouble(this::m_2858).reversed()).toList();
      boolean var29 = f_5909.currentScreen instanceof ChatScreen || !var28.isEmpty();
      this.f_10521.m_3631(var29 ? 1.0 : 0.0);
      float var30 = (float)this.f_10521.m_2276();
      if (var30 <= f_10527) {
         this.f_10920.m_1597(0.0F);
         this.f_10920.m_1076(0.0F);
      } else {
         float var14 = 0.0F;
         float var15 = 0.0F;

         for (Module var17 : var28) {
            float var18 = Util93.f_6001[15].m_585(var17.m_1199());
            float var19 = Util93.f_6001[15].m_585(Util40.m_2030(var17.m_689()));
            var14 = Math.max(var14, var18);
            var15 = Math.max(var15, var19);
         }

         float var9 = Math.max(var8, f_10528 + var14 + f_10529 + var15 + f_10530);
         this.f_10520 = this.f_10520 + (var9 - this.f_10520) * f_10531;
         Util158.m_3998(var4, var5, this.f_10520, var10, f_10532, Util71.m_756(20, 20, 25, (int)(Interface.m_886(150) * var30)), var30);
         Util93.f_6000[18].m_2915(var2, f_10533, var4 + f_10534, var5 + f_10535, Util71.m_1907(EnergyClient.getTheme(0), var30));
         Util93.f_6001[16].m_2915(var2, var6, var4 + f_10536, var5 + f_10537, Util71.m_1907(-1, var30));
         float var31 = 0.0F;

         for (Module var33 : var28) {
            float var34 = Util93.f_6001[15].m_585(var33.m_1199());
            float var20 = Util93.f_6001[15].m_585(Util40.m_2030(var33.m_689()));
            Util165 var21 = this.f_10522.get(var33);
            float var22 = var21 == null ? 0.0F : (float)var21.m_2276();
            float var23 = var22 * var30;
            if (!(var23 <= f_10538)) {
               int var24 = (int)(var23 * f_10539);
               int var25 = (int)(var23 * Interface.m_886(100));
               Util158.m_3998(var4, var5 + var31 + f_10540 - f_10541, var34 + f_10542, f_10543, f_10544, Util71.m_3389(f_10545, var25), var23);
               float var26 = var20 + f_10546;
               float var27 = var4 + this.f_10520 - var26;
               Util158.m_3998(var27, var5 + var31 + f_10547 - f_10548, var26, f_10549, f_10550, Util71.m_3389(f_10551, var25), var23);
               Util93.f_6000[16]
                  .m_2915(
                     var2, var33.m_2409().m_3343(), var4 + f_10552, var5 + var31 + f_10553 + f_10554 - f_10555, Util71.m_3389(EnergyClient.getTheme(0), var24)
                  );
               Util93.f_6001[15].m_2915(var2, var33.m_1199(), var4 + f_10556, var5 + var31 + f_10557 + f_10558 - f_10559, Util71.m_3389(-1, var24));
               Util93.f_6001[15]
                  .m_2915(var2, Util40.m_2030(var33.m_689()), var27 + f_10560, var5 + var31 + f_10561 + f_10562 - f_10563, Util71.m_3389(-1, var24));
               var31 += var23 * f_10564;
            }
         }

         this.f_10920.m_1597(this.f_10520 * var30);
         this.f_10920.m_1076((var10 + var31) * var30);
      }
   }

   public Util132(Util112 var1) {
      super(var1);
      this.f_10521 = new Util165(Util153.LINEAR, f_10523);
      this.f_10522 = new HashMap<>();
   }
}
