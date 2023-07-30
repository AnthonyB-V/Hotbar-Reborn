package dev.abbv55.hotbarreborn.mixin.client.gui.hud;

import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Inject(method = "renderHotbar(FLnet/minecraft/client/gui/DrawContext;)V", at = @At("HEAD"), cancellable = true)
    public void cancelVanillaHotbarMixin(CallbackInfo ci) {
      //  ci.cancel();
    }

    @ModifyArg(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V"), index = 2)
    private int modifyHotbar(int value) {
        return value - 10;
    }

    @Inject(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V", ordinal = 1), cancellable = true)
    private void modifyHotbar(CallbackInfo ci) {
        //ci.cancel();
    }
}
