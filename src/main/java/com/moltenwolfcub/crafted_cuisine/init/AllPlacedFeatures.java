package com.moltenwolfcub.crafted_cuisine.init;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class AllPlacedFeatures {
    public static final Holder<PlacedFeature> CINNAMON_TREE_PLACED = PlacementUtils.register("cinnamon_tree_placed",
        AllConfiguredFeatures.CINNAMON_TREE_SPAWN, VegetationPlacements.treePlacement(
            PlacementUtils.countExtra(3, 0.5f, 1)));

    public static final Holder<PlacedFeature> PINK_ROSE_PLACED = PlacementUtils.register("pink_rose_placed",
        AllConfiguredFeatures.PINK_ROSE, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(),
        PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    
}
