package com.moltenwolfcub.crafted_cuisine.screen.slot;

import com.moltenwolfcub.crafted_cuisine.init.ModTags;

import net.minecraft.core.Registry;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BlowtorchSlot extends Slot {

    public BlowtorchSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack stack) {
        return Registry.ITEM.getHolderOrThrow(Registry.ITEM.getResourceKey(stack.getItem()).get()).is(ModTags.Items.BLOW_TORCHES);
    }
}
