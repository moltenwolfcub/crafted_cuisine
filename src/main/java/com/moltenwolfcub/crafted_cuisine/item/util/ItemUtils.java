package com.moltenwolfcub.crafted_cuisine.item.util;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class ItemUtils {

    public static void addToComposterList(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
    
}
