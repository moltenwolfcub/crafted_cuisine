package com.moltenwolfcub.craftedcuisine.util;

import com.moltenwolfcub.craftedcuisine.init.AllItems;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;


public class ModLootTableModifiers {
    private static final ResourceLocation PLAINS_HOUSE_ID = new ResourceLocation("chests/village/village_plains_house");
    private static final ResourceLocation SAVANA_HOUSE_ID = new ResourceLocation("chests/village/village_savanna_house");
    private static final ResourceLocation DESERT_HOUSE_ID = new ResourceLocation("chests/village/village_desert_house");
    private static final ResourceLocation JUNGLE_TEMPLE_ID = new ResourceLocation("chests/jungle_temple");

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if (PLAINS_HOUSE_ID.equals(id) && source.isBuiltin()) {
                registerItemToTable(tableBuilder, AllItems.LEMON, 0.5f, 0, 3);
                registerItemToTable(tableBuilder, AllItems.LIME, 0.35f, 0, 2);
                registerItemToTable(tableBuilder, AllItems.ORANGE, 0.6f, 0, 6);
            }
            if (SAVANA_HOUSE_ID.equals(id) && source.isBuiltin()) {
                registerItemToTable(tableBuilder, AllItems.LEMON, 0.8f, 1, 6);
                registerItemToTable(tableBuilder, AllItems.LIME, 0.7f, 0, 4);
                registerItemToTable(tableBuilder, AllItems.ORANGE, 0.9f, 1, 9);
            }
            if (DESERT_HOUSE_ID.equals(id) && source.isBuiltin()) {
                registerItemToTable(tableBuilder, AllItems.LEMON, 0.75f, 0, 5);
                registerItemToTable(tableBuilder, AllItems.LIME, 0.65f, 0, 4);
                registerItemToTable(tableBuilder, AllItems.ORANGE, 0.8f, 0, 8);
            }

            if (JUNGLE_TEMPLE_ID.equals(id) && source.isBuiltin()) {
                registerItemToTable(tableBuilder, AllItems.JUNGLE_BARK, 0.7f, 0, 3);
                registerItemToTable(tableBuilder, AllItems.OAK_BARK, 0.5f, 0, 2);
            }

        });
    }

    public static void registerItemToTable(LootTable.Builder tableBuilder, Item item, float additionChance, int minCount, int maxCount) {
        if (minCount > 0) {

            LootPool.Builder basePool = LootPool.lootPool()
                .add(LootItem.lootTableItem(item))
                .when(LootItemRandomChanceCondition.randomChance(additionChance))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(minCount)).build());
    
            tableBuilder.withPool(basePool);

        }
    
        int maxExtra = maxCount - minCount;
        for (int i = 0; i < maxExtra; i++) {

            tableBuilder.withPool(
                LootPool.lootPool()
                    .add(LootItem.lootTableItem(item))
                    .when(LootItemRandomChanceCondition.randomChance(additionChance))
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)).build())
            );

        }
        
    }
    
}
