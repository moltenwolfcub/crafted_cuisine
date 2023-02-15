package com.moltenwolfcub.crafted_cuisine.world.gen;

import com.moltenwolfcub.crafted_cuisine.init.AllPlacedFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.JUNGLE), 
            GenerationStep.Decoration.VEGETAL_DECORATION, 
            AllPlacedFeatures.CINNAMON_TREE_PLACED.unwrapKey().get()
        );
    }
}
