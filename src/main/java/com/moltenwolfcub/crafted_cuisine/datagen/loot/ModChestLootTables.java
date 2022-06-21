package com.moltenwolfcub.crafted_cuisine.datagen.loot;

import java.util.function.BiConsumer;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;

import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModChestLootTables extends ChestLoot {

    private static final ResourceLocation BARK_CHEST = new ResourceLocation(CraftedCuisine.MODID, "chests/bark_chest");

    private static final ResourceLocation BASIC_BLACKSTONE_FORTRESS_CHEST = new ResourceLocation(CraftedCuisine.MODID, "chests/blackstone_fortress_basic");

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

        builder.accept(BASIC_BLACKSTONE_FORTRESS_CHEST, LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2.0f, 6.0f))
                .add(LootItem.lootTableItem(Items.BLACKSTONE)
                    .setWeight(20)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 20f)))
                )
                .add(LootItem.lootTableItem(ModItems.REINFORCED_BLACKSTONE_NUGGET.get())
                    .setWeight(18)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 18f)))
                )
                .add(LootItem.lootTableItem(ModItems.REINFORCED_BLACKSTONE_NUGGET.get())
                    .setWeight(18)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 18f)))
                )
                .add(LootItem.lootTableItem(ModItems.REINFORCED_BLACKSTONE_INGOT.get())
                    .setWeight(15)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 4f)))
                )
                .add(LootItem.lootTableItem(ModItems.REINFORCED_BLACKSTONE_SWORD.get())
                    .setWeight(13)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                    .apply(EnchantRandomlyFunction.randomApplicableEnchantment())
                )
                .add(LootItem.lootTableItem(Items.IRON_INGOT)
                    .setWeight(10)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 5f)))
                )
                .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                    .setWeight(8)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 3f)))
                )
                .add(LootItem.lootTableItem(Items.EMERALD)
                    .setWeight(5)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 4f)))
                )
                .add(LootItem.lootTableItem(ModBlockItems.REINFORCED_BLACKSTONE.get())
                    .setWeight(3)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)))
                )
                .add(LootItem.lootTableItem(Items.GILDED_BLACKSTONE)
                    .setWeight(2)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1f, 2f)))
                )
                .add(LootItem.lootTableItem(Items.DIAMOND)
                    .setWeight(1)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                )
            )
        );
    }
    
}
