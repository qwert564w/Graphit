package su.energyclient.util;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardEntry;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import su.energyclient.EnergyClient;
import su.energyclient.manager.InitManager;
import su.energyclient.module.render.Interface;

public class Util115 extends Util156 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private PlayerEntity f_13115;
   private final Util165 f_13116;
   private float f_13117;
   private float f_13118;
   private static final long f_13119 = 200L;
   private static final float f_13120 = 95.0F;
   private static final float f_13121 = 41.0F;
   private static final float f_13122 = 20.0F;
   private static final float f_13123 = 5.0F;
   private static final float f_13124 = 5.0F;
   private static final float f_13125 = 95.0F;
   private static final float f_13126 = 41.0F;
   private static final float f_13127 = 20.0F;
   private static final int f_13128 = 1315865;
   private static final float f_13129 = 5.0F;
   private static final float f_13130 = 5.0F;
   private static final float f_13131 = 25.0F;
   private static final float f_13132 = 25.0F;
   private static final float f_13133 = 5.0F;
   private static final float f_13134 = 5.0F;
   private static final float f_13135 = 32.0F;
   private static final float f_13136 = 85.0F;
   private static final float f_13137 = 4.5F;
   private static final float f_13138 = 0.25F;
   private static final float f_13139 = 0.25F;
   private static final float f_13140 = 0.25F;
   private static final float f_13141 = 0.3F;
   private static final float f_13142 = 5.0F;
   private static final float f_13143 = 32.0F;
   private static final float f_13144 = 85.0F;
   private static final float f_13145 = 4.5F;
   private static final float f_13146 = 0.25F;
   private static final float f_13147 = 0.25F;
   private static final float f_13148 = 5.0F;
   private static final float f_13149 = 32.0F;
   private static final float f_13150 = 85.0F;
   private static final float f_13151 = 4.5F;
   private static final float f_13152 = 0.25F;
   private static final float f_13153 = 0.25F;
   private static final float f_13154 = 34.0F;
   private static final float f_13155 = 10.5F;
   private static final float f_13156 = 38.0F;
   private static final float f_13157 = 34.0F;
   private static final float f_13158 = 21.0F;
   private static final float f_13159 = 95.0F;
   private static final float f_13160 = 41.0F;

   public Util115(Util112 var1) {
      super(var1);
      this.f_13116 = new Util165(Util153.LINEAR, f_13119);
   }

   @Override
   public void m_4(Util169 var1) {
      DrawContext var2 = var1.m_4037();
      float var3 = this.f_10920.m_2838();
      float var4 = this.f_10920.m_671();
      float var5 = f_13120;
      float var6 = f_13121;
      this.f_13115 = this.m_4033(this.f_13115);
      if (this.f_13115 != null) {
         float var7 = this.f_13115.getHealth();
         float var8 = this.f_13115.getMaxHealth();
         if (InitManager.f_2740.f_2741.fixhp.m_677()) {
            Scoreboard var9 = f_5909.world.getScoreboard();
            ScoreboardObjective var10 = var9.getObjectiveForSlot(ScoreboardDisplaySlot.BELOW_NAME);
            if (var10 != null) {
               String var11 = this.f_13115.getName().getString();
               boolean var12 = false;

               for (ScoreboardEntry var14 : var9.getScoreboardEntries(var10)) {
                  if (var14.owner().equals(var11)) {
                     var7 = var14.value();
                     var12 = true;
                     break;
                  }
               }

               if (!var12 || var7 <= 0.0F) {
                  var7 = f_13122;
               }

               var8 = Math.max(this.f_13115.getMaxHealth(), var7);
            } else {
               var7 = this.f_13115.getHealth();
               var8 = this.f_13115.getMaxHealth();
            }
         }

         var8 = Math.max(var8, 1.0F);
         this.f_13117 = Util39.m_3959(this.f_13117, var7 / var8, f_13123);
         this.f_13117 = MathHelper.clamp(this.f_13117, 0.0F, 1.0F);
         this.f_13118 = Util39.m_3959(this.f_13118, this.f_13115.getAbsorptionAmount() / var8, f_13124);
         this.f_13118 = MathHelper.clamp(this.f_13118, 0.0F, 1.0F);
         Util158.m_3998(var3, var4, f_13125, f_13126, f_13127, Util71.m_3389(f_13128, Interface.m_886(150)), (float)this.f_13116.m_2276());
         Identifier var16;
         if (this.f_13115 instanceof AbstractClientPlayerEntity) {
            var16 = ((AbstractClientPlayerEntity)this.f_13115).getSkin().body().texturePath();
         } else {
            var16 = DefaultSkinHelper.getTexture();
         }

         double var17 = Util39.m_2261(this.f_13117 * var8, 1.0F);
         double var18 = Util39.m_2261(this.f_13118 * var8, 1.0F);
         Util158.m_4005(var16, this.f_13115, var3 + f_13129, var4 + f_13130, f_13131, f_13132, f_13133, (float)this.f_13116.m_2276());
         Util158.m_3404(
            var3 + f_13134,
            var4 + f_13135,
            f_13136,
            f_13137,
            1.0F,
            Util71.m_2101(EnergyClient.getTheme(0), f_13138),
            Util71.m_2101(EnergyClient.getTheme(0), f_13139),
            Util71.m_2101(EnergyClient.getTheme(0), f_13140),
            Util71.m_2101(EnergyClient.getTheme(0), f_13141),
            (float)this.f_13116.m_2276()
         );
         Util158.m_3404(
            var3 + f_13142,
            var4 + f_13143,
            f_13144 * this.f_13117,
            f_13145,
            1.0F,
            Util71.m_2101(EnergyClient.getTheme(0), f_13146),
            Util71.m_2101(EnergyClient.getTheme(0), f_13147),
            EnergyClient.getTheme(0),
            EnergyClient.getTheme(0),
            (float)this.f_13116.m_2276()
         );
         Util158.m_3404(
            var3 + f_13148,
            var4 + f_13149,
            f_13150 * this.f_13118,
            f_13151,
            1.0F,
            Util71.m_2101(Util71.m_1415(250, 199, 32), f_13152),
            Util71.m_2101(Util71.m_1415(250, 199, 32), f_13153),
            Util71.m_1415(250, 199, 32),
            Util71.m_1415(250, 199, 32),
            (float)this.f_13116.m_2276()
         );
         Util93.f_6001[16]
            .m_1904(var2, this.f_13115.getName().getString(), var3 + f_13154, var4 + f_13155, Util71.m_1907(-1, (float)this.f_13116.m_2276()), f_13156);
         Util93.f_6001[15]
            .m_2915(
               var2,
               "HP: " + var17 + (this.f_13115.getAbsorptionAmount() > 0.0F ? " (" + var18 + ")" : ""),
               var3 + f_13157,
               var4 + f_13158,
               Util71.m_1907(-1, (float)this.f_13116.m_2276())
            );
         this.f_10920.m_1597(f_13159);
         this.f_10920.m_1076(f_13160);
      }
   }

   private PlayerEntity m_4033(PlayerEntity var1) {
      Object var2 = var1;
      if (InitManager.f_2740.f_2741.attackAura.m_891() instanceof PlayerEntity) {
         var2 = (PlayerEntity)InitManager.f_2740.f_2741.attackAura.m_891();
         this.f_13116.m_3631(1.0);
      } else if (f_5909.currentScreen instanceof ChatScreen) {
         var2 = f_5909.player;
         this.f_13116.m_3631(1.0);
      } else {
         this.f_13116.m_3631(0.0);
      }

      return (PlayerEntity)var2;
   }
}
