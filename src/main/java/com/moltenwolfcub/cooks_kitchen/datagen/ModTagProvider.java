package com.moltenwolfcub.cooks_kitchen.datagen;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.init.ModBlockItems;
import com.moltenwolfcub.cooks_kitchen.init.ModBlocks;
import com.moltenwolfcub.cooks_kitchen.init.ModItems;
import com.moltenwolfcub.cooks_kitchen.init.ModTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModTagProvider{

    public class ModBlockTagsProvider extends BlockTagsProvider {

        public ModBlockTagsProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
            super(gen, CooksKitchen.MODID, fileHelper);
        }

        @Override
        public String getName() {
            return "Block Tags: " + CooksKitchen.MODID;
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
        
        private void addForgeTags() {}
    }
    
    public class ModItemTagProvider extends ItemTagsProvider {

        public ModItemTagProvider(DataGenerator gen, ExistingFileHelper fileHelper) {
            super(gen, new ModBlockTagsProvider(gen, fileHelper), CooksKitchen.MODID, fileHelper);
        }

        @Override
        public String getName() {
            return "Item Tags: " + CooksKitchen.MODID;
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
    
        private void addForgeTags() {}
    }
    
}
