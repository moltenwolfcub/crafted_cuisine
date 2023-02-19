package com.moltenwolfcub.crafted_cuisine.item.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.Item;


public class ItemBase extends Item {

    public ItemBase() {
        super(new FabricItemSettings());
    }

    public ItemBase(FabricItemSettings properties) {
        super(properties);
    }
    
}
