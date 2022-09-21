package com.moltenwolfcub.crafted_cuisine.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class ModResultSlot extends Slot {

    public ModResultSlot(Inventory container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }
}
