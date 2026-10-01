package su.energyclient.module.render;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.awt.Color;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util11;
import su.energyclient.util.Util114;
import su.energyclient.util.Util158;
import su.energyclient.util.Util169;
import su.energyclient.util.Util38;
import su.energyclient.util.Util63;
import su.energyclient.util.Util71;
import su.energyclient.util.Util82;
import su.energyclient.util.Util93;
import su.energyclient.util.Util98;
import su.energyclient.util.math.MathUtil4;

public class Triangle extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Identifier f_3990 = Identifier.of(Triangle.f_4040, Triangle.f_4041);
   private static final int f_3991 = 10;
   protected static final MinecraftClient f_3992 = MinecraftClient.getInstance();
   public final NumberSetting f_3993;
   public final NumberSetting f_3994;
   private final BooleanSetting f_3995;
   private final Util63 f_3996;
   private final Util82 f_3997;
   private final Util82 f_3998;
   private final Util82 f_3999;
   private final Util82 f_4000;
   private final List<Triangle.YcKI6lBsjxo9ByXH> f_4001;
   private int f_4002;
   private static final String f_4003 = "Triangle";
   private static final String f_4004 = "Дистанция от прицела";
   private static final float f_4005 = 25.0F;
   private static final float f_4006 = 50.0F;
   private static final String f_4007 = "Размер стрелки";
   private static final float f_4008 = 1.5F;
   private static final float f_4009 = 0.1F;
   private static final String f_4010 = "Информация";
   private static final String f_4011 = "Отображать";
   private static final String f_4012 = "Никнеймы";
   private static final String f_4013 = "Дистанцию";
   private static final float f_4014 = 20.0F;
   private static final float f_4015 = 90.0F;
   private static final float f_4016 = 6.0F;
   private static final String f_4017 = "Никнеймы";
   private static final float f_4018 = 20.0F;
   private static final String f_4019 = "Дистанцию";
   private static final float f_4020 = 20.0F;
   private static final float f_4021 = 5.0F;
   private static final double f_4022 = 0.75;
   private static final float f_4023 = 5.0F;
   private static final double f_4024 = 0.75;
   private static final double f_4025 = 0.75;
   private static final float f_4026 = 35.0F;
   private static final float f_4027 = 80.0F;
   private static final float f_4028 = 20.0F;
   private static final float f_4029 = 10.0F;
   private static final long f_4030 = 200L;
   private static final double f_4031 = Math.PI / 180.0;
   private static final double f_4032 = 180.0;
   private static final double f_4033 = Math.PI;
   private static final int f_4034 = 33085;
   private static final int f_4035 = 33082;
   private static final int f_4036 = 33083;
   private static final int f_4037 = 34049;
   private static final int f_4038 = 33071;
   private static final int f_4039 = 33071;
   private static final String f_4040 = "energy";
   private static final String f_4041 = "images/esp/triangle.png";

   private float m_2071(PlayerEntity var1, float var2) {
      Camera var3 = f_3992.gameRenderer.getCamera();
      if (var3 == null) {
         return 0.0F;
      } else {
         double var4 = MathHelper.lerp(var2, var1.lastX, var1.getX()) - var3.getCameraPos().getX();
         double var6 = MathHelper.lerp(var2, var1.lastZ, var1.getZ()) - var3.getCameraPos().getZ();
         double var8 = this.f_4000.m_979() * f_4031;
         double var10 = MathHelper.cos((float)var8);
         double var12 = MathHelper.sin((float)var8);
         double var14 = -(var6 * var10 - var4 * var12);
         double var16 = -(var4 * var10 + var6 * var12);
         return (float)(Math.atan2(var14, var16) * f_4032 / f_4033);
      }
   }

   @EventHandler
   public void m_1022(Util169 var1) {
      if (f_3992.player != null && f_3992.world != null) {
         DrawContext var2 = var1.m_4037();
         float var3 = var1.m_4119();
         this.m_2239();
         float var4 = this.m_286();
         this.f_3997.m_1803(var4, 1.0, Util11.f_2949, false);
         List var5 = this.m_115();
         this.m_3267(var5);
         this.f_4001.clear();
         this.f_4001.addAll(var5);
         float var6 = f_3992.getWindow().getScaledWidth() / 2.0F;
         float var7 = f_3992.getWindow().getScaledHeight() / 2.0F;

         for (Triangle.YcKI6lBsjxo9ByXH var9 : this.f_4001) {
            PlayerEntity var10 = var9.f_586;
            if (this.m_1257(var10)) {
               float var11 = this.m_2071(var10, var3);
               float var12 = var9.f_587.m_1698();
               float var13 = (float)(this.f_3997.m_979() * var12);
               float var14 = var13 * MathHelper.cos((float)Math.toRadians(var11)) + var6;
               float var15 = var13 * MathHelper.sin((float)Math.toRadians(var11)) + var7;
               var14 += (float)this.f_3998.m_979();
               var15 += (float)this.f_3999.m_979();
               int var16 = EnergyClient.getTheme(90);
               boolean var17 = InitManager.f_2740.f_2744.m_2704(var10.getGameProfile().name());
               int var18 = var17 ? Color.GREEN.getRGB() : Util71.m_1907(var16, var12);
               int var19 = Util71.m_1907(-1, var12);
               float var20 = f_4014 * this.f_3994.m_134().floatValue();
               var2.getMatrices().pushMatrix();
               var2.getMatrices().translate(var14, var15);
               var2.getMatrices().pushMatrix();
               var2.getMatrices().rotate((float)Math.toRadians(var11 + f_4015));
               this.m_3564(var2, 0.0F, 0.0F, var20, var18);
               var2.getMatrices().popMatrix();
               if (this.f_3995.m_1163()) {
                  float var21 = var20 / 2.0F - f_4016;
                  if (this.f_3996.I(f_4017)) {
                     Util93.f_6001[13].m_765(var2, var10.getName().getString(), 0.0, -var21 + f_4018, var19);
                  }

                  if (this.f_3996.I(f_4019)) {
                     Util93.f_6001[13].m_765(var2, (int)f_3992.player.distanceTo(var10) + "m", 0.0, var21 - f_4020, var19);
                  }
               }

               var2.getMatrices().popMatrix();
            }
         }
      }
   }

   private boolean m_1257(PlayerEntity var1) {
      return var1 != f_3992.player;
   }

   public Triangle() {
      super(f_4003, "", Category.RENDER);
      this.f_3993 = new NumberSetting(f_4004, f_4005, 1.0F, f_4006, 1.0F);
      this.f_3994 = new NumberSetting(f_4007, 1.0F, 1.0F, f_4008, f_4009);
      this.f_3995 = new BooleanSetting(f_4010, true);
      this.f_3996 = new Util63(f_4011, new BooleanSetting(f_4012, true), new BooleanSetting(f_4013, false).m_334(this.f_3995::m_1163));
      this.f_3997 = new Util82();
      this.f_3998 = new Util82();
      this.f_3999 = new Util82();
      this.f_4000 = new Util82();
      this.f_4001 = new ArrayList<>();
      this.f_4002 = -1;
   }

   private void m_1798() {
      AbstractTexture var1 = f_3992.getTextureManager().getTexture(f_3990);
      if (var1 != null) {
         int var2 = Util98.m_1819(var1);
         if (var2 > 0 && var2 != this.f_4002) {
            Util114.m_2012(var2);
            GlStateManager._texParameter(3553, f_4034, 10);
            GlStateManager._texParameter(3553, f_4035, 0);
            GlStateManager._texParameter(3553, f_4036, 10);
            GL11.glTexParameterf(3553, f_4037, 0.0F);
            GlStateManager._texParameter(3553, 10242, f_4038);
            GlStateManager._texParameter(3553, 10243, f_4039);
            GL30.glGenerateMipmap(3553);
            GL11.glTexParameteri(3553, 10241, 9987);
            GL11.glTexParameteri(3553, 10240, 9729);
            this.f_4002 = var2;
         }
      }
   }

   private void m_3267(List<Triangle.YcKI6lBsjxo9ByXH> var1) {
      for (Triangle.YcKI6lBsjxo9ByXH var3 : new ArrayList<>(this.f_4001)) {
         boolean var4 = var1.stream().anyMatch(var1x -> var1x.m_2902() == var3.m_2902());
         if (!var4) {
            var3.m_1828().m_203(false);
            if (!var3.m_1828().m_2897()) {
               var1.add(var3);
            }
         }
      }
   }

   private void m_3564(DrawContext var1, float var2, float var3, float var4, int var5) {
      float var6 = var4 / 2.0F;
      Util158.m_3024(var1.getMatrices(), f_3990, var2 - var6, var3 - var6, var4, var4, new Color(var5, true));
      this.m_1798();
   }

   private float m_286() {
      float var1 = f_4026 + this.f_3993.m_134().floatValue();
      if (f_3992.currentScreen instanceof InventoryScreen) {
         var1 += f_4027;
      }

      if (f_3992.player.isSneaking()) {
         var1 -= f_4028;
      }

      if (Util38.m_469()) {
         var1 += f_4029;
      }

      return var1;
   }

   private void m_2239() {
      this.f_3997.m_1596();
      this.f_3998.m_1596();
      this.f_3999.m_1596();
      this.f_4000.m_1596();
      this.f_3998.m_1285(f_3992.player.sidewaysSpeed * f_4021, f_4022, Util11.f_2949);
      this.f_3999.m_1285(f_3992.player.forwardSpeed * f_4023, f_4024, Util11.f_2949);
      this.f_4000.m_1803(f_3992.gameRenderer.getCamera().getYaw(), f_4025, Util11.f_2949, true);
   }

   private List<Triangle.YcKI6lBsjxo9ByXH> m_115() {
      ArrayList var1 = new ArrayList();

      for (AbstractClientPlayerEntity var3 : f_3992.world.getPlayers()) {
         Optional<Triangle.YcKI6lBsjxo9ByXH> var4 = this.f_4001.stream().filter(var1x -> var1x.m_2902() == var3).findFirst();
         if (!var4.isPresent() || this.m_1257(var3)) {
            Triangle.YcKI6lBsjxo9ByXH var5 = new Triangle.YcKI6lBsjxo9ByXH(
               var3, var4.map(Triangle.YcKI6lBsjxo9ByXH::m_1828).orElse(new MathUtil4(1.0F, Duration.ofMillis(f_4030)))
            );
            var1.add(var5);
         }
      }

      return var1;
   }

   private static class YcKI6lBsjxo9ByXH {
      private final PlayerEntity f_586;
      private final MathUtil4 f_587;

      public YcKI6lBsjxo9ByXH(PlayerEntity var1, MathUtil4 var2) {
         this.f_586 = var1;
         this.f_587 = var2;
      }

      public PlayerEntity m_2902() {
         return this.f_586;
      }

      public MathUtil4 m_1828() {
         return this.f_587;
      }
   }
}
