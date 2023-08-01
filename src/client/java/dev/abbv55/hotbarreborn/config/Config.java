package dev.abbv55.hotbarreborn.config;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

// Mostly copied from CITResewn github.com/SHsuperCM/CITResewn
public class Config {

    public boolean globalEnabled = true, showHotbarBack = true, showHotbarSelector = true, animateSelector = true;

    public int xOffsetHotbar, ySubtractHotbar;

    public long animTimeHotbar = 1000L;

    private static final File FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), "hotbar reborn.json");

    public static final Config INSTANCE = read();

    public static Config read() {
        if (!FILE.exists())
            return new Config().write();

        Reader reader = null;
        try {
            return new Gson().fromJson(reader = new FileReader(FILE), Config.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    public Config write() {
        Gson gson = new Gson();
        JsonWriter writer = null;
        try {
            writer = gson.newJsonWriter(new FileWriter(FILE));
            writer.setIndent("    ");

            gson.toJson(gson.toJsonTree(this, Config.class), writer);
        } catch (Exception e) {
            System.out.println("Couldn't save config");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(writer);
        }
        return this;
    }
}
