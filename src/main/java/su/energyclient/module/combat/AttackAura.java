package su.energyclient.module.combat;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.AttributeModifiersComponent.Entry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MaceItem;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.movement.ElytraResolver;
import su.energyclient.module.movement.ElytraSample;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil22;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util103;
import su.energyclient.util.Util111;
import su.energyclient.util.Util114;
import su.energyclient.util.Util12;
import su.energyclient.util.Util121;
import su.energyclient.util.Util122;
import su.energyclient.util.Util123;
import su.energyclient.util.Util124;
import su.energyclient.util.Util125;
import su.energyclient.util.Util126;
import su.energyclient.util.Util129;
import su.energyclient.util.Util146;
import su.energyclient.util.Util152;
import su.energyclient.util.Util159;
import su.energyclient.util.Util162;
import su.energyclient.util.Util164;
import su.energyclient.util.Util169;
import su.energyclient.util.Util170;
import su.energyclient.util.Util25;
import su.energyclient.util.Util27;
import su.energyclient.util.Util36;
import su.energyclient.util.Util38;
import su.energyclient.util.Util49;
import su.energyclient.util.Util54;
import su.energyclient.util.Util63;
import su.energyclient.util.Util66;
import su.energyclient.util.Util68;
import su.energyclient.util.Util7;
import su.energyclient.util.math.MathUtil10;
import su.energyclient.util.math.MathUtil2;

