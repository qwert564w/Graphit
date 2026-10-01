package su.energyclient.mixin;

import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.dreamix.fabricloader.VMBridge;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.impl.EventHandleMouseClick;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.InventoryManager;
import su.energyclient.module.miscellaneous.AutoBuy;
import su.energyclient.module.render.ShulkerPreview;
import su.energyclient.render.RenderUtil15;
import su.energyclient.util.Util147;
import su.energyclient.util.Util158;
import su.energyclient.util.Util71;

@Mixin({HandledScreen.class})
public abstract class HandledScreenMixin implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   protected Slot focusedSlot;
   @Shadow
   protected ScreenHandler handler;
   @Unique
   private Slot energy$quickdropSlot;
   @Unique
   private long energy$quickdropTime;
   @Shadow
   protected int x;
   @Shadow
   protected int y;
   @Shadow
   protected int backgroundWidth;
   private static final float f_10709 = 0.0F;
   private static final float f_10710 = 0.0F;
   private static final float f_10711 = 0.0F;
   private static final float f_10712 = 0.0F;
   private static final float f_10713 = 0.0F;
   private static final float f_10714 = 0.0F;
   private static final float f_10715 = 0.0F;
   private static final float f_10716 = 0.0F;
   private static final float f_10717 = 0.0F;
   private static final float f_10718 = 0.0F;
   private static final float f_10719 = 0.0F;
   private static final float f_10720 = 0.0F;
   private static final int f_10721 = 0;
   private static final int f_10722 = 0;
   private static final float f_10723 = 0.0F;
   private static final float f_10724 = 0.0F;
   private static final float f_10725 = 0.0F;
   private static final float f_10726 = 0.0F;
   private static final float f_10727 = 0.0F;
   private static final float f_10728 = 0.0F;
   private static final float f_10729 = 0.0F;
   private static final float f_10730 = 0.0F;
   private static final float f_10731 = 0.0F;
   private static final float f_10732 = 0.0F;
   private static final float f_10733 = 0.0F;
   private static final float f_10734 = 0.0F;
   private static final float f_10735 = 0.0F;
   private static final float f_10736 = 0.0F;
   private static final String f_10737 = "";
   private static final String f_10738 = "";
   private static final String f_10739 = "";
   @Shadow
   protected abstract void onMouseClick(Slot var1, int var2, int var3, SlotActionType var4);

   @Inject(
      method = {"mouseDragged"},
      at = {@At("HEAD")}
   )
   private void onMouseDragged(Click var1, double var2, double var4, CallbackInfoReturnable<Boolean> var6) {
      Slot var7 = this.focusedSlot;
      if (var1.button() == 0 && f_5909.isShiftPressed() && var7 != null && var7.hasStack() && !(Boolean)f_5909.options.getTouchscreen().getValue()) {
         long var8 = Util.getMeasuringTimeMs();
         if (this.energy$quickdropSlot != var7) {
            RenderUtil15 var10 = new RenderUtil15(0);
            EnergyClient.f_1622.f_1624.m_30(var10);
            long var11 = var10.m_1401();
            if (var8 - this.energy$quickdropTime >= var11) {
               this.onMouseClick(var7, var7.id, 0, SlotActionType.QUICK_MOVE);
               this.energy$quickdropSlot = var7;
               this.energy$quickdropTime = var8;
            }
         }
      }
   }

   @Inject(
      method = {"onMouseClick(Lnet/minecraft/screen/slot/Slot;IILnet/minecraft/screen/slot/SlotActionType;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void mouseclick(Slot var1, int var2, int var3, SlotActionType var4, CallbackInfo var5) {
      EventHandleMouseClick var6 = new EventHandleMouseClick(var1, var2, var3, var4);
      EnergyClient.f_1622.f_1624.m_30(var6);
      if (var6.m_2244()) {
         var5.cancel();
      }
   }

   @Inject(
      method = {"drawMouseoverTooltip"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void energy$drawContainerShulkerPreview(DrawContext var1, int var2, int var3, CallbackInfo var4) {
      if (this.focusedSlot != null && this.focusedSlot.hasStack() && this.handler.getCursorStack().isEmpty()) {
         if (InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null) {
            ShulkerPreview var5 = InitManager.f_2740.f_2741.shulkerPreview;
            ItemStack var6 = this.focusedSlot.getStack();
            if (var5 != null && var5.m_1815(var1, f_5909.textRenderer, var6, var2, var3)) {
               var4.cancel();
            }
         }
      }
   }

   @Inject(
      method = {"init"},
      at = {@At("TAIL")}
   )
   private void energy$addAutoBuyButton(CallbackInfo var1) {
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null) {
         AutoBuy var2 = InitManager.f_2740.f_2741.autoBuy;
         if (var2 != null && var2.m_677()) {
            HandledScreen<?> var3 = (HandledScreen<?>)(Object)this;
            Util147 var4 = var2.m_1361();
            if (var4.m_484(var3)) {
               byte var5 = 120;
               int var6 = this.x + (this.backgroundWidth - var5) / 2;
               int var7 = this.y - 24;
               ButtonWidget var8 = ButtonWidget.builder(this.energy$getAutoBuyButtonText(var4), var2x -> {
                  var4.m_2663();
                  var2x.setMessage(this.energy$getAutoBuyButtonText(var4));
               }).dimensions(var6, var7, var5, 20).build();
               ((ScreenMixin2)var3).invokeAddDrawableChild(var8);
            }
         }
      }
   }

   @Inject(
      method = {"render"},
      at = {@At("TAIL")}
   )
   private void energy$renderSavedInventory(DrawContext var1, int var2, int var3, float var4, CallbackInfo var5) {
      if ((Object)this instanceof InventoryScreen) {
         if (InitManager.f_2740 != null) {
            InventoryManager var6 = InitManager.f_2740.f_2745;
            if (var6 != null && var6.m_2811()) {
               DefaultedList var7 = var6.m_2290();
               float var8 = f_10709;
               float var9 = f_10710;
               float var10 = f_10711;
               float var11 = f_10712;
               float var12 = f_10713;
               float var13 = this.x + this.backgroundWidth + f_10714;
               float var14 = this.y;
               if (var13 + f_10715 > f_5909.getWindow().getScaledWidth()) {
                  var13 = this.x - f_10716 - f_10717;
               }

               Util158.m_3998(var13, var14, f_10718, f_10719, f_10720, Util71.m_3389(f_10721, 200), 1.0F);
               int var15 = Util71.m_3389(f_10722, 180);
               float var16 = var13 + f_10723;
               float var17 = var14 + f_10724;
               ItemStack var18 = ItemStack.EMPTY;

               for (int var19 = 0; var19 < 4; var19++) {
                  if (this.energy$drawSavedSlot(var1, var7, 36 + var19, var16 + var19 * f_10725, var17, var15, var2, var3)) {
                     var18 = (ItemStack)var7.get(36 + var19);
                  }
               }

               if (this.energy$drawSavedSlot(var1, var7, 40, var16 + f_10726, var17, var15, var2, var3)) {
                  var18 = (ItemStack)var7.get(40);
               }

               var17 += f_10727;

               for (int var24 = 0; var24 < 3; var24++) {
                  for (int var20 = 0; var20 < 9; var20++) {
                     int var21 = 9 + var24 * 9 + var20;
                     if (this.energy$drawSavedSlot(var1, var7, var21, var16 + var20 * f_10728, var17 + var24 * f_10729, var15, var2, var3)) {
                        var18 = (ItemStack)var7.get(var21);
                     }
                  }
               }

               var17 += f_10730;

               for (int var25 = 0; var25 < 9; var25++) {
                  if (this.energy$drawSavedSlot(var1, var7, var25, var16 + var25 * f_10731, var17, var15, var2, var3)) {
                     var18 = (ItemStack)var7.get(var25);
                  }
               }

               if (!var18.isEmpty()) {
                  var1.drawItemTooltip(f_5909.textRenderer, var18, var2, var3);
               }
            }
         }
      }
   }

   @Unique
   private boolean energy$drawSavedSlot(DrawContext var1, DefaultedList<ItemStack> var2, int var3, float var4, float var5, int var6, int var7, int var8) {
      Util158.m_1849(var4, var5, f_10732, f_10733, f_10734, var6);
      ItemStack var9 = (ItemStack)var2.get(var3);
      if (!var9.isEmpty()) {
         int var10 = (int)var4;
         int var11 = (int)var5;
         var1.drawItem(var9, var10, var11);
         var1.drawStackOverlay(f_5909.textRenderer, var9, var10, var11);
      }

      return var7 >= var4 && var7 < var4 + f_10735 && var8 >= var5 && var8 < var5 + f_10736;
   }

   @Unique
   private Text energy$getAutoBuyButtonText(Util147 var1) {
      boolean var2 = var1.m_3004();
      return Text.literal(f_10737).append(Text.literal(var2 ? f_10738 : f_10739).formatted(var2 ? Formatting.GREEN : Formatting.RED));
   }

   static {
      VMBridge.identifyClass(HandledScreenMixin.class, "R4OMFPNq");
   }
}
