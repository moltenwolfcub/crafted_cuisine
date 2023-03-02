package com.moltenwolfcub.crafted_cuisine.screen.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ModResultSlot extends Slot {

    public ModResultSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }
}
