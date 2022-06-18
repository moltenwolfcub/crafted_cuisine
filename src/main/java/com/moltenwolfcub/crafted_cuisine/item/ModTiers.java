package com.moltenwolfcub.crafted_cuisine.item;

import com.moltenwolfcub.crafted_cuisine.init.ModItems;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier REINFORCED_BLACKSTONE = new ForgeTier(
        2, 275, 5.5f, 1.5f, 8,
        BlockTags.NEEDS_IRON_TOOL, ()-> Ingredient.of(ModItems.REINFORCED_BLACKSTONE_INGOT.get())
    );
    
}
