package su.energyclient.module.render;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.ChestMinecartEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import org.joml.Vector2f;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util158;
import su.energyclient.util.Util169;
import su.energyclient.util.Util170;
import su.energyclient.util.Util71;
import su.energyclient.util.Util93;
import su.energyclient.util.math.MathUtil10;

public class LootTracker extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_8453 = "Залутано";
   private static final String f_8454 = "";
   private final NumberSetting f_8455;
   private final NumberSetting f_8456;
   private final NumberSetting f_8457;
   private final List<LootTracker.g5EQ5nY2L7gph2iJ> f_8458;
   private int f_8459;
   private static final String f_8460 = "Loot Tracker";
   private static final String f_8461 = "Показывает, залутан ли лут";
   private static final String f_8462 = "Радиус";
   private static final float f_8463 = 32.0F;
   private static final float f_8464 = 8.0F;
   private static final float f_8465 = 64.0F;
   private static final String f_8466 = "Радиус проверки";
   private static final float f_8467 = 4.0F;
   private static final String f_8468 = "Блоки воздуха";
   private static final float f_8469 = 3.0F;
   private static final float f_8470 = 32.0F;
   private static final double f_8471 = 0.5;
   private static final double f_8472 = 1.35;
   private static final double f_8473 = 0.5;
   private static final double f_8474 = 0.45;
   private static final String f_8475 = "Залутано";
   private static final String f_8476 = "Не залутано";
   private static final float f_8477 = 14.0F;
   private static final float f_8478 = 14.0F;
   private static final float f_8479 = 4.0F;
   private static final float f_8480 = 7.0F;
   private static final float f_8481 = 5.0F;

   private void m_310() {
      int var1 = this.f_8455.m_134().intValue();
      BlockPos var2 = f_5909.player.getBlockPos();
      Mutable var3 = new Mutable();
      this.f_8458.clear();

      for (int var4 = -var1; var4 <= var1; var4++) {
         for (int var5 = -var1; var5 <= var1; var5++) {
            for (int var6 = -var1; var6 <= var1; var6++) {
               var3.set(var2.getX() + var4, var2.getY() + var5, var2.getZ() + var6);
               if (f_5909.world.isChunkLoaded(var3.getX() >> 4, var3.getZ() >> 4) && f_5909.world.getBlockState(var3).isOf(Blocks.SPAWNER)) {
                  BlockPos var7 = var3.toImmutable();
                  this.f_8458
                     .add(new LootTracker.g5EQ5nY2L7gph2iJ(new Vec3d(var7.getX() + f_8471, var7.getY() + f_8472, var7.getZ() + f_8473), this.m_124(var7)));
               }
            }
         }
      }

      this.m_3645(var1);
   }

   @EventHandler
   private void O(Util169 var1) {
      if (f_5909.world != null && f_5909.player != null && !this.f_8458.isEmpty()) {
         DrawContext var2 = var1.m_4037();

         for (LootTracker.g5EQ5nY2L7gph2iJ var4 : this.f_8458) {
            Vec3d var5 = var4.labelPos();
            Vector2f var6 = MathUtil10.m_362(var5.x, var5.y, var5.z, false, false);
            if (MathUtil10.m_1452(var6)) {
               this.m_1645(var2, var6.x, var6.y, var4.looted());
            }
         }
      }
   }

   @EventHandler
   private void m_1769(Util170 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         if (++this.f_8459 >= 5) {
            this.f_8459 = 0;
            this.m_310();
         }
      } else {
         this.f_8458.clear();
      }
   }

   private boolean m_124(BlockPos var1) {
      int var2 = this.f_8456.m_134().intValue();
      int var3 = this.f_8457.m_134().intValue();
      int var4 = 0;
      Mutable var5 = new Mutable();

      for (int var6 = -var2; var6 <= var2; var6++) {
         for (int var7 = -1; var7 <= 1; var7++) {
            for (int var8 = -var2; var8 <= var2; var8++) {
               if (var6 != 0 || var7 != 0 || var8 != 0) {
                  var5.set(var1.getX() + var6, var1.getY() + var7, var1.getZ() + var8);
                  if (f_5909.world.isChunkLoaded(var5.getX() >> 4, var5.getZ() >> 4)) {
                     BlockState var9 = f_5909.world.getBlockState(var5);
                     if (var9.isAir()) {
                        if (++var4 >= var3) {
                           return true;
                        }
                     }
                  }
               }
            }
         }
      }

      return false;
   }

   public LootTracker() {
      super(f_8460, f_8461, Category.RENDER);
      this.f_8455 = new NumberSetting(f_8462, f_8463, f_8464, f_8465, 1.0F);
      this.f_8456 = new NumberSetting(f_8466, 2.0F, 1.0F, f_8467, 1.0F);
      this.f_8457 = new NumberSetting(f_8468, f_8469, 1.0F, f_8470, 1.0F);
      this.f_8458 = new ArrayList<>();
   }

   private boolean m_2879(ChestMinecartEntity var1) {
      return var1.getLootTable() == null && var1.isInventoryEmpty();
   }

   @Override
   public void m_1() {
      this.f_8458.clear();
      this.f_8459 = 0;
      super.m_1();
   }

   private void m_3645(int var1) {
      Box var2 = f_5909.player.getBoundingBox().expand(var1);

      for (ChestMinecartEntity var5 : f_5909.world.getEntitiesByClass(ChestMinecartEntity.class, var2, Entity::isAlive)) {
         Vec3d var6 = var5.getEntityPos().add(0.0, var5.getHeight() + f_8474, 0.0);
         this.f_8458.add(new LootTracker.g5EQ5nY2L7gph2iJ(var6, this.m_2879(var5)));
      }
   }

   private void m_1645(DrawContext var1, float var2, float var3, boolean var4) {
      String var5 = var4 ? f_8475 : f_8476;
      int var6 = var4 ? Util71.m_1415(94, 255, 145) : Util71.m_1415(255, 92, 92);
      int var7 = Util71.m_756(10, 10, 12, 150);
      float var8 = Util93.f_6003[14].m_585(var5);
      float var9 = var8 + f_8477;
      float var10 = f_8478;
      float var11 = var2 - var9 / 2.0F;
      float var12 = var3 - var10 / 2.0F;
      Util158.m_1849(var11, var12, var9, var10, 2.0F, var7);
      Util158.m_1849(var11 + 1.0F, var12 + 2.0F, 2.0F, var10 - f_8479, 1.0F, var6);
      Util93.f_6003[14].m_2915(var1, var5, var11 + f_8480, var12 + f_8481, Util71.m_1415(255, 255, 255));
   }

   private record g5EQ5nY2L7gph2iJ(Vec3d labelPos, boolean looted) {
   }
}
