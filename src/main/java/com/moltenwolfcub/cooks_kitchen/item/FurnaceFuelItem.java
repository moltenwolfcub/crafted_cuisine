package com.moltenwolfcub.cooks_kitchen.item;

import com.moltenwolfcub.cooks_kitchen.item.util.ItemBase;

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
    public FurnaceFuelItem() {
        super();
        this.burnTime = 200;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return this.burnTime;
    }
    
}
