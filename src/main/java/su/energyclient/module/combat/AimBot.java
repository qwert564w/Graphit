package su.energyclient.module.combat;

import java.util.ArrayList;
import java.util.Comparator;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.AttributeModifiersComponent.Entry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util12;
import su.energyclient.util.Util164;
import su.energyclient.util.Util170;
import su.energyclient.util.Util36;
import su.energyclient.util.Util54;
import su.energyclient.util.Util63;

public class AimBot extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_888;
   private final NumberSetting f_889;
   private final ModeSetting f_890;
   private final Util63 f_891;
   private final Util63 f_892;
   private final BooleanSetting f_893;
   private LivingEntity f_894;
   private static final String f_895 = "Aim Bot";
   private static final String f_896 = "Aims at players while charging bow/trident";
   private static final String f_897 = "Дистанция";
   private static final float f_898 = 55.0F;
   private static final float f_899 = 3.0F;
   private static final float f_900 = 140.0F;
   private static final float f_901 = 0.5F;
   private static final String f_902 = "Скорость наводки";
   private static final float f_903 = 360.0F;
   private static final float f_904 = 30.0F;
   private static final float f_905 = 360.0F;
   private static final float f_906 = 5.0F;
   private static final String f_907 = "Приоритет";
   private static final String f_908 = "Оптимальный";
   private static final String f_909 = "Оптимальный";
   private static final String f_910 = "Дистанция";
   private static final String f_911 = "Здоровье";
   private static final String f_912 = "Угол поворота";
   private static final String f_913 = "Оружие";
   private static final String f_914 = "Лук";
   private static final String f_915 = "Трезубец";
   private static final String f_916 = "Цели";
   private static final String f_917 = "Голые";
   private static final String f_918 = "Друзья";
   private static final String f_919 = "Только видимые";
   private static final float f_920 = 180.0F;
   private static final float f_921 = 180.0F;
   private static final String f_922 = "Дистанция";
   private static final String f_923 = "Здоровье";
   private static final String f_924 = "Угол поворота";
   private static final String f_925 = "Друзья";
   private static final String f_926 = "Голые";
   private static final String f_927 = "Лук";
   private static final float f_928 = 0.1F;
   private static final float f_929 = 3.0F;
   private static final double f_930 = 0.05F;
   private static final String f_931 = "Трезубец";
   private static final double f_932 = 2.5;
   private static final double f_933 = 0.05F;
   private static final double f_934 = 0.01F;
   private static final double f_935 = 3.0;
   private static final double f_936 = 1.0E-4;
   private static final double f_937 = 90.0;
   private static final double f_938 = -89.0;
   private static final double f_939 = 89.0;
   private static final double f_940 = 1.0E-4;
   private static final double f_941 = 3.0;
   private static final double f_942 = 0.7;
   private static final double f_943 = 0.35;
   private static final double f_944 = 1.6;
   private static final double f_945 = 2.0;
   private static final double f_946 = Double.MAX_VALUE;
   private static final double f_947 = 3.0;
   private static final double f_948 = 2.0;
   private static final double f_949 = 1.5;
   private static final double f_950 = 5.0;
   private static final double f_951 = 3.0;
   private static final float f_952 = 6.0F;
   private static final double f_953 = 5.0;
   private static final double f_954 = 2.0;
   private static final double f_955 = 2.0;
   private static final double f_956 = 90.0;
   private static final double f_957 = 0.5;
   private static final double f_958 = 0.25;
   private static final double f_959 = 0.15;
   private static final double f_960 = 0.15;
   private static final double f_961 = 0.15;
   private static final double f_962 = 25.0;

   private boolean m_2184() {
      return this.m_661() != null;
   }

   public AimBot() {
      super(f_895, f_896, Category.COMBAT);
      this.f_888 = new NumberSetting(f_897, f_898, f_899, f_900, f_901);
      this.f_889 = new NumberSetting(f_902, f_903, f_904, f_905, f_906);
      this.f_890 = new ModeSetting(f_907, f_908, f_909, f_910, f_911, f_912);
      this.f_891 = new Util63(f_913, new BooleanSetting(f_914, true), new BooleanSetting(f_915, true));
      this.f_892 = new Util63(f_916, new BooleanSetting(f_917, true), new BooleanSetting(f_918, false));
      this.f_893 = new BooleanSetting(f_919, false);
   }

   public ModeSetting m_2757() {
      return this.f_890;
   }

   private AimBot.I8J4BINi4IKWm4zZ m_661() {
      if (f_5909.player != null && f_5909.player.isUsingItem()) {
         ItemStack var1 = f_5909.player.getActiveItem();
         if (var1 != null && !var1.isEmpty()) {
            Item var2 = var1.getItem();
            if (var2 instanceof BowItem) {
               if (!this.f_891.I(f_927)) {
                  return null;
               } else {
                  float var3 = BowItem.getPullProgress(f_5909.player.getItemUseTime());
                  var3 = Math.max(var3, f_928);
                  return new AimBot.I8J4BINi4IKWm4zZ((double)(f_929 * var3), f_930);
               }
            } else if (!(var2 instanceof TridentItem)) {
               return null;
            } else {
               return !this.f_891.I(f_931) ? null : new AimBot.I8J4BINi4IKWm4zZ(f_932, f_933);
            }
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @Override
   public void m_1() {
      super.m_1();
      this.f_894 = null;
      Util54.m_2498(null, f_920, f_921, 1, 5);
   }

   private double m_726(LivingEntity var1) {
      double var2 = var1.getHealth() + var1.getAbsorptionAmount();
      if (var1 instanceof PlayerEntity var4) {
         double var5 = this.m_2797(var4);
         return var2 * (1.0 + var5 / f_962);
      } else {
         return var2;
      }
   }

   @EventHandler
   public void m_4100(Util164 var1) {
      if (f_5909.player != null && f_5909.world != null && this.f_894 != null) {
         if (this.m_2184()) {
            Util10 var2 = this.m_2755(this.f_894);
            if (var2 != null) {
               Util54.m_3501(var2, this.f_889.m_4046(), 1, 5);
            }
         }
      }
   }

   @EventHandler
   public void m_425(Util170 var1) {
      if (f_5909.player == null || f_5909.world == null) {
         this.f_894 = null;
      } else if (!this.m_2184()) {
         this.f_894 = null;
      } else {
         if (this.f_894 == null || !this.m_2783(this.f_894)) {
            this.m_426();
         }
      }
   }

   private Vec3d m_273(LivingEntity var1) {
      double var2 = Math.clamp(var1.getHeight() * f_942, f_943, f_944);
      return var1.getEntityPos().add(0.0, var2, 0.0);
   }

   public NumberSetting m_1723() {
      return this.f_888;
   }

   private double m_3244(LivingEntity var1) {
      if (f_5909.player == null) {
         return 0.0;
      } else {
         Vec3d var2 = f_5909.player.getEyePos();
         Vec3d var3 = var1.getEntityPos().add(0.0, var1.getHeight() / f_955, 0.0);
         Vec3d var4 = var3.subtract(var2);
         double var5 = Math.toDegrees(Math.atan2(var4.z, var4.x)) - f_956;
         double var7 = -Math.toDegrees(Math.atan2(var4.y, Math.sqrt(var4.x * var4.x + var4.z * var4.z)));
         double var9 = MathHelper.wrapDegrees((float)(var5 - f_5909.player.getYaw()));
         double var11 = var7 - f_5909.player.getPitch();
         return Math.sqrt(var9 * var9 + var11 * var11);
      }
   }

   public BooleanSetting m_2686() {
      return this.f_893;
   }

   public Util63 m_2624() {
      return this.f_891;
   }

   private void m_426() {
      if (f_5909.player != null && f_5909.world != null) {
         ArrayList var1 = new ArrayList();

         for (Entity var3 : f_5909.world.getEntities()) {
            if (var3 instanceof PlayerEntity var4 && this.m_2783(var4)) {
               var1.add(var4);
            }
         }

         if (var1.isEmpty()) {
            this.f_894 = null;
         } else if (var1.size() == 1) {
            this.f_894 = (LivingEntity)var1.getFirst();
         } else {
            String var5 = this.f_890.m_3862();
            switch (var5) {
               case f_922:
                  var1.sort(Comparator.comparingDouble(var0 -> f_5909.player.distanceTo((Entity)var0)));
                  break;
               case f_923:
                  var1.sort(Comparator.comparingDouble(this::m_726));
                  break;
               case f_924:
                  var1.sort(Comparator.comparingDouble(this::m_3244));
                  break;
               default:
                  var1.sort(Comparator.comparingDouble(this::m_2721));
            }

            this.f_894 = (LivingEntity)var1.getFirst();
         }
      }
   }

   private double m_2457(double var1, double var3, double var5, double var7) {
      if (!(var1 <= 0.0) && !(var5 <= 0.0) && !(var7 <= 0.0)) {
         double var9 = var5 * var5;
         double var11 = var9 * var9 - var7 * (var7 * var1 * var1 + f_945 * var3 * var9);
         if (var11 < 0.0) {
            return Double.NaN;
         } else {
            double var13 = Math.sqrt(var11);
            double var15 = Math.atan((var9 - var13) / (var7 * var1));
            return -Math.toDegrees(var15);
         }
      } else {
         return Double.NaN;
      }
   }

   public NumberSetting m_1800() {
      return this.f_889;
   }

   public Util63 m_413() {
      return this.f_892;
   }

   private double m_2797(LivingEntity var1) {
      if (var1 instanceof PlayerEntity var2) {
         double var3 = 0.0;

         for (ItemStack var6 : Util12.m_1105(var2)) {
            if (!var6.isEmpty()) {
               var3 += this.m_787(var6);
            }
         }

         return var3;
      } else {
         return var1.getArmor();
      }
   }

   private double m_2721(LivingEntity var1) {
      if (f_5909.player == null) {
         return f_946;
      } else {
         double var2 = 0.0;
         double var4 = f_5909.player.distanceTo(var1);
         var2 += var4 * f_947;
         double var6 = this.m_3244(var1);
         var2 += var6 * f_948;
         double var8 = this.m_726(var1);
         var2 += var8 * f_949;
         double var10 = this.m_2797(var1);
         var2 += var10;
         if (var1 instanceof PlayerEntity var12) {
            if (var12.isBlocking()) {
               var2 += f_950;
            }

            if (var12.getArmor() == 0) {
               var2 -= f_951;
            }

            if (var12.getHealth() <= f_952) {
               var2 -= f_953;
            }
         }

         if (f_5909.player.canSee(var1)) {
            var2 -= f_954;
         }

         return var2;
      }
   }

   private boolean m_2783(LivingEntity var1) {
      if (f_5909.player == null || f_5909.world == null) {
         return false;
      } else if (!(var1 instanceof PlayerEntity var2)) {
         return false;
      } else if (var1 instanceof ClientPlayerEntity) {
         return false;
      } else if (var2 == f_5909.player) {
         return false;
      } else if (!var1.isAlive() || var1.isInvulnerable()) {
         return false;
      } else if (var1 instanceof ArmorStandEntity) {
         return false;
      } else if (AntiBot.m_79(var1)) {
         return false;
      } else if (Util36.m_3448(var1).length() > this.f_888.m_4046()) {
         return false;
      } else if (this.f_893.m_1163() && !f_5909.player.canSee(var1)) {
         return false;
      } else {
         return !this.f_892.I(f_925) && InitManager.f_2740.f_2744.m_3914(var2) ? false : this.f_892.I(f_926) || var2.getArmor() > 0;
      }
   }

   private Util10 m_2755(LivingEntity var1) {
      AimBot.I8J4BINi4IKWm4zZ var2 = this.m_661();
      if (var2 != null && f_5909.player != null) {
         Vec3d var3 = f_5909.player.getEyePos();
         Vec3d var4 = this.m_273(var1);
         Vec3d var5 = var1.getVelocity();
         Vec3d var6 = f_5909.player.getVelocity();
         double var7 = Math.clamp(var3.distanceTo(var4) / Math.max(var2.speed(), f_934), 0.0, f_935);
         float var9 = f_5909.player.getYaw();
         float var10 = f_5909.player.getPitch();

         for (int var11 = 0; var11 < 4; var11++) {
            Vec3d var12 = var4.add(var5.multiply(var7));
            Vec3d var13 = var12.subtract(var3).subtract(var6.multiply(var7));
            double var14 = Math.hypot(var13.x, var13.z);
            if (var14 < f_936) {
               break;
            }

            double var16 = this.m_2457(var14, var13.y, var2.speed(), var2.gravity());
            if (Double.isNaN(var16)) {
               var16 = -Math.toDegrees(Math.atan2(var13.y, var14));
            }

            var9 = (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var13.z, var13.x)) - f_937);
            var10 = (float)MathHelper.clamp(var16, f_938, f_939);
            double var18 = Math.abs(var2.speed() * Math.cos(Math.toRadians(var16)));
            if (var18 < f_940) {
               break;
            }

            var7 = Math.clamp(var14 / var18, 0.0, f_941);
         }

         return new Util10(var9, var10);
      } else {
         return null;
      }
   }

   public LivingEntity m_3028() {
      return this.f_894;
   }

   private double m_787(ItemStack var1) {
      if (var1.isEmpty()) {
         return 0.0;
      } else {
         double var2 = 0.0;
         AttributeModifiersComponent var4 = (AttributeModifiersComponent)var1.get(DataComponentTypes.ATTRIBUTE_MODIFIERS);
         if (var4 != null) {
            for (Entry var6 : var4.modifiers()) {
               if (var6.attribute().equals(EntityAttributes.ARMOR)) {
                  var2 += var6.modifier().value();
               }

               if (var6.attribute().equals(EntityAttributes.ARMOR_TOUGHNESS)) {
                  var2 += var6.modifier().value() * f_957;
               }
            }
         }

         ItemEnchantmentsComponent var9 = (ItemEnchantmentsComponent)var1.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);

         for (RegistryEntry var7 : var9.getEnchantments()) {
            int var8 = var9.getLevel(var7);
            if (var7.matchesKey(Enchantments.PROTECTION)) {
               var2 += var8 * f_958;
            } else if (var7.matchesKey(Enchantments.FIRE_PROTECTION)) {
               var2 += var8 * f_959;
            } else if (var7.matchesKey(Enchantments.BLAST_PROTECTION)) {
               var2 += var8 * f_960;
            } else if (var7.matchesKey(Enchantments.PROJECTILE_PROTECTION)) {
               var2 += var8 * f_961;
            }
         }

         return var2;
      }
   }

   private record I8J4BINi4IKWm4zZ(double speed, double gravity) {
   }
}
