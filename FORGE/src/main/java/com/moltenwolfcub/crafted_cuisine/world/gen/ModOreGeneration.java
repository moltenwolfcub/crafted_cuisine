package com.moltenwolfcub.crafted_cuisine.world.gen;

import java.util.List;

import com.moltenwolfcub.crafted_cuisine.init.AllPlacedFeatures;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES);

        base.add(AllPlacedFeatures.BLACKSTONE_GRAVEL_PLACED);
    }
}
