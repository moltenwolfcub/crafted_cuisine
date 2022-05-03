package com.moltenwolfcub.create_food.item.util;

import com.moltenwolfcub.create_food.CreateFood;

import net.minecraft.world.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(ItemUtils.DefaultItemProperties);
    }

    public ItemBase(Properties properties) {
        super(properties.tab(CreateFood.TAB));
    }
    
}
