package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
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
import su.energyclient.util.Util124;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;

public class Dashtrail extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static Dashtrail f_1633;
   private static final String f_1634 = "dashtrail/";
   private static final String f_1635 = "";
   private static final String f_1636 = "";
   private static final String f_1637 = "";
   private static final int f_1638 = Util71.m_1415(170, 40, 255);
   public final BooleanSetting f_1639;
   public final BooleanSetting f_1640;
   public final BooleanSetting f_1641;
   private final ModeSetting f_1642;
   private final NumberSetting f_1643;
   private final NumberSetting f_1644;
   private final NumberSetting f_1645;
   private final NumberSetting f_1646;
   private final BooleanSetting f_1647;
   private final BooleanSetting f_1648;
   private final BooleanSetting f_1649;
   private final BooleanSetting f_1650;
   private final NumberSetting f_1651;
   private final NumberSetting f_1652;
   private Identifier f_1653;
   private final List<Dashtrail.fWXVDd5cthTckpqG> f_1654;
   private final List<List<Dashtrail.fWXVDd5cthTckpqG>> f_1655;
   private final List<Dashtrail.Inner_2jfqKW2v6ENkZ89V> f_1656;
   private final Map<Integer, Vec3d> f_1657;
   private final Random f_1658;
   private final Dashtrail.tH0T07W0kHbD1aIO f_1659;
   private final Dashtrail.tH0T07W0kHbD1aIO f_1660;
   private boolean f_1661;
   private boolean f_1662;
   private boolean f_1663;
   private int f_1664;
   private Identifier f_1665;
   private static final String f_1666 = "DashTrail";
   private static final String f_1667 = "Следы рывка как в Vega";
   private static final String f_1668 = "Себя";
   private static final String f_1669 = "Игроков";
   private static final String f_1670 = "Друзей";
   private static final String f_1671 = "Цвет";
   private static final String f_1672 = "Случайная палитра";
   private static final String f_1673 = "Случайная палитра";
   private static final String f_1674 = "Свой";
   private static final String f_1675 = "Клиент";
   private static final String f_1676 = "Радуга";
   private static final String f_1677 = "Свой цвет R";
   private static final float f_1678 = 255.0F;
   private static final String f_1679 = "Свой цвет G";
   private static final float f_1680 = 255.0F;
   private static final String f_1681 = "Свой цвет B";
   private static final float f_1682 = 255.0F;
   private static final String f_1683 = "Дистанция";
   private static final float f_1684 = 25.0F;
   private static final float f_1685 = 15.0F;
   private static final float f_1686 = 100.0F;
   private static final String f_1687 = "Сглаживание движения";
   private static final String f_1688 = "Сегменты";
   private static final String f_1689 = "Точки";
   private static final String f_1690 = "Свечение";
   private static final String f_1691 = "Длина";
   private static final float f_1692 = 0.75F;
   private static final float f_1693 = 0.5F;
   private static final float f_1694 = 1.5F;
   private static final float f_1695 = 0.05F;
   private static final String f_1696 = "Размер";
   private static final float f_1697 = 1.8F;
   private static final float f_1698 = 0.5F;
   private static final float f_1699 = 4.0F;
   private static final float f_1700 = 0.05F;
   private static final String f_1701 = "dashtrail/dashbloomsample.png";
   private static final float f_1702 = 0.035F;
   private static final float f_1703 = 0.12F;
   private static final long f_1704 = 1234567891L;
   private static final float f_1705 = 0.05F;
   private static final String f_1706 = "Случайная палитра";
   private static final String f_1707 = "Клиент";
   private static final String f_1708 = "Свой";
   private static final long f_1709 = 1000L;
   private static final float f_1710 = 1000.0F;
   private static final float f_1711 = 0.8F;
   private static final double f_1712 = 0.08F;
   private static final double f_1713 = 0.08;
   private static final float f_1714 = 0.04F;
   private static final float f_1715 = 255.0F;
   private static final float f_1716 = 550.0F;
   private static final float f_1717 = -1.0F;
   private static final float f_1718 = -0.1F;
   private static final float f_1719 = -0.1F;
   private static final float f_1720 = 0.1F;
   private static final float f_1721 = 1.33333F;
   private static final float f_1722 = 0.016F;
   private static final float f_1723 = 3.0F;
   private static final String f_1724 = "energy";
   private static final double f_1725 = 0.5;
   private static final double f_1726 = 2.0;
   private static final double f_1727 = 0.5;
   private static final double f_1728 = 2.0;
   private static final double f_1729 = -2.0;
   private static final double f_1730 = 2.0;
   private static final double f_1731 = 2.0;
   private static final double f_1732 = 2.0;
   private static final float f_1733 = 360.0F;
   private static final float f_1734 = 180.0F;
   private static final float f_1735 = 360.0F;
   private static final float f_1736 = 0.05F;
   private static final float f_1737 = 0.02F;
   private static final String f_1738 = "Свой";
   private static final String f_1739 = "Свой";
   private static final String f_1740 = "Свой";

   private static float m_3715(float var0, float var1) {
      float var2 = Math.abs(var1 - var0) % f_1733;
      return var2 > f_1734 ? f_1735 - var2 : var2;
   }

   private boolean m_1014(LivingEntity var1) {
      if (var1 == f_5909.player) {
         return this.f_1639.m_1163();
      } else if (!(var1 instanceof PlayerEntity var2 && (this.f_1640.m_1163() || this.f_1641.m_1163()))) {
         return false;
      } else if (f_5909.getCameraEntity() != null && f_5909.getCameraEntity().distanceTo(var2) > this.f_1646.m_4046()) {
         return false;
      } else {
         boolean var3 = InitManager.f_2740.f_2744 != null && InitManager.f_2740.f_2744.m_2704(var2.getGameProfile().name());
         return this.f_1640.m_1163() && !var3 || this.f_1641.m_1163() && var3;
      }
   }

   void m_2700(Dashtrail.Inner_2jfqKW2v6ENkZ89V var1) {
      var1.f_4132.add(new Dashtrail.nlFzc9HimsulxqWE());
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_1659.f_6145 = 1.0F;
      this.f_1659.m_3436(0.0F);
      this.f_1657.clear();
   }

   private void m_993(MatrixStack var1, List<Dashtrail.Inner_2jfqKW2v6ENkZ89V> var2, float var3, Vec3d var4) {
      if (this.m_1720(var2)) {
         Util114.m_3784(RenderUtil7.f_13885);
         Matrix4f var5 = var1.peek().getPositionMatrix();
         BufferBuilder var6 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

         for (Dashtrail.Inner_2jfqKW2v6ENkZ89V var8 : var2) {
            double[] var9 = this.m_829(var8, var3, var4);

            for (Dashtrail.nlFzc9HimsulxqWE var11 : var8.f_4132) {
               double[] var12 = var11.m_3934(var3);
               float var13 = (float)(var11.m_2190() * var8.f_4127.f_6144);
               var13 = (float)m_1050(var13);
               int var14 = m_189(var8.f_4130, m_2796(-1, Util71.m_2734(var8.f_4130)), 1.0F - var13);
               var14 = m_2796(var14, Util71.m_2734(var14) * var13 / f_1723);
               var6.vertex(var5, (float)(var12[0] + var9[0]), (float)(var12[1] + var9[1]), (float)(var12[2] + var9[2])).color(var14);
               var6.vertex(var5, (float)(-var12[0] + var9[0]), (float)(-var12[1] + var9[1]), (float)(-var12[2] + var9[2])).color(var14);
            }
         }

         RenderUtil12.I(var6.end());
      }
   }

   void m_973(Dashtrail.Inner_2jfqKW2v6ENkZ89V var1) {
      if (!var1.f_4132.isEmpty()) {
         if (var1.f_4133) {
            var1.f_4132.removeIf(Dashtrail.nlFzc9HimsulxqWE::m_2793);
         } else {
            var1.f_4132.clear();
         }
      }
   }

   private void m_2247(MatrixStack var1, float var2, float var3, float var4, float var5, int var6) {
      this.m_2994(var1, var2, var3, var4, var5, var6, var6, var6, var6);
   }

   private void m_946(MatrixStack var1, double[] var2, Runnable var3, float[] var4) {
      var1.push();
      var1.translate(var2[0], var2[1], var2[2]);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-var4[0]));
      float var5 = f_5909.options.getPerspective() == Perspective.THIRD_PERSON_FRONT ? f_1717 : 1.0F;
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var4[1] * var5));
      var1.scale(f_1718, f_1719, f_1720);
      var3.run();
      var1.pop();
   }

   private double[] m_829(Dashtrail.Inner_2jfqKW2v6ENkZ89V var1, float var2, Vec3d var3) {
      return new double[]{var1.m_1625(var2) - var3.x, var1.m_3077(var2) - var3.y, var1.m_2069(var2) - var3.z};
   }

   private boolean m_2221() {
      return this.f_1658.nextInt(100) > 40;
   }

   private void m_2682() {
      this.f_1660.f_6145 = this.f_1650.m_1163() ? 1.0F : 0.0F;
      this.f_1660.m_2864();
      this.f_1656.stream().filter(var0 -> var0.m_3548() >= 1.0F && var0.f_4127.f_6145 != 0.0F).forEach(var0 -> var0.f_4127.f_6145 = 0.0F);
      this.f_1656.removeIf(var0 -> var0.m_3548() >= 1.0F && var0.f_4127.f_6145 == 0.0F && var0.f_4127.m_2864() < f_1737);
      List<Dashtrail.Inner_2jfqKW2v6ENkZ89V> var1 = this.O();
      int var2 = 0;
      int var3 = this.f_1647.m_1163() ? var1.size() : -1;

      for (Dashtrail.Inner_2jfqKW2v6ENkZ89V var5 : var1) {
         var2++;
         var5.m_2401(var2 < var3 ? (Dashtrail.Inner_2jfqKW2v6ENkZ89V)var1.get(var2) : null);
      }
   }

   private Dashtrail.fWXVDd5cthTckpqG m_2893(int var1) {
      return this.f_1654.get(var1);
   }

   private boolean m_4091() {
      return this.f_1639.m_1163() || this.f_1640.m_1163() || this.f_1641.m_1163();
   }

   private int[] m_2400(Identifier var1) {
      try {
         Optional var2 = f_5909.getResourceManager().getResource(var1);
         if (var2.isPresent()) {
            try (InputStream var3 = ((Resource)var2.get()).getInputStream()) {
               BufferedImage var4 = ImageIO.read(var3);
               if (var4 != null) {
                  return new int[]{var4.getWidth(), var4.getHeight()};
               }

               return new int[]{32, 32};
            }
         }
      } catch (Exception var8) {
      }

      return new int[]{32, 32};
   }

   private void m_2504() {
      this.f_1654.clear();
      byte var1 = 21;
      int var2 = 0;

      while (var2 < var1) {
         Identifier var3 = m_349("dashtrail/dashcubics/dashcubic" + ++var2 + ".png");
         this.f_1654.add(new Dashtrail.fWXVDd5cthTckpqG(var3));
      }
   }

   private static int m_2796(int var0, float var1) {
      return Util71.m_3389(var0, MathHelper.clamp((int)var1, 0, 255));
   }

   @EventHandler
   private void m_926(Util88 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         float var2 = this.f_1659.m_2864();
         if (!(var2 < f_1705)) {
            this.f_1661 = this.f_1642.m_2073(f_1706);
            this.f_1662 = this.f_1642.m_2073(f_1707);
            this.f_1663 = this.f_1642.m_2073(f_1708);
            if (!this.f_1661 && !this.f_1662 && !this.f_1663) {
               this.f_1664 = Color.getHSBColor((float)(System.currentTimeMillis() % f_1709) / f_1710, f_1711, 1.0F).getRGB();
            }

            boolean[] var3 = this.m_3773();
            List<Dashtrail.Inner_2jfqKW2v6ENkZ89V> var4 = this.O();
            if (!var4.isEmpty()) {
               MatrixStack var5 = var1.m_213();
               Camera var6 = f_5909.gameRenderer.getCamera();
               Vec3d var7 = var6.getCameraPos();
               float var8 = var1.m_191();
               if (var3[0] || var3[1]) {
                  if (var3[1]) {
                     this.m_1718(() -> this.m_649(var5, var4, var8, var7), false, false);
                  }

                  if (var3[0]) {
                     this.m_1718(() -> this.m_993(var5, var4, var8, var7), false, true);
                  }
               }

               float var9 = this.f_1660.m_2864();
               this.m_1718(() -> {
                  for (Dashtrail.Inner_2jfqKW2v6ENkZ89V var9x : var4) {
                     var9x.m_3792(var5, var6, var8, var7, false, var2, var9);
                  }

                  this.m_2982(this.f_1653);

                  for (Dashtrail.Inner_2jfqKW2v6ENkZ89V var11 : var4) {
                     var11.m_3792(var5, var6, var8, var7, true, var2, var9);
                  }
               }, true, true);
            }
         }
      }
   }

   private static double m_1050(double var0) {
      var0 = (var0 > f_1725 ? 1.0 - var0 : var0) * f_1726;
      var0 = var0 < f_1727 ? f_1728 * var0 * var0 : 1.0 - Math.pow(f_1729 * var0 + f_1730, f_1731) / f_1732;
      return MathHelper.clamp((float)var0, 0.0F, 1.0F);
   }

   private void m_1298(PlayerEntity var1, Set<Integer> var2) {
      if (var1 != null && !var1.isRemoved()) {
         int var3 = var1.getId();
         var2.add(var3);
         Vec3d var4 = var1.getEntityPos();
         Vec3d var5 = this.f_1657.put(var3, var4);
         if (var5 == null) {
            var5 = new Vec3d(var1.lastX, var1.lastY, var1.lastZ);
         }

         if (!var4.equals(var5)) {
            this.m_2835(var1, var5);
         }
      }
   }

   private void m_649(MatrixStack var1, List<Dashtrail.Inner_2jfqKW2v6ENkZ89V> var2, float var3, Vec3d var4) {
      if (this.m_1720(var2)) {
         Util114.m_3784(RenderUtil7.f_13885);
         Matrix4f var5 = var1.peek().getPositionMatrix();
         BufferBuilder var6 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

         for (Dashtrail.Inner_2jfqKW2v6ENkZ89V var8 : var2) {
            double[] var9 = this.m_829(var8, var3, var4);

            for (Dashtrail.nlFzc9HimsulxqWE var11 : var8.f_4132) {
               double[] var12 = var11.m_3934(var3);
               float var13 = (float)(var11.m_2190() * var8.f_4127.f_6144);
               var13 = (float)m_1050(var13);
               int var14 = m_189(var8.f_4130, m_2796(-1, Util71.m_2734(var8.f_4130)), var13);
               var14 = m_2796(var14, Util71.m_2734(var14) * var13 / f_1721);
               this.m_2317(var6, var5, (float)(var12[0] + var9[0]), (float)(var12[1] + var9[1]), (float)(var12[2] + var9[2]), var14);
               this.m_2317(var6, var5, (float)(-var12[0] + var9[0]), (float)(-var12[1] + var9[1]), (float)(-var12[2] + var9[2]), var14);
            }
         }

         RenderUtil12.I(var6.end());
      }
   }

   @Override
   public void m_1() {
      this.f_1656.clear();
      this.f_1657.clear();
      this.f_1665 = null;
      super.m_1();
   }

   private void m_2835(LivingEntity var1, Vec3d var2) {
      if (this.m_677() && var1 != null && this.m_4091()) {
         if (this.m_1014(var1)) {
            Vec3d var3 = var1.getEntityPos();
            double var4 = var3.x - var2.x;
            double var6 = var3.y - var2.y;
            double var8 = var3.z - var2.z;
            double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
            double var12 = Math.sqrt(var4 * var4 + var8 * var8);
            if (!(var12 < f_1712)) {
               boolean var14 = true;
               boolean[] var15 = this.m_3773();
               int var16 = MathHelper.clamp((int)(var10 / f_1713), 1, 16);

               for (int var17 = 0; var17 < var16; var17++) {
                  Dashtrail.fuLxdt7SniySa8JJ var18 = new Dashtrail.fuLxdt7SniySa8JJ(
                     var1, var2, f_1714, new Dashtrail.FBgJpX2bRyGYQDIz(var14), (float)var17 / var16, this.m_2138()
                  );
                  this.f_1656.add(new Dashtrail.Inner_2jfqKW2v6ENkZ89V(var18, var15[0] || var15[1]));
               }
            }
         }
      }
   }

   private void m_3569() {
      HashSet var1 = new HashSet();
      this.m_1298(f_5909.player, var1);

      for (PlayerEntity var3 : f_5909.world.getPlayers()) {
         this.m_1298(var3, var1);
      }

      this.f_1657.keySet().removeIf(var1x -> !var1.contains(var1x));
   }

   private void m_92() {
      this.f_1655.clear();
      int[] var1 = new int[]{11, 23, 32, 16, 32};
      int var2 = 0;

      for (int var6 : var1) {
         var2++;
         ArrayList var7 = new ArrayList();
         int var8 = 0;

         while (var8 < var6) {
            Identifier var9 = m_349("dashtrail/dashcubics/group_dashs/group" + var2 + "/dashcubic" + ++var8 + ".png");
            var7.add(new Dashtrail.fWXVDd5cthTckpqG(var9));
         }

         if (!var7.isEmpty()) {
            this.f_1655.add(var7);
         }
      }
   }

   private static int m_189(int var0, int var1, float var2) {
      int var3 = MathHelper.lerp(var2, Util71.m_1989(var0), Util71.m_1989(var1));
      int var4 = MathHelper.lerp(var2, Util71.m_644(var0), Util71.m_644(var1));
      int var5 = MathHelper.lerp(var2, Util71.m_3163(var0), Util71.m_3163(var1));
      int var6 = MathHelper.lerp(var2, Util71.m_2734(var0), Util71.m_2734(var1));
      return Util71.m_756(var3, var4, var5, var6);
   }

   private boolean m_2982(Identifier var1) {
      if (var1.equals(this.f_1665)) {
         return false;
      } else {
         this.f_1665 = var1;
         Util114.m_2037(0, this.f_1665);
         TextureManager var2 = f_5909.getTextureManager();
         AbstractTexture var3 = var2.getTexture(this.f_1665);
         if (var3 != null) {
            Util114.m_2012(var3);
         }

         return true;
      }
   }

   private int m_2138() {
      return (int)((f_1716 + this.f_1658.nextInt(300)) * this.f_1651.m_4046());
   }

   private static Identifier m_349(String var0) {
      return Identifier.of(f_1724, var0);
   }

   private List<Dashtrail.Inner_2jfqKW2v6ENkZ89V> O() {
      return this.f_1656.stream().filter(Objects::nonNull).filter(var0 -> var0.f_4127.m_2864() > f_1736).toList();
   }

   private boolean m_1720(List<Dashtrail.Inner_2jfqKW2v6ENkZ89V> var1) {
      for (Dashtrail.Inner_2jfqKW2v6ENkZ89V var3 : var1) {
         if (!var3.f_4132.isEmpty()) {
            return true;
         }
      }

      return false;
   }

   @EventHandler
   private void m_3214(Util124 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (!this.m_4091()) {
            this.m_1926(false);
         } else {
            this.m_2682();
            this.m_3569();
         }
      }
   }

   private void m_2994(MatrixStack var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, int var9) {
      Matrix4f var10 = var1.peek().getPositionMatrix();
      BufferBuilder var11 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      var11.vertex(var10, var2, var3, 0.0F).texture(0.0F, 0.0F).color(var6);
      var11.vertex(var10, var2, var5, 0.0F).texture(0.0F, 1.0F).color(var7);
      var11.vertex(var10, var4, var5, 0.0F).texture(1.0F, 1.0F).color(var8);
      var11.vertex(var10, var4, var3, 0.0F).texture(1.0F, 0.0F).color(var9);
      RenderUtil12.I(var11.end());
   }

   private static int m_632(int var0, float var1) {
      return Util71.m_756(
         MathHelper.clamp((int)(Util71.m_1989(var0) * var1), 0, 255),
         MathHelper.clamp((int)(Util71.m_644(var0) * var1), 0, 255),
         MathHelper.clamp((int)(Util71.m_3163(var0) * var1), 0, 255),
         Util71.m_2734(var0)
      );
   }

   private int m_1026() {
      return this.f_1658.nextInt(this.f_1655.size());
   }

   private int m_3287() {
      return this.f_1661
         ? Color.getHSBColor(this.f_1658.nextInt(255) / f_1715, 1.0F, 1.0F).getRGB()
         : (this.f_1662 ? EnergyClient.getTheme(0) : (this.f_1663 ? this.m_3783() : this.f_1664));
   }

   private void m_2317(BufferBuilder var1, Matrix4f var2, float var3, float var4, float var5, int var6) {
      float var7 = f_1722 * this.f_1652.m_4046();
      var1.vertex(var2, var3 - var7, var4, var5).color(var6);
      var1.vertex(var2, var3 + var7, var4, var5).color(var6);
      var1.vertex(var2, var3, var4 - var7, var5).color(var6);
      var1.vertex(var2, var3, var4 + var7, var5).color(var6);
      var1.vertex(var2, var3, var4, var5 - var7).color(var6);
      var1.vertex(var2, var3, var4, var5 + var7).color(var6);
   }

   private int m_1882() {
      return this.f_1658.nextInt(this.f_1654.size());
   }

   private int m_3783() {
      return Util71.m_1415((int)this.f_1643.m_4046(), (int)this.f_1644.m_4046(), (int)this.f_1645.m_4046());
   }

   boolean[] m_3773() {
      return new boolean[]{this.f_1648.m_1163(), this.f_1649.m_1163()};
   }

   public Dashtrail() {
      super(f_1666, f_1667, Category.RENDER);
      this.f_1639 = new BooleanSetting(f_1668, true);
      this.f_1640 = new BooleanSetting(f_1669, false);
      this.f_1641 = new BooleanSetting(f_1670, true);
      this.f_1642 = new ModeSetting(f_1671, f_1672, f_1673, f_1674, f_1675, f_1676).m_1263(this::m_4091);
      this.f_1643 = new NumberSetting(f_1677, Util71.m_1989(f_1638), 0.0F, f_1678, 1.0F).m_356(() -> this.f_1642.m_2073(f_1740) && this.m_4091());
      this.f_1644 = new NumberSetting(f_1679, Util71.m_644(f_1638), 0.0F, f_1680, 1.0F).m_356(() -> this.f_1642.m_2073(f_1739) && this.m_4091());
      this.f_1645 = new NumberSetting(f_1681, Util71.m_3163(f_1638), 0.0F, f_1682, 1.0F).m_356(() -> this.f_1642.m_2073(f_1738) && this.m_4091());
      this.f_1646 = new NumberSetting(f_1683, f_1684, f_1685, f_1686, 1.0F).m_356(() -> this.f_1640.m_1163() || this.f_1641.m_1163());
      this.f_1647 = new BooleanSetting(f_1687, false).m_334(this::m_4091);
      this.f_1648 = new BooleanSetting(f_1688, false).m_334(this::m_4091);
      this.f_1649 = new BooleanSetting(f_1689, true).m_334(this::m_4091);
      this.f_1650 = new BooleanSetting(f_1690, true).m_334(this::m_4091);
      this.f_1651 = new NumberSetting(f_1691, f_1692, f_1693, f_1694, f_1695).m_356(this::m_4091);
      this.f_1652 = new NumberSetting(f_1696, f_1697, f_1698, f_1699, f_1700).m_356(this::m_4091);
      this.f_1653 = m_349(f_1701);
      this.f_1654 = new ArrayList<>();
      this.f_1655 = new ArrayList<>();
      this.f_1656 = new ArrayList<>();
      this.f_1657 = new HashMap<>();
      this.f_1658 = new Random();
      this.f_1659 = new Dashtrail.tH0T07W0kHbD1aIO(0.0F, 1.0F, f_1702);
      this.f_1660 = new Dashtrail.tH0T07W0kHbD1aIO(1.0F, 1.0F, f_1703);
      this.f_1664 = -1;
      this.f_1665 = null;
      this.m_2504();
      this.m_92();
      this.f_1658.setSeed(f_1704);
      f_1633 = this;
   }

   private void m_1718(Runnable var1, boolean var2, boolean var3) {
      Util114.m_1481();
      Util114.m_1206(770, var3 ? 1 : 771, 1, 0);
      Util114.m_100();
      Util114.m_3978();
      Util114.m_1878(false);
      Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      Util114.m_3784(var2 ? RenderUtil7.f_13886 : RenderUtil7.f_13885);

      try {
         var1.run();
      } finally {
         Util114.m_1878(true);
         Util114.m_1562();
         Util114.m_542();
         Util114.m_963();
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   private List<Dashtrail.fWXVDd5cthTckpqG> m_809(int var1) {
      return this.f_1655.get(var1);
   }

   private class FBgJpX2bRyGYQDIz {
      private final List<Dashtrail.fWXVDd5cthTckpqG> f_8299;
      private final boolean f_8300;
      private long f_8301;
      private long f_8302;

      private FBgJpX2bRyGYQDIz(boolean var2) {
         this.f_8300 = var2 && Dashtrail.this.m_2221();
         if (this.f_8300) {
            this.f_8301 = System.currentTimeMillis();
            this.f_8299 = Dashtrail.this.m_809(Dashtrail.this.m_1026());
            this.f_8302 = Dashtrail.this.m_2138();
         } else {
            this.f_8299 = new ArrayList<>();
            this.f_8299.add(Dashtrail.this.m_2893(Dashtrail.this.m_1882()));
         }
      }

      private Dashtrail.fWXVDd5cthTckpqG m_3091() {
         if (this.f_8300) {
            float var1 = this.f_8299.size();
            if (var1 > 0.0F) {
               int var2 = (int)(System.currentTimeMillis() - this.f_8301);
               float var3 = var2 % (int)this.f_8302 / (float)this.f_8302;
               int var4 = (int)MathHelper.clamp(var3 * var1, 0.0F, var1 - 1.0F);
               Dashtrail.fWXVDd5cthTckpqG var5 = this.f_8299.get(var4);
               if (var5 != null) {
                  return var5;
               }
            }
         }

         return this.f_8299.get(0);
      }
   }

   private class Inner_2jfqKW2v6ENkZ89V {
      private final Dashtrail.tH0T07W0kHbD1aIO f_4127;
      private final long f_4128;
      private final Dashtrail.fuLxdt7SniySa8JJ f_4129;
      private final int f_4130;
      private final float[] f_4131;
      private final List<Dashtrail.nlFzc9HimsulxqWE> f_4132;
      private final boolean f_4133;
      private static final float f_4135 = 0.035F;
      private static final double f_4136 = 5.0E-4;
      private static final double f_4137 = 360.0;
      private static final float f_4138 = 45.0F;
      private static final float f_4139 = 15.0F;
      private static final float f_4140 = 3.0F;
      private static final float f_4141 = 26.3F;
      private static final float f_4142 = 10.0F;
      private static final float f_4143 = 160.0F;
      private static final float f_4144 = -90.0F;
      private static final double f_4145 = 1.05F;
      private static final double f_4146 = 5.0;
      private static final double f_4147 = 1.05F;
      private static final double f_4148 = 5.0;
      private static final double f_4149 = 3.5;
      private static final double f_4150 = 1.05F;
      private static final double f_4151 = 5.0;
      private static final double f_4152 = 5.0E-4;
      private static final double f_4153 = 360.0;
      private static final float f_4154 = 45.0F;
      private static final float f_4155 = 15.0F;
      private static final float f_4156 = 3.0F;
      private static final float f_4157 = 26.3F;
      private static final float f_4158 = 10.0F;
      private static final float f_4159 = 160.0F;
      private static final float f_4160 = -90.0F;
      private static final double f_4161 = 0.3;
      private static final float f_4162 = 0.033F;
      private static final float f_4163 = 0.4F;
      private static final float f_4164 = 0.15F;
      private static final float f_4165 = 1.75F;
      private static final float f_4166 = 1.75F;
      private static final float f_4167 = 1.75F;
      private static final float f_4168 = 1.75F;
      private static final float f_4169 = 55.0F;
      private static final float f_4170 = 6.0F;
      private static final float f_4171 = 4.0F;
      private static final float f_4172 = 90.0F;

      private void m_2401(Dashtrail.Inner_2jfqKW2v6ENkZ89V var1) {
         if (var1 != null && var1.f_4129.f_8352.getId() != this.f_4129.f_8352.getId()) {
            var1 = null;
         }

         this.f_4129.f_8359 = this.f_4129.f_8356;
         this.f_4129.f_8360 = this.f_4129.f_8357;
         this.f_4129.f_8361 = this.f_4129.f_8358;
         this.f_4129.f_8353 = (var1 != null ? var1.f_4129.f_8353 : this.f_4129.f_8353) / f_4145;
         this.f_4129.f_8356 = this.f_4129.f_8356 + f_4146 * this.f_4129.f_8353;
         this.f_4129.f_8354 = (var1 != null ? var1.f_4129.f_8354 : this.f_4129.f_8354) / f_4147;
         this.f_4129.f_8357 = this.f_4129.f_8357 + f_4148 * this.f_4129.f_8354 / (this.f_4129.f_8354 < 0.0 ? 1.0 : f_4149);
         this.f_4129.f_8355 = (var1 != null ? var1.f_4129.f_8355 : this.f_4129.f_8355) / f_4150;
         this.f_4129.f_8358 = this.f_4129.f_8358 + f_4151 * this.f_4129.f_8355;
         if (Math.sqrt(this.f_4129.f_8353 * this.f_4129.f_8353 + this.f_4129.f_8355 * this.f_4129.f_8355) < f_4152) {
            this.f_4131[0] = (float)(f_4153 * Math.random());
            this.f_4131[1] = QuickImports.f_5909.gameRenderer.getCamera().getPitch();
         } else {
            float var2 = this.f_4129.m_3224();
            this.f_4131[0] = var2 - f_4154 - f_4155 - (this.f_4129.f_8352.lastYaw - this.f_4129.f_8352.getYaw()) * f_4156;
            float var3 = Dashtrail.m_3715(var2 + f_4157, this.f_4129.f_8352.getYaw());
            this.f_4131[1] = !(var3 < f_4158) && !(var3 > f_4159) ? QuickImports.f_5909.gameRenderer.getCamera().getPitch() : f_4160;
         }

         if (this.f_4133) {
            if (this.m_3548() < f_4161 && Dashtrail.this.f_1658.nextInt(12) > 5) {
               for (int var4 = 0; var4 < (Dashtrail.this.m_3773()[0] ? 1 : 2); var4++) {
                  Dashtrail.this.m_2700(this);
               }
            }

            this.f_4132.forEach(Dashtrail.nlFzc9HimsulxqWE::m_1371);
         }

         Dashtrail.this.m_973(this);
      }

      private double m_3077(float var1) {
         return this.f_4129.f_8360 + (this.f_4129.f_8357 - this.f_4129.f_8360) * var1;
      }

      private float m_3548() {
         return (float)(System.currentTimeMillis() - this.f_4128) / this.f_4129.f_8362;
      }

      private double m_2069(float var1) {
         return this.f_4129.f_8361 + (this.f_4129.f_8358 - this.f_4129.f_8361) * var1;
      }

      private double m_1625(float var1) {
         return this.f_4129.f_8359 + (this.f_4129.f_8356 - this.f_4129.f_8359) * var1;
      }

      private Inner_2jfqKW2v6ENkZ89V(Dashtrail.fuLxdt7SniySa8JJ var2, boolean var3) {
         this.f_4127 = new Dashtrail.tH0T07W0kHbD1aIO(0.0F, 1.0F, f_4135);
         this.f_4128 = System.currentTimeMillis();
         this.f_4130 = Dashtrail.this.m_3287();
         this.f_4131 = new float[]{0.0F, 0.0F};
         this.f_4132 = new ArrayList<>();
         this.f_4129 = var2;
         this.f_4133 = var3;
         if (Math.sqrt(var2.f_8353 * var2.f_8353 + var2.f_8355 * var2.f_8355) < f_4136) {
            this.f_4131[0] = (float)(f_4137 * Math.random());
            this.f_4131[1] = QuickImports.f_5909.gameRenderer.getCamera().getPitch();
         } else {
            float var4 = var2.m_3224();
            this.f_4131[0] = var4 - f_4138 - f_4139 - (var2.f_8352.lastYaw - var2.f_8352.getYaw()) * f_4140;
            float var5 = Dashtrail.m_3715(var4 + f_4141, var2.f_8352.getYaw());
            this.f_4131[1] = !(var5 < f_4142) && !(var5 > f_4143) ? QuickImports.f_5909.gameRenderer.getCamera().getPitch() : f_4144;
         }
      }

      private void m_3792(MatrixStack var1, Camera var2, float var3, Vec3d var4, boolean var5, float var6, float var7) {
         Dashtrail.fWXVDd5cthTckpqG var8 = this.f_4129.f_8363.m_3091();
         if (var8 != null) {
            float var9 = var6 * this.f_4127.f_6144;
            float var10 = f_4162 * Dashtrail.this.f_1652.m_4046() * var9;
            float var11 = var8.m_96()[0] * var10;
            float var12 = var8.m_96()[1] * var10;
            double[] var13 = Dashtrail.this.m_829(this, var3, var4);
            if (var5) {
               Dashtrail.this.m_946(
                  var1,
                  var13,
                  () -> {
                     float var6x = (float)Math.sqrt(var11 * var11 + var12 * var12);
                     float var7x = 1.0F - this.m_3548();
                     var7x = Math.min(var7x, 1.0F);
                     int var8x = Dashtrail.m_189(this.f_4130, -1, f_4164);
                     Dashtrail.this.m_2247(var1, -var6x / f_4165, -var6x / f_4166, var6x / f_4167, var6x / f_4168, Dashtrail.m_2796(var8x, f_4169 * var9));
                     if (var7 != 0.0F) {
                        float var9x = var9 * var7;
                        float var10x = var6x * (1.0F + f_4170 * var7x * var9x);
                        Dashtrail.this.m_2247(
                           var1,
                           -var10x / 2.0F,
                           -var10x / 2.0F,
                           var10x / 2.0F,
                           var10x / 2.0F,
                           Dashtrail.m_2796(Dashtrail.m_632(var8x, var9x / f_4171), f_4172 * var9x)
                        );
                     }
                  },
                  new float[]{var2.getYaw(), var2.getPitch()}
               );
            } else {
               Dashtrail.this.m_946(
                  var1,
                  var13,
                  () -> {
                     Dashtrail.this.m_2982(var8.m_2881());
                     Dashtrail.this.m_2247(
                        var1, -var11 / 2.0F, -var12 / 2.0F, var11 / 2.0F, var12 / 2.0F, Dashtrail.m_632(Dashtrail.m_189(this.f_4130, -1, f_4163), var9)
                     );
                  },
                  this.f_4131
               );
            }
         }
      }
   }

   private class fWXVDd5cthTckpqG {
      private final Identifier f_12557;
      private final int[] f_12558;

      private int[] m_96() {
         return this.f_12558;
      }

      private fWXVDd5cthTckpqG(Identifier var2) {
         this.f_12557 = var2;
         this.f_12558 = Dashtrail.this.m_2400(var2);
      }

      private Identifier m_2881() {
         return this.f_12557;
      }
   }

   private static class fuLxdt7SniySa8JJ {
      private final LivingEntity f_8352;
      private double f_8353;
      private double f_8354;
      private double f_8355;
      private double f_8356;
      private double f_8357;
      private double f_8358;
      private double f_8359;
      private double f_8360;
      private double f_8361;
      private final int f_8362;
      private final Dashtrail.FBgJpX2bRyGYQDIz f_8363;
      private static final double f_8364 = 2.4;
      private static final double f_8365 = -0.0875F;
      private static final double f_8366 = 0.175F;
      private static final double f_8367 = 3.0;
      private static final double f_8368 = 4.0;
      private static final double f_8369 = 0.7F;
      private static final double f_8370 = -0.0875F;
      private static final double f_8371 = 0.175F;
      private static final double f_8372 = 90.0;

      private fuLxdt7SniySa8JJ(LivingEntity var1, Vec3d var2, float var3, Dashtrail.FBgJpX2bRyGYQDIz var4, float var5, int var6) {
         this.f_8362 = var6;
         this.f_8352 = var1;
         this.f_8353 = var1.getX() - var2.x;
         this.f_8354 = var1.getY() - var2.y;
         this.f_8355 = var1.getZ() - var2.z;
         double var7 = var1.isSleeping() ? f_8364 : 1.0;
         this.f_8356 = var2.x - this.f_8353 * var5 + (f_8365 + f_8366 * Math.random());
         this.f_8357 = var2.y - this.f_8354 * var5 + (var1.getHeight() / var7 / f_8367 + var1.getHeight() / var7 / f_8368 * Math.random() * f_8369);
         this.f_8358 = var2.z - this.f_8355 * var5 + (f_8370 + f_8371 * Math.random());
         this.f_8359 = this.f_8356;
         this.f_8360 = this.f_8357;
         this.f_8361 = this.f_8358;
         this.f_8353 *= var3;
         this.f_8354 *= var3;
         this.f_8355 *= var3;
         this.f_8363 = var4;
      }

      private int m_3224() {
         int var1 = (int)Math.toDegrees(Math.atan2(this.f_8355, this.f_8353) - f_8372);
         return var1 < 0 ? var1 + 360 : var1;
      }
   }

   private static class nlFzc9HimsulxqWE {
      double f_5977;
      double f_5978;
      double f_5979;
      double f_5980;
      double f_5981;
      double f_5982;
      double f_5983;
      double f_5984;
      double f_5985;
      long f_5986;
      private static final double f_5987 = 50.0;
      private static final double f_5988 = 360.0;
      private static final double f_5989 = -90.0;
      private static final double f_5990 = 180.0;
      private static final float f_5991 = 1000.0F;
      private static final double f_5992 = 90.0;

      double[] m_3934(float var1) {
         return new double[]{
            this.f_5980 + (this.f_5977 - this.f_5980) * var1,
            this.f_5981 + (this.f_5978 - this.f_5981) * var1,
            this.f_5982 + (this.f_5979 - this.f_5982) * var1
         };
      }

      double m_3933() {
         return MathHelper.clamp((float)(System.currentTimeMillis() - this.f_5986) / f_5991, 0.0F, 1.0F);
      }

      boolean m_2793() {
         return this.m_3933() == 1.0;
      }

      double m_2190() {
         return 1.0 - this.m_3933();
      }

      void m_1371() {
         double var1 = Math.toRadians(this.f_5984);
         this.f_5980 = this.f_5977;
         this.f_5981 = this.f_5978;
         this.f_5982 = this.f_5979;
         this.f_5977 = this.f_5977 + Math.sin(var1) * this.f_5983;
         this.f_5978 = this.f_5978 + Math.cos(Math.toRadians(this.f_5985 - f_5992)) * this.f_5983;
         this.f_5979 = this.f_5979 + Math.cos(var1) * this.f_5983;
      }

      private nlFzc9HimsulxqWE() {
         this.f_5983 = Math.random() / f_5987;
         this.f_5984 = Math.random() * f_5988;
         this.f_5985 = f_5989 + Math.random() * f_5990;
         this.f_5986 = System.currentTimeMillis();
      }
   }

   private static class tH0T07W0kHbD1aIO {
      private long f_6143 = System.currentTimeMillis();
      private float f_6144;
      private float f_6145;
      private final float f_6146;
      private static final double f_6147 = 1.0E-4;
      private static final long f_6148 = 400L;
      private static final float f_6149 = 5.0F;

      private tH0T07W0kHbD1aIO(float var1, float var2, float var3) {
         this.f_6144 = var1;
         this.f_6145 = var2;
         this.f_6146 = var3;
      }

      private float m_2864() {
         if (Math.abs(this.f_6144 - this.f_6145) < f_6147) {
            this.f_6144 = this.f_6145;
         }

         int var1 = (int)((float)Math.min(System.currentTimeMillis() - this.f_6143, f_6148) / f_6149);
         if (var1 > 0) {
            this.f_6143 = System.currentTimeMillis();
         }

         for (int var2 = 0; var2 < var1; var2++) {
            this.f_6144 = MathHelper.lerp(this.f_6146, this.f_6144, this.f_6145);
         }

         return this.f_6144;
      }

      private void m_3436(float var1) {
         this.f_6144 = var1;
         this.f_6143 = System.currentTimeMillis();
      }
   }
}
