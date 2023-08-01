package dev.abbv55.hotbarreborn.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ConfigScreenFactory {

    private static ConfigBuilder configBuilder;

    public static Screen createConfigScreen(Screen parent) {
        Config currentConfig = Config.INSTANCE;

        configBuilder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.translatable("title.hotbarreborn.config"))
                .setSavingRunnable(currentConfig::write);

        ConfigCategory hotbarCategory = configBuilder.getOrCreateCategory(Text.translatable("category.hotbarreborn.hotbar"));

        ConfigEntryBuilder entryBuilder = configBuilder.entryBuilder();

        hotbarCategory.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.hotbarreborn.globalenabled"), currentConfig.globalEnabled)
                .setDefaultValue(true)
                .setTooltip(Text.translatable("tooltip.hotbarreborn.globalenabled"))
                .requireRestart()
                .setSaveConsumer(newValue -> currentConfig.globalEnabled = newValue)
                .build());

        hotbarCategory.addEntry(entryBuilder.startIntField(Text.translatable("option.hotbarreborn.xoffhot"), currentConfig.xOffsetHotbar)
                .setDefaultValue(0)
                .setTooltip(Text.translatable("tooltip.hotbarreborn.xoffhot"))
                .setSaveConsumer(newValue -> currentConfig.xOffsetHotbar = newValue)
                .build());

        hotbarCategory.addEntry(entryBuilder.startIntField(Text.translatable("option.hotbarreborn.ysubhot"), currentConfig.ySubtractHotbar)
                .setDefaultValue(0)
                .setTooltip(Text.translatable("tooltip.hotbarreborn.ysubhot"))
                .setSaveConsumer(newValue -> currentConfig.ySubtractHotbar = newValue)
                .build());

        hotbarCategory.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.hotbarreborn.showHotBack"), currentConfig.showHotbarBack)
                .setDefaultValue(true)
                .setTooltip(Text.translatable("tooltip.hotbarreborn.showHotBack"))
                .setSaveConsumer(newValue -> currentConfig.showHotbarBack = newValue)
                .build());

        hotbarCategory.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.hotbarreborn.showHotSel"), currentConfig.showHotbarSelector)
                .setDefaultValue(true)
                .setTooltip(Text.translatable("tooltip.hotbarreborn.showHotSel"))
                .setSaveConsumer(newValue -> currentConfig.showHotbarSelector = newValue)
                .build());

        hotbarCategory.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.hotbarreborn.animSel"), currentConfig.animateSelector)
                .setDefaultValue(true)
                .setTooltip(Text.translatable("tooltip.hotbarreborn.animSel"))
                .setSaveConsumer(newValue -> currentConfig.animateSelector = newValue)
                .build());

        hotbarCategory.addEntry(entryBuilder.startLongSlider(Text.translatable("option.hotbarreborn.animTimeHot"), currentConfig.animTimeHotbar, 100, 3000)
                .setDefaultValue(1000)
                .setTooltip(Text.translatable("tooltip.hotbarreborn.animTimeHot"))
                .setSaveConsumer(newValue -> currentConfig.animTimeHotbar = newValue)
                .build());

        return configBuilder.build();
    }

}
