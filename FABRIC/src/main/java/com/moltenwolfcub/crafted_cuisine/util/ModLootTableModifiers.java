package com.moltenwolfcub.crafted_cuisine.util;

import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier PLAINS_HOUSE_ID = new Identifier("chests/village/village_plains_house");
    private static final Identifier SAVANA_HOUSE_ID = new Identifier("chests/village/village_savanna_house");
    private static final Identifier DESERT_HOUSE_ID = new Identifier("chests/village/village_desert_house");
    private static final Identifier JUNGLE_TEMPLE_ID = new Identifier("chests/jungle_temple");

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

            LootPool.Builder basePool = LootPool.builder()
                .with(ItemEntry.builder(item))
                .conditionally(RandomChanceLootCondition.builder(additionChance))
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(minCount)).build());
    
            tableBuilder.pool(basePool);

        }
    
        int maxExtra = maxCount - minCount;
        for (int i = 0; i < maxExtra; i++) {

            tableBuilder.pool(
                LootPool.builder()
                    .with(ItemEntry.builder(item))
                    .conditionally(RandomChanceLootCondition.builder(additionChance))
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)).build())
            );

        }
        
    }
    
}
