package com.moltenwolfcub.crafted_cuisine.init;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class AllConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CINNAMON_TREE = 
        FeatureUtils.register("cinnamon_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(AllBlocks.CINNAMON_LOG.get()),
            new StraightTrunkPlacer(10, 6, 3),
            BlockStateProvider.simple(AllBlocks.CINNAMON_LEAVES.get()),
            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
            new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> CINNAMON_TREE_CHECKED =
        PlacementUtils.register("cinnamon_tree_checked", CINNAMON_TREE,
            PlacementUtils.filteredByBlockSurvival(AllBlocks.CINNAMON_SAPLING.get()));
    
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CINNAMON_TREE_SPAWN =
        FeatureUtils.register("cinnamon_tree_spawn", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(CINNAMON_TREE_CHECKED, 0.5f)), CINNAMON_TREE_CHECKED)); 
    

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PINK_ROSE =
        FeatureUtils.register("flower_pink_rose", Feature.FLOWER,
            new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(AllBlocks.PINK_ROSE.get())))));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_BLACKSTONE_GRAVEL = 
        FeatureUtils.register("blackstone_gravel_ore", Feature.ORE, 
            new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, AllBlocks.REINFORCED_BLACKSTONE_GRAVEL.get().defaultBlockState(), 33));
    
}
