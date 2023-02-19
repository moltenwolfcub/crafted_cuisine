package com.moltenwolfcub.crafted_cuisine.world.gen;

import com.moltenwolfcub.crafted_cuisine.init.AllPlacedFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModFlowerGeneration {
    
    public static void generateFlowers() {
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.PLAINS),
            GenerationStep.Decoration.VEGETAL_DECORATION, 
            AllPlacedFeatures.PINK_ROSE_PLACED_KEY
        );
    }
    
}
