package com.moltenwolfcub.crafted_cuisine;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;
import com.moltenwolfcub.crafted_cuisine.item.util.ModCreativeTabs;

public class CraftedCuisine implements ModInitializer {
	public static final String MODID = "crafted_cuisine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static final ItemGroup MAIN_TAB = ModCreativeTabs.MAIN_CREATIVE_TAB;

	@Override
	public void onInitialize() {
		AllItems.registerItems();
		AllBlocks.registerBlocks();
		AllBlockItems.registerBlockItems();
		
		AllItems.fillComposterList();
		AllBlockItems.fillComposterList();
		AllItems.fillFurnaceFuelList();
		AllBlockItems.fillFurnaceFuelList();

		AllBlocks.registerFlammableBlocks();
	}
}
