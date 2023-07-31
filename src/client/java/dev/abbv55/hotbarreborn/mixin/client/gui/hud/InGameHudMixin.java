package dev.abbv55.hotbarreborn.mixin.client.gui.hud;

import dev.abbv55.hotbarreborn.config.Config;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import ru.hogoshi.Animation;
import ru.hogoshi.util.Easings;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    private static Animation selectorAnimation = Animation.builder().build();

    @ModifyArgs(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V", ordinal = 0))
    private void modifyHotbarBackgroundXY(Args args) {
        if(!Config.INSTANCE.showHotbarBack) {
            args.set(2, -50);
        }else {
            args.set(1, (int) args.get(1) + Config.INSTANCE.xOffsetHotbar);
            args.set(2, (int) args.get(2) - Config.INSTANCE.ySubtractHotbar);
        }
    }

    @ModifyArgs(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V", ordinal = 1))
    private void modifyHotbarSelectorXY(Args args) {
        if(!Config.INSTANCE.showHotbarSelector) {
            args.set(2, -50);
        }else {
            if(Config.INSTANCE.animateSelector) {
                selectorAnimation.update();
                selectorAnimation.animate(((int) args.get(1)) + Config.INSTANCE.xOffsetHotbar, 1, Easings.QUAD_BOTH, true);
                args.set(1, ((int) selectorAnimation.getValue()));
            }else {
                args.set(1, (int) args.get(1) + Config.INSTANCE.xOffsetHotbar);
            }
            args.set(2, (int) args.get(2) - Config.INSTANCE.ySubtractHotbar);
        }
    }

    @ModifyArgs(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;renderHotbarItem(Lnet/minecraft/client/gui/DrawContext;IIFLnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;I)V", ordinal = 0))
    private void modifyHotbarItemsXY(Args args) {
        args.set(1, (int) args.get(1) + Config.INSTANCE.xOffsetHotbar);
        args.set(2, (int) args.get(2) - Config.INSTANCE.ySubtractHotbar);
    }
}
