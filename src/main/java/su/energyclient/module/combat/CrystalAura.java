package su.energyclient.module.combat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.AttributeModifiersComponent.Entry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInputC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerActionResponseS2CPacket;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.PlayerInput;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventPlaceBlock;
import su.energyclient.manager.InitManager;
import su.energyclient.mixin.ClientPlayerInteractionManagerMixin2;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil25;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util105;
import su.energyclient.util.Util138;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;
import su.energyclient.util.Util35;
import su.energyclient.util.Util54;
import su.energyclient.util.Util66;
import su.energyclient.util.Util68;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;
import su.energyclient.util.Util96;
import su.energyclient.util.Util99;
import su.energyclient.util.math.MathUtil5;

public class CrystalAura extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_13972 = 110;
   private static final float f_13973 = 0.0F;
   private static final float f_13974 = 0.0F;
   private static final float f_13975 = 0.0F;
   private static final int f_13976 = 0;
   private static final int f_13977 = 0;
   private static final int f_13978 = 0;
   private static final long f_13979 = 0L;
   private static final int f_13980 = 0;
   private static final int f_13981 = 0;
   private static final int f_13982 = 0;
   private static final int[] f_13983 = new int[]{-1, 0, -2, 1, -3, -4};
   private final NumberSetting f_13984;
   private final NumberSetting f_13985;
   private final NumberSetting f_13986;
   private final NumberSetting f_13987;
   private final NumberSetting f_13988;
   private final NumberSetting f_13989;
   private final NumberSetting f_13990;
   private final NumberSetting f_13991;
   private final NumberSetting f_13992;
   private final BooleanSetting f_13993;
   private final BooleanSetting f_13994;
   private final BooleanSetting f_13995;
   private final BooleanSetting f_13996;
   private final BooleanSetting f_13997;
   private final BooleanSetting f_13998;
   private final BooleanSetting f_13999;
   private final BooleanSetting f_14000;
   private final BooleanSetting f_14001;
   private long f_14002;
   private int f_14003;
   private BlockPos f_14004;
   private boolean f_14005;
   private BlockPos f_14006;
   private int f_14007;
   private int f_14008;
   private float f_14009;
   private int f_14010;
   private int f_14011;
   private int f_14012;
   private int f_14013;
   private ItemStack f_14014;
   private ItemStack f_14015;
   private int f_14016;
   private BlockPos f_14017;
   private final AtomicReference<CrystalAura.YHCQXQRdsmtmi4vz> f_14018;
   private int f_14019;
   private int f_14020;
   private int f_14021;
   private int f_14022;
   private CrystalAura.rykxIRxnR0LNxLQg f_14023;
   private BlockPos f_14024;
   private BlockHitResult f_14025;
   private int f_14026;
   private int f_14027;
   private int f_14028;
   private final AtomicReference<CrystalAura.YHCQXQRdsmtmi4vz> f_14029;
   private BlockPos f_14030;
   private Util10 f_14031;
   private boolean f_14032;
   private final Map<BlockPos, Integer> f_14033;
   private final Map<Integer, Integer> f_14034;
   private final List<CrystalAura.H0EkYdlaE5DWDLwT> f_14035;
   private final CrystalAura.emRZnElKmImDQMla f_14036;
   private boolean f_14037;
   private static final String f_14038 = "Crystal Aura";
   private static final String f_14039 = "Автоматически ставит и взрывает кристаллы";
   private static final String f_14040 = "Радиус цели";
   private static final float f_14041 = 8.0F;
   private static final float f_14042 = 4.0F;
   private static final float f_14043 = 12.0F;
   private static final float f_14044 = 0.5F;
   private static final String f_14045 = "Дальность установки";
   private static final float f_14046 = 4.5F;
   private static final float f_14047 = 3.0F;
   private static final float f_14048 = 6.0F;
   private static final float f_14049 = 0.1F;
   private static final String f_14050 = "Дальность взрыва";
   private static final float f_14051 = 4.5F;
   private static final float f_14052 = 6.0F;
   private static final float f_14053 = 0.1F;
   private static final String f_14054 = "Мин. урон врагу";
   private static final float f_14055 = 6.0F;
   private static final float f_14056 = 20.0F;
   private static final float f_14057 = 0.5F;
   private static final String f_14058 = "Мин. урон в паутине";
   private static final float f_14059 = 3.0F;
   private static final float f_14060 = 10.0F;
   private static final float f_14061 = 0.5F;
   private static final String f_14062 = "Фейсплейс здоровье";
   private static final float f_14063 = 8.0F;
   private static final float f_14064 = 20.0F;
   private static final float f_14065 = 0.5F;
   private static final String f_14066 = "Макс. урон себе";
   private static final float f_14067 = 8.0F;
   private static final float f_14068 = 20.0F;
   private static final float f_14069 = 0.5F;
   private static final String f_14070 = "Задержка";
   private static final float f_14071 = 100.0F;
   private static final float f_14072 = 100.0F;
   private static final float f_14073 = 500.0F;
   private static final float f_14074 = 10.0F;
   private static final String f_14075 = "Предикт тиков";
   private static final float f_14076 = 4.0F;
   private static final String f_14077 = "Ставить обсидиан";
   private static final String f_14078 = "Легитный";
   private static final String f_14079 = "Анти-слабость";
   private static final String f_14080 = "Анти-суицид";
   private static final String f_14081 = "Авто подкоп";
   private static final String f_14082 = "Сейвить себя";
   private static final String f_14083 = "Игнорировать друзей";
   private static final String f_14084 = "Визуализация";
   private static final String f_14085 = "Логи";
   private static final long f_14086 = 100L;
   private static final float f_14087 = 300.0F;
   private static final int f_14088 = -4962561;
   private static final float f_14089 = 200.0F;
   private static final double f_14090 = -0.08;
   private static final float f_14091 = 0.35F;
   private static final float f_14092 = 0.35F;
   private static final int f_14093 = -51401;
   private static final int f_14094 = -4962561;
   private static final long f_14095 = 4L;
   private static final double f_14096 = 0.5;
   private static final double f_14097 = 0.5;
   private static final float f_14098 = 3.0F;
   private static final float f_14099 = 3.0F;
   private static final double f_14100 = 2.0;
   private static final double f_14101 = 3.0;
   private static final double f_14102 = 4.0;
   private static final float f_14103 = Float.MAX_VALUE;
   private static final float f_14104 = Float.MAX_VALUE;
   private static final double f_14105 = 0.5;
   private static final double f_14106 = 0.001;
   private static final double f_14107 = 0.001;
   private static final float f_14108 = 90.0F;
   private static final float f_14109 = -90.0F;
   private static final float f_14110 = 90.0F;
   private static final double f_14111 = 0.01;
   private static final double f_14112 = 0.01;
   private static final double f_14113 = 0.01;
   private static final double f_14114 = 0.01;
   private static final double f_14115 = 0.01;
   private static final double f_14116 = 0.01;
   private static final double f_14117 = 0.1;
   private static final double f_14118 = 0.1;
   private static final double f_14119 = 0.1;
   private static final double f_14120 = 0.1;
   private static final double f_14121 = 0.1;
   private static final double f_14122 = 0.1;
   private static final float f_14123 = 20.0F;
   private static final float f_14124 = 35.0F;
   private static final float f_14125 = 15.0F;
   private static final float f_14126 = 25.0F;
   private static final float f_14127 = 20.0F;
   private static final float f_14128 = 20.0F;
   private static final float f_14129 = 0.01F;
   private static final float f_14130 = 35.0F;
   private static final float f_14131 = 20.0F;
   private static final double f_14132 = 1.5;
   private static final double f_14133 = 0.16;
   private static final double f_14134 = 0.5;
   private static final double f_14135 = 0.5;
   private static final float f_14136 = 3.0F;
   private static final float f_14137 = 1.25F;
   private static final float f_14138 = 4.0F;
   private static final float f_14139 = 0.35F;
   private static final float f_14140 = 1.5F;
   private static final float f_14141 = 3.0F;
   private static final float f_14142 = 0.01F;
   private static final double f_14143 = 0.5;
   private static final double f_14144 = 0.5;
   private static final double f_14145 = 1.5;
   private static final double f_14146 = 3.0;
   private static final double f_14147 = 1.5;
   private static final double f_14148 = 0.3;
   private static final float f_14149 = 0.001F;
   private static final float f_14150 = 0.01F;
   private static final float f_14151 = 0.01F;
   private static final String f_14152 = "skip unsafe mining slot restore";
   private static final double f_14153 = 4.0;
   private static final double f_14154 = 3.0;
   private static final double f_14155 = 0.5;
   private static final double f_14156 = 0.5;

   private void m_76() {
      Util54 var1 = Util54.m_1085();
      if (this.f_14031 != null && var1.m_2266() == 110 && var1.m_340() != null && var1.m_340().m_855(this.f_14031) < f_14129) {
         Util54.m_2498(null, f_14130, f_14131, 1, 110);
         var1.m_2736(0);
      }

      this.f_14031 = null;
      this.f_14032 = false;
   }

   private boolean m_654(BlockPos var1, BlockPos var2, List<PlayerEntity> var3, float var4) {
      Vec3d var5 = Vec3d.ofBottomCenter(var1.up());
      float var6 = Util35.O(var5, f_5909.player, f_5909.player.getBoundingBox(), var1, var2);
      if (var6 > var4) {
         return false;
      } else {
         float var7 = 0.0F;
         boolean var8 = false;

         for (PlayerEntity var10 : var3) {
            float var11 = Util35.O(var5, var10, var10.getBoundingBox(), var1, var2);
            var7 = Math.max(var7, var11);
            if (var11 >= this.m_113(var10)) {
               var8 = true;
            }
         }

         if (!var8) {
            return false;
         } else {
            float var12 = this.m_1057(var5, var1, var2);
            return (!(var6 > this.f_13990.m_4046()) || !(var6 >= var7)) && (!(var12 > this.f_13990.m_4046()) || !(var12 >= var7));
         }
      }
   }

   private boolean m_94(BlockPos var1) {
      if (!this.m_3927(var1)) {
         return false;
      } else {
         List var2 = this.m_2420();
         return !var2.isEmpty() && this.m_2088(var1, var2, this.m_2009());
      }
   }

   public CrystalAura() {
      super(f_14038, f_14039, Category.COMBAT);
      this.f_13984 = new NumberSetting(f_14040, f_14041, f_14042, f_14043, f_14044);
      this.f_13985 = new NumberSetting(f_14045, f_14046, f_14047, f_14048, f_14049);
      this.f_13986 = new NumberSetting(f_14050, f_14051, 1.0F, f_14052, f_14053);
      this.f_13987 = new NumberSetting(f_14054, f_14055, 1.0F, f_14056, f_14057);
      this.f_13988 = new NumberSetting(f_14058, f_14059, 1.0F, f_14060, f_14061);
      this.f_13989 = new NumberSetting(f_14062, f_14063, 0.0F, f_14064, f_14065);
      this.f_13990 = new NumberSetting(f_14066, f_14067, 0.0F, f_14068, f_14069);
      this.f_13991 = new NumberSetting(f_14070, f_14071, f_14072, f_14073, f_14074);
      this.f_13992 = new NumberSetting(f_14075, 2.0F, 0.0F, f_14076, 1.0F);
      this.f_13993 = new BooleanSetting(f_14077, true);
      this.f_13994 = new BooleanSetting(f_14078, false);
      this.f_13995 = new BooleanSetting(f_14079, true);
      this.f_13996 = new BooleanSetting(f_14080, true);
      this.f_13997 = new BooleanSetting(f_14081, true);
      this.f_13998 = new BooleanSetting(f_14082, false);
      this.f_13999 = new BooleanSetting(f_14083, true);
      this.f_14000 = new BooleanSetting(f_14084, true);
      this.f_14001 = new BooleanSetting(f_14085, false);
      this.f_14003 = -2;
      this.f_14008 = -5;
      this.f_14010 = -1;
      this.f_14011 = -1;
      this.f_14012 = -1;
      this.f_14013 = -1;
      this.f_14014 = ItemStack.EMPTY;
      this.f_14015 = ItemStack.EMPTY;
      this.f_14018 = new AtomicReference<>();
      this.f_14019 = -1;
      this.f_14020 = -1;
      this.f_14021 = -1;
      this.f_14022 = -1;
      this.f_14027 = -1;
      this.f_14028 = -1;
      this.f_14029 = new AtomicReference<>();
      this.f_14033 = new HashMap<>();
      this.f_14034 = new HashMap<>();
      this.f_14035 = new ArrayList<>();
      this.f_14036 = new CrystalAura.emRZnElKmImDQMla();
   }

   private boolean m_300(BlockHitResult var1, Item var2) {
      return this.m_754(var2, var1);
   }

   private void m_3149(BlockPos var1, BlockPos var2) {
      if (var1 != null && !this.m_2583(var1) && this.f_14012 < 9 && this.m_4075(var1) && this.m_1126()) {
         BlockState var3 = f_5909.world.getBlockState(var1);
         if (!var3.isAir() && !(var3.getHardness(f_5909.world, var1) < 0.0F)) {
            if (this.f_14006 == null || !this.f_14006.equals(var1)) {
               if (this.f_14006 != null) {
                  this.m_1094(true);
               }

               if (this.m_2519()) {
                  this.f_14006 = var1.toImmutable();
                  this.f_14017 = var2.toImmutable();
                  this.f_14018.set(new CrystalAura.YHCQXQRdsmtmi4vz(this.f_14006, new Util105()));
                  this.f_14019 = -1;
                  this.f_14007 = f_5909.player.age;
                  this.f_14008 = f_5909.player.age - 5;
                  this.f_14009 = 0.0F;
                  this.f_14010 = f_5909.player.getInventory().getSelectedSlot();
                  this.f_14011 = this.f_14010;
                  int var4 = this.m_3860(var1);
                  if (var4 >= 0 && var4 < 9 && var4 != this.f_14010) {
                     this.f_14011 = var4;
                     if (this.f_13994.m_1163()) {
                        this.m_2800(var4);
                     } else {
                        f_5909.player.getInventory().setSelectedSlot(this.f_14011);
                        ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
                     }
                  } else if (!this.f_13994.m_1163() && var4 >= 9 && f_5909.player.currentScreenHandler.getCursorStack().isEmpty()) {
                     int var5 = this.m_309(var4);
                     if (var5 != -1) {
                        this.f_14014 = f_5909.player.getInventory().getStack(var4).copy();
                        this.f_14015 = f_5909.player.getInventory().getStack(this.f_14010).copy();
                        f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var5, this.f_14010, SlotActionType.SWAP, f_5909.player);
                        if (ItemStack.areItemsAndComponentsEqual(f_5909.player.getInventory().getStack(this.f_14010), this.f_14014)) {
                           this.f_14012 = var4;
                           this.f_14013 = this.f_14010;
                        } else {
                           if (ItemStack.areItemsAndComponentsEqual(f_5909.player.getInventory().getStack(var4), this.f_14015)) {
                              f_5909.interactionManager
                                 .clickSlot(f_5909.player.currentScreenHandler.syncId, var5, this.f_14010, SlotActionType.SWAP, f_5909.player);
                           }

                           this.f_14014 = ItemStack.EMPTY;
                           this.f_14015 = ItemStack.EMPTY;
                        }
                     }
                  }

                  float var7 = var3.calcBlockBreakingDelta(f_5909.player, f_5909.world, var1);
                  int var6 = var7 > 0.0F ? MathHelper.ceil(1.0F / var7) : 300;
                  this.f_14016 = f_5909.player.age + MathHelper.clamp(var6 + 100, 100, 6000);
                  this.f_14004 = var1;
                  this.m_3789();
                  this.m_1655();
                  this.m_1577();
                  this.m_3124("start dig " + var1.toShortString());
               }
            }
         }
      }
   }

   private void m_333() {
      this.f_14012 = -1;
      this.f_14013 = -1;
      this.f_14014 = ItemStack.EMPTY;
      this.f_14015 = ItemStack.EMPTY;
      if (this.f_14037) {
         EnergyClient.f_1622.f_1624.m_52(this.f_14036);
         this.f_14037 = false;
      }
   }

   private boolean m_3760(BlockPos var1) {
      BlockPos var2 = var1.up();
      Box var3 = new Box(var2.getX(), var2.getY(), var2.getZ(), var2.getX() + 1.0, var2.getY() + f_14100, var2.getZ() + 1.0);
      return f_5909.world.getOtherEntities(null, var3).isEmpty();
   }

   private Box m_4022(BlockPos var1) {
      return new Box(var1.getX() - f_14143, var1.getY() + 1.0, var1.getZ() - f_14144, var1.getX() + f_14145, var1.getY() + f_14146, var1.getZ() + f_14147);
   }

   private boolean m_3262(BlockPos var1, BlockPos var2, List<PlayerEntity> var3, float var4) {
      Vec3d var5 = Vec3d.ofBottomCenter(var1.up());
      float var6 = Util35.O(var5, f_5909.player, f_5909.player.getBoundingBox(), var2);
      if (var6 > var4) {
         return false;
      } else {
         float var7 = 0.0F;
         boolean var8 = false;

         for (PlayerEntity var10 : var3) {
            float var11 = Util35.O(var5, var10, var10.getBoundingBox(), var2);
            var7 = Math.max(var7, var11);
            if (var11 >= this.m_113(var10)) {
               var8 = true;
            }
         }

         if (!var8) {
            return false;
         } else {
            float var12 = this.m_1098(var5, var2);
            return (!(var6 > this.f_13990.m_4046()) || !(var6 >= var7)) && (!(var12 > this.f_13990.m_4046()) || !(var12 >= var7));
         }
      }
   }

   private boolean m_2088(BlockPos var1, List<PlayerEntity> var2, float var3) {
      Vec3d var4 = Vec3d.ofBottomCenter(var1.up());
      float var5 = Util35.O(var4, f_5909.player);
      if (var5 > var3) {
         return false;
      } else {
         float var6 = 0.0F;
         boolean var7 = false;

         for (PlayerEntity var9 : var2) {
            float var10 = Util35.O(var4, var9);
            var6 = Math.max(var6, var10);
            if (var10 >= this.m_113(var9)) {
               var7 = true;
            }
         }

         if (!var7) {
            return false;
         } else {
            float var11 = this.m_1453(var4);
            return (!(var5 > this.f_13990.m_4046()) || !(var5 >= var6)) && (!(var11 > this.f_13990.m_4046()) || !(var11 >= var6));
         }
      }
   }

   private BlockPos m_1902(EndCrystalEntity var1) {
      return BlockPos.ofFloored(var1.getX(), var1.getY() - 1.0, var1.getZ());
   }

   private double m_2773() {
      return this.f_13994.m_1163() ? Math.min((double)this.f_13985.m_4046(), f_5909.player.getBlockInteractionRange()) : this.f_13985.m_4046();
   }

   private boolean m_2519() {
      return !Util138.m_3050().m_3132(this, 110) ? false : Util54.m_1085().m_2266() <= 110;
   }

   private boolean m_2162(BlockPos var1, List<PlayerEntity> var2, float var3) {
      if (this.f_13994.m_1163()) {
         Util99.SfIKBt5vqdTr90GS var6 = this.m_128(var1);
         return var6 != null
            && (this.f_13997.m_1163() || var6.removedBlocks().isEmpty())
            && this.m_2375(var1, var6.removedBlocks(), var2, var3) > Float.NEGATIVE_INFINITY;
      } else if (this.m_3927(var1) && this.m_3760(var1) && this.m_361(var1, false) != null) {
         BlockState var4 = f_5909.world.getBlockState(var1.up());
         BlockPos var5 = null;
         if (!var4.isAir()) {
            var5 = this.m_2451(var1);
            if (!this.f_13997.m_1163() || var5 == null || this.m_2583(var5) || !this.m_4075(var5)) {
               return false;
            }
         }

         return this.m_654(var1, var5, var2, var3);
      } else {
         return false;
      }
   }

   private void m_2539() {
      if (this.f_14006 != null) {
         BlockPos var1 = this.f_14006;
         BlockPos var2 = this.f_14017;
         this.f_14033.put(var1.toImmutable(), f_5909.player.age + 80);
         this.m_3124("dig blacklisted " + var1.toShortString());
         this.m_1094(true);
         if (this.f_14024 != null && this.f_14024.equals(var2)) {
            this.m_1318();
         }
      }
   }

   private void m_1852() {
      int var1 = f_5909.player.age;
      this.f_14033.entrySet().removeIf(var1x -> var1 > var1x.getValue());
   }

   private void m_2262() {
      CrystalAura.rykxIRxnR0LNxLQg var1 = this.f_14023;
      if (var1 != null && this.m_1126() && this.m_3534(var1) && this.m_1668(var1)) {
         if (!this.f_13994.m_1163() || f_5909.player.age > this.f_14022 && this.m_1854(var1)) {
            this.f_14023 = null;
            this.m_3789();
            boolean var2;
            if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.ATTACK_CRYSTAL) {
               var2 = this.m_3076(var1.crystal());
            } else if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.PLACE_CRYSTAL) {
               var2 = this.m_4076(var1.hit());
            } else {
               if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.PLACE_OBSIDIAN) {
                  this.m_3753(var1.pos());
               }

               var2 = this.m_300(var1.hit(), var1.item());
               if (!var2 && var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.PLACE_OBSIDIAN) {
                  this.m_3494();
               }
            }

            if (!var2) {
               this.f_14033.put(var1.pos(), f_5909.player.age + 10);
               if (var1.pos().equals(this.f_14024)) {
                  this.m_1318();
               }

               this.m_3124("action rejected locally " + var1.kind() + " " + var1.pos().toShortString());
            } else {
               this.f_14002 = System.currentTimeMillis();
               this.f_14004 = var1.pos();
               this.f_14005 = var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.PLACE_OBSIDIAN || var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.PLACE_SHIELD;
               this.m_1101(var1.pos(), this.f_14005 ? CrystalAura.Kcj5pdxmLyT1GeTx.OBSIDIAN : CrystalAura.Kcj5pdxmLyT1GeTx.CRYSTAL);
               switch (var1.kind()) {
                  case ATTACK_CRYSTAL:
                     this.f_14034.put(var1.crystal().getId(), f_5909.player.age + 40);
                     if (this.f_14024 != null && this.f_14024.equals(var1.pos())) {
                        this.f_14028 = -1;
                        this.m_1577();
                     }

                     this.m_3124("explode crystal " + var1.pos().toShortString());
                     break;
                  case PLACE_CRYSTAL:
                     this.f_14028 = f_5909.player.age;
                     this.m_1577();
                     this.m_3124("place crystal " + var1.pos().toShortString());
                     break;
                  case PLACE_OBSIDIAN:
                     this.f_14027 = f_5909.player.age;
                     this.m_1577();
                     this.m_3124("place obsidian " + var1.pos().toShortString());
                     break;
                  case PLACE_SHIELD:
                     this.m_3124("self shield " + var1.pos().toShortString());
               }
            }
         }
      }
   }

   private boolean m_1858(Vec3d var1, Vec3d var2, BlockPos var3, Direction var4, boolean var5) {
      if (var1.squaredDistanceTo(var2) > this.m_2773() * this.m_2773()) {
         return false;
      } else {
         Vec3d var6 = Vec3d.of(var4.getVector());
         return var1.subtract(var2).dotProduct(var6) <= f_14106
            ? false
            : !var5 || this.m_2807(var1, var2.add(var2.subtract(var1).normalize().multiply(f_14107)), var3, var4);
      }
   }

   private void m_3753(BlockPos var1) {
      this.f_14029.set(new CrystalAura.YHCQXQRdsmtmi4vz(var1.toImmutable(), new Util105()));
   }

   private void m_3023(CrystalAura.Inner_0b6mbNXHOZeb7efh var1, Item var2) {
      if (var1.inventorySwap()) {
         f_5909.interactionManager
            .clickSlot(f_5909.player.currentScreenHandler.syncId, var1.sourceScreenSlot(), var1.oldSlot(), SlotActionType.SWAP, f_5909.player);
      }

      boolean var3 = this.f_13994.m_1163() && var2 == Items.END_CRYSTAL && var1.hand() == Hand.MAIN_HAND && !var1.inventorySwap();
      if (var3) {
         if (this.f_14020 == -1 && var1.oldSlot() != var1.selectedSlot()) {
            this.f_14020 = var1.oldSlot();
         }

         if (var1.oldSlot() != var1.selectedSlot()) {
            this.f_14021 = var1.selectedSlot();
         }
      } else if (f_5909.player.getInventory().getSelectedSlot() == var1.selectedSlot() && var1.oldSlot() != var1.selectedSlot()) {
         f_5909.player.getInventory().setSelectedSlot(var1.oldSlot());
         ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
      }
   }

   private boolean m_754(Item var1, BlockHitResult var2) {
      CrystalAura.Inner_0b6mbNXHOZeb7efh var3 = this.m_2919(var1);
      if (var3 == null) {
         return false;
      } else {
         boolean var4 = !this.f_13994.m_1163()
            && var1 == Items.OBSIDIAN
            && !f_5909.player.isSneaking()
            && Util138.m_4111(f_5909.world.getBlockState(var2.getBlockPos()));

         boolean var6;
         try {
            if (var4) {
               this.m_424(true);
            }

            ActionResult var5 = f_5909.interactionManager.interactBlock(f_5909.player, var3.hand(), var2);
            if (!var5.isAccepted()) {
               return false;
            }

            f_5909.player.swingHand(var3.hand());
            var6 = true;
         } finally {
            if (var4) {
               this.m_424(false);
            }

            this.m_3023(var3, var1);
         }

         return var6;
      }
   }

   private void m_1577() {
      if (f_5909.player != null && this.f_14024 != null) {
         this.f_14026 = f_5909.player.age;
      }
   }

   private void m_1513(EndCrystalEntity var1) {
      BlockPos var2 = this.m_1902(var1);
      if (this.m_3367(var2)) {
         this.m_3854(var2);
      }

      this.f_14023 = new CrystalAura.rykxIRxnR0LNxLQg(CrystalAura.gYShz1ijBLWFbRWb.ATTACK_CRYSTAL, var2, var1, null, null, f_5909.player.age);
   }

   private boolean m_3279() {
      if (this.f_14012 < 9) {
         return true;
      } else if (f_5909.player != null && f_5909.interactionManager != null && f_5909.player.currentScreenHandler.getCursorStack().isEmpty()) {
         int var1 = this.m_309(this.f_14012);
         if (var1 != -1 && this.f_14013 >= 0 && this.f_14013 <= 8) {
            ItemStack var2 = f_5909.player.getInventory().getStack(this.f_14013);
            ItemStack var3 = f_5909.player.getInventory().getStack(this.f_14012);
            boolean var4 = var2.isEmpty() || ItemStack.areItemsEqual(var2, this.f_14014);
            boolean var5 = ItemStack.areItemsAndComponentsEqual(var3, this.f_14015);
            if (var4 && var5) {
               f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var1, this.f_14013, SlotActionType.SWAP, f_5909.player);
               if (ItemStack.areItemsAndComponentsEqual(f_5909.player.getInventory().getStack(this.f_14013), this.f_14015)) {
                  this.m_333();
                  return true;
               } else {
                  return false;
               }
            } else {
               this.m_3124(f_14152);
               this.m_333();
               return true;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void m_1435(BlockPos var1, BlockHitResult var2, boolean var3) {
      this.f_14023 = new CrystalAura.rykxIRxnR0LNxLQg(
         var3 ? CrystalAura.gYShz1ijBLWFbRWb.PLACE_SHIELD : CrystalAura.gYShz1ijBLWFbRWb.PLACE_OBSIDIAN,
         var1.toImmutable(),
         null,
         Items.OBSIDIAN,
         var2,
         f_5909.player.age
      );
   }

   private CrystalAura.jomZbuWdEigmeGwg m_814(BlockPos var1, boolean var2) {
      CrystalAura.jomZbuWdEigmeGwg var3 = null;
      float var4 = f_14103;
      Util10 var5 = Util10.m_3601();
      Vec3d var6 = f_5909.player.getEyePos();

      for (Direction var10 : Direction.values()) {
         BlockPos var11 = var1.offset(var10.getOpposite());
         BlockState var12 = f_5909.world.getBlockState(var11);
         if (!var12.isReplaceable()
            && !var12.getCollisionShape(f_5909.world, var11).isEmpty()
            && (!this.f_13994.m_1163() || f_5909.player.isSneaking() || !Util138.m_4111(var12))) {
            Vec3d var13 = this.m_3400(var11, var10);
            if (var13 != null && this.m_1858(var6, var13, var11, var10, var2)) {
               Util10 var14 = this.m_1119(var13);
               float var15 = var5.m_855(var14);
               if (var15 < var4) {
                  var4 = var15;
                  var3 = new CrystalAura.jomZbuWdEigmeGwg(new BlockHitResult(var13, var10, var11, false));
               }
            }
         }
      }

      return var3;
   }

   private void m_1094(boolean var1) {
      if (var1 && f_5909.interactionManager != null) {
         f_5909.interactionManager.cancelBlockBreaking();
      }

      this.m_3279();
      if (!this.f_13994.m_1163()
         && f_5909.player != null
         && this.f_14010 != -1
         && this.f_14011 != this.f_14010
         && f_5909.player.getInventory().getSelectedSlot() == this.f_14011) {
         f_5909.player.getInventory().setSelectedSlot(this.f_14010);
         if (f_5909.interactionManager != null) {
            ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
         }
      }

      this.f_14006 = null;
      this.f_14017 = null;
      this.f_14018.set(null);
      this.f_14019 = -1;
      this.f_14010 = -1;
      this.f_14011 = -1;
      this.f_14016 = 0;
      this.f_14009 = 0.0F;
      this.m_1655();
      this.m_76();
   }

   private void m_3494() {
      this.f_14029.set(null);
   }

   private void m_3789() {
      this.f_14002 = System.currentTimeMillis();
      this.f_14003 = f_5909.player.age;
   }

   private void m_1101(BlockPos var1, CrystalAura.Kcj5pdxmLyT1GeTx var2) {
      if (this.f_14000.m_1163() && var1 != null) {
         this.f_14035.add(new CrystalAura.H0EkYdlaE5DWDLwT(var1.toImmutable(), var2, System.currentTimeMillis()));
      }
   }

   private void m_1318() {
      Util138.m_3050().m_1018(this);
      this.f_14024 = null;
      this.f_14025 = null;
      this.f_14026 = 0;
      this.f_14027 = -1;
      this.f_14028 = -1;
      this.f_14030 = null;
      this.m_3494();
   }

   private EndCrystalEntity m_3627(BlockPos var1) {
      for (Entity var3 : f_5909.world.getEntities()) {
         if (var3 instanceof EndCrystalEntity var4 && var4.isAlive() && this.m_1902(var4).equals(var1)) {
            return var4;
         }
      }

      return null;
   }

   @EventHandler
   private void m_652(Util170 var1) {
      this.f_14032 = false;
      this.m_3291();
      if (this.f_14023 != null && this.f_13994.m_1163()) {
         this.m_3539(this.f_14023);
      }

      this.m_1757();
   }

   private CrystalAura.R0fg9fV7FWlxZXys m_3661(List<PlayerEntity> var1, float var2) {
      if (this.f_13994.m_1163()) {
         return this.m_981(var1, var2);
      } else {
         CrystalAura.R0fg9fV7FWlxZXys var3 = null;
         float var4 = Float.NEGATIVE_INFINITY;
         int var5 = 0;

         for (PlayerEntity var7 : var1) {
            Util96.wzUwRrngJnenpZwo var8 = this.m_394(var7)
               ? new Util96.wzUwRrngJnenpZwo(var7.getBoundingBox(), var7.getEntityPos())
               : Util96.m_2264(var7, Math.round(this.f_13992.m_4046()));
            BlockPos var9 = BlockPos.ofFloored(var8.position());

            for (int var10 = 0; var10 <= 3; var10++) {
               for (int var11 = -var10; var11 <= var10; var11++) {
                  for (int var12 = -var10; var12 <= var10; var12++) {
                     if (Math.max(Math.abs(var11), Math.abs(var12)) == var10) {
                        for (int var16 : f_13983) {
                           if (var11 != 0 || var12 != 0 || var16 <= -3) {
                              if (++var5 > 220) {
                                 return var3;
                              }

                              BlockPos var17 = var9.add(var11, var16, var12);
                              if (this.m_3927(var17)) {
                                 boolean var18 = this.m_3367(var17);
                                 BlockPos var20 = null;
                                 BlockPos var19;
                                 if (var18) {
                                    var19 = this.m_2451(var17);
                                    if (!this.m_3760(var17) || this.m_361(var17, false) == null) {
                                       continue;
                                    }

                                    var20 = var19;
                                 } else {
                                    BlockState var21 = f_5909.world.getBlockState(var17);
                                    BlockState var22 = f_5909.world.getBlockState(var17.up());
                                    if (!var22.isAir()) {
                                       var20 = this.m_2451(var17);
                                       if (var20 == null || this.m_2583(var20) || !this.m_4075(var20)) {
                                          continue;
                                       }
                                    }

                                    if (!this.f_13993.m_1163()
                                       || !this.m_2705(Items.OBSIDIAN)
                                       || var21.isReplaceable()
                                       || var21.getHardness(f_5909.world, var17) < 0.0F
                                       || !this.m_3760(var17)
                                       || this.m_814(var17, false) == null
                                       || this.m_361(var17, false) == null) {
                                       continue;
                                    }

                                    var19 = var17;
                                 }

                                 if (var19 != null && !this.m_2583(var19) && this.m_4075(var19)) {
                                    double var35 = var17.getX() + f_14134 - var8.position().x;
                                    double var23 = var17.getZ() + f_14135 - var8.position().z;
                                    double var25 = var17.getY() + 1.0 - var8.position().y;
                                    float var27 = (float)Math.hypot(var35, var23) * f_14136 + (float)Math.abs(var25) * f_14137;
                                    float var28 = Math.min(
                                       f_14138, Math.max(0.0F, f_5909.world.getBlockState(var19).getHardness(f_5909.world, var19)) * f_14139
                                    );
                                    Vec3d var29 = Vec3d.ofBottomCenter(var17.up());
                                    if (var18) {
                                       float var30 = Util35.O(var29, var7, var8.box(), var19);
                                       float var31 = var8.box().equals(var7.getBoundingBox())
                                          ? var30
                                          : Math.min(var30, Util35.O(var29, var7, var7.getBoundingBox(), var19));
                                       if (!(var31 < this.m_113(var7))) {
                                          float var32 = Util35.O(var29, f_5909.player, f_5909.player.getBoundingBox(), var19);
                                          float var33 = this.m_1098(var29, var19);
                                          float var34 = var31 - var32 * 2.0F - var33 * 2.0F - var27 - var28;
                                          if (var32 <= var2 && (!(var33 > this.f_13990.m_4046()) || !(var33 >= var31)) && var34 > var4) {
                                             var4 = var34;
                                             var3 = new CrystalAura.R0fg9fV7FWlxZXys(var19.toImmutable(), var17.toImmutable());
                                          }
                                       }
                                    } else {
                                       float var36 = Util35.O(var29, var7, var8.box(), var17, var20);
                                       float var37 = var8.box().equals(var7.getBoundingBox())
                                          ? var36
                                          : Math.min(var36, Util35.O(var29, var7, var7.getBoundingBox(), var17, var20));
                                       if (!(var37 < this.m_113(var7))) {
                                          float var38 = Util35.O(var29, f_5909.player, f_5909.player.getBoundingBox(), var17, var20);
                                          float var39 = this.m_1057(var29, var17, var20);
                                          float var40 = var37 - var38 * 2.0F - var39 * 2.0F - var27 - var28;
                                          if (var38 <= var2 && (!(var39 > this.f_13990.m_4046()) || !(var39 >= var37)) && var40 > var4) {
                                             var4 = var40;
                                             var3 = new CrystalAura.R0fg9fV7FWlxZXys(var19.toImmutable(), var17.toImmutable());
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var3;
      }
   }

   private float m_1453(Vec3d var1) {
      return this.m_1098(var1, null);
   }

   private boolean m_394(LivingEntity var1) {
      Box var2 = var1.getBoundingBox();
      int var3 = MathHelper.floor(var2.minX);
      int var4 = MathHelper.floor(var2.minY);
      int var5 = MathHelper.floor(var2.minZ);
      int var6 = MathHelper.floor(var2.maxX);
      int var7 = MathHelper.floor(var2.maxY);
      int var8 = MathHelper.floor(var2.maxZ);

      for (int var9 = var3; var9 <= var6; var9++) {
         for (int var10 = var4; var10 <= var7; var10++) {
            for (int var11 = var5; var11 <= var8; var11++) {
               if (f_5909.world.getBlockState(new BlockPos(var9, var10, var11)).isOf(Blocks.COBWEB)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private int m_3386(Item var1) {
      return this.m_613(var1, 0, 9);
   }

   private Util10 m_2692(EndCrystalEntity var1) {
      CrystalAura.jomZbuWdEigmeGwg var2 = this.m_3089(this.m_1902(var1));
      if (var2 != null) {
         Util10 var3 = this.m_1119(var2.hit().getPos());
         if (MathUtil5.O(var1, var3.m_2643(), var3.m_2573(), this.m_1353(), true)) {
            return var3;
         }
      }

      Box var13 = var1.getBoundingBox();
      Vec3d var4 = var13.getCenter();
      Vec3d var5 = f_5909.player.getEyePos();
      Vec3d var6 = new Vec3d(
         MathHelper.clamp(var5.x, var13.minX + f_14111, var13.maxX - f_14112),
         MathHelper.clamp(var5.y, var13.minY + f_14113, var13.maxY - f_14114),
         MathHelper.clamp(var5.z, var13.minZ + f_14115, var13.maxZ - f_14116)
      );
      Vec3d[] var7 = new Vec3d[]{
         var6,
         var4,
         new Vec3d(var4.x, var13.maxY - f_14117, var4.z),
         new Vec3d(var4.x, var13.minY + f_14118, var4.z),
         new Vec3d(var13.minX + f_14119, var4.y, var4.z),
         new Vec3d(var13.maxX - f_14120, var4.y, var4.z),
         new Vec3d(var4.x, var4.y, var13.minZ + f_14121),
         new Vec3d(var4.x, var4.y, var13.maxZ - f_14122)
      };

      for (Vec3d var11 : var7) {
         Util10 var12 = this.m_1119(var11);
         if (MathUtil5.O(var1, var12.m_2643(), var12.m_2573(), this.m_1353(), true)) {
            return var12;
         }
      }

      return null;
   }

   private void m_939(CrystalAura.Inner_4hAITp8s5cmvnS7E var1) {
      if (!this.f_13994.m_1163()) {
         if (var1.inventorySwap()) {
            f_5909.interactionManager
               .clickSlot(f_5909.player.currentScreenHandler.syncId, var1.sourceScreenSlot(), var1.oldSlot(), SlotActionType.SWAP, f_5909.player);
         } else if (var1.selectedSlot() != var1.oldSlot() && f_5909.player.getInventory().getSelectedSlot() == var1.selectedSlot()) {
            f_5909.player.getInventory().setSelectedSlot(var1.oldSlot());
            ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
         }
      }
   }

   @Override
   public void m_2() {
      super.m_2();
      this.m_894();
   }

   private boolean m_1668(CrystalAura.rykxIRxnR0LNxLQg var1) {
      if (this.f_14032 && this.f_14031 != null && this.m_2519()) {
         Util54 var2 = Util54.m_1085();
         if (var2.m_2266() == 110 && var2.m_340() == this.f_14031) {
            Util10 var3 = Util10.m_3601();
            if (var3.m_855(this.f_14031) > 2.0F) {
               return false;
            } else if (this.f_13994.m_1163() && new Util10(f_5909.player).m_855(var3) > 2.0F) {
               return false;
            } else if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.ATTACK_CRYSTAL) {
               return MathUtil5.O(var1.crystal(), var3.m_2643(), var3.m_2573(), this.m_1353(), this.f_13994.m_1163());
            } else if (!MathUtil5.O(var1.hit().getPos(), var3.m_2643(), var3.m_2573(), this.m_2773(), f_14133)) {
               return false;
            } else if (!this.f_13994.m_1163()) {
               return true;
            } else {
               Vec3d var4 = f_5909.player.getEyePos();
               Vec3d var5 = var4.add(MathUtil5.O(var3.m_2643(), var3.m_2573()).multiply(this.m_2773()));
               return this.m_2807(var4, var5, var1.hit().getBlockPos(), var1.hit().getSide());
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void m_2800(int var1) {
      if (var1 != -1 && f_5909.player.getInventory().getSelectedSlot() != var1) {
         if (this.f_14020 == -1) {
            this.f_14020 = f_5909.player.getInventory().getSelectedSlot();
         }

         this.f_14021 = var1;
         this.f_14022 = f_5909.player.age;
         f_5909.player.getInventory().setSelectedSlot(var1);
         ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
      }
   }

   private EndCrystalEntity m_1007(List<PlayerEntity> var1, float var2) {
      EndCrystalEntity var3 = null;
      float var4 = Float.NEGATIVE_INFINITY;
      double var5 = this.m_1353() * this.m_1353();

      for (Entity var8 : f_5909.world.getEntities()) {
         if (var8 instanceof EndCrystalEntity var9
            && var9.isAlive()
            && !this.m_3768(var9)
            && !(this.m_885(f_5909.player.getEyePos(), var9.getBoundingBox()) > var5)) {
            float var10 = this.m_2450(var9, var1, var2);
            if (var10 > var4) {
               var4 = var10;
               var3 = var9;
            }
         }
      }

      return var3;
   }

   private void m_2821() {
      if (this.f_14006 != null) {
         if (!this.m_900()) {
            if (this.f_14032 && this.f_14031 != null && this.m_2519()) {
               Util54 var1 = Util54.m_1085();
               if (var1.m_2266() == 110 && var1.m_340() == this.f_14031) {
                  if (!this.f_13994.m_1163() || f_5909.player.age > this.f_14022 && f_5909.player.getInventory().getSelectedSlot() == this.f_14011) {
                     Util10 var2 = Util10.m_3601();
                     Vec3d var3 = this.m_3015();
                     if (MathUtil5.O(var3, var2.m_2643(), var2.m_2573(), this.m_2773(), f_14148)) {
                        Vec3d var4 = f_5909.player.getEyePos();
                        Vec3d var5 = var4.add(MathUtil5.O(var2.m_2643(), var2.m_2573()).multiply(this.m_2773()));
                        BlockHitResult var6 = f_5909.world.raycast(new RaycastContext(var4, var5, ShapeType.OUTLINE, FluidHandling.NONE, f_5909.player));
                        Direction var7 = Direction.UP;
                        if (var6.getType() == Type.BLOCK && var6 instanceof BlockHitResult var8 && var8.getBlockPos().equals(this.f_14006)) {
                           var7 = var8.getSide();
                        } else if (this.f_13994.m_1163()) {
                           return;
                        }

                        if (f_5909.interactionManager.updateBlockBreakingProgress(this.f_14006, var7) && f_5909.player.age - this.f_14008 >= 5) {
                           f_5909.player.swingHand(Hand.MAIN_HAND);
                           this.f_14008 = f_5909.player.age;
                        }

                        if (!this.m_900()) {
                           float var9 = ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).getcurrentBreakingProgress();
                           if (var9 > this.f_14009 + f_14149) {
                              this.f_14009 = var9;
                              this.f_14007 = f_5909.player.age;
                              this.m_1577();
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean m_2899(PlayerEntity var1) {
      if (!this.m_2705(Items.OBSIDIAN)) {
         return false;
      } else {
         Vec3d var2 = var1.getEntityPos().subtract(f_5909.player.getEntityPos());
         if (!(Math.abs(var2.y) > 1.0) && !(var2.horizontalLength() > this.m_2773() + f_14132)) {
            Direction var3 = Math.abs(var2.x) > Math.abs(var2.z)
               ? (var2.x > 0.0 ? Direction.EAST : Direction.WEST)
               : (var2.z > 0.0 ? Direction.SOUTH : Direction.NORTH);
            BlockPos var4 = f_5909.player.getBlockPos().offset(var3);
            CrystalAura.jomZbuWdEigmeGwg var5 = this.m_3156(var4) ? this.m_2918(var4) : null;
            if (var5 == null) {
               return false;
            } else {
               this.m_1435(var4, var5.hit(), true);
               return true;
            }
         } else {
            return false;
         }
      }
   }

   private Vec3d m_3400(BlockPos var1, Direction var2) {
      VoxelShape var3 = f_5909.world.getBlockState(var1).getOutlineShape(f_5909.world, var1, ShapeContext.of(f_5909.player));
      if (var3.isEmpty()) {
         return null;
      } else {
         Box var4 = var3.getBoundingBox();
         Vec3d var5 = var4.getCenter();
         double var6 = var2 == Direction.WEST ? var4.minX : (var2 == Direction.EAST ? var4.maxX : var5.x);
         double var8 = var2 == Direction.DOWN ? var4.minY : (var2 == Direction.UP ? var4.maxY : var5.y);
         double var10 = var2 == Direction.NORTH ? var4.minZ : (var2 == Direction.SOUTH ? var4.maxZ : var5.z);
         return new Vec3d(var1.getX() + var6, var1.getY() + var8, var1.getZ() + var10);
      }
   }

   private Util10 m_1398(CrystalAura.rykxIRxnR0LNxLQg var1) {
      if (var1.kind() != CrystalAura.gYShz1ijBLWFbRWb.ATTACK_CRYSTAL) {
         return this.m_1119(var1.hit().getPos());
      } else if (this.f_13994.m_1163()) {
         return this.m_2692(var1.crystal());
      } else {
         CrystalAura.jomZbuWdEigmeGwg var2 = this.m_3089(var1.pos());
         if (var2 != null) {
            Util10 var3 = this.m_1119(var2.hit().getPos());
            if (MathUtil5.O(var1.crystal(), var3.m_2643(), var3.m_2573(), this.m_1353(), this.f_13994.m_1163())) {
               if (var1.pos().equals(this.f_14024)) {
                  this.f_14025 = var2.hit();
               }

               return var3;
            }
         }

         return this.m_1119(var1.crystal().getBoundingBox().getCenter());
      }
   }

   private void m_1377() {
      if (!f_5909.player.getOffHandStack().isOf(Items.END_CRYSTAL)) {
         this.m_2800(this.m_3386(Items.END_CRYSTAL));
      }
   }

   private float m_113(PlayerEntity var1) {
      float var2 = var1.getHealth() + var1.getAbsorptionAmount();
      if (var2 <= this.f_13989.m_4046()) {
         return 1.0F;
      } else {
         float var3 = this.m_394(var1) ? Math.min(this.f_13987.m_4046(), this.f_13988.m_4046()) : this.f_13987.m_4046();
         return Math.min(var3, Math.max(1.0F, var2));
      }
   }

   private boolean m_4075(BlockPos var1) {
      return var1 != null && f_5909.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1)) <= this.m_2773() * this.m_2773();
   }

   private void m_478(BlockPos var1, BlockState var2) {
      CrystalAura.YHCQXQRdsmtmi4vz var3 = this.f_14029.get();
      if (var3 != null && var3.pos().equals(var1)) {
         var3.confirmation().m_545(var2.isOf(Blocks.OBSIDIAN));
      }

      CrystalAura.YHCQXQRdsmtmi4vz var4 = this.f_14018.get();
      if (var4 != null && var4.pos().equals(var1)) {
         var4.confirmation().m_545(var2.isAir());
      }
   }

   private boolean m_2941(BlockHitResult var1) {
      BlockState var2 = f_5909.world.getBlockState(var1.getBlockPos());
      return !var2.isReplaceable()
         && !var2.getCollisionShape(f_5909.world, var1.getBlockPos()).isEmpty()
         && (!this.f_13994.m_1163() || f_5909.player.isSneaking() || !Util138.m_4111(var2));
   }

   @EventHandler
   private void m_332(Util88 var1) {
      if (this.f_14000.m_1163() && f_5909.world != null && f_5909.gameRenderer != null) {
         Vec3d var2 = f_5909.gameRenderer.getCamera().getCameraPos();
         var1.m_213().push();
         var1.m_213().translate(-var2.x, -var2.y, -var2.z);
         long var3 = System.currentTimeMillis();
         Iterator var5 = this.f_14035.iterator();

         while (var5.hasNext()) {
            CrystalAura.H0EkYdlaE5DWDLwT var6 = (CrystalAura.H0EkYdlaE5DWDLwT)var5.next();
            float var7 = (float)(var3 - var6.createdAt()) / f_14087;
            if (var7 >= 1.0F) {
               var5.remove();
            } else {
               int var8 = var6.type() == CrystalAura.Kcj5pdxmLyT1GeTx.OBSIDIAN ? f_14088 : EnergyClient.getTheme(0);
               int var9 = Util71.m_3389(var8, Math.round((1.0F - var7) * f_14089));
               RenderUtil25.m_724(new Box(var6.pos()).expand(f_14090 * var7), var9, true, true);
            }
         }

         if (this.f_14006 != null) {
            double var10 = MathHelper.clamp((1.0F - this.f_14009) * f_14091, 0.0F, f_14092);
            RenderUtil25.m_724(new Box(this.f_14006).expand(-var10), Util71.m_3389(f_14093, 210), true, true);
         } else if (this.f_14004 != null) {
            int var11 = this.f_14005 ? f_14094 : EnergyClient.getTheme(0);
            RenderUtil25.m_724(new Box(this.f_14004), Util71.m_3389(var11, 150), true, true);
         }

         RenderUtil25.m_1569(var1.m_213());
         var1.m_213().pop();
      }
   }

   private void m_1757() {
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null && !f_5909.player.isSpectator()) {
         Util10 var1 = null;
         if (this.f_14023 != null) {
            var1 = this.m_1398(this.f_14023);
         } else if (this.f_14006 != null) {
            var1 = this.m_1119(this.m_3015());
         } else if (this.f_14024 != null) {
            CrystalAura.jomZbuWdEigmeGwg var2 = this.m_3089(this.f_14024);
            if (var2 != null) {
               this.f_14025 = var2.hit();
               var1 = this.m_1119(this.f_14025.getPos());
            } else if (this.f_14027 >= 0) {
               var1 = this.m_1119(Vec3d.ofBottomCenter(this.f_14024.up()));
            }
         }

         if (var1 == null) {
            this.m_76();
         } else {
            this.m_3363(var1);
         }
      }
   }

   private List<PlayerEntity> m_2420() {
      double var1 = this.f_13984.m_4046() * this.f_13984.m_4046();
      return f_5909.world
         .getPlayers()
         .stream()
         .filter(var0 -> var0 != f_5909.player && var0.isAlive() && !var0.isSpectator())
         .filter(var2 -> f_5909.player.squaredDistanceTo(var2) <= var1)
         .filter(var1x -> !this.f_13999.m_1163() || InitManager.f_2740.f_2744 == null || !InitManager.f_2740.f_2744.m_3914(var1x))
         .filter(var0 -> !AntiBot.m_79(var0))
         .sorted(Comparator.comparingDouble(f_5909.player::squaredDistanceTo))
         .limit(f_14095)
         .map(var0 -> (PlayerEntity)var0)
         .toList();
   }

   private boolean m_209(BlockPos var1) {
      return f_5909.world.isAir(var1.up()) && this.m_3760(var1);
   }

   private void m_424(boolean var1) {
      PlayerInput var2 = f_5909.player.input.playerInput;
      f_5909.player
         .networkHandler
         .sendPacket(new PlayerInputC2SPacket(new PlayerInput(var2.forward(), var2.backward(), var2.left(), var2.right(), var2.jump(), var1, var2.sprint())));
   }

   private boolean m_3156(BlockPos var1) {
      return !f_5909.world.getBlockState(var1).isReplaceable() ? false : f_5909.world.canPlace(Blocks.OBSIDIAN.getDefaultState(), var1, ShapeContext.absent());
   }

   private boolean m_3076(EndCrystalEntity var1) {
      CrystalAura.Inner_4hAITp8s5cmvnS7E var2 = this.m_896();
      if (var2 == null) {
         return false;
      } else {
         boolean var3;
         try {
            f_5909.interactionManager.attackEntity(f_5909.player, var1);
            f_5909.player.swingHand(Hand.MAIN_HAND);
            var3 = true;
         } finally {
            this.m_939(var2);
         }

         return var3;
      }
   }

   private Util99.SfIKBt5vqdTr90GS m_128(BlockPos var1) {
      boolean var2 = !this.m_3367(var1);
      if (!var2 || this.f_13993.m_1163() && this.m_2705(Items.OBSIDIAN)) {
         return this.m_3760(var1) && this.m_3927(var1)
            ? Util99.m_1750(
               var1,
               var2,
               this.m_2773(),
               f_5909.player.isSneaking(),
               var1x -> !this.m_2583(var1x)
                  && !Util138.m_3050().m_1948(this, var1x)
                  && !new Box(var1x).intersects(f_5909.player.getBoundingBox())
                  && !var1x.equals(f_5909.player.getBlockPos().down())
            )
            : null;
      } else {
         return null;
      }
   }

   private int m_1693() {
      int var1 = f_5909.player.getInventory().getSelectedSlot();
      StatusEffectInstance var2 = f_5909.player.getStatusEffect(StatusEffects.WEAKNESS);
      if (this.f_13995.m_1163() && var2 != null) {
         StatusEffectInstance var3 = f_5909.player.getStatusEffect(StatusEffects.STRENGTH);
         double var4 = (var2.getAmplifier() + 1) * f_14153 - (var3 == null ? 0.0 : (var3.getAmplifier() + 1) * f_14154);
         if (this.m_3533(f_5909.player.getMainHandStack()) > var4) {
            return var1;
         } else {
            for (int var6 = 0; var6 < 9; var6++) {
               if (this.m_3533(f_5909.player.getInventory().getStack(var6)) > var4) {
                  return var6;
               }
            }

            return -1;
         }
      } else {
         return var1;
      }
   }

   private CrystalAura.jomZbuWdEigmeGwg m_2918(BlockPos var1) {
      return this.m_814(var1, this.f_13994.m_1163());
   }

   private boolean m_3927(BlockPos var1) {
      return this.m_885(f_5909.player.getEyePos(), this.m_4022(var1)) <= this.m_1353() * this.m_1353();
   }

   private CrystalAura.Ar1aPP5f2zSjorN3 m_3449(List<PlayerEntity> var1, float var2, boolean var3) {
      CrystalAura.Ar1aPP5f2zSjorN3 var4 = null;
      int var5 = 0;

      for (PlayerEntity var7 : var1) {
         Util96.wzUwRrngJnenpZwo var8 = this.m_394(var7)
            ? new Util96.wzUwRrngJnenpZwo(var7.getBoundingBox(), var7.getEntityPos())
            : Util96.m_2264(var7, Math.round(this.f_13992.m_4046()));
         Vec3d var9 = var8.position();
         BlockPos var10 = BlockPos.ofFloored(var9);

         for (int var11 = 0; var11 <= 3; var11++) {
            for (int var12 = -var11; var12 <= var11; var12++) {
               for (int var13 = -var11; var13 <= var11; var13++) {
                  if (Math.max(Math.abs(var12), Math.abs(var13)) == var11) {
                     for (int var17 : f_13983) {
                        if (var12 != 0 || var13 != 0 || var17 <= -3) {
                           if (++var5 > 180) {
                              return var4;
                           }

                           BlockPos var18 = var10.add(var12, var17, var13);
                           if (!this.m_2583(var18) && this.m_3927(var18) && this.m_209(var18)) {
                              CrystalAura.jomZbuWdEigmeGwg var19;
                              if (var3) {
                                 if (this.m_3367(var18) || !this.m_3156(var18)) {
                                    continue;
                                 }

                                 var19 = this.m_2918(var18);
                              } else {
                                 if (!this.m_3367(var18)) {
                                    continue;
                                 }

                                 var19 = this.m_3089(var18);
                              }

                              if (var19 != null) {
                                 if (this.f_13994.m_1163() && var3) {
                                    Util99.SfIKBt5vqdTr90GS var20 = this.m_128(var18);
                                    if (var20 == null || !var20.removedBlocks().isEmpty()) {
                                       continue;
                                    }
                                 }

                                 Vec3d var30 = Vec3d.ofBottomCenter(var18.up());
                                 float var21 = var3 ? Util35.O(var30, var7, var8.box(), var18, (BlockPos)null) : Util35.O(var30, var7, var8.box());
                                 float var22 = var8.box().equals(var7.getBoundingBox())
                                    ? var21
                                    : Math.min(var21, var3 ? Util35.O(var30, var7, var7.getBoundingBox(), var18, (BlockPos)null) : Util35.O(var30, var7));
                                 if (!(var22 < this.m_113(var7))) {
                                    float var23 = var3
                                       ? Util35.O(var30, f_5909.player, f_5909.player.getBoundingBox(), var18, (BlockPos)null)
                                       : Util35.O(var30, f_5909.player);
                                    float var24 = var3 ? this.m_1057(var30, var18, (BlockPos)null) : this.m_1453(var30);
                                    if (!(var23 > var2)
                                       && (!(var23 > this.f_13990.m_4046()) || !(var23 >= var22))
                                       && (!(var24 > this.f_13990.m_4046()) || !(var24 >= var22))) {
                                       double var25 = var18.getX() + f_14096 - var9.x;
                                       double var27 = var18.getZ() + f_14097 - var9.z;
                                       float var29 = var22 - var23 * 2.0F - var24 * 2.0F - (float)Math.sqrt(var25 * var25 + var27 * var27) * f_14098;
                                       if (var3) {
                                          var29 -= f_14099;
                                       }

                                       if (var12 == 0 && var13 == 0) {
                                          var29 += 2.0F;
                                       }

                                       if (var4 == null || var29 > var4.score()) {
                                          var4 = new CrystalAura.Ar1aPP5f2zSjorN3(var18, var29, var19.hit());
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var4;
   }

   private void m_1655() {
      if (this.f_14024 != null) {
         Util138.m_3050()
            .m_4125(this, this.f_14006 == null ? List.of(this.f_14024, this.f_14024.up()) : List.of(this.f_14024, this.f_14024.up(), this.f_14006));
      }
   }

   private void m_3581() {
      if (this.f_14006 != null) {
         if (!this.m_900()) {
            if (this.f_13994.m_1163()) {
               Util99.SfIKBt5vqdTr90GS var1 = this.m_128(this.f_14017);
               if (var1 != null && var1.nextBlock() != null && !this.f_14006.equals(var1.nextBlock())) {
                  if (this.m_1126()) {
                     this.m_3149(var1.nextBlock(), this.f_14017);
                  }

                  return;
               }
            }

            BlockState var2 = f_5909.world.getBlockState(this.f_14006);
            if (var2.getHardness(f_5909.world, this.f_14006) < 0.0F || f_5909.player.age > this.f_14016 || f_5909.player.age - this.f_14007 > 60) {
               this.m_2539();
            }
         }
      }
   }

   private CrystalAura.jomZbuWdEigmeGwg m_3089(BlockPos var1) {
      return this.m_361(var1, this.f_13994.m_1163());
   }

   private void m_3291() {
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null && !f_5909.player.isSpectator()) {
         if (!this.f_13994.m_1163()) {
            this.m_1447();
         }

         if (!this.f_13994.m_1163() || f_5909.currentScreen == null && !f_5909.player.isUsingItem() && !f_5909.player.hasVehicle()) {
            this.m_1852();
            this.m_1617();
            List var1 = this.m_2420();
            if (var1.isEmpty()) {
               this.f_14023 = null;
               this.m_1318();
               this.m_1094(true);
               this.m_1447();
               this.f_14004 = null;
               this.m_76();
            } else {
               this.m_4096(var1);
               if (this.f_14024 != null && (f_5909.player.age - this.f_14026 > 240 || !this.m_3927(this.f_14024))) {
                  if (this.f_14017 != null && this.f_14017.equals(this.f_14024)) {
                     this.m_1094(true);
                  }

                  if (this.f_14023 != null && this.f_14023.pos().equals(this.f_14024)) {
                     this.f_14023 = null;
                     this.m_76();
                  }

                  this.m_1318();
               }

               if (this.f_14006 == null && !this.m_3279()) {
                  this.f_14023 = null;
                  this.m_76();
               } else {
                  float var2 = this.m_2009();
                  if (this.f_14023 != null) {
                     if (f_5909.player.age - this.f_14023.createdTick() <= 20 && this.m_3534(this.f_14023)) {
                        return;
                     }

                     this.f_14023 = null;
                     this.m_76();
                  }

                  boolean var3 = this.m_1126();
                  if (this.f_14006 != null) {
                     if (!this.m_900()) {
                        if (!this.m_319()) {
                           if (!this.m_3614(var1)) {
                              this.m_1094(true);
                              this.m_1318();
                              this.m_76();
                           } else {
                              EndCrystalEntity var7 = var3 ? this.m_1007(var1, var2) : null;
                              if (var7 != null) {
                                 this.m_1094(true);
                                 if (this.f_14012 < 9) {
                                    this.m_1513(var7);
                                 }
                              } else {
                                 this.m_3581();
                              }
                           }
                        }
                     }
                  } else if (var3) {
                     PlayerEntity var4 = (PlayerEntity)var1.get(0);
                     if (!this.f_13998.m_1163() || !this.m_2899(var4)) {
                        if (!this.m_3237(var1, var2)) {
                           EndCrystalEntity var5 = this.m_1007(var1, var2);
                           if (var5 != null) {
                              this.m_1513(var5);
                           } else {
                              if (this.m_2705(Items.END_CRYSTAL)) {
                                 CrystalAura.Ar1aPP5f2zSjorN3 var6 = this.m_3449(var1, var2, false);
                                 if (var6 != null) {
                                    this.m_3854(var6.pos());
                                    this.m_1695(var6.pos(), var6.hit());
                                    return;
                                 }
                              }

                              if (this.f_13993.m_1163() && this.m_2705(Items.END_CRYSTAL) && this.m_2705(Items.OBSIDIAN)) {
                                 CrystalAura.Ar1aPP5f2zSjorN3 var8 = this.m_3449(var1, var2, true);
                                 if (var8 != null) {
                                    this.m_3854(var8.pos());
                                    this.m_1435(var8.pos(), var8.hit(), false);
                                    return;
                                 }
                              }

                              if (this.f_13997.m_1163() && this.m_2705(Items.END_CRYSTAL)) {
                                 CrystalAura.R0fg9fV7FWlxZXys var9 = this.m_3661(var1, var2);
                                 if (var9 != null) {
                                    this.m_3854(var9.base());
                                    this.m_3149(var9.blocker(), var9.base());
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         } else {
            this.f_14023 = null;
            this.m_1318();
            this.m_1094(true);
            this.m_1447();
            this.m_76();
         }
      } else {
         this.f_14023 = null;
         this.m_1094(true);
         this.m_1447();
         this.m_76();
         this.m_894();
      }
   }

   private void m_1617() {
      int var1 = f_5909.player.age;
      this.f_14034
         .entrySet()
         .removeIf(var1x -> !(var1 <= var1x.getValue() && f_5909.world.getEntityById(var1x.getKey()) instanceof EndCrystalEntity var3) || !var3.isAlive());
   }

   private CrystalAura.Inner_0b6mbNXHOZeb7efh m_2919(Item var1) {
      int var2 = f_5909.player.getInventory().getSelectedSlot();
      if (f_5909.player.getMainHandStack().isOf(var1)) {
         return new CrystalAura.Inner_0b6mbNXHOZeb7efh(Hand.MAIN_HAND, var2, var2, -1, false);
      } else if (f_5909.player.getOffHandStack().isOf(var1)) {
         return new CrystalAura.Inner_0b6mbNXHOZeb7efh(Hand.OFF_HAND, var2, var2, -1, false);
      } else {
         int var3 = this.m_3386(var1);
         if (var3 != -1) {
            if (this.f_13994.m_1163()) {
               return null;
            } else {
               f_5909.player.getInventory().setSelectedSlot(var3);
               ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
               return new CrystalAura.Inner_0b6mbNXHOZeb7efh(Hand.MAIN_HAND, var2, var3, -1, false);
            }
         } else if (this.f_13994.m_1163()) {
            return null;
         } else {
            int var4 = this.m_613(var1, 9, 36);
            int var5 = this.m_309(var4);
            if (var4 != -1 && var5 != -1 && f_5909.player.currentScreenHandler.getCursorStack().isEmpty()) {
               f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var5, var2, SlotActionType.SWAP, f_5909.player);
               if (!f_5909.player.getMainHandStack().isOf(var1)) {
                  f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var5, var2, SlotActionType.SWAP, f_5909.player);
                  return null;
               } else {
                  return new CrystalAura.Inner_0b6mbNXHOZeb7efh(Hand.MAIN_HAND, var2, var2, var5, true);
               }
            } else {
               return null;
            }
         }
      }
   }

   private double m_1353() {
      return this.f_13994.m_1163() ? Math.min((double)this.f_13986.m_4046(), f_5909.player.getEntityInteractionRange()) : this.f_13986.m_4046();
   }

   private float m_1098(Vec3d var1, BlockPos var2) {
      if (InitManager.f_2740.f_2744 == null) {
         return 0.0F;
      } else {
         float var3 = 0.0F;

         for (PlayerEntity var5 : f_5909.world.getPlayers()) {
            if (var5 != f_5909.player && var5.isAlive() && InitManager.f_2740.f_2744.m_3914(var5)) {
               float var6 = var2 == null ? Util35.O(var1, var5) : Util35.O(var1, var5, var5.getBoundingBox(), var2);
               var3 = Math.max(var3, var6);
            }
         }

         return var3;
      }
   }

   private void m_4096(List<PlayerEntity> var1) {
      BlockPos var2 = this.f_14030;
      this.f_14030 = null;
      if (var2 != null) {
         CrystalAura.YHCQXQRdsmtmi4vz var3 = this.f_14029.get();
         if (this.f_14024 == null
            && this.f_14023 == null
            && this.f_14006 == null
            && this.m_3367(var2)
            && this.m_3927(var2)
            && this.m_2705(Items.END_CRYSTAL)
            && this.m_2088(var2, var1, this.m_2009())) {
            this.m_3854(var2);
            this.f_14029.set(var3);
            this.f_14027 = f_5909.player.age;
            this.m_3789();
         } else if (this.f_14024 == null) {
            this.m_3494();
         }
      }
   }

   private CrystalAura.Inner_4hAITp8s5cmvnS7E m_896() {
      int var1 = f_5909.player.getInventory().getSelectedSlot();
      StatusEffectInstance var2 = f_5909.player.getStatusEffect(StatusEffects.WEAKNESS);
      if (this.f_13995.m_1163() && var2 != null) {
         double var3 = 0.0;
         StatusEffectInstance var5 = f_5909.player.getStatusEffect(StatusEffects.STRENGTH);
         if (var5 != null) {
            var3 = (var5.getAmplifier() + 1) * f_14101;
         }

         double var6 = (var2.getAmplifier() + 1) * f_14102 - var3;
         if (this.m_3533(f_5909.player.getMainHandStack()) > var6) {
            return new CrystalAura.Inner_4hAITp8s5cmvnS7E(var1, var1, -1, false);
         } else {
            int var8 = -1;
            double var9 = Double.NEGATIVE_INFINITY;

            for (int var11 = 0; var11 < (this.f_13994.m_1163() ? 9 : 36); var11++) {
               ItemStack var12 = f_5909.player.getInventory().getStack(var11);
               if (!var12.isEmpty()) {
                  double var13 = this.m_3533(var12);
                  if (var13 > var9) {
                     var9 = var13;
                     var8 = var11;
                  }
               }
            }

            if (var8 == -1 || var9 <= var6) {
               return null;
            } else if (var8 < 9) {
               f_5909.player.getInventory().setSelectedSlot(var8);
               ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
               return new CrystalAura.Inner_4hAITp8s5cmvnS7E(var1, var8, -1, false);
            } else {
               int var15 = this.m_309(var8);
               if (var15 != -1 && f_5909.player.currentScreenHandler.getCursorStack().isEmpty()) {
                  f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var15, var1, SlotActionType.SWAP, f_5909.player);
                  if (this.m_3533(f_5909.player.getMainHandStack()) <= var6) {
                     f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var15, var1, SlotActionType.SWAP, f_5909.player);
                     return null;
                  } else {
                     return new CrystalAura.Inner_4hAITp8s5cmvnS7E(var1, var1, var15, true);
                  }
               } else {
                  return null;
               }
            }
         }
      } else {
         return new CrystalAura.Inner_4hAITp8s5cmvnS7E(var1, var1, -1, false);
      }
   }

   private boolean m_3363(Util10 var1) {
      if (!this.m_2519()) {
         return false;
      } else {
         Util54 var2 = Util54.m_1085();
         Util54.m_2145(var1, this.f_13994.m_1163() ? f_14123 : f_14124, this.f_13994.m_1163() ? f_14125 : f_14126, f_14127, f_14128, 2, 110, false);
         if (var2.m_2266() != 110) {
            return false;
         } else {
            this.f_14031 = var1;
            this.f_14032 = true;
            return true;
         }
      }
   }

   private BlockPos m_2451(BlockPos var1) {
      BlockPos var2 = var1.up();
      BlockState var3 = f_5909.world.getBlockState(var2);
      if (!var3.isAir() && var3.getFluidState().isEmpty()) {
         return var3.getHardness(f_5909.world, var2) >= 0.0F ? var2 : null;
      } else {
         return null;
      }
   }

   private void m_3854(BlockPos var1) {
      if (this.f_14024 == null || !this.f_14024.equals(var1)) {
         this.m_3494();
         this.f_14024 = var1.toImmutable();
         this.f_14025 = null;
         this.f_14027 = -1;
         this.f_14028 = -1;
      }

      this.m_1655();
      this.m_1577();
   }

   private void m_1695(BlockPos var1, BlockHitResult var2) {
      if (this.f_13994.m_1163()) {
         this.m_1377();
      }

      if (var1.equals(this.f_14024)) {
         this.f_14025 = var2;
      }

      this.f_14023 = new CrystalAura.rykxIRxnR0LNxLQg(
         CrystalAura.gYShz1ijBLWFbRWb.PLACE_CRYSTAL, var1.toImmutable(), null, Items.END_CRYSTAL, var2, f_5909.player.age
      );
   }

   private boolean m_1126() {
      return f_5909.player.age - this.f_14003 >= 2 && System.currentTimeMillis() - this.f_14002 >= Math.max(f_14086, (long)this.f_13991.m_4046());
   }

   private void m_3124(String var1) {
      if (this.f_14001.m_1163()) {
         System.out.println("[CrystalAura] " + var1);
      }
   }

   private boolean m_3367(BlockPos var1) {
      BlockState var2 = f_5909.world.getBlockState(var1);
      return var2.isOf(Blocks.OBSIDIAN) || var2.isOf(Blocks.BEDROCK);
   }

   private float m_2009() {
      return this.f_13996.m_1163()
         ? Math.max(0.0F, Math.min(this.f_13990.m_4046(), f_5909.player.getHealth() + f_5909.player.getAbsorptionAmount() - 1.0F))
         : this.f_13990.m_4046();
   }

   private boolean m_1854(CrystalAura.rykxIRxnR0LNxLQg var1) {
      return var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.ATTACK_CRYSTAL
         ? this.m_1693() == f_5909.player.getInventory().getSelectedSlot()
         : f_5909.player.getMainHandStack().isOf(var1.item()) || f_5909.player.getOffHandStack().isOf(var1.item());
   }

   @EventHandler
   private void m_3527(Util68 var1) {
      if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
         if (this.f_14023 != null) {
            this.m_2262();
         } else {
            if (this.f_14006 != null) {
               this.m_2821();
            }
         }
      }
   }

   private boolean m_3614(List<PlayerEntity> var1) {
      if (!this.f_13997.m_1163()
         || !this.m_2705(Items.END_CRYSTAL)
         || this.f_14017 == null
         || this.f_14006 == null
         || var1.isEmpty()
         || !this.m_3927(this.f_14017)
         || !this.m_4075(this.f_14006)) {
         return false;
      } else if (this.f_13994.m_1163()) {
         Util99.SfIKBt5vqdTr90GS var4 = this.m_128(this.f_14017);
         return var4 != null
            && var4.removedBlocks().contains(this.f_14006)
            && this.m_2375(this.f_14017, var4.removedBlocks(), var1, this.m_2009()) > Float.NEGATIVE_INFINITY;
      } else {
         BlockState var2 = f_5909.world.getBlockState(this.f_14006);
         boolean var3 = this.f_14017.equals(this.f_14006);
         if (!var3) {
            if (!this.f_14006.equals(this.f_14017.up()) || !this.m_3760(this.f_14017)) {
               return false;
            } else {
               return var2.isAir()
                  ? this.m_2088(this.f_14017, var1, this.m_2009())
                  : var2.getHardness(f_5909.world, this.f_14006) >= 0.0F && this.m_3262(this.f_14017, this.f_14006, var1, this.m_2009());
            }
         } else {
            return this.f_13993.m_1163() && this.m_2705(Items.OBSIDIAN)
               ? (var2.isAir() || var2.isReplaceable() || var2.getHardness(f_5909.world, this.f_14006) >= 0.0F)
                  && this.m_814(this.f_14017, false) != null
                  && this.m_2162(this.f_14017, var1, this.m_2009())
               : false;
         }
      }
   }

   private boolean m_2807(Vec3d var1, Vec3d var2, BlockPos var3, Direction var4) {
      BlockHitResult var5 = f_5909.world.raycast(new RaycastContext(var1, var2, ShapeType.OUTLINE, FluidHandling.NONE, f_5909.player));
      return var5.getType() == Type.BLOCK && var5 instanceof BlockHitResult var6 && var6.getBlockPos().equals(var3) && var6.getSide() == var4;
   }

   private Util10 m_1119(Vec3d var1) {
      Vec3d var2 = var1.subtract(f_5909.player.getEyePos());
      double var3 = Math.hypot(var2.x, var2.z);
      float var5 = MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(var2.z, var2.x)) - f_14108);
      float var6 = MathHelper.clamp((float)(-Math.toDegrees(Math.atan2(var2.y, var3))), f_14109, f_14110);
      return new Util10(var5, var6);
   }

   private void m_1447() {
      if (f_5909.player != null
         && this.f_14020 != -1
         && (this.f_14021 == f_5909.player.getInventory().getSelectedSlot() || f_5909.player.getInventory().getSelectedSlot() == this.f_14020)) {
         f_5909.player.getInventory().setSelectedSlot(this.f_14020);
         if (f_5909.interactionManager != null) {
            ((ClientPlayerInteractionManagerMixin2)f_5909.interactionManager).invokeSyncSelectedSlot();
         }
      }

      this.f_14020 = -1;
      this.f_14021 = -1;
      this.f_14022 = -1;
   }

   private boolean m_900() {
      if (this.f_14006 == null) {
         return false;
      } else {
         BlockState var1 = f_5909.world.getBlockState(this.f_14006);
         if (!var1.isAir()) {
            if (this.f_14019 >= 0) {
               this.m_2539();
               return true;
            } else {
               return false;
            }
         } else {
            if (this.f_14019 < 0) {
               this.f_14019 = f_5909.player.age;
            }

            CrystalAura.YHCQXQRdsmtmi4vz var2 = this.f_14018.get();
            Util105.cVP3VyoKPbwWD3Cr var3 = var2 == null ? Util105.cVP3VyoKPbwWD3Cr.WAITING : var2.confirmation().m_2228(f_5909.player.age, true);
            if (var3 == Util105.cVP3VyoKPbwWD3Cr.CONFIRMED) {
               BlockPos var4 = this.f_14006;
               this.m_3124("dig complete " + var4.toShortString());
               this.m_1101(var4, CrystalAura.Kcj5pdxmLyT1GeTx.DIG);
               this.m_1094(true);
               this.m_1577();
               this.m_3789();
               return true;
            } else {
               if (var3 == Util105.cVP3VyoKPbwWD3Cr.REJECTED || f_5909.player.age - this.f_14019 > 40) {
                  this.m_2539();
               }

               return true;
            }
         }
      }
   }

   private boolean m_319() {
      if (this.f_14006 != null && this.f_14017 != null && this.f_14017.equals(this.f_14006) && this.m_3367(this.f_14006)) {
         this.m_3124("base became ready " + this.f_14006.toShortString());
         this.m_1094(true);
         this.m_1577();
         this.f_14002 = System.currentTimeMillis();
         return true;
      } else {
         return false;
      }
   }

   private void m_894() {
      this.f_14002 = 0L;
      this.f_14003 = -2;
      this.f_14004 = null;
      this.f_14005 = false;
      this.f_14023 = null;
      this.f_14006 = null;
      this.f_14017 = null;
      this.f_14010 = -1;
      this.f_14011 = -1;
      this.f_14007 = 0;
      this.f_14009 = 0.0F;
      this.f_14016 = 0;
      this.f_14018.set(null);
      this.f_14019 = -1;
      this.f_14020 = -1;
      this.f_14021 = -1;
      this.f_14022 = -1;
      this.f_14030 = null;
      this.f_14034.clear();
      this.m_1318();
      this.f_14031 = null;
      this.f_14032 = false;
      this.f_14033.clear();
      this.f_14035.clear();
   }

   private float m_2450(EndCrystalEntity var1, List<PlayerEntity> var2, float var3) {
      if (this.f_13994.m_1163() && this.m_2692(var1) == null) {
         return Float.NEGATIVE_INFINITY;
      } else {
         float var4 = Util35.O(var1.getEntityPos(), f_5909.player);
         if (var4 > var3) {
            return Float.NEGATIVE_INFINITY;
         } else {
            float var5 = 0.0F;
            boolean var6 = false;

            for (PlayerEntity var8 : var2) {
               float var9 = Util35.O(var1.getEntityPos(), var8);
               var5 = Math.max(var5, var9);
               if (var9 >= this.m_113(var8)) {
                  var6 = true;
               }
            }

            float var10 = this.m_1453(var1.getEntityPos());
            return var6 && (!(var4 > this.f_13990.m_4046()) || !(var4 >= var5)) && (!(var10 > this.f_13990.m_4046()) || !(var10 >= var5))
               ? var5 - var4 * 2.0F - var10 * 2.0F
               : Float.NEGATIVE_INFINITY;
         }
      }
   }

   private CrystalAura.R0fg9fV7FWlxZXys m_981(List<PlayerEntity> var1, float var2) {
      CrystalAura.R0fg9fV7FWlxZXys var3 = null;
      float var4 = Float.NEGATIVE_INFINITY;
      LinkedHashSet var5 = new LinkedHashSet();

      for (PlayerEntity var7 : var1) {
         BlockPos var8 = var7.getBlockPos();

         for (int var9 = 0; var9 <= 3; var9++) {
            for (int var10 = -var9; var10 <= var9; var10++) {
               for (int var11 = -var9; var11 <= var9; var11++) {
                  if (Math.max(Math.abs(var10), Math.abs(var11)) == var9) {
                     for (int var15 : f_13983) {
                        if (var10 != 0 || var11 != 0 || var15 <= -3) {
                           BlockPos var16 = var8.add(var10, var15, var11);
                           if (!this.m_2583(var16) && this.m_3927(var16) && this.m_3760(var16)) {
                              var5.add(var16);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      ArrayList<BlockPos> var17 = new ArrayList<>(var5);
      var17.sort(Comparator.comparingDouble(var0 -> f_5909.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var0))));
      int var18 = 0;

      for (BlockPos var20 : var17) {
         if (++var18 > 220) {
            break;
         }

         Util99.SfIKBt5vqdTr90GS var21 = this.m_128(var20);
         if (var21 != null && var21.nextBlock() != null) {
            float var22 = this.m_2375(var20, var21.removedBlocks(), var1, var2);
            double var24 = var1.stream()
               .mapToDouble(var1x -> Math.hypot(var20.getX() + f_14155 - var1x.getX(), var20.getZ() + f_14156 - var1x.getZ()))
               .min()
               .orElse(0.0);
            var22 -= var21.removedBlocks().size() * f_14140
               + (float)var24 * f_14141
               + Util10.m_3601().m_855(this.m_1119(Vec3d.ofCenter(var21.nextBlock()))) * f_14142;
            if (var22 > var4) {
               var4 = var22;
               var3 = new CrystalAura.R0fg9fV7FWlxZXys(var21.nextBlock(), var20);
            }
         }
      }

      return var3;
   }

   private boolean m_2705(Item var1) {
      if (f_5909.player.getOffHandStack().isOf(var1) || this.m_3386(var1) != -1) {
         return true;
      } else if (this.f_13994.m_1163()) {
         return false;
      } else {
         int var2 = this.m_613(var1, 9, 36);
         return var2 != -1 && this.m_309(var2) != -1 && f_5909.player.currentScreenHandler.getCursorStack().isEmpty();
      }
   }

   private void m_3677() {
      if (!this.f_14037) {
         EnergyClient.f_1622.f_1624.m_32(this.f_14036);
         this.f_14037 = true;
      }
   }

   private float m_2375(BlockPos var1, Set<BlockPos> var2, List<PlayerEntity> var3, float var4) {
      Vec3d var5 = Vec3d.ofBottomCenter(var1.up());
      BlockPos var6 = this.m_3367(var1) ? null : var1;
      float var7 = Util35.O(var5, f_5909.player, f_5909.player.getBoundingBox(), var6, var2);
      if (var7 > var4) {
         return Float.NEGATIVE_INFINITY;
      } else {
         float var8 = 0.0F;
         boolean var9 = false;

         for (PlayerEntity var11 : var3) {
            float var12 = Util35.O(var5, var11, var11.getBoundingBox(), var6, var2);
            var8 = Math.max(var8, var12);
            if (var12 >= this.m_113(var11)) {
               var9 = true;
            }
         }

         if (!var9) {
            return Float.NEGATIVE_INFINITY;
         } else {
            float var13 = 0.0F;
            if (InitManager.f_2740.f_2744 != null) {
               for (PlayerEntity var15 : f_5909.world.getPlayers()) {
                  if (var15 != f_5909.player && var15.isAlive() && InitManager.f_2740.f_2744.m_3914(var15)) {
                     var13 = Math.max(var13, Util35.O(var5, var15, var15.getBoundingBox(), var6, var2));
                  }
               }
            }

            return (!(var7 > this.f_13990.m_4046()) || !(var7 >= var8)) && (!(var13 > this.f_13990.m_4046()) || !(var13 >= var8))
               ? var8 - var7 * 2.0F - var13 * 2.0F
               : Float.NEGATIVE_INFINITY;
         }
      }
   }

   private int m_613(Item var1, int var2, int var3) {
      for (int var4 = var2; var4 < var3; var4++) {
         if (f_5909.player.getInventory().getStack(var4).isOf(var1)) {
            return var4;
         }
      }

      return -1;
   }

   private void m_3539(CrystalAura.rykxIRxnR0LNxLQg var1) {
      if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.ATTACK_CRYSTAL) {
         this.m_2800(this.m_1693());
      } else if (!f_5909.player.getMainHandStack().isOf(var1.item()) && !f_5909.player.getOffHandStack().isOf(var1.item())) {
         this.m_2800(this.m_3386(var1.item()));
      }
   }

   private boolean m_3237(List<PlayerEntity> var1, float var2) {
      if (this.f_14024 == null) {
         return false;
      } else if (f_5909.player.age - this.f_14026 <= 240 && this.m_3927(this.f_14024)) {
         if (this.f_14027 >= 0) {
            CrystalAura.YHCQXQRdsmtmi4vz var3 = this.f_14029.get();
            Util105.cVP3VyoKPbwWD3Cr var4 = var3 == null
               ? Util105.cVP3VyoKPbwWD3Cr.WAITING
               : var3.confirmation().m_2228(f_5909.player.age, this.m_3367(this.f_14024));
            if (var4 != Util105.cVP3VyoKPbwWD3Cr.CONFIRMED) {
               if (var4 == Util105.cVP3VyoKPbwWD3Cr.WAITING && f_5909.player.age - this.f_14027 <= 40) {
                  return true;
               }

               this.m_3124("obsidian unconfirmed " + this.f_14024.toShortString());
               this.f_14033.put(this.f_14024, f_5909.player.age + 40);
               this.m_1318();
               return false;
            }

            this.f_14027 = -1;
            this.m_3494();
         }

         EndCrystalEntity var6 = this.m_3627(this.f_14024);
         if (var6 != null) {
            if (this.m_3768(var6)) {
               return true;
            } else if (this.m_2450(var6, var1, var2) > Float.NEGATIVE_INFINITY) {
               this.m_1513(var6);
               return true;
            } else {
               this.m_1318();
               return false;
            }
         } else if (this.f_14028 >= 0) {
            if (f_5909.player.age - this.f_14028 <= 40) {
               return true;
            } else {
               this.m_3124("crystal spawn timed out " + this.f_14024.toShortString());
               this.f_14033.put(this.f_14024, f_5909.player.age + 40);
               this.m_1318();
               return false;
            }
         } else {
            if (this.f_13994.m_1163() && this.f_13997.m_1163() && this.m_3760(this.f_14024)) {
               Util99.SfIKBt5vqdTr90GS var7 = this.m_128(this.f_14024);
               if (var7 == null) {
                  this.m_1318();
                  return false;
               }

               if (var7.nextBlock() != null) {
                  if (this.m_2375(this.f_14024, var7.removedBlocks(), var1, var2) > Float.NEGATIVE_INFINITY) {
                     this.m_3149(var7.nextBlock(), this.f_14024);
                     return this.f_14006 != null;
                  }

                  this.m_1318();
                  return false;
               }
            }

            if (!this.m_3367(this.f_14024)) {
               BlockState var9 = f_5909.world.getBlockState(this.f_14024);
               if (var9.isReplaceable()) {
                  if (this.f_14027 >= 0 && f_5909.player.age - this.f_14027 <= 40) {
                     return true;
                  } else {
                     this.f_14027 = -1;
                     if (this.f_13993.m_1163() && this.m_2705(Items.OBSIDIAN) && this.m_3156(this.f_14024) && this.m_2162(this.f_14024, var1, var2)) {
                        CrystalAura.jomZbuWdEigmeGwg var10 = this.m_2918(this.f_14024);
                        if (var10 == null) {
                           this.m_1318();
                           return false;
                        } else {
                           this.m_1435(this.f_14024, var10.hit(), false);
                           return true;
                        }
                     } else {
                        this.m_1318();
                        return false;
                     }
                  }
               } else if (this.f_13997.m_1163()
                  && this.f_13993.m_1163()
                  && this.m_2705(Items.OBSIDIAN)
                  && var9.getHardness(f_5909.world, this.f_14024) >= 0.0F
                  && !this.m_2583(this.f_14024)
                  && this.m_4075(this.f_14024)
                  && this.m_814(this.f_14024, false) != null
                  && this.m_2162(this.f_14024, var1, var2)) {
                  this.m_3149(this.f_14024, this.f_14024);
                  return true;
               } else {
                  this.m_1318();
                  return false;
               }
            } else if (!this.m_2705(Items.END_CRYSTAL)) {
               this.m_1318();
               return false;
            } else if (!this.m_3760(this.f_14024)) {
               this.m_1318();
               return false;
            } else {
               BlockPos var8 = this.m_2451(this.f_14024);
               if (var8 != null) {
                  if (this.f_13997.m_1163() && !this.m_2583(var8) && this.m_4075(var8) && this.m_3262(this.f_14024, var8, var1, var2)) {
                     this.m_3149(var8, this.f_14024);
                     return true;
                  } else {
                     this.m_1318();
                     return false;
                  }
               } else if (!this.m_209(this.f_14024)) {
                  this.m_1318();
                  return false;
               } else if (!this.m_2088(this.f_14024, var1, var2)) {
                  this.m_1318();
                  return false;
               } else {
                  CrystalAura.jomZbuWdEigmeGwg var5 = this.m_3089(this.f_14024);
                  if (var5 == null) {
                     this.m_1318();
                     return false;
                  } else {
                     this.m_1695(this.f_14024, var5.hit());
                     return true;
                  }
               }
            }
         }
      } else {
         this.m_1318();
         return false;
      }
   }

   private double m_3533(ItemStack var1) {
      AttributeModifiersComponent var2 = (AttributeModifiersComponent)var1.getOrDefault(
         DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT
      );
      double var3 = 1.0;
      double var5 = 0.0;
      double var7 = 0.0;
      double var9 = 1.0;

      for (Entry var12 : var2.modifiers()) {
         if (var12.attribute().equals(EntityAttributes.ATTACK_DAMAGE) && var12.slot().matches(EquipmentSlot.MAINHAND)) {
            EntityAttributeModifier var13 = var12.modifier();
            switch (var13.operation()) {
               case ADD_VALUE:
                  var5 += var13.value();
                  break;
               case ADD_MULTIPLIED_BASE:
                  var7 += var13.value();
                  break;
               case ADD_MULTIPLIED_TOTAL:
                  var9 *= 1.0 + var13.value();
            }
         }
      }

      return (var3 + var5 + var3 * var7) * var9;
   }

   @EventHandler
   private void m_2743(EventPlaceBlock var1) {
      if (var1.m_2404() == Blocks.OBSIDIAN && f_5909.player != null && f_5909.world != null) {
         if (this.f_14024 == null && this.f_14023 == null && this.f_14006 == null) {
            this.f_14030 = var1.m_1421().toImmutable();
            this.m_3753(this.f_14030);
         }
      }
   }

   private boolean m_3534(CrystalAura.rykxIRxnR0LNxLQg var1) {
      if (this.m_2583(var1.pos())) {
         return false;
      } else if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.ATTACK_CRYSTAL) {
         if (var1.crystal() != null
            && var1.crystal().isAlive()
            && !(this.m_885(f_5909.player.getEyePos(), var1.crystal().getBoundingBox()) > this.m_1353() * this.m_1353())) {
            List var3 = this.m_2420();
            return !var3.isEmpty() && this.m_2450(var1.crystal(), var3, this.m_2009()) > Float.NEGATIVE_INFINITY;
         } else {
            return false;
         }
      } else if (var1.item() != null && this.m_2705(var1.item()) && var1.hit() != null) {
         if (!this.m_1858(f_5909.player.getEyePos(), var1.hit().getPos(), var1.hit().getBlockPos(), var1.hit().getSide(), this.f_13994.m_1163())) {
            return false;
         } else if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.PLACE_OBSIDIAN && !this.f_13993.m_1163()) {
            return false;
         } else if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.PLACE_SHIELD && !this.f_13998.m_1163()) {
            return false;
         } else if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.PLACE_CRYSTAL) {
            return this.m_3367(var1.pos()) && this.m_209(var1.pos()) && this.m_2941(var1.hit()) && this.m_94(var1.pos());
         } else if (this.m_3156(var1.pos()) && this.m_2941(var1.hit())) {
            if (var1.kind() == CrystalAura.gYShz1ijBLWFbRWb.PLACE_SHIELD) {
               return true;
            } else {
               List var2 = this.m_2420();
               return this.f_14024 != null && this.f_14024.equals(var1.pos()) && !var2.isEmpty() && this.m_2162(var1.pos(), var2, this.m_2009());
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private double m_885(Vec3d var1, Box var2) {
      double var3 = MathHelper.clamp(var1.x, var2.minX, var2.maxX);
      double var5 = MathHelper.clamp(var1.y, var2.minY, var2.maxY);
      double var7 = MathHelper.clamp(var1.z, var2.minZ, var2.maxZ);
      return var1.squaredDistanceTo(var3, var5, var7);
   }

   private Vec3d m_3015() {
      VoxelShape var1 = f_5909.world.getBlockState(this.f_14006).getOutlineShape(f_5909.world, this.f_14006, ShapeContext.of(f_5909.player));
      return var1.isEmpty()
         ? Vec3d.ofCenter(this.f_14006)
         : var1.getBoundingBox().getCenter().add(this.f_14006.getX(), this.f_14006.getY(), this.f_14006.getZ());
   }

   private boolean m_3768(EndCrystalEntity var1) {
      Integer var2 = this.f_14034.get(var1.getId());
      return var2 != null && f_5909.player.age <= var2;
   }

   private float m_1057(Vec3d var1, BlockPos var2, BlockPos var3) {
      if (InitManager.f_2740.f_2744 == null) {
         return 0.0F;
      } else {
         float var4 = 0.0F;

         for (PlayerEntity var6 : f_5909.world.getPlayers()) {
            if (var6 != f_5909.player && var6.isAlive() && InitManager.f_2740.f_2744.m_3914(var6)) {
               var4 = Math.max(var4, Util35.O(var1, var6, var6.getBoundingBox(), var2, var3));
            }
         }

         return var4;
      }
   }

   private CrystalAura.jomZbuWdEigmeGwg m_361(BlockPos var1, boolean var2) {
      CrystalAura.jomZbuWdEigmeGwg var3 = null;
      float var4 = f_14104;
      Util10 var5 = Util10.m_3601();
      Vec3d var6 = f_5909.player.getEyePos();
      if (var1.equals(this.f_14024) && this.f_14025 != null && this.m_1858(var6, this.f_14025.getPos(), var1, this.f_14025.getSide(), var2)) {
         return new CrystalAura.jomZbuWdEigmeGwg(this.f_14025);
      } else {
         for (Direction var10 : Direction.values()) {
            Vec3d var11 = Vec3d.ofCenter(var1).add(Vec3d.of(var10.getVector()).multiply(f_14105));
            if (this.m_1858(var6, var11, var1, var10, var2)) {
               if (var10 == Direction.UP) {
                  return new CrystalAura.jomZbuWdEigmeGwg(new BlockHitResult(var11, var10, var1, false));
               }

               Util10 var12 = this.m_1119(var11);
               float var13 = var5.m_855(var12);
               if (var13 < var4) {
                  var4 = var13;
                  var3 = new CrystalAura.jomZbuWdEigmeGwg(new BlockHitResult(var11, var10, var1, false));
               }
            }
         }

         return var3;
      }
   }

   private int m_3860(BlockPos var1) {
      BlockState var2 = f_5909.world.getBlockState(var1);
      int var3 = f_5909.player.getInventory().getSelectedSlot();
      ItemStack var4 = f_5909.player.getInventory().getStack(var3);
      float var5 = Util146.m_141(var2, var4) + var4.getEnchantments().getSize() * f_14150;

      for (int var6 = 0; var6 < (this.f_13994.m_1163() ? 9 : 36); var6++) {
         ItemStack var7 = f_5909.player.getInventory().getStack(var6);
         if (!var7.isEmpty()) {
            float var8 = Util146.m_141(var2, var7) + var7.getEnchantments().getSize() * f_14151;
            if (var8 > var5) {
               var5 = var8;
               var3 = var6;
            }
         }
      }

      return var3;
   }

   @EventHandler
   private void m_354(Util66 var1) {
      if (!var1.m_2586()) {
         if (var1.m_2068()) {
            if (var1.m_3295() instanceof PlayerActionResponseS2CPacket var7) {
               CrystalAura.YHCQXQRdsmtmi4vz var13 = this.f_14029.get();
               CrystalAura.YHCQXQRdsmtmi4vz var6 = this.f_14018.get();
               if (var13 != null) {
                  var13.confirmation().m_1234(var7.sequence());
               }

               if (var6 != null) {
                  var6.confirmation().m_1234(var7.sequence());
               }
            } else if (var1.m_3295() instanceof BlockUpdateS2CPacket var8) {
               this.m_478(var8.getPos(), var8.getState());
            } else if (var1.m_3295() instanceof ChunkDeltaUpdateS2CPacket var12) {
               var12.visitUpdates(this::m_478);
            }
         }
      } else {
         if (var1.m_3295() instanceof PlayerInteractBlockC2SPacket var2) {
            CrystalAura.YHCQXQRdsmtmi4vz var9 = this.f_14029.get();
            if (var9 != null
               && (
                  var2.getBlockHitResult().getBlockPos().equals(var9.pos())
                     || var2.getBlockHitResult().getBlockPos().offset(var2.getBlockHitResult().getSide()).equals(var9.pos())
               )) {
               var9.confirmation().m_383(var2.getSequence());
            }
         } else if (var1.m_3295() instanceof PlayerActionC2SPacket var3) {
            CrystalAura.YHCQXQRdsmtmi4vz var11 = this.f_14018.get();
            if (var11 != null && var3.getPos().equals(var11.pos())) {
               if (var3.getAction() == Action.START_DESTROY_BLOCK) {
                  var11.confirmation().m_383(var3.getSequence());
               } else if (var3.getAction() == Action.STOP_DESTROY_BLOCK) {
                  var11.confirmation().m_383(var3.getSequence());
               }
            }
         }
      }
   }

   private boolean m_4076(BlockHitResult var1) {
      return this.m_754(Items.END_CRYSTAL, var1);
   }

   private boolean m_2583(BlockPos var1) {
      Integer var2 = this.f_14033.get(var1);
      return var2 != null && f_5909.player.age <= var2;
   }

   @Override
   public void m_1() {
      this.f_14023 = null;
      this.m_1318();
      this.m_1094(true);
      this.m_1447();
      this.m_76();
      this.m_894();
      if (this.f_14012 >= 9) {
         this.m_3677();
      }

      super.m_1();
   }

   private int m_309(int var1) {
      if (var1 < 0) {
         return -1;
      } else {
         for (Slot var3 : f_5909.player.currentScreenHandler.slots) {
            if (var3.inventory == f_5909.player.getInventory() && var3.getIndex() == var1) {
               return var3.id;
            }
         }

         return -1;
      }
   }

   private record Ar1aPP5f2zSjorN3(BlockPos pos, float score, BlockHitResult hit) {
   }

   private record H0EkYdlaE5DWDLwT(BlockPos pos, CrystalAura.Kcj5pdxmLyT1GeTx type, long createdAt) {
   }

   private record Inner_0b6mbNXHOZeb7efh(Hand hand, int oldSlot, int selectedSlot, int sourceScreenSlot, boolean inventorySwap) {
   }

   private record Inner_4hAITp8s5cmvnS7E(int oldSlot, int selectedSlot, int sourceScreenSlot, boolean inventorySwap) {
   }

   private static enum Kcj5pdxmLyT1GeTx {
      CRYSTAL,
      OBSIDIAN,
      DIG;
   }

   private record R0fg9fV7FWlxZXys(BlockPos blocker, BlockPos base) {
   }

   private record YHCQXQRdsmtmi4vz(BlockPos pos, Util105 confirmation) {
   }

   private final class emRZnElKmImDQMla {
      @EventHandler
      private void m_3032(Util170 var1) {
         CrystalAura.this.m_3279();
      }
   }

   private static enum gYShz1ijBLWFbRWb {
      ATTACK_CRYSTAL,
      PLACE_CRYSTAL,
      PLACE_OBSIDIAN,
      PLACE_SHIELD;
   }

   private record jomZbuWdEigmeGwg(BlockHitResult hit) {
   }

   private record rykxIRxnR0LNxLQg(CrystalAura.gYShz1ijBLWFbRWb kind, BlockPos pos, EndCrystalEntity crystal, Item item, BlockHitResult hit, int createdTick) {
   }
}