public class AttackAura extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_3558 = 6;
   private static final int f_3559 = 0;
   private static final int[][] f_3560 = new int[][]{{0, 1}, {1, 5}, {5, 4}, {4, 0}, {2, 3}, {3, 7}, {7, 6}, {6, 2}, {0, 2}, {1, 3}, {4, 6}, {5, 7}};
   private final ModeSetting f_3561;
   public final NumberSetting f_3562;
   public final NumberSetting f_3563;
   public final NumberSetting f_3564;
   public final NumberSetting f_3565;
   public final NumberSetting f_3566;
   public final NumberSetting f_3567;
   public final NumberSetting f_3568;
   private final BooleanSetting f_3569;
   public final BooleanSetting f_3570;
   private final ModeSetting f_3571;
   private final Util63 f_3572;
   private final Util63 f_3573;
   private final ModeSetting f_3574;
   private final BooleanSetting f_3575;
   private final BooleanSetting f_3576;
   private final ModeSetting f_3577;
   private final BooleanSetting f_3578;
   private final BooleanSetting f_3579;
   private final BooleanSetting f_3580;
   private final BooleanSetting f_3581;
   public final RenderUtil22 f_3582;
   public final BooleanSetting f_3583;
   private LivingEntity f_3584;
   private long f_3585;
   private boolean f_3586;
   private int f_3587;
   private int f_3588;
   private float f_3589;
   public double f_3590;
   public double f_3591;
   private final Util129 f_3592;
   private final Util27 f_3593;
   private boolean f_3594;
   private boolean f_3595;
   private boolean f_3596;
   private int f_3597;
   private int f_3598;
   private int f_3599;
   private int f_3600;
   private int f_3601;
   private int f_3602;
   private int f_3603;
   private float f_3604;
   private float f_3605;
   private float f_3606;
   private float f_3607;
   private float f_3608;
   private float f_3609;
   private float f_3610;
   private float f_3611;
   private float f_3612;
   private float f_3613;
   private float f_3614;
   private float f_3615;
   private float f_3616;
   private float f_3617;
   private float f_3618;
   private float f_3619;
   private float f_3620;
   private float f_3621;
   private float f_3622;
   private float f_3623;
   private float f_3624;
   private float f_3625;
   private float f_3626;
   private float f_3627;
   private float f_3628;
   private float f_3629;
   private float f_3630;
   private Util10 f_3631;
   private final Util125 f_3632;
   private final Util125 f_3633;
   private int f_3634;
   public boolean f_3635;
   public boolean f_3636;
   private boolean f_3637;
   public boolean f_3638;
   private int f_3639;
   public boolean f_3640;
   public final ObjectArrayList<AttackAura.XG2B0wLrQB0BY1qL> f_3641;
   public int f_3642;
   private final Util125 f_3643;
   private int f_3644;
   private boolean f_3645;
   public boolean f_3646;
   public boolean f_3647;
   private static final String f_3648 = "\\R";
   private static final String f_3649 = "\\s+";
   private static final String f_3650 = "Attack Aura";
   private static final String f_3651 = "Бьет женщин и детей";
   private static final String f_3652 = "Обход";
   private static final String f_3653 = "ReallyWorld";
   private static final String f_3654 = "ReallyWorld";
   private static final String f_3655 = "FunTime";
   private static final String f_3656 = "Spooky";
   private static final String f_3657 = "AimAssist";
   private static final String f_3658 = "HolyWorld";
   private static final String f_3659 = "ML";
   private static final String f_3660 = "Ares/FT";
   private static final String f_3661 = "Snap";
   private static final String f_3662 = "Сила AimAssist";
   private static final float f_3663 = 0.5F;
   private static final float f_3664 = 0.05F;
   private static final float f_3665 = 0.05F;
   private static final String f_3666 = "Сглаживание джерка";
   private static final float f_3667 = 3.0F;
   private static final float f_3668 = 16.0F;
   private static final String f_3669 = "Скорость джерка";
   private static final float f_3670 = 0.5F;
   private static final float f_3671 = 3.0F;
   private static final float f_3672 = 0.05F;
   private static final String f_3673 = "Доводка";
   private static final float f_3674 = 0.35F;
   private static final float f_3675 = 0.05F;
   private static final String f_3676 = "Дистанция аттаки";
   private static final float f_3677 = 3.0F;
   private static final float f_3678 = 5.0F;
   private static final float f_3679 = 0.1F;
   private static final String f_3680 = "Дистанция ротации";
   private static final float f_3681 = 1.5F;
   private static final float f_3682 = 5.0F;
   private static final float f_3683 = 0.05F;
   private static final String f_3684 = "Элитра ротация";
   private static final float f_3685 = 30.0F;
   private static final float f_3686 = 30.0F;
   private static final float f_3687 = 0.05F;
   private static final String f_3688 = "Проверка на луч";
   private static final String f_3689 = "От 1-го лица";
   private static final String f_3690 = "Приоритет";
   private static final String f_3691 = "Оптимальный";
   private static final String f_3692 = "Оптимальный";
   private static final String f_3693 = "Дистанция";
   private static final String f_3694 = "Здоровье";
   private static final String f_3695 = "Угол поворота";
   private static final String f_3696 = "Цели";
   private static final String f_3697 = "Игроки";
   private static final String f_3698 = "Голые";
   private static final String f_3699 = "Мобы";
   private static final String f_3700 = "Друзья";
   private static final String f_3701 = "Опции";
   private static final String f_3702 = "Только криты";
   private static final String f_3703 = "Криты от буллавы";
   private static final String f_3704 = "Ломать щит";
   private static final String f_3705 = "Отжимать щит";
   private static final String f_3706 = "Тип коррекции";
   private static final String f_3707 = "Свободная";
   private static final String f_3708 = "Свободная";
   private static final String f_3709 = "Строгая";
   private static final String f_3710 = "Только с хотбара";
   private static final String f_3711 = "Только с пробелом";
   private static final String f_3712 = "Обход спринта";
   private static final String f_3713 = "Legit";
   private static final String f_3714 = "Funtime";
   private static final String f_3715 = "Legit";
   private static final String f_3716 = "Не бить если ешь";
   private static final String f_3717 = "Не бить если открыт контейнер";
   private static final String f_3718 = "Бить через стены";
   private static final String f_3719 = "Бить через стены RW";
   private static final String f_3720 = "Очистить дельту";
   private static final String f_3721 = "Только попадания";
   private static final float f_3722 = 0.95F;
   private static final String f_3723 = "Свободная";
   private static final double f_3724 = 90.0;
   private static final String f_3725 = "Датасет ML очищен";
   private static final long f_3726 = 50L;
   private static final double f_3727 = 20.0;
   private static final double f_3728 = 10.0;
   private static final String f_3729 = "Slow/Web";
   private static final float f_3730 = Float.MAX_VALUE;
   private static final float f_3731 = Float.MAX_VALUE;
   private static final float f_3732 = 255.0F;
   private static final float f_3733 = 255.0F;
   private static final float f_3734 = 255.0F;
   private static final float f_3735 = 255.0F;
   private static final float f_3736 = 1.5F;
   private static final String f_3737 = "Slow/Web";
   private static final String f_3738 = "Spooky";
   private static final String f_3739 = "FunTime";
   private static final String f_3740 = "Spooky";
   private static final float f_3741 = -89.0F;
   private static final float f_3742 = 89.0F;
   private static final float f_3743 = 8.0F;
   private static final float f_3744 = 1.5F;
   private static final float f_3745 = 0.25F;
   private static final float f_3746 = 0.55F;
   private static final float f_3747 = 5.0F;
   private static final float f_3748 = 0.22F;
   private static final float f_3749 = 0.5F;
   private static final float f_3750 = 0.01F;
   private static final float f_3751 = 0.01F;
   private static final float f_3752 = 0.18F;
   private static final float f_3753 = 0.4F;
   private static final float f_3754 = 0.3F;
   private static final float f_3755 = 3.4F;
   private static final float f_3756 = 0.12F;
   private static final float f_3757 = 1.6F;
   private static final float f_3758 = 0.48F;
   private static final float f_3759 = 0.74F;
   private static final float f_3760 = 23.0F;
   private static final float f_3761 = 36.0F;
   private static final float f_3762 = 1.1F;
   private static final float f_3763 = 1.48F;
   private static final float f_3764 = 20.0F;
   private static final float f_3765 = 38.0F;
   private static final float f_3766 = 0.18F;
   private static final float f_3767 = 0.38F;
   private static final float f_3768 = 0.48F;
   private static final float f_3769 = 0.72F;
   private static final float f_3770 = 1.08F;
   private static final float f_3771 = 1.42F;
   private static final float f_3772 = 10.0F;
   private static final float f_3773 = 31.0F;
   private static final float f_3774 = 0.16F;
   private static final float f_3775 = 0.34F;
   private static final float f_3776 = 3.6F;
   private static final float f_3777 = 7.8F;
   private static final float f_3778 = 2.2F;
   private static final float f_3779 = 5.4F;
   private static final float f_3780 = 5.2F;
   private static final float f_3781 = 10.5F;
   private static final float f_3782 = 4.0F;
   private static final float f_3783 = 8.2F;
   private static final float f_3784 = 0.68F;
   private static final float f_3785 = 0.88F;
   private static final float f_3786 = 0.92F;
   private static final float f_3787 = 1.34F;
   private static final float f_3788 = 0.18F;
   private static final float f_3789 = 0.72F;
   private static final float f_3790 = 0.84F;
   private static final float f_3791 = 1.16F;
   private static final float f_3792 = 0.18F;
   private static final float f_3793 = 0.34F;
   private static final String f_3794 = "Spooky";
   private static final float f_3795 = -89.0F;
   private static final float f_3796 = 89.0F;
   private static final float f_3797 = -18.0F;
   private static final float f_3798 = 18.0F;
   private static final float f_3799 = -12.0F;
   private static final float f_3800 = 12.0F;
   private static final float f_3801 = -89.0F;
   private static final float f_3802 = 89.0F;
   private static final float f_3803 = 0.72F;
   private static final float f_3804 = 0.38F;
   private static final float f_3805 = 0.32F;
   private static final float f_3806 = -89.0F;
   private static final float f_3807 = 89.0F;
   private static final float f_3808 = 0.5F;
   private static final float f_3809 = 0.45F;
   private static final float f_3810 = 0.45F;
   private static final float f_3811 = 0.4F;
   private static final float f_3812 = 1.25F;
   private static final float f_3813 = 0.35F;
   private static final float f_3814 = 1.5F;
   private static final float f_3815 = 1.5F;
   private static final float f_3816 = 0.82F;
   private static final float f_3817 = 1.18F;
   private static final float f_3818 = 0.18F;
   private static final float f_3819 = 0.34F;
   private static final float f_3820 = 45.0F;
   private static final float f_3821 = 0.04F;
   private static final float f_3822 = 0.58F;
   private static final float f_3823 = 4.0F;
   private static final float f_3824 = 0.22F;
   private static final float f_3825 = 0.34F;
   private static final float f_3826 = 0.58F;
   private static final float f_3827 = 0.18F;
   private static final float f_3828 = 0.4F;
   private static final float f_3829 = 6.0F;
   private static final float f_3830 = 0.86F;
   private static final float f_3831 = 1.8F;
   private static final float f_3832 = 1.35F;
   private static final float f_3833 = 1.2F;
   private static final float f_3834 = 1.35F;
   private static final float f_3835 = 0.012F;
   private static final float f_3836 = 0.01F;
   private static final float f_3837 = 3.0F;
   private static final float f_3838 = 42.0F;
   private static final float f_3839 = 0.28F;
   private static final float f_3840 = 0.16F;
   private static final float f_3841 = 0.48F;
   private static final float f_3842 = 0.001F;
   private static final float f_3843 = 0.28F;
   private static final float f_3844 = 0.35F;
   private static final float f_3845 = 0.01F;
   private static final float f_3846 = 0.001F;
   private static final float f_3847 = 7.0F;
   private static final float f_3848 = 0.68F;
   private static final float f_3849 = 0.055F;
   private static final float f_3850 = 0.01F;
   private static final String f_3851 = "Дистанция";
   private static final String f_3852 = "Здоровье";
   private static final String f_3853 = "Угол поворота";
   private static final double f_3854 = Double.MAX_VALUE;
   private static final double f_3855 = 3.0;
   private static final double f_3856 = 2.0;
   private static final double f_3857 = 1.5;
   private static final double f_3858 = 5.0;
   private static final double f_3859 = 3.0;
   private static final float f_3860 = 6.0F;
   private static final double f_3861 = 5.0;
   private static final double f_3862 = 2.0;
   private static final double f_3863 = 2.0;
   private static final double f_3864 = 90.0;
   private static final String f_3865 = "Отжимать щит";
   private static final long f_3866 = 500L;
   private static final String f_3867 = "Ломать щит";
   private static final float f_3868 = 0.88F;
   private static final float f_3869 = 0.94F;
   private static final String f_3870 = "Ломать щит";
   private static final String f_3871 = "Криты от буллавы";
   private static final String f_3872 = "Криты от буллавы";
   private static final String f_3873 = "Snap";
   private static final String f_3874 = "Друзья";
   private static final String f_3875 = "Игроки";
   private static final String f_3876 = "Голые";
   private static final String f_3877 = "Мобы";
   private static final String f_3878 = "Spooky";
   private static final float f_3879 = 3.0F;
   private static final String f_3880 = "ML";
   private static final double f_3881 = 0.5;
   private static final double f_3882 = 0.25;
   private static final double f_3883 = 0.15;
   private static final double f_3884 = 0.15;
   private static final double f_3885 = 0.15;
   private static final double f_3886 = 25.0;
   private static final String f_3887 = "ML";
   private static final String f_3888 = "ML";
   private static final String f_3889 = "ReallyWorld";
   private static final String f_3890 = "Ares/FT";
   private static final String f_3891 = "Spooky";
   private static final String f_3892 = "Только криты";
   private static final String f_3893 = "Ломать щит";
   private static final String f_3894 = "HolyNew";
   private static final String f_3895 = "HolyWorld";
   private static final String f_3896 = "Snap";
   private static final String f_3897 = "HolyWorld";
   private static final String f_3898 = "HolyWorld";
   private static final String f_3899 = "HolyWorld";
   private static final String f_3900 = "AimAssist";

   public void m_3610(boolean var1) {
      this.f_3638 = var1;
   }

   public void m_931(float var1) {
      this.f_3608 = var1;
   }

   public void m_1418(float var1) {
      this.f_3606 = var1;
   }

   public float m_2649() {
      return this.f_3608;
   }

   private void m_1510() {
      if (!Macetarget.m_329()) {
         if (f_5909.player != null && f_5909.world != null && this.f_3584 != null) {
            ElytraSample var1 = InitManager.f_2740.f_2741.elytraSample;
            if (var1.m_677() && f_5909.player.isGliding() && this.f_3584.isGliding() && Util122.m_3954(this.f_3584)) {
               this.f_3586 = true;
            } else {
               this.f_3586 = false;
               this.f_3593.m_4102(this, this.f_3584);
            }
         } else {
            this.f_3586 = false;
            Util49.m_3528();
         }
      }
   }

   @EventHandler
   public void m_1125(Util68 var1) {
      if (!Macetarget.m_329()) {
         if (f_5909.player != null && f_5909.world != null) {
            if (InitManager.f_2740.f_2741.criticals.m_677()
               && InitManager.f_2740.f_2741.criticals.f_2689.m_2073(f_3729)
               && f_5909.player.hasStatusEffect(StatusEffects.SLOW_FALLING)
               && !f_5909.player.isTouchingWater()
               && f_5909.player.fallDistance > 0.0
               && f_5909.player.fallDistance < 1.0) {
               if (this.f_3584 != null) {
                  if (this.m_2673() && !this.f_3593.m_1095(this, this.f_3584)) {
                     this.m_3724();
                  }
               } else {
                  this.f_3585 = System.currentTimeMillis();
               }
            }
         }
      }
   }

   public boolean m_1191() {
      return this.f_3646;
   }

   public void m_341(LivingEntity var1) {
      this.f_3584 = var1;
   }

   public int m_1139() {
      return this.f_3642;
   }

   public ModeSetting m_3153() {
      return this.f_3574;
   }

   public float m_3059() {
      return this.f_3604;
   }

   public void m_849(boolean var1) {
      this.f_3637 = var1;
   }

   public static boolean m_204(float var0, float var1, double var2, Entity var4) {
      Vec3d var5 = f_5909.player.getCameraPosVec(f_5909.getRenderTickCounter().getTickProgress(false));
      Vec3d var6 = f_5909.player.getRotationVector(var1, var0);
      Vec3d var7 = var5.add(var6.multiply(var2));
      Box var8 = var4.getBoundingBox();
      return var8.contains(var5) || var8.raycast(var5, var7).isPresent();
   }

   private float m_720(float var1, float var2, float var3, float var4, float var5) {
      float var6 = Math.abs(var1);
      if (var6 < f_3842) {
         return 0.0F;
      } else {
         float var7 = f_3843 + (float)Math.pow(var6, this.f_3621) * var5;
         float var8 = (float)Math.sqrt(Math.max(0.0F, 2.0F * var4 * var6));
         float var9 = Math.min(var3, Math.min(var7, var8 + Math.abs(var2) * f_3844));
         return MathHelper.clamp(Math.copySign(var9, var1) + var2 * this.f_3623, -var3, var3);
      }
   }

   public void m_1787(float var1) {
      this.f_3605 = var1;
   }

   public BooleanSetting m_2121() {
      return this.f_3575;
   }

   private boolean m_3107() {
      return this.f_3561.m_2073(f_3880);
   }

   public BooleanSetting m_90() {
      return this.f_3580;
   }

   public float m_2873() {
      return this.f_3621;
   }

   public int m_497() {
      return this.f_3639;
   }

   public long m_2082() {
      return this.f_3585;
   }

   private boolean m_2215(ElytraSample var1) {
      return var1 != null
         && var1.m_677()
         && var1.f_770.m_1163()
         && f_5909.player.isGliding()
         && this.f_3584.isGliding()
         && !f_5909.player.isTouchingWater()
         && !f_5909.player.isInLava();
   }

   public void m_3179(float var1) {
      this.f_3615 = var1;
   }

   public NumberSetting m_3334() {
      return this.f_3565;
   }

   public void m_1786(LivingEntity var1) {
      if (this.f_3643.m_2636(f_3726)) {
         if (var1 == null) {
            this.f_3643.m_3493();
         } else {
            double var2 = var1.getX() - var1.lastX;
            double var4 = var1.getY() - var1.lastY;
            double var6 = var1.getZ() - var1.lastZ;
            double var8 = Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6) * f_3727;
            this.f_3591 = this.f_3590;
            this.f_3590 = var8;
            if (var8 > f_3728) {
               this.f_3644 = 0;
               this.f_3645 = false;
               this.f_3646 = true;
            } else {
               this.f_3644++;
               if (this.f_3646) {
                  this.f_3645 = true;
               }

               if (this.f_3644 >= 3) {
                  this.f_3646 = false;
                  this.f_3644 = 0;
                  this.f_3645 = false;
               } else {
                  this.f_3646 = this.f_3645;
               }
            }

            this.f_3643.m_3493();
         }
      }
   }

   private void m_238() {
      this.f_3595 = false;
      this.f_3596 = false;
      this.f_3631 = null;
      this.f_3597 = 0;
      this.f_3598 = 0;
      this.f_3599 = 0;
      this.f_3600 = 0;
      this.f_3601 = 0;
      this.f_3602 = 0;
      this.f_3603 = 0;
      this.f_3604 = 0.0F;
      this.f_3605 = 0.0F;
      this.f_3606 = 0.0F;
      this.f_3607 = 0.0F;
      this.f_3608 = 0.0F;
      this.f_3609 = 0.0F;
      this.f_3610 = 0.0F;
      this.f_3611 = 0.0F;
      this.f_3612 = 0.0F;
      this.f_3613 = 0.0F;
      this.f_3614 = 0.0F;
      this.f_3615 = 0.0F;
      this.f_3616 = 0.0F;
      this.f_3617 = 0.0F;
      this.f_3618 = 0.0F;
      this.f_3619 = 0.0F;
      this.f_3620 = 0.0F;
      this.f_3621 = 0.0F;
      this.f_3622 = 0.0F;
      this.f_3623 = 0.0F;
      this.f_3624 = 1.0F;
      this.f_3625 = 1.0F;
      this.f_3626 = 0.0F;
      this.f_3627 = 1.0F;
      this.f_3628 = 0.0F;
      this.f_3629 = 2.0F;
      this.f_3630 = 2.0F;
   }

   public void m_1691(float var1) {
      this.f_3589 = var1;
   }

   public void m_3658(int var1) {
      this.f_3644 = var1;
   }

   public int m_3045() {
      return this.f_3602;
   }

   private void m_1699() {
      if (this.f_3573.I(f_3870)) {
         int var1 = Util146.m_2581();
         if (var1 != -1) {
            if (this.f_3584.getOffHandStack().getItem() == Items.SHIELD || this.f_3584.getMainHandStack().getItem() == Items.SHIELD) {
               if (var1 >= 9) {
                  if (this.f_3575.m_1163()) {
                     return;
                  }

                  f_5909.interactionManager
                     .clickSlot(
                        f_5909.player.currentScreenHandler.syncId, var1, f_5909.player.getInventory().getSelectedSlot(), SlotActionType.SWAP, f_5909.player
                     );
                  f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(f_5909.player.currentScreenHandler.syncId));
                  f_5909.interactionManager.attackEntity(f_5909.player, this.f_3584);
                  f_5909.player.swingHand(Hand.MAIN_HAND);
                  f_5909.interactionManager
                     .clickSlot(
                        f_5909.player.currentScreenHandler.syncId, var1, f_5909.player.getInventory().getSelectedSlot(), SlotActionType.SWAP, f_5909.player
                     );
                  f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(f_5909.player.currentScreenHandler.syncId));
               } else {
                  f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var1));
                  f_5909.interactionManager.attackEntity(f_5909.player, this.f_3584);
                  f_5909.player.swingHand(Hand.MAIN_HAND);
                  f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(f_5909.player.getInventory().getSelectedSlot()));
               }
            }
         }
      }
   }

   public BooleanSetting I() {
      return this.f_3583;
   }

   public void m_3876(int var1) {
      this.f_3642 = var1;
   }

   public boolean m_186() {
      return this.f_3595;
   }

   public void m_2514(float var1) {
      this.f_3609 = var1;
   }

   @EventHandler
   public void m_4063(Util169 var1) {
      if (f_5909.player != null && f_5909.world != null && this.f_3584 != null) {
         ElytraSample var2 = InitManager.f_2740.f_2741.elytraSample;
         if (this.m_2215(var2)) {
            Box var3 = this.m_503(var2, var1.m_4119());
            if (var3 != null) {
               this.m_1264(var1, var3, -1);
            }
         }
      }
   }

   @EventHandler
   public void I(Util121 var1) {
      if (!Macetarget.m_329()) {
         if (this.f_3584 != null) {
            if (this.f_3574.m_2073(f_3723)) {
               Util38.m_3088(var1, Util49.m_883());
            } else {
               Vec3d var2 = Util36.m_3448(this.f_3584);
               float var3 = (float)MathHelper.wrapDegrees(Math.toDegrees(Math.atan2(var2.z, var2.x)) - f_3724);
               Util38.m_3088(var1, var3);
            }
         }
      }
   }

   private void m_2579() {
      if (f_5909.player != null && f_5909.world != null) {
         ArrayList var1 = new ArrayList();

         for (Entity var3 : f_5909.world.getEntities()) {
            if (var3 instanceof LivingEntity var4 && this.m_1809(var4)) {
               var1.add(var4);
            }
         }

         if (var1.isEmpty()) {
            this.f_3584 = null;
         } else if (var1.size() == 1) {
            this.f_3584 = (LivingEntity)var1.getFirst();
         } else {
            String var5 = this.f_3571.m_3862();
            switch (var5) {
               case f_3851:
                  var1.sort(Comparator.comparingDouble(var0 -> f_5909.player.distanceTo((Entity)var0)));
                  break;
               case f_3852:
                  var1.sort(Comparator.comparingDouble(this::m_1733));
                  break;
               case f_3853:
                  var1.sort(Comparator.comparingDouble(this::m_343));
                  break;
               default:
                  var1.sort(Comparator.comparingDouble(this::m_1762));
            }

            this.f_3584 = (LivingEntity)var1.getFirst();
         }
      }
   }

   public void m_4085(boolean var1) {
      this.f_3596 = var1;
   }

   private static float m_3513(float var0, float var1, float var2, float var3) {
      boolean var4 = Math.signum(var0) != 0.0F && Math.signum(var1) != 0.0F && Math.signum(var0) != Math.signum(var1);
      boolean var5 = Math.abs(var1) < Math.abs(var0);
      return m_2591(var0, var1, Math.max(f_3845, !var4 && !var5 ? var2 : var3));
   }

   public BooleanSetting m_325() {
      return this.f_3569;
   }

   private boolean m_1845() {
      return this.f_3592.m_2980(this);
   }

   public void m_1616() {
      if (!Macetarget.m_329()) {
         if (f_5909.player == null || f_5909.world == null) {
            this.O(true);
         } else if (!this.f_3561.m_2073(f_3794)) {
            this.O(true);
         } else if (this.f_3596) {
            if (!Util49.m_2511()) {
               this.O(true);
            } else if (this.f_3584 != null) {
               this.O(true);
            } else {
               Util54 var1 = Util54.m_1085();
               if (var1.m_2266() > 6) {
                  if (++this.f_3597 >= 10) {
                     this.m_238();
                  }
               } else if (var1.m_2266() == 6 && var1.m_340() != null && var1.m_340() != this.f_3631) {
                  if (++this.f_3597 >= 10) {
                     this.m_238();
                  }
               } else {
                  this.f_3597 = 0;
                  float var2 = f_5909.player.getYaw();
                  float var3 = f_5909.player.getPitch();
                  float var4 = Util49.m_883();
                  float var5 = MathHelper.clamp(Util49.m_3811(), f_3795, f_3796);
                  float var6 = MathHelper.clamp(MathHelper.wrapDegrees(var4 - this.f_3606), f_3797, f_3798);
                  float var7 = MathHelper.clamp(var5 - this.f_3607, f_3799, f_3800);
                  this.f_3606 = var4;
                  this.f_3607 = var5;
                  this.I(var4, var5, var2, var3);
                  boolean var8 = this.f_3598 > 0;
                  if (var8) {
                     this.f_3598--;
                     this.f_3604 = m_2591(this.f_3604, 0.0F, this.f_3619 * this.f_3624);
                     this.f_3605 = m_2591(this.f_3605, 0.0F, this.f_3620 * this.f_3624);
                  }

                  float var9 = var4 + this.f_3612 + this.f_3608;
                  float var10 = MathHelper.clamp(var5 + this.f_3613 + this.f_3609, f_3801, f_3802);
                  float var11 = MathHelper.wrapDegrees(var9 - var2);
                  float var12 = var10 - var3;
                  if (!var8) {
                     float var13 = this.f_3601 > 0 ? this.f_3627 : 1.0F;
                     float var14 = this.m_720(var11, var6, this.f_3615, this.f_3619, this.f_3622 * var13);
                     float var15 = this.m_720(var12, var7, this.f_3616, this.f_3620, this.f_3622 * f_3803 * var13);
                     this.f_3604 = m_3513(this.f_3604, var14, this.f_3617 * this.f_3624, this.f_3619 * this.f_3624);
                     this.f_3605 = m_3513(this.f_3605, var15, this.f_3618 * this.f_3624, this.f_3620 * this.f_3624);
                  }

                  float var21 = m_3774(this.f_3604, var11, this.f_3615);
                  float var22 = m_3774(this.f_3605, var12, this.f_3616);
                  if (var8) {
                     var21 *= f_3804;
                     var22 *= f_3805;
                  }

                  Util10 var23 = new Util10(var2 + var21, MathHelper.clamp(var3 + var22, f_3806, f_3807));
                  float var16 = Math.max(Math.abs(var21) + f_3808, f_3809);
                  float var17 = Math.max(Math.abs(var22) + f_3810, f_3811);
                  Util54.m_2145(var23, var16, var17, var16, var17, 1, 6, false);
                  if (var1.m_340() == var23) {
                     this.f_3631 = var23;
                     this.f_3629 = var16;
                     this.f_3630 = var17;
                     this.f_3604 = MathHelper.wrapDegrees(f_5909.player.getYaw() - var2);
                     this.f_3605 = f_5909.player.getPitch() - var3;
                     float var18 = Math.abs(MathHelper.wrapDegrees(var4 - f_5909.player.getYaw()));
                     float var19 = Math.abs(var5 - f_5909.player.getPitch());
                     float var20 = Math.max(Util36.m_399() * f_3812, f_3813);
                     if (var18 <= var20 && var19 <= var20 && Math.abs(this.f_3604) <= var20 * f_3814 && Math.abs(this.f_3605) <= var20 * f_3815) {
                        if (this.f_3584 == null && var1.m_340() == var23) {
                           Util54.m_2145(null, var16, var17, var16, var17, 1, 6, false);
                        }

                        this.m_238();
                     }
                  }
               }
            }
         }
      }
   }

   public void m_3309(int var1) {
      this.f_3597 = var1;
   }

   public float m_119() {
      return this.f_3619;
   }

   public int m_2445() {
      return this.f_3598;
   }

   public void m_1063(boolean var1) {
      this.f_3645 = var1;
   }

   public BooleanSetting m_504() {
      return this.f_3579;
   }

   public float m_2149() {
      return this.f_3630;
   }

   public float m_3069() {
      return this.f_3618;
   }

   public int m_868() {
      return this.f_3644;
   }

   public float m_4083() {
      return this.f_3626;
   }

   @EventHandler(
      priority = -200
   )
   public void m_554(Util159 var1) {
      if (!Macetarget.m_329() && this.f_3592.m_2998()) {
         var1.m_277(false);
      }
   }

   public Util10 m_2749() {
      return this.f_3631;
   }

   public void m_2293(double var1) {
      this.f_3591 = var1;
   }

   private static float m_2591(float var0, float var1, float var2) {
      return var0 < var1 ? Math.min(var0 + var2, var1) : Math.max(var0 - var2, var1);
   }

   private void I(float var1, float var2, float var3, float var4) {
      ThreadLocalRandom var5 = ThreadLocalRandom.current();
      float var6 = Math.abs(MathHelper.wrapDegrees(var1 - var3));
      float var7 = Math.abs(var2 - var4);
      float var8 = MathHelper.sqrt(var6 * var6 + var7 * var7);
      if (--this.f_3600 <= 0) {
         this.f_3625 = var5.nextFloat(f_3816, f_3817);
         this.f_3626 = var5.nextFloat(f_3818, f_3819);
         this.f_3600 = var5.nextInt(2, 7);
      }

      this.f_3624 = MathHelper.lerp(this.f_3626, this.f_3624, this.f_3625);
      if (--this.f_3599 <= 0) {
         float var9 = MathHelper.lerp(MathHelper.clamp(var8 / f_3820, 0.0F, 1.0F), f_3821, f_3822);
         if (var8 < f_3823) {
            var9 *= f_3824;
         }

         this.f_3610 = m_2273(var9);
         this.f_3611 = m_2273(var9 * var5.nextFloat(f_3825, f_3826));
         this.f_3628 = var5.nextFloat(f_3827, f_3828);
         this.f_3599 = var5.nextInt(2, var8 < f_3829 ? 5 : 7);
      }

      this.f_3608 = MathHelper.lerp(this.f_3628, this.f_3608, this.f_3610);
      this.f_3609 = MathHelper.lerp(this.f_3628 * f_3830, this.f_3609, this.f_3611);
      boolean var10 = var6 <= Math.max(f_3831, Math.abs(this.f_3612) * f_3832) && var7 <= Math.max(f_3833, Math.abs(this.f_3613) * f_3834);
      if (this.f_3603 > 0 && var10) {
         this.f_3603--;
      } else if (this.f_3603 <= 0) {
         this.f_3612 = this.f_3612 * this.f_3614;
         this.f_3613 = this.f_3613 * this.f_3614;
         if (Math.abs(this.f_3612) < f_3835) {
            this.f_3612 = 0.0F;
         }

         if (Math.abs(this.f_3613) < f_3836) {
            this.f_3613 = 0.0F;
         }
      }

      if (this.f_3601 > 0) {
         this.f_3601--;
      } else if (--this.f_3602 <= 0) {
         if (var8 > f_3837 && var8 < f_3838 && var5.nextFloat() < f_3839) {
            this.f_3601 = var5.nextInt(1, 3);
            this.f_3627 = var5.nextFloat(f_3840, f_3841);
         }

         this.f_3602 = var5.nextInt(8, 22);
      }
   }

   @Override
   public void m_1() {
      this.m_3918();
      this.f_3592.m_2004();
      this.f_3592.m_2572();
      super.m_1();
      if (this.f_3561.m_2073(f_3878)) {
         this.m_1238();
      } else {
         this.O(true);
      }

      this.f_3584 = null;
      this.f_3585 = System.currentTimeMillis();
      this.f_3634 = 0;
      this.f_3586 = false;
      this.f_3635 = false;
      this.f_3594 = false;
      Util49.m_3528();
      this.f_3593.m_3612(this);
      Util103.m_1429();
   }

   public void m_2558(float var1) {
      this.f_3630 = var1;
   }

   private double m_343(LivingEntity var1) {
      if (f_5909.player == null) {
         return 0.0;
      } else {
         Vec3d var2 = f_5909.player.getEyePos();
         Vec3d var3 = var1.getEntityPos().add(0.0, var1.getHeight() / f_3863, 0.0);
         Vec3d var4 = var3.subtract(var2);
         double var5 = Math.toDegrees(Math.atan2(var4.z, var4.x)) - f_3864;
         double var7 = -Math.toDegrees(Math.atan2(var4.y, Math.sqrt(var4.x * var4.x + var4.z * var4.z)));
         double var9 = MathHelper.wrapDegrees(var5 - f_5909.player.getYaw());
         double var11 = var7 - f_5909.player.getPitch();
         return Math.sqrt(var9 * var9 + var11 * var11);
      }
   }

   public float m_2319() {
      return this.f_3625;
   }

   private void m_2535() {
      this.f_3641.clear();
      Util103.m_1995();
      Util25.m_2405();
      Util152.m_662(f_3725);
   }

   public float m_2648() {
      return this.f_3629;
   }

   public ModeSetting m_3445() {
      return this.f_3571;
   }

   public void m_3097(float var1) {
      this.f_3622 = var1;
   }

   private double m_3171(LivingEntity var1) {
      if (var1 instanceof PlayerEntity var2) {
         double var3 = 0.0;

         for (ItemStack var6 : Util12.m_1105(var2)) {
            if (!var6.isEmpty()) {
               var3 += this.m_2059(var6);
            }
         }

         return var3;
      } else {
         return var1.getArmor();
      }
   }

   public boolean m_3786() {
      return this.f_3586;
   }

   public int m_3225() {
      return this.f_3588;
   }

   public void m_2351(float var1) {
      this.f_3619 = var1;
   }

   public void m_1862(boolean var1) {
      this.f_3647 = var1;
   }

   public boolean m_2306() {
      return this.f_3636;
   }

   @EventHandler
   public void m_4136(Util164 var1) {
      this.m_1510();
   }

   public void m_517(boolean var1) {
      this.f_3594 = var1;
   }

   private void m_3497() {
      this.f_3594 = false;
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
         boolean var1 = InitManager.f_2740.f_2741.criticals.m_677()
            && InitManager.f_2740.f_2741.criticals.f_2689.m_2073(f_3737)
            && f_5909.player.hasStatusEffect(StatusEffects.SLOW_FALLING)
            && !f_5909.player.isTouchingWater();
         if (this.f_3584 != null) {
            boolean var2 = this.m_2673();
            boolean var3 = this.f_3561.m_2073(f_3738);
            boolean var4 = this.f_3561.m_2073(f_3739);
            this.f_3594 = var3 && var2;
            if (!this.f_3586 && var3) {
               this.f_3593.m_1097(this, this.f_3584);
               this.m_2865();
            } else if (this.f_3586 && var3) {
               this.O(true);
            }

            if (!this.f_3586 && var4) {
               this.f_3593.m_4102(this, this.f_3584);
            }

            if (!this.f_3586) {
               this.f_3593.m_916(this, this.f_3584, var2);
            }

            boolean var5 = !var1 && var2 && !this.f_3593.m_1095(this, this.f_3584);
            if (var5) {
               if (!this.f_3569.m_1163()) {
                  this.m_3724();
               } else {
                  boolean var6 = f_5909.targetedEntity == this.f_3584
                     || Util36.m_1308(f_5909.player.getRotationVector(), this.f_3566.m_4046(), this.f_3584.getBoundingBox())
                     || Util36.m_1308(
                        f_5909.player.getRotationVector(Util123.f_10760.m_3186(), Util123.f_10760.m_627()), this.f_3566.m_4046(), this.f_3584.getBoundingBox()
                     );
                  if (var6) {
                     this.m_3724();
                  }
               }
            }

            if (!this.f_3586 && !var3) {
               this.f_3593.m_1097(this, this.f_3584);
               this.O(true);
            }
         } else {
            this.f_3585 = System.currentTimeMillis();
            this.f_3586 = false;
            this.f_3635 = false;
            this.m_1238();
            Util49.m_3528();
            this.f_3593.m_1161(this);
         }
      }
   }

   public void m_428(float var1) {
      this.f_3623 = var1;
   }

   public float m_1165() {
      return this.f_3607;
   }

   public Util125 m_3977() {
      return this.f_3643;
   }

   public void m_2679(int var1) {
      this.f_3634 = var1;
   }

   public boolean m_1068() {
      return this.f_3637;
   }

   public void m_846(float var1) {
      this.f_3614 = var1;
   }

   public boolean m_1351() {
      return this.f_3596;
   }

   private void m_3724() {
      if (!Macetarget.m_329()) {
         if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
            if (!this.f_3578.m_1163() || !f_5909.player.isUsingItem() || f_5909.player.getOffHandStack().getItem().equals(Items.SHIELD)) {
               if (this.f_3580.m_1163() || f_5909.player.canSee(this.f_3584)) {
                  if (!(f_5909.player.distanceTo(this.f_3584) > this.m_1837())) {
                     if (this.f_3573.I(f_3865) && f_5909.player.isBlocking()) {
                        f_5909.interactionManager.stopUsingItem(f_5909.player);
                     }

                     if (this.f_3592.m_1110(this)) {
                        try {
                           this.f_3637 = false;
                           this.m_1312();
                           this.f_3636 = true;

                           try {
                              f_5909.interactionManager.attackEntity(f_5909.player, this.f_3584);
                           } finally {
                              this.f_3636 = false;
                              FastCriticals var3 = InitManager.f_2740.f_2741.fastCriticals;
                              if (var3 != null) {
                                 var3.m_1537();
                              }
                           }

                           if (this.f_3637) {
                              this.f_3585 = System.currentTimeMillis() + f_3866;
                              this.f_3593.m_3618(this, this.f_3584);
                              ElytraResolver var1 = InitManager.f_2740.f_2741.elytraResolver;
                              if (var1 != null && var1.m_677()) {
                                 var1.m_1515(this.f_3584);
                              }

                              f_5909.player.swingHand(Hand.MAIN_HAND);
                              this.f_3639 = 0;
                              if (this.f_3573.I(f_3867)) {
                                 this.m_1699();
                              }

                              this.f_3633.m_3493();
                              this.f_3634++;
                              this.f_3589 = ThreadLocalRandom.current().nextFloat(f_3868, f_3869);
                              return;
                           }

                           this.m_3918();
                        } finally {
                           this.f_3592.m_2004();
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public float m_1608() {
      return this.f_3628;
   }

   public Util27 m_3542() {
      return this.f_3593;
   }

   public void m_82(int var1) {
      this.f_3603 = var1;
   }

   public LivingEntity m_891() {
      return this.f_3584;
   }

   public int m_2727() {
      return this.f_3599;
   }

   public ObjectArrayList<AttackAura.XG2B0wLrQB0BY1qL> m_1984() {
      return this.f_3641;
   }

   public Util125 m_2175() {
      return this.f_3632;
   }

   public float m_1889() {
      return this.f_3610;
   }

   public void m_1765(int var1) {
      this.f_3599 = var1;
   }

   public NumberSetting m_4121() {
      return this.f_3567;
   }

   public void m_1425(int var1) {
      this.f_3588 = var1;
   }

   private static float m_2273(float var0) {
      ThreadLocalRandom var1 = ThreadLocalRandom.current();
      return (var1.nextFloat() + var1.nextFloat() - 1.0F) * var0;
   }

   private int m_137() {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var1 = 0; var1 < 9; var1++) {
            if (f_5909.player.getInventory().getStack(var1).isOf(Items.MACE)) {
               return var1;
            }
         }

         return -1;
      }
   }

   public float m_2446() {
      return this.f_3605;
   }

   public void m_3992(long var1) {
      this.f_3585 = var1;
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_3592.m_2572();
      this.f_3587 = -1;
      this.f_3588 = -1;
      if (!this.f_3596) {
         this.m_238();
      }

      this.f_3586 = false;
      this.f_3635 = false;
      this.f_3594 = false;
      Util49.m_3528();
      this.f_3593.m_98(this);
   }

   public float m_1226() {
      return this.f_3613;
   }

   public void m_3604(int var1) {
      this.f_3602 = var1;
   }

   public void m_1184(int var1) {
      this.f_3601 = var1;
   }

   public RenderUtil22 m_3187() {
      return this.f_3582;
   }

   public float m_3802() {
      return this.f_3614;
   }

   private double m_1762(LivingEntity var1) {
      if (f_5909.player == null) {
         return f_3854;
      } else {
         double var2 = 0.0;
         double var4 = f_5909.player.distanceTo(var1);
         var2 += var4 * f_3855;
         double var6 = this.m_343(var1);
         var2 += var6 * f_3856;
         double var8 = this.m_1733(var1);
         var2 += var8 * f_3857;
         double var10 = this.m_3171(var1);
         var2 += var10 * 1.0;
         if (var1 instanceof PlayerEntity var12) {
            if (var12.isBlocking()) {
               var2 += f_3858;
            }

            if (var12.getArmor() == 0) {
               var2 -= f_3859;
            }

            if (var12.getHealth() <= f_3860) {
               var2 -= f_3861;
            }
         }

         if (f_5909.player.canSee(var1)) {
            var2 -= f_3862;
         }

         return var2;
      }
   }

   public void m_610(float var1) {
      this.f_3624 = var1;
   }

   public void m_1010(float var1) {
      this.f_3611 = var1;
   }

   private boolean m_897() {
      if (!this.f_3573.I(f_3871) || f_5909.player == null || this.m_137() == -1) {
         return true;
      } else {
         return !f_5909.player.isOnGround()
               && !f_5909.player.isGliding()
               && !f_5909.player.isTouchingWater()
               && !f_5909.player.isInLava()
               && !f_5909.player.isSwimming()
               && !f_5909.player.isClimbing()
               && !f_5909.player.hasVehicle()
               && !f_5909.player.getAbilities().flying
               && !f_5909.player.hasStatusEffect(StatusEffects.SLOW_FALLING)
               && MathUtil2.m_2870()
            ? MaceItem.shouldDealAdditionalDamage(f_5909.player)
            : true;
      }
   }

   private void m_2006(BufferBuilder var1, Matrix4f var2, Vector2f var3, Vector2f var4, float var5, float var6, float var7, float var8) {
      var1.vertex(var2, var3.x, var3.y, 0.0F).color(var5, var6, var7, var8);
      var1.vertex(var2, var4.x, var4.y, 0.0F).color(var5, var6, var7, var8);
   }

   public void l(double var1) {
      this.f_3590 = var1;
   }

   public void m_2972() {
      if (this.f_3636 && !this.f_3637) {
         this.f_3637 = true;
         this.f_3592.m_2274(this);
      }
   }

   public void m_3406(float var1) {
      this.f_3627 = var1;
   }

   public void m_3782(float var1) {
      this.f_3628 = var1;
   }

   public void m_2058(float var1) {
      this.f_3629 = var1;
   }

   public void m_2220(float var1) {
      this.f_3621 = var1;
   }

   @EventHandler(
      priority = -210
   )
   public void m_3597(Util66 var1) {
      if (!Macetarget.m_329()) {
         this.f_3592.m_3987(var1, this);
      }
   }

   public void m_2910(boolean var1) {
      this.f_3595 = var1;
   }

   private boolean m_1809(LivingEntity var1) {
      if (f_5909.player == null || f_5909.world == null) {
         return false;
      } else if (var1 instanceof ClientPlayerEntity) {
         return false;
      } else if (f_5909.player.distanceTo(var1)
         >= this.f_3566.m_134().floatValue()
            + (
               (!this.f_3561.m_2073(f_3873) ? this.f_3567.m_134().floatValue() : 0.0F)
                  + (f_5909.player.isGliding() && f_5909.player.isGliding() ? this.f_3568.m_134().floatValue() : 0.0F)
            )) {
         return false;
      } else {
         if (var1 instanceof PlayerEntity var2) {
            if (var2.getName().getString().equalsIgnoreCase(f_5909.player.getName().getString())) {
               return false;
            }

            if (AntiBot.m_79(var1)) {
               return false;
            }

            if (!this.f_3572.I(f_3874) && InitManager.f_2740.f_2744.m_3914(var2)) {
               return false;
            }
         }

         if (!this.f_3572.I(f_3875) && var1 instanceof PlayerEntity) {
            return false;
         } else if (!this.f_3572.I(f_3876) && var1 instanceof PlayerEntity && var1.getArmor() == 0) {
            return false;
         } else {
            return !this.f_3572.I(f_3877) && var1 instanceof MobEntity
               ? false
               : !var1.isInvulnerable() && var1.isAlive() && !(var1 instanceof ArmorStandEntity);
         }
      }
   }

   public void m_1661(boolean var1) {
      this.f_3635 = var1;
   }

   private double m_1733(LivingEntity var1) {
      double var2 = var1.getHealth() + var1.getAbsorptionAmount();
      if (var1 instanceof PlayerEntity var4) {
         double var5 = this.m_3171(var4);
         return var2 * (1.0 + var5 / f_3886);
      } else {
         return var2;
      }
   }

   public float m_2926() {
      return this.f_3627;
   }

   public int m_1814() {
      return this.f_3601;
   }

   public float m_3804() {
      return this.f_3616;
   }

   public NumberSetting m_1944() {
      return this.f_3562;
   }

   public float m_2874() {
      return this.f_3615;
   }

   public Util125 m_3884() {
      return this.f_3633;
   }

   public AttackAura() {
      super(f_3650, f_3651, Category.COMBAT);
      this.f_3561 = new ModeSetting(f_3652, f_3653, f_3654, f_3655, f_3656, f_3657, f_3658, f_3659, f_3660, f_3661) {
         private static final String f_540 = "ReallyWorld";

         @Override
         public void m_21(String var1) {
            super.m_21(this.m_3551().contains(var1) ? var1 : f_540);
         }
      };
      this.f_3562 = new NumberSetting(f_3662, f_3663, f_3664, 1.0F, f_3665).m_356(() -> this.f_3561.m_2073(f_3900));
      this.f_3563 = new NumberSetting(f_3666, f_3667, 1.0F, f_3668, 1.0F).m_356(() -> this.f_3561.m_2073(f_3899));
      this.f_3564 = new NumberSetting(f_3669, 1.0F, f_3670, f_3671, f_3672).m_356(() -> this.f_3561.m_2073(f_3898));
      this.f_3565 = new NumberSetting(f_3673, f_3674, 0.0F, 1.0F, f_3675).m_356(() -> this.f_3561.m_2073(f_3897));
      this.f_3566 = new NumberSetting(f_3676, f_3677, 2.0F, f_3678, f_3679);
      this.f_3567 = new NumberSetting(f_3680, f_3681, 0.0F, f_3682, f_3683).m_356(() -> !this.f_3561.m_2073(f_3896));
      this.f_3568 = new NumberSetting(f_3684, f_3685, 0.0F, f_3686, f_3687);
      this.f_3569 = new BooleanSetting(f_3688, false);
      this.f_3570 = new BooleanSetting(f_3689, false).m_334(() -> this.f_3561.m_2073(f_3894) || this.f_3561.m_2073(f_3895));
      this.f_3571 = new ModeSetting(f_3690, f_3691, f_3692, f_3693, f_3694, f_3695);
      this.f_3572 = new Util63(
         f_3696, new BooleanSetting(f_3697, true), new BooleanSetting(f_3698, true), new BooleanSetting(f_3699, false), new BooleanSetting(f_3700, false)
      );
      this.f_3573 = new Util63(
         f_3701, new BooleanSetting(f_3702, true), new BooleanSetting(f_3703, false), new BooleanSetting(f_3704, false), new BooleanSetting(f_3705, false)
      );
      this.f_3574 = new ModeSetting(f_3706, f_3707, f_3708, f_3709);
      this.f_3575 = new BooleanSetting(f_3710, false).m_334(() -> this.f_3573.I(f_3893));
      this.f_3576 = new BooleanSetting(f_3711, false).m_334(() -> this.f_3573.I(f_3892));
      this.f_3577 = new ModeSetting(f_3712, f_3713, f_3714, f_3715).m_1263(() -> !this.f_3561.m_2073(f_3891));
      this.f_3578 = new BooleanSetting(f_3716, false);
      this.f_3579 = new BooleanSetting(f_3717, false).m_334(() -> this.f_3561.m_2073(f_3890));
      this.f_3580 = new BooleanSetting(f_3718, true);
      this.f_3581 = new BooleanSetting(f_3719, true).m_334(() -> this.f_3561.m_2073(f_3889));
      this.f_3582 = new RenderUtil22(f_3720, -1).m_2895(() -> this.f_3561.m_2073(f_3888));
      this.f_3583 = new BooleanSetting(f_3721, true).m_334(() -> this.f_3561.m_2073(f_3887));
      this.f_3585 = 0L;
      this.f_3587 = -1;
      this.f_3588 = -1;
      this.f_3589 = f_3722;
      this.f_3590 = 0.0;
      this.f_3591 = 0.0;
      this.f_3592 = new Util129();
      this.f_3593 = new Util27();
      this.f_3627 = 1.0F;
      this.f_3629 = 2.0F;
      this.f_3630 = 2.0F;
      this.f_3632 = new Util125();
      this.f_3633 = new Util125();
      this.f_3634 = 0;
      this.f_3641 = new ObjectArrayList();
      this.f_3643 = new Util125();
   }

   private void m_3918() {
      if (this.f_3587 != -1) {
         int var1 = this.f_3587;
         int var2 = this.f_3588;
         this.f_3587 = -1;
         this.f_3588 = -1;
         if (f_5909.player != null && f_5909.interactionManager != null) {
            if (f_5909.player.getInventory().getSelectedSlot() == var2) {
               f_5909.player.getInventory().setSelectedSlot(var1);
               ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
            }
         }
      }
   }

   public BooleanSetting m_143() {
      return this.f_3570;
   }

   public BooleanSetting m_857() {
      return this.f_3576;
   }

   public void m_3681(boolean var1) {
      this.f_3646 = var1;
   }

   public float m_284() {
      return this.f_3624;
   }

   private void m_1264(Util169 var1, Box var2, int var3) {
      Vec3d[] var4 = MathUtil10.m_1801(var2);
      Vector2f[] var5 = new Vector2f[var4.length];

      for (int var6 = 0; var6 < var4.length; var6++) {
         Vector2f var7 = MathUtil10.m_2018(var4[var6]);
         if (var7.x == f_3730 || var7.y == f_3731 || !Float.isFinite(var7.x) || !Float.isFinite(var7.y)) {
            return;
         }

         var5[var6] = var7;
      }

      float var16 = (var3 >> 16 & 0xFF) / f_3732;
      float var17 = (var3 >> 8 & 0xFF) / f_3733;
      float var8 = (var3 & 0xFF) / f_3734;
      float var9 = (var3 >> 24 & 0xFF) / f_3735;
      Matrix4f var10 = Util7.m_1924(var1.m_4037().getMatrices());
      Util114.m_1481();
      Util114.m_542();
      Util114.m_3784(RenderUtil7.f_13885);
      Util114.m_2977(f_3736);
      BufferBuilder var11 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

      for (int[] var15 : f_3560) {
         this.m_2006(var11, var10, var5[var15[0]], var5[var15[1]], var16, var17, var8, var9);
      }

      RenderUtil12.I(var11.end());
      Util114.m_2977(1.0F);
      Util114.m_963();
   }

   public void m_66(float var1) {
      this.f_3618 = var1;
   }

   public float m_3207() {
      return this.f_3623;
   }

   public int m_622() {
      return this.f_3600;
   }

   public float m_3168() {
      return this.f_3622;
   }

   public float m_1921() {
      return this.f_3606;
   }

   public void m_217(float var1) {
      this.f_3625 = var1;
   }

   public boolean m_445() {
      return this.f_3645;
   }

   private double m_2059(ItemStack var1) {
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
                  var2 += var6.modifier().value() * f_3881;
               }
            }
         }

         ItemEnchantmentsComponent var9 = (ItemEnchantmentsComponent)var1.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);

         for (RegistryEntry var7 : var9.getEnchantments()) {
            int var8 = var9.getLevel(var7);
            if (var7.matchesKey(Enchantments.PROTECTION)) {
               var2 += var8 * f_3882;
            } else if (var7.matchesKey(Enchantments.FIRE_PROTECTION)) {
               var2 += var8 * f_3883;
            } else if (var7.matchesKey(Enchantments.BLAST_PROTECTION)) {
               var2 += var8 * f_3884;
            } else if (var7.matchesKey(Enchantments.PROJECTILE_PROTECTION)) {
               var2 += var8 * f_3885;
            }
         }

         return var2;
      }
   }

   public boolean m_2146() {
      return !this.m_1871() && this.m_1845();
   }

   public double m_2549() {
      return this.f_3590;
   }

   public int m_2842() {
      return this.f_3603;
   }

   public int m_416() {
      return this.f_3634;
   }

   public float m_3013() {
      return this.f_3612;
   }

   private static ObjectArrayList<AttackAura.XG2B0wLrQB0BY1qL> m_1428() {
      ObjectArrayList var0 = new ObjectArrayList();
      StringBuilder var1 = new StringBuilder();

      for (String var5 : Util126.f_10702) {
         var1.append(var5);
      }

      for (String var10 : var1.toString().strip().split(f_3648)) {
         if (!var10.isBlank()) {
            String[] var6 = var10.trim().split(f_3649);
            if (var6.length >= 2) {
               var0.add(new AttackAura.XG2B0wLrQB0BY1qL(Float.parseFloat(var6[0]), Float.parseFloat(var6[1])));
            }
         }
      }

      return var0;
   }

   public void m_3475(float var1) {
      this.f_3607 = var1;
   }

   public int m_3462() {
      return this.f_3597;
   }

   public boolean m_129() {
      return this.f_3638;
   }

   public boolean m_1288() {
      return this.f_3647;
   }

   public Util63 m_3057() {
      return this.f_3572;
   }

   public void m_2642(float var1) {
      this.f_3616 = var1;
   }

   public void m_1847(boolean var1) {
      this.f_3640 = var1;
   }

   public ModeSetting m_1920() {
      return this.f_3577;
   }

   public void m_108(float var1) {
      this.f_3612 = var1;
   }

   public void m_2515(int var1) {
      this.f_3587 = var1;
   }

   public void m_2342(boolean var1) {
      this.f_3636 = var1;
   }

   private boolean m_2673() {
      return this.m_2146() && this.m_897();
   }

   public boolean m_1871() {
      return f_5909.player != null && f_5909.world != null && this.f_3584 != null
         ? this.f_3578.m_1163() && f_5909.player.isUsingItem()
            || this.f_3579.m_1163() && f_5909.currentScreen != null && !(f_5909.currentScreen instanceof ThemeEditor)
         : true;
   }

   public void m_1941(int var1) {
      this.f_3598 = var1;
   }

   @EventHandler
   public void m_3942(Util124 var1) {
      if (f_5909.player != null && f_5909.world != null && this.f_3584 != null) {
         this.f_3639++;
         if (this.f_3639 >= 0 && f_5909.player.isSprinting() && f_5909.player.isSubmergedInWater()) {
            this.f_3640 = true;
         }

         if (this.f_3640 && this.f_3639 > 3) {
            this.f_3640 = false;
         }

         this.m_1786(this.f_3584);
      }
   }

   private void m_3079() {
      if (this.f_3584 != null) {
         Util162.m_526(new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, f_5909.player.getYaw(), f_5909.player.getPitch()));
      }
   }

   private void m_1238() {
      if (this.f_3561.m_2073(f_3740) && this.f_3595 && !this.f_3596) {
         if (f_5909.player != null && Util49.m_2511()) {
            this.f_3595 = false;
            this.f_3596 = true;
            this.f_3597 = 0;
            ThreadLocalRandom var1 = ThreadLocalRandom.current();
            float var2 = f_5909.player.getYaw();
            float var3 = f_5909.player.getPitch();
            float var4 = Util49.m_883();
            float var5 = MathHelper.clamp(Util49.m_3811(), f_3741, f_3742);
            float var6 = MathHelper.wrapDegrees(var4 - var2);
            float var7 = var5 - var3;
            this.f_3598 = var1.nextInt(0, 3);
            this.f_3599 = var1.nextInt(2, 7);
            this.f_3600 = var1.nextInt(2, 7);
            this.f_3601 = 0;
            this.f_3602 = var1.nextInt(7, 18);
            this.f_3603 = var1.nextInt(1, 4);
            float var8 = Math.min(f_3743, Math.max(f_3744, this.f_3629 * var1.nextFloat(f_3745, f_3746)));
            float var9 = Math.min(f_3747, Math.max(1.0F, this.f_3630 * var1.nextFloat(f_3748, f_3749)));
            this.f_3604 = Math.copySign(Math.min(Math.abs(var6), var1.nextFloat(0.0F, Math.min(var8, Math.abs(var6) + f_3750))), var6);
            this.f_3605 = Math.copySign(Math.min(Math.abs(var7), var1.nextFloat(0.0F, Math.min(var9, Math.abs(var7) + f_3751))), var7);
            this.f_3606 = var4;
            this.f_3607 = var5;
            this.f_3608 = this.f_3609 = 0.0F;
            this.f_3610 = this.f_3611 = 0.0F;
            this.f_3628 = var1.nextFloat(f_3752, f_3753);
            this.f_3612 = m_2939(var6, f_3754, f_3755);
            this.f_3613 = m_2939(var7, f_3756, f_3757);
            this.f_3614 = var1.nextFloat(f_3758, f_3759);
            float var10 = var1.nextFloat(f_3760, f_3761);
            float var11 = MathHelper.clamp(this.f_3629 * var1.nextFloat(f_3762, f_3763), f_3764, f_3765);
            this.f_3615 = MathHelper.lerp(var1.nextFloat(f_3766, f_3767), var10, var11);
            float var12 = this.f_3615 * var1.nextFloat(f_3768, f_3769);
            float var13 = MathHelper.clamp(this.f_3630 * var1.nextFloat(f_3770, f_3771), f_3772, f_3773);
            this.f_3616 = MathHelper.lerp(var1.nextFloat(f_3774, f_3775), var12, var13);
            this.f_3617 = var1.nextFloat(f_3776, f_3777);
            this.f_3618 = var1.nextFloat(f_3778, f_3779);
            this.f_3619 = var1.nextFloat(f_3780, f_3781);
            this.f_3620 = var1.nextFloat(f_3782, f_3783);
            this.f_3621 = var1.nextFloat(f_3784, f_3785);
            this.f_3622 = var1.nextFloat(f_3786, f_3787);
            this.f_3623 = var1.nextFloat(f_3788, f_3789);
            this.f_3624 = this.f_3625 = var1.nextFloat(f_3790, f_3791);
            this.f_3626 = var1.nextFloat(f_3792, f_3793);
            this.f_3627 = 1.0F;
         } else {
            this.O(true);
         }
      }
   }

   public void m_1673(int var1) {
      this.f_3600 = var1;
   }

   public void m_1993(int var1) {
      this.f_3639 = var1;
   }

   @EventHandler
   public void m_592(CancellableEvent var1) {
      if (!var1.m_3546()) {
         if (var1.m_2169() == this.f_3582.m_1958() && var1.m_1362()) {
            this.m_2535();
         }
      }
   }

   private Box m_503(ElytraSample var1, float var2) {
      Vec3d var3 = this.f_3584.getEntityPos();
      Vec3d var4 = var1.m_2961(this.f_3584, var3, this.f_3584.getVelocity());
      return var4 == null ? null : this.f_3584.getBoundingBox().offset(var4.subtract(var3)).offset(this.f_3584.getLerpedPos(var2).subtract(var3));
   }

   private void O(boolean var1) {
      if (var1) {
         Util54 var2 = Util54.m_1085();
         if (var2.m_2266() == 6 && var2.m_340() != null && var2.m_340() == this.f_3631) {
            if (f_5909.player != null && f_5909.world != null) {
               Util54.m_2145(null, this.f_3629, this.f_3630, this.f_3629, this.f_3630, 1, 6, false);
            } else {
               var2.m_2951();
            }
         }
      }

      this.m_238();
   }

   public float m_3836() {
      return this.f_3611;
   }

   public void m_2674(float var1) {
      this.f_3604 = var1;
   }

   public BooleanSetting m_2997() {
      return this.f_3578;
   }

   public float m_1837() {
      if (f_5909.world != null && f_5909.player != null) {
         float var1;
         if (f_5909.player.isGliding()) {
            var1 = f_3879;
         } else {
            var1 = this.f_3566.m_4046();
         }

         return var1;
      } else {
         return 0.0F;
      }
   }

   public int m_2976() {
      return this.f_3587;
   }

   public BooleanSetting m_3644() {
      return this.f_3581;
   }

   public void m_1533(float var1) {
      this.f_3626 = var1;
   }

   public void m_598(float var1) {
      this.f_3613 = var1;
   }

   public void m_3844(float var1) {
      this.f_3620 = var1;
   }

   @EventHandler
   public void m_2541(Util170 var1) {
      if (Macetarget.m_329()) {
         this.f_3592.m_2572();
         this.f_3587 = -1;
         this.f_3588 = -1;
         this.f_3594 = false;
      } else {
         this.m_3918();
         this.f_3592.m_2015();
         if (f_5909.player != null && f_5909.world != null) {
            LivingEntity var2 = this.f_3584;
            if (this.f_3584 == null || !this.m_1809(this.f_3584)) {
               this.m_2579();
            }

            if (var2 != null && this.f_3584 == null) {
               this.m_1238();
            }

            this.f_3592.m_1142(this);
            this.m_3497();
         }
      }
   }

   public float m_1741() {
      return this.f_3620;
   }

   public ModeSetting m_2597() {
      return this.f_3561;
   }

   public double m_2464() {
      return this.f_3591;
   }

   public void m_77(Util10 var1) {
      this.f_3631 = var1;
   }

   public boolean m_2934() {
      return this.f_3594;
   }

   private void m_1312() {
      if (this.f_3573.I(f_3872) && f_5909.player != null && f_5909.interactionManager != null && MaceItem.shouldDealAdditionalDamage(f_5909.player)) {
         int var1 = this.m_137();
         int var2 = f_5909.player.getInventory().getSelectedSlot();
         if (var1 != -1 && var1 != var2) {
            this.f_3587 = var2;
            this.f_3588 = var1;
            f_5909.player.getInventory().setSelectedSlot(var1);
            ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
         }
      }
   }

   public void m_275(float var1) {
      this.f_3617 = var1;
   }

   public boolean m_1358() {
      return this.f_3640;
   }

   public void m_645(float var1) {
      this.f_3610 = var1;
   }

   public Util129 m_550() {
      return this.f_3592;
   }

   public void m_795(boolean var1) {
      this.f_3586 = var1;
   }

   private static float m_3774(float var0, float var1, float var2) {
      return !(Math.abs(var1) < f_3846) && Math.signum(var0) == Math.signum(var1)
         ? Math.copySign(Math.min(Math.abs(var0), Math.min(Math.abs(var1), var2)), var1)
         : MathHelper.clamp(var0, -var2, var2);
   }

   private static float m_2939(float var0, float var1, float var2) {
      float var3 = Math.abs(var0);
      if (!(var3 < f_3847) && !(ThreadLocalRandom.current().nextFloat() > f_3848)) {
         float var4 = Math.min(var2, var1 + var3 * f_3849);
         return Math.copySign(ThreadLocalRandom.current().nextFloat(var1, Math.max(var1 + f_3850, var4)), var0);
      } else {
         return 0.0F;
      }
   }

   public float m_3306() {
      return this.f_3617;
   }

   public NumberSetting m_2440() {
      return this.f_3568;
   }

   public NumberSetting m_905() {
      return this.f_3563;
   }

   public NumberSetting m_2174() {
      return this.f_3564;
   }

   @EventHandler(
      priority = -200
   )
   public void m_723(Util111 var1) {
      if (!Macetarget.m_329() && this.f_3592.m_2385()) {
         var1.m_277(true);
      }
   }

   public boolean m_490() {
      return this.f_3635;
   }

   private void m_2865() {
      this.f_3596 = false;
      Util54 var1 = Util54.m_1085();
      if (var1.m_2266() == 6 && var1.m_813() == Util54.qN3BdDWeCOfQ39UG.AIM) {
         this.f_3595 = true;
         this.f_3631 = var1.m_340();
         this.f_3629 = Math.max(var1.m_2109(), 2.0F);
         this.f_3630 = Math.max(var1.m_101(), 2.0F);
      } else {
         this.m_238();
      }
   }

   public float m_660() {
      return this.f_3589;
   }

   public float m_733() {
      return this.f_3609;
   }

   public Util63 m_1233() {
      return this.f_3573;
   }

   public static class XG2B0wLrQB0BY1qL {
      public float f_10812;
      public float f_10813;

      public XG2B0wLrQB0BY1qL(float var1, float var2) {
         this.f_10812 = var1;
         this.f_10813 = var2;
      }
   }
}
