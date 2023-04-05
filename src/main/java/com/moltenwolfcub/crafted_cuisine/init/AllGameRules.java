package com.moltenwolfcub.crafted_cuisine.init;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules.BooleanValue;
import net.minecraft.world.level.GameRules.Category;
import net.minecraft.world.level.GameRules.Key;

public class AllGameRules {
    public static final Key<BooleanValue> RULE_LAVA_SOURCE_CONVERSION =GameRuleRegistry.register(
        "caramelSourceConversion",
        Category.UPDATES,
        GameRuleFactory.createBooleanRule(false)
    );

    public static void registerGameRules() {
        CraftedCuisine.LOGGER.info("Registering Gamerules for " + CraftedCuisine.MODID);
    }
    
}
