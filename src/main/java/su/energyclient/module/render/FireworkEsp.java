package su.energyclient.module.render;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector2f;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil25;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util125;
import su.energyclient.util.Util158;
import su.energyclient.util.Util169;
import su.energyclient.util.Util66;
import su.energyclient.util.Util71;
import su.energyclient.util.Util93;
import su.energyclient.util.math.MathUtil10;

public class FireworkEsp extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BooleanSetting f_13164;
   private final List<FireworkEsp.Inner_7w50xzoqFUWtIQyy> f_13165;
   private static final String f_13166 = "Firework ESP";
   private static final String f_13167 = "Показывает тег на позиции использованного фейерверка";
   private static final String f_13168 = "Отображать время";
   private static final float f_13169 = Float.MAX_VALUE;
   private static final float f_13170 = Float.MAX_VALUE;
   private static final float f_13171 = 20.0F;
   private static final String f_13172 = "%.1f сек.";
   private static final long f_13173 = 5000L;
   private static final double f_13174 = 1000.0;
   private static final float f_13175 = 15.5F;
   private static final float f_13176 = 10.0F;
   private static final float f_13177 = 11.0F;
   private static final float f_13178 = 120.0F;
   private static final float f_13179 = 0.5F;
   private static final float f_13180 = 1.5F;
   private static final float f_13181 = 0.5F;
   private static final float f_13182 = 11.0F;
   private static final float f_13183 = 4.0F;
   private static final float f_13184 = 255.0F;
   private static final long f_13185 = 5000L;
   private static final double f_13186 = 25.0;

   public FireworkEsp() {
      super(f_13166, f_13167, Category.RENDER);
      this.f_13164 = new BooleanSetting(f_13168, true);
      this.f_13165 = new CopyOnWriteArrayList<>();
   }

   @Override
   public void m_1() {
      this.f_13165.clear();
      super.m_1();
   }

   @EventHandler
   public void m_1343(Util169 var1) {
      if (f_5909.player != null && f_5909.world != null && !this.f_13165.isEmpty()) {
         this.f_13165.removeIf(var0 -> {
            long var10000x = var0.f_4928.m_1913();
            Objects.requireNonNull(var0);
            if (var10000x >= f_13185) {
               if (!var0.f_4930) {
                  var0.m_2156();
               }

               return var0.m_1650();
            } else {
               return false;
            }
         });

         for (FireworkEsp.Inner_7w50xzoqFUWtIQyy var3 : this.f_13165) {
            Vector2f var4 = MathUtil10.m_2788(var3.f_4927.x, var3.f_4927.y, var3.f_4927.z, false);
            if (var4.x != f_13169 && var4.y != f_13170) {
               float var5 = var3.m_1595();
               float var6 = var4.x - f_13171;
               float var7 = var4.y;
               String var10000 = f_13172;
               Object[] var10001 = new Object[1];
               Objects.requireNonNull(var3);
               var10001[0] = Math.max(0.0, (f_13173 - var3.f_4928.m_1913()) / f_13174);
               String var8 = String.format(var10000, var10001);
               float var9 = Util93.f_6001[14].m_585(var8);
               float var10 = this.f_13164.m_1163() ? var9 + f_13175 : f_13176;
               RenderUtil25.m_1557(var1.m_4037(), var6, var7, var10, f_13177, Util71.m_756(0, 0, 0, (int)(f_13178 * var5)));
               Util158.m_1974(var1.m_4037(), new ItemStack(Items.FIREWORK_ROCKET), var6 + f_13179, var7 + f_13180, f_13181, -1, var5);
               if (this.f_13164.m_1163()) {
                  Util93.f_6001[14].m_2915(var1.m_4037(), var8, var6 + f_13182, var7 + f_13183, Util71.m_756(255, 255, 255, (int)(f_13184 * var5)));
               }
            }
         }
      }
   }

   @EventHandler
   public void m_4105(Util66 var1) {
      if (var1.m_2068()) {
         if (var1.m_3295() instanceof PlaySoundS2CPacket var2) {
            RegistryEntry var5 = var2.getSound();
            if (var2.getCategory() == SoundCategory.AMBIENT && var5.value() == SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH) {
               Vec3d var4 = new Vec3d(var2.getX(), var2.getY(), var2.getZ());
               if (this.f_13165.stream().filter(FireworkEsp.Inner_7w50xzoqFUWtIQyy::m_1087).noneMatch(var1x -> var4.squaredDistanceTo(var1x.f_4927) <= f_13186)
                  )
                {
                  this.f_13165.add(new FireworkEsp.Inner_7w50xzoqFUWtIQyy(var4));
               }
            }
         }
      }
   }

   private static class Inner_7w50xzoqFUWtIQyy {
      final Vec3d f_4927;
      final Util125 f_4928 = new Util125();
      final long f_4929;
      boolean f_4930;
      long f_4931;
      private static final long f_4932 = 5000L;
      private static final float f_4933 = 1000.0F;
      private static final float f_4934 = 0.1F;

      float m_1595() {
         return !this.f_4930 ? 1.0F : Math.max(0.0F, 1.0F - Math.min(1.0F, (float)(System.currentTimeMillis() - this.f_4931) / f_4933));
      }

      Inner_7w50xzoqFUWtIQyy(Vec3d var1) {
         this.f_4929 = f_4932;
         this.f_4927 = var1;
      }

      void m_2156() {
         this.f_4930 = true;
         this.f_4931 = System.currentTimeMillis();
      }

      boolean m_1087() {
         return !this.f_4930 || this.m_1595() > f_4934;
      }

      boolean m_1650() {
         return this.f_4930 && this.m_1595() <= 0.0F;
      }
   }
}
