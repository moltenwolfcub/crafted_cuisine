package com.moltenwolfcub.crafted_cuisine.datagen;

import com.moltenwolfcub.crafted_cuisine.CraftedCuisine;
import com.moltenwolfcub.crafted_cuisine.init.AllBlockItems;
import com.moltenwolfcub.crafted_cuisine.init.AllBlocks;
import com.moltenwolfcub.crafted_cuisine.init.AllFluids;
import com.moltenwolfcub.crafted_cuisine.init.AllItems;
import com.moltenwolfcub.crafted_cuisine.init.AllTags;

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
            tag(AllTags.Blocks.CINNAMON_LOGS).add(
                AllBlocks.CINNAMON_LOG.get(),
                AllBlocks.CINNAMON_WOOD.get(),
                AllBlocks.STRIPPED_CINNAMON_LOG.get(),
                AllBlocks.STRIPPED_CINNAMON_WOOD.get()
            );
            tag(AllTags.Blocks.ROSE_CARPET_PLACEABLES).add(
                Blocks.HOPPER
            );
        }

        private void addVanillaTags() {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                AllBlocks.AUTO_BLOWTORCH.get(),
                AllBlocks.CARAMELISER.get(),
                AllBlocks.REINFORCED_BLACKSTONE.get(),
                AllBlocks.REINFORCED_BLACKSTONE_DOOR.get(),
                AllBlocks.REINFORCED_BLACKSTONE_LADDER.get(),
                AllBlocks.REINFORCED_BLACKSTONE_BARS.get(),
                AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR.get()
            );
            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                AllBlocks.SAW_DUST.get(),
                AllBlocks.REINFORCED_BLACKSTONE_GRAVEL.get()
            );
            tag(BlockTags.NEEDS_STONE_TOOL).add(
                AllBlocks.REINFORCED_BLACKSTONE.get()
            );

            tag(BlockTags.DRAGON_IMMUNE).add(
                AllBlocks.REINFORCED_BLACKSTONE_BARS.get()
            );

            tag(BlockTags.FENCE_GATES).add(
                AllBlocks.CINNAMON_FENCE_GATE.get()
            );
            tag(BlockTags.LEAVES).add(
                AllBlocks.CINNAMON_LEAVES.get()
            );
            tag(BlockTags.LOGS_THAT_BURN).addTag(
                AllTags.Blocks.CINNAMON_LOGS
            );
            tag(BlockTags.LOGS).addTag(
                AllTags.Blocks.CINNAMON_LOGS
            );
            tag(BlockTags.PLANKS).add(
                AllBlocks.CINNAMON_PLANKS.get()
            );
            tag(BlockTags.SAPLINGS).add(
                AllBlocks.CINNAMON_SAPLING.get()
            );
            tag(BlockTags.STANDING_SIGNS).add(
                AllBlocks.CINNAMON_SIGN.get()
            );
            tag(BlockTags.WALL_SIGNS).add(
                AllBlocks.CINNAMON_WALL_SIGN.get()
            );
            tag(BlockTags.WOODEN_BUTTONS).add(
                AllBlocks.CINNAMON_BUTTON.get()
            );
            tag(BlockTags.WOODEN_DOORS).add(
                AllBlocks.CINNAMON_DOOR.get()
            );
            tag(BlockTags.WOODEN_FENCES).add(
                AllBlocks.CINNAMON_FENCE.get()
            );
            tag(BlockTags.PRESSURE_PLATES).add(
                AllBlocks.CINNAMON_PRESSURE_PLATE.get()
            );
            tag(BlockTags.WOODEN_SLABS).add(
                AllBlocks.CINNAMON_SLAB.get()
            );
            tag(BlockTags.WOODEN_STAIRS).add(
                AllBlocks.CINNAMON_STAIRS.get()
            );
            tag(BlockTags.WOODEN_TRAPDOORS).add(
                AllBlocks.CINNAMON_TRAPDOOR.get()
            );
            tag(BlockTags.CLIMBABLE).add(
                AllBlocks.REINFORCED_BLACKSTONE_LADDER.get()
            );
            tag(BlockTags.DOORS).add(
                AllBlocks.REINFORCED_BLACKSTONE_DOOR.get()
            );
            tag(BlockTags.TRAPDOORS).add(
                AllBlocks.REINFORCED_BLACKSTONE_TRAPDOOR.get()
            );
        }
        
        @SuppressWarnings("unchecked")
        private void addForgeTags() {
            tag(AllTags.Blocks.FLOWER_STEMS).add(
                AllBlocks.FLOWER_STEM.get()
            );

            tag(AllTags.Blocks.RED_ROSE_CARPETS).add(AllBlocks.RED_ROSE_CARPET.get());
            tag(AllTags.Blocks.ORANGE_ROSE_CARPETS).add(AllBlocks.ORANGE_ROSE_CARPET.get());
            tag(AllTags.Blocks.YELLOW_ROSE_CARPETS).add(AllBlocks.YELLOW_ROSE_CARPET.get());
            tag(AllTags.Blocks.LIME_ROSE_CARPETS).add(AllBlocks.LIME_ROSE_CARPET.get());
            tag(AllTags.Blocks.GREEN_ROSE_CARPETS).add(AllBlocks.GREEN_ROSE_CARPET.get());
            tag(AllTags.Blocks.BLUE_ROSE_CARPETS).add(AllBlocks.BLUE_ROSE_CARPET.get());
            tag(AllTags.Blocks.CYAN_ROSE_CARPETS).add(AllBlocks.CYAN_ROSE_CARPET.get());
            tag(AllTags.Blocks.LIGHT_BLUE_ROSE_CARPETS).add(AllBlocks.LIGHT_BLUE_ROSE_CARPET.get());
            tag(AllTags.Blocks.PURPLE_ROSE_CARPETS).add(AllBlocks.PURPLE_ROSE_CARPET.get());
            tag(AllTags.Blocks.MAGENTA_ROSE_CARPETS).add(AllBlocks.MAGENTA_ROSE_CARPET.get());
            tag(AllTags.Blocks.PINK_ROSE_CARPETS).add(AllBlocks.PINK_ROSE_CARPET.get());
            tag(AllTags.Blocks.BLACK_ROSE_CARPETS).add(AllBlocks.BLACK_ROSE_CARPET.get());
            tag(AllTags.Blocks.GRAY_ROSE_CARPETS).add(AllBlocks.GRAY_ROSE_CARPET.get());
            tag(AllTags.Blocks.LIGHT_GRAY_ROSE_CARPETS).add(AllBlocks.LIGHT_GRAY_ROSE_CARPET.get());
            tag(AllTags.Blocks.WHITE_ROSE_CARPETS).add(AllBlocks.WHITE_ROSE_CARPET.get());
            tag(AllTags.Blocks.BROWN_ROSE_CARPETS).add(AllBlocks.BROWN_ROSE_CARPET.get());

            tag(AllTags.Blocks.ROSE_CARPETS).addTags(
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
            tag(AllTags.Items.CINNAMON_LOGS).add(
                AllBlockItems.CINNAMON_LOG.get(),
                AllBlockItems.CINNAMON_WOOD.get(),
                AllBlockItems.STRIPPED_CINNAMON_LOG.get(),
                AllBlockItems.STRIPPED_CINNAMON_WOOD.get()
            );
            tag(AllTags.Items.POLISHED_BLACKSTONE).add(
                Items.POLISHED_BLACKSTONE
            );
        }
        
        private void addVanillaTags() {
            tag(ItemTags.LEAVES).add(AllBlockItems.CINNAMON_LEAVES.get());
            tag(ItemTags.LOGS_THAT_BURN).addTag(AllTags.Items.CINNAMON_LOGS);
            tag(ItemTags.LOGS).addTag(AllTags.Items.CINNAMON_LOGS);
            tag(ItemTags.PLANKS).add(AllBlockItems.CINNAMON_PLANKS.get());
            tag(ItemTags.SAPLINGS).add(AllBlockItems.CINNAMON_SAPLING.get());
            tag(ItemTags.SIGNS).add(AllItems.CINNAMON_SIGN.get());
            tag(ItemTags.WOODEN_BUTTONS).add(AllBlockItems.CINNAMON_BUTTON.get());
            tag(ItemTags.WOODEN_DOORS).add(AllBlockItems.CINNAMON_DOOR.get());
            tag(ItemTags.WOODEN_PRESSURE_PLATES).add(AllBlockItems.CINNAMON_PRESSURE_PLATE.get());
            tag(ItemTags.WOODEN_SLABS).add(AllBlockItems.CINNAMON_SLAB.get());
            tag(ItemTags.WOODEN_STAIRS).add(AllBlockItems.CINNAMON_STAIRS.get());
            tag(ItemTags.WOODEN_TRAPDOORS).add(AllBlockItems.CINNAMON_TRAPDOOR.get());
        }
    
        @SuppressWarnings("unchecked")
        private void addForgeTags() {

            tag(AllTags.Items.PAPER_PULP).add(
                AllItems.PAPER_PULP.get()
            );

            tag(AllTags.Items.BARK).addTags(
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
            tag(AllTags.Items.BARK).add(
                AllItems.UNKNOWN_BARK.get()
            );
            tag(AllTags.Items.ACACIA_BARK).add(
                AllItems.ACACIA_BARK.get()
            );
            tag(AllTags.Items.BIRCH_BARK).add(
                AllItems.BIRCH_BARK.get()
            );
            tag(AllTags.Items.CINNAMON_BARK).add(
                AllItems.CINNAMON_BARK.get()
            );
            tag(AllTags.Items.CRIMSON_BARK).add(
                AllItems.CRIMSON_BARK.get()
            );
            tag(AllTags.Items.DARK_OAK_BARK).add(
                AllItems.DARK_OAK_BARK.get()
            );
            tag(AllTags.Items.JUNGLE_BARK).add(
                AllItems.JUNGLE_BARK.get()
            );
            tag(AllTags.Items.OAK_BARK).add(
                AllItems.OAK_BARK.get()
            );
            tag(AllTags.Items.SPRUCE_BARK).add(
                AllItems.SPRUCE_BARK.get()
            );
            tag(AllTags.Items.WARPED_BARK).add(
                AllItems.WARPED_BARK.get()
            );

            tag(AllTags.Items.ROSE_CARPETS).addTags(
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
            tag(AllTags.Items.RED_ROSE_CARPETS).add(AllBlockItems.RED_ROSE_CARPET.get());
            tag(AllTags.Items.ORANGE_ROSE_CARPETS).add(AllBlockItems.ORANGE_ROSE_CARPET.get());
            tag(AllTags.Items.YELLOW_ROSE_CARPETS).add(AllBlockItems.YELLOW_ROSE_CARPET.get());
            tag(AllTags.Items.LIME_ROSE_CARPETS).add(AllBlockItems.LIME_ROSE_CARPET.get());
            tag(AllTags.Items.GREEN_ROSE_CARPETS).add(AllBlockItems.GREEN_ROSE_CARPET.get());
            tag(AllTags.Items.BLUE_ROSE_CARPETS).add(AllBlockItems.BLUE_ROSE_CARPET.get());
            tag(AllTags.Items.CYAN_ROSE_CARPETS).add(AllBlockItems.CYAN_ROSE_CARPET.get());
            tag(AllTags.Items.LIGHT_BLUE_ROSE_CARPETS).add(AllBlockItems.LIGHT_BLUE_ROSE_CARPET.get());
            tag(AllTags.Items.PURPLE_ROSE_CARPETS).add(AllBlockItems.PURPLE_ROSE_CARPET.get());
            tag(AllTags.Items.MAGENTA_ROSE_CARPETS).add(AllBlockItems.MAGENTA_ROSE_CARPET.get());
            tag(AllTags.Items.PINK_ROSE_CARPETS).add(AllBlockItems.PINK_ROSE_CARPET.get());
            tag(AllTags.Items.BLACK_ROSE_CARPETS).add(AllBlockItems.BLACK_ROSE_CARPET.get());
            tag(AllTags.Items.GRAY_ROSE_CARPETS).add(AllBlockItems.GRAY_ROSE_CARPET.get());
            tag(AllTags.Items.LIGHT_GRAY_ROSE_CARPETS).add(AllBlockItems.LIGHT_GRAY_ROSE_CARPET.get());
            tag(AllTags.Items.WHITE_ROSE_CARPETS).add(AllBlockItems.WHITE_ROSE_CARPET.get());
            tag(AllTags.Items.BROWN_ROSE_CARPETS).add(AllBlockItems.BROWN_ROSE_CARPET.get());

            tag(AllTags.Items.PETALS).addTags(
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
            tag(AllTags.Items.RED_PETALS).add(AllItems.RED_ROSE_PETAL.get());
            tag(AllTags.Items.ORANGE_PETALS).add(AllItems.ORANGE_ROSE_PETAL.get());
            tag(AllTags.Items.YELLOW_PETALS).add(AllItems.YELLOW_ROSE_PETAL.get());
            tag(AllTags.Items.LIME_PETALS).add(AllItems.LIME_ROSE_PETAL.get());
            tag(AllTags.Items.GREEN_PETALS).add(AllItems.GREEN_ROSE_PETAL.get());
            tag(AllTags.Items.BLUE_PETALS).add(AllItems.BLUE_ROSE_PETAL.get());
            tag(AllTags.Items.CYAN_PETALS).add(AllItems.CYAN_ROSE_PETAL.get());
            tag(AllTags.Items.LIGHT_BLUE_PETALS).add(AllItems.LIGHT_BLUE_ROSE_PETAL.get());
            tag(AllTags.Items.PURPLE_PETALS).add(AllItems.PURPLE_ROSE_PETAL.get());
            tag(AllTags.Items.MAGENTA_PETALS).add(AllItems.MAGENTA_ROSE_PETAL.get());
            tag(AllTags.Items.PINK_PETALS).add(AllItems.PINK_ROSE_PETAL.get());
            tag(AllTags.Items.BLACK_PETALS).add(AllItems.BLACK_ROSE_PETAL.get());
            tag(AllTags.Items.GRAY_PETALS).add(AllItems.GRAY_ROSE_PETAL.get());
            tag(AllTags.Items.LIGHT_GRAY_PETALS).add(AllItems.LIGHT_GRAY_ROSE_PETAL.get());
            tag(AllTags.Items.WHITE_PETALS).add(AllItems.WHITE_ROSE_PETAL.get());
            tag(AllTags.Items.BROWN_PETALS).add(AllItems.BROWN_ROSE_PETAL.get());


            tag(AllTags.Items.EGG_YOLK).add(AllItems.EGG_YOLK.get());
            tag(AllTags.Items.EGG_WHITE).add(AllItems.EGG_WHITE.get());
            tag(AllTags.Items.CINNAMON).add(AllItems.CINNAMON.get());
            tag(AllTags.Items.CRUSHED_CINNAMON).add(AllItems.CRUSHED_CINNAMON.get());
            tag(AllTags.Items.BLOW_TORCHES).add(AllItems.BLOW_TORCH.get());
            tag(AllTags.Items.RAW_MERINGUE).add(AllItems.RAW_MERINGUE.get());
            tag(AllTags.Items.MERINGUE).add(AllItems.MERINGUE.get());
            tag(AllTags.Items.SUGAR).add(Items.SUGAR);
            tag(AllTags.Items.BUTTER).add(AllItems.BUTTER.get());
            tag(AllTags.Items.CREAM).add(AllItems.CREAM.get());
            tag(AllTags.Items.CARAMEL).add(AllItems.CARAMEL.get());

            tag(AllTags.Items.CROP_LEMONS).add(AllItems.LEMON.get());
            tag(AllTags.Items.FRUIT_LEMONS).add(AllItems.LEMON.get());
            tag(AllTags.Items.CROP_LIMES).add(AllItems.LIME.get());
            tag(AllTags.Items.FRUIT_LIMES).add(AllItems.LIME.get());
            tag(AllTags.Items.CROP_ORANGES).add(AllItems.ORANGE.get(), AllItems.BLOOD_ORANGE.get());
            tag(AllTags.Items.FRUIT_ORANGES).add(AllItems.ORANGE.get(), AllItems.BLOOD_ORANGE.get());

            tag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE).add(AllItems.REINFORCED_BLACKSTONE_INGOT.get());
            tag(AllTags.Items.RODS_REINFORCED_BLACKSONE).add(AllItems.REINFORCED_BLACKSTONE_STICK.get());
            tag(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE).add(AllItems.REINFORCED_BLACKSTONE_NUGGET.get());
            tag(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE).add(AllBlockItems.REINFORCED_BLACKSTONE.get());
            tag(AllTags.Items.REINFORCED_BLACKSTONE_SHARD).add(AllItems.REINFORCED_BLACKSTONE_SHARD.get());

            tag(Tags.Items.INGOTS).addTag(AllTags.Items.INGOTS_REINFORCED_BLACKSONE);
            tag(Tags.Items.RODS).addTag(AllTags.Items.RODS_REINFORCED_BLACKSONE);
            tag(Tags.Items.NUGGETS).addTag(AllTags.Items.NUGGETS_REINFORCED_BLACKSONE);
            tag(Tags.Items.STORAGE_BLOCKS).addTag(AllTags.Items.STORAGE_BLOCKS_REINFORCED_BLACKSONE);
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
            tag(FluidTags.WATER).add(AllFluids.CARAMEL_FLOWING.get(), AllFluids.CARAMEL_STILL.get());
        }

        
    }

}
