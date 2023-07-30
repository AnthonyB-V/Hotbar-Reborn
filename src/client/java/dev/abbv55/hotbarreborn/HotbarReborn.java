package dev.abbv55.hotbarreborn;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.abbv55.hotbarreborn.util.render.RenderUtil;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.*;
import net.minecraft.client.util.InputUtil;
import org.joml.Matrix4f;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class HotbarReborn implements ClientModInitializer {

	private static final HotbarReborn hotbarReborn = new HotbarReborn();

	public KeyBinding settingsOpenKey;

	@Override
	public void onInitializeClient() {
		settingsOpenKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.hotbarreborn.openSettings", // The translation key of the keybinding's name
				InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
				GLFW.GLFW_KEY_HOME, // The keycode of the key
				"category.hotbarreborn.misc" // The translation key of the keybinding's category.
		));
		HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {

			//drawContext.drawBorder(50, 50, 50, 50,-1);
			//drawContext.fill(50, 50, 50, 50, -1);
			//RenderUtil.glDrawRect(drawContext.getMatrices(), 50, 50, 50,50, -1);\

			drawContext.fill(50, 50, 100, 100, -1);

		});
	}

	private static void setup2dRender() {
		RenderSystem.disableCull();
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
	}

	private static void end2dRender() {
		RenderSystem.disableBlend();
		RenderSystem.enableCull();
		RenderSystem.depthFunc(GL11.GL_LEQUAL);
	}

	public static HotbarReborn getInstance() {
		return hotbarReborn;
	}

	public KeyBinding getSettingsOpenKey() {
		return settingsOpenKey;
	}
}