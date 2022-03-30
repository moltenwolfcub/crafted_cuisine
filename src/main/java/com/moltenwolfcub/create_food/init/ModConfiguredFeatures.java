package com.moltenwolfcub.create_food.init;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CINNAMON_TREE = 
        FeatureUtils.register("cinnamon", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.CINNAMON_LOG.get()),
            new StraightTrunkPlacer(10, 6, 3),
            BlockStateProvider.simple(ModBlocks.CINNAMON_LEAVES.get()),
            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
            new TwoLayersFeatureSize(1, 0, 2)).build());
    
}
