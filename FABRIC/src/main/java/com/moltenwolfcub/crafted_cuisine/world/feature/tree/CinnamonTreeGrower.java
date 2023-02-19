package com.moltenwolfcub.crafted_cuisine.world.feature.tree;

import com.moltenwolfcub.crafted_cuisine.init.AllConfiguredFeatures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CinnamonTreeGrower extends AbstractTreeGrower {

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bees) {
        return AllConfiguredFeatures.CINNAMON_TREE_KEY;
    }    
}
