package su.energyclient.module.render;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.InputUtil;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import org.joml.Vector2f;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil25;
import su.energyclient.util.Util158;
import su.energyclient.util.Util169;
import su.energyclient.util.math.MathUtil10;

public class ShulkerPreview extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Identifier f_3459 = Identifier.of(ShulkerPreview.f_3487, ShulkerPreview.f_3488);
   private static final int f_3460 = 27;
   private static final int f_3461 = 0;
   private static final int f_3462 = 0;
   private static final int f_3463 = 0;
   private static final String f_3464 = "Shulker Preview";
   private static final String f_3465 = "description";
   private static final int f_3466 = 16777215;
   private static final String f_3467 = "Contains 27 items";
   private static final int f_3468 = 10526880;
   private static final float f_3469 = 256.0F;
   private static final float f_3470 = 256.0F;
   private static final float f_3471 = 14.0F;
   private static final float f_3472 = 20.0F;
   private static final float f_3473 = 129.0F;
   private static final float f_3474 = 129.0F;
   private static final float f_3475 = 4.0F;
   private static final float f_3476 = 9.0F;
   private static final float f_3477 = 4.0F;
   private static final float f_3478 = 9.0F;
   private static final float f_3479 = 0.5F;
   private static final int f_3480 = -267386864;
   private static final int f_3481 = 1347420415;
   private static final int f_3482 = 1344798847;
   private static final int f_3483 = 1347420415;
   private static final int f_3484 = 1344798847;
   private static final int f_3485 = -16777216;
   private static final int f_3486 = 16777215;
   private static final String f_3487 = "energy";
   private static final String f_3488 = "images/models/shulker_box_tooltip.png";

   private int m_2587(ItemStack var1) {
      DyeColor var2 = DyeColor.PURPLE;
      if (var1.getItem() instanceof BlockItem var3 && var3.getBlock() instanceof ShulkerBoxBlock var4 && var4.getColor() != null) {
         var2 = var4.getColor();
      }

      return f_3485 | var2.getEntityColor() & f_3486;
   }

   private void m_3582(DrawContext var1, TextRenderer var2, List<Text> var3, int var4, int var5, int var6, int var7) {
      int var8 = var4 - 3;
      int var9 = var5 - 4;
      int var10 = var4 + var6 + 3;
      int var11 = var5 + var7 + 4;
      var1.fill(var8, var9, var10, var11, f_3480);
      var1.fill(var8, var9, var10, var9 + 1, f_3481);
      var1.fill(var8, var11 - 1, var10, var11, f_3482);
      var1.fill(var8, var9, var8 + 1, var11, f_3483);
      var1.fill(var10 - 1, var9, var10, var11, f_3484);
      int var12 = var5;

      for (Text var14 : var3) {
         var1.drawText(var2, var14, var4, var12, -1, true);
         var12 += 10;
      }
   }

   public ShulkerPreview() {
      super(f_3464, f_3465, Category.RENDER);
   }

   private void m_648(DrawContext var1, ItemEntity var2, float var3) {
      Vector2f var4 = MathUtil10.m_2018(MathUtil10.m_516(var2, var3));
      if (MathUtil10.m_1452(var4)) {
         ItemStack var5 = var2.getStack();
         List var6 = this.m_3340(var5);
         float var7 = var4.x + f_3471;
         float var8 = var4.y - f_3472;
         int var9 = this.m_2587(var5);
         var1.getMatrices().pushMatrix();
         var1.getMatrices().translate(0.0F, 0.0F);
         RenderUtil25.m_3570(var1, f_3459, var7, var8, f_3473, f_3474, var9);

         for (int var10 = 0; var10 < var6.size(); var10++) {
            ItemStack var11 = (ItemStack)var6.get(var10);
            if (!var11.isEmpty()) {
               float var12 = var7 + f_3475 + var10 % 9 * f_3476;
               float var13 = var8 + f_3477 + var10 / 9 * f_3478;
               Util158.m_1974(var1, var11, var12, var13, f_3479, -1, 1.0F);
            }
         }

         var1.getMatrices().popMatrix();
      }
   }

   private List<ItemStack> m_3340(ItemStack var1) {
      DefaultedList var2 = DefaultedList.ofSize(27, ItemStack.EMPTY);
      ContainerComponent var3 = (ContainerComponent)var1.getOrDefault(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT);
      var3.copyTo(var2);
      return var2;
   }

   private boolean m_2794(ItemStack var1) {
      for (ItemStack var3 : this.m_3340(var1)) {
         if (!var3.isEmpty()) {
            return true;
         }
      }

      return false;
   }

   public boolean m_1815(DrawContext var1, TextRenderer var2, ItemStack var3, int var4, int var5) {
      if (this.m_677() && this.m_3734(var3)) {
         if (var2 == null) {
            var2 = f_5909.textRenderer;
         }

         if (var2 == null) {
            return false;
         } else {
            List var6 = this.m_3340(var3);
            List<Text> var7 = List.of(var3.getName().copy().withColor(f_3466), Text.literal(f_3467).withColor(f_3468));
            int var8 = var7.stream().mapToInt(var2::getWidth).max().orElse(0);
            int var9 = 10 + (var7.size() - 1) * 10;
            int var10 = Math.max(256, var8 + 8);
            int var11 = var9 + 5 + 256;
            int var12 = var4 + 12;
            int var13 = var5 - 12;
            int var14 = f_5909.getWindow().getScaledWidth();
            int var15 = f_5909.getWindow().getScaledHeight();
            if (var12 + var10 > var14) {
               var12 = var4 - 12 - var10;
            }

            if (var13 + var11 > var15) {
               var13 = var15 - var11 - 4;
            }

            var12 = Math.max(4, var12);
            var13 = Math.max(4, var13);
            int var16 = var12 - 4;
            int var17 = var13 + var9 + 5;
            int var18 = this.m_2587(var3);
            var1.getMatrices().pushMatrix();
            var1.getMatrices().translate(0.0F, 0.0F);
            this.m_3582(var1, var2, var7, var12, var13, var8, var9);
            RenderUtil25.m_3570(var1, f_3459, var16, var17, f_3469, f_3470, var18);
            int var19 = var12 + 4;
            int var20 = var13 + var9 + 13;

            for (int var21 = 0; var21 < var6.size(); var21++) {
               ItemStack var22 = (ItemStack)var6.get(var21);
               if (!var22.isEmpty()) {
                  int var23 = var19 + var21 % 9 * 18;
                  int var24 = var20 + var21 / 9 * 18;
                  var1.drawItem(var22, var23, var24);
                  var1.drawStackOverlay(var2, var22, var23, var24);
               }
            }

            var1.getMatrices().popMatrix();
            return true;
         }
      } else {
         return false;
      }
   }

   @EventHandler
   public void m_2275(Util169 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         List<ItemEntity> var2 = new ArrayList<>();

         for (Entity var4 : f_5909.world.getEntities()) {
            if (var4 instanceof ItemEntity var5 && this.m_2885(var5.getStack()) && this.m_2794(var5.getStack())) {
               var2.add(var5);
            }
         }

         var2.sort(Comparator.<ItemEntity>comparingDouble(var0 -> var0.squaredDistanceTo(f_5909.player)).reversed());

         for (ItemEntity var7 : var2) {
            this.m_648(var1.m_4037(), var7, var1.m_4119());
         }
      }
   }

   private boolean m_367() {
      return f_5909.getWindow() != null && InputUtil.isKeyPressed(f_5909.getWindow(), 341);
   }

   private boolean m_3734(ItemStack var1) {
      return this.m_367() && this.m_2885(var1);
   }

   private boolean m_2885(ItemStack var1) {
      return !var1.isEmpty() && var1.getItem() instanceof BlockItem var2 && var2.getBlock() instanceof ShulkerBoxBlock;
   }
}
