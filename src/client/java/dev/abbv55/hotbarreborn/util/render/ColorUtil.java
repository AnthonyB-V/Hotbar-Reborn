package dev.abbv55.hotbarreborn.util.render;

import java.awt.*;

public class ColorUtil {

    private ColorUtil() {}

    public static float getRed(int color) {
        return (float) (color & 255) / 255.0F;
    }

    public static float getBlue(int color) {
        return (float) (color >> 16 & 255) / 255.0F;
    }

    public static float getGreen(int color) {
        return (float) (color >> 8 & 255) / 255.0F;
    }

    public static float getAlpha(int color) {
        return (float) (color >> 24 & 255) / 255.0F;
    }

    /**
     * Returns a color dimmed by the multiplier.
     * @param c The original color to be dimmed.
     * @param multiplier What to multiply the color by
     * @return The dimmed color.
     */
    public static Color dimByMultiplier(int c, float multiplier) {
        return new Color(getRed(c) * multiplier, getGreen(c) * multiplier, getBlue(c) * multiplier);
    }

    public static int dimByMultiplierInt(int c, float multiplier) {
        return dimByMultiplier(c, multiplier).getRGB();
    }

}
