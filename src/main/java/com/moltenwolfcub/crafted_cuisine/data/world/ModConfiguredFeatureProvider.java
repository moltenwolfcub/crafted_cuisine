package com.moltenwolfcub.crafted_cuisine.data.world;

import java.util.List;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
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
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ModConfiguredFeatureProvider {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CINNAMON_TREE_KEY = registerKey("cinnamon_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CINNAMON_TREE_SPAWN_KEY = registerKey("cinnamon_tree_spawn");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_ROSE_KEY = registerKey("flower_pink_rose");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BLACKSTONE_GRAVEL_KEY = registerKey("blackstone_gravel_ore");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedRegistryLookup = context.lookup(Registries.PLACED_FEATURE);
        
        RuleTest deeplslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        register(context, CINNAMON_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(AllBlocks.CINNAMON_LOG),
            new StraightTrunkPlacer(10, 6, 3),
            BlockStateProvider.simple(AllBlocks.CINNAMON_LEAVES),
            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
            new TwoLayersFeatureSize(1, 0, 2)).build()
        );
        register(context, CINNAMON_TREE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
            new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                placedRegistryLookup.getOrThrow(ModPlacedFeatureProvider.CINNAMON_TREE_CHECKED_KEY), 0.5f)),
            placedRegistryLookup.getOrThrow(ModPlacedFeatureProvider.CINNAMON_TREE_CHECKED_KEY))
        );

        register(context, PINK_ROSE_KEY, Feature.FLOWER, new RandomPatchConfiguration(
            32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
            new SimpleBlockConfiguration(BlockStateProvider.simple(AllBlocks.PINK_ROSE))))
        );

        register(context, ORE_BLACKSTONE_GRAVEL_KEY, Feature.ORE, 
            new OreConfiguration(deeplslateReplacables, 
                AllBlocks.REINFORCED_BLACKSTONE_GRAVEL.defaultBlockState(), 33)
        );
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CraftedCuisine.MODID, name));
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature,C config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }

}
