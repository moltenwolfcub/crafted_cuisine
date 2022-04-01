package com.moltenwolfcub.create_food.item;

import com.moltenwolfcub.create_food.item.util.BlockItemBase;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class FurnaceFuelBlockItem extends BlockItemBase {

    private Integer burnTime;

    public FurnaceFuelBlockItem(Block block, Integer burnTime, Properties properties) {
        super(block, properties);
        this.burnTime = burnTime;
    }
    public FurnaceFuelBlockItem(Block block, Integer burnTime) {
        super(block);
        this.burnTime = burnTime;
    }
    public FurnaceFuelBlockItem(Block block) {
        super(block);
        this.burnTime = 200;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return this.burnTime;
    }
    
}
