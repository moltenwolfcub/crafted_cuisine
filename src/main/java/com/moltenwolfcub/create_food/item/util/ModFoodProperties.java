package com.moltenwolfcub.create_food.item.util;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties SUGAR_ROSE_PETAL = new FoodProperties.Builder()
        .nutrition(2).saturationMod(1.5f)
        .build();
    
    public static final FoodProperties LEMON = new FoodProperties.Builder()
        .nutrition(4).saturationMod(1)
        .effect(()-> new MobEffectInstance(MobEffects.CONFUSION, 150, 1, true, false, true), 0.25f)
        .build();
    
}
