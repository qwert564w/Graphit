package su.energyclient.render;

import java.nio.file.Path;
import java.util.List;
import net.minecraft.client.gui.DrawContext;
import su.energyclient.manager.impl.RotationManager;
import su.energyclient.manager.impl.TargetManager;
import su.energyclient.util.Util153;
import su.energyclient.util.Util158;
import su.energyclient.util.Util165;
import su.energyclient.util.Util39;
import su.energyclient.util.Util71;
import su.energyclient.util.Util93;

public final class RenderUtil19 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_1421 = 94.0F;
   private static final float f_1422 = 0.0F;
   private static final float f_1423 = 0.0F;
   private final Util165 f_1424;
   private Path f_1425;
   private String f_1426;
   private String f_1427;
   private int f_1428;
   private int f_1429;
   private static final long f_1430 = 220L;
   private static final float f_1431 = 94.0F;
   private static final String f_1432 = "Перетащите .cfg сюда";
   private static final String f_1433 = "После этого нажмите \"Загрузить\"";
   private static final int f_1434 = 13158601;
   private static final int f_1435 = 9408400;
   private static final float f_1436 = 0.01F;
   private static final float f_1437 = 255.0F;
   private static final float f_1438 = 96.0F;
   private static final float f_1439 = 19.5F;
   private static final int f_1440 = 1447448;
   private static final float f_1441 = 220.0F;
   private static final float f_1442 = 94.0F;
   private static final float f_1443 = 19.0F;
   private static final int f_1444 = 1052946;
   private static final float f_1445 = 205.0F;
   private static final String f_1446 = "Config Import";
   private static final float f_1447 = 11.0F;
   private static final float f_1448 = 12.0F;
   private static final String f_1449 = "Drop a file and load it";
   private static final float f_1450 = 11.0F;
   private static final float f_1451 = 24.0F;
   private static final int f_1452 = 9408400;
   private static final float f_1453 = 10.0F;
   private static final float f_1454 = 38.0F;
   private static final float f_1455 = 20.0F;
   private static final float f_1456 = 0.58F;
   private static final float f_1457 = 0.5F;
   private static final float f_1458 = 0.5F;
   private static final float f_1459 = 27.0F;
   private static final float f_1460 = 11.0F;
   private static final int f_1461 = 1710876;
   private static final float f_1462 = 225.0F;
   private static final float f_1463 = 58.0F;
   private static final float f_1464 = 26.0F;
   private static final float f_1465 = 10.5F;
   private static final int f_1466 = 1316118;
   private static final float f_1467 = 225.0F;
   private static final float f_1468 = 0.72F;
   private static final float f_1469 = 155.0F;
   private static final float f_1470 = 10.0F;
   private static final float f_1471 = 8.0F;
   private static final float f_1472 = 95.0F;
   private static final float f_1473 = 10.0F;
   private static final float f_1474 = 17.0F;
   private static final float f_1475 = 103.0F;
   private static final float f_1476 = 11.0F;
   private static final float f_1477 = 13.0F;
   private static final float f_1478 = 8.0F;
   private static final float f_1479 = 0.2F;
   private static final float f_1480 = 10.0F;
   private static final float f_1481 = 94.0F;
   private static final float f_1482 = 16.0F;
   private static final float f_1483 = 10.0F;
   private static final float f_1484 = 20.0F;
   private static final float f_1485 = 0.5F;
   private static final float f_1486 = 0.5F;
   private static final float f_1487 = 17.0F;
   private static final float f_1488 = 10.0F;
   private static final int f_1489 = 1710876;
   private static final float f_1490 = 225.0F;
   private static final float f_1491 = 95.0F;
   private static final float f_1492 = 16.0F;
   private static final float f_1493 = 9.5F;
   private static final int f_1494 = 1316118;
   private static final float f_1495 = 225.0F;
   private static final float f_1496 = 0.72F;
   private static final float f_1497 = 180.0F;
   private static final String f_1498 = "Загрузить";
   private static final int f_1499 = 15198442;
   private static final int f_1500 = 16777215;
   private static final int f_1501 = 7895161;
   private static final float f_1502 = 7.0F;
   private static final String f_1503 = "Config";
   private static final String f_1504 = "Config";
   private static final int f_1505 = 9408400;
   private static final String f_1506 = "Конфиг загружен";
   private static final int f_1507 = 11138760;
   private static final int f_1508 = 13158601;
   private static final String f_1509 = "Ошибка импорта";
   private static final int f_1510 = 16751258;
   private static final int f_1511 = 12615294;
   private static final float f_1512 = 0.04F;
   private static final float f_1513 = 94.0F;
   private static final float f_1514 = 0.04F;
   private static final float f_1515 = 10.0F;
   private static final float f_1516 = 94.0F;
   private static final float f_1517 = 16.0F;
   private static final float f_1518 = 10.0F;
   private static final float f_1519 = 20.0F;
   private static final float f_1520 = 16.0F;

   private boolean m_1092(double var1, double var3, float var5, float var6, float var7, float var8) {
      return var8 > f_1514 && Util39.m_121(var1, var3, var5 + f_1515, var6 + f_1516 - f_1517 - f_1518, var7 - f_1519, f_1520);
   }

   public void m_3961(List<Path> var1, TargetManager var2) {
      if (var1 != null && !var1.isEmpty() && var2 != null) {
         TargetManager.BMnfwtQglxOM05G9 var3 = null;

         for (Path var5 : var1) {
            TargetManager.BMnfwtQglxOM05G9 var6 = var2.m_1940(var5);
            if (var6.success()) {
               this.f_1425 = var5;
               this.m_3655(var6.sourceName(), "Загрузится как " + var6.configName(), -1, f_1505);
               return;
            }

            if (var3 == null) {
               var3 = var6;
            }
         }

         if (var3 != null) {
            this.m_3022(var3.message());
         } else {
            this.m_1549();
         }
      } else {
         this.m_1549();
      }
   }

   private void m_3655(String var1, String var2, int var3, int var4) {
      this.f_1426 = var1;
      this.f_1427 = var2;
      this.f_1428 = var3;
      this.f_1429 = var4;
   }

   private void O(String var1) {
      this.f_1425 = null;
      this.m_3655(f_1506, var1 + ".cfg", f_1507, f_1508);
   }

   private void m_3022(String var1) {
      this.f_1425 = null;
      this.m_3655(f_1509, var1, f_1510, f_1511);
   }

   public boolean m_3509(double var1, double var3, int var5, float var6, float var7, float var8, float var9, TargetManager var10) {
      if (!this.m_1978(var1, var3, var6, var7, var8, var9)) {
         return false;
      } else if (var5 != 0) {
         return true;
      } else {
         if (this.m_1092(var1, var3, var6, var7, var8, var9)) {
            if (this.f_1425 == null || var10 == null) {
               return true;
            }

            TargetManager.BMnfwtQglxOM05G9 var11 = var10.m_620(this.f_1425);
            if (var11.success()) {
               this.O(var11.configName());
               RotationManager.m_260(f_1503, "Loaded " + var11.configName(), Util71.m_1415(112, 242, 156));
            } else {
               this.m_3022(var11.message());
               RotationManager.m_260(f_1504, var11.message(), Util71.m_1415(255, 126, 126));
            }
         }

         return true;
      }
   }

   private boolean m_1978(double var1, double var3, float var5, float var6, float var7, float var8) {
      return var8 > f_1512 && Util39.m_121(var1, var3, var5, var6, var7, f_1513);
   }

   public RenderUtil19() {
      this.f_1424 = new Util165(Util153.EASE_OUT_CUBIC, f_1430);
      this.m_1549();
   }

   public void m_211(DrawContext var1, int var2, int var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      float var10 = Util39.m_2529(var4 * var8, 0.0F, 1.0F);
      if (!(var10 <= f_1436)) {
         int var11 = (int)(f_1437 * var10);
         boolean var12 = this.f_1425 != null;
         Util158.m_1031(var5 - 1.0F, var6 - 1.0F, var7 + 2.0F, f_1438, f_1439, Util71.m_3389(f_1440, (int)(f_1441 * var10)), var10);
         Util158.m_1031(var5, var6, var7, f_1442, f_1443, Util71.m_3389(f_1444, (int)(f_1445 * var10)), var10);
         Util93.f_6001[16].m_2915(var1, f_1446, var5 + f_1447, var6 + f_1448, Util71.m_3389(-1, var11));
         Util93.f_6003[13].m_2915(var1, f_1449, var5 + f_1450, var6 + f_1451, Util71.m_3389(f_1452, var11));
         float var13 = var5 + f_1453;
         float var14 = var6 + f_1454;
         float var15 = var7 - f_1455;
         int var16 = var12 ? var9 : this.f_1428;
         float var17 = var12 ? f_1456 : 0.0F;
         Util158.m_1031(
            var13 - f_1457,
            var14 - f_1458,
            var15 + 1.0F,
            f_1459,
            f_1460,
            Util71.m_2924(Util71.m_3389(f_1461, (int)(f_1462 * var10)), Util71.m_3389(var16, (int)(f_1463 * var10)), var17),
            var10
         );
         Util158.m_1031(
            var13,
            var14,
            var15,
            f_1464,
            f_1465,
            Util71.m_2924(Util71.m_3389(f_1466, (int)(f_1467 * var10)), Util71.m_3389(Util71.m_2101(var16, f_1468), (int)(f_1469 * var10)), var17),
            var10
         );
         Util93.f_6003[13].m_1904(var1, this.f_1426, var13 + f_1470, var14 + f_1471, Util71.m_3389(this.f_1428, var11), f_1472);
         Util93.f_6001[12].m_1904(var1, this.f_1427, var13 + f_1473, var14 + f_1474, Util71.m_3389(this.f_1429, var11), f_1475);
         Util158.m_1115(var13 + var15 - f_1476, var14 + f_1477, f_1478, Util71.m_3389(var16, var11));
         boolean var19 = var12 && this.m_1092(var2, var3, var5, var6, var7, var8);
         this.f_1424.m_3631(var19 ? 1.0 : 0.0);
         float var20 = (float)this.f_1424.m_2276();
         float var21 = var12 ? Math.max(f_1479, var20) : 0.0F;
         float var22 = var5 + f_1480;
         float var23 = var6 + f_1481 - f_1482 - f_1483;
         float var24 = var7 - f_1484;
         Util158.m_1031(
            var22 - f_1485,
            var23 - f_1486,
            var24 + 1.0F,
            f_1487,
            f_1488,
            Util71.m_2924(Util71.m_3389(f_1489, (int)(f_1490 * var10)), Util71.m_3389(var9, (int)(f_1491 * var10)), var21),
            var10
         );
         Util158.m_1031(
            var22,
            var23,
            var24,
            f_1492,
            f_1493,
            Util71.m_2924(Util71.m_3389(f_1494, (int)(f_1495 * var10)), Util71.m_3389(Util71.m_2101(var9, f_1496), (int)(f_1497 * var10)), var21),
            var10
         );
         String var25 = f_1498;
         float var26 = Util93.f_6001[13].m_585(var25);
         int var27 = var12 ? Util71.m_2924(f_1499, f_1500, var20) : f_1501;
         Util93.f_6001[13].m_2915(var1, var25, var22 + (var24 - var26) / 2.0F, var23 + f_1502, Util71.m_3389(var27, var11));
      }
   }

   public float m_1013() {
      return f_1431;
   }

   public void m_1549() {
      this.f_1425 = null;
      this.m_3655(f_1432, f_1433, f_1434, f_1435);
   }
}
