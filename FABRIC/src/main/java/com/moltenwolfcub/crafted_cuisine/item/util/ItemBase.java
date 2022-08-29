package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;


public class ItemBase extends Item {

    public ItemBase() {
        super(new FabricItemSettings().group(CraftedCuisine.MAIN_TAB));
    }

    public ItemBase(Settings settings) {
        super(settings.group(CraftedCuisine.MAIN_TAB));
    }
    
}