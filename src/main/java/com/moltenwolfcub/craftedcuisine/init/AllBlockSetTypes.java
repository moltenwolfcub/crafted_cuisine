package com.moltenwolfcub.craftedcuisine.init;

import com.moltenwolfcub.craftedcuisine.mixin.BlockSetTypeAccessor;

import net.minecraft.world.level.block.state.properties.BlockSetType;

public class AllBlockSetTypes {
    public static final BlockSetType CINNAMON = BlockSetTypeAccessor.registerNew(new BlockSetType("cinnamon"));

}
