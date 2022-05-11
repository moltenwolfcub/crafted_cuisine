package com.moltenwolfcub.cooks_kitchen.datagen.loot;

import java.util.function.BiConsumer;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.init.ModItems;

import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModChestLootTables extends ChestLoot {

    private static final ResourceLocation BARK_CHEST = new ResourceLocation(CooksKitchen.MODID, "chests/bark_chest");

    @Override
    public void accept(BiConsumer<ResourceLocation, Builder> builder) {
        builder.accept(BARK_CHEST, LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 5.0F))
                .add(LootItem.lootTableItem(ModItems.ACACIA_BARK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 10.0f))))
                .add(LootItem.lootTableItem(ModItems.BIRCH_BARK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 10.0f))))
                .add(LootItem.lootTableItem(ModItems.DARK_OAK_BARK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 10.0f))))
                .add(LootItem.lootTableItem(ModItems.JUNGLE_BARK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 10.0f))))
                .add(LootItem.lootTableItem(ModItems.OAK_BARK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 10.0f))))
                .add(LootItem.lootTableItem(ModItems.SPRUCE_BARK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 10.0f))))
                .add(LootItem.lootTableItem(ModItems.CINNAMON_BARK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 10.0f))))
            )
        );
    }
    
}
