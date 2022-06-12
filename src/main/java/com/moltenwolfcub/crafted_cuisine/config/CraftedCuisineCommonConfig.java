package com.moltenwolfcub.crafted_cuisine.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CraftedCuisineCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> FRUIT_TREE_RARE_DROP_CHANCE;

    static {
        BUILDER.push("Configs for Crafted Cuisine");

        FRUIT_TREE_RARE_DROP_CHANCE = BUILDER.comment("Chance of a Rare Item(Like a blood orange from orange tree) dropping from an fruit tree E.G. 100 would be 1 in 100 chance.")
            .define("fruitTreeRareDropChance", 512);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
