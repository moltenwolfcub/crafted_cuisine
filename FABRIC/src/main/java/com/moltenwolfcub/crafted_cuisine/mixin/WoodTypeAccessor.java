package com.moltenwolfcub.crafted_cuisine.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.level.block.state.properties.WoodType;

//TODO rename class remember to update mixins.json
@Mixin(WoodType.class)
public interface WoodTypeAccessor {
    
    @Invoker("<init>")
    static WoodType newSignType(String name) {
        throw new AssertionError();
    }

    @Invoker("register")
    static WoodType registerNew(WoodType type) {
        throw new AssertionError();
    }
}
