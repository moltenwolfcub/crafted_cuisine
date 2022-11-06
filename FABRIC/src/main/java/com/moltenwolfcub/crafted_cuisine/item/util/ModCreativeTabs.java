package com.moltenwolfcub.crafted_cuisine.item.util;

import java.util.function.Supplier;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.impl.item.group.ItemGroupExtensions;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {

    public static final CreativeModeTab MAIN_CREATIVE_TAB = register(CraftedCuisine.MODID, () -> new ItemStack(AllItems.CARAMEL_BUCKET));


	public static CreativeModeTab register(String name, Supplier<ItemStack> icon) {
		((ItemGroupExtensions) CreativeModeTab.TAB_BUILDING_BLOCKS).fabric_expandArray();

		return new CreativeModeTab(CreativeModeTab.TABS.length - 1, name) {

			@Override
			public ItemStack makeIcon() {
				return icon.get();
			}

		};
	}
}

