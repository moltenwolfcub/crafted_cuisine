package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.FruitTreeBlock;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

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
        // addDrop(AllBlocks.AUTO_BLOWTORCH);
        // addDrop(AllBlocks.CARAMELISER);

        addDrop(AllBlocks.REINFORCED_BLACKSTONE);
        addDrop(AllBlocks.REINFORCED_BLACKSTONE_DOOR, BlockLootTableGenerator::addDoorDrop);
        addDrop(AllBlocks.REINFORCED_BLACKSTONE_LADDER);
        addDrop(AllBlocks.REINFORCED_BLACKSTONE_ROD);
        addDrop(AllBlocks.REINFORCED_BLACKSTONE_LEVER);
        addDrop(AllBlocks.REINFORCED_BLACKSTONE_BARS);
        addDrop(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR);
        //TODO: change the reinforced blackstone nugget to shard
        addDrop(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL, (Block block) -> 
            BlockLootTableGenerator.dropsWithSilkTouch(
                block, BlockLootTableGenerator.addSurvivesExplosionCondition(
                    block, (ItemEntry.builder(AllItems.REINFORCED_BLACKSTONE_NUGGET)
                        .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.1f, 0.14285715f, 0.25f, 1.0f)))
                        .alternatively(ItemEntry.builder(block))
                ))
        );

        addDrop(AllBlocks.RED_ROSE_CARPET);
        addDrop(AllBlocks.ORANGE_ROSE_CARPET);
        addDrop(AllBlocks.YELLOW_ROSE_CARPET);
        addDrop(AllBlocks.LIME_ROSE_CARPET);
        addDrop(AllBlocks.GREEN_ROSE_CARPET);
        addDrop(AllBlocks.BLUE_ROSE_CARPET);
        addDrop(AllBlocks.CYAN_ROSE_CARPET);
        addDrop(AllBlocks.LIGHT_BLUE_ROSE_CARPET);
        addDrop(AllBlocks.PURPLE_ROSE_CARPET);
        addDrop(AllBlocks.MAGENTA_ROSE_CARPET);
        addDrop(AllBlocks.PINK_ROSE_CARPET);
        addDrop(AllBlocks.WHITE_ROSE_CARPET);
        addDrop(AllBlocks.LIGHT_GRAY_ROSE_CARPET);
        addDrop(AllBlocks.GRAY_ROSE_CARPET);
        addDrop(AllBlocks.BLACK_ROSE_CARPET);
        addDrop(AllBlocks.BROWN_ROSE_CARPET);

        addDrop(AllBlocks.CINNAMON_BUTTON);
        addDrop(AllBlocks.CINNAMON_FENCE);
        addDrop(AllBlocks.CINNAMON_FENCE_GATE);
        addDrop(AllBlocks.CINNAMON_LOG);
        addDrop(AllBlocks.CINNAMON_PLANKS);
        addDrop(AllBlocks.CINNAMON_PRESSURE_PLATE);
        addDrop(AllBlocks.CINNAMON_SAPLING);
        addDrop(AllBlocks.CINNAMON_STAIRS);
        addDrop(AllBlocks.CINNAMON_TRAPDOOR);
        addDrop(AllBlocks.CINNAMON_WOOD);
        addDrop(AllBlocks.STRIPPED_CINNAMON_LOG);
        addDrop(AllBlocks.STRIPPED_CINNAMON_WOOD);
        addDrop(AllBlocks.CINNAMON_SIGN, AllItems.CINNAMON_SIGN);
        addDrop(AllBlocks.CINNAMON_WALL_SIGN, AllItems.CINNAMON_SIGN);
        addPottedPlantDrop(AllBlocks.POTTED_CINNAMON_SAPLING);
        addDrop(AllBlocks.CINNAMON_SLAB, BlockLootTableGenerator::slabDrops);
        addDrop(AllBlocks.CINNAMON_DOOR, BlockLootTableGenerator::addDoorDrop);
        addDrop(AllBlocks.CINNAMON_LEAVES, (block) -> {
            return leavesDrop(block, AllBlocks.CINNAMON_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
        });

        addDrop(AllBlocks.FLOWER_STEM);
        addDrop(AllBlocks.PINK_ROSE);
        addPottedPlantDrop(AllBlocks.POTTED_FLOWER_STEM);
        addPottedPlantDrop(AllBlocks.POTTED_PINK_ROSE);

        addDrop(AllBlocks.LEMON_TREE, ModBlockLootTableProvider::createFruitTreeTable);
        addDrop(AllBlocks.LIME_TREE, ModBlockLootTableProvider::createFruitTreeTable);
        addDrop(AllBlocks.ORANGE_TREE, ModBlockLootTableProvider::createFruitTreeTable);

        addDrop(AllBlocks.SAW_DUST, (block) -> {
            return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                .with(ItemEntry.builder(AllBlockItems.SAW_DUST)
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).conditionally(BlockStatePropertyLootCondition.builder(AllBlocks.SAW_DUST).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, 1))))
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0f)).conditionally(BlockStatePropertyLootCondition.builder(AllBlocks.SAW_DUST).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, 2))))
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3.0f)).conditionally(BlockStatePropertyLootCondition.builder(AllBlocks.SAW_DUST).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, 3))))
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4.0f)).conditionally(BlockStatePropertyLootCondition.builder(AllBlocks.SAW_DUST).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, 4))))
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(5.0f)).conditionally(BlockStatePropertyLootCondition.builder(AllBlocks.SAW_DUST).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, 5))))
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6.0f)).conditionally(BlockStatePropertyLootCondition.builder(AllBlocks.SAW_DUST).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, 6))))
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7.0f)).conditionally(BlockStatePropertyLootCondition.builder(AllBlocks.SAW_DUST).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, 7))))
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8.0f)).conditionally(BlockStatePropertyLootCondition.builder(AllBlocks.SAW_DUST).properties(StatePredicate.Builder.create().exactMatch(SnowBlock.LAYERS, 8))))
            ));
        });

        addDrop(AllFluids.CARAMEL_BLOCK, LootTable.builder());
        
    }

    public static LootTable.Builder createFruitTreeTable(Block block) {
        return dropsWithProperty(block, FruitTreeBlock.HALF, DoubleBlockHalf.LOWER);
    }
    
}
