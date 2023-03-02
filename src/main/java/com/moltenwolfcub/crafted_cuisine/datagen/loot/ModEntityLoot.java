package com.moltenwolfcub.crafted_cuisine.datagen.loot;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

import com.google.common.collect.Sets;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModEntityLoot extends EntityLootSubProvider {
    private final boolean strictValidation;

    protected ModEntityLoot() {
        super(FeatureFlags.REGISTRY.allFlags());
        strictValidation = true;
    }

    @Override
    public void generate() {
        this.add(AllEntityTypes.CLOAK, LootTable.lootTable());
    }


    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        this.generate();

        Set<ResourceLocation> allLocations = Sets.newHashSet();
        for (Map.Entry<EntityType<?>, Map<ResourceLocation, LootTable.Builder>> entityMaps : map.entrySet()) {
            for (Map.Entry<ResourceLocation, LootTable.Builder> entry : entityMaps.getValue().entrySet()) {
                ResourceLocation resourceLocation = entry.getKey();
                allLocations.add(resourceLocation);

                if (resourceLocation == BuiltInLootTables.EMPTY) {
                    continue;
                }
    
                biConsumer.accept(resourceLocation, entry.getValue());
            }
        }

		if (strictValidation) {
			Set<ResourceLocation> missing = Sets.newHashSet();

			for (ResourceLocation entityId : BuiltInRegistries.ENTITY_TYPE.keySet()) {
				if (!entityId.getNamespace().equals(CraftedCuisine.MODID)) {
                    continue;
                }
                ResourceLocation entityLootTableId = BuiltInRegistries.ENTITY_TYPE.get(entityId).getDefaultLootTable();


                if (!allLocations.contains(entityLootTableId)) {
                    missing.add(entityId);
                }
			}

			if (!missing.isEmpty()) {
				throw new IllegalStateException("Missing loot table(s) for %s".formatted(missing));
			}
		}
    }

}
