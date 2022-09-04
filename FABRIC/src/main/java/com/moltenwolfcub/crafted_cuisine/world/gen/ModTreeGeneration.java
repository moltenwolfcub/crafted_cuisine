package com.moltenwolfcub.crafted_cuisine.world.gen;

import com.moltenwolfcub.crafted_cuisine.init.AllPlacedFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(
            BiomeSelectors.categories(Category.JUNGLE), 
            GenerationStep.Feature.VEGETAL_DECORATION, 
            AllPlacedFeatures.CINNAMON_TREE_PLACED.getKey().get()
        );
    }
}
