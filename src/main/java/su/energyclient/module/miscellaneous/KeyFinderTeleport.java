package su.energyclient.module.miscellaneous;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.ChestMinecartEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import su.energyclient.EnergyClient;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.render.RenderUtil25;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util152;
import su.energyclient.util.Util170;
import su.energyclient.util.Util71;
import su.energyclient.util.Util72;
import su.energyclient.util.Util88;

public class KeyFinderTeleport extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_11469 = "Всё";
   private static final String f_11470 = "";
   private static final String f_11471 = "";
   private static final int f_11472 = 0;
   private static final int f_11473 = 0;
   private static final int f_11474 = 0;
   private final RenderUtil22 l;
   private final RenderUtil22 f_11475;
   private final ModeSetting f_11476;
   private final BooleanSetting f_11477;
   private final Set<Long> f_11478;
   private final Set<Long> f_11479;
   private final Set<BlockPos> f_11480;
   private final Set<BlockPos> f_11481;
   private boolean f_11482;
   private boolean f_11483;
   private int f_11484;
   private int f_11485;
   private int f_11486;
   private int f_11487;
   private int f_11488;
   private int f_11489;
   private int f_11490;
   private int f_11491;
   private int f_11492;
   private int f_11493;
   private int f_11494;
   private BlockPos f_11495;
   private static final String f_11496 = "Key Finder Teleport";
   private static final String f_11497 = "Автоматически ищет ключ карты и чарки под землёй";
   private static final String f_11498 = "Кнопка поиска";
   private static final String f_11499 = "Очистить найденное";
   private static final String f_11500 = "Тип поиска";
   private static final String f_11501 = "Всё";
   private static final String f_11502 = "Всё";
   private static final String f_11503 = "Вагонетка с сундуком";
   private static final String f_11504 = "Сундук рядом со спавнером";
   private static final String f_11505 = "Отображать найденное";
   private static final double f_11506 = 0.5;
   private static final double f_11507 = 0.5;
   private static final String f_11508 = "Телепортация к найденному завершена";
   private static final String f_11509 = "Поиск остановлен: требуется режим полёта";
   private static final String f_11510 = "Найденные объекты очищены";
   private static final String f_11511 = "Поиск остановлен";
   private static final String O1 = "Для поиска требуется режим полёта";
   private static final String f_11512 = "Начинаем поиск...";
   private static final String f_11513 = "Всё";
   private static final String Ol = "Вагонетка с сундуком";
   private static final String O2 = "Вагонетка с сундуком";
   private static final String f_11514 = "Всё";
   private static final String f_11515 = "Сундук рядом со спавнером";
   private static final String f_11516 = "Сундук у спавнера";
   private static final String f_11517 = "Вагонетка с сундуком";
   private static final long f_11518 = 4294967295L;

   private void m_3821() {
      this.m_3489("Поиск завершён. Найдено: " + (this.f_11480.size() + this.f_11481.size()), Formatting.YELLOW);
      this.m_2287();
   }

   @EventHandler
   private void m_63(CancellableEvent var1) {
      if (var1.m_1362() && !var1.m_3546()) {
         if (this.f_11475.m_1958() != -1 && var1.m_2169() == this.f_11475.m_1958()) {
            this.m_1346();
            this.m_3489(f_11510, Formatting.YELLOW);
         } else if (this.l.m_1958() != -1 && var1.m_2169() == this.l.m_1958()) {
            if (!this.f_11482 && !Util72.m_2465()) {
               this.m_1840();
            } else {
               this.m_2287();
               this.m_3489(f_11511, Formatting.RED);
            }
         }
      }
   }

   private boolean m_359() {
      this.f_11493++;
      this.f_11488 = this.f_11488 + this.f_11490;
      this.f_11489 = this.f_11489 + this.f_11491;
      if (this.f_11493 == this.f_11492) {
         this.f_11493 = 0;
         int var1 = -this.f_11491;
         int var2 = this.f_11490;
         this.f_11490 = var1;
         this.f_11491 = var2;
         if (++this.f_11494 == 2) {
            this.f_11494 = 0;
            this.f_11492++;
         }
      }

      int var3 = Math.max(Math.abs(this.f_11488), Math.abs(this.f_11489));
      return var3 * 16 <= 32000;
   }

   private int m_3247(int var1) {
      int var2 = Math.floorDiv(var1, 16) * 16;
      return MathHelper.clamp(var2, -16000, 16000);
   }

   private void m_2268(int var1, int var2) {
      if (this.f_11478.add(this.m_339(var1 >> 4, var2 >> 4))) {
         String var3 = this.f_11476.m_3862();
         int var4 = f_5909.world.getBottomY();
         int var5 = var4 + f_5909.world.getHeight() - 1;
         int var6 = Math.min(60, var5);
         if (f_11513.equals(var3) || Ol.equals(var3)) {
            Box var7 = new Box(var1 - 8, var4, var2 - 8, var1 + 8, var6 + 1, var2 + 8);

            for (ChestMinecartEntity var10 : f_5909.world.getEntitiesByClass(ChestMinecartEntity.class, var7, Entity::isAlive)) {
               BlockPos var11 = var10.getBlockPos();
               if (this.f_11481.add(var11)) {
                  this.m_2212(var11, O2);
                  return;
               }
            }
         }

         if (f_11514.equals(var3) || f_11515.equals(var3)) {
            this.m_3374(var1, var2, var4, var6);
         }
      }
   }

   private void m_3374(int var1, int var2, int var3, int var4) {
      Mutable var5 = new Mutable();

      for (int var6 = 0; var6 < 16; var6++) {
         for (int var7 = 0; var7 < 16; var7++) {
            for (int var8 = var3; var8 <= var4; var8++) {
               var5.set(var1 + var6, var8, var2 + var7);
               if (f_5909.world.getBlockState(var5).getBlock() instanceof ChestBlock) {
                  BlockPos var9 = var5.toImmutable();
                  BlockPos var10 = this.m_1994(var9);
                  if (var10 != null) {
                     if (this.f_11479.add(var10.asLong())) {
                        this.f_11480.add(var9);
                        this.m_2212(var9, f_11516);
                        return;
                     }

                     this.f_11480.add(var9);
                  }
               }
            }
         }
      }
   }

   private boolean m_784() {
      while (this.m_359()) {
         int var1 = this.f_11486 + this.f_11488 * 16;
         int var2 = this.f_11487 + this.f_11489 * 16;
         if (var1 >= -16000 && var1 <= 16000 && var2 >= -16000 && var2 <= 16000 && !this.f_11478.contains(this.m_339(var1 >> 4, var2 >> 4))) {
            this.f_11484 = var1;
            this.f_11485 = var2;
            return true;
         }
      }

      return false;
   }

   @EventHandler
   private void m_1632(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         Util72.m_3729();
         if (this.f_11495 != null) {
            f_5909.player.setPosition(this.f_11495.getX() + f_11506, this.f_11495.getY(), this.f_11495.getZ() + f_11507);
            this.f_11495 = null;
            this.f_11482 = false;
            this.f_11483 = false;
            this.m_3489(f_11508, Formatting.GREEN);
         } else if (this.f_11482) {
            if (!f_5909.player.getAbilities().flying) {
               this.m_3489(f_11509, Formatting.RED);
               this.m_2287();
            } else if (!Util72.m_2465()) {
               if (this.f_11483) {
                  this.f_11483 = false;
                  this.m_2268(this.f_11484, this.f_11485);
                  if (!this.f_11482) {
                     return;
                  }
               }

               if (!this.m_784()) {
                  this.m_3821();
               } else {
                  Util72.m_2163(this.f_11484, this.f_11485, true);
                  this.f_11483 = Util72.m_2465();
                  if (!this.f_11483) {
                     this.m_2287();
                  }
               }
            }
         }
      } else {
         this.m_2287();
      }
   }

   private void m_1840() {
      if (f_5909.player != null && f_5909.world != null) {
         if (!f_5909.player.getAbilities().flying) {
            this.m_3489(O1, Formatting.RED);
         } else {
            this.f_11486 = this.m_3247(MathHelper.floor(f_5909.player.getX()));
            this.f_11487 = this.m_3247(MathHelper.floor(f_5909.player.getZ()));
            this.f_11484 = this.f_11486;
            this.f_11485 = this.f_11487;
            this.f_11488 = 0;
            this.f_11489 = 0;
            this.f_11490 = 1;
            this.f_11491 = 0;
            this.f_11492 = 1;
            this.f_11493 = 0;
            this.f_11494 = 0;
            this.f_11483 = false;
            this.f_11482 = true;
            this.f_11495 = null;
            this.m_3489(f_11512, Formatting.GREEN);
            this.m_2268(this.f_11486, this.f_11487);
         }
      }
   }

   private long m_339(int var1, int var2) {
      return (long)var1 << 32 ^ var2 & f_11518;
   }

   private void m_1346() {
      this.f_11478.clear();
      this.f_11479.clear();
      this.f_11480.clear();
      this.f_11481.clear();
      this.m_2287();
   }

   private void m_2287() {
      this.f_11482 = false;
      this.f_11483 = false;
      this.f_11495 = null;
   }

   @EventHandler
   private void m_4006(Util88 var1) {
      if (this.f_11477.m_1163() && f_5909.world != null && (!this.f_11480.isEmpty() || !this.f_11481.isEmpty())) {
         Vec3d var2 = f_5909.gameRenderer.getCamera().getCameraPos();
         int var3 = Util71.m_3389(EnergyClient.getTheme(0), 180);
         var1.m_213().push();
         var1.m_213().translate(-var2.x, -var2.y, -var2.z);

         for (BlockPos var5 : this.f_11480) {
            RenderUtil25.m_724(new Box(var5), var3, true, true);
         }

         for (BlockPos var7 : this.f_11481) {
            RenderUtil25.m_724(new Box(var7), var3, true, true);
         }

         RenderUtil25.m_1569(var1.m_213());
         var1.m_213().pop();
      }
   }

   @Override
   public void m_1() {
      this.m_2287();
      super.m_1();
   }

   private void m_2212(BlockPos var1, String var2) {
      this.m_3489("Найден(а) " + var2 + " на " + var1.getX() + " " + var1.getY() + " " + var1.getZ(), Formatting.GREEN);
      if (f_11517.equals(var2)) {
         this.f_11495 = var1.down();
      } else {
         this.f_11495 = var1;
      }

      this.f_11478.add(this.m_339(var1.getX() >> 4, var1.getZ() >> 4));
      this.f_11483 = false;
      this.f_11482 = false;
   }

   private BlockPos m_1994(BlockPos var1) {
      for (int var2 = -5; var2 <= 5; var2++) {
         for (int var3 = -5; var3 <= 5; var3++) {
            BlockPos var4 = var1.add(var2, 0, var3);
            if (f_5909.world.getBlockState(var4).isOf(Blocks.SPAWNER)) {
               return var4;
            }
         }
      }

      return null;
   }

   private void m_3489(String var1, Formatting var2) {
      Util152.m_662(Text.literal(var1).formatted(var2));
   }

   public KeyFinderTeleport() {
      super(f_11496, f_11497, Category.MISCELLANEOUS);
      this.l = new RenderUtil22(f_11498, -1);
      this.f_11475 = new RenderUtil22(f_11499, -1);
      this.f_11476 = new ModeSetting(f_11500, f_11501, f_11502, f_11503, f_11504);
      this.f_11477 = new BooleanSetting(f_11505, true);
      this.f_11478 = new HashSet<>();
      this.f_11479 = new HashSet<>();
      this.f_11480 = new HashSet<>();
      this.f_11481 = new HashSet<>();
      this.f_11490 = 1;
      this.f_11492 = 1;
   }
}
