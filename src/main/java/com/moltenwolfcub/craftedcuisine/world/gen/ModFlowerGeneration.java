package com.moltenwolfcub.craftedcuisine.world.gen;

import com.moltenwolfcub.craftedcuisine.data.world.ModPlacedFeatureProvider;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModFlowerGeneration {
    
    public static void generateFlowers() {
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(Biomes.PLAINS),
            GenerationStep.Decoration.VEGETAL_DECORATION, 
            ModPlacedFeatureProvider.PINK_ROSE_PLACED_KEY
        );
    }
    
}
