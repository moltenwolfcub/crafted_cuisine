package com.moltenwolfcub.cooks_kitchen.world.feature.tree;

import java.util.Random;

import com.moltenwolfcub.cooks_kitchen.init.ModConfiguredFeatures;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CinnamonTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
        return ModConfiguredFeatures.CINNAMON_TREE;
    }
    
}
