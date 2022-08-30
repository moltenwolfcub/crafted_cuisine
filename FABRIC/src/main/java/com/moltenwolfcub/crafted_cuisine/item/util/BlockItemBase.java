package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;


public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new FabricItemSettings().group(CraftedCuisine.MAIN_TAB));
    }

    public BlockItemBase(Block block, Settings properties) {
        super(block, properties.group(CraftedCuisine.MAIN_TAB));
    }
    
}
