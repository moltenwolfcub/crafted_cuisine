package com.moltenwolfcub.cooks_kitchen.datagen;

import java.util.function.Supplier;

import com.moltenwolfcub.cooks_kitchen.CooksKitchen;
import com.moltenwolfcub.cooks_kitchen.init.ModBlocks;
import com.moltenwolfcub.cooks_kitchen.init.ModItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider {
    
    public class EnUs extends LanguageProvider {

        public EnUs(DataGenerator gen) {
            super(gen, CooksKitchen.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            addItems();
            addBlocks();

            add("tooltip.cooks_kitchen.bark_remover", "Press §e§nSHIFT§r for more info!");
            add("tooltip.cooks_kitchen.bark_remover.shift", "Left click on a log to strip it and drop the corresponding bark item!");

            add("itemGroup.cooks_kitchen", "Create Food");

            add("subtitles.item.blow_torch.use", "Blow Torch burns");
        }


        private void addBlocks() {
            addBlock(ModBlocks.SAW_DUST, "Saw Dust");
            addBlock(ModBlocks.AUTO_BLOWTORCH, "Auto Blowtorch");
            addBlock(ModBlocks.CARAMELISER, "Caramelizer");

            addCinnamonPrefixBlock(ModBlocks.CINNAMON_LOG, "Log");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_WOOD, "Wood");
            addBlock(ModBlocks.STRIPPED_CINNAMON_LOG, "Stripped Cinnamon Log");
            addBlock(ModBlocks.STRIPPED_CINNAMON_WOOD, "Stripped Cinnamon Wood");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_PLANKS, "Planks");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_SLAB, "Slab");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_STAIRS, "Stairs");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_FENCE, "Fence");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_FENCE_GATE, "Fence Gate");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_BUTTON, "Button");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_PRESSURE_PLATE, "Pressure Plate");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_DOOR, "Door");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_TRAPDOOR, "Trapdoor");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_SIGN, "Sign");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_LEAVES, "Leaves");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_SAPLING, "Sapling");
            addBlock(ModBlocks.POTTED_CINNAMON_SAPLING, "Potted Cinnamon Sapling");

            addBlock(ModBlocks.PINK_ROSE, "Pink Rose");
            addBlock(ModBlocks.POTTED_PINK_ROSE, "Potted Pink Rose");
            addBlock(ModBlocks.FLOWER_STEM, "Flower Stem");
            addBlock(ModBlocks.POTTED_FLOWER_STEM, "Potted Flower Stem");

            addPetalCarpet(ModBlocks.RED_ROSE_CARPET, "Red");
            addPetalCarpet(ModBlocks.ORANGE_ROSE_CARPET, "Orange");
            addPetalCarpet(ModBlocks.YELLOW_ROSE_CARPET, "Yellow");
            addPetalCarpet(ModBlocks.LIME_ROSE_CARPET, "Lime");
            addPetalCarpet(ModBlocks.GREEN_ROSE_CARPET, "Green");
            addPetalCarpet(ModBlocks.LIGHT_BLUE_ROSE_CARPET, "Light Blue");
            addPetalCarpet(ModBlocks.CYAN_ROSE_CARPET, "Cyan");
            addPetalCarpet(ModBlocks.BLUE_ROSE_CARPET, "Blue");
            addPetalCarpet(ModBlocks.PURPLE_ROSE_CARPET, "Purple");
            addPetalCarpet(ModBlocks.MAGENTA_ROSE_CARPET, "Magenta");
            addPetalCarpet(ModBlocks.PINK_ROSE_CARPET, "Pink");
            addPetalCarpet(ModBlocks.BLACK_ROSE_CARPET, "Black");
            addPetalCarpet(ModBlocks.GRAY_ROSE_CARPET, "Gray");
            addPetalCarpet(ModBlocks.LIGHT_GRAY_ROSE_CARPET, "Light Gray");
            addPetalCarpet(ModBlocks.WHITE_ROSE_CARPET, "White");
            addPetalCarpet(ModBlocks.BROWN_ROSE_CARPET, "Brown");

            addBlock(ModBlocks.LEMON_TREE, "Lemon Tree");
            addBlock(ModBlocks.LIME_TREE, "Lime Tree");
            addBlock(ModBlocks.ORANGE_TREE, "Orange Tree");
        }

        private void addItems() {
            addItem(ModItems.BARK_REMOVER, "Bark Stripper");
            addItem(ModItems.BLOW_TORCH, "Blow Torch");

            addItem(ModItems.CARAMEL_BUCKET, "Caramel Bucket");

            addItem(ModItems.CINNAMON, "Cinnamon Stick");
            addItem(ModItems.CRUSHED_CINNAMON, "Crushed Cinnamon");
            addItem(ModItems.EGG_WHITE, "Egg White");
            addItem(ModItems.EGG_YOLK, "Egg Yolk");
            addItem(ModItems.RAW_MERINGUE, "Raw Meringue");
            addItem(ModItems.BUTTER, "Butter");
            addItem(ModItems.CREAM, "Cream");

            addRosePetal(ModItems.RED_ROSE_PETAL, "Red");
            addRosePetal(ModItems.ORANGE_ROSE_PETAL, "Orange");
            addRosePetal(ModItems.YELLOW_ROSE_PETAL, "Yellow");
            addRosePetal(ModItems.LIME_ROSE_PETAL, "Lime");
            addRosePetal(ModItems.GREEN_ROSE_PETAL, "Green");
            addRosePetal(ModItems.LIGHT_BLUE_ROSE_PETAL, "Light Blue");
            addRosePetal(ModItems.CYAN_ROSE_PETAL, "Cyan");
            addRosePetal(ModItems.BLUE_ROSE_PETAL, "Blue");
            addRosePetal(ModItems.PURPLE_ROSE_PETAL, "Purple");
            addRosePetal(ModItems.MAGENTA_ROSE_PETAL, "Magenta");
            addRosePetal(ModItems.PINK_ROSE_PETAL, "Pink");
            addRosePetal(ModItems.BLACK_ROSE_PETAL, "Black");
            addRosePetal(ModItems.GRAY_ROSE_PETAL, "Gray");
            addRosePetal(ModItems.LIGHT_GRAY_ROSE_PETAL, "Light Gray");
            addRosePetal(ModItems.WHITE_ROSE_PETAL, "White");
            addRosePetal(ModItems.BROWN_ROSE_PETAL, "Brown");

            addItem(ModItems.OAK_BARK, "Oak Bark");
            addItem(ModItems.BIRCH_BARK, "Birch Bark");
            addItem(ModItems.SPRUCE_BARK, "Spruce Bark");
            addItem(ModItems.JUNGLE_BARK, "Jungle Bark");
            addItem(ModItems.ACACIA_BARK, "Acacia Bark");
            addItem(ModItems.DARK_OAK_BARK, "Dark Oak Bark");
            addItem(ModItems.CRIMSON_BARK, "Crimson Bark");
            addItem(ModItems.WARPED_BARK, "Warped Bark");
            addItem(ModItems.CINNAMON_BARK, "Cinnamon Bark");
            addItem(ModItems.PAPER_PULP, "Paper Pulp");

            addItem(ModItems.SUGAR_ROSE_PETAL, "Sugar Coated Rose Petal");
            addItem(ModItems.MERINGUE, "Meringue");
            addItem(ModItems.LEMON, "Lemon");
            addItem(ModItems.LIME, "Lime");
            addItem(ModItems.ORANGE, "Orange");
            addItem(ModItems.BLOOD_ORANGE, "Blood Orange");
            addItem(ModItems.CARAMEL, "Caramel");
        }


        public void addRosePetal(Supplier<? extends Item> item, String color) {
            addItem(item, color + " Rose Petal");
        }


        public void addCinnamonPrefixBlock(Supplier<? extends Block> block, String name) {
            addBlock(block, "Cinnamon " + name);
        }
        
        public void addPetalCarpet(Supplier<? extends Block> block, String color) {
            addBlock(block, color + " Rose Petal Carpet");
        }
    }
    
    public class EnGb extends LanguageProvider {

        public EnGb(DataGenerator gen) {
            super(gen, CooksKitchen.MODID, "en_gb");
        }

        @Override
        protected void addTranslations() {
            addItems();
            addBlocks();

            add("tooltip.cooks_kitchen.bark_remover", "Press §e§nSHIFT§r for more info!");
            add("tooltip.cooks_kitchen.bark_remover.shift", "Left click on a log to strip it and drop the corresponding bark item!");

            add("itemGroup.cooks_kitchen", "Create Food");

            add("subtitles.item.blow_torch.use", "Blow Torch burns");
        }


        private void addBlocks() {
            addBlock(ModBlocks.SAW_DUST, "Saw Dust");
            addBlock(ModBlocks.AUTO_BLOWTORCH, "Auto Blowtorch");
            addBlock(ModBlocks.CARAMELISER, "Carameliser");

            addCinnamonPrefixBlock(ModBlocks.CINNAMON_LOG, "Log");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_WOOD, "Wood");
            addBlock(ModBlocks.STRIPPED_CINNAMON_LOG, "Stripped Cinnamon Log");
            addBlock(ModBlocks.STRIPPED_CINNAMON_WOOD, "Stripped Cinnamon Wood");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_PLANKS, "Planks");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_SLAB, "Slab");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_STAIRS, "Stairs");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_FENCE, "Fence");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_FENCE_GATE, "Fence Gate");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_BUTTON, "Button");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_PRESSURE_PLATE, "Pressure Plate");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_DOOR, "Door");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_TRAPDOOR, "Trapdoor");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_SIGN, "Sign");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_LEAVES, "Leaves");
            addCinnamonPrefixBlock(ModBlocks.CINNAMON_SAPLING, "Sapling");
            addBlock(ModBlocks.POTTED_CINNAMON_SAPLING, "Potted Cinnamon Sapling");

            addBlock(ModBlocks.PINK_ROSE, "Pink Rose");
            addBlock(ModBlocks.POTTED_PINK_ROSE, "Potted Pink Rose");
            addBlock(ModBlocks.FLOWER_STEM, "Flower Stem");
            addBlock(ModBlocks.POTTED_FLOWER_STEM, "Potted Flower Stem");

            addPetalCarpet(ModBlocks.RED_ROSE_CARPET, "Red");
            addPetalCarpet(ModBlocks.ORANGE_ROSE_CARPET, "Orange");
            addPetalCarpet(ModBlocks.YELLOW_ROSE_CARPET, "Yellow");
            addPetalCarpet(ModBlocks.LIME_ROSE_CARPET, "Lime");
            addPetalCarpet(ModBlocks.GREEN_ROSE_CARPET, "Green");
            addPetalCarpet(ModBlocks.LIGHT_BLUE_ROSE_CARPET, "Light Blue");
            addPetalCarpet(ModBlocks.CYAN_ROSE_CARPET, "Cyan");
            addPetalCarpet(ModBlocks.BLUE_ROSE_CARPET, "Blue");
            addPetalCarpet(ModBlocks.PURPLE_ROSE_CARPET, "Purple");
            addPetalCarpet(ModBlocks.MAGENTA_ROSE_CARPET, "Magenta");
            addPetalCarpet(ModBlocks.PINK_ROSE_CARPET, "Pink");
            addPetalCarpet(ModBlocks.BLACK_ROSE_CARPET, "Black");
            addPetalCarpet(ModBlocks.GRAY_ROSE_CARPET, "Gray");
            addPetalCarpet(ModBlocks.LIGHT_GRAY_ROSE_CARPET, "Light Gray");
            addPetalCarpet(ModBlocks.WHITE_ROSE_CARPET, "White");
            addPetalCarpet(ModBlocks.BROWN_ROSE_CARPET, "Brown");

            addBlock(ModBlocks.LEMON_TREE, "Lemon Tree");
            addBlock(ModBlocks.LIME_TREE, "Lime Tree");
            addBlock(ModBlocks.ORANGE_TREE, "Orange Tree");
        }

        private void addItems() {
            addItem(ModItems.BARK_REMOVER, "Bark Stripper");
            addItem(ModItems.BLOW_TORCH, "Blow Torch");

            addItem(ModItems.CARAMEL_BUCKET, "Caramel Bucket");

            addItem(ModItems.CINNAMON, "Cinnamon Stick");
            addItem(ModItems.CRUSHED_CINNAMON, "Crushed Cinnamon");
            addItem(ModItems.EGG_WHITE, "Egg White");
            addItem(ModItems.EGG_YOLK, "Egg Yolk");
            addItem(ModItems.RAW_MERINGUE, "Raw Meringue");
            addItem(ModItems.BUTTER, "Butter");
            addItem(ModItems.CREAM, "Cream");

            addRosePetal(ModItems.RED_ROSE_PETAL, "Red");
            addRosePetal(ModItems.ORANGE_ROSE_PETAL, "Orange");
            addRosePetal(ModItems.YELLOW_ROSE_PETAL, "Yellow");
            addRosePetal(ModItems.LIME_ROSE_PETAL, "Lime");
            addRosePetal(ModItems.GREEN_ROSE_PETAL, "Green");
            addRosePetal(ModItems.LIGHT_BLUE_ROSE_PETAL, "Light Blue");
            addRosePetal(ModItems.CYAN_ROSE_PETAL, "Cyan");
            addRosePetal(ModItems.BLUE_ROSE_PETAL, "Blue");
            addRosePetal(ModItems.PURPLE_ROSE_PETAL, "Purple");
            addRosePetal(ModItems.MAGENTA_ROSE_PETAL, "Magenta");
            addRosePetal(ModItems.PINK_ROSE_PETAL, "Pink");
            addRosePetal(ModItems.BLACK_ROSE_PETAL, "Black");
            addRosePetal(ModItems.GRAY_ROSE_PETAL, "Gray");
            addRosePetal(ModItems.LIGHT_GRAY_ROSE_PETAL, "Light Gray");
            addRosePetal(ModItems.WHITE_ROSE_PETAL, "White");
            addRosePetal(ModItems.BROWN_ROSE_PETAL, "Brown");

            addItem(ModItems.OAK_BARK, "Oak Bark");
            addItem(ModItems.BIRCH_BARK, "Birch Bark");
            addItem(ModItems.SPRUCE_BARK, "Spruce Bark");
            addItem(ModItems.JUNGLE_BARK, "Jungle Bark");
            addItem(ModItems.ACACIA_BARK, "Acacia Bark");
            addItem(ModItems.DARK_OAK_BARK, "Dark Oak Bark");
            addItem(ModItems.CRIMSON_BARK, "Crimson Bark");
            addItem(ModItems.WARPED_BARK, "Warped Bark");
            addItem(ModItems.CINNAMON_BARK, "Cinnamon Bark");
            addItem(ModItems.PAPER_PULP, "Paper Pulp");

            addItem(ModItems.SUGAR_ROSE_PETAL, "Sugar Coated Rose Petal");
            addItem(ModItems.MERINGUE, "Meringue");
            addItem(ModItems.LEMON, "Lemon");
            addItem(ModItems.LIME, "Lime");
            addItem(ModItems.ORANGE, "Orange");
            addItem(ModItems.BLOOD_ORANGE, "Blood Orange");
            addItem(ModItems.CARAMEL, "Caramel");
        }


        public void addRosePetal(Supplier<? extends Item> item, String color) {
            addItem(item, color + " Rose Petal");
        }


        public void addCinnamonPrefixBlock(Supplier<? extends Block> block, String name) {
            addBlock(block, "Cinnamon " + name);
        }
        
        public void addPetalCarpet(Supplier<? extends Block> block, String color) {
            addBlock(block, color + " Rose Petal Carpet");
        }
    }
}
