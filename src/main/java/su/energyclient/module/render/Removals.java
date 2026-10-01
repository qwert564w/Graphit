package su.energyclient.module.render;

import net.minecraft.entity.Entity;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.decoration.ArmorStandEntity;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventNoRender;
import su.energyclient.event.impl.EventThirdPersonDistance;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util170;
import su.energyclient.util.Util63;

public class Removals extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static Util63 f_3931 = new Util63(
      Removals.f_3957,
      new BooleanSetting(Removals.f_3958, true),
      new BooleanSetting(Removals.f_3959, true),
      new BooleanSetting(Removals.f_3960, true),
      new BooleanSetting(Removals.f_3961, true),
      new BooleanSetting(Removals.f_3962, true),
      new BooleanSetting(Removals.f_3963, true),
      new BooleanSetting(Removals.f_3964, true),
      new BooleanSetting(Removals.f_3965, true),
      new BooleanSetting(Removals.f_3966, true),
      new BooleanSetting(Removals.f_3967, true),
      new BooleanSetting(Removals.f_3968, true),
      new BooleanSetting(Removals.f_3969, true),
      new BooleanSetting(Removals.f_3970, true),
      new BooleanSetting(Removals.f_3971, true),
      new BooleanSetting(Removals.f_3972, false),
      new BooleanSetting(Removals.f_3973, true),
      new BooleanSetting(Removals.f_3974, true),
      new BooleanSetting(Removals.f_3975, true),
      new BooleanSetting(Removals.f_3976, false),
      new BooleanSetting(Removals.f_3977, false),
      new BooleanSetting(Removals.f_3978, false)
   );
   private static final String f_3932 = "Removals";
   private static final String f_3933 = "Увеличивает FPS, убирая лишние визуальные эффекты";
   private static final String f_3934 = "Огонь";
   private static final String f_3935 = "Босс-бар";
   private static final String f_3936 = "Скорборд";
   private static final String f_3937 = "Тайтлы";
   private static final String f_3938 = "Снесение тотема";
   private static final String f_3939 = "Тряска камеры";
   private static final String f_3940 = "Камера клип";
   private static final String f_3941 = "Удочка на экране";
   private static final String f_3942 = "Частицы разрушения";
   private static final String f_3943 = "Дождь";
   private static final String f_3944 = "Тени";
   private static final String f_3945 = "Свечение игроков";
   private static final String f_3946 = "Дым";
   private static final String f_3947 = "Виньетка";
   private static final String f_3948 = "Стрелы в игроке";
   private static final String f_3949 = "Игроки";
   private static final String f_3950 = "Плохие эффекты";
   private static final String f_3951 = "Размытие под водой";
   private static final String f_3952 = "Фон контейнера";
   private static final String f_3953 = "Видимость лавы";
   private static final String f_3954 = "Стойки для брони";
   private static final String f_3955 = "Камера клип";
   private static final float f_3956 = 4.0F;
   private static final String f_3957 = "Применять на";
   private static final String f_3958 = "Тряска камеры";
   private static final String f_3959 = "Скорборд";
   private static final String f_3960 = "Удочка на экране";
   private static final String f_3961 = "Босс-бар";
   private static final String f_3962 = "Частицы разрушения";
   private static final String f_3963 = "Дождь";
   private static final String f_3964 = "Камера клип";
   private static final String f_3965 = "Тени";
   private static final String f_3966 = "Дым";
   private static final String f_3967 = "Снесение тотема";
   private static final String f_3968 = "Виньетка";
   private static final String f_3969 = "Стрелы в игроке";
   private static final String f_3970 = "Плохие эффекты";
   private static final String f_3971 = "Свечение игроков";
   private static final String f_3972 = "Игроки";
   private static final String f_3973 = "Размытие под водой";
   private static final String f_3974 = "Огонь";
   private static final String f_3975 = "Тайтлы";
   private static final String f_3976 = "Видимость лавы";
   private static final String f_3977 = "Фон контейнера";
   private static final String f_3978 = "Стойки для брони";

   public Removals() {
      super(f_3932, f_3933, Category.RENDER);
   }

   @EventHandler
   public void m_955(EventNoRender var1) {
      boolean var2 = switch (var1.f_800) {
         case fire -> f_3931.I(f_3934);
         case bossbar -> f_3931.I(f_3935);
         case scoreboard -> f_3931.I(f_3936);
         case title -> f_3931.I(f_3937);
         case totem -> f_3931.I(f_3938);
         case hurttime -> f_3931.I(f_3939);
         case cameraclip -> f_3931.I(f_3940);
         case fishingrod -> f_3931.I(f_3941);
         case destroyparticles -> f_3931.I(f_3942);
         case rain -> f_3931.I(f_3943);
         case shadows -> f_3931.I(f_3944);
         case glowing -> f_3931.I(f_3945);
         case smoke -> f_3931.I(f_3946);
         case vignette -> f_3931.I(f_3947);
         case arrows -> f_3931.I(f_3948);
         case players -> f_3931.I(f_3949);
         case bad_effects -> f_3931.I(f_3950);
         case underwater_blur -> f_3931.I(f_3951);
         case container_background -> f_3931.I(f_3952);
         case lava -> f_3931.I(f_3953);
      };
      if (var2) {
         var1.m_277(true);
      }
   }

   @EventHandler
   public void m_3038(EventThirdPersonDistance var1) {
      if (f_3931.I(f_3955)) {
         var1.m_4098(f_3956);
      }
   }

   @EventHandler
   public void m_414(Util170 var1) {
      if (f_3931.I(f_3954) && f_5909.world != null) {
         for (Entity var3 : f_5909.world.getEntities()) {
            if (var3 instanceof ArmorStandEntity var4) {
               var4.remove(RemovalReason.KILLED);
            }
         }
      }
   }
}
