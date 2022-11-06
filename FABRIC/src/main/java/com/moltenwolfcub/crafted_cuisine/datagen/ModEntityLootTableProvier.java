package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.function.BiConsumer;

import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModEntityLootTableProvier extends SimpleFabricLootTableProvider {
    
    public ModEntityLootTableProvier(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextParamSets.ENTITY);
    }

    @Override
    public void accept(BiConsumer<ResourceLocation, Builder> builder) {

        builder.accept(entityId(AllEntityTypes.CLOAK), LootTable.lootTable());
        
    }


    protected ResourceLocation entityId(EntityType<?> type){
        return type.getDefaultLootTable();
    }
    
}
