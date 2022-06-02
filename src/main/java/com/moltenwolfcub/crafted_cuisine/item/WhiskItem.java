package com.moltenwolfcub.crafted_cuisine.item;

import java.util.Random;

import com.moltenwolfcub.crafted_cuisine.item.util.ItemBase;
import net.minecraft.world.item.ItemStack;

public class WhiskItem extends ItemBase {

    public WhiskItem() {
        super();
    }

    public WhiskItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        if(container.hurt(1, new Random(), null)) {
            return ItemStack.EMPTY;
        } else {
            return container;
        }
    }
    
}
