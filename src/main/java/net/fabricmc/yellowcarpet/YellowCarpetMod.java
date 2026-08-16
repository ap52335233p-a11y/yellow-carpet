package net.fabricmc.yellowcarpet;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YellowCarpetMod implements ModInitializer {
    public static final String MOD_ID = "yellowcarpet";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Yellow Carpet mod initialized successfully for Minecraft 1.21.1!");
    }
}
