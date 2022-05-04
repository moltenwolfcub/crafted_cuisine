package com.moltenwolfcub.cooks_kitchen.screen.slot;

import com.moltenwolfcub.cooks_kitchen.init.ModTags;

import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BlowtorchSlot extends SlotItemHandler {

    public BlowtorchSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack stack) {
        return Registry.ITEM.getHolderOrThrow(Registry.ITEM.getResourceKey(stack.getItem()).get()).is(ModTags.Items.BLOW_TORCHES);
    }
}
