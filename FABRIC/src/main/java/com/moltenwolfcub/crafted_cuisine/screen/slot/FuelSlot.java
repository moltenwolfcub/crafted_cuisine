package com.moltenwolfcub.crafted_cuisine.screen.slot;

import com.moltenwolfcub.crafted_cuisine.screen.CarameliserScreenHandler;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;


public class FuelSlot extends Slot {
    private final CarameliserScreenHandler screenHandler;
 
    public FuelSlot(CarameliserScreenHandler carameliserHandler, Container inv, int index, int x, int y) {
        super(inv, index, x, y);
        this.screenHandler = carameliserHandler;
    }
 
    @Override
    public boolean mayPlace(ItemStack stack) {
       return this.screenHandler.isFuel(stack);
    }
}
