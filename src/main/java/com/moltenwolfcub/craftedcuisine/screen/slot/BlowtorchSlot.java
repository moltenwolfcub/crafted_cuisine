package com.moltenwolfcub.craftedcuisine.screen.slot;

import com.moltenwolfcub.craftedcuisine.init.AllTags;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;


public class BlowtorchSlot extends Slot {

    public BlowtorchSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.is(AllTags.Items.BLOW_TORCHES);
    }
}
