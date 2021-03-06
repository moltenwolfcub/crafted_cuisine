package com.moltenwolfcub.crafted_cuisine.item;

import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class FurnaceFuelItem extends ItemBase {

    private final Integer burnTime;

    public FurnaceFuelItem(Properties properties, Integer burnTime) {
        super(properties);
        this.burnTime = burnTime;
    }
    public FurnaceFuelItem(Integer burnTime) {
        super();
        this.burnTime = burnTime;
    }
    public FurnaceFuelItem() {
        super();
        this.burnTime = 200;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return this.burnTime;
    }
    
}
