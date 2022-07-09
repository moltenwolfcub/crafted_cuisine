package com.moltenwolfcub.crafted_cuisine.datagen.loot;

import com.moltenwolfcub.crafted_cuisine.blocks.FruitTreeBlock;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

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
        dropSelf(AllBlocks.AUTO_BLOWTORCH.get());
        dropSelf(AllBlocks.CARAMELISER.get());

        dropSelf(AllBlocks.REINFORCED_BLACKSTONE.get());
        add(AllBlocks.REINFORCED_BLACKSTONE_DOOR.get(), BlockLoot::createDoorTable);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_LADDER.get());
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_ROD.get());
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_LEVER.get());

        dropSelf(AllBlocks.RED_ROSE_CARPET.get());
        dropSelf(AllBlocks.ORANGE_ROSE_CARPET.get());
        dropSelf(AllBlocks.YELLOW_ROSE_CARPET.get());
        dropSelf(AllBlocks.LIME_ROSE_CARPET.get());
        dropSelf(AllBlocks.GREEN_ROSE_CARPET.get());
        dropSelf(AllBlocks.BLUE_ROSE_CARPET.get());
        dropSelf(AllBlocks.CYAN_ROSE_CARPET.get());
        dropSelf(AllBlocks.LIGHT_BLUE_ROSE_CARPET.get());
        dropSelf(AllBlocks.PURPLE_ROSE_CARPET.get());
        dropSelf(AllBlocks.MAGENTA_ROSE_CARPET.get());
        dropSelf(AllBlocks.PINK_ROSE_CARPET.get());
        dropSelf(AllBlocks.WHITE_ROSE_CARPET.get());
        dropSelf(AllBlocks.LIGHT_GRAY_ROSE_CARPET.get());
        dropSelf(AllBlocks.GRAY_ROSE_CARPET.get());
        dropSelf(AllBlocks.BLACK_ROSE_CARPET.get());
        dropSelf(AllBlocks.BROWN_ROSE_CARPET.get());

        dropSelf(AllBlocks.CINNAMON_BUTTON.get());
        dropSelf(AllBlocks.CINNAMON_FENCE.get());
        dropSelf(AllBlocks.CINNAMON_FENCE_GATE.get());
        dropSelf(AllBlocks.CINNAMON_LOG.get());
        dropSelf(AllBlocks.CINNAMON_PLANKS.get());
        dropSelf(AllBlocks.CINNAMON_PRESSURE_PLATE.get());
        dropSelf(AllBlocks.CINNAMON_SAPLING.get());
        dropSelf(AllBlocks.CINNAMON_STAIRS.get());
        dropSelf(AllBlocks.CINNAMON_TRAPDOOR.get());
        dropSelf(AllBlocks.CINNAMON_WOOD.get());
        dropSelf(AllBlocks.STRIPPED_CINNAMON_LOG.get());
        dropSelf(AllBlocks.STRIPPED_CINNAMON_WOOD.get());
        dropOther(AllBlocks.CINNAMON_SIGN.get(), AllItems.CINNAMON_SIGN.get());
        dropOther(AllBlocks.CINNAMON_WALL_SIGN.get(), AllItems.CINNAMON_SIGN.get());
        dropPottedContents(AllBlocks.POTTED_CINNAMON_SAPLING.get());
        add(AllBlocks.CINNAMON_SLAB.get(), BlockLoot::createSlabItemTable);
        add(AllBlocks.CINNAMON_DOOR.get(), BlockLoot::createDoorTable);
        add(AllBlocks.CINNAMON_LEAVES.get(), (block) -> {
            return createLeavesDrops(block, AllBlocks.CINNAMON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES);
        });

        dropSelf(AllBlocks.FLOWER_STEM.get());
        dropSelf(AllBlocks.PINK_ROSE.get());
        dropPottedContents(AllBlocks.POTTED_FLOWER_STEM.get());
        dropPottedContents(AllBlocks.POTTED_PINK_ROSE.get());

        add(AllBlocks.LEMON_TREE.get(), ModBlockLootTables::createFruitTreeTable);
        add(AllBlocks.LIME_TREE.get(), ModBlockLootTables::createFruitTreeTable);
        add(AllBlocks.ORANGE_TREE.get(), ModBlockLootTables::createFruitTreeTable);

        this.add(AllBlocks.SAW_DUST.get(), (block) -> {
            return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(AllBlockItems.SAW_DUST.get())
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 1))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 2))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 3))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 4))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 5))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 6))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 7))))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0f)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(AllBlocks.SAW_DUST.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 8))))
            ));
        });
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return AllBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


    public static LootTable.Builder createFruitTreeTable(Block block) {
        return createSinglePropConditionTable(block, FruitTreeBlock.HALF, DoubleBlockHalf.LOWER);
    }
}
