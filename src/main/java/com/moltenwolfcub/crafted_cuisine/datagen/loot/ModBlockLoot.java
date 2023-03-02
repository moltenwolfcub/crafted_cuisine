package com.moltenwolfcub.crafted_cuisine.datagen.loot;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

import com.google.common.collect.Sets;
import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.blocks.FruitTreeBlock;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModBlockLoot extends BlockLootSubProvider {
    /*
     * Defines which blocks drop 100% of the time from creeper explosions.
     * In vanilla this would have things like shulker boxes, beacons and mob heads
     * Currently empty as I have no blocks that should have this behaviour.
     * 
     * @see VanillaBlockLoot if implementation is needed. (weird stream stuff is nessesary)
    */
    private static final Set<Item> EXPLOSION_RESISTANT = new HashSet<>();
    private final boolean strictValidation;

    protected ModBlockLoot() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
        strictValidation = true;
    }

    @Override
    public void generate() {
        dropSelf(AllBlocks.AUTO_BLOWTORCH);
        dropSelf(AllBlocks.CARAMELISER);

        dropSelf(AllBlocks.REINFORCED_BLACKSTONE);
        add(AllBlocks.REINFORCED_BLACKSTONE_DOOR, this::createDoorTable);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_LADDER);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_ROD);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_LEVER);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_BARS);
        dropSelf(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR);
        add(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL, (Block block) -> 
            ModBlockLoot.createSilkTouchDispatchTable(
                block, this.applyExplosionCondition(
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
        add(AllBlocks.CINNAMON_SLAB, this::createSlabItemTable);
        add(AllBlocks.CINNAMON_DOOR, this::createDoorTable);
        add(AllBlocks.CINNAMON_LEAVES, (block) -> {
            return createLeavesDrops(block, AllBlocks.CINNAMON_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES);
        });

        dropSelf(AllBlocks.FLOWER_STEM);
        dropSelf(AllBlocks.PINK_ROSE);
        dropPottedContents(AllBlocks.POTTED_FLOWER_STEM);
        dropPottedContents(AllBlocks.POTTED_PINK_ROSE);

        add(AllBlocks.LEMON_TREE, this::createFruitTreeTable);
        add(AllBlocks.LIME_TREE, this::createFruitTreeTable);
        add(AllBlocks.ORANGE_TREE, this::createFruitTreeTable);

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

    public LootTable.Builder createFruitTreeTable(Block block) {
        return this.createSinglePropConditionTable(block, FruitTreeBlock.HALF, DoubleBlockHalf.LOWER);
    }

    
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        this.generate();
        for (Map.Entry<ResourceLocation, LootTable.Builder> entry : map.entrySet()) {
			ResourceLocation resourceLocation = entry.getKey();

            if (resourceLocation == BuiltInLootTables.EMPTY) {
                continue;
            }

            biConsumer.accept(resourceLocation, entry.getValue());
        }

		if (strictValidation) {
			Set<ResourceLocation> missing = Sets.newHashSet();

			for (ResourceLocation blockId : BuiltInRegistries.BLOCK.keySet()) {
				if (!blockId.getNamespace().equals(CraftedCuisine.MODID)) {
                    continue;
                }
                ResourceLocation blockLootTableId = BuiltInRegistries.BLOCK.get(blockId).getLootTable();

                if (blockLootTableId.getNamespace().equals(CraftedCuisine.MODID)) {
                    if (!map.containsKey(blockLootTableId)) {
                        missing.add(blockId);
                    }
                }
			}

			if (!missing.isEmpty()) {
				throw new IllegalStateException("Missing loot table(s) for %s".formatted(missing));
			}
		}
    }

}
