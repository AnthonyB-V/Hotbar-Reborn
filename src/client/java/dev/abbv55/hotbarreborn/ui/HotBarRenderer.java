package dev.abbv55.hotbarreborn.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import ru.hogoshi.Animation;
import ru.hogoshi.bezier.Bezier;
import ru.hogoshi.bezier.list.CubicBezier;
import ru.hogoshi.util.Easings;

public class HotBarRenderer {

    private static final int selectorWidth = 24, selectorHeight = 22;

    private static Animation selectorAnimation = Animation.builder().build();

    private HotBarRenderer() {}

    public static void drawItemOutline(DrawContext dc, int x, int y, int width, int height, int lineWidth, int color) {
        dc.fill(x, y, x + width, y + lineWidth, color);
        dc.fill(x, y + height - lineWidth, x + width, y + height, color);
        dc.fill(x, y, x + lineWidth, y + height, color);
        dc.fill(x + width - lineWidth, y, x + width, y + height, color);
    }

    public static void renderHotbar(DrawContext drawContext, float tickDelta) {
        int halfScaledWidth = drawContext.getScaledWindowWidth() / 2;
        int scaledHeight = drawContext.getScaledWindowHeight();
        //drawItemOutline(drawContext, halScaledWidth - 92, scaledHeight - 23, 24, 22, 1, -1);
        //drawSelector(drawContext, halfScaledWidth, scaledHeight);
    }

    public static void drawSelector(DrawContext drawContext, int halfScaledWidth, int scaledHeight) {
        // Variables
        PlayerEntity playerEntity = (PlayerEntity) MinecraftClient.getInstance().getCameraEntity();
        // Animations
        selectorAnimation.update();
        selectorAnimation.animate(halfScaledWidth - 92 + playerEntity.getInventory().selectedSlot * 20, 1, Easings.QUAD_BOTH, true);
        // Drawing
        drawItemOutline(drawContext, ((int) selectorAnimation.getValue()), scaledHeight - 23, selectorWidth, selectorHeight, 1, -1);
    }

    private static void renderBackground(DrawContext drawContext) {

    }
}