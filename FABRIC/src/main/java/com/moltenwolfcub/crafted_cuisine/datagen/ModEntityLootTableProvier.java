package com.moltenwolfcub.crafted_cuisine.datagen;

import java.util.function.BiConsumer;

import com.moltenwolfcub.crafted_cuisine.init.AllEntityTypes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

public class ModEntityLootTableProvier extends SimpleFabricLootTableProvider {
    
    public ModEntityLootTableProvier(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(BiConsumer<Identifier, Builder> builder) {

        builder.accept(entityId(AllEntityTypes.CLOAK), LootTable.builder());
        
    }


    protected Identifier entityId(EntityType<?> type){
        return type.getLootTableId();
    }
    
}
