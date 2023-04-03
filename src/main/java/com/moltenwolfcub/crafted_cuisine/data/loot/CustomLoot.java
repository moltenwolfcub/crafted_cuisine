package com.moltenwolfcub.crafted_cuisine.data.loot;

import java.util.function.BiConsumer;

import com.moltenwolfcub.crafted_cuisine.block.FruitTreeBlock;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class CustomLoot implements LootTableSubProvider {

    @Override
    public void generate(BiConsumer<ResourceLocation, Builder> builder) {
        builder.accept(((FruitTreeBlock)AllBlocks.LEMON_TREE).getFruitLootTable(), LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(AllItems.LEMON).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 4.0f))))
            )
        );
        builder.accept(((FruitTreeBlock)AllBlocks.LIME_TREE).getFruitLootTable(), LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(AllItems.LIME).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 4.0f))))
            )
        );
        builder.accept(((FruitTreeBlock)AllBlocks.ORANGE_TREE).getFruitLootTable(), LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(AllItems.ORANGE).setWeight(127).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 4.0f))))
                .add(LootItem.lootTableItem(AllItems.BLOOD_ORANGE).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))))
            )
        );
    }
    
}
