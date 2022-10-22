package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.effect.InvertMovementEffect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllEffects {

    public static final StatusEffect INVERTED_MOVEMENT = STATUS_EFFECTS.register("dizziness", 
        new InvertMovementEffect(StatusEffectCategory.HARMFUL, 8791571));


    public static class STATUS_EFFECTS{
        //this method is in a class for the simplicity of porting the forge project
        public static final StatusEffect register(String name, StatusEffect effect) {
            return Registry.register(Registry.STATUS_EFFECT, new Identifier(CraftedCuisine.MODID, name), effect);
        }
    }

    public static void registerEffects() {
        CraftedCuisine.LOGGER.info("Registering Effects for " + CraftedCuisine.MODID);
    }
}
