package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import org.joml.Matrix4f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;
import su.energyclient.util.Util170;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;

public class Holeesp extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_6922;
   private final NumberSetting f_6923;
   private final BooleanSetting f_6924;
   private final BooleanSetting f_6925;
   private final ModeSetting f_6926;
   private static final int f_6927 = 0;
   private static final int f_6928 = 0;
   private static final int f_6929 = 0;
   private static final int f_6930 = Util71.m_1415(40, 255, 20);
   private static final int f_6931 = Util71.m_1415(205, 40, 255);
   private static final int f_6932 = Util71.m_1415(255, 185, 40);
   private static final int f_6933 = Util71.m_1415(200, 145, 200);
   private static final Direction[] f_6934 = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
   private static final int f_6935 = 0;
   private static final int f_6936 = 0;
   private static final int f_6937 = 0;
   private static final double f_6938 = 0.0;
   private static final float f_6939 = 0.0F;
   private static final float f_6940 = 0.0F;
   private static final float f_6941 = 0.0F;
   private static final float f_6942 = 0.0F;
   private static final long f_6943 = 0L;
   private final Map<BlockPos, Holeesp.eTgsDwEPHY8VVyBn> f_6944;
   private int f_6945;
   private static final String f_6946 = "HoleESP";
   private static final String f_6947 = "Подсвечивает холы вокруг игрока";
   private static final String f_6948 = "Отображение";
   private static final String f_6949 = "Бокс";
   private static final String f_6950 = "Бокс";
   private static final String f_6951 = "Градиент";
   private static final String f_6952 = "Радиус";
   private static final float f_6953 = 8.0F;
   private static final float f_6954 = 3.0F;
   private static final float f_6955 = 16.0F;
   private static final String f_6956 = "Только бедрок";
   private static final String f_6957 = "Подсветка стен";
   private static final String f_6958 = "Цвет";
   private static final String f_6959 = "Стандарт";
   private static final String f_6960 = "Стандарт";
   private static final String f_6961 = "Тема";
   private static final String f_6962 = "Градиент";
   private static final double f_6963 = 0.5;
   private static final double f_6964 = 0.5;
   private static final long f_6965 = 1600L;
   private static final double f_6966 = 1600.0;
   private static final double f_6967 = Math.PI;
   private static final double f_6968 = 2.0;
   private static final float f_6969 = 0.045F;
   private static final float f_6970 = 0.015F;
   private static final float f_6971 = 0.5F;
   private static final float f_6972 = 0.5F;
   private static final float f_6973 = 0.2F;
   private static final float f_6974 = 0.01F;
   private static final float f_6975 = 0.75F;
   private static final float f_6976 = 0.45F;
   private static final float f_6977 = 0.12F;
   private static final float f_6978 = 0.25F;
   private static final float f_6979 = 1.5F;
   private static final float f_6980 = 0.01F;
   private static final float f_6981 = 0.12F;
   private static final double f_6982 = 256.0;
   private static final String f_6983 = "Тема";
   private static final float f_6984 = 0.55F;
   private static final String f_6985 = "Тема";
   private static final double f_6986 = 0.82F;
   private static final double f_6987 = 0.82F;
   private static final double f_6988 = 0.01F;
   private static final double f_6989 = 0.01F;
   private static final double f_6990 = 0.01F;
   private static final double f_6991 = 0.01F;
   private static final double f_6992 = 0.01;

   @EventHandler
   private void m_2143(Util170 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         if (++this.f_6945 >= 5) {
            this.f_6945 = 0;

            for (Holeesp.eTgsDwEPHY8VVyBn var3 : this.f_6944.values()) {
               var3.f_13402 = true;
            }

            int var12 = this.f_6923.m_134().intValue();
            boolean var13 = this.f_6924.m_1163();
            BlockPos var4 = f_5909.player.getBlockPos();
            Mutable var5 = new Mutable();

            for (int var6 = -var12; var6 <= var12; var6++) {
               for (int var7 = -var12; var7 <= var12; var7++) {
                  if (var6 * var6 + var7 * var7 <= var12 * var12) {
                     for (int var8 = -5; var8 <= 3; var8++) {
                        var5.set(var4.getX() + var6, var4.getY() + var8, var4.getZ() + var7);
                        if (f_5909.world.getBlockState(var5).isAir()) {
                           BlockPos var9 = var5.toImmutable();
                           int var10 = this.m_397(var9, true);
                           if (var10 != 0 && (!var13 || var10 == 2)) {
                              Holeesp.eTgsDwEPHY8VVyBn var11 = this.f_6944.computeIfAbsent(var9, Holeesp.eTgsDwEPHY8VVyBn::new);
                              var11.f_13401 = var10 == 2;
                              var11.f_13402 = false;
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         this.f_6944.clear();
      }
   }

   private static void m_4145(BufferBuilder var0) {
      BuiltBuffer var1 = var0.endNullable();
      if (var1 != null) {
         RenderUtil12.I(var1);
      }
   }

   private void m_2882(BufferBuilder var1, Matrix4f var2, Vec3d var3, Holeesp.zXHILmDAaKgPFDGP var4, float var5, int var6, boolean var7) {
      double var8 = var4.pos().getX() - var3.x;
      double var10 = var4.pos().getY() - var3.y;
      double var12 = var4.pos().getZ() - var3.z;
      float var14 = (float)(var10 + f_6986 - var5);
      float var15 = (float)(var10 + f_6987 + var5);
      float var16;
      float var17;
      float var18;
      float var19;
      switch (var4.side()) {
         case EAST:
            var16 = (float)(var8 + 1.0 - f_6988);
            var17 = (float)var12;
            var18 = var16;
            var19 = (float)(var12 + 1.0);
            break;
         case WEST:
            var16 = (float)(var8 + f_6989);
            var17 = (float)var12;
            var18 = var16;
            var19 = (float)(var12 + 1.0);
            break;
         case SOUTH:
            var16 = (float)var8;
            var17 = (float)(var12 + 1.0 - f_6990);
            var18 = (float)(var8 + 1.0);
            var19 = var17;
            break;
         default:
            var16 = (float)var8;
            var17 = (float)(var12 + f_6991);
            var18 = (float)(var8 + 1.0);
            var19 = var17;
      }

      if (var7) {
         m_1456(var1, var2, var16, var14, var17, var6);
         m_1456(var1, var2, var18, var14, var19, var6);
         m_1456(var1, var2, var18, var14, var19, var6);
         m_1456(var1, var2, var18, var15, var19, var6);
         m_1456(var1, var2, var18, var15, var19, var6);
         m_1456(var1, var2, var16, var15, var17, var6);
         m_1456(var1, var2, var16, var15, var17, var6);
         m_1456(var1, var2, var16, var14, var17, var6);
      } else {
         m_1456(var1, var2, var16, var14, var17, var6);
         m_1456(var1, var2, var18, var14, var19, var6);
         m_1456(var1, var2, var18, var15, var19, var6);
         m_1456(var1, var2, var16, var15, var17, var6);
      }
   }

   private int m_1823() {
      return this.f_6926.m_2073(f_6985) ? Util71.m_3793(EnergyClient.getTheme(0), 40) : f_6933;
   }

   private static void m_1456(BufferBuilder var0, Matrix4f var1, float var2, float var3, float var4, int var5) {
      var0.vertex(var1, var2, var3, var4).color(var5);
   }

   private static void m_3128(BufferBuilder var0, Matrix4f var1, float var2, float var3, float var4, int var5) {
      float var6 = var2 + 1.0F;
      float var7 = var4 + 1.0F;
      m_1456(var0, var1, var2, var3, var4, var5);
      m_1456(var0, var1, var6, var3, var4, var5);
      m_1456(var0, var1, var6, var3, var4, var5);
      m_1456(var0, var1, var6, var3, var7, var5);
      m_1456(var0, var1, var6, var3, var7, var5);
      m_1456(var0, var1, var2, var3, var7, var5);
      m_1456(var0, var1, var2, var3, var7, var5);
      m_1456(var0, var1, var2, var3, var4, var5);
   }

   private static void m_734(BufferBuilder var0, Matrix4f var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      float var8 = var2 + 1.0F;
      float var9 = var4 + 1.0F;
      m_331(var0, var1, var2, var4, var8, var4, var3, var5, var6, var7);
      m_331(var0, var1, var8, var4, var8, var9, var3, var5, var6, var7);
      m_331(var0, var1, var8, var9, var2, var9, var3, var5, var6, var7);
      m_331(var0, var1, var2, var9, var2, var4, var3, var5, var6, var7);
   }

   private static void m_1657(BufferBuilder var0, Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      m_1456(var0, var1, var2, var3, var4, var8);
      m_1456(var0, var1, var5, var3, var4, var8);
      m_1456(var0, var1, var5, var3, var4, var8);
      m_1456(var0, var1, var5, var3, var7, var8);
      m_1456(var0, var1, var5, var3, var7, var8);
      m_1456(var0, var1, var2, var3, var7, var8);
      m_1456(var0, var1, var2, var3, var7, var8);
      m_1456(var0, var1, var2, var3, var4, var8);
      m_1456(var0, var1, var2, var6, var4, var8);
      m_1456(var0, var1, var5, var6, var4, var8);
      m_1456(var0, var1, var5, var6, var4, var8);
      m_1456(var0, var1, var5, var6, var7, var8);
      m_1456(var0, var1, var5, var6, var7, var8);
      m_1456(var0, var1, var2, var6, var7, var8);
      m_1456(var0, var1, var2, var6, var7, var8);
      m_1456(var0, var1, var2, var6, var4, var8);
      m_1456(var0, var1, var2, var3, var4, var8);
      m_1456(var0, var1, var2, var6, var4, var8);
      m_1456(var0, var1, var5, var3, var4, var8);
      m_1456(var0, var1, var5, var6, var4, var8);
      m_1456(var0, var1, var5, var3, var7, var8);
      m_1456(var0, var1, var5, var6, var7, var8);
      m_1456(var0, var1, var2, var3, var7, var8);
      m_1456(var0, var1, var2, var6, var7, var8);
   }

   private Set<BlockPos> m_3852() {
      HashSet var1 = new HashSet();

      for (PlayerEntity var3 : f_5909.world.getPlayers()) {
         if (var3 != f_5909.player && var3.isAlive()) {
            var1.add(var3.getBlockPos());
         }
      }

      return var1;
   }

   private static void m_2930(BufferBuilder var0, Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      m_1456(var0, var1, var2, var3, var4, var8);
      m_1456(var0, var1, var5, var3, var4, var8);
      m_1456(var0, var1, var5, var3, var7, var8);
      m_1456(var0, var1, var2, var3, var7, var8);
      m_1456(var0, var1, var2, var6, var4, var8);
      m_1456(var0, var1, var2, var6, var7, var8);
      m_1456(var0, var1, var5, var6, var7, var8);
      m_1456(var0, var1, var5, var6, var4, var8);
      m_1456(var0, var1, var2, var3, var4, var8);
      m_1456(var0, var1, var2, var6, var4, var8);
      m_1456(var0, var1, var5, var6, var4, var8);
      m_1456(var0, var1, var5, var3, var4, var8);
      m_1456(var0, var1, var2, var3, var7, var8);
      m_1456(var0, var1, var5, var3, var7, var8);
      m_1456(var0, var1, var5, var6, var7, var8);
      m_1456(var0, var1, var2, var6, var7, var8);
      m_1456(var0, var1, var2, var3, var4, var8);
      m_1456(var0, var1, var2, var3, var7, var8);
      m_1456(var0, var1, var2, var6, var7, var8);
      m_1456(var0, var1, var2, var6, var4, var8);
      m_1456(var0, var1, var5, var3, var4, var8);
      m_1456(var0, var1, var5, var6, var4, var8);
      m_1456(var0, var1, var5, var6, var7, var8);
      m_1456(var0, var1, var5, var3, var7, var8);
   }

   public Holeesp() {
      super(f_6946, f_6947, Category.RENDER);
      this.f_6922 = new ModeSetting(f_6948, f_6949, f_6950, f_6951);
      this.f_6923 = new NumberSetting(f_6952, f_6953, f_6954, f_6955, 1.0F);
      this.f_6924 = new BooleanSetting(f_6956, false);
      this.f_6925 = new BooleanSetting(f_6957, true);
      this.f_6926 = new ModeSetting(f_6958, f_6959, f_6960, f_6961);
      this.f_6944 = new LinkedHashMap<>();
   }

   @EventHandler
   private void m_2335(Util88 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         for (Holeesp.eTgsDwEPHY8VVyBn var3 : this.f_6944.values()) {
            var3.f_13400.m_3631(var3.f_13402 ? 0.0 : 1.0);
         }

         this.f_6944.values().removeIf(var0 -> var0.f_13402 && var0.f_13400.m_2276() < f_6992);
         List<Holeesp.zXHILmDAaKgPFDGP> var21 = this.f_6925.m_1163() ? this.m_1219() : List.of();
         if (!this.f_6944.isEmpty() || !var21.isEmpty()) {
            Vec3d var22 = f_5909.gameRenderer.getCamera().getCameraPos();
            Matrix4f var4 = var1.m_213().peek().getPositionMatrix();
            boolean var5 = this.f_6922.m_2073(f_6962);
            Set var6 = this.m_3852();
            float var7 = (float)(f_6963 + f_6964 * Math.sin(System.currentTimeMillis() % f_6965 / f_6966 * f_6967 * f_6968));
            float var8 = f_6969 + var7 * f_6970;
            float var9 = f_6971 + var7 * f_6972;
            int var10 = Util71.m_3765(this.m_1823(), var9);
            int var11 = Util71.m_3765(this.m_1823(), var9 * f_6973);
            Util114.m_1481();
            Util114.m_542();
            Util114.m_3978();
            Util114.m_672();
            Util114.m_1878(false);
            Util114.m_3784(RenderUtil7.f_13885);
            BufferBuilder var12 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

            for (Holeesp.eTgsDwEPHY8VVyBn var14 : this.f_6944.values()) {
               float var15 = (float)var14.f_13400.m_2276();
               if (!(var15 < f_6974)) {
                  int var16 = this.m_1521(var14, var6.contains(var14.f_13399));
                  float var17 = (float)(var14.f_13399.getX() - var22.x);
                  float var18 = (float)(var14.f_13399.getY() - var22.y);
                  float var19 = (float)(var14.f_13399.getZ() - var22.z);
                  if (var5) {
                     m_734(var12, var4, var17, var18, var19, var18 + f_6975 * var15, Util71.m_3765(var16, f_6976 * var15), Util71.m_3765(var16, 0.0F));
                  } else {
                     m_2930(var12, var4, var17, var18, var19, var17 + 1.0F, var18 + f_6977 * var15, var19 + 1.0F, Util71.m_3765(var16, f_6978 * var15));
                  }
               }
            }

            for (Holeesp.zXHILmDAaKgPFDGP var25 : var21) {
               this.m_2882(var12, var4, var22, var25, var8, var11, false);
            }

            m_4145(var12);
            Util114.m_2977(f_6979);
            BufferBuilder var24 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

            for (Holeesp.eTgsDwEPHY8VVyBn var28 : this.f_6944.values()) {
               float var30 = (float)var28.f_13400.m_2276();
               if (!(var30 < f_6980)) {
                  int var31 = Util71.m_3765(this.m_1521(var28, var6.contains(var28.f_13399)), var30);
                  float var32 = (float)(var28.f_13399.getX() - var22.x);
                  float var33 = (float)(var28.f_13399.getY() - var22.y);
                  float var20 = (float)(var28.f_13399.getZ() - var22.z);
                  if (var5) {
                     m_3128(var24, var4, var32, var33, var20, var31);
                  } else {
                     m_1657(var24, var4, var32, var33, var20, var32 + 1.0F, var33 + f_6981 * var30, var20 + 1.0F, var31);
                  }
               }
            }

            for (Holeesp.zXHILmDAaKgPFDGP var29 : var21) {
               this.m_2882(var24, var4, var22, var29, var8, var10, true);
            }

            m_4145(var24);
            Util114.m_2977(1.0F);
            Util114.m_1878(true);
            Util114.m_100();
            Util114.m_1562();
            Util114.m_963();
         }
      }
   }

   private int m_1521(Holeesp.eTgsDwEPHY8VVyBn var1, boolean var2) {
      boolean var3 = this.f_6926.m_2073(f_6983);
      if (var2) {
         return var3 ? Util71.m_3793(EnergyClient.getTheme(0), 70) : f_6932;
      } else if (var1.f_13401) {
         return var3 ? EnergyClient.getTheme(0) : f_6930;
      } else {
         return var3 ? Util71.m_2101(EnergyClient.getTheme(0), f_6984) : f_6931;
      }
   }

   private static void m_331(BufferBuilder var0, Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8, int var9) {
      m_1456(var0, var1, var2, var6, var3, var8);
      m_1456(var0, var1, var4, var6, var5, var8);
      m_1456(var0, var1, var4, var7, var5, var9);
      m_1456(var0, var1, var2, var7, var3, var9);
   }

   private static boolean m_3943(Block var0) {
      return var0 == Blocks.BEDROCK
         || var0 == Blocks.OBSIDIAN
         || var0 == Blocks.CRYING_OBSIDIAN
         || var0 == Blocks.RESPAWN_ANCHOR
         || var0 == Blocks.NETHERITE_BLOCK
         || var0 == Blocks.ANCIENT_DEBRIS
         || var0 == Blocks.ENDER_CHEST;
   }

   private int m_397(BlockPos var1, boolean var2) {
      if (!var2 || f_5909.world.getBlockState(var1.up()).isAir() && f_5909.world.getBlockState(var1.up(2)).isAir()) {
         BlockPos var3 = var1.down();
         if (f_5909.world.getBlockState(var3).getCollisionShape(f_5909.world, var3).isEmpty()) {
            return 0;
         } else {
            byte var4 = 2;

            for (Direction var8 : f_6934) {
               Block var9 = f_5909.world.getBlockState(var1.offset(var8)).getBlock();
               if (var9 != Blocks.BEDROCK) {
                  if (!m_3943(var9)) {
                     return 0;
                  }

                  var4 = 1;
               }
            }

            return var4;
         }
      } else {
         return 0;
      }
   }

   @Override
   public void m_1() {
      this.f_6944.clear();
      this.f_6945 = 0;
      super.m_1();
   }

   private List<Holeesp.zXHILmDAaKgPFDGP> m_1219() {
      ArrayList var1 = new ArrayList();

      for (PlayerEntity var3 : f_5909.world.getPlayers()) {
         if (var3 != f_5909.player && var3.isAlive() && !(var3.squaredDistanceTo(f_5909.player) > f_6982) && !InitManager.f_2740.f_2744.m_3914(var3)) {
            BlockPos var4 = var3.getBlockPos();
            if (f_5909.world.getBlockState(var4).isAir() && this.m_397(var4, false) != 0) {
               for (Direction var8 : f_6934) {
                  if (f_5909.world.getBlockState(var4.offset(var8)).getBlock() != Blocks.BEDROCK) {
                     var1.add(new Holeesp.zXHILmDAaKgPFDGP(var4, var8));
                  }
               }
            }
         }
      }

      return var1;
   }

   private static final class eTgsDwEPHY8VVyBn {
      private final BlockPos f_13399;
      private final Util165 f_13400;
      private boolean f_13401;
      private boolean f_13402;
      private static final long f_13403 = 220L;

      private eTgsDwEPHY8VVyBn(BlockPos var1) {
         this.f_13400 = new Util165(Util153.EASE_OUT_QUAD, f_13403);
         this.f_13399 = var1;
      }
   }

   private record zXHILmDAaKgPFDGP(BlockPos pos, Direction side) {
   }
}
