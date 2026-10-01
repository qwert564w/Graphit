package su.energyclient.manager.impl;

import java.awt.Color;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.command.impl.GpsCommand;
import su.energyclient.event.EventHandler;
import su.energyclient.render.RenderUtil25;
import su.energyclient.util.Util158;
import su.energyclient.util.Util169;
import su.energyclient.util.Util93;

public class AccountManager implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_11870 = 60.0F;
   private static final double f_11871 = 180.0;
   private static final double f_11872 = 2.0;
   private static final double f_11873 = 2.0;
   private static final float f_11874 = 155.0F;
   private static final float f_11875 = 6.0F;
   private static final float f_11876 = 90.0F;
   private static final String f_11877 = "energy";
   private static final String f_11878 = "images/esp/arrow_gps.png";
   private static final float f_11879 = 21.0F;

   public AccountManager() {
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   @EventHandler
   public void m_1392(Util169 var1) {
      if (GpsCommand.f_1379 && f_5909.player != null) {
         RenderUtil25.m_2716(var1.m_4037());
         float var2 = f_11870;
         float var3 = (float)(
            Math.toDegrees(Math.atan2(GpsCommand.f_1381 - f_5909.player.getZ(), GpsCommand.f_1380 - f_5909.player.getX())) - f_5909.player.getYaw() - f_11871
         );
         int var4 = (int)Math.sqrt(Math.pow(GpsCommand.f_1380 - f_5909.player.getX(), f_11872) + Math.pow(GpsCommand.f_1381 - f_5909.player.getZ(), f_11873));
         int var5 = f_5909.getWindow().getScaledWidth();
         int var6 = f_5909.getWindow().getScaledHeight();
         float var7 = (var5 - var2) / 2.0F;
         float var8 = var6 / 2.0F - f_11874;
         MatrixStack var9 = new MatrixStack();
         var9.push();
         var9.translate(var7 + var2 / 2.0F, var8 + var2 / f_11875, 0.0F);
         var9.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var3 + f_11876));
         var9.translate(-var2 / 2.0F, -var2 / 2.0F, 0.0F);
         Util158.m_1000(var9, Identifier.of(f_11877, f_11878), 0.0, 0.0, var2, var2, new Color(-1));
         var9.pop();
         String var10 = var4 + "m";
         float var11 = Util93.f_6003[14].m_585(var10);
         float var12 = var7 + var2 / 2.0F;
         float var13 = var8 + f_11879;
         float var14 = var12 - var11 / 2.0F;
         Util93.f_6003[14].m_2915(var1.m_4037(), var10, var14, var13, -1);
         RenderUtil25.m_2848();
      }
   }
}
