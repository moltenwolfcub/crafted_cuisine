package com.moltenwolfcub.crafted_cuisine.loot;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;

import java.util.function.Consumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.Nullable;

public class ModLootContextParamSets {
    private static final BiMap<ResourceLocation, LootContextParamSet> REGISTRY = HashBiMap.create();
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

    @Nullable
    public static LootContextParamSet get(ResourceLocation resourceLocation) {
        return (LootContextParamSet)REGISTRY.get(resourceLocation);
    }

    @Nullable
    public static ResourceLocation getKey(LootContextParamSet lootContextParamSet) {
        return (ResourceLocation)REGISTRY.inverse().get(lootContextParamSet);
    }
}

