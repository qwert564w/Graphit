package ru.pulse.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pulse.cosmetic.CosmeticsScreen;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("RETURN"))
    private void energy$addCosmeticsButton(CallbackInfo ci) {
        int btnW = 100;
        int x = this.width / 2 - btnW / 2;
        int y = this.height / 4 + 48 + 72; // under singleplayer/multi buttons area
        // try not to overlap - place lower if needed
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Косметика"), b -> {
            this.client.setScreen(new CosmeticsScreen(this));
        }).dimensions(x, Math.min(y, this.height - 50), btnW, 20).build());
    }
}
