package com.moltenwolfcub.crafted_cuisine.world.feature.tree;

import com.moltenwolfcub.crafted_cuisine.init.AllConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

//TODO rename class
public class CinnamonTreeGrower extends AbstractTreeGrower {

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlower) {
        return AllConfiguredFeatures.CINNAMON_TREE;
    }
    
}
