package com.moltenwolfcub.create_food.world;

import com.moltenwolfcub.create_food.CreateFood;
import com.moltenwolfcub.create_food.world.gen.ModTreeGeneration;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateFood.MODID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void BiomeLoadingEvent(final BiomeLoadingEvent event) {
        ModTreeGeneration.generateTrees(event);
    }
    
}
