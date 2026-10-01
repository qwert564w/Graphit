package su.energyclient.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import su.energyclient.QuickImports;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.ArmorManager;
import su.energyclient.util.Util114;
import su.energyclient.util.Util153;
import su.energyclient.util.Util158;
import su.energyclient.util.Util165;
import su.energyclient.util.Util7;
import su.energyclient.util.Util71;
import su.energyclient.util.Util93;

public class RenderUtil29 extends Screen implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_1100 = 110.0F;
   private static final float f_1101 = 0.0F;
   private int f_1102 = -1;
   private final Util165[] f_1103 = new Util165[3];
   private static final long f_1104 = 200L;
   private static final double f_1105 = Math.PI * 2.0 / 3.0;
   private static final float f_1106 = 95.0F;
   private static final double f_1107 = 0.99;
   private static final double f_1108 = 2.0;
   private static final double f_1109 = -Math.PI / 2;
   private static final float f_1110 = 80.0F;
   private static final float f_1111 = 110.0F;
   private static final double f_1112 = 2.0;
   private static final float f_1113 = 1.2F;
   private static final float f_1114 = 16.0F;
   private static final float f_1115 = 16.0F;
   private static final String f_1116 = "+";
   private static final float f_1117 = 255.0F;
   private static final float f_1118 = 255.0F;
   private static final float f_1119 = 255.0F;
   private static final float f_1120 = 255.0F;
   private static final float f_1121 = 255.0F;
   private static final float f_1122 = 255.0F;
   private static final float f_1123 = 255.0F;
   private static final float f_1124 = 255.0F;
   private static final double f_1125 = 32.0;
   private static final double f_1126 = 176.0;
   private static final double f_1127 = Math.PI / 2;
   private static final double f_1128 = Math.PI * 2;
   private static final double f_1129 = Math.PI * 2.0 / 3.0;

   private void updateHoveredSlot(int var1, int var2, int var3, int var4) {
      double var5 = var1 - var3;
      double var7 = var2 - var4;
      double var9 = Math.hypot(var5, var7);
      if (!(var9 < f_1125) && !(var9 > f_1126)) {
         double var11 = Math.atan2(var7, var5) + f_1127;
         if (var11 < 0.0) {
            var11 += f_1128;
         }

         double var13 = f_1129;
         int var15 = (int)(var11 / var13);
         if (var15 >= 3) {
            var15 = 2;
         }

         this.f_1102 = var15;
      } else {
         this.f_1102 = -1;
      }
   }

   public boolean shouldPause() {
      return false;
   }

   private ItemStack getStackForSlot(int var1) {
      ArmorManager var2 = InitManager.f_2740.f_2746;
      return var2 == null ? ItemStack.EMPTY : var2.m_987(var1);
   }

   public void render(DrawContext var1, int var2, int var3, float var4) {
      int var5 = this.width / 2;
      int var6 = this.height / 2;
      this.updateHoveredSlot(var2, var3, var5, var6);
      double var7 = f_1105;
      float var9 = f_1106;
      double var10 = f_1107;
      double var12 = var7 * (1.0 - var10) / f_1108;
      ArmorManager var14 = InitManager.f_2740.f_2746;
      int var15 = var14 != null ? var14.m_2248() : -1;

      for (int var16 = 0; var16 < 3; var16++) {
         double var17 = f_1109 + var7 * var16;
         double var19 = var17 + var7;
         boolean var21 = var16 == this.f_1102;
         boolean var22 = var16 == var15;
         int var23;
         if (var22) {
            var23 = Util71.m_756(255, 128, 128, 170);
         } else if (var21) {
            var23 = Util71.m_756(255, 220, 0, 170);
         } else {
            var23 = Util71.m_756(255, 255, 255, 80);
         }

         this.drawSegment(var1, var5, var6, f_1110, f_1111, var17 + var12, var19 - var12, var23);
         double var24 = (var17 + var19) / f_1112;
         float var26 = var5 + (float)(Math.cos(var24) * var9);
         float var27 = var6 + (float)(Math.sin(var24) * var9);
         ItemStack var28 = this.getStackForSlot(var16);
         if (!var28.isEmpty()) {
            float var29 = var21 ? f_1113 : 1.0F;
            this.f_1103[var16].m_3631(var29);
            float var30 = (float)this.f_1103[var16].m_2276();
            float var31 = f_1114 * var30;
            float var32 = f_1115 * var30;
            Util158.m_1974(var1, var28, var26 - var31 / 2.0F, var27 - var32 / 2.0F, var30, -1, 1.0F);
         } else {
            String var33 = f_1116;
            float var34 = Util93.f_6002[32].m_585(var33);
            float var35 = Util93.f_6002[32].m_619();
            Util93.f_6002[32].m_2915(var1, var33, var26 - var34 / 2.0F, var27 - var35 / 2.0F, Util71.m_756(255, 255, 255, 220));
         }
      }
   }

   private void drawSegment(DrawContext var1, int var2, int var3, float var4, float var5, double var6, double var8, int var10) {
      float var11 = Util71.m_1989(var10) / f_1117;
      float var12 = Util71.m_644(var10) / f_1118;
      float var13 = Util71.m_3163(var10) / f_1119;
      float var14 = Util71.m_2734(var10) / f_1120;
      Util114.m_1481();
      Util114.m_542();
      Util114.m_3784(RenderUtil7.f_13885);
      Matrix4f var15 = Util7.m_1924(var1.getMatrices());
      BufferBuilder var16 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
      short var17 = 360;
      double var18 = (var8 - var6) / var17;

      for (int var20 = 0; var20 <= var17; var20++) {
         double var21 = var6 + var18 * var20;
         float var23 = (float)Math.cos(var21);
         float var24 = (float)Math.sin(var21);
         float var25 = var2 + var23 * var5;
         float var26 = var3 + var24 * var5;
         float var27 = var2 + var23 * var4;
         float var28 = var3 + var24 * var4;
         var16.vertex(var15, var25, var26, 0.0F).color(var11, var12, var13, var14);
         var16.vertex(var15, var27, var28, 0.0F).color(var11, var12, var13, var14);
      }

      RenderUtil12.I(var16.end());
      Util114.m_963();
      int var29 = Util71.m_3389(var10, 220);
      this.drawSegmentOutline(var1, var2, var3, var4, var5, var6, var8, var29);
   }

   public void tick() {
      this.updateMovementKeysWhileOpen();
      super.tick();
   }

   private void drawSegmentOutline(DrawContext var1, int var2, int var3, float var4, float var5, double var6, double var8, int var10) {
      float var11 = Util71.m_1989(var10) / f_1121;
      float var12 = Util71.m_644(var10) / f_1122;
      float var13 = Util71.m_3163(var10) / f_1123;
      float var14 = Util71.m_2734(var10) / f_1124;
      Util114.m_1481();
      Util114.m_542();
      Util114.m_3784(RenderUtil7.f_13885);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      Matrix4f var15 = Util7.m_1924(var1.getMatrices());
      BufferBuilder var16 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
      short var17 = 360;
      double var18 = (var8 - var6) / var17;

      for (int var20 = 0; var20 < var17; var20++) {
         double var21 = var6 + var18 * var20;
         double var23 = var6 + var18 * (var20 + 1);
         float var25 = (float)Math.cos(var21);
         float var26 = (float)Math.sin(var21);
         float var27 = (float)Math.cos(var23);
         float var28 = (float)Math.sin(var23);
         float var29 = var2 + var25 * var5;
         float var30 = var3 + var26 * var5;
         float var31 = var2 + var27 * var5;
         float var32 = var3 + var28 * var5;
         var16.vertex(var15, var29, var30, 0.0F).color(var11, var12, var13, var14);
         var16.vertex(var15, var31, var32, 0.0F).color(var11, var12, var13, var14);
         float var33 = var2 + var25 * var4;
         float var34 = var3 + var26 * var4;
         float var35 = var2 + var27 * var4;
         float var36 = var3 + var28 * var4;
         var16.vertex(var15, var33, var34, 0.0F).color(var11, var12, var13, var14);
         var16.vertex(var15, var35, var36, 0.0F).color(var11, var12, var13, var14);
      }

      float var37 = (float)Math.cos(var6);
      float var38 = (float)Math.sin(var6);
      float var22 = (float)Math.cos(var8);
      float var39 = (float)Math.sin(var8);
      float var24 = var2 + var37 * var5;
      float var40 = var3 + var38 * var5;
      float var41 = var2 + var37 * var4;
      float var42 = var3 + var38 * var4;
      float var43 = var2 + var22 * var5;
      float var44 = var3 + var39 * var5;
      float var45 = var2 + var22 * var4;
      float var46 = var3 + var39 * var4;
      var16.vertex(var15, var24, var40, 0.0F).color(var11, var12, var13, var14);
      var16.vertex(var15, var41, var42, 0.0F).color(var11, var12, var13, var14);
      var16.vertex(var15, var43, var44, 0.0F).color(var11, var12, var13, var14);
      var16.vertex(var15, var45, var46, 0.0F).color(var11, var12, var13, var14);
      RenderUtil12.I(var16.end());
      GL11.glDisable(2848);
      Util114.m_963();
   }

   public RenderUtil29() {
      super(Text.literal(""));

      for (int var1 = 0; var1 < 3; var1++) {
         this.f_1103[var1] = new Util165(Util153.EASE_IN_OUT_QUAD, f_1104);
      }
   }

   public boolean mouseClicked(Click var1, boolean var2) {
      double var3 = var1.x();
      double var5 = var1.y();
      int var7 = var1.button();
      if (this.f_1102 < 0) {
         return super.mouseClicked(var1, var2);
      } else {
         ArmorManager var8 = InitManager.f_2740.f_2746;
         if (var7 == 0) {
            ItemStack var9 = this.getStackForSlot(this.f_1102);
            if (var9.isEmpty()) {
               this.selectHoveredSlot();
            } else if (var8 != null) {
               var8.m_91(this.f_1102);
            }

            return true;
         } else if (var7 == 1) {
            if (var8 != null) {
               var8.m_225(this.f_1102);
            }

            return true;
         } else {
            return super.mouseClicked(var1, var2);
         }
      }
   }

   public int getHoveredSlot() {
      return this.f_1102;
   }

   private void updateMovementKeysWhileOpen() {
      KeyBinding[] var1 = new KeyBinding[]{
         f_5909.options.forwardKey, f_5909.options.backKey, f_5909.options.leftKey, f_5909.options.rightKey, f_5909.options.jumpKey
      };

      for (KeyBinding var5 : var1) {
         boolean var6 = InputUtil.isKeyPressed(f_5909.getWindow(), var5.getDefaultKey().getCode());
         var5.setPressed(var6);
      }
   }

   private void selectHoveredSlot() {
      if (this.f_1102 >= 0) {
         ArmorManager var1 = InitManager.f_2740.f_2746;
         if (var1 != null) {
            var1.m_2090(this.f_1102);
         }
      }
   }
}
