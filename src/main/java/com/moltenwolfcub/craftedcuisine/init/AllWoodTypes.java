package com.moltenwolfcub.craftedcuisine.init;

import com.moltenwolfcub.craftedcuisine.mixin.WoodTypeAccessor;

import net.minecraft.world.level.block.state.properties.WoodType;

public class AllWoodTypes {
    public static final WoodType CINNAMON = WoodTypeAccessor.registerNew(new WoodType("cinnamon", AllBlockSetTypes.CINNAMON));
}
