package com.moltenwolfcub.crafted_cuisine.world.feature.tree;

import java.util.Random;

import com.moltenwolfcub.crafted_cuisine.init.AllConfiguredFeatures;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class CinnamonSaplingGenerator extends SaplingGenerator {

    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random var1, boolean var2) {
        return AllConfiguredFeatures.CINNAMON_TREE;
    }
    
}
