package com.moltenwolfcub.crafted_cuisine.item.util;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

public class ReusableCraftingItem extends ItemBase {

    public ReusableCraftingItem(FabricItemSettings properties) {
        super(properties);
        this.craftingRemainingItem = this.asItem();
    }

    public ReusableCraftingItem() {
        this.craftingRemainingItem = this.asItem();
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        if (stack.isDamageableItem() && stack.getDamageValue() < stack.getMaxDamage() - 1) {
            ItemStack damaged = stack.copy();
            Minecraft mc = Minecraft.getInstance();
            damaged.hurt(1, mc.level.random, null);
            return damaged;
        }
      
        return ItemStack.EMPTY;
    }
    
}
