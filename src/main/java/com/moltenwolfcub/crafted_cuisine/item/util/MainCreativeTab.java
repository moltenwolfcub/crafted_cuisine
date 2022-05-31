package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MainCreativeTab extends CreativeModeTab {
    public MainCreativeTab() {
        super(CraftedCuisine.MODID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.MERINGUE.get());
    }
    
}
