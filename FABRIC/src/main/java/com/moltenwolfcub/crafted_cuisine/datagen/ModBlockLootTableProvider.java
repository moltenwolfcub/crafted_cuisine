package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.FruitTreeBlock;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    protected ModBlockLootTableProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getName() {
        return "Loot Tables - Blocks: " + CraftedCuisine.MODID;
    }

    @Override
    protected void generateBlockLootTables() {
        dropSelf(AllBlocks.AUTO_BLOWTORCH);
        dropSelf(AllBlocks.CARAMELISER);

        dropSelf(AllBlocks.REINFORCED_BLACKSTONE);
        add(AllBlocks.REINFORCED_BLACKSTONE_DOOR, BlockLoot::createDoorTable);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_LADDER);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_ROD);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_LEVER);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_BARS);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR);
        add(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL, (Block block) -> 
            BlockLoot.createSilkTouchDispatchTable(
                block, BlockLoot.applyExplosionCondition(
                    block, (LootItem.lootTableItem(AllItems.REINFORCED_BLACKSTONE_SHARD)
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.1f, 0.14285715f, 0.25f, 1.0f)))
                        .otherwise(LootItem.lootTableItem(block))
                ))
        );

        dropSelf(AllBlocks.RED_ROSE_CARPET);
        dropSelf(AllBlocks.ORANGE_ROSE_CARPET);
        dropSelf(AllBlocks.YELLOW_ROSE_CARPET);
        dropSelf(AllBlocks.LIME_ROSE_CARPET);
        dropSelf(AllBlocks.GREEN_ROSE_CARPET);
        dropSelf(AllBlocks.BLUE_ROSE_CARPET);
        dropSelf(AllBlocks.CYAN_ROSE_CARPET);
        dropSelf(AllBlocks.LIGHT_BLUE_ROSE_CARPET);
        dropSelf(AllBlocks.PURPLE_ROSE_CARPET);
        dropSelf(AllBlocks.MAGENTA_ROSE_CARPET);
        dropSelf(AllBlocks.PINK_ROSE_CARPET);
        dropSelf(AllBlocks.WHITE_ROSE_CARPET);
        dropSelf(AllBlocks.LIGHT_GRAY_ROSE_CARPET);
        dropSelf(AllBlocks.GRAY_ROSE_CARPET);
        dropSelf(AllBlocks.BLACK_ROSE_CARPET);
        dropSelf(AllBlocks.BROWN_ROSE_CARPET);

        dropSelf(AllBlocks.CINNAMON_BUTTON);
        dropSelf(AllBlocks.CINNAMON_FENCE);
        dropSelf(AllBlocks.CINNAMON_FENCE_GATE);
        dropSelf(AllBlocks.CINNAMON_LOG);
        dropSelf(AllBlocks.CINNAMON_PLANKS);
        dropSelf(AllBlocks.CINNAMON_PRESSURE_PLATE);
        dropSelf(AllBlocks.CINNAMON_SAPLING);
        dropSelf(AllBlocks.CINNAMON_STAIRS);
        dropSelf(AllBlocks.CINNAMON_TRAPDOOR);
        dropSelf(AllBlocks.CINNAMON_WOOD);
        dropSelf(AllBlocks.STRIPPED_CINNAMON_LOG);
        dropSelf(AllBlocks.STRIPPED_CINNAMON_WOOD);
        dropOther(AllBlocks.CINNAMON_SIGN, AllItems.CINNAMON_SIGN);
        dropOther(AllBlocks.CINNAMON_WALL_SIGN, AllItems.CINNAMON_SIGN);
        dropPottedContents(AllBlocks.POTTED_CINNAMON_SAPLING);
        add(AllBlocks.CINNAMON_SLAB, BlockLoot::createSlabItemTable);
        add(AllBlocks.CINNAMON_DOOR, BlockLoot::createDoorTable);
        add(AllBlocks.CINNAMON_LEAVES, (block) -> {
            return createLeavesDrops(block, AllBlocks.CINNAMON_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
        });

        dropSelf(AllBlocks.FLOWER_STEM);
        dropSelf(AllBlocks.PINK_ROSE);
        dropPottedContents(AllBlocks.POTTED_FLOWER_STEM);
        dropPottedContents(AllBlocks.POTTED_PINK_ROSE);

        add(AllBlocks.LEMON_TREE, ModBlockLootTableProvider::createFruitTreeTable);
        add(AllBlocks.LIME_TREE, ModBlockLootTableProvider::createFruitTreeTable);
        add(AllBlocks.ORANGE_TREE, ModBlockLootTableProvider::createFruitTreeTable);

        dropSelf(AllBlocks.AUTO_BLOWTORCH);

        add(AllBlocks.SAW_DUST, (block) -> {
            return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f))
                .add(LootItem.lootTableItem(AllBlockItems.SAW_DUST)
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 1))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 2))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 3))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 4))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 5))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 6))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 7))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 8))))
            ));
        });

        add(AllFluids.CARAMEL_BLOCK, LootTable.lootTable());
        
    }

    public static LootTable.Builder createFruitTreeTable(Block block) {
        return createSinglePropConditionTable(block, FruitTreeBlock.HALF, DoubleBlockHalf.LOWER);
    }
    
}
