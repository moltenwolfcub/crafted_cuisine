package com.moltenwolfcub.crafted_cuisine.world.gen;

import com.moltenwolfcub.crafted_cuisine.init.AllPlacedFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStep;

public class ModFlowerGeneration {
    
    public static void generateFlowers() {
        BiomeModifications.addFeature(
            BiomeSelectors.categories(Category.PLAINS),
            GenerationStep.Feature.VEGETAL_DECORATION, 
            AllPlacedFeatures.PINK_ROSE_PLACED.getKey().get()
        );
    }
    
}
