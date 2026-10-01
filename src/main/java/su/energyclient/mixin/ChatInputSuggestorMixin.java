package su.energyclient.mixin;

import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.suggestion.Suggestions;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.gui.screen.ChatInputSuggestor;
import net.minecraft.client.gui.screen.ChatInputSuggestor.SuggestionWindow;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.command.CommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.energyclient.command.impl.PanicCommand;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.CommandManager;

@Mixin({ChatInputSuggestor.class})
public abstract class ChatInputSuggestorMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Shadow
   private TextFieldWidget textField;
   @Shadow
   private boolean suggestingWhenEmpty;
   @Shadow
   private boolean completingSuggestions;
   @Shadow
   private CompletableFuture<Suggestions> pendingSuggestions;
   @Shadow
   private SuggestionWindow window;
   @Shadow
   private ParseResults<CommandSource> parse;

   @Shadow
   protected abstract void show(boolean var1);

   @Inject(
      method = {"refresh"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void minced$useClientCommandManager(CallbackInfo var1) {
      if (InitManager.f_2740 != null) {
         CommandManager var2 = InitManager.f_2740.f_2742;
         if (var2 != null) {
            String var3 = this.textField.getText();
            StringReader var4 = new StringReader(var3);
            String var5 = var2.m_1465();
            if (PanicCommand.m_2020() && !var5.isEmpty() && var3.startsWith(var5)) {
               this.textField.setSuggestion(null);
               this.window = null;
               this.parse = null;
               this.pendingSuggestions = Suggestions.empty();
               var1.cancel();
            } else {
               if (!var5.isEmpty() && var4.canRead(var5.length()) && var4.getString().startsWith(var5, var4.getCursor())) {
                  if (!this.completingSuggestions) {
                     this.textField.setSuggestion(null);
                     this.window = null;
                  }

                  var4.setCursor(var4.getCursor() + var5.length());
                  ParseResults var6 = var2.m_4069().parse(var4, var2.O());
                  this.parse = var6;
                  int var7 = this.textField.getCursor();
                  int var8 = this.suggestingWhenEmpty ? var4.getCursor() : 1;
                  if (var7 >= var8 && (this.window == null || !this.completingSuggestions)) {
                     this.pendingSuggestions = var2.m_4069().getCompletionSuggestions(var6, var7);
                     this.pendingSuggestions.thenRun(() -> {
                        if (this.pendingSuggestions != null && this.pendingSuggestions.isDone()) {
                           this.show(false);
                        }
                     });
                  }

                  var1.cancel();
               }
            }
         }
      }
   }
}
