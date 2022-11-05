package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.mixin.SignTypeAccessor;

import net.minecraft.world.level.block.state.properties.WoodType;
//TODO rename class
public class AllSignTypes {
    public static final WoodType CINNAMON = SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("cinnamon"));
}
