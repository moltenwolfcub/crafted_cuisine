package com.moltenwolfcub.crafted_cuisine.init;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class AllPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> CINNAMON_TREE_PLACED = PlacedFeatures.register("cinnamon_tree_placed",
        AllConfiguredFeatures.CINNAMON_TREE_SPAWN, VegetationPlacedFeatures.modifiers(
            PlacedFeatures.createCountExtraModifier(3, 0.5f, 1)));

    // public static final RegistryEntry<PlacedFeature> PINK_ROSE_PLACED = PlacedFeatures.register("pink_rose_placed",
    //     AllConfiguredFeatures.PINK_ROSE, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(),
    //         PlacedFeatures.HEIGHTMAP, BiomeFilter.biome());
    

    // public static final RegistryEntry<PlacedFeature> BLACKSTONE_GRAVEL_PLACED = PlacedFeatures.register(
    //     "blackstone_gravel_placed", AllConfiguredFeatures.ORE_BLACKSTONE_GRAVEL,
    //     commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()))
    // );


    // public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
    //     return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    // }

    // public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
    //     return modifiers(CountPlacementModifier.of(count), heightModifier);
    // }

    // public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
    //     return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    // }
}