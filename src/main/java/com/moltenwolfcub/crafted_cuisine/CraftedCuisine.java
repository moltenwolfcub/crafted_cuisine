package com.moltenwolfcub.crafted_cuisine;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.item.CreativeModeTab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moltenwolfcub.crafted_cuisine.init.*;
import com.moltenwolfcub.crafted_cuisine.item.util.ModCreativeTabs;
import com.moltenwolfcub.crafted_cuisine.util.CreativeTabFiller;
import com.moltenwolfcub.crafted_cuisine.util.ModLootTableModifiers;
import com.moltenwolfcub.crafted_cuisine.util.ModVillagerTrades;
import com.moltenwolfcub.crafted_cuisine.world.ModWorldGeneration;

public class CraftedCuisine implements ModInitializer {
	public static final String MODID = "crafted_cuisine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static final CreativeModeTab MAIN_TAB = ModCreativeTabs.MAIN_CREATIVE_TAB;

	@Override
	public void onInitialize() {
		AllItems.registerItems();
		AllBlocks.registerBlocks();
		AllBlockItems.registerBlockItems();
		AllBlockEntities.registerBlockEntities();
		AllSounds.registerSounds();
		AllMenuTypes.registerScreenHandlerTypes();
		AllRecipes.registerRecipes();
		AllEntityTypes.registerEntities();
		AllEffects.registerEffects();
		
		AllItems.fillComposterList();
		AllBlockItems.fillComposterList();
		AllItems.fillFurnaceFuelList();
		AllBlockItems.fillFurnaceFuelList();

		AllBlocks.registerFlammableBlocks();
		AllBlocks.registerStrippableBlocks();

		CreativeTabFiller.fillItemGroups();
		ModVillagerTrades.registerCustomTrades();
		ModLootTableModifiers.modifyLootTables();

		ModWorldGeneration.generateModWorldGen();
	}
}
