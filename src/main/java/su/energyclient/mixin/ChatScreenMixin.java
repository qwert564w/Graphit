package su.energyclient.mixin;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.energyclient.QuickImports;
import su.energyclient.manager.InitManager;
import su.energyclient.util.Util112;

@Mixin({ChatScreen.class})
public abstract class ChatScreenMixin extends Screen {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   protected ChatScreenMixin() {
      super(null);
   }

   @Inject(
      method = {"render"},
      at = {@At("RETURN")}
   )
   private void onRender(DrawContext var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2743 != null) {
         ObjectListIterator var6 = InitManager.f_2740.f_2743.m_2418().iterator();

         while (var6.hasNext()) {
            Util112 var7 = (Util112)var6.next();
            var7.m_1618(var2, var3, QuickImports.f_5909.getWindow());
         }
      }
   }

   @Inject(
      method = {"mouseClicked"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onMouseClicked(Click var1, boolean var2, CallbackInfoReturnable<Boolean> var3) {
      double var4 = var1.x();
      double var6 = var1.y();
      int var8 = var1.button();
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2743 != null) {
         ObjectArrayList var9 = InitManager.f_2740.f_2743.m_2418();

         for (int var10 = var9.size() - 1; var10 >= 0; var10--) {
            Util112 var11 = (Util112)var9.get(var10);
            if (var11.m_1403(var4, var6, var8)) {
               var3.setReturnValue(true);
               return;
            }
         }
      }
   }

   public boolean mouseReleased(Click var1) {
      double var2 = var1.x();
      double var4 = var1.y();
      int var6 = var1.button();
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2743 != null) {
         ObjectListIterator var7 = InitManager.f_2740.f_2743.m_2418().iterator();

         while (var7.hasNext()) {
            Util112 var8 = (Util112)var7.next();
            var8.m_1405(var2, var4, var6);
         }
      }

      return super.mouseReleased(var1);
   }

   @Inject(
      method = {"removed"},
      at = {@At("HEAD")}
   )
   private void onRemoved(CallbackInfo var1) {
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2743 != null) {
         ObjectListIterator var2 = InitManager.f_2740.f_2743.m_2418().iterator();

         while (var2.hasNext()) {
            Util112 var3 = (Util112)var2.next();
            var3.m_1709();
         }
      }
   }
}
