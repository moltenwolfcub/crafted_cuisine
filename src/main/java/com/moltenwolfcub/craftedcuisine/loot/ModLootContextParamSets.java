package com.moltenwolfcub.craftedcuisine.loot;

import java.util.function.Consumer;

import com.moltenwolfcub.craftedcuisine.CraftedCuisine;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class ModLootContextParamSets extends LootContextParamSets {
    public static final LootContextParamSet FRUIT_TREE = register(new ResourceLocation(CraftedCuisine.MODID, "fruit_tree"), builder -> builder
        .required(LootContextParams.BLOCK_STATE).required(LootContextParams.ORIGIN)
        .optional(LootContextParams.TOOL).optional(LootContextParams.THIS_ENTITY)
    );

    private static LootContextParamSet register(ResourceLocation typeLocation, Consumer<LootContextParamSet.Builder> consumer) {
        LootContextParamSet.Builder builder = new LootContextParamSet.Builder();
        consumer.accept(builder);
        LootContextParamSet lootParams = builder.build();
        LootContextParamSet mappedLootParams = REGISTRY.put(typeLocation, lootParams);
        if (mappedLootParams != null) {
            throw new IllegalStateException("Loot table parameter set " + typeLocation + " is already registered");
        }
        return lootParams;
    }
}

