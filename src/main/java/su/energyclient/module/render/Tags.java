package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardEntry;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector2d;
import org.joml.Vector2f;
import org.joml.Vector3d;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util12;
import su.energyclient.util.Util158;
import su.energyclient.util.Util169;
import su.energyclient.util.Util63;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;
import su.energyclient.util.Util93;
import su.energyclient.util.math.MathUtil10;

public class Tags extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final long f_1521 = Long.MIN_VALUE;
   private static final String[] f_1522 = new String[]{
      Tags.f_1612, Tags.f_1613, Tags.f_1614, Tags.f_1615, Tags.f_1616, Tags.f_1617, Tags.f_1618, Tags.f_1619, Tags.f_1620, Tags.f_1621
   };
   private final ObjectArrayList<Entity> f_1523 = new ObjectArrayList();
   private final IntOpenHashSet f_1524 = new IntOpenHashSet();
   private final Int2ObjectOpenHashMap<Tags.NTJLd2M2cFB40xb9> f_1525 = new Int2ObjectOpenHashMap();
   private final Int2ObjectOpenHashMap<Tags.EMN9O3kWBNAmnmO9> f_1526 = new Int2ObjectOpenHashMap();
   private final Long2ObjectOpenHashMap<String> f_1527 = new Long2ObjectOpenHashMap();
   private final Object2FloatOpenHashMap<String> f_1528 = new Object2FloatOpenHashMap();
   private final Vector3d[] f_1529 = new Vector3d[8];
   private final StringBuilder f_1530 = new StringBuilder(16);
   private final Vector2d f_1531 = new Vector2d();
   private final Vector2d f_1532 = new Vector2d();
   private long f_1533;
   private long f_1534;
   private final BooleanSetting f_1535;
   private final BooleanSetting f_1536;
   private final Util63 f_1537;
   private final BooleanSetting f_1538;
   private final BooleanSetting f_1539;
   private final BooleanSetting f_1540;
   private final BooleanSetting f_1541;
   private static final String f_1542 = "Tags";
   private static final String f_1543 = "description";
   private static final long f_1544 = Long.MIN_VALUE;
   private static final long f_1545 = Long.MIN_VALUE;
   private static final String f_1546 = "Игроки";
   private static final String f_1547 = "Предметы";
   private static final String f_1548 = "Отображать";
   private static final String f_1549 = "Показывать броню";
   private static final String f_1550 = "Показывать прочность";
   private static final String f_1551 = "Показывать чары брони";
   private static final String f_1552 = "Показывать бокс";
   private static final float f_1553 = 255.0F;
   private static final float f_1554 = 255.0F;
   private static final float f_1555 = 255.0F;
   private static final float f_1556 = 255.0F;
   private static final float f_1557 = 255.0F;
   private static final float f_1558 = 255.0F;
   private static final float f_1559 = 255.0F;
   private static final float f_1560 = 255.0F;
   private static final float f_1561 = 1.5F;
   private static final double f_1562 = 1.5;
   private static final float f_1563 = 0.1F;
   private static final float f_1564 = 0.2F;
   private static final float f_1565 = 0.1F;
   private static final float f_1566 = 1.5F;
   private static final float f_1567 = 15.0F;
   private static final float f_1568 = 4.0F;
   private static final float f_1569 = 3.0F;
   private static final float f_1570 = 5.5F;
   private static final float f_1571 = 12.0F;
   private static final float f_1572 = 4.0F;
   private static final float f_1573 = 12.0F;
   private static final float f_1574 = 8.0F;
   private static final float f_1575 = 0.75F;
   private static final float f_1576 = 16.0F;
   private static final float f_1577 = 4.0F;
   private static final float f_1578 = 1.5F;
   private static final float f_1579 = 0.5F;
   private static final float f_1580 = 0.5F;
   private static final float f_1581 = 2.5F;
   private static final float f_1582 = 4.0F;
   private static final float f_1583 = 0.5F;
   private static final float f_1584 = 6.0F;
   private static final float f_1585 = 4.0F;
   private static final float f_1586 = 6.0F;
   private static final float f_1587 = 1.5F;
   private static final float f_1588 = 15.0F;
   private static final float f_1589 = 4.0F;
   private static final float f_1590 = 3.0F;
   private static final float f_1591 = 5.5F;
   private static final float f_1592 = 0.66F;
   private static final float f_1593 = 0.66F;
   private static final float f_1594 = 0.34F;
   private static final float f_1595 = 255.0F;
   private static final float f_1596 = 0.8F;
   private static final float f_1597 = 0.33F;
   private static final float f_1598 = 0.33F;
   private static final float f_1599 = 0.33F;
   private static final float f_1600 = 140.0F;
   private static final float f_1601 = 115.0F;
   private static final float f_1602 = 0.33F;
   private static final float f_1603 = 50.0F;
   private static final float f_1604 = 90.0F;
   private static final long f_1605 = 4294967295L;
   private static final String f_1606 = "[F] ";
   private static final String f_1607 = "INV";
   private static final float f_1608 = 20.0F;
   private static final float f_1609 = 20.0F;
   private static final long f_1610 = Long.MIN_VALUE;
   private static final long f_1611 = Long.MIN_VALUE;
   private static final String f_1612 = "I";
   private static final String f_1613 = "II";
   private static final String f_1614 = "III";
   private static final String f_1615 = "IV";
   private static final String f_1616 = "V";
   private static final String f_1617 = "VI";
   private static final String f_1618 = "VII";
   private static final String f_1619 = "VIII";
   private static final String f_1620 = "IX";
   private static final String f_1621 = "X";

   private void m_3683(ObjectArrayList<Tags.j8dJk6DNjM7C544R> var1, ItemStack var2) {
      if (!var2.isEmpty()) {
         Tags.j8dJk6DNjM7C544R var3 = new Tags.j8dJk6DNjM7C544R();
         var3.f_1364 = var2.copy();
         if (var3.f_1364.isDamageable() && var3.f_1364.getMaxDamage() > 0) {
            var3.f_1365 = true;
            var3.f_1366 = (float)(var3.f_1364.getMaxDamage() - var3.f_1364.getDamage()) / var3.f_1364.getMaxDamage();
         }

         if (this.f_1540.m_1163()) {
            ItemEnchantmentsComponent var4 = (ItemEnchantmentsComponent)var3.f_1364.get(DataComponentTypes.ENCHANTMENTS);
            if (var4 != null) {
               for (RegistryEntry var6 : var4.getEnchantments()) {
                  int var7 = var4.getLevel(var6);
                  String var8 = this.m_558(var6, var7);
                  if (!var8.isEmpty()) {
                     var3.f_1367.add(var8);
                  }
               }
            }
         }

         var1.add(var3);
      }
   }

   private void m_1042(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      float var9 = (var8 >> 16 & 0xFF) / f_1557;
      float var10 = (var8 >> 8 & 0xFF) / f_1558;
      float var11 = (var8 & 0xFF) / f_1559;
      float var12 = (var8 >> 24 & 0xFF) / f_1560;
      Util114.m_2977(f_1561);
      BufferBuilder var13 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
      var13.vertex(var1, var2, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var7).color(var9, var10, var11, var12);
      RenderUtil12.I(var13.end());
      Util114.m_2977(1.0F);
   }

   private void m_1327() {
      IntIterator var1 = this.f_1525.keySet().iterator();

      while (var1.hasNext()) {
         int var2 = var1.nextInt();
         if (!this.f_1524.contains(var2)) {
            var1.remove();
         }
      }

      IntIterator var4 = this.f_1526.keySet().iterator();

      while (var4.hasNext()) {
         int var3 = var4.nextInt();
         if (!this.f_1524.contains(var3)) {
            var4.remove();
         }
      }
   }

   public Tags() {
      super(f_1542, f_1543, Category.RENDER);
      this.f_1533 = f_1544;
      this.f_1534 = f_1545;
      this.f_1535 = new BooleanSetting(f_1546, true);
      this.f_1536 = new BooleanSetting(f_1547, true);
      this.f_1537 = new Util63(f_1548, this.f_1535, this.f_1536);
      this.f_1538 = new BooleanSetting(f_1549, true).m_334(this.f_1535::m_1163);
      this.f_1539 = new BooleanSetting(f_1550, true).m_334(() -> this.f_1535.m_1163() && this.f_1538.m_1163());
      this.f_1540 = new BooleanSetting(f_1551, true).m_334(() -> this.f_1535.m_1163() && this.f_1538.m_1163());
      this.f_1541 = new BooleanSetting(f_1552, false).m_334(this.f_1535::m_1163);

      for (int var1 = 0; var1 < 8; var1++) {
         this.f_1529[var1] = new Vector3d();
      }
   }

   private void m_2468(Util169 var1) {
      DrawContext var2 = var1.m_4037();
      ObjectListIterator var3 = this.f_1523.iterator();

      while (var3.hasNext()) {
         Entity var4 = (Entity)var3.next();
         if (var4 instanceof PlayerEntity var5) {
            double var6 = var4.getWidth() / f_1562;
            double var8 = var4.getHeight() + f_1563 - (var4.isInSneakingPose() ? f_1564 : 0.0F);
            if (this.m_3654(var4, var6, var8)) {
               Tags.NTJLd2M2cFB40xb9 var10 = this.m_719(var5);
               float var11 = (float)this.f_1531.x;
               float var12 = (float)this.f_1531.y;
               float var13 = (float)this.f_1532.x;
               this.m_3302(var2, var10, var11, var13, var12);
               if (this.f_1538.m_1163()) {
                  this.m_2826(var2, var10, var11, var13, var12);
               }
            }
         } else if (var4 instanceof ItemEntity var14) {
            double var15 = var4.getWidth();
            double var16 = var4.getHeight() + f_1565;
            if (this.m_3654(var4, var15, var16)) {
               float var17 = (float)this.f_1531.x;
               float var18 = (float)this.f_1531.y;
               float var19 = (float)this.f_1532.x;
               Tags.EMN9O3kWBNAmnmO9 var20 = this.m_4060(var14);
               if (var20 != null) {
                  this.m_2295(var2, var20, var17, var19, var18);
               }
            }
         }
      }
   }

   private String m_558(RegistryEntry<Enchantment> var1, int var2) {
      long var3 = (long)System.identityHashCode(var1.value()) << 32 ^ var2 & f_1605;
      String var5 = (String)this.f_1527.get(var3);
      if (var5 != null) {
         return var5;
      } else {
         String var6 = this.m_3362(var1, var2);
         this.f_1527.put(var3, var6);
         return var6;
      }
   }

   private float m_1134(PlayerEntity var1) {
      float var2 = var1.getHealth();
      if (!InitManager.f_2740.f_2741.fixhp.m_677()) {
         return var2;
      } else {
         this.m_1620();
         String var3 = var1.getName().getString();
         if (!this.f_1528.containsKey(var3)) {
            return f_1608;
         } else {
            float var4 = this.f_1528.getFloat(var3);
            return var4 <= 0.0F ? f_1609 : var4;
         }
      }
   }

   private void m_1774() {
      long var1 = f_5909.world.getTime();
      if (this.f_1533 != var1) {
         this.f_1533 = var1;
         this.f_1523.clear();
         this.f_1524.clear();

         for (Entity var4 : f_5909.world.getEntities()) {
            if (this.m_1576(var4)) {
               this.f_1523.add(var4);
               this.f_1524.add(var4.getId());
            }
         }

         this.m_1327();
      }
   }

   private void m_3672(Box var1) {
      this.f_1529[0].set(var1.minX, var1.minY, var1.minZ);
      this.f_1529[1].set(var1.minX, var1.maxY, var1.minZ);
      this.f_1529[2].set(var1.maxX, var1.minY, var1.minZ);
      this.f_1529[3].set(var1.maxX, var1.maxY, var1.minZ);
      this.f_1529[4].set(var1.minX, var1.minY, var1.maxZ);
      this.f_1529[5].set(var1.minX, var1.maxY, var1.maxZ);
      this.f_1529[6].set(var1.maxX, var1.minY, var1.maxZ);
      this.f_1529[7].set(var1.maxX, var1.maxY, var1.maxZ);
   }

   private void m_2826(DrawContext var1, Tags.NTJLd2M2cFB40xb9 var2, float var3, float var4, float var5) {
      if (!var2.f_1770.isEmpty()) {
         float var6 = var3 + (var4 - var3) / 2.0F;
         float var7 = f_1575;
         float var8 = f_1576;
         float var9 = var8 * var7;
         float var10 = f_1577;
         int var11 = var2.f_1770.size();
         float var12 = var11 * var9 + (var11 - 1) * var10;
         float var13 = var5 - Util93.f_5998[14].m_1875() * f_1578;
         float var14 = var13 - (var2.f_1767 ? 14 : 1) - var9;
         float var15 = var6 - var12 / 2.0F;

         try (Util158.PhIPT3TwNL2N87b8 var16 = Util158.m_3873()) {
            ObjectListIterator var17 = var2.f_1770.iterator();

            while (var17.hasNext()) {
               Tags.j8dJk6DNjM7C544R var18 = (Tags.j8dJk6DNjM7C544R)var17.next();
               ItemStack var19 = var18.f_1364;
               if (!var19.isEmpty()) {
                  float var20 = var15;
                  Util158.m_1849(var15 - f_1579, var14 - f_1580, var9 + 1.0F, var9 + 1.0F, 0.0F, Util71.m_2523(20, 20, 20, 150));
                  if (this.f_1539.m_1163() && var18.f_1365) {
                     float var23 = f_1581;
                     float var25 = var14 - f_1582;
                     int var26 = this.m_1525(var18.f_1366);
                     Util158.m_1849(var15, var25, var9, var23, 0.0F, Util71.m_2523(15, 15, 15, 200));
                     float var27 = (var9 - 2.0F) * var18.f_1366;
                     if (var27 > 0.0F) {
                        Util158.m_1849(var15 + 1.0F, var25 + f_1583, var27, var23 - 1.0F, 0.0F, var26);
                     }
                  }

                  Util158.m_3781(var1, var19, var15, var14, var7, -1, 1.0F, false);
                  if (this.f_1540.m_1163() && !var18.f_1367.isEmpty()) {
                     float var22 = var14 - f_1584;
                     if (this.f_1539.m_1163() && var18.f_1365) {
                        var22 -= f_1585;
                     }

                     for (ObjectListIterator var30 = var18.f_1367.iterator(); var30.hasNext(); var22 -= Util93.f_5998[12].m_1875() - f_1586) {
                        String var24 = (String)var30.next();
                        Util93.f_5998[12].m_765(var1, var24, var20 + var9 / 2.0F, var22, -1);
                     }
                  }

                  var15 += var9 + var10;
               }
            }
         }
      }
   }

   private void m_715() {
      this.f_1523.clear();
      this.f_1524.clear();
      this.f_1525.clear();
      this.f_1526.clear();
      this.f_1528.clear();
      this.f_1527.clear();
      this.f_1533 = f_1610;
      this.f_1534 = f_1611;
   }

   private Text m_731(PlayerEntity var1, boolean var2, float var3) {
      Text var4 = var1.getDisplayName();
      if (var4 == null) {
         var4 = var1.getName();
      }

      int var5 = Math.max(0, Math.round(var3));
      MutableText var6 = var2 ? Text.literal(f_1606).formatted(Formatting.GREEN) : Text.empty();
      MutableText var7 = Text.literal(" " + (var5 > 990 ? f_1607 : var5 + "HP")).formatted(Formatting.RED);
      return Text.empty().append(var6).append(var4).append(var7);
   }

   private Tags.EMN9O3kWBNAmnmO9 m_4060(ItemEntity var1) {
      ItemStack var2 = var1.getStack();
      if (var2.isEmpty()) {
         return null;
      } else {
         long var3 = f_5909.world.getTime();
         int var5 = this.m_3866(var2);
         Tags.EMN9O3kWBNAmnmO9 var6 = (Tags.EMN9O3kWBNAmnmO9)this.f_1526.computeIfAbsent(var1.getId(), var0 -> new Tags.EMN9O3kWBNAmnmO9());
         if (var6.f_7851 == var3 && var6.f_7852 == var5) {
            return var6;
         } else {
            MutableText var7 = Text.empty().append(var2.getName());
            if (var2.getCount() > 1) {
               var7 = var7.copy().append(Text.literal(" x" + var2.getCount()).formatted(Formatting.GRAY));
            }

            var6.f_7853 = var7;
            var6.f_7854 = Util93.f_5998[14].m_3324(var7);
            var6.f_7852 = var5;
            var6.f_7851 = var3;
            return var6;
         }
      }
   }

   private int m_1525(float var1) {
      int var2;
      int var3;
      byte var4;
      if (var1 > f_1592) {
         float var5 = (var1 - f_1593) / f_1594;
         var2 = (int)(f_1595 * (1.0F - var5) * f_1596);
         var3 = 255;
         var4 = 50;
      } else if (var1 > f_1597) {
         float var6 = (var1 - f_1598) / f_1599;
         var2 = 255;
         var3 = (int)(f_1600 + f_1601 * var6);
         var4 = 30;
      } else {
         float var7 = var1 / f_1602;
         var2 = 255;
         var3 = (int)(f_1603 + f_1604 * var7);
         var4 = 30;
      }

      return Util71.m_2523(var2, var3, var4, 255);
   }

   private void m_1900(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      float var9 = (var8 >> 16 & 0xFF) / f_1553;
      float var10 = (var8 >> 8 & 0xFF) / f_1554;
      float var11 = (var8 & 0xFF) / f_1555;
      float var12 = (var8 >> 24 & 0xFF) / f_1556;
      BufferBuilder var13 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      var13.vertex(var1, var2, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var6, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var7).color(var9, var10, var11, var12);
      var13.vertex(var1, var5, var3, var4).color(var9, var10, var11, var12);
      var13.vertex(var1, var2, var3, var4).color(var9, var10, var11, var12);
      RenderUtil12.I(var13.end());
   }

   private void m_3302(DrawContext var1, Tags.NTJLd2M2cFB40xb9 var2, float var3, float var4, float var5) {
      float var6 = var3 + (var4 - var3) / 2.0F;
      float var7 = var5 - Util93.f_5998[14].m_1875() * f_1566;
      float var8 = var2.f_1765;
      float var9 = f_1567;
      Util158.m_1849(
         var6 - var8 / 2.0F - 2.0F,
         var7 + 1.0F,
         var8 + f_1568,
         var9 - f_1569,
         0.0F,
         var2.f_1766 ? Util71.m_2523(35, 81, 41, 150) : Util71.m_2523(20, 20, 20, 150)
      );
      Util93.f_5998[14].m_2959(var1, var2.f_1764, var6 - var8 / 2.0F, var7 + f_1570, -1);
      this.m_4049(var1, var2, var6, var7);
   }

   private Tags.NTJLd2M2cFB40xb9 m_719(PlayerEntity var1) {
      long var2 = f_5909.world.getTime();
      Tags.NTJLd2M2cFB40xb9 var4 = (Tags.NTJLd2M2cFB40xb9)this.f_1525.computeIfAbsent(var1.getId(), var0 -> new Tags.NTJLd2M2cFB40xb9());
      if (var4.f_1763 == var2) {
         return var4;
      } else {
         boolean var5 = InitManager.f_2740.f_2744.m_3914(var1);
         float var6 = this.m_1134(var1);
         var4.f_1766 = var5;
         var4.f_1764 = this.m_731(var1, var5, var6);
         var4.f_1765 = Util93.f_5998[14].m_3324(var4.f_1764);
         ItemStack var7 = var1.getOffHandStack();
         var4.f_1767 = var7.getItem() == Items.PLAYER_HEAD;
         if (var4.f_1767) {
            var4.f_1768 = var7.getName();
            var4.f_1769 = Util93.f_5998[14].m_3324(var4.f_1768);
         } else {
            var4.f_1768 = Text.empty();
            var4.f_1769 = 0.0F;
         }

         var4.f_1770.clear();
         if (this.f_1538.m_1163()) {
            this.m_3683(var4.f_1770, var1.getMainHandStack());

            for (ItemStack var9 : Util12.m_1105(var1)) {
               this.m_3683(var4.f_1770, var9);
            }

            this.m_3683(var4.f_1770, var7);
         }

         var4.f_1763 = var2;
         return var4;
      }
   }

   private void m_2295(DrawContext var1, Tags.EMN9O3kWBNAmnmO9 var2, float var3, float var4, float var5) {
      float var6 = var3 + (var4 - var3) / 2.0F;
      float var7 = var5 - Util93.f_5998[14].m_1875() * f_1587;
      float var8 = var2.f_7854;
      float var9 = f_1588;
      Util158.m_1849(var6 - var8 / 2.0F - 2.0F, var7 + 1.0F, var8 + f_1589, var9 - f_1590, 0.0F, Util71.m_2523(20, 20, 20, 150));
      Util93.f_5998[14].m_2959(var1, var2.f_7853, var6 - var8 / 2.0F, var7 + f_1591, -1);
   }

   private String m_3362(RegistryEntry<Enchantment> var1, int var2) {
      if (var2 < 0) {
         return "";
      } else {
         this.f_1530.setLength(0);
         String var3 = ((Enchantment)var1.value()).description().getString();
         if (var3.length() >= 2) {
            this.f_1530.append(var3, 0, 2);
         }

         this.f_1530.append(' ');
         if (var2 != 1 || ((Enchantment)var1.value()).getMaxLevel() != 1) {
            if (var2 == 32767) {
               this.f_1530.append('∞');
            } else if (var2 > 10) {
               this.f_1530.append(var2);
            } else if (var2 > 0 && var2 <= 10) {
               this.f_1530.append(f_1522[var2 - 1]);
            } else {
               this.f_1530.append(var2);
            }
         }

         return this.f_1530.toString();
      }
   }

   @EventHandler
   private void m_3178(Util169 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         this.m_1774();
         this.m_2468(var1);
      } else {
         this.m_715();
      }
   }

   private boolean m_1576(Entity var1) {
      if (var1 == f_5909.player && f_5909.options.getPerspective().isFirstPerson()) {
         return false;
      } else if (!var1.isAlive()) {
         return false;
      } else if (var1 instanceof PlayerEntity) {
         return this.f_1535.m_1163();
      } else {
         return !(var1 instanceof ItemEntity var2) ? false : this.f_1536.m_1163() && !var2.getStack().isEmpty();
      }
   }

   private void m_4049(DrawContext var1, Tags.NTJLd2M2cFB40xb9 var2, float var3, float var4) {
      if (var2.f_1767) {
         Util158.m_1849(
            var3 - var2.f_1769 / 2.0F - 2.0F,
            var4 - f_1571,
            var2.f_1769 + f_1572,
            f_1573,
            0.0F,
            var2.f_1766 ? Util71.m_2523(35, 81, 41, 150) : Util71.m_2523(20, 20, 20, 150)
         );
         Util93.f_5998[14].m_2959(var1, var2.f_1768, var3 - var2.f_1769 / 2.0F, var4 - f_1574, -1);
      }
   }

   private boolean m_3654(Entity var1, double var2, double var4) {
      Vector3d var6 = Util158.m_508(var1, f_5909.getRenderTickCounter().getTickProgress(false));
      double var7 = var6.x;
      double var9 = var6.y;
      double var11 = var6.z;
      Box var13 = new Box(var7 - var2, var9, var11 - var2, var7 + var2, var9 + var4, var11 + var2);
      return this.m_2135(var13);
   }

   private void m_1620() {
      long var1 = f_5909.world.getTime();
      if (this.f_1534 != var1) {
         this.f_1534 = var1;
         this.f_1528.clear();
         Scoreboard var3 = f_5909.world.getScoreboard();
         ScoreboardObjective var4 = var3.getObjectiveForSlot(ScoreboardDisplaySlot.BELOW_NAME);
         if (var4 != null) {
            for (ScoreboardEntry var6 : var3.getScoreboardEntries(var4)) {
               this.f_1528.put(var6.owner(), var6.value());
            }
         }
      }
   }

   @EventHandler
   private void m_4058(Util88 var1) {
      if (f_5909.world != null && f_5909.player != null && this.f_1541.m_1163() && this.f_1535.m_1163()) {
         this.m_1774();
         Camera var2 = f_5909.gameRenderer.getCamera();
         Vec3d var3 = var2.getCameraPos();
         float var4 = var1.m_191();
         Matrix4f var5 = var1.m_213().peek().getPositionMatrix();
         Util114.m_1481();
         Util114.m_542();
         Util114.m_3978();
         Util114.m_672();
         Util114.m_1878(false);
         Util114.m_3784(RenderUtil7.f_13885);
         ObjectListIterator var6 = this.f_1523.iterator();

         while (var6.hasNext()) {
            Entity var7 = (Entity)var6.next();
            if (var7 instanceof PlayerEntity) {
               double var8 = MathHelper.lerp(var4, var7.lastX, var7.getX()) - var3.x;
               double var10 = MathHelper.lerp(var4, var7.lastY, var7.getY()) - var3.y;
               double var12 = MathHelper.lerp(var4, var7.lastZ, var7.getZ()) - var3.z;
               float var14 = var7.getWidth() / 2.0F;
               float var15 = var7.getHeight();
               float var16 = (float)(var8 - var14);
               float var17 = (float)var10;
               float var18 = (float)(var12 - var14);
               float var19 = (float)(var8 + var14);
               float var20 = (float)(var10 + var15);
               float var21 = (float)(var12 + var14);
               int var22 = InitManager.f_2740.f_2744.m_3914((PlayerEntity)var7) ? Util71.m_1415(0, 255, 0) : EnergyClient.getTheme(0);
               int var23 = Util71.m_3389(var22, 35);
               int var24 = Util71.m_3389(var22, 200);
               this.m_1900(var5, var16, var17, var18, var19, var20, var21, var23);
               this.m_1042(var5, var16, var17, var18, var19, var20, var21, var24);
            }
         }

         Util114.m_100();
         Util114.m_1878(true);
         Util114.m_1562();
         Util114.m_963();
      }
   }

   private int m_3866(ItemStack var1) {
      int var2 = System.identityHashCode(var1.getItem());
      var2 = 31 * var2 + var1.getCount();
      var2 = 31 * var2 + var1.getDamage();
      return 31 * var2 + var1.getName().getString().hashCode();
   }

   private boolean m_2135(Box var1) {
      this.m_3672(var1);
      boolean var2 = false;

      for (Vector3d var6 : this.f_1529) {
         Vector2f var7 = MathUtil10.m_362(var6.x, var6.y, var6.z, false, false);
         if (var7 != null) {
            if (!var2) {
               this.f_1531.set(var7.x, var7.y);
               this.f_1532.set(var7.x, var7.y);
               var2 = true;
            } else {
               this.f_1531.x = Math.min(this.f_1531.x, (double)var7.x);
               this.f_1531.y = Math.min(this.f_1531.y, (double)var7.y);
               this.f_1532.x = Math.max(this.f_1532.x, (double)var7.x);
               this.f_1532.y = Math.max(this.f_1532.y, (double)var7.y);
            }
         }
      }

      return var2;
   }

   private static final class EMN9O3kWBNAmnmO9 {
      private long f_7851;
      private int f_7852;
      private Text f_7853;
      private float f_7854;
      private static final long f_7855 = Long.MIN_VALUE;

      private EMN9O3kWBNAmnmO9() {
         this.f_7851 = f_7855;
         this.f_7852 = 0;
         this.f_7853 = Text.empty();
         this.f_7854 = 0.0F;
      }
   }

   private static final class NTJLd2M2cFB40xb9 {
      private long f_1763;
      private Text f_1764;
      private float f_1765;
      private boolean f_1766;
      private boolean f_1767;
      private Text f_1768;
      private float f_1769;
      private final ObjectArrayList<Tags.j8dJk6DNjM7C544R> f_1770;
      private static final long f_1771 = Long.MIN_VALUE;

      private NTJLd2M2cFB40xb9() {
         this.f_1763 = f_1771;
         this.f_1764 = Text.empty();
         this.f_1765 = 0.0F;
         this.f_1766 = false;
         this.f_1767 = false;
         this.f_1768 = Text.empty();
         this.f_1769 = 0.0F;
         this.f_1770 = new ObjectArrayList(6);
      }
   }

   private static final class j8dJk6DNjM7C544R {
      private ItemStack f_1364 = ItemStack.EMPTY;
      private boolean f_1365 = false;
      private float f_1366 = 0.0F;
      private final ObjectArrayList<String> f_1367 = new ObjectArrayList(4);
   }
}
