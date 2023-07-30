package dev.abbv55.hotbarreborn.util.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

public class RenderUtil {

    private static boolean blendingEnabled;
    private static boolean texture2DEnabled;

    private RenderUtil() {}

    public static void glDrawRect(float x, float y, float width, float height, int color) {

    }

    private static void color(int color) {
        GL11.glColor4f(ColorUtil.getRed(color), ColorUtil.getGreen(color), ColorUtil.getBlue(color), ColorUtil.getAlpha(color));
    }

    private static void start2dRender() {

    }

    public static void end2dRender() {

    }
}
