package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {
	public static CreativeModeTab MAIN_CREATIVE_TAB= FabricItemGroup.builder(
		new ResourceLocation(CraftedCuisine.MODID, "main"))
		.title(Component.translatable("itemGroup.crafted_cuisine"))
		.icon(() -> new ItemStack(AllItems.CARAMEL_BUCKET))
		.build();
}

