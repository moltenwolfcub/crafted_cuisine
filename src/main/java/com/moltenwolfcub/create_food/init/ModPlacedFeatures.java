package com.moltenwolfcub.create_food.init;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> CINNAMON_PLACED = PlacementUtils.register("cinnamon_placed",
        ModConfiguredFeatures.CINNAMON_SPAWN, VegetationPlacements.treePlacement(
            PlacementUtils.countExtra(3, 0.5f, 1)));
    
}
