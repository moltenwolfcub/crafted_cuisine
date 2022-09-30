package com.moltenwolfcub.crafted_cuisine.item.util;

public class ReusableCraftingItem extends ItemBase {

    public ReusableCraftingItem(Settings properties) {
        super(properties);
        this.recipeRemainder = this.asItem();
    }

    public ReusableCraftingItem() {
        super();
        this.recipeRemainder = this.asItem();
    }
    
}
