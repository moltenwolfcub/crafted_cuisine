package com.moltenwolfcub.crafted_cuisine.init;

import java.util.List;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class AllPlacedFeatures {
    public static final ResourceKey<PlacedFeature> CINNAMON_TREE_CHECKED_KEY = registerKey("cinnamon_tree_checked");
    public static final ResourceKey<PlacedFeature> CINNAMON_TREE_PLACED_KEY = registerKey("cinnamon_tree_placed");

    public static final ResourceKey<PlacedFeature> PINK_ROSE_PLACED_KEY = registerKey("pink_rose_placed");

    public static final ResourceKey<PlacedFeature> BLACKSTONE_GRAVEL_PLACED_KEY = registerKey("blackstone_gravel_placed");

    
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredRegistryLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CINNAMON_TREE_CHECKED_KEY, configuredRegistryLookup.getOrThrow(AllConfiguredFeatures.CINNAMON_TREE_KEY),
            List.of(PlacementUtils.filteredByBlockSurvival(AllBlocks.CINNAMON_SAPLING)));

        register(context, CINNAMON_TREE_PLACED_KEY, configuredRegistryLookup.getOrThrow(AllConfiguredFeatures.CINNAMON_TREE_SPAWN_KEY),
            VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.5f, 1)));

        register(context, PINK_ROSE_PLACED_KEY, configuredRegistryLookup.getOrThrow(AllConfiguredFeatures.PINK_ROSE_KEY),
            List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, BLACKSTONE_GRAVEL_PLACED_KEY, configuredRegistryLookup.getOrThrow(AllConfiguredFeatures.ORE_BLACKSTONE_GRAVEL_KEY),
            commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
    }


    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CraftedCuisine.MODID, name));
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> void register(
            BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
            Holder<ConfiguredFeature<?, ?>> config, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }



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
