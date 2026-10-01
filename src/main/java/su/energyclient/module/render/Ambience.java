package su.energyclient.module.render;

import java.awt.Color;
import java.time.LocalTime;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents.ClientStopping;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents.Disconnect;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.util.math.MathHelper;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventFogColor;
import su.energyclient.event.impl.EventFogDistance;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util149;
import su.energyclient.util.Util170;
import su.energyclient.util.Util66;

public class Ambience extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static Ambience f_6196;
   public static ModeSetting f_6197 = new ModeSetting(
      Ambience.f_6257,
      Ambience.f_6258,
      Ambience.f_6259,
      Ambience.f_6260,
      Ambience.f_6261,
      Ambience.f_6262,
      Ambience.f_6263,
      Ambience.f_6264,
      Ambience.f_6265,
      Ambience.f_6266
   );
   public static ModeSetting f_6198 = new ModeSetting(Ambience.f_6267, Ambience.f_6268, Ambience.f_6269, Ambience.f_6270, Ambience.f_6271);
   public static NumberSetting f_6199 = new NumberSetting(Ambience.f_6272, 1.0F, Ambience.f_6273, Ambience.f_6274, Ambience.f_6275)
      .m_356(() -> f_6198.m_2073(Ambience.f_6256));
   public static NumberSetting f_6200 = new NumberSetting(Ambience.f_6276, Ambience.f_6277, Ambience.f_6278, Ambience.f_6279, Ambience.f_6280)
      .m_356(() -> f_6198.m_2073(Ambience.f_6255));
   public final BooleanSetting f_6201;
   public final NumberSetting f_6202;
   public final NumberSetting f_6203;
   private final Util149 f_6204;
   private final Vector4f f_6205;
   private boolean f_6206;
   private static final String f_6207 = "Ambience";
   private static final String f_6208 = "Изменяет время суток и туман в мире, создавая нужную атмосферу";
   private static final String f_6209 = "Свечение тумана";
   private static final String f_6210 = "Яркость свечения";
   private static final float f_6211 = 0.9F;
   private static final float f_6212 = 2.5F;
   private static final float f_6213 = 0.05F;
   private static final String f_6214 = "Мягкость свечения";
   private static final float f_6215 = 0.25F;
   private static final float f_6216 = 3.0F;
   private static final float f_6217 = 0.05F;
   private static final String f_6218 = "Очистить";
   private static final String f_6219 = "Очистить";
   private static final float f_6220 = -1000000.0F;
   private static final float f_6221 = 1000000.0F;
   private static final float f_6222 = 1000000.0F;
   private static final String f_6223 = "Не менять";
   private static final String f_6224 = "Не менять";
   private static final String f_6225 = "Время из рельной жизни";
   private static final String f_6226 = "Рассвет";
   private static final String f_6227 = "Утро";
   private static final String f_6228 = "День";
   private static final String f_6229 = "Вечер";
   private static final String f_6230 = "Заход солнца";
   private static final String f_6231 = "Ночь";
   private static final long f_6232 = 23000L;
   private static final long f_6233 = 1000L;
   private static final long f_6234 = 6000L;
   private static final long f_6235 = 12000L;
   private static final long f_6236 = 13000L;
   private static final long f_6237 = 18000L;
   private static final String f_6238 = "Переопределить";
   private static final float f_6239 = 255.0F;
   private static final float f_6240 = 255.0F;
   private static final float f_6241 = 255.0F;
   private static final String f_6242 = "Переопределить";
   private static final float f_6243 = 42.67F;
   private static final float f_6244 = 42.67F;
   private static final float f_6245 = 5.0F;
   private static final String f_6246 = "Очистить";
   private static final float f_6247 = Float.MAX_VALUE;
   private static final int f_6248 = 86400;
   private static final int f_6249 = 86400;
   private static final double f_6250 = 86400.0;
   private static final double f_6251 = 24000.0;
   private static final String f_6252 = "Очистить";
   private static final String f_6253 = "Очистить";
   private static final String f_6254 = "Очистить";
   private static final String f_6255 = "Переопределить";
   private static final String f_6256 = "Переопределить";
   private static final String f_6257 = "Время";
   private static final String f_6258 = "Не менять";
   private static final String f_6259 = "Рассвет";
   private static final String f_6260 = "Утро";
   private static final String f_6261 = "День";
   private static final String f_6262 = "Вечер";
   private static final String f_6263 = "Заход солнца";
   private static final String f_6264 = "Ночь";
   private static final String f_6265 = "Время из рельной жизни";
   private static final String f_6266 = "Не менять";
   private static final String f_6267 = "Туман";
   private static final String f_6268 = "Ничего не делать";
   private static final String f_6269 = "Ничего не делать";
   private static final String f_6270 = "Очистить";
   private static final String f_6271 = "Переопределить";
   private static final String f_6272 = "Конец тумана";
   private static final float f_6273 = 0.1F;
   private static final float f_6274 = 1.5F;
   private static final float f_6275 = 0.1F;
   private static final String f_6276 = "Начало тумана";
   private static final float f_6277 = 0.5F;
   private static final float f_6278 = 0.1F;
   private static final float f_6279 = 1.5F;
   private static final float f_6280 = 0.1F;

   public void m_777(Matrix4f var1, Matrix4f var2, Vector4f var3) {
      if (!this.m_677()
         || !this.f_6201.m_1163()
         || f_6198.m_2073(f_6219)
         || this.f_6202.m_4046() <= 0.0F
         || f_5909.world == null
         || f_5909.player == null
         || f_5909.gameRenderer.isRenderingPanorama()) {
         this.m_1965();
      } else if (this.f_6206) {
         this.f_6206 = false;
         this.f_6204.m_1486(var1, var2, this.f_6205, var3, this.f_6202.m_4046(), this.f_6203.m_4046());
      }
   }

   @EventHandler
   public void m_2438(Util66 var1) {
      if (var1.m_2068() && var1.m_3295() instanceof WorldTimeUpdateS2CPacket && !f_6197.m_2073(f_6223)) {
         var1.m_277(true);
      }
   }

   private void m_1965() {
      this.f_6206 = false;
      this.f_6204.m_2240();
   }

   public void m_3319(float var1, float var2, float var3, float var4) {
      if (this.m_677() && this.f_6201.m_1163() && !f_6198.m_2073(f_6218)) {
         this.f_6205.set(m_3508(var1), m_3508(var2), m_3508(var3), m_3508(var4));
         this.f_6206 = true;
      }
   }

   private long m_767() {
      LocalTime var1 = LocalTime.now();
      int var2 = var1.getHour();
      int var3 = var1.getMinute();
      int var4 = var1.getSecond();
      int var5 = var2 * 3600 + var3 * 60 + var4;
      int var6 = (var5 - 21600) % f_6248;
      if (var6 < 0) {
         var6 += f_6249;
      }

      return (long)(var6 / f_6250 * f_6251);
   }

   @EventHandler
   public void m_457(EventFogColor var1) {
      if (f_6198.m_2073(f_6238)) {
         int var2 = EnergyClient.getTheme(0);
         Color var3 = new Color(var2);
         var1.m_2168(var3.getRed() / f_6239);
         var1.m_2051(var3.getGreen() / f_6240);
         var1.m_2096(var3.getBlue() / f_6241);
      }
   }

   public Ambience() {
      super(f_6207, f_6208, Category.RENDER);
      this.f_6201 = new BooleanSetting(f_6209, false).m_334(() -> !f_6198.m_2073(f_6254));
      this.f_6202 = new NumberSetting(f_6210, f_6211, 0.0F, f_6212, f_6213).m_356(() -> this.f_6201.m_1163() && !f_6198.m_2073(f_6253));
      this.f_6203 = new NumberSetting(f_6214, 1.0F, f_6215, f_6216, f_6217).m_356(() -> this.f_6201.m_1163() && !f_6198.m_2073(f_6252));
      this.f_6204 = new Util149();
      this.f_6205 = new Vector4f();
      f_6196 = this;
      ClientPlayConnectionEvents.DISCONNECT.register((Disconnect)(var1, var2) -> this.m_1965());
      ClientLifecycleEvents.CLIENT_STOPPING.register((ClientStopping)var1 -> this.m_1965());
   }

   private static float m_3508(float var0) {
      return Float.isFinite(var0) ? MathHelper.clamp(var0, f_6220, f_6221) : f_6222;
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_6206 = false;
      this.f_6204.m_1952();
   }

   @EventHandler
   public void m_3603(EventFogDistance var1) {
      if (f_6198.m_2073(f_6242)) {
         float var2 = f_6200.m_4046() * f_6243;
         float var3 = f_6199.m_4046() * f_6244;
         var3 = Math.max(var3, var2 + f_6245);
         var1.m_3355(var2);
         var1.m_3967(var3);
      } else if (f_6198.m_2073(f_6246)) {
         var1.m_3355(0.0F);
         var1.m_3967(f_6247);
      }
   }

   @Override
   public void m_1() {
      this.m_1965();
      super.m_1();
   }

   @EventHandler
   public void m_3776(Util170 var1) {
      if (f_5909.world != null) {
         if (!f_6197.m_2073(f_6224)) {
            long var2;
            if (f_6197.m_2073(f_6225)) {
               var2 = this.m_767();
            } else {
               String var4 = f_6197.m_3862();

               var2 = switch (var4) {
                  case f_6226 -> f_6232;
                  case f_6227 -> f_6233;
                  case f_6228 -> f_6234;
                  case f_6229 -> f_6235;
                  case f_6230 -> f_6236;
                  case f_6231 -> f_6237;
                  default -> f_5909.world.getTimeOfDay();
               };
            }

            ClientWorld var6 = f_5909.world;
            if (var6 instanceof ClientWorld) {
               var6.getLevelProperties().setTimeOfDay(var2);
            }
         }
      }
   }
}
