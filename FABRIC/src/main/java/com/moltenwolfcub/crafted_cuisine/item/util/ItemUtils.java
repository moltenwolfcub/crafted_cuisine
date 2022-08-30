package com.moltenwolfcub.crafted_cuisine.item.util;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;

public class ItemUtils {

    public static void addToComposterList(float chance, Item item) {
        CompostingChanceRegistry.INSTANCE.add(item, chance);
    }

    public static void addToSmeltables(int burnTime, Item item) {
        FuelRegistry.INSTANCE.add(item, burnTime);
    }
    
}
