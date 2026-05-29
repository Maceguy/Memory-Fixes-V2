package com.memfix.common;

import it.unimi.dsi.fastutil.longs.Long2FloatLinkedOpenHashMap;

public class MemFixTemperatureCache {
    public static final ThreadLocal<Long2FloatLinkedOpenHashMap> CACHE =
        ThreadLocal.withInitial(() -> {
            Long2FloatLinkedOpenHashMap map = new Long2FloatLinkedOpenHashMap(1024, 0.25f);
            map.defaultReturnValue(Float.NaN);
            return map;
        });
}
