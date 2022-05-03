package com.moltenwolfcub.create_food.item.util;

import com.moltenwolfcub.create_food.CreateFood;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, ItemUtils.DefaultItemProperties);
    }

    public BlockItemBase(Block block, Properties properties) {
        super(block, properties.tab(CreateFood.TAB));
    }
    
}
