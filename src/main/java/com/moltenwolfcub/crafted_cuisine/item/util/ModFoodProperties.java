package com.moltenwolfcub.crafted_cuisine.item.util;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties SUGAR_ROSE_PETAL = new FoodProperties.Builder()
        .nutrition(2).saturationMod(0.1f)
        .alwaysEat().fast()
        .build();
    
    public static final FoodProperties LEMON = new FoodProperties.Builder()
        .nutrition(3).saturationMod(0.1f)
        .effect(new MobEffectInstance(MobEffects.CONFUSION, 150, 1, true, false, true), 0.25f)
        .build();
    
    public static final FoodProperties LIME = new FoodProperties.Builder()
        .nutrition(1).saturationMod(0)
        .effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1, true, false, true), 0.6f)
        .build();
    
    public static final FoodProperties ORANGE = new FoodProperties.Builder()
        .nutrition(6).saturationMod(0.3f)
        .build();

    public static final FoodProperties BLOOD_ORANGE = new FoodProperties.Builder()
        .nutrition(8).saturationMod(1)
        .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1800, 1, true, false, true), 1)
        .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 1, true, false, true), 1)
        .build();
    
    public static final FoodProperties MERINGUE = new FoodProperties.Builder()
        .nutrition(5).saturationMod(0.4f)
        .build();
    
    public static final FoodProperties CARAMEL = new FoodProperties.Builder()
        .nutrition(5).saturationMod(0.5f)
        .build();
    
}
