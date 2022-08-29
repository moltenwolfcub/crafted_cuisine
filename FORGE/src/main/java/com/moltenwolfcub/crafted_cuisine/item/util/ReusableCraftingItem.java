package com.moltenwolfcub.crafted_cuisine.item.util;

import java.util.Random;

import net.minecraft.world.item.ItemStack;

public class ReusableCraftingItem extends ItemBase {

    public ReusableCraftingItem() {
        super();
    }

    public ReusableCraftingItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        container.hurt(1, new Random(), null);
        return container;
    }
    
}
