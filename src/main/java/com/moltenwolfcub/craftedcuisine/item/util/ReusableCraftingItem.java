package com.moltenwolfcub.craftedcuisine.item.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ReusableCraftingItem extends ItemBase {

    public ReusableCraftingItem(FabricItemSettings properties) {
        super(properties);
        this.craftingRemainingItem = this.asItem();
    }

    public ReusableCraftingItem() {
        this.craftingRemainingItem = this.asItem();
    }
    
}
