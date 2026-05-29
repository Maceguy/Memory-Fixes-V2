package com.memfix.mixin.world.biome;

import com.memfix.common.MemFixTemperatureCache;
import it.unimi.dsi.fastutil.longs.Long2FloatLinkedOpenHashMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.world.level.biome.Biome;
import java.util.function.Supplier;

@Mixin(Biome.class)
public class BiomeMixin {
    @Redirect(
        method = "<clinit>",
        at = @At(
            value = "INVOKE",
            target = "Ljava/lang/ThreadLocal;withInitial(Ljava/util/function/Supplier;)Ljava/lang/ThreadLocal;"
        )
    )
    private static <T> ThreadLocal<T> memfix$replaceTemperatureCache(Supplier<T> supplier) {
        //noinspection unchecked
        return (ThreadLocal<T>) MemFixTemperatureCache.CACHE;
    }
}
