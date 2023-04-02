package com.moltenwolfcub.craftedcuisine.item.util;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.item.Item;

public class ItemUtils {

    public static void addToComposterList(float chance, Item item) {
        CompostingChanceRegistry.INSTANCE.add(item, chance);
    }

    public static void addToSmeltables(int burnTime, Item item) {
        FuelRegistry.INSTANCE.add(item, burnTime);
    }
    
}
