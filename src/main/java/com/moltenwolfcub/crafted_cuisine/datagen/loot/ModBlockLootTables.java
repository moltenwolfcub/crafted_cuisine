package com.moltenwolfcub.crafted_cuisine.datagen.loot;

import com.moltenwolfcub.crafted_cuisine.blocks.FruitTreeBlock;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.ModBlocks;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    
    @Override
    protected void addTables() {
        dropSelf(ModBlocks.AUTO_BLOWTORCH.get());
        dropSelf(ModBlocks.CARAMELISER.get());

        dropSelf(ModBlocks.REINFORCED_BLACKSTONE.get());
        add(ModBlocks.REINFORCED_BLACKSTONE_DOOR.get(), BlockLoot::createDoorTable);
        dropSelf(ModBlocks.REINFORCED_BLACKSTONE_LADDER.get());
        dropSelf(ModBlocks.REINFORCED_BLACKSTONE_ROD.get());

        dropSelf(ModBlocks.RED_ROSE_CARPET.get());
        dropSelf(ModBlocks.ORANGE_ROSE_CARPET.get());
        dropSelf(ModBlocks.YELLOW_ROSE_CARPET.get());
        dropSelf(ModBlocks.LIME_ROSE_CARPET.get());
        dropSelf(ModBlocks.GREEN_ROSE_CARPET.get());
        dropSelf(ModBlocks.BLUE_ROSE_CARPET.get());
        dropSelf(ModBlocks.CYAN_ROSE_CARPET.get());
        dropSelf(ModBlocks.LIGHT_BLUE_ROSE_CARPET.get());
        dropSelf(ModBlocks.PURPLE_ROSE_CARPET.get());
        dropSelf(ModBlocks.MAGENTA_ROSE_CARPET.get());
        dropSelf(ModBlocks.PINK_ROSE_CARPET.get());
        dropSelf(ModBlocks.WHITE_ROSE_CARPET.get());
        dropSelf(ModBlocks.LIGHT_GRAY_ROSE_CARPET.get());
        dropSelf(ModBlocks.GRAY_ROSE_CARPET.get());
        dropSelf(ModBlocks.BLACK_ROSE_CARPET.get());
        dropSelf(ModBlocks.BROWN_ROSE_CARPET.get());

        dropSelf(ModBlocks.CINNAMON_BUTTON.get());
        dropSelf(ModBlocks.CINNAMON_FENCE.get());
        dropSelf(ModBlocks.CINNAMON_FENCE_GATE.get());
        dropSelf(ModBlocks.CINNAMON_LOG.get());
        dropSelf(ModBlocks.CINNAMON_PLANKS.get());
        dropSelf(ModBlocks.CINNAMON_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.CINNAMON_SAPLING.get());
        dropSelf(ModBlocks.CINNAMON_STAIRS.get());
        dropSelf(ModBlocks.CINNAMON_TRAPDOOR.get());
        dropSelf(ModBlocks.CINNAMON_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_CINNAMON_LOG.get());
        dropSelf(ModBlocks.STRIPPED_CINNAMON_WOOD.get());
        dropOther(ModBlocks.CINNAMON_SIGN.get(), ModItems.CINNAMON_SIGN.get());
        dropOther(ModBlocks.CINNAMON_WALL_SIGN.get(), ModItems.CINNAMON_SIGN.get());
        dropPottedContents(ModBlocks.POTTED_CINNAMON_SAPLING.get());
        add(ModBlocks.CINNAMON_SLAB.get(), BlockLoot::createSlabItemTable);
        add(ModBlocks.CINNAMON_DOOR.get(), BlockLoot::createDoorTable);
        add(ModBlocks.CINNAMON_LEAVES.get(), (block) -> {
            return createLeavesDrops(block, ModBlocks.CINNAMON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES);
        });

        dropSelf(ModBlocks.FLOWER_STEM.get());
        dropSelf(ModBlocks.PINK_ROSE.get());
        dropPottedContents(ModBlocks.POTTED_FLOWER_STEM.get());
        dropPottedContents(ModBlocks.POTTED_PINK_ROSE.get());

        add(ModBlocks.LEMON_TREE.get(), ModBlockLootTables::createFruitTreeTable);
        add(ModBlocks.LIME_TREE.get(), ModBlockLootTables::createFruitTreeTable);
        add(ModBlocks.ORANGE_TREE.get(), ModBlockLootTables::createFruitTreeTable);

        this.add(ModBlocks.SAW_DUST.get(), (block) -> {
            return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModBlockItems.SAW_DUST_BLOCK_ITEM.get())
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 1))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 2))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 3))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 4))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 5))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 6))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 7))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 8))))
            ));
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


    public static LootTable.Builder createFruitTreeTable(Block block) {
        return createSinglePropConditionTable(block, FruitTreeBlock.HALF, DoubleBlockHalf.LOWER);
    }
}
