package com.moltenwolfcub.crafted_cuisine;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moltenwolfcub.crafted_cuisine.init.*;
import com.moltenwolfcub.crafted_cuisine.item.util.ModCreativeTabs;
import com.moltenwolfcub.crafted_cuisine.world.ModWorldGeneration;

public class CraftedCuisine implements ModInitializer {
	public static final String MODID = "crafted_cuisine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static final ItemGroup MAIN_TAB = ModCreativeTabs.MAIN_CREATIVE_TAB;

	@Override
	public void onInitialize() {
		AllConfiguredFeatures.registerConfiguredFeatures();
		AllItems.registerItems();
		AllBlocks.registerBlocks();
		AllBlockItems.registerBlockItems();
		AllSounds.registerSounds();
		
		AllItems.fillComposterList();
		AllBlockItems.fillComposterList();
		AllItems.fillFurnaceFuelList();
		AllBlockItems.fillFurnaceFuelList();

		AllBlocks.registerFlammableBlocks();
		AllBlocks.registerStrippableBlocks();


		ModWorldGeneration.generateModWorldGen();
	}
}
