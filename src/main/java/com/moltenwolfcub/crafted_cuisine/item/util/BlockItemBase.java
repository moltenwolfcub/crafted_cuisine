package com.moltenwolfcub.crafted_cuisine.item.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;


public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new FabricItemSettings());
    }

    public BlockItemBase(Block block, FabricItemSettings properties) {
        super(block, properties);
    }
    
}
