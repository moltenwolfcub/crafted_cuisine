package com.moltenwolfcub.craftedcuisine.world.gen;

import com.moltenwolfcub.craftedcuisine.data.world.ModPlacedFeatureProvider;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(), 
            GenerationStep.Decoration.UNDERGROUND_ORES, 
            ModPlacedFeatureProvider.BLACKSTONE_GRAVEL_PLACED_KEY
        );
    }
}
