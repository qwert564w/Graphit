package su.energyclient.module.miscellaneous;

import baritone.api.IBaritone;
import baritone.api.Settings;
import baritone.api.Settings.Setting;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.process.IBaritoneProcess;
import baritone.api.process.IBuilderProcess;
import baritone.api.utils.RayTraceUtils;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.input.Input;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util152;
import su.energyclient.util.Util170;
import su.energyclient.util.Util3;
import su.energyclient.util.Util4;
import su.energyclient.util.Util95;

public final class AutoBrewerBuilder extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_3493 = 2400;
   private static final int f_3494 = 0;
   private static final int f_3495 = 0;
   private final ModeSetting f_3496;
   private final ModeSetting f_3497;
   private AutoBrewerBuilder.O0NIVwkygBrdMI6Y f_3498;
   private AutoBrewerBuilder.kbCK5AEvLpFyqB28 f_3499;
   private BlockPos f_3500;
   private Direction f_3501;
   private Util3.wTUpIpIowbV03OJe f_3502;
   private Map<BlockPos, BlockState> f_3503;
   private int f_3504;
   private int f_3505;
   private int f_3506;
   private int f_3507;
   private int f_3508;
   private int f_3509;
   private boolean f_3510;
   private boolean f_3511;
   private AutoBrewerBuilder.Inner_36KOmsuMHHax6bjr f_3512;
   private AutoBrewerBuilder.QgRR3fmnvNJDKJSV f_3513;
   private static final String f_3514 = "Auto Brewer Builder";
   private static final String f_3515 = "Строит компактную трёхступенчатую автозельеварку через Baritone";
   private static final String f_3516 = "Направление";
   private static final String f_3517 = "По взгляду";
   private static final String f_3518 = "По взгляду";
   private static final String f_3519 = "NORTH";
   private static final String f_3520 = "SOUTH";
   private static final String f_3521 = "EAST";
   private static final String f_3522 = "WEST";
   private static final String f_3523 = "Опоры";
   private static final String f_3524 = "Камень";
   private static final String f_3525 = "Камень";
   private static final String f_3526 = "Булыжник";
   private static final String f_3527 = "Глубинный сланец";
   private static final String f_3528 = "Доски дуба";
   private static final int f_3529 = Integer.MAX_VALUE;
   private static final String f_3530 = "Нет игрока или загруженного мира.";
   private static final String f_3531 = "Закрой открытый контейнер или инвентарь перед запуском.";
   private static final String f_3532 = "Не удалось определить направление постройки.";
   private static final String f_3533 = "&cНе хватает материалов:";
   private static final String f_3534 = "auto-brewer-foundation";
   private static final String f_3535 = "&aСтрою автозельеварку перед стартовой точкой %s, направление %s.";
   private static final String f_3536 = "&eСтроительство автозельеварки остановлено.";
   private static final String f_3537 = "Мир был закрыт во время строительства.";
   private static final String f_3538 = "auto-brewer-redstone";
   private static final String f_3539 = "…";
   private static final int f_3540 = Integer.MAX_VALUE;
   private static final String f_3541 = "; ";
   private static final String f_3542 = "активный маршрут";
   private static final String f_3543 = "По взгляду";
   private static final String f_3544 = "NORTH";
   private static final String f_3545 = "SOUTH";
   private static final String f_3546 = "EAST";
   private static final String f_3547 = "WEST";
   private static final String f_3548 = "Булыжник";
   private static final String f_3549 = "Глубинный сланец";
   private static final String f_3550 = "Доски дуба";
   private static final String f_3551 = "&aАвтозельеварка построена.";
   private static final String f_3552 = "&7Верхний сундук — бутылки с водой; огненный порошок положи в варочную стойку.";
   private static final String f_3553 = "&7Выбрасыватели от стойки: адский нарост → основной ингредиент → модификатор.";
   private static final String f_3554 = "&eПосле загрузки нажми кнопку один раз: первая вода уйдёт вниз, зато запустится первый цикл.";
   private static final String f_3555 = "&eДальше нажимай только после окончания варки: готовая партия уйдёт вниз, следующая запустится сама.";
   private static final int f_3556 = Integer.MAX_VALUE;
   private static final String f_3557 = ", ";

   private void m_3711(Util3.D7sPArcYOVamY1AK var1) {
      if (this.f_3512 == null) {
         this.f_3512 = this.m_2378(var1.item());
         if (this.f_3512 == null) {
            this.m_4074("Не найден " + this.m_317(var1.item()) + " для позиции " + this.m_1468(this.m_2630(var1.pos())) + ".");
         } else {
            this.f_3505 = 0;
         }
      } else if (++this.f_3505 >= 2) {
         if (!f_5909.player.getMainHandStack().isOf(var1.item())) {
            this.m_4074("Baritone не смог выбрать " + this.m_317(var1.item()) + " в хотбаре.");
         } else {
            if (var1.sneak()) {
               Util95.m_1583().getInputOverrideHandler().setInputForceState(Input.SNEAK, true);
               this.f_3499 = AutoBrewerBuilder.kbCK5AEvLpFyqB28.SNEAK;
               this.f_3505 = 0;
            } else {
               this.f_3499 = AutoBrewerBuilder.kbCK5AEvLpFyqB28.AIM;
               this.f_3506 = 0;
            }
         }
      }
   }

   private int m_898(Map<BlockPos, BlockState> var1) {
      if (var1 != null && f_5909.world != null) {
         int var2 = 0;

         for (Entry var4 : var1.entrySet()) {
            if (!Util3.m_3035(f_5909.world.getBlockState(this.m_2630((BlockPos)var4.getKey())), (BlockState)var4.getValue())) {
               var2++;
            }
         }

         return var2;
      } else {
         return f_3540;
      }
   }

   public AutoBrewerBuilder() {
      super(f_3514, f_3515, Category.MISCELLANEOUS);
      this.f_3496 = new ModeSetting(f_3516, f_3517, f_3518, f_3519, f_3520, f_3521, f_3522);
      this.f_3497 = new ModeSetting(f_3523, f_3524, f_3525, f_3526, f_3527, f_3528);
      this.f_3498 = AutoBrewerBuilder.O0NIVwkygBrdMI6Y.IDLE;
      this.f_3499 = AutoBrewerBuilder.kbCK5AEvLpFyqB28.MOVE;
      this.f_3508 = f_3529;
   }

   private void m_4074(String var1) {
      Util152.m_662("&c" + var1);
      this.m_3524(true);
      if (this.m_677()) {
         this.m_1926(false);
      }
   }

   private void m_1955(AutoBrewerBuilder.O0NIVwkygBrdMI6Y var1, Map<BlockPos, BlockState> var2, String var3) {
      this.f_3503 = var2;
      Util4 var4 = new Util4(var2, this.f_3500);
      this.f_3498 = var1;
      this.f_3508 = this.m_898(var2);
      this.f_3509 = 0;
      Util95.m_3356(var3, var4, var4.origin());
   }

   private AutoBrewerBuilder.Inner_36KOmsuMHHax6bjr m_2378(Item var1) {
      IBaritone var2 = Util95.m_1583();
      PlayerInventory var3 = f_5909.player.getInventory();
      int var4 = var3.getSelectedSlot();

      for (int var5 = 0; var5 < 9; var5++) {
         if (var3.getStack(var5).isOf(var1)) {
            var3.setSelectedSlot(var5);
            var2.getPlayerContext().playerController().syncHeldItem();
            return new AutoBrewerBuilder.Inner_36KOmsuMHHax6bjr(var4, -1, var5);
         }
      }

      if (f_5909.player.currentScreenHandler != f_5909.player.playerScreenHandler) {
         return null;
      } else {
         int var8 = -1;

         for (int var6 = 9; var6 < 36; var6++) {
            if (var3.getStack(var6).isOf(var1)) {
               var8 = var6;
               break;
            }
         }

         if (var8 < 0) {
            return null;
         } else {
            int var9 = -1;

            for (int var7 = 0; var7 < 9; var7++) {
               if (var3.getStack(var7).isEmpty()) {
                  var9 = var7;
                  break;
               }
            }

            if (var9 < 0) {
               var9 = var3.getSwappableHotbarSlot();
            }

            var2.getPlayerContext().playerController().windowClick(f_5909.player.playerScreenHandler.syncId, var8, var9, SlotActionType.SWAP, f_5909.player);
            var3.setSelectedSlot(var9);
            var2.getPlayerContext().playerController().syncHeldItem();
            return new AutoBrewerBuilder.Inner_36KOmsuMHHax6bjr(var4, var8, var9);
         }
      }
   }

   private void m_3524(boolean var1) {
      this.m_3378();
      if (var1 && this.f_3511) {
         try {
            Util95.m_1583().getPathingBehavior().cancelEverything();
         } catch (Throwable var4) {
         }
      }

      if (this.f_3513 != null) {
         try {
            this.f_3513.m_133();
         } catch (Throwable var3) {
         }
      }

      this.f_3498 = AutoBrewerBuilder.O0NIVwkygBrdMI6Y.IDLE;
      this.f_3499 = AutoBrewerBuilder.kbCK5AEvLpFyqB28.MOVE;
      this.f_3500 = null;
      this.f_3501 = null;
      this.f_3502 = null;
      this.f_3503 = null;
      this.f_3504 = 0;
      this.f_3505 = 0;
      this.f_3506 = 0;
      this.f_3507 = 0;
      this.f_3508 = f_3556;
      this.f_3509 = 0;
      this.f_3510 = false;
      this.f_3511 = false;
      this.f_3512 = null;
      this.f_3513 = null;
   }

   @Override
   public void m_2() {
      super.m_2();
      if (f_5909.player == null || f_5909.world == null || f_5909.interactionManager == null) {
         this.m_4074(f_3530);
      } else if (f_5909.player.currentScreenHandler != f_5909.player.playerScreenHandler) {
         this.m_4074(f_3531);
      } else {
         IBaritone var1;
         try {
            var1 = Util95.m_1583();
         } catch (Throwable var10) {
            this.m_4074("Baritone недоступен: " + this.m_2735(var10));
            return;
         }

         String var2 = this.m_694(var1);
         if (var2 != null) {
            this.m_4074("Baritone уже занят: " + var2 + ". Сначала останови текущую задачу.");
         } else {
            this.f_3501 = this.m_244();
            if (this.f_3501 == null) {
               this.m_4074(f_3532);
            } else {
               this.f_3500 = f_5909.player.getBlockPos();

               try {
                  this.f_3502 = Util3.m_2050(this.f_3501, this.m_1404());
               } catch (RuntimeException var9) {
                  this.m_4074("Ошибка схемы: " + this.m_2735(var9));
                  return;
               }

               String var3 = this.m_3122();
               if (var3 != null) {
                  this.m_4074(var3);
               } else {
                  String var4 = this.m_3730();
                  if (var4 != null) {
                     this.m_4074(var4);
                  } else {
                     List<String> var5 = this.m_3820(this.m_1654(this.f_3502.blocks()));
                     if (var5.isEmpty()) {
                        try {
                           this.f_3513 = new AutoBrewerBuilder.QgRR3fmnvNJDKJSV(Util95.m_2576());
                           this.f_3513.m_1635();
                           this.f_3511 = true;
                           this.m_1955(AutoBrewerBuilder.O0NIVwkygBrdMI6Y.FOUNDATION, this.f_3502.foundationBlocks(), f_3534);
                        } catch (Throwable var8) {
                           this.m_4074("Не удалось запустить Builder: " + this.m_2735(var8));
                           return;
                        }

                        Util152.m_662(String.format(Locale.ROOT, f_3535, this.m_1468(this.f_3500), this.f_3501.asString().toUpperCase(Locale.ROOT)));
                     } else {
                        Util152.m_662(f_3533);

                        for (String var7 : var5) {
                           Util152.m_662("&c • " + var7);
                        }

                        this.m_3524(false);
                        this.m_1926(false);
                     }
                  }
               }
            }
         }
      }
   }

   private void m_3446(Util3.D7sPArcYOVamY1AK var1) {
      BlockPos var2 = this.m_2630(var1.stand());
      Optional var3 = this.m_3881(var1);
      if (Util95.m_1583().getPlayerContext().playerFeet().equals(var2) && var3.isPresent()) {
         Util95.m_1583().getPathingBehavior().cancelEverything();
         this.f_3510 = false;
         this.f_3505 = 0;
         this.f_3499 = AutoBrewerBuilder.kbCK5AEvLpFyqB28.SELECT;
      } else if (!this.f_3510) {
         Util95.m_1583().getCustomGoalProcess().setGoalAndPath(new GoalBlock(var2));
         this.f_3510 = true;
         this.f_3505 = 0;
      } else if (++this.f_3505 > 600) {
         this.m_4074("Baritone не нашёл позицию для установки " + this.m_317(var1.item()) + " в " + this.m_1468(this.m_2630(var1.pos())) + ".");
      } else {
         IBaritone var4 = Util95.m_1583();
         if (!var4.getCustomGoalProcess().isActive() && !var4.getPathingBehavior().isPathing() && var4.getPlayerContext().playerFeet().equals(var2)) {
            this.m_4074("Из выбранной позиции не видна нужная грань для " + this.m_317(var1.item()) + " в " + this.m_1468(this.m_2630(var1.pos())) + ".");
         }
      }
   }

   @EventHandler
   private void m_3425(Util170 var1) {
      if (this.f_3498 != AutoBrewerBuilder.O0NIVwkygBrdMI6Y.IDLE) {
         if (f_5909.player != null && f_5909.world != null && f_5909.interactionManager != null) {
            try {
               switch (this.f_3498) {
                  case IDLE:
                  default:
                     break;
                  case FOUNDATION:
                  case REDSTONE:
                     this.m_3953();
                     break;
                  case MANUAL:
                     this.m_1289();
               }
            } catch (Throwable var3) {
               this.m_4074("Ошибка строительства: " + this.m_2735(var3));
            }
         } else {
            this.m_4074(f_3537);
         }
      }
   }

   private void m_3378() {
      try {
         Util95.m_1583().getInputOverrideHandler().setInputForceState(Input.SNEAK, false);
      } catch (Throwable var3) {
      }

      try {
         this.m_3394();
      } catch (Throwable var2) {
         this.f_3512 = null;
      }
   }

   private Object2IntMap<Item> m_1654(Map<BlockPos, BlockState> var1) {
      Object2IntLinkedOpenHashMap var2 = new Object2IntLinkedOpenHashMap();

      for (Entry var4 : var1.entrySet()) {
         if (!Util3.m_3035(f_5909.world.getBlockState(this.m_2630((BlockPos)var4.getKey())), (BlockState)var4.getValue())) {
            Item var5 = Util3.m_2710(((BlockState)var4.getValue()).getBlock());
            var2.put(var5, var2.getInt(var5) + 1);
         }
      }

      return var2;
   }

   private Vec3d m_1423(BlockPos var1, Util3.D7sPArcYOVamY1AK var2) {
      return Vec3d.ofCenter(var1).add(var2.hitOffset());
   }

   private void m_2002() {
      this.m_3378();
      this.f_3504++;
      this.f_3499 = AutoBrewerBuilder.kbCK5AEvLpFyqB28.MOVE;
      this.f_3505 = 0;
      this.f_3506 = 0;
      this.f_3507 = 0;
      this.f_3510 = false;
   }

   private String m_2520(int var1) {
      List var2 = this.m_3820(this.m_1654(this.f_3503));
      if (!var2.isEmpty()) {
         return "Не хватает материалов: " + String.join(f_3541, var2) + ".";
      } else {
         for (Entry var4 : this.f_3503.entrySet()) {
            BlockPos var5 = this.m_2630((BlockPos)var4.getKey());
            BlockState var6 = f_5909.world.getBlockState(var5);
            if (!Util3.m_3035(var6, (BlockState)var4.getValue())) {
               return "Baritone не может поставить "
                  + this.m_317(Util3.m_2710(((BlockState)var4.getValue()).getBlock()))
                  + " в "
                  + this.m_1468(var5)
                  + " (сейчас "
                  + var6.getBlock().getName().getString()
                  + "). Осталось: "
                  + var1
                  + ".";
            }
         }

         return "Baritone поставил Builder на паузу. Осталось блоков: " + var1 + ".";
      }
   }

   private int O(Item var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         ItemStack var4 = f_5909.player.getInventory().getStack(var3);
         if (!var4.isEmpty() && var4.isOf(var1)) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   private boolean m_1494(BlockState var1) {
      return !var1.getFluidState().isEmpty() ? false : var1.isAir() || var1.isReplaceable();
   }

   @Override
   public void m_1() {
      boolean var1 = this.f_3498 != AutoBrewerBuilder.O0NIVwkygBrdMI6Y.IDLE;
      this.m_3524(var1);
      if (var1) {
         Util152.m_662(f_3536);
      }

      super.m_1();
   }

   private String m_2140(List<BlockPos> var1) {
      StringBuilder var2 = new StringBuilder();

      for (int var3 = 0; var3 < var1.size(); var3++) {
         if (var3 > 0) {
            var2.append(f_3557);
         }

         var2.append(this.m_1468((BlockPos)var1.get(var3)));
      }

      return var2.toString();
   }

   private String m_1468(BlockPos var1) {
      return var1.getX() + " " + var1.getY() + " " + var1.getZ();
   }

   private void m_3394() {
      if (this.f_3512 != null && f_5909.player != null) {
         try {
            IBaritone var1 = Util95.m_1583();
            if (this.f_3512.sourceInventorySlot() >= 0 && f_5909.player.currentScreenHandler == f_5909.player.playerScreenHandler) {
               var1.getPlayerContext()
                  .playerController()
                  .windowClick(
                     f_5909.player.playerScreenHandler.syncId, this.f_3512.sourceInventorySlot(), this.f_3512.hotbarSlot(), SlotActionType.SWAP, f_5909.player
                  );
            }

            f_5909.player.getInventory().setSelectedSlot(this.f_3512.oldSelected());
            var1.getPlayerContext().playerController().syncHeldItem();
         } finally {
            this.f_3512 = null;
         }
      }
   }

   private void m_3739() {
      Util152.m_662(f_3551);
      Util152.m_662(f_3552);
      Util152.m_662(f_3553);
      Util152.m_662(f_3554);
      Util152.m_662(f_3555);
      this.m_3524(false);
      this.m_1926(false);
   }

   private void m_1413() {
      this.f_3498 = AutoBrewerBuilder.O0NIVwkygBrdMI6Y.MANUAL;
      this.f_3499 = AutoBrewerBuilder.kbCK5AEvLpFyqB28.MOVE;
      this.f_3504 = 0;
      this.f_3505 = 0;
      this.f_3506 = 0;
      this.f_3507 = 0;
      this.f_3510 = false;
      this.f_3503 = null;
   }

   private void m_2066(Util3.D7sPArcYOVamY1AK var1) {
      IBaritone var2 = Util95.m_1583();
      Optional var3 = this.m_3881(var1);
      if (var3.isEmpty()) {
         if (++this.f_3505 > 10) {
            this.m_4074("Потеряна видимость грани для " + this.m_317(var1.item()) + " в " + this.m_1468(this.m_2630(var1.pos())) + ".");
         }
      } else {
         var2.getLookBehavior().updateTarget((Rotation)var3.get(), true);
         this.f_3506++;
         if (this.f_3506 >= 2 && this.m_2063(var1)) {
            BlockPos var4 = this.m_2630(var1.support());
            BlockHitResult var5 = new BlockHitResult(this.m_1423(var4, var1), var1.face(), var4, false);
            ActionResult var6 = var2.getPlayerContext()
               .playerController()
               .processRightClickBlock(var2.getPlayerContext().player(), var2.getPlayerContext().world(), Hand.MAIN_HAND, var5);
            if (!var6.isAccepted()) {
               this.m_4074("Сервер отклонил установку " + this.m_317(var1.item()) + " в " + this.m_1468(this.m_2630(var1.pos())) + ".");
            } else {
               f_5909.player.swingHand(Hand.MAIN_HAND);
               this.f_3499 = AutoBrewerBuilder.kbCK5AEvLpFyqB28.WAIT_ACK;
               this.f_3505 = 0;
               this.f_3507 = 0;
            }
         } else {
            if (this.f_3506 > 20) {
               this.m_4074("Baritone не смог навестись на грань для " + this.m_317(var1.item()) + " в " + this.m_1468(this.m_2630(var1.pos())) + ".");
            }
         }
      }
   }

   private String m_175(int var1) {
      for (Entry var3 : this.f_3502.blocks().entrySet()) {
         BlockPos var4 = this.m_2630((BlockPos)var3.getKey());
         BlockState var5 = f_5909.world.getBlockState(var4);
         if (!Util3.m_3035(var5, (BlockState)var3.getValue())) {
            return "Перед завершением повреждён узел "
               + this.m_1468(var4)
               + ": нужен "
               + ((BlockState)var3.getValue()).getBlock().getName().getString()
               + ", сейчас "
               + var5.getBlock().getName().getString()
               + ". Осталось исправить: "
               + var1
               + ".";
         }
      }

      return "Финальная проверка схемы не пройдена. Несовпадений: " + var1 + ".";
   }

   private Direction m_244() {
      String var1 = this.f_3496.m_3862();
      if (var1 != null && !var1.equalsIgnoreCase(f_3543)) {
         String var2 = var1.toUpperCase(Locale.ROOT);

         return switch (var2) {
            case f_3544 -> Direction.NORTH;
            case f_3545 -> Direction.SOUTH;
            case f_3546 -> Direction.EAST;
            case f_3547 -> Direction.WEST;
            default -> null;
         };
      } else {
         return f_5909.player.getHorizontalFacing();
      }
   }

   private void m_3540() {
      Util95.m_1583().getInputOverrideHandler().setInputForceState(Input.SNEAK, true);
      if (++this.f_3505 >= 2) {
         this.f_3499 = AutoBrewerBuilder.kbCK5AEvLpFyqB28.AIM;
         this.f_3506 = 0;
      }
   }

   private Optional<Rotation> m_3881(Util3.D7sPArcYOVamY1AK var1) {
      IBaritone var2 = Util95.m_1583();
      BlockPos var3 = this.m_2630(var1.support());
      Vec3d var4 = this.m_1423(var3, var1);
      double var5 = var2.getPlayerContext().playerController().getBlockReachDistance();
      Optional var7 = RotationUtils.reachableOffset(var2.getPlayerContext(), var3, var4, var5, var1.sneak());
      if (var7.isEmpty()) {
         return Optional.empty();
      } else {
         Rotation var8 = var2.getLookBehavior().getAimProcessor().peekRotation((Rotation)var7.get());
         return RayTraceUtils.rayTraceTowards(var2.getPlayerContext().player(), var8, var5, var1.sneak()) instanceof BlockHitResult var10
               && var10.getBlockPos().equals(var3)
               && var10.getSide() == var1.face()
            ? var7
            : Optional.empty();
      }
   }

   private void m_1217(Util3.D7sPArcYOVamY1AK var1) {
      BlockPos var2 = this.m_2630(var1.pos());
      BlockState var3 = f_5909.world.getBlockState(var2);
      if (Util3.m_2512(var3, var1)) {
         if (++this.f_3507 >= 2) {
            this.m_2002();
         }
      } else {
         this.f_3507 = 0;
         if (!this.m_1494(var3)) {
            this.m_4074(
               "Блок поставлен неверно в "
                  + this.m_1468(var2)
                  + ": нужен "
                  + var1.state().getBlock().getName().getString()
                  + " с правильным направлением, сейчас "
                  + var3.getBlock().getName().getString()
                  + "."
            );
         } else {
            if (++this.f_3505 > 50) {
               this.m_4074("Сервер не подтвердил установку " + this.m_317(var1.item()) + " в " + this.m_1468(var2) + ".");
            }
         }
      }
   }

   private String m_3122() {
      ArrayList var1 = new ArrayList();

      for (Entry var3 : this.f_3502.blocks().entrySet()) {
         BlockPos var4 = this.m_2630((BlockPos)var3.getKey());
         if (f_5909.world.isOutOfHeightLimit(var4)) {
            return "Схема выходит за допустимую высоту мира: " + this.m_1468(var4) + ".";
         }

         if (!f_5909.world.getWorldBorder().contains(var4)) {
            return "Схема выходит за границу мира: " + this.m_1468(var4) + ".";
         }

         BlockState var5 = f_5909.world.getBlockState(var4);
         if (!Util3.m_3035(var5, (BlockState)var3.getValue()) && !var5.isAir()) {
            var1.add(var4);
            if (var1.size() < 8) {
               continue;
            }
            break;
         }
      }

      return var1.isEmpty() ? null : "Место занято. Освободи: " + this.m_2140(var1) + (var1.size() >= 8 ? f_3539 : "") + ".";
   }

   private void m_3953() {
      IBuilderProcess var1 = Util95.m_227();
      int var2 = this.m_898(this.f_3503);
      if (var2 == 0) {
         Util95.m_1583().getPathingBehavior().cancelEverything();
         if (this.f_3498 == AutoBrewerBuilder.O0NIVwkygBrdMI6Y.FOUNDATION) {
            this.m_1413();
         } else {
            int var3 = this.m_898(this.f_3502.blocks());
            if (var3 == 0) {
               this.m_3739();
            } else {
               this.m_4074(this.m_175(var3));
            }
         }
      } else if (var1.isPaused()) {
         this.m_4074(this.m_2520(var2));
      } else if (!var1.isActive()) {
         this.m_4074("Baritone отменил строительство. Осталось блоков: " + var2 + ".");
      } else {
         if (var2 < this.f_3508) {
            this.f_3508 = var2;
            this.f_3509 = 0;
         } else if (++this.f_3509 > 2400) {
            this.m_4074("Baritone не продвинулся за 120 секунд. " + this.m_2520(var2));
         }
      }
   }

   private String m_694(IBaritone var1) {
      IBaritoneProcess[] var2 = new IBaritoneProcess[]{
         var1.getBuilderProcess(),
         var1.getCustomGoalProcess(),
         var1.getMineProcess(),
         var1.getFollowProcess(),
         var1.getExploreProcess(),
         var1.getFarmProcess(),
         var1.getGetToBlockProcess(),
         var1.getElytraProcess()
      };

      for (IBaritoneProcess var6 : var2) {
         if (var6 != null && var6.isActive()) {
            return var6.displayName();
         }
      }

      return var1.getPathingBehavior().isPathing() ? f_3542 : null;
   }

   private boolean m_2063(Util3.D7sPArcYOVamY1AK var1) {
      IBaritone var2 = Util95.m_1583();
      BlockPos var3 = this.m_2630(var1.support());
      return RayTraceUtils.rayTraceTowards(
            var2.getPlayerContext().player(),
            var2.getPlayerContext().playerRotations(),
            var2.getPlayerContext().playerController().getBlockReachDistance(),
            var1.sneak()
         ) instanceof BlockHitResult var5
         && var5.getBlockPos().equals(var3)
         && var5.getSide() == var1.face();
   }

   private String m_317(Item var1) {
      return var1.getName().getString();
   }

   private String m_3730() {
      LinkedHashSet<BlockPos> var1 = new LinkedHashSet<>(this.f_3502.approachFeet());

      for (BlockPos var3 : this.f_3502.blocks().keySet()) {
         if (var3.getY() == 0) {
            var1.add(var3);
         }
      }

      for (BlockPos var11 : var1) {
         BlockPos var4 = this.m_2630(var11);
         BlockPos var5 = var4.down();
         if (f_5909.world.isOutOfHeightLimit(var4) || f_5909.world.isOutOfHeightLimit(var5) || !f_5909.world.getWorldBorder().contains(var4)) {
            return "Позиция подхода Baritone вне доступной области: " + this.m_1468(var4) + ".";
         }

         BlockState var6 = f_5909.world.getBlockState(var5);
         BlockState var7 = this.f_3502.blocks().get(var11.down());
         boolean var8 = var7 != null && var7.isSolidBlock(f_5909.world, var5);
         if (!var6.isSolidBlock(f_5909.world, var5) && !var8) {
            return "Нужна ровная твёрдая площадка; нет опоры под " + this.m_1468(var4) + ".";
         }
      }

      for (Util3.D7sPArcYOVamY1AK var12 : this.f_3502.placements()) {
         if (!Util3.m_2512(f_5909.world.getBlockState(this.m_2630(var12.pos())), var12)) {
            BlockPos var13 = this.m_2630(var12.stand());
            BlockPos var14 = var13.up();
            if (!f_5909.world.isOutOfHeightLimit(var14) && f_5909.world.getWorldBorder().contains(var14)) {
               if (this.m_1494(f_5909.world.getBlockState(var13)) && this.m_1494(f_5909.world.getBlockState(var14))) {
                  continue;
               }

               return "Baritone не сможет встать в " + this.m_1468(var13) + " для установки " + this.m_317(var12.item()) + ".";
            }

            return "Позиция подхода Baritone вне доступной области: " + this.m_1468(var13) + ".";
         }
      }

      return null;
   }

   private String m_2735(Throwable var1) {
      String var2 = var1.getMessage();
      return var2 != null && !var2.isBlank() ? var2 : var1.getClass().getSimpleName();
   }

   private List<String> m_3820(Object2IntMap<Item> var1) {
      ArrayList var2 = new ArrayList();
      ObjectIterator var3 = var1.object2IntEntrySet().iterator();

      while (var3.hasNext()) {
         it.unimi.dsi.fastutil.objects.Object2IntMap.Entry var4 = (it.unimi.dsi.fastutil.objects.Object2IntMap.Entry)var3.next();
         int var5 = this.O((Item)var4.getKey());
         int var6 = var4.getIntValue();
         if (var5 < var6) {
            var2.add(this.m_317((Item)var4.getKey()) + " ×" + (var6 - var5) + " (есть " + var5 + "/" + var6 + ")");
         }
      }

      return var2;
   }

   private BlockPos m_2630(BlockPos var1) {
      return this.f_3500.add(var1);
   }

   private void m_1289() {
      if (this.f_3504 >= this.f_3502.placements().size()) {
         this.m_3378();
         this.m_1955(AutoBrewerBuilder.O0NIVwkygBrdMI6Y.REDSTONE, this.f_3502.redstoneBlocks(), f_3538);
      } else {
         Util3.D7sPArcYOVamY1AK var1 = this.f_3502.placements().get(this.f_3504);
         BlockPos var2 = this.m_2630(var1.pos());
         if (Util3.m_2512(f_5909.world.getBlockState(var2), var1)) {
            this.m_2002();
         } else {
            switch (this.f_3499) {
               case MOVE:
                  this.m_3446(var1);
                  break;
               case SELECT:
                  this.m_3711(var1);
                  break;
               case SNEAK:
                  this.m_3540();
                  break;
               case AIM:
                  this.m_2066(var1);
                  break;
               case WAIT_ACK:
                  this.m_1217(var1);
            }
         }
      }
   }

   private Block m_1404() {
      String var1 = this.f_3497.m_3862();

      return switch (var1) {
         case f_3548 -> Blocks.COBBLESTONE;
         case f_3549 -> Blocks.COBBLED_DEEPSLATE;
         case f_3550 -> Blocks.OAK_PLANKS;
         default -> Blocks.STONE;
      };
   }

   private record Inner_36KOmsuMHHax6bjr(int oldSelected, int sourceInventorySlot, int hotbarSlot) {
   }

   private static enum O0NIVwkygBrdMI6Y {
      IDLE,
      FOUNDATION,
      MANUAL,
      REDSTONE;
   }

   private static final class QgRR3fmnvNJDKJSV {
      private final Settings f_14296;
      private final Map<Setting<?>, Object> f_14297 = new IdentityHashMap<>();

      QgRR3fmnvNJDKJSV(Settings var1) {
         this.f_14296 = var1;
         this.m_1029(
            var1.allowPlace,
            var1.allowBreak,
            var1.allowInventory,
            var1.freeLook,
            var1.blockFreeLook,
            var1.smoothLook,
            var1.remainWithExistingLookDirection,
            var1.randomLooking,
            var1.randomLooking113,
            var1.allowPlaceInFluidsSource,
            var1.allowPlaceInFluidsFlow,
            var1.buildIgnoreExisting,
            var1.buildIgnoreDirection,
            var1.buildIgnoreProperties,
            var1.buildInLayers,
            var1.layerOrder,
            var1.layerHeight,
            var1.startAtLayer,
            var1.skipFailedLayers,
            var1.buildOnlySelection,
            var1.buildRepeat,
            var1.buildRepeatCount,
            var1.schematicOrientationX,
            var1.schematicOrientationY,
            var1.schematicOrientationZ,
            var1.buildSchematicRotation,
            var1.buildSchematicMirror,
            var1.buildSubstitutes,
            var1.buildValidSubstitutes,
            var1.buildSkipBlocks,
            var1.buildIgnoreBlocks,
            var1.okIfAir,
            var1.mapArtMode,
            var1.okIfWater
         );
      }

      void m_1635() {
         this.f_14296.allowPlace.value = true;
         this.f_14296.allowBreak.value = false;
         this.f_14296.allowInventory.value = true;
         this.f_14296.freeLook.value = false;
         this.f_14296.blockFreeLook.value = false;
         this.f_14296.smoothLook.value = false;
         this.f_14296.remainWithExistingLookDirection.value = false;
         this.f_14296.randomLooking.value = 0.0;
         this.f_14296.randomLooking113.value = 0.0;
         this.f_14296.allowPlaceInFluidsSource.value = false;
         this.f_14296.allowPlaceInFluidsFlow.value = false;
         this.f_14296.buildIgnoreExisting.value = false;
         this.f_14296.buildIgnoreDirection.value = false;
         this.f_14296.buildIgnoreProperties.value = List.of();
         this.f_14296.buildInLayers.value = true;
         this.f_14296.layerOrder.value = false;
         this.f_14296.layerHeight.value = 1;
         this.f_14296.startAtLayer.value = 0;
         this.f_14296.skipFailedLayers.value = false;
         this.f_14296.buildOnlySelection.value = false;
         this.f_14296.buildRepeat.value = Vec3i.ZERO;
         this.f_14296.buildRepeatCount.value = 1;
         this.f_14296.schematicOrientationX.value = false;
         this.f_14296.schematicOrientationY.value = false;
         this.f_14296.schematicOrientationZ.value = false;
         this.f_14296.buildSchematicRotation.value = BlockRotation.NONE;
         this.f_14296.buildSchematicMirror.value = BlockMirror.NONE;
         this.f_14296.buildSubstitutes.value = Map.of();
         this.f_14296.buildValidSubstitutes.value = Map.of();
         this.f_14296.buildSkipBlocks.value = List.of();
         this.f_14296.buildIgnoreBlocks.value = List.of();
         this.f_14296.okIfAir.value = List.of();
         this.f_14296.mapArtMode.value = false;
         this.f_14296.okIfWater.value = false;
      }

      private void m_1029(Setting<?>... var1) {
         for (Setting var5 : var1) {
            this.f_14297.put(var5, var5.value);
         }
      }

      void m_133() {
         for (Entry var2 : this.f_14297.entrySet()) {
            Setting var3 = (Setting)var2.getKey();
            var3.value = var2.getValue();
         }

         this.f_14297.clear();
      }
   }

   private static enum kbCK5AEvLpFyqB28 {
      MOVE,
      SELECT,
      SNEAK,
      AIM,
      WAIT_ACK;
   }
}
