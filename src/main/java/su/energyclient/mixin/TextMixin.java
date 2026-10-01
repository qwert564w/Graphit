package su.energyclient.mixin;

import net.minecraft.text.Text;
import net.minecraft.text.StringVisitable.StyledVisitor;
import net.minecraft.text.StringVisitable.Visitor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import su.energyclient.manager.InitManager;
import su.energyclient.module.miscellaneous.NameProtect;

@Mixin({Text.class})
public interface TextMixin {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @ModifyVariable(
      method = {"visit(Lnet/minecraft/text/StringVisitable$Visitor;)Ljava/util/Optional;"},
      at = @At("HEAD"),
      argsOnly = true
   )
   default <T> Visitor<T> wrapVisitor(Visitor<T> var1) {
      return var1x -> {
         if (InitManager.f_2740 != null) {
            NameProtect var2 = InitManager.f_2740.f_2741.nameProtect;
            if (var2 != null && var2.m_677()) {
               var1x = NameProtect.m_1075(var1x);
            }
         }

         return var1.accept(var1x);
      };
   }

   @ModifyVariable(
      method = {"visit(Lnet/minecraft/text/StringVisitable$StyledVisitor;Lnet/minecraft/text/Style;)Ljava/util/Optional;"},
      at = @At("HEAD"),
      argsOnly = true
   )
   default <T> StyledVisitor<T> wrapStyledVisitor(StyledVisitor<T> var1) {
      return (var1x, var2) -> {
         if (InitManager.f_2740 != null) {
            NameProtect var3 = InitManager.f_2740.f_2741.nameProtect;
            if (var3 != null && var3.m_677()) {
               var2 = NameProtect.m_1075(var2);
            }
         }

         return var1.accept(var1x, var2);
      };
   }
}
