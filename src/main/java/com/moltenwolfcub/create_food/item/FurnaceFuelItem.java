package com.moltenwolfcub.create_food.item;

import com.moltenwolfcub.create_food.item.util.ItemBase;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class FurnaceFuelItem extends ItemBase {

    private Integer burnTime;

    public FurnaceFuelItem(Properties properties, Integer burnTime) {
        super(properties);
        this.burnTime = burnTime;
    }
    public FurnaceFuelItem(Integer burnTime) {
        super();
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return this.burnTime;
    }
    
}
