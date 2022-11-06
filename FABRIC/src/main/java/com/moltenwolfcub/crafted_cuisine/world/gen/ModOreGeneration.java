package com.moltenwolfcub.crafted_cuisine.world.gen;

import com.moltenwolfcub.crafted_cuisine.init.AllPlacedFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(), 
            GenerationStep.Decoration.UNDERGROUND_ORES, 
            AllPlacedFeatures.BLACKSTONE_GRAVEL_PLACED.unwrapKey().get()
        );
    }
}
