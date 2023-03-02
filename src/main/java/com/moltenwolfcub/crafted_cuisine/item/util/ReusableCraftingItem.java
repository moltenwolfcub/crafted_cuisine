package com.moltenwolfcub.crafted_cuisine.item.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ReusableCraftingItem extends ItemBase {

    public ReusableCraftingItem(FabricItemSettings properties) {
        super(properties);
        this.craftingRemainingItem = this.asItem();
    }

    public ReusableCraftingItem() {
        super();
        this.craftingRemainingItem = this.asItem();
    }
    
}
