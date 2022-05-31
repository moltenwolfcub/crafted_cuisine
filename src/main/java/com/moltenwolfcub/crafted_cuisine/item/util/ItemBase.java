package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.world.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(ItemUtils.DefaultItemProperties);
    }

    public ItemBase(Properties properties) {
        super(properties.tab(CraftedCuisine.TAB));
    }
    
}
