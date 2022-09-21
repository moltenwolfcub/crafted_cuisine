package com.moltenwolfcub.crafted_cuisine.screen.slot;

import com.moltenwolfcub.crafted_cuisine.init.AllTags;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class BlowtorchSlot extends Slot {

    public BlowtorchSlot(Inventory container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean canInsert(ItemStack stack) {
        // return stack.is(AllTags.Items.BLOW_TORCHES);
        return false;
    }
}
