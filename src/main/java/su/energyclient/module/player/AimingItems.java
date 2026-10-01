package su.energyclient.module.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util152;
import su.energyclient.util.Util166;
import su.energyclient.util.Util170;
import su.energyclient.util.Util63;

public class AimingItems extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Util63 l;
   private Util10 f_6904;
   private ItemEntity f_6905;
   private boolean f_6906;
   private static final String f_6907 = "Aiming Items";
   private static final String f_6908 = "В радиусе прогруженных чанках летит на выбранные предметы";
   private static final String f_6909 = "Наводиться на";
   private static final String f_6910 = "Голову игрока";
   private static final String f_6911 = "Элитру";
   private static final double f_6912 = -1.25;
   private static final float f_6913 = 90.0F;
   private static final float f_6914 = 180.0F;
   private static final float f_6915 = 360.0F;
   private static final float f_6916 = -180.0F;
   private static final float f_6917 = 360.0F;
   private static final float f_6918 = -90.0F;
   private static final float f_6919 = 90.0F;
   private static final String f_6920 = "Голову игрока";
   private static final String f_6921 = "Элитру";

   public AimingItems() {
      super(f_6907, f_6908, Category.PLAYER);
      this.l = new Util63(f_6909, new BooleanSetting(f_6910, true), new BooleanSetting(f_6911, true));
      this.f_6904 = null;
      this.f_6905 = null;
      this.f_6906 = false;
   }

   private Util10 m_1041(ItemEntity var1) {
      if (f_5909.player == null) {
         return new Util10(0.0F, 0.0F);
      } else {
         Vec3d var2 = f_5909.player.getEyePos();
         Vec3d var3 = var1.getEntityPos().add(0.0, f_6912, 0.0);
         Vec3d var4 = var3.subtract(var2);
         double var5 = Math.sqrt(var4.x * var4.x + var4.z * var4.z);
         float var7 = (float)Math.toDegrees(Math.atan2(var4.z, var4.x)) - f_6913;
         float var8 = (float)(-Math.toDegrees(Math.atan2(var4.y, var5)));

         while (var7 > f_6914) {
            var7 -= f_6915;
         }

         while (var7 < f_6916) {
            var7 += f_6917;
         }

         var8 = Math.max(f_6918, Math.min(f_6919, var8));
         return new Util10(var7, var8);
      }
   }

   @EventHandler
   public void m_2487(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         boolean var2 = false;

         for (Entity var4 : f_5909.world.getEntities()) {
            if (var4 instanceof ItemEntity var5 && this.m_344(var5)) {
               this.f_6904 = this.m_1041(var5);
               if (!this.f_6906) {
                  Util152.m_662(
                     Formatting.GREEN
                        + "Предмет найден! "
                        + Formatting.WHITE
                        + "Лечу на предмет "
                        + Formatting.GOLD
                        + var5.getName().getString()
                        + Formatting.RESET
                  );
                  this.f_6906 = true;
               }

               this.f_6905 = var5;
               var2 = true;
               break;
            }
         }

         if (!var2) {
            if (f_5909.player != null) {
               this.f_6904 = new Util10(f_5909.player.getYaw(), f_5909.player.getPitch());
            } else {
               this.f_6904 = null;
            }

            this.f_6905 = null;
            this.f_6906 = false;
         }
      }
   }

   private boolean m_344(ItemEntity var1) {
      Item var2 = var1.getStack().getItem();
      boolean var3 = var2 == Items.PLAYER_HEAD && this.l.I(f_6920);
      boolean var4 = var2 == Items.ELYTRA && this.l.I(f_6921);
      return var3 || var4;
   }

   @Override
   public void m_1() {
      if (f_5909.player != null) {
         this.f_6904 = new Util10(f_5909.player.getYaw(), f_5909.player.getPitch());
      } else {
         this.f_6904 = null;
      }

      this.f_6905 = null;
      this.f_6906 = false;
      super.m_1();
   }

   @EventHandler
   public void m_616(Util166 var1) {
      if (this.f_6905 != null && this.f_6904 != null && f_5909.player != null) {
         f_5909.player.setYaw(this.f_6904.m_2643());
         f_5909.player.setPitch(this.f_6904.m_2573());
      }
   }
}
