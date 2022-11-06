package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

//TODO rename class
public class ModCreativeTabs {

    public static final CreativeModeTab MAIN_CREATIVE_TAB = FabricItemGroupBuilder.build(
        new ResourceLocation(CraftedCuisine.MODID, "main_group"),
            () -> new ItemStack(AllItems.CARAMEL_BUCKET));
}

