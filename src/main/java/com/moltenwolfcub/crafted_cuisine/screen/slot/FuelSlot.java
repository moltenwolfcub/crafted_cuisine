package com.moltenwolfcub.crafted_cuisine.screen.slot;

import com.moltenwolfcub.crafted_cuisine.screen.CarameliserMenu;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;


public class FuelSlot extends Slot {
 
    public FuelSlot(Container inv, int index, int x, int y) {
        super(inv, index, x, y);
    }
 
    @Override
    public boolean mayPlace(ItemStack stack) {
       return CarameliserMenu.isFuel(stack);
    }
}
