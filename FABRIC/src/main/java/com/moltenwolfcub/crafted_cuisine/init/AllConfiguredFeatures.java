package com.moltenwolfcub.crafted_cuisine.init;

import java.util.List;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class AllConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> CINNAMON_TREE =
        ConfiguredFeatures.register("cinnamon_tree", Feature.TREE, new TreeFeatureConfig.Builder(
        BlockStateProvider.of(AllBlocks.CINNAMON_LOG),
        new StraightTrunkPlacer(10, 6, 3),
        BlockStateProvider.of(AllBlocks.CINNAMON_LEAVES),
        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
        new TwoLayersFeatureSize(1, 0, 2)).build()
    );

    public static final RegistryEntry<PlacedFeature> CINNAMON_TREE_CHECKED =
        PlacedFeatures.register("cinnamon_tree_checked", CINNAMON_TREE,
        PlacedFeatures.wouldSurvive(AllBlocks.CINNAMON_SAPLING)
    );

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> CINNAMON_TREE_SPAWN =
        ConfiguredFeatures.register("cinnamon_tree_spawn", Feature.RANDOM_SELECTOR,
        new RandomFeatureConfig(List.of(new RandomFeatureEntry(CINNAMON_TREE_CHECKED, 0.5f)), 
        CINNAMON_TREE_CHECKED)
    ); 

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> PINK_ROSE =
        ConfiguredFeatures.register("flower_pink_rose", Feature.FLOWER,
        new RandomPatchFeatureConfig(32, 6, 2,
        PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
        new SimpleBlockFeatureConfig(BlockStateProvider.of(AllBlocks.PINK_ROSE))))
    );


    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_BLACKSTONE_GRAVEL = 
        ConfiguredFeatures.register("blackstone_gravel_ore", Feature.ORE, 
        new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, 
        AllBlocks.REINFORCED_BLACKSTONE_GRAVEL.getDefaultState(), 33)
    );
        
    public static void registerConfiguredFeatures() {
        CraftedCuisine.LOGGER.info("Registering Configured Features for " + CraftedCuisine.MODID);
    }
}
