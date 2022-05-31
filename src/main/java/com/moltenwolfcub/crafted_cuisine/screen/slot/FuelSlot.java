package com.moltenwolfcub.crafted_cuisine.screen.slot;

import com.moltenwolfcub.crafted_cuisine.screen.CarameliserMenu;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class FuelSlot extends Slot {
    private final CarameliserMenu menu;
 
    public FuelSlot(CarameliserMenu carameliserMenu ,Container container, int index, int x, int y) {
        super(container, index, x, y);
        this.menu = carameliserMenu;
    }
 
    @Override
    public boolean mayPlace(ItemStack stack) {
       return this.menu.isFuel(stack);
    }
}
