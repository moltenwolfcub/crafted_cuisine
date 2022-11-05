package com.moltenwolfcub.crafted_cuisine.init;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class AllPlacedFeatures {
    public static final Holder<PlacedFeature> CINNAMON_TREE_PLACED = PlacementUtils.register("cinnamon_tree_placed",
        AllConfiguredFeatures.CINNAMON_TREE_SPAWN, VegetationPlacements.treePlacement(
            PlacementUtils.countExtra(3, 0.5f, 1))
    );

    public static final Holder<PlacedFeature> PINK_ROSE_PLACED = PlacementUtils.register("pink_rose_placed",
        AllConfiguredFeatures.PINK_ROSE, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP, BiomeFilter.biome()
    );
    

    public static final Holder<PlacedFeature> BLACKSTONE_GRAVEL_PLACED = PlacementUtils.register(
        "blackstone_gravel_placed", AllConfiguredFeatures.ORE_BLACKSTONE_GRAVEL,
        commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()))
    );

  
    public static List<PlacementModifier> orePlacement(PlacementModifier chanceModifier, PlacementModifier positionModifier) {
        return List.of(chanceModifier, InSquarePlacement.spread(), positionModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int perChunk, PlacementModifier pos) {
        return orePlacement(CountPlacement.of(perChunk), pos);
    }

    public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier pos) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), pos);
    }
}
