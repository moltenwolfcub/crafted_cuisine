package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class ModCreativeTabs {

    public static final ItemGroup MAIN_CREATIVE_TAB = FabricItemGroupBuilder.build(
        new Identifier(CraftedCuisine.MODID, "main_group"),
            () -> ItemStack.EMPTY);
}
