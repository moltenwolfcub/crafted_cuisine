package com.moltenwolfcub.create_food.item.util;

import com.moltenwolfcub.create_food.CreateFood;
import com.simibubi.create.AllItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MainCreativeTab extends CreativeModeTab {
    public MainCreativeTab() {
        super(CreateFood.MODID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(AllItems.BAR_OF_CHOCOLATE.get());
    }
    
}
