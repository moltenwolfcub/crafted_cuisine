package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.mixin.WoodTypeAccessor;

import net.minecraft.world.level.block.state.properties.WoodType;

public class AllWoodTypes {
    public static final WoodType CINNAMON = WoodTypeAccessor.registerNew(WoodTypeAccessor.newSignType("cinnamon"));
}
