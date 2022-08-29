package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().tab(CraftedCuisine.MAIN_TAB));
    }

    public BlockItemBase(Block block, Properties properties) {
        super(block, properties.tab(CraftedCuisine.MAIN_TAB));
    }
    
}
