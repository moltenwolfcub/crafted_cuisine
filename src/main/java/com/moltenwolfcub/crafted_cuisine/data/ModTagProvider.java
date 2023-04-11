package com.moltenwolfcub.crafted_cuisine.data;

import java.util.concurrent.CompletableFuture;

import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

@SuppressWarnings("unchecked")
public class ModTagProvider{
    
    public static class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

        public ModItemTagProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(dataOutput, registriesFuture);
        }

        @Override
        public void addTags(HolderLookup.Provider registriesFuture) {
            addModTags();
            addVanillaTags();
            addCommonTags();
            fillExistingCommonTags();
        }

        public void addTagsToTag(TagKey<Item> mainTag, TagKey<Item>... addingTags) {
            FabricTagBuilder tagBuilder = getOrCreateTagBuilder(mainTag);

            for (TagKey<Item> tag : addingTags) {
                tagBuilder.addTag(tag);
            }
        }

        private void addModTags() {
            getOrCreateTagBuilder(AllTags.Items.CINNAMON_LOGS).add(
                AllBlockItems.CINNAMON_LOG,
                AllBlockItems.CINNAMON_WOOD,
                AllBlockItems.STRIPPED_CINNAMON_LOG,
                AllBlockItems.STRIPPED_CINNAMON_WOOD
            );
        }
        
        private void addVanillaTags() {
            getOrCreateTagBuilder(ItemTags.LEAVES).add(AllBlockItems.CINNAMON_LEAVES);
            getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(AllTags.Items.CINNAMON_LOGS);
            getOrCreateTagBuilder(ItemTags.PLANKS).add(AllBlockItems.CINNAMON_PLANKS);
            getOrCreateTagBuilder(ItemTags.SAPLINGS).add(AllBlockItems.CINNAMON_SAPLING);
            getOrCreateTagBuilder(ItemTags.SIGNS).add(AllItems.CINNAMON_SIGN);
            getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(AllBlockItems.CINNAMON_BUTTON);
            getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(AllBlockItems.CINNAMON_DOOR);
            getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(AllBlockItems.CINNAMON_FENCE);
            getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(AllBlockItems.CINNAMON_FENCE_GATE);
            getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(AllBlockItems.CINNAMON_PRESSURE_PLATE);
            getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(AllBlockItems.CINNAMON_SLAB);
            getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(AllBlockItems.CINNAMON_STAIRS);
            getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(AllBlockItems.CINNAMON_TRAPDOOR);

            getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS).add(AllBlockItems.PINK_ROSE, AllBlockItems.FLOWER_STEM);

            getOrCreateTagBuilder(ItemTags.SWORDS).add(AllItems.REINFORCED_BLACKSTONE_SWORD);
            getOrCreateTagBuilder(ItemTags.PICKAXES).add(AllItems.REINFORCED_BLACKSTONE_PICKAXE);
            getOrCreateTagBuilder(ItemTags.AXES).add(AllItems.REINFORCED_BLACKSTONE_AXE);
            getOrCreateTagBuilder(ItemTags.SHOVELS).add(AllItems.REINFORCED_BLACKSTONE_SHOVEL);
            getOrCreateTagBuilder(ItemTags.HOES).add(AllItems.REINFORCED_BLACKSTONE_HOE);

            getOrCreateTagBuilder(ItemTags.CREEPER_IGNITERS).add(AllItems.BLOW_TORCH);
        }
    
        private void addCommonTags() {

            getOrCreateTagBuilder(AllTags.Items.PAPER_PULP).add(
                AllItems.PAPER_PULP
            );

            addTagsToTag(AllTags.Items.BARK,
                AllTags.Items.ACACIA_BARK,
                AllTags.Items.BIRCH_BARK,
                AllTags.Items.CINNAMON_BARK,
                AllTags.Items.CRIMSON_BARK,
                AllTags.Items.DARK_OAK_BARK,
                AllTags.Items.JUNGLE_BARK,
                AllTags.Items.OAK_BARK,
                AllTags.Items.SPRUCE_BARK,
                AllTags.Items.WARPED_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.BARK).add(
                AllItems.UNKNOWN_BARK
            );

            getOrCreateTagBuilder(AllTags.Items.ACACIA_BARK).add(
                AllItems.ACACIA_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.BIRCH_BARK).add(
                AllItems.BIRCH_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.CINNAMON_BARK).add(
                AllItems.CINNAMON_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.CRIMSON_BARK).add(
                AllItems.CRIMSON_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.DARK_OAK_BARK).add(
                AllItems.DARK_OAK_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.JUNGLE_BARK).add(
                AllItems.JUNGLE_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.MANGROVE_BARK).add(
                AllItems.MANGROVE_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.OAK_BARK).add(
                AllItems.OAK_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.SPRUCE_BARK).add(
                AllItems.SPRUCE_BARK
            );
            getOrCreateTagBuilder(AllTags.Items.WARPED_BARK).add(
                AllItems.WARPED_BARK
            );

            addTagsToTag(AllTags.Items.ROSE_CARPETS,
                AllTags.Items.RED_ROSE_CARPETS,
                AllTags.Items.ORANGE_ROSE_CARPETS,
                AllTags.Items.YELLOW_ROSE_CARPETS,
                AllTags.Items.LIME_ROSE_CARPETS,
                AllTags.Items.GREEN_ROSE_CARPETS,
                AllTags.Items.BLUE_ROSE_CARPETS,
                AllTags.Items.CYAN_ROSE_CARPETS,
                AllTags.Items.LIGHT_BLUE_ROSE_CARPETS,
                AllTags.Items.PURPLE_ROSE_CARPETS,
                AllTags.Items.MAGENTA_ROSE_CARPETS,
                AllTags.Items.PINK_ROSE_CARPETS,
                AllTags.Items.BLACK_ROSE_CARPETS,
                AllTags.Items.GRAY_ROSE_CARPETS,
                AllTags.Items.LIGHT_GRAY_ROSE_CARPETS,
                AllTags.Items.WHITE_ROSE_CARPETS,
                AllTags.Items.BROWN_ROSE_CARPETS
            );
            getOrCreateTagBuilder(AllTags.Items.RED_ROSE_CARPETS).add(AllBlockItems.RED_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.ORANGE_ROSE_CARPETS).add(AllBlockItems.ORANGE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.YELLOW_ROSE_CARPETS).add(AllBlockItems.YELLOW_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.LIME_ROSE_CARPETS).add(AllBlockItems.LIME_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.GREEN_ROSE_CARPETS).add(AllBlockItems.GREEN_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.BLUE_ROSE_CARPETS).add(AllBlockItems.BLUE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.CYAN_ROSE_CARPETS).add(AllBlockItems.CYAN_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.LIGHT_BLUE_ROSE_CARPETS).add(AllBlockItems.LIGHT_BLUE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.PURPLE_ROSE_CARPETS).add(AllBlockItems.PURPLE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.MAGENTA_ROSE_CARPETS).add(AllBlockItems.MAGENTA_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.PINK_ROSE_CARPETS).add(AllBlockItems.PINK_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.BLACK_ROSE_CARPETS).add(AllBlockItems.BLACK_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.GRAY_ROSE_CARPETS).add(AllBlockItems.GRAY_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.LIGHT_GRAY_ROSE_CARPETS).add(AllBlockItems.LIGHT_GRAY_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.WHITE_ROSE_CARPETS).add(AllBlockItems.WHITE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Items.BROWN_ROSE_CARPETS).add(AllBlockItems.BROWN_ROSE_CARPET);

            addTagsToTag(AllTags.Items.PETALS,
                AllTags.Items.RED_PETALS,
                AllTags.Items.ORANGE_PETALS,
                AllTags.Items.YELLOW_PETALS,
                AllTags.Items.LIME_PETALS,
                AllTags.Items.GREEN_PETALS,
                AllTags.Items.BLUE_PETALS,
                AllTags.Items.CYAN_PETALS,
                AllTags.Items.LIGHT_BLUE_PETALS,
                AllTags.Items.PURPLE_PETALS,
                AllTags.Items.MAGENTA_PETALS,
                AllTags.Items.PINK_PETALS,
                AllTags.Items.BLACK_PETALS,
                AllTags.Items.GRAY_PETALS,
                AllTags.Items.LIGHT_GRAY_PETALS,
                AllTags.Items.WHITE_PETALS,
                AllTags.Items.BROWN_PETALS
            );
            getOrCreateTagBuilder(AllTags.Items.RED_PETALS).add(AllItems.RED_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.ORANGE_PETALS).add(AllItems.ORANGE_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.YELLOW_PETALS).add(AllItems.YELLOW_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.LIME_PETALS).add(AllItems.LIME_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.GREEN_PETALS).add(AllItems.GREEN_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.BLUE_PETALS).add(AllItems.BLUE_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.CYAN_PETALS).add(AllItems.CYAN_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.LIGHT_BLUE_PETALS).add(AllItems.LIGHT_BLUE_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.PURPLE_PETALS).add(AllItems.PURPLE_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.MAGENTA_PETALS).add(AllItems.MAGENTA_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.PINK_PETALS).add(AllItems.PINK_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.BLACK_PETALS).add(AllItems.BLACK_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.GRAY_PETALS).add(AllItems.GRAY_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.LIGHT_GRAY_PETALS).add(AllItems.LIGHT_GRAY_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.WHITE_PETALS).add(AllItems.WHITE_ROSE_PETAL);
            getOrCreateTagBuilder(AllTags.Items.BROWN_PETALS).add(AllItems.BROWN_ROSE_PETAL);


            getOrCreateTagBuilder(AllTags.Items.EGG_YOLK).add(AllItems.EGG_YOLK);
            getOrCreateTagBuilder(AllTags.Items.EGG_WHITE).add(AllItems.EGG_WHITE);
            getOrCreateTagBuilder(AllTags.Items.CINNAMON).add(AllItems.CINNAMON);
            getOrCreateTagBuilder(AllTags.Items.CRUSHED_CINNAMON).add(AllItems.CRUSHED_CINNAMON);
            getOrCreateTagBuilder(AllTags.Items.BLOW_TORCHES).add(AllItems.BLOW_TORCH);
            getOrCreateTagBuilder(AllTags.Items.RAW_MERINGUE).add(AllItems.RAW_MERINGUE);
            getOrCreateTagBuilder(AllTags.Items.MERINGUE).add(AllItems.MERINGUE);
            getOrCreateTagBuilder(AllTags.Items.SUGAR).add(Items.SUGAR);
            getOrCreateTagBuilder(AllTags.Common.Items.BUTTER).add(AllItems.BUTTER);
            getOrCreateTagBuilder(AllTags.Items.CREAM).add(AllItems.CREAM);
            getOrCreateTagBuilder(AllTags.Common.Items.CARAMEL).add(AllItems.CARAMEL);

            getOrCreateTagBuilder(AllTags.Common.Items.FRUIT_LEMONS).add(AllItems.LEMON);
            getOrCreateTagBuilder(AllTags.Common.Items.FRUIT_LIMES).add(AllItems.LIME);
            getOrCreateTagBuilder(AllTags.Common.Items.FRUIT_ORANGES).add(AllItems.ORANGE, AllItems.BLOOD_ORANGE);

            getOrCreateTagBuilder(AllTags.Items.INGOTS_REINFORCED_BLACKSONE).add(AllItems.REINFORCED_BLACKSTONE_INGOT);
            getOrCreateTagBuilder(AllTags.Items.RODS_REINFORCED_BLACKSONE).add(AllItems.REINFORCED_BLACKSTONE_STICK);
            getOrCreateTagBuilder(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE).add(AllItems.REINFORCED_BLACKSTONE_NUGGET);
            getOrCreateTagBuilder(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE).add(AllBlockItems.REINFORCED_BLACKSTONE);
            getOrCreateTagBuilder(AllTags.Items.REINFORCED_BLACKSTONE_SHARD).add(AllItems.REINFORCED_BLACKSTONE_SHARD);
        }

        private void fillExistingCommonTags() {
            getOrCreateTagBuilder(AllTags.Common.Items.WOODEN_RODS).add(Items.STICK);
            getOrCreateTagBuilder(AllTags.Common.Items.IRON_NUGGETS).add(Items.IRON_NUGGET);
            getOrCreateTagBuilder(AllTags.Common.Items.POLISHED_BLACKSTONE).add(Items.POLISHED_BLACKSTONE);
            getOrCreateTagBuilder(AllTags.Common.Items.BUTTERS).addTag(AllTags.Common.Items.BUTTER);
            getOrCreateTagBuilder(AllTags.Common.Items.EGGS).add(Items.EGG);


            getOrCreateTagBuilder(AllTags.Common.Items.RED_DYE).add(Items.RED_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.ORANGE_DYE).add(Items.ORANGE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.YELLOW_DYE).add(Items.YELLOW_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.LIME_DYE).add(Items.LIME_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.GREEN_DYE).add(Items.GREEN_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.LIGHT_BLUE_DYE).add(Items.LIGHT_BLUE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.CYAN_DYE).add(Items.CYAN_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.BLUE_DYE).add(Items.BLUE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.PURPLE_DYE).add(Items.PURPLE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.MAGENTA_DYE).add(Items.MAGENTA_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.PINK_DYE).add(Items.PINK_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.BLACK_DYE).add(Items.BLACK_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.GRAY_DYE).add(Items.GRAY_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.LIGHT_GRAY_DYE).add(Items.LIGHT_GRAY_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.WHITE_DYE).add(Items.WHITE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.BROWN_DYE).add(Items.BROWN_DYE);

            getOrCreateTagBuilder(AllTags.Common.Items.DYE_RED).add(Items.RED_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_ORANGE).add(Items.ORANGE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_YELLOW).add(Items.YELLOW_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_LIME).add(Items.LIME_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_GREEN).add(Items.GREEN_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_LIGHT_BLUE).add(Items.LIGHT_BLUE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_CYAN).add(Items.CYAN_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_BLUE).add(Items.BLUE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_PURPLE).add(Items.PURPLE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_MAGENTA).add(Items.MAGENTA_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_PINK).add(Items.PINK_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_BLACK).add(Items.BLACK_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_GRAY).add(Items.GRAY_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_LIGHT_GRAY).add(Items.LIGHT_GRAY_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_WHITE).add(Items.WHITE_DYE);
            getOrCreateTagBuilder(AllTags.Common.Items.DYE_BROWN).add(Items.BROWN_DYE);

            addTagsToTag(ConventionalItemTags.RED_DYES, AllTags.Common.Items.RED_DYE, AllTags.Common.Items.DYE_RED);
            addTagsToTag(ConventionalItemTags.ORANGE_DYES, AllTags.Common.Items.ORANGE_DYE, AllTags.Common.Items.DYE_ORANGE);
            addTagsToTag(ConventionalItemTags.YELLOW_DYES, AllTags.Common.Items.YELLOW_DYE, AllTags.Common.Items.DYE_YELLOW);
            addTagsToTag(ConventionalItemTags.LIME_DYES, AllTags.Common.Items.LIME_DYE, AllTags.Common.Items.DYE_LIME);
            addTagsToTag(ConventionalItemTags.GREEN_DYES, AllTags.Common.Items.GREEN_DYE, AllTags.Common.Items.DYE_GREEN);
            addTagsToTag(ConventionalItemTags.LIGHT_BLUE_DYES, AllTags.Common.Items.LIGHT_BLUE_DYE, AllTags.Common.Items.DYE_LIGHT_BLUE);
            addTagsToTag(ConventionalItemTags.CYAN_DYES, AllTags.Common.Items.CYAN_DYE, AllTags.Common.Items.DYE_CYAN);
            addTagsToTag(ConventionalItemTags.BLUE_DYES, AllTags.Common.Items.BLUE_DYE, AllTags.Common.Items.DYE_BLUE);
            addTagsToTag(ConventionalItemTags.PURPLE_DYES, AllTags.Common.Items.PURPLE_DYE, AllTags.Common.Items.DYE_PURPLE);
            addTagsToTag(ConventionalItemTags.MAGENTA_DYES, AllTags.Common.Items.MAGENTA_DYE, AllTags.Common.Items.DYE_MAGENTA);
            addTagsToTag(ConventionalItemTags.PINK_DYES, AllTags.Common.Items.PINK_DYE, AllTags.Common.Items.DYE_PINK);
            addTagsToTag(ConventionalItemTags.BLACK_DYES, AllTags.Common.Items.BLACK_DYE, AllTags.Common.Items.DYE_BLACK);
            addTagsToTag(ConventionalItemTags.GRAY_DYES, AllTags.Common.Items.GRAY_DYE, AllTags.Common.Items.DYE_GRAY);
            addTagsToTag(ConventionalItemTags.LIGHT_GRAY_DYES, AllTags.Common.Items.LIGHT_GRAY_DYE, AllTags.Common.Items.DYE_LIGHT_GRAY);
            addTagsToTag(ConventionalItemTags.WHITE_DYES, AllTags.Common.Items.WHITE_DYE, AllTags.Common.Items.DYE_WHITE);
            addTagsToTag(ConventionalItemTags.BROWN_DYES, AllTags.Common.Items.BROWN_DYE, AllTags.Common.Items.DYE_BROWN);
        }
    }

    public static class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {

        public ModBlockTagsProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(dataOutput, registriesFuture);
        }

        @Override
        public void addTags(HolderLookup.Provider registriesFuture) {
            addModTags();
            addVanillaTags();
            addCommonTags();
            fillExistingCommonTags();
        }

        public void addTagsToTag(TagKey<Block> mainTag, TagKey<Block>... addingTags) {
            FabricTagBuilder tagBuilder = getOrCreateTagBuilder(mainTag);

            for (TagKey<Block> tag : addingTags) {
                tagBuilder.addTag(tag);
            }
        }

        private void addModTags() {
            getOrCreateTagBuilder(AllTags.Blocks.CINNAMON_LOGS).add(
                AllBlocks.CINNAMON_LOG,
                AllBlocks.CINNAMON_WOOD,
                AllBlocks.STRIPPED_CINNAMON_LOG,
                AllBlocks.STRIPPED_CINNAMON_WOOD
            );
            getOrCreateTagBuilder(AllTags.Blocks.ROSE_CARPET_PLACEABLES).add(
                Blocks.HOPPER
            );
        }

        private void addVanillaTags() {
            getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(
                AllBlocks.AUTO_BLOWTORCH,
                AllBlocks.CARAMELISER,
                AllBlocks.REINFORCED_BLACKSTONE,
                AllBlocks.REINFORCED_BLACKSTONE_DOOR,
                AllBlocks.REINFORCED_BLACKSTONE_LADDER,
                AllBlocks.REINFORCED_BLACKSTONE_BARS,
                AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR
            );
            getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(
                AllBlocks.SAW_DUST,
                AllBlocks.REINFORCED_BLACKSTONE_GRAVEL
            );

            getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(AllBlocks.CINNAMON_FENCE_GATE);
            getOrCreateTagBuilder(BlockTags.LEAVES).add(AllBlocks.CINNAMON_LEAVES);
            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(AllTags.Blocks.CINNAMON_LOGS);
            getOrCreateTagBuilder(BlockTags.PLANKS).add(AllBlocks.CINNAMON_PLANKS);
            getOrCreateTagBuilder(BlockTags.SAPLINGS).add(AllBlocks.CINNAMON_SAPLING);
            getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(AllBlocks.CINNAMON_SIGN);
            getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(AllBlocks.CINNAMON_WALL_SIGN);
            getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(AllBlocks.CINNAMON_BUTTON);
            getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(AllBlocks.CINNAMON_DOOR);
            getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(AllBlocks.CINNAMON_FENCE);
            getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(AllBlocks.CINNAMON_PRESSURE_PLATE);
            getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(AllBlocks.CINNAMON_SLAB);
            getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(AllBlocks.CINNAMON_STAIRS);
            getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(AllBlocks.CINNAMON_TRAPDOOR);
            getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS).add(AllBlocks.CINNAMON_LOG);

            getOrCreateTagBuilder(BlockTags.CLIMBABLE).add(AllBlocks.REINFORCED_BLACKSTONE_LADDER);
            getOrCreateTagBuilder(BlockTags.DOORS).add(AllBlocks.REINFORCED_BLACKSTONE_DOOR);
            getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR);
            getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(AllBlocks.REINFORCED_BLACKSTONE);
            getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE).add(AllBlocks.REINFORCED_BLACKSTONE_BARS);
            getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE).add(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL);
            getOrCreateTagBuilder(BlockTags.LUSH_GROUND_REPLACEABLE).add(AllBlocks.REINFORCED_BLACKSTONE_GRAVEL);
        }
        
        private void addCommonTags() {
            getOrCreateTagBuilder(AllTags.Blocks.FLOWER_STEMS).add(
                AllBlocks.FLOWER_STEM
            );

            getOrCreateTagBuilder(AllTags.Blocks.RED_ROSE_CARPETS).add(AllBlocks.RED_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.ORANGE_ROSE_CARPETS).add(AllBlocks.ORANGE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.YELLOW_ROSE_CARPETS).add(AllBlocks.YELLOW_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.LIME_ROSE_CARPETS).add(AllBlocks.LIME_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.GREEN_ROSE_CARPETS).add(AllBlocks.GREEN_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.BLUE_ROSE_CARPETS).add(AllBlocks.BLUE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.CYAN_ROSE_CARPETS).add(AllBlocks.CYAN_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.LIGHT_BLUE_ROSE_CARPETS).add(AllBlocks.LIGHT_BLUE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.PURPLE_ROSE_CARPETS).add(AllBlocks.PURPLE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.MAGENTA_ROSE_CARPETS).add(AllBlocks.MAGENTA_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.PINK_ROSE_CARPETS).add(AllBlocks.PINK_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.BLACK_ROSE_CARPETS).add(AllBlocks.BLACK_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.GRAY_ROSE_CARPETS).add(AllBlocks.GRAY_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.LIGHT_GRAY_ROSE_CARPETS).add(AllBlocks.LIGHT_GRAY_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.WHITE_ROSE_CARPETS).add(AllBlocks.WHITE_ROSE_CARPET);
            getOrCreateTagBuilder(AllTags.Blocks.BROWN_ROSE_CARPETS).add(AllBlocks.BROWN_ROSE_CARPET);

            addTagsToTag(AllTags.Blocks.ROSE_CARPETS,
                AllTags.Blocks.RED_ROSE_CARPETS,
                AllTags.Blocks.ORANGE_ROSE_CARPETS,
                AllTags.Blocks.YELLOW_ROSE_CARPETS,
                AllTags.Blocks.LIME_ROSE_CARPETS,
                AllTags.Blocks.GREEN_ROSE_CARPETS,
                AllTags.Blocks.BLUE_ROSE_CARPETS,
                AllTags.Blocks.CYAN_ROSE_CARPETS,
                AllTags.Blocks.LIGHT_BLUE_ROSE_CARPETS,
                AllTags.Blocks.PURPLE_ROSE_CARPETS,
                AllTags.Blocks.MAGENTA_ROSE_CARPETS,
                AllTags.Blocks.PINK_ROSE_CARPETS,
                AllTags.Blocks.BLACK_ROSE_CARPETS,
                AllTags.Blocks.GRAY_ROSE_CARPETS,
                AllTags.Blocks.LIGHT_GRAY_ROSE_CARPETS,
                AllTags.Blocks.WHITE_ROSE_CARPETS,
                AllTags.Blocks.BROWN_ROSE_CARPETS
            );
        }
    
        private void fillExistingCommonTags() {

        }
    }

    public static class ModFluidTagProvider extends FabricTagProvider.FluidTagProvider {

        public ModFluidTagProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(dataOutput, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider registriesFuture) {
            addVanillaTags();
            addCommonTags();
            addModTags();
            fillExistingCommonTags();
        }

        private void addCommonTags() {

        }

        private void addVanillaTags() {
            getOrCreateTagBuilder(FluidTags.WATER).add(AllFluids.CARAMEL_FLOWING, AllFluids.CARAMEL_STILL);
        }

        private void addModTags() {

        }
        
        private void fillExistingCommonTags() {

        }
        
    }
    
    public static class ModBiomeTagProvider extends FabricTagProvider<Biome> {

        public ModBiomeTagProvider(FabricDataOutput dataOutput, CompletableFuture<Provider> registriesFuture) {
            super(dataOutput, Registries.BIOME, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider registriesFuture) {
            addVanillaTags();
            addCommonTags();
            addModTags();
            fillExistingCommonTags();
        }

        private void addCommonTags() {

        }

        private void addVanillaTags() {

        }

        private void addModTags() {
            getOrCreateTagBuilder(AllTags.Biomes.HAS_BLACKSTONE_FORTRESS).forceAddTag(BiomeTags.IS_MOUNTAIN);
        }
        
        private void fillExistingCommonTags() {

        }
        
    }

}
