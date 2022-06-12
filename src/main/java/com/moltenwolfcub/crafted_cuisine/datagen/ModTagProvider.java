package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.ModBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.ModBlocks;
import com.moltenwolfcub.crafted_cuisine.init.ModFluids;
import com.moltenwolfcub.crafted_cuisine.init.ModItems;
import com.moltenwolfcub.crafted_cuisine.init.ModTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModTagProvider{

    public class ModBlockTagsProvider extends BlockTagsProvider {

        public ModBlockTagsProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
            super(gen, CraftedCuisine.MODID, fileHelper);
        }

        @Override
        public String getName() {
            return "Block Tags: " + CraftedCuisine.MODID;
        }

        @Override
        public void addTags() {
            addModTags();
            addVanillaTags();
            addForgeTags();
        }

        private void addModTags() {
            tag(ModTags.Blocks.CINNAMON_LOGS).add(
                ModBlocks.CINNAMON_LOG.get(),
                ModBlocks.CINNAMON_WOOD.get(),
                ModBlocks.STRIPPED_CINNAMON_LOG.get(),
                ModBlocks.STRIPPED_CINNAMON_WOOD.get()
            );
            tag(ModTags.Blocks.ROSE_CARPET_PLACEABLES).add(
                Blocks.HOPPER
            );
        }

        private void addVanillaTags() {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.AUTO_BLOWTORCH.get(),
                ModBlocks.CARAMELISER.get()
            );
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                ModBlocks.SAW_DUST.get()
            );
            tag(BlockTags.FENCE_GATES).add(
                ModBlocks.CINNAMON_FENCE_GATE.get()
            );
            tag(BlockTags.LEAVES).add(
                ModBlocks.CINNAMON_LEAVES.get()
            );
            tag(BlockTags.LOGS_THAT_BURN).addTag(
                ModTags.Blocks.CINNAMON_LOGS
            );
            tag(BlockTags.LOGS).addTag(
                ModTags.Blocks.CINNAMON_LOGS
            );
            tag(BlockTags.PLANKS).add(
                ModBlocks.CINNAMON_PLANKS.get()
            );
            tag(BlockTags.SAPLINGS).add(
                ModBlocks.CINNAMON_SAPLING.get()
            );
            tag(BlockTags.STANDING_SIGNS).add(
                ModBlocks.CINNAMON_SIGN.get()
            );
            tag(BlockTags.WALL_SIGNS).add(
                ModBlocks.CINNAMON_WALL_SIGN.get()
            );
            tag(BlockTags.WOODEN_BUTTONS).add(
                ModBlocks.CINNAMON_BUTTON.get()
            );
            tag(BlockTags.WOODEN_DOORS).add(
                ModBlocks.CINNAMON_DOOR.get()
            );
            tag(BlockTags.WOODEN_FENCES).add(
                ModBlocks.CINNAMON_FENCE.get()
            );
            tag(BlockTags.PRESSURE_PLATES).add(
                ModBlocks.CINNAMON_PRESSURE_PLATE.get()
            );
            tag(BlockTags.SLABS).add(
                ModBlocks.CINNAMON_SLAB.get()
            );
            tag(BlockTags.STAIRS).add(
                ModBlocks.CINNAMON_STAIRS.get()
            );
            tag(BlockTags.TRAPDOORS).add(
                ModBlocks.CINNAMON_TRAPDOOR.get()
            );
        }
        
        @SuppressWarnings("unchecked")
        private void addForgeTags() {
            tag(ModTags.Blocks.FLOWER_STEMS).add(
                ModBlocks.FLOWER_STEM.get()
            );

            tag(ModTags.Blocks.RED_ROSE_CARPETS).add(ModBlocks.RED_ROSE_CARPET.get());
            tag(ModTags.Blocks.ORANGE_ROSE_CARPETS).add(ModBlocks.ORANGE_ROSE_CARPET.get());
            tag(ModTags.Blocks.YELLOW_ROSE_CARPETS).add(ModBlocks.YELLOW_ROSE_CARPET.get());
            tag(ModTags.Blocks.LIME_ROSE_CARPETS).add(ModBlocks.LIME_ROSE_CARPET.get());
            tag(ModTags.Blocks.GREEN_ROSE_CARPETS).add(ModBlocks.GREEN_ROSE_CARPET.get());
            tag(ModTags.Blocks.BLUE_ROSE_CARPETS).add(ModBlocks.BLUE_ROSE_CARPET.get());
            tag(ModTags.Blocks.CYAN_ROSE_CARPETS).add(ModBlocks.CYAN_ROSE_CARPET.get());
            tag(ModTags.Blocks.LIGHT_BLUE_ROSE_CARPETS).add(ModBlocks.LIGHT_BLUE_ROSE_CARPET.get());
            tag(ModTags.Blocks.PURPLE_ROSE_CARPETS).add(ModBlocks.PURPLE_ROSE_CARPET.get());
            tag(ModTags.Blocks.MAGENTA_ROSE_CARPETS).add(ModBlocks.MAGENTA_ROSE_CARPET.get());
            tag(ModTags.Blocks.PINK_ROSE_CARPETS).add(ModBlocks.PINK_ROSE_CARPET.get());
            tag(ModTags.Blocks.BLACK_ROSE_CARPETS).add(ModBlocks.BLACK_ROSE_CARPET.get());
            tag(ModTags.Blocks.GRAY_ROSE_CARPETS).add(ModBlocks.GRAY_ROSE_CARPET.get());
            tag(ModTags.Blocks.LIGHT_GRAY_ROSE_CARPETS).add(ModBlocks.LIGHT_GRAY_ROSE_CARPET.get());
            tag(ModTags.Blocks.WHITE_ROSE_CARPETS).add(ModBlocks.WHITE_ROSE_CARPET.get());
            tag(ModTags.Blocks.BROWN_ROSE_CARPETS).add(ModBlocks.BROWN_ROSE_CARPET.get());

            tag(ModTags.Blocks.ROSE_CARPETS).addTags(
                ModTags.Blocks.RED_ROSE_CARPETS,
                ModTags.Blocks.ORANGE_ROSE_CARPETS,
                ModTags.Blocks.YELLOW_ROSE_CARPETS,
                ModTags.Blocks.LIME_ROSE_CARPETS,
                ModTags.Blocks.GREEN_ROSE_CARPETS,
                ModTags.Blocks.BLUE_ROSE_CARPETS,
                ModTags.Blocks.CYAN_ROSE_CARPETS,
                ModTags.Blocks.LIGHT_BLUE_ROSE_CARPETS,
                ModTags.Blocks.PURPLE_ROSE_CARPETS,
                ModTags.Blocks.MAGENTA_ROSE_CARPETS,
                ModTags.Blocks.PINK_ROSE_CARPETS,
                ModTags.Blocks.BLACK_ROSE_CARPETS,
                ModTags.Blocks.GRAY_ROSE_CARPETS,
                ModTags.Blocks.LIGHT_GRAY_ROSE_CARPETS,
                ModTags.Blocks.WHITE_ROSE_CARPETS,
                ModTags.Blocks.BROWN_ROSE_CARPETS
            );
        }
    }
    
    public class ModItemTagProvider extends ItemTagsProvider {

        public ModItemTagProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
            super(gen, new ModBlockTagsProvider(gen, fileHelper), CraftedCuisine.MODID, fileHelper);
        }

        @Override
        public String getName() {
            return "Item Tags: " + CraftedCuisine.MODID;
        }

        @Override
        public void addTags() {
            addModTags();
            addVanillaTags();
            addForgeTags();
        }

        private void addModTags() {
            tag(ModTags.Items.CINNAMON_LOGS).add(
                ModBlockItems.CINNAMON_LOG_BLOCK_ITEM.get(),
                ModBlockItems.CINNAMON_WOOD_BLOCK_ITEM.get(),
                ModBlockItems.STRIPPED_CINNAMON_LOG_BLOCK_ITEM.get(),
                ModBlockItems.STRIPPED_CINNAMON_WOOD_BLOCK_ITEM.get()
            );
            tag(ModTags.Items.BLACKSTONE).add(
                Items.POLISHED_BLACKSTONE
            );
        }
        
        private void addVanillaTags() {
            tag(ItemTags.LEAVES).add(ModBlockItems.CINNAMON_LEAVES_BLOCK_ITEM.get());
            tag(ItemTags.LOGS_THAT_BURN).addTag(ModTags.Items.CINNAMON_LOGS);
            tag(ItemTags.LOGS).addTag(ModTags.Items.CINNAMON_LOGS);
            tag(ItemTags.PLANKS).add(ModBlockItems.CINNAMON_PLANKS_BLOCK_ITEM.get());
            tag(ItemTags.SAPLINGS).add(ModBlockItems.CINNAMON_SAPLING_BLOCK_ITEM.get());
            tag(ItemTags.SIGNS).add(ModItems.CINNAMON_SIGN.get());
            tag(ItemTags.WOODEN_BUTTONS).add(ModBlockItems.CINNAMON_BUTTON_BLOCK_ITEM.get());
            tag(ItemTags.WOODEN_DOORS).add(ModBlockItems.CINNAMON_DOOR_BLOCK_ITEM.get());
            tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlockItems.CINNAMON_PRESSURE_PLATE_BLOCK_ITEM.get());
            tag(ItemTags.WOODEN_SLABS).add(ModBlockItems.CINNAMON_SLAB_BLOCK_ITEM.get());
            tag(ItemTags.WOODEN_STAIRS).add(ModBlockItems.CINNAMON_STAIRS_BLOCK_ITEM.get());
            tag(ItemTags.WOODEN_TRAPDOORS).add(ModBlockItems.CINNAMON_TRAPDOOR_BLOCK_ITEM.get());
        }
    
        @SuppressWarnings("unchecked")
        private void addForgeTags() {

            tag(ModTags.Items.PAPER_PULP).add(
                ModItems.PAPER_PULP.get()
            );

            tag(ModTags.Items.BARK).addTags(
                ModTags.Items.ACACIA_BARK,
                ModTags.Items.BIRCH_BARK,
                ModTags.Items.CINNAMON_BARK,
                ModTags.Items.CRIMSON_BARK,
                ModTags.Items.DARK_OAK_BARK,
                ModTags.Items.JUNGLE_BARK,
                ModTags.Items.OAK_BARK,
                ModTags.Items.SPRUCE_BARK,
                ModTags.Items.WARPED_BARK
            );
            tag(ModTags.Items.ACACIA_BARK).add(
                ModItems.ACACIA_BARK.get()
            );
            tag(ModTags.Items.BIRCH_BARK).add(
                ModItems.BIRCH_BARK.get()
            );
            tag(ModTags.Items.CINNAMON_BARK).add(
                ModItems.CINNAMON_BARK.get()
            );
            tag(ModTags.Items.CRIMSON_BARK).add(
                ModItems.CRIMSON_BARK.get()
            );
            tag(ModTags.Items.DARK_OAK_BARK).add(
                ModItems.DARK_OAK_BARK.get()
            );
            tag(ModTags.Items.JUNGLE_BARK).add(
                ModItems.JUNGLE_BARK.get()
            );
            tag(ModTags.Items.OAK_BARK).add(
                ModItems.OAK_BARK.get()
            );
            tag(ModTags.Items.SPRUCE_BARK).add(
                ModItems.SPRUCE_BARK.get()
            );
            tag(ModTags.Items.WARPED_BARK).add(
                ModItems.WARPED_BARK.get()
            );

            tag(ModTags.Items.ROSE_CARPETS).addTags(
                ModTags.Items.RED_ROSE_CARPETS,
                ModTags.Items.ORANGE_ROSE_CARPETS,
                ModTags.Items.YELLOW_ROSE_CARPETS,
                ModTags.Items.LIME_ROSE_CARPETS,
                ModTags.Items.GREEN_ROSE_CARPETS,
                ModTags.Items.BLUE_ROSE_CARPETS,
                ModTags.Items.CYAN_ROSE_CARPETS,
                ModTags.Items.LIGHT_BLUE_ROSE_CARPETS,
                ModTags.Items.PURPLE_ROSE_CARPETS,
                ModTags.Items.MAGENTA_ROSE_CARPETS,
                ModTags.Items.PINK_ROSE_CARPETS,
                ModTags.Items.BLACK_ROSE_CARPETS,
                ModTags.Items.GRAY_ROSE_CARPETS,
                ModTags.Items.LIGHT_GRAY_ROSE_CARPETS,
                ModTags.Items.WHITE_ROSE_CARPETS,
                ModTags.Items.BROWN_ROSE_CARPETS
            );
            tag(ModTags.Items.RED_ROSE_CARPETS).add(ModBlockItems.RED_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.ORANGE_ROSE_CARPETS).add(ModBlockItems.ORANGE_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.YELLOW_ROSE_CARPETS).add(ModBlockItems.YELLOW_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.LIME_ROSE_CARPETS).add(ModBlockItems.LIME_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.GREEN_ROSE_CARPETS).add(ModBlockItems.GREEN_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.BLUE_ROSE_CARPETS).add(ModBlockItems.BLUE_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.CYAN_ROSE_CARPETS).add(ModBlockItems.CYAN_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.LIGHT_BLUE_ROSE_CARPETS).add(ModBlockItems.LIGHT_BLUE_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.PURPLE_ROSE_CARPETS).add(ModBlockItems.PURPLE_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.MAGENTA_ROSE_CARPETS).add(ModBlockItems.MAGENTA_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.PINK_ROSE_CARPETS).add(ModBlockItems.PINK_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.BLACK_ROSE_CARPETS).add(ModBlockItems.BLACK_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.GRAY_ROSE_CARPETS).add(ModBlockItems.GRAY_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.LIGHT_GRAY_ROSE_CARPETS).add(ModBlockItems.LIGHT_GRAY_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.WHITE_ROSE_CARPETS).add(ModBlockItems.WHITE_ROSE_CARPET_BLOCK_ITEM.get());
            tag(ModTags.Items.BROWN_ROSE_CARPETS).add(ModBlockItems.BROWN_ROSE_CARPET_BLOCK_ITEM.get());

            tag(ModTags.Items.PETALS).addTags(
                ModTags.Items.RED_PETALS,
                ModTags.Items.ORANGE_PETALS,
                ModTags.Items.YELLOW_PETALS,
                ModTags.Items.LIME_PETALS,
                ModTags.Items.GREEN_PETALS,
                ModTags.Items.BLUE_PETALS,
                ModTags.Items.CYAN_PETALS,
                ModTags.Items.LIGHT_BLUE_PETALS,
                ModTags.Items.PURPLE_PETALS,
                ModTags.Items.MAGENTA_PETALS,
                ModTags.Items.PINK_PETALS,
                ModTags.Items.BLACK_PETALS,
                ModTags.Items.GRAY_PETALS,
                ModTags.Items.LIGHT_GRAY_PETALS,
                ModTags.Items.WHITE_PETALS,
                ModTags.Items.BROWN_PETALS
            );
            tag(ModTags.Items.RED_PETALS).add(ModItems.RED_ROSE_PETAL.get());
            tag(ModTags.Items.ORANGE_PETALS).add(ModItems.ORANGE_ROSE_PETAL.get());
            tag(ModTags.Items.YELLOW_PETALS).add(ModItems.YELLOW_ROSE_PETAL.get());
            tag(ModTags.Items.LIME_PETALS).add(ModItems.LIME_ROSE_PETAL.get());
            tag(ModTags.Items.GREEN_PETALS).add(ModItems.GREEN_ROSE_PETAL.get());
            tag(ModTags.Items.BLUE_PETALS).add(ModItems.BLUE_ROSE_PETAL.get());
            tag(ModTags.Items.CYAN_PETALS).add(ModItems.CYAN_ROSE_PETAL.get());
            tag(ModTags.Items.LIGHT_BLUE_PETALS).add(ModItems.LIGHT_BLUE_ROSE_PETAL.get());
            tag(ModTags.Items.PURPLE_PETALS).add(ModItems.PURPLE_ROSE_PETAL.get());
            tag(ModTags.Items.MAGENTA_PETALS).add(ModItems.MAGENTA_ROSE_PETAL.get());
            tag(ModTags.Items.PINK_PETALS).add(ModItems.PINK_ROSE_PETAL.get());
            tag(ModTags.Items.BLACK_PETALS).add(ModItems.BLACK_ROSE_PETAL.get());
            tag(ModTags.Items.GRAY_PETALS).add(ModItems.GRAY_ROSE_PETAL.get());
            tag(ModTags.Items.LIGHT_GRAY_PETALS).add(ModItems.LIGHT_GRAY_ROSE_PETAL.get());
            tag(ModTags.Items.WHITE_PETALS).add(ModItems.WHITE_ROSE_PETAL.get());
            tag(ModTags.Items.BROWN_PETALS).add(ModItems.BROWN_ROSE_PETAL.get());


            tag(ModTags.Items.EGG_YOLK).add(ModItems.EGG_YOLK.get());
            tag(ModTags.Items.EGG_WHITE).add(ModItems.EGG_WHITE.get());
            tag(ModTags.Items.CINNAMON).add(ModItems.CINNAMON.get());
            tag(ModTags.Items.CRUSHED_CINNAMON).add(ModItems.CRUSHED_CINNAMON.get());
            tag(ModTags.Items.BLOW_TORCHES).add(ModItems.BLOW_TORCH.get());
            tag(ModTags.Items.RAW_MERINGUE).add(ModItems.RAW_MERINGUE.get());
            tag(ModTags.Items.MERINGUE).add(ModItems.MERINGUE.get());
            tag(ModTags.Items.SUGAR).add(Items.SUGAR);
            tag(ModTags.Items.BUTTER).add(ModItems.BUTTER.get());
            tag(ModTags.Items.CREAM).add(ModItems.CREAM.get());
            tag(ModTags.Items.CARAMEL).add(ModItems.CARAMEL.get());

            tag(ModTags.Items.CROP_LEMONS).add(ModItems.LEMON.get());
            tag(ModTags.Items.FRUIT_LEMONS).add(ModItems.LEMON.get());
            tag(ModTags.Items.CROP_LIMES).add(ModItems.LIME.get());
            tag(ModTags.Items.FRUIT_LIMES).add(ModItems.LIME.get());
            tag(ModTags.Items.CROP_ORANGES).add(ModItems.ORANGE.get(), ModItems.BLOOD_ORANGE.get());
            tag(ModTags.Items.FRUIT_ORANGES).add(ModItems.ORANGE.get(), ModItems.BLOOD_ORANGE.get());

            tag(ModTags.Items.REINFORCED_BLACKSONE_INGOTS).add(ModItems.REINFORCED_BLACKSTONE_INGOT.get());
            tag(ModTags.Items.REINFORCED_BLACKSONE_NUGGETS).add(ModItems.REINFORCED_BLACKSTONE_NUGGET.get());
            tag(ModTags.Items.REINFORCED_BLACKSONE_STORAGE_BLOCKS).add(ModBlockItems.REINFORCED_BLACKSTONE.get());

            tag(Tags.Items.INGOTS).addTag(ModTags.Items.REINFORCED_BLACKSONE_INGOTS);
            tag(Tags.Items.NUGGETS).addTag(ModTags.Items.REINFORCED_BLACKSONE_NUGGETS);
            tag(Tags.Items.STORAGE_BLOCKS).addTag(ModTags.Items.REINFORCED_BLACKSONE_STORAGE_BLOCKS);
        }
    }

    public class ModFluidTagProvider extends FluidTagsProvider {

        public ModFluidTagProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
            super(gen, CraftedCuisine.MODID, fileHelper);
        }

        @Override
        public String getName() {
            return "Fluid Tags: " + CraftedCuisine.MODID;
        }

        @Override
        public void addTags() {
            addVanillaTags();
            addForgeTags();
        }

        private void addForgeTags() {
        }

        private void addVanillaTags() {
            tag(FluidTags.WATER).add(ModFluids.CARAMEL_FLOWING.get(), ModFluids.CARAMEL_FLUID.get());
        }

        
    }

}
