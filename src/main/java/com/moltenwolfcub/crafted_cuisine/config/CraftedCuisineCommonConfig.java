package com.moltenwolfcub.crafted_cuisine.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CraftedCuisineCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> BLOOD_ORANGE_CHANCE;

    static {
        BUILDER.push("Configs for Crafted Cuisine");

        BLOOD_ORANGE_CHANCE = BUILDER.comment("Chance of Blood Orange dropping from an orange tree E.G. 100 would be 1 in 100 chance")
            .define("bloodOrangeDropChance", 512);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
