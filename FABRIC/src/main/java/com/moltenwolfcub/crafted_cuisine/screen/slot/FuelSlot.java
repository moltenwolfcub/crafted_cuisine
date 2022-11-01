package com.moltenwolfcub.crafted_cuisine.screen.slot;

import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreenHandler;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class FuelSlot extends Slot {
    private final CarameliserScreenHandler screenHandler;
 
    public FuelSlot(CarameliserScreenHandler carameliserHandler, Inventory inv, int index, int x, int y) {
        super(inv, index, x, y);
        this.screenHandler = carameliserHandler;
    }
 
    @Override
    public boolean canInsert(ItemStack stack) {
       return this.screenHandler.isFuel(stack);
    }
}
