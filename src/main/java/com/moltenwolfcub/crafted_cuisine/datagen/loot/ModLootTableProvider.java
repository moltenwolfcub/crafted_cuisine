package com.moltenwolfcub.crafted_cuisine.datagen.loot;

import java.util.HashSet;
import java.util.List;

import com.moltenwolfcub.crafted_cuisine.loot.ModLootContextParamSets;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModLootTableProvider {
    
    public static LootTableProvider create(PackOutput packOutput) {
        return new LootTableProvider(packOutput, new HashSet<ResourceLocation>(), List.of(
            new LootTableProvider.SubProviderEntry(ModBlockLoot::new, LootContextParamSets.BLOCK),
            new LootTableProvider.SubProviderEntry(ModEntityLoot::new, LootContextParamSets.ENTITY),
            new LootTableProvider.SubProviderEntry(ModChestLoot::new, LootContextParamSets.CHEST),
            new LootTableProvider.SubProviderEntry(CustomLoot::new, ModLootContextParamSets.FRUIT_TREE)
        ));
    }
}
