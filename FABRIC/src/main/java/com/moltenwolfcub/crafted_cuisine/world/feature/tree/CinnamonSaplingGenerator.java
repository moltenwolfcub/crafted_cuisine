package com.moltenwolfcub.crafted_cuisine.world.feature.tree;

import java.util.Random;

import com.moltenwolfcub.crafted_cuisine.init.AllConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

//TODO rename class
public class CinnamonSaplingGenerator extends AbstractTreeGrower {

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random var1, boolean var2) {
        return AllConfiguredFeatures.CINNAMON_TREE;
    }
    
}
