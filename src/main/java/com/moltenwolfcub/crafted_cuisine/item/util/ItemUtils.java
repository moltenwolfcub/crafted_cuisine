package com.moltenwolfcub.crafted_cuisine.item.util;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class ItemUtils {

    public static Item.Properties DefaultItemProperties = new Item.Properties().tab(CraftedCuisine.TAB);
    public static Item.Properties SixteenStackableItemProperties = new Item.Properties().tab(CraftedCuisine.TAB).stacksTo(16);
    public static Item.Properties NonStackableItemProperties = new Item.Properties().tab(CraftedCuisine.TAB).stacksTo(1);

    public static void addToComposterList(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
    
}
