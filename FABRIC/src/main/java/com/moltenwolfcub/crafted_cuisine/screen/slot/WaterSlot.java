package com.moltenwolfcub.crafted_cuisine.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.screen.slot.Slot;

public class WaterSlot extends Slot {

    public WaterSlot(Inventory container, int index, int x, int y) {
        super(container, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.isOf(Items.WATER_BUCKET) || PotionUtil.getPotion(stack) == Potions.WATER;
    }

    @Override
    public int getMaxItemCount() {
        return 1;
    }
}
