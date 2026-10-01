package su.energyclient.mixin;

import java.util.Map;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({ItemCooldownManager.class})
public interface ItemCooldownManagerMixin2 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   @Accessor("entries")
   Map<Identifier, Object> getEntries();

   @Accessor("tick")
   int getTick();
}
