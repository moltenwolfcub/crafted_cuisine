package com.moltenwolfcub.cooks_kitchen.item.util;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class ItemUtils {

    public static Item.Properties DefaultItemProperties = new Item.Properties().tab(CooksKitchen.TAB);
    public static Item.Properties NonStackableItemProperties = new Item.Properties().tab(CooksKitchen.TAB).stacksTo(1);

    public static void addToComposterList(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
    
}
