package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;


public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new FabricItemSettings().group(CraftedCuisine.MAIN_TAB));
    }

    public BlockItemBase(Block block, FabricItemSettings properties) {
        super(block, properties.group(CraftedCuisine.MAIN_TAB));
    }
    
}
