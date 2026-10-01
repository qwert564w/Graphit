package su.energyclient.util;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.PositionAndOnGround;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import su.energyclient.QuickImports;

public class Util72 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static boolean f_9144;
   private static boolean f_9145;
   private static boolean f_9146;
   private static int f_9147;
   private static int f_9148;
   private static int f_9149;
   private static Vec3d f_9150;
   private static ClientWorld f_9151;
   private static boolean f_9152;
   private static final String f_9153 = "Вы не в режиме полета, телепорт невозможен";
   private static final String f_9154 = "Игрок не найден";
   private static final double f_9155 = 0.5;
   private static final double f_9156 = 0.5;
   private static final String f_9157 = "Вы не в режиме полета, телепорт невозможен";
   private static final String f_9158 = "Координаты находятся за границей мира";
   private static final double f_9159 = 0.5;
   private static final double f_9160 = 0.5;
   private static final int f_9161 = Integer.MIN_VALUE;
   private static final double f_9162 = 0.5;
   private static final double f_9163 = 0.5;
   private static final double f_9164 = 0.5;
   private static final double f_9165 = 0.5;
   private static final int f_9166 = Integer.MIN_VALUE;

   private static int m_3829() {
      for (int var0 = f_5909.world.getHeight() - 1; var0 >= 0; var0--) {
         if (O(new BlockPos(f_9147, var0, f_9148))) {
            return var0;
         }
      }

      return f_9166;
   }

   public static void m_3729() {
      if (f_9144) {
         if (f_5909.player == null || f_5909.world == null || f_5909.world != f_9151) {
            m_1492();
         } else if (!f_5909.player.getAbilities().flying) {
            m_1492();
         } else if (f_9149 > 0) {
            f_9149--;
         } else {
            if (f_9150 != null) {
               if (!f_5909.player.getBlockPos().equals(BlockPos.ofFloored(f_9150))) {
                  f_5909.player.setPosition(f_9150.x, f_9150.y, f_9150.z);
                  Util162.m_1605(new PositionAndOnGround(f_9150.x, f_9150.y, f_9150.z, false, f_5909.player.horizontalCollision));
                  f_9149 = 2;
                  return;
               }

               f_9150 = null;
               if (f_9146) {
                  if (!f_9152) {
                     Util152.m_662("Телепортация завершена: " + f_9147 + " " + f_9148);
                  }

                  m_1492();
                  return;
               }

               f_9145 = true;
            }

            if (m_429(f_9147 + f_9159, f_9148 + f_9160)) {
               int var14 = m_3829();
               if (var14 == f_9161) {
                  Util152.m_662("Не найден блок на координатах " + f_9147 + " " + f_9148);
                  m_1492();
               } else {
                  f_9146 = true;
                  m_830(f_9147 + f_9162, var14, f_9148 + f_9163);
               }
            } else if (!f_9145) {
               m_830(f_5909.player.getX(), 1.0, f_5909.player.getZ());
            } else {
               double var0 = f_5909.player.getX();
               double var2 = f_5909.player.getY();
               double var4 = f_5909.player.getZ();
               double var6 = f_9147 + f_9164 - var0;
               double var8 = f_9148 + f_9165 - var4;
               double var10 = Math.hypot(var6, var8);
               if (!(var10 < 1.0)) {
                  double var12 = m_1899(var0, var4, var6, var8, var10);
                  if (!(var12 <= 1.0)) {
                     m_830(var0 + var6 / var10 * var12, var2, var4 + var8 / var10 * var12);
                  }
               }
            }
         }
      }
   }

   private static boolean O(BlockPos var0) {
      return f_5909.world == null ? false : !f_5909.world.getBlockState(var0).getCollisionShape(f_5909.world, var0).isEmpty();
   }

   private static void m_830(double var0, double var2, double var4) {
      f_9150 = new Vec3d(var0, var2, var4);
      f_5909.player.setPosition(var0, var2, var4);
      Util162.m_1605(new PositionAndOnGround(var0, var2, var4, false, f_5909.player.horizontalCollision));
      f_9149 = 2;
   }

   private static void m_1492() {
      f_9144 = false;
      f_9145 = false;
      f_9146 = false;
      f_9150 = null;
      f_9151 = null;
      f_9152 = false;
      f_9149 = 0;
   }

   private static boolean m_429(double var0, double var2) {
      int var4 = MathHelper.floor(var0) >> 4;
      int var5 = MathHelper.floor(var2) >> 4;
      return f_5909.world.getChunkManager().getChunk(var4, var5) != null;
   }

   public static void m_2163(int var0, int var1, boolean var2) {
      if (f_5909.player != null && f_5909.world != null) {
         m_1492();
         if (!f_5909.player.getAbilities().flying) {
            Util152.m_662(f_9157);
         } else if (!World.isValid(new BlockPos(var0, 1, var1))) {
            Util152.m_662(f_9158);
         } else {
            f_9147 = var0;
            f_9148 = var1;
            f_9149 = 0;
            f_9150 = null;
            f_9145 = false;
            f_9146 = false;
            f_9151 = f_5909.world;
            f_9152 = var2;
            f_9144 = true;
            if (!var2) {
               Util152.m_662("Телепортация на " + var0 + " " + var1);
            }
         }
      }
   }

   public static void m_785(int var0, int var1) {
      m_2163(var0, var1, false);
   }

   private static double m_1899(double var0, double var2, double var4, double var6, double var8) {
      double var10 = var4 / var8;
      double var12 = var6 / var8;
      double var14 = 0.0;
      double var16 = 0.0;

      while (var16 <= var8 && m_429(var0 + var10 * var16, var2 + var12 * var16)) {
         var14 = var16++;
      }

      return var14;
   }

   public static boolean m_2465() {
      return f_9144;
   }

   public static void m_1742(String var0) {
      if (f_5909.player != null && f_5909.world != null) {
         m_1492();
         if (!f_5909.player.getAbilities().flying) {
            Util152.m_662(f_9153);
         } else {
            PlayerEntity var1 = f_5909.world.getPlayers().stream().filter(var1x -> var1x.getName().getString().equals(var0)).findFirst().orElse(null);
            if (var1 == null) {
               Util152.m_662(f_9154);
            } else {
               Vec3d var2 = var1.getEntityPos();
               int var3 = (int)Math.floor(var2.x);
               int var4 = (int)Math.floor(var2.z);
               int var5 = (int)Math.floor(var2.y);
               if (O(var1.getBlockPos().up())) {
                  Util162.m_1605(new PositionAndOnGround(var2.x, var2.y, var2.z, false, f_5909.player.horizontalCollision));
                  Util152.m_662("Попытка телепортации к " + var0);
               } else {
                  for (int var6 = var5; var6 > 0; var6--) {
                     BlockPos var7 = new BlockPos(var3, var6, var4);
                     if (O(var7)) {
                        Util162.m_1605(new PositionAndOnGround(var3 + f_9155, var6, var4 + f_9156, false, f_5909.player.horizontalCollision));
                        Util152.m_662("Попытка телепортации к " + var0);
                        return;
                     }
                  }

                  Util152.m_662("Не найден блок под игроком " + var0);
               }
            }
         }
      }
   }
}
