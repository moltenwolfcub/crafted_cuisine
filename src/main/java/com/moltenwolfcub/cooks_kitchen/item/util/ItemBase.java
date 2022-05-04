package com.moltenwolfcub.cooks_kitchen.item.util;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;

import net.minecraft.world.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(ItemUtils.DefaultItemProperties);
    }

    public ItemBase(Properties properties) {
        super(properties.tab(CooksKitchen.TAB));
    }
    
}
