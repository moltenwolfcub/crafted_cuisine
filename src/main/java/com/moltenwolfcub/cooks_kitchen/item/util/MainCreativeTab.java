package com.moltenwolfcub.cooks_kitchen.item.util;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.init.ModItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MainCreativeTab extends CreativeModeTab {
    public MainCreativeTab() {
        super(CooksKitchen.MODID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.MERINGUE.get());
    }
    
}
