package com.memfix.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemFix implements ModInitializer {
    public static final String MOD_ID = "memfix";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final int GC_INTERVAL = 600;
    private int ticks = 0;

    @Override
    public void onInitialize() {
        LOGGER.info("[MemFix] Memory optimization active.");
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            ticks++;
            if (ticks >= GC_INTERVAL) {
                ticks = 0;
                System.gc();
            }
        });
    }
}
