package com.moltenwolfcub.crafted_cuisine.world;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.world.gen.ModFlowerGeneration;
import com.moltenwolfcub.crafted_cuisine.world.gen.ModOreGeneration;
import com.moltenwolfcub.crafted_cuisine.world.gen.ModTreeGeneration;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CraftedCuisine.MODID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void BiomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);
        ModFlowerGeneration.generateFlowers(event);
    }
    
}
