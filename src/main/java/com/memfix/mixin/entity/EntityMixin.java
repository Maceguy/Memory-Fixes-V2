package com.memfix.mixin.entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.entity.Entity;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "remove", at = @At("TAIL"))
    private void memfix$clearTagsOnRemove(Entity.RemovalReason reason, CallbackInfo ci) {
        Entity self = (Entity)(Object)this;
        if (!self.getTags().isEmpty()) {
            self.getTags().clear();
        }
    }
}
