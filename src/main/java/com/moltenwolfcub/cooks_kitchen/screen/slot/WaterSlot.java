package com.moltenwolfcub.cooks_kitchen.screen.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class WaterSlot extends Slot {

    public WaterSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.is(Items.WATER_BUCKET);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
    
}
