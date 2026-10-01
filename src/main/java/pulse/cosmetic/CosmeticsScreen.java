package pulse.cosmetic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

/**
 * Simple cosmetics selector opened from the main menu.
 * Toggle cosmetics by type (one per slot type).
 */
public class CosmeticsScreen extends Screen {
    private final Screen parent;
    private int scroll;
    private static final int ROW_H = 22;
    private static final int PAD = 12;

    public CosmeticsScreen(Screen parent) {
        super(Text.literal("Cosmetics"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        this.clearChildren();
        int btnW = 120;
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Назад"), b -> this.client.setScreen(this.parent))
            .dimensions(this.width / 2 - btnW / 2, this.height - 28, btnW, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Сбросить"), b -> {
            for (int i = 0; i < LocalCosmetics.size(); i++) {
                // clear all by toggling off if selected
            }
            // hard clear via re-select nothing: toggle selected ones off
            List<Integer> sel = new ArrayList<>(LocalCosmetics.selectedIndices());
            for (Integer idx : sel) {
                LocalCosmetics.toggle(idx);
            }
        }).dimensions(this.width / 2 - btnW / 2 - 130, this.height - 28, btnW, 20).build());
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        this.scroll = (int) Math.max(0, this.scroll - verticalAmount * 18);
        return true;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int listTop = 40;
            int listBottom = this.height - 40;
            if (mouseY >= listTop && mouseY <= listBottom) {
                int y = listTop - this.scroll;
                for (int i = 0; i < LocalCosmetics.size(); i++) {
                    if (mouseY >= y && mouseY < y + ROW_H) {
                        LocalCosmetics.toggle(i);
                        return true;
                    }
                    y += ROW_H;
                }
            }
        }
        return false;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        try {
            this.renderBackground(context, mouseX, mouseY, delta);
        } catch (Throwable t) {
            context.fill(0, 0, this.width, this.height, 0xC0101010);
        }
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 12, 0xFFFFFF);
        context.drawCenteredTextWithShadow(this.textRenderer,
            Text.literal("Клик — надеть/снять. По одному на тип."),
            this.width / 2, 26, 0xAAAAAA);

        int listTop = 40;
        int listBottom = this.height - 40;
        context.enableScissor(0, listTop, this.width, listBottom);

        int y = listTop - this.scroll;
        List<Integer> selected = LocalCosmetics.selectedIndices();
        for (int i = 0; i < LocalCosmetics.size(); i++) {
            if (y + ROW_H < listTop) {
                y += ROW_H;
                continue;
            }
            if (y > listBottom) break;

            boolean isSel = selected.contains(i);
            int bg = isSel ? 0x8044AA44 : (mouseY >= y && mouseY < y + ROW_H ? 0x60FFFFFF : 0x40000000);
            context.fill(PAD, y, this.width - PAD, y + ROW_H - 2, bg);

            String name = LocalCosmetics.name(i);
            String type = LocalCosmetics.type(i);
            int color = isSel ? 0x55FF55 : 0xFFFFFF;
            context.drawTextWithShadow(this.textRenderer, name, PAD + 8, y + 6, color);
            context.drawTextWithShadow(this.textRenderer, "[" + type + "]", this.width - PAD - 80, y + 6, 0xAAAAAA);
            y += ROW_H;
        }
        context.disableScissor();

        // selected summary
        String sum = "Выбрано: " + selected.size();
        context.drawTextWithShadow(this.textRenderer, sum, PAD, this.height - 28, 0xCCCCCC);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void close() {
        this.client.setScreen(this.parent);
    }
}
