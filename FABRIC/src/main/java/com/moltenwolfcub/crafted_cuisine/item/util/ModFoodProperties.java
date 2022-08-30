package com.moltenwolfcub.crafted_cuisine.item.util;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodProperties {

    public static final FoodComponent SUGAR_ROSE_PETAL = new FoodComponent.Builder()
        .hunger(2).saturationModifier(0.1f)
        .alwaysEdible().snack()
        .build();
    
    public static final FoodComponent LEMON = new FoodComponent.Builder()
        .hunger(3).saturationModifier(0.1f)
        .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 150, 1, true, false, true), 0.25f)
        .build();
    
    public static final FoodComponent LIME = new FoodComponent.Builder()
        .hunger(1).saturationModifier(0)
        .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1, true, false, true), 0.6f)
        .build();
    
    public static final FoodComponent ORANGE = new FoodComponent.Builder()
        .hunger(6).saturationModifier(0.3f)
        .build();

    public static final FoodComponent BLOOD_ORANGE = new FoodComponent.Builder()
        .hunger(8).saturationModifier(1)
        .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1800, 1, true, false, true), 1)
        .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 300, 1, true, false, true), 1)
        .build();
    
    public static final FoodComponent MERINGUE = new FoodComponent.Builder()
        .hunger(5).saturationModifier(0.4f)
        .build();
    
    public static final FoodComponent CARAMEL = new FoodComponent.Builder()
        .hunger(5).saturationModifier(0.5f)
        .build();
    
}
