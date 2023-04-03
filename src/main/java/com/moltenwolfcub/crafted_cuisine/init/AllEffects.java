package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.effect.*;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class AllEffects {

    public static final MobEffect INVERTED_MOVEMENT = AllEffects.register("dizziness", 
        new InvertMovementEffect(MobEffectCategory.HARMFUL, 8791571));


    public static MobEffect register(String name, MobEffect effect) {
        return Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(CraftedCuisine.MODID, name), effect);
    }

    public static void registerEffects() {
        CraftedCuisine.LOGGER.info("Registering Effects for " + CraftedCuisine.MODID);
    }
}
